/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.Pointer.Deallocator;
/*     */ import com.googlecode.javacpp.annotation.Adapter;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByPtrRef;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Opaque;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ 
/*     */ @Properties(inherit={opencv_highgui.class, opencv_flann.class, opencv_features2d.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/calib3d/calib3d.hpp>"}, link={"opencv_calib3d@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_calib3d248"})})
/*     */ public class opencv_calib3d
/*     */ {
/*     */   public static final int CV_FM_7POINT = 1;
/*     */   public static final int CV_FM_8POINT = 2;
/*     */   public static final int CV_LMEDS = 4;
/*     */   public static final int CV_RANSAC = 8;
/*     */   public static final int CV_FM_LMEDS_ONLY = 4;
/*     */   public static final int CV_FM_RANSAC_ONLY = 8;
/*     */   public static final int CV_FM_LMEDS = 4;
/*     */   public static final int CV_FM_RANSAC = 8;
/*     */   public static final int CV_ITERATIVE = 0;
/*     */   public static final int CV_EPNP = 1;
/*     */   public static final int CV_P3P = 2;
/*     */   public static final int CV_CALIB_CB_ADAPTIVE_THRESH = 1;
/*     */   public static final int CV_CALIB_CB_NORMALIZE_IMAGE = 2;
/*     */   public static final int CV_CALIB_CB_FILTER_QUADS = 4;
/*     */   public static final int CV_CALIB_CB_FAST_CHECK = 8;
/*     */   public static final int CV_CALIB_USE_INTRINSIC_GUESS = 1;
/*     */   public static final int CV_CALIB_FIX_ASPECT_RATIO = 2;
/*     */   public static final int CV_CALIB_FIX_PRINCIPAL_POINT = 4;
/*     */   public static final int CV_CALIB_ZERO_TANGENT_DIST = 8;
/*     */   public static final int CV_CALIB_FIX_FOCAL_LENGTH = 16;
/*     */   public static final int CV_CALIB_FIX_K1 = 32;
/*     */   public static final int CV_CALIB_FIX_K2 = 64;
/*     */   public static final int CV_CALIB_FIX_K3 = 128;
/*     */   public static final int CV_CALIB_FIX_K4 = 2048;
/*     */   public static final int CV_CALIB_FIX_K5 = 4096;
/*     */   public static final int CV_CALIB_FIX_K6 = 8192;
/*     */   public static final int CV_CALIB_RATIONAL_MODEL = 16384;
/*     */   public static final int CV_CALIB_FIX_INTRINSIC = 256;
/*     */   public static final int CV_CALIB_SAME_FOCAL_LENGTH = 512;
/*     */   public static final int CV_CALIB_ZERO_DISPARITY = 1024;
/*     */   public static final int CV_STEREO_BM_NORMALIZED_RESPONSE = 0;
/*     */   public static final int CV_STEREO_BM_XSOBEL = 1;
/*     */   public static final int CV_STEREO_BM_BASIC = 0;
/*     */   public static final int CV_STEREO_BM_FISH_EYE = 1;
/*     */   public static final int CV_STEREO_BM_NARROW = 2;
/*     */   public static final int ITERATIVE = 0;
/*     */   public static final int EPNP = 1;
/*     */   public static final int P3P = 2;
/*     */   public static final int CALIB_CB_SYMMETRIC_GRID = 1;
/*     */   public static final int CALIB_CB_ASYMMETRIC_GRID = 2;
/*     */   public static final int CALIB_CB_CLUSTERING = 4;
/*     */ 
/*     */   public static native CvPOSITObject cvCreatePOSITObject(opencv_core.CvPoint3D32f paramCvPoint3D32f, int paramInt);
/*     */ 
/*     */   public static native void cvPOSIT(CvPOSITObject paramCvPOSITObject, opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*     */ 
/*     */   public static native void cvPOSIT(CvPOSITObject paramCvPOSITObject, opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2);
/*     */ 
/*     */   public static native void cvReleasePOSITObject(@ByPtrPtr CvPOSITObject paramCvPOSITObject);
/*     */ 
/*     */   public static native int cvRANSACUpdateNumIters(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native void cvConvertPointsHomogeneous(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2);
/*     */ 
/*     */   public static native int cvFindFundamentalMat(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt, double paramDouble1, double paramDouble2, opencv_core.CvMat paramCvMat4);
/*     */ 
/*     */   public static native void cvComputeCorrespondEpilines(opencv_core.CvMat paramCvMat1, int paramInt, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
/*     */ 
/*     */   public static native void cvTriangulatePoints(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5);
/*     */ 
/*     */   public static native void cvCorrectMatches(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5);
/*     */ 
/*     */   public static native void cvGetOptimalNewCameraMatrix(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, @ByVal opencv_core.CvSize paramCvSize1, double paramDouble, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize2, opencv_core.CvRect paramCvRect, int paramInt);
/*     */ 
/*     */   public static native int cvRodrigues2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
/*     */ 
/*     */   public static int cvFindHomography(opencv_core.CvMat src_points, opencv_core.CvMat dst_points, opencv_core.CvMat homography)
/*     */   {
/* 158 */     return cvFindHomography(src_points, dst_points, homography, 0, 3.0D, null);
/*     */   }
/*     */ 
/*     */   public static native int cvFindHomography(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, int paramInt, double paramDouble, opencv_core.CvMat paramCvMat4);
/*     */ 
/*     */   public static native void cvRQDecomp3x3(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvPoint3D64f paramCvPoint3D64f);
/*     */ 
/*     */   public static native void cvDecomposeProjectionMatrix(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvPoint3D64f paramCvPoint3D64f);
/*     */ 
/*     */   public static native void cvCalcMatMulDeriv(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4);
/*     */ 
/*     */   public static native void cvComposeRT(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, opencv_core.CvMat paramCvMat12, opencv_core.CvMat paramCvMat13, opencv_core.CvMat paramCvMat14);
/*     */ 
/*     */   public static void cvProjectPoints2(opencv_core.CvMat object_points, opencv_core.CvMat rotation_vector, opencv_core.CvMat translation_vector, opencv_core.CvMat intrinsic_matrix, opencv_core.CvMat distortion_coeffs, opencv_core.CvMat image_points)
/*     */   {
/* 183 */     cvProjectPoints2(object_points, rotation_vector, translation_vector, intrinsic_matrix, distortion_coeffs, image_points, null, null, null, null, null, 0.0D);
/*     */   }
/*     */ 
/*     */   public static native void cvProjectPoints2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, double paramDouble);
/*     */ 
/*     */   public static void cvFindExtrinsicCameraParams2(opencv_core.CvMat object_points, opencv_core.CvMat image_points, opencv_core.CvMat camera_matrix, opencv_core.CvMat distortion_coeffs, opencv_core.CvMat rotation_vector, opencv_core.CvMat translation_vector)
/*     */   {
/* 196 */     cvFindExtrinsicCameraParams2(object_points, image_points, camera_matrix, distortion_coeffs, rotation_vector, translation_vector, 0);
/*     */   }
/*     */ 
/*     */   public static native void cvFindExtrinsicCameraParams2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, int paramInt);
/*     */ 
/*     */   public static void cvInitIntrinsicParams2D(opencv_core.CvMat object_points, opencv_core.CvMat image_points, opencv_core.CvMat npoints, @ByVal opencv_core.CvSize image_size, opencv_core.CvMat camera_matrix)
/*     */   {
/* 205 */     cvInitIntrinsicParams2D(object_points, image_points, npoints, image_size, camera_matrix, -1.0D);
/*     */   }
/*     */ 
/*     */   public static native void cvInitIntrinsicParams2D(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, double paramDouble);
/*     */ 
/*     */   public static native int cvCheckChessboard(opencv_core.IplImage paramIplImage, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */   public static native int cvFindChessboardCorners(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, int[] paramArrayOfInt, int paramInt);
/*     */ 
/*     */   public static native void cvDrawChessboardCorners(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native double cvCalibrateCamera2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, int paramInt);
/*     */ 
/*     */   public static native double cvCalibrateCamera2(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*     */ 
/*     */   public static native void cvCalibrationMatrixValues(opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, opencv_core.CvPoint2D64f paramCvPoint2D64f, double[] paramArrayOfDouble4);
/*     */ 
/*     */   public static native double cvStereoCalibrate(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, opencv_core.CvMat paramCvMat12, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, int paramInt);
/*     */ 
/*     */   public static native void cvStereoRectify(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, @ByVal opencv_core.CvSize paramCvSize1, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9, opencv_core.CvMat paramCvMat10, opencv_core.CvMat paramCvMat11, int paramInt, double paramDouble, @ByVal opencv_core.CvSize paramCvSize2, opencv_core.CvRect paramCvRect1, opencv_core.CvRect paramCvRect2);
/*     */ 
/*     */   public static native int cvStereoRectifyUncalibrated(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, @ByVal opencv_core.CvSize paramCvSize, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, double paramDouble);
/*     */ 
/*     */   public static native CvStereoBMState cvCreateStereoBMState(int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native void cvReleaseStereoBMState(@ByPtrPtr CvStereoBMState paramCvStereoBMState);
/*     */ 
/*     */   public static native void cvFindStereoCorrespondenceBM(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, CvStereoBMState paramCvStereoBMState);
/*     */ 
/*     */   @ByVal
/*     */   public static native opencv_core.CvRect cvGetValidDisparityROI(@ByVal opencv_core.CvRect paramCvRect1, @ByVal opencv_core.CvRect paramCvRect2, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */   public static native void cvValidateDisparity(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */   public static void cvReprojectImageTo3D(opencv_core.CvArr disparityImage, opencv_core.CvArr _3dImage, opencv_core.CvMat Q)
/*     */   {
/* 349 */     cvReprojectImageTo3D(disparityImage, _3dImage, Q, 0);
/*     */   }
/*     */ 
/*     */   public static native void cvReprojectImageTo3D(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native boolean solvePnP(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat5, @opencv_core.OutputArray opencv_core.CvMat paramCvMat6, boolean paramBoolean, int paramInt);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void solvePnPRansac(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.InputArray opencv_core.CvMat paramCvMat5, @opencv_core.InputArray opencv_core.CvMat paramCvMat6, boolean paramBoolean, int paramInt1, float paramFloat, int paramInt2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat7, int paramInt3);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native boolean find4QuadCornerSubpix(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native boolean findCirclesGrid(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, int paramInt, @opencv_core.Ptr opencv_features2d.FeatureDetector paramFeatureDetector);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native boolean findCirclesGridDefault(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, int paramInt);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native float rectify3Collinear(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.InputArray opencv_core.CvMat paramCvMat3, @opencv_core.InputArray opencv_core.CvMat paramCvMat4, @opencv_core.InputArray opencv_core.CvMat paramCvMat5, @opencv_core.InputArray opencv_core.CvMat paramCvMat6, @ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector1, @ByRef opencv_core.Point2fVectorVector paramPoint2fVectorVector2, @ByVal opencv_core.CvSize paramCvSize1, @opencv_core.InputArray opencv_core.CvMat paramCvMat7, @opencv_core.InputArray opencv_core.CvMat paramCvMat8, @opencv_core.InputArray opencv_core.CvMat paramCvMat9, @opencv_core.InputArray opencv_core.CvMat paramCvMat10, @opencv_core.InputArray opencv_core.CvMat paramCvMat11, @opencv_core.InputArray opencv_core.CvMat paramCvMat12, @opencv_core.InputArray opencv_core.CvMat paramCvMat13, @opencv_core.InputArray opencv_core.CvMat paramCvMat14, @opencv_core.InputArray opencv_core.CvMat paramCvMat15, @opencv_core.InputArray opencv_core.CvMat paramCvMat16, @opencv_core.InputArray opencv_core.CvMat paramCvMat17, double paramDouble, @ByVal opencv_core.CvSize paramCvSize2, @Const @Adapter("RectAdapter") opencv_core.CvRect paramCvRect1, @Const @Adapter("RectAdapter") opencv_core.CvRect paramCvRect2, int paramInt);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native void filterSpeckles(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, double paramDouble1, int paramInt, double paramDouble2, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
/*     */ 
/*     */   @Namespace("cv")
/*     */   public static native int estimateAffine3D(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, double paramDouble1, double paramDouble2);
/*     */ 
/*     */   static
/*     */   {
/*  88 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class StereoSGBM extends Pointer
/*     */   {
/*     */     public static final int DISP_SHIFT = 4;
/*     */     public static final int DISP_SCALE = 16;
/*     */ 
/*     */     public StereoSGBM()
/*     */     {
/* 458 */       allocate();
/*     */     }
/*     */ 
/*     */     public StereoSGBM(int minDisparity, int numDisparities, int SADWindowSize, int P1, int P2, int disp12MaxDiff, int preFilterCap, int uniquenessRatio, int speckleWindowSize, int speckleRange, boolean fullDP) {
/* 462 */       allocate(minDisparity, numDisparities, SADWindowSize, P1, P2, disp12MaxDiff, preFilterCap, uniquenessRatio, speckleWindowSize, speckleRange, fullDP);
/*     */     }
/*     */     public StereoSGBM(Pointer p) {
/* 465 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean);
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
/*     */ 
/*     */     public native int minDisparity();
/*     */ 
/*     */     public native StereoSGBM minDisparity(int paramInt);
/*     */ 
/*     */     public native int numberOfDisparities();
/*     */ 
/*     */     public native StereoSGBM numberOfDisparities(int paramInt);
/*     */ 
/*     */     public native int SADWindowSize();
/*     */ 
/*     */     public native StereoSGBM SADWindowSize(int paramInt);
/*     */ 
/*     */     public native int preFilterCap();
/*     */ 
/*     */     public native StereoSGBM preFilterCap(int paramInt);
/*     */ 
/*     */     public native int uniquenessRatio();
/*     */ 
/*     */     public native StereoSGBM uniquenessRatio(int paramInt);
/*     */ 
/*     */     public native int P1();
/*     */ 
/*     */     public native StereoSGBM P1(int paramInt);
/*     */ 
/*     */     public native int P2();
/*     */ 
/*     */     public native StereoSGBM P2(int paramInt);
/*     */ 
/*     */     public native int speckleWindowSize();
/*     */ 
/*     */     public native StereoSGBM speckleWindowSize(int paramInt);
/*     */ 
/*     */     public native int speckleRange();
/*     */ 
/*     */     public native StereoSGBM speckleRange(int paramInt);
/*     */ 
/*     */     public native int disp12MaxDiff();
/*     */ 
/*     */     public native StereoSGBM disp12MaxDiff(int paramInt);
/*     */ 
/*     */     public native boolean fullDP();
/*     */ 
/*     */     public native StereoSGBM fullDP(boolean paramBoolean);
/*     */ 
/*     */     static
/*     */     {
/* 457 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   @Namespace("cv")
/*     */   public static class StereoBM extends Pointer
/*     */   {
/*     */     public static final int PREFILTER_NORMALIZED_RESPONSE = 0;
/*     */     public static final int PREFILTER_XSOBEL = 1;
/*     */     public static final int BASIC_PRESET = 0;
/*     */     public static final int FISH_EYE_PRESET = 1;
/*     */     public static final int NARROW_PRESET = 2;
/*     */ 
/*     */     public StereoBM()
/*     */     {
/* 437 */       allocate();
/*     */     }
/* 439 */     public StereoBM(int preset, int ndisparities, int SADWindowSize) { allocate(preset, ndisparities, SADWindowSize); } 
/*     */     public StereoBM(Pointer p) {
/* 441 */       super();
/*     */     }
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */     public native void init(int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */     @Name({"operator()"})
/*     */     public native void compute(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, int paramInt);
/*     */ 
/*     */     public native opencv_calib3d.CvStereoBMState state();
/*     */ 
/*     */     public native StereoBM state(opencv_calib3d.CvStereoBMState paramCvStereoBMState);
/*     */ 
/*     */     static
/*     */     {
/* 436 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   public static class CvLevMarq extends Pointer
/*     */   {
/*     */     public static final int DONE = 0;
/*     */     public static final int STARTED = 1;
/*     */     public static final int CALC_J = 2;
/*     */     public static final int CHECK_ERR = 3;
/*     */ 
/*     */     public CvLevMarq()
/*     */     {
/* 357 */       allocate();
/*     */     }
/*     */ 
/*     */     public CvLevMarq(int nparams, int nerrs, @ByVal opencv_core.CvTermCriteria criteria, boolean completeSymmFlag) {
/* 361 */       allocate(nparams, nerrs, criteria, completeSymmFlag);
/*     */     }
/* 363 */     public CvLevMarq(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, boolean paramBoolean);
/*     */ 
/*     */     public native void init(int paramInt1, int paramInt2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria, boolean paramBoolean);
/*     */ 
/*     */     public native boolean update(@Cast({"const CvMat*&"}) opencv_core.CvMat paramCvMat1, @ByPtrRef opencv_core.CvMat paramCvMat2, @ByPtrRef opencv_core.CvMat paramCvMat3);
/*     */ 
/*     */     public native boolean updateAlt(@Cast({"const CvMat*&"}) opencv_core.CvMat paramCvMat1, @ByPtrRef opencv_core.CvMat paramCvMat2, @ByPtrRef opencv_core.CvMat paramCvMat3, @ByPtrRef DoublePointer paramDoublePointer);
/*     */ 
/*     */     public native void clear();
/*     */ 
/*     */     public native void step();
/*     */ 
/*     */     public native opencv_core.CvMat mask();
/*     */ 
/*     */     public native CvLevMarq mask(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat prevParam();
/*     */ 
/*     */     public native CvLevMarq prevParam(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat param();
/*     */ 
/*     */     public native CvLevMarq param(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat J();
/*     */ 
/*     */     public native CvLevMarq J(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat err();
/*     */ 
/*     */     public native CvLevMarq err(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat JtJ();
/*     */ 
/*     */     public native CvLevMarq JtJ(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat JtJN();
/*     */ 
/*     */     public native CvLevMarq JtJN(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat JtErr();
/*     */ 
/*     */     public native CvLevMarq JtErr(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat JtJV();
/*     */ 
/*     */     public native CvLevMarq JtJV(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat JtJW();
/*     */ 
/*     */     public native CvLevMarq JtJW(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native double prevErrNorm();
/*     */ 
/*     */     public native CvLevMarq prevErrNorm(double paramDouble);
/*     */ 
/*     */     public native double errNorm();
/*     */ 
/*     */     public native CvLevMarq errNorm(double paramDouble);
/*     */ 
/*     */     public native int lambdaLg10();
/*     */ 
/*     */     public native CvLevMarq lambdaLg10(int paramInt);
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvTermCriteria criteria();
/*     */ 
/*     */     public native CvLevMarq criteria(opencv_core.CvTermCriteria paramCvTermCriteria);
/*     */ 
/*     */     public native int state();
/*     */ 
/*     */     public native CvLevMarq state(int paramInt);
/*     */ 
/*     */     public native int iters();
/*     */ 
/*     */     public native CvLevMarq iters(int paramInt);
/*     */ 
/*     */     public native boolean completeSymmFlag();
/*     */ 
/*     */     public native CvLevMarq completeSymmFlag(boolean paramBoolean);
/*     */ 
/*     */     static
/*     */     {
/* 356 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvStereoBMState extends Pointer
/*     */   {
/*     */     public CvStereoBMState()
/*     */     {
/* 280 */       allocate(); zero(); } 
/* 281 */     public CvStereoBMState(int size) { allocateArray(size); zero(); } 
/* 282 */     public CvStereoBMState(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 287 */     public CvStereoBMState position(int position) { return (CvStereoBMState)super.position(position); }
/*     */ 
/*     */     public static CvStereoBMState create(int preset, int numberOfDisparities)
/*     */     {
/* 291 */       CvStereoBMState p = opencv_calib3d.cvCreateStereoBMState(preset, numberOfDisparities);
/* 292 */       if (p != null) {
/* 293 */         p.deallocator(new ReleaseDeallocator(p));
/*     */       }
/* 295 */       return p;
/*     */     }
/*     */     public void release() {
/* 298 */       deallocate();
/*     */     }
/*     */ 
/*     */     public native int preFilterType();
/*     */ 
/*     */     public native CvStereoBMState preFilterType(int paramInt);
/*     */ 
/*     */     public native int preFilterSize();
/*     */ 
/*     */     public native CvStereoBMState preFilterSize(int paramInt);
/*     */ 
/*     */     public native int preFilterCap();
/*     */ 
/*     */     public native CvStereoBMState preFilterCap(int paramInt);
/*     */ 
/*     */     public native int SADWindowSize();
/*     */ 
/*     */     public native CvStereoBMState SADWindowSize(int paramInt);
/*     */ 
/*     */     public native int minDisparity();
/*     */ 
/*     */     public native CvStereoBMState minDisparity(int paramInt);
/*     */ 
/*     */     public native int numberOfDisparities();
/*     */ 
/*     */     public native CvStereoBMState numberOfDisparities(int paramInt);
/*     */ 
/*     */     public native int textureThreshold();
/*     */ 
/*     */     public native CvStereoBMState textureThreshold(int paramInt);
/*     */ 
/*     */     public native int uniquenessRatio();
/*     */ 
/*     */     public native CvStereoBMState uniquenessRatio(int paramInt);
/*     */ 
/*     */     public native int speckleWindowSize();
/*     */ 
/*     */     public native CvStereoBMState speckleWindowSize(int paramInt);
/*     */ 
/*     */     public native int speckleRange();
/*     */ 
/*     */     public native CvStereoBMState speckleRange(int paramInt);
/*     */ 
/*     */     public native int trySmallerWindows();
/*     */ 
/*     */     public native CvStereoBMState trySmallerWindows(int paramInt);
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvRect roi1();
/*     */ 
/*     */     public native CvStereoBMState roi1(opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     @ByRef
/*     */     public native opencv_core.CvRect roi2();
/*     */ 
/*     */     public native CvStereoBMState roi2(opencv_core.CvRect paramCvRect);
/*     */ 
/*     */     public native int disp12MaxDiff();
/*     */ 
/*     */     public native CvStereoBMState disp12MaxDiff(int paramInt);
/*     */ 
/*     */     public native opencv_core.CvMat preFilteredImg0();
/*     */ 
/*     */     public native CvStereoBMState preFilteredImg0(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat preFilteredImg1();
/*     */ 
/*     */     public native CvStereoBMState preFilteredImg1(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat slidingSumBuf();
/*     */ 
/*     */     public native CvStereoBMState slidingSumBuf(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat cost();
/*     */ 
/*     */     public native CvStereoBMState cost(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat disp();
/*     */ 
/*     */     public native CvStereoBMState disp(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     static
/*     */     {
/* 279 */       Loader.load();
/*     */     }
/*     */ 
/*     */     static class ReleaseDeallocator extends opencv_calib3d.CvStereoBMState
/*     */       implements Pointer.Deallocator
/*     */     {
/*     */       ReleaseDeallocator(opencv_calib3d.CvStereoBMState p)
/*     */       {
/* 301 */         super(); } 
/* 302 */       public void deallocate() { opencv_calib3d.cvReleaseStereoBMState(this); }
/*     */ 
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class CvPOSITObject extends Pointer
/*     */   {
/*     */     public CvPOSITObject()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CvPOSITObject(Pointer p)
/*     */     {
/*  93 */       super();
/*     */     }
/*     */     public static CvPOSITObject create(opencv_core.CvPoint3D32f points, int point_count) {
/*  96 */       CvPOSITObject p = opencv_calib3d.cvCreatePOSITObject(points, point_count);
/*  97 */       if (p != null) {
/*  98 */         p.deallocator(new ReleaseDeallocator(p));
/*     */       }
/* 100 */       return p;
/*     */     }
/*     */ 
/*     */     public void release() {
/* 104 */       deallocate();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/*  91 */       Loader.load();
/*     */     }
/*     */ 
/*     */     static class ReleaseDeallocator extends opencv_calib3d.CvPOSITObject
/*     */       implements Pointer.Deallocator
/*     */     {
/*     */       ReleaseDeallocator(opencv_calib3d.CvPOSITObject p)
/*     */       {
/* 107 */         super(); } 
/* 108 */       public void deallocate() { opencv_calib3d.cvReleasePOSITObject(this); }
/*     */ 
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_calib3d
 * JD-Core Version:    0.6.2
 */