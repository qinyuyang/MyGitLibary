/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.PointerPointer;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Opaque;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ 
/*     */ @Properties(inherit={avutil.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libswresample/swresample.h>"}, link={"swresample@.0"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"swresample-0"})})
/*     */ public class swresample
/*     */ {
/*     */   public static final int SWR_CH_MAX = 32;
/*     */   public static final int SWR_FLAG_RESAMPLE = 1;
/*     */   public static final int SWR_DITHER_NONE = 0;
/*     */   public static final int SWR_DITHER_RECTANGULAR = 1;
/*     */   public static final int SWR_DITHER_TRIANGULAR = 2;
/*     */   public static final int SWR_DITHER_TRIANGULAR_HIGHPASS = 3;
/*     */   public static final int SWR_DITHER_NS = 64;
/*     */   public static final int SWR_DITHER_NS_LIPSHITZ = 65;
/*     */   public static final int SWR_DITHER_NS_F_WEIGHTED = 66;
/*     */   public static final int SWR_DITHER_NS_MODIFIED_E_WEIGHTED = 67;
/*     */   public static final int SWR_DITHER_NS_IMPROVED_E_WEIGHTED = 68;
/*     */   public static final int SWR_DITHER_NS_SHIBATA = 69;
/*     */   public static final int SWR_DITHER_NS_LOW_SHIBATA = 70;
/*     */   public static final int SWR_DITHER_NS_HIGH_SHIBATA = 71;
/*     */   public static final int SWR_DITHER_NB = 72;
/*     */   public static final int SWR_ENGINE_SWR = 0;
/*     */   public static final int SWR_ENGINE_SOXR = 1;
/*     */   public static final int SWR_ENGINE_NB = 2;
/*     */   public static final int SWR_FILTER_TYPE_CUBIC = 0;
/*     */   public static final int SWR_FILTER_TYPE_BLACKMAN_NUTTALL = 1;
/*     */   public static final int SWR_FILTER_TYPE_KAISER = 2;
/*     */ 
/*     */   @Const
/*     */   public static native avutil.AVClass swr_get_class();
/*     */ 
/*     */   public static native SwrContext swr_alloc();
/*     */ 
/*     */   public static native int swr_init(SwrContext paramSwrContext);
/*     */ 
/*     */   public static native SwrContext swr_alloc_set_opts(SwrContext paramSwrContext, long paramLong1, @Cast({"AVSampleFormat"}) int paramInt1, int paramInt2, long paramLong2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4, int paramInt5, Pointer paramPointer);
/*     */ 
/*     */   public static native void swr_free(@Cast({"SwrContext**"}) PointerPointer paramPointerPointer);
/*     */ 
/*     */   public static native void swr_free(@ByPtrPtr SwrContext paramSwrContext);
/*     */ 
/*     */   public static native int swr_convert(SwrContext paramSwrContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, int paramInt1, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer2, int paramInt2);
/*     */ 
/*     */   public static native int swr_convert(SwrContext paramSwrContext, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, int paramInt1, @Cast({"const uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer2, int paramInt2);
/*     */ 
/*     */   public static native int swr_convert(SwrContext paramSwrContext, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, int paramInt1, @Cast({"const uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer2, int paramInt2);
/*     */ 
/*     */   public static native int swr_convert(SwrContext paramSwrContext, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int paramInt1, @Cast({"const uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte2, int paramInt2);
/*     */ 
/*     */   public static native long swr_next_pts(SwrContext paramSwrContext, long paramLong);
/*     */ 
/*     */   public static native int swr_set_compensation(SwrContext paramSwrContext, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native int swr_set_channel_mapping(SwrContext paramSwrContext, @Const IntPointer paramIntPointer);
/*     */ 
/*     */   public static native int swr_set_channel_mapping(SwrContext paramSwrContext, @Const IntBuffer paramIntBuffer);
/*     */ 
/*     */   public static native int swr_set_channel_mapping(SwrContext paramSwrContext, @Const int[] paramArrayOfInt);
/*     */ 
/*     */   public static native int swr_set_matrix(SwrContext paramSwrContext, @Const DoublePointer paramDoublePointer, int paramInt);
/*     */ 
/*     */   public static native int swr_set_matrix(SwrContext paramSwrContext, @Const DoubleBuffer paramDoubleBuffer, int paramInt);
/*     */ 
/*     */   public static native int swr_set_matrix(SwrContext paramSwrContext, @Const double[] paramArrayOfDouble, int paramInt);
/*     */ 
/*     */   public static native int swr_drop_output(SwrContext paramSwrContext, int paramInt);
/*     */ 
/*     */   public static native int swr_inject_silence(SwrContext paramSwrContext, int paramInt);
/*     */ 
/*     */   public static native long swr_get_delay(SwrContext paramSwrContext, long paramLong);
/*     */ 
/*     */   @Cast({"unsigned"})
/*     */   public static native int swresample_version();
/*     */ 
/*     */   @Cast({"const char*"})
/*     */   public static native BytePointer swresample_configuration();
/*     */ 
/*     */   @Cast({"const char*"})
/*     */   public static native BytePointer swresample_license();
/*     */ 
/*     */   static
/*     */   {
/*  39 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class SwrContext extends Pointer
/*     */   {
/*     */     public SwrContext()
/*     */     {
/*     */     }
/*     */ 
/*     */     public SwrContext(Pointer p)
/*     */     {
/* 194 */       super();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.swresample
 * JD-Core Version:    0.6.2
 */