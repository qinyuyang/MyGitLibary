/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.Pointer.Deallocator;
/*     */ import com.googlecode.javacpp.PointerPointer;
/*     */ import com.googlecode.javacpp.annotation.Adapter;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Index;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Opaque;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacpp.annotation.StdVector;
/*     */ 
/*     */ @Properties(inherit={opencv_highgui.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/objdetect/objdetect.hpp>"}, link={"opencv_objdetect@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_objdetect248"})})
/*     */ public class opencv_objdetect
/*     */ {
/*     */   public static final int CV_HAAR_MAGIC_VAL = 1112539136;
/*     */   public static final String CV_TYPE_NAME_HAAR = "opencv-haar-classifier";
/*     */   public static final int CV_HAAR_FEATURE_MAX = 3;
/*     */   public static final int CV_HAAR_DO_CANNY_PRUNING = 1;
/*     */   public static final int CV_HAAR_SCALE_IMAGE = 2;
/*     */   public static final int CV_HAAR_FIND_BIGGEST_OBJECT = 4;
/*     */   public static final int CV_HAAR_DO_ROUGH_SEARCH = 8;
/*     */ 
/*     */   public static boolean CV_IS_HAAR_CLASSIFIER(CvHaarClassifierCascade haar)
/*     */   {
/*  97 */     return (haar != null) && ((haar.flags() & 0xFFFF0000) == 1112539136);
/*     */   }
/*     */ 
/*     */   public static native CvHaarClassifierCascade cvLoadHaarClassifierCascade(String paramString, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */   public static native void cvReleaseHaarClassifierCascade(@ByPtrPtr CvHaarClassifierCascade paramCvHaarClassifierCascade);
/*     */ 
/*     */   public static opencv_core.CvSeq cvHaarDetectObjects(opencv_core.CvArr image, CvHaarClassifierCascade cascade, opencv_core.CvMemStorage storage, double scale_factor, int min_neighbors, int flags)
/*     */   {
/* 238 */     return cvHaarDetectObjects(image, cascade, storage, scale_factor, min_neighbors, flags, opencv_core.CvSize.ZERO, opencv_core.CvSize.ZERO);
/*     */   }
/*     */ 
/*     */   public static native opencv_core.CvSeq cvHaarDetectObjects(opencv_core.CvArr paramCvArr, CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
/*     */ 
/*     */   public static native void cvSetImagesForHaarClassifierCascade(CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble);
/*     */ 
/*     */   public static native int cvRunHaarClassifierCascade(CvHaarClassifierCascade paramCvHaarClassifierCascade, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt);
/*     */ 
/*     */   public static native CvLatentSvmDetector cvLoadLatentSvmDetector(String paramString);
/*     */ 
/*     */   public static native void cvReleaseLatentSvmDetector(@ByPtrPtr CvLatentSvmDetector paramCvLatentSvmDetector);
/*     */ 
/*     */   public static native opencv_core.CvSeq cvLatentSvmDetectObjects(@opencv_core.InputMat opencv_core.CvArr paramCvArr, CvLatentSvmDetector paramCvLatentSvmDetector, opencv_core.CvMemStorage paramCvMemStorage, float paramFloat, int paramInt);
/*     */ 
/*     */   public static native opencv_core.CvSeq cvHaarDetectObjectsForROC(opencv_core.CvArr paramCvArr, CvHaarClassifierCascade paramCvHaarClassifierCascade, opencv_core.CvMemStorage paramCvMemStorage, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, int paramInt, double paramDouble);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, int paramInt, double paramDouble);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, int paramInt, double paramDouble, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, int paramInt, double paramDouble);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void groupRectangles_meanshift(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector DoublePointer paramDoublePointer1, @StdVector DoublePointer paramDoublePointer2, double paramDouble, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void findDataMatrix(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @opencv_core.OutputArray opencv_core.CvMatArray paramCvMatArray);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void drawDataMatrixCodes(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
/*     */ 
/*     */   @ByVal
/*     */   public static native CvDataMatrixCodeDeque cvFindDataMatrix(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */   @Namespace("cv::linemod")
/*     */   @opencv_core.Ptr
/*     */   public static native Detector getDefaultLINE();
/*     */ 
/*     */   @Namespace("cv::linemod")
/*     */   @opencv_core.Ptr
/*     */   public static native Detector getDefaultLINEMOD();
/*     */ 
/*     */   static
/*     */   {
/*  91 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Namespace("cv::linemod")
/*     */   public static class Detector extends Pointer
/*     */   {
/*     */     public Detector()
/*     */     {
/* 864 */       allocate();
/*     */     }
/* 866 */     public Detector(@ByRef opencv_objdetect.ModalityVector modalities, @Const @StdVector int[] T_pyramid) { allocate(modalities, T_pyramid); } 
/*     */     public Detector(Pointer p) {
/* 868 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(@ByRef opencv_objdetect.ModalityVector paramModalityVector, @Const @StdVector int[] paramArrayOfInt);
/*     */ 
/*     */     public native void match(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, float paramFloat, @StdVector opencv_objdetect.Match paramMatch, @ByRef opencv_core.StringVector paramStringVector, @opencv_core.InputArray opencv_core.IplImageArray paramIplImageArray2, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray3);
/*     */ 
/*     */     public native int addTemplate(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, String paramString, opencv_core.IplImage paramIplImage, @Const @Adapter("RectAdapter") opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     public native int addSyntheticTemplate(@Const @StdVector opencv_objdetect.Template paramTemplate, String paramString);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native opencv_objdetect.ModalityVector getModalities();
/*     */ 
/*     */     public native int getT(int paramInt);
/*     */ 
/*     */     public native int pyramidLevels();
/*     */ 
/*     */     @StdVector
/*     */     public native opencv_objdetect.Template getTemplates(String paramString, int paramInt);
/*     */ 
/*     */     public native int numTemplates();
/*     */ 
/*     */     public native int numTemplates(String paramString);
/*     */ 
/*     */     public native int numClasses();
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.StringVector classIds();
/*     */ 
/*     */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*     */ 
/*     */     @ByRef
/*     */     public native String readClass(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString);
/*     */ 
/*     */     public native void writeClass(String paramString, @Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*     */ 
/*     */     public native void readClasses(@ByRef opencv_core.StringVector paramStringVector, String paramString);
/*     */ 
/*     */     public native void writeClasses(String paramString);
/*     */ 
/*     */     static
/*     */     {
/* 863 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Name({"std::vector<cv::Ptr<cv::linemod::Modality> >"})
/*     */   public static class ModalityVector extends Pointer
/*     */   {
/*     */     public ModalityVector(opencv_objdetect.Modality[] array)
/*     */     {
/* 840 */       this(array.length); put(array); } 
/* 841 */     public ModalityVector() { allocate(); } 
/* 842 */     public ModalityVector(long n) { allocate(n); } 
/* 843 */     public ModalityVector(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     public native long size();
/*     */ 
/*     */     public native void resize(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     @Index
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native opencv_objdetect.Modality get(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     public native ModalityVector put(@Cast({"size_t"}) long paramLong, opencv_objdetect.Modality paramModality);
/*     */ 
/* 854 */     public ModalityVector put(opencv_objdetect.Modality[] array) { if (size() < array.length) resize(array.length);
/* 855 */       for (int i = 0; i < array.length; i++) {
/* 856 */         put(i, array[i]);
/*     */       }
/* 858 */       return this;
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 839 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::linemod")
/*     */   public static class Match extends Pointer
/*     */   {
/*     */     public Match()
/*     */     {
/* 812 */       allocate();
/*     */     }
/* 814 */     public Match(int x, int y, float similarity, String class_id, int template_id) { allocate(x, y, similarity, class_id, template_id); } 
/*     */     public Match(int size) {
/* 816 */       allocateArray(size); } 
/* 817 */     public Match(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, float paramFloat, String paramString, int paramInt3);
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 823 */     public Match position(int position) { return (Match)super.position(position); }
/*     */ 
/*     */ 
/*     */     @Cast({"bool"})
/*     */     @Name({"operator<"})
/*     */     public native boolean compare(@ByRef Match paramMatch);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     @Name({"operator=="})
/*     */     public native boolean equals(@ByRef Match paramMatch);
/*     */ 
/*     */     public native int x();
/*     */ 
/*     */     public native Match x(int paramInt);
/*     */ 
/*     */     public native int y();
/*     */ 
/*     */     public native Match y(int paramInt);
/*     */ 
/*     */     public native float similarity();
/*     */ 
/*     */     public native Match similarity(float paramFloat);
/*     */ 
/*     */     @ByRef
/*     */     public native String class_id();
/*     */ 
/*     */     public native Match class_id(String paramString);
/*     */ 
/*     */     public native int template_id();
/*     */ 
/*     */     public native Match template_id(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 811 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::linemod")
/*     */   public static class DepthNormal extends opencv_objdetect.Modality
/*     */   {
/*     */     public DepthNormal()
/*     */     {
/* 786 */       allocate();
/*     */     }
/* 788 */     public DepthNormal(int distance_threshold, int difference_threshold, @Cast({"size_t"}) long num_features, int extract_threshold) { allocate(distance_threshold, difference_threshold, num_features, extract_threshold); } 
/*     */     public DepthNormal(Pointer p) {
/* 790 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
/*     */ 
/*     */     public native int distance_threshold();
/*     */ 
/*     */     public native DepthNormal distance_threshold(int paramInt);
/*     */ 
/*     */     public native int difference_threshold();
/*     */ 
/*     */     public native DepthNormal difference_threshold(int paramInt);
/*     */ 
/*     */     @Cast({"size_t"})
/*     */     public native long num_features();
/*     */ 
/*     */     public native DepthNormal num_features(long paramLong);
/*     */ 
/*     */     public native int extract_threshold();
/*     */ 
/*     */     public native DepthNormal extract_threshold(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 785 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::linemod")
/*     */   public static class ColorGradient extends opencv_objdetect.Modality
/*     */   {
/*     */     public ColorGradient()
/*     */     {
/* 764 */       allocate();
/*     */     }
/* 766 */     public ColorGradient(float weak_threshold, @Cast({"size_t"}) long num_features, float strong_threshold) { allocate(weak_threshold, num_features, strong_threshold); } 
/*     */     public ColorGradient(Pointer p) {
/* 768 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(float paramFloat1, @Cast({"size_t"}) long paramLong, float paramFloat2);
/*     */ 
/*     */     public native float weak_threshold();
/*     */ 
/*     */     public native ColorGradient weak_threshold(float paramFloat);
/*     */ 
/*     */     public native long num_features();
/*     */ 
/*     */     public native ColorGradient num_features(long paramLong);
/*     */ 
/*     */     public native float strong_threshold();
/*     */ 
/*     */     public native ColorGradient strong_threshold(float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 763 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::linemod")
/*     */   public static class Modality extends Pointer
/*     */   {
/*     */     public Modality()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Modality(Pointer p)
/*     */     {
/* 747 */       super();
/*     */     }
/*     */ 
/*     */     @opencv_core.Ptr
/*     */     public native opencv_objdetect.QuantizedPyramid process(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2);
/*     */ 
/*     */     @ByRef
/*     */     public native String name();
/*     */ 
/*     */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*     */ 
/*     */     @opencv_core.Ptr
/*     */     public static native Modality create(String paramString);
/*     */ 
/*     */     @opencv_core.Ptr
/*     */     public static native Modality create(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     static
/*     */     {
/* 745 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::linemod")
/*     */   public static class QuantizedPyramid extends Pointer
/*     */   {
/*     */     public QuantizedPyramid()
/*     */     {
/*     */     }
/*     */ 
/*     */     public QuantizedPyramid(Pointer p)
/*     */     {
/* 714 */       super();
/*     */     }
/*     */ 
/*     */     public native void quantize(@opencv_core.InputMat opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean extractTemplate(@ByRef opencv_objdetect.Template paramTemplate);
/*     */ 
/*     */     public native void pyrDown();
/*     */ 
/*     */     static
/*     */     {
/* 712 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::linemod")
/*     */   public static class Template extends Pointer
/*     */   {
/*     */     public Template()
/*     */     {
/* 691 */       allocate(); } 
/* 692 */     public Template(int size) { allocateArray(size); } 
/* 693 */     public Template(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 698 */     public Template position(int position) { return (Template)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int width();
/*     */ 
/*     */     public native Template width(int paramInt);
/*     */ 
/*     */     public native int height();
/*     */ 
/*     */     public native Template height(int paramInt);
/*     */ 
/*     */     public native int pyramid_level();
/*     */ 
/*     */     public native Template pyramid_level(int paramInt);
/*     */ 
/*     */     @Const
/*     */     @StdVector
/*     */     public native opencv_objdetect.Feature features();
/*     */ 
/*     */     public native Template features(opencv_objdetect.Feature paramFeature);
/*     */ 
/*     */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*     */ 
/*     */     static
/*     */     {
/* 690 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::linemod")
/*     */   public static class Feature extends Pointer
/*     */   {
/*     */     public Feature()
/*     */     {
/* 669 */       allocate(); } 
/* 670 */     public Feature(int x, int y, int label) { allocate(x, y, label); } 
/* 671 */     public Feature(int size) { allocateArray(size); } 
/* 672 */     public Feature(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 678 */     public Feature position(int position) { return (Feature)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int x();
/*     */ 
/*     */     public native Feature x(int paramInt);
/*     */ 
/*     */     public native int y();
/*     */ 
/*     */     public native Feature y(int paramInt);
/*     */ 
/*     */     public native int label();
/*     */ 
/*     */     public native Feature label(int paramInt);
/*     */ 
/*     */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*     */ 
/*     */     static
/*     */     {
/* 668 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Name({"std::deque<CvDataMatrixCode>"})
/*     */   public static class CvDataMatrixCodeDeque extends Pointer
/*     */   {
/*     */     public CvDataMatrixCodeDeque()
/*     */     {
/* 651 */       allocate(); } 
/* 652 */     public CvDataMatrixCodeDeque(long n) { allocate(n); } 
/* 653 */     public CvDataMatrixCodeDeque(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     public native long size();
/*     */ 
/*     */     public native void resize(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     @Index
/*     */     @ByRef
/*     */     public native opencv_objdetect.CvDataMatrixCode get(@Cast({"size_t"}) long paramLong);
/*     */ 
/*     */     public native CvDataMatrixCodeDeque put(@Cast({"size_t"}) long paramLong, opencv_objdetect.CvDataMatrixCode paramCvDataMatrixCode);
/*     */ 
/*     */     static
/*     */     {
/* 650 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvDataMatrixCode extends Pointer
/*     */   {
/*     */     public CvDataMatrixCode()
/*     */     {
/* 633 */       allocate(); } 
/* 634 */     public CvDataMatrixCode(int size) { allocateArray(size); } 
/* 635 */     public CvDataMatrixCode(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 640 */     public CvDataMatrixCode position(int position) { return (CvDataMatrixCode)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native String msg();
/*     */ 
/*     */     public native CvDataMatrixCode msg(String paramString);
/*     */ 
/*     */     public native opencv_core.CvMat original();
/*     */ 
/*     */     public native CvDataMatrixCode original(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat corners();
/*     */ 
/*     */     public native CvDataMatrixCode corners(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     static
/*     */     {
/* 632 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class HOGDescriptor extends Pointer
/*     */   {
/*     */     public static final int L2Hys = 0;
/*     */     public static final int DEFAULT_NLEVELS = 64;
/*     */ 
/*     */     public HOGDescriptor()
/*     */     {
/* 533 */       allocate();
/*     */     }
/*     */ 
/*     */     public HOGDescriptor(@ByVal opencv_core.CvSize _winSize, @ByVal opencv_core.CvSize _blockSize, @ByVal opencv_core.CvSize _blockStride, @ByVal opencv_core.CvSize _cellSize, int _nbins, int _derivAperture, double _winSigma, int _histogramNormType, double _L2HysThreshold, boolean _gammaCorrection, int _nlevels)
/*     */     {
/* 539 */       allocate(_winSize, _blockSize, _blockStride, _cellSize, _nbins, _derivAperture, _winSigma, _histogramNormType, _L2HysThreshold, _gammaCorrection, _nlevels);
/*     */     }
/*     */     public HOGDescriptor(String filename) {
/* 542 */       allocate(filename); } 
/* 543 */     public HOGDescriptor(@ByRef HOGDescriptor d) { allocate(d); } 
/* 544 */     public HOGDescriptor(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3, @ByVal opencv_core.CvSize paramCvSize4, int paramInt1, int paramInt2, double paramDouble1, int paramInt3, double paramDouble2, @Cast({"bool"}) boolean paramBoolean, int paramInt4);
/*     */ 
/*     */     private native void allocate(String paramString);
/*     */ 
/*     */     private native void allocate(@ByRef HOGDescriptor paramHOGDescriptor);
/*     */ 
/*     */     public native long getDescriptorSize();
/*     */ 
/*     */     public native boolean checkDetectorSize();
/*     */ 
/*     */     public native double getWinSigma();
/*     */ 
/*     */     public native void setSVMDetector(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*     */ 
/*     */     public native void setSVMDetector(@opencv_core.InputArray FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native boolean read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*     */ 
/*     */     public native boolean load(String paramString1, String paramString2);
/*     */ 
/*     */     public native void save(String paramString1, String paramString2);
/*     */ 
/*     */     public native void copyTo(@ByRef HOGDescriptor paramHOGDescriptor);
/*     */ 
/*     */     public native void compute(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint);
/*     */ 
/*     */     public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, @StdVector DoublePointer paramDoublePointer, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2);
/*     */ 
/*     */     public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2);
/*     */ 
/*     */     public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, int paramInt);
/*     */ 
/*     */     public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector DoublePointer paramDoublePointer, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble1, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native void computeGradient(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
/*     */ 
/*     */     @StdVector
/*     */     public static native FloatPointer getDefaultPeopleDetector();
/*     */ 
/*     */     @StdVector
/*     */     public static native FloatPointer getDaimlerPeopleDetector();
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.CvSize winSize();
/*     */ 
/*     */     public native HOGDescriptor winSize(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.CvSize blockSize();
/*     */ 
/*     */     public native HOGDescriptor blockSize(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.CvSize blockStride();
/*     */ 
/*     */     public native HOGDescriptor blockStride(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.CvSize cellSize();
/*     */ 
/*     */     public native HOGDescriptor cellSize(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     public native int nbins();
/*     */ 
/*     */     public native HOGDescriptor nbins(int paramInt);
/*     */ 
/*     */     public native int derivAperture();
/*     */ 
/*     */     public native HOGDescriptor derivAperture(int paramInt);
/*     */ 
/*     */     public native double winSigma();
/*     */ 
/*     */     public native HOGDescriptor winSigma(double paramDouble);
/*     */ 
/*     */     public native int histogramNormType();
/*     */ 
/*     */     public native HOGDescriptor histogramNormType(int paramInt);
/*     */ 
/*     */     public native double L2HysThreshold();
/*     */ 
/*     */     public native HOGDescriptor L2HysThreshold(double paramDouble);
/*     */ 
/*     */     @Cast({"bool"})
/*     */     public native boolean gammaCorrection();
/*     */ 
/*     */     public native HOGDescriptor gammaCorrection(boolean paramBoolean);
/*     */ 
/*     */     @Const
/*     */     @StdVector
/*     */     public native FloatPointer svmDetector();
/*     */ 
/*     */     public native HOGDescriptor svmDetector(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native int nlevels();
/*     */ 
/*     */     public native HOGDescriptor nlevels(int paramInt);
/*     */ 
/*     */     public native void detectROI(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @Const @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint1, @StdVector("CvPoint,cv::Point") opencv_core.CvPoint paramCvPoint2, @StdVector DoublePointer paramDoublePointer, double paramDouble, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
/*     */ 
/*     */     public native void detectMultiScaleROI(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector opencv_objdetect.DetectionROI paramDetectionROI, double paramDouble, int paramInt);
/*     */ 
/*     */     public native void readALTModel(String paramString);
/*     */ 
/*     */     public native void groupRectangles(@StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector DoublePointer paramDoublePointer, int paramInt, double paramDouble);
/*     */ 
/*     */     static
/*     */     {
/* 532 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class DetectionROI extends Pointer
/*     */   {
/*     */     public DetectionROI()
/*     */     {
/* 514 */       allocate(); } 
/* 515 */     public DetectionROI(int size) { allocateArray(size); } 
/* 516 */     public DetectionROI(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 521 */     public DetectionROI position(int position) { return (DetectionROI)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native double scale();
/*     */ 
/*     */     public native DetectionROI scale(double paramDouble);
/*     */ 
/*     */     @StdVector("CvPoint,cv::Point")
/*     */     public native opencv_core.CvPoint locations();
/*     */ 
/*     */     public native DetectionROI locations(opencv_core.CvPoint paramCvPoint);
/*     */ 
/*     */     @StdVector
/*     */     public native DoublePointer confidences();
/*     */ 
/*     */     public native DetectionROI confidences(DoublePointer paramDoublePointer);
/*     */ 
/*     */     static
/*     */     {
/* 513 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class CascadeClassifier extends Pointer
/*     */   {
/*     */     public CascadeClassifier()
/*     */     {
/* 386 */       allocate(); } 
/* 387 */     public CascadeClassifier(String filename) { allocate(filename); } 
/* 388 */     public CascadeClassifier(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(String paramString);
/*     */ 
/*     */     public native boolean empty();
/*     */ 
/*     */     public native boolean load(String paramString);
/*     */ 
/*     */     public native boolean read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2);
/*     */ 
/*     */     public native void detectMultiScale(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector("CvRect,cv::Rect") opencv_core.CvRect paramCvRect, @StdVector IntPointer paramIntPointer, @StdVector DoublePointer paramDoublePointer, double paramDouble, int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native boolean isOldFormatCascade();
/*     */ 
/*     */     @ByVal
/*     */     public native opencv_core.CvSize getOriginalWindowSize();
/*     */ 
/*     */     public native int getFeatureType();
/*     */ 
/*     */     public native boolean setImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*     */ 
/*     */     public native void setMaskGenerator(@opencv_core.Ptr MaskGenerator paramMaskGenerator);
/*     */ 
/*     */     @Const
/*     */     @opencv_core.Ptr
/*     */     public native MaskGenerator getMaskGenerator();
/*     */ 
/*     */     public native void setFaceDetectionMaskGenerator();
/*     */ 
/*     */     static
/*     */     {
/* 385 */       Loader.load();
/*     */     }
/*     */ 
/*     */     public static class MaskGenerator extends Pointer
/*     */     {
/*     */       public MaskGenerator()
/*     */       {
/*     */       }
/*     */ 
/*     */       public MaskGenerator(Pointer p)
/*     */       {
/* 498 */         super();
/*     */       }
/*     */ 
/*     */       @opencv_core.OutputMat
/*     */       public native opencv_core.CvMat generateMask(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */       public native void initializeMask(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */       static
/*     */       {
/* 496 */         Loader.load();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static class FeatureEvaluator extends Pointer
/*     */   {
/*     */     public static final int HAAR = 0;
/*     */     public static final int LBP = 1;
/*     */     public static final int HOG = 2;
/*     */ 
/*     */     public FeatureEvaluator()
/*     */     {
/* 359 */       allocate(); } 
/* 360 */     public FeatureEvaluator(int size) { allocateArray(size); } 
/* 361 */     public FeatureEvaluator(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 366 */     public FeatureEvaluator position(int position) { return (FeatureEvaluator)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native boolean read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*     */ 
/*     */     @opencv_core.Ptr
/*     */     public native FeatureEvaluator clone();
/*     */ 
/*     */     public native int getFeatureType();
/*     */ 
/*     */     public native boolean setImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     public native boolean setWindow(@ByVal opencv_core.CvPoint paramCvPoint);
/*     */ 
/*     */     public native double calcOrd(int paramInt);
/*     */ 
/*     */     public native int calcCat(int paramInt);
/*     */ 
/*     */     @opencv_core.Ptr
/*     */     public static native FeatureEvaluator create(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 358 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static class SimilarRects extends Pointer
/*     */   {
/*     */     public SimilarRects(double _eps)
/*     */     {
/* 336 */       allocate(_eps); } 
/* 337 */     public SimilarRects(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(double paramDouble);
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native boolean compute(@ByVal opencv_core.CvRect paramCvRect1, @ByVal opencv_core.CvRect paramCvRect2);
/*     */ 
/*     */     public native double eps();
/*     */ 
/*     */     public native SimilarRects eps(double paramDouble);
/*     */ 
/*     */     static
/*     */     {
/* 335 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvObjectDetection extends Pointer
/*     */   {
/*     */     public CvObjectDetection()
/*     */     {
/* 309 */       allocate(); } 
/* 310 */     public CvObjectDetection(int size) { allocateArray(size); } 
/* 311 */     public CvObjectDetection(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 316 */     public CvObjectDetection position(int position) { return (CvObjectDetection)super.position(position); }
/*     */ 
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvRect rect();
/*     */ 
/*     */     public native CvObjectDetection rect(opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     public native float score();
/*     */ 
/*     */     public native CvObjectDetection score(float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 308 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvLatentSvmDetector extends Pointer
/*     */   {
/*     */     public CvLatentSvmDetector()
/*     */     {
/* 288 */       allocate(); } 
/* 289 */     public CvLatentSvmDetector(int size) { allocateArray(size); } 
/* 290 */     public CvLatentSvmDetector(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 295 */     public CvLatentSvmDetector position(int position) { return (CvLatentSvmDetector)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int num_filters();
/*     */ 
/*     */     public native CvLatentSvmDetector num_filters(int paramInt);
/*     */ 
/*     */     public native int num_components();
/*     */ 
/*     */     public native CvLatentSvmDetector num_components(int paramInt);
/*     */ 
/*     */     public native IntPointer num_part_filters();
/*     */ 
/*     */     public native CvLatentSvmDetector num_part_filters(IntPointer paramIntPointer);
/*     */ 
/*     */     @Cast({"CvLSVMFilterObject**"})
/*     */     public native PointerPointer filters();
/*     */ 
/*     */     public native CvLatentSvmDetector filters(PointerPointer paramPointerPointer);
/*     */ 
/*     */     public native FloatPointer b();
/*     */ 
/*     */     public native CvLatentSvmDetector b(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native float score_threshold();
/*     */ 
/*     */     public native CvLatentSvmDetector score_threshold(float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 287 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvLSVMFilterObject extends Pointer
/*     */   {
/*     */     public CvLSVMFilterObject()
/*     */     {
/* 268 */       allocate(); } 
/* 269 */     public CvLSVMFilterObject(int size) { allocateArray(size); } 
/* 270 */     public CvLSVMFilterObject(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 275 */     public CvLSVMFilterObject position(int position) { return (CvLSVMFilterObject)super.position(position); }
/*     */ 
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_objdetect.CvLSVMFilterPosition V();
/*     */ 
/*     */     public native CvLSVMFilterObject V(opencv_objdetect.CvLSVMFilterPosition paramCvLSVMFilterPosition);
/*     */ 
/*     */     public native float fineFunction(int paramInt);
/*     */ 
/*     */     public native CvLSVMFilterObject fineFunction(int paramInt, float paramFloat);
/*     */ 
/*     */     public native int sizeX();
/*     */ 
/*     */     public native CvLSVMFilterObject sizeX(int paramInt);
/*     */ 
/*     */     public native int sizeY();
/*     */ 
/*     */     public native CvLSVMFilterObject sizeY(int paramInt);
/*     */ 
/*     */     public native int numFeatures();
/*     */ 
/*     */     public native CvLSVMFilterObject numFeatures(int paramInt);
/*     */ 
/*     */     public native FloatPointer H();
/*     */ 
/*     */     public native CvLSVMFilterObject H(FloatPointer paramFloatPointer);
/*     */ 
/*     */     static
/*     */     {
/* 267 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvLSVMFilterPosition extends Pointer
/*     */   {
/*     */     public CvLSVMFilterPosition()
/*     */     {
/* 251 */       allocate(); } 
/* 252 */     public CvLSVMFilterPosition(int size) { allocateArray(size); } 
/* 253 */     public CvLSVMFilterPosition(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 258 */     public CvLSVMFilterPosition position(int position) { return (CvLSVMFilterPosition)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int x();
/*     */ 
/*     */     public native CvLSVMFilterPosition x(int paramInt);
/*     */ 
/*     */     public native int y();
/*     */ 
/*     */     public native CvLSVMFilterPosition y(int paramInt);
/*     */ 
/*     */     public native int l();
/*     */ 
/*     */     public native CvLSVMFilterPosition l(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 250 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvAvgComp extends Pointer
/*     */   {
/*     */     public CvAvgComp()
/*     */     {
/* 211 */       allocate(); } 
/* 212 */     public CvAvgComp(int size) { allocateArray(size); } 
/* 213 */     public CvAvgComp(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 218 */     public CvAvgComp position(int position) { return (CvAvgComp)super.position(position); }
/*     */ 
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvRect rect();
/*     */ 
/*     */     public native CvAvgComp rect(opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     public native int neighbors();
/*     */ 
/*     */     public native CvAvgComp neighbors(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 210 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvHaarClassifierCascade extends Pointer
/*     */   {
/*     */     public CvHaarClassifierCascade()
/*     */     {
/* 171 */       allocate(); } 
/* 172 */     public CvHaarClassifierCascade(int size) { allocateArray(size); } 
/* 173 */     public CvHaarClassifierCascade(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 178 */     public CvHaarClassifierCascade position(int position) { return (CvHaarClassifierCascade)super.position(position); }
/*     */ 
/*     */ 
/*     */     public static CvHaarClassifierCascade load(String directory, opencv_core.CvSize orig_window_size)
/*     */     {
/* 183 */       CvHaarClassifierCascade h = opencv_objdetect.cvLoadHaarClassifierCascade(directory, orig_window_size);
/*     */ 
/* 185 */       if (h != null) {
/* 186 */         h.deallocator(new ReleaseDeallocator(h));
/*     */       }
/* 188 */       return h;
/*     */     }
/*     */ 
/*     */     public void release() {
/* 192 */       deallocate();
/*     */     }
/*     */ 
/*     */     public native int flags();
/*     */ 
/*     */     public native CvHaarClassifierCascade flags(int paramInt);
/*     */ 
/*     */     public native int count();
/*     */ 
/*     */     public native CvHaarClassifierCascade count(int paramInt);
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvSize orig_window_size();
/*     */ 
/*     */     public native CvHaarClassifierCascade orig_window_size(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvSize real_window_size();
/*     */ 
/*     */     public native CvHaarClassifierCascade real_window_size(opencv_core.CvSize paramCvSize);
/*     */ 
/*     */     public native double scale();
/*     */ 
/*     */     public native CvHaarClassifierCascade scale(double paramDouble);
/*     */ 
/*     */     public native opencv_objdetect.CvHaarStageClassifier stage_classifier();
/*     */ 
/*     */     public native CvHaarClassifierCascade stage_classifier(opencv_objdetect.CvHaarStageClassifier paramCvHaarStageClassifier);
/*     */ 
/*     */     public native opencv_objdetect.CvHidHaarClassifierCascade hid_cascade();
/*     */ 
/*     */     public native CvHaarClassifierCascade hid_cascade(opencv_objdetect.CvHidHaarClassifierCascade paramCvHidHaarClassifierCascade);
/*     */ 
/*     */     static
/*     */     {
/* 170 */       Loader.load();
/*     */     }
/*     */ 
/*     */     static class ReleaseDeallocator extends opencv_objdetect.CvHaarClassifierCascade
/*     */       implements Pointer.Deallocator
/*     */     {
/*     */       ReleaseDeallocator(opencv_objdetect.CvHaarClassifierCascade p)
/*     */       {
/* 195 */         super(); } 
/* 196 */       public void deallocate() { opencv_objdetect.cvReleaseHaarClassifierCascade(this); }
/*     */ 
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class CvHidHaarClassifierCascade extends Pointer
/*     */   {
/*     */     public CvHidHaarClassifierCascade()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CvHidHaarClassifierCascade(Pointer p)
/*     */     {
/* 166 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 164 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvHaarStageClassifier extends Pointer
/*     */   {
/*     */     public CvHaarStageClassifier()
/*     */     {
/* 144 */       allocate(); } 
/* 145 */     public CvHaarStageClassifier(int size) { allocateArray(size); } 
/* 146 */     public CvHaarStageClassifier(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 151 */     public CvHaarStageClassifier position(int position) { return (CvHaarStageClassifier)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int count();
/*     */ 
/*     */     public native CvHaarStageClassifier count(int paramInt);
/*     */ 
/*     */     public native float threshold();
/*     */ 
/*     */     public native CvHaarStageClassifier threshold(float paramFloat);
/*     */ 
/*     */     public native opencv_objdetect.CvHaarClassifier classifier();
/*     */ 
/*     */     public native CvHaarStageClassifier classifier(opencv_objdetect.CvHaarClassifier paramCvHaarClassifier);
/*     */ 
/*     */     public native int next();
/*     */ 
/*     */     public native CvHaarStageClassifier next(int paramInt);
/*     */ 
/*     */     public native int child();
/*     */ 
/*     */     public native CvHaarStageClassifier child(int paramInt);
/*     */ 
/*     */     public native int parent();
/*     */ 
/*     */     public native CvHaarStageClassifier parent(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 143 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvHaarClassifier extends Pointer
/*     */   {
/*     */     public CvHaarClassifier()
/*     */     {
/* 124 */       allocate(); } 
/* 125 */     public CvHaarClassifier(int size) { allocateArray(size); } 
/* 126 */     public CvHaarClassifier(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 131 */     public CvHaarClassifier position(int position) { return (CvHaarClassifier)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int count();
/*     */ 
/*     */     public native CvHaarClassifier count(int paramInt);
/*     */ 
/*     */     public native opencv_objdetect.CvHaarFeature haar_feature();
/*     */ 
/*     */     public native CvHaarClassifier haar_feature(opencv_objdetect.CvHaarFeature paramCvHaarFeature);
/*     */ 
/*     */     public native FloatPointer threshold();
/*     */ 
/*     */     public native CvHaarClassifier threshold(FloatPointer paramFloatPointer);
/*     */ 
/*     */     public native IntPointer left();
/*     */ 
/*     */     public native CvHaarClassifier left(IntPointer paramIntPointer);
/*     */ 
/*     */     public native IntPointer right();
/*     */ 
/*     */     public native CvHaarClassifier right(IntPointer paramIntPointer);
/*     */ 
/*     */     public native FloatPointer alpha();
/*     */ 
/*     */     public native CvHaarClassifier alpha(FloatPointer paramFloatPointer);
/*     */ 
/*     */     static
/*     */     {
/* 123 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvHaarFeature extends Pointer
/*     */   {
/*     */     public CvHaarFeature()
/*     */     {
/* 104 */       allocate(); } 
/* 105 */     public CvHaarFeature(int size) { allocateArray(size); } 
/* 106 */     public CvHaarFeature(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 111 */     public CvHaarFeature position(int position) { return (CvHaarFeature)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int tilted();
/*     */ 
/*     */     public native CvHaarFeature tilted(int paramInt);
/*     */ 
/*     */     @Name({"rect", ".r"})
/*     */     @ByRef
/*     */     public native opencv_core.CvRect rect_r(int paramInt);
/*     */ 
/*     */     public native CvHaarFeature rect_r(int paramInt, opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     @Name({"rect", ".weight"})
/*     */     public native float rect_weight(int paramInt);
/*     */ 
/*     */     public native CvHaarFeature rect_weight(int paramInt, float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 103 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_objdetect
 * JD-Core Version:    0.6.2
 */