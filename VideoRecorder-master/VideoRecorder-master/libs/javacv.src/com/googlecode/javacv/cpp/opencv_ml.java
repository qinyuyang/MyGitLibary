/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BoolPointer;
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.ShortPointer;
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
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ 
/*      */ @Properties(inherit={opencv_core.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/ml/ml.hpp>"}, link={"opencv_ml@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_ml248"})})
/*      */ public class opencv_ml
/*      */ {
/*      */   public static final double CV_LOG2PI = 1.837877066409346D;
/*      */   public static final int CV_COL_SAMPLE = 0;
/*      */   public static final int CV_ROW_SAMPLE = 1;
/*      */   public static final int CV_VAR_NUMERICAL = 0;
/*      */   public static final int CV_VAR_ORDERED = 0;
/*      */   public static final int CV_VAR_CATEGORICAL = 1;
/*      */   public static final String CV_TYPE_NAME_ML_SVM = "opencv-ml-svm";
/*      */   public static final String CV_TYPE_NAME_ML_KNN = "opencv-ml-knn";
/*      */   public static final String CV_TYPE_NAME_ML_NBAYES = "opencv-ml-bayesian";
/*      */   public static final String CV_TYPE_NAME_ML_EM = "opencv-ml-em";
/*      */   public static final String CV_TYPE_NAME_ML_BOOSTING = "opencv-ml-boost-tree";
/*      */   public static final String CV_TYPE_NAME_ML_TREE = "opencv-ml-tree";
/*      */   public static final String CV_TYPE_NAME_ML_ANN_MLP = "opencv-ml-ann-mlp";
/*      */   public static final String CV_TYPE_NAME_ML_CNN = "opencv-ml-cnn";
/*      */   public static final String CV_TYPE_NAME_ML_RTREES = "opencv-ml-random-trees";
/*      */   public static final String CV_TYPE_NAME_ML_ERTREES = "opencv-ml-extremely-randomized-trees";
/*      */   public static final String CV_TYPE_NAME_ML_GBT = "opencv-ml-gradient-boosting-trees";
/*      */   public static final int CV_TRAIN_ERROR = 0;
/*      */   public static final int CV_TEST_ERROR = 1;
/*      */   public static final int CV_TS_CONCENTRIC_SPHERES = 0;
/*      */   public static final int CV_COUNT = 0;
/*      */   public static final int CV_PORTION = 1;
/*      */ 
/*      */   @Namespace("cv")
/*      */   @Cast({"bool"})
/*      */   public static native boolean initModule_ml();
/*      */ 
/*      */   public static int CV_IS_ROW_SAMPLE(int flags)
/*      */   {
/*  106 */     return flags & 0x1;
/*      */   }
/*      */ 
/*      */   public static native int CV_DTREE_CAT_DIR(int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void cvRandMVNormal(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvRNG paramCvRNG);
/*      */ 
/*      */   public static native void cvRandGaussMixture(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2, float[] paramArrayOfFloat, int paramInt, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */   public static native void cvCreateTestSet(int paramInt1, opencv_core.CvMatArray paramCvMatArray1, int paramInt2, int paramInt3, opencv_core.CvMatArray paramCvMatArray2, int paramInt4, Pointer paramPointer);
/*      */ 
/*      */   static
/*      */   {
/*   92 */     Loader.load(opencv_core.class);
/*   93 */     if (Loader.load() != null)
/*   94 */       initModule_ml();
/*      */   }
/*      */ 
/*      */   public static class CvMLData extends Pointer
/*      */   {
/*      */     public CvMLData()
/*      */     {
/* 1481 */       allocate(); } 
/* 1482 */     public CvMLData(int size) { allocateArray(size); } 
/* 1483 */     public CvMLData(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1488 */     public CvMLData position(int position) { return (CvMLData)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int read_csv(String paramString);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_values();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_responses();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_missing();
/*      */ 
/*      */     public native void set_response_idx(int paramInt);
/*      */ 
/*      */     public native int get_response_idx();
/*      */ 
/*      */     public native void set_train_test_split(opencv_ml.CvTrainTestSplit paramCvTrainTestSplit);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_train_sample_idx();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_test_sample_idx();
/*      */ 
/*      */     public native void mix_train_and_test_idx();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_var_idx();
/*      */ 
/*      */     public native void change_var_idx(int paramInt, boolean paramBoolean);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_var_types();
/*      */ 
/*      */     public native int get_var_type(int paramInt);
/*      */ 
/*      */     public native void set_var_types(String paramString);
/*      */ 
/*      */     public native void change_var_type(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void set_delimiter(byte paramByte);
/*      */ 
/*      */     public native byte get_delimiter();
/*      */ 
/*      */     public native void set_miss_ch(byte paramByte);
/*      */ 
/*      */     public native byte get_miss_ch();
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_ml.StringIntMap get_class_labels_map();
/*      */ 
/*      */     static
/*      */     {
/* 1480 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::map<std::string, int>"})
/*      */   public static class StringIntMap extends Pointer
/*      */   {
/*      */     public StringIntMap()
/*      */     {
/* 1469 */       allocate(); } 
/* 1470 */     public StringIntMap(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native long size();
/*      */ 
/*      */     @Index
/*      */     public native int get(String paramString);
/*      */ 
/*      */     public native StringIntMap put(String paramString, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1468 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvTrainTestSplit extends Pointer
/*      */   {
/*      */     public CvTrainTestSplit()
/*      */     {
/* 1443 */       allocate(); } 
/* 1444 */     public CvTrainTestSplit(int train_sample_count, boolean mix) { allocate(train_sample_count, mix); } 
/* 1445 */     public CvTrainTestSplit(float train_sample_portion, boolean mix) { allocate(train_sample_portion, mix); } 
/* 1446 */     public CvTrainTestSplit(int size) { allocateArray(size); } 
/* 1447 */     public CvTrainTestSplit(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt, boolean paramBoolean);
/*      */ 
/*      */     private native void allocate(float paramFloat, boolean paramBoolean);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1454 */     public CvTrainTestSplit position(int position) { return (CvTrainTestSplit)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Name({"train_sample_part.count"})
/*      */     public native int train_sample_part_count();
/*      */ 
/*      */     public native CvTrainTestSplit train_sample_part_count(int paramInt);
/*      */ 
/*      */     @Name({"train_sample_part.portion"})
/*      */     public native float train_sample_part_portion();
/*      */ 
/*      */     public native CvTrainTestSplit train_sample_part_portion(float paramFloat);
/*      */ 
/*      */     public native int train_sample_part_mode();
/*      */ 
/*      */     public native CvTrainTestSplit train_sample_part_mode(int paramInt);
/*      */ 
/*      */     public native boolean mix();
/*      */ 
/*      */     public native CvTrainTestSplit mix(boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/* 1442 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvANN_MLP extends opencv_ml.CvStatModel
/*      */   {
/*      */     public static final int IDENTITY = 0;
/*      */     public static final int SIGMOID_SYM = 1;
/*      */     public static final int GAUSSIAN = 2;
/*      */     public static final int UPDATE_WEIGHTS = 1;
/*      */     public static final int NO_INPUT_SCALE = 2;
/*      */     public static final int NO_OUTPUT_SCALE = 4;
/*      */ 
/*      */     public CvANN_MLP()
/*      */     {
/* 1361 */       allocate();
/*      */     }
/*      */     public CvANN_MLP(opencv_core.CvMat layerSizes, int activateFunc, double fparam1, double fparam2) {
/* 1364 */       allocate(layerSizes, activateFunc, fparam1, fparam2);
/*      */     }
/* 1366 */     public CvANN_MLP(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native void create(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native int train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvANN_MLP_TrainParams paramCvANN_MLP_TrainParams, int paramInt);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native int get_layer_count();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_layer_sizes();
/*      */ 
/*      */     public native DoublePointer get_weights(int paramInt);
/*      */ 
/*      */     public native void calc_activ_func_deriv(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, double[] paramArrayOfDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1360 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvANN_MLP_TrainParams extends Pointer
/*      */   {
/*      */     public static final int BACKPROP = 0;
/*      */     public static final int RPROP = 1;
/*      */ 
/*      */     public CvANN_MLP_TrainParams()
/*      */     {
/* 1328 */       allocate();
/*      */     }
/* 1330 */     public CvANN_MLP_TrainParams(opencv_core.CvTermCriteria term_crit, int train_method, double param1, double param2) { allocate(term_crit, train_method, param1, param2); } 
/*      */     public CvANN_MLP_TrainParams(int size) {
/* 1332 */       allocateArray(size); } 
/* 1333 */     public CvANN_MLP_TrainParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1339 */     public CvANN_MLP_TrainParams position(int position) { return (CvANN_MLP_TrainParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvTermCriteria term_crit();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     public native int train_method();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams train_method(int paramInt);
/*      */ 
/*      */     public native double bp_dw_scale();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams bp_dw_scale(double paramDouble);
/*      */ 
/*      */     public native double bp_moment_scale();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams bp_moment_scale(double paramDouble);
/*      */ 
/*      */     public native double rp_dw0();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams rp_dw0(double paramDouble);
/*      */ 
/*      */     public native double rp_dw_plus();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams rp_dw_plus(double paramDouble);
/*      */ 
/*      */     public native double rp_dw_minus();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams rp_dw_minus(double paramDouble);
/*      */ 
/*      */     public native double rp_dw_min();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams rp_dw_min(double paramDouble);
/*      */ 
/*      */     public native double rp_dw_max();
/*      */ 
/*      */     public native CvANN_MLP_TrainParams rp_dw_max(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1327 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGBTrees extends opencv_ml.CvStatModel
/*      */   {
/*      */     public static final int SQUARED_LOSS = 0;
/*      */     public static final int ABSOLUTE_LOSS = 1;
/*      */     public static final int HUBER_LOSS = 3;
/*      */     public static final int DEVIANCE_LOSS = 4;
/*      */ 
/*      */     public CvGBTrees()
/*      */     {
/* 1265 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvGBTrees(opencv_core.CvMat trainData, int tflag, opencv_core.CvMat responses, opencv_core.CvMat varIdx, opencv_core.CvMat sampleIdx, opencv_core.CvMat varType, opencv_core.CvMat missingDataMask, @ByVal opencv_ml.CvGBTreesParams params) {
/* 1269 */       allocate(trainData, tflag, responses, varIdx, sampleIdx, varType, missingDataMask, params);
/*      */     }
/* 1271 */     public CvGBTrees(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams, boolean paramBoolean);
/*      */ 
/*      */     public native boolean train(opencv_ml.CvMLData paramCvMLData, @ByVal opencv_ml.CvGBTreesParams paramCvGBTreesParams, boolean paramBoolean);
/*      */ 
/*      */     public native float predict_serial(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
/*      */ 
/*      */     public native float calc_error(opencv_ml.CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/* 1264 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvGBTreesParams extends opencv_ml.CvDTreeParams
/*      */   {
/*      */     public CvGBTreesParams()
/*      */     {
/* 1241 */       allocate();
/*      */     }
/*      */     public CvGBTreesParams(int loss_function_type, int weak_count, float shrinkage, float subsample_portion, int max_depth, boolean use_surrogates) {
/* 1244 */       allocate(loss_function_type, weak_count, shrinkage, subsample_portion, max_depth, use_surrogates);
/*      */     }
/* 1246 */     public CvGBTreesParams(int size) { allocateArray(size); } 
/* 1247 */     public CvGBTreesParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, boolean paramBoolean);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1254 */     public CvGBTreesParams position(int position) { return (CvGBTreesParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int weak_count();
/*      */ 
/*      */     public native CvGBTreesParams weak_count(int paramInt);
/*      */ 
/*      */     public native int loss_function_type();
/*      */ 
/*      */     public native CvGBTreesParams loss_function_type(int paramInt);
/*      */ 
/*      */     public native float subsample_portion();
/*      */ 
/*      */     public native CvGBTreesParams subsample_portion(float paramFloat);
/*      */ 
/*      */     public native float shrinkage();
/*      */ 
/*      */     public native CvGBTreesParams shrinkage(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 1240 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBoost extends opencv_ml.CvStatModel
/*      */   {
/*      */     public static final int DISCRETE = 0;
/*      */     public static final int REAL = 1;
/*      */     public static final int LOGIT = 2;
/*      */     public static final int GENTLE = 3;
/*      */     public static final int DEFAULT = 0;
/*      */     public static final int GINI = 1;
/*      */     public static final int MISCLASS = 3;
/*      */     public static final int SQERR = 4;
/*      */ 
/*      */     public CvBoost()
/*      */     {
/* 1176 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvBoost(opencv_core.CvMat trainData, int tflag, opencv_core.CvMat responses, opencv_core.CvMat varIdx, opencv_core.CvMat sampleIdx, opencv_core.CvMat varType, opencv_core.CvMat missingDataMask, @ByVal opencv_ml.CvBoostParams params) {
/* 1180 */       allocate(trainData, tflag, responses, varIdx, sampleIdx, varType, missingDataMask, params);
/*      */     }
/* 1182 */     public CvBoost(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvBoostParams paramCvBoostParams);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvBoostParams paramCvBoostParams, boolean paramBoolean);
/*      */ 
/*      */     public native boolean train(opencv_ml.CvMLData paramCvMLData, @ByVal opencv_ml.CvBoostParams paramCvBoostParams, boolean paramBoolean);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSlice paramCvSlice, boolean paramBoolean1, boolean paramBoolean2);
/*      */ 
/*      */     public native float calc_error(opencv_ml.CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native void prune(@ByVal opencv_core.CvSlice paramCvSlice);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_active_vars(boolean paramBoolean);
/*      */ 
/*      */     public native opencv_core.CvSeq get_weak_predictors();
/*      */ 
/*      */     public native opencv_core.CvMat get_weights();
/*      */ 
/*      */     public native opencv_core.CvMat get_subtree_weights();
/*      */ 
/*      */     public native opencv_core.CvMat get_weak_response();
/*      */ 
/*      */     @Const
/*      */     @ByRef
/*      */     public native opencv_ml.CvBoostParams get_params();
/*      */ 
/*      */     @Const
/*      */     public native opencv_ml.CvDTreeTrainData get_data();
/*      */ 
/*      */     static
/*      */     {
/* 1175 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBoostTree extends opencv_ml.CvDTree
/*      */   {
/*      */     public CvBoostTree()
/*      */     {
/* 1139 */       allocate(); } 
/* 1140 */     public CvBoostTree(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean train(opencv_ml.CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat, opencv_ml.CvBoost paramCvBoost);
/*      */ 
/*      */     public native void scale(double paramDouble);
/*      */ 
/*      */     public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, opencv_ml.CvBoost paramCvBoost, opencv_ml.CvDTreeTrainData paramCvDTreeTrainData);
/*      */ 
/*      */     static
/*      */     {
/* 1138 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvBoostParams extends opencv_ml.CvDTreeParams
/*      */   {
/*      */     public CvBoostParams()
/*      */     {
/* 1115 */       allocate();
/*      */     }
/*      */     public CvBoostParams(int boost_type, int weak_count, double weight_trim_rate, int max_depth, boolean use_surrogates, float[] priors) {
/* 1118 */       allocate(boost_type, weak_count, weight_trim_rate, max_depth, use_surrogates, priors);
/*      */     }
/* 1120 */     public CvBoostParams(int size) { allocateArray(size); } 
/* 1121 */     public CvBoostParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, double paramDouble, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1128 */     public CvBoostParams position(int position) { return (CvBoostParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int boost_type();
/*      */ 
/*      */     public native CvBoostParams boost_type(int paramInt);
/*      */ 
/*      */     public native int weak_count();
/*      */ 
/*      */     public native CvBoostParams weak_count(int paramInt);
/*      */ 
/*      */     public native int split_criteria();
/*      */ 
/*      */     public native CvBoostParams split_criteria(int paramInt);
/*      */ 
/*      */     public native double weight_trim_rate();
/*      */ 
/*      */     public native CvBoostParams weight_trim_rate(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1114 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvERTrees extends opencv_ml.CvRTrees
/*      */   {
/*      */     public CvERTrees()
/*      */     {
/* 1099 */       allocate(); } 
/* 1100 */     public CvERTrees(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/* 1098 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvForestERTree extends opencv_ml.CvForestTree
/*      */   {
/*      */     public CvForestERTree()
/*      */     {
/* 1081 */       allocate(); } 
/* 1082 */     public CvForestERTree(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/* 1080 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvERTreeTrainData extends opencv_ml.CvDTreeTrainData
/*      */   {
/*      */     public CvERTreeTrainData()
/*      */     {
/* 1058 */       allocate(); } 
/* 1059 */     public CvERTreeTrainData(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat missing_mask();
/*      */ 
/*      */     public native CvERTreeTrainData missing_mask(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/* 1057 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvRTrees extends opencv_ml.CvStatModel
/*      */   {
/*      */     public CvRTrees()
/*      */     {
/* 1010 */       allocate(); } 
/* 1011 */     public CvRTrees(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvRTParams paramCvRTParams);
/*      */ 
/*      */     public native boolean train(opencv_ml.CvMLData paramCvMLData, @ByVal opencv_ml.CvRTParams paramCvRTParams);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native float predict_prob(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_var_importance();
/*      */ 
/*      */     public native float get_proximity(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
/*      */ 
/*      */     public native float calc_error(opencv_ml.CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native float get_train_error();
/*      */ 
/*      */     public native opencv_core.CvMat get_active_var_mask();
/*      */ 
/*      */     public native opencv_core.CvRNG get_rng();
/*      */ 
/*      */     public native int get_tree_count();
/*      */ 
/*      */     public native opencv_ml.CvForestTree get_tree(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1009 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvRTParams extends opencv_ml.CvDTreeParams
/*      */   {
/*      */     public CvRTParams()
/*      */     {
/*  983 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvRTParams(int max_depth, int min_sample_count, float regression_accuracy, boolean use_surrogates, int max_categories, float[] priors, boolean calc_var_importance, int nactive_vars, int max_num_of_trees_in_the_forest, float forest_accuracy, int termcrit_type) {
/*  987 */       allocate(max_depth, min_sample_count, regression_accuracy, use_surrogates, max_categories, priors, calc_var_importance, nactive_vars, max_num_of_trees_in_the_forest, forest_accuracy, termcrit_type);
/*      */     }
/*      */ 
/*      */     public CvRTParams(int size) {
/*  991 */       allocateArray(size); } 
/*  992 */     public CvRTParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat1, boolean paramBoolean1, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean2, int paramInt4, int paramInt5, float paramFloat2, int paramInt6);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public CvRTParams position(int position) {
/* 1000 */       return (CvRTParams)super.position(position);
/*      */     }
/*      */ 
/*      */     public native boolean calc_var_importance();
/*      */ 
/*      */     public native CvRTParams calc_var_importance(boolean paramBoolean);
/*      */ 
/*      */     public native int nactive_vars();
/*      */ 
/*      */     public native CvRTParams nactive_vars(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvTermCriteria term_crit();
/*      */ 
/*      */     public native CvRTParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     static
/*      */     {
/*  982 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvForestTree extends opencv_ml.CvDTree
/*      */   {
/*      */     public CvForestTree()
/*      */     {
/*  960 */       allocate(); } 
/*  961 */     public CvForestTree(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean train(opencv_ml.CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat, opencv_ml.CvRTrees paramCvRTrees);
/*      */ 
/*      */     public native int get_var_count();
/*      */ 
/*      */     public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, opencv_ml.CvRTrees paramCvRTrees, opencv_ml.CvDTreeTrainData paramCvDTreeTrainData);
/*      */ 
/*      */     static
/*      */     {
/*  959 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvDTree extends opencv_ml.CvStatModel
/*      */   {
/*      */     public CvDTree()
/*      */     {
/*  891 */       allocate(); } 
/*  892 */     public CvDTree(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByVal opencv_ml.CvDTreeParams paramCvDTreeParams);
/*      */ 
/*      */     public native boolean train(opencv_ml.CvMLData paramCvMLData, @ByVal opencv_ml.CvDTreeParams paramCvDTreeParams);
/*      */ 
/*      */     public native float calc_error(opencv_ml.CvMLData paramCvMLData, int paramInt, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native boolean train(opencv_ml.CvDTreeTrainData paramCvDTreeTrainData, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_ml.CvDTreeNode predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, boolean paramBoolean);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_var_importance();
/*      */ 
/*      */     public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, opencv_ml.CvDTreeTrainData paramCvDTreeTrainData);
/*      */ 
/*      */     public native void write(opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     @Const
/*      */     public native opencv_ml.CvDTreeNode get_root();
/*      */ 
/*      */     public native int get_pruned_tree_idx();
/*      */ 
/*      */     public native opencv_ml.CvDTreeTrainData get_data();
/*      */ 
/*      */     public native int pruned_tree_idx();
/*      */ 
/*      */     public native CvDTree pruned_tree_idx(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  890 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvDTreeTrainData extends Pointer
/*      */   {
/*      */     public CvDTreeTrainData()
/*      */     {
/*  787 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvDTreeTrainData(opencv_core.CvMat trainData, int tflag, opencv_core.CvMat responses, opencv_core.CvMat varIdx, opencv_core.CvMat sampleIdx, opencv_core.CvMat varType, opencv_core.CvMat missingDataMask, opencv_ml.CvDTreeParams params, boolean _shared, boolean _add_labels) {
/*  791 */       allocate(trainData, tflag, responses, varIdx, sampleIdx, varType, missingDataMask, params, _shared, _add_labels);
/*      */     }
/*  793 */     public CvDTreeTrainData(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByRef opencv_ml.CvDTreeParams paramCvDTreeParams, boolean paramBoolean1, boolean paramBoolean2);
/*      */ 
/*      */     public native void set_data(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, @ByRef opencv_ml.CvDTreeParams paramCvDTreeParams, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*      */ 
/*      */     public native void do_responses_copy();
/*      */ 
/*      */     public native void get_vectors(opencv_core.CvMat paramCvMat, float[] paramArrayOfFloat1, @Cast({"uchar*"}) byte[] paramArrayOfByte, float[] paramArrayOfFloat2, boolean paramBoolean);
/*      */ 
/*      */     public native opencv_ml.CvDTreeNode subsample_data(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native void write_params(opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void read_params(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native int get_num_classes();
/*      */ 
/*      */     public native int get_var_type(int paramInt);
/*      */ 
/*      */     public native int get_work_var_count();
/*      */ 
/*      */     @Const
/*      */     public native FloatPointer get_ord_responses(opencv_ml.CvDTreeNode paramCvDTreeNode, float[] paramArrayOfFloat, int[] paramArrayOfInt);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer get_class_labels(opencv_ml.CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer get_cv_labels(opencv_ml.CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer get_sample_indices(opencv_ml.CvDTreeNode paramCvDTreeNode, int[] paramArrayOfInt);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer get_cat_var_data(opencv_ml.CvDTreeNode paramCvDTreeNode, int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */     public native void get_ord_var_data(opencv_ml.CvDTreeNode paramCvDTreeNode, int paramInt, float[] paramArrayOfFloat, int[] paramArrayOfInt1, @Cast({"const float**"}) PointerPointer paramPointerPointer1, @Cast({"const int**"}) PointerPointer paramPointerPointer2, int[] paramArrayOfInt2);
/*      */ 
/*      */     public native int get_child_buf_idx(opencv_ml.CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native boolean set_params(@ByRef opencv_ml.CvDTreeParams paramCvDTreeParams);
/*      */ 
/*      */     public native opencv_ml.CvDTreeNode new_node(opencv_ml.CvDTreeNode paramCvDTreeNode, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     public native opencv_ml.CvDTreeSplit new_split_ord(int paramInt1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2);
/*      */ 
/*      */     public native opencv_ml.CvDTreeSplit new_split_cat(int paramInt, float paramFloat);
/*      */ 
/*      */     public native void free_node_data(opencv_ml.CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native void free_train_data();
/*      */ 
/*      */     public native void free_node(opencv_ml.CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native int sample_count();
/*      */ 
/*      */     public native CvDTreeTrainData sample_count(int paramInt);
/*      */ 
/*      */     public native int var_all();
/*      */ 
/*      */     public native CvDTreeTrainData var_all(int paramInt);
/*      */ 
/*      */     public native int var_count();
/*      */ 
/*      */     public native CvDTreeTrainData var_count(int paramInt);
/*      */ 
/*      */     public native int max_c_count();
/*      */ 
/*      */     public native CvDTreeTrainData max_c_count(int paramInt);
/*      */ 
/*      */     public native int ord_var_count();
/*      */ 
/*      */     public native CvDTreeTrainData ord_var_count(int paramInt);
/*      */ 
/*      */     public native int cat_var_count();
/*      */ 
/*      */     public native CvDTreeTrainData cat_var_count(int paramInt);
/*      */ 
/*      */     public native int work_var_count();
/*      */ 
/*      */     public native CvDTreeTrainData work_var_count(int paramInt);
/*      */ 
/*      */     public native boolean have_labels();
/*      */ 
/*      */     public native CvDTreeTrainData have_labels(boolean paramBoolean);
/*      */ 
/*      */     public native boolean have_priors();
/*      */ 
/*      */     public native CvDTreeTrainData have_priors(boolean paramBoolean);
/*      */ 
/*      */     public native boolean is_classifier();
/*      */ 
/*      */     public native CvDTreeTrainData is_classifier(boolean paramBoolean);
/*      */ 
/*      */     public native int tflag();
/*      */ 
/*      */     public native CvDTreeTrainData tflag(int paramInt);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat train_data();
/*      */ 
/*      */     public native CvDTreeTrainData train_data(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat responses();
/*      */ 
/*      */     public native CvDTreeTrainData responses(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat responses_copy();
/*      */ 
/*      */     public native CvDTreeTrainData responses_copy(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native int buf_count();
/*      */ 
/*      */     public native CvDTreeTrainData buf_count(int paramInt);
/*      */ 
/*      */     public native int buf_size();
/*      */ 
/*      */     public native CvDTreeTrainData buf_size(int paramInt);
/*      */ 
/*      */     public native boolean shared();
/*      */ 
/*      */     public native CvDTreeTrainData shared(boolean paramBoolean);
/*      */ 
/*      */     public native int is_buf_16u();
/*      */ 
/*      */     public native CvDTreeTrainData is_buf_16u(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvMat cat_count();
/*      */ 
/*      */     public native CvDTreeTrainData cat_count(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat cat_ofs();
/*      */ 
/*      */     public native CvDTreeTrainData cat_ofs(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat cat_map();
/*      */ 
/*      */     public native CvDTreeTrainData cat_map(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat counts();
/*      */ 
/*      */     public native CvDTreeTrainData counts(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat buf();
/*      */ 
/*      */     public native CvDTreeTrainData buf(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native long get_length_subbuf();
/*      */ 
/*      */     public native opencv_core.CvMat direction();
/*      */ 
/*      */     public native CvDTreeTrainData direction(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat split_buf();
/*      */ 
/*      */     public native CvDTreeTrainData split_buf(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat var_idx();
/*      */ 
/*      */     public native CvDTreeTrainData var_idx(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat var_type();
/*      */ 
/*      */     public native CvDTreeTrainData var_type(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat priors();
/*      */ 
/*      */     public native CvDTreeTrainData priors(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat priors_mult();
/*      */ 
/*      */     public native CvDTreeTrainData priors_mult(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_ml.CvDTreeParams params();
/*      */ 
/*      */     public native CvDTreeTrainData params(opencv_ml.CvDTreeParams paramCvDTreeParams);
/*      */ 
/*      */     public native opencv_core.CvMemStorage tree_storage();
/*      */ 
/*      */     public native CvDTreeTrainData tree_storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native opencv_core.CvMemStorage temp_storage();
/*      */ 
/*      */     public native CvDTreeTrainData temp_storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native opencv_ml.CvDTreeNode data_root();
/*      */ 
/*      */     public native CvDTreeTrainData data_root(opencv_ml.CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native opencv_core.CvSet node_heap();
/*      */ 
/*      */     public native CvDTreeTrainData node_heap(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     public native opencv_core.CvSet split_heap();
/*      */ 
/*      */     public native CvDTreeTrainData split_heap(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     public native opencv_core.CvSet cv_heap();
/*      */ 
/*      */     public native CvDTreeTrainData cv_heap(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     public native opencv_core.CvSet nv_heap();
/*      */ 
/*      */     public native CvDTreeTrainData nv_heap(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     @Const
/*      */     @Adapter("RNGAdapter")
/*      */     public native opencv_core.CvRNG rng();
/*      */ 
/*      */     public native CvDTreeTrainData rng(opencv_core.CvRNG paramCvRNG);
/*      */ 
/*      */     static
/*      */     {
/*  786 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvDTreeParams extends Pointer
/*      */   {
/*      */     public CvDTreeParams()
/*      */     {
/*  757 */       allocate();
/*      */     }
/*      */     public CvDTreeParams(int max_depth, int min_sample_count, float regression_accuracy, boolean use_surrogates, int max_categories, int cv_folds, boolean use_1se_rule, boolean truncate_pruned_tree, float[] priors) {
/*  760 */       allocate(max_depth, min_sample_count, regression_accuracy, use_surrogates, max_categories, cv_folds, use_1se_rule, truncate_pruned_tree, priors);
/*      */     }
/*      */     public CvDTreeParams(int size) {
/*  763 */       allocateArray(size); } 
/*  764 */     public CvDTreeParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  771 */     public CvDTreeParams position(int position) { return (CvDTreeParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int max_categories();
/*      */ 
/*      */     public native CvDTreeParams max_categories(int paramInt);
/*      */ 
/*      */     public native int max_depth();
/*      */ 
/*      */     public native CvDTreeParams max_depth(int paramInt);
/*      */ 
/*      */     public native int min_sample_count();
/*      */ 
/*      */     public native CvDTreeParams min_sample_count(int paramInt);
/*      */ 
/*      */     public native int cv_folds();
/*      */ 
/*      */     public native CvDTreeParams cv_folds(int paramInt);
/*      */ 
/*      */     public native boolean use_surrogates();
/*      */ 
/*      */     public native CvDTreeParams use_surrogates(boolean paramBoolean);
/*      */ 
/*      */     public native boolean use_1se_rule();
/*      */ 
/*      */     public native CvDTreeParams use_1se_rule(boolean paramBoolean);
/*      */ 
/*      */     public native boolean truncate_pruned_tree();
/*      */ 
/*      */     public native CvDTreeParams truncate_pruned_tree(boolean paramBoolean);
/*      */ 
/*      */     public native float regression_accuracy();
/*      */ 
/*      */     public native CvDTreeParams regression_accuracy(float paramFloat);
/*      */ 
/*      */     @Const
/*      */     public native FloatPointer priors();
/*      */ 
/*      */     public native CvDTreeParams priors(FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/*  756 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvDTreeNode extends Pointer
/*      */   {
/*      */     public CvDTreeNode()
/*      */     {
/*  714 */       allocate(); } 
/*  715 */     public CvDTreeNode(int size) { allocateArray(size); } 
/*  716 */     public CvDTreeNode(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  721 */     public CvDTreeNode position(int position) { return (CvDTreeNode)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int class_idx();
/*      */ 
/*      */     public native CvDTreeNode class_idx(int paramInt);
/*      */ 
/*      */     public native int Tn();
/*      */ 
/*      */     public native CvDTreeNode Tn(int paramInt);
/*      */ 
/*      */     public native double value();
/*      */ 
/*      */     public native CvDTreeNode value(double paramDouble);
/*      */ 
/*      */     public native CvDTreeNode parent();
/*      */ 
/*      */     public native CvDTreeNode parent(CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native CvDTreeNode left();
/*      */ 
/*      */     public native CvDTreeNode left(CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native CvDTreeNode right();
/*      */ 
/*      */     public native CvDTreeNode right(CvDTreeNode paramCvDTreeNode);
/*      */ 
/*      */     public native opencv_ml.CvDTreeSplit split();
/*      */ 
/*      */     public native CvDTreeNode split(opencv_ml.CvDTreeSplit paramCvDTreeSplit);
/*      */ 
/*      */     public native int sample_count();
/*      */ 
/*      */     public native CvDTreeNode sample_count(int paramInt);
/*      */ 
/*      */     public native int depth();
/*      */ 
/*      */     public native CvDTreeNode depth(int paramInt);
/*      */ 
/*      */     public native IntPointer num_valid();
/*      */ 
/*      */     public native CvDTreeNode num_valid(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int offset();
/*      */ 
/*      */     public native CvDTreeNode offset(int paramInt);
/*      */ 
/*      */     public native int buf_idx();
/*      */ 
/*      */     public native CvDTreeNode buf_idx(int paramInt);
/*      */ 
/*      */     public native double maxlr();
/*      */ 
/*      */     public native CvDTreeNode maxlr(double paramDouble);
/*      */ 
/*      */     public native int complexity();
/*      */ 
/*      */     public native CvDTreeNode complexity(int paramInt);
/*      */ 
/*      */     public native double alpha();
/*      */ 
/*      */     public native CvDTreeNode alpha(double paramDouble);
/*      */ 
/*      */     public native double node_risk();
/*      */ 
/*      */     public native CvDTreeNode node_risk(double paramDouble);
/*      */ 
/*      */     public native double tree_risk();
/*      */ 
/*      */     public native CvDTreeNode tree_risk(double paramDouble);
/*      */ 
/*      */     public native double tree_error();
/*      */ 
/*      */     public native CvDTreeNode tree_error(double paramDouble);
/*      */ 
/*      */     public native IntPointer cv_Tn();
/*      */ 
/*      */     public native CvDTreeNode cv_Tn(IntPointer paramIntPointer);
/*      */ 
/*      */     public native DoublePointer cv_node_risk();
/*      */ 
/*      */     public native CvDTreeNode cv_node_risk(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native DoublePointer cv_node_error();
/*      */ 
/*      */     public native CvDTreeNode cv_node_error(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native int get_num_valid(int paramInt);
/*      */ 
/*      */     public native void set_num_valid(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  713 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvDTreeSplit extends Pointer
/*      */   {
/*      */     public CvDTreeSplit()
/*      */     {
/*  690 */       allocate(); } 
/*  691 */     public CvDTreeSplit(int size) { allocateArray(size); } 
/*  692 */     public CvDTreeSplit(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  697 */     public CvDTreeSplit position(int position) { return (CvDTreeSplit)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int var_idx();
/*      */ 
/*      */     public native CvDTreeSplit var_idx(int paramInt);
/*      */ 
/*      */     public native int condensed_idx();
/*      */ 
/*      */     public native CvDTreeSplit condensed_idx(int paramInt);
/*      */ 
/*      */     public native int inversed();
/*      */ 
/*      */     public native CvDTreeSplit inversed(int paramInt);
/*      */ 
/*      */     public native float quality();
/*      */ 
/*      */     public native CvDTreeSplit quality(float paramFloat);
/*      */ 
/*      */     public native CvDTreeSplit next();
/*      */ 
/*      */     public native CvDTreeSplit next(CvDTreeSplit paramCvDTreeSplit);
/*      */ 
/*      */     public native int subset(int paramInt);
/*      */ 
/*      */     public native CvDTreeSplit subset(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"ord.c"})
/*      */     public native float ord_c();
/*      */ 
/*      */     public native CvDTreeSplit ord_c(float paramFloat);
/*      */ 
/*      */     @Name({"ord.split_point"})
/*      */     public native int ord_split_point();
/*      */ 
/*      */     public native CvDTreeSplit ord_split_point(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  689 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPair16u32s extends Pointer
/*      */   {
/*      */     public CvPair16u32s()
/*      */     {
/*  671 */       allocate(); } 
/*  672 */     public CvPair16u32s(int size) { allocateArray(size); } 
/*  673 */     public CvPair16u32s(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  678 */     public CvPair16u32s position(int position) { return (CvPair16u32s)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"unsigned short*"})
/*      */     public native ShortPointer u();
/*      */ 
/*      */     public native CvPair16u32s u(ShortPointer paramShortPointer);
/*      */ 
/*      */     public native IntPointer i();
/*      */ 
/*      */     public native CvPair16u32s i(IntPointer paramIntPointer);
/*      */ 
/*      */     static
/*      */     {
/*  670 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class EM extends opencv_core.Algorithm
/*      */   {
/*      */     public static final int COV_MAT_SPHERICAL = 0;
/*      */     public static final int COV_MAT_DIAGONAL = 1;
/*      */     public static final int COV_MAT_GENERIC = 2;
/*      */     public static final int COV_MAT_DEFAULT = 1;
/*      */     public static final int DEFAULT_NCLUSTERS = 5;
/*      */     public static final int DEFAULT_MAX_ITERS = 100;
/*      */     public static final int START_E_STEP = 1;
/*      */     public static final int START_M_STEP = 2;
/*      */     public static final int START_AUTO_STEP = 0;
/*      */ 
/*      */     public EM()
/*      */     {
/*  594 */       allocate();
/*      */     }
/*      */     public EM(int nclusters, int covMatType, @ByVal opencv_core.CvTermCriteria termCrit) {
/*  597 */       allocate(nclusters, covMatType, termCrit);
/*      */     }
/*  599 */     public EM(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean train(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean trainE(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.InputArray opencv_core.CvArr paramCvArr4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean trainM(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvScalar predict(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean isTrained();
/*      */ 
/*      */     static
/*      */     {
/*  593 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSVM extends opencv_ml.CvStatModel
/*      */   {
/*      */     public static final int C_SVC = 100;
/*      */     public static final int NU_SVC = 101;
/*      */     public static final int ONE_CLASS = 102;
/*      */     public static final int EPS_SVR = 103;
/*      */     public static final int NU_SVR = 104;
/*      */     public static final int LINEAR = 0;
/*      */     public static final int POLY = 1;
/*      */     public static final int RBF = 2;
/*      */     public static final int SIGMOID = 3;
/*      */     public static final int C = 0;
/*      */     public static final int GAMMA = 1;
/*      */     public static final int P = 2;
/*      */     public static final int NU = 3;
/*      */     public static final int COEF = 4;
/*      */     public static final int DEGREE = 5;
/*      */ 
/*      */     public CvSVM()
/*      */     {
/*  519 */       allocate();
/*      */     }
/*      */     public CvSVM(opencv_core.CvMat trainData, opencv_core.CvMat responses, opencv_core.CvMat varIdx, opencv_core.CvMat sampleIdx, @ByVal opencv_ml.CvSVMParams params) {
/*  522 */       allocate(trainData, responses, varIdx, sampleIdx, params);
/*      */     }
/*  524 */     public CvSVM(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams);
/*      */ 
/*      */     public native boolean train_auto(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_ml.CvSVMParams paramCvSVMParams, int paramInt, @ByVal opencv_ml.CvParamGrid paramCvParamGrid1, @ByVal opencv_ml.CvParamGrid paramCvParamGrid2, @ByVal opencv_ml.CvParamGrid paramCvParamGrid3, @ByVal opencv_ml.CvParamGrid paramCvParamGrid4, @ByVal opencv_ml.CvParamGrid paramCvParamGrid5, @ByVal opencv_ml.CvParamGrid paramCvParamGrid6, boolean paramBoolean);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat, boolean paramBoolean);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native int get_support_vector_count();
/*      */ 
/*      */     @Const
/*      */     public native FloatPointer get_support_vector(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_ml.CvSVMParams get_params();
/*      */ 
/*      */     @ByVal
/*      */     public static native opencv_ml.CvParamGrid get_default_grid(int paramInt);
/*      */ 
/*      */     public native int get_var_count();
/*      */ 
/*      */     static
/*      */     {
/*  518 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSVMDecisionFunc extends Pointer
/*      */   {
/*      */     public CvSVMDecisionFunc()
/*      */     {
/*  501 */       allocate(); } 
/*  502 */     public CvSVMDecisionFunc(int size) { allocateArray(size); } 
/*  503 */     public CvSVMDecisionFunc(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  508 */     public CvSVMDecisionFunc position(int position) { return (CvSVMDecisionFunc)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native double rho();
/*      */ 
/*      */     public native CvSVMDecisionFunc rho(double paramDouble);
/*      */ 
/*      */     public native int sv_count();
/*      */ 
/*      */     public native CvSVMDecisionFunc sv_count(int paramInt);
/*      */ 
/*      */     public native DoublePointer alpha();
/*      */ 
/*      */     public native CvSVMDecisionFunc alpha(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native IntPointer sv_index();
/*      */ 
/*      */     public native CvSVMDecisionFunc sv_index(IntPointer paramIntPointer);
/*      */ 
/*      */     static
/*      */     {
/*  500 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvSVMSolver extends Pointer
/*      */   {
/*      */     public CvSVMSolver()
/*      */     {
/*  415 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvSVMSolver(int count, int var_count, @Cast({"const float**"}) PointerPointer samples, byte[] y, int alpha_count, double[] alpha, double Cp, double Cn, opencv_core.CvMemStorage storage, opencv_ml.CvSVMKernel kernel, GetRow get_row, SelectWorkingSet select_working_set, CalcRho calc_rho) {
/*  419 */       allocate(count, var_count, samples, y, alpha_count, alpha, Cp, Cn, storage, kernel, get_row, select_working_set, calc_rho);
/*      */     }
/*  421 */     public CvSVMSolver(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, int paramInt3, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, GetRow paramGetRow, SelectWorkingSet paramSelectWorkingSet, CalcRho paramCalcRho);
/*      */ 
/*      */     public native boolean create(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, int paramInt3, double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, GetRow paramGetRow, SelectWorkingSet paramSelectWorkingSet, CalcRho paramCalcRho);
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native boolean solve_generic(@ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native boolean solve_c_svc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native boolean solve_nu_svc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, byte[] paramArrayOfByte, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native boolean solve_one_class(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native boolean solve_eps_svr(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native boolean solve_nu_svr(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat, opencv_core.CvMemStorage paramCvMemStorage, opencv_ml.CvSVMKernel paramCvSVMKernel, double[] paramArrayOfDouble, @ByRef opencv_ml.CvSVMSolutionInfo paramCvSVMSolutionInfo);
/*      */ 
/*      */     public native FloatPointer get_row_base(int paramInt, BoolPointer paramBoolPointer);
/*      */ 
/*      */     public native FloatPointer get_row(int paramInt, float[] paramArrayOfFloat);
/*      */ 
/*      */     public native int sample_count();
/*      */ 
/*      */     public native CvSVMSolver sample_count(int paramInt);
/*      */ 
/*      */     public native int var_count();
/*      */ 
/*      */     public native CvSVMSolver var_count(int paramInt);
/*      */ 
/*      */     public native int cache_size();
/*      */ 
/*      */     public native CvSVMSolver cache_size(int paramInt);
/*      */ 
/*      */     public native int cache_line_size();
/*      */ 
/*      */     public native CvSVMSolver cache_line_size(int paramInt);
/*      */ 
/*      */     @Cast({"const float**"})
/*      */     public native PointerPointer samples();
/*      */ 
/*      */     public native CvSVMSolver samples(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Const
/*      */     public native opencv_ml.CvSVMParams params();
/*      */ 
/*      */     public native CvSVMSolver params(opencv_ml.CvSVMParams paramCvSVMParams);
/*      */ 
/*      */     public native opencv_core.CvMemStorage storage();
/*      */ 
/*      */     public native CvSVMSolver storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_ml.CvSVMKernelRow lru_list();
/*      */ 
/*      */     public native CvSVMSolver lru_list(opencv_ml.CvSVMKernelRow paramCvSVMKernelRow);
/*      */ 
/*      */     public native opencv_ml.CvSVMKernelRow rows();
/*      */ 
/*      */     public native CvSVMSolver rows(opencv_ml.CvSVMKernelRow paramCvSVMKernelRow);
/*      */ 
/*      */     public native int alpha_count();
/*      */ 
/*      */     public native CvSVMSolver alpha_count(int paramInt);
/*      */ 
/*      */     public native DoublePointer G();
/*      */ 
/*      */     public native CvSVMSolver G(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native DoublePointer alpha();
/*      */ 
/*      */     public native CvSVMSolver alpha(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native BytePointer alpha_status();
/*      */ 
/*      */     public native CvSVMSolver alpha_status(BytePointer paramBytePointer);
/*      */ 
/*      */     public native BytePointer y();
/*      */ 
/*      */     public native CvSVMSolver y(BytePointer paramBytePointer);
/*      */ 
/*      */     public native DoublePointer b();
/*      */ 
/*      */     public native CvSVMSolver b(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native FloatPointer buf(int paramInt);
/*      */ 
/*      */     public native CvSVMSolver buf(int paramInt, FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native double eps();
/*      */ 
/*      */     public native CvSVMSolver eps(double paramDouble);
/*      */ 
/*      */     public native int max_iter();
/*      */ 
/*      */     public native CvSVMSolver max_iter(int paramInt);
/*      */ 
/*      */     public native double C(int paramInt);
/*      */ 
/*      */     public native CvSVMSolver C(int paramInt, double paramDouble);
/*      */ 
/*      */     public native opencv_ml.CvSVMKernel kernel();
/*      */ 
/*      */     public native CvSVMSolver kernel(opencv_ml.CvSVMKernel paramCvSVMKernel);
/*      */ 
/*      */     public native SelectWorkingSet select_working_set_func();
/*      */ 
/*      */     public native CvSVMSolver select_working_set_func(SelectWorkingSet paramSelectWorkingSet);
/*      */ 
/*      */     public native CalcRho calc_rho_func();
/*      */ 
/*      */     public native CvSVMSolver calc_rho_func(CalcRho paramCalcRho);
/*      */ 
/*      */     public native GetRow get_row_func();
/*      */ 
/*      */     public native CvSVMSolver get_row_func(GetRow paramGetRow);
/*      */ 
/*      */     public native boolean select_working_set(@ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2);
/*      */ 
/*      */     public native boolean select_working_set_nu_svm(@ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2);
/*      */ 
/*      */     public native void calc_rho(@ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2);
/*      */ 
/*      */     public native void calc_rho_nu_svm(@ByRef double[] paramArrayOfDouble1, @ByRef double[] paramArrayOfDouble2);
/*      */ 
/*      */     public native FloatPointer get_row_svc(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
/*      */ 
/*      */     public native FloatPointer get_row_one_class(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
/*      */ 
/*      */     public native FloatPointer get_row_svr(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native SelectWorkingSet select_working_set();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native SelectWorkingSet select_working_set_nu_svm();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native CalcRho calc_rho();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native CalcRho calc_rho_nu_svm();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native GetRow get_row_svc();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native GetRow get_row_one_class();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native GetRow get_row_svr();
/*      */ 
/*      */     static
/*      */     {
/*  397 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @Namespace("CvSVMSolver")
/*      */     public static class CalcRho extends FunctionPointer
/*      */     {
/*      */       public CalcRho(Pointer p)
/*      */       {
/*  411 */         super();
/*      */       }
/*      */ 
/*      */       public native void call(opencv_ml.CvSVMSolver paramCvSVMSolver, @ByRef DoublePointer paramDoublePointer1, @ByRef DoublePointer paramDoublePointer2);
/*      */ 
/*      */       static
/*      */       {
/*  410 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     @Namespace("CvSVMSolver")
/*      */     public static class GetRow extends FunctionPointer
/*      */     {
/*      */       public GetRow(Pointer p)
/*      */       {
/*  405 */         super();
/*      */       }
/*      */ 
/*      */       public native FloatPointer call(opencv_ml.CvSVMSolver paramCvSVMSolver, int paramInt, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */       static
/*      */       {
/*  404 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     @Namespace("CvSVMSolver")
/*      */     public static class SelectWorkingSet extends FunctionPointer
/*      */     {
/*      */       public SelectWorkingSet(Pointer p)
/*      */       {
/*  400 */         super();
/*      */       }
/*      */ 
/*      */       @Cast({"bool"})
/*      */       public native boolean call(opencv_ml.CvSVMSolver paramCvSVMSolver, @ByRef IntPointer paramIntPointer1, @ByRef IntPointer paramIntPointer2);
/*      */ 
/*      */       static
/*      */       {
/*  399 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSVMSolutionInfo extends Pointer
/*      */   {
/*      */     public CvSVMSolutionInfo()
/*      */     {
/*  379 */       allocate(); } 
/*  380 */     public CvSVMSolutionInfo(int size) { allocateArray(size); } 
/*  381 */     public CvSVMSolutionInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  386 */     public CvSVMSolutionInfo position(int position) { return (CvSVMSolutionInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native double obj();
/*      */ 
/*      */     public native CvSVMSolutionInfo obj(double paramDouble);
/*      */ 
/*      */     public native double rho();
/*      */ 
/*      */     public native CvSVMSolutionInfo rho(double paramDouble);
/*      */ 
/*      */     public native double upper_bound_p();
/*      */ 
/*      */     public native CvSVMSolutionInfo upper_bound_p(double paramDouble);
/*      */ 
/*      */     public native double upper_bound_n();
/*      */ 
/*      */     public native CvSVMSolutionInfo upper_bound_n(double paramDouble);
/*      */ 
/*      */     public native double r();
/*      */ 
/*      */     public native CvSVMSolutionInfo r(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  378 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSVMKernelRow extends Pointer
/*      */   {
/*      */     public CvSVMKernelRow()
/*      */     {
/*  362 */       allocate(); } 
/*  363 */     public CvSVMKernelRow(int size) { allocateArray(size); } 
/*  364 */     public CvSVMKernelRow(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  369 */     public CvSVMKernelRow position(int position) { return (CvSVMKernelRow)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvSVMKernelRow prev();
/*      */ 
/*      */     public native CvSVMKernelRow prev(CvSVMKernelRow paramCvSVMKernelRow);
/*      */ 
/*      */     public native CvSVMKernelRow next();
/*      */ 
/*      */     public native CvSVMKernelRow next(CvSVMKernelRow paramCvSVMKernelRow);
/*      */ 
/*      */     public native FloatPointer data();
/*      */ 
/*      */     public native CvSVMKernelRow data(FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/*  361 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvSVMKernel extends Pointer
/*      */   {
/*      */     public CvSVMKernel()
/*      */     {
/*  323 */       allocate(); } 
/*  324 */     public CvSVMKernel(opencv_ml.CvSVMParams params, Calc _calc_func) { allocate(params, _calc_func); } 
/*  325 */     public CvSVMKernel(int size) { allocateArray(size); } 
/*  326 */     public CvSVMKernel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_ml.CvSVMParams paramCvSVMParams, Calc paramCalc);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  332 */     public CvSVMKernel position(int position) { return (CvSVMKernel)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native void calc(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */     @Const
/*      */     public native opencv_ml.CvSVMParams params();
/*      */ 
/*      */     public native CvSVMKernel params(opencv_ml.CvSVMParams paramCvSVMParams);
/*      */ 
/*      */     public native Calc calc_func();
/*      */ 
/*      */     public native CvSVMKernel calc_func(Calc paramCalc);
/*      */ 
/*      */     public native void calc_non_rbf_base(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     public native void calc_linear(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */     public native void calc_rbf(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */     public native void calc_poly(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */     public native void calc_sigmoid(int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native Calc calc_linear();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native Calc calc_rbf();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native Calc calc_poly();
/*      */ 
/*      */     @MemberGetter
/*      */     @ByRef
/*      */     public static native Calc calc_sigmoid();
/*      */ 
/*      */     static
/*      */     {
/*  316 */       Loader.load();
/*      */     }
/*  319 */     @Namespace("CvSVMKernel")
/*      */     public static class Calc extends FunctionPointer { public Calc(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */       public native void call(opencv_ml.CvSVMKernel paramCvSVMKernel, int paramInt1, int paramInt2, @Cast({"const float**"}) PointerPointer paramPointerPointer, @Const FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2);
/*      */ 
/*      */       static
/*      */       {
/*  318 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvSVMParams extends Pointer
/*      */   {
/*      */     public CvSVMParams()
/*      */     {
/*  285 */       allocate();
/*      */     }
/*      */     public CvSVMParams(int svm_type, int kernel_type, double degree, double gamma, double coef0, double Cvalue, double nu, double p, opencv_core.CvMat class_weights, opencv_core.CvTermCriteria term_crit) {
/*  288 */       allocate(svm_type, kernel_type, degree, gamma, coef0, Cvalue, nu, p, class_weights, term_crit);
/*      */     }
/*  290 */     public CvSVMParams(int size) { allocateArray(size); } 
/*  291 */     public CvSVMParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  298 */     public CvSVMParams position(int position) { return (CvSVMParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int svm_type();
/*      */ 
/*      */     public native CvSVMParams svm_type(int paramInt);
/*      */ 
/*      */     public native int kernel_type();
/*      */ 
/*      */     public native CvSVMParams kernel_type(int paramInt);
/*      */ 
/*      */     public native double degree();
/*      */ 
/*      */     public native CvSVMParams degree(double paramDouble);
/*      */ 
/*      */     public native double gamma();
/*      */ 
/*      */     public native CvSVMParams gamma(double paramDouble);
/*      */ 
/*      */     public native double coef0();
/*      */ 
/*      */     public native CvSVMParams coef0(double paramDouble);
/*      */ 
/*      */     public native double C();
/*      */ 
/*      */     public native CvSVMParams C(double paramDouble);
/*      */ 
/*      */     public native double nu();
/*      */ 
/*      */     public native CvSVMParams nu(double paramDouble);
/*      */ 
/*      */     public native double p();
/*      */ 
/*      */     public native CvSVMParams p(double paramDouble);
/*      */ 
/*      */     public native opencv_core.CvMat class_weights();
/*      */ 
/*      */     public native CvSVMParams class_weights(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvTermCriteria term_crit();
/*      */ 
/*      */     public native CvSVMParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     static
/*      */     {
/*  284 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvKNearest extends opencv_ml.CvStatModel
/*      */   {
/*      */     public CvKNearest()
/*      */     {
/*  247 */       allocate();
/*      */     }
/*      */     public CvKNearest(opencv_core.CvMat trainData, opencv_core.CvMat responses, opencv_core.CvMat sampleIdx, boolean isRegression, int max_k) {
/*  250 */       allocate(trainData, responses, sampleIdx, isRegression, max_k);
/*      */     }
/*  252 */     public CvKNearest(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, boolean paramBoolean, int paramInt);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
/*      */ 
/*      */     public native float find_nearest(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, @Cast({"const float**"}) PointerPointer paramPointerPointer, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
/*      */ 
/*      */     public native int get_max_k();
/*      */ 
/*      */     public native int get_var_count();
/*      */ 
/*      */     public native int get_sample_count();
/*      */ 
/*      */     public native boolean is_regression();
/*      */ 
/*      */     public native float write_results(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.Cv32suf paramCv32suf);
/*      */ 
/*      */     public native void find_neighbors_direct(opencv_core.CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat1, @Cast({"const float**"}) PointerPointer paramPointerPointer, float[] paramArrayOfFloat2);
/*      */ 
/*      */     static
/*      */     {
/*  246 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvNormalBayesClassifier extends opencv_ml.CvStatModel
/*      */   {
/*      */     public CvNormalBayesClassifier()
/*      */     {
/*  214 */       allocate();
/*      */     }
/*      */     public CvNormalBayesClassifier(opencv_core.CvMat trainData, opencv_core.CvMat responses, opencv_core.CvMat varIdx, opencv_core.CvMat sampleIdx) {
/*  217 */       allocate(trainData, responses, varIdx, sampleIdx);
/*      */     }
/*  219 */     public CvNormalBayesClassifier(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, boolean paramBoolean);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     static
/*      */     {
/*  213 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvParamGrid extends Pointer
/*      */   {
/*      */     public static final int SVM_C = 0;
/*      */     public static final int SVM_GAMMA = 1;
/*      */     public static final int SVM_P = 2;
/*      */     public static final int SVM_NU = 3;
/*      */     public static final int SVM_COEF = 4;
/*      */     public static final int SVM_DEGREE = 5;
/*      */ 
/*      */     public CvParamGrid()
/*      */     {
/*  188 */       allocate();
/*      */     }
/*  190 */     public CvParamGrid(double min_val, double max_val, double log_step) { allocate(min_val, max_val, log_step); }
/*      */ 
/*      */     public CvParamGrid(int size) {
/*  193 */       allocateArray(size); } 
/*  194 */     public CvParamGrid(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  200 */     public CvParamGrid position(int position) { return (CvParamGrid)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native boolean check();
/*      */ 
/*      */     public native double min_val();
/*      */ 
/*      */     public native CvParamGrid min_val(double paramDouble);
/*      */ 
/*      */     public native double max_val();
/*      */ 
/*      */     public native CvParamGrid max_val(double paramDouble);
/*      */ 
/*      */     public native double step();
/*      */ 
/*      */     public native CvParamGrid step(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  187 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStatModel extends Pointer
/*      */   {
/*      */     public CvStatModel()
/*      */     {
/*  171 */       allocate(); } 
/*  172 */     public CvStatModel(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native void save(String paramString1, String paramString2);
/*      */ 
/*      */     public native void load(String paramString1, String paramString2);
/*      */ 
/*      */     public native void write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     public native void read(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     static
/*      */     {
/*  170 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVectors extends Pointer
/*      */   {
/*      */     public CvVectors()
/*      */     {
/*  110 */       allocate(); } 
/*  111 */     public CvVectors(int size) { allocateArray(size); } 
/*  112 */     public CvVectors(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  117 */     public CvVectors position(int position) { return (CvVectors)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int type();
/*      */ 
/*      */     public native CvVectors type(int paramInt);
/*      */ 
/*      */     public native int dims();
/*      */ 
/*      */     public native CvVectors dims(int paramInt);
/*      */ 
/*      */     public native int count();
/*      */ 
/*      */     public native CvVectors count(int paramInt);
/*      */ 
/*      */     public native CvVectors next();
/*      */ 
/*      */     public native CvVectors next(CvVectors paramCvVectors);
/*      */ 
/*      */     @Name({"data.ptr"})
/*      */     @Cast({"uchar**"})
/*      */     public native PointerPointer data_ptr();
/*      */ 
/*      */     public native CvVectors data_ptr(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Name({"data.fl"})
/*      */     @Cast({"float**"})
/*      */     public native PointerPointer data_fl();
/*      */ 
/*      */     public native CvVectors data_fl(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Name({"data.db"})
/*      */     @Cast({"double**"})
/*      */     public native PointerPointer data_db();
/*      */ 
/*      */     public native CvVectors data_db(PointerPointer paramPointerPointer);
/*      */ 
/*      */     static
/*      */     {
/*  109 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_ml
 * JD-Core Version:    0.6.2
 */