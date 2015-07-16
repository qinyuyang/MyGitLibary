/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.LongPointer;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ 
/*      */ @Properties(inherit={avcodec.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavformat/avio.h>", "<libavformat/avformat.h>"}, link={"avformat@.55"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"avformat-55"})})
/*      */ public class avformat
/*      */ {
/*      */   public static final int AVIO_SEEKABLE_NORMAL = 1;
/*      */   public static final int AVSEEK_SIZE = 65536;
/*      */   public static final int AVSEEK_FORCE = 131072;
/*      */   public static final int AVIO_FLAG_READ = 1;
/*      */   public static final int AVIO_FLAG_WRITE = 2;
/*      */   public static final int AVIO_FLAG_READ_WRITE = 3;
/*      */   public static final int AVIO_FLAG_NONBLOCK = 8;
/*      */   public static final int AVIO_FLAG_DIRECT = 32768;
/* 1068 */   public static final int AVPROBE_SCORE_RETRY = AVPROBE_SCORE_RETRY();
/*      */   public static final int AVPROBE_SCORE_EXTENSION = 50;
/*      */   public static final int AVPROBE_SCORE_MAX = 100;
/*      */   public static final int AVPROBE_PADDING_SIZE = 32;
/*      */   public static final int AVFMT_NOFILE = 1;
/*      */   public static final int AVFMT_NEEDNUMBER = 2;
/*      */   public static final int AVFMT_SHOW_IDS = 8;
/*      */   public static final int AVFMT_RAWPICTURE = 32;
/*      */   public static final int AVFMT_GLOBALHEADER = 64;
/*      */   public static final int AVFMT_NOTIMESTAMPS = 128;
/*      */   public static final int AVFMT_GENERIC_INDEX = 256;
/*      */   public static final int AVFMT_TS_DISCONT = 512;
/*      */   public static final int AVFMT_VARIABLE_FPS = 1024;
/*      */   public static final int AVFMT_NODIMENSIONS = 2048;
/*      */   public static final int AVFMT_NOSTREAMS = 4096;
/*      */   public static final int AVFMT_NOBINSEARCH = 8192;
/*      */   public static final int AVFMT_NOGENSEARCH = 16384;
/*      */   public static final int AVFMT_NO_BYTE_SEEK = 32768;
/*      */   public static final int AVFMT_ALLOW_FLUSH = 65536;
/*      */   public static final int AVFMT_TS_NONSTRICT = 131072;
/*      */   public static final int AVFMT_TS_NEGATIVE = 262144;
/*      */   public static final int AVFMT_SEEK_TO_PTS = 67108864;
/*      */   public static final int AVSTREAM_PARSE_NONE = 0;
/*      */   public static final int AVSTREAM_PARSE_FULL = 1;
/*      */   public static final int AVSTREAM_PARSE_HEADERS = 2;
/*      */   public static final int AVSTREAM_PARSE_TIMESTAMPS = 3;
/*      */   public static final int AVSTREAM_PARSE_FULL_ONCE = 4;
/* 1484 */   public static final int AVSTREAM_PARSE_FULL_RAW = AVSTREAM_PARSE_FULL_RAW();
/*      */   public static final int AV_DISPOSITION_DEFAULT = 1;
/*      */   public static final int AV_DISPOSITION_DUB = 2;
/*      */   public static final int AV_DISPOSITION_ORIGINAL = 4;
/*      */   public static final int AV_DISPOSITION_COMMENT = 8;
/*      */   public static final int AV_DISPOSITION_LYRICS = 16;
/*      */   public static final int AV_DISPOSITION_KARAOKE = 32;
/*      */   public static final int AV_DISPOSITION_FORCED = 64;
/*      */   public static final int AV_DISPOSITION_HEARING_IMPAIRED = 128;
/*      */   public static final int AV_DISPOSITION_VISUAL_IMPAIRED = 256;
/*      */   public static final int AV_DISPOSITION_CLEAN_EFFECTS = 512;
/*      */   public static final int AV_DISPOSITION_ATTACHED_PIC = 1024;
/*      */   public static final int AV_DISPOSITION_CAPTIONS = 65536;
/*      */   public static final int AV_DISPOSITION_DESCRIPTIONS = 131072;
/*      */   public static final int AV_DISPOSITION_METADATA = 262144;
/*      */   public static final int AV_PTS_WRAP_IGNORE = 0;
/*      */   public static final int AV_PTS_WRAP_ADD_OFFSET = 1;
/*      */   public static final int AV_PTS_WRAP_SUB_OFFSET = -1;
/*      */   public static final int AV_PROGRAM_RUNNING = 1;
/*      */   public static final int AVFMTCTX_NOHEADER = 1;
/*      */   public static final int AVFMT_DURATION_FROM_PTS = 0;
/*      */   public static final int AVFMT_DURATION_FROM_STREAM = 1;
/*      */   public static final int AVFMT_DURATION_FROM_BITRATE = 2;
/*      */   public static final int AVSEEK_FLAG_BACKWARD = 1;
/*      */   public static final int AVSEEK_FLAG_BYTE = 2;
/*      */   public static final int AVSEEK_FLAG_ANY = 4;
/*      */   public static final int AVSEEK_FLAG_FRAME = 8;
/*      */ 
/*      */   public static native int avio_check(@Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int avio_check(String paramString, int paramInt);
/*      */ 
/*      */   public static native AVIOContext avio_alloc_context(@Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, Pointer paramPointer, Read_packet_Pointer_BytePointer_int paramRead_packet_Pointer_BytePointer_int, Write_packet_Pointer_BytePointer_int paramWrite_packet_Pointer_BytePointer_int, Seek_Pointer_long_int paramSeek_Pointer_long_int);
/*      */ 
/*      */   public static native AVIOContext avio_alloc_context(@Cast({"unsigned char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, Pointer paramPointer, Read_packet_Pointer_ByteBuffer_int paramRead_packet_Pointer_ByteBuffer_int, Write_packet_Pointer_ByteBuffer_int paramWrite_packet_Pointer_ByteBuffer_int, Seek_Pointer_long_int paramSeek_Pointer_long_int);
/*      */ 
/*      */   public static native AVIOContext avio_alloc_context(@Cast({"unsigned char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2, Pointer paramPointer, Read_packet_Pointer_byte_int paramRead_packet_Pointer_byte_int, Write_packet_Pointer_byte_int paramWrite_packet_Pointer_byte_int, Seek_Pointer_long_int paramSeek_Pointer_long_int);
/*      */ 
/*      */   public static native void avio_w8(AVIOContext paramAVIOContext, int paramInt);
/*      */ 
/*      */   public static native void avio_write(AVIOContext paramAVIOContext, @Cast({"const unsigned char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native void avio_write(AVIOContext paramAVIOContext, @Cast({"const unsigned char*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   public static native void avio_write(AVIOContext paramAVIOContext, @Cast({"const unsigned char*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   public static native void avio_wl64(AVIOContext paramAVIOContext, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native void avio_wb64(AVIOContext paramAVIOContext, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native void avio_wl32(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avio_wb32(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avio_wl24(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avio_wb24(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avio_wl16(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avio_wb16(AVIOContext paramAVIOContext, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native int avio_put_str(AVIOContext paramAVIOContext, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avio_put_str(AVIOContext paramAVIOContext, String paramString);
/*      */ 
/*      */   public static native int avio_put_str16le(AVIOContext paramAVIOContext, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avio_put_str16le(AVIOContext paramAVIOContext, String paramString);
/*      */ 
/*      */   public static native long avio_seek(AVIOContext paramAVIOContext, long paramLong, int paramInt);
/*      */ 
/*      */   public static native long avio_skip(AVIOContext paramAVIOContext, long paramLong);
/*      */ 
/*      */   public static native long avio_tell(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native long avio_size(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int url_feof(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_printf(AVIOContext paramAVIOContext, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avio_printf(AVIOContext paramAVIOContext, String paramString);
/*      */ 
/*      */   public static native void avio_flush(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_read(AVIOContext paramAVIOContext, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int avio_read(AVIOContext paramAVIOContext, @Cast({"unsigned char*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   public static native int avio_read(AVIOContext paramAVIOContext, @Cast({"unsigned char*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   public static native int avio_r8(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rl16(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rl24(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rl32(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"uint64_t"})
/*      */   public static native long avio_rl64(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rb16(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rb24(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avio_rb32(AVIOContext paramAVIOContext);
/*      */ 
/*      */   @Cast({"uint64_t"})
/*      */   public static native long avio_rb64(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_get_str(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16le(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16le(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16le(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16be(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16be(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2);
/*      */ 
/*      */   public static native int avio_get_str16be(AVIOContext paramAVIOContext, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2);
/*      */ 
/*      */   public static native int avio_open(@Cast({"AVIOContext**"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int avio_open(@ByPtrPtr AVIOContext paramAVIOContext, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int avio_open(@ByPtrPtr AVIOContext paramAVIOContext, String paramString, int paramInt);
/*      */ 
/*      */   public static native int avio_open2(@Cast({"AVIOContext**"}) PointerPointer paramPointerPointer1, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Const AVIOInterruptCB paramAVIOInterruptCB, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer2);
/*      */ 
/*      */   public static native int avio_open2(@ByPtrPtr AVIOContext paramAVIOContext, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Const AVIOInterruptCB paramAVIOInterruptCB, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int avio_open2(@ByPtrPtr AVIOContext paramAVIOContext, String paramString, int paramInt, @Const AVIOInterruptCB paramAVIOInterruptCB, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int avio_close(AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_closep(@Cast({"AVIOContext**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avio_closep(@ByPtrPtr AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_open_dyn_buf(@Cast({"AVIOContext**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avio_open_dyn_buf(@ByPtrPtr AVIOContext paramAVIOContext);
/*      */ 
/*      */   public static native int avio_close_dyn_buf(AVIOContext paramAVIOContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avio_close_dyn_buf(AVIOContext paramAVIOContext, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avio_close_dyn_buf(AVIOContext paramAVIOContext, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native int avio_close_dyn_buf(AVIOContext paramAVIOContext, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avio_enum_protocols(@Cast({"void**"}) PointerPointer paramPointerPointer, int paramInt);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avio_enum_protocols(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, int paramInt);
/*      */ 
/*      */   public static native int avio_pause(AVIOContext paramAVIOContext, int paramInt);
/*      */ 
/*      */   public static native long avio_seek_time(AVIOContext paramAVIOContext, int paramInt1, long paramLong, int paramInt2);
/*      */ 
/*      */   public static native int av_get_packet(AVIOContext paramAVIOContext, avcodec.AVPacket paramAVPacket, int paramInt);
/*      */ 
/*      */   public static native int av_append_packet(AVIOContext paramAVIOContext, avcodec.AVPacket paramAVPacket, int paramInt);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVPROBE_SCORE_RETRY();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVSTREAM_PARSE_FULL_RAW();
/*      */ 
/*      */   @ByVal
/*      */   public static native avutil.AVRational av_stream_get_r_frame_rate(@Const AVStream paramAVStream);
/*      */ 
/*      */   public static native void av_stream_set_r_frame_rate(AVStream paramAVStream, @ByVal avutil.AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_format_get_probe_score(@Const AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native avcodec.AVCodec av_format_get_video_codec(@Const AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native void av_format_set_video_codec(AVFormatContext paramAVFormatContext, avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */   public static native avcodec.AVCodec av_format_get_audio_codec(@Const AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native void av_format_set_audio_codec(AVFormatContext paramAVFormatContext, avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */   public static native avcodec.AVCodec av_format_get_subtitle_codec(@Const AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native void av_format_set_subtitle_codec(AVFormatContext paramAVFormatContext, avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */   @Cast({"AVDurationEstimationMethod"})
/*      */   public static native int av_fmt_ctx_get_duration_estimation_method(@Const AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int avformat_version();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avformat_configuration();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avformat_license();
/*      */ 
/*      */   public static native void av_register_all();
/*      */ 
/*      */   public static native void av_register_input_format(AVInputFormat paramAVInputFormat);
/*      */ 
/*      */   public static native void av_register_output_format(AVOutputFormat paramAVOutputFormat);
/*      */ 
/*      */   public static native int avformat_network_init();
/*      */ 
/*      */   public static native int avformat_network_deinit();
/*      */ 
/*      */   public static native AVInputFormat av_iformat_next(AVInputFormat paramAVInputFormat);
/*      */ 
/*      */   public static native AVOutputFormat av_oformat_next(AVOutputFormat paramAVOutputFormat);
/*      */ 
/*      */   public static native AVFormatContext avformat_alloc_context();
/*      */ 
/*      */   public static native void avformat_free_context(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   @Const
/*      */   public static native avutil.AVClass avformat_get_class();
/*      */ 
/*      */   public static native AVStream avformat_new_stream(AVFormatContext paramAVFormatContext, @Const avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */   public static native AVProgram av_new_program(AVFormatContext paramAVFormatContext, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFormatContext avformat_alloc_output_context(@Cast({"const char*"}) BytePointer paramBytePointer1, AVOutputFormat paramAVOutputFormat, @Cast({"const char*"}) BytePointer paramBytePointer2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFormatContext avformat_alloc_output_context(String paramString1, AVOutputFormat paramAVOutputFormat, String paramString2);
/*      */ 
/*      */   public static native int avformat_alloc_output_context2(@Cast({"AVFormatContext**"}) PointerPointer paramPointerPointer, AVOutputFormat paramAVOutputFormat, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native int avformat_alloc_output_context2(@ByPtrPtr AVFormatContext paramAVFormatContext, AVOutputFormat paramAVOutputFormat, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native int avformat_alloc_output_context2(@ByPtrPtr AVFormatContext paramAVFormatContext, AVOutputFormat paramAVOutputFormat, String paramString1, String paramString2);
/*      */ 
/*      */   public static native AVInputFormat av_find_input_format(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVInputFormat av_find_input_format(String paramString);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format(AVProbeData paramAVProbeData, int paramInt);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format2(AVProbeData paramAVProbeData, int paramInt, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format2(AVProbeData paramAVProbeData, int paramInt, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format2(AVProbeData paramAVProbeData, int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format3(AVProbeData paramAVProbeData, int paramInt, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format3(AVProbeData paramAVProbeData, int paramInt, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native AVInputFormat av_probe_input_format3(AVProbeData paramAVProbeData, int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_probe_input_buffer2(AVIOContext paramAVIOContext, @Cast({"AVInputFormat**"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int av_probe_input_buffer2(AVIOContext paramAVIOContext, @ByPtrPtr AVInputFormat paramAVInputFormat, @Cast({"const char*"}) BytePointer paramBytePointer, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int av_probe_input_buffer2(AVIOContext paramAVIOContext, @ByPtrPtr AVInputFormat paramAVInputFormat, String paramString, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int av_probe_input_buffer(AVIOContext paramAVIOContext, @Cast({"AVInputFormat**"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int av_probe_input_buffer(AVIOContext paramAVIOContext, @ByPtrPtr AVInputFormat paramAVInputFormat, @Cast({"const char*"}) BytePointer paramBytePointer, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int av_probe_input_buffer(AVIOContext paramAVIOContext, @ByPtrPtr AVInputFormat paramAVInputFormat, String paramString, Pointer paramPointer, @Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2);
/*      */ 
/*      */   public static native int avformat_open_input(@Cast({"AVFormatContext**"}) PointerPointer paramPointerPointer1, @Cast({"const char*"}) BytePointer paramBytePointer, AVInputFormat paramAVInputFormat, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer2);
/*      */ 
/*      */   public static native int avformat_open_input(@ByPtrPtr AVFormatContext paramAVFormatContext, @Cast({"const char*"}) BytePointer paramBytePointer, AVInputFormat paramAVInputFormat, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int avformat_open_input(@ByPtrPtr AVFormatContext paramAVFormatContext, String paramString, AVInputFormat paramAVInputFormat, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_demuxer_open(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_find_stream_info(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native int avformat_find_stream_info(AVFormatContext paramAVFormatContext, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avformat_find_stream_info(AVFormatContext paramAVFormatContext, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native AVProgram av_find_program_from_stream(AVFormatContext paramAVFormatContext, AVProgram paramAVProgram, int paramInt);
/*      */ 
/*      */   public static native int av_find_best_stream(AVFormatContext paramAVFormatContext, @Cast({"AVMediaType"}) int paramInt1, int paramInt2, int paramInt3, @Cast({"AVCodec**"}) PointerPointer paramPointerPointer, int paramInt4);
/*      */ 
/*      */   public static native int av_find_best_stream(AVFormatContext paramAVFormatContext, @Cast({"AVMediaType"}) int paramInt1, int paramInt2, int paramInt3, @ByPtrPtr avcodec.AVCodec paramAVCodec, int paramInt4);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_read_packet(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_read_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_seek_frame(AVFormatContext paramAVFormatContext, int paramInt1, long paramLong, int paramInt2);
/*      */ 
/*      */   public static native int avformat_seek_file(AVFormatContext paramAVFormatContext, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*      */ 
/*      */   public static native int av_read_play(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native int av_read_pause(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_close_input_file(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native void avformat_close_input(@Cast({"AVFormatContext**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void avformat_close_input(@ByPtrPtr AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVStream av_new_stream(AVFormatContext paramAVFormatContext, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_set_pts_info(AVStream paramAVStream, int paramInt1, @Cast({"unsigned int"}) int paramInt2, @Cast({"unsigned int"}) int paramInt3);
/*      */ 
/*      */   public static native int avformat_write_header(AVFormatContext paramAVFormatContext, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avformat_write_header(AVFormatContext paramAVFormatContext, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int av_write_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_interleaved_write_frame(AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_write_trailer(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native AVOutputFormat av_guess_format(@Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native AVOutputFormat av_guess_format(String paramString1, String paramString2, String paramString3);
/*      */ 
/*      */   @Cast({"AVCodecID"})
/*      */   public static native int av_guess_codec(AVOutputFormat paramAVOutputFormat, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"AVMediaType"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVCodecID"})
/*      */   public static native int av_guess_codec(AVOutputFormat paramAVOutputFormat, String paramString1, String paramString2, String paramString3, @Cast({"AVMediaType"}) int paramInt);
/*      */ 
/*      */   public static native int av_get_output_timestamp(AVFormatContext paramAVFormatContext, int paramInt, LongPointer paramLongPointer1, LongPointer paramLongPointer2);
/*      */ 
/*      */   public static native int av_get_output_timestamp(AVFormatContext paramAVFormatContext, int paramInt, LongBuffer paramLongBuffer1, LongBuffer paramLongBuffer2);
/*      */ 
/*      */   public static native int av_get_output_timestamp(AVFormatContext paramAVFormatContext, int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2);
/*      */ 
/*      */   public static native void av_hex_dump(@Cast({"FILE*"}) Pointer paramPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native void av_hex_dump(@Cast({"FILE*"}) Pointer paramPointer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   public static native void av_hex_dump(@Cast({"FILE*"}) Pointer paramPointer, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   public static native void av_hex_dump_log(Pointer paramPointer, int paramInt1, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native void av_hex_dump_log(Pointer paramPointer, int paramInt1, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt2);
/*      */ 
/*      */   public static native void av_hex_dump_log(Pointer paramPointer, int paramInt1, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, int paramInt2);
/*      */ 
/*      */   public static native void av_pkt_dump2(@Cast({"FILE*"}) Pointer paramPointer, avcodec.AVPacket paramAVPacket, int paramInt, AVStream paramAVStream);
/*      */ 
/*      */   public static native void av_pkt_dump_log2(Pointer paramPointer, int paramInt1, avcodec.AVPacket paramAVPacket, int paramInt2, AVStream paramAVStream);
/*      */ 
/*      */   @Cast({"AVCodecID"})
/*      */   public static native int av_codec_get_id(@Cast({"const AVCodecTag*const*"}) PointerPointer paramPointerPointer, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVCodecID"})
/*      */   public static native int av_codec_get_id(@Const @ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int av_codec_get_tag(@Cast({"const AVCodecTag*const*"}) PointerPointer paramPointerPointer, @Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int av_codec_get_tag(@Const @ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   public static native int av_codec_get_tag2(@Cast({"const AVCodecTag*const*"}) PointerPointer paramPointerPointer, @Cast({"AVCodecID"}) int paramInt, @Cast({"unsigned int*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_codec_get_tag2(@Const @ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt, @Cast({"unsigned int*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_codec_get_tag2(@Const @ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt, @Cast({"unsigned int*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_codec_get_tag2(@Const @ByPtrPtr AVCodecTag paramAVCodecTag, @Cast({"AVCodecID"}) int paramInt, @Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_find_default_stream_index(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   public static native int av_index_search_timestamp(AVStream paramAVStream, long paramLong, int paramInt);
/*      */ 
/*      */   public static native int av_add_index_entry(AVStream paramAVStream, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt2, @Cast({"char*"}) BytePointer paramBytePointer3, int paramInt3, IntPointer paramIntPointer, @Cast({"char*"}) BytePointer paramBytePointer4, int paramInt4, @Cast({"const char*"}) BytePointer paramBytePointer5);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) ByteBuffer paramByteBuffer1, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer2, int paramInt2, @Cast({"char*"}) ByteBuffer paramByteBuffer3, int paramInt3, IntBuffer paramIntBuffer, @Cast({"char*"}) ByteBuffer paramByteBuffer4, int paramInt4, String paramString);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) byte[] paramArrayOfByte1, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte2, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte3, int paramInt3, int[] paramArrayOfInt, @Cast({"char*"}) byte[] paramArrayOfByte4, int paramInt4, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt2, @Cast({"char*"}) BytePointer paramBytePointer3, int paramInt3, IntPointer paramIntPointer, @Cast({"char*"}) BytePointer paramBytePointer4, int paramInt4, String paramString);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) ByteBuffer paramByteBuffer1, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer2, int paramInt2, @Cast({"char*"}) ByteBuffer paramByteBuffer3, int paramInt3, IntBuffer paramIntBuffer, @Cast({"char*"}) ByteBuffer paramByteBuffer4, int paramInt4, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native void av_url_split(@Cast({"char*"}) byte[] paramArrayOfByte1, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte2, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte3, int paramInt3, int[] paramArrayOfInt, @Cast({"char*"}) byte[] paramArrayOfByte4, int paramInt4, String paramString);
/*      */ 
/*      */   public static native void av_dump_format(AVFormatContext paramAVFormatContext, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native void av_dump_format(AVFormatContext paramAVFormatContext, int paramInt1, String paramString, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, String paramString, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, String paramString, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int av_get_frame_filename(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, String paramString, int paramInt2);
/*      */ 
/*      */   public static native int av_filename_number_test(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_filename_number_test(String paramString);
/*      */ 
/*      */   public static native int av_sdp_create(@Cast({"AVFormatContext**"}) PointerPointer paramPointerPointer, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int av_sdp_create(@ByPtrPtr AVFormatContext paramAVFormatContext, int paramInt1, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2);
/*      */ 
/*      */   public static native int av_sdp_create(@ByPtrPtr AVFormatContext paramAVFormatContext, int paramInt1, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2);
/*      */ 
/*      */   public static native int av_sdp_create(@ByPtrPtr AVFormatContext paramAVFormatContext, int paramInt1, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2);
/*      */ 
/*      */   public static native int av_match_ext(@Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native int av_match_ext(String paramString1, String paramString2);
/*      */ 
/*      */   public static native int avformat_query_codec(AVOutputFormat paramAVOutputFormat, @Cast({"AVCodecID"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecTag avformat_get_riff_video_tags();
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecTag avformat_get_riff_audio_tags();
/*      */ 
/*      */   @ByVal
/*      */   public static native avutil.AVRational av_guess_sample_aspect_ratio(AVFormatContext paramAVFormatContext, AVStream paramAVStream, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @ByVal
/*      */   public static native avutil.AVRational av_guess_frame_rate(AVFormatContext paramAVFormatContext, AVStream paramAVStream, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int avformat_match_stream_specifier(AVFormatContext paramAVFormatContext, AVStream paramAVStream, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avformat_match_stream_specifier(AVFormatContext paramAVFormatContext, AVStream paramAVStream, String paramString);
/*      */ 
/*      */   public static native int avformat_queue_attached_pictures(AVFormatContext paramAVFormatContext);
/*      */ 
/*      */   static
/*      */   {
/*   40 */     Loader.load();
/*      */   }
/*      */ 
/*      */   public static class AVPacketList extends Pointer
/*      */   {
/*      */     public AVPacketList()
/*      */     {
/* 2341 */       allocate(); } 
/* 2342 */     public AVPacketList(int size) { allocateArray(size); } 
/* 2343 */     public AVPacketList(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2347 */     public AVPacketList position(int position) { return (AVPacketList)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByVal
/*      */     public native avcodec.AVPacket pkt();
/*      */ 
/*      */     public native AVPacketList pkt(avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */     public native AVPacketList next();
/*      */ 
/*      */     public native AVPacketList next(AVPacketList paramAVPacketList);
/*      */ 
/*      */     static
/*      */     {
/* 2340 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFormatContext extends Pointer
/*      */   {
/*      */     public static final int AVFMT_FLAG_GENPTS = 1;
/*      */     public static final int AVFMT_FLAG_IGNIDX = 2;
/*      */     public static final int AVFMT_FLAG_NONBLOCK = 4;
/*      */     public static final int AVFMT_FLAG_IGNDTS = 8;
/*      */     public static final int AVFMT_FLAG_NOFILLIN = 16;
/*      */     public static final int AVFMT_FLAG_NOPARSE = 32;
/*      */     public static final int AVFMT_FLAG_NOBUFFER = 64;
/*      */     public static final int AVFMT_FLAG_CUSTOM_IO = 128;
/*      */     public static final int AVFMT_FLAG_DISCARD_CORRUPT = 256;
/*      */     public static final int AVFMT_FLAG_FLUSH_PACKETS = 512;
/*      */     public static final int AVFMT_FLAG_MP4A_LATM = 32768;
/*      */     public static final int AVFMT_FLAG_SORT_DTS = 65536;
/*      */     public static final int AVFMT_FLAG_PRIV_OPT = 131072;
/*      */     public static final int AVFMT_FLAG_KEEP_SIDE_DATA = 262144;
/*      */     public static final int FF_FDEBUG_TS = 1;
/*      */     public static final int RAW_PACKET_BUFFER_SIZE = 2500000;
/*      */ 
/*      */     public AVFormatContext()
/*      */     {
/* 1910 */       allocate(); } 
/* 1911 */     public AVFormatContext(int size) { allocateArray(size); } 
/* 1912 */     public AVFormatContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1916 */     public AVFormatContext position(int position) { return (AVFormatContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass av_class();
/*      */ 
/*      */     public native avformat.AVInputFormat iformat();
/*      */ 
/*      */     public native AVFormatContext iformat(avformat.AVInputFormat paramAVInputFormat);
/*      */ 
/*      */     public native avformat.AVOutputFormat oformat();
/*      */ 
/*      */     public native AVFormatContext oformat(avformat.AVOutputFormat paramAVOutputFormat);
/*      */ 
/*      */     public native Pointer priv_data();
/*      */ 
/*      */     public native AVFormatContext priv_data(Pointer paramPointer);
/*      */ 
/*      */     public native avformat.AVIOContext pb();
/*      */ 
/*      */     public native AVFormatContext pb(avformat.AVIOContext paramAVIOContext);
/*      */ 
/*      */     public native int ctx_flags();
/*      */ 
/*      */     public native AVFormatContext ctx_flags(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int nb_streams();
/*      */ 
/*      */     public native AVFormatContext nb_streams(int paramInt);
/*      */ 
/*      */     public native avformat.AVStream streams(int paramInt);
/*      */ 
/*      */     public native AVFormatContext streams(int paramInt, avformat.AVStream paramAVStream);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVStream**"})
/*      */     public native PointerPointer streams();
/*      */ 
/*      */     @Cast({"char"})
/*      */     public native byte filename(int paramInt);
/*      */ 
/*      */     public native AVFormatContext filename(int paramInt, byte paramByte);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"char*"})
/*      */     public native BytePointer filename();
/*      */ 
/*      */     public native long start_time();
/*      */ 
/*      */     public native AVFormatContext start_time(long paramLong);
/*      */ 
/*      */     public native long duration();
/*      */ 
/*      */     public native AVFormatContext duration(long paramLong);
/*      */ 
/*      */     public native int bit_rate();
/*      */ 
/*      */     public native AVFormatContext bit_rate(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int packet_size();
/*      */ 
/*      */     public native AVFormatContext packet_size(int paramInt);
/*      */ 
/*      */     public native int max_delay();
/*      */ 
/*      */     public native AVFormatContext max_delay(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVFormatContext flags(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int probesize();
/*      */ 
/*      */     public native AVFormatContext probesize(int paramInt);
/*      */ 
/*      */     public native int max_analyze_duration();
/*      */ 
/*      */     public native AVFormatContext max_analyze_duration(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const uint8_t*"})
/*      */     public native BytePointer key();
/*      */ 
/*      */     public native int keylen();
/*      */ 
/*      */     public native AVFormatContext keylen(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int nb_programs();
/*      */ 
/*      */     public native AVFormatContext nb_programs(int paramInt);
/*      */ 
/*      */     public native avformat.AVProgram programs(int paramInt);
/*      */ 
/*      */     public native AVFormatContext programs(int paramInt, avformat.AVProgram paramAVProgram);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVProgram**"})
/*      */     public native PointerPointer programs();
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int video_codec_id();
/*      */ 
/*      */     public native AVFormatContext video_codec_id(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int audio_codec_id();
/*      */ 
/*      */     public native AVFormatContext audio_codec_id(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int subtitle_codec_id();
/*      */ 
/*      */     public native AVFormatContext subtitle_codec_id(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int max_index_size();
/*      */ 
/*      */     public native AVFormatContext max_index_size(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int max_picture_buffer();
/*      */ 
/*      */     public native AVFormatContext max_picture_buffer(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int nb_chapters();
/*      */ 
/*      */     public native AVFormatContext nb_chapters(int paramInt);
/*      */ 
/*      */     public native avformat.AVChapter chapters(int paramInt);
/*      */ 
/*      */     public native AVFormatContext chapters(int paramInt, avformat.AVChapter paramAVChapter);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVChapter**"})
/*      */     public native PointerPointer chapters();
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVFormatContext metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     public native long start_time_realtime();
/*      */ 
/*      */     public native AVFormatContext start_time_realtime(long paramLong);
/*      */ 
/*      */     public native int fps_probe_size();
/*      */ 
/*      */     public native AVFormatContext fps_probe_size(int paramInt);
/*      */ 
/*      */     public native int error_recognition();
/*      */ 
/*      */     public native AVFormatContext error_recognition(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avformat.AVIOInterruptCB interrupt_callback();
/*      */ 
/*      */     public native AVFormatContext interrupt_callback(avformat.AVIOInterruptCB paramAVIOInterruptCB);
/*      */ 
/*      */     public native int debug();
/*      */ 
/*      */     public native AVFormatContext debug(int paramInt);
/*      */ 
/*      */     public native int ts_id();
/*      */ 
/*      */     public native AVFormatContext ts_id(int paramInt);
/*      */ 
/*      */     public native int audio_preload();
/*      */ 
/*      */     public native AVFormatContext audio_preload(int paramInt);
/*      */ 
/*      */     public native int max_chunk_duration();
/*      */ 
/*      */     public native AVFormatContext max_chunk_duration(int paramInt);
/*      */ 
/*      */     public native int max_chunk_size();
/*      */ 
/*      */     public native AVFormatContext max_chunk_size(int paramInt);
/*      */ 
/*      */     public native int use_wallclock_as_timestamps();
/*      */ 
/*      */     public native AVFormatContext use_wallclock_as_timestamps(int paramInt);
/*      */ 
/*      */     public native int avoid_negative_ts();
/*      */ 
/*      */     public native AVFormatContext avoid_negative_ts(int paramInt);
/*      */ 
/*      */     public native int avio_flags();
/*      */ 
/*      */     public native AVFormatContext avio_flags(int paramInt);
/*      */ 
/*      */     @Cast({"AVDurationEstimationMethod"})
/*      */     public native int duration_estimation_method();
/*      */ 
/*      */     public native AVFormatContext duration_estimation_method(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int skip_initial_bytes();
/*      */ 
/*      */     public native AVFormatContext skip_initial_bytes(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int correct_ts_overflow();
/*      */ 
/*      */     public native AVFormatContext correct_ts_overflow(int paramInt);
/*      */ 
/*      */     public native int seek2any();
/*      */ 
/*      */     public native AVFormatContext seek2any(int paramInt);
/*      */ 
/*      */     public native int flush_packets();
/*      */ 
/*      */     public native AVFormatContext flush_packets(int paramInt);
/*      */ 
/*      */     public native int probe_score();
/*      */ 
/*      */     public native AVFormatContext probe_score(int paramInt);
/*      */ 
/*      */     public native avformat.AVPacketList packet_buffer();
/*      */ 
/*      */     public native AVFormatContext packet_buffer(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native avformat.AVPacketList packet_buffer_end();
/*      */ 
/*      */     public native AVFormatContext packet_buffer_end(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native long data_offset();
/*      */ 
/*      */     public native AVFormatContext data_offset(long paramLong);
/*      */ 
/*      */     public native avformat.AVPacketList raw_packet_buffer();
/*      */ 
/*      */     public native AVFormatContext raw_packet_buffer(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native avformat.AVPacketList raw_packet_buffer_end();
/*      */ 
/*      */     public native AVFormatContext raw_packet_buffer_end(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native avformat.AVPacketList parse_queue();
/*      */ 
/*      */     public native AVFormatContext parse_queue(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native avformat.AVPacketList parse_queue_end();
/*      */ 
/*      */     public native AVFormatContext parse_queue_end(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     public native int raw_packet_buffer_remaining_size();
/*      */ 
/*      */     public native AVFormatContext raw_packet_buffer_remaining_size(int paramInt);
/*      */ 
/*      */     public native long offset();
/*      */ 
/*      */     public native AVFormatContext offset(long paramLong);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational offset_timebase();
/*      */ 
/*      */     public native AVFormatContext offset_timebase(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native int io_repositioned();
/*      */ 
/*      */     public native AVFormatContext io_repositioned(int paramInt);
/*      */ 
/*      */     public native avcodec.AVCodec video_codec();
/*      */ 
/*      */     public native AVFormatContext video_codec(avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */     public native avcodec.AVCodec audio_codec();
/*      */ 
/*      */     public native AVFormatContext audio_codec(avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */     public native avcodec.AVCodec subtitle_codec();
/*      */ 
/*      */     public native AVFormatContext subtitle_codec(avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */     static
/*      */     {
/* 1909 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVChapter extends Pointer
/*      */   {
/*      */     public AVChapter()
/*      */     {
/* 1867 */       allocate(); } 
/* 1868 */     public AVChapter(int size) { allocateArray(size); } 
/* 1869 */     public AVChapter(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1873 */     public AVChapter position(int position) { return (AVChapter)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native AVChapter id(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational time_base();
/*      */ 
/*      */     public native AVChapter time_base(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native long start();
/*      */ 
/*      */     public native AVChapter start(long paramLong);
/*      */ 
/*      */     public native long end();
/*      */ 
/*      */     public native AVChapter end(long paramLong);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVChapter metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     static
/*      */     {
/* 1866 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVProgram extends Pointer
/*      */   {
/*      */     public AVProgram()
/*      */     {
/* 1824 */       allocate(); } 
/* 1825 */     public AVProgram(int size) { allocateArray(size); } 
/* 1826 */     public AVProgram(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1830 */     public AVProgram position(int position) { return (AVProgram)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native AVProgram id(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVProgram flags(int paramInt);
/*      */ 
/*      */     @Cast({"AVDiscard"})
/*      */     public native int discard();
/*      */ 
/*      */     public native AVProgram discard(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int*"})
/*      */     public native IntPointer stream_index();
/*      */ 
/*      */     public native AVProgram stream_index(IntPointer paramIntPointer);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int nb_stream_indexes();
/*      */ 
/*      */     public native AVProgram nb_stream_indexes(int paramInt);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVProgram metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     public native int program_num();
/*      */ 
/*      */     public native AVProgram program_num(int paramInt);
/*      */ 
/*      */     public native int pmt_pid();
/*      */ 
/*      */     public native AVProgram pmt_pid(int paramInt);
/*      */ 
/*      */     public native int pcr_pid();
/*      */ 
/*      */     public native AVProgram pcr_pid(int paramInt);
/*      */ 
/*      */     public native long start_time();
/*      */ 
/*      */     public native AVProgram start_time(long paramLong);
/*      */ 
/*      */     public native long end_time();
/*      */ 
/*      */     public native AVProgram end_time(long paramLong);
/*      */ 
/*      */     public native long pts_wrap_reference();
/*      */ 
/*      */     public native AVProgram pts_wrap_reference(long paramLong);
/*      */ 
/*      */     public native int pts_wrap_behavior();
/*      */ 
/*      */     public native AVProgram pts_wrap_behavior(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1823 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVStream extends Pointer
/*      */   {
/*      */     public static final int MAX_STD_TIMEBASES = 726;
/*      */     public static final int MAX_PROBE_PACKETS = 2500;
/*      */     public static final int MAX_REORDER_DELAY = 16;
/*      */ 
/*      */     public AVStream()
/*      */     {
/* 1565 */       allocate(); } 
/* 1566 */     public AVStream(int size) { allocateArray(size); } 
/* 1567 */     public AVStream(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1571 */     public AVStream position(int position) { return (AVStream)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int index();
/*      */ 
/*      */     public native AVStream index(int paramInt);
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native AVStream id(int paramInt);
/*      */ 
/*      */     public native avcodec.AVCodecContext codec();
/*      */ 
/*      */     public native AVStream codec(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */     public native Pointer priv_data();
/*      */ 
/*      */     public native AVStream priv_data(Pointer paramPointer);
/*      */ 
/*      */     @ByVal
/*      */     public native avformat.AVFrac pts();
/*      */ 
/*      */     public native AVStream pts(avformat.AVFrac paramAVFrac);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational time_base();
/*      */ 
/*      */     public native AVStream time_base(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native long start_time();
/*      */ 
/*      */     public native AVStream start_time(long paramLong);
/*      */ 
/*      */     public native long duration();
/*      */ 
/*      */     public native AVStream duration(long paramLong);
/*      */ 
/*      */     public native long nb_frames();
/*      */ 
/*      */     public native AVStream nb_frames(long paramLong);
/*      */ 
/*      */     public native int disposition();
/*      */ 
/*      */     public native AVStream disposition(int paramInt);
/*      */ 
/*      */     @Cast({"AVDiscard"})
/*      */     public native int discard();
/*      */ 
/*      */     public native AVStream discard(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational sample_aspect_ratio();
/*      */ 
/*      */     public native AVStream sample_aspect_ratio(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVStream metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational avg_frame_rate();
/*      */ 
/*      */     public native AVStream avg_frame_rate(avutil.AVRational paramAVRational);
/*      */ 
/*      */     @ByVal
/*      */     public native avcodec.AVPacket attached_pic();
/*      */ 
/*      */     public native AVStream attached_pic(avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */     @Name({"info", ".last_dts"})
/*      */     public native long info_last_dts(int paramInt);
/*      */ 
/*      */     public native AVStream info_last_dts(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".duration_gcd"})
/*      */     public native long info_duration_gcd(int paramInt);
/*      */ 
/*      */     public native AVStream info_duration_gcd(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".duration_count"})
/*      */     public native int info_duration_count(int paramInt);
/*      */ 
/*      */     public native AVStream info_duration_count(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"info", ".duration_error"})
/*      */     @MemberGetter
/*      */     @Cast({"double*"})
/*      */     public native DoublePointer info_duration_error(int paramInt);
/*      */ 
/*      */     @Name({"info", ".codec_info_duration"})
/*      */     public native long info_codec_info_duration(int paramInt);
/*      */ 
/*      */     public native AVStream info_codec_info_duration(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".codec_info_duration_fields"})
/*      */     public native long info_codec_info_duration_fields(int paramInt);
/*      */ 
/*      */     public native AVStream info_codec_info_duration_fields(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".found_decoder"})
/*      */     public native int info_found_decoder(int paramInt);
/*      */ 
/*      */     public native AVStream info_found_decoder(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"info", ".last_duration"})
/*      */     public native long info_last_duration(int paramInt);
/*      */ 
/*      */     public native AVStream info_last_duration(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".fps_first_dts"})
/*      */     public native long info_fps_first_dts(int paramInt);
/*      */ 
/*      */     public native AVStream info_fps_first_dts(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".fps_first_dts_idx"})
/*      */     public native int info_fps_first_dts_idx(int paramInt);
/*      */ 
/*      */     public native AVStream info_fps_first_dts_idx(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"info", ".fps_last_dts"})
/*      */     public native long info_fps_last_dts(int paramInt);
/*      */ 
/*      */     public native AVStream info_fps_last_dts(int paramInt, long paramLong);
/*      */ 
/*      */     @Name({"info", ".fps_last_dts_idx"})
/*      */     public native int info_fps_last_dts_idx(int paramInt);
/*      */ 
/*      */     public native AVStream info_fps_last_dts_idx(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int pts_wrap_bits();
/*      */ 
/*      */     public native AVStream pts_wrap_bits(int paramInt);
/*      */ 
/*      */     public native long reference_dts();
/*      */ 
/*      */     public native AVStream reference_dts(long paramLong);
/*      */ 
/*      */     public native long first_dts();
/*      */ 
/*      */     public native AVStream first_dts(long paramLong);
/*      */ 
/*      */     public native long cur_dts();
/*      */ 
/*      */     public native AVStream cur_dts(long paramLong);
/*      */ 
/*      */     public native long last_IP_pts();
/*      */ 
/*      */     public native AVStream last_IP_pts(long paramLong);
/*      */ 
/*      */     public native int last_IP_duration();
/*      */ 
/*      */     public native AVStream last_IP_duration(int paramInt);
/*      */ 
/*      */     public native int probe_packets();
/*      */ 
/*      */     public native AVStream probe_packets(int paramInt);
/*      */ 
/*      */     public native int codec_info_nb_frames();
/*      */ 
/*      */     public native AVStream codec_info_nb_frames(int paramInt);
/*      */ 
/*      */     @Cast({"AVStreamParseType"})
/*      */     public native int need_parsing();
/*      */ 
/*      */     public native AVStream need_parsing(int paramInt);
/*      */ 
/*      */     public native avcodec.AVCodecParserContext parser();
/*      */ 
/*      */     public native AVStream parser(avcodec.AVCodecParserContext paramAVCodecParserContext);
/*      */ 
/*      */     public native avformat.AVPacketList last_in_packet_buffer();
/*      */ 
/*      */     public native AVStream last_in_packet_buffer(avformat.AVPacketList paramAVPacketList);
/*      */ 
/*      */     @ByVal
/*      */     public native avformat.AVProbeData probe_data();
/*      */ 
/*      */     public native AVStream probe_data(avformat.AVProbeData paramAVProbeData);
/*      */ 
/*      */     public native long pts_buffer(int paramInt);
/*      */ 
/*      */     public native AVStream pts_buffer(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer pts_buffer();
/*      */ 
/*      */     public native avformat.AVIndexEntry index_entries();
/*      */ 
/*      */     public native AVStream index_entries(avformat.AVIndexEntry paramAVIndexEntry);
/*      */ 
/*      */     public native int nb_index_entries();
/*      */ 
/*      */     public native AVStream nb_index_entries(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int index_entries_allocated_size();
/*      */ 
/*      */     public native AVStream index_entries_allocated_size(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational r_frame_rate();
/*      */ 
/*      */     public native AVStream r_frame_rate(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native int stream_identifier();
/*      */ 
/*      */     public native AVStream stream_identifier(int paramInt);
/*      */ 
/*      */     public native long interleaver_chunk_size();
/*      */ 
/*      */     public native AVStream interleaver_chunk_size(long paramLong);
/*      */ 
/*      */     public native long interleaver_chunk_duration();
/*      */ 
/*      */     public native AVStream interleaver_chunk_duration(long paramLong);
/*      */ 
/*      */     public native int request_probe();
/*      */ 
/*      */     public native AVStream request_probe(int paramInt);
/*      */ 
/*      */     public native int skip_to_keyframe();
/*      */ 
/*      */     public native AVStream skip_to_keyframe(int paramInt);
/*      */ 
/*      */     public native int skip_samples();
/*      */ 
/*      */     public native AVStream skip_samples(int paramInt);
/*      */ 
/*      */     public native int nb_decoded_frames();
/*      */ 
/*      */     public native AVStream nb_decoded_frames(int paramInt);
/*      */ 
/*      */     public native long mux_ts_offset();
/*      */ 
/*      */     public native AVStream mux_ts_offset(long paramLong);
/*      */ 
/*      */     public native long pts_wrap_reference();
/*      */ 
/*      */     public native AVStream pts_wrap_reference(long paramLong);
/*      */ 
/*      */     public native int pts_wrap_behavior();
/*      */ 
/*      */     public native AVStream pts_wrap_behavior(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1564 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVIndexEntry extends Pointer
/*      */   {
/*      */     public static final int AVINDEX_KEYFRAME = 1;
/*      */ 
/*      */     public AVIndexEntry()
/*      */     {
/* 1488 */       allocate(); } 
/* 1489 */     public AVIndexEntry(int size) { allocateArray(size); } 
/* 1490 */     public AVIndexEntry(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1494 */     public AVIndexEntry position(int position) { return (AVIndexEntry)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native long pos();
/*      */ 
/*      */     public native AVIndexEntry pos(long paramLong);
/*      */ 
/*      */     public native long timestamp();
/*      */ 
/*      */     public native AVIndexEntry timestamp(long paramLong);
/*      */ 
/*      */     @NoOffset
/*      */     public native int flags();
/*      */ 
/*      */     public native AVIndexEntry flags(int paramInt);
/*      */ 
/*      */     @NoOffset
/*      */     public native int size();
/*      */ 
/*      */     public native AVIndexEntry size(int paramInt);
/*      */ 
/*      */     public native int min_distance();
/*      */ 
/*      */     public native AVIndexEntry min_distance(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1487 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVInputFormat extends Pointer
/*      */   {
/*      */     public AVInputFormat()
/*      */     {
/* 1271 */       allocate(); } 
/* 1272 */     public AVInputFormat(int size) { allocateArray(size); } 
/* 1273 */     public AVInputFormat(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1277 */     public AVInputFormat position(int position) { return (AVInputFormat)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer long_name();
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVInputFormat flags(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer extensions();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avformat.AVCodecTag codec_tag(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVCodecTag*const*"})
/*      */     public native PointerPointer codec_tag();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass priv_class();
/*      */ 
/*      */     public native AVInputFormat next();
/*      */ 
/*      */     public native AVInputFormat next(AVInputFormat paramAVInputFormat);
/*      */ 
/*      */     public native int raw_codec_id();
/*      */ 
/*      */     public native AVInputFormat raw_codec_id(int paramInt);
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVInputFormat priv_data_size(int paramInt);
/*      */ 
/*      */     public native Read_probe_AVProbeData read_probe();
/*      */ 
/*      */     public native AVInputFormat read_probe(Read_probe_AVProbeData paramRead_probe_AVProbeData);
/*      */ 
/*      */     public native Read_header_AVFormatContext read_header();
/*      */ 
/*      */     public native AVInputFormat read_header(Read_header_AVFormatContext paramRead_header_AVFormatContext);
/*      */ 
/*      */     public native Read_packet_AVFormatContext_AVPacket read_packet();
/*      */ 
/*      */     public native AVInputFormat read_packet(Read_packet_AVFormatContext_AVPacket paramRead_packet_AVFormatContext_AVPacket);
/*      */ 
/*      */     public native Read_close_AVFormatContext read_close();
/*      */ 
/*      */     public native AVInputFormat read_close(Read_close_AVFormatContext paramRead_close_AVFormatContext);
/*      */ 
/*      */     public native Read_seek_AVFormatContext_int_long_int read_seek();
/*      */ 
/*      */     public native AVInputFormat read_seek(Read_seek_AVFormatContext_int_long_int paramRead_seek_AVFormatContext_int_long_int);
/*      */ 
/*      */     public native Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp();
/*      */ 
/*      */     public native AVInputFormat read_timestamp(Read_timestamp_AVFormatContext_int_LongPointer_long paramRead_timestamp_AVFormatContext_int_LongPointer_long);
/*      */ 
/*      */     public native Read_play_AVFormatContext read_play();
/*      */ 
/*      */     public native AVInputFormat read_play(Read_play_AVFormatContext paramRead_play_AVFormatContext);
/*      */ 
/*      */     public native Read_pause_AVFormatContext read_pause();
/*      */ 
/*      */     public native AVInputFormat read_pause(Read_pause_AVFormatContext paramRead_pause_AVFormatContext);
/*      */ 
/*      */     public native Read_seek2_AVFormatContext_int_long_long_long_int read_seek2();
/*      */ 
/*      */     public native AVInputFormat read_seek2(Read_seek2_AVFormatContext_int_long_long_long_int paramRead_seek2_AVFormatContext_int_long_long_long_int);
/*      */ 
/*      */     static
/*      */     {
/* 1270 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Read_seek2_AVFormatContext_int_long_long_long_int extends FunctionPointer
/*      */     {
/*      */       public Read_seek2_AVFormatContext_int_long_long_long_int(Pointer p)
/*      */       {
/* 1457 */         super(); } 
/* 1458 */       protected Read_seek2_AVFormatContext_int_long_long_long_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 1456 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_pause_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Read_pause_AVFormatContext(Pointer p)
/*      */       {
/* 1442 */         super(); } 
/* 1443 */       protected Read_pause_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1441 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_play_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Read_play_AVFormatContext(Pointer p)
/*      */       {
/* 1429 */         super(); } 
/* 1430 */       protected Read_play_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1428 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_timestamp_AVFormatContext_int_LongPointer_long extends FunctionPointer
/*      */     {
/*      */       public Read_timestamp_AVFormatContext_int_LongPointer_long(Pointer p)
/*      */       {
/* 1415 */         super(); } 
/* 1416 */       protected Read_timestamp_AVFormatContext_int_LongPointer_long() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native long call(avformat.AVFormatContext paramAVFormatContext, int paramInt, LongPointer paramLongPointer, long paramLong);
/*      */ 
/*      */       static
/*      */       {
/* 1414 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_seek_AVFormatContext_int_long_int extends FunctionPointer
/*      */     {
/*      */       public Read_seek_AVFormatContext_int_long_int(Pointer p)
/*      */       {
/* 1401 */         super(); } 
/* 1402 */       protected Read_seek_AVFormatContext_int_long_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext, int paramInt1, long paramLong, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 1400 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_close_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Read_close_AVFormatContext(Pointer p)
/*      */       {
/* 1384 */         super(); } 
/* 1385 */       protected Read_close_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1383 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_packet_AVFormatContext_AVPacket extends FunctionPointer
/*      */     {
/*      */       public Read_packet_AVFormatContext_AVPacket(Pointer p)
/*      */       {
/* 1371 */         super(); } 
/* 1372 */       protected Read_packet_AVFormatContext_AVPacket() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */       static
/*      */       {
/* 1370 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_header_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Read_header_AVFormatContext(Pointer p)
/*      */       {
/* 1353 */         super(); } 
/* 1354 */       protected Read_header_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1352 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_probe_AVProbeData extends FunctionPointer
/*      */     {
/*      */       public Read_probe_AVProbeData(Pointer p)
/*      */       {
/* 1339 */         super(); } 
/* 1340 */       protected Read_probe_AVProbeData() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVProbeData paramAVProbeData);
/*      */ 
/*      */       static
/*      */       {
/* 1338 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVOutputFormat extends Pointer
/*      */   {
/*      */     public AVOutputFormat()
/*      */     {
/* 1134 */       allocate(); } 
/* 1135 */     public AVOutputFormat(int size) { allocateArray(size); } 
/* 1136 */     public AVOutputFormat(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1140 */     public AVOutputFormat position(int position) { return (AVOutputFormat)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer long_name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer mime_type();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer extensions();
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int audio_codec();
/*      */ 
/*      */     public native AVOutputFormat audio_codec(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int video_codec();
/*      */ 
/*      */     public native AVOutputFormat video_codec(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int subtitle_codec();
/*      */ 
/*      */     public native AVOutputFormat subtitle_codec(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVOutputFormat flags(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avformat.AVCodecTag codec_tag(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVCodecTag*const*"})
/*      */     public native PointerPointer codec_tag();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass priv_class();
/*      */ 
/*      */     public native AVOutputFormat next();
/*      */ 
/*      */     public native AVOutputFormat next(AVOutputFormat paramAVOutputFormat);
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVOutputFormat priv_data_size(int paramInt);
/*      */ 
/*      */     public native Write_header_AVFormatContext write_header();
/*      */ 
/*      */     public native AVOutputFormat write_header(Write_header_AVFormatContext paramWrite_header_AVFormatContext);
/*      */ 
/*      */     public native Write_packet_AVFormatContext_AVPacket write_packet();
/*      */ 
/*      */     public native AVOutputFormat write_packet(Write_packet_AVFormatContext_AVPacket paramWrite_packet_AVFormatContext_AVPacket);
/*      */ 
/*      */     public native Write_trailer_AVFormatContext write_trailer();
/*      */ 
/*      */     public native AVOutputFormat write_trailer(Write_trailer_AVFormatContext paramWrite_trailer_AVFormatContext);
/*      */ 
/*      */     public native Interleave_packet_AVFormatContext_AVPacket_AVPacket_int interleave_packet();
/*      */ 
/*      */     public native AVOutputFormat interleave_packet(Interleave_packet_AVFormatContext_AVPacket_AVPacket_int paramInterleave_packet_AVFormatContext_AVPacket_AVPacket_int);
/*      */ 
/*      */     public native Query_codec_int_int query_codec();
/*      */ 
/*      */     public native AVOutputFormat query_codec(Query_codec_int_int paramQuery_codec_int_int);
/*      */ 
/*      */     public native Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer get_output_timestamp();
/*      */ 
/*      */     public native AVOutputFormat get_output_timestamp(Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer paramGet_output_timestamp_AVFormatContext_int_LongPointer_LongPointer);
/*      */ 
/*      */     static
/*      */     {
/* 1133 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer extends FunctionPointer
/*      */     {
/*      */       public Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer(Pointer p)
/*      */       {
/* 1253 */         super(); } 
/* 1254 */       protected Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avformat.AVFormatContext paramAVFormatContext, int paramInt, LongPointer paramLongPointer1, LongPointer paramLongPointer2);
/*      */ 
/*      */       static
/*      */       {
/* 1252 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Query_codec_int_int extends FunctionPointer
/*      */     {
/*      */       public Query_codec_int_int(Pointer p)
/*      */       {
/* 1244 */         super(); } 
/* 1245 */       protected Query_codec_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(@Cast({"AVCodecID"}) int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 1243 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Interleave_packet_AVFormatContext_AVPacket_AVPacket_int extends FunctionPointer
/*      */     {
/*      */       public Interleave_packet_AVFormatContext_AVPacket_AVPacket_int(Pointer p)
/*      */       {
/* 1228 */         super(); } 
/* 1229 */       protected Interleave_packet_AVFormatContext_AVPacket_AVPacket_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket1, avcodec.AVPacket paramAVPacket2, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 1227 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Write_trailer_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Write_trailer_AVFormatContext(Pointer p)
/*      */       {
/* 1217 */         super(); } 
/* 1218 */       protected Write_trailer_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1216 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Write_packet_AVFormatContext_AVPacket extends FunctionPointer
/*      */     {
/*      */       public Write_packet_AVFormatContext_AVPacket(Pointer p)
/*      */       {
/* 1209 */         super(); } 
/* 1210 */       protected Write_packet_AVFormatContext_AVPacket() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */       static
/*      */       {
/* 1208 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Write_header_AVFormatContext extends FunctionPointer
/*      */     {
/*      */       public Write_header_AVFormatContext(Pointer p)
/*      */       {
/* 1194 */         super(); } 
/* 1195 */       protected Write_header_AVFormatContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avformat.AVFormatContext paramAVFormatContext);
/*      */ 
/*      */       static
/*      */       {
/* 1193 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVProbeData extends Pointer
/*      */   {
/*      */     public AVProbeData()
/*      */     {
/* 1051 */       allocate(); } 
/* 1052 */     public AVProbeData(int size) { allocateArray(size); } 
/* 1053 */     public AVProbeData(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1057 */     public AVProbeData position(int position) { return (AVProbeData)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer filename();
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer buf();
/*      */ 
/*      */     public native AVProbeData buf(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int buf_size();
/*      */ 
/*      */     public native AVProbeData buf_size(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1050 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVCodecTag extends Pointer
/*      */   {
/*      */     public AVCodecTag()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVCodecTag(Pointer p)
/*      */     {
/* 1043 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFrac extends Pointer
/*      */   {
/*      */     public AVFrac()
/*      */     {
/* 1024 */       allocate(); } 
/* 1025 */     public AVFrac(int size) { allocateArray(size); } 
/* 1026 */     public AVFrac(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1030 */     public AVFrac position(int position) { return (AVFrac)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native long val();
/*      */ 
/*      */     public native AVFrac val(long paramLong);
/*      */ 
/*      */     public native long num();
/*      */ 
/*      */     public native AVFrac num(long paramLong);
/*      */ 
/*      */     public native long den();
/*      */ 
/*      */     public native AVFrac den(long paramLong);
/*      */ 
/*      */     static
/*      */     {
/* 1023 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Write_packet_Pointer_byte_int extends FunctionPointer
/*      */   {
/*      */     public Write_packet_Pointer_byte_int(Pointer p)
/*      */     {
/*  355 */       super(); } 
/*  356 */     protected Write_packet_Pointer_byte_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  354 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Read_packet_Pointer_byte_int extends FunctionPointer
/*      */   {
/*      */     public Read_packet_Pointer_byte_int(Pointer p)
/*      */     {
/*  348 */       super(); } 
/*  349 */     protected Read_packet_Pointer_byte_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  347 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Write_packet_Pointer_ByteBuffer_int extends FunctionPointer
/*      */   {
/*      */     public Write_packet_Pointer_ByteBuffer_int(Pointer p)
/*      */     {
/*  340 */       super(); } 
/*  341 */     protected Write_packet_Pointer_ByteBuffer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  339 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Read_packet_Pointer_ByteBuffer_int extends FunctionPointer
/*      */   {
/*      */     public Read_packet_Pointer_ByteBuffer_int(Pointer p)
/*      */     {
/*  333 */       super(); } 
/*  334 */     protected Read_packet_Pointer_ByteBuffer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  332 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Seek_Pointer_long_int extends FunctionPointer
/*      */   {
/*      */     public Seek_Pointer_long_int(Pointer p)
/*      */     {
/*  325 */       super(); } 
/*  326 */     protected Seek_Pointer_long_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native long call(Pointer paramPointer, long paramLong, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  324 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Write_packet_Pointer_BytePointer_int extends FunctionPointer
/*      */   {
/*      */     public Write_packet_Pointer_BytePointer_int(Pointer p)
/*      */     {
/*  318 */       super(); } 
/*  319 */     protected Write_packet_Pointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  317 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Read_packet_Pointer_BytePointer_int extends FunctionPointer
/*      */   {
/*      */     public Read_packet_Pointer_BytePointer_int(Pointer p)
/*      */     {
/*  311 */       super(); } 
/*  312 */     protected Read_packet_Pointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  310 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVIOContext extends Pointer
/*      */   {
/*      */     public AVIOContext()
/*      */     {
/*  131 */       allocate(); } 
/*  132 */     public AVIOContext(int size) { allocateArray(size); } 
/*  133 */     public AVIOContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  137 */     public AVIOContext position(int position) { return (AVIOContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass av_class();
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer buffer();
/*      */ 
/*      */     public native AVIOContext buffer(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int buffer_size();
/*      */ 
/*      */     public native AVIOContext buffer_size(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer buf_ptr();
/*      */ 
/*      */     public native AVIOContext buf_ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer buf_end();
/*      */ 
/*      */     public native AVIOContext buf_end(BytePointer paramBytePointer);
/*      */ 
/*      */     public native Pointer opaque();
/*      */ 
/*      */     public native AVIOContext opaque(Pointer paramPointer);
/*      */ 
/*      */     public native Read_packet_Pointer_BytePointer_int read_packet();
/*      */ 
/*      */     public native AVIOContext read_packet(Read_packet_Pointer_BytePointer_int paramRead_packet_Pointer_BytePointer_int);
/*      */ 
/*      */     public native Write_packet_Pointer_BytePointer_int write_packet();
/*      */ 
/*      */     public native AVIOContext write_packet(Write_packet_Pointer_BytePointer_int paramWrite_packet_Pointer_BytePointer_int);
/*      */ 
/*      */     public native Seek_Pointer_long_int seek();
/*      */ 
/*      */     public native AVIOContext seek(Seek_Pointer_long_int paramSeek_Pointer_long_int);
/*      */ 
/*      */     public native long pos();
/*      */ 
/*      */     public native AVIOContext pos(long paramLong);
/*      */ 
/*      */     public native int must_flush();
/*      */ 
/*      */     public native AVIOContext must_flush(int paramInt);
/*      */ 
/*      */     public native int eof_reached();
/*      */ 
/*      */     public native AVIOContext eof_reached(int paramInt);
/*      */ 
/*      */     public native int write_flag();
/*      */ 
/*      */     public native AVIOContext write_flag(int paramInt);
/*      */ 
/*      */     public native int max_packet_size();
/*      */ 
/*      */     public native AVIOContext max_packet_size(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native long checksum();
/*      */ 
/*      */     public native AVIOContext checksum(long paramLong);
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer checksum_ptr();
/*      */ 
/*      */     public native AVIOContext checksum_ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     public native Update_checksum_long_BytePointer_int update_checksum();
/*      */ 
/*      */     public native AVIOContext update_checksum(Update_checksum_long_BytePointer_int paramUpdate_checksum_long_BytePointer_int);
/*      */ 
/*      */     public native int error();
/*      */ 
/*      */     public native AVIOContext error(int paramInt);
/*      */ 
/*      */     public native Read_pause_Pointer_int read_pause();
/*      */ 
/*      */     public native AVIOContext read_pause(Read_pause_Pointer_int paramRead_pause_Pointer_int);
/*      */ 
/*      */     public native Read_seek_Pointer_int_long_int read_seek();
/*      */ 
/*      */     public native AVIOContext read_seek(Read_seek_Pointer_int_long_int paramRead_seek_Pointer_int_long_int);
/*      */ 
/*      */     public native int seekable();
/*      */ 
/*      */     public native AVIOContext seekable(int paramInt);
/*      */ 
/*      */     public native long maxsize();
/*      */ 
/*      */     public native AVIOContext maxsize(long paramLong);
/*      */ 
/*      */     public native int direct();
/*      */ 
/*      */     public native AVIOContext direct(int paramInt);
/*      */ 
/*      */     public native long bytes_read();
/*      */ 
/*      */     public native AVIOContext bytes_read(long paramLong);
/*      */ 
/*      */     public native int seek_count();
/*      */ 
/*      */     public native AVIOContext seek_count(int paramInt);
/*      */ 
/*      */     public native int writeout_count();
/*      */ 
/*      */     public native AVIOContext writeout_count(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  130 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Read_seek_Pointer_int_long_int extends FunctionPointer
/*      */     {
/*      */       public Read_seek_Pointer_int_long_int(Pointer p)
/*      */       {
/*  230 */         super(); } 
/*  231 */       protected Read_seek_Pointer_int_long_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native long call(Pointer paramPointer, int paramInt1, long paramLong, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/*  229 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_pause_Pointer_int extends FunctionPointer
/*      */     {
/*      */       public Read_pause_Pointer_int(Pointer p)
/*      */       {
/*  217 */         super(); } 
/*  218 */       protected Read_pause_Pointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(Pointer paramPointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  216 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Update_checksum_long_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Update_checksum_long_BytePointer_int(Pointer p)
/*      */       {
/*  204 */         super(); } 
/*  205 */       protected Update_checksum_long_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Cast({"unsigned long"})
/*      */       public native long call(@Cast({"unsigned long"}) long paramLong, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  203 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Seek_Pointer_long_int extends FunctionPointer
/*      */     {
/*      */       public Seek_Pointer_long_int(Pointer p)
/*      */       {
/*  185 */         super(); } 
/*  186 */       protected Seek_Pointer_long_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native long call(Pointer paramPointer, long paramLong, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  184 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Write_packet_Pointer_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Write_packet_Pointer_BytePointer_int(Pointer p)
/*      */       {
/*  177 */         super(); } 
/*  178 */       protected Write_packet_Pointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  176 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Read_packet_Pointer_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Read_packet_Pointer_BytePointer_int(Pointer p)
/*      */       {
/*  169 */         super(); } 
/*  170 */       protected Read_packet_Pointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  168 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVIOInterruptCB extends Pointer
/*      */   {
/*      */     public AVIOInterruptCB()
/*      */     {
/*   97 */       allocate(); } 
/*   98 */     public AVIOInterruptCB(int size) { allocateArray(size); } 
/*   99 */     public AVIOInterruptCB(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  103 */     public AVIOInterruptCB position(int position) { return (AVIOInterruptCB)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native Callback_Pointer callback();
/*      */ 
/*      */     public native AVIOInterruptCB callback(Callback_Pointer paramCallback_Pointer);
/*      */ 
/*      */     public native Pointer opaque();
/*      */ 
/*      */     public native AVIOInterruptCB opaque(Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/*   96 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Callback_Pointer extends FunctionPointer
/*      */     {
/*      */       public Callback_Pointer(Pointer p)
/*      */       {
/*  108 */         super(); } 
/*  109 */       protected Callback_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(Pointer paramPointer);
/*      */ 
/*      */       static
/*      */       {
/*  107 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.avformat
 * JD-Core Version:    0.6.2
 */