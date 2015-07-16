/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.annotation.Adapter;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.Index;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Platform;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ import com.googlecode.javacpp.annotation.ValueGetter;
/*      */ 
/*      */ @Properties(inherit={opencv_calib3d.class, opencv_objdetect.class, opencv_video.class, opencv_ml.class}, value={@Platform(include={"<opencv2/contrib/contrib.hpp>", "<opencv2/contrib/detection_based_tracker.hpp>", "<opencv2/contrib/hybridtracker.hpp>"}, link={"opencv_contrib@.2.4"}), @Platform(value={"windows"}, link={"opencv_contrib248"})})
/*      */ public class opencv_contrib
/*      */ {
/*      */   public static final int ROTATION = 1;
/*      */   public static final int TRANSLATION = 2;
/*      */   public static final int RIGID_BODY_MOTION = 4;
/*      */   public static final int COLORMAP_AUTUMN = 0;
/*      */   public static final int COLORMAP_BONE = 1;
/*      */   public static final int COLORMAP_JET = 2;
/*      */   public static final int COLORMAP_WINTER = 3;
/*      */   public static final int COLORMAP_RAINBOW = 4;
/*      */   public static final int COLORMAP_OCEAN = 5;
/*      */   public static final int COLORMAP_SUMMER = 6;
/*      */   public static final int COLORMAP_SPRING = 7;
/*      */   public static final int COLORMAP_COOL = 8;
/*      */   public static final int COLORMAP_HSV = 9;
/*      */   public static final int COLORMAP_PINK = 10;
/*      */   public static final int COLORMAP_HOT = 11;
/*      */   public static final int RETINA_COLOR_RANDOM = 0;
/*      */   public static final int RETINA_COLOR_DIAGONAL = 1;
/*      */   public static final int RETINA_COLOR_BAYER = 2;
/*      */ 
/*      */   @Namespace("cv")
/*      */   @Cast({"bool"})
/*      */   public static native boolean initModule_contrib();
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native int chamerMatching(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_core.PointVectorVector paramPointVectorVector, @StdVector FloatPointer paramFloatPointer, double paramDouble1, int paramInt1, double paramDouble2, int paramInt2, int paramInt3, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void polyfit(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @opencv_core.InputMat opencv_core.CvMat paramCvMat3, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void generateColors(@Const @StdVector("CvScalar,cv::Scalar") opencv_core.CvScalar paramCvScalar, long paramLong1, long paramLong2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native boolean RGBDOdometry(@opencv_core.InputMat opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, opencv_core.IplImage paramIplImage5, opencv_core.IplImage paramIplImage6, opencv_core.CvMat paramCvMat3, float paramFloat1, float paramFloat2, float paramFloat3, @Const @StdVector IntPointer paramIntPointer, @Const @StdVector FloatPointer paramFloatPointer, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.OutputMat
/*      */   public static native opencv_core.CvMat subspaceProject(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.OutputMat
/*      */   public static native opencv_core.CvMat subspaceReconstruct(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createEigenFaceRecognizer();
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createFisherFaceRecognizer();
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createLBPHFaceRecognizer();
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createEigenFaceRecognizer(int paramInt, double paramDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createFisherFaceRecognizer(int paramInt, double paramDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FaceRecognizer createLBPHFaceRecognizer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void applyColorMap(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   static
/*      */   {
/*   97 */     if (Loader.load() != null)
/*   98 */       initModule_contrib();
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class BOWMSCTrainer extends opencv_features2d.BOWTrainer
/*      */   {
/*      */     public BOWMSCTrainer()
/*      */     {
/* 1467 */       allocate(); } 
/* 1468 */     public BOWMSCTrainer(double clusterSize) { allocate(clusterSize); } 
/* 1469 */     public BOWMSCTrainer(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1466 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class ChowLiuTree extends Pointer
/*      */   {
/*      */     public ChowLiuTree()
/*      */     {
/* 1453 */       allocate(); } 
/* 1454 */     public ChowLiuTree(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void add(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void add(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getImgDescriptors();
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat make(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1452 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class FabMap2 extends opencv_contrib.FabMap
/*      */   {
/*      */     public FabMap2(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags)
/*      */     {
/* 1418 */       allocate(clTree, PzGe, PzGNe, flags);
/*      */     }
/* 1420 */     public FabMap2(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1416 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class FabMapFBO extends opencv_contrib.FabMap
/*      */   {
/*      */     public FabMapFBO(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags)
/*      */     {
/* 1368 */       allocate(clTree, PzGe, PzGNe, flags);
/*      */     }
/*      */ 
/*      */     public FabMapFBO(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags, int numSamples, double rejectionThreshold, double PsGd, int bisectionStart, int bisectionIts) {
/* 1372 */       allocate(clTree, PzGe, PzGNe, flags, numSamples, rejectionThreshold, PsGd, bisectionStart, bisectionIts);
/*      */     }
/* 1374 */     public FabMapFBO(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, int paramInt3, int paramInt4);
/*      */ 
/*      */     static
/*      */     {
/* 1366 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class FabMapLUT extends opencv_contrib.FabMap
/*      */   {
/*      */     public FabMapLUT(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags)
/*      */     {
/* 1348 */       allocate(clTree, PzGe, PzGNe, flags);
/*      */     }
/*      */     public FabMapLUT(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags, int numSamples, int precision) {
/* 1351 */       allocate(clTree, PzGe, PzGNe, flags, numSamples, precision);
/*      */     }
/* 1353 */     public FabMapLUT(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     static
/*      */     {
/* 1346 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class FabMap1 extends opencv_contrib.FabMap
/*      */   {
/*      */     public FabMap1(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags)
/*      */     {
/* 1332 */       allocate(clTree, PzGe, PzGNe, flags);
/*      */     }
/*      */     public FabMap1(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags, int numSamples) {
/* 1335 */       allocate(clTree, PzGe, PzGNe, flags, numSamples);
/*      */     }
/* 1337 */     public FabMap1(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 1330 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::of2")
/*      */   public static class FabMap extends Pointer
/*      */   {
/*      */     public static final int MEAN_FIELD = 1;
/*      */     public static final int SAMPLED = 2;
/*      */     public static final int NAIVE_BAYES = 4;
/*      */     public static final int CHOW_LIU = 8;
/*      */     public static final int MOTION_MODEL = 16;
/*      */ 
/*      */     protected FabMap()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FabMap(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags)
/*      */     {
/* 1262 */       allocate(clTree, PzGe, PzGNe, flags);
/*      */     }
/*      */     public FabMap(opencv_core.CvArr clTree, double PzGe, double PzGNe, int flags, int numSamples) {
/* 1265 */       allocate(clTree, PzGe, PzGNe, flags, numSamples);
/*      */     }
/* 1267 */     public FabMap(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */     private native void allocate(@opencv_core.InputMat opencv_core.CvArr paramCvArr, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void addTraining(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void addTraining(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     public native void add(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void add(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getTrainingImgDescriptors();
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getTestImgDescriptors();
/*      */ 
/*      */     public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_contrib.IMatch paramIMatch, boolean paramBoolean, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */     public native void compare(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByRef opencv_core.MatVector paramMatVector, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native void compare(@ByRef opencv_core.MatVector paramMatVector, @StdVector opencv_contrib.IMatch paramIMatch, boolean paramBoolean, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void compare(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_core.MatVector paramMatVector2, @StdVector opencv_contrib.IMatch paramIMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     static
/*      */     {
/* 1252 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::of2")
/*      */   public static class IMatch extends Pointer
/*      */   {
/*      */     public IMatch()
/*      */     {
/* 1228 */       allocate();
/*      */     }
/* 1230 */     public IMatch(int _queryIdx, int _imgIdx, double _likelihood, double _match) { allocate(_queryIdx, _imgIdx, _likelihood, _match); } 
/*      */     public IMatch(int size) {
/* 1232 */       allocateArray(size); } 
/* 1233 */     public IMatch(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1239 */     public IMatch position(int position) { return (IMatch)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int queryIdx();
/*      */ 
/*      */     public native IMatch queryIdx(int paramInt);
/*      */ 
/*      */     public native int imgIdx();
/*      */ 
/*      */     public native IMatch imgIdx(int paramInt);
/*      */ 
/*      */     public native double likelihood();
/*      */ 
/*      */     public native IMatch likelihood(double paramDouble);
/*      */ 
/*      */     public native double match();
/*      */ 
/*      */     public native IMatch match(double paramDouble);
/*      */ 
/*      */     @Name({"operator<"})
/*      */     public native boolean compare(@ByRef IMatch paramIMatch);
/*      */ 
/*      */     static
/*      */     {
/* 1227 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvHybridTracker extends Pointer
/*      */   {
/*      */     public CvHybridTracker()
/*      */     {
/* 1210 */       allocate();
/*      */     }
/* 1212 */     public CvHybridTracker(@ByVal opencv_contrib.CvHybridTrackerParams params) { allocate(params); } 
/*      */     public CvHybridTracker(Pointer p) {
/* 1214 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByVal opencv_contrib.CvHybridTrackerParams paramCvHybridTrackerParams);
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public native opencv_contrib.CvHybridTrackerParams params();
/*      */ 
/*      */     public native void newTracker(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native void updateTracker(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect getTrackingWindow();
/*      */ 
/*      */     static
/*      */     {
/* 1209 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvFeatureTracker extends Pointer
/*      */   {
/*      */     public CvFeatureTracker(@ByVal opencv_contrib.CvFeatureTrackerParams params)
/*      */     {
/* 1190 */       allocate(params);
/*      */     }
/* 1192 */     public CvFeatureTracker(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams);
/*      */ 
/*      */     @MemberGetter
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat disp_matches();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public native opencv_contrib.CvFeatureTrackerParams params();
/*      */ 
/*      */     public native void newTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect updateTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect updateTrackingWindowWithSIFT(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect updateTrackingWindowWithFlow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native void setTrackingWindow(@ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect getTrackingWindow();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f getTrackingCenter();
/*      */ 
/*      */     static
/*      */     {
/* 1187 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvMeanShiftTracker extends Pointer
/*      */   {
/*      */     public CvMeanShiftTracker(@ByVal opencv_contrib.CvMeanShiftTrackerParams _params)
/*      */     {
/* 1169 */       allocate(_params);
/*      */     }
/* 1171 */     public CvMeanShiftTracker(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams);
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public native opencv_contrib.CvMeanShiftTrackerParams params();
/*      */ 
/*      */     public native void newTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvBox2D updateTrackingWindow(@opencv_core.InputMat opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.IplImage getHistogramProjection(int paramInt);
/*      */ 
/*      */     public native void setTrackingWindow(@ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect getTrackingWindow();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvBox2D getTrackingEllipse();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f getTrackingCenter();
/*      */ 
/*      */     static
/*      */     {
/* 1166 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvHybridTrackerParams extends Pointer
/*      */   {
/*      */     public CvHybridTrackerParams()
/*      */     {
/* 1141 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvHybridTrackerParams(float ft_tracker_weight, float ms_tracker_weight, @ByVal opencv_contrib.CvFeatureTrackerParams ft_params, @ByVal opencv_contrib.CvMeanShiftTrackerParams ms_params, @ByVal opencv_contrib.CvMotionModel model)
/*      */     {
/* 1146 */       allocate(ft_tracker_weight, ms_tracker_weight, ft_params, ms_params, model);
/*      */     }
/* 1148 */     public CvHybridTrackerParams(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, @ByVal opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams, @ByVal opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams, @ByVal opencv_contrib.CvMotionModel paramCvMotionModel);
/*      */ 
/*      */     public native float ft_tracker_weight();
/*      */ 
/*      */     public native CvHybridTrackerParams ft_tracker_weight(float paramFloat);
/*      */ 
/*      */     public native float ms_tracker_weight();
/*      */ 
/*      */     public native CvHybridTrackerParams ms_tracker_weight(float paramFloat);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_contrib.CvFeatureTrackerParams ft_params();
/*      */ 
/*      */     public native CvHybridTrackerParams ft_params(opencv_contrib.CvFeatureTrackerParams paramCvFeatureTrackerParams);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_contrib.CvMeanShiftTrackerParams ms_params();
/*      */ 
/*      */     public native CvHybridTrackerParams ms_params(opencv_contrib.CvMeanShiftTrackerParams paramCvMeanShiftTrackerParams);
/*      */ 
/*      */     public native int motion_model();
/*      */ 
/*      */     public native CvHybridTrackerParams motion_model(int paramInt);
/*      */ 
/*      */     public native float low_pass_gain();
/*      */ 
/*      */     public native CvHybridTrackerParams low_pass_gain(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 1140 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvFeatureTrackerParams extends Pointer
/*      */   {
/*      */     public static final int SIFT = 0;
/*      */     public static final int SURF = 1;
/*      */     public static final int OPTICAL_FLOW = 2;
/*      */ 
/*      */     public CvFeatureTrackerParams()
/*      */     {
/* 1125 */       allocate();
/*      */     }
/* 1127 */     public CvFeatureTrackerParams(int feature_type, int window_size) { allocate(feature_type, window_size); } 
/*      */     public CvFeatureTrackerParams(Pointer p) {
/* 1129 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int feature_type();
/*      */ 
/*      */     public native CvFeatureTrackerParams feature_type(int paramInt);
/*      */ 
/*      */     public native int window_size();
/*      */ 
/*      */     public native CvFeatureTrackerParams window_size(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1124 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvMeanShiftTrackerParams extends Pointer
/*      */   {
/*      */     public static final int H = 0;
/*      */     public static final int HS = 1;
/*      */     public static final int HSV = 2;
/*      */ 
/*      */     public CvMeanShiftTrackerParams()
/*      */     {
/* 1104 */       allocate();
/*      */     }
/* 1106 */     public CvMeanShiftTrackerParams(int tracking_type, @ByVal opencv_core.CvTermCriteria term_crit) { allocate(tracking_type, term_crit); } 
/*      */     public CvMeanShiftTrackerParams(Pointer p) {
/* 1108 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     public native int tracking_type();
/*      */ 
/*      */     public native CvMeanShiftTrackerParams tracking_type(int paramInt);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native FloatPointer h_range();
/*      */ 
/*      */     public native CvMeanShiftTrackerParams h_range(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native FloatPointer s_range();
/*      */ 
/*      */     public native CvMeanShiftTrackerParams s_range(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native FloatPointer v_range();
/*      */ 
/*      */     public native CvMeanShiftTrackerParams v_range(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvTermCriteria term_crit();
/*      */ 
/*      */     public native CvMeanShiftTrackerParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     static
/*      */     {
/* 1103 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class CvMotionModel extends Pointer
/*      */   {
/*      */     public static final int LOW_PASS_FILTER = 0;
/*      */     public static final int KALMAN_FILTER = 1;
/*      */     public static final int EM = 2;
/*      */ 
/*      */     public CvMotionModel()
/*      */     {
/* 1093 */       allocate(); } 
/* 1094 */     public CvMotionModel(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native float low_pass_gain();
/*      */ 
/*      */     public native CvMotionModel low_pass_gain(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 1092 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform({"linux", "macosx", "android"})
/*      */   public static class DetectionBasedTracker extends Pointer
/*      */   {
/*      */     public DetectionBasedTracker(String cascadeFilename, @ByRef Parameters params)
/*      */     {
/* 1007 */       allocate(cascadeFilename, params);
/*      */     }
/* 1009 */     public DetectionBasedTracker(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(String paramString, @ByRef Parameters paramParameters);
/*      */ 
/*      */     public native boolean run();
/*      */ 
/*      */     public native void stop();
/*      */ 
/*      */     public native void resetTracking();
/*      */ 
/*      */     public native void process(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native boolean setParameters(@ByRef Parameters paramParameters);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native Parameters getParameters();
/*      */ 
/*      */     public native void getObjects(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native void getObjects(@ByRef opencv_contrib.RectIntPairVector paramRectIntPairVector);
/*      */ 
/*      */     static
/*      */     {
/* 1005 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @NoOffset
/*      */     public static class Parameters extends Pointer
/*      */     {
/*      */       public Parameters()
/*      */       {
/* 1014 */         allocate(); } 
/* 1015 */       public Parameters(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int minObjectSize();
/*      */ 
/*      */       public native Parameters minObjectSize(int paramInt);
/*      */ 
/*      */       public native int maxObjectSize();
/*      */ 
/*      */       public native Parameters maxObjectSize(int paramInt);
/*      */ 
/*      */       public native double scaleFactor();
/*      */ 
/*      */       public native Parameters scaleFactor(double paramDouble);
/*      */ 
/*      */       public native int maxTrackLifetime();
/*      */ 
/*      */       public native Parameters maxTrackLifetime(int paramInt);
/*      */ 
/*      */       public native int minNeighbors();
/*      */ 
/*      */       public native Parameters minNeighbors(int paramInt);
/*      */ 
/*      */       public native int minDetectionPeriod();
/*      */ 
/*      */       public native Parameters minDetectionPeriod(int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 1013 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::pair<cv::Rect, int> >"})
/*      */   public static class RectIntPairVector extends Pointer
/*      */   {
/*      */     public RectIntPairVector()
/*      */     {
/*  992 */       allocate(); } 
/*  993 */     public RectIntPairVector(long n) { allocate(n); } 
/*  994 */     public RectIntPairVector(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(long paramLong);
/*      */ 
/*      */     @Const
/*      */     @Adapter("RectAdapter")
/*      */     @Index
/*      */     public native opencv_core.CvRect first(long paramLong);
/*      */ 
/*      */     public native RectIntPairVector first(long paramLong, opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @Index
/*      */     public native int second(long paramLong);
/*      */ 
/*      */     public native RectIntPairVector second(long paramLong, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  991 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Retina extends Pointer
/*      */   {
/*      */     public Retina(@ByVal opencv_core.CvSize inputSize)
/*      */     {
/*  894 */       allocate(inputSize);
/*      */     }
/*      */ 
/*      */     public Retina(@ByVal opencv_core.CvSize inputSize, boolean colorMode, @Cast({"cv::RETINA_COLORSAMPLINGMETHOD"}) int colorSamplingMethod, boolean useRetinaLogSampling, double reductionFactor, double samplingStrenght)
/*      */     {
/*  899 */       allocate(inputSize, colorMode, colorSamplingMethod, useRetinaLogSampling, reductionFactor, samplingStrenght);
/*      */     }
/*  901 */     public Retina(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, @Cast({"bool"}) boolean paramBoolean1, @Cast({"cv::RETINA_COLORSAMPLINGMETHOD"}) int paramInt, @Cast({"bool"}) boolean paramBoolean2, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize inputSize();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize outputSize();
/*      */ 
/*      */     public native void setup(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void setup(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void setup(@ByVal RetinaParameters paramRetinaParameters);
/*      */ 
/*      */     @ByVal
/*      */     public native RetinaParameters getParameters();
/*      */ 
/*      */     @ByRef
/*      */     public native String printSetup();
/*      */ 
/*      */     public native void write(String paramString);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void setupOPLandIPLParvoChannel(@Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
/*      */ 
/*      */     public native void setupIPLMagnoChannel(@Cast({"bool"}) boolean paramBoolean, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
/*      */ 
/*      */     public native void run(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void getParvo(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void getMagno(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void setColorSaturation(@Cast({"bool"}) boolean paramBoolean, float paramFloat);
/*      */ 
/*      */     public native void clearBuffers();
/*      */ 
/*      */     public native void activateMovingContoursProcessing(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void activateContoursProcessing(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  892 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @NoOffset
/*      */     public static class RetinaParameters extends Pointer
/*      */     {
/*      */       public RetinaParameters()
/*      */       {
/*  909 */         allocate(); } 
/*  910 */       public RetinaParameters(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @MemberGetter
/*      */       @ByRef
/*      */       public native OPLandIplParvoParameters OPLandIplParvo();
/*      */ 
/*      */       @MemberGetter
/*      */       @ByRef
/*      */       public native IplMagnoParameters IplMagno();
/*      */ 
/*      */       static
/*      */       {
/*  908 */         Loader.load();
/*      */       }
/*      */ 
/*      */       @NoOffset
/*      */       public static class IplMagnoParameters extends Pointer
/*      */       {
/*      */         public IplMagnoParameters()
/*      */         {
/*  931 */           allocate(); } 
/*  932 */         public IplMagnoParameters(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */         private native void allocate();
/*      */ 
/*      */         public native boolean normaliseOutput();
/*      */ 
/*      */         public native IplMagnoParameters normaliseOutput(boolean paramBoolean);
/*      */ 
/*      */         public native float parasolCells_beta();
/*      */ 
/*      */         public native IplMagnoParameters parasolCells_beta(float paramFloat);
/*      */ 
/*      */         public native float parasolCells_tau();
/*      */ 
/*      */         public native IplMagnoParameters parasolCells_tau(float paramFloat);
/*      */ 
/*      */         public native float parasolCells_k();
/*      */ 
/*      */         public native IplMagnoParameters parasolCells_k(float paramFloat);
/*      */ 
/*      */         public native float amacrinCellsTemporalCutFrequency();
/*      */ 
/*      */         public native IplMagnoParameters amacrinCellsTemporalCutFrequency(float paramFloat);
/*      */ 
/*      */         public native float V0CompressionParameter();
/*      */ 
/*      */         public native IplMagnoParameters V0CompressionParameter(float paramFloat);
/*      */ 
/*      */         public native float localAdaptintegration_tau();
/*      */ 
/*      */         public native IplMagnoParameters localAdaptintegration_tau(float paramFloat);
/*      */ 
/*      */         public native float localAdaptintegration_k();
/*      */ 
/*      */         public native IplMagnoParameters localAdaptintegration_k(float paramFloat);
/*      */ 
/*      */         static
/*      */         {
/*  930 */           Loader.load();
/*      */         }
/*      */       }
/*      */ 
/*      */       @NoOffset
/*      */       public static class OPLandIplParvoParameters extends Pointer
/*      */       {
/*      */         public OPLandIplParvoParameters()
/*      */         {
/*  915 */           allocate(); } 
/*  916 */         public OPLandIplParvoParameters(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */         private native void allocate();
/*      */ 
/*      */         public native boolean colorMode();
/*      */ 
/*      */         public native OPLandIplParvoParameters colorMode(boolean paramBoolean);
/*      */ 
/*      */         public native boolean normaliseOutput();
/*      */ 
/*      */         public native OPLandIplParvoParameters normaliseOutput(boolean paramBoolean);
/*      */ 
/*      */         public native float photoreceptorsLocalAdaptationSensitivity();
/*      */ 
/*      */         public native OPLandIplParvoParameters photoreceptorsLocalAdaptationSensitivity(float paramFloat);
/*      */ 
/*      */         public native float photoreceptorsTemporalConstant();
/*      */ 
/*      */         public native OPLandIplParvoParameters photoreceptorsTemporalConstant(float paramFloat);
/*      */ 
/*      */         public native float photoreceptorsSpatialConstant();
/*      */ 
/*      */         public native OPLandIplParvoParameters photoreceptorsSpatialConstant(float paramFloat);
/*      */ 
/*      */         public native float horizontalCellsGain();
/*      */ 
/*      */         public native OPLandIplParvoParameters horizontalCellsGain(float paramFloat);
/*      */ 
/*      */         public native float hcellsTemporalConstant();
/*      */ 
/*      */         public native OPLandIplParvoParameters hcellsTemporalConstant(float paramFloat);
/*      */ 
/*      */         public native float hcellsSpatialConstant();
/*      */ 
/*      */         public native OPLandIplParvoParameters hcellsSpatialConstant(float paramFloat);
/*      */ 
/*      */         public native float ganglionCellsSensitivity();
/*      */ 
/*      */         public native OPLandIplParvoParameters ganglionCellsSensitivity(float paramFloat);
/*      */ 
/*      */         static
/*      */         {
/*  914 */           Loader.load();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FaceRecognizer extends opencv_core.Algorithm
/*      */   {
/*      */     public FaceRecognizer()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FaceRecognizer(Pointer p)
/*      */     {
/*  843 */       super();
/*      */     }
/*      */ 
/*      */     public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt);
/*      */ 
/*      */     public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void train(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer);
/*      */ 
/*      */     public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt);
/*      */ 
/*      */     public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void update(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer);
/*      */ 
/*      */     public native int predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef int[] paramArrayOfInt, @ByRef double[] paramArrayOfDouble);
/*      */ 
/*      */     public native void save(String paramString);
/*      */ 
/*      */     public native void load(String paramString);
/*      */ 
/*      */     public native void save(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void load(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     static
/*      */     {
/*  841 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class LDA extends Pointer
/*      */   {
/*      */     public LDA()
/*      */     {
/*  805 */       allocate(); } 
/*  806 */     public LDA(int num_components) { allocate(num_components); } 
/*  807 */     public LDA(opencv_core.MatVector src, int[] labels, int num_components) { allocate(src, labels, num_components); } 
/*  808 */     public LDA(opencv_core.MatVector src, opencv_core.CvArr labels, int num_components) { allocate(src, labels, num_components); } 
/*  809 */     public LDA(opencv_core.MatVector src, IntPointer labels, int num_components) { allocate(src, labels, num_components); } 
/*  810 */     public LDA(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray int[] paramArrayOfInt, int paramInt);
/*      */ 
/*      */     private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt);
/*      */ 
/*      */     private native void allocate(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray IntPointer paramIntPointer, int paramInt);
/*      */ 
/*      */     public native void save(String paramString);
/*      */ 
/*      */     public native void load(String paramString);
/*      */ 
/*      */     public native void save(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void load(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.InputArray int[] paramArrayOfInt);
/*      */ 
/*      */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.InputArray IntPointer paramIntPointer);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat project(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat reconstruct(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat eigenvectors();
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat eigenvalues();
/*      */ 
/*      */     static
/*      */     {
/*  804 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class LogPolar_Adjacent extends Pointer
/*      */   {
/*      */     public LogPolar_Adjacent()
/*      */     {
/*  755 */       allocate();
/*      */     }
/*      */     public LogPolar_Adjacent(int w, int h, @ByVal opencv_core.CvPoint center, int R, double ro0, double smin, int full, int S, int sp) {
/*  758 */       allocate(w, h, center, R, ro0, smin, full, S, sp);
/*      */     }
/*  760 */     public LogPolar_Adjacent(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, int paramInt5, int paramInt6);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/*  754 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class LogPolar_Overlapping extends Pointer
/*      */   {
/*      */     public LogPolar_Overlapping()
/*      */     {
/*  693 */       allocate();
/*      */     }
/*      */     public LogPolar_Overlapping(int w, int h, @ByVal opencv_core.CvPoint center, int R, double ro0, int full, int S, int sp) {
/*  696 */       allocate(w, h, center, R, ro0, full, S, sp);
/*      */     }
/*  698 */     public LogPolar_Overlapping(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/*  692 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class LogPolar_Interp extends Pointer
/*      */   {
/*      */     public LogPolar_Interp()
/*      */     {
/*  655 */       allocate();
/*      */     }
/*      */     public LogPolar_Interp(int w, int h, @ByVal opencv_core.CvPoint center, int R, double ro0, int interp, int full, int S, int sp) {
/*  658 */       allocate(w, h, center, R, ro0, interp, full, S, sp);
/*      */     }
/*  660 */     public LogPolar_Interp(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cortical(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat to_cartesian(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/*  654 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Directory extends Pointer
/*      */   {
/*      */     public Directory()
/*      */     {
/*  628 */       allocate(); } 
/*  629 */     public Directory(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @ByVal
/*      */     public static native opencv_core.StringVector GetListFiles(String paramString1, String paramString2, boolean paramBoolean);
/*      */ 
/*      */     @ByVal
/*      */     public static native opencv_core.StringVector GetListFilesR(String paramString1, String paramString2, boolean paramBoolean);
/*      */ 
/*      */     @ByVal
/*      */     public static native opencv_core.StringVector GetListFolders(String paramString1, String paramString2, boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  627 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class StereoVar extends Pointer
/*      */   {
/*      */     public static final int USE_INITIAL_DISPARITY = 1;
/*      */     public static final int USE_EQUALIZE_HIST = 2;
/*      */     public static final int USE_SMART_ID = 4;
/*      */     public static final int USE_AUTO_PARAMS = 8;
/*      */     public static final int USE_MEDIAN_FILTERING = 16;
/*      */     public static final int CYCLE_O = 0;
/*      */     public static final int CYCLE_V = 1;
/*      */     public static final int PENALIZATION_TICHONOV = 0;
/*      */     public static final int PENALIZATION_CHARBONNIER = 1;
/*      */     public static final int PENALIZATION_PERONA_MALIK = 2;
/*      */ 
/*      */     public StereoVar()
/*      */     {
/*  591 */       allocate();
/*      */     }
/*      */     public StereoVar(int levels, double pyrScale, int nIt, int minDisp, int maxDisp, int poly_n, double poly_sigma, float fi, float lambda, int penalization, int cycle, int flags) {
/*  594 */       allocate(levels, pyrScale, nIt, minDisp, maxDisp, poly_n, poly_sigma, fi, lambda, penalization, cycle, flags);
/*      */     }
/*  596 */     public StereoVar(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, double paramDouble1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble2, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */     public native int levels();
/*      */ 
/*      */     public native StereoVar levels(int paramInt);
/*      */ 
/*      */     public native double pyrScale();
/*      */ 
/*      */     public native StereoVar pyrScale(double paramDouble);
/*      */ 
/*      */     public native int nIt();
/*      */ 
/*      */     public native StereoVar nIt(int paramInt);
/*      */ 
/*      */     public native int minDisp();
/*      */ 
/*      */     public native StereoVar minDisp(int paramInt);
/*      */ 
/*      */     public native int maxDisp();
/*      */ 
/*      */     public native StereoVar maxDisp(int paramInt);
/*      */ 
/*      */     public native int poly_n();
/*      */ 
/*      */     public native StereoVar poly_n(int paramInt);
/*      */ 
/*      */     public native double poly_sigma();
/*      */ 
/*      */     public native StereoVar poly_sigma(double paramDouble);
/*      */ 
/*      */     public native float fi();
/*      */ 
/*      */     public native StereoVar fi(float paramFloat);
/*      */ 
/*      */     public native float lambda();
/*      */ 
/*      */     public native StereoVar lambda(float paramFloat);
/*      */ 
/*      */     public native int penalization();
/*      */ 
/*      */     public native StereoVar penalization(int paramInt);
/*      */ 
/*      */     public native int cycle();
/*      */ 
/*      */     public native StereoVar cycle(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native StereoVar flags(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  590 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class SelfSimDescriptor extends Pointer
/*      */   {
/*      */     public static final int DEFAULT_SMALL_SIZE = 5;
/*      */     public static final int DEFAULT_LARGE_SIZE = 41;
/*      */     public static final int DEFAULT_NUM_ANGLES = 20;
/*      */     public static final int DEFAULT_START_DISTANCE_BUCKET = 3;
/*      */     public static final int DEFAULT_NUM_DISTANCE_BUCKETS = 7;
/*      */ 
/*      */     public SelfSimDescriptor()
/*      */     {
/*  430 */       allocate();
/*      */     }
/*      */ 
/*      */     public SelfSimDescriptor(int _ssize, int _lsize, int _startDistanceBucket, int _numberOfDistanceBuckets, int _nangles)
/*      */     {
/*  435 */       allocate(_ssize, _lsize, _startDistanceBucket, _numberOfDistanceBuckets, _nangles);
/*      */     }
/*  437 */     public SelfSimDescriptor(@ByRef SelfSimDescriptor ss) { allocate(ss); } 
/*  438 */     public SelfSimDescriptor(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */     private native void allocate(@ByRef SelfSimDescriptor paramSelfSimDescriptor);
/*      */ 
/*      */     @Name({"operator="})
/*      */     @ByRef
/*      */     public native SelfSimDescriptor put(@ByRef SelfSimDescriptor paramSelfSimDescriptor);
/*      */ 
/*      */     public native long getDescriptorSize();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize getGridSize(@ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
/*      */ 
/*      */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native void computeLogPolarMapping(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native void SSD(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvPoint paramCvPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native int smallSize();
/*      */ 
/*      */     public native SelfSimDescriptor smallSize(int paramInt);
/*      */ 
/*      */     public native int largeSize();
/*      */ 
/*      */     public native SelfSimDescriptor largeSize(int paramInt);
/*      */ 
/*      */     public native int startDistanceBucket();
/*      */ 
/*      */     public native SelfSimDescriptor startDistanceBucket(int paramInt);
/*      */ 
/*      */     public native int numberOfDistanceBuckets();
/*      */ 
/*      */     public native SelfSimDescriptor numberOfDistanceBuckets(int paramInt);
/*      */ 
/*      */     public native int numberOfAngles();
/*      */ 
/*      */     public native SelfSimDescriptor numberOfAngles(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  429 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class TickMeter extends Pointer
/*      */   {
/*      */     public TickMeter()
/*      */     {
/*  409 */       allocate(); } 
/*  410 */     public TickMeter(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void start();
/*      */ 
/*      */     public native void stop();
/*      */ 
/*      */     public native long getTimeTicks();
/*      */ 
/*      */     public native double getTimeMicro();
/*      */ 
/*      */     public native double getTimeMilli();
/*      */ 
/*      */     public native double getTimeSec();
/*      */ 
/*      */     public native long getCounter();
/*      */ 
/*      */     public native void reset();
/*      */ 
/*      */     static
/*      */     {
/*  408 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class SpinImageModel extends Pointer
/*      */   {
/*      */     public SpinImageModel()
/*      */     {
/*  345 */       allocate(); } 
/*  346 */     public SpinImageModel(opencv_contrib.Mesh3D mesh) { allocate(mesh); } 
/*  347 */     public SpinImageModel(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef opencv_contrib.Mesh3D paramMesh3D);
/*      */ 
/*      */     public native float normalRadius();
/*      */ 
/*      */     public native SpinImageModel normalRadius(float paramFloat);
/*      */ 
/*      */     public native int minNeighbors();
/*      */ 
/*      */     public native SpinImageModel minNeighbors(int paramInt);
/*      */ 
/*      */     public native float binSize();
/*      */ 
/*      */     public native SpinImageModel binSize(float paramFloat);
/*      */ 
/*      */     public native int imageWidth();
/*      */ 
/*      */     public native SpinImageModel imageWidth(int paramInt);
/*      */ 
/*      */     public native float lambda();
/*      */ 
/*      */     public native SpinImageModel lambda(float paramFloat);
/*      */ 
/*      */     public native float gamma();
/*      */ 
/*      */     public native SpinImageModel gamma(float paramFloat);
/*      */ 
/*      */     public native float T_GeometriccConsistency();
/*      */ 
/*      */     public native SpinImageModel T_GeometriccConsistency(float paramFloat);
/*      */ 
/*      */     public native float T_GroupingCorespondances();
/*      */ 
/*      */     public native SpinImageModel T_GroupingCorespondances(float paramFloat);
/*      */ 
/*      */     public native void setLogger(@Cast({"std::ostream*"}) Pointer paramPointer);
/*      */ 
/*      */     public native void selectRandomSubset(float paramFloat);
/*      */ 
/*      */     public native void setSubset(@Const @StdVector int[] paramArrayOfInt);
/*      */ 
/*      */     public native void compute();
/*      */ 
/*      */     public native void match(@ByRef SpinImageModel paramSpinImageModel, @ByRef opencv_contrib.Vec2iVectorVector paramVec2iVectorVector);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.IplImage packRandomScaledSpins(@Cast({"bool"}) boolean paramBoolean, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native long getSpinCount();
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.IplImage getSpinImage(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint3D32f getSpinVertex(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint3D32f getSpinNormal(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_contrib.Mesh3D getMesh();
/*      */ 
/*      */     public static native boolean spinCorrelation(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, float paramFloat, @ByRef float[] paramArrayOfFloat);
/*      */ 
/*      */     static
/*      */     {
/*  344 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::Vec2i> >"})
/*      */   public static class Vec2iVectorVector extends Pointer
/*      */   {
/*      */     public Vec2iVectorVector()
/*      */     {
/*  328 */       allocate(); } 
/*  329 */     public Vec2iVectorVector(long n) { allocate(n); } 
/*  330 */     public Vec2iVectorVector(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     public native long size();
/*      */ 
/*      */     public native void resize(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     public native long size(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     public native void resize(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     @Index
/*      */     @ValueGetter
/*      */     @ByVal
/*      */     public native opencv_core.CvScalar get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     static
/*      */     {
/*  327 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class Mesh3D extends Pointer
/*      */   {
/*      */     public Mesh3D()
/*      */     {
/*  295 */       allocate(); } 
/*  296 */     public Mesh3D(@ByVal opencv_core.CvPoint3D32f vtx) { allocate(vtx); } 
/*  297 */     public Mesh3D(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f);
/*      */ 
/*      */     public native void buildOctree();
/*      */ 
/*      */     public native void clearOctree();
/*      */ 
/*      */     public native float estimateResolution(float paramFloat);
/*      */ 
/*      */     public native void computeNormals(float paramFloat, int paramInt);
/*      */ 
/*      */     public native void computeNormals(@Const @StdVector int[] paramArrayOfInt, float paramFloat, int paramInt);
/*      */ 
/*      */     public native void writeAsVrml(String paramString, @Const @StdVector("CvScalar, cv::Scalar") opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     @StdVector("CvPoint3D32f,cv::Point3f")
/*      */     public native opencv_core.CvPoint3D32f vtx();
/*      */ 
/*      */     public native Mesh3D vtx(@Const opencv_core.CvPoint3D32f paramCvPoint3D32f);
/*      */ 
/*      */     @StdVector("CvPoint3D32f,cv::Point3f")
/*      */     public native opencv_core.CvPoint3D32f normals();
/*      */ 
/*      */     public native Mesh3D normals(@Const opencv_core.CvPoint3D32f paramCvPoint3D32f);
/*      */ 
/*      */     public native float resolution();
/*      */ 
/*      */     public native Mesh3D resolution(float paramFloat);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_contrib.Octree octree();
/*      */ 
/*      */     public native Mesh3D octree(opencv_contrib.Octree paramOctree);
/*      */ 
/*      */     static
/*      */     {
/*  294 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @Opaque
/*      */     public static class EmptyMeshException extends Pointer
/*      */     {
/*      */       public EmptyMeshException() {
/*      */       }
/*      */ 
/*      */       public EmptyMeshException(Pointer p) {
/*  304 */         super();
/*      */       }
/*      */ 
/*      */       static
/*      */       {
/*  302 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Octree extends Pointer
/*      */   {
/*      */     public Octree()
/*      */     {
/*  277 */       allocate();
/*      */     }
/*  279 */     public Octree(opencv_core.CvPoint3D32f points, int maxLevels, int minPoints) { allocate(points, maxLevels, minPoints); } 
/*      */     public Octree(Pointer p) {
/*  281 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void buildTree(@Const @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void getPointsWithinSphere(@ByVal opencv_core.CvPoint3D32f paramCvPoint3D32f1, float paramFloat, @StdVector("CvPoint3D32f,cv::Point3f") opencv_core.CvPoint3D32f paramCvPoint3D32f2);
/*      */ 
/*      */     @StdVector
/*      */     public native Node getNodes();
/*      */ 
/*      */     static
/*      */     {
/*  251 */       Loader.load();
/*      */     }
/*  254 */     @NoOffset
/*      */     public static class Node extends Pointer { public Node() { allocate(); } 
/*  255 */       public Node(int size) { allocateArray(size); } 
/*  256 */       public Node(Pointer p) { super(); } 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocateArray(int paramInt);
/*      */ 
/*  261 */       public Node position(int position) { return (Node)super.position(position); }
/*      */ 
/*      */ 
/*      */       public native int begin();
/*      */ 
/*      */       public native Node begin(int paramInt);
/*      */ 
/*      */       public native int end();
/*      */ 
/*      */       public native Node end(int paramInt);
/*      */ 
/*      */       public native float x_min();
/*      */ 
/*      */       public native Node x_min(float paramFloat);
/*      */ 
/*      */       public native float x_max();
/*      */ 
/*      */       public native Node x_max(float paramFloat);
/*      */ 
/*      */       public native float y_min();
/*      */ 
/*      */       public native Node y_min(float paramFloat);
/*      */ 
/*      */       public native float y_max();
/*      */ 
/*      */       public native Node y_max(float paramFloat);
/*      */ 
/*      */       public native float z_min();
/*      */ 
/*      */       public native Node z_min(float paramFloat);
/*      */ 
/*      */       public native float z_max();
/*      */ 
/*      */       public native Node z_max(float paramFloat);
/*      */ 
/*      */       public native int maxLevels();
/*      */ 
/*      */       public native Node maxLevels(int paramInt);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean isLeaf();
/*      */ 
/*      */       public native Node isLeaf(boolean paramBoolean);
/*      */ 
/*      */       public native int children(int paramInt);
/*      */ 
/*      */       public native Node children(int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/*  253 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvFuzzyMeanShiftTracker extends Pointer
/*      */   {
/*      */     public static final int tsNone = 0;
/*      */     public static final int tsSearching = 1;
/*      */     public static final int tsTracking = 2;
/*      */     public static final int tsSetWindow = 3;
/*      */     public static final int tsDisabled = 10;
/*      */     public static final int rmEdgeDensityLinear = 0;
/*      */     public static final int rmEdgeDensityFuzzy = 1;
/*      */     public static final int rmInnerDensity = 2;
/*      */     public static final int MinKernelMass = 1000;
/*      */ 
/*      */     public CvFuzzyMeanShiftTracker()
/*      */     {
/*  216 */       allocate(); } 
/*  217 */     public CvFuzzyMeanShiftTracker(int size) { allocateArray(size); } 
/*  218 */     public CvFuzzyMeanShiftTracker(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  223 */     public CvFuzzyMeanShiftTracker position(int position) { return (CvFuzzyMeanShiftTracker)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public native Pointer kernel();
/*      */ 
/*      */     public native int searchMode();
/*      */ 
/*      */     public native CvFuzzyMeanShiftTracker searchMode(int paramInt);
/*      */ 
/*      */     public native void track(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  215 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFuzzyController extends Pointer
/*      */   {
/*      */     public CvFuzzyController()
/*      */     {
/*  200 */       allocate(); } 
/*  201 */     public CvFuzzyController(int size) { allocateArray(size); } 
/*  202 */     public CvFuzzyController(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  207 */     public CvFuzzyController position(int position) { return (CvFuzzyController)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void addRule(opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve1, opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve2, opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve3);
/*      */ 
/*      */     public native double calcOutput(double paramDouble1, double paramDouble2);
/*      */ 
/*      */     static
/*      */     {
/*  199 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFuzzyRule extends Pointer
/*      */   {
/*      */     public CvFuzzyRule()
/*      */     {
/*  183 */       allocate(); } 
/*  184 */     public CvFuzzyRule(int size) { allocateArray(size); } 
/*  185 */     public CvFuzzyRule(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  190 */     public CvFuzzyRule position(int position) { return (CvFuzzyRule)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void setRule(opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve1, opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve2, opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve3);
/*      */ 
/*      */     public native double calcValue(double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native opencv_contrib.CvFuzzyCurve getOutputCurve();
/*      */ 
/*      */     static
/*      */     {
/*  182 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFuzzyFunction extends Pointer
/*      */   {
/*      */     public CvFuzzyFunction()
/*      */     {
/*  162 */       allocate(); } 
/*  163 */     public CvFuzzyFunction(int size) { allocateArray(size); } 
/*  164 */     public CvFuzzyFunction(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  169 */     public CvFuzzyFunction position(int position) { return (CvFuzzyFunction)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void addCurve(opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve, double paramDouble);
/*      */ 
/*      */     public native void resetValues();
/*      */ 
/*      */     public native double calcValue();
/*      */ 
/*      */     public native opencv_contrib.CvFuzzyCurve newCurve();
/*      */ 
/*      */     @NoOffset
/*      */     @Const
/*      */     @StdVector
/*      */     public native opencv_contrib.CvFuzzyCurve curves();
/*      */ 
/*      */     public native CvFuzzyFunction curves(opencv_contrib.CvFuzzyCurve paramCvFuzzyCurve);
/*      */ 
/*      */     static
/*      */     {
/*  161 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFuzzyCurve extends Pointer
/*      */   {
/*      */     public CvFuzzyCurve()
/*      */     {
/*  141 */       allocate(); } 
/*  142 */     public CvFuzzyCurve(int size) { allocateArray(size); } 
/*  143 */     public CvFuzzyCurve(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  148 */     public CvFuzzyCurve position(int position) { return (CvFuzzyCurve)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void setCentre(double paramDouble);
/*      */ 
/*      */     public native double getCentre();
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native void addPoint(double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native double calcValue(double paramDouble);
/*      */ 
/*      */     public native double getValue();
/*      */ 
/*      */     public native void setValue(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  140 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvFuzzyPoint extends Pointer
/*      */   {
/*      */     public CvFuzzyPoint()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFuzzyPoint(double _x, double _y)
/*      */     {
/*  130 */       allocate(_x, _y); } 
/*  131 */     public CvFuzzyPoint(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native double x();
/*      */ 
/*      */     public native CvFuzzyPoint x(double paramDouble);
/*      */ 
/*      */     public native double y();
/*      */ 
/*      */     public native CvFuzzyPoint y(double paramDouble);
/*      */ 
/*      */     public native double value();
/*      */ 
/*      */     public native CvFuzzyPoint value(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  128 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvAdaptiveSkinDetector extends Pointer
/*      */   {
/*      */     public static final int MORPHING_METHOD_NONE = 0;
/*      */     public static final int MORPHING_METHOD_ERODE = 1;
/*      */     public static final int MORPHING_METHOD_ERODE_ERODE = 2;
/*      */     public static final int MORPHING_METHOD_ERODE_DILATE = 3;
/*      */ 
/*      */     public CvAdaptiveSkinDetector()
/*      */     {
/*  106 */       allocate();
/*      */     }
/*  108 */     public CvAdaptiveSkinDetector(int samplingDivider, int morphingMethod) { allocate(samplingDivider, morphingMethod); } 
/*      */     public CvAdaptiveSkinDetector(Pointer p) {
/*  110 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     static
/*      */     {
/*  105 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_contrib
 * JD-Core Version:    0.6.2
 */