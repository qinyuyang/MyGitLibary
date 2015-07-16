/*    */ package com.googlecode.javacv.cpp;
/*    */ 
/*    */ import com.googlecode.javacpp.BytePointer;
/*    */ import com.googlecode.javacpp.IntPointer;
/*    */ import com.googlecode.javacpp.Loader;
/*    */ import com.googlecode.javacpp.Pointer;
/*    */ import com.googlecode.javacpp.PointerPointer;
/*    */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*    */ import com.googlecode.javacpp.annotation.Cast;
/*    */ import com.googlecode.javacpp.annotation.Const;
/*    */ import com.googlecode.javacpp.annotation.MemberGetter;
/*    */ import com.googlecode.javacpp.annotation.Properties;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ 
/*    */ @Properties(inherit={avutil.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libpostproc/postprocess.h>"}, link={"postproc@.52"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"postproc-52"})})
/*    */ public class postproc
/*    */ {
/*    */   public static final int PP_QUALITY_MAX = 6;
/*    */   public static final int PP_CPU_CAPS_MMX = -2147483648;
/*    */   public static final int PP_CPU_CAPS_MMX2 = 536870912;
/*    */   public static final int PP_CPU_CAPS_3DNOW = 1073741824;
/*    */   public static final int PP_CPU_CAPS_ALTIVEC = 268435456;
/*    */   public static final int PP_CPU_CAPS_AUTO = 524288;
/*    */   public static final int PP_FORMAT = 8;
/*    */   public static final int PP_FORMAT_420 = 25;
/*    */   public static final int PP_FORMAT_422 = 9;
/*    */   public static final int PP_FORMAT_411 = 10;
/*    */   public static final int PP_FORMAT_444 = 8;
/*    */   public static final int PP_PICT_TYPE_QP2 = 16;
/*    */ 
/*    */   @Cast({"unsigned"})
/*    */   public static native int postproc_version();
/*    */ 
/*    */   @Cast({"const char*"})
/*    */   public static native BytePointer postproc_configuration();
/*    */ 
/*    */   @Cast({"const char*"})
/*    */   public static native BytePointer postproc_license();
/*    */ 
/*    */   @MemberGetter
/*    */   public static native byte pp_help(int paramInt);
/*    */ 
/*    */   @MemberGetter
/*    */   @Cast({"const char*"})
/*    */   public static native BytePointer pp_help();
/*    */ 
/*    */   public static native void pp_postprocess(@Cast({"const uint8_t**"}) PointerPointer paramPointerPointer1, @Const IntPointer paramIntPointer1, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer2, @Const IntPointer paramIntPointer2, int paramInt1, int paramInt2, @Const BytePointer paramBytePointer, int paramInt3, @Cast({"pp_mode*"}) Pointer paramPointer1, @Cast({"pp_context*"}) Pointer paramPointer2, int paramInt4);
/*    */ 
/*    */   public static native void pp_postprocess(@Cast({"const uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, @Const IntPointer paramIntPointer1, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer2, @Const IntPointer paramIntPointer2, int paramInt1, int paramInt2, @Const BytePointer paramBytePointer3, int paramInt3, @Cast({"pp_mode*"}) Pointer paramPointer1, @Cast({"pp_context*"}) Pointer paramPointer2, int paramInt4);
/*    */ 
/*    */   public static native void pp_postprocess(@Cast({"const uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, @Const IntBuffer paramIntBuffer1, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Const IntBuffer paramIntBuffer2, int paramInt1, int paramInt2, @Const BytePointer paramBytePointer, int paramInt3, @Cast({"pp_mode*"}) Pointer paramPointer1, @Cast({"pp_context*"}) Pointer paramPointer2, int paramInt4);
/*    */ 
/*    */   public static native void pp_postprocess(@Cast({"const uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, @Const int[] paramArrayOfInt1, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte2, @Const int[] paramArrayOfInt2, int paramInt1, int paramInt2, @Const BytePointer paramBytePointer, int paramInt3, @Cast({"pp_mode*"}) Pointer paramPointer1, @Cast({"pp_context*"}) Pointer paramPointer2, int paramInt4);
/*    */ 
/*    */   @Cast({"pp_mode*"})
/*    */   public static native Pointer pp_get_mode_by_name_and_quality(@Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*    */ 
/*    */   @Cast({"pp_mode*"})
/*    */   public static native Pointer pp_get_mode_by_name_and_quality(String paramString, int paramInt);
/*    */ 
/*    */   public static native void pp_free_mode(@Cast({"pp_mode*"}) Pointer paramPointer);
/*    */ 
/*    */   @Cast({"pp_context*"})
/*    */   public static native Pointer pp_get_context(int paramInt1, int paramInt2, int paramInt3);
/*    */ 
/*    */   public static native void pp_free_context(@Cast({"pp_context*"}) Pointer paramPointer);
/*    */ 
/*    */   static
/*    */   {
/* 39 */     Loader.load();
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.postproc
 * JD-Core Version:    0.6.2
 */