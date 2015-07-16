/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacpp.annotation.StdVector;
/*     */ 
/*     */ @Properties(inherit={opencv_calib3d.class, opencv_features2d.class, opencv_objdetect.class, opencv_photo.class, opencv_ml.class, opencv_legacy.class, opencv_video.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/nonfree/nonfree.hpp>", "<opencv2/features2d/features2d.hpp>"}, link={"opencv_nonfree@.2.4", "opencv_gpu@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_nonfree248", "opencv_gpu248"}), @com.googlecode.javacpp.annotation.Platform(value={"android"}, link={"opencv_nonfree"})})
/*     */ public class opencv_nonfree
/*     */ {
/*     */   @Namespace("cv")
/*     */   @Cast({"bool"})
/*     */   public static native boolean initModule_nonfree();
/*     */ 
/*     */   static
/*     */   {
/*  85 */     if (Loader.load() != null)
/*  86 */       initModule_nonfree();
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class SURF extends opencv_features2d.Feature2D
/*     */   {
/*     */     public SURF(double hessianThreshold)
/*     */     {
/* 134 */       allocate(hessianThreshold); } 
/* 135 */     public SURF(Pointer p) { super(); }
/*     */ 
/*     */     public SURF(double hessianThreshold, int nOctaves, int nOctaveLayers, @Cast({"bool"}) boolean extended, @Cast({"bool"}) boolean upright) {
/* 138 */       allocate(hessianThreshold, nOctaves, nOctaveLayers, extended, upright);
/*     */     }
/*     */ 
/*     */     private native void allocate(double paramDouble);
/*     */ 
/*     */     private native void allocate(double paramDouble, int paramInt1, int paramInt2, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
/*     */ 
/*     */     public native int descriptorSize();
/*     */ 
/*     */     public native int descriptorType();
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native opencv_core.AlgorithmInfo info();
/*     */ 
/*     */     public native double hessianThreshold();
/*     */ 
/*     */     public native SURF hessianThreshold(double paramDouble);
/*     */ 
/*     */     public native int nOctaves();
/*     */ 
/*     */     public native SURF nOctaves(int paramInt);
/*     */ 
/*     */     public native int nOctaveLayers();
/*     */ 
/*     */     public native SURF nOctaveLayers(int paramInt);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean extended();
/*     */ 
/*     */     public native SURF extended(boolean paramBoolean);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean upright();
/*     */ 
/*     */     public native SURF upright(boolean paramBoolean);
/*     */ 
/*     */     static
/*     */     {
/* 133 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static class SIFT extends opencv_features2d.Feature2D
/*     */   {
/*     */     public SIFT()
/*     */     {
/*  94 */       allocate(); } 
/*  95 */     public SIFT(Pointer p) { super(); }
/*     */ 
/*     */     public SIFT(int nfeatures, int nOctaveLayers, double contrastThreshold, double edgeThreshold, double sigma) {
/*  98 */       allocate(nfeatures, nOctaveLayers, contrastThreshold, edgeThreshold, sigma);
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3);
/*     */ 
/*     */     public native int descriptorSize();
/*     */ 
/*     */     public native int descriptorType();
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native opencv_core.AlgorithmInfo info();
/*     */ 
/*     */     public native void buildGaussianPyramid(opencv_core.IplImage paramIplImage, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt);
/*     */ 
/*     */     public native void buildDoGPyramid(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray2);
/*     */ 
/*     */     public native void findScaleSpaceExtrema(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*     */ 
/*     */     static
/*     */     {
/*  93 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_nonfree
 * JD-Core Version:    0.6.2
 */