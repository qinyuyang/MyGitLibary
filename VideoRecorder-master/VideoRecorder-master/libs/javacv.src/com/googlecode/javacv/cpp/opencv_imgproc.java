/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
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
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ 
/*      */ @Properties(inherit={opencv_core.class}, value={@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/imgproc/imgproc_c.h>", "<opencv2/imgproc/imgproc.hpp>"}, link={"opencv_imgproc@.2.4"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"opencv_imgproc248"})})
/*      */ public class opencv_imgproc
/*      */ {
/*      */   public static final int CV_BLUR_NO_SCALE = 0;
/*      */   public static final int CV_BLUR = 1;
/*      */   public static final int CV_GAUSSIAN = 2;
/*      */   public static final int CV_MEDIAN = 3;
/*      */   public static final int CV_BILATERAL = 4;
/*      */   public static final int CV_GAUSSIAN_5x5 = 7;
/*      */   public static final int CV_SCHARR = -1;
/*      */   public static final int CV_MAX_SOBEL_KSIZE = 7;
/*      */   public static final int CV_BGR2BGRA = 0;
/*      */   public static final int CV_RGB2RGBA = 0;
/*      */   public static final int CV_BGRA2BGR = 1;
/*      */   public static final int CV_RGBA2RGB = 1;
/*      */   public static final int CV_BGR2RGBA = 2;
/*      */   public static final int CV_RGB2BGRA = 2;
/*      */   public static final int CV_RGBA2BGR = 3;
/*      */   public static final int CV_BGRA2RGB = 3;
/*      */   public static final int CV_BGR2RGB = 4;
/*      */   public static final int CV_RGB2BGR = 4;
/*      */   public static final int CV_BGRA2RGBA = 5;
/*      */   public static final int CV_RGBA2BGRA = 5;
/*      */   public static final int CV_BGR2GRAY = 6;
/*      */   public static final int CV_RGB2GRAY = 7;
/*      */   public static final int CV_GRAY2BGR = 8;
/*      */   public static final int CV_GRAY2RGB = 8;
/*      */   public static final int CV_GRAY2BGRA = 9;
/*      */   public static final int CV_GRAY2RGBA = 9;
/*      */   public static final int CV_BGRA2GRAY = 10;
/*      */   public static final int CV_RGBA2GRAY = 11;
/*      */   public static final int CV_BGR2BGR565 = 12;
/*      */   public static final int CV_RGB2BGR565 = 13;
/*      */   public static final int CV_BGR5652BGR = 14;
/*      */   public static final int CV_BGR5652RGB = 15;
/*      */   public static final int CV_BGRA2BGR565 = 16;
/*      */   public static final int CV_RGBA2BGR565 = 17;
/*      */   public static final int CV_BGR5652BGRA = 18;
/*      */   public static final int CV_BGR5652RGBA = 19;
/*      */   public static final int CV_GRAY2BGR565 = 20;
/*      */   public static final int CV_BGR5652GRAY = 21;
/*      */   public static final int CV_BGR2BGR555 = 22;
/*      */   public static final int CV_RGB2BGR555 = 23;
/*      */   public static final int CV_BGR5552BGR = 24;
/*      */   public static final int CV_BGR5552RGB = 25;
/*      */   public static final int CV_BGRA2BGR555 = 26;
/*      */   public static final int CV_RGBA2BGR555 = 27;
/*      */   public static final int CV_BGR5552BGRA = 28;
/*      */   public static final int CV_BGR5552RGBA = 29;
/*      */   public static final int CV_GRAY2BGR555 = 30;
/*      */   public static final int CV_BGR5552GRAY = 31;
/*      */   public static final int CV_BGR2XYZ = 32;
/*      */   public static final int CV_RGB2XYZ = 33;
/*      */   public static final int CV_XYZ2BGR = 34;
/*      */   public static final int CV_XYZ2RGB = 35;
/*      */   public static final int CV_BGR2YCrCb = 36;
/*      */   public static final int CV_RGB2YCrCb = 37;
/*      */   public static final int CV_YCrCb2BGR = 38;
/*      */   public static final int CV_YCrCb2RGB = 39;
/*      */   public static final int CV_BGR2HSV = 40;
/*      */   public static final int CV_RGB2HSV = 41;
/*      */   public static final int CV_BGR2Lab = 44;
/*      */   public static final int CV_RGB2Lab = 45;
/*      */   public static final int CV_BayerBG2BGR = 46;
/*      */   public static final int CV_BayerGB2BGR = 47;
/*      */   public static final int CV_BayerRG2BGR = 48;
/*      */   public static final int CV_BayerGR2BGR = 49;
/*      */   public static final int CV_BayerBG2RGB = 48;
/*      */   public static final int CV_BayerGB2RGB = 49;
/*      */   public static final int CV_BayerRG2RGB = 46;
/*      */   public static final int CV_BayerGR2RGB = 47;
/*      */   public static final int CV_BGR2Luv = 50;
/*      */   public static final int CV_RGB2Luv = 51;
/*      */   public static final int CV_BGR2HLS = 52;
/*      */   public static final int CV_RGB2HLS = 53;
/*      */   public static final int CV_HSV2BGR = 54;
/*      */   public static final int CV_HSV2RGB = 55;
/*      */   public static final int CV_Lab2BGR = 56;
/*      */   public static final int CV_Lab2RGB = 57;
/*      */   public static final int CV_Luv2BGR = 58;
/*      */   public static final int CV_Luv2RGB = 59;
/*      */   public static final int CV_HLS2BGR = 60;
/*      */   public static final int CV_HLS2RGB = 61;
/*      */   public static final int CV_BayerBG2BGR_VNG = 62;
/*      */   public static final int CV_BayerGB2BGR_VNG = 63;
/*      */   public static final int CV_BayerRG2BGR_VNG = 64;
/*      */   public static final int CV_BayerGR2BGR_VNG = 65;
/*      */   public static final int CV_BayerBG2RGB_VNG = 64;
/*      */   public static final int CV_BayerGB2RGB_VNG = 65;
/*      */   public static final int CV_BayerRG2RGB_VNG = 62;
/*      */   public static final int CV_BayerGR2RGB_VNG = 63;
/*      */   public static final int CV_BGR2HSV_FULL = 66;
/*      */   public static final int CV_RGB2HSV_FULL = 67;
/*      */   public static final int CV_BGR2HLS_FULL = 68;
/*      */   public static final int CV_RGB2HLS_FULL = 69;
/*      */   public static final int CV_HSV2BGR_FULL = 70;
/*      */   public static final int CV_HSV2RGB_FULL = 71;
/*      */   public static final int CV_HLS2BGR_FULL = 72;
/*      */   public static final int CV_HLS2RGB_FULL = 73;
/*      */   public static final int CV_LBGR2Lab = 74;
/*      */   public static final int CV_LRGB2Lab = 75;
/*      */   public static final int CV_LBGR2Luv = 76;
/*      */   public static final int CV_LRGB2Luv = 77;
/*      */   public static final int CV_Lab2LBGR = 78;
/*      */   public static final int CV_Lab2LRGB = 79;
/*      */   public static final int CV_Luv2LBGR = 80;
/*      */   public static final int CV_Luv2LRGB = 81;
/*      */   public static final int CV_BGR2YUV = 82;
/*      */   public static final int CV_RGB2YUV = 83;
/*      */   public static final int CV_YUV2BGR = 84;
/*      */   public static final int CV_YUV2RGB = 85;
/*      */   public static final int CV_BayerBG2GRAY = 86;
/*      */   public static final int CV_BayerGB2GRAY = 87;
/*      */   public static final int CV_BayerRG2GRAY = 88;
/*      */   public static final int CV_BayerGR2GRAY = 89;
/*      */   public static final int CV_YUV2RGB_NV12 = 90;
/*      */   public static final int CV_YUV2BGR_NV12 = 91;
/*      */   public static final int CV_YUV2RGB_NV21 = 92;
/*      */   public static final int CV_YUV2BGR_NV21 = 93;
/*      */   public static final int CV_YUV420sp2RGB = 92;
/*      */   public static final int CV_YUV420sp2BGR = 93;
/*      */   public static final int CV_YUV2RGBA_NV12 = 94;
/*      */   public static final int CV_YUV2BGRA_NV12 = 95;
/*      */   public static final int CV_YUV2RGBA_NV21 = 96;
/*      */   public static final int CV_YUV2BGRA_NV21 = 97;
/*      */   public static final int CV_YUV420sp2RGBA = 96;
/*      */   public static final int CV_YUV420sp2BGRA = 97;
/*      */   public static final int CV_YUV2RGB_YV12 = 98;
/*      */   public static final int CV_YUV2BGR_YV12 = 99;
/*      */   public static final int CV_YUV2RGB_IYUV = 100;
/*      */   public static final int CV_YUV2BGR_IYUV = 101;
/*      */   public static final int CV_YUV2RGB_I420 = 100;
/*      */   public static final int CV_YUV2BGR_I420 = 101;
/*      */   public static final int CV_YUV420p2RGB = 98;
/*      */   public static final int CV_YUV420p2BGR = 99;
/*      */   public static final int CV_YUV2RGBA_YV12 = 102;
/*      */   public static final int CV_YUV2BGRA_YV12 = 103;
/*      */   public static final int CV_YUV2RGBA_IYUV = 104;
/*      */   public static final int CV_YUV2BGRA_IYUV = 105;
/*      */   public static final int CV_YUV2RGBA_I420 = 104;
/*      */   public static final int CV_YUV2BGRA_I420 = 105;
/*      */   public static final int CV_YUV420p2RGBA = 102;
/*      */   public static final int CV_YUV420p2BGRA = 103;
/*      */   public static final int CV_YUV2GRAY_420 = 106;
/*      */   public static final int CV_YUV2GRAY_NV21 = 106;
/*      */   public static final int CV_YUV2GRAY_NV12 = 106;
/*      */   public static final int CV_YUV2GRAY_YV12 = 106;
/*      */   public static final int CV_YUV2GRAY_IYUV = 106;
/*      */   public static final int CV_YUV2GRAY_I420 = 106;
/*      */   public static final int CV_YUV420sp2GRAY = 106;
/*      */   public static final int CV_YUV420p2GRAY = 106;
/*      */   public static final int CV_YUV2RGB_UYVY = 107;
/*      */   public static final int CV_YUV2BGR_UYVY = 108;
/*      */   public static final int CV_YUV2RGB_Y422 = 107;
/*      */   public static final int CV_YUV2BGR_Y422 = 108;
/*      */   public static final int CV_YUV2RGB_UYNV = 107;
/*      */   public static final int CV_YUV2BGR_UYNV = 108;
/*      */   public static final int CV_YUV2RGBA_UYVY = 111;
/*      */   public static final int CV_YUV2BGRA_UYVY = 112;
/*      */   public static final int CV_YUV2RGBA_Y422 = 111;
/*      */   public static final int CV_YUV2BGRA_Y422 = 112;
/*      */   public static final int CV_YUV2RGBA_UYNV = 111;
/*      */   public static final int CV_YUV2BGRA_UYNV = 112;
/*      */   public static final int CV_YUV2RGB_YUY2 = 115;
/*      */   public static final int CV_YUV2BGR_YUY2 = 116;
/*      */   public static final int CV_YUV2RGB_YVYU = 117;
/*      */   public static final int CV_YUV2BGR_YVYU = 118;
/*      */   public static final int CV_YUV2RGB_YUYV = 115;
/*      */   public static final int CV_YUV2BGR_YUYV = 116;
/*      */   public static final int CV_YUV2RGB_YUNV = 115;
/*      */   public static final int CV_YUV2BGR_YUNV = 116;
/*      */   public static final int CV_YUV2RGBA_YUY2 = 119;
/*      */   public static final int CV_YUV2BGRA_YUY2 = 120;
/*      */   public static final int CV_YUV2RGBA_YVYU = 121;
/*      */   public static final int CV_YUV2BGRA_YVYU = 122;
/*      */   public static final int CV_YUV2RGBA_YUYV = 119;
/*      */   public static final int CV_YUV2BGRA_YUYV = 120;
/*      */   public static final int CV_YUV2RGBA_YUNV = 119;
/*      */   public static final int CV_YUV2BGRA_YUNV = 120;
/*      */   public static final int CV_YUV2GRAY_UYVY = 123;
/*      */   public static final int CV_YUV2GRAY_YUY2 = 124;
/*      */   public static final int CV_YUV2GRAY_Y422 = 123;
/*      */   public static final int CV_YUV2GRAY_UYNV = 123;
/*      */   public static final int CV_YUV2GRAY_YVYU = 124;
/*      */   public static final int CV_YUV2GRAY_YUYV = 124;
/*      */   public static final int CV_YUV2GRAY_YUNV = 124;
/*      */   public static final int CV_RGBA2mRGBA = 125;
/*      */   public static final int CV_mRGBA2RGBA = 126;
/*      */   public static final int CV_RGB2YUV_I420 = 127;
/*      */   public static final int CV_BGR2YUV_I420 = 128;
/*      */   public static final int CV_RGB2YUV_IYUV = 127;
/*      */   public static final int CV_BGR2YUV_IYUV = 128;
/*      */   public static final int CV_RGBA2YUV_I420 = 129;
/*      */   public static final int CV_BGRA2YUV_I420 = 130;
/*      */   public static final int CV_RGBA2YUV_IYUV = 129;
/*      */   public static final int CV_BGRA2YUV_IYUV = 130;
/*      */   public static final int CV_RGB2YUV_YV12 = 131;
/*      */   public static final int CV_BGR2YUV_YV12 = 132;
/*      */   public static final int CV_RGBA2YUV_YV12 = 133;
/*      */   public static final int CV_BGRA2YUV_YV12 = 134;
/*      */   public static final int CV_COLORCVT_MAX = 135;
/*      */   public static final int CV_INTER_NN = 0;
/*      */   public static final int CV_INTER_LINEAR = 1;
/*      */   public static final int CV_INTER_CUBIC = 2;
/*      */   public static final int CV_INTER_AREA = 3;
/*      */   public static final int CV_INTER_LANCZOS4 = 4;
/*      */   public static final int CV_WARP_FILL_OUTLIERS = 8;
/*      */   public static final int CV_WARP_INVERSE_MAP = 16;
/*      */   public static final int CV_SHAPE_RECT = 0;
/*      */   public static final int CV_SHAPE_CROSS = 1;
/*      */   public static final int CV_SHAPE_ELLIPSE = 2;
/*      */   public static final int CV_SHAPE_CUSTOM = 100;
/*      */   public static final int CV_MOP_ERODE = 0;
/*      */   public static final int CV_MOP_DILATE = 1;
/*      */   public static final int CV_MOP_OPEN = 2;
/*      */   public static final int CV_MOP_CLOSE = 3;
/*      */   public static final int CV_MOP_GRADIENT = 4;
/*      */   public static final int CV_MOP_TOPHAT = 5;
/*      */   public static final int CV_MOP_BLACKHAT = 6;
/*      */   public static final int CV_TM_SQDIFF = 0;
/*      */   public static final int CV_TM_SQDIFF_NORMED = 1;
/*      */   public static final int CV_TM_CCORR = 2;
/*      */   public static final int CV_TM_CCORR_NORMED = 3;
/*      */   public static final int CV_TM_CCOEFF = 4;
/*      */   public static final int CV_TM_CCOEFF_NORMED = 5;
/*      */   public static final int CV_RETR_EXTERNAL = 0;
/*      */   public static final int CV_RETR_LIST = 1;
/*      */   public static final int CV_RETR_CCOMP = 2;
/*      */   public static final int CV_RETR_TREE = 3;
/*      */   public static final int CV_RETR_FLOODFILL = 4;
/*      */   public static final int CV_CHAIN_CODE = 0;
/*      */   public static final int CV_CHAIN_APPROX_NONE = 1;
/*      */   public static final int CV_CHAIN_APPROX_SIMPLE = 2;
/*      */   public static final int CV_CHAIN_APPROX_TC89_L1 = 3;
/*      */   public static final int CV_CHAIN_APPROX_TC89_KCOS = 4;
/*      */   public static final int CV_LINK_RUNS = 5;
/*      */   public static final int CV_SUBDIV2D_VIRTUAL_POINT_FLAG = 1073741824;
/*      */   public static final int CV_PTLOC_ERROR = -2;
/*      */   public static final int CV_PTLOC_OUTSIDE_RECT = -1;
/*      */   public static final int CV_PTLOC_INSIDE = 0;
/*      */   public static final int CV_PTLOC_VERTEX = 1;
/*      */   public static final int CV_PTLOC_ON_EDGE = 2;
/*      */   public static final int CV_NEXT_AROUND_ORG = 0;
/*      */   public static final int CV_NEXT_AROUND_DST = 34;
/*      */   public static final int CV_PREV_AROUND_ORG = 17;
/*      */   public static final int CV_PREV_AROUND_DST = 51;
/*      */   public static final int CV_NEXT_AROUND_LEFT = 19;
/*      */   public static final int CV_NEXT_AROUND_RIGHT = 49;
/*      */   public static final int CV_PREV_AROUND_LEFT = 32;
/*      */   public static final int CV_PREV_AROUND_RIGHT = 2;
/*      */   public static final int CV_POLY_APPROX_DP = 0;
/*      */   public static final int CV_CONTOURS_MATCH_I1 = 1;
/*      */   public static final int CV_CONTOURS_MATCH_I2 = 2;
/*      */   public static final int CV_CONTOURS_MATCH_I3 = 3;
/*      */   public static final int CV_CLOCKWISE = 1;
/*      */   public static final int CV_COUNTER_CLOCKWISE = 2;
/*      */   public static final int CV_COMP_CORREL = 0;
/*      */   public static final int CV_COMP_CHISQR = 1;
/*      */   public static final int CV_COMP_INTERSECT = 2;
/*      */   public static final int CV_COMP_BHATTACHARYYA = 3;
/*      */   public static final int CV_COMP_HELLINGER = 3;
/*      */   public static final int CV_DIST_MASK_3 = 3;
/*      */   public static final int CV_DIST_MASK_5 = 5;
/*      */   public static final int CV_DIST_MASK_PRECISE = 0;
/*      */   public static final int CV_DIST_LABEL_CCOMP = 0;
/*      */   public static final int CV_DIST_LABEL_PIXEL = 1;
/*      */   public static final int CV_DIST_USER = -1;
/*      */   public static final int CV_DIST_L1 = 1;
/*      */   public static final int CV_DIST_L2 = 2;
/*      */   public static final int CV_DIST_C = 3;
/*      */   public static final int CV_DIST_L12 = 4;
/*      */   public static final int CV_DIST_FAIR = 5;
/*      */   public static final int CV_DIST_WELSCH = 6;
/*      */   public static final int CV_DIST_HUBER = 7;
/*      */   public static final int CV_THRESH_BINARY = 0;
/*      */   public static final int CV_THRESH_BINARY_INV = 1;
/*      */   public static final int CV_THRESH_TRUNC = 2;
/*      */   public static final int CV_THRESH_TOZERO = 3;
/*      */   public static final int CV_THRESH_TOZERO_INV = 4;
/*      */   public static final int CV_THRESH_MASK = 7;
/*      */   public static final int CV_THRESH_OTSU = 8;
/*      */   public static final int CV_ADAPTIVE_THRESH_MEAN_C = 0;
/*      */   public static final int CV_ADAPTIVE_THRESH_GAUSSIAN_C = 1;
/*      */   public static final int CV_FLOODFILL_FIXED_RANGE = 65536;
/*      */   public static final int CV_FLOODFILL_MASK_ONLY = 131072;
/*      */   public static final int CV_CANNY_L2_GRADIENT = -2147483648;
/*      */   public static final int CV_HOUGH_STANDARD = 0;
/*      */   public static final int CV_HOUGH_PROBABILISTIC = 1;
/*      */   public static final int CV_HOUGH_MULTI_SCALE = 2;
/*      */   public static final int CV_HOUGH_GRADIENT = 3;
/*      */   public static final int CV_HIST_MAGIC_VAL = 1111818240;
/*      */   public static final int CV_HIST_UNIFORM_FLAG = 1024;
/*      */   public static final int CV_HIST_RANGES_FLAG = 2048;
/*      */   public static final int CV_HIST_ARRAY = 0;
/*      */   public static final int CV_HIST_SPARSE = 1;
/*      */   public static final int CV_HIST_TREE = 1;
/*      */   public static final int CV_HIST_UNIFORM = 1;
/*      */   public static final int BORDER_REPLICATE = 1;
/*      */   public static final int BORDER_CONSTANT = 0;
/*      */   public static final int BORDER_REFLECT = 2;
/*      */   public static final int BORDER_WRAP = 3;
/*      */   public static final int BORDER_REFLECT_101 = 4;
/*      */   public static final int BORDER_REFLECT101 = 4;
/*      */   public static final int BORDER_TRANSPARENT = 5;
/*      */   public static final int BORDER_DEFAULT = 4;
/*      */   public static final int BORDER_ISOLATED = 16;
/*      */   public static final int KERNEL_GENERAL = 0;
/*      */   public static final int KERNEL_SYMMETRICAL = 1;
/*      */   public static final int KERNEL_ASYMMETRICAL = 2;
/*      */   public static final int KERNEL_SMOOTH = 4;
/*      */   public static final int KERNEL_INTEGER = 8;
/*      */   public static final int MORPH_ERODE = 0;
/*      */   public static final int MORPH_DILATE = 1;
/*      */   public static final int MORPH_OPEN = 2;
/*      */   public static final int MORPH_CLOSE = 3;
/*      */   public static final int MORPH_GRADIENT = 4;
/*      */   public static final int MORPH_TOPHAT = 5;
/*      */   public static final int MORPH_BLACKHAT = 6;
/*      */   public static final int GHT_POSITION = 0;
/*      */   public static final int GHT_SCALE = 1;
/*      */   public static final int GHT_ROTATION = 2;
/*      */   public static final int PROJ_SPHERICAL_ORTHO = 0;
/*      */   public static final int PROJ_SPHERICAL_EQRECT = 1;
/*      */   public static final int GC_BGD = 0;
/*      */   public static final int GC_FGD = 1;
/*      */   public static final int GC_PR_BGD = 2;
/*      */   public static final int GC_PR_FGD = 3;
/*      */   public static final int GC_INIT_WITH_RECT = 0;
/*      */   public static final int GC_INIT_WITH_MASK = 1;
/*      */   public static final int GC_EVAL = 2;
/*      */ 
/*      */   public static native void CV_INIT_3X3_DELTAS(int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvSubdiv2DEdge CV_SUBDIV2D_NEXT_EDGE(@ByVal CvSubdiv2DEdge paramCvSubdiv2DEdge);
/*      */ 
/*      */   public static native void cvAcc(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvSquareAcc(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvMultiplyAcc(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvRunningAvg(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble, opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvCopyMakeBorder(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   public static void cvSmooth(opencv_core.CvArr src, opencv_core.CvArr dst, int smoothtype, int size1)
/*      */   {
/*  716 */     cvSmooth(src, dst, smoothtype, size1, 0, 0.0D, 0.0D); } 
/*      */   public static native void cvSmooth(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static native void cvFilter2D(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   public static native void cvIntegral(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvPyrDown(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native void cvPyrUp(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native opencv_core.CvMatArray cvCreatePyramid(opencv_core.CvArr paramCvArr1, int paramInt1, double paramDouble, opencv_core.CvSize paramCvSize, opencv_core.CvArr paramCvArr2, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvReleasePyramid(@ByPtrPtr opencv_core.CvMatArray paramCvMatArray, int paramInt);
/*      */ 
/*      */   public static native void cvPyrMeanShiftFiltering(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */   public static native void cvWatershed(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvSobel(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvLaplace(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native void cvCvtColor(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*  736 */   public static void cvResize(opencv_core.CvArr src, opencv_core.CvArr dst) { cvResize(src, dst, 1); } 
/*      */   public static native void cvResize(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static void cvWarpAffine(opencv_core.CvArr src, opencv_core.CvArr dst, opencv_core.CvMat map_matrix) {
/*  740 */     cvWarpAffine(src, dst, map_matrix, 9, opencv_core.CvScalar.ZERO);
/*      */   }
/*      */ 
/*      */   public static native void cvWarpAffine(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   public static native opencv_core.CvMat cvGetAffineTransform(opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native opencv_core.CvMat cvGetAffineTransform(@Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat1, @Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native opencv_core.CvMat cv2DRotationMatrix(@ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble1, double paramDouble2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static void cvWarpPerspective(opencv_core.CvArr src, opencv_core.CvArr dst, opencv_core.CvMat map_matrix) {
/*  752 */     cvWarpPerspective(src, dst, map_matrix, 9, opencv_core.CvScalar.ZERO);
/*      */   }
/*      */ 
/*      */   public static native void cvWarpPerspective(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat, int paramInt, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   public static native opencv_core.CvMat cvGetPerspectiveTransform(opencv_core.CvPoint2D32f paramCvPoint2D32f1, opencv_core.CvPoint2D32f paramCvPoint2D32f2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native opencv_core.CvMat cvGetPerspectiveTransform(@Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat1, @Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native void cvRemap(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, int paramInt, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvConvertMaps(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvLogPolar(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, int paramInt);
/*      */ 
/*      */   public static native void cvLinearPolar(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, double paramDouble, int paramInt);
/*      */ 
/*      */   public static void cvUndistort2(opencv_core.CvArr src, opencv_core.CvArr dst, opencv_core.CvMat intrinsic_matrix, opencv_core.CvMat distortion_coeffs) {
/*  770 */     cvUndistort2(src, dst, intrinsic_matrix, distortion_coeffs, null);
/*      */   }
/*      */ 
/*      */   public static native void cvUndistort2(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */   public static native void cvInitUndistortMap(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvInitUndistortRectifyMap(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvUndistortPoints(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6);
/*      */ 
/*      */   public static native IplConvKernel cvCreateStructuringElementEx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void cvReleaseStructuringElement(@ByPtrPtr IplConvKernel paramIplConvKernel);
/*      */ 
/*      */   public static native void cvErode(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, IplConvKernel paramIplConvKernel, int paramInt);
/*      */ 
/*      */   public static native void cvDilate(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, IplConvKernel paramIplConvKernel, int paramInt);
/*      */ 
/*      */   public static native void cvMorphologyEx(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, IplConvKernel paramIplConvKernel, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvMoments(opencv_core.CvArr paramCvArr, CvMoments paramCvMoments, int paramInt);
/*      */ 
/*      */   public static native double cvGetSpatialMoment(CvMoments paramCvMoments, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native double cvGetCentralMoment(CvMoments paramCvMoments, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native double cvGetNormalizedCentralMoment(CvMoments paramCvMoments, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvGetHuMoments(CvMoments paramCvMoments, CvHuMoments paramCvHuMoments);
/*      */ 
/*      */   public static native int cvSampleLine(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvPoint paramCvPoint1, @ByVal opencv_core.CvPoint paramCvPoint2, Pointer paramPointer, int paramInt);
/*      */ 
/*      */   public static native void cvGetRectSubPix(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native void cvGetQuadrangleSubPix(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */   public static native void cvMatchTemplate(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, int paramInt);
/*      */ 
/*      */   public static native float cvCalcEMD2(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt, CvDistanceFunction paramCvDistanceFunction, opencv_core.CvArr paramCvArr3, opencv_core.CvArr paramCvArr4, float[] paramArrayOfFloat, Pointer paramPointer);
/*      */ 
/*      */   public static int cvFindContours(opencv_core.CvArr image, opencv_core.CvMemStorage storage, @ByPtrPtr opencv_core.CvSeq first_contour, int header_size, int mode, int method)
/*      */   {
/*  867 */     return cvFindContours(image, storage, first_contour, header_size, mode, method, opencv_core.CvPoint.ZERO);
/*      */   }
/*      */ 
/*      */   public static native int cvFindContours(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage, @ByPtrPtr opencv_core.CvSeq paramCvSeq, int paramInt1, int paramInt2, int paramInt3, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   public static CvContourScanner cvStartFindContours(opencv_core.CvArr image, opencv_core.CvMemStorage storage, int header_size, int mode, int method)
/*      */   {
/*  874 */     return cvStartFindContours(image, storage, header_size, mode, method, opencv_core.CvPoint.ZERO); } 
/*      */   @ByVal
/*      */   public static native CvContourScanner cvStartFindContours(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage, int paramInt1, int paramInt2, int paramInt3, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvFindNextContour(@ByVal CvContourScanner paramCvContourScanner);
/*      */ 
/*      */   public static native void cvSubstituteContour(@ByVal CvContourScanner paramCvContourScanner, opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvEndFindContours(CvContourScanner paramCvContourScanner);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvApproxChains(opencv_core.CvSeq paramCvSeq, opencv_core.CvMemStorage paramCvMemStorage, int paramInt1, double paramDouble, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvStartReadChainPoints(opencv_core.CvChain paramCvChain, CvChainPtReader paramCvChainPtReader);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvPoint cvReadChainPoint(CvChainPtReader paramCvChainPtReader);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvApproxPoly(Pointer paramPointer, int paramInt1, opencv_core.CvMemStorage paramCvMemStorage, int paramInt2, double paramDouble, int paramInt3);
/*      */ 
/*      */   public static native double cvArcLength(Pointer paramPointer, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
/*      */ 
/*  894 */   public static double cvContourPerimeter(Pointer contour) { return cvArcLength(contour, opencv_core.CV_WHOLE_SEQ, 1); }
/*      */ 
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvRect cvBoundingRect(opencv_core.CvArr paramCvArr, int paramInt);
/*      */ 
/*      */   public static native double cvContourArea(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSlice paramCvSlice, int paramInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvBox2D cvMinAreaRect2(opencv_core.CvArr paramCvArr, opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native int cvMinEnclosingCircle(opencv_core.CvArr paramCvArr, opencv_core.CvPoint2D32f paramCvPoint2D32f, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native int cvMinEnclosingCircle(opencv_core.CvArr paramCvArr, @Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*      */ 
/*      */   public static native double cvMatchShapes(Pointer paramPointer1, Pointer paramPointer2, int paramInt, double paramDouble);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvConvexHull2(opencv_core.CvArr paramCvArr, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int cvCheckContourConvexity(opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvConvexityDefects(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvBox2D cvFitEllipse2(opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   @ByVal
/*      */   public static native opencv_core.CvRect cvMaxRect(opencv_core.CvRect paramCvRect1, opencv_core.CvRect paramCvRect2);
/*      */ 
/*      */   public static native void cvBoxPoints(@ByVal opencv_core.CvBox2D paramCvBox2D, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */   public static native void cvBoxPoints(@ByVal opencv_core.CvBox2D paramCvBox2D, @Cast({"CvPoint2D32f*"}) float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvPointSeqFromMat(int paramInt, opencv_core.CvArr paramCvArr, opencv_core.CvContour paramCvContour, opencv_core.CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */   public static native double cvPointPolygonTest(opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt);
/*      */ 
/*      */   public static boolean CV_IS_HIST(opencv_core.CvArr hist)
/*      */   {
/*  966 */     CvHistogram h = new CvHistogram(hist);
/*  967 */     return (hist != null) && ((h.type() & 0xFFFF0000) == 1111818240) && (h.bins() != null);
/*      */   }
/*      */   public static boolean CV_IS_UNIFORM_HIST(CvHistogram hist) {
/*  970 */     return (hist.type() & 0x400) != 0;
/*      */   }
/*      */   public static boolean CV_IS_SPARSE_HIST(CvHistogram hist) {
/*  973 */     return opencv_core.CV_IS_SPARSE_MAT(hist.bins());
/*      */   }
/*      */   public static boolean CV_HIST_HAS_RANGES(CvHistogram hist) {
/*  976 */     return (hist.type() & 0x800) != 0;
/*      */   }
/*      */ 
/*      */   public static CvHistogram cvCreateHist(int dims, int[] sizes, int type, float[][] ranges, int uniform)
/*      */   {
/*  981 */     return cvCreateHist(dims, sizes, type, ranges == null ? null : new PointerPointer(ranges), uniform);
/*      */   }
/*      */ 
/*      */   public static native CvHistogram cvCreateHist(int paramInt1, int[] paramArrayOfInt, int paramInt2, @Cast({"float**"}) PointerPointer paramPointerPointer, int paramInt3);
/*      */ 
/*      */   public static void cvSetHistBinRanges(CvHistogram hist, float[][] ranges, int uniform) {
/*  987 */     cvSetHistBinRanges(hist, ranges == null ? null : new PointerPointer(ranges), uniform);
/*      */   }
/*      */ 
/*      */   public static native void cvSetHistBinRanges(CvHistogram paramCvHistogram, @Cast({"float**"}) PointerPointer paramPointerPointer, int paramInt);
/*      */ 
/*      */   public static CvHistogram cvMakeHistHeaderForArray(int dims, int[] sizes, CvHistogram hist, float[] data, float[][] ranges, int uniform)
/*      */   {
/*  994 */     return cvMakeHistHeaderForArray(dims, sizes, hist, data, ranges == null ? null : new PointerPointer(ranges), uniform);
/*      */   }
/*      */ 
/*      */   public static native CvHistogram cvMakeHistHeaderForArray(int paramInt1, int[] paramArrayOfInt, CvHistogram paramCvHistogram, float[] paramArrayOfFloat, @Cast({"float**"}) PointerPointer paramPointerPointer, int paramInt2);
/*      */ 
/*      */   public static CvHistogram cvMakeHistHeaderForArray(int dims, int[] sizes, CvHistogram hist, FloatPointer data, float[][] ranges, int uniform) {
/* 1000 */     return cvMakeHistHeaderForArray(dims, sizes, hist, data, ranges == null ? null : new PointerPointer(ranges), uniform); } 
/*      */   public static native CvHistogram cvMakeHistHeaderForArray(int paramInt1, int[] paramArrayOfInt, CvHistogram paramCvHistogram, FloatPointer paramFloatPointer, @Cast({"float**"}) PointerPointer paramPointerPointer, int paramInt2);
/*      */ 
/*      */   public static native void cvReleaseHist(@ByPtrPtr CvHistogram paramCvHistogram);
/*      */ 
/*      */   public static native void cvClearHist(CvHistogram paramCvHistogram);
/*      */ 
/*      */   public static native void cvGetMinMaxHistValue(CvHistogram paramCvHistogram, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native void cvNormalizeHist(CvHistogram paramCvHistogram, double paramDouble);
/*      */ 
/*      */   public static native void cvThreshHist(CvHistogram paramCvHistogram, double paramDouble);
/*      */ 
/*      */   public static native double cvCompareHist(CvHistogram paramCvHistogram1, CvHistogram paramCvHistogram2, int paramInt);
/*      */ 
/*      */   public static native void cvCopyHist(CvHistogram paramCvHistogram1, @ByPtrPtr CvHistogram paramCvHistogram2);
/*      */ 
/*      */   public static native void cvCalcBayesianProb(@ByPtrPtr CvHistogram paramCvHistogram1, int paramInt, @ByPtrPtr CvHistogram paramCvHistogram2);
/*      */ 
/* 1016 */   public static void cvCalcArrHist(opencv_core.CvArr[] arr, CvHistogram hist, int accumulate, opencv_core.CvArr mask) { cvCalcArrHist(new opencv_core.CvArrArray(arr), hist, accumulate, mask); }
/*      */ 
/*      */   public static native void cvCalcArrHist(opencv_core.CvArrArray paramCvArrArray, CvHistogram paramCvHistogram, int paramInt, opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   public static void cvCalcHist(opencv_core.IplImage[] arr, CvHistogram hist, int accumulate, opencv_core.CvArr mask) {
/* 1021 */     cvCalcHist(new opencv_core.IplImageArray(arr), hist, accumulate, mask);
/*      */   }
/*      */ 
/*      */   public static void cvCalcHist(opencv_core.IplImageArray arr, CvHistogram hist, int accumulate, opencv_core.CvArr mask) {
/* 1025 */     cvCalcArrHist(arr, hist, accumulate, mask);
/*      */   }
/*      */ 
/*      */   public static void cvCalcArrBackProject(opencv_core.CvArr[] image, opencv_core.CvArr dst, CvHistogram hist) {
/* 1029 */     cvCalcArrBackProject(new opencv_core.CvArrArray(image), dst, hist);
/*      */   }
/*      */   public static native void cvCalcArrBackProject(opencv_core.CvArrArray paramCvArrArray, opencv_core.CvArr paramCvArr, CvHistogram paramCvHistogram);
/*      */ 
/*      */   public static void cvCalcBackProject(opencv_core.IplImage[] image, opencv_core.CvArr dst, CvHistogram hist) {
/* 1034 */     cvCalcBackProject(new opencv_core.IplImageArray(image), dst, hist);
/*      */   }
/*      */ 
/*      */   public static void cvCalcBackProject(opencv_core.IplImageArray image, opencv_core.CvArr dst, CvHistogram hist) {
/* 1038 */     cvCalcArrBackProject(image, dst, hist);
/*      */   }
/*      */ 
/*      */   public static void cvCalcArrBackProjectPatch(opencv_core.CvArr[] image, opencv_core.CvArr dst, @ByVal opencv_core.CvSize range, CvHistogram hist, int method, double factor)
/*      */   {
/* 1043 */     cvCalcArrBackProjectPatch(new opencv_core.CvArrArray(image), dst, range, hist, method, factor);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcArrBackProjectPatch(opencv_core.CvArrArray paramCvArrArray, opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvSize paramCvSize, CvHistogram paramCvHistogram, int paramInt, double paramDouble);
/*      */ 
/*      */   public static void cvCalcBackProjectPatch(opencv_core.IplImage[] image, opencv_core.CvArr dst, @ByVal opencv_core.CvSize range, CvHistogram hist, int method, double factor) {
/* 1049 */     cvCalcBackProjectPatch(new opencv_core.IplImageArray(image), dst, range, hist, method, factor);
/*      */   }
/*      */ 
/*      */   public static void cvCalcBackProjectPatch(opencv_core.IplImageArray image, opencv_core.CvArr dst, opencv_core.CvSize range, CvHistogram hist, int method, double factor) {
/* 1053 */     cvCalcArrBackProjectPatch(image, dst, range, hist, method, factor);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcProbDensity(CvHistogram paramCvHistogram1, CvHistogram paramCvHistogram2, CvHistogram paramCvHistogram3, double paramDouble);
/*      */ 
/*      */   public static native void cvEqualizeHist(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvDistTransform(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, FloatPointer paramFloatPointer, opencv_core.CvArr paramCvArr3, int paramInt3);
/*      */ 
/*      */   public static native double cvThreshold(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */   public static native void cvAdaptiveThreshold(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2);
/*      */ 
/*      */   public static native void cvFloodFill(opencv_core.CvArr paramCvArr1, @ByVal opencv_core.CvPoint paramCvPoint, @ByVal opencv_core.CvScalar paramCvScalar1, @ByVal opencv_core.CvScalar paramCvScalar2, @ByVal opencv_core.CvScalar paramCvScalar3, CvConnectedComp paramCvConnectedComp, int paramInt, opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvCanny(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */   public static native void cvPreCornerDetect(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native void cvCornerEigenValsAndVecs(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvCornerMinEigenVal(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvCornerHarris(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, double paramDouble);
/*      */ 
/*      */   public static native void cvFindCornerSubPix(opencv_core.CvArr paramCvArr, opencv_core.CvPoint2D32f paramCvPoint2D32f, int paramInt, @ByVal opencv_core.CvSize paramCvSize1, @ByVal opencv_core.CvSize paramCvSize2, @ByVal opencv_core.CvTermCriteria paramCvTermCriteria);
/*      */ 
/*      */   public static native void cvGoodFeaturesToTrack(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, opencv_core.CvPoint2D32f paramCvPoint2D32f, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, opencv_core.CvArr paramCvArr4, int paramInt1, int paramInt2, double paramDouble3);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvHoughLines2(opencv_core.CvArr paramCvArr, Pointer paramPointer, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, double paramDouble3, double paramDouble4);
/*      */ 
/*      */   public static native opencv_core.CvSeq cvHoughCircles(opencv_core.CvArr paramCvArr, Pointer paramPointer, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvFitLine(opencv_core.CvArr paramCvArr, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native void cvFitLine(opencv_core.CvArr paramCvArr, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, FloatPointer paramFloatPointer);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native int borderInterpolate(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native int getKernelType(@opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseRowFilter getLinearRowFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseColumnFilter getLinearColumnFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, int paramInt3, int paramInt4, double paramDouble, int paramInt5);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseFilter getLinearFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint, double paramDouble, int paramInt3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createSeparableLinearFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @ByVal opencv_core.CvPoint paramCvPoint, double paramDouble, int paramInt3, int paramInt4, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createLinearFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint, double paramDouble, int paramInt3, int paramInt4, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.OutputMat
/*      */   public static native opencv_core.CvMat getGaussianKernel(int paramInt1, double paramDouble, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createGaussianFilter(int paramInt1, @ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void getDerivKernels(@opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2, int paramInt3, @Cast({"bool"}) boolean paramBoolean, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createDerivFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseRowFilter getRowSumFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseColumnFilter getColumnSumFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createBoxFilter(int paramInt1, int paramInt2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvPoint paramCvPoint, @Cast({"bool"}) boolean paramBoolean, int paramInt3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.OutputMat
/*      */   public static native opencv_core.CvMat getGaborKernel(@ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseRowFilter getMorphologyRowFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseColumnFilter getMorphologyColumnFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native BaseFilter getMorphologyFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @ByVal
/*      */   public static native opencv_core.CvScalar morphologyDefaultBorderValue();
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native FilterEngine createMorphologyFilter(int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt3, int paramInt4, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void medianBlur(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void GaussianBlur(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void bilateralFilter(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void adaptiveBilateralFilter(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, double paramDouble1, double paramDouble2, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void boxFilter(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvPoint paramCvPoint, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void blur(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvPoint paramCvPoint, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void filter2D(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, @opencv_core.InputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvPoint paramCvPoint, double paramDouble, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void sepFilter2D(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, @opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @ByVal opencv_core.CvPoint paramCvPoint, double paramDouble, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void Sobel(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, int paramInt5);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void Scharr(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, int paramInt4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void Laplacian(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void Canny(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt, boolean paramBoolean);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void eigen2x2(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void eigen2x2(FloatPointer paramFloatPointer1, FloatPointer paramFloatPointer2, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native double PSNR(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @Adapter("Point2dAdapter")
/*      */   public static native opencv_core.CvPoint2D64f phaseCorrelate(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @Adapter("Point2dAdapter")
/*      */   public static native opencv_core.CvPoint2D64f phaseCorrelateRes(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, double[] paramArrayOfDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void createHanningWindow(@opencv_core.OutputArray opencv_core.CvMat paramCvMat, @ByVal opencv_core.CvSize paramCvSize, int paramInt);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native float initWideAngleProjMap(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @ByVal opencv_core.CvSize paramCvSize, int paramInt1, int paramInt2, @opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt3, double paramDouble);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @opencv_core.Ptr
/*      */   public static native CLAHE createCLAHE(double paramDouble, @ByVal opencv_core.CvSize paramCvSize);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native float EMD(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, int paramInt, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, float[] paramArrayOfFloat, @opencv_core.InputArray opencv_core.CvArr paramCvArr4);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void grabCut(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvRect paramCvRect, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @Cast({"bool"})
/*      */   public static native boolean isContourConvex(@opencv_core.InputArray opencv_core.CvArr paramCvArr);
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native float intersectConvexConvex(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   static
/*      */   {
/*   91 */     Loader.load();
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class CLAHE extends opencv_core.Algorithm
/*      */   {
/*      */     public CLAHE()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CLAHE(Pointer p)
/*      */     {
/* 1348 */       super();
/*      */     }
/*      */ 
/*      */     public native void apply(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2);
/*      */ 
/*      */     public native void setClipLimit(double paramDouble);
/*      */ 
/*      */     public native double getClipLimit();
/*      */ 
/*      */     public native void setTilesGridSize(@ByVal opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize getTilesGridSize();
/*      */ 
/*      */     public native void collectGarbage();
/*      */ 
/*      */     static
/*      */     {
/* 1346 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class GeneralizedHough extends opencv_core.Algorithm
/*      */   {
/*      */     public GeneralizedHough()
/*      */     {
/*      */     }
/*      */ 
/*      */     public GeneralizedHough(Pointer p)
/*      */     {
/* 1309 */       super();
/*      */     }
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native GeneralizedHough create(int paramInt);
/*      */ 
/*      */     public native void setTemplate(@opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native void setTemplate(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @ByVal opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, int paramInt);
/*      */ 
/*      */     public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @opencv_core.InputArray opencv_core.CvArr paramCvArr3, @opencv_core.OutputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2);
/*      */ 
/*      */     public native void release();
/*      */ 
/*      */     static
/*      */     {
/* 1307 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class FilterEngine extends Pointer
/*      */   {
/*      */     public FilterEngine()
/*      */     {
/* 1148 */       allocate();
/*      */     }
/*      */ 
/*      */     public FilterEngine(@opencv_core.Ptr opencv_imgproc.BaseFilter _filter2D, @opencv_core.Ptr opencv_imgproc.BaseRowFilter _rowFilter, @opencv_core.Ptr opencv_imgproc.BaseColumnFilter _columnFilter, int srcType, int dstType, int bufType, int _rowBorderType, int _columnBorderType, @ByVal opencv_core.CvScalar _borderValue)
/*      */     {
/* 1153 */       allocate(_filter2D, _rowFilter, _columnFilter, srcType, dstType, bufType, _rowBorderType, _columnBorderType, _borderValue);
/*      */     }
/*      */     public FilterEngine(Pointer p) {
/* 1156 */       super();
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@opencv_core.Ptr opencv_imgproc.BaseFilter paramBaseFilter, @opencv_core.Ptr opencv_imgproc.BaseRowFilter paramBaseRowFilter, @opencv_core.Ptr opencv_imgproc.BaseColumnFilter paramBaseColumnFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     public native void init(@opencv_core.Ptr opencv_imgproc.BaseFilter paramBaseFilter, @opencv_core.Ptr opencv_imgproc.BaseRowFilter paramBaseRowFilter, @opencv_core.Ptr opencv_imgproc.BaseColumnFilter paramBaseColumnFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @ByVal opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     public native int start(@ByVal opencv_core.CvSize paramCvSize, @ByVal opencv_core.CvRect paramCvRect, int paramInt);
/*      */ 
/*      */     public native int start(@opencv_core.InputMat opencv_core.CvArr paramCvArr, @ByVal opencv_core.CvRect paramCvRect, @Cast({"bool"}) boolean paramBoolean, int paramInt);
/*      */ 
/*      */     public native int proceed(@Cast({"uchar*"}) BytePointer paramBytePointer1, int paramInt1, int paramInt2, @Cast({"uchar*"}) BytePointer paramBytePointer2, int paramInt3);
/*      */ 
/*      */     public native void apply(@opencv_core.InputMat opencv_core.CvArr paramCvArr1, @opencv_core.InputMat opencv_core.CvArr paramCvArr2, @ByVal opencv_core.CvRect paramCvRect, @ByVal opencv_core.CvPoint paramCvPoint, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native boolean isSeparable();
/*      */ 
/*      */     public native int remainingInputRows();
/*      */ 
/*      */     public native int remainingOutputRows();
/*      */ 
/*      */     public native int srcType();
/*      */ 
/*      */     public native FilterEngine srcType(int paramInt);
/*      */ 
/*      */     public native int dstType();
/*      */ 
/*      */     public native FilterEngine dstType(int paramInt);
/*      */ 
/*      */     public native int bufType();
/*      */ 
/*      */     public native FilterEngine bufType(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize ksize();
/*      */ 
/*      */     public native FilterEngine ksize(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint anchor();
/*      */ 
/*      */     public native FilterEngine anchor(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native int maxWidth();
/*      */ 
/*      */     public native FilterEngine maxWidth(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize wholeSize();
/*      */ 
/*      */     public native FilterEngine wholeSize(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvRect roi();
/*      */ 
/*      */     public native FilterEngine roi(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native int dx1();
/*      */ 
/*      */     public native FilterEngine dx1(int paramInt);
/*      */ 
/*      */     public native int dx2();
/*      */ 
/*      */     public native FilterEngine dx2(int paramInt);
/*      */ 
/*      */     public native int rowBorderType();
/*      */ 
/*      */     public native FilterEngine rowBorderType(int paramInt);
/*      */ 
/*      */     public native int columnBorderType();
/*      */ 
/*      */     public native FilterEngine columnBorderType(int paramInt);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native IntPointer borderTab();
/*      */ 
/*      */     public native FilterEngine borderTab(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int borderElemSize();
/*      */ 
/*      */     public native FilterEngine borderElemSize(int paramInt);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer ringBuf();
/*      */ 
/*      */     public native FilterEngine ringBuf(BytePointer paramBytePointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer srcRow();
/*      */ 
/*      */     public native FilterEngine srcRow(BytePointer paramBytePointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer constBorderValue();
/*      */ 
/*      */     public native FilterEngine constBorderValue(BytePointer paramBytePointer);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer constBorderRow();
/*      */ 
/*      */     public native FilterEngine constBorderRow(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int bufStep();
/*      */ 
/*      */     public native FilterEngine bufStep(int paramInt);
/*      */ 
/*      */     public native int startY();
/*      */ 
/*      */     public native FilterEngine startY(int paramInt);
/*      */ 
/*      */     public native int startY0();
/*      */ 
/*      */     public native FilterEngine startY0(int paramInt);
/*      */ 
/*      */     public native int endY();
/*      */ 
/*      */     public native FilterEngine endY(int paramInt);
/*      */ 
/*      */     public native int rowCount();
/*      */ 
/*      */     public native FilterEngine rowCount(int paramInt);
/*      */ 
/*      */     public native int dstY();
/*      */ 
/*      */     public native FilterEngine dstY(int paramInt);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     @Cast({"uchar**"})
/*      */     public native PointerPointer rows();
/*      */ 
/*      */     public native FilterEngine rows(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_imgproc.BaseFilter filter2D();
/*      */ 
/*      */     public native FilterEngine filter2D(opencv_imgproc.BaseFilter paramBaseFilter);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_imgproc.BaseRowFilter rowFilter();
/*      */ 
/*      */     public native FilterEngine rowFilter(opencv_imgproc.BaseRowFilter paramBaseRowFilter);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native opencv_imgproc.BaseColumnFilter columnFilter();
/*      */ 
/*      */     public native FilterEngine columnFilter(opencv_imgproc.BaseColumnFilter paramBaseColumnFilter);
/*      */ 
/*      */     static
/*      */     {
/* 1147 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class BaseFilter extends Pointer
/*      */   {
/*      */     public BaseFilter()
/*      */     {
/*      */     }
/*      */ 
/*      */     public BaseFilter(Pointer p)
/*      */     {
/* 1136 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void filter(@Cast({"const uchar**"}) PointerPointer paramPointerPointer, @Cast({"uchar*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */     public native void reset();
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvSize ksize();
/*      */ 
/*      */     public native BaseFilter ksize(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint anchor();
/*      */ 
/*      */     public native BaseFilter anchor(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     static
/*      */     {
/* 1134 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class BaseColumnFilter extends Pointer
/*      */   {
/*      */     public BaseColumnFilter()
/*      */     {
/*      */     }
/*      */ 
/*      */     public BaseColumnFilter(Pointer p)
/*      */     {
/* 1123 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void filter(@Cast({"const uchar**"}) PointerPointer paramPointerPointer, @Cast({"uchar*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     public native void reset();
/*      */ 
/*      */     public native int ksize();
/*      */ 
/*      */     public native BaseColumnFilter ksize(int paramInt);
/*      */ 
/*      */     public native int anchor();
/*      */ 
/*      */     public native BaseColumnFilter anchor(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1121 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class BaseRowFilter extends Pointer
/*      */   {
/*      */     public BaseRowFilter()
/*      */     {
/*      */     }
/*      */ 
/*      */     public BaseRowFilter(Pointer p)
/*      */     {
/* 1111 */       super();
/*      */     }
/*      */ 
/*      */     @Name({"operator()"})
/*      */     public native void filter(@Cast({"uchar*"}) BytePointer paramBytePointer1, @Cast({"uchar*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int ksize();
/*      */ 
/*      */     public native BaseRowFilter ksize(int paramInt);
/*      */ 
/*      */     public native int anchor();
/*      */ 
/*      */     public native BaseRowFilter anchor(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1109 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvHistogram extends Pointer
/*      */   {
/*      */     public CvHistogram()
/*      */     {
/*  931 */       allocate(); zero(); } 
/*  932 */     public CvHistogram(int size) { allocateArray(size); zero(); } 
/*  933 */     public CvHistogram(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  938 */     public CvHistogram position(int position) { return (CvHistogram)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvHistogram create(int dims, int[] sizes, int type, float[][] ranges, int uniform)
/*      */     {
/*  943 */       CvHistogram h = opencv_imgproc.cvCreateHist(dims, sizes, type, ranges, uniform);
/*  944 */       if (h != null) {
/*  945 */         h.deallocator(new ReleaseDeallocator(h));
/*      */       }
/*  947 */       return h;
/*      */     }
/*      */ 
/*      */     public void release() {
/*  951 */       deallocate();
/*      */     }
/*      */ 
/*      */     @Cast({"CvHistType"})
/*      */     public native int type();
/*      */ 
/*      */     public native CvHistogram type(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvArr bins();
/*      */ 
/*      */     public native CvHistogram bins(opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     public native float thresh(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native CvHistogram thresh(int paramInt1, int paramInt2, float paramFloat);
/*      */ 
/*      */     @Cast({"float**"})
/*      */     public native PointerPointer thresh2();
/*      */ 
/*      */     public native CvHistogram thresh2(PointerPointer paramPointerPointer);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvMatND mat();
/*      */ 
/*      */     public native CvHistogram mat(opencv_core.CvMatND paramCvMatND);
/*      */ 
/*      */     static
/*      */     {
/*  930 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_imgproc.CvHistogram
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_imgproc.CvHistogram p)
/*      */       {
/*  954 */         super(); } 
/*  955 */       public void deallocate() { opencv_imgproc.cvReleaseHist(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class IplConvKernelFP extends Pointer
/*      */   {
/*      */     public IplConvKernelFP()
/*      */     {
/*  821 */       allocate(); zero(); } 
/*  822 */     public IplConvKernelFP(int size) { allocateArray(size); zero(); } 
/*  823 */     public IplConvKernelFP(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  828 */     public IplConvKernelFP position(int position) { return (IplConvKernelFP)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int nCols();
/*      */ 
/*      */     public native IplConvKernelFP nCols(int paramInt);
/*      */ 
/*      */     public native int nRows();
/*      */ 
/*      */     public native IplConvKernelFP nRows(int paramInt);
/*      */ 
/*      */     public native int anchorX();
/*      */ 
/*      */     public native IplConvKernelFP anchorX(int paramInt);
/*      */ 
/*      */     public native int anchorY();
/*      */ 
/*      */     public native IplConvKernelFP anchorY(int paramInt);
/*      */ 
/*      */     public native FloatPointer values();
/*      */ 
/*      */     public native IplConvKernelFP values(FloatPointer paramFloatPointer);
/*      */ 
/*      */     static
/*      */     {
/*  820 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class IplConvKernel extends Pointer
/*      */   {
/*      */     public IplConvKernel()
/*      */     {
/*  783 */       allocate(); zero(); } 
/*  784 */     public IplConvKernel(int size) { allocateArray(size); zero(); } 
/*  785 */     public IplConvKernel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  790 */     public IplConvKernel position(int position) { return (IplConvKernel)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static IplConvKernel create(int cols, int rows, int anchor_x, int anchor_y, int shape, int[] values)
/*      */     {
/*  795 */       IplConvKernel p = opencv_imgproc.cvCreateStructuringElementEx(cols, rows, anchor_x, anchor_y, shape, values);
/*      */ 
/*  797 */       if (p != null) {
/*  798 */         p.deallocator(new ReleaseDeallocator(p));
/*      */       }
/*  800 */       return p;
/*      */     }
/*      */ 
/*      */     public void release() {
/*  804 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int nCols();
/*      */ 
/*      */     public native IplConvKernel nCols(int paramInt);
/*      */ 
/*      */     public native int nRows();
/*      */ 
/*      */     public native IplConvKernel nRows(int paramInt);
/*      */ 
/*      */     public native int anchorX();
/*      */ 
/*      */     public native IplConvKernel anchorX(int paramInt);
/*      */ 
/*      */     public native int anchorY();
/*      */ 
/*      */     public native IplConvKernel anchorY(int paramInt);
/*      */ 
/*      */     public native IntPointer values();
/*      */ 
/*      */     public native IplConvKernel values(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int nShiftR();
/*      */ 
/*      */     public native IplConvKernel nShiftR(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  782 */       Loader.load();
/*      */     }
/*      */ 
/*      */     static class ReleaseDeallocator extends opencv_imgproc.IplConvKernel
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_imgproc.IplConvKernel p)
/*      */       {
/*  807 */         super(); } 
/*  808 */       public void deallocate() { opencv_imgproc.cvReleaseStructuringElement(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvFeatureTree extends Pointer
/*      */   {
/*      */     public CvFeatureTree()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFeatureTree(Pointer p)
/*      */     {
/*  703 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  701 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvConvexityDefect extends Pointer
/*      */   {
/*      */     public CvConvexityDefect()
/*      */     {
/*  633 */       allocate(); } 
/*  634 */     public CvConvexityDefect(int size) { allocateArray(size); } 
/*  635 */     public CvConvexityDefect(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  640 */     public CvConvexityDefect position(int position) { return (CvConvexityDefect)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvPoint start();
/*      */ 
/*      */     public native CvConvexityDefect start(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native opencv_core.CvPoint end();
/*      */ 
/*      */     public native CvConvexityDefect end(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native opencv_core.CvPoint depth_point();
/*      */ 
/*      */     public native CvConvexityDefect depth_point(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native float depth();
/*      */ 
/*      */     public native CvConvexityDefect depth(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  632 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSubdiv2D extends opencv_core.CvGraph
/*      */   {
/*      */     public CvSubdiv2D()
/*      */     {
/*  579 */       allocate(); } 
/*  580 */     public CvSubdiv2D(int size) { allocateArray(size); } 
/*  581 */     public CvSubdiv2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  586 */     public CvSubdiv2D position(int position) { return (CvSubdiv2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int quad_edges();
/*      */ 
/*      */     public native CvSubdiv2D quad_edges(int paramInt);
/*      */ 
/*      */     public native int is_geometry_valid();
/*      */ 
/*      */     public native CvSubdiv2D is_geometry_valid(int paramInt);
/*      */ 
/*      */     @Cast({"CvSubdiv2DEdge"})
/*      */     public native long recent_edge();
/*      */ 
/*      */     public native CvSubdiv2D recent_edge(long paramLong);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f topleft();
/*      */ 
/*      */     public native CvSubdiv2D topleft(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f bottomright();
/*      */ 
/*      */     public native CvSubdiv2D bottomright(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     static
/*      */     {
/*  578 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSubdiv2DPoint extends Pointer
/*      */   {
/*      */     public CvSubdiv2DPoint()
/*      */     {
/*  561 */       allocate(); } 
/*  562 */     public CvSubdiv2DPoint(int size) { allocateArray(size); } 
/*  563 */     public CvSubdiv2DPoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  568 */     public CvSubdiv2DPoint position(int position) { return (CvSubdiv2DPoint)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvSubdiv2DPoint flags(int paramInt);
/*      */ 
/*      */     @Cast({"CvSubdiv2DEdge"})
/*      */     public native long first();
/*      */ 
/*      */     public native CvSubdiv2DPoint first(long paramLong);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f pt();
/*      */ 
/*      */     public native CvSubdiv2DPoint pt(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native CvSubdiv2DPoint id(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  560 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvQuadEdge2D extends Pointer
/*      */   {
/*      */     public CvQuadEdge2D()
/*      */     {
/*  520 */       allocate(); } 
/*  521 */     public CvQuadEdge2D(int size) { allocateArray(size); } 
/*  522 */     public CvQuadEdge2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  527 */     public CvQuadEdge2D position(int position) { return (CvQuadEdge2D)super.position(position); } 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvQuadEdge2D flags(int paramInt);
/*      */ 
/*      */     public native opencv_imgproc.CvSubdiv2DPoint pt(int paramInt);
/*      */ 
/*      */     public native CvQuadEdge2D pt(int paramInt, opencv_imgproc.CvSubdiv2DPoint paramCvSubdiv2DPoint);
/*      */ 
/*      */     @Cast({"CvSubdiv2DEdge"})
/*      */     public native long next(int paramInt);
/*      */ 
/*      */     public native CvQuadEdge2D next(int paramInt, long paramLong);
/*      */ 
/*  535 */     @Cast({"CvSubdiv2DEdge"})
/*      */     public long CV_SUBDIV2D_NEXT_EDGE(@Cast({"CvSubdiv2DEdge"}) long edge) { return next((int)edge & 0x3); } 
/*      */     @Cast({"CvSubdiv2DEdge"})
/*      */     public long cvSubdiv2DNextEdge(@Cast({"CvSubdiv2DEdge"}) long edge) {
/*  538 */       return CV_SUBDIV2D_NEXT_EDGE(edge);
/*      */     }
/*  541 */     @Cast({"CvSubdiv2DEdge"})
/*      */     public long cvSubdiv2DGetEdge(@Cast({"CvSubdiv2DEdge"}) long edge, @Cast({"CvNextEdgeType"}) int type) { edge = next((int)edge + type & 0x3);
/*  542 */       return (edge & 0xFFFFFFFC) + (edge + (type >> 4) & 0x3); } 
/*      */     @Cast({"CvSubdiv2DEdge"})
/*      */     public static long cvSubdiv2DRotateEdge(@Cast({"CvSubdiv2DEdge"}) long edge, int rotate) {
/*  545 */       return (edge & 0xFFFFFFFC) + (edge + rotate & 0x3);
/*      */     }
/*      */     public opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeOrg(@Cast({"CvSubdiv2DEdge"}) long edge) {
/*  548 */       return pt((int)edge & 0x3);
/*      */     }
/*      */     public opencv_imgproc.CvSubdiv2DPoint cvSubdiv2DEdgeDst(@Cast({"CvSubdiv2DEdge"}) long edge) {
/*  551 */       return pt((int)edge + 2 & 0x3);
/*      */     }
/*  554 */     @Cast({"CvSubdiv2DEdge"})
/*      */     public static long cvSubdiv2DSymEdge(@Cast({"CvSubdiv2DEdge"}) long edge) { return edge ^ 0x2; }
/*      */ 
/*      */ 
/*      */     static
/*      */     {
/*  519 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSubdiv2DEdge extends SizeTPointer
/*      */   {
/*      */     public CvSubdiv2DEdge()
/*      */     {
/*  511 */       super(); } 
/*  512 */     public CvSubdiv2DEdge(int size) { super(); } 
/*  513 */     public CvSubdiv2DEdge(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     static
/*      */     {
/*  510 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvChainPtReader extends opencv_core.CvSeqReader
/*      */   {
/*      */     public CvChainPtReader()
/*      */     {
/*  491 */       allocate(); } 
/*  492 */     public CvChainPtReader(int size) { allocateArray(size); } 
/*  493 */     public CvChainPtReader(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  498 */     public CvChainPtReader position(int position) { return (CvChainPtReader)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native byte code();
/*      */ 
/*      */     public native CvChainPtReader code(byte paramByte);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint pt();
/*      */ 
/*      */     public native CvChainPtReader pt(opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     public native byte deltas(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native CvChainPtReader deltas(int paramInt1, int paramInt2, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/*  490 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvContourScanner extends Pointer
/*      */   {
/*      */     public CvContourScanner()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvContourScanner(Pointer p)
/*      */     {
/*  486 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  484 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvDistanceFunction extends FunctionPointer
/*      */   {
/*      */     public CvDistanceFunction(Pointer p)
/*      */     {
/*  463 */       super(); } 
/*  464 */     protected CvDistanceFunction() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native float call(@Const FloatPointer paramFloatPointer1, @Const FloatPointer paramFloatPointer2, Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/*  462 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvHuMoments extends Pointer
/*      */   {
/*      */     public CvHuMoments()
/*      */     {
/*  433 */       allocate(); } 
/*  434 */     public CvHuMoments(int size) { allocateArray(size); } 
/*  435 */     public CvHuMoments(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  440 */     public CvHuMoments position(int position) { return (CvHuMoments)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native double hu1();
/*      */ 
/*      */     public native CvHuMoments hu1(double paramDouble);
/*      */ 
/*      */     public native double hu2();
/*      */ 
/*      */     public native CvHuMoments hu2(double paramDouble);
/*      */ 
/*      */     public native double hu3();
/*      */ 
/*      */     public native CvHuMoments hu3(double paramDouble);
/*      */ 
/*      */     public native double hu4();
/*      */ 
/*      */     public native CvHuMoments hu4(double paramDouble);
/*      */ 
/*      */     public native double hu5();
/*      */ 
/*      */     public native CvHuMoments hu5(double paramDouble);
/*      */ 
/*      */     public native double hu6();
/*      */ 
/*      */     public native CvHuMoments hu6(double paramDouble);
/*      */ 
/*      */     public native double hu7();
/*      */ 
/*      */     public native CvHuMoments hu7(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  432 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMoments extends Pointer
/*      */   {
/*      */     public CvMoments()
/*      */     {
/*  391 */       allocate(); } 
/*  392 */     public CvMoments(int size) { allocateArray(size); } 
/*  393 */     public CvMoments(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  398 */     public CvMoments position(int position) { return (CvMoments)super.position(position); }
/*      */ 
/*      */     public static ThreadLocal<CvMoments> createThreadLocal()
/*      */     {
/*  402 */       return new ThreadLocal() {
/*      */         protected opencv_imgproc.CvMoments initialValue() {
/*  404 */           return new opencv_imgproc.CvMoments();
/*      */         }
/*      */       };
/*      */     }
/*      */ 
/*      */     public native double m00();
/*      */ 
/*      */     public native CvMoments m00(double paramDouble);
/*      */ 
/*      */     public native double m10();
/*      */ 
/*      */     public native CvMoments m10(double paramDouble);
/*      */ 
/*      */     public native double m01();
/*      */ 
/*      */     public native CvMoments m01(double paramDouble);
/*      */ 
/*      */     public native double m20();
/*      */ 
/*      */     public native CvMoments m20(double paramDouble);
/*      */ 
/*      */     public native double m11();
/*      */ 
/*      */     public native CvMoments m11(double paramDouble);
/*      */ 
/*      */     public native double m02();
/*      */ 
/*      */     public native CvMoments m02(double paramDouble);
/*      */ 
/*      */     public native double m30();
/*      */ 
/*      */     public native CvMoments m30(double paramDouble);
/*      */ 
/*      */     public native double m21();
/*      */ 
/*      */     public native CvMoments m21(double paramDouble);
/*      */ 
/*      */     public native double m12();
/*      */ 
/*      */     public native CvMoments m12(double paramDouble);
/*      */ 
/*      */     public native double m03();
/*      */ 
/*      */     public native CvMoments m03(double paramDouble);
/*      */ 
/*      */     public native double mu20();
/*      */ 
/*      */     public native CvMoments mu20(double paramDouble);
/*      */ 
/*      */     public native double mu11();
/*      */ 
/*      */     public native CvMoments mu11(double paramDouble);
/*      */ 
/*      */     public native double mu02();
/*      */ 
/*      */     public native CvMoments mu02(double paramDouble);
/*      */ 
/*      */     public native double mu30();
/*      */ 
/*      */     public native CvMoments mu30(double paramDouble);
/*      */ 
/*      */     public native double mu21();
/*      */ 
/*      */     public native CvMoments mu21(double paramDouble);
/*      */ 
/*      */     public native double mu12();
/*      */ 
/*      */     public native CvMoments mu12(double paramDouble);
/*      */ 
/*      */     public native double mu03();
/*      */ 
/*      */     public native CvMoments mu03(double paramDouble);
/*      */ 
/*      */     public native double inv_sqrt_m00();
/*      */ 
/*      */     public native CvMoments inv_sqrt_m00(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  390 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvConnectedComp extends Pointer
/*      */   {
/*      */     public CvConnectedComp()
/*      */     {
/*   95 */       allocate(); } 
/*   96 */     public CvConnectedComp(int size) { allocateArray(size); } 
/*   97 */     public CvConnectedComp(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  102 */     public CvConnectedComp position(int position) { return (CvConnectedComp)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native double area();
/*      */ 
/*      */     public native CvConnectedComp area(double paramDouble);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvScalar value();
/*      */ 
/*      */     public native CvConnectedComp value(opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvRect rect();
/*      */ 
/*      */     public native CvConnectedComp rect(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native opencv_core.CvSeq contour();
/*      */ 
/*      */     public native CvConnectedComp contour(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     static
/*      */     {
/*   94 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_imgproc
 * JD-Core Version:    0.6.2
 */