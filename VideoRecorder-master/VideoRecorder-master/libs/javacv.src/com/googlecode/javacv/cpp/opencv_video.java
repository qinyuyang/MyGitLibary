/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.Pointer.Deallocator;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ 
/*     */ @Properties(inherit={opencv_imgproc.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/video/video.hpp>"}, link={"opencv_video@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_video248"})})
/*     */ public class opencv_video
/*     */ {
/*     */   public static final int CV_LKFLOW_PYR_A_READY = 1;
/*     */   public static final int CV_LKFLOW_PYR_B_READY = 2;
/*     */   public static final int CV_LKFLOW_INITIAL_GUESSES = 4;
/*     */   public static final int CV_LKFLOW_GET_MIN_EIGENVALS = 8;
/*     */   public static final int OPTFLOW_USE_INITIAL_FLOW = 4;
/*     */   public static final int OPTFLOW_LK_GET_MIN_EIGENVALS = 8;
/*     */   public static final int OPTFLOW_FARNEBACK_GAUSSIAN = 256;
/*     */ 
/*     */   @Namespace("cv")
/*     */   @Cast({"bool"})
/*     */   public static native boolean initModule_video();
/*     */ 
/*     */   public static native void cvCalcOpticalFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*     */ 
/*     */   public static native void cvCalcOpticalFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, FloatPointer paramFloatPointer, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*     */ 
/*     */   public static native void cvCalcAffineFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, float[] paramArrayOfFloat1, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*     */ 
/*     */   public static native void cvCalcAffineFlowPyrLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, FloatPointer paramFloatPointer1, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2, @Cast({"char*"}) byte[] paramArrayOfByte, FloatPointer paramFloatPointer2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*     */ 
/*     */   public static native int cvEstimateRigidTransform(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt);
/*     */ 
/*     */   public static native void cvCalcOpticalFlowFarneback(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble2, int paramInt5);
/*     */ 
/*     */   public static native void cvUpdateMotionHistory(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2);
/*     */ 
/*     */   public static native void cvCalcMotionGradient(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, double paramDouble2, int paramInt);
/*     */ 
/*     */   public static native double cvCalcGlobalOrientation(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble1, double paramDouble2);
/*     */ 
/*     */   public static native opencv_core.CvSeq cvSegmentMotion(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble1, double paramDouble2);
/*     */ 
/*     */   public static native int cvCamShift(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvRect paramCvRect, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_imgproc.CvConnectedComp paramCvConnectedComp, opencv_core.CvBox2D paramCvBox2D);
/*     */ 
/*     */   public static native int cvMeanShift(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvRect paramCvRect, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_imgproc.CvConnectedComp paramCvConnectedComp);
/*     */ 
/*     */   public static native CvKalman cvCreateKalman(int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */   public static native void cvReleaseKalman(@ByPtrPtr CvKalman paramCvKalman);
/*     */ 
/*     */   @Const
/*     */   public static native opencv_core.CvMat cvKalmanPredict(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat);
/*     */ 
/*     */   @Const
/*     */   public static native opencv_core.CvMat cvKalmanCorrect(CvKalman paramCvKalman, opencv_core.CvMat paramCvMat);
/*     */ 
/*     */   public static opencv_core.CvMat cvKalmanUpdateByTime(CvKalman kalman, opencv_core.CvMat control)
/*     */   {
/* 201 */     return cvKalmanPredict(kalman, control);
/*     */   }
/*     */   public static opencv_core.CvMat cvKalmanUpdateByMeasurement(CvKalman kalman, opencv_core.CvMat measurement) {
/* 204 */     return cvKalmanCorrect(kalman, measurement);
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native int buildOpticalFlowPyramid(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.IplImageArray paramIplImageArray, @ByVal opencv_core.CvSize paramCvSize, int paramInt1, @Cast({"bool"}) boolean paramBoolean1, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean2);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void calcOpticalFlowPyrLK(@opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray1, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @ByVal opencv_core.CvSize paramCvSize, int paramInt1, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt2, double paramDouble);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void calcOpticalFlowFarneback(@opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray1, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @opencv_core.InputArray opencv_core.CvArr paramCvArr, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble2, int paramInt5);
/*     */ 
/*     */   @Namespace("cv")
/*     */   @opencv_core.OutputMat
/*     */   public static native opencv_core.CvMat estimateRigidTransform(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, boolean paramBoolean);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void calcOpticalFlowSF(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void calcOpticalFlowSF(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt5, double paramDouble6, double paramDouble7, double paramDouble8);
/*     */ 
/*     */   @Namespace("cv")
/*     */   @opencv_core.Ptr
/*     */   public static native DenseOpticalFlow createOptFlow_DualTVL1();
/*     */ 
/*     */   static
/*     */   {
/*  83 */     Loader.load(opencv_imgproc.class);
/*  84 */     if (Loader.load() != null)
/*  85 */       initModule_video();
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class BackgroundSubtractorGMG extends opencv_video.BackgroundSubtractor
/*     */   {
/*     */     public BackgroundSubtractorGMG()
/*     */     {
/* 328 */       allocate(); } 
/* 329 */     public BackgroundSubtractorGMG(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void initialize(@ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2);
/*     */ 
/*     */     public native void release();
/*     */ 
/*     */     public native int maxFeatures();
/*     */ 
/*     */     public native BackgroundSubtractorGMG maxFeatures(int paramInt);
/*     */ 
/*     */     public native double learningRate();
/*     */ 
/*     */     public native BackgroundSubtractorGMG learningRate(double paramDouble);
/*     */ 
/*     */     public native int numInitializationFrames();
/*     */ 
/*     */     public native BackgroundSubtractorGMG numInitializationFrames(int paramInt);
/*     */ 
/*     */     public native int quantizationLevels();
/*     */ 
/*     */     public native BackgroundSubtractorGMG quantizationLevels(int paramInt);
/*     */ 
/*     */     public native double backgroundPrior();
/*     */ 
/*     */     public native BackgroundSubtractorGMG backgroundPrior(double paramDouble);
/*     */ 
/*     */     public native double decisionThreshold();
/*     */ 
/*     */     public native BackgroundSubtractorGMG decisionThreshold(double paramDouble);
/*     */ 
/*     */     public native int smoothingRadius();
/*     */ 
/*     */     public native BackgroundSubtractorGMG smoothingRadius(int paramInt);
/*     */ 
/*     */     public native boolean updateBackgroundModel();
/*     */ 
/*     */     public native BackgroundSubtractorGMG updateBackgroundModel(boolean paramBoolean);
/*     */ 
/*     */     static
/*     */     {
/* 327 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class BackgroundSubtractorMOG2 extends opencv_video.BackgroundSubtractor
/*     */   {
/*     */     public BackgroundSubtractorMOG2()
/*     */     {
/* 288 */       allocate();
/*     */     }
/* 290 */     public BackgroundSubtractorMOG2(int history, float varThreshold, boolean bShadowDetection) { allocate(history, varThreshold, bShadowDetection); } 
/*     */     public BackgroundSubtractorMOG2(Pointer p) {
/* 292 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt, float paramFloat, boolean paramBoolean);
/*     */ 
/*     */     public native void initialize(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 287 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class BackgroundSubtractorMOG extends opencv_video.BackgroundSubtractor
/*     */   {
/*     */     public BackgroundSubtractorMOG()
/*     */     {
/* 259 */       allocate();
/*     */     }
/* 261 */     public BackgroundSubtractorMOG(int history, int nmixtures, double backgroundRatio, double noiseSigma) { allocate(history, nmixtures, backgroundRatio, noiseSigma); } 
/*     */     public BackgroundSubtractorMOG(Pointer p) {
/* 263 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
/*     */ 
/*     */     public native void initialize(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 258 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static class BackgroundSubtractor extends opencv_core.Algorithm
/*     */   {
/*     */     public BackgroundSubtractor()
/*     */     {
/*     */     }
/*     */ 
/*     */     public BackgroundSubtractor(Pointer p)
/*     */     {
/* 249 */       super();
/*     */     }
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void apply(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, double paramDouble);
/*     */ 
/*     */     public native void getBackgroundImage(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*     */ 
/*     */     static
/*     */     {
/* 247 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static class DenseOpticalFlow extends opencv_core.Algorithm
/*     */   {
/*     */     public DenseOpticalFlow()
/*     */     {
/*     */     }
/*     */ 
/*     */     public DenseOpticalFlow(Pointer p)
/*     */     {
/* 238 */       super();
/*     */     }
/*     */ 
/*     */     public native void calc(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
/*     */ 
/*     */     public native void collectGarbage();
/*     */ 
/*     */     static
/*     */     {
/* 236 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvKalman extends Pointer
/*     */   {
/*     */     public CvKalman()
/*     */     {
/* 135 */       allocate(); zero(); } 
/* 136 */     public CvKalman(int size) { allocateArray(size); zero(); } 
/* 137 */     public CvKalman(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 142 */     public CvKalman position(int position) { return (CvKalman)super.position(position); }
/*     */ 
/*     */ 
/*     */     public static CvKalman create(int dynam_params, int measure_params, int control_params)
/*     */     {
/* 147 */       CvKalman k = opencv_video.cvCreateKalman(dynam_params, measure_params, control_params);
/* 148 */       if (k != null) {
/* 149 */         k.deallocator(new ReleaseDeallocator(k));
/*     */       }
/* 151 */       return k;
/*     */     }
/*     */ 
/*     */     public void release() {
/* 155 */       deallocate();
/*     */     }
/*     */ 
/*     */     public native int MP();
/*     */ 
/*     */     public native CvKalman MP(int paramInt);
/*     */ 
/*     */     public native int DP();
/*     */ 
/*     */     public native CvKalman DP(int paramInt);
/*     */ 
/*     */     public native int CP();
/*     */ 
/*     */     public native CvKalman CP(int paramInt);
/*     */ 
/*     */     public native FloatPointer PosterState();
/*     */ 
/*     */     public native CvKalman PosterState(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer PriorState();
/*     */ 
/*     */     public native CvKalman PriorState(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer DynamMatr();
/*     */ 
/*     */     public native CvKalman DynamMatr(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer MeasurementMatr();
/*     */ 
/*     */     public native CvKalman MeasurementMatr(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer MNCovariance();
/*     */ 
/*     */     public native CvKalman MNCovariance(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer PNCovariance();
/*     */ 
/*     */     public native CvKalman PNCovariance(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer KalmGainMatr();
/*     */ 
/*     */     public native CvKalman KalmGainMatr(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer PriorErrorCovariance();
/*     */ 
/*     */     public native CvKalman PriorErrorCovariance(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer PosterErrorCovariance();
/*     */ 
/*     */     public native CvKalman PosterErrorCovariance(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer Temp1();
/*     */ 
/*     */     public native CvKalman Temp1(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native FloatPointer Temp2();
/*     */ 
/*     */     public native CvKalman Temp2(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native opencv_core.CvMat state_pre();
/*     */ 
/*     */     public native CvKalman state_pre(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat state_post();
/*     */ 
/*     */     public native CvKalman state_post(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat transition_matrix();
/*     */ 
/*     */     public native CvKalman transition_matrix(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat control_matrix();
/*     */ 
/*     */     public native CvKalman control_matrix(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat measurement_matrix();
/*     */ 
/*     */     public native CvKalman measurement_matrix(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat process_noise_cov();
/*     */ 
/*     */     public native CvKalman process_noise_cov(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat measurement_noise_cov();
/*     */ 
/*     */     public native CvKalman measurement_noise_cov(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat error_cov_pre();
/*     */ 
/*     */     public native CvKalman error_cov_pre(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat gain();
/*     */ 
/*     */     public native CvKalman gain(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat error_cov_post();
/*     */ 
/*     */     public native CvKalman error_cov_post(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat temp1();
/*     */ 
/*     */     public native CvKalman temp1(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat temp2();
/*     */ 
/*     */     public native CvKalman temp2(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat temp3();
/*     */ 
/*     */     public native CvKalman temp3(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat temp4();
/*     */ 
/*     */     public native CvKalman temp4(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat temp5();
/*     */ 
/*     */     public native CvKalman temp5(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     static
/*     */     {
/* 134 */       Loader.load();
/*     */     }
/*     */ 
/*     */     static class ReleaseDeallocator extends opencv_video.CvKalman
/*     */       implements Pointer.Deallocator
/*     */     {
/*     */       ReleaseDeallocator(opencv_video.CvKalman p)
/*     */       {
/* 158 */         super(); } 
/* 159 */       public void deallocate() { opencv_video.cvReleaseKalman(this); }
/*     */ 
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_video
 * JD-Core Version:    0.6.2
 */