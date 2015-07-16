/*    */ package com.googlecode.javacv.cpp;
/*    */ 
/*    */ import com.googlecode.javacpp.Loader;
/*    */ import com.googlecode.javacpp.annotation.ByRef;
/*    */ import com.googlecode.javacpp.annotation.Namespace;
/*    */ import com.googlecode.javacpp.annotation.Properties;
/*    */ 
/*    */ @Properties(inherit={opencv_imgproc.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/photo/photo_c.h>", "<opencv2/photo/photo.hpp>"}, link={"opencv_photo@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_photo248"})})
/*    */ public class opencv_photo
/*    */ {
/*    */   public static final int CV_INPAINT_NS = 0;
/*    */   public static final int CV_INPAINT_TELEA = 1;
/*    */ 
/*    */   public static native void cvInpaint(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble, int paramInt);
/*    */ 
/*    */   @Namespace("cv")
/*    */   public static native void fastNlMeansDenoising(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, float paramFloat, int paramInt1, int paramInt2);
/*    */ 
/*    */   @Namespace("cv")
/*    */   public static native void fastNlMeansDenoisingColored(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
/*    */ 
/*    */   @Namespace("cv")
/*    */   public static native void fastNlMeansDenoisingMulti(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
/*    */ 
/*    */   @Namespace("cv")
/*    */   public static native void fastNlMeansDenoisingColoredMulti(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4);
/*    */ 
/*    */   static
/*    */   {
/* 75 */     Loader.load();
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_photo
 * JD-Core Version:    0.6.2
 */