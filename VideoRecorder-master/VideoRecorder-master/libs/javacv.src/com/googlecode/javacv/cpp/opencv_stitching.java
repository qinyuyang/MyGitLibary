/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.annotation.Adapter;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.Index;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Platform;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ 
/*      */ @Properties(inherit={opencv_calib3d.class, opencv_features2d.class, opencv_objdetect.class, opencv_nonfree.class, opencv_photo.class, opencv_ml.class, opencv_legacy.class, opencv_video.class}, value={@Platform(include={"<opencv2/stitching/stitcher.hpp>", "<opencv2/stitching/detail/autocalib.hpp>"}, link={"opencv_stitching@.2.4", "opencv_gpu@.2.4"}), @Platform(value={"windows"}, link={"opencv_stitching248", "opencv_gpu248"}), @Platform(value={"android"}, link={"opencv_stitching"})})
/*      */ public class opencv_stitching
/*      */ {
/*      */   public static final int WAVE_CORRECT_HORIZ = 0;
/*      */   public static final int WAVE_CORRECT_VERT = 1;
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void focalsFromHomography(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2, @ByRef @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @ByRef @Cast({"bool*"}) boolean[] paramArrayOfBoolean2);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void estimateFocal(@Const @StdVector ImageFeatures paramImageFeatures, @Const @StdVector MatchesInfo paramMatchesInfo, @Const @StdVector double[] paramArrayOfDouble);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @Cast({"bool"})
/*      */   public static native boolean calibrateRotatingCamera(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @Cast({"bool"})
/*      */   public static native boolean overlapRoi(@ByVal opencv_core.CvPoint paramCvPoint1, @ByVal opencv_core.CvPoint paramCvPoint2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @Adapter("RectAdapter") opencv_core.CvRect paramCvRect);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @ByVal
/*      */   public static native opencv_core.CvRect resultRoi(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @ByVal
/*      */   public static native opencv_core.CvRect resultRoi(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @Const @StdVector("CvSize,cv::Size") opencv_core.CvSize paramCvSize);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @ByVal
/*      */   public static native opencv_core.CvPoint resultTl(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void selectRandomSubset(int paramInt1, int paramInt2, @Const @StdVector int[] paramArrayOfInt);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @ByRef
/*      */   public static native IntPointer stitchingLogLevel();
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void waveCorrect(@ByRef opencv_core.MatVector paramMatVector, @Cast({"cv::detail::WaveCorrectKind"}) int paramInt);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @ByRef
/*      */   public static native String matchesGraphAsString(@ByRef opencv_core.StringVector paramStringVector, @Const @StdVector MatchesInfo paramMatchesInfo, float paramFloat);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   @StdVector
/*      */   public static native IntPointer leaveBiggestComponent(@Const @StdVector ImageFeatures paramImageFeatures, @Const @StdVector MatchesInfo paramMatchesInfo, float paramFloat);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void findMaxSpanningTree(int paramInt, @Const @StdVector MatchesInfo paramMatchesInfo, @ByRef Graph paramGraph, @Const @StdVector int[] paramArrayOfInt);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void normalizeUsingWeightMap(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void createWeightMap(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void createLaplacePyr(@opencv_core.InputMat opencv_core.CvArr paramCvArr, int paramInt, @ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void createLaplacePyrGpu(@opencv_core.InputMat opencv_core.CvArr paramCvArr, int paramInt, @ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void restoreImageFromLaplacePyr(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static native void restoreImageFromLaplacePyrGpu(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */   static
/*      */   {
/*   92 */     Loader.load();
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Stitcher extends Pointer
/*      */   {
/*      */     public static final int ORIG_RESOL = -1;
/*      */     public static final int OK = 0;
/*      */     public static final int ERR_NEED_MORE_IMGS = 1;
/*      */ 
/*      */     public Stitcher()
/*      */     {
/*      */     }
/*      */ 
/*      */     public Stitcher(Pointer p)
/*      */     {
/* 1167 */       super();
/*      */     }
/*      */ 
/*      */     @ByVal
/*      */     public static native Stitcher createDefault(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native double registrationResol();
/*      */ 
/*      */     public native void setRegistrationResol(double paramDouble);
/*      */ 
/*      */     public native double seamEstimationResol();
/*      */ 
/*      */     public native void setSeamEstimationResol(double paramDouble);
/*      */ 
/*      */     public native double compositingResol();
/*      */ 
/*      */     public native void setCompositingResol(double paramDouble);
/*      */ 
/*      */     public native double panoConfidenceThresh();
/*      */ 
/*      */     public native void setPanoConfidenceThresh(double paramDouble);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean waveCorrection();
/*      */ 
/*      */     public native void setWaveCorrection(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     @Cast({"cv::detail::WaveCorrectKind"})
/*      */     public native int waveCorrectKind();
/*      */ 
/*      */     public native void setWaveCorrectKind(@Cast({"cv::detail::WaveCorrectKind"}) int paramInt);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.FeaturesFinder featuresFinder();
/*      */ 
/*      */     public native void setFeaturesFinder(@opencv_core.Ptr opencv_stitching.FeaturesFinder paramFeaturesFinder);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.FeaturesMatcher featuresMatcher();
/*      */ 
/*      */     public native void setFeaturesMatcher(@opencv_core.Ptr opencv_stitching.FeaturesMatcher paramFeaturesMatcher);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.IplImage matchingMask();
/*      */ 
/*      */     public native void setMatchingMask(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.BundleAdjusterBase bundleAdjuster();
/*      */ 
/*      */     public native void setBundleAdjuster(@opencv_core.Ptr opencv_stitching.BundleAdjusterBase paramBundleAdjusterBase);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.WarperCreator warper();
/*      */ 
/*      */     public native void setWarper(@opencv_core.Ptr opencv_stitching.WarperCreator paramWarperCreator);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.ExposureCompensator exposureCompensator();
/*      */ 
/*      */     public native void setExposureCompensator(@opencv_core.Ptr opencv_stitching.ExposureCompensator paramExposureCompensator);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.SeamFinder seamFinder();
/*      */ 
/*      */     public native void setSeamFinder(@opencv_core.Ptr opencv_stitching.SeamFinder paramSeamFinder);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.Blender blender();
/*      */ 
/*      */     public native void setBlender(@opencv_core.Ptr opencv_stitching.Blender paramBlender);
/*      */ 
/*      */     public native int estimateTransform(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     public native int estimateTransform(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_core.RectVectorVector paramRectVectorVector);
/*      */ 
/*      */     public native int composePanorama(@opencv_core.OutputArray opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native int composePanorama(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native int stitch(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native int stitch(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_core.RectVectorVector paramRectVectorVector, @opencv_core.OutputArray opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @StdVector
/*      */     public native IntPointer component();
/*      */ 
/*      */     @StdVector
/*      */     public native opencv_stitching.CameraParams cameras();
/*      */ 
/*      */     public native double workScale();
/*      */ 
/*      */     static
/*      */     {
/* 1165 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class MultiBandBlender extends opencv_stitching.Blender
/*      */   {
/*      */     public MultiBandBlender()
/*      */     {
/* 1137 */       allocate();
/*      */     }
/* 1139 */     public MultiBandBlender(@Cast({"int"}) boolean try_gpu, int num_bands, int weight_type) { allocate(try_gpu, num_bands, weight_type); } 
/*      */     public MultiBandBlender(Pointer p) {
/* 1141 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"int"}) boolean paramBoolean, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int numBands();
/*      */ 
/*      */     public native void setNumBands(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1136 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class FeatherBlender extends opencv_stitching.Blender
/*      */   {
/*      */     public FeatherBlender()
/*      */     {
/* 1118 */       allocate(); } 
/* 1119 */     public FeatherBlender(float sharpness) { allocate(sharpness); } 
/* 1120 */     public FeatherBlender(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     public native float sharpness();
/*      */ 
/*      */     public native void setSharpness(float paramFloat);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect createWeightMaps(@ByRef opencv_core.MatVector paramMatVector1, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector2);
/*      */ 
/*      */     static
/*      */     {
/* 1117 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class Blender extends Pointer
/*      */   {
/*      */     public static final int NO = 0;
/*      */     public static final int FEATHER = 1;
/*      */     public static final int MULTI_BAND = 2;
/*      */ 
/*      */     public Blender()
/*      */     {
/* 1097 */       allocate(); } 
/* 1098 */     public Blender(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native Blender createDefault(int paramInt);
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native Blender createDefault(int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void prepare(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @Const @StdVector("CvSize,cv::Size") opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     public native void prepare(@ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native void feed(@opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native void blend(@opencv_core.OutputMat opencv_core.IplImage paramIplImage1, @opencv_core.OutputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     static
/*      */     {
/* 1096 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Namespace("cv::detail")
/*      */   public static class GraphCutSeamFinderGpu extends opencv_stitching.PairwiseSeamFinder
/*      */     implements opencv_stitching.GraphCutSeamFinderBase
/*      */   {
/*      */     public GraphCutSeamFinderGpu()
/*      */     {
/* 1078 */       allocate();
/*      */     }
/*      */     public GraphCutSeamFinderGpu(int cost_type, float terminal_cost, float bad_region_penalty) {
/* 1081 */       allocate(cost_type, terminal_cost, bad_region_penalty);
/*      */     }
/* 1083 */     public GraphCutSeamFinderGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt, float paramFloat1, float paramFloat2);
/*      */ 
/*      */     public native void findInPair(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     static
/*      */     {
/* 1077 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class GraphCutSeamFinder extends opencv_stitching.SeamFinder
/*      */     implements opencv_stitching.GraphCutSeamFinderBase
/*      */   {
/*      */     public GraphCutSeamFinder()
/*      */     {
/* 1062 */       allocate();
/*      */     }
/*      */     public GraphCutSeamFinder(int cost_type, float terminal_cost, float bad_region_penalty) {
/* 1065 */       allocate(cost_type, terminal_cost, bad_region_penalty);
/*      */     }
/* 1067 */     public GraphCutSeamFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt, float paramFloat1, float paramFloat2);
/*      */ 
/*      */     static
/*      */     {
/* 1061 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static abstract interface GraphCutSeamFinderBase
/*      */   {
/*      */     public static final int COST_COLOR = 0;
/*      */     public static final int COST_COLOR_GRAD = 1;
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class DpSeamFinder extends opencv_stitching.SeamFinder
/*      */   {
/*      */     public static final int COLOR = 0;
/*      */     public static final int COLOR_GRAD = 1;
/*      */ 
/*      */     public DpSeamFinder()
/*      */     {
/* 1043 */       allocate(); } 
/* 1044 */     public DpSeamFinder(int costFunc) { allocate(costFunc); } 
/* 1045 */     public DpSeamFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"cv::detail::DpSeamFinder::CostFunction"}) int paramInt);
/*      */ 
/*      */     @Cast({"cv::detail::DpSeamFinder::CostFunction"})
/*      */     public native int costFunction();
/*      */ 
/*      */     public native void setCostFunction(@Cast({"cv::detail::DpSeamFinder::CostFunction"}) int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1038 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class VoronoiSeamFinder extends opencv_stitching.PairwiseSeamFinder
/*      */   {
/*      */     public VoronoiSeamFinder()
/*      */     {
/* 1029 */       allocate(); } 
/* 1030 */     public VoronoiSeamFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/* 1028 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class PairwiseSeamFinder extends opencv_stitching.SeamFinder
/*      */   {
/*      */     public PairwiseSeamFinder()
/*      */     {
/*      */     }
/*      */ 
/*      */     public PairwiseSeamFinder(Pointer p)
/*      */     {
/* 1013 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 1011 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class NoSeamFinder extends opencv_stitching.SeamFinder
/*      */   {
/*      */     public NoSeamFinder()
/*      */     {
/* 1002 */       allocate(); } 
/* 1003 */     public NoSeamFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/* 1001 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class SeamFinder extends Pointer
/*      */   {
/*      */     public SeamFinder()
/*      */     {
/*      */     }
/*      */ 
/*      */     public SeamFinder(Pointer p)
/*      */     {
/*  994 */       super();
/*      */     }
/*      */ 
/*      */     public native void find(@ByRef opencv_core.MatVector paramMatVector1, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector2);
/*      */ 
/*      */     static
/*      */     {
/*  992 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class BlocksGainCompensator extends opencv_stitching.ExposureCompensator
/*      */   {
/*      */     public BlocksGainCompensator()
/*      */     {
/*  977 */       allocate(); } 
/*  978 */     public BlocksGainCompensator(int bl_width, int bl_height) { allocate(bl_width, bl_height); } 
/*  979 */     public BlocksGainCompensator(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  976 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class GainCompensator extends opencv_stitching.ExposureCompensator
/*      */   {
/*      */     public GainCompensator()
/*      */     {
/*  963 */       allocate(); } 
/*  964 */     public GainCompensator(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @StdVector
/*      */     public native DoublePointer gains();
/*      */ 
/*      */     static
/*      */     {
/*  962 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class NoExposureCompensator extends opencv_stitching.ExposureCompensator
/*      */   {
/*      */     public NoExposureCompensator()
/*      */     {
/*  950 */       allocate(); } 
/*  951 */     public NoExposureCompensator(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  949 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class ExposureCompensator extends Pointer
/*      */   {
/*      */     public static final int NO = 0;
/*      */     public static final int GAIN = 1;
/*      */     public static final int GAIN_BLOCKS = 2;
/*      */ 
/*      */     public ExposureCompensator()
/*      */     {
/*      */     }
/*      */ 
/*      */     public ExposureCompensator(Pointer p)
/*      */     {
/*  935 */       super();
/*      */     }
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native ExposureCompensator createDefault(int paramInt);
/*      */ 
/*      */     public native void feed(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_core.MatVector paramMatVector2);
/*      */ 
/*      */     public native void feed(@Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint, @ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_stitching.MatBytePairVector paramMatBytePairVector);
/*      */ 
/*      */     public native void apply(int paramInt, @ByVal opencv_core.CvPoint paramCvPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     static
/*      */     {
/*  933 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::pair<cv::Mat,uchar> >"})
/*      */   public static class MatBytePairVector extends Pointer
/*      */   {
/*      */     public MatBytePairVector()
/*      */     {
/*  921 */       allocate(); } 
/*  922 */     public MatBytePairVector(long n) { allocate(n); } 
/*  923 */     public MatBytePairVector(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(long paramLong);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     @Index
/*      */     public native opencv_core.CvMat first(long paramLong);
/*      */ 
/*      */     public native MatBytePairVector first(long paramLong, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Index
/*      */     public native byte second(long paramLong);
/*      */ 
/*      */     public native MatBytePairVector second(long paramLong, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/*  920 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class BundleAdjusterRay extends opencv_stitching.BundleAdjusterBase
/*      */   {
/*      */     public BundleAdjusterRay()
/*      */     {
/*  898 */       allocate(); } 
/*  899 */     public BundleAdjusterRay(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  897 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class BundleAdjusterReproj extends opencv_stitching.BundleAdjusterBase
/*      */   {
/*      */     public BundleAdjusterReproj()
/*      */     {
/*  891 */       allocate(); } 
/*  892 */     public BundleAdjusterReproj(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  890 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class BundleAdjusterBase extends opencv_stitching.Estimator
/*      */   {
/*      */     public BundleAdjusterBase()
/*      */     {
/*      */     }
/*      */ 
/*      */     public BundleAdjusterBase(Pointer p)
/*      */     {
/*  851 */       super();
/*      */     }
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat refinementMask();
/*      */ 
/*      */     public native void setRefinementMask(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native double confThresh();
/*      */ 
/*      */     public native void setConfThresh(double paramDouble);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvTermCriteria termCriteria();
/*      */ 
/*      */     public native void setTermCriteria(@ByRef opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     static
/*      */     {
/*  849 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class HomographyBasedEstimator extends opencv_stitching.Estimator
/*      */   {
/*      */     public HomographyBasedEstimator()
/*      */     {
/*  839 */       allocate();
/*      */     }
/*  841 */     public HomographyBasedEstimator(@Cast({"bool"}) boolean is_focals_estimated) { allocate(is_focals_estimated); } 
/*      */     public HomographyBasedEstimator(Pointer p) {
/*  843 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  838 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class Estimator extends Pointer
/*      */   {
/*      */     public Estimator()
/*      */     {
/*      */     }
/*      */ 
/*      */     public Estimator(Pointer p)
/*      */     {
/*  828 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void estimate(@Const @StdVector opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector opencv_stitching.MatchesInfo paramMatchesInfo, @Const @StdVector opencv_stitching.CameraParams paramCameraParams);
/*      */ 
/*      */     static
/*      */     {
/*  826 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class Graph extends Pointer
/*      */   {
/*      */     public Graph()
/*      */     {
/*  797 */       allocate(); } 
/*  798 */     public Graph(int num_vertices) { allocate(num_vertices); } 
/*  799 */     public Graph(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     public native void create(int paramInt);
/*      */ 
/*      */     public native int numVertices();
/*      */ 
/*      */     public native void addEdge(int paramInt1, int paramInt2, float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  796 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::detail")
/*      */   public static class GraphEdge extends Pointer
/*      */   {
/*      */     public GraphEdge(int from, int to, float weight)
/*      */     {
/*  783 */       allocate(from, to, weight); } 
/*  784 */     public GraphEdge(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     @Name({"operator<"})
/*      */     public native boolean lessThan(@ByRef GraphEdge paramGraphEdge);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     @Name({"operator>"})
/*      */     public native boolean greaterThan(@ByRef GraphEdge paramGraphEdge);
/*      */ 
/*      */     public native int from();
/*      */ 
/*      */     public native GraphEdge from(int paramInt);
/*      */ 
/*      */     public native int to();
/*      */ 
/*      */     public native GraphEdge to(int paramInt);
/*      */ 
/*      */     public native float weight();
/*      */ 
/*      */     public native GraphEdge weight(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  782 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::detail")
/*      */   public static class DisjointSets extends Pointer
/*      */   {
/*      */     public DisjointSets()
/*      */     {
/*  767 */       allocate(); } 
/*  768 */     public DisjointSets(int elem_count) { allocate(elem_count); } 
/*  769 */     public DisjointSets(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     public native void createOneElemSets(int paramInt);
/*      */ 
/*      */     public native int findSetByElem(int paramInt);
/*      */ 
/*      */     public native int mergeSets(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native IntPointer parent();
/*      */ 
/*      */     public native DisjointSets parent(IntPointer paramIntPointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native IntPointer size();
/*      */ 
/*      */     public native DisjointSets size(IntPointer paramIntPointer);
/*      */ 
/*      */     static
/*      */     {
/*  766 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::detail")
/*      */   public static class CameraParams extends Pointer
/*      */   {
/*      */     public CameraParams()
/*      */     {
/*  735 */       allocate(); } 
/*  736 */     public CameraParams(@ByRef CameraParams other) { allocate(other); } 
/*  737 */     public CameraParams(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef CameraParams paramCameraParams);
/*      */ 
/*      */     @Name({"operator="})
/*      */     @Const
/*      */     @ByRef
/*      */     public native CameraParams put(@ByRef CameraParams paramCameraParams);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat K();
/*      */ 
/*      */     public native double focal();
/*      */ 
/*      */     public native CameraParams focal(double paramDouble);
/*      */ 
/*      */     public native double aspect();
/*      */ 
/*      */     public native CameraParams aspect(double paramDouble);
/*      */ 
/*      */     public native double ppx();
/*      */ 
/*      */     public native CameraParams ppx(double paramDouble);
/*      */ 
/*      */     public native double ppy();
/*      */ 
/*      */     public native CameraParams ppy(double paramDouble);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat R();
/*      */ 
/*      */     public native CameraParams R(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat t();
/*      */ 
/*      */     public native CameraParams t(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/*  734 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class BestOf2NearestMatcher extends opencv_stitching.FeaturesMatcher
/*      */   {
/*      */     public BestOf2NearestMatcher()
/*      */     {
/*  711 */       allocate();
/*      */     }
/*      */     public BestOf2NearestMatcher(@Cast({"bool"}) boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2) {
/*  714 */       allocate(try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2);
/*      */     }
/*  716 */     public BestOf2NearestMatcher(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"bool"}) boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  710 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class FeaturesMatcher extends Pointer
/*      */   {
/*      */     public FeaturesMatcher()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FeaturesMatcher(Pointer p)
/*      */     {
/*  690 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void match(@ByRef opencv_stitching.ImageFeatures paramImageFeatures1, @ByRef opencv_stitching.ImageFeatures paramImageFeatures2, @ByRef opencv_stitching.MatchesInfo paramMatchesInfo);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void match(@Const @StdVector opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector opencv_stitching.MatchesInfo paramMatchesInfo, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean isThreadSafe();
/*      */ 
/*      */     public native void collectGarbage();
/*      */ 
/*      */     static
/*      */     {
/*  688 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::detail")
/*      */   public static class MatchesInfo extends Pointer
/*      */   {
/*      */     public MatchesInfo()
/*      */     {
/*  667 */       allocate(); } 
/*  668 */     public MatchesInfo(@ByRef MatchesInfo other) { allocate(other); } 
/*  669 */     public MatchesInfo(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef MatchesInfo paramMatchesInfo);
/*      */ 
/*      */     @Name({"operator="})
/*      */     @Const
/*      */     @ByRef
/*      */     public native MatchesInfo put(@ByRef MatchesInfo paramMatchesInfo);
/*      */ 
/*      */     public native int src_img_idx();
/*      */ 
/*      */     public native MatchesInfo src_img_idx(int paramInt);
/*      */ 
/*      */     public native int dst_img_idx();
/*      */ 
/*      */     public native MatchesInfo dst_img_idx(int paramInt);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native opencv_features2d.DMatch matches();
/*      */ 
/*      */     public native MatchesInfo matches(opencv_features2d.DMatch paramDMatch);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer inliers_mask();
/*      */ 
/*      */     public native MatchesInfo inliers_mask(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int num_inliers();
/*      */ 
/*      */     public native MatchesInfo num_inliers(int paramInt);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat H();
/*      */ 
/*      */     public native MatchesInfo H(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native double confidence();
/*      */ 
/*      */     public native MatchesInfo confidence(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  666 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Namespace("cv::detail")
/*      */   public static class SurfFeaturesFinderGpu extends opencv_stitching.FeaturesFinder
/*      */   {
/*      */     public SurfFeaturesFinderGpu()
/*      */     {
/*  652 */       allocate();
/*      */     }
/*      */     public SurfFeaturesFinderGpu(double hess_thresh, int num_octaves, int num_layers, int num_octaves_descr, int num_layers_descr) {
/*  655 */       allocate(hess_thresh, num_octaves, num_layers, num_octaves_descr, num_layers_descr);
/*      */     }
/*  657 */     public SurfFeaturesFinderGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */     static
/*      */     {
/*  651 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class OrbFeaturesFinder extends opencv_stitching.FeaturesFinder
/*      */   {
/*      */     public OrbFeaturesFinder()
/*      */     {
/*  639 */       allocate();
/*      */     }
/*      */     public OrbFeaturesFinder(@ByVal opencv_core.CvSize _grid_size, int nfeatures, float scaleFactor, int nlevels) {
/*  642 */       allocate(_grid_size, nfeatures, scaleFactor, nlevels);
/*      */     }
/*  644 */     public OrbFeaturesFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, float paramFloat, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  638 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class SurfFeaturesFinder extends opencv_stitching.FeaturesFinder
/*      */   {
/*      */     public SurfFeaturesFinder()
/*      */     {
/*  626 */       allocate();
/*      */     }
/*      */     public SurfFeaturesFinder(double hess_thresh, int num_octaves, int num_layers, int num_octaves_descr, int num_layers_descr) {
/*  629 */       allocate(hess_thresh, num_octaves, num_layers, num_octaves_descr, num_layers_descr);
/*      */     }
/*  631 */     public SurfFeaturesFinder(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */     static
/*      */     {
/*  625 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class FeaturesFinder extends Pointer
/*      */   {
/*      */     public FeaturesFinder()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FeaturesFinder(Pointer p)
/*      */     {
/*  615 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void find(opencv_core.IplImage paramIplImage, @ByRef opencv_stitching.ImageFeatures paramImageFeatures);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void find(opencv_core.IplImage paramIplImage, @ByRef opencv_stitching.ImageFeatures paramImageFeatures, @Const @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native void collectGarbage();
/*      */ 
/*      */     static
/*      */     {
/*  613 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv::detail")
/*      */   public static class ImageFeatures extends Pointer
/*      */   {
/*      */     public ImageFeatures()
/*      */     {
/*  593 */       allocate(); } 
/*  594 */     public ImageFeatures(int size) { allocateArray(size); } 
/*  595 */     public ImageFeatures(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  600 */     public ImageFeatures position(int position) { return (ImageFeatures)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int img_idx();
/*      */ 
/*      */     public native ImageFeatures img_idx(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize img_size();
/*      */ 
/*      */     public native ImageFeatures img_size(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native opencv_features2d.KeyPoint keypoints();
/*      */ 
/*      */     public native ImageFeatures keypoints(opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat descriptors();
/*      */ 
/*      */     public native ImageFeatures descriptors(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/*  592 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Namespace("cv")
/*      */   public static class SphericalWarperGpu extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public SphericalWarperGpu()
/*      */     {
/*  582 */       allocate(); } 
/*  583 */     public SphericalWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  581 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Namespace("cv")
/*      */   public static class CylindricalWarperGpu extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public CylindricalWarperGpu()
/*      */     {
/*  573 */       allocate(); } 
/*  574 */     public CylindricalWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  572 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Namespace("cv")
/*      */   public static class PlaneWarperGpu extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public PlaneWarperGpu()
/*      */     {
/*  564 */       allocate(); } 
/*  565 */     public PlaneWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  563 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class TransverseMercatorWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public TransverseMercatorWarper()
/*      */     {
/*  555 */       allocate(); } 
/*  556 */     public TransverseMercatorWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  554 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class MercatorWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public MercatorWarper()
/*      */     {
/*  546 */       allocate(); } 
/*  547 */     public MercatorWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  545 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class PaniniPortraitWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public PaniniPortraitWarper()
/*      */     {
/*  533 */       allocate();
/*      */     }
/*  535 */     public PaniniPortraitWarper(float A, float B) { allocate(A, B); } 
/*      */     public PaniniPortraitWarper(Pointer p) {
/*  537 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2);
/*      */ 
/*      */     static
/*      */     {
/*  532 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class PaniniWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public PaniniWarper()
/*      */     {
/*  520 */       allocate();
/*      */     }
/*  522 */     public PaniniWarper(float A, float B) { allocate(A, B); } 
/*      */     public PaniniWarper(Pointer p) {
/*  524 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2);
/*      */ 
/*      */     static
/*      */     {
/*  519 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class CompressedRectilinearPortraitWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public CompressedRectilinearPortraitWarper()
/*      */     {
/*  507 */       allocate();
/*      */     }
/*  509 */     public CompressedRectilinearPortraitWarper(float A, float B) { allocate(A, B); } 
/*      */     public CompressedRectilinearPortraitWarper(Pointer p) {
/*  511 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2);
/*      */ 
/*      */     static
/*      */     {
/*  506 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class CompressedRectilinearWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public CompressedRectilinearWarper()
/*      */     {
/*  494 */       allocate();
/*      */     }
/*  496 */     public CompressedRectilinearWarper(float A, float B) { allocate(A, B); } 
/*      */     public CompressedRectilinearWarper(Pointer p) {
/*  498 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2);
/*      */ 
/*      */     static
/*      */     {
/*  493 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class StereographicWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public StereographicWarper()
/*      */     {
/*  485 */       allocate(); } 
/*  486 */     public StereographicWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  484 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FisheyeWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public FisheyeWarper()
/*      */     {
/*  476 */       allocate(); } 
/*  477 */     public FisheyeWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  475 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class SphericalWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public SphericalWarper()
/*      */     {
/*  467 */       allocate(); } 
/*  468 */     public SphericalWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  466 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class CylindricalWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public CylindricalWarper()
/*      */     {
/*  458 */       allocate(); } 
/*  459 */     public CylindricalWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  457 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class PlaneWarper extends opencv_stitching.WarperCreator
/*      */   {
/*      */     public PlaneWarper()
/*      */     {
/*  449 */       allocate(); } 
/*  450 */     public PlaneWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  448 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class WarperCreator extends Pointer
/*      */   {
/*      */     public WarperCreator()
/*      */     {
/*      */     }
/*      */ 
/*      */     public WarperCreator(Pointer p)
/*      */     {
/*  442 */       super();
/*      */     }
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native opencv_stitching.RotationWarper create(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  440 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class PlanePortraitWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public PlanePortraitWarper(float scale)
/*      */     {
/*  430 */       allocate(scale); } 
/*  431 */     public PlanePortraitWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  429 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class CylindricalPortraitWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public CylindricalPortraitWarper(float scale)
/*      */     {
/*  415 */       allocate(scale); } 
/*  416 */     public CylindricalPortraitWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  414 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Name({"cv::detail::CylindricalWarperGpu"})
/*      */   public static class DetailCylindricalWarperGpu extends opencv_stitching.DetailCylindricalWarper
/*      */   {
/*      */     public DetailCylindricalWarperGpu(float scale)
/*      */     {
/*  377 */       super(); allocate(scale); } 
/*  378 */     public DetailCylindricalWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  376 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Name({"cv::detail::SphericalWarperGpu"})
/*      */   public static class DetailSphericalWarperGpu extends opencv_stitching.DetailSphericalWarper
/*      */   {
/*      */     public DetailSphericalWarperGpu(float scale)
/*      */     {
/*  360 */       super(); allocate(scale); } 
/*  361 */     public DetailSphericalWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  359 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Platform(not={"android"})
/*      */   @Name({"cv::detail::PlaneWarperGpu"})
/*      */   public static class DetailPlaneWarperGpu extends opencv_stitching.DetailPlaneWarper
/*      */   {
/*      */     public DetailPlaneWarperGpu()
/*      */     {
/*  332 */       allocate(); } 
/*  333 */     public DetailPlaneWarperGpu(float scale) { allocate(scale); } 
/*  334 */     public DetailPlaneWarperGpu(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect buildMaps(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint warp(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     static
/*      */     {
/*  331 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::TransverseMercatorWarper"})
/*      */   public static class DetailTransverseMercatorWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailTransverseMercatorWarper(float scale)
/*      */     {
/*  325 */       allocate(scale); } 
/*  326 */     public DetailTransverseMercatorWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  324 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::MercatorWarper"})
/*      */   public static class DetailMercatorWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailMercatorWarper(float scale)
/*      */     {
/*  312 */       allocate(scale); } 
/*  313 */     public DetailMercatorWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  311 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::PaniniPortraitWarper"})
/*      */   public static class DetailPaniniPortraitWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailPaniniPortraitWarper(float scale)
/*      */     {
/*  297 */       allocate(scale); } 
/*  298 */     public DetailPaniniPortraitWarper(float scale, float A, float B) { allocate(scale, A, B); } 
/*  299 */     public DetailPaniniPortraitWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */     static
/*      */     {
/*  296 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::PaniniWarper"})
/*      */   public static class DetailPaniniWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailPaniniWarper(float scale)
/*      */     {
/*  279 */       allocate(scale); } 
/*  280 */     public DetailPaniniWarper(float scale, float A, float B) { allocate(scale, A, B); } 
/*  281 */     public DetailPaniniWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */     static
/*      */     {
/*  278 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::CompressedRectilinearPortraitWarper"})
/*      */   public static class DetailCompressedRectilinearPortraitWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailCompressedRectilinearPortraitWarper(float scale)
/*      */     {
/*  261 */       allocate(scale); } 
/*  262 */     public DetailCompressedRectilinearPortraitWarper(float scale, float A, float B) { allocate(scale, A, B); } 
/*  263 */     public DetailCompressedRectilinearPortraitWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */     static
/*      */     {
/*  260 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::CompressedRectilinearWarper"})
/*      */   public static class DetailCompressedRectilinearWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailCompressedRectilinearWarper(float scale)
/*      */     {
/*  243 */       allocate(scale); } 
/*  244 */     public DetailCompressedRectilinearWarper(float scale, float A, float B) { allocate(scale, A, B); } 
/*  245 */     public DetailCompressedRectilinearWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */     static
/*      */     {
/*  242 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::StereographicWarper"})
/*      */   public static class DetailStereographicWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailStereographicWarper(float scale)
/*      */     {
/*  227 */       allocate(scale); } 
/*  228 */     public DetailStereographicWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  226 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::FisheyeWarper"})
/*      */   public static class DetailFisheyeWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailFisheyeWarper(float scale)
/*      */     {
/*  214 */       allocate(scale); } 
/*  215 */     public DetailFisheyeWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  213 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::CylindricalWarper"})
/*      */   public static class DetailCylindricalWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailCylindricalWarper(float scale)
/*      */     {
/*  199 */       allocate(scale); } 
/*  200 */     public DetailCylindricalWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  198 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::SphericalWarper"})
/*      */   public static class DetailSphericalWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailSphericalWarper(float scale)
/*      */     {
/*  184 */       allocate(scale); } 
/*  185 */     public DetailSphericalWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  183 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::detail::PlaneWarper"})
/*      */   public static class DetailPlaneWarper extends opencv_stitching.RotationWarper
/*      */   {
/*      */     public DetailPlaneWarper()
/*      */     {
/*  158 */       allocate(); } 
/*  159 */     public DetailPlaneWarper(float scale) { allocate(scale); } 
/*  160 */     public DetailPlaneWarper(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  157 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv::detail")
/*      */   public static class RotationWarper extends Pointer
/*      */   {
/*      */     public RotationWarper()
/*      */     {
/*      */     }
/*      */ 
/*      */     public RotationWarper(Pointer p)
/*      */     {
/*   98 */       super();
/*      */     }
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f warpPoint(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect buildMaps(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @opencv_core.InputMat opencv_core.IplImage paramIplImage1, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint warp(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void warpBackward(opencv_core.IplImage paramIplImage1, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.InputMat opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect warpRoi(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native float getScale();
/*      */ 
/*      */     public native void setScale(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*   96 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_stitching
 * JD-Core Version:    0.6.2
 */