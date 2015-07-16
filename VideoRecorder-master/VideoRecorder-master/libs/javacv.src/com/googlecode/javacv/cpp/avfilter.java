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
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ 
/*      */ @Properties(inherit={avformat.class, postproc.class, swresample.class, swscale.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavfilter/avfilter.h>", "<libavfilter/buffersink.h>", "<libavfilter/buffersrc.h>"}, link={"avfilter@.3"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"avfilter-3"})})
/*      */ public class avfilter
/*      */ {
/*      */   public static final int AV_PERM_READ = 1;
/*      */   public static final int AV_PERM_WRITE = 2;
/*      */   public static final int AV_PERM_PRESERVE = 4;
/*      */   public static final int AV_PERM_REUSE = 8;
/*      */   public static final int AV_PERM_REUSE2 = 16;
/*      */   public static final int AV_PERM_NEG_LINESIZES = 32;
/*      */   public static final int AV_PERM_ALIGN = 64;
/*      */   public static final int AVFILTER_ALIGN = 16;
/*      */   public static final int AVFILTER_FLAG_DYNAMIC_INPUTS = 1;
/*      */   public static final int AVFILTER_FLAG_DYNAMIC_OUTPUTS = 2;
/*      */   public static final int AVFILTER_FLAG_SLICE_THREADS = 4;
/*      */   public static final int AVFILTER_FLAG_SUPPORT_TIMELINE_GENERIC = 65536;
/*      */   public static final int AVFILTER_FLAG_SUPPORT_TIMELINE_INTERNAL = 131072;
/*      */   public static final int AVFILTER_FLAG_SUPPORT_TIMELINE = 196608;
/*      */   public static final int AVFILTER_THREAD_SLICE = 1;
/*      */   public static final int AVFILTER_CMD_FLAG_ONE = 1;
/*      */   public static final int AVFILTER_CMD_FLAG_FAST = 2;
/*      */   public static final int AVFILTER_AUTO_CONVERT_ALL = 0;
/*      */   public static final int AVFILTER_AUTO_CONVERT_NONE = -1;
/*      */   public static final int AV_BUFFERSINK_FLAG_PEEK = 1;
/*      */   public static final int AV_BUFFERSINK_FLAG_NO_REQUEST = 2;
/*      */   public static final int AV_BUFFERSRC_FLAG_NO_CHECK_FORMAT = 1;
/*      */   public static final int AV_BUFFERSRC_FLAG_NO_COPY = 2;
/*      */   public static final int AV_BUFFERSRC_FLAG_PUSH = 4;
/*      */   public static final int AV_BUFFERSRC_FLAG_KEEP_REF = 8;
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int avfilter_version();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avfilter_configuration();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avfilter_license();
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avfilter_copy_buffer_ref_props(AVFilterBufferRef paramAVFilterBufferRef1, AVFilterBufferRef paramAVFilterBufferRef2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_ref_buffer(AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avfilter_unref_buffer(AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avfilter_unref_bufferp(@Cast({"AVFilterBufferRef**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avfilter_unref_bufferp(@ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_ref_get_channels(AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   public static native int avfilter_pad_count(@Const AVFilterPad paramAVFilterPad);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avfilter_pad_get_name(@Const AVFilterPad paramAVFilterPad, int paramInt);
/*      */ 
/*      */   @Cast({"AVMediaType"})
/*      */   public static native int avfilter_pad_get_type(@Const AVFilterPad paramAVFilterPad, int paramInt);
/*      */ 
/*      */   public static native int avfilter_link(AVFilterContext paramAVFilterContext1, @Cast({"unsigned"}) int paramInt1, AVFilterContext paramAVFilterContext2, @Cast({"unsigned"}) int paramInt2);
/*      */ 
/*      */   public static native void avfilter_link_free(@Cast({"AVFilterLink**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void avfilter_link_free(@ByPtrPtr AVFilterLink paramAVFilterLink);
/*      */ 
/*      */   public static native int avfilter_link_get_channels(AVFilterLink paramAVFilterLink);
/*      */ 
/*      */   public static native void avfilter_link_set_closed(AVFilterLink paramAVFilterLink, int paramInt);
/*      */ 
/*      */   public static native int avfilter_config_links(AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(@Cast({"uint8_t*const*"}) PointerPointer paramPointerPointer, @Const IntPointer paramIntPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVPixelFormat"}) int paramInt4);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(@Cast({"uint8_t*const*"}) @ByPtrPtr BytePointer paramBytePointer, @Const IntPointer paramIntPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVPixelFormat"}) int paramInt4);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(@Cast({"uint8_t*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer, @Const IntBuffer paramIntBuffer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVPixelFormat"}) int paramInt4);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(@Cast({"uint8_t*const*"}) @ByPtrPtr byte[] paramArrayOfByte, @Const int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVPixelFormat"}) int paramInt4);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, int paramInt5, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, int paramInt5, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, int paramInt5, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4, int paramInt5, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"char*"}) BytePointer paramBytePointer3, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, String paramString1, String paramString2, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, String paramString1, String paramString2, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_process_command(AVFilterContext paramAVFilterContext, String paramString1, String paramString2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void avfilter_register_all();
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avfilter_uninit();
/*      */ 
/*      */   public static native int avfilter_register(AVFilter paramAVFilter);
/*      */ 
/*      */   public static native AVFilter avfilter_get_by_name(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVFilter avfilter_get_by_name(String paramString);
/*      */ 
/*      */   @Const
/*      */   public static native AVFilter avfilter_next(@Const AVFilter paramAVFilter);
/*      */ 
/*      */   @Cast({"AVFilter**"})
/*      */   @Deprecated
/*      */   public static native PointerPointer av_filter_next(@Cast({"AVFilter**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @Deprecated
/*      */   @ByPtrPtr
/*      */   public static native AVFilter av_filter_next(@ByPtrPtr AVFilter paramAVFilter);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_open(@Cast({"AVFilterContext**"}) PointerPointer paramPointerPointer, AVFilter paramAVFilter, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_open(@ByPtrPtr AVFilterContext paramAVFilterContext, AVFilter paramAVFilter, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_open(@ByPtrPtr AVFilterContext paramAVFilterContext, AVFilter paramAVFilter, String paramString);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_init_filter(AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer, Pointer paramPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_init_filter(AVFilterContext paramAVFilterContext, String paramString, Pointer paramPointer);
/*      */ 
/*      */   public static native int avfilter_init_str(AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int avfilter_init_str(AVFilterContext paramAVFilterContext, String paramString);
/*      */ 
/*      */   public static native int avfilter_init_dict(AVFilterContext paramAVFilterContext, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avfilter_init_dict(AVFilterContext paramAVFilterContext, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native void avfilter_free(AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   public static native int avfilter_insert_filter(AVFilterLink paramAVFilterLink, AVFilterContext paramAVFilterContext, @Cast({"unsigned"}) int paramInt1, @Cast({"unsigned"}) int paramInt2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_copy_frame_props(AVFilterBufferRef paramAVFilterBufferRef, @Const avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_copy_buf_props(avutil.AVFrame paramAVFrame, @Const AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   @Const
/*      */   public static native avutil.AVClass avfilter_get_class();
/*      */ 
/*      */   public static native AVFilterGraph avfilter_graph_alloc();
/*      */ 
/*      */   public static native AVFilterContext avfilter_graph_alloc_filter(AVFilterGraph paramAVFilterGraph, @Const AVFilter paramAVFilter, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVFilterContext avfilter_graph_alloc_filter(AVFilterGraph paramAVFilterGraph, @Const AVFilter paramAVFilter, String paramString);
/*      */ 
/*      */   public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph paramAVFilterGraph, @Cast({"char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph paramAVFilterGraph, @Cast({"char*"}) ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph paramAVFilterGraph, @Cast({"char*"}) byte[] paramArrayOfByte);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_graph_add_filter(AVFilterGraph paramAVFilterGraph, AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   public static native int avfilter_graph_create_filter(@Cast({"AVFilterContext**"}) PointerPointer paramPointerPointer, @Const AVFilter paramAVFilter, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, Pointer paramPointer, AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */   public static native int avfilter_graph_create_filter(@ByPtrPtr AVFilterContext paramAVFilterContext, @Const AVFilter paramAVFilter, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, Pointer paramPointer, AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */   public static native int avfilter_graph_create_filter(@ByPtrPtr AVFilterContext paramAVFilterContext, @Const AVFilter paramAVFilter, String paramString1, String paramString2, Pointer paramPointer, AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */   public static native void avfilter_graph_set_auto_convert(AVFilterGraph paramAVFilterGraph, @Cast({"unsigned"}) int paramInt);
/*      */ 
/*      */   public static native int avfilter_graph_config(AVFilterGraph paramAVFilterGraph, Pointer paramPointer);
/*      */ 
/*      */   public static native void avfilter_graph_free(@Cast({"AVFilterGraph**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void avfilter_graph_free(@ByPtrPtr AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */   public static native AVFilterInOut avfilter_inout_alloc();
/*      */ 
/*      */   public static native void avfilter_inout_free(@Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void avfilter_inout_free(@ByPtrPtr AVFilterInOut paramAVFilterInOut);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_graph_parse(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer1, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer2, Pointer paramPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_graph_parse(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2, Pointer paramPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avfilter_graph_parse(AVFilterGraph paramAVFilterGraph, String paramString, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2, Pointer paramPointer);
/*      */ 
/*      */   public static native int avfilter_graph_parse_ptr(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer1, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer2, Pointer paramPointer);
/*      */ 
/*      */   public static native int avfilter_graph_parse_ptr(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2, Pointer paramPointer);
/*      */ 
/*      */   public static native int avfilter_graph_parse_ptr(AVFilterGraph paramAVFilterGraph, String paramString, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2, Pointer paramPointer);
/*      */ 
/*      */   public static native int avfilter_graph_parse2(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer1, @Cast({"AVFilterInOut**"}) PointerPointer paramPointerPointer2);
/*      */ 
/*      */   public static native int avfilter_graph_parse2(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2);
/*      */ 
/*      */   public static native int avfilter_graph_parse2(AVFilterGraph paramAVFilterGraph, String paramString, @ByPtrPtr AVFilterInOut paramAVFilterInOut1, @ByPtrPtr AVFilterInOut paramAVFilterInOut2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"char*"}) BytePointer paramBytePointer4, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_send_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avfilter_graph_queue_command(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, int paramInt, double paramDouble);
/*      */ 
/*      */   public static native int avfilter_graph_queue_command(AVFilterGraph paramAVFilterGraph, String paramString1, String paramString2, String paramString3, int paramInt, double paramDouble);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native BytePointer avfilter_graph_dump(AVFilterGraph paramAVFilterGraph, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native ByteBuffer avfilter_graph_dump(AVFilterGraph paramAVFilterGraph, String paramString);
/*      */ 
/*      */   public static native int avfilter_graph_request_oldest(AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_get_buffer_ref(AVFilterContext paramAVFilterContext, @Cast({"AVFilterBufferRef**"}) PointerPointer paramPointerPointer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_get_buffer_ref(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_poll_frame(AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_read(AVFilterContext paramAVFilterContext, @Cast({"AVFilterBufferRef**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_read(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_read_samples(AVFilterContext paramAVFilterContext, @Cast({"AVFilterBufferRef**"}) PointerPointer paramPointerPointer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersink_read_samples(AVFilterContext paramAVFilterContext, @ByPtrPtr AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
/*      */ 
/*      */   public static native int av_buffersink_get_frame_flags(AVFilterContext paramAVFilterContext, avutil.AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native AVBufferSinkParams av_buffersink_params_alloc();
/*      */ 
/*      */   public static native AVABufferSinkParams av_abuffersink_params_alloc();
/*      */ 
/*      */   public static native void av_buffersink_set_frame_size(AVFilterContext paramAVFilterContext, @Cast({"unsigned"}) int paramInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native avutil.AVRational av_buffersink_get_frame_rate(AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   public static native int av_buffersink_get_frame(AVFilterContext paramAVFilterContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_buffersink_get_samples(AVFilterContext paramAVFilterContext, avutil.AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native int av_buffersrc_add_ref(AVFilterContext paramAVFilterContext, AVFilterBufferRef paramAVFilterBufferRef, int paramInt);
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int av_buffersrc_get_nb_failed_requests(AVFilterContext paramAVFilterContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_buffersrc_buffer(AVFilterContext paramAVFilterContext, AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */   public static native int av_buffersrc_write_frame(AVFilterContext paramAVFilterContext, @Const avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_buffersrc_add_frame(AVFilterContext paramAVFilterContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_buffersrc_add_frame_flags(AVFilterContext paramAVFilterContext, avutil.AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   static
/*      */   {
/*   44 */     Loader.load();
/*      */   }
/*      */ 
/*      */   public static class AVABufferSinkParams extends Pointer
/*      */   {
/*      */     public AVABufferSinkParams()
/*      */     {
/* 2071 */       allocate(); } 
/* 2072 */     public AVABufferSinkParams(int size) { allocateArray(size); } 
/* 2073 */     public AVABufferSinkParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2077 */     public AVABufferSinkParams position(int position) { return (AVABufferSinkParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVSampleFormat*"})
/*      */     public native IntPointer sample_fmts();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native LongPointer channel_layouts();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native IntPointer channel_counts();
/*      */ 
/*      */     public native int all_channel_counts();
/*      */ 
/*      */     public native AVABufferSinkParams all_channel_counts(int paramInt);
/*      */ 
/*      */     public native IntPointer sample_rates();
/*      */ 
/*      */     public native AVABufferSinkParams sample_rates(IntPointer paramIntPointer);
/*      */ 
/*      */     static
/*      */     {
/* 2070 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVBufferSinkParams extends Pointer
/*      */   {
/*      */     public AVBufferSinkParams()
/*      */     {
/* 2046 */       allocate(); } 
/* 2047 */     public AVBufferSinkParams(int size) { allocateArray(size); } 
/* 2048 */     public AVBufferSinkParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2052 */     public AVBufferSinkParams position(int position) { return (AVBufferSinkParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVPixelFormat*"})
/*      */     public native IntPointer pixel_fmts();
/*      */ 
/*      */     static
/*      */     {
/* 2045 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterInOut extends Pointer
/*      */   {
/*      */     public AVFilterInOut()
/*      */     {
/* 1730 */       allocate(); } 
/* 1731 */     public AVFilterInOut(int size) { allocateArray(size); } 
/* 1732 */     public AVFilterInOut(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1736 */     public AVFilterInOut position(int position) { return (AVFilterInOut)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     public native AVFilterInOut name(BytePointer paramBytePointer);
/*      */ 
/*      */     public native avfilter.AVFilterContext filter_ctx();
/*      */ 
/*      */     public native AVFilterInOut filter_ctx(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */     public native int pad_idx();
/*      */ 
/*      */     public native AVFilterInOut pad_idx(int paramInt);
/*      */ 
/*      */     public native AVFilterInOut next();
/*      */ 
/*      */     public native AVFilterInOut next(AVFilterInOut paramAVFilterInOut);
/*      */ 
/*      */     static
/*      */     {
/* 1729 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterGraph extends Pointer
/*      */   {
/*      */     public AVFilterGraph()
/*      */     {
/* 1524 */       allocate(); } 
/* 1525 */     public AVFilterGraph(int size) { allocateArray(size); } 
/* 1526 */     public AVFilterGraph(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1530 */     public AVFilterGraph position(int position) { return (AVFilterGraph)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass av_class();
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     @Deprecated
/*      */     public native int filter_count_unused();
/*      */ 
/*      */     public native AVFilterGraph filter_count_unused(int paramInt);
/*      */ 
/*      */     public native avfilter.AVFilterContext filters(int paramInt);
/*      */ 
/*      */     public native AVFilterGraph filters(int paramInt, avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVFilterContext**"})
/*      */     public native PointerPointer filters();
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer scale_sws_opts();
/*      */ 
/*      */     public native AVFilterGraph scale_sws_opts(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer resample_lavr_opts();
/*      */ 
/*      */     public native AVFilterGraph resample_lavr_opts(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int nb_filters();
/*      */ 
/*      */     public native AVFilterGraph nb_filters(int paramInt);
/*      */ 
/*      */     public native int thread_type();
/*      */ 
/*      */     public native AVFilterGraph thread_type(int paramInt);
/*      */ 
/*      */     public native int nb_threads();
/*      */ 
/*      */     public native AVFilterGraph nb_threads(int paramInt);
/*      */ 
/*      */     public native avfilter.AVFilterGraphInternal internal();
/*      */ 
/*      */     public native AVFilterGraph internal(avfilter.AVFilterGraphInternal paramAVFilterGraphInternal);
/*      */ 
/*      */     public native Pointer opaque();
/*      */ 
/*      */     public native AVFilterGraph opaque(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"avfilter_execute_func*"})
/*      */     public native IntPointer execute();
/*      */ 
/*      */     public native AVFilterGraph execute(IntPointer paramIntPointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer aresample_swr_opts();
/*      */ 
/*      */     public native AVFilterGraph aresample_swr_opts(BytePointer paramBytePointer);
/*      */ 
/*      */     public native avfilter.AVFilterLink sink_links(int paramInt);
/*      */ 
/*      */     public native AVFilterGraph sink_links(int paramInt, avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVFilterLink**"})
/*      */     public native PointerPointer sink_links();
/*      */ 
/*      */     public native int sink_links_count();
/*      */ 
/*      */     public native AVFilterGraph sink_links_count(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int disable_auto_convert();
/*      */ 
/*      */     public native AVFilterGraph disable_auto_convert(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1523 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVFilterGraphInternal extends Pointer
/*      */   {
/*      */     public AVFilterGraphInternal()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVFilterGraphInternal(Pointer p)
/*      */     {
/* 1493 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterLink extends Pointer
/*      */   {
/*      */     public static final int AVLINK_UNINIT = 0;
/*      */     public static final int AVLINK_STARTINIT = 1;
/*      */     public static final int AVLINK_INIT = 2;
/*      */ 
/*      */     public AVFilterLink()
/*      */     {
/*  982 */       allocate(); } 
/*  983 */     public AVFilterLink(int size) { allocateArray(size); } 
/*  984 */     public AVFilterLink(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  988 */     public AVFilterLink position(int position) { return (AVFilterLink)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native avfilter.AVFilterContext src();
/*      */ 
/*      */     public native AVFilterLink src(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */     public native avfilter.AVFilterPad srcpad();
/*      */ 
/*      */     public native AVFilterLink srcpad(avfilter.AVFilterPad paramAVFilterPad);
/*      */ 
/*      */     public native avfilter.AVFilterContext dst();
/*      */ 
/*      */     public native AVFilterLink dst(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */     public native avfilter.AVFilterPad dstpad();
/*      */ 
/*      */     public native AVFilterLink dstpad(avfilter.AVFilterPad paramAVFilterPad);
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVFilterLink type(int paramInt);
/*      */ 
/*      */     public native int w();
/*      */ 
/*      */     public native AVFilterLink w(int paramInt);
/*      */ 
/*      */     public native int h();
/*      */ 
/*      */     public native AVFilterLink h(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational sample_aspect_ratio();
/*      */ 
/*      */     public native AVFilterLink sample_aspect_ratio(avutil.AVRational paramAVRational);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long channel_layout();
/*      */ 
/*      */     public native AVFilterLink channel_layout(long paramLong);
/*      */ 
/*      */     public native int sample_rate();
/*      */ 
/*      */     public native AVFilterLink sample_rate(int paramInt);
/*      */ 
/*      */     public native int format();
/*      */ 
/*      */     public native AVFilterLink format(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational time_base();
/*      */ 
/*      */     public native AVFilterLink time_base(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native avfilter.AVFilterFormats in_formats();
/*      */ 
/*      */     public native AVFilterLink in_formats(avfilter.AVFilterFormats paramAVFilterFormats);
/*      */ 
/*      */     public native avfilter.AVFilterFormats out_formats();
/*      */ 
/*      */     public native AVFilterLink out_formats(avfilter.AVFilterFormats paramAVFilterFormats);
/*      */ 
/*      */     public native avfilter.AVFilterFormats in_samplerates();
/*      */ 
/*      */     public native AVFilterLink in_samplerates(avfilter.AVFilterFormats paramAVFilterFormats);
/*      */ 
/*      */     public native avfilter.AVFilterFormats out_samplerates();
/*      */ 
/*      */     public native AVFilterLink out_samplerates(avfilter.AVFilterFormats paramAVFilterFormats);
/*      */ 
/*      */     @Cast({"AVFilterChannelLayouts*"})
/*      */     public native Pointer in_channel_layouts();
/*      */ 
/*      */     public native AVFilterLink in_channel_layouts(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"AVFilterChannelLayouts*"})
/*      */     public native Pointer out_channel_layouts();
/*      */ 
/*      */     public native AVFilterLink out_channel_layouts(Pointer paramPointer);
/*      */ 
/*      */     public native int request_samples();
/*      */ 
/*      */     public native AVFilterLink request_samples(int paramInt);
/*      */ 
/*      */     @Cast({"AVFilterPool*"})
/*      */     public native Pointer pool();
/*      */ 
/*      */     public native AVFilterLink pool(Pointer paramPointer);
/*      */ 
/*      */     public native avfilter.AVFilterGraph graph();
/*      */ 
/*      */     public native AVFilterLink graph(avfilter.AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */     public native long current_pts();
/*      */ 
/*      */     public native AVFilterLink current_pts(long paramLong);
/*      */ 
/*      */     public native int age_index();
/*      */ 
/*      */     public native AVFilterLink age_index(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational frame_rate();
/*      */ 
/*      */     public native AVFilterLink frame_rate(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native avutil.AVFrame partial_buf();
/*      */ 
/*      */     public native AVFilterLink partial_buf(avutil.AVFrame paramAVFrame);
/*      */ 
/*      */     public native int partial_buf_size();
/*      */ 
/*      */     public native AVFilterLink partial_buf_size(int paramInt);
/*      */ 
/*      */     public native int min_samples();
/*      */ 
/*      */     public native AVFilterLink min_samples(int paramInt);
/*      */ 
/*      */     public native int max_samples();
/*      */ 
/*      */     public native AVFilterLink max_samples(int paramInt);
/*      */ 
/*      */     public native avfilter.AVFilterBufferRef cur_buf_copy();
/*      */ 
/*      */     public native AVFilterLink cur_buf_copy(avfilter.AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */     public native int closed();
/*      */ 
/*      */     public native AVFilterLink closed(int paramInt);
/*      */ 
/*      */     public native int channels();
/*      */ 
/*      */     public native AVFilterLink channels(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int frame_requested();
/*      */ 
/*      */     public native AVFilterLink frame_requested(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int flags();
/*      */ 
/*      */     public native AVFilterLink flags(int paramInt);
/*      */ 
/*      */     public native long frame_count();
/*      */ 
/*      */     public native AVFilterLink frame_count(long paramLong);
/*      */ 
/*      */     static
/*      */     {
/*  981 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterContext extends Pointer
/*      */   {
/*      */     public AVFilterContext()
/*      */     {
/*  890 */       allocate(); } 
/*  891 */     public AVFilterContext(int size) { allocateArray(size); } 
/*  892 */     public AVFilterContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  896 */     public AVFilterContext position(int position) { return (AVFilterContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass av_class();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avfilter.AVFilter filter();
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     public native AVFilterContext name(BytePointer paramBytePointer);
/*      */ 
/*      */     public native avfilter.AVFilterPad input_pads();
/*      */ 
/*      */     public native AVFilterContext input_pads(avfilter.AVFilterPad paramAVFilterPad);
/*      */ 
/*      */     public native avfilter.AVFilterLink inputs(int paramInt);
/*      */ 
/*      */     public native AVFilterContext inputs(int paramInt, avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVFilterLink**"})
/*      */     public native PointerPointer inputs();
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     @Deprecated
/*      */     public native int input_count();
/*      */ 
/*      */     public native AVFilterContext input_count(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int nb_inputs();
/*      */ 
/*      */     public native AVFilterContext nb_inputs(int paramInt);
/*      */ 
/*      */     public native avfilter.AVFilterPad output_pads();
/*      */ 
/*      */     public native AVFilterContext output_pads(avfilter.AVFilterPad paramAVFilterPad);
/*      */ 
/*      */     public native avfilter.AVFilterLink outputs(int paramInt);
/*      */ 
/*      */     public native AVFilterContext outputs(int paramInt, avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVFilterLink**"})
/*      */     public native PointerPointer outputs();
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     @Deprecated
/*      */     public native int output_count();
/*      */ 
/*      */     public native AVFilterContext output_count(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int nb_outputs();
/*      */ 
/*      */     public native AVFilterContext nb_outputs(int paramInt);
/*      */ 
/*      */     public native Pointer priv();
/*      */ 
/*      */     public native AVFilterContext priv(Pointer paramPointer);
/*      */ 
/*      */     public native avfilter.AVFilterGraph graph();
/*      */ 
/*      */     public native AVFilterContext graph(avfilter.AVFilterGraph paramAVFilterGraph);
/*      */ 
/*      */     public native int thread_type();
/*      */ 
/*      */     public native AVFilterContext thread_type(int paramInt);
/*      */ 
/*      */     public native avfilter.AVFilterInternal internal();
/*      */ 
/*      */     public native AVFilterContext internal(avfilter.AVFilterInternal paramAVFilterInternal);
/*      */ 
/*      */     @Cast({"AVFilterCommand*"})
/*      */     public native Pointer command_queue();
/*      */ 
/*      */     public native AVFilterContext command_queue(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer enable_str();
/*      */ 
/*      */     public native AVFilterContext enable_str(BytePointer paramBytePointer);
/*      */ 
/*      */     public native Pointer enable();
/*      */ 
/*      */     public native AVFilterContext enable(Pointer paramPointer);
/*      */ 
/*      */     public native DoublePointer var_values();
/*      */ 
/*      */     public native AVFilterContext var_values(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native int is_disabled();
/*      */ 
/*      */     public native AVFilterContext is_disabled(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  889 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVFilterInternal extends Pointer
/*      */   {
/*      */     public AVFilterInternal()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVFilterInternal(Pointer p)
/*      */     {
/*  884 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilter extends Pointer
/*      */   {
/*      */     public AVFilter()
/*      */     {
/*  671 */       allocate(); } 
/*  672 */     public AVFilter(int size) { allocateArray(size); } 
/*  673 */     public AVFilter(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  677 */     public AVFilter position(int position) { return (AVFilter)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer description();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avfilter.AVFilterPad inputs();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avfilter.AVFilterPad outputs();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass priv_class();
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVFilter flags(int paramInt);
/*      */ 
/*      */     public native Init_AVFilterContext init();
/*      */ 
/*      */     public native AVFilter init(Init_AVFilterContext paramInit_AVFilterContext);
/*      */ 
/*      */     public native Init_dict_AVFilterContext_PointerPointer init_dict();
/*      */ 
/*      */     public native AVFilter init_dict(Init_dict_AVFilterContext_PointerPointer paramInit_dict_AVFilterContext_PointerPointer);
/*      */ 
/*      */     public native Uninit_AVFilterContext uninit();
/*      */ 
/*      */     public native AVFilter uninit(Uninit_AVFilterContext paramUninit_AVFilterContext);
/*      */ 
/*      */     public native Query_formats_AVFilterContext query_formats();
/*      */ 
/*      */     public native AVFilter query_formats(Query_formats_AVFilterContext paramQuery_formats_AVFilterContext);
/*      */ 
/*      */     public native int priv_size();
/*      */ 
/*      */     public native AVFilter priv_size(int paramInt);
/*      */ 
/*      */     public native AVFilter next();
/*      */ 
/*      */     public native AVFilter next(AVFilter paramAVFilter);
/*      */ 
/*      */     public native Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command();
/*      */ 
/*      */     public native AVFilter process_command(Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int paramProcess_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int);
/*      */ 
/*      */     public native Init_opaque_AVFilterContext_Pointer init_opaque();
/*      */ 
/*      */     public native AVFilter init_opaque(Init_opaque_AVFilterContext_Pointer paramInit_opaque_AVFilterContext_Pointer);
/*      */ 
/*      */     static
/*      */     {
/*  670 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Init_opaque_AVFilterContext_Pointer extends FunctionPointer
/*      */     {
/*      */       public Init_opaque_AVFilterContext_Pointer(Pointer p)
/*      */       {
/*  869 */         super(); } 
/*  870 */       protected Init_opaque_AVFilterContext_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterContext paramAVFilterContext, Pointer paramPointer);
/*      */ 
/*      */       static
/*      */       {
/*  868 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int extends FunctionPointer
/*      */     {
/*      */       public Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int(Pointer p)
/*      */       {
/*  855 */         super(); } 
/*  856 */       protected Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterContext paramAVFilterContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"char*"}) BytePointer paramBytePointer3, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/*  854 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Query_formats_AVFilterContext extends FunctionPointer
/*      */     {
/*      */       public Query_formats_AVFilterContext(Pointer p)
/*      */       {
/*  825 */         super(); } 
/*  826 */       protected Query_formats_AVFilterContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */       static
/*      */       {
/*  824 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Uninit_AVFilterContext extends FunctionPointer
/*      */     {
/*      */       public Uninit_AVFilterContext(Pointer p)
/*      */       {
/*  794 */         super(); } 
/*  795 */       protected Uninit_AVFilterContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */       static
/*      */       {
/*  793 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Init_dict_AVFilterContext_PointerPointer extends FunctionPointer
/*      */     {
/*      */       public Init_dict_AVFilterContext_PointerPointer(Pointer p)
/*      */       {
/*  775 */         super(); } 
/*  776 */       protected Init_dict_AVFilterContext_PointerPointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterContext paramAVFilterContext, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */       static
/*      */       {
/*  774 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Init_AVFilterContext extends FunctionPointer
/*      */     {
/*      */       public Init_AVFilterContext(Pointer p)
/*      */       {
/*  755 */         super(); } 
/*  756 */       protected Init_AVFilterContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterContext paramAVFilterContext);
/*      */ 
/*      */       static
/*      */       {
/*  754 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterPad extends Pointer
/*      */   {
/*      */     public AVFilterPad()
/*      */     {
/*  390 */       allocate(); } 
/*  391 */     public AVFilterPad(int size) { allocateArray(size); } 
/*  392 */     public AVFilterPad(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  396 */     public AVFilterPad position(int position) { return (AVFilterPad)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVFilterPad type(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int min_perms();
/*      */ 
/*      */     public native AVFilterPad min_perms(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int rej_perms();
/*      */ 
/*      */     public native AVFilterPad rej_perms(int paramInt);
/*      */ 
/*      */     public native Start_frame_AVFilterLink_AVFilterBufferRef start_frame();
/*      */ 
/*      */     public native AVFilterPad start_frame(Start_frame_AVFilterLink_AVFilterBufferRef paramStart_frame_AVFilterLink_AVFilterBufferRef);
/*      */ 
/*      */     public native Get_video_buffer_AVFilterLink_int_int get_video_buffer();
/*      */ 
/*      */     public native AVFilterPad get_video_buffer(Get_video_buffer_AVFilterLink_int_int paramGet_video_buffer_AVFilterLink_int_int);
/*      */ 
/*      */     public native Get_audio_buffer_AVFilterLink_int get_audio_buffer();
/*      */ 
/*      */     public native AVFilterPad get_audio_buffer(Get_audio_buffer_AVFilterLink_int paramGet_audio_buffer_AVFilterLink_int);
/*      */ 
/*      */     public native End_frame_AVFilterLink end_frame();
/*      */ 
/*      */     public native AVFilterPad end_frame(End_frame_AVFilterLink paramEnd_frame_AVFilterLink);
/*      */ 
/*      */     public native Draw_slice_AVFilterLink_int_int_int draw_slice();
/*      */ 
/*      */     public native AVFilterPad draw_slice(Draw_slice_AVFilterLink_int_int_int paramDraw_slice_AVFilterLink_int_int_int);
/*      */ 
/*      */     public native Filter_frame_AVFilterLink_AVFrame filter_frame();
/*      */ 
/*      */     public native AVFilterPad filter_frame(Filter_frame_AVFilterLink_AVFrame paramFilter_frame_AVFilterLink_AVFrame);
/*      */ 
/*      */     public native Poll_frame_AVFilterLink poll_frame();
/*      */ 
/*      */     public native AVFilterPad poll_frame(Poll_frame_AVFilterLink paramPoll_frame_AVFilterLink);
/*      */ 
/*      */     public native Request_frame_AVFilterLink request_frame();
/*      */ 
/*      */     public native AVFilterPad request_frame(Request_frame_AVFilterLink paramRequest_frame_AVFilterLink);
/*      */ 
/*      */     public native Config_props_AVFilterLink config_props();
/*      */ 
/*      */     public native AVFilterPad config_props(Config_props_AVFilterLink paramConfig_props_AVFilterLink);
/*      */ 
/*      */     public native int needs_fifo();
/*      */ 
/*      */     public native AVFilterPad needs_fifo(int paramInt);
/*      */ 
/*      */     public native int needs_writable();
/*      */ 
/*      */     public native AVFilterPad needs_writable(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  389 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Config_props_AVFilterLink extends FunctionPointer
/*      */     {
/*      */       public Config_props_AVFilterLink(Pointer p)
/*      */       {
/*  578 */         super(); } 
/*  579 */       protected Config_props_AVFilterLink() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */       static
/*      */       {
/*  577 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Request_frame_AVFilterLink extends FunctionPointer
/*      */     {
/*      */       public Request_frame_AVFilterLink(Pointer p)
/*      */       {
/*  552 */         super(); } 
/*  553 */       protected Request_frame_AVFilterLink() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */       static
/*      */       {
/*  551 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Poll_frame_AVFilterLink extends FunctionPointer
/*      */     {
/*      */       public Poll_frame_AVFilterLink(Pointer p)
/*      */       {
/*  534 */         super(); } 
/*  535 */       protected Poll_frame_AVFilterLink() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */       static
/*      */       {
/*  533 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Filter_frame_AVFilterLink_AVFrame extends FunctionPointer
/*      */     {
/*      */       public Filter_frame_AVFilterLink_AVFrame(Pointer p)
/*      */       {
/*  516 */         super(); } 
/*  517 */       protected Filter_frame_AVFilterLink_AVFrame() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */       static
/*      */       {
/*  515 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     /** @deprecated */
/*      */     public static class Draw_slice_AVFilterLink_int_int_int extends FunctionPointer
/*      */     {
/*      */       public Draw_slice_AVFilterLink_int_int_int(Pointer p)
/*      */       {
/*  497 */         super(); } 
/*  498 */       protected Draw_slice_AVFilterLink_int_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */       static
/*      */       {
/*  496 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     /** @deprecated */
/*      */     public static class End_frame_AVFilterLink extends FunctionPointer
/*      */     {
/*      */       public End_frame_AVFilterLink(Pointer p)
/*      */       {
/*  485 */         super(); } 
/*  486 */       protected End_frame_AVFilterLink() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink);
/*      */ 
/*      */       static
/*      */       {
/*  484 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Get_audio_buffer_AVFilterLink_int extends FunctionPointer
/*      */     {
/*      */       public Get_audio_buffer_AVFilterLink_int(Pointer p)
/*      */       {
/*  473 */         super(); } 
/*  474 */       protected Get_audio_buffer_AVFilterLink_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native avutil.AVFrame call(avfilter.AVFilterLink paramAVFilterLink, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/*  472 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Get_video_buffer_AVFilterLink_int_int extends FunctionPointer
/*      */     {
/*      */       public Get_video_buffer_AVFilterLink_int_int(Pointer p)
/*      */       {
/*  458 */         super(); } 
/*  459 */       protected Get_video_buffer_AVFilterLink_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native avutil.AVFrame call(avfilter.AVFilterLink paramAVFilterLink, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/*  457 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     /** @deprecated */
/*      */     public static class Start_frame_AVFilterLink_AVFilterBufferRef extends FunctionPointer
/*      */     {
/*      */       public Start_frame_AVFilterLink_AVFilterBufferRef(Pointer p)
/*      */       {
/*  443 */         super(); } 
/*  444 */       protected Start_frame_AVFilterLink_AVFilterBufferRef() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avfilter.AVFilterLink paramAVFilterLink, avfilter.AVFilterBufferRef paramAVFilterBufferRef);
/*      */ 
/*      */       static
/*      */       {
/*  442 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterBufferRef extends Pointer
/*      */   {
/*      */     public AVFilterBufferRef()
/*      */     {
/*  273 */       allocate(); } 
/*  274 */     public AVFilterBufferRef(int size) { allocateArray(size); } 
/*  275 */     public AVFilterBufferRef(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  279 */     public AVFilterBufferRef position(int position) { return (AVFilterBufferRef)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native avfilter.AVFilterBuffer buf();
/*      */ 
/*      */     public native AVFilterBufferRef buf(avfilter.AVFilterBuffer paramAVFilterBuffer);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data(int paramInt);
/*      */ 
/*      */     public native AVFilterBufferRef data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer data();
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer extended_data(int paramInt);
/*      */ 
/*      */     public native AVFilterBufferRef extended_data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer extended_data();
/*      */ 
/*      */     public native int linesize(int paramInt);
/*      */ 
/*      */     public native AVFilterBufferRef linesize(int paramInt1, int paramInt2);
/*      */ 
/*      */     @MemberGetter
/*      */     public native IntPointer linesize();
/*      */ 
/*      */     public native avfilter.AVFilterBufferRefVideoProps video();
/*      */ 
/*      */     public native AVFilterBufferRef video(avfilter.AVFilterBufferRefVideoProps paramAVFilterBufferRefVideoProps);
/*      */ 
/*      */     public native avfilter.AVFilterBufferRefAudioProps audio();
/*      */ 
/*      */     public native AVFilterBufferRef audio(avfilter.AVFilterBufferRefAudioProps paramAVFilterBufferRefAudioProps);
/*      */ 
/*      */     public native long pts();
/*      */ 
/*      */     public native AVFilterBufferRef pts(long paramLong);
/*      */ 
/*      */     public native long pos();
/*      */ 
/*      */     public native AVFilterBufferRef pos(long paramLong);
/*      */ 
/*      */     public native int format();
/*      */ 
/*      */     public native AVFilterBufferRef format(int paramInt);
/*      */ 
/*      */     public native int perms();
/*      */ 
/*      */     public native AVFilterBufferRef perms(int paramInt);
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVFilterBufferRef type(int paramInt);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVFilterBufferRef metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     static
/*      */     {
/*  272 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterBufferRefVideoProps extends Pointer
/*      */   {
/*      */     public AVFilterBufferRefVideoProps()
/*      */     {
/*  232 */       allocate(); } 
/*  233 */     public AVFilterBufferRefVideoProps(int size) { allocateArray(size); } 
/*  234 */     public AVFilterBufferRefVideoProps(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  238 */     public AVFilterBufferRefVideoProps position(int position) { return (AVFilterBufferRefVideoProps)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int w();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps w(int paramInt);
/*      */ 
/*      */     public native int h();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps h(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational sample_aspect_ratio();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps sample_aspect_ratio(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native int interlaced();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps interlaced(int paramInt);
/*      */ 
/*      */     public native int top_field_first();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps top_field_first(int paramInt);
/*      */ 
/*      */     @Cast({"AVPictureType"})
/*      */     public native int pict_type();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps pict_type(int paramInt);
/*      */ 
/*      */     public native int key_frame();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps key_frame(int paramInt);
/*      */ 
/*      */     public native int qp_table_linesize();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps qp_table_linesize(int paramInt);
/*      */ 
/*      */     public native int qp_table_size();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps qp_table_size(int paramInt);
/*      */ 
/*      */     public native BytePointer qp_table();
/*      */ 
/*      */     public native AVFilterBufferRefVideoProps qp_table(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/*  231 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterBufferRefAudioProps extends Pointer
/*      */   {
/*      */     public AVFilterBufferRefAudioProps()
/*      */     {
/*  206 */       allocate(); } 
/*  207 */     public AVFilterBufferRefAudioProps(int size) { allocateArray(size); } 
/*  208 */     public AVFilterBufferRefAudioProps(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  212 */     public AVFilterBufferRefAudioProps position(int position) { return (AVFilterBufferRefAudioProps)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long channel_layout();
/*      */ 
/*      */     public native AVFilterBufferRefAudioProps channel_layout(long paramLong);
/*      */ 
/*      */     public native int nb_samples();
/*      */ 
/*      */     public native AVFilterBufferRefAudioProps nb_samples(int paramInt);
/*      */ 
/*      */     public native int sample_rate();
/*      */ 
/*      */     public native AVFilterBufferRefAudioProps sample_rate(int paramInt);
/*      */ 
/*      */     public native int channels();
/*      */ 
/*      */     public native AVFilterBufferRefAudioProps channels(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  205 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFilterBuffer extends Pointer
/*      */   {
/*      */     public AVFilterBuffer()
/*      */     {
/*  123 */       allocate(); } 
/*  124 */     public AVFilterBuffer(int size) { allocateArray(size); } 
/*  125 */     public AVFilterBuffer(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  129 */     public AVFilterBuffer position(int position) { return (AVFilterBuffer)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data(int paramInt);
/*      */ 
/*      */     public native AVFilterBuffer data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer data();
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer extended_data(int paramInt);
/*      */ 
/*      */     public native AVFilterBuffer extended_data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer extended_data();
/*      */ 
/*      */     public native int linesize(int paramInt);
/*      */ 
/*      */     public native AVFilterBuffer linesize(int paramInt1, int paramInt2);
/*      */ 
/*      */     @MemberGetter
/*      */     public native IntPointer linesize();
/*      */ 
/*      */     public native Pointer priv();
/*      */ 
/*      */     public native AVFilterBuffer priv(Pointer paramPointer);
/*      */ 
/*      */     public native Free_AVFilterBuffer free();
/*      */ 
/*      */     public native AVFilterBuffer free(Free_AVFilterBuffer paramFree_AVFilterBuffer);
/*      */ 
/*      */     public native int format();
/*      */ 
/*      */     public native AVFilterBuffer format(int paramInt);
/*      */ 
/*      */     public native int w();
/*      */ 
/*      */     public native AVFilterBuffer w(int paramInt);
/*      */ 
/*      */     public native int h();
/*      */ 
/*      */     public native AVFilterBuffer h(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int refcount();
/*      */ 
/*      */     public native AVFilterBuffer refcount(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  122 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Free_AVFilterBuffer extends FunctionPointer
/*      */     {
/*      */       public Free_AVFilterBuffer(Pointer p)
/*      */       {
/*  166 */         super(); } 
/*  167 */       protected Free_AVFilterBuffer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avfilter.AVFilterBuffer paramAVFilterBuffer);
/*      */ 
/*      */       static
/*      */       {
/*  165 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVFilterFormats extends Pointer
/*      */   {
/*      */     public AVFilterFormats()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVFilterFormats(Pointer p)
/*      */     {
/*  112 */       super();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.avfilter
 * JD-Core Version:    0.6.2
 */