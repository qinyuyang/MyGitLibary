extern "C"
{
#include"include/libavcodec/avcodec.h"
#include"include/libavformat/avformat.h"
#include"include/libswscale/swscale.h"
}





#include<iostream>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<jni.h>
#include<android/log.h>
#include"include/com_example_aresrecorderactivity_CameraView.h"


#define TAG "AresRecorder" // 这个是自定义的LOG的标识
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型

using namespace std;


int g_width = 352;
int g_height = 288;
int g_video_outbuff_size;
uint8_t* g_video_outbuff = NULL;

#define STREAM_PIX_FMT PIX_FMT_YUV420P /* default pix_fmt */
static char* curFileName;

//init Video Stream and return it
AVStream* getVideoStream(AVFormatContext* fmt_ctx)
{
    AVStream* stream = NULL;

   stream = avformat_new_stream(fmt_ctx, NULL);
    if( stream == NULL)
   {
        fprintf(stderr, "new stream fail\n");
        exit(1);
    }

    AVCodecContext* codec_ctx = stream->codec;

    codec_ctx->codec_id = fmt_ctx->oformat->video_codec;
    codec_ctx->codec_type = AVMEDIA_TYPE_VIDEO;

    codec_ctx->bit_rate = 400000;
    codec_ctx->gop_size = 3;

   codec_ctx->pix_fmt = STREAM_PIX_FMT;
    codec_ctx->width = g_width;
    codec_ctx->height = g_height;

    codec_ctx->time_base.num = 1;
    codec_ctx->time_base.den = 25;

    codec_ctx->me_range = 16;
    codec_ctx->max_qdiff = 4;
    codec_ctx->qmin = 10;
    codec_ctx->qmax = 51;
    codec_ctx->qcompress = 0.6;

    if( codec_ctx->codec_id == CODEC_ID_MPEG2VIDEO )
        codec_ctx->max_b_frames = 2;

    if( codec_ctx->codec_id == CODEC_ID_MPEG1VIDEO)
        codec_ctx->mb_decision = 2;


    // some formats want stream headers to be separate
    if(!strcmp(fmt_ctx->oformat->name, "mp4")
            || !strcmp(fmt_ctx->oformat->name, "mov")
            || !strcmp(fmt_ctx->oformat->name, "3gp")
       )
    {
        codec_ctx->flags |= CODEC_FLAG_GLOBAL_HEADER;
    }

    return stream;
}

void initEncoder(AVStream* stream)
{
    AVCodecContext* codec_ctx = stream->codec;

    AVCodec* encoder = avcodec_find_encoder(codec_ctx->codec_id);
    if( encoder == NULL )
    {
        fprintf(stderr, "cann't find the encoder\n");
        exit(1);
    }

    if( avcodec_open2(codec_ctx, encoder, NULL) < 0 )
    {
        fprintf(stderr, "could not open video codec\n");
        exit(1);
    }
}


AVFrame* getAVFrame()
{
    int size = avpicture_get_size(STREAM_PIX_FMT, g_width, g_height);
    uint8_t* buff = (uint8_t*)av_malloc(size);

    if( buff == NULL)
    {
        fprintf(stderr, "av malloc fail\n");
        exit(1);
    }

    AVFrame* frame = avcodec_alloc_frame();
    if( frame == NULL)
    {
       fprintf(stderr, "alloc frame fail\n");
        exit(1);
    }

    avpicture_fill((AVPicture*)frame, buff, STREAM_PIX_FMT,
                   g_width, g_height);

    return frame;
}


void writeFrame(AVFormatContext* fmt_ctx, AVStream* stream, AVFrame* frame)
{
    int ret, out_size;
    AVPacket packet;
    AVCodecContext* codec_ctx = stream->codec;

    if (fmt_ctx->oformat->flags & AVFMT_RAWPICTURE) {
        /* raw video case. The API will change slightly in the near
           futur for that */

        av_init_packet(&packet);

       packet.flags |= AV_PKT_FLAG_KEY;
        packet.stream_index= stream->index;
        packet.data= (uint8_t *)frame;
        packet.size= sizeof(AVPicture);

        ret = av_write_frame(fmt_ctx, &packet);
    }
    else {
        /* encode the image */
        out_size = avcodec_encode_video(codec_ctx, g_video_outbuff, g_video_outbuff_size, frame);
        /* if zero size, it means the image was buffered */
        if (out_size > 0) {
           av_init_packet(&packet);


            if(codec_ctx->coded_frame->key_frame)
                packet.flags |= AV_PKT_FLAG_KEY;


            packet.stream_index= stream->index;
            packet.data= g_video_outbuff;
            // not the video_outbuf_size, note!
            packet.size= out_size;

            /* write the compressed frame in the media file */
            ret = av_write_frame(fmt_ctx, &packet);
        }
        else {
            ret = 0;
       }
    }
    if (ret != 0)
    {
        fprintf(stderr, "Error while writing video frame\n");
        exit(1);
    }
}


int recordVideo(char* filename,uint8_t* data)
{

	int dataSize = sizeof(data)/sizeof(int);

    char* output_filename;
    strcpy(output_filename,filename);

    g_width = 352;
    g_height = 288;


    //正如其函数名，该函数就是在猜。根据文件名的后缀猜应该使用什么编码
    //当然，也可能找不到对应后缀的编码方法。此时返回NULL。
    AVOutputFormat* output_fmt = av_guess_format(NULL, output_filename, NULL);
    if( output_fmt == NULL )
    {
        fprintf(stderr, "Couldn't deduce output format from file extension: using MPEG.\n");
        output_fmt = av_guess_format("mpeg", NULL, NULL);
    }

    if( output_fmt == NULL )
    {
        fprintf(stderr, "Could not find suitable output format");
        return -1;
    }

    //负责申请一个AVFormatContext结构的内存,并进行简单初始化
    //需要使用avformat_free_context()来释放
    //avformat_free_context()可以用来释放该结构里的所有东西以及该结构本身
   AVFormatContext* fmt_ctx = avformat_alloc_context();
    if( fmt_ctx == NULL )
    {
        fprintf(stderr, "Memory error");
       return -1;
   }

    //把要使用的编码器复制给format_ctx
    fmt_ctx->oformat = output_fmt;
    strncpy(fmt_ctx->filename, output_filename, sizeof(fmt_ctx->filename));



    //http://www.ffmpeg.org/doxygen/1.0/group__lavc__core.html
    //can see #define   CodecID   AVCodecID
    if( output_fmt->video_codec == AV_CODEC_ID_NONE)
        return -1;

    AVStream* stream = getVideoStream(fmt_ctx);

    av_dump_format(fmt_ctx, 0, output_filename, 1);
    initEncoder(stream);

    if( avio_open(&fmt_ctx->pb, output_filename, AVIO_FLAG_WRITE) < 0)
    {
       fprintf(stderr, "cann't open the output file\n");
        return -1;
    }


    if (!(fmt_ctx->oformat->flags & AVFMT_RAWPICTURE)) {

        /* allocate output buffer */
        /* XXX: API change will be done */
        /* buffers passed into lav* can be allocated any way you prefer,
           as long as they're aligned enough for the architecture, and
           they're freed appropriately (such as using av_free for buffers
           allocated with av_malloc) */
        g_video_outbuff_size = 200000;
        g_video_outbuff = (uint8_t *)av_malloc(g_video_outbuff_size);
    }

    AVFrame* frame = getAVFrame();


    if( avformat_write_header(fmt_ctx, NULL) < 0 )
    {
        fprintf(stderr, "cann't write the file head\n");
        return -1;
    }


    int yuv_frame_size = avpicture_get_size(STREAM_PIX_FMT, g_width, g_height);
    int ret = 0;

    while( 1 )
    {

        frame->data[0]=data;

        if( ret != yuv_frame_size )
        {
            fprintf(stderr, "%d don't read enough data\n", ret);
           break;
       }

       writeFrame(fmt_ctx, stream, frame);
    }


    av_write_trailer(fmt_ctx);
   avio_close(fmt_ctx->pb);

   av_free(fmt_ctx);

   return 0;
}

char* jstringTostring(JNIEnv* env, jstring jstr) {
	char* rtn = NULL;
	jclass clsstring = env->FindClass("java/lang/String");
	jstring strencode = env->NewStringUTF("utf-8");
	jmethodID mid = env->GetMethodID(clsstring, "getBytes",
			"(Ljava/lang/String;)[B");
	jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
	jsize alen = env->GetArrayLength(barr);
	jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
	if (alen > 0) {
		rtn = (char*) malloc(alen + 1);

		memcpy(rtn, ba, alen);
		rtn[alen] = 0;
	}
	env->ReleaseByteArrayElements(barr, ba, 0);
	return rtn;
}

//uint8_t*
void jbyteArray_to_uint8_t(JNIEnv* env, jbyteArray jdata)
{
	  jsize len  = env->GetArrayLength(jdata);

      jbyte *jbarray = (jbyte *)malloc(len * sizeof(jbyte));

      env->GetByteArrayRegion(env,jdata,0,len,jdata);

      uint8_t* dDate=(uint8_t*)jbarray;
}

JNIEXPORT void JNICALL  Java_com_example_aresrecorderactivity_CameraView_saveFrameToVideo(JNIEnv* env, jobject obj, jstring js, jbyteArray jdata)
{
	char* filename = jstringTostring(env, js);
	LOGD("%s",filename);
	jbyteArray_to_uint8_t(env, jdata);
}


