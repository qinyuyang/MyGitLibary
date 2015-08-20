//============================================================================
// Name        : ffmpegtest.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "libavformat/avformat.h"
#include "libswscale/swscale.h"
#include "libavcodec/avcodec.h"


/* 5 seconds stream duration */
#define STREAM_DURATION   5.0
#define STREAM_FRAME_RATE 25 /* 25 images/s */
#define STREAM_NB_FRAMES  ((int)(STREAM_DURATION * STREAM_FRAME_RATE))
#define STREAM_PIX_FMT PIX_FMT_YUV420P /* default pix_fmt */


using namespace std;

AVFrame *picture, *tmp_picture;
uint8_t *video_outbuf;
int frame_count, video_outbuf_size;

 /**************************************************************/
 /* audio output */

 float t, tincr, tincr2;
 int16_t* samples;
 uint8_t* audio_outbuf;
 int audio_outbuf_size;
int audio_input_frame_size;



 /* add a video output stream */
 static AVStream *add_video_stream(AVFormatContext *oc, AVCodecID codec_id)
 {
     AVCodecContext *c;
     AVStream *st;

     //增加一个新的流到媒体文件
     st = av_new_stream(oc, 0);
     if (!st) {
         fprintf(stderr, "Could not alloc stream\n");
         exit(1);
     }

     //初始化编解码器
     c = st->codec;
     c->codec_id = codec_id;
     c->codec_type = AVMEDIA_TYPE_VIDEO;

     /* put sample parameters */
     c->bit_rate = 400000;
     /* resolution must be a multiple of two */
     c->width = 352;
     c->height = 288;
     /* time base: this is the fundamental unit of time (in seconds) in terms
        of which frame timestamps are represented. for fixed-fps content,
        timebase should be 1/framerate and timestamp increments should be
        identically 1. */
     c->time_base.den = STREAM_FRAME_RATE;
     c->time_base.num = 1;
     c->gop_size = 12; /* emit one intra frame every twelve frames at most */
     c->pix_fmt = STREAM_PIX_FMT;
     if (c->codec_id == CODEC_ID_MPEG2VIDEO) {
         /* just for testing, we also add B frames */
         c->max_b_frames = 2;
     }
     if (c->codec_id == CODEC_ID_MPEG1VIDEO){
         /* Needed to avoid using macroblocks in which some coeffs overflow.
            This does not happen with normal video, it just happens here as
            the motion of the chroma plane does not match the luma plane. */
         c->mb_decision=2;
     }
     // some formats want stream headers to be separate
     if(oc->oformat->flags & AVFMT_GLOBALHEADER)
         c->flags |= CODEC_FLAG_GLOBAL_HEADER;

     return st;
}

static AVStream *add_audio_stream(AVFormatContext *oc, AVCodecID codec_id)
{
     AVCodecContext *c;
     AVStream *st;

     st = av_new_stream(oc, 1);
     if (!st) {
         fprintf(stderr, "Could not alloc stream\n");
          exit(1);
     }

     c = st->codec;
     c->codec_id = codec_id;
     c->codec_type = AVMEDIA_TYPE_AUDIO;

    /* put sample parameters */
     c->bit_rate = 64000;
     c->sample_rate = 44100;
     c->channels = 2;
     return st;
 }

static AVFrame *alloc_picture(PixelFormat pix_fmt, int width, int height)
{
     AVFrame *picture;
     uint8_t *picture_buf;
     int size;

     //分配一个视频帧并设置默认值
     picture = avcodec_alloc_frame();
     if (!picture)
         return NULL;
     //根据指定的图片格式和尺寸算需要的内存大小
     size = avpicture_get_size(pix_fmt, width, height);
     //分配帧缓存
     picture_buf = (uint8_t*)av_malloc(size);
     if (!picture_buf) {
         av_free(picture);
         return NULL;
     }
     //填充
     avpicture_fill((AVPicture *)picture, picture_buf,
                    pix_fmt, width, height);
     return picture;
 }



static void open_video(AVFormatContext *oc, AVStream *st)
{
     AVCodec *codec;
     AVCodecContext *c;

     c = st->codec;

     /* find the video encoder */
     codec = avcodec_find_encoder(c->codec_id);
     if (!codec) {
         fprintf(stderr, "codec not found\n");
         exit(1);
     }

     /* open the codec */
     if (avcodec_open(c, codec) < 0) {
         fprintf(stderr, "could not open codec\n");
         exit(1);
     }

     video_outbuf = NULL;
     if (!(oc->oformat->flags & AVFMT_RAWPICTURE)) {
         /* allocate output buffer */
         /* XXX: API change will be done */
         /* buffers passed into lav* can be allocated any way you prefer,
            as long as they're aligned enough for the architecture, and
            they're freed appropriately (such as using av_free for buffers
            allocated with av_malloc) */
         video_outbuf_size = 200000;
         video_outbuf = (uint8_t*)av_malloc(video_outbuf_size);
     }

     /* allocate the encoded raw picture */
     picture = alloc_picture(c->pix_fmt, c->width, c->height);
     if (!picture) {
         fprintf(stderr, "Could not allocate picture\n");
         exit(1);
     }

     /* if the output format is not YUV420P, then a temporary YUV420P
        picture is needed too. It is then converted to the required
        output format */
     tmp_picture = NULL;
     //如果输出格式不是YUV420P，那么需要创建一个临时的YUV420P格式的图片，然后再转换成我们需要的图片格式
     if (c->pix_fmt != PIX_FMT_YUV420P) {
         tmp_picture = alloc_picture(PIX_FMT_YUV420P, c->width, c->height);
         if (!tmp_picture) {
             fprintf(stderr, "Could not allocate temporary picture\n");
             exit(1);
         }
     }
 }

static void open_audio(AVFormatContext *oc, AVStream *st)
{
     AVCodecContext *c;
     AVCodec *codec;

     c = st->codec;

     /* find the audio encoder */
     codec = avcodec_find_encoder(c->codec_id);
     if (!codec) {
         fprintf(stderr, "codec not found\n");
         exit(1);
     }

     /* open it */
     if (avcodec_open(c, codec) < 0) {
         fprintf(stderr, "could not open codec\n");
         exit(1);
     }

     /* init signal generator */
     t = 0;
     tincr = 2 * M_PI * 110.0 / c->sample_rate;
     /* increment frequency by 110 Hz per second */
     tincr2 = 2 * M_PI * 110.0 / c->sample_rate / c->sample_rate;

     audio_outbuf_size = 10000;
     audio_outbuf = (uint8_t*)av_malloc(audio_outbuf_size);

     /* ugly hack for PCM codecs (will be removed ASAP with new PCM
        support to compute the input frame size in samples */
     if (c->frame_size <= 1) {
         audio_input_frame_size = audio_outbuf_size / c->channels;
         switch(st->codec->codec_id) {
         case CODEC_ID_PCM_S16LE:
         case CODEC_ID_PCM_S16BE:
         case CODEC_ID_PCM_U16LE:
         case CODEC_ID_PCM_U16BE:
             audio_input_frame_size >>= 1;
             break;
         default:
             break;
         }
     } else {
         audio_input_frame_size = c->frame_size;
     }
     samples = (int16_t*)av_malloc(audio_input_frame_size * 2 * c->channels);
 }

 static void get_audio_frame(int16_t *samples, int frame_size, int nb_channels)
 {
     int j, i, v;
     int16_t *q;

     q = samples;
     for(j=0;j<frame_size;j++) {
         v = (int)(sin(t) * 10000);
         for(i = 0; i < nb_channels; i++)
             *q++ = v;
         t += tincr;
         tincr += tincr2;
     }
 }


 static void write_audio_frame(AVFormatContext *oc, AVStream *st)
 {
     AVCodecContext *c;
     AVPacket pkt;
     av_init_packet(&pkt);

     c = st->codec;

     get_audio_frame(samples, audio_input_frame_size, c->channels);

     pkt.size= avcodec_encode_audio(c, audio_outbuf, audio_outbuf_size, samples);

     if (c->coded_frame->pts != AV_NOPTS_VALUE)
         pkt.pts= av_rescale_q(c->coded_frame->pts, c->time_base, st->time_base);
     pkt.flags |= 0x0001;
     pkt.stream_index= st->index;
     pkt.data= audio_outbuf;

     /* write the compressed frame in the media file */
     if (av_interleaved_write_frame(oc, &pkt) != 0) {
         fprintf(stderr, "Error while writing audio frame\n");
         exit(1);
     }
 }

/* prepare a dummy image */
 static void fill_yuv_image(AVFrame *pict, int frame_index, int width, int height)
 {
     int x, y, i;

     i = frame_index;

     /* Y */
     for(y=0;y<height;y++) {
         for(x=0;x<width;x++) {
             pict->data[0][y * pict->linesize[0] + x] = x + y + i * 3;
         }
     }

     /* Cb and Cr */
     for(y=0;y<height/2;y++) {
         for(x=0;x<width/2;x++) {
             pict->data[1][y * pict->linesize[1] + x] = 128 + y + i * 2;
             pict->data[2][y * pict->linesize[2] + x] = 64 + x + i * 5;
         }
     }
 }

static void write_video_frame(AVFormatContext *oc, AVStream *st)
{
     int out_size, ret;
     AVCodecContext *c;
     static struct SwsContext *img_convert_ctx;

     c = st->codec;

     if (frame_count >= STREAM_NB_FRAMES) {
         /* no more frame to compress. The codec has a latency of a few
            frames if using B frames, so we get the last frames by
            passing the same picture again */
     } else {
         if (c->pix_fmt != PIX_FMT_YUV420P) {
             /* as we only generate a YUV420P picture, we must convert it
                to the codec pixel format if needed */
             if (img_convert_ctx == NULL) {
                 img_convert_ctx = sws_getContext(c->width, c->height,
                                                  PIX_FMT_YUV420P,
                                                  c->width, c->height,
                                                  c->pix_fmt,
                                                  4, NULL, NULL, NULL);
                 if (img_convert_ctx == NULL) {
                     fprintf(stderr, "Cannot initialize the conversion context\n");
                     exit(1);
                 }
             }

             fill_yuv_image(tmp_picture, frame_count, c->width, c->height);
             sws_scale(img_convert_ctx, tmp_picture->data, tmp_picture->linesize,
                       0, c->height, picture->data, picture->linesize);
         } else {
             fill_yuv_image(picture, frame_count, c->width, c->height);
         }
     }


     if (oc->oformat->flags & AVFMT_RAWPICTURE) {
         /* raw video case. The API will change slightly in the near
            futur for that */
         AVPacket pkt;
         av_init_packet(&pkt);

         pkt.flags |= 0x0001;
         pkt.stream_index= st->index;
         pkt.data= (uint8_t *)picture;
         pkt.size= sizeof(AVPicture);

         ret = av_interleaved_write_frame(oc, &pkt);
     } else {
         /* encode the image */
         out_size = avcodec_encode_video(c, video_outbuf, video_outbuf_size, picture);
         /* if zero size, it means the image was buffered */
         if (out_size > 0) {
             AVPacket pkt;
             av_init_packet(&pkt);

             if (c->coded_frame->pts != AV_NOPTS_VALUE)
                 pkt.pts= av_rescale_q(c->coded_frame->pts, c->time_base, st->time_base);
             if(c->coded_frame->key_frame)
                 pkt.flags |= 0x0001;
             pkt.stream_index= st->index;
             pkt.data= video_outbuf;
             pkt.size= out_size;

             /* write the compressed frame in the media file */
             ret = av_interleaved_write_frame(oc, &pkt);
         } else {
             ret = 0;
         }
     }
     if (ret != 0) {
         fprintf(stderr, "Error while writing video frame\n");
         exit(1);
     }
     frame_count++;
 }

static void close_video(AVFormatContext *oc, AVStream *st)
{
    avcodec_close(st->codec);
    av_free(picture->data[0]);
    av_free(picture);
    if (tmp_picture) {
        av_free(tmp_picture->data[0]);
        av_free(tmp_picture);
    }
    av_free(video_outbuf);
}

static void close_audio(AVFormatContext *oc, AVStream *st)
{
    avcodec_close(st->codec);

    av_free(samples);
    av_free(audio_outbuf);
}

void save_video(char *path)
{
	char* savePath = path;
	const char *filename;
	AVOutputFormat *fmt;
	AVStream *audio_st, *video_st;
	double audio_pts, video_pts;
	int i;
	AVFormatContext *oc;
	//av_register_all()，初始化libavcodec库，并注册所有的编解码器和格式。
	av_register_all();

	filename ="";

	//根据文件名猜格式
	fmt = av_guess_format(NULL,filename,NULL);

	if(!fmt)
	{
		exit(1);
	}

	//初始化AVFormatContext , 分配输出媒体内容
	oc = avformat_alloc_context();

	if(!oc)
	{
		exit(1);
	}

	oc->oformat = fmt;

	video_st = NULL;
	audio_st = NULL;
	if( fmt->audio_codec != CODEC_ID_NONE)
	{
		//初始化视频流
		video_st = add_video_stream(oc,fmt->video_codec);
	}
	if( fmt->audio_codec != CODEC_ID_NONE)
	{
		//初始化音频流
		audio_st = add_audio_stream(oc, fmt->audio_codec);
	}

	//av_set_parameters 0.7版本废弃
	av_dump_format(oc, 0, filename, 1);

	//打开视频编解码器并分配必要的编码缓存。
	if(video_st)
		open_video(oc, video_st);
	if(audio_st)
		open_audio(oc,audio_st);

	/* write the stream header, if any */
	avformat_write_header(oc,NULL);

    for(;;) {
         /* compute current audio and video time */
         if (audio_st)
             audio_pts = (double)audio_st->pts.val * audio_st->time_base.num / audio_st->time_base.den;
         else
             audio_pts = 0.0;

         if (video_st)
             video_pts = (double)video_st->pts.val * video_st->time_base.num / video_st->time_base.den;
         else
             video_pts = 0.0;

         if ((!audio_st || audio_pts >= STREAM_DURATION) &&
             (!video_st || video_pts >= STREAM_DURATION))
             break;

         /* write interleaved audio and video frames */
         if (!video_st || (video_st && audio_st && audio_pts < video_pts))
         {
             write_audio_frame(oc, audio_st);
         } else {
             write_video_frame(oc, video_st);
         }
     }


    /* write the trailer, if any.  the trailer must be written
     * before you close the CodecContexts open when you wrote the
     * header; otherwise write_trailer may try to use memory that
     * was freed on av_codec_close() */
    av_write_trailer(oc);

         /* close each codec */
         if (video_st)
           close_video(oc, video_st);
         if (audio_st)
           close_audio(oc, audio_st);

         /* free the streams */
       for(i = 0; i < oc->nb_streams; i++) {
             av_freep(&oc->streams[i]->codec);
             av_freep(&oc->streams[i]);
         }

      if (!(fmt->flags & AVFMT_NOFILE)) {
            /* close the output file */
            avio_close(oc->pb);
         }

        /* free the stream */
        av_free(oc);

        return 0;


	return 0;
}
