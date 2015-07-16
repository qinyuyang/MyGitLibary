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
/*     */ @Properties(inherit={avutil.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libswscale/swscale.h>"}, link={"swscale@.2"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"swscale-2"})})
/*     */ public class swscale
/*     */ {
/*     */   public static final int SWS_FAST_BILINEAR = 1;
/*     */   public static final int SWS_BILINEAR = 2;
/*     */   public static final int SWS_BICUBIC = 4;
/*     */   public static final int SWS_X = 8;
/*     */   public static final int SWS_POINT = 16;
/*     */   public static final int SWS_AREA = 32;
/*     */   public static final int SWS_BICUBLIN = 64;
/*     */   public static final int SWS_GAUSS = 128;
/*     */   public static final int SWS_SINC = 256;
/*     */   public static final int SWS_LANCZOS = 512;
/*     */   public static final int SWS_SPLINE = 1024;
/*     */   public static final int SWS_SRC_V_CHR_DROP_MASK = 196608;
/*     */   public static final int SWS_SRC_V_CHR_DROP_SHIFT = 16;
/*     */   public static final int SWS_PARAM_DEFAULT = 123456;
/*     */   public static final int SWS_PRINT_INFO = 4096;
/*     */   public static final int SWS_FULL_CHR_H_INT = 8192;
/*     */   public static final int SWS_FULL_CHR_H_INP = 16384;
/*     */   public static final int SWS_DIRECT_BGR = 32768;
/*     */   public static final int SWS_ACCURATE_RND = 262144;
/*     */   public static final int SWS_BITEXACT = 524288;
/*     */   public static final int SWS_ERROR_DIFFUSION = 8388608;
/*     */   public static final int SWS_CPU_CAPS_MMX = -2147483648;
/*     */   public static final int SWS_CPU_CAPS_MMXEXT = 536870912;
/*     */   public static final int SWS_CPU_CAPS_MMX2 = 536870912;
/*     */   public static final int SWS_CPU_CAPS_3DNOW = 1073741824;
/*     */   public static final int SWS_CPU_CAPS_ALTIVEC = 268435456;
/*     */   public static final int SWS_CPU_CAPS_BFIN = 16777216;
/*     */   public static final int SWS_CPU_CAPS_SSE2 = 33554432;
/*     */   public static final double SWS_MAX_REDUCE_CUTOFF = 0.002D;
/*     */   public static final int SWS_CS_ITU709 = 1;
/*     */   public static final int SWS_CS_FCC = 4;
/*     */   public static final int SWS_CS_ITU601 = 5;
/*     */   public static final int SWS_CS_ITU624 = 5;
/*     */   public static final int SWS_CS_SMPTE170M = 5;
/*     */   public static final int SWS_CS_SMPTE240M = 7;
/*     */   public static final int SWS_CS_DEFAULT = 5;
/*     */ 
/*     */   @Cast({"unsigned"})
/*     */   public static native int swscale_version();
/*     */ 
/*     */   @Cast({"const char*"})
/*     */   public static native BytePointer swscale_configuration();
/*     */ 
/*     */   @Cast({"const char*"})
/*     */   public static native BytePointer swscale_license();
/*     */ 
/*     */   @Const
/*     */   public static native IntPointer sws_getCoefficients(int paramInt);
/*     */ 
/*     */   public static native int sws_isSupportedInput(@Cast({"AVPixelFormat"}) int paramInt);
/*     */ 
/*     */   public static native int sws_isSupportedOutput(@Cast({"AVPixelFormat"}) int paramInt);
/*     */ 
/*     */   public static native int sws_isSupportedEndiannessConversion(@Cast({"AVPixelFormat"}) int paramInt);
/*     */ 
/*     */   public static native SwsContext sws_alloc_context();
/*     */ 
/*     */   public static native int sws_init_context(SwsContext paramSwsContext, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2);
/*     */ 
/*     */   public static native void sws_freeContext(SwsContext paramSwsContext);
/*     */ 
/*     */   /** @deprecated */
/*     */   public static native SwsContext sws_getContext(int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const DoublePointer paramDoublePointer);
/*     */ 
/*     */   public static native SwsContext sws_getContext(int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const DoubleBuffer paramDoubleBuffer);
/*     */ 
/*     */   public static native SwsContext sws_getContext(int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const double[] paramArrayOfDouble);
/*     */ 
/*     */   public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t*const*"}) PointerPointer paramPointerPointer1, @Const IntPointer paramIntPointer1, int paramInt1, int paramInt2, @Cast({"uint8_t*const*"}) PointerPointer paramPointerPointer2, @Const IntPointer paramIntPointer2);
/*     */ 
/*     */   public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t*const*"}) @ByPtrPtr BytePointer paramBytePointer1, @Const IntPointer paramIntPointer1, int paramInt1, int paramInt2, @Cast({"uint8_t*const*"}) @ByPtrPtr BytePointer paramBytePointer2, @Const IntPointer paramIntPointer2);
/*     */ 
/*     */   public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer1, @Const IntBuffer paramIntBuffer1, int paramInt1, int paramInt2, @Cast({"uint8_t*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Const IntBuffer paramIntBuffer2);
/*     */ 
/*     */   public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t*const*"}) @ByPtrPtr byte[] paramArrayOfByte1, @Const int[] paramArrayOfInt1, int paramInt1, int paramInt2, @Cast({"uint8_t*const*"}) @ByPtrPtr byte[] paramArrayOfByte2, @Const int[] paramArrayOfInt2);
/*     */ 
/*     */   public static native int sws_setColorspaceDetails(SwsContext paramSwsContext, @Const IntPointer paramIntPointer1, int paramInt1, @Const IntPointer paramIntPointer2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */ 
/*     */   public static native int sws_setColorspaceDetails(SwsContext paramSwsContext, @Const IntBuffer paramIntBuffer1, int paramInt1, @Const IntBuffer paramIntBuffer2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */ 
/*     */   public static native int sws_setColorspaceDetails(SwsContext paramSwsContext, @Const int[] paramArrayOfInt1, int paramInt1, @Const int[] paramArrayOfInt2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */ 
/*     */   public static native int sws_getColorspaceDetails(SwsContext paramSwsContext, @Cast({"int**"}) PointerPointer paramPointerPointer1, IntPointer paramIntPointer1, @Cast({"int**"}) PointerPointer paramPointerPointer2, IntPointer paramIntPointer2, IntPointer paramIntPointer3, IntPointer paramIntPointer4, IntPointer paramIntPointer5);
/*     */ 
/*     */   public static native int sws_getColorspaceDetails(SwsContext paramSwsContext, @ByPtrPtr IntPointer paramIntPointer1, IntPointer paramIntPointer2, @ByPtrPtr IntPointer paramIntPointer3, IntPointer paramIntPointer4, IntPointer paramIntPointer5, IntPointer paramIntPointer6, IntPointer paramIntPointer7);
/*     */ 
/*     */   public static native int sws_getColorspaceDetails(SwsContext paramSwsContext, @ByPtrPtr IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, @ByPtrPtr IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, IntBuffer paramIntBuffer6, IntBuffer paramIntBuffer7);
/*     */ 
/*     */   public static native int sws_getColorspaceDetails(SwsContext paramSwsContext, @ByPtrPtr int[] paramArrayOfInt1, int[] paramArrayOfInt2, @ByPtrPtr int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7);
/*     */ 
/*     */   public static native SwsVector sws_allocVec(int paramInt);
/*     */ 
/*     */   public static native SwsVector sws_getGaussianVec(double paramDouble1, double paramDouble2);
/*     */ 
/*     */   public static native SwsVector sws_getConstVec(double paramDouble, int paramInt);
/*     */ 
/*     */   public static native SwsVector sws_getIdentityVec();
/*     */ 
/*     */   public static native void sws_scaleVec(SwsVector paramSwsVector, double paramDouble);
/*     */ 
/*     */   public static native void sws_normalizeVec(SwsVector paramSwsVector, double paramDouble);
/*     */ 
/*     */   public static native void sws_convVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
/*     */ 
/*     */   public static native void sws_addVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
/*     */ 
/*     */   public static native void sws_subVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
/*     */ 
/*     */   public static native void sws_shiftVec(SwsVector paramSwsVector, int paramInt);
/*     */ 
/*     */   public static native SwsVector sws_cloneVec(SwsVector paramSwsVector);
/*     */ 
/*     */   public static native void sws_printVec2(SwsVector paramSwsVector, avutil.AVClass paramAVClass, int paramInt);
/*     */ 
/*     */   public static native void sws_freeVec(SwsVector paramSwsVector);
/*     */ 
/*     */   public static native SwsFilter sws_getDefaultFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt);
/*     */ 
/*     */   public static native void sws_freeFilter(SwsFilter paramSwsFilter);
/*     */ 
/*     */   public static native SwsContext sws_getCachedContext(SwsContext paramSwsContext, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const DoublePointer paramDoublePointer);
/*     */ 
/*     */   public static native SwsContext sws_getCachedContext(SwsContext paramSwsContext, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const DoubleBuffer paramDoubleBuffer);
/*     */ 
/*     */   public static native SwsContext sws_getCachedContext(SwsContext paramSwsContext, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, @Const double[] paramArrayOfDouble);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked32(@Cast({"const uint8_t*"}) BytePointer paramBytePointer1, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, int paramInt, @Cast({"const uint8_t*"}) BytePointer paramBytePointer3);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked32(@Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer1, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer3);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked32(@Cast({"const uint8_t*"}) byte[] paramArrayOfByte1, @Cast({"uint8_t*"}) byte[] paramArrayOfByte2, int paramInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte3);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked24(@Cast({"const uint8_t*"}) BytePointer paramBytePointer1, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, int paramInt, @Cast({"const uint8_t*"}) BytePointer paramBytePointer3);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked24(@Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer1, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer3);
/*     */ 
/*     */   public static native void sws_convertPalette8ToPacked24(@Cast({"const uint8_t*"}) byte[] paramArrayOfByte1, @Cast({"uint8_t*"}) byte[] paramArrayOfByte2, int paramInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte3);
/*     */ 
/*     */   @Const
/*     */   public static native avutil.AVClass sws_get_class();
/*     */ 
/*     */   static
/*     */   {
/*  39 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class SwsContext extends Pointer
/*     */   {
/*     */     public SwsContext()
/*     */     {
/*     */     }
/*     */ 
/*     */     public SwsContext(Pointer p)
/*     */     {
/* 201 */       super();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class SwsFilter extends Pointer
/*     */   {
/*     */     public SwsFilter()
/*     */     {
/* 184 */       allocate(); } 
/* 185 */     public SwsFilter(int size) { allocateArray(size); } 
/* 186 */     public SwsFilter(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 190 */     public SwsFilter position(int position) { return (SwsFilter)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native swscale.SwsVector lumH();
/*     */ 
/*     */     public native SwsFilter lumH(swscale.SwsVector paramSwsVector);
/*     */ 
/*     */     public native swscale.SwsVector lumV();
/*     */ 
/*     */     public native SwsFilter lumV(swscale.SwsVector paramSwsVector);
/*     */ 
/*     */     public native swscale.SwsVector chrH();
/*     */ 
/*     */     public native SwsFilter chrH(swscale.SwsVector paramSwsVector);
/*     */ 
/*     */     public native swscale.SwsVector chrV();
/*     */ 
/*     */     public native SwsFilter chrV(swscale.SwsVector paramSwsVector);
/*     */ 
/*     */     static
/*     */     {
/* 183 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class SwsVector extends Pointer
/*     */   {
/*     */     public SwsVector()
/*     */     {
/* 166 */       allocate(); } 
/* 167 */     public SwsVector(int size) { allocateArray(size); } 
/* 168 */     public SwsVector(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 172 */     public SwsVector position(int position) { return (SwsVector)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native DoublePointer coeff();
/*     */ 
/*     */     public native SwsVector coeff(DoublePointer paramDoublePointer);
/*     */ 
/*     */     public native int length();
/*     */ 
/*     */     public native SwsVector length(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 165 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.swscale
 * JD-Core Version:    0.6.2
 */