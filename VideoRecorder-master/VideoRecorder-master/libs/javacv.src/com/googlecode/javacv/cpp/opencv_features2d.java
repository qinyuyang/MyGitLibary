/*      */ package com.googlecode.javacv.cpp;
/*      */ 
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
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ 
/*      */ @Properties(inherit={opencv_highgui.class, opencv_flann.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/features2d/features2d.hpp>"}, link={"opencv_features2d@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_features2d248"})})
/*      */ public class opencv_features2d
/*      */ {
/*      */   @Namespace("cv")
/*      */   @Cast({"bool"})
/*      */   public static native boolean initModule_features2d();
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, String paramString, @Const @StdVector KeyPoint paramKeyPoint);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, @StdVector KeyPoint paramKeyPoint);
/*      */ 
/*      */   @Name({"dynamic_cast<cv::FeatureDetector*>"})
/*      */   public static native FeatureDetector castFeatureDetector(Feature2D paramFeature2D);
/*      */ 
/*      */   @Name({"dynamic_cast<cv::DescriptorExtractor*>"})
/*      */   public static native DescriptorExtractor castDescriptorExtractor(Feature2D paramFeature2D);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void FAST(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @StdVector KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void FASTX(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @StdVector KeyPoint paramKeyPoint, int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
/*      */ 
/*      */   @opencv_core.OutputMat
/*      */   public static native opencv_core.CvMat windowedMatchingMask(@Const @StdVector KeyPoint paramKeyPoint1, @Const @StdVector KeyPoint paramKeyPoint2, float paramFloat1, float paramFloat2);
/*      */ 
/*      */   public static native void drawKeypoints(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_core.CvScalar paramCvScalar, int paramInt);
/*      */ 
/*      */   public static native void drawMatches(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @Const @StdVector KeyPoint paramKeyPoint2, @Const @StdVector DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByRef opencv_core.CvScalar paramCvScalar1, @ByRef opencv_core.CvScalar paramCvScalar2, @Const @StdVector @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   public static native void drawMatches(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @Const @StdVector KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @Const @StdVector KeyPoint paramKeyPoint2, @ByRef DMatchVectorVector paramDMatchVectorVector, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByRef opencv_core.CvScalar paramCvScalar1, @ByRef opencv_core.CvScalar paramCvScalar2, @ByRef opencv_core.ByteVectorVector paramByteVectorVector, int paramInt);
/*      */ 
/*      */   public static native void evaluateFeatureDetector(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, @StdVector KeyPoint paramKeyPoint1, @StdVector KeyPoint paramKeyPoint2, @ByRef float[] paramArrayOfFloat, @ByRef int[] paramArrayOfInt, @opencv_core.Ptr FeatureDetector paramFeatureDetector);
/*      */ 
/*      */   public static native void computeRecallPrecisionCurve(@ByRef DMatchVectorVector paramDMatchVectorVector, @ByRef @Cast({"std::vector<std::vector<uchar> >*"}) opencv_core.ByteVectorVector paramByteVectorVector, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native float getRecall(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat);
/*      */ 
/*      */   public static native int getNearestPoint(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat);
/*      */ 
/*      */   public static native void evaluateGenericDescriptorMatcher(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, @StdVector KeyPoint paramKeyPoint1, @StdVector KeyPoint paramKeyPoint2, DMatchVectorVector paramDMatchVectorVector, @Cast({"std::vector<std::vector<uchar> >*"}) opencv_core.ByteVectorVector paramByteVectorVector, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @opencv_core.Ptr GenericDescriptorMatcher paramGenericDescriptorMatcher);
/*      */ 
/*      */   static
/*      */   {
/*   87 */     if (Loader.load() != null)
/*   88 */       initModule_features2d();
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BOWImgDescriptorExtractor extends Pointer
/*      */   {
/*      */     public BOWImgDescriptorExtractor(@opencv_core.Ptr opencv_features2d.DescriptorExtractor dextractor, @opencv_core.Ptr opencv_features2d.DescriptorMatcher dmatcher)
/*      */     {
/* 1208 */       allocate(dextractor, dmatcher);
/*      */     }
/* 1210 */     public BOWImgDescriptorExtractor(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr opencv_features2d.DescriptorMatcher paramDescriptorMatcher);
/*      */ 
/*      */     public native void setVocabulary(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat getVocabulary();
/*      */ 
/*      */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputMat opencv_core.CvMat paramCvMat1, opencv_core.IntVectorVector paramIntVectorVector, @opencv_core.OutputMat opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native int descriptorSize();
/*      */ 
/*      */     public native int descriptorType();
/*      */ 
/*      */     static
/*      */     {
/* 1206 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BOWKMeansTrainer extends opencv_features2d.BOWTrainer
/*      */   {
/*      */     public BOWKMeansTrainer(int clusterCount)
/*      */     {
/* 1186 */       allocate(clusterCount);
/*      */     }
/*      */     public BOWKMeansTrainer(int clusterCount, @ByRef opencv_core.CvTermCriteria termcrit, int attempts, int flags) {
/* 1189 */       allocate(clusterCount, termcrit, attempts, flags);
/*      */     }
/* 1191 */     public BOWKMeansTrainer(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     private native void allocate(int paramInt1, @ByRef opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt2, int paramInt3);
/*      */ 
/*      */     static
/*      */     {
/* 1185 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BOWTrainer extends Pointer
/*      */   {
/*      */     public BOWTrainer()
/*      */     {
/*      */     }
/*      */ 
/*      */     public BOWTrainer(Pointer p)
/*      */     {
/* 1169 */       super();
/*      */     }
/*      */ 
/*      */     public native void add(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getDescriptors();
/*      */ 
/*      */     public native int descripotorsCount();
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat cluster();
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat cluster(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/* 1167 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class DrawMatchesFlags
/*      */   {
/*      */     public static final int DEFAULT = 0;
/*      */     public static final int DRAW_OVER_OUTIMG = 1;
/*      */     public static final int NOT_DRAW_SINGLE_POINTS = 2;
/*      */     public static final int DRAW_RICH_KEYPOINTS = 4;
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class VectorDescriptorMatcher extends opencv_features2d.GenericDescriptorMatcher
/*      */   {
/*      */     public VectorDescriptorMatcher()
/*      */     {
/*      */     }
/*      */ 
/*      */     public VectorDescriptorMatcher(@opencv_core.Ptr opencv_features2d.DescriptorExtractor extractor, @opencv_core.Ptr opencv_features2d.DescriptorMatcher matcher)
/*      */     {
/* 1100 */       allocate(extractor, matcher);
/*      */     }
/* 1102 */     public VectorDescriptorMatcher(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.DescriptorExtractor paramDescriptorExtractor, @opencv_core.Ptr opencv_features2d.DescriptorMatcher paramDescriptorMatcher);
/*      */ 
/*      */     static
/*      */     {
/* 1097 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class GenericDescriptorMatcher extends Pointer
/*      */   {
/*      */     public GenericDescriptorMatcher()
/*      */     {
/*      */     }
/*      */ 
/*      */     public GenericDescriptorMatcher(Pointer p)
/*      */     {
/* 1017 */       super();
/*      */     }
/*      */ 
/*      */     public native void add(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getTrainImages();
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_features2d.KeyPointVectorVector getTrainKeypoints();
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native boolean isMaskSupported();
/*      */ 
/*      */     public native void train();
/*      */ 
/*      */     public native void classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2);
/*      */ 
/*      */     public native void classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @StdVector opencv_features2d.DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */     public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @StdVector opencv_features2d.DMatch paramDMatch, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native boolean empty();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native GenericDescriptorMatcher clone();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native GenericDescriptorMatcher clone(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native GenericDescriptorMatcher create(String paramString1, String paramString2);
/*      */ 
/*      */     static
/*      */     {
/* 1015 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FlannBasedMatcher extends opencv_features2d.DescriptorMatcher
/*      */   {
/*      */     public FlannBasedMatcher()
/*      */     {
/*  978 */       allocate();
/*      */     }
/*      */     public FlannBasedMatcher(opencv_flann.IndexParams indexParams, opencv_flann.SearchParams searchParams) {
/*  981 */       allocate(indexParams, searchParams);
/*      */     }
/*  983 */     public FlannBasedMatcher(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_flann.IndexParams paramIndexParams, opencv_flann.SearchParams paramSearchParams);
/*      */ 
/*      */     static
/*      */     {
/*  977 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BFMatcher extends opencv_features2d.DescriptorMatcher
/*      */   {
/*      */     public BFMatcher()
/*      */     {
/*  957 */       allocate(); } 
/*  958 */     public BFMatcher(int normType, @Cast({"bool"}) boolean crossCheck) { allocate(normType, crossCheck); } 
/*  959 */     public BFMatcher(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  956 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class DescriptorMatcher extends opencv_core.Algorithm
/*      */   {
/*      */     public DescriptorMatcher()
/*      */     {
/*      */     }
/*      */ 
/*      */     public DescriptorMatcher(Pointer p)
/*      */     {
/*  886 */       super();
/*      */     }
/*      */ 
/*      */     public native void add(@ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_core.MatVector getTrainDescriptors();
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native boolean empty();
/*      */ 
/*      */     public native boolean isMaskSupported();
/*      */ 
/*      */     public native void train();
/*      */ 
/*      */     public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.DMatch paramDMatch, @opencv_core.InputMat opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */     public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void match(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.DMatch paramDMatch, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     public native void knnMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, int paramInt, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void radiusMatch(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByRef opencv_features2d.DMatchVectorVector paramDMatchVectorVector, float paramFloat, @Const(true) @StdVector("CvMat*,cv::Mat") opencv_core.CvMatArray paramCvMatArray, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native DescriptorMatcher clone();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native DescriptorMatcher clone(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native DescriptorMatcher create(String paramString);
/*      */ 
/*      */     static
/*      */     {
/*  884 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::DMatch> >"})
/*      */   public static class DMatchVectorVector extends Pointer
/*      */   {
/*      */     public DMatchVectorVector()
/*      */     {
/*  868 */       allocate(); } 
/*  869 */     public DMatchVectorVector(long n) { allocate(n); } 
/*  870 */     public DMatchVectorVector(Pointer p) { super(); }
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
/*      */     @ByRef
/*      */     public native opencv_features2d.DMatch get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native DMatchVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_features2d.DMatch paramDMatch);
/*      */ 
/*      */     static
/*      */     {
/*  867 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class DMatch extends Pointer
/*      */   {
/*      */     public DMatch()
/*      */     {
/*  838 */       allocate();
/*      */     }
/*  840 */     public DMatch(int _queryIdx, int _trainIdx, float _distance) { allocate(_queryIdx, _trainIdx, _distance); }
/*      */ 
/*      */     public DMatch(int _queryIdx, int _trainIdx, int _imgIdx, float _distance) {
/*  843 */       allocate(_queryIdx, _trainIdx, _imgIdx, _distance);
/*      */     }
/*  845 */     public DMatch(int size) { allocateArray(size); } 
/*  846 */     public DMatch(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat);
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  853 */     public DMatch position(int position) { return (DMatch)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int queryIdx();
/*      */ 
/*      */     public native DMatch queryIdx(int paramInt);
/*      */ 
/*      */     public native int trainIdx();
/*      */ 
/*      */     public native DMatch trainIdx(int paramInt);
/*      */ 
/*      */     public native int imgIdx();
/*      */ 
/*      */     public native DMatch imgIdx(int paramInt);
/*      */ 
/*      */     public native float distance();
/*      */ 
/*      */     public native DMatch distance(float paramFloat);
/*      */ 
/*      */     @Name({"operator<"})
/*      */     public native boolean compare(@ByRef DMatch paramDMatch);
/*      */ 
/*      */     static
/*      */     {
/*  837 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::HammingMultilevel<4>"})
/*      */   public static class HammingMultilevel4 extends Pointer
/*      */   {
/*      */     public HammingMultilevel4()
/*      */     {
/*  827 */       allocate(); } 
/*  828 */     public HammingMultilevel4(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  826 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::HammingMultilevel<2>"})
/*      */   public static class HammingMultilevel2 extends Pointer
/*      */   {
/*      */     public HammingMultilevel2()
/*      */     {
/*  818 */       allocate(); } 
/*  819 */     public HammingMultilevel2(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  817 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Hamming extends Pointer
/*      */   {
/*      */     public static final int normType = 6;
/*      */ 
/*      */     public Hamming()
/*      */     {
/*  806 */       allocate(); } 
/*  807 */     public Hamming(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native int d(@Cast({"unsigned char*"}) byte[] paramArrayOfByte1, @Cast({"unsigned char*"}) byte[] paramArrayOfByte2, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  805 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BriefDescriptorExtractor extends opencv_features2d.DescriptorExtractor
/*      */   {
/*      */     public static final int PATCH_SIZE = 48;
/*      */     public static final int KERNEL_SIZE = 9;
/*      */ 
/*      */     public BriefDescriptorExtractor()
/*      */     {
/*  782 */       allocate(); } 
/*  783 */     public BriefDescriptorExtractor(Pointer p) { super(); } 
/*      */     public BriefDescriptorExtractor(int bytes) {
/*  785 */       allocate(bytes);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  777 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class OpponentColorDescriptorExtractor extends opencv_features2d.DescriptorExtractor
/*      */   {
/*      */     public OpponentColorDescriptorExtractor()
/*      */     {
/*      */     }
/*      */ 
/*      */     public OpponentColorDescriptorExtractor(Pointer p)
/*      */     {
/*  757 */       super();
/*      */     }
/*  759 */     public OpponentColorDescriptorExtractor(@opencv_core.Ptr opencv_features2d.DescriptorExtractor descriptorExtractor) { allocate(descriptorExtractor); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.DescriptorExtractor paramDescriptorExtractor);
/*      */ 
/*      */     static
/*      */     {
/*  755 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class SurfAdjuster extends opencv_features2d.AdjusterAdapter
/*      */   {
/*      */     public SurfAdjuster()
/*      */     {
/*  728 */       allocate();
/*      */     }
/*  730 */     public SurfAdjuster(double initial_thresh, double min_thresh, double max_thresh) { allocate(initial_thresh, min_thresh, max_thresh); } 
/*      */     public SurfAdjuster(Pointer p) {
/*  732 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
/*      */ 
/*      */     static
/*      */     {
/*  727 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class StarAdjuster extends opencv_features2d.AdjusterAdapter
/*      */   {
/*      */     public StarAdjuster()
/*      */     {
/*  704 */       allocate(); } 
/*  705 */     public StarAdjuster(Pointer p) { super(); } 
/*      */     public StarAdjuster(double initial_thresh, double min_thresh, double max_thresh) {
/*  707 */       allocate(initial_thresh, min_thresh, max_thresh);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
/*      */ 
/*      */     static
/*      */     {
/*  703 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FastAdjuster extends opencv_features2d.AdjusterAdapter
/*      */   {
/*      */     public FastAdjuster()
/*      */     {
/*  681 */       allocate(); } 
/*  682 */     public FastAdjuster(Pointer p) { super(); } 
/*      */     public FastAdjuster(int init_thresh, boolean nonmax, int min_thresh, int max_thresh) {
/*  684 */       allocate(init_thresh, nonmax, min_thresh, max_thresh);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2, int paramInt3);
/*      */ 
/*      */     static
/*      */     {
/*  680 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class DynamicAdaptedFeatureDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public DynamicAdaptedFeatureDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public DynamicAdaptedFeatureDetector(Pointer p)
/*      */     {
/*  666 */       super();
/*      */     }
/*      */     public DynamicAdaptedFeatureDetector(@opencv_core.Ptr opencv_features2d.AdjusterAdapter adjuster, int min_features, int max_features, int max_iters) {
/*  669 */       allocate(adjuster, min_features, max_features, max_iters);
/*      */     }
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.AdjusterAdapter paramAdjusterAdapter, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     static
/*      */     {
/*  664 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class AdjusterAdapter extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public AdjusterAdapter()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AdjusterAdapter(Pointer p)
/*      */     {
/*  652 */       super();
/*      */     }
/*      */ 
/*      */     public native void tooFew(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void tooMany(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native boolean good();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public native AdjusterAdapter clone();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native AdjusterAdapter create(String paramString);
/*      */ 
/*      */     static
/*      */     {
/*  650 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class PyramidAdaptedFeatureDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public PyramidAdaptedFeatureDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public PyramidAdaptedFeatureDetector(Pointer p)
/*      */     {
/*  634 */       super();
/*      */     }
/*  636 */     public PyramidAdaptedFeatureDetector(@opencv_core.Ptr opencv_features2d.FeatureDetector detector, int maxLevel) { allocate(detector, maxLevel); }
/*      */ 
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  632 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class GridAdaptedFeatureDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public GridAdaptedFeatureDetector()
/*      */     {
/*  609 */       allocate(); } 
/*  610 */     public GridAdaptedFeatureDetector(Pointer p) { super(); }
/*      */ 
/*      */     public GridAdaptedFeatureDetector(@opencv_core.Ptr opencv_features2d.FeatureDetector detector, int maxTotalKeypoints, int gridRows, int gridCols) {
/*  613 */       allocate(detector, maxTotalKeypoints, gridRows, gridCols);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     static
/*      */     {
/*  608 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class DenseFeatureDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public DenseFeatureDetector()
/*      */     {
/*  580 */       allocate(); } 
/*  581 */     public DenseFeatureDetector(Pointer p) { super(); }
/*      */ 
/*      */     public DenseFeatureDetector(float initFeatureScale, int featureScaleLevels, float featureScaleMul, int initXyStep, int initImgBound, @Cast({"bool"}) boolean varyXyStepWithScale, @Cast({"bool"}) boolean varyImgBoundWithScale)
/*      */     {
/*  585 */       allocate(initFeatureScale, featureScaleLevels, featureScaleMul, initXyStep, initImgBound, varyXyStepWithScale, varyImgBoundWithScale);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
/*      */ 
/*      */     static
/*      */     {
/*  579 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class SimpleBlobDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public SimpleBlobDetector()
/*      */     {
/*  513 */       allocate(); } 
/*  514 */     public SimpleBlobDetector(Pointer p) { super(); } 
/*      */     public SimpleBlobDetector(@ByRef Params parameters) {
/*  516 */       allocate(parameters);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef Params paramParams);
/*      */ 
/*      */     static
/*      */     {
/*  512 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @NoOffset
/*      */     public static class Params extends Pointer
/*      */     {
/*      */       public Params()
/*      */       {
/*  523 */         allocate(); } 
/*  524 */       public Params(int size) { allocateArray(size); } 
/*  525 */       public Params(Pointer p) { super(); } 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocateArray(int paramInt);
/*      */ 
/*  530 */       public Params position(int position) { return (Params)super.position(position); }
/*      */ 
/*      */ 
/*      */       public native float thresholdStep();
/*      */ 
/*      */       public native Params thresholdStep(float paramFloat);
/*      */ 
/*      */       public native float minThreshold();
/*      */ 
/*      */       public native Params minThreshold(float paramFloat);
/*      */ 
/*      */       public native float maxThreshold();
/*      */ 
/*      */       public native Params maxThreshold(float paramFloat);
/*      */ 
/*      */       @Cast({"size_t"})
/*      */       public native long minRepeatability();
/*      */ 
/*      */       public native Params minRepeatability(long paramLong);
/*      */ 
/*      */       public native float minDistBetweenBlobs();
/*      */ 
/*      */       public native Params minDistBetweenBlobs(float paramFloat);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean filterByColor();
/*      */ 
/*      */       public native Params filterByColor(boolean paramBoolean);
/*      */ 
/*      */       public native byte blobColor();
/*      */ 
/*      */       public native Params blobColor(byte paramByte);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean filterByArea();
/*      */ 
/*      */       public native Params filterByArea(boolean paramBoolean);
/*      */ 
/*      */       public native float minArea();
/*      */ 
/*      */       public native Params minArea(float paramFloat);
/*      */ 
/*      */       public native float maxArea();
/*      */ 
/*      */       public native Params maxArea(float paramFloat);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean filterByCircularity();
/*      */ 
/*      */       public native Params filterByCircularity(boolean paramBoolean);
/*      */ 
/*      */       public native float minCircularity();
/*      */ 
/*      */       public native Params minCircularity(float paramFloat);
/*      */ 
/*      */       public native float maxCircularity();
/*      */ 
/*      */       public native Params maxCircularity(float paramFloat);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean filterByInertia();
/*      */ 
/*      */       public native Params filterByInertia(boolean paramBoolean);
/*      */ 
/*      */       public native float minInertiaRatio();
/*      */ 
/*      */       public native Params minInertiaRatio(float paramFloat);
/*      */ 
/*      */       public native float maxInertiaRatio();
/*      */ 
/*      */       public native Params maxInertiaRatio(float paramFloat);
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean filterByConvexity();
/*      */ 
/*      */       public native Params filterByConvexity(boolean paramBoolean);
/*      */ 
/*      */       public native float minConvexity();
/*      */ 
/*      */       public native Params minConvexity(float paramFloat);
/*      */ 
/*      */       public native float maxConvexity();
/*      */ 
/*      */       public native Params maxConvexity(float paramFloat);
/*      */ 
/*      */       public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */       public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */       static
/*      */       {
/*  522 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class GFTTDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public GFTTDetector()
/*      */     {
/*  489 */       allocate(); } 
/*  490 */     public GFTTDetector(Pointer p) { super(); }
/*      */ 
/*      */     public GFTTDetector(int maxCorners, double qualityLevel, double minDistance, int blockSize, @Cast({"bool"}) boolean useHarrisDetector, double k) {
/*  493 */       allocate(maxCorners, qualityLevel, minDistance, blockSize, useHarrisDetector, k);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, @Cast({"bool"}) boolean paramBoolean, double paramDouble3);
/*      */ 
/*      */     static
/*      */     {
/*  488 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FastFeatureDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public static final int TYPE_5_8 = 0;
/*      */     public static final int TYPE_7_12 = 1;
/*      */     public static final int TYPE_9_16 = 2;
/*      */ 
/*      */     public FastFeatureDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FastFeatureDetector(Pointer p)
/*      */     {
/*  473 */       super();
/*      */     }
/*  475 */     public FastFeatureDetector(int threshold, boolean nonmaxSuppression) { allocate(threshold, nonmaxSuppression); }
/*      */ 
/*      */ 
/*      */     private native void allocate(int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  470 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class StarDetector extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public StarDetector()
/*      */     {
/*  441 */       allocate(); } 
/*  442 */     public StarDetector(Pointer p) { super(); }
/*      */ 
/*      */     public StarDetector(int _maxSize, int _responseThreshold, int _lineThresholdProjected, int _lineThresholdBinarized, int _suppressNonmaxSize) {
/*  445 */       allocate(_maxSize, _responseThreshold, _lineThresholdProjected, _lineThresholdBinarized, _suppressNonmaxSize);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */     public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     static
/*      */     {
/*  440 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class MSER extends opencv_features2d.FeatureDetector
/*      */   {
/*      */     public MSER()
/*      */     {
/*  407 */       allocate(); } 
/*  408 */     public MSER(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     public MSER(int _delta, int _min_area, int _max_area, double _max_variation, double _min_diversity, int _max_evolution, double _area_threshold, double _min_margin, int _edge_blur_size)
/*      */     {
/*  413 */       allocate(_delta, _min_area, _max_area, _max_variation, _min_diversity, _max_evolution, _area_threshold, _min_margin, _edge_blur_size);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4, double paramDouble3, double paramDouble4, int paramInt5);
/*      */ 
/*      */     static
/*      */     {
/*  406 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FREAK extends opencv_features2d.DescriptorExtractor
/*      */   {
/*      */     public static final int kBytes = 32;
/*      */     public static final int HARRIS_SCORE = 0;
/*      */     public static final int FAST_SCORE = 1;
/*      */     public static final int NB_SCALES = 64;
/*      */     public static final int NB_PAIRS = 512;
/*      */     public static final int NB_ORIENPAIRS = 45;
/*      */ 
/*      */     public FREAK()
/*      */     {
/*  340 */       allocate(); } 
/*  341 */     public FREAK(Pointer p) { super(); }
/*      */ 
/*      */     public FREAK(boolean orientationNormalized, boolean scaleNormalized, float patternScale, int nOctaves, @Const @StdVector IntPointer selectedPairs)
/*      */     {
/*  345 */       allocate(orientationNormalized, scaleNormalized, patternScale, nOctaves, selectedPairs);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(boolean paramBoolean1, boolean paramBoolean2, float paramFloat, int paramInt, @Const @StdVector IntPointer paramIntPointer);
/*      */ 
/*      */     @StdVector
/*      */     public native IntPointer selectPairs(@ByRef opencv_core.MatVector paramMatVector, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, double paramDouble, boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/*  338 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class ORB extends opencv_features2d.Feature2D
/*      */   {
/*      */     public static final int kBytes = 32;
/*      */     public static final int HARRIS_SCORE = 0;
/*      */     public static final int FAST_SCORE = 1;
/*      */ 
/*      */     public ORB()
/*      */     {
/*  304 */       allocate(); } 
/*  305 */     public ORB(Pointer p) { super(); }
/*      */ 
/*      */     public ORB(int nfeatures, float scaleFactor, int nlevels, int edgeThreshold, int firstLevel, int WTA_K, int scoreType, int patchSize) {
/*  308 */       allocate(nfeatures, scaleFactor, nlevels, edgeThreshold, firstLevel, WTA_K, scoreType, patchSize);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*      */ 
/*      */     public native int descriptorSize();
/*      */ 
/*      */     public native int descriptorType();
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native opencv_core.AlgorithmInfo info();
/*      */ 
/*      */     static
/*      */     {
/*  302 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class BRISK extends opencv_features2d.Feature2D
/*      */   {
/*      */     public static final int kBytes = 32;
/*      */     public static final int HARRIS_SCORE = 0;
/*      */     public static final int FAST_SCORE = 1;
/*      */ 
/*      */     public BRISK()
/*      */     {
/*  227 */       allocate(); } 
/*  228 */     public BRISK(Pointer p) { super(); } 
/*      */     public BRISK(int thresh, int octaves, float patternScale) {
/*  230 */       allocate(thresh, octaves, patternScale);
/*      */     }
/*      */ 
/*      */     public BRISK(@StdVector float[] radiusList, @StdVector int[] numberList, float dMax, float dMin, @StdVector int[] indexChange) {
/*  234 */       allocate(radiusList, numberList, dMax, dMin, indexChange);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat);
/*      */ 
/*      */     private native void allocate(@StdVector float[] paramArrayOfFloat, @StdVector int[] paramArrayOfInt1, float paramFloat1, float paramFloat2, @StdVector int[] paramArrayOfInt2);
/*      */ 
/*      */     public native void generateKernel(@StdVector float[] paramArrayOfFloat, @StdVector int[] paramArrayOfInt1, float paramFloat1, float paramFloat2, @StdVector int[] paramArrayOfInt2);
/*      */ 
/*      */     public native int descriptorSize();
/*      */ 
/*      */     public native int descriptorType();
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, boolean paramBoolean);
/*      */ 
/*      */     public native opencv_core.AlgorithmInfo info();
/*      */ 
/*      */     static
/*      */     {
/*  225 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Feature2D extends Pointer
/*      */   {
/*      */     public Feature2D()
/*      */     {
/*      */     }
/*      */ 
/*      */     public Feature2D(Pointer p)
/*      */     {
/*  211 */       super(); } 
/*      */     @Name({"operator()"})
/*      */     public native void detectAndCompute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputMat opencv_core.CvMat paramCvMat);
/*      */ 
/*  218 */     public opencv_features2d.FeatureDetector getFeatureDetector() { return opencv_features2d.castFeatureDetector(this); } 
/*  219 */     public opencv_features2d.DescriptorExtractor getDescriptorExtractor() { return opencv_features2d.castDescriptorExtractor(this); }
/*      */ 
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native Feature2D create(String paramString);
/*      */ 
/*      */     static
/*      */     {
/*  209 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class DescriptorExtractor extends opencv_core.Algorithm
/*      */   {
/*      */     public DescriptorExtractor()
/*      */     {
/*      */     }
/*      */ 
/*      */     public DescriptorExtractor(Pointer p)
/*      */     {
/*  189 */       super();
/*      */     }
/*      */ 
/*      */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputMat opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native void compute(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, @ByRef opencv_core.MatVector paramMatVector2);
/*      */ 
/*      */     public native int descriptorSize();
/*      */ 
/*      */     public native int descriptorType();
/*      */ 
/*      */     public native boolean empty();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native DescriptorExtractor create(String paramString);
/*      */ 
/*      */     static
/*      */     {
/*  187 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FeatureDetector extends opencv_core.Algorithm
/*      */   {
/*      */     public FeatureDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FeatureDetector(Pointer p)
/*      */     {
/*  175 */       super();
/*      */     }
/*      */ 
/*      */     public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native void detect(@ByRef opencv_core.MatVector paramMatVector1, @ByRef opencv_features2d.KeyPointVectorVector paramKeyPointVectorVector, @ByRef opencv_core.MatVector paramMatVector2);
/*      */ 
/*      */     public native boolean empty();
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native FeatureDetector create(String paramString);
/*      */ 
/*      */     static
/*      */     {
/*  173 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::KeyPoint> >"})
/*      */   public static class KeyPointVectorVector extends Pointer
/*      */   {
/*      */     public KeyPointVectorVector()
/*      */     {
/*  157 */       allocate(); } 
/*  158 */     public KeyPointVectorVector(long n) { allocate(n); } 
/*  159 */     public KeyPointVectorVector(Pointer p) { super(); }
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
/*      */     @ByRef
/*      */     public native opencv_features2d.KeyPoint get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native KeyPointVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     static
/*      */     {
/*  156 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class KeyPointsFilter extends Pointer
/*      */   {
/*      */     public KeyPointsFilter()
/*      */     {
/*  144 */       allocate(); } 
/*  145 */     public KeyPointsFilter(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public static native void runByImageBorder(@StdVector opencv_features2d.KeyPoint paramKeyPoint, @ByVal opencv_core.CvSize paramCvSize, int paramInt);
/*      */ 
/*      */     public static native void runByKeypointSize(@StdVector opencv_features2d.KeyPoint paramKeyPoint, float paramFloat1, float paramFloat2);
/*      */ 
/*      */     public static native void runByPixelsMask(@StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public static native void removeDuplicated(@StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     static
/*      */     {
/*  143 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class KeyPoint extends Pointer
/*      */   {
/*      */     public KeyPoint()
/*      */     {
/*   96 */       allocate(); } 
/*   97 */     public KeyPoint(int size) { allocateArray(size); }
/*      */ 
/*      */     public KeyPoint(opencv_core.CvPoint2D32f _pt, float _size, float _angle, float _response, int _octave, int _class_id) {
/*  100 */       allocate(_pt, _size, _angle, _response, _octave, _class_id);
/*      */     }
/*      */ 
/*      */     public KeyPoint(float x, float y, float _size, float _angle, float _response, int _octave, int _class_id) {
/*  104 */       allocate(x, y, _size, _angle, _response, _octave, _class_id);
/*      */     }
/*  106 */     public KeyPoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef opencv_core.CvPoint2D32f paramCvPoint2D32f, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
/*      */ 
/*      */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  115 */     public KeyPoint position(int position) { return (KeyPoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native long hash();
/*      */ 
/*      */     public static native void convert(@Const @StdVector KeyPoint paramKeyPoint, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @Const @StdVector int[] paramArrayOfInt);
/*      */ 
/*      */     public static native void convert(@Const @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector KeyPoint paramKeyPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
/*      */ 
/*      */     public static native float overlap(@ByRef KeyPoint paramKeyPoint1, @ByRef KeyPoint paramKeyPoint2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f pt();
/*      */ 
/*      */     public native KeyPoint pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @Name({"pt.x"})
/*      */     public native float pt_x();
/*      */ 
/*      */     public native KeyPoint pt_x(float paramFloat);
/*      */ 
/*      */     @Name({"pt.y"})
/*      */     public native float pt_y();
/*      */ 
/*      */     public native KeyPoint pt_y(float paramFloat);
/*      */ 
/*      */     public native float size();
/*      */ 
/*      */     public native KeyPoint size(float paramFloat);
/*      */ 
/*      */     public native float angle();
/*      */ 
/*      */     public native KeyPoint angle(float paramFloat);
/*      */ 
/*      */     public native float response();
/*      */ 
/*      */     public native KeyPoint response(float paramFloat);
/*      */ 
/*      */     public native int octave();
/*      */ 
/*      */     public native KeyPoint octave(int paramInt);
/*      */ 
/*      */     public native int class_id();
/*      */ 
/*      */     public native KeyPoint class_id(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*   95 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_features2d
 * JD-Core Version:    0.6.2
 */