/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Platform;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacpp.annotation.StdVector;
/*     */ 
/*     */ @Properties(inherit={opencv_calib3d.class, opencv_features2d.class, opencv_objdetect.class, opencv_photo.class, opencv_nonfree.class, opencv_video.class, opencv_ml.class, opencv_legacy.class}, value={@Platform(include={"<opencv2/videostab/videostab.hpp>"}, link={"opencv_videostab@.2.4", "opencv_gpu@.2.4"}), @Platform(value={"windows"}, link={"opencv_videostab248", "opencv_gpu248"}), @Platform(value={"android"}, link={"opencv_videostab"})})
/*     */ public class opencv_videostab
/*     */ {
/*     */   public static final int TRANSLATION = 0;
/*     */   public static final int TRANSLATION_AND_SCALE = 1;
/*     */   public static final int LINEAR_SIMILARITY = 2;
/*     */   public static final int AFFINE = 3;
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::PyrLkOptFlowEstimatorBase*>"})
/*     */   public static native PyrLkOptFlowEstimatorBase castPyrLkOptFlowEstimatorBase(SparsePyrLkOptFlowEstimator paramSparsePyrLkOptFlowEstimator);
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::ISparseOptFlowEstimator*>"})
/*     */   public static native ISparseOptFlowEstimator castISparseOptFlowEstimator(SparsePyrLkOptFlowEstimator paramSparsePyrLkOptFlowEstimator);
/*     */ 
/*     */   @Platform(not={"android"})
/*     */   @Name({"dynamic_cast<cv::videostab::PyrLkOptFlowEstimatorBase*>"})
/*     */   public static native PyrLkOptFlowEstimatorBase castPyrLkOptFlowEstimatorBase(DensePyrLkOptFlowEstimatorGpu paramDensePyrLkOptFlowEstimatorGpu);
/*     */ 
/*     */   @Platform(not={"android"})
/*     */   @Name({"dynamic_cast<cv::videostab::IDenseOptFlowEstimator*>"})
/*     */   public static native IDenseOptFlowEstimator castIDenseOptFlowEstimator(DensePyrLkOptFlowEstimatorGpu paramDensePyrLkOptFlowEstimatorGpu);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   @opencv_core.OutputMat
/*     */   public static native opencv_core.CvMat estimateGlobalMotionLeastSquares(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f1, @Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt, float[] paramArrayOfFloat);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   @opencv_core.OutputMat
/*     */   public static native opencv_core.CvMat estimateGlobalMotionRobust(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f1, @Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt, @ByRef RansacParams paramRansacParams, float[] paramArrayOfFloat, int[] paramArrayOfInt);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   @opencv_core.OutputMat
/*     */   public static native opencv_core.CvMat getMotion(int paramInt1, int paramInt2, @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   @opencv_core.OutputMat
/*     */   public static native opencv_core.CvMat ensureInclusionConstraint(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize, float paramFloat);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static native float estimateOptimalTrimRatio(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static native void calcFlowMask(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, float paramFloat, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, @opencv_core.InputMat opencv_core.IplImage paramIplImage6);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static native void completeFrameAccordingToFlow(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, float paramFloat, @opencv_core.InputMat opencv_core.IplImage paramIplImage6, @opencv_core.InputMat opencv_core.IplImage paramIplImage7);
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static native float calcBlurriness(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::StabilizerBase*>"})
/*     */   public static native StabilizerBase castStabilizerBase(OnePassStabilizer paramOnePassStabilizer);
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::IFrameSource*>"})
/*     */   public static native IFrameSource castIFrameSource(OnePassStabilizer paramOnePassStabilizer);
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::StabilizerBase*>"})
/*     */   public static native StabilizerBase castStabilizerBase(TwoPassStabilizer paramTwoPassStabilizer);
/*     */ 
/*     */   @Name({"dynamic_cast<cv::videostab::IFrameSource*>"})
/*     */   public static native IFrameSource castIFrameSource(TwoPassStabilizer paramTwoPassStabilizer);
/*     */ 
/*     */   static
/*     */   {
/*  86 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class TwoPassStabilizer extends Pointer
/*     */   {
/*     */     public TwoPassStabilizer()
/*     */     {
/* 629 */       allocate(); } 
/* 630 */     public TwoPassStabilizer(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setMotionStabilizer(@opencv_core.Ptr opencv_videostab.IMotionStabilizer paramIMotionStabilizer);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.IMotionStabilizer motionStabilizer();
/*     */ 
/*     */     public native void setEstimateTrimRatio(@Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean mustEstimateTrimaRatio();
/*     */ 
/*     */     public native void reset();
/*     */ 
/*     */     @opencv_core.OutputMat
/*     */     public native opencv_core.IplImage nextFrame();
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.MatVector motions();
/*     */ 
/* 644 */     public opencv_videostab.StabilizerBase getStabilizerBase() { return opencv_videostab.castStabilizerBase(this); } 
/* 645 */     public opencv_videostab.IFrameSource getIFrameSource() { return opencv_videostab.castIFrameSource(this); }
/*     */ 
/*     */ 
/*     */     static
/*     */     {
/* 628 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class OnePassStabilizer extends Pointer
/*     */   {
/*     */     public OnePassStabilizer()
/*     */     {
/* 610 */       allocate(); } 
/* 611 */     public OnePassStabilizer(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setMotionFilter(@opencv_core.Ptr opencv_videostab.MotionFilterBase paramMotionFilterBase);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.MotionFilterBase motionFilter();
/*     */ 
/*     */     public native void reset();
/*     */ 
/*     */     @opencv_core.OutputMat
/*     */     public native opencv_core.IplImage nextFrame();
/*     */ 
/* 620 */     public opencv_videostab.StabilizerBase getStabilizerBase() { return opencv_videostab.castStabilizerBase(this); } 
/* 621 */     public opencv_videostab.IFrameSource getIFrameSource() { return opencv_videostab.castIFrameSource(this); }
/*     */ 
/*     */ 
/*     */     static
/*     */     {
/* 609 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class StabilizerBase extends Pointer
/*     */   {
/*     */     public StabilizerBase()
/*     */     {
/*     */     }
/*     */ 
/*     */     public StabilizerBase(Pointer p)
/*     */     {
/* 541 */       super();
/*     */     }
/*     */ 
/*     */     public native void setLog(@opencv_core.Ptr opencv_videostab.ILog paramILog);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.ILog log();
/*     */ 
/*     */     public native void setRadius(int paramInt);
/*     */ 
/*     */     public native int radius();
/*     */ 
/*     */     public native void setFrameSource(@opencv_core.Ptr opencv_videostab.IFrameSource paramIFrameSource);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.IFrameSource frameSource();
/*     */ 
/*     */     public native void setMotionEstimator(@opencv_core.Ptr opencv_videostab.IGlobalMotionEstimator paramIGlobalMotionEstimator);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.IGlobalMotionEstimator motionEstimator();
/*     */ 
/*     */     public native void setDeblurer(@opencv_core.Ptr opencv_videostab.DeblurerBase paramDeblurerBase);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.DeblurerBase deblurrer();
/*     */ 
/*     */     public native void setTrimRatio(float paramFloat);
/*     */ 
/*     */     public native float trimRatio();
/*     */ 
/*     */     public native void setCorrectionForInclusion(@Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean doCorrectionForInclusion();
/*     */ 
/*     */     public native void setBorderMode(int paramInt);
/*     */ 
/*     */     public native int borderMode();
/*     */ 
/*     */     public native void setInpainter(@opencv_core.Ptr opencv_videostab.InpainterBase paramInpainterBase);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.InpainterBase inpainter();
/*     */ 
/*     */     static
/*     */     {
/* 539 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class WeightingDeblurer extends opencv_videostab.DeblurerBase
/*     */   {
/*     */     public WeightingDeblurer()
/*     */     {
/* 526 */       allocate(); } 
/* 527 */     public WeightingDeblurer(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setSensitivity(float paramFloat);
/*     */ 
/*     */     public native float sensitivity();
/*     */ 
/*     */     static
/*     */     {
/* 525 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class NullDeblurer extends opencv_videostab.DeblurerBase
/*     */   {
/*     */     public NullDeblurer()
/*     */     {
/* 517 */       allocate(); } 
/* 518 */     public NullDeblurer(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 516 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class DeblurerBase extends Pointer
/*     */   {
/*     */     public DeblurerBase()
/*     */     {
/*     */     }
/*     */ 
/*     */     public DeblurerBase(Pointer p)
/*     */     {
/* 491 */       super();
/*     */     }
/*     */ 
/*     */     public native void setRadius(int paramInt);
/*     */ 
/*     */     public native int radius();
/*     */ 
/*     */     public native void setFrames(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector frames();
/*     */ 
/*     */     public native void setMotions(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector motions();
/*     */ 
/*     */     public native void setBlurrinessRates(@Const @StdVector FloatPointer paramFloatPointer);
/*     */ 
/*     */     @StdVector
/*     */     public native FloatPointer blurrinessRates();
/*     */ 
/*     */     public native void update();
/*     */ 
/*     */     public native void deblur(int paramInt, @opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     static
/*     */     {
/* 489 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class ColorInpainter extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public ColorInpainter()
/*     */     {
/* 469 */       allocate(); } 
/* 470 */     public ColorInpainter(int method, double radius) { allocate(method, radius); } 
/* 471 */     public ColorInpainter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt, double paramDouble);
/*     */ 
/*     */     static
/*     */     {
/* 468 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class ColorAverageInpainter extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public ColorAverageInpainter()
/*     */     {
/* 460 */       allocate(); } 
/* 461 */     public ColorAverageInpainter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 459 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class MotionInpainter extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public MotionInpainter()
/*     */     {
/* 439 */       allocate(); } 
/* 440 */     public MotionInpainter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setOptFlowEstimator(@opencv_core.Ptr opencv_videostab.IDenseOptFlowEstimator paramIDenseOptFlowEstimator);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.IDenseOptFlowEstimator optFlowEstimator();
/*     */ 
/*     */     public native void setFlowErrorThreshold(float paramFloat);
/*     */ 
/*     */     public native float flowErrorThreshold();
/*     */ 
/*     */     public native void setDistThreshold(float paramFloat);
/*     */ 
/*     */     public native float distThresh();
/*     */ 
/*     */     public native void setBorderMode(int paramInt);
/*     */ 
/*     */     public native int borderMode();
/*     */ 
/*     */     static
/*     */     {
/* 438 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class ConsistentMosaicInpainter extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public ConsistentMosaicInpainter()
/*     */     {
/* 427 */       allocate(); } 
/* 428 */     public ConsistentMosaicInpainter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setStdevThresh(float paramFloat);
/*     */ 
/*     */     public native float stdevThresh();
/*     */ 
/*     */     static
/*     */     {
/* 426 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class InpaintingPipeline extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public InpaintingPipeline()
/*     */     {
/* 407 */       allocate(); } 
/* 408 */     public InpaintingPipeline(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void pushBack(@opencv_core.Ptr opencv_videostab.InpainterBase paramInpainterBase);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean empty();
/*     */ 
/*     */     static
/*     */     {
/* 406 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class NullInpainter extends opencv_videostab.InpainterBase
/*     */   {
/*     */     public NullInpainter()
/*     */     {
/* 398 */       allocate(); } 
/* 399 */     public NullInpainter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 397 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class InpainterBase extends Pointer
/*     */   {
/*     */     public InpainterBase()
/*     */     {
/*     */     }
/*     */ 
/*     */     public InpainterBase(Pointer p)
/*     */     {
/* 368 */       super();
/*     */     }
/*     */ 
/*     */     public native void setRadius(int paramInt);
/*     */ 
/*     */     public native int radius();
/*     */ 
/*     */     public native void setFrames(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector frames();
/*     */ 
/*     */     public native void setMotions(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector motions();
/*     */ 
/*     */     public native void setStabilizedFrames(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector stabilizedFrames();
/*     */ 
/*     */     public native void setStabilizationMotions(@Const @ByRef opencv_core.MatVector paramMatVector);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_core.MatVector stabilizationMotions();
/*     */ 
/*     */     public native void update();
/*     */ 
/*     */     public native void inpaint(int paramInt, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*     */ 
/*     */     static
/*     */     {
/* 366 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class LogToStdout extends opencv_videostab.ILog
/*     */   {
/*     */     public LogToStdout()
/*     */     {
/* 342 */       allocate(); } 
/* 343 */     public LogToStdout(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 341 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class NullLog extends opencv_videostab.ILog
/*     */   {
/*     */     public NullLog()
/*     */     {
/* 333 */       allocate(); } 
/* 334 */     public NullLog(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 332 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class ILog extends Pointer
/*     */   {
/*     */     public ILog()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ILog(Pointer p)
/*     */     {
/* 326 */       super();
/*     */     }
/*     */ 
/*     */     public native void print(String paramString);
/*     */ 
/*     */     static
/*     */     {
/* 324 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class VideoFileSource extends opencv_videostab.IFrameSource
/*     */   {
/*     */     public VideoFileSource(String path)
/*     */     {
/* 306 */       allocate(path);
/*     */     }
/* 308 */     public VideoFileSource(String path, @Cast({"bool"}) boolean volatileFrame) { allocate(path, volatileFrame); } 
/*     */     public VideoFileSource(Pointer p) {
/* 310 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate(String paramString);
/*     */ 
/*     */     private native void allocate(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native int frameCount();
/*     */ 
/*     */     public native double fps();
/*     */ 
/*     */     static
/*     */     {
/* 305 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class NullFrameSource extends opencv_videostab.IFrameSource
/*     */   {
/*     */     public NullFrameSource()
/*     */     {
/* 296 */       allocate(); } 
/* 297 */     public NullFrameSource(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 295 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class IFrameSource extends Pointer
/*     */   {
/*     */     public IFrameSource()
/*     */     {
/*     */     }
/*     */ 
/*     */     public IFrameSource(Pointer p)
/*     */     {
/* 288 */       super();
/*     */     }
/*     */ 
/*     */     public native void reset();
/*     */ 
/*     */     @opencv_core.OutputMat
/*     */     public native opencv_core.IplImage nextFrame();
/*     */ 
/*     */     static
/*     */     {
/* 286 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class GaussianMotionFilter extends opencv_videostab.MotionFilterBase
/*     */   {
/*     */     public GaussianMotionFilter()
/*     */     {
/* 268 */       allocate(); } 
/* 269 */     public GaussianMotionFilter(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setStdev(float paramFloat);
/*     */ 
/*     */     public native float stdev();
/*     */ 
/*     */     static
/*     */     {
/* 267 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class MotionFilterBase extends opencv_videostab.IMotionStabilizer
/*     */   {
/*     */     public MotionFilterBase()
/*     */     {
/*     */     }
/*     */ 
/*     */     public MotionFilterBase(Pointer p)
/*     */     {
/* 253 */       super();
/*     */     }
/*     */ 
/*     */     public native void setRadius(int paramInt);
/*     */ 
/*     */     public native int radius();
/*     */ 
/*     */     public native void update();
/*     */ 
/*     */     @opencv_core.OutputMat
/*     */     public native opencv_core.CvMat stabilize(int paramInt1, @opencv_core.InputMat opencv_core.CvMat paramCvMat, int paramInt2);
/*     */ 
/*     */     static
/*     */     {
/* 251 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class IMotionStabilizer extends Pointer
/*     */   {
/*     */     public IMotionStabilizer()
/*     */     {
/*     */     }
/*     */ 
/*     */     public IMotionStabilizer(Pointer p)
/*     */     {
/* 245 */       super();
/*     */     }
/*     */ 
/*     */     public native void stabilize(@opencv_core.InputMat opencv_core.CvMat paramCvMat1, int paramInt, @opencv_core.InputMat opencv_core.CvMat paramCvMat2);
/*     */ 
/*     */     static
/*     */     {
/* 243 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class PyrLkRobustMotionEstimator extends opencv_videostab.IGlobalMotionEstimator
/*     */   {
/*     */     public PyrLkRobustMotionEstimator()
/*     */     {
/* 212 */       allocate(); } 
/* 213 */     public PyrLkRobustMotionEstimator(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setDetector(@opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_features2d.FeatureDetector detector();
/*     */ 
/*     */     public native void setOptFlowEstimator(@opencv_core.Ptr opencv_videostab.ISparseOptFlowEstimator paramISparseOptFlowEstimator);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_videostab.ISparseOptFlowEstimator optFlowEstimator();
/*     */ 
/*     */     public native void setMotionModel(@Cast({"cv::videostab::MotionModel"}) int paramInt);
/*     */ 
/*     */     @Cast({"cv::videostab::MotionModel"})
/*     */     public native int motionModel();
/*     */ 
/*     */     public native void setRansacParams(@ByRef opencv_videostab.RansacParams paramRansacParams);
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_videostab.RansacParams ransacParams();
/*     */ 
/*     */     public native void setMaxRmse(float paramFloat);
/*     */ 
/*     */     public native float maxRmse();
/*     */ 
/*     */     public native void setMinInlierRatio(float paramFloat);
/*     */ 
/*     */     public native float minInlierRatio();
/*     */ 
/*     */     static
/*     */     {
/* 211 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class IGlobalMotionEstimator extends Pointer
/*     */   {
/*     */     public IGlobalMotionEstimator()
/*     */     {
/*     */     }
/*     */ 
/*     */     public IGlobalMotionEstimator(Pointer p)
/*     */     {
/* 205 */       super();
/*     */     }
/*     */ 
/*     */     @opencv_core.OutputMat
/*     */     public native opencv_core.CvMat estimate(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*     */ 
/*     */     static
/*     */     {
/* 203 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::videostab")
/*     */   public static class RansacParams extends Pointer
/*     */   {
/*     */     public RansacParams(int size, float thresh, float eps, float prob)
/*     */     {
/* 180 */       allocate(size, thresh, eps, prob);
/*     */     }
/* 182 */     public RansacParams(Pointer p) { super(); } 
/*     */     private native void allocate(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */ 
/*     */     public native int size();
/*     */ 
/*     */     public native RansacParams size(int paramInt);
/*     */ 
/*     */     public native float thresh();
/*     */ 
/*     */     public native RansacParams thresh(float paramFloat);
/*     */ 
/*     */     public native float eps();
/*     */ 
/*     */     public native RansacParams eps(float paramFloat);
/*     */ 
/*     */     public native float prob();
/*     */ 
/*     */     public native RansacParams prob(float paramFloat);
/*     */ 
/* 190 */     static RansacParams translationMotionStd() { return new RansacParams(2, 0.5F, 0.5F, 0.99F); } 
/* 191 */     static RansacParams translationAndScale2dMotionStd() { return new RansacParams(3, 0.5F, 0.5F, 0.99F); } 
/* 192 */     static RansacParams linearSimilarityMotionStd() { return new RansacParams(4, 0.5F, 0.5F, 0.99F); } 
/* 193 */     static RansacParams affine2dMotionStd() { return new RansacParams(6, 0.5F, 0.5F, 0.99F); }
/*     */ 
/*     */ 
/*     */     static
/*     */     {
/* 178 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Platform(not={"android"})
/*     */   @Namespace("cv::videostab")
/*     */   public static class DensePyrLkOptFlowEstimatorGpu extends Pointer
/*     */   {
/*     */     public DensePyrLkOptFlowEstimatorGpu()
/*     */     {
/* 152 */       allocate(); } 
/* 153 */     public DensePyrLkOptFlowEstimatorGpu(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5);
/*     */ 
/*     */     public opencv_videostab.PyrLkOptFlowEstimatorBase getPyrLkOptFlowEstimatorBase() {
/* 159 */       return opencv_videostab.castPyrLkOptFlowEstimatorBase(this); } 
/* 160 */     public opencv_videostab.IDenseOptFlowEstimator getIDenseOptFlowEstimator() { return opencv_videostab.castIDenseOptFlowEstimator(this); }
/*     */ 
/*     */ 
/*     */     static
/*     */     {
/* 151 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class SparsePyrLkOptFlowEstimator extends Pointer
/*     */   {
/*     */     public SparsePyrLkOptFlowEstimator()
/*     */     {
/* 132 */       allocate(); } 
/* 133 */     public SparsePyrLkOptFlowEstimator(Pointer p) { super(); }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5, @opencv_core.InputArray opencv_core.CvArr paramCvArr6);
/*     */ 
/*     */     public opencv_videostab.PyrLkOptFlowEstimatorBase getPyrLkOptFlowEstimatorBase() {
/* 140 */       return opencv_videostab.castPyrLkOptFlowEstimatorBase(this); } 
/* 141 */     public opencv_videostab.ISparseOptFlowEstimator getISparseOptFlowEstimator() { return opencv_videostab.castISparseOptFlowEstimator(this); }
/*     */ 
/*     */ 
/*     */     static
/*     */     {
/* 131 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class PyrLkOptFlowEstimatorBase extends Pointer
/*     */   {
/*     */     public PyrLkOptFlowEstimatorBase()
/*     */     {
/* 110 */       allocate(); } 
/* 111 */     public PyrLkOptFlowEstimatorBase(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void setWinSize(@ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     @Const
/*     */     @ByVal
/*     */     public native opencv_core.CvSize winSize();
/*     */ 
/*     */     public native void setMaxLevel(int paramInt);
/*     */ 
/*     */     public native int maxLevel();
/*     */ 
/*     */     static
/*     */     {
/* 109 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class IDenseOptFlowEstimator extends Pointer
/*     */   {
/*     */     public IDenseOptFlowEstimator()
/*     */     {
/*     */     }
/*     */ 
/*     */     public IDenseOptFlowEstimator(Pointer p)
/*     */     {
/* 102 */       super();
/*     */     }
/*     */ 
/*     */     public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5);
/*     */ 
/*     */     static
/*     */     {
/* 100 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::videostab")
/*     */   public static class ISparseOptFlowEstimator extends Pointer
/*     */   {
/*     */     public ISparseOptFlowEstimator()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ISparseOptFlowEstimator(Pointer p)
/*     */     {
/*  92 */       super();
/*     */     }
/*     */ 
/*     */     public native void run(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.InputArray opencv_core.CvArr paramCvArr5, @opencv_core.InputArray opencv_core.CvArr paramCvArr6);
/*     */ 
/*     */     static
/*     */     {
/*  90 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_videostab
 * JD-Core Version:    0.6.2
 */