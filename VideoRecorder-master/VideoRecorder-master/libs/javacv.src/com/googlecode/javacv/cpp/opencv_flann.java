/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacpp.annotation.StdVector;
/*     */ 
/*     */ @Properties(inherit={opencv_core.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/flann/miniflann.hpp>"}, link={"opencv_flann@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_flann248"})})
/*     */ public class opencv_flann
/*     */ {
/*     */   public static final String FLANN_VERSION_ = "1.6.10";
/*     */   public static final int FLANN_INDEX_LINEAR = 0;
/*     */   public static final int FLANN_INDEX_KDTREE = 1;
/*     */   public static final int FLANN_INDEX_KMEANS = 2;
/*     */   public static final int FLANN_INDEX_COMPOSITE = 3;
/*     */   public static final int FLANN_INDEX_SAVED = 254;
/*     */   public static final int FLANN_INDEX_AUTOTUNED = 255;
/*     */   public static final int FLANN_CENTERS_RANDOM = 0;
/*     */   public static final int FLANN_CENTERS_GONZALES = 1;
/*     */   public static final int FLANN_CENTERS_KMEANSPP = 2;
/*     */   public static final int FLANN_DIST_EUCLIDEAN = 1;
/*     */   public static final int FLANN_DIST_L2 = 1;
/*     */   public static final int FLANN_DIST_MANHATTAN = 2;
/*     */   public static final int FLANN_DIST_L1 = 2;
/*     */   public static final int FLANN_DIST_MINKOWSKI = 3;
/*     */   public static final int FLANN_DIST_MAX = 4;
/*     */   public static final int FLANN_DIST_HIST_INTERSECT = 5;
/*     */   public static final int FLANN_DIST_HELLINGER = 6;
/*     */   public static final int FLANN_DIST_CHI_SQUARE = 7;
/*     */   public static final int FLANN_DIST_CS = 7;
/*     */   public static final int FLANN_DIST_KULLBACK_LEIBLER = 8;
/*     */   public static final int FLANN_DIST_KL = 8;
/*     */   public static final int FLANN_DIST_HAMMING = 9;
/*     */ 
/*     */   static
/*     */   {
/*  83 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class Index extends Pointer
/*     */   {
/*     */     public Index()
/*     */     {
/* 237 */       allocate();
/*     */     }
/* 239 */     public Index(opencv_core.CvArr features, opencv_flann.IndexParams params, int distType) { allocate(features, params, distType); }
/*     */ 
/*     */     public Index(FloatPointer features, opencv_flann.IndexParams params, int distType) {
/* 242 */       allocate(features, params, distType);
/*     */     }
/* 244 */     public Index(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
/*     */ 
/*     */     private native void allocate(@opencv_core.InputArray FloatPointer paramFloatPointer, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
/*     */ 
/*     */     public native void build(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
/*     */ 
/*     */     public native void build(@opencv_core.InputArray FloatPointer paramFloatPointer, @ByRef opencv_flann.IndexParams paramIndexParams, @Cast({"cvflann::flann_distance_t"}) int paramInt);
/*     */ 
/*     */     public native void knnSearch(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
/*     */ 
/*     */     public native void knnSearch(@opencv_core.InputArray FloatPointer paramFloatPointer1, @opencv_core.OutputArray IntPointer paramIntPointer, @opencv_core.OutputArray FloatPointer paramFloatPointer2, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
/*     */ 
/*     */     public native int radiusSearch(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, double paramDouble, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
/*     */ 
/*     */     public native int radiusSearch(@opencv_core.InputArray FloatPointer paramFloatPointer1, @opencv_core.OutputArray IntPointer paramIntPointer, @opencv_core.OutputArray FloatPointer paramFloatPointer2, double paramDouble, int paramInt, @ByRef opencv_flann.SearchParams paramSearchParams);
/*     */ 
/*     */     public native void save(String paramString);
/*     */ 
/*     */     public native boolean load(@opencv_core.InputArray opencv_core.CvArr paramCvArr, String paramString);
/*     */ 
/*     */     public native boolean load(@opencv_core.InputArray FloatPointer paramFloatPointer, String paramString);
/*     */ 
/*     */     public native void release();
/*     */ 
/*     */     @Cast({"cvflann::flann_distance_t"})
/*     */     public native int getDistance();
/*     */ 
/*     */     @Cast({"cvflann::flann_algorithm_t"})
/*     */     public native int getAlgorithm();
/*     */ 
/*     */     static
/*     */     {
/* 236 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class SearchParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public SearchParams()
/*     */     {
/* 226 */       allocate();
/*     */     }
/* 228 */     public SearchParams(int checks, float eps, boolean sorted) { allocate(checks, eps, sorted); } 
/*     */     public SearchParams(Pointer p) {
/* 230 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt, float paramFloat, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     static
/*     */     {
/* 225 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class SavedIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public SavedIndexParams()
/*     */     {
/*     */     }
/*     */ 
/*     */     public SavedIndexParams(String filename)
/*     */     {
/* 219 */       allocate(filename); } 
/* 220 */     public SavedIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(String paramString);
/*     */ 
/*     */     static
/*     */     {
/* 217 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class LshIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public LshIndexParams(int table_number, int key_size, int multi_probe_level)
/*     */     {
/* 210 */       allocate(table_number, key_size, multi_probe_level);
/*     */     }
/* 212 */     public LshIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */     static
/*     */     {
/* 208 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class KMeansIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public KMeansIndexParams()
/*     */     {
/* 196 */       allocate();
/*     */     }
/*     */     public KMeansIndexParams(int branching, int iterations, int centers_init, float cb_index) {
/* 199 */       allocate(branching, iterations, centers_init, cb_index);
/*     */     }
/* 201 */     public KMeansIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, @Cast({"cvflann::flann_centers_init_t"}) int paramInt3, float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 195 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class HierarchicalClusteringIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public HierarchicalClusteringIndexParams()
/*     */     {
/* 183 */       allocate();
/*     */     }
/*     */     public HierarchicalClusteringIndexParams(int branching, int centers_init, int trees, int leaf_size) {
/* 186 */       allocate(branching, centers_init, trees, leaf_size);
/*     */     }
/* 188 */     public HierarchicalClusteringIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, @Cast({"cvflann::flann_centers_init_t"}) int paramInt2, int paramInt3, int paramInt4);
/*     */ 
/*     */     static
/*     */     {
/* 182 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class AutotunedIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public AutotunedIndexParams()
/*     */     {
/* 170 */       allocate();
/*     */     }
/*     */     public AutotunedIndexParams(float target_precision, float build_weight, float memory_weight, float sample_fraction) {
/* 173 */       allocate(target_precision, build_weight, memory_weight, sample_fraction);
/*     */     }
/* 175 */     public AutotunedIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */ 
/*     */     static
/*     */     {
/* 169 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class CompositeIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public CompositeIndexParams()
/*     */     {
/* 157 */       allocate();
/*     */     }
/*     */     public CompositeIndexParams(int trees, int branching, int iterations, int centers_init, float cb_index) {
/* 160 */       allocate(trees, branching, iterations, centers_init, cb_index);
/*     */     }
/* 162 */     public CompositeIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, @Cast({"cvflann::flann_centers_init_t"}) int paramInt4, float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 156 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class LinearIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public LinearIndexParams()
/*     */     {
/* 150 */       allocate(); } 
/* 151 */     public LinearIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     static
/*     */     {
/* 149 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Namespace("cv::flann")
/*     */   public static class KDTreeIndexParams extends opencv_flann.IndexParams
/*     */   {
/*     */     public KDTreeIndexParams()
/*     */     {
/* 141 */       allocate(); } 
/* 142 */     public KDTreeIndexParams(int trees) { allocate(trees); } 
/* 143 */     public KDTreeIndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 140 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv::flann")
/*     */   public static class IndexParams extends Pointer
/*     */   {
/*     */     public IndexParams()
/*     */     {
/* 118 */       allocate(); } 
/* 119 */     public IndexParams(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     @ByRef
/*     */     public native String getString(String paramString1, String paramString2);
/*     */ 
/*     */     public native int getInt(String paramString, int paramInt);
/*     */ 
/*     */     public native double getDouble(String paramString, double paramDouble);
/*     */ 
/*     */     public native void setString(String paramString1, String paramString2);
/*     */ 
/*     */     public native void setInt(String paramString, int paramInt);
/*     */ 
/*     */     public native void setDouble(String paramString, double paramDouble);
/*     */ 
/*     */     public native void setFloat(String paramString, float paramFloat);
/*     */ 
/*     */     public native void setBool(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*     */ 
/*     */     public native void setAlgorithm(int paramInt);
/*     */ 
/*     */     public native void getAll(@ByRef opencv_core.StringVector paramStringVector1, @StdVector IntPointer paramIntPointer, @ByRef opencv_core.StringVector paramStringVector2, @StdVector DoublePointer paramDoublePointer);
/*     */ 
/*     */     public native Pointer params();
/*     */ 
/*     */     public native IndexParams params(Pointer paramPointer);
/*     */ 
/*     */     static
/*     */     {
/* 117 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_flann
 * JD-Core Version:    0.6.2
 */