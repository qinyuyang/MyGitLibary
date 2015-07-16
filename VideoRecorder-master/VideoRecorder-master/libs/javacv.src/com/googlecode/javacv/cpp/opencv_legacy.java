/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.Pointer.Deallocator;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.SizeTPointer;
/*      */ import com.googlecode.javacpp.annotation.Adapter;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ 
/*      */ @Properties(inherit={opencv_calib3d.class, opencv_features2d.class, opencv_video.class, opencv_ml.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/legacy/compat.hpp>", "<opencv2/legacy/legacy.hpp>", "<opencv2/legacy/blobtrack.hpp>"}, link={"opencv_legacy@.2.4", "opencv_gpu@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_legacy248", "opencv_gpu248"}), @com.googlecode.javacpp.annotation.Platform(value={"android"}, link={"opencv_legacy"})})
/*      */ public class opencv_legacy
/*      */ {
/*      */   public static final int CV_EIGOBJ_NO_CALLBACK = 0;
/*      */   public static final int CV_EIGOBJ_INPUT_CALLBACK = 1;
/*      */   public static final int CV_EIGOBJ_OUTPUT_CALLBACK = 2;
/*      */   public static final int CV_EIGOBJ_BOTH_CALLBACK = 3;
/*      */   public static final int CV_NOT_WEIGHTED = 0;
/*      */   public static final int CV_WEIGHTED_VTX = 1;
/*      */   public static final int CV_WEIGHTED_EDGE = 2;
/*      */   public static final int CV_WEIGHTED_ALL = 3;
/*      */   public static final int CV_DOMINANT_IPAN = 1;
/*      */   public static final int CLIQUE_TIME_OFF = 2;
/*      */   public static final int CLIQUE_FOUND = 1;
/*      */   public static final int CLIQUE_END = 0;
/*      */   public static final int CV_UNDEF_SC_PARAM = 12345;
/*      */   public static final int CV_IDP_BIRCHFIELD_PARAM1 = 25;
/*      */   public static final int CV_IDP_BIRCHFIELD_PARAM2 = 5;
/*      */   public static final int CV_IDP_BIRCHFIELD_PARAM3 = 12;
/*      */   public static final int CV_IDP_BIRCHFIELD_PARAM4 = 15;
/*      */   public static final int CV_IDP_BIRCHFIELD_PARAM5 = 25;
/*      */   public static final int CV_DISPARITY_BIRCHFIELD = 0;
/*      */   public static final int CV_CAMERA_TO_WARP = 1;
/*      */   public static final int CV_WARP_TO_CAMERA = 2;
/*      */   public static final int CV_CONTOUR_TREES_MATCH_I1 = 1;
/*      */   public static final int CV_VALUE = 1;
/*      */   public static final int CV_ARRAY = 2;
/*      */   public static final int CV_GLCM_OPTIMIZATION_NONE = -2;
/*      */   public static final int CV_GLCM_OPTIMIZATION_LUT = -1;
/*      */   public static final int CV_GLCM_OPTIMIZATION_HISTOGRAM = 0;
/*      */   public static final int CV_GLCMDESC_OPTIMIZATION_ALLOWDOUBLENEST = 10;
/*      */   public static final int CV_GLCMDESC_OPTIMIZATION_ALLOWTRIPLENEST = 11;
/*      */   public static final int CV_GLCMDESC_OPTIMIZATION_HISTOGRAM = 4;
/*      */   public static final int CV_GLCMDESC_ENTROPY = 0;
/*      */   public static final int CV_GLCMDESC_ENERGY = 1;
/*      */   public static final int CV_GLCMDESC_HOMOGENITY = 2;
/*      */   public static final int CV_GLCMDESC_CONTRAST = 3;
/*      */   public static final int CV_GLCMDESC_CLUSTERTENDENCY = 4;
/*      */   public static final int CV_GLCMDESC_CLUSTERSHADE = 5;
/*      */   public static final int CV_GLCMDESC_CORRELATION = 6;
/*      */   public static final int CV_GLCMDESC_CORRELATIONINFO1 = 7;
/*      */   public static final int CV_GLCMDESC_CORRELATIONINFO2 = 8;
/*      */   public static final int CV_GLCMDESC_MAXIMUMPROBABILITY = 9;
/*      */   public static final int CV_GLCM_ALL = 0;
/*      */   public static final int CV_GLCM_GLCM = 1;
/*      */   public static final int CV_GLCM_DESC = 2;
/*      */   public static final int CV_NUM_FACE_ELEMENTS = 3;
/*      */   public static final int CV_FACE_MOUTH = 0;
/*      */   public static final int CV_FACE_LEFT_EYE = 1;
/*      */   public static final int CV_FACE_RIGHT_EYE = 2;
/*      */   public static final int CV_LEE_INT = 0;
/*      */   public static final int CV_LEE_FLOAT = 1;
/*      */   public static final int CV_LEE_DOUBLE = 2;
/*      */   public static final int CV_LEE_AUTO = -1;
/*      */   public static final int CV_LEE_ERODE = 0;
/*      */   public static final int CV_LEE_ZOOM = 1;
/*      */   public static final int CV_LEE_NON = 2;
/*      */   public static final int CV_CALIB_ETALON_USER = -1;
/*      */   public static final int CV_CALIB_ETALON_CHESSBOARD = 0;
/*      */   public static final int CV_CALIB_ETALON_CHECKERBOARD = 0;
/*      */   public static final int CV_STEREO_GC_OCCLUDED = 32767;
/*      */   public static final int CV_BG_MODEL_FGD = 0;
/*      */   public static final int CV_BG_MODEL_MOG = 1;
/*      */   public static final int CV_BG_MODEL_FGD_SIMPLE = 2;
/*      */   public static final int CV_BGFG_FGD_LC = 128;
/*      */   public static final int CV_BGFG_FGD_N1C = 15;
/*      */   public static final int CV_BGFG_FGD_N2C = 25;
/*      */   public static final int CV_BGFG_FGD_LCC = 64;
/*      */   public static final int CV_BGFG_FGD_N1CC = 25;
/*      */   public static final int CV_BGFG_FGD_N2CC = 40;
/*      */   public static final float CV_BGFG_FGD_ALPHA_1 = 0.1F;
/*      */   public static final float CV_BGFG_FGD_ALPHA_2 = 0.005F;
/*      */   public static final float CV_BGFG_FGD_ALPHA_3 = 0.1F;
/*      */   public static final float CV_BGFG_FGD_DELTA = 2.0F;
/*      */   public static final float CV_BGFG_FGD_T = 0.9F;
/*      */   public static final float CV_BGFG_FGD_MINAREA = 15.0F;
/*      */   public static final float CV_BGFG_FGD_BG_UPDATE_TRESH = 0.5F;
/*      */   public static final int CV_BGFG_MOG_MAX_NGAUSSIANS = 500;
/*      */   public static final int CV_BGFG_MOG_WINDOW_SIZE = 200;
/*      */   public static final int CV_BGFG_MOG_NGAUSSIANS = 5;
/*      */   public static final int CV_BGFG_MOG_NCOLORS = 3;
/*      */   public static final double CV_BGFG_MOG_BACKGROUND_THRESHOLD = 0.7D;
/*      */   public static final double CV_BGFG_MOG_STD_THRESHOLD = 2.5D;
/*      */   public static final double CV_BGFG_MOG_WEIGHT_INIT = 0.05D;
/*      */   public static final double CV_BGFG_MOG_SIGMA_INIT = 30.0D;
/*      */   public static final double CV_BGFG_MOG_MINAREA = 15.0D;
/*      */   public static final int CV_BLOB_MINW = 5;
/*      */   public static final int CV_BLOB_MINH = 5;
/*      */   public static final int PROFILE_EPANECHNIKOV = 0;
/*      */   public static final int PROFILE_DOG = 1;
/*      */   public static final int CV_NOISE_NONE = 0;
/*      */   public static final int CV_NOISE_GAUSSIAN = 1;
/*      */   public static final int CV_NOISE_UNIFORM = 2;
/*      */   public static final int CV_NOISE_SPECKLE = 3;
/*      */   public static final int CV_NOISE_SALT_AND_PEPPER = 4;
/*      */ 
/*      */   public static float cvQueryHistValue_1D(opencv_imgproc.CvHistogram hist, int idx0)
/*      */   {
/*  101 */     return (float)opencv_core.cvGetReal1D(hist.bins(), idx0);
/*      */   }
/*      */   public static float cvQueryHistValue_2D(opencv_imgproc.CvHistogram hist, int idx0, int idx1) {
/*  104 */     return (float)opencv_core.cvGetReal2D(hist.bins(), idx0, idx1);
/*      */   }
/*      */   public static float cvQueryHistValue_3D(opencv_imgproc.CvHistogram hist, int idx0, int idx1, int idx2) {
/*  107 */     return (float)opencv_core.cvGetReal3D(hist.bins(), idx0, idx1, idx2);
/*      */   }
/*      */   public static float cvQueryHistValue_nD(opencv_imgproc.CvHistogram hist, int idx0, int[] idx) {
/*  110 */     return (float)opencv_core.cvGetRealND(hist.bins(), idx);
/*      */   }
/*      */ 
/*      */   public static Pointer cvGetHistValue_1D(opencv_imgproc.CvHistogram hist, int idx0) {
/*  114 */     return opencv_core.cvPtr1D(hist.bins(), idx0, null);
/*      */   }
/*      */   public static Pointer cvGetHistValue_2D(opencv_imgproc.CvHistogram hist, int idx0, int idx1) {
/*  117 */     return opencv_core.cvPtr2D(hist.bins(), idx0, idx1, null);
/*      */   }
/*      */   public static Pointer cvGetHistValue_3D(opencv_imgproc.CvHistogram hist, int idx0, int idx1, int idx2) {
/*  120 */     return opencv_core.cvPtr3D(hist.bins(), idx0, idx1, idx2, null);
/*      */   }
/*      */   public static Pointer cvGetHistValue_nD(opencv_imgproc.CvHistogram hist, int idx0, int[] idx) {
/*  123 */     return opencv_core.cvPtrND(hist.bins(), idx, null, 1, null);
/*      */   }
/*      */ 
/*      */   public static CvSURFPoint cvSURFPoint(opencv_core.CvPoint2D32f pt, int laplacian, int size)
/*      */   {
/*  146 */     return cvSURFPoint(pt, laplacian, size, 0.0F, 0.0F);
/*      */   }
/*      */ 
/*      */   public static CvSURFPoint cvSURFPoint(opencv_core.CvPoint2D32f pt, int laplacian, int size, float dir, float hessian) {
/*  150 */     CvSURFPoint kp = new CvSURFPoint();
/*  151 */     kp.pt(pt);
/*  152 */     kp.laplacian(laplacian);
/*  153 */     kp.size(size);
/*  154 */     kp.dir(dir);
/*  155 */     kp.hessian(hessian);
/*  156 */     return kp;
/*      */   }
/*      */ 
/*      */   @ByVal
/*      */   public static native CvSURFParams cvSURFParams(double paramDouble, int paramInt);
/*      */ 
/*      */   public static native void cvExtractSURF(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByPtrPtr opencv_core.CvSeq paramCvSeq1, @ByPtrPtr opencv_core.CvSeq paramCvSeq2, opencv_core.CvMemStorage paramCvMemStorage, @ByVal CvSURFParams paramCvSURFParams, int paramInt);
/*      */ 
/*      */   public static CvStarKeypoint cvStarKeypoint(opencv_core.CvPoint pt, int size, float response)
/*      */   {
/*  237 */     CvStarKeypoint kpt = new CvStarKeypoint();
/*  238 */     kpt.pt(pt);
/*  239 */     kpt.size(size);
/*  240 */     kpt.response(response);
/*  241 */     return kpt;
/*      */   }
/*      */ 
/*      */   public static CvStarDetectorParams cvStarDetectorParams(int maxSize, int responseThreshold, int lineThresholdProjected, int lineThresholdBinarized, int suppressNonmaxSize)
/*      */   {
/*  265 */     CvStarDetectorParams params = new CvStarDetectorParams();
/*  266 */     params.maxSize(maxSize);
/*  267 */     params.responseThreshold(responseThreshold);
/*  268 */     params.lineThresholdProjected(lineThresholdProjected);
/*  269 */     params.lineThresholdBinarized(lineThresholdBinarized);
/*  270 */     params.suppressNonmaxSize(suppressNonmaxSize);
/*  271 */     return params;
/*      */   }
/*      */   public static CvStarDetectorParams cvStarDetectorParams() {
/*  274 */     return cvStarDetectorParams(45, 30, 10, 8, 5);
/*      */   }
/*      */ 
/*      */   public static opencv_core.CvSeq cvGetStarKeypoints(opencv_core.CvArr image, opencv_core.CvMemStorage storage) {
/*  278 */     return cvGetStarKeypoints(image, storage, cvStarDetectorParams());
/*      */   }
/*      */ 
/*      */   public static native opencv_core.CvSeq cvGetStarKeypoints(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage, @ByVal CvStarDetectorParams paramCvStarDetectorParams);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvSegmentImage(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native void cvCalcCovarMatrixEx(int paramInt1, Pointer paramPointer1, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer2, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static void cvCalcCovarMatrixEx(int nObjects, opencv_core.IplImage[] input, int ioFlags, int ioBufSize, @Cast({"uchar*"}) BytePointer buffer, Pointer userData, opencv_core.IplImage avg, float[] covarMatrix)
/*      */   {
/*  306 */     cvCalcCovarMatrixEx(nObjects, new opencv_core.IplImageArray(input), ioFlags, ioBufSize, buffer, userData, avg, covarMatrix);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcEigenObjects(int paramInt1, Pointer paramPointer1, Pointer paramPointer2, int paramInt2, int paramInt3, Pointer paramPointer3, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static void cvCalcEigenObjects(int nObjects, opencv_core.IplImage[] input, opencv_core.IplImage[] output, int ioFlags, int ioBufSize, Pointer userData, opencv_core.CvTermCriteria calcLimit, opencv_core.IplImage avg, float[] eigVals) {
/*  312 */     cvCalcEigenObjects(nObjects, new opencv_core.IplImageArray(input), new opencv_core.IplImageArray(output), ioFlags, ioBufSize, userData, calcLimit, avg, eigVals);
/*      */   }
/*      */ 
/*      */   public static native double cvCalcDecompCoeff(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
/*      */ 
/*      */   public static native void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, opencv_core.IplImage paramIplImage2, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static void cvEigenDecomposite(opencv_core.IplImage obj, int nEigObjs, opencv_core.IplImage[] eigInput, int ioFlags, Pointer userData, opencv_core.IplImage avg, float[] coeffs) {
/*  320 */     cvEigenDecomposite(obj, nEigObjs, new opencv_core.IplImageArray(eigInput), ioFlags, userData, avg, coeffs);
/*      */   }
/*      */ 
/*      */   public static native void cvEigenProjection(Pointer paramPointer1, int paramInt1, int paramInt2, Pointer paramPointer2, float[] paramArrayOfFloat, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */   public static void cvEigenProjection(opencv_core.IplImage[] eigInput, int nEigObjs, int ioFlags, Pointer userData, float[] coeffs, opencv_core.IplImage avg, opencv_core.IplImage proj) {
/*  326 */     cvEigenProjection(new opencv_core.IplImageArray(eigInput), nEigObjs, ioFlags, userData, coeffs, avg, proj);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcCovarMatrixEx(int paramInt1, Pointer paramPointer1, int paramInt2, int paramInt3, @Cast({"uchar*"}) BytePointer paramBytePointer, Pointer paramPointer2, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static void cvCalcCovarMatrixEx(int nObjects, opencv_core.IplImage[] input, int ioFlags, int ioBufSize, @Cast({"uchar*"}) BytePointer buffer, Pointer userData, opencv_core.IplImage avg, FloatPointer covarMatrix)
/*      */   {
/*  333 */     cvCalcCovarMatrixEx(nObjects, new opencv_core.IplImageArray(input), ioFlags, ioBufSize, buffer, userData, avg, covarMatrix);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcEigenObjects(int paramInt1, Pointer paramPointer1, Pointer paramPointer2, int paramInt2, int paramInt3, Pointer paramPointer3, opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.IplImage paramIplImage, FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static void cvCalcEigenObjects(int nObjects, opencv_core.IplImage[] input, opencv_core.IplImage[] output, int ioFlags, int ioBufSize, Pointer userData, opencv_core.CvTermCriteria calcLimit, opencv_core.IplImage avg, FloatPointer eigVals) {
/*  339 */     cvCalcEigenObjects(nObjects, new opencv_core.IplImageArray(input), new opencv_core.IplImageArray(output), ioFlags, ioBufSize, userData, calcLimit, avg, eigVals);
/*      */   }
/*      */ 
/*      */   public static native void cvEigenDecomposite(opencv_core.IplImage paramIplImage1, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, opencv_core.IplImage paramIplImage2, FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static void cvEigenDecomposite(opencv_core.IplImage obj, int nEigObjs, opencv_core.IplImage[] eigInput, int ioFlags, Pointer userData, opencv_core.IplImage avg, FloatPointer coeffs)
/*      */   {
/*  346 */     cvEigenDecomposite(obj, nEigObjs, new opencv_core.IplImageArray(eigInput), ioFlags, userData, avg, coeffs);
/*      */   }
/*      */ 
/*      */   public static native void cvEigenProjection(Pointer paramPointer1, int paramInt1, int paramInt2, Pointer paramPointer2, FloatPointer paramFloatPointer, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */   public static void cvEigenProjection(opencv_core.IplImage[] eigInput, int nEigObjs, int ioFlags, Pointer userData, FloatPointer coeffs, opencv_core.IplImage avg, opencv_core.IplImage proj) {
/*  352 */     cvEigenProjection(new opencv_core.IplImageArray(eigInput), nEigObjs, ioFlags, userData, coeffs, avg, proj);
/*      */   }
/*      */ 
/*      */   public static native CvEHMM cvCreate2DHMM(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
/*      */ 
/*      */   public static native void cvRelease2DHMM(@ByPtrPtr CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static void CV_COUNT_OBS(opencv_core.CvSize roi, opencv_core.CvSize win, opencv_core.CvSize delta, opencv_core.CvSize numObs)
/*      */   {
/*  475 */     numObs.width((roi.width() - win.width() + delta.width()) / delta.width());
/*  476 */     numObs.height((roi.height() - win.height() + delta.height()) / delta.height());
/*      */   }
/*      */ 
/*      */   public static native CvImgObsInfo cvCreateObsInfo(@ByVal opencv_core.CvSize paramCvSize, int paramInt);
/*      */ 
/*      */   public static native void cvReleaseObsInfo(@ByPtrPtr CvImgObsInfo paramCvImgObsInfo);
/*      */ 
/*      */   public static native void cvImgToObs_DCT(opencv_core.CvArr paramCvArr, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3);
/*      */ 
/*      */   public static native void cvImgToObs_DCT(opencv_core.CvArr paramCvArr, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3);
/*      */ 
/*      */   public static native void cvUniformImgSegm(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvInitMixSegm(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvEstimateHMMStateParams(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvEstimateTransProb(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvEstimateObsProb(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native float cvEViterbi(CvImgObsInfo paramCvImgObsInfo, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvMixSegmL2(@Cast({"CvImgObsInfo**"}) PointerPointer paramPointerPointer, int paramInt, CvEHMM paramCvEHMM);
/*      */ 
/*      */   public static native void cvCreateHandMask(opencv_core.CvSeq paramCvSeq, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect);
/*      */ 
/*      */   public static native void cvFindHandRegion(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
/*      */ 
/*      */   public static native void cvFindHandRegionA(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, float[] paramArrayOfFloat, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
/*      */ 
/*      */   public static native void cvFindHandRegion(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
/*      */ 
/*      */   public static native void cvFindHandRegionA(opencv_core.CvPoint3D32f paramCvPoint3D32f1, int paramInt1, opencv_core.CvSeq paramCvSeq1, FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize2D32f paramCvSize2D32f, int paramInt2, opencv_core.CvPoint3D32f paramCvPoint3D32f2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq2);
/*      */ 
/*      */   public static native void cvCalcImageHomography(float[] paramArrayOfFloat1, opencv_core.CvPoint3D32f paramCvPoint3D32f, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
/*      */ 
/*      */   public static native void cvCalcImageHomography(FloatPointer paramFloatPointer1, opencv_core.CvPoint3D32f paramCvPoint3D32f, FloatPointer paramFloatPointer2, FloatPointer paramFloatPointer3);
/*      */ 
/*      */   public static native void icvDrawMosaic(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */   public static native int icvSubdiv2DCheck(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
/*      */ 
/*      */   public static double icvSqDist2D32f(opencv_core.CvPoint2D32f pt1, opencv_core.CvPoint2D32f pt2)
/*      */   {
/*  522 */     double dx = pt1.x() - pt2.x();
/*  523 */     double dy = pt1.y() - pt2.y();
/*      */ 
/*  525 */     return dx * dx + dy * dy;
/*      */   }
/*      */ 
/*      */   public static int CV_CURRENT_INT(opencv_core.CvSeqReader reader) {
/*  529 */     return new IntPointer(reader.ptr()).get(); } 
/*  530 */   public static int CV_PREV_INT(opencv_core.CvSeqReader reader) { return new IntPointer(reader.prev_elem()).get(); }
/*      */ 
/*      */ 
/*      */   public static native void cvCalcPGH(opencv_core.CvSeq paramCvSeq, opencv_imgproc.CvHistogram paramCvHistogram);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvFindDominantPoints(opencv_core.CvSeq paramCvSeq, opencv_core.CvMemStorage paramCvMemStorage, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
/*      */ 
/*      */   public static native void cvFindStereoCorrespondence(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, opencv_core.CvArr paramCvArr3, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5);
/*      */ 
/*      */   public static native int icvConvertWarpCoordinates(@Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt);
/*      */ 
/*      */   public static native int icvConvertWarpCoordinates(@Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, int paramInt);
/*      */ 
/*      */   public static native int icvGetSymPoint3D(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, opencv_core.CvPoint3D64f paramCvPoint3D64f4);
/*      */ 
/*      */   public static native void icvGetPieceLength3D(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int icvCompute3DPoint(double paramDouble1, double paramDouble2, CvStereoLineCoeff paramCvStereoLineCoeff, opencv_core.CvPoint3D64f paramCvPoint3D64f);
/*      */ 
/*      */   public static native int icvCreateConvertMatrVect(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6);
/*      */ 
/*      */   public static native int icvConvertPointSystem(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
/*      */ 
/*      */   public static native int icvCreateConvertMatrVect(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6);
/*      */ 
/*      */   public static native int icvConvertPointSystem(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2);
/*      */ 
/*      */   public static native int icvComputeCoeffForStereo(CvStereoCamera paramCvStereoCamera);
/*      */ 
/*      */   public static native int icvGetCrossPieceVector(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f4, opencv_core.CvPoint2D32f paramCvPoint2D32f5);
/*      */ 
/*      */   public static native int icvGetCrossLineDirect(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, float paramFloat1, float paramFloat2, float paramFloat3, opencv_core.CvPoint2D32f paramCvPoint2D32f3);
/*      */ 
/*      */   public static native float icvDefinePointPosition(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3);
/*      */ 
/*      */   public static native int icvStereoCalibration(int paramInt, int[] paramArrayOfInt, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, opencv_core.CvPoint3D32f paramCvPoint3D32f, CvStereoCamera paramCvStereoCamera);
/*      */ 
/*      */   public static native int icvComputeRestStereoParams(CvStereoCamera paramCvStereoCamera);
/*      */ 
/*      */   public static native void cvComputePerspectiveMap(@Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvComputePerspectiveMap(@Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native int icvComCoeffForLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6, CvStereoLineCoeff paramCvStereoLineCoeff, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int icvComCoeffForLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6, CvStereoLineCoeff paramCvStereoLineCoeff, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int icvGetDirectionForPoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble, opencv_core.CvPoint3D64f paramCvPoint3D64f);
/*      */ 
/*      */   public static native int icvGetDirectionForPoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer, opencv_core.CvPoint3D64f paramCvPoint3D64f);
/*      */ 
/*      */   public static native int icvGetCrossLines(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f4, opencv_core.CvPoint3D64f paramCvPoint3D64f5);
/*      */ 
/*      */   public static native int icvComputeStereoLineCoeffs(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f1, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f2, @ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f3, double paramDouble, CvStereoLineCoeff paramCvStereoLineCoeff);
/*      */ 
/*      */   public static native int icvGetAngleLine(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3);
/*      */ 
/*      */   public static native void icvGetCoefForPiece(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvComputeeInfiniteProject1(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2);
/*      */ 
/*      */   public static native void icvComputeeInfiniteProject1(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2);
/*      */ 
/*      */   public static native void icvComputeeInfiniteProject2(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2);
/*      */ 
/*      */   public static native void icvComputeeInfiniteProject2(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2);
/*      */ 
/*      */   public static native void icvGetCrossDirectDirect(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvPoint2D64f paramCvPoint2D64f, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetCrossDirectDirect(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, opencv_core.CvPoint2D64f paramCvPoint2D64f, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetCrossPieceDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double paramDouble1, double paramDouble2, double paramDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f3, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetCrossPiecePiece(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetPieceLength(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native void icvGetCrossRectDirect(@ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f1, opencv_core.CvPoint2D64f paramCvPoint2D64f2, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvProjectPointToImage(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f);
/*      */ 
/*      */   public static native void icvProjectPointToImage(@ByVal opencv_core.CvPoint3D64f paramCvPoint3D64f, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, opencv_core.CvPoint2D64f paramCvPoint2D64f);
/*      */ 
/*      */   public static native void icvGetQuadsTransform(@ByVal opencv_core.CvSize paramCvSize1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4, double[] paramArrayOfDouble5, double[] paramArrayOfDouble6, opencv_core.CvSize paramCvSize2, @Cast({"double(*)[2]"}) double[] paramArrayOfDouble7, @Cast({"double(*)[2]"}) double[] paramArrayOfDouble8, double[] paramArrayOfDouble9, opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2);
/*      */ 
/*      */   public static native void icvGetQuadsTransform(@ByVal opencv_core.CvSize paramCvSize1, DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, DoublePointer paramDoublePointer3, DoublePointer paramDoublePointer4, DoublePointer paramDoublePointer5, DoublePointer paramDoublePointer6, opencv_core.CvSize paramCvSize2, @Cast({"double(*)[2]"}) DoublePointer paramDoublePointer7, @Cast({"double(*)[2]"}) DoublePointer paramDoublePointer8, DoublePointer paramDoublePointer9, opencv_core.CvPoint3D64f paramCvPoint3D64f1, opencv_core.CvPoint3D64f paramCvPoint3D64f2);
/*      */ 
/*      */   public static native void icvGetQuadsTransformStruct(CvStereoCamera paramCvStereoCamera);
/*      */ 
/*      */   public static native void icvComputeStereoParamsForCameras(CvStereoCamera paramCvStereoCamera);
/*      */ 
/*      */   public static native void icvGetCutPiece(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetCutPiece(DoublePointer paramDoublePointer1, DoublePointer paramDoublePointer2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D64f paramCvPoint2D64f2, opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4, opencv_core.CvPoint2D64f paramCvPoint2D64f5, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void icvGetMiddleAnglePoint(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3, opencv_core.CvPoint2D64f paramCvPoint2D64f4);
/*      */ 
/*      */   public static native void icvGetNormalDirect(double[] paramArrayOfDouble1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble2);
/*      */ 
/*      */   public static native void icvGetNormalDirect(DoublePointer paramDoublePointer1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer2);
/*      */ 
/*      */   public static native double icvGetVect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f2, @ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f3);
/*      */ 
/*      */   public static native void icvProjectPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, double[] paramArrayOfDouble, opencv_core.CvPoint2D64f paramCvPoint2D64f2);
/*      */ 
/*      */   public static native void icvProjectPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f1, DoublePointer paramDoublePointer, opencv_core.CvPoint2D64f paramCvPoint2D64f2);
/*      */ 
/*      */   public static native void icvGetDistanceFromPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
/*      */ 
/*      */   public static native void icvGetDistanceFromPointToDirect(@ByVal opencv_core.CvPoint2D64f paramCvPoint2D64f, DoublePointer paramDoublePointer, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native opencv_core.IplImage icvCreateIsometricImage(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvDeInterlace(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   public static native CvContourTree cvCreateContourTree(opencv_core.CvSeq paramCvSeq, opencv_core.CvMemStorage paramCvMemStorage, double paramDouble);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvContourFromContourTree(CvContourTree paramCvContourTree, opencv_core.CvMemStorage paramCvMemStorage, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */   public static native double cvMatchContourTrees(CvContourTree paramCvContourTree1, CvContourTree paramCvContourTree2, int paramInt, double paramDouble);
/*      */ 
/*      */   public static native void cvSnakeImage(opencv_core.IplImage paramIplImage, opencv_core.CvPoint paramCvPoint, int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*      */ 
/*      */   public static native void cvSnakeImage(opencv_core.IplImage paramIplImage, opencv_core.CvPoint paramCvPoint, int paramInt1, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2, FloatPointer paramFloatPointer3, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt3);
/*      */ 
/*      */   public static native CvGLCM cvCreateGLCM(opencv_core.IplImage paramIplImage, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvReleaseGLCM(@ByPtrPtr CvGLCM paramCvGLCM, int paramInt);
/*      */ 
/*      */   public static native void cvCreateGLCMDescriptors(CvGLCM paramCvGLCM, int paramInt);
/*      */ 
/*      */   public static native double cvGetGLCMDescriptor(CvGLCM paramCvGLCM, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvGetGLCMDescriptorStatistics(CvGLCM paramCvGLCM, int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
/*      */ 
/*      */   public static native opencv_core.IplImage cvCreateGLCMImage(CvGLCM paramCvGLCM, int paramInt);
/*      */ 
/*      */   public static native CvFaceTracker cvInitFaceTracker(CvFaceTracker paramCvFaceTracker, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect, int paramInt);
/*      */ 
/*      */   public static native int cvTrackFace(CvFaceTracker paramCvFaceTracker, opencv_core.IplImage paramIplImage, opencv_core.CvRect paramCvRect, int paramInt, opencv_core.CvPoint paramCvPoint, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native void cvReleaseFaceTracker(@ByPtrPtr CvFaceTracker paramCvFaceTracker);
/*      */ 
/*      */   public static Cv3dTracker2dTrackedObject cv3dTracker2dTrackedObject(int id, opencv_core.CvPoint2D32f p)
/*      */   {
/* 1077 */     Cv3dTracker2dTrackedObject r = new Cv3dTracker2dTrackedObject();
/* 1078 */     r.id(id);
/* 1079 */     r.p(p);
/* 1080 */     return r;
/*      */   }
/*      */ 
/*      */   public static Cv3dTrackerTrackedObject cv3dTrackerTrackedObject(int id, opencv_core.CvPoint3D32f p)
/*      */   {
/* 1100 */     Cv3dTrackerTrackedObject r = new Cv3dTrackerTrackedObject();
/* 1101 */     r.id(id);
/* 1102 */     r.p(p);
/* 1103 */     return r;
/*      */   }
/*      */ 
/*      */   public static native boolean cv3dTrackerCalibrateCameras(int paramInt, Cv3dTrackerCameraIntrinsics paramCv3dTrackerCameraIntrinsics, @ByVal opencv_core.CvSize paramCvSize, float paramFloat, opencv_core.IplImageArray paramIplImageArray, Cv3dTrackerCameraInfo paramCv3dTrackerCameraInfo);
/*      */ 
/*      */   public static native int cv3dTrackerLocateObjects(int paramInt1, int paramInt2, Cv3dTrackerCameraInfo paramCv3dTrackerCameraInfo, Cv3dTracker2dTrackedObject paramCv3dTracker2dTrackedObject, Cv3dTrackerTrackedObject paramCv3dTrackerTrackedObject);
/*      */ 
/*      */   public static CvVoronoiSite2D CV_NEXT_VORONOISITE2D(CvVoronoiSite2D SITE)
/*      */   {
/* 1163 */     return SITE.edge(0).site(SITE.edge(0).site(0) == SITE ? 1 : 0);
/*      */   }
/*      */   public static CvVoronoiSite2D CV_PREV_VORONOISITE2D(CvVoronoiSite2D SITE) {
/* 1166 */     return SITE.edge(1).site(SITE.edge(1).site(0) == SITE ? 1 : 0);
/*      */   }
/*      */   public static CvVoronoiEdge2D CV_FIRST_VORONOIEDGE2D(CvVoronoiSite2D SITE) {
/* 1169 */     return SITE.edge(0);
/*      */   }
/*      */   public static CvVoronoiEdge2D CV_LAST_VORONOIEDGE2D(CvVoronoiSite2D SITE) {
/* 1172 */     return SITE.edge(1);
/*      */   }
/*      */   public static CvVoronoiEdge2D CV_NEXT_VORONOIEDGE2D(CvVoronoiEdge2D EDGE, CvVoronoiSite2D SITE) {
/* 1175 */     return EDGE.next(EDGE.site(0) != SITE ? 1 : 0);
/*      */   }
/*      */   public static CvVoronoiEdge2D CV_PREV_VORONOIEDGE2D(CvVoronoiEdge2D EDGE, CvVoronoiSite2D SITE) {
/* 1178 */     return EDGE.next(2 + (EDGE.site(0) != SITE ? 1 : 0));
/*      */   }
/*      */   public static CvVoronoiNode2D CV_VORONOIEDGE2D_BEGINNODE(CvVoronoiEdge2D EDGE, CvVoronoiSite2D SITE) {
/* 1181 */     return EDGE.node(EDGE.site(0) != SITE ? 1 : 0);
/*      */   }
/*      */   public static CvVoronoiNode2D CV_VORONOIEDGE2D_ENDNODE(CvVoronoiEdge2D EDGE, CvVoronoiSite2D SITE) {
/* 1184 */     return EDGE.node(EDGE.site(0) == SITE ? 1 : 0);
/*      */   }
/*      */   public static CvVoronoiSite2D CV_TWIN_VORONOISITE2D(CvVoronoiSite2D SITE, CvVoronoiEdge2D EDGE) {
/* 1187 */     return EDGE.site(EDGE.site(0) == SITE ? 1 : 0);
/*      */   }
/*      */ 
/*      */   public static native int cvVoronoiDiagramFromContour(opencv_core.CvSeq paramCvSeq, @ByPtrPtr CvVoronoiDiagram2D paramCvVoronoiDiagram2D, opencv_core.CvMemStorage paramCvMemStorage, @Cast({"CvLeeParameters"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int cvVoronoiDiagramFromImage(opencv_core.IplImage paramIplImage, @ByPtrPtr opencv_core.CvSeq paramCvSeq, @ByPtrPtr CvVoronoiDiagram2D paramCvVoronoiDiagram2D, opencv_core.CvMemStorage paramCvMemStorage, @Cast({"CvLeeParameters"}) int paramInt, float paramFloat);
/*      */ 
/*      */   public static native void cvReleaseVoronoiStorage(CvVoronoiDiagram2D paramCvVoronoiDiagram2D, @ByPtrPtr opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native opencv_core.CvGraph cvLinearContorModelFromVoronoiDiagram(CvVoronoiDiagram2D paramCvVoronoiDiagram2D, float paramFloat);
/*      */ 
/*      */   public static native int cvReleaseLinearContorModelStorage(@ByPtrPtr opencv_core.CvGraph paramCvGraph);
/*      */ 
/*      */   public static native void cvInitPerspectiveTransform(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"double(*)[3]"}) double[] paramArrayOfDouble, opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvInitPerspectiveTransform(@ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"double(*)[3]"}) DoublePointer paramDoublePointer, opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvMakeScanlines(@Cast({"CvMatrix3*"}) float[] paramArrayOfFloat, @ByVal opencv_core.CvSize paramCvSize, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
/*      */ 
/*      */   public static native void cvMakeScanlines(@Cast({"CvMatrix3*"}) FloatPointer paramFloatPointer, @ByVal opencv_core.CvSize paramCvSize, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
/*      */ 
/*      */   public static native void cvPreWarpImage(int paramInt, opencv_core.IplImage paramIplImage, @Cast({"uchar*"}) BytePointer paramBytePointer, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native void cvFindRuns(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer1, @Cast({"uchar*"}) BytePointer paramBytePointer2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6);
/*      */ 
/*      */   public static native void cvDynamicCorrespondMulti(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6);
/*      */ 
/*      */   public static native void cvMakeAlphaScanlines(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int paramInt, float paramFloat);
/*      */ 
/*      */   public static native void cvMorphEpilinesMulti(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer1, int[] paramArrayOfInt1, @Cast({"uchar*"}) BytePointer paramBytePointer2, int[] paramArrayOfInt2, @Cast({"uchar*"}) BytePointer paramBytePointer3, int[] paramArrayOfInt3, float paramFloat, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7, int[] paramArrayOfInt8, int[] paramArrayOfInt9);
/*      */ 
/*      */   public static native void cvPostWarpImage(int paramInt, @Cast({"uchar*"}) BytePointer paramBytePointer, int[] paramArrayOfInt1, opencv_core.IplImage paramIplImage, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native void cvDeleteMoire(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */   public static native CvConDensation cvCreateConDensation(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvReleaseConDensation(@ByPtrPtr CvConDensation paramCvConDensation);
/*      */ 
/*      */   public static native void cvConDensUpdateByTime(CvConDensation paramCvConDensation);
/*      */ 
/*      */   public static native void cvConDensInitSampleSet(CvConDensation paramCvConDensation, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */   public static int iplWidth(opencv_core.IplImage img)
/*      */   {
/* 1409 */     return img.roi() == null ? img.width() : img == null ? 0 : img.roi().width();
/*      */   }
/*      */ 
/*      */   public static int iplHeight(opencv_core.IplImage img) {
/* 1413 */     return img.roi() == null ? img.height() : img == null ? 0 : img.roi().height();
/*      */   }
/*      */ 
/*      */   public static native void cvPyrSegmentation(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static native void cvInitSubdivDelaunay2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */   public static native opencv_imgproc.CvSubdiv2D cvCreateSubdiv2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static opencv_imgproc.CvSubdiv2D cvCreateSubdivDelaunay2D(opencv_core.CvRect rect, opencv_core.CvMemStorage storage)
/*      */   {
/* 2376 */     opencv_imgproc.CvSubdiv2D subdiv = cvCreateSubdiv2D(8192, Loader.sizeof(opencv_imgproc.CvSubdiv2D.class), Loader.sizeof(opencv_imgproc.CvSubdiv2DPoint.class), Loader.sizeof(opencv_imgproc.CvQuadEdge2D.class), storage);
/*      */ 
/* 2378 */     cvInitSubdivDelaunay2D(subdiv, rect);
/* 2379 */     return subdiv; } 
/*      */   public static native opencv_imgproc.CvSubdiv2DPoint cvSubdivDelaunay2DInsert(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native int cvSubdiv2DLocate(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @Cast({"CvSubdiv2DEdge*"}) SizeTPointer paramSizeTPointer, @ByPtrPtr opencv_imgproc.CvSubdiv2DPoint paramCvSubdiv2DPoint);
/*      */ 
/*      */   public static native void cvCalcSubdivVoronoi2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
/*      */ 
/*      */   public static native void cvClearSubdivVoronoi2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D);
/*      */ 
/*      */   public static native opencv_imgproc.CvSubdiv2DPoint cvFindNearestPoint2D(opencv_imgproc.CvSubdiv2D paramCvSubdiv2D, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/* 2389 */   public static opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DNextEdge(opencv_imgproc.CvSubdiv2DEdge edge) { return opencv_imgproc.CV_SUBDIV2D_NEXT_EDGE(edge); }
/*      */ 
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DRotateEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge, int paramInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DSymEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_imgproc.CvSubdiv2DEdge cvSubdiv2DGetEdge(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge, @Cast({"CvNextEdgeType"}) int paramInt);
/*      */ 
/*      */   public static native opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeOrg(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
/*      */ 
/*      */   public static native opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeDst(@ByVal opencv_imgproc.CvSubdiv2DEdge paramCvSubdiv2DEdge);
/*      */ 
/*      */   public static native double cvTriangleArea(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f3);
/*      */ 
/*      */   public static native opencv_imgproc.CvFeatureTree cvCreateKDTree(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native opencv_imgproc.CvFeatureTree cvCreateSpillTree(opencv_core.CvMat paramCvMat, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static native void cvReleaseFeatureTree(opencv_imgproc.CvFeatureTree paramCvFeatureTree);
/*      */ 
/*      */   public static native void cvFindFeatures(opencv_imgproc.CvFeatureTree paramCvFeatureTree, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int cvFindFeaturesBoxed(opencv_imgproc.CvFeatureTree paramCvFeatureTree, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */   public static native CvLSH cvCreateLSH(CvLSHOperations paramCvLSHOperations, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, long paramLong);
/*      */ 
/*      */   public static native CvLSH cvCreateMemoryLSH(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, long paramLong);
/*      */ 
/*      */   public static native void cvReleaseLSH(@ByPtrPtr CvLSH paramCvLSH);
/*      */ 
/*      */   public static native int LSHSize(CvLSH paramCvLSH);
/*      */ 
/*      */   public static native void cvLSHAdd(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */   public static native void cvLSHRemove(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native void cvLSHQuery(CvLSH paramCvLSH, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native CvStereoGCState cvCreateStereoGCState(int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvReleaseStereoGCState(@ByPtrPtr CvStereoGCState paramCvStereoGCState);
/*      */ 
/*      */   public static native void cvFindStereoCorrespondenceGC(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, CvStereoGCState paramCvStereoGCState, int paramInt);
/*      */ 
/*      */   public static native void cvCalcOpticalFlowLK(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvCalcOpticalFlowBM(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvSize paramCvSize3, int paramInt, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvCalcOpticalFlowHS(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */   public static native void cvReleaseBGStatModel(@ByPtrPtr CvBGStatModel paramCvBGStatModel);
/*      */ 
/*      */   public static native int cvUpdateBGStatModel(opencv_core.IplImage paramIplImage, CvBGStatModel paramCvBGStatModel, double paramDouble);
/*      */ 
/*      */   public static native void cvRefineForegroundMaskBySegm(opencv_core.CvSeq paramCvSeq, CvBGStatModel paramCvBGStatModel);
/*      */ 
/*      */   public static native int cvChangeDetection(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
/*      */ 
/*      */   public static native CvBGStatModel cvCreateFGDStatModel(opencv_core.IplImage paramIplImage, CvFGDStatModelParams paramCvFGDStatModelParams);
/*      */ 
/*      */   public static native CvBGStatModel cvCreateGaussianBGModel(opencv_core.IplImage paramIplImage, CvGaussBGStatModelParams paramCvGaussBGStatModelParams);
/*      */ 
/*      */   public static native CvBGCodeBookModel cvCreateBGCodeBookModel();
/*      */ 
/*      */   public static native void cvReleaseBGCodeBookModel(@ByPtrPtr CvBGCodeBookModel paramCvBGCodeBookModel);
/*      */ 
/*      */   public static native void cvBGCodeBookUpdate(CvBGCodeBookModel paramCvBGCodeBookModel, opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvRect paramCvRect, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native int cvBGCodeBookDiff(CvBGCodeBookModel paramCvBGCodeBookModel, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */   public static native void cvBGCodeBookClearStale(CvBGCodeBookModel paramCvBGCodeBookModel, int paramInt, @ByVal opencv_core.CvRect paramCvRect, opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvSegmentFGMask(opencv_core.CvArr paramCvArr, int paramInt, float paramFloat, opencv_core.CvMemStorage paramCvMemStorage, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   public static native void cvWriteStruct(opencv_core.CvFileStorage paramCvFileStorage, String paramString1, Pointer paramPointer, String paramString2, int paramInt);
/*      */ 
/*      */   public static native void cvReadStructByName(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString1, Pointer paramPointer, String paramString2);
/*      */ 
/*      */   public static native void cvReleaseFGDetector(@ByPtrPtr CvFGDetector paramCvFGDetector);
/*      */ 
/*      */   public static native CvFGDetector cvCreateFGDetectorBase(int paramInt, Pointer paramPointer);
/*      */ 
/*      */   public static CvBlob cvBlob(float x, float y, float w, float h)
/*      */   {
/* 2962 */     return new CvBlob().x(x).y(y).w(w).h(h).ID(0);
/*      */   }
/*      */ 
/*      */   public static int CV_BLOB_ID(CvBlob pB)
/*      */   {
/* 2968 */     return pB.ID(); } 
/* 2969 */   public static opencv_core.CvPoint2D32f CV_BLOB_CENTER(CvBlob pB) { return opencv_core.cvPoint2D32f(pB.x(), pB.y()); } 
/* 2970 */   public static float CV_BLOB_X(CvBlob pB) { return pB.x(); } 
/* 2971 */   public static float CV_BLOB_Y(CvBlob pB) { return pB.y(); } 
/* 2972 */   public static float CV_BLOB_WX(CvBlob pB) { return pB.w(); } 
/* 2973 */   public static float CV_BLOB_WY(CvBlob pB) { return pB.h(); } 
/* 2974 */   public static float CV_BLOB_RX(CvBlob pB) { return 0.5F * CV_BLOB_WX(pB); } 
/* 2975 */   public static float CV_BLOB_RY(CvBlob pB) { return 0.5F * CV_BLOB_WY(pB); } 
/* 2976 */   public static opencv_core.CvRect CV_BLOB_RECT(CvBlob pB) { return opencv_core.cvRect(Math.round(pB.x() - CV_BLOB_RX(pB)), Math.round(pB.y() - CV_BLOB_RY(pB)), Math.round(CV_BLOB_WX(pB)), Math.round(CV_BLOB_WY(pB))); }
/*      */ 
/*      */ 
/*      */   public static native void cvReleaseBlobDetector(@ByPtrPtr CvBlobDetector paramCvBlobDetector);
/*      */ 
/*      */   public static native CvBlobDetector cvCreateBlobDetectorSimple();
/*      */ 
/*      */   public static native CvBlobDetector cvCreateBlobDetectorCC();
/*      */ 
/*      */   public static CvDetectedBlob cvDetectedBlob(float x, float y, float w, float h, int ID, float response)
/*      */   {
/* 3068 */     CvDetectedBlob b = new CvDetectedBlob();
/* 3069 */     b.x(x).y(y).w(w).h(h).ID(ID); b.response(response);
/* 3070 */     return b;
/*      */   }
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvRect cvRectIntersection(@ByVal opencv_core.CvRect paramCvRect1, @ByVal opencv_core.CvRect paramCvRect2);
/*      */ 
/*      */   public static native void cvReleaseBlobTrackGen(@ByPtrPtr CvBlobTrackGen paramCvBlobTrackGen);
/*      */ 
/*      */   public static native CvBlobTrackGen cvCreateModuleBlobTrackGen1();
/*      */ 
/*      */   public static native CvBlobTrackGen cvCreateModuleBlobTrackGenYML();
/*      */ 
/*      */   public static native void cvReleaseBlobTracker(@ByPtrPtr CvBlobTracker paramCvBlobTracker);
/*      */ 
/*      */   public static native void cvReleaseBlobTrackerOne(@ByPtrPtr CvBlobTrackerOne paramCvBlobTrackerOne);
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerList(CreateCvBlobTrackerOne paramCreateCvBlobTrackerOne);
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerCC();
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerCCMSPF();
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerMSFG();
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerMSFGS();
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerMS();
/*      */ 
/*      */   public static native CvBlobTracker cvCreateBlobTrackerMSPF();
/*      */ 
/*      */   public static native void cvReleaseBlobTrackPostProc(@ByPtrPtr CvBlobTrackPostProc paramCvBlobTrackPostProc);
/*      */ 
/*      */   public static native CvBlobTrackPostProc cvCreateBlobTrackPostProcList(CreateCvBlobTrackPostProcOne paramCreateCvBlobTrackPostProcOne);
/*      */ 
/*      */   public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcKalman();
/*      */ 
/*      */   public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcTimeAverRect();
/*      */ 
/*      */   public static native CvBlobTrackPostProc cvCreateModuleBlobTrackPostProcTimeAverExp();
/*      */ 
/*      */   public static native CvBlobTrackPredictor cvCreateModuleBlobTrackPredictKalman();
/*      */ 
/*      */   public static native void cvReleaseBlobTrackAnalysis(@ByPtrPtr CvBlobTrackAnalysis paramCvBlobTrackAnalysis);
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateBlobTrackAnalysisList(CreateCvBlobTrackAnalysisOne paramCreateCvBlobTrackAnalysisOne);
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistP();
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistPV();
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistPVS();
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisHistSS();
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisTrackDist();
/*      */ 
/*      */   public static native CvBlobTrackAnalysis cvCreateModuleBlobTrackAnalysisIOR();
/*      */ 
/*      */   public static native void cvReleaseBlobTrackerAuto(@ByPtrPtr CvBlobTrackerAuto paramCvBlobTrackerAuto);
/*      */ 
/*      */   public static native CvBlobTrackerAuto cvCreateBlobTrackerAuto1(CvBlobTrackerAutoParam1 paramCvBlobTrackerAutoParam1);
/*      */ 
/*      */   public static native CvBlobTrackerAuto cvCreateBlobTrackerAuto(int paramInt, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvReleaseProb(@ByPtrPtr CvProb paramCvProb);
/*      */ 
/*      */   public static native CvTestSeq cvCreateTestSeq(@Cast({"char*"}) String paramString, @Cast({"char**"}) PointerPointer paramPointerPointer, int paramInt1, float paramFloat, int paramInt2, double paramDouble);
/*      */ 
/*      */   public static native void cvReleaseTestSeq(@ByPtrPtr CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native opencv_core.IplImage cvTestSeqQueryFrame(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native opencv_core.IplImage cvTestSeqGetFGMask(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native opencv_core.IplImage cvTestSeqGetImage(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvSize cvTestSeqGetImageSize(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native int cvTestSeqFrameNum(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native int cvTestSeqGetObjectNum(CvTestSeq paramCvTestSeq);
/*      */ 
/*      */   public static native int cvTestSeqGetObjectPos(CvTestSeq paramCvTestSeq, int paramInt, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native int cvTestSeqGetObjectSize(CvTestSeq paramCvTestSeq, int paramInt, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native void cvTestSeqAddNoise(CvTestSeq paramCvTestSeq, int paramInt, double paramDouble);
/*      */ 
/*      */   public static native void cvTestSeqAddIntensityVariation(CvTestSeq paramCvTestSeq, float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */   public static native void cvTestSeqSetFrame(CvTestSeq paramCvTestSeq, int paramInt);
/*      */ 
/*      */   static
/*      */   {
/*   98 */     Loader.load();
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvTestSeq extends Pointer
/*      */   {
/*      */     public CvTestSeq()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvTestSeq(Pointer p)
/*      */     {
/* 3469 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 3467 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvProb extends Pointer
/*      */   {
/*      */     public CvProb()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvProb(Pointer p)
/*      */     {
/* 3435 */       super();
/*      */     }
/*      */ 
/*      */     public native double Value(int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void AddFeature(float paramFloat, int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void Scale(float paramFloat, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void Release();
/*      */ 
/*      */     static
/*      */     {
/* 3433 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvTracksTimePos extends Pointer
/*      */   {
/*      */     public CvTracksTimePos()
/*      */     {
/* 3404 */       allocate(); } 
/* 3405 */     public CvTracksTimePos(int size) { allocateArray(size); } 
/* 3406 */     public CvTracksTimePos(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3411 */     public CvTracksTimePos position(int position) { return (CvTracksTimePos)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int len1();
/*      */ 
/*      */     public native CvTracksTimePos len1(int paramInt);
/*      */ 
/*      */     public native int len2();
/*      */ 
/*      */     public native CvTracksTimePos len2(int paramInt);
/*      */ 
/*      */     public native int beg1();
/*      */ 
/*      */     public native CvTracksTimePos beg1(int paramInt);
/*      */ 
/*      */     public native int beg2();
/*      */ 
/*      */     public native CvTracksTimePos beg2(int paramInt);
/*      */ 
/*      */     public native int end1();
/*      */ 
/*      */     public native CvTracksTimePos end1(int paramInt);
/*      */ 
/*      */     public native int end2();
/*      */ 
/*      */     public native CvTracksTimePos end2(int paramInt);
/*      */ 
/*      */     public native int comLen();
/*      */ 
/*      */     public native CvTracksTimePos comLen(int paramInt);
/*      */ 
/*      */     public native int shift1();
/*      */ 
/*      */     public native CvTracksTimePos shift1(int paramInt);
/*      */ 
/*      */     public native int shift2();
/*      */ 
/*      */     public native CvTracksTimePos shift2(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3403 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackerAutoParam1 extends Pointer
/*      */   {
/*      */     public CvBlobTrackerAutoParam1()
/*      */     {
/* 3378 */       allocate(); } 
/* 3379 */     public CvBlobTrackerAutoParam1(int size) { allocateArray(size); } 
/* 3380 */     public CvBlobTrackerAutoParam1(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3385 */     public CvBlobTrackerAutoParam1 position(int position) { return (CvBlobTrackerAutoParam1)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int FGTrainFrames();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 FGTrainFrames(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvFGDetector pFG();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pFG(opencv_legacy.CvFGDetector paramCvFGDetector);
/*      */ 
/*      */     public native opencv_legacy.CvBlobDetector pBD();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pBD(opencv_legacy.CvBlobDetector paramCvBlobDetector);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTracker pBT();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pBT(opencv_legacy.CvBlobTracker paramCvBlobTracker);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackGen pBTGen();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pBTGen(opencv_legacy.CvBlobTrackGen paramCvBlobTrackGen);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackPostProc pBTPP();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pBTPP(opencv_legacy.CvBlobTrackPostProc paramCvBlobTrackPostProc);
/*      */ 
/*      */     public native int UsePPData();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 UsePPData(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackAnalysis pBTA();
/*      */ 
/*      */     public native CvBlobTrackerAutoParam1 pBTA(opencv_legacy.CvBlobTrackAnalysis paramCvBlobTrackAnalysis);
/*      */ 
/*      */     static
/*      */     {
/* 3377 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackerAuto extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackerAuto()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackerAuto(Pointer p)
/*      */     {
/* 3363 */       super();
/*      */     }
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlob(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlobByID(int paramInt);
/*      */ 
/*      */     public native int GetBlobNum();
/*      */ 
/*      */     public native opencv_core.IplImage GetFGMask();
/*      */ 
/*      */     public native float GetState(int paramInt);
/*      */ 
/*      */     public native String GetStateDesc(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3361 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackAnalysisHeight extends opencv_legacy.CvBlobTrackAnalysis
/*      */   {
/*      */     public CvBlobTrackAnalysisHeight()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackAnalysisHeight(Pointer p)
/*      */     {
/* 3353 */       super();
/*      */     }
/*      */ 
/*      */     public native double GetHeight(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     static
/*      */     {
/* 3351 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CreateCvBlobTrackAnalysisOne extends FunctionPointer
/*      */   {
/*      */     public CreateCvBlobTrackAnalysisOne(Pointer p)
/*      */     {
/* 3333 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackAnalysisOne call();
/*      */ 
/*      */     static
/*      */     {
/* 3332 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackAnalysisOne extends Pointer
/*      */   {
/*      */     public CvBlobTrackAnalysisOne()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackAnalysisOne(Pointer p)
/*      */     {
/* 3325 */       super();
/*      */     }
/*      */ 
/*      */     public native int Process(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void Release();
/*      */ 
/*      */     static
/*      */     {
/* 3323 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackFVGen extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackFVGen()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackFVGen(Pointer p)
/*      */     {
/* 3309 */       super();
/*      */     }
/*      */ 
/*      */     public native void AddBlob(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native int GetFVSize();
/*      */ 
/*      */     public native int GetFVNum();
/*      */ 
/*      */     public native FloatPointer GetFV(int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */     public native FloatPointer GetFVVar();
/*      */ 
/*      */     public native FloatPointer GetFVMin();
/*      */ 
/*      */     public native FloatPointer GetFVMax();
/*      */ 
/*      */     static
/*      */     {
/* 3307 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackAnalysis extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackAnalysis()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackAnalysis(Pointer p)
/*      */     {
/* 3293 */       super();
/*      */     }
/*      */ 
/*      */     public native void AddBlob(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native float GetState(int paramInt);
/*      */ 
/*      */     public native String GetStateDesc(int paramInt);
/*      */ 
/*      */     public native void SetFileName(@Cast({"char*"}) String paramString);
/*      */ 
/*      */     static
/*      */     {
/* 3291 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackPredictor extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackPredictor()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackPredictor(Pointer p)
/*      */     {
/* 3282 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlob Predict();
/*      */ 
/*      */     public native void Update(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     static
/*      */     {
/* 3280 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CreateCvBlobTrackPostProcOne extends FunctionPointer
/*      */   {
/*      */     public CreateCvBlobTrackPostProcOne(Pointer p)
/*      */     {
/* 3270 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackPostProcOne call();
/*      */ 
/*      */     static
/*      */     {
/* 3269 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackPostProcOne extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackPostProcOne()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackPostProcOne(Pointer p)
/*      */     {
/* 3263 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlob Process(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     static
/*      */     {
/* 3261 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackPostProc extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackPostProc()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackPostProc(Pointer p)
/*      */     {
/* 3248 */       super();
/*      */     }
/*      */ 
/*      */     public native void AddBlob(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native void Process();
/*      */ 
/*      */     public native int GetBlobNum();
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlob(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlobByID(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3246 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackerParamLH extends Pointer
/*      */   {
/*      */     public CvBlobTrackerParamLH()
/*      */     {
/* 3219 */       allocate(); } 
/* 3220 */     public CvBlobTrackerParamLH(int size) { allocateArray(size); } 
/* 3221 */     public CvBlobTrackerParamLH(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3226 */     public CvBlobTrackerParamLH position(int position) { return (CvBlobTrackerParamLH)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int HistType();
/*      */ 
/*      */     public native CvBlobTrackerParamLH HistType(int paramInt);
/*      */ 
/*      */     public native int ScaleAfter();
/*      */ 
/*      */     public native CvBlobTrackerParamLH ScaleAfter(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3218 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackerParamMS extends Pointer
/*      */   {
/*      */     public CvBlobTrackerParamMS()
/*      */     {
/* 3197 */       allocate(); } 
/* 3198 */     public CvBlobTrackerParamMS(int size) { allocateArray(size); } 
/* 3199 */     public CvBlobTrackerParamMS(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3204 */     public CvBlobTrackerParamMS position(int position) { return (CvBlobTrackerParamMS)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int noOfSigBits();
/*      */ 
/*      */     public native CvBlobTrackerParamMS noOfSigBits(int paramInt);
/*      */ 
/*      */     public native int appearance_profile();
/*      */ 
/*      */     public native CvBlobTrackerParamMS appearance_profile(int paramInt);
/*      */ 
/*      */     public native int meanshift_profile();
/*      */ 
/*      */     public native CvBlobTrackerParamMS meanshift_profile(int paramInt);
/*      */ 
/*      */     public native float sigma();
/*      */ 
/*      */     public native CvBlobTrackerParamMS sigma(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 3196 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CreateCvBlobTrackerOne extends FunctionPointer
/*      */   {
/*      */     public CreateCvBlobTrackerOne(Pointer p)
/*      */     {
/* 3186 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrackerOne call();
/*      */ 
/*      */     static
/*      */     {
/* 3185 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackerOne extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackerOne()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackerOne(Pointer p)
/*      */     {
/* 3171 */       super();
/*      */     }
/*      */ 
/*      */     public native void Init(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native opencv_legacy.CvBlob Process(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void SkipProcess(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void Update(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void SetCollision(int paramInt);
/*      */ 
/*      */     public native double GetConfidence(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3);
/*      */ 
/*      */     static
/*      */     {
/* 3169 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTracker extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTracker()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTracker(Pointer p)
/*      */     {
/* 3142 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_legacy.CvBlob AddBlob(opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native int GetBlobNum();
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlob(int paramInt);
/*      */ 
/*      */     public native void DelBlob(int paramInt);
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void ProcessBlob(int paramInt, opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native double GetConfidence(int paramInt, opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native double GetConfidenceList(opencv_legacy.CvBlobSeq paramCvBlobSeq, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void UpdateBlob(int paramInt, opencv_legacy.CvBlob paramCvBlob, opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native void Update(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     public native int GetBlobIndexByID(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlobByID(int paramInt);
/*      */ 
/*      */     public native void DelBlobByID(int paramInt);
/*      */ 
/*      */     public native void SetBlob(int paramInt, opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native void SetBlobByID(int paramInt, opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native int GetBlobHypNum(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlobHyp(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void SetBlobHyp(int paramInt, opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     static
/*      */     {
/* 3140 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackGen extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobTrackGen()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobTrackGen(Pointer p)
/*      */     {
/* 3126 */       super();
/*      */     }
/*      */ 
/*      */     public native void SetFileName(@Cast({"char*"}) String paramString);
/*      */ 
/*      */     public native void AddBlob(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2);
/*      */ 
/*      */     static
/*      */     {
/* 3124 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvImageDrawer extends Pointer
/*      */   {
/*      */     public CvImageDrawer()
/*      */     {
/* 3110 */       allocate(); } 
/* 3111 */     public CvImageDrawer(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native opencv_core.IplImage GetImage();
/*      */ 
/*      */     static
/*      */     {
/* 3109 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvDrawShape extends Pointer
/*      */   {
/*      */     public static final int RECT = 0;
/*      */     public static final int ELLIPSE = 1;
/*      */ 
/*      */     public CvDrawShape()
/*      */     {
/* 3094 */       allocate(); } 
/* 3095 */     public CvDrawShape(int size) { allocateArray(size); } 
/* 3096 */     public CvDrawShape(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3101 */     public CvDrawShape position(int position) { return (CvDrawShape)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvScalar color();
/*      */ 
/*      */     public native CvDrawShape color(opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     static
/*      */     {
/* 3093 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvObjectDetector extends Pointer
/*      */   {
/*      */     public CvObjectDetector()
/*      */     {
/* 3075 */       allocate(); } 
/* 3076 */     public CvObjectDetector(String detector_file_name) { allocate(detector_file_name); } 
/* 3077 */     public CvObjectDetector(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(String paramString);
/*      */ 
/*      */     public native boolean Load(String paramString);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize GetMinWindowSize();
/*      */ 
/*      */     public native int GetMaxBorderSize();
/*      */ 
/*      */     public native void Detect(opencv_core.CvArr paramCvArr, opencv_legacy.CvBlobSeq paramCvBlobSeq);
/*      */ 
/*      */     static
/*      */     {
/* 3074 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvDetectedBlob extends opencv_legacy.CvBlob
/*      */   {
/*      */     public CvDetectedBlob()
/*      */     {
/* 3054 */       allocate(); } 
/* 3055 */     public CvDetectedBlob(int size) { allocateArray(size); } 
/* 3056 */     public CvDetectedBlob(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3061 */     public CvDetectedBlob position(int position) { return (CvDetectedBlob)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float response();
/*      */ 
/*      */     public native CvDetectedBlob response(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 3053 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobDetector extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvBlobDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvBlobDetector(Pointer p)
/*      */     {
/* 3042 */       super();
/*      */     }
/*      */ 
/*      */     public native int DetectNewBlob(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_legacy.CvBlobSeq paramCvBlobSeq1, opencv_legacy.CvBlobSeq paramCvBlobSeq2);
/*      */ 
/*      */     static
/*      */     {
/* 3040 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrackSeq extends Pointer
/*      */   {
/*      */     public CvBlobTrackSeq()
/*      */     {
/* 3021 */       allocate(); } 
/* 3022 */     public CvBlobTrackSeq(int TrackSize) { allocate(TrackSize); } 
/* 3023 */     public CvBlobTrackSeq(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrack GetBlobTrack(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlobTrack GetBlobTrackByID(int paramInt);
/*      */ 
/*      */     public native void DelBlobTrack(int paramInt);
/*      */ 
/*      */     public native void DelBlobTrackByID(int paramInt);
/*      */ 
/*      */     public native void Clear();
/*      */ 
/*      */     public native void AddBlobTrack(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int GetBlobTrackNum();
/*      */ 
/*      */     static
/*      */     {
/* 3020 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobTrack extends Pointer
/*      */   {
/*      */     public CvBlobTrack()
/*      */     {
/* 3004 */       allocate(); } 
/* 3005 */     public CvBlobTrack(int size) { allocateArray(size); } 
/* 3006 */     public CvBlobTrack(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3011 */     public CvBlobTrack position(int position) { return (CvBlobTrack)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int TrackID();
/*      */ 
/*      */     public native CvBlobTrack TrackID(int paramInt);
/*      */ 
/*      */     public native int StartFrame();
/*      */ 
/*      */     public native CvBlobTrack StartFrame(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlobSeq pBlobSeq();
/*      */ 
/*      */     public native CvBlobTrack pBlobSeq(opencv_legacy.CvBlobSeq paramCvBlobSeq);
/*      */ 
/*      */     static
/*      */     {
/* 3003 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlobSeq extends Pointer
/*      */   {
/*      */     public CvBlobSeq()
/*      */     {
/* 2980 */       allocate(); } 
/* 2981 */     public CvBlobSeq(int BlobSize) { allocate(BlobSize); } 
/* 2982 */     public CvBlobSeq(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlob(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvBlob GetBlobByID(int paramInt);
/*      */ 
/*      */     public native void DelBlob(int paramInt);
/*      */ 
/*      */     public native void DelBlobByID(int paramInt);
/*      */ 
/*      */     public native void Clear();
/*      */ 
/*      */     public native void AddBlob(opencv_legacy.CvBlob paramCvBlob);
/*      */ 
/*      */     public native int GetBlobNum();
/*      */ 
/*      */     public native void Write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     public native void Load(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void AddFormat(String paramString);
/*      */ 
/*      */     static
/*      */     {
/* 2979 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBlob extends Pointer
/*      */   {
/*      */     public CvBlob()
/*      */     {
/* 2944 */       allocate(); } 
/* 2945 */     public CvBlob(int size) { allocateArray(size); } 
/* 2946 */     public CvBlob(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2951 */     public CvBlob position(int position) { return (CvBlob)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float x();
/*      */ 
/*      */     public native CvBlob x(float paramFloat);
/*      */ 
/*      */     public native float y();
/*      */ 
/*      */     public native CvBlob y(float paramFloat);
/*      */ 
/*      */     public native float w();
/*      */ 
/*      */     public native CvBlob w(float paramFloat);
/*      */ 
/*      */     public native float h();
/*      */ 
/*      */     public native CvBlob h(float paramFloat);
/*      */ 
/*      */     public native int ID();
/*      */ 
/*      */     public native CvBlob ID(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2943 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFGDetector extends opencv_legacy.CvVSModule
/*      */   {
/*      */     public CvFGDetector()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFGDetector(Pointer p)
/*      */     {
/* 2932 */       super();
/*      */     }
/*      */ 
/*      */     public native opencv_core.IplImage GetMask();
/*      */ 
/*      */     public native void Process(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     static
/*      */     {
/* 2930 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVSModule extends Pointer
/*      */   {
/*      */     public CvVSModule()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvVSModule(Pointer p)
/*      */     {
/* 2890 */       super();
/*      */     }
/*      */ 
/*      */     public native String GetParamName(int paramInt);
/*      */ 
/*      */     public native String GetParamComment(String paramString);
/*      */ 
/*      */     public native double GetParam(String paramString);
/*      */ 
/*      */     public native String GetParamStr(String paramString);
/*      */ 
/*      */     public native void SetParam(String paramString, double paramDouble);
/*      */ 
/*      */     public native void SetParamStr(String paramString1, String paramString2);
/*      */ 
/*      */     public native void TransferParamsFromChild(CvVSModule paramCvVSModule, String paramString);
/*      */ 
/*      */     public native void TransferParamsToChild(CvVSModule paramCvVSModule, @Cast({"char*"}) String paramString);
/*      */ 
/*      */     public native void ParamUpdate();
/*      */ 
/*      */     public native String GetTypeName();
/*      */ 
/*      */     public native int IsModuleTypeName(String paramString);
/*      */ 
/*      */     public native String GetModuleName();
/*      */ 
/*      */     public native int IsModuleName(String paramString);
/*      */ 
/*      */     public native void SetNickName(String paramString);
/*      */ 
/*      */     public native String GetNickName();
/*      */ 
/*      */     public native void SaveState(opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void LoadState(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void Release();
/*      */ 
/*      */     static
/*      */     {
/* 2888 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvDefParam extends Pointer
/*      */   {
/*      */     public CvDefParam()
/*      */     {
/* 2860 */       allocate(); } 
/* 2861 */     public CvDefParam(int size) { allocateArray(size); } 
/* 2862 */     public CvDefParam(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2867 */     public CvDefParam position(int position) { return (CvDefParam)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvDefParam next();
/*      */ 
/*      */     public native CvDefParam next(CvDefParam paramCvDefParam);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer pName();
/*      */ 
/*      */     public native CvDefParam pName(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer pComment();
/*      */ 
/*      */     public native CvDefParam pComment(BytePointer paramBytePointer);
/*      */ 
/*      */     public native DoublePointer pDouble();
/*      */ 
/*      */     public native CvDefParam pDouble(DoublePointer paramDoublePointer);
/*      */ 
/*      */     public native double Double();
/*      */ 
/*      */     public native CvDefParam Double(double paramDouble);
/*      */ 
/*      */     public native FloatPointer pFloat();
/*      */ 
/*      */     public native CvDefParam pFloat(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native float Float();
/*      */ 
/*      */     public native CvDefParam Float(float paramFloat);
/*      */ 
/*      */     public native IntPointer pInt();
/*      */ 
/*      */     public native CvDefParam pInt(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int Int();
/*      */ 
/*      */     public native CvDefParam Int(int paramInt);
/*      */ 
/*      */     @Cast({"char**"})
/*      */     public native PointerPointer pStr();
/*      */ 
/*      */     public native CvDefParam pStr(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer Str();
/*      */ 
/*      */     public native CvDefParam Str(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 2859 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGCodeBookModel extends Pointer
/*      */   {
/*      */     public CvBGCodeBookModel()
/*      */     {
/* 2806 */       allocate(); zero(); } 
/* 2807 */     public CvBGCodeBookModel(int size) { allocateArray(size); zero(); } 
/* 2808 */     public CvBGCodeBookModel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2813 */     public CvBGCodeBookModel position(int position) { return (CvBGCodeBookModel)super.position(position); }
/*      */ 
/*      */     public static CvBGCodeBookModel create()
/*      */     {
/* 2817 */       CvBGCodeBookModel m = opencv_legacy.cvCreateBGCodeBookModel();
/* 2818 */       if (m != null) {
/* 2819 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 2821 */       return m;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 2825 */       deallocate();
/*      */     }
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvSize size();
/*      */ 
/*      */     public native CvBGCodeBookModel size(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     public native int t();
/*      */ 
/*      */     public native CvBGCodeBookModel t(int paramInt);
/*      */ 
/*      */     public native byte cbBounds(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookModel cbBounds(int paramInt, byte paramByte);
/*      */ 
/*      */     public native byte modMin(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookModel modMin(int paramInt, byte paramByte);
/*      */ 
/*      */     public native byte modMax(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookModel modMax(int paramInt, byte paramByte);
/*      */ 
/*      */     @Cast({"CvBGCodeBookElem**"})
/*      */     public native PointerPointer cbmap();
/*      */ 
/*      */     public native CvBGCodeBookModel cbmap(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native opencv_core.CvMemStorage storage();
/*      */ 
/*      */     public native CvBGCodeBookModel storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native opencv_legacy.CvBGCodeBookElem freeList();
/*      */ 
/*      */     public native CvBGCodeBookModel freeList(opencv_legacy.CvBGCodeBookElem paramCvBGCodeBookElem);
/*      */ 
/*      */     static
/*      */     {
/* 2805 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvBGCodeBookModel
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvBGCodeBookModel p)
/*      */       {
/* 2828 */         super(); } 
/* 2829 */       public void deallocate() { opencv_legacy.cvReleaseBGCodeBookModel(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGCodeBookElem extends Pointer
/*      */   {
/*      */     public CvBGCodeBookElem()
/*      */     {
/* 2785 */       allocate(); } 
/* 2786 */     public CvBGCodeBookElem(int size) { allocateArray(size); } 
/* 2787 */     public CvBGCodeBookElem(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2792 */     public CvBGCodeBookElem position(int position) { return (CvBGCodeBookElem)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvBGCodeBookElem next();
/*      */ 
/*      */     public native CvBGCodeBookElem next(CvBGCodeBookElem paramCvBGCodeBookElem);
/*      */ 
/*      */     public native int tLastUpdate();
/*      */ 
/*      */     public native CvBGCodeBookElem tLastUpdate(int paramInt);
/*      */ 
/*      */     public native int stale();
/*      */ 
/*      */     public native CvBGCodeBookElem stale(int paramInt);
/*      */ 
/*      */     public native byte boxMin(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookElem boxMin(int paramInt, byte paramByte);
/*      */ 
/*      */     public native byte boxMax(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookElem boxMax(int paramInt, byte paramByte);
/*      */ 
/*      */     public native byte learnMin(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookElem learnMin(int paramInt, byte paramByte);
/*      */ 
/*      */     public native byte learnMax(int paramInt);
/*      */ 
/*      */     public native CvBGCodeBookElem learnMax(int paramInt, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/* 2784 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGaussBGModel extends opencv_legacy.CvBGStatModel
/*      */   {
/*      */     public CvGaussBGModel()
/*      */     {
/* 2763 */       allocate(); zero(); } 
/* 2764 */     public CvGaussBGModel(int size) { allocateArray(size); zero(); } 
/* 2765 */     public CvGaussBGModel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2770 */     public CvGaussBGModel position(int position) { return (CvGaussBGModel)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_legacy.CvGaussBGStatModelParams params();
/*      */ 
/*      */     public native CvGaussBGModel params(opencv_legacy.CvGaussBGStatModelParams paramCvGaussBGStatModelParams);
/*      */ 
/*      */     public native opencv_legacy.CvGaussBGPoint g_point();
/*      */ 
/*      */     public native CvGaussBGModel g_point(opencv_legacy.CvGaussBGPoint paramCvGaussBGPoint);
/*      */ 
/*      */     public native int countFrames();
/*      */ 
/*      */     public native CvGaussBGModel countFrames(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2762 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGaussBGPoint extends Pointer
/*      */   {
/*      */     public CvGaussBGPoint()
/*      */     {
/* 2748 */       allocate(); } 
/* 2749 */     public CvGaussBGPoint(int size) { allocateArray(size); } 
/* 2750 */     public CvGaussBGPoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2755 */     public CvGaussBGPoint position(int position) { return (CvGaussBGPoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_legacy.CvGaussBGValues g_values();
/*      */ 
/*      */     public native CvGaussBGPoint g_values(opencv_legacy.CvGaussBGValues paramCvGaussBGValues);
/*      */ 
/*      */     static
/*      */     {
/* 2747 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGaussBGValues extends Pointer
/*      */   {
/*      */     public CvGaussBGValues()
/*      */     {
/* 2729 */       allocate(); } 
/* 2730 */     public CvGaussBGValues(int size) { allocateArray(size); } 
/* 2731 */     public CvGaussBGValues(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2736 */     public CvGaussBGValues position(int position) { return (CvGaussBGValues)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int match_sum();
/*      */ 
/*      */     public native CvGaussBGValues match_sum(int paramInt);
/*      */ 
/*      */     public native double weight();
/*      */ 
/*      */     public native CvGaussBGValues weight(double paramDouble);
/*      */ 
/*      */     public native double variance(int paramInt);
/*      */ 
/*      */     public native CvGaussBGValues variance(int paramInt, double paramDouble);
/*      */ 
/*      */     public native double mean(int paramInt);
/*      */ 
/*      */     public native CvGaussBGValues mean(int paramInt, double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 2728 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGaussBGStatModelParams extends opencv_legacy.CvBGStatModel
/*      */   {
/*      */     public CvGaussBGStatModelParams()
/*      */     {
/* 2708 */       allocate(); zero(); } 
/* 2709 */     public CvGaussBGStatModelParams(int size) { allocateArray(size); zero(); } 
/* 2710 */     public CvGaussBGStatModelParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2715 */     public CvGaussBGStatModelParams position(int position) { return (CvGaussBGStatModelParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int win_size();
/*      */ 
/*      */     public native CvGaussBGStatModelParams win_size(int paramInt);
/*      */ 
/*      */     public native int n_gauss();
/*      */ 
/*      */     public native CvGaussBGStatModelParams n_gauss(int paramInt);
/*      */ 
/*      */     public native double bg_threshold();
/*      */ 
/*      */     public native CvGaussBGStatModelParams bg_threshold(double paramDouble);
/*      */ 
/*      */     public native double std_threshold();
/*      */ 
/*      */     public native CvGaussBGStatModelParams std_threshold(double paramDouble);
/*      */ 
/*      */     public native double minArea();
/*      */ 
/*      */     public native CvGaussBGStatModelParams minArea(double paramDouble);
/*      */ 
/*      */     public native double weight_init();
/*      */ 
/*      */     public native CvGaussBGStatModelParams weight_init(double paramDouble);
/*      */ 
/*      */     public native double variance_init();
/*      */ 
/*      */     public native CvGaussBGStatModelParams variance_init(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 2707 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFGDStatModel extends opencv_legacy.CvBGStatModel
/*      */   {
/*      */     public CvFGDStatModel()
/*      */     {
/* 2669 */       allocate(); zero(); } 
/* 2670 */     public CvFGDStatModel(int size) { allocateArray(size); zero(); } 
/* 2671 */     public CvFGDStatModel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2676 */     public CvFGDStatModel position(int position) { return (CvFGDStatModel)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_legacy.CvBGPixelStat pixel_stat();
/*      */ 
/*      */     public native CvFGDStatModel pixel_stat(opencv_legacy.CvBGPixelStat paramCvBGPixelStat);
/*      */ 
/*      */     public native opencv_core.IplImage Ftd();
/*      */ 
/*      */     public native CvFGDStatModel Ftd(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native opencv_core.IplImage Fbd();
/*      */ 
/*      */     public native CvFGDStatModel Fbd(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native opencv_core.IplImage prev_frame();
/*      */ 
/*      */     public native CvFGDStatModel prev_frame(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_legacy.CvFGDStatModelParams params();
/*      */ 
/*      */     public native CvFGDStatModel params(opencv_legacy.CvFGDStatModelParams paramCvFGDStatModelParams);
/*      */ 
/*      */     static
/*      */     {
/* 2668 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGPixelStat extends Pointer
/*      */   {
/*      */     public CvBGPixelStat()
/*      */     {
/* 2649 */       allocate(); } 
/* 2650 */     public CvBGPixelStat(int size) { allocateArray(size); } 
/* 2651 */     public CvBGPixelStat(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2656 */     public CvBGPixelStat position(int position) { return (CvBGPixelStat)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float Pbc();
/*      */ 
/*      */     public native CvBGPixelStat Pbc(float paramFloat);
/*      */ 
/*      */     public native float Pbcc();
/*      */ 
/*      */     public native CvBGPixelStat Pbcc(float paramFloat);
/*      */ 
/*      */     public native opencv_legacy.CvBGPixelCStatTable ctable();
/*      */ 
/*      */     public native CvBGPixelStat ctable(opencv_legacy.CvBGPixelCStatTable paramCvBGPixelCStatTable);
/*      */ 
/*      */     public native opencv_legacy.CvBGPixelCCStatTable cctable();
/*      */ 
/*      */     public native CvBGPixelStat cctable(opencv_legacy.CvBGPixelCCStatTable paramCvBGPixelCCStatTable);
/*      */ 
/*      */     public native byte is_trained_st_model();
/*      */ 
/*      */     public native CvBGPixelStat is_trained_st_model(byte paramByte);
/*      */ 
/*      */     public native byte is_trained_dyn_model();
/*      */ 
/*      */     public native CvBGPixelStat is_trained_dyn_model(byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/* 2648 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGPixelCCStatTable extends Pointer
/*      */   {
/*      */     public CvBGPixelCCStatTable()
/*      */     {
/* 2632 */       allocate(); } 
/* 2633 */     public CvBGPixelCCStatTable(int size) { allocateArray(size); } 
/* 2634 */     public CvBGPixelCCStatTable(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2639 */     public CvBGPixelCCStatTable position(int position) { return (CvBGPixelCCStatTable)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float Pv();
/*      */ 
/*      */     public native CvBGPixelCCStatTable Pv(float paramFloat);
/*      */ 
/*      */     public native float Pvb();
/*      */ 
/*      */     public native CvBGPixelCCStatTable Pvb(float paramFloat);
/*      */ 
/*      */     public native byte v(int paramInt);
/*      */ 
/*      */     public native CvBGPixelCCStatTable v(int paramInt, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/* 2631 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGPixelCStatTable extends Pointer
/*      */   {
/*      */     public CvBGPixelCStatTable()
/*      */     {
/* 2615 */       allocate(); } 
/* 2616 */     public CvBGPixelCStatTable(int size) { allocateArray(size); } 
/* 2617 */     public CvBGPixelCStatTable(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2622 */     public CvBGPixelCStatTable position(int position) { return (CvBGPixelCStatTable)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float Pv();
/*      */ 
/*      */     public native CvBGPixelCStatTable Pv(float paramFloat);
/*      */ 
/*      */     public native float Pvb();
/*      */ 
/*      */     public native CvBGPixelCStatTable Pvb(float paramFloat);
/*      */ 
/*      */     public native byte v(int paramInt);
/*      */ 
/*      */     public native CvBGPixelCStatTable v(int paramInt, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/* 2614 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFGDStatModelParams extends Pointer
/*      */   {
/*      */     public CvFGDStatModelParams()
/*      */     {
/* 2583 */       allocate(); } 
/* 2584 */     public CvFGDStatModelParams(int size) { allocateArray(size); } 
/* 2585 */     public CvFGDStatModelParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2590 */     public CvFGDStatModelParams position(int position) { return (CvFGDStatModelParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int Lc();
/*      */ 
/*      */     public native CvFGDStatModelParams Lc(int paramInt);
/*      */ 
/*      */     public native int N1c();
/*      */ 
/*      */     public native CvFGDStatModelParams N1c(int paramInt);
/*      */ 
/*      */     public native int N2c();
/*      */ 
/*      */     public native CvFGDStatModelParams N2c(int paramInt);
/*      */ 
/*      */     public native int Lcc();
/*      */ 
/*      */     public native CvFGDStatModelParams Lcc(int paramInt);
/*      */ 
/*      */     public native int N1cc();
/*      */ 
/*      */     public native CvFGDStatModelParams N1cc(int paramInt);
/*      */ 
/*      */     public native int N2cc();
/*      */ 
/*      */     public native CvFGDStatModelParams N2cc(int paramInt);
/*      */ 
/*      */     public native int is_obj_without_holes();
/*      */ 
/*      */     public native CvFGDStatModelParams is_obj_without_holes(int paramInt);
/*      */ 
/*      */     public native int perform_morphing();
/*      */ 
/*      */     public native CvFGDStatModelParams perform_morphing(int paramInt);
/*      */ 
/*      */     public native float alpha1();
/*      */ 
/*      */     public native CvFGDStatModelParams alpha1(float paramFloat);
/*      */ 
/*      */     public native float alpha2();
/*      */ 
/*      */     public native CvFGDStatModelParams alpha2(float paramFloat);
/*      */ 
/*      */     public native float alpha3();
/*      */ 
/*      */     public native CvFGDStatModelParams alpha3(float paramFloat);
/*      */ 
/*      */     public native float delta();
/*      */ 
/*      */     public native CvFGDStatModelParams delta(float paramFloat);
/*      */ 
/*      */     public native float T();
/*      */ 
/*      */     public native CvFGDStatModelParams T(float paramFloat);
/*      */ 
/*      */     public native float minArea();
/*      */ 
/*      */     public native CvFGDStatModelParams minArea(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 2582 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBGStatModel extends Pointer
/*      */   {
/*      */     public CvBGStatModel()
/*      */     {
/* 2513 */       allocate(); zero(); } 
/* 2514 */     public CvBGStatModel(int size) { allocateArray(size); zero(); } 
/* 2515 */     public CvBGStatModel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2520 */     public CvBGStatModel position(int position) { return (CvBGStatModel)super.position(position); }
/*      */ 
/*      */     public static CvBGStatModel create(opencv_core.IplImage first_frame, opencv_legacy.CvFGDStatModelParams parameters)
/*      */     {
/* 2524 */       CvBGStatModel m = opencv_legacy.cvCreateFGDStatModel(first_frame, parameters);
/* 2525 */       if (m != null) {
/* 2526 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 2528 */       return m;
/*      */     }
/*      */     public static CvBGStatModel create(opencv_core.IplImage first_frame, opencv_legacy.CvGaussBGStatModelParams parameters) {
/* 2531 */       CvBGStatModel m = opencv_legacy.cvCreateGaussianBGModel(first_frame, parameters);
/* 2532 */       if (m != null) {
/* 2533 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 2535 */       return m;
/*      */     }
/*      */ 
/*      */     public void release2() {
/* 2539 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int type();
/*      */ 
/*      */     public native CvBGStatModel type(int paramInt);
/*      */ 
/*      */     public native opencv_legacy.CvReleaseBGStatModel release();
/*      */ 
/*      */     public native CvBGStatModel release(opencv_legacy.CvReleaseBGStatModel paramCvReleaseBGStatModel);
/*      */ 
/*      */     public native opencv_legacy.CvUpdateBGStatModel update();
/*      */ 
/*      */     public native CvBGStatModel update(opencv_legacy.CvUpdateBGStatModel paramCvUpdateBGStatModel);
/*      */ 
/*      */     public native opencv_core.IplImage background();
/*      */ 
/*      */     public native CvBGStatModel background(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native opencv_core.IplImage foreground();
/*      */ 
/*      */     public native CvBGStatModel foreground(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native opencv_core.IplImageArray layers();
/*      */ 
/*      */     public native CvBGStatModel layers(opencv_core.IplImageArray paramIplImageArray);
/*      */ 
/*      */     public native int layer_count();
/*      */ 
/*      */     public native CvBGStatModel layer_count(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvMemStorage storage();
/*      */ 
/*      */     public native CvBGStatModel storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native opencv_core.CvSeq foreground_regions();
/*      */ 
/*      */     public native CvBGStatModel foreground_regions(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     static
/*      */     {
/* 2512 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvBGStatModel
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvBGStatModel p)
/*      */       {
/* 2542 */         super(); } 
/* 2543 */       public void deallocate() { opencv_legacy.cvReleaseBGStatModel(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvUpdateBGStatModel extends FunctionPointer
/*      */   {
/*      */     public native int call(opencv_core.IplImage paramIplImage, opencv_legacy.CvBGStatModel paramCvBGStatModel, double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 2507 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvReleaseBGStatModel extends FunctionPointer
/*      */   {
/*      */     public native void call(@ByPtrPtr opencv_legacy.CvBGStatModel paramCvBGStatModel);
/*      */ 
/*      */     static
/*      */     {
/* 2503 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStereoGCState extends Pointer
/*      */   {
/*      */     public CvStereoGCState()
/*      */     {
/* 2436 */       allocate(); zero(); } 
/* 2437 */     public CvStereoGCState(int size) { allocateArray(size); zero(); } 
/* 2438 */     public CvStereoGCState(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2443 */     public CvStereoGCState position(int position) { return (CvStereoGCState)super.position(position); }
/*      */ 
/*      */     public static CvStereoGCState create(int numberOfDisparities, int maxIters)
/*      */     {
/* 2447 */       CvStereoGCState p = opencv_legacy.cvCreateStereoGCState(numberOfDisparities, maxIters);
/* 2448 */       if (p != null) {
/* 2449 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/* 2451 */       return p;
/*      */     }
/*      */     public void release() {
/* 2454 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int Ithreshold();
/*      */ 
/*      */     public native CvStereoGCState Ithreshold(int paramInt);
/*      */ 
/*      */     public native int interactionRadius();
/*      */ 
/*      */     public native CvStereoGCState interactionRadius(int paramInt);
/*      */ 
/*      */     public native float K();
/*      */ 
/*      */     public native CvStereoGCState K(float paramFloat);
/*      */ 
/*      */     public native float lambda();
/*      */ 
/*      */     public native CvStereoGCState lambda(float paramFloat);
/*      */ 
/*      */     public native float lambda1();
/*      */ 
/*      */     public native CvStereoGCState lambda1(float paramFloat);
/*      */ 
/*      */     public native float lambda2();
/*      */ 
/*      */     public native CvStereoGCState lambda2(float paramFloat);
/*      */ 
/*      */     public native int occlusionCost();
/*      */ 
/*      */     public native CvStereoGCState occlusionCost(int paramInt);
/*      */ 
/*      */     public native int minDisparity();
/*      */ 
/*      */     public native CvStereoGCState minDisparity(int paramInt);
/*      */ 
/*      */     public native int numberOfDisparities();
/*      */ 
/*      */     public native CvStereoGCState numberOfDisparities(int paramInt);
/*      */ 
/*      */     public native int maxIters();
/*      */ 
/*      */     public native CvStereoGCState maxIters(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvMat left();
/*      */ 
/*      */     public native CvStereoGCState left(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat right();
/*      */ 
/*      */     public native CvStereoGCState right(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat dispLeft();
/*      */ 
/*      */     public native CvStereoGCState dispLeft(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat dispRight();
/*      */ 
/*      */     public native CvStereoGCState dispRight(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat ptrLeft();
/*      */ 
/*      */     public native CvStereoGCState ptrLeft(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat ptrRight();
/*      */ 
/*      */     public native CvStereoGCState ptrRight(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat vtxBuf();
/*      */ 
/*      */     public native CvStereoGCState vtxBuf(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native opencv_core.CvMat edgeBuf();
/*      */ 
/*      */     public native CvStereoGCState edgeBuf(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     static
/*      */     {
/* 2435 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvStereoGCState
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvStereoGCState p)
/*      */       {
/* 2457 */         super(); } 
/* 2458 */       public void deallocate() { opencv_legacy.cvReleaseStereoGCState(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvLSHOperations extends Pointer
/*      */   {
/*      */     public CvLSHOperations()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvLSHOperations(Pointer p)
/*      */     {
/* 2417 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2415 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvLSH extends Pointer
/*      */   {
/*      */     public CvLSH()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvLSH(Pointer p)
/*      */     {
/* 2411 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2409 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class PlanarObjectDetector extends Pointer
/*      */   {
/*      */     public PlanarObjectDetector()
/*      */     {
/* 2308 */       allocate(); } 
/* 2309 */     public PlanarObjectDetector(Pointer p) { super(); } 
/* 2310 */     public PlanarObjectDetector(opencv_core.CvFileStorage fs, opencv_core.CvFileNode node) { allocate(fs, node); }
/*      */ 
/*      */ 
/*      */     public PlanarObjectDetector(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray pyr, int _npoints, int _patchSize, int _nstructs, int _structSize, int _nviews, @ByRef opencv_legacy.LDetector detector, @ByRef opencv_legacy.PatchGenerator patchGenerator)
/*      */     {
/* 2318 */       allocate(pyr, _npoints, _patchSize, _nstructs, _structSize, _nviews, detector, patchGenerator);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     private native void allocate(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     public native void train(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     public native void train(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @ByRef opencv_legacy.LDetector paramLDetector, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     @StdVector
/*      */     public native opencv_features2d.KeyPoint getModelPoints();
/*      */ 
/*      */     public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native boolean detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native boolean detect(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @StdVector("CvPoint2D32f,cv::Point2f") opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector IntPointer paramIntPointer);
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FernDescriptorMatcher extends opencv_features2d.GenericDescriptorMatcher
/*      */   {
/*      */     public FernDescriptorMatcher()
/*      */     {
/* 2279 */       allocate(); } 
/* 2280 */     public FernDescriptorMatcher(Pointer p) { super(); } 
/* 2281 */     public FernDescriptorMatcher(Params params) { allocate(params); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef Params paramParams);
/*      */ 
/*      */     static
/*      */     {
/* 2236 */       Loader.load();
/*      */     }
/* 2239 */     @NoOffset
/*      */     public static class Params extends Pointer { public Params() { allocate(); }
/*      */ 
/*      */ 
/*      */       public Params(int nclasses, int patchSize, int signatureSize, int nstructs, int structSize, int nviews, int compressionMethod, @ByRef opencv_legacy.PatchGenerator patchGenerator)
/*      */       {
/* 2247 */         allocate(nclasses, patchSize, signatureSize, nstructs, structSize, nviews, compressionMethod, patchGenerator);
/*      */       }
/*      */       public Params(String filename) {
/* 2250 */         allocate(filename); } 
/* 2251 */       public Params(int size) { allocateArray(size); } 
/* 2252 */       public Params(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */       private native void allocate(String paramString);
/*      */ 
/*      */       private native void allocateArray(int paramInt);
/*      */ 
/*      */       public Params position(int position)
/*      */       {
/* 2265 */         return (Params)super.position(position);
/*      */       }
/*      */ 
/*      */       public native int nclasses();
/*      */ 
/*      */       public native Params nclasses(int paramInt);
/*      */ 
/*      */       public native int patchSize();
/*      */ 
/*      */       public native Params patchSize(int paramInt);
/*      */ 
/*      */       public native int signatureSize();
/*      */ 
/*      */       public native Params signatureSize(int paramInt);
/*      */ 
/*      */       public native int nstructs();
/*      */ 
/*      */       public native Params nstructs(int paramInt);
/*      */ 
/*      */       public native int structSize();
/*      */ 
/*      */       public native Params structSize(int paramInt);
/*      */ 
/*      */       public native int nviews();
/*      */ 
/*      */       public native Params nviews(int paramInt);
/*      */ 
/*      */       public native int compressionMethod();
/*      */ 
/*      */       public native Params compressionMethod(int paramInt);
/*      */ 
/*      */       @ByRef
/*      */       public native opencv_legacy.PatchGenerator patchGenerator();
/*      */ 
/*      */       public native Params patchGenerator(opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */       @ByRef
/*      */       public native String filename();
/*      */ 
/*      */       public native Params filename(String paramString);
/*      */ 
/*      */       static
/*      */       {
/* 2238 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class OneWayDescriptorMatcher extends opencv_features2d.GenericDescriptorMatcher
/*      */   {
/*      */     public OneWayDescriptorMatcher()
/*      */     {
/* 2209 */       allocate(); } 
/* 2210 */     public OneWayDescriptorMatcher(Pointer p) { super(); } 
/* 2211 */     public OneWayDescriptorMatcher(Params params) { allocate(params); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@ByRef Params paramParams);
/*      */ 
/*      */     public native void initialize(@ByRef Params paramParams, @opencv_core.Ptr opencv_legacy.OneWayDescriptorBase paramOneWayDescriptorBase);
/*      */ 
/*      */     static
/*      */     {
/* 2170 */       Loader.load(); } 
/*      */     @NoOffset
/*      */     public static class Params extends Pointer { public static final int POSE_COUNT = 500;
/*      */       public static final int PATCH_WIDTH = 24;
/*      */       public static final int PATCH_HEIGHT = 24;
/*      */ 
/*      */       public static native float GET_MIN_SCALE();
/*      */ 
/*      */       public static native float GET_MAX_SCALE();
/*      */ 
/*      */       public static native float GET_STEP_SCALE();
/*      */ 
/* 2181 */       public Params() { allocate(); }
/*      */ 
/*      */       public Params(int poseCount, @ByVal opencv_core.CvSize patchSize, String pcaFilename, String trainPath, String trainImagesList, float minScale, float maxScale, float stepScale)
/*      */       {
/* 2185 */         allocate(poseCount, patchSize, pcaFilename, trainPath, trainImagesList, minScale, maxScale, stepScale);
/*      */       }
/* 2187 */       public Params(int size) { allocateArray(size); } 
/* 2188 */       public Params(Pointer p) { super(); } 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocate(int paramInt, @ByVal opencv_core.CvSize paramCvSize, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3);
/*      */ 
/*      */       private native void allocateArray(int paramInt);
/*      */ 
/*      */       public Params position(int position) {
/* 2196 */         return (Params)super.position(position);
/*      */       }
/*      */ 
/*      */       public native int poseCount();
/*      */ 
/*      */       public native Params poseCount(int paramInt);
/*      */ 
/*      */       @ByVal
/*      */       public native opencv_core.CvSize patchSize();
/*      */ 
/*      */       public native Params patchSize(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */       @ByRef
/*      */       public native String pcaFilename();
/*      */ 
/*      */       public native Params pcaFilename(String paramString);
/*      */ 
/*      */       @ByRef
/*      */       public native String trainPath();
/*      */ 
/*      */       public native Params trainPath(String paramString);
/*      */ 
/*      */       @ByRef
/*      */       public native String trainImagesList();
/*      */ 
/*      */       public native Params trainImagesList(String paramString);
/*      */ 
/*      */       public native float minScale();
/*      */ 
/*      */       public native Params minScale(float paramFloat);
/*      */ 
/*      */       public native float maxScale();
/*      */ 
/*      */       public native Params maxScale(float paramFloat);
/*      */ 
/*      */       public native float stepScale();
/*      */ 
/*      */       public native Params stepScale(float paramFloat);
/*      */ 
/*      */       static
/*      */       {
/* 2172 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"cv::CalonderDescriptorExtractor<float>"})
/*      */   public static class FloatCalonderDescriptorExtractor extends opencv_features2d.DescriptorExtractor
/*      */   {
/*      */     protected static final int BORDER_SIZE = 16;
/*      */ 
/*      */     public FloatCalonderDescriptorExtractor()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FloatCalonderDescriptorExtractor(Pointer p)
/*      */     {
/* 2149 */       super();
/*      */     }
/* 2151 */     public FloatCalonderDescriptorExtractor(String classifierFile) { allocate(classifierFile); }
/*      */ 
/*      */ 
/*      */     private native void allocate(String paramString);
/*      */ 
/*      */     static
/*      */     {
/* 2147 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class OneWayDescriptorObject extends opencv_legacy.OneWayDescriptorBase
/*      */   {
/*      */     public OneWayDescriptorObject()
/*      */     {
/*      */     }
/*      */ 
/*      */     public OneWayDescriptorObject(Pointer p)
/*      */     {
/* 2111 */       super();
/*      */     }
/*      */     public OneWayDescriptorObject(@ByVal opencv_core.CvSize patch_size, int pose_count, String train_path, String pca_config, String pca_hr_config, String pca_desc_config, int pyr_levels) {
/* 2114 */       allocate(patch_size, pose_count, train_path, pca_config, pca_hr_config, pca_desc_config, pyr_levels);
/*      */     }
/*      */ 
/*      */     public OneWayDescriptorObject(@ByVal opencv_core.CvSize patch_size, int pose_count, String pca_filename, String train_path, String images_list, float _scale_min, float _scale_max, float _scale_step, int pyr_levels)
/*      */     {
/* 2119 */       allocate(patch_size, pose_count, pca_filename, train_path, images_list, _scale_min, _scale_max, _scale_step, pyr_levels);
/*      */     }
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2);
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2);
/*      */ 
/*      */     public native void Allocate(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native void SetLabeledFeatures(@Const @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     @StdVector
/*      */     public native opencv_features2d.KeyPoint GetLabeledFeatures();
/*      */ 
/*      */     @StdVector
/*      */     public native opencv_features2d.KeyPoint _GetLabeledFeatures();
/*      */ 
/*      */     public native int IsDescriptorObject(int paramInt);
/*      */ 
/*      */     public native int MatchPointToPart(@ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native int GetDescriptorPart(int paramInt);
/*      */ 
/*      */     public native void InitializeObjectDescriptors(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, String paramString, int paramInt1, float paramFloat, int paramInt2);
/*      */ 
/*      */     public native int GetObjectFeatureCount();
/*      */ 
/*      */     static
/*      */     {
/* 2109 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class OneWayDescriptorBase extends Pointer
/*      */   {
/*      */     public OneWayDescriptorBase()
/*      */     {
/*      */     }
/*      */ 
/*      */     public OneWayDescriptorBase(Pointer p)
/*      */     {
/* 2008 */       super();
/*      */     }
/*      */ 
/*      */     public OneWayDescriptorBase(@ByVal opencv_core.CvSize patch_size, int pose_count, String train_path, String pca_config, String pca_hr_config, String pca_desc_config, int pyr_levels, int pca_dim_high, int pca_dim_low) {
/* 2012 */       allocate(patch_size, pose_count, train_path, pca_config, pca_hr_config, pca_desc_config, pyr_levels, pca_dim_high, pca_dim_low);
/*      */     }
/*      */ 
/*      */     public OneWayDescriptorBase(@ByVal opencv_core.CvSize patch_size, int pose_count, String pca_filename, String train_path, String images_list, float _scale_min, float _scale_max, float _scale_step, int pyr_levels, int pca_dim_high, int pca_dim_low)
/*      */     {
/* 2018 */       allocate(patch_size, pose_count, pca_filename, train_path, images_list, _scale_min, _scale_max, _scale_step, pyr_levels, pca_dim_high, pca_dim_low);
/*      */     }
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */     private native void allocate(@ByVal opencv_core.CvSize paramCvSize, int paramInt1, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native void Allocate(int paramInt);
/*      */ 
/*      */     public native void AllocatePCADescriptors();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize GetPatchSize();
/*      */ 
/*      */     public native int GetPoseCount();
/*      */ 
/*      */     public native int GetPyrLevels();
/*      */ 
/*      */     public native int GetDescriptorCount();
/*      */ 
/*      */     public native void CreateDescriptorsFromImage(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint);
/*      */ 
/*      */     public native void CreatePCADescriptors();
/*      */ 
/*      */     @Const
/*      */     public native opencv_legacy.OneWayDescriptor GetDescriptor(int paramInt);
/*      */ 
/*      */     public native void FindDescriptor(opencv_core.IplImage paramIplImage, @ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2, @ByRef float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
/*      */ 
/*      */     public native void FindDescriptor(opencv_core.IplImage paramIplImage, int paramInt, @Const @StdVector int[] paramArrayOfInt1, @Const @StdVector int[] paramArrayOfInt2, @Const @StdVector float[] paramArrayOfFloat1, @Const @StdVector float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
/*      */ 
/*      */     public native void FindDescriptor(opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @ByRef int[] paramArrayOfInt1, @ByRef int[] paramArrayOfInt2, @ByRef float[] paramArrayOfFloat);
/*      */ 
/*      */     public native void InitializePoses();
/*      */ 
/*      */     public native void InitializeTransformsFromPoses();
/*      */ 
/*      */     public native void InitializePoseTransforms();
/*      */ 
/*      */     public native void InitializeDescriptor(int paramInt, opencv_core.IplImage paramIplImage, String paramString);
/*      */ 
/*      */     public native void InitializeDescriptor(int paramInt, opencv_core.IplImage paramIplImage, @ByRef opencv_features2d.KeyPoint paramKeyPoint, String paramString);
/*      */ 
/*      */     public native void InitializeDescriptors(opencv_core.IplImage paramIplImage, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, String paramString, int paramInt);
/*      */ 
/*      */     public native void Write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void Read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native int LoadPCADescriptors(String paramString);
/*      */ 
/*      */     public native void LoadPCADescriptors(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void SavePCADescriptors(String paramString);
/*      */ 
/*      */     public native void SavePCADescriptors(opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void GeneratePCA(String paramString1, String paramString2, int paramInt);
/*      */ 
/*      */     public native void SetPCAHigh(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native void SetPCALow(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native int GetLowPCA(@ByPtrPtr opencv_core.CvMat paramCvMat1, @ByPtrPtr opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native int GetPCADimLow();
/*      */ 
/*      */     public native int GetPCADimHigh();
/*      */ 
/*      */     @ByRef
/*      */     public static native String GetPCAFilename();
/*      */ 
/*      */     public native boolean empty();
/*      */ 
/*      */     static
/*      */     {
/* 2006 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class OneWayDescriptor extends Pointer
/*      */   {
/*      */     public OneWayDescriptor()
/*      */     {
/* 1954 */       allocate(); } 
/* 1955 */     public OneWayDescriptor(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void Allocate(int paramInt1, @ByVal opencv_core.CvSize paramCvSize, int paramInt2);
/*      */ 
/*      */     public native void GenerateSamples(int paramInt1, opencv_core.IplImage paramIplImage, int paramInt2);
/*      */ 
/*      */     public native void GenerateSamplesFast(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, OneWayDescriptor paramOneWayDescriptor);
/*      */ 
/*      */     public native void SetTransforms(opencv_legacy.CvAffinePose paramCvAffinePose, opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     public native void Initialize(int paramInt1, opencv_core.IplImage paramIplImage, String paramString, int paramInt2);
/*      */ 
/*      */     public native void InitializeFast(int paramInt, opencv_core.IplImage paramIplImage, String paramString, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, OneWayDescriptor paramOneWayDescriptor);
/*      */ 
/*      */     public native void ProjectPCASample(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     public native void InitializePCACoeffs(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native void EstimatePose(opencv_core.IplImage paramIplImage, @ByRef int[] paramArrayOfInt, @ByRef float[] paramArrayOfFloat);
/*      */ 
/*      */     public native void EstimatePosePCA(opencv_core.CvArr paramCvArr, @ByRef int[] paramArrayOfInt, @ByRef float[] paramArrayOfFloat, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize GetPatchSize();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize GetInputPatchSize();
/*      */ 
/*      */     public native opencv_core.IplImage GetPatch(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_legacy.CvAffinePose GetPose(int paramInt);
/*      */ 
/*      */     public native void Save(String paramString);
/*      */ 
/*      */     public native int ReadByName(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode, String paramString);
/*      */ 
/*      */     public native void Write(opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     public native String GetFeatureName();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint GetCenter();
/*      */ 
/*      */     public native void SetPCADimHigh(int paramInt);
/*      */ 
/*      */     public native void SetPCADimLow(int paramInt);
/*      */ 
/*      */     public native int GetPCADimLow();
/*      */ 
/*      */     public native int GetPCADimHigh();
/*      */ 
/*      */     public native opencv_core.CvMatArray GetPCACoeffs();
/*      */ 
/*      */     static
/*      */     {
/* 1953 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class CvAffinePose extends Pointer
/*      */   {
/*      */     public CvAffinePose()
/*      */     {
/* 1936 */       allocate(); } 
/* 1937 */     public CvAffinePose(int size) { allocateArray(size); } 
/* 1938 */     public CvAffinePose(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1943 */     public CvAffinePose position(int position) { return (CvAffinePose)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float phi();
/*      */ 
/*      */     public native CvAffinePose phi(float paramFloat);
/*      */ 
/*      */     public native float theta();
/*      */ 
/*      */     public native CvAffinePose theta(float paramFloat);
/*      */ 
/*      */     public native float lambda1();
/*      */ 
/*      */     public native CvAffinePose lambda1(float paramFloat);
/*      */ 
/*      */     public native float lambda2();
/*      */ 
/*      */     public native CvAffinePose lambda2(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 1935 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class RTreeClassifier extends Pointer
/*      */   {
/*      */     public static final int DEFAULT_TREES = 48;
/*      */     public static final int DEFAULT_NUM_QUANT_BITS = 4;
/*      */ 
/*      */     public RTreeClassifier()
/*      */     {
/* 1886 */       allocate(); } 
/* 1887 */     public RTreeClassifier(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Const @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, int paramInt1, int paramInt2, int paramInt3, @Cast({"size_t"}) long paramLong, int paramInt4);
/*      */ 
/*      */     public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Const @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator, int paramInt1, int paramInt2, int paramInt3, @Cast({"size_t"}) long paramLong, int paramInt4);
/*      */ 
/*      */     public native void getSignature(opencv_core.IplImage paramIplImage, @Cast({"uchar*"}) byte[] paramArrayOfByte);
/*      */ 
/*      */     public native void getSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
/*      */ 
/*      */     public native void getSparseSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat, float paramFloat);
/*      */ 
/*      */     public native void getFloatSignature(opencv_core.IplImage paramIplImage, float[] paramArrayOfFloat);
/*      */ 
/*      */     public static native int countNonZeroElements(float[] paramArrayOfFloat, int paramInt, double paramDouble);
/*      */ 
/*      */     public native int classes();
/*      */ 
/*      */     public native int original_num_classes();
/*      */ 
/*      */     public native void setQuantization(int paramInt);
/*      */ 
/*      */     public native void discardFloatPosteriors();
/*      */ 
/*      */     public native void read(String paramString);
/*      */ 
/*      */     public native void read(@ByRef @Cast({"std::istream*"}) Pointer paramPointer);
/*      */ 
/*      */     public native void write(String paramString);
/*      */ 
/*      */     public native void write(@ByRef @Cast({"std::ostream*"}) Pointer paramPointer);
/*      */ 
/*      */     public native void saveAllFloatPosteriors(String paramString);
/*      */ 
/*      */     public native void saveAllBytePosteriors(String paramString);
/*      */ 
/*      */     public native void setFloatPosteriorsFromTextfile_176(String paramString);
/*      */ 
/*      */     public native float countZeroElements();
/*      */ 
/*      */     @NoOffset
/*      */     @Const
/*      */     @StdVector
/*      */     public native opencv_legacy.RandomizedTree trees_();
/*      */ 
/*      */     public native RTreeClassifier trees_(opencv_legacy.RandomizedTree paramRandomizedTree);
/*      */ 
/*      */     static
/*      */     {
/* 1881 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class RTreeNode extends Pointer
/*      */   {
/*      */     public RTreeNode()
/*      */     {
/* 1869 */       allocate(); } 
/* 1870 */     public RTreeNode(byte x1, byte y1, byte x2, byte y2) { allocate(x1, y1, x2, y2); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
/*      */ 
/*      */     public native short offset1();
/*      */ 
/*      */     public native RTreeNode offset1(short paramShort);
/*      */ 
/*      */     public native short offset2();
/*      */ 
/*      */     public native RTreeNode offset2(short paramShort);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native boolean compare(@Cast({"uchar*"}) BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 1868 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class RandomizedTree extends Pointer
/*      */   {
/*      */     public static final byte PATCH_SIZE = 32;
/*      */     public static final int DEFAULT_DEPTH = 9;
/*      */     public static final int DEFAULT_VIEWS = 5000;
/*      */     public static final int DEFAULT_REDUCED_NUM_DIM = 176;
/*      */ 
/*      */     public static native float GET_LOWER_QUANT_PERC();
/*      */ 
/*      */     public static native float GET_UPPER_QUANT_PERC();
/*      */ 
/*      */     public RandomizedTree()
/*      */     {
/* 1829 */       allocate(); } 
/* 1830 */     public RandomizedTree(int size) { allocateArray(size); } 
/* 1831 */     public RandomizedTree(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1836 */     public RandomizedTree position(int position) { return (RandomizedTree)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Const @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
/*      */ 
/*      */     public native void train(@Const @StdVector opencv_legacy.BaseKeypoint paramBaseKeypoint, @Const @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator, int paramInt1, int paramInt2, @Cast({"size_t"}) long paramLong, int paramInt3);
/*      */ 
/*      */     public static native void quantizeVector(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3);
/*      */ 
/*      */     public static native void quantizeVector(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, @Cast({"uchar*"}) BytePointer paramBytePointer);
/*      */ 
/*      */     public native FloatPointer getPosterior(@Cast({"uchar*"}) BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer getPosterior2(@Cast({"uchar*"}) BytePointer paramBytePointer);
/*      */ 
/*      */     public native void read(String paramString, int paramInt);
/*      */ 
/*      */     public native void read(@ByRef @Cast({"std::istream*"}) Pointer paramPointer, int paramInt);
/*      */ 
/*      */     public native void write(String paramString);
/*      */ 
/*      */     public native void write(@ByRef @Cast({"std::ostream*"}) Pointer paramPointer);
/*      */ 
/*      */     public native int classes();
/*      */ 
/*      */     public native int depth();
/*      */ 
/*      */     public native void discardFloatPosteriors();
/*      */ 
/*      */     public native void applyQuantization(int paramInt);
/*      */ 
/*      */     public native void savePosteriors(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void savePosteriors2(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     static
/*      */     {
/* 1820 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class BaseKeypoint extends Pointer
/*      */   {
/*      */     public BaseKeypoint()
/*      */     {
/* 1802 */       allocate(); } 
/* 1803 */     public BaseKeypoint(int x, int y, opencv_core.IplImage image) { allocate(x, y, image); } 
/* 1804 */     public BaseKeypoint(int size) { allocateArray(size); } 
/* 1805 */     public BaseKeypoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1811 */     public BaseKeypoint position(int position) { return (BaseKeypoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int x();
/*      */ 
/*      */     public native BaseKeypoint x(int paramInt);
/*      */ 
/*      */     public native int y();
/*      */ 
/*      */     public native BaseKeypoint y(int paramInt);
/*      */ 
/*      */     public native opencv_core.IplImage image();
/*      */ 
/*      */     public native BaseKeypoint image(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     static
/*      */     {
/* 1801 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class FernClassifier extends Pointer
/*      */   {
/*      */     public static final int PATCH_SIZE = 31;
/*      */     public static final int DEFAULT_STRUCTS = 50;
/*      */     public static final int DEFAULT_STRUCT_SIZE = 9;
/*      */     public static final int DEFAULT_VIEWS = 5000;
/*      */     public static final int DEFAULT_SIGNATURE_SIZE = 176;
/*      */     public static final int COMPRESSION_NONE = 0;
/*      */     public static final int COMPRESSION_RANDOM_PROJ = 1;
/*      */     public static final int COMPRESSION_PCA = 2;
/*      */     public static final int DEFAULT_COMPRESSION_METHOD = 0;
/*      */ 
/*      */     public FernClassifier()
/*      */     {
/* 1700 */       allocate(); } 
/* 1701 */     public FernClassifier(Pointer p) { super(); } 
/* 1702 */     public FernClassifier(opencv_core.CvFileStorage fs, opencv_core.CvFileNode node) { allocate(fs, node); }
/*      */ 
/*      */ 
/*      */     public FernClassifier(@ByRef opencv_core.Point2fVectorVector points, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray refimgs, @ByRef opencv_core.IntVectorVector labels, int _nclasses, int _patchSize, int _signatureSize, int _nstructs, int _structSize, int _nviews, int _compressionMethod, @ByRef opencv_legacy.PatchGenerator patchGenerator)
/*      */     {
/* 1713 */       allocate(points, refimgs, labels, _nclasses, _patchSize, _signatureSize, _nstructs, _structSize, _nviews, _compressionMethod, patchGenerator);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     private native void allocate(@ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @ByRef opencv_core.IntVectorVector paramIntVectorVector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     public native void trainFromSingleView(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @Const @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     public native void train(@ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @ByRef opencv_core.IntVectorVector paramIntVectorVector, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native int classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native int classify(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native void clear();
/*      */ 
/*      */     public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native int getClassCount();
/*      */ 
/*      */     public native int getStructCount();
/*      */ 
/*      */     public native int getStructSize();
/*      */ 
/*      */     public native int getSignatureSize();
/*      */ 
/*      */     public native int getCompressionMethod();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize getPatchSize();
/*      */ 
/*      */     static
/*      */     {
/* 1699 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Feature extends Pointer
/*      */     {
/*      */       public byte x1;
/*      */       public byte y1;
/*      */       public byte x2;
/*      */       public byte y2;
/*      */ 
/*      */       public Feature()
/*      */       {
/* 1759 */         allocate();
/*      */       }
/* 1761 */       public Feature(int _x1, int _y1, int _x2, int _y2) { allocate(_x1, _y1, _x2, _y2); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */       static
/*      */       {
/* 1757 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class LDetector extends Pointer
/*      */   {
/*      */     public LDetector()
/*      */     {
/* 1665 */       allocate(); } 
/* 1666 */     public LDetector(Pointer p) { super(); }
/*      */ 
/*      */     public LDetector(int _radius, int _threshold, int _nOctaves, int _nViews, double _baseFeatureSize, double _clusteringDistance) {
/* 1669 */       allocate(_radius, _threshold, _nOctaves, _nViews, _baseFeatureSize, _clusteringDistance);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void detect(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void detect(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void getMostStable2D(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @StdVector opencv_features2d.KeyPoint paramKeyPoint, int paramInt, @ByRef opencv_legacy.PatchGenerator paramPatchGenerator);
/*      */ 
/*      */     public native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage, String paramString);
/*      */ 
/*      */     public native int radius();
/*      */ 
/*      */     public native LDetector radius(int paramInt);
/*      */ 
/*      */     public native int threshold();
/*      */ 
/*      */     public native LDetector threshold(int paramInt);
/*      */ 
/*      */     public native int nOctaves();
/*      */ 
/*      */     public native LDetector nOctaves(int paramInt);
/*      */ 
/*      */     public native int nViews();
/*      */ 
/*      */     public native LDetector nViews(int paramInt);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean verbose();
/*      */ 
/*      */     public native LDetector verbose(boolean paramBoolean);
/*      */ 
/*      */     public native double baseFeatureSize();
/*      */ 
/*      */     public native LDetector baseFeatureSize(double paramDouble);
/*      */ 
/*      */     public native double clusteringDistance();
/*      */ 
/*      */     public native LDetector clusteringDistance(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1664 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class PatchGenerator extends Pointer
/*      */   {
/*      */     public PatchGenerator()
/*      */     {
/* 1627 */       allocate(); } 
/* 1628 */     public PatchGenerator(Pointer p) { super(); }
/*      */ 
/*      */     public PatchGenerator(double _backgroundMin, double _backgroundMax, double _noiseRange, boolean _randomBlur, double _lambdaMin, double _lambdaMax, double _thetaMin, double _thetaMax, double _phiMin, double _phiMax)
/*      */     {
/* 1632 */       allocate(_backgroundMin, _backgroundMax, _noiseRange, _randomBlur, _lambdaMin, _lambdaMax, _thetaMin, _thetaMax, _phiMin, _phiMax);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(double paramDouble1, double paramDouble2, double paramDouble3, @Cast({"bool"}) boolean paramBoolean, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void generate(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void generate(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, opencv_core.CvMat paramCvMat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
/*      */ 
/*      */     public native void warpWholeImage(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @opencv_core.InputMat opencv_core.CvArr paramCvArr3, int paramInt, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG);
/*      */ 
/*      */     public native void generateRandomTransform(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f1, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f2, @opencv_core.InputMat opencv_core.CvMat paramCvMat, @Adapter("RNGAdapter") opencv_core.CvRNG paramCvRNG, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void setAffineParam(double paramDouble1, double paramDouble2, double paramDouble3);
/*      */ 
/*      */     public native double backgroundMin();
/*      */ 
/*      */     public native PatchGenerator backgroundMin(double paramDouble);
/*      */ 
/*      */     public native double backgroundMax();
/*      */ 
/*      */     public native PatchGenerator backgroundMax(double paramDouble);
/*      */ 
/*      */     public native double noiseRange();
/*      */ 
/*      */     public native PatchGenerator noiseRange(double paramDouble);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean randomBlur();
/*      */ 
/*      */     public native PatchGenerator randomBlur(boolean paramBoolean);
/*      */ 
/*      */     public native double lambdaMin();
/*      */ 
/*      */     public native PatchGenerator lambdaMin(double paramDouble);
/*      */ 
/*      */     public native double lambdaMax();
/*      */ 
/*      */     public native PatchGenerator lambdaMax(double paramDouble);
/*      */ 
/*      */     public native double thetaMin();
/*      */ 
/*      */     public native PatchGenerator thetaMin(double paramDouble);
/*      */ 
/*      */     public native double thetaMax();
/*      */ 
/*      */     public native PatchGenerator thetaMax(double paramDouble);
/*      */ 
/*      */     public native double phiMin();
/*      */ 
/*      */     public native PatchGenerator phiMin(double paramDouble);
/*      */ 
/*      */     public native double phiMax();
/*      */ 
/*      */     public native PatchGenerator phiMax(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 1626 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvEM extends opencv_ml.CvStatModel
/*      */   {
/*      */     public static final int COV_MAT_SPHERICAL = 0;
/*      */     public static final int COV_MAT_DIAGONAL = 1;
/*      */     public static final int COV_MAT_GENERIC = 2;
/*      */     public static final int START_E_STEP = 1;
/*      */     public static final int START_M_STEP = 2;
/*      */     public static final int START_AUTO_STEP = 0;
/*      */ 
/*      */     public CvEM()
/*      */     {
/* 1575 */       allocate();
/*      */     }
/*      */     public CvEM(opencv_core.CvMat samples, opencv_core.CvMat sampleIdx, opencv_legacy.CvEMParams params, opencv_core.CvMat labels) {
/* 1578 */       allocate(samples, sampleIdx, params, labels);
/*      */     }
/* 1580 */     public CvEM(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_legacy.CvEMParams paramCvEMParams, opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     public native boolean train(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_legacy.CvEMParams paramCvEMParams, opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     public native float predict(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native double calcLikelihood(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native int get_nclusters();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_means();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMatArray get_covs();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_weights();
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat get_probs();
/*      */ 
/*      */     public native double get_log_likelihood();
/*      */ 
/*      */     static
/*      */     {
/* 1574 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   public static class CvEMParams extends Pointer
/*      */   {
/*      */     public CvEMParams()
/*      */     {
/* 1544 */       allocate();
/*      */     }
/*      */ 
/*      */     public CvEMParams(int nclusters, int cov_mat_type, int start_step, @ByVal opencv_core.CvTermCriteria term_crit, opencv_core.CvMat probs, opencv_core.CvMat weights, opencv_core.CvMat means, @Const opencv_core.CvMatArray covs) {
/* 1548 */       allocate(nclusters, cov_mat_type, start_step, term_crit, probs, weights, means, covs);
/*      */     }
/* 1550 */     public CvEMParams(int size) { allocateArray(size); } 
/* 1551 */     public CvEMParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @Const opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public CvEMParams position(int position) {
/* 1559 */       return (CvEMParams)super.position(position);
/*      */     }
/*      */ 
/*      */     public native int nclusters();
/*      */ 
/*      */     public native CvEMParams nclusters(int paramInt);
/*      */ 
/*      */     public native int cov_mat_type();
/*      */ 
/*      */     public native CvEMParams cov_mat_type(int paramInt);
/*      */ 
/*      */     public native int start_step();
/*      */ 
/*      */     public native CvEMParams start_step(int paramInt);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat probs();
/*      */ 
/*      */     public native CvEMParams probs(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat weights();
/*      */ 
/*      */     public native CvEMParams weights(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMat means();
/*      */ 
/*      */     public native CvEMParams means(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     public native opencv_core.CvMatArray covs();
/*      */ 
/*      */     public native CvEMParams covs(opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvTermCriteria term_crit();
/*      */ 
/*      */     public native CvEMParams term_crit(opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */     static
/*      */     {
/* 1543 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCamShiftTracker extends Pointer
/*      */   {
/*      */     public CvCamShiftTracker()
/*      */     {
/* 1492 */       allocate(); } 
/* 1493 */     public CvCamShiftTracker(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native float get_orientation();
/*      */ 
/*      */     public native float get_length();
/*      */ 
/*      */     public native float get_width();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f get_center();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect get_window();
/*      */ 
/*      */     public native int get_threshold();
/*      */ 
/*      */     public native int get_hist_dims(int[] paramArrayOfInt);
/*      */ 
/*      */     public native int get_min_ch_val(int paramInt);
/*      */ 
/*      */     public native int get_max_ch_val(int paramInt);
/*      */ 
/*      */     public native boolean set_window(@ByVal opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native boolean set_threshold(int paramInt);
/*      */ 
/*      */     public native boolean set_hist_bin_range(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     public native boolean set_hist_dims(int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */     public native boolean set_min_ch_val(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native boolean set_max_ch_val(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native boolean track_object(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native boolean update_histogram(opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     public native void reset_histogram();
/*      */ 
/*      */     public native opencv_core.IplImage get_back_project();
/*      */ 
/*      */     public native float query(int[] paramArrayOfInt);
/*      */ 
/*      */     static
/*      */     {
/* 1491 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCalibFilter extends Pointer
/*      */   {
/*      */     public CvCalibFilter()
/*      */     {
/* 1425 */       allocate(); } 
/* 1426 */     public CvCalibFilter(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean SetEtalon(@Cast({"CvCalibEtalonType"}) int paramInt1, double[] paramArrayOfDouble, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @Cast({"CvCalibEtalonType"})
/*      */     public native int GetEtalon(int[] paramArrayOfInt1, @Cast({"const double**"}) PointerPointer paramPointerPointer1, int[] paramArrayOfInt2, @Cast({"const CvPoint2D32f**"}) PointerPointer paramPointerPointer2);
/*      */ 
/*      */     public native void SetCameraCount(int paramInt);
/*      */ 
/*      */     public native int GetCameraCount();
/*      */ 
/*      */     public native boolean SetFrames(int paramInt);
/*      */ 
/*      */     public native void Stop(boolean paramBoolean);
/*      */ 
/*      */     public native boolean IsCalibrated();
/*      */ 
/*      */     public native boolean FindEtalon(opencv_core.IplImageArray paramIplImageArray);
/*      */ 
/*      */     public native boolean FindEtalon(opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     public native boolean Push(@Cast({"const CvPoint2D32f**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native int GetFrameCount(int[] paramArrayOfInt);
/*      */ 
/*      */     @Const
/*      */     public native opencv_legacy.CvCamera GetCameraParams(int paramInt);
/*      */ 
/*      */     @Const
/*      */     public native opencv_legacy.CvStereoCamera GetStereoParams();
/*      */ 
/*      */     public native boolean SetCameraParams(opencv_legacy.CvCamera paramCvCamera);
/*      */ 
/*      */     public native boolean SaveCameraParams(String paramString);
/*      */ 
/*      */     public native boolean LoadCameraParams(String paramString);
/*      */ 
/*      */     public native boolean Undistort(opencv_core.IplImageArray paramIplImageArray1, opencv_core.IplImageArray paramIplImageArray2);
/*      */ 
/*      */     public native boolean Undistort(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2);
/*      */ 
/*      */     public native boolean GetLatestPoints(int paramInt, @Cast({"CvPoint2D32f**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
/*      */ 
/*      */     public native void DrawPoints(opencv_core.IplImageArray paramIplImageArray);
/*      */ 
/*      */     public native void DrawPoints(opencv_core.CvMatArray paramCvMatArray);
/*      */ 
/*      */     public native boolean Rectify(opencv_core.IplImageArray paramIplImageArray1, opencv_core.IplImageArray paramIplImageArray2);
/*      */ 
/*      */     public native boolean Rectify(opencv_core.CvMatArray paramCvMatArray1, opencv_core.CvMatArray paramCvMatArray2);
/*      */ 
/*      */     static
/*      */     {
/* 1424 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvConDensation extends Pointer
/*      */   {
/*      */     public CvConDensation()
/*      */     {
/* 1360 */       allocate(); zero(); } 
/* 1361 */     public CvConDensation(int size) { allocateArray(size); zero(); } 
/* 1362 */     public CvConDensation(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1367 */     public CvConDensation position(int position) { return (CvConDensation)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvConDensation create(int dynam_params, int measure_params, int sample_count)
/*      */     {
/* 1372 */       CvConDensation c = opencv_legacy.cvCreateConDensation(dynam_params, measure_params, sample_count);
/* 1373 */       if (c != null) {
/* 1374 */         c.deallocator(new ReleaseDeallocator(c));
/*      */       }
/* 1376 */       return c;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 1380 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int MP();
/*      */ 
/*      */     public native CvConDensation MP(int paramInt);
/*      */ 
/*      */     public native int DP();
/*      */ 
/*      */     public native CvConDensation DP(int paramInt);
/*      */ 
/*      */     public native FloatPointer DynamMatr();
/*      */ 
/*      */     public native CvConDensation DynamMatr(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer State();
/*      */ 
/*      */     public native CvConDensation State(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native int SamplesNum();
/*      */ 
/*      */     public native CvConDensation SamplesNum(int paramInt);
/*      */ 
/*      */     @Cast({"float**"})
/*      */     public native PointerPointer flSamples();
/*      */ 
/*      */     public native CvConDensation flSamples(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Cast({"float**"})
/*      */     public native PointerPointer flNewSamples();
/*      */ 
/*      */     public native CvConDensation flNewSamples(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native FloatPointer flConfidence();
/*      */ 
/*      */     public native CvConDensation flConfidence(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer flCumulative();
/*      */ 
/*      */     public native CvConDensation flCumulative(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer Temp();
/*      */ 
/*      */     public native CvConDensation Temp(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer RandomSample();
/*      */ 
/*      */     public native CvConDensation RandomSample(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native opencv_legacy.CvRandState RandS();
/*      */ 
/*      */     public native CvConDensation RandS(opencv_legacy.CvRandState paramCvRandState);
/*      */ 
/*      */     static
/*      */     {
/* 1359 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvConDensation
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvConDensation p)
/*      */       {
/* 1383 */         super(); } 
/* 1384 */       public void deallocate() { opencv_legacy.cvReleaseConDensation(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvRandState extends Pointer
/*      */   {
/*      */     public CvRandState()
/*      */     {
/* 1342 */       allocate(); } 
/* 1343 */     public CvRandState(int size) { allocateArray(size); } 
/* 1344 */     public CvRandState(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1349 */     public CvRandState position(int position) { return (CvRandState)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native long state();
/*      */ 
/*      */     public native CvRandState state(long paramLong);
/*      */ 
/*      */     public native int disttype();
/*      */ 
/*      */     public native CvRandState disttype(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvScalar param(int paramInt);
/*      */ 
/*      */     public native CvRandState param(int paramInt, opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     static
/*      */     {
/* 1341 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvLCMNode extends opencv_core.CvGraphVtx
/*      */   {
/*      */     public CvLCMNode()
/*      */     {
/* 1289 */       allocate(); } 
/* 1290 */     public CvLCMNode(int size) { allocateArray(size); } 
/* 1291 */     public CvLCMNode(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1296 */     public CvLCMNode position(int position) { return (CvLCMNode)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvContour contour();
/*      */ 
/*      */     public native CvLCMNode contour(opencv_core.CvContour paramCvContour);
/*      */ 
/*      */     static
/*      */     {
/* 1288 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvLCMEdge extends opencv_core.CvGraphEdge
/*      */   {
/*      */     public CvLCMEdge()
/*      */     {
/* 1271 */       allocate(); } 
/* 1272 */     public CvLCMEdge(int size) { allocateArray(size); } 
/* 1273 */     public CvLCMEdge(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1278 */     public CvLCMEdge position(int position) { return (CvLCMEdge)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvSeq chain();
/*      */ 
/*      */     public native CvLCMEdge chain(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     public native float width();
/*      */ 
/*      */     public native CvLCMEdge width(float paramFloat);
/*      */ 
/*      */     public native int index1();
/*      */ 
/*      */     public native CvLCMEdge index1(int paramInt);
/*      */ 
/*      */     public native int index2();
/*      */ 
/*      */     public native CvLCMEdge index2(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1270 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVoronoiDiagram2D extends opencv_core.CvGraph
/*      */   {
/*      */     public CvVoronoiDiagram2D()
/*      */     {
/* 1244 */       allocate(); } 
/* 1245 */     public CvVoronoiDiagram2D(int size) { allocateArray(size); } 
/* 1246 */     public CvVoronoiDiagram2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1251 */     public CvVoronoiDiagram2D position(int position) { return (CvVoronoiDiagram2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvSet sites();
/*      */ 
/*      */     public native CvVoronoiDiagram2D sites(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     static
/*      */     {
/* 1243 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVoronoiNode2D extends opencv_core.CvSetElem
/*      */   {
/*      */     public CvVoronoiNode2D()
/*      */     {
/* 1227 */       allocate(); } 
/* 1228 */     public CvVoronoiNode2D(int size) { allocateArray(size); } 
/* 1229 */     public CvVoronoiNode2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1234 */     public CvVoronoiNode2D position(int position) { return (CvVoronoiNode2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f pt();
/*      */ 
/*      */     public native CvVoronoiNode2D pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     public native float radius();
/*      */ 
/*      */     public native CvVoronoiNode2D radius(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 1226 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVoronoiEdge2D extends Pointer
/*      */   {
/*      */     public CvVoronoiEdge2D()
/*      */     {
/* 1210 */       allocate(); } 
/* 1211 */     public CvVoronoiEdge2D(int size) { allocateArray(size); } 
/* 1212 */     public CvVoronoiEdge2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1217 */     public CvVoronoiEdge2D position(int position) { return (CvVoronoiEdge2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_legacy.CvVoronoiNode2D node(int paramInt);
/*      */ 
/*      */     public native CvVoronoiEdge2D node(int paramInt, opencv_legacy.CvVoronoiNode2D paramCvVoronoiNode2D);
/*      */ 
/*      */     public native opencv_legacy.CvVoronoiSite2D site(int paramInt);
/*      */ 
/*      */     public native CvVoronoiEdge2D site(int paramInt, opencv_legacy.CvVoronoiSite2D paramCvVoronoiSite2D);
/*      */ 
/*      */     public native CvVoronoiEdge2D next(int paramInt);
/*      */ 
/*      */     public native CvVoronoiEdge2D next(int paramInt, CvVoronoiEdge2D paramCvVoronoiEdge2D);
/*      */ 
/*      */     static
/*      */     {
/* 1209 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvVoronoiSite2D extends Pointer
/*      */   {
/*      */     public CvVoronoiSite2D()
/*      */     {
/* 1192 */       allocate(); } 
/* 1193 */     public CvVoronoiSite2D(int size) { allocateArray(size); } 
/* 1194 */     public CvVoronoiSite2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1199 */     public CvVoronoiSite2D position(int position) { return (CvVoronoiSite2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_legacy.CvVoronoiNode2D node(int paramInt);
/*      */ 
/*      */     public native CvVoronoiSite2D node(int paramInt, opencv_legacy.CvVoronoiNode2D paramCvVoronoiNode2D);
/*      */ 
/*      */     public native opencv_legacy.CvVoronoiEdge2D edge(int paramInt);
/*      */ 
/*      */     public native CvVoronoiSite2D edge(int paramInt, opencv_legacy.CvVoronoiEdge2D paramCvVoronoiEdge2D);
/*      */ 
/*      */     public native CvVoronoiSite2D next(int paramInt);
/*      */ 
/*      */     public native CvVoronoiSite2D next(int paramInt, CvVoronoiSite2D paramCvVoronoiSite2D);
/*      */ 
/*      */     static
/*      */     {
/* 1191 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv3dTrackerCameraIntrinsics extends Pointer
/*      */   {
/*      */     public Cv3dTrackerCameraIntrinsics()
/*      */     {
/* 1128 */       allocate(); } 
/* 1129 */     public Cv3dTrackerCameraIntrinsics(int size) { allocateArray(size); } 
/* 1130 */     public Cv3dTrackerCameraIntrinsics(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1135 */     public Cv3dTrackerCameraIntrinsics position(int position) { return (Cv3dTrackerCameraIntrinsics)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f principal_point();
/*      */ 
/*      */     public native Cv3dTrackerCameraIntrinsics principal_point(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer focal_length();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer distortion();
/*      */ 
/*      */     static
/*      */     {
/* 1127 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv3dTrackerCameraInfo extends Pointer
/*      */   {
/*      */     public Cv3dTrackerCameraInfo()
/*      */     {
/* 1108 */       allocate(); } 
/* 1109 */     public Cv3dTrackerCameraInfo(int size) { allocateArray(size); } 
/* 1110 */     public Cv3dTrackerCameraInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1115 */     public Cv3dTrackerCameraInfo position(int position) { return (Cv3dTrackerCameraInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native boolean valid();
/*      */ 
/*      */     public native Cv3dTrackerCameraInfo valid(boolean paramBoolean);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"float(*)[4]"})
/*      */     public native FloatPointer mat();
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f principal_point();
/*      */ 
/*      */     public native Cv3dTrackerCameraInfo principal_point(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     static
/*      */     {
/* 1107 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv3dTrackerTrackedObject extends Pointer
/*      */   {
/*      */     public Cv3dTrackerTrackedObject()
/*      */     {
/* 1085 */       allocate(); } 
/* 1086 */     public Cv3dTrackerTrackedObject(int size) { allocateArray(size); } 
/* 1087 */     public Cv3dTrackerTrackedObject(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1092 */     public Cv3dTrackerTrackedObject position(int position) { return (Cv3dTrackerTrackedObject)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native Cv3dTrackerTrackedObject id(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint3D32f p();
/*      */ 
/*      */     public native Cv3dTrackerTrackedObject p(opencv_core.CvPoint3D32f paramCvPoint3D32f);
/*      */ 
/*      */     static
/*      */     {
/* 1084 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv3dTracker2dTrackedObject extends Pointer
/*      */   {
/*      */     public Cv3dTracker2dTrackedObject()
/*      */     {
/* 1062 */       allocate(); } 
/* 1063 */     public Cv3dTracker2dTrackedObject(int size) { allocateArray(size); } 
/* 1064 */     public Cv3dTracker2dTrackedObject(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1069 */     public Cv3dTracker2dTrackedObject position(int position) { return (Cv3dTracker2dTrackedObject)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native Cv3dTracker2dTrackedObject id(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f p();
/*      */ 
/*      */     public native Cv3dTracker2dTrackedObject p(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     static
/*      */     {
/* 1061 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFace extends Pointer
/*      */   {
/*      */     public CvFace()
/*      */     {
/* 1039 */       allocate(); } 
/* 1040 */     public CvFace(int size) { allocateArray(size); } 
/* 1041 */     public CvFace(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1046 */     public CvFace position(int position) { return (CvFace)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvRect MouthRect();
/*      */ 
/*      */     public native CvFace MouthRect(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvRect LeftEyeRect();
/*      */ 
/*      */     public native CvFace LeftEyeRect(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvRect RightEyeRect();
/*      */ 
/*      */     public native CvFace RightEyeRect(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     static
/*      */     {
/* 1038 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvFaceTracker extends Pointer
/*      */   {
/*      */     public CvFaceTracker()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFaceTracker(Pointer p)
/*      */     {
/* 1004 */       super();
/*      */     }
/*      */ 
/*      */     public static CvFaceTracker create(CvFaceTracker pFaceTracking, opencv_core.IplImage imgGray, opencv_core.CvRect pRects, int nRects) {
/* 1008 */       CvFaceTracker p = opencv_legacy.cvInitFaceTracker(new CvFaceTracker(), imgGray, pRects, nRects);
/* 1009 */       if (p != null) {
/* 1010 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/* 1012 */       return p;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 1016 */       deallocate();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 1002 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvFaceTracker
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvFaceTracker p)
/*      */       {
/* 1019 */         super(); } 
/* 1020 */       public void deallocate() { opencv_legacy.cvReleaseFaceTracker(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvGLCM extends Pointer
/*      */   {
/*      */     public CvGLCM()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvGLCM(Pointer p)
/*      */     {
/*  964 */       super();
/*      */     }
/*      */     public static CvGLCM create(opencv_core.IplImage srcImage, int stepMagnitude) {
/*  967 */       return create(srcImage, stepMagnitude, null, 0, -2);
/*      */     }
/*      */ 
/*      */     public static CvGLCM create(opencv_core.IplImage srcImage, int stepMagnitude, int[] stepDirections, int numStepDirections, int optimizationType)
/*      */     {
/*  972 */       CvGLCM p = opencv_legacy.cvCreateGLCM(srcImage, stepMagnitude, stepDirections, numStepDirections, optimizationType);
/*      */ 
/*  974 */       if (p != null) {
/*  975 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/*  977 */       return p;
/*      */     }
/*      */ 
/*      */     public void release() {
/*  981 */       deallocate();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  962 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvGLCM
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvGLCM p)
/*      */       {
/*  984 */         super(); } 
/*  985 */       public void deallocate() { opencv_legacy.cvReleaseGLCM(this, 0); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvContourTree extends opencv_core.CvSeq
/*      */   {
/*      */     public CvContourTree()
/*      */     {
/*  900 */       allocate(); zero(); } 
/*  901 */     public CvContourTree(int size) { allocateArray(size); zero(); } 
/*  902 */     public CvContourTree(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  907 */     public CvContourTree position(int position) { return (CvContourTree)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint p1();
/*      */ 
/*      */     public native CvContourTree p1(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint p2();
/*      */ 
/*      */     public native CvContourTree p2(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     static
/*      */     {
/*  899 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvContourOrientation extends Pointer
/*      */   {
/*      */     public CvContourOrientation()
/*      */     {
/*  725 */       allocate(); } 
/*  726 */     public CvContourOrientation(int size) { allocateArray(size); } 
/*  727 */     public CvContourOrientation(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  732 */     public CvContourOrientation position(int position) { return (CvContourOrientation)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float egvals(int paramInt);
/*      */ 
/*      */     public native CvContourOrientation egvals(int paramInt, float paramFloat);
/*      */ 
/*      */     public native float egvects(int paramInt);
/*      */ 
/*      */     public native CvContourOrientation egvects(int paramInt, float paramFloat);
/*      */ 
/*      */     public native float max();
/*      */ 
/*      */     public native CvContourOrientation max(float paramFloat);
/*      */ 
/*      */     public native float min();
/*      */ 
/*      */     public native CvContourOrientation min(float paramFloat);
/*      */ 
/*      */     public native int imax();
/*      */ 
/*      */     public native CvContourOrientation imax(int paramInt);
/*      */ 
/*      */     public native int imin();
/*      */ 
/*      */     public native CvContourOrientation imin(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  724 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStereoCamera extends Pointer
/*      */   {
/*      */     public CvStereoCamera()
/*      */     {
/*  691 */       allocate(); } 
/*  692 */     public CvStereoCamera(int size) { allocateArray(size); } 
/*  693 */     public CvStereoCamera(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  698 */     public CvStereoCamera position(int position) { return (CvStereoCamera)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_legacy.CvCamera camera(int paramInt);
/*      */ 
/*      */     public native CvStereoCamera camera(int paramInt, opencv_legacy.CvCamera paramCvCamera);
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer fundMatr();
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint3D32f epipole(int paramInt);
/*      */ 
/*      */     public native CvStereoCamera epipole(int paramInt, opencv_core.CvPoint3D32f paramCvPoint3D32f);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f quad(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native CvStereoCamera quad(int paramInt1, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     public native double coeffs(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     public native CvStereoCamera coeffs(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f border(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native CvStereoCamera border(int paramInt1, int paramInt2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvSize warpSize();
/*      */ 
/*      */     public native CvStereoCamera warpSize(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     public native opencv_legacy.CvStereoLineCoeff lineCoeffs();
/*      */ 
/*      */     public native CvStereoCamera lineCoeffs(opencv_legacy.CvStereoLineCoeff paramCvStereoLineCoeff);
/*      */ 
/*      */     public native int needSwapCameras();
/*      */ 
/*      */     public native CvStereoCamera needSwapCameras(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer rotMatrix();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer transVector();
/*      */ 
/*      */     static
/*      */     {
/*  690 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCamera extends Pointer
/*      */   {
/*      */     public CvCamera()
/*      */     {
/*  672 */       allocate(); } 
/*  673 */     public CvCamera(int size) { allocateArray(size); } 
/*  674 */     public CvCamera(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  679 */     public CvCamera position(int position) { return (CvCamera)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer imgSize();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer matrix();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer distortion();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer rotMatr();
/*      */ 
/*      */     @MemberGetter
/*      */     public native FloatPointer transVect();
/*      */ 
/*      */     static
/*      */     {
/*  671 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStereoLineCoeff extends Pointer
/*      */   {
/*      */     public CvStereoLineCoeff()
/*      */     {
/*  644 */       allocate(); } 
/*  645 */     public CvStereoLineCoeff(int size) { allocateArray(size); } 
/*  646 */     public CvStereoLineCoeff(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  651 */     public CvStereoLineCoeff position(int position) { return (CvStereoLineCoeff)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native double Xcoef();
/*      */ 
/*      */     public native CvStereoLineCoeff Xcoef(double paramDouble);
/*      */ 
/*      */     public native double XcoefA();
/*      */ 
/*      */     public native CvStereoLineCoeff XcoefA(double paramDouble);
/*      */ 
/*      */     public native double XcoefB();
/*      */ 
/*      */     public native CvStereoLineCoeff XcoefB(double paramDouble);
/*      */ 
/*      */     public native double XcoefAB();
/*      */ 
/*      */     public native CvStereoLineCoeff XcoefAB(double paramDouble);
/*      */ 
/*      */     public native double Ycoef();
/*      */ 
/*      */     public native CvStereoLineCoeff Ycoef(double paramDouble);
/*      */ 
/*      */     public native double YcoefA();
/*      */ 
/*      */     public native CvStereoLineCoeff YcoefA(double paramDouble);
/*      */ 
/*      */     public native double YcoefB();
/*      */ 
/*      */     public native CvStereoLineCoeff YcoefB(double paramDouble);
/*      */ 
/*      */     public native double YcoefAB();
/*      */ 
/*      */     public native CvStereoLineCoeff YcoefAB(double paramDouble);
/*      */ 
/*      */     public native double Zcoef();
/*      */ 
/*      */     public native CvStereoLineCoeff Zcoef(double paramDouble);
/*      */ 
/*      */     public native double ZcoefA();
/*      */ 
/*      */     public native CvStereoLineCoeff ZcoefA(double paramDouble);
/*      */ 
/*      */     public native double ZcoefB();
/*      */ 
/*      */     public native CvStereoLineCoeff ZcoefB(double paramDouble);
/*      */ 
/*      */     public native double ZcoefAB();
/*      */ 
/*      */     public native CvStereoLineCoeff ZcoefAB(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  643 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCliqueFinder extends Pointer
/*      */   {
/*      */     public CvCliqueFinder()
/*      */     {
/*  568 */       allocate(); } 
/*  569 */     public CvCliqueFinder(int size) { allocateArray(size); } 
/*  570 */     public CvCliqueFinder(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  575 */     public CvCliqueFinder position(int position) { return (CvCliqueFinder)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvGraph graph();
/*      */ 
/*      */     public native CvCliqueFinder graph(opencv_core.CvGraph paramCvGraph);
/*      */ 
/*      */     @Cast({"int**"})
/*      */     public native PointerPointer adj_matr();
/*      */ 
/*      */     public native CvCliqueFinder adj_matr(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native int N();
/*      */ 
/*      */     public native CvCliqueFinder N(int paramInt);
/*      */ 
/*      */     public native int k();
/*      */ 
/*      */     public native CvCliqueFinder k(int paramInt);
/*      */ 
/*      */     public native IntPointer current_comp();
/*      */ 
/*      */     public native CvCliqueFinder current_comp(IntPointer paramIntPointer);
/*      */ 
/*      */     @Cast({"int**"})
/*      */     public native PointerPointer All();
/*      */ 
/*      */     public native CvCliqueFinder All(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native IntPointer ne();
/*      */ 
/*      */     public native CvCliqueFinder ne(IntPointer paramIntPointer);
/*      */ 
/*      */     public native IntPointer ce();
/*      */ 
/*      */     public native CvCliqueFinder ce(IntPointer paramIntPointer);
/*      */ 
/*      */     public native IntPointer fixp();
/*      */ 
/*      */     public native CvCliqueFinder fixp(IntPointer paramIntPointer);
/*      */ 
/*      */     public native IntPointer nod();
/*      */ 
/*      */     public native CvCliqueFinder nod(IntPointer paramIntPointer);
/*      */ 
/*      */     public native IntPointer s();
/*      */ 
/*      */     public native CvCliqueFinder s(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int status();
/*      */ 
/*      */     public native CvCliqueFinder status(int paramInt);
/*      */ 
/*      */     public native int best_score();
/*      */ 
/*      */     public native CvCliqueFinder best_score(int paramInt);
/*      */ 
/*      */     public native int weighted();
/*      */ 
/*      */     public native CvCliqueFinder weighted(int paramInt);
/*      */ 
/*      */     public native int weighted_edges();
/*      */ 
/*      */     public native CvCliqueFinder weighted_edges(int paramInt);
/*      */ 
/*      */     public native float best_weight();
/*      */ 
/*      */     public native CvCliqueFinder best_weight(float paramFloat);
/*      */ 
/*      */     public native FloatPointer edge_weights();
/*      */ 
/*      */     public native CvCliqueFinder edge_weights(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer vertex_weights();
/*      */ 
/*      */     public native CvCliqueFinder vertex_weights(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer cur_weight();
/*      */ 
/*      */     public native CvCliqueFinder cur_weight(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer cand_weight();
/*      */ 
/*      */     public native CvCliqueFinder cand_weight(FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/*  567 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGraphWeightedEdge extends opencv_core.CvGraphEdge
/*      */   {
/*      */   }
/*      */ 
/*      */   public static class CvGraphWeightedVtx extends opencv_core.CvGraphVtx
/*      */   {
/*      */     public CvGraphWeightedVtx()
/*      */     {
/*  534 */       allocate(); } 
/*  535 */     public CvGraphWeightedVtx(int size) { allocateArray(size); } 
/*  536 */     public CvGraphWeightedVtx(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  541 */     public CvGraphWeightedVtx position(int position) { return (CvGraphWeightedVtx)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native float weight();
/*      */ 
/*      */     public native CvGraphWeightedVtx weight(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  533 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvEHMM extends Pointer
/*      */   {
/*      */     public CvEHMM()
/*      */     {
/*  420 */       allocate(); zero(); } 
/*  421 */     public CvEHMM(int size) { allocateArray(size); zero(); } 
/*  422 */     public CvEHMM(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  427 */     public CvEHMM position(int position) { return (CvEHMM)super.position(position); }
/*      */ 
/*      */     public static CvEHMM create(int[] stateNumber, int[] numMix, int obsSize)
/*      */     {
/*  431 */       CvEHMM p = opencv_legacy.cvCreate2DHMM(stateNumber, numMix, obsSize);
/*  432 */       if (p != null) {
/*  433 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/*  435 */       return p;
/*      */     }
/*      */ 
/*      */     public void release() {
/*  439 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int level();
/*      */ 
/*      */     public native CvEHMM level(int paramInt);
/*      */ 
/*      */     public native int num_states();
/*      */ 
/*      */     public native CvEHMM num_states(int paramInt);
/*      */ 
/*      */     public native FloatPointer transP();
/*      */ 
/*      */     public native CvEHMM transP(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Cast({"float**"})
/*      */     public native PointerPointer obsProb();
/*      */ 
/*      */     public native CvEHMM obsProb(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Name({"u.state"})
/*      */     public native opencv_legacy.CvEHMMState u_state();
/*      */ 
/*      */     public native CvEHMM u_state(opencv_legacy.CvEHMMState paramCvEHMMState);
/*      */ 
/*      */     @Name({"u.ehmm"})
/*      */     public native CvEHMM u_ehmm();
/*      */ 
/*      */     public native CvEHMM u_ehmm(CvEHMM paramCvEHMM);
/*      */ 
/*      */     static
/*      */     {
/*  419 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvEHMM
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvEHMM p)
/*      */       {
/*  442 */         super(); } 
/*  443 */       public void deallocate() { opencv_legacy.cvRelease2DHMM(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvEHMMState extends Pointer
/*      */   {
/*      */     public CvEHMMState()
/*      */     {
/*  401 */       allocate(); } 
/*  402 */     public CvEHMMState(int size) { allocateArray(size); } 
/*  403 */     public CvEHMMState(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  408 */     public CvEHMMState position(int position) { return (CvEHMMState)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int num_mix();
/*      */ 
/*      */     public native CvEHMMState num_mix(int paramInt);
/*      */ 
/*      */     public native FloatPointer mu();
/*      */ 
/*      */     public native CvEHMMState mu(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer inv_var();
/*      */ 
/*      */     public native CvEHMMState inv_var(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer log_var_val();
/*      */ 
/*      */     public native CvEHMMState log_var_val(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native FloatPointer weight();
/*      */ 
/*      */     public native CvEHMMState weight(FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/*  400 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class Cv1DObsInfo extends opencv_legacy.CvImgObsInfo
/*      */   {
/*      */     public Cv1DObsInfo()
/*      */     {
/*      */     }
/*      */ 
/*      */     public Cv1DObsInfo(Pointer p)
/*      */     {
/*  396 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  394 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvImgObsInfo extends Pointer
/*      */   {
/*      */     public CvImgObsInfo()
/*      */     {
/*  358 */       allocate(); zero(); } 
/*  359 */     public CvImgObsInfo(int size) { allocateArray(size); zero(); } 
/*  360 */     public CvImgObsInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  365 */     public CvImgObsInfo position(int position) { return (CvImgObsInfo)super.position(position); }
/*      */ 
/*      */     public static CvImgObsInfo create(opencv_core.CvSize numObs, int obsSize)
/*      */     {
/*  369 */       CvImgObsInfo p = opencv_legacy.cvCreateObsInfo(numObs, obsSize);
/*  370 */       if (p != null) {
/*  371 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/*  373 */       return p;
/*      */     }
/*      */ 
/*      */     public void release() {
/*  377 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int obs_x();
/*      */ 
/*      */     public native CvImgObsInfo obs_x(int paramInt);
/*      */ 
/*      */     public native int obs_y();
/*      */ 
/*      */     public native CvImgObsInfo obs_y(int paramInt);
/*      */ 
/*      */     public native int obs_size();
/*      */ 
/*      */     public native CvImgObsInfo obs_size(int paramInt);
/*      */ 
/*      */     public native FloatPointer obs();
/*      */ 
/*      */     public native CvImgObsInfo obs(FloatPointer paramFloatPointer);
/*      */ 
/*      */     public native IntPointer state();
/*      */ 
/*      */     public native CvImgObsInfo state(IntPointer paramIntPointer);
/*      */ 
/*      */     public native IntPointer mix();
/*      */ 
/*      */     public native CvImgObsInfo mix(IntPointer paramIntPointer);
/*      */ 
/*      */     static
/*      */     {
/*  357 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_legacy.CvImgObsInfo
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_legacy.CvImgObsInfo p)
/*      */       {
/*  380 */         super(); } 
/*  381 */       public void deallocate() { opencv_legacy.cvReleaseObsInfo(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCallback extends FunctionPointer
/*      */   {
/*      */     public CvCallback(Pointer p)
/*      */     {
/*  290 */       super(); } 
/*  291 */     protected CvCallback() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(int paramInt, Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */     static
/*      */     {
/*  289 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStarDetectorParams extends Pointer
/*      */   {
/*      */     public CvStarDetectorParams()
/*      */     {
/*  246 */       allocate(); } 
/*  247 */     public CvStarDetectorParams(int size) { allocateArray(size); } 
/*  248 */     public CvStarDetectorParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  253 */     public CvStarDetectorParams position(int position) { return (CvStarDetectorParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int maxSize();
/*      */ 
/*      */     public native CvStarDetectorParams maxSize(int paramInt);
/*      */ 
/*      */     public native int responseThreshold();
/*      */ 
/*      */     public native CvStarDetectorParams responseThreshold(int paramInt);
/*      */ 
/*      */     public native int lineThresholdProjected();
/*      */ 
/*      */     public native CvStarDetectorParams lineThresholdProjected(int paramInt);
/*      */ 
/*      */     public native int lineThresholdBinarized();
/*      */ 
/*      */     public native CvStarDetectorParams lineThresholdBinarized(int paramInt);
/*      */ 
/*      */     public native int suppressNonmaxSize();
/*      */ 
/*      */     public native CvStarDetectorParams suppressNonmaxSize(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  245 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStarKeypoint extends Pointer
/*      */   {
/*      */     public CvStarKeypoint()
/*      */     {
/*  222 */       allocate(); } 
/*  223 */     public CvStarKeypoint(int size) { allocateArray(size); } 
/*  224 */     public CvStarKeypoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  229 */     public CvStarKeypoint position(int position) { return (CvStarKeypoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint pt();
/*      */ 
/*      */     public native CvStarKeypoint pt(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native int size();
/*      */ 
/*      */     public native CvStarKeypoint size(int paramInt);
/*      */ 
/*      */     public native float response();
/*      */ 
/*      */     public native CvStarKeypoint response(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  221 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSURFParams extends Pointer
/*      */   {
/*      */     public CvSURFParams()
/*      */     {
/*  161 */       allocate(); } 
/*  162 */     public CvSURFParams(int size) { allocateArray(size); } 
/*  163 */     public CvSURFParams(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  168 */     public CvSURFParams position(int position) { return (CvSURFParams)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int extended();
/*      */ 
/*      */     public native CvSURFParams extended(int paramInt);
/*      */ 
/*      */     public native int upright();
/*      */ 
/*      */     public native CvSURFParams upright(int paramInt);
/*      */ 
/*      */     public native double hessianThreshold();
/*      */ 
/*      */     public native CvSURFParams hessianThreshold(double paramDouble);
/*      */ 
/*      */     public native int nOctaves();
/*      */ 
/*      */     public native CvSURFParams nOctaves(int paramInt);
/*      */ 
/*      */     public native int nOctaveLayers();
/*      */ 
/*      */     public native CvSURFParams nOctaveLayers(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  160 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSURFPoint extends Pointer
/*      */   {
/*      */     public CvSURFPoint()
/*      */     {
/*  129 */       allocate(); } 
/*  130 */     public CvSURFPoint(int size) { allocateArray(size); } 
/*  131 */     public CvSURFPoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  136 */     public CvSURFPoint position(int position) { return (CvSURFPoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f pt();
/*      */ 
/*      */     public native CvSURFPoint pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     public native int laplacian();
/*      */ 
/*      */     public native CvSURFPoint laplacian(int paramInt);
/*      */ 
/*      */     public native int size();
/*      */ 
/*      */     public native CvSURFPoint size(int paramInt);
/*      */ 
/*      */     public native float dir();
/*      */ 
/*      */     public native CvSURFPoint dir(float paramFloat);
/*      */ 
/*      */     public native float hessian();
/*      */ 
/*      */     public native CvSURFPoint hessian(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  128 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_legacy
 * JD-Core Version:    0.6.2
 */