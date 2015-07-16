/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.LongPointer;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.Pointer.Deallocator;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.ShortPointer;
/*      */ import com.googlecode.javacpp.SizeTPointer;
/*      */ import com.googlecode.javacpp.annotation.Adapter;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.Convention;
/*      */ import com.googlecode.javacpp.annotation.Index;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.MemberSetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.StdVector;
/*      */ import com.googlecode.javacpp.annotation.ValueGetter;
/*      */ import com.googlecode.javacpp.annotation.ValueSetter;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.color.ColorSpace;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.ColorModel;
/*      */ import java.awt.image.ComponentColorModel;
/*      */ import java.awt.image.ComponentSampleModel;
/*      */ import java.awt.image.DataBuffer;
/*      */ import java.awt.image.DataBufferByte;
/*      */ import java.awt.image.DataBufferDouble;
/*      */ import java.awt.image.DataBufferFloat;
/*      */ import java.awt.image.DataBufferInt;
/*      */ import java.awt.image.DataBufferShort;
/*      */ import java.awt.image.DataBufferUShort;
/*      */ import java.awt.image.MultiPixelPackedSampleModel;
/*      */ import java.awt.image.Raster;
/*      */ import java.awt.image.SampleModel;
/*      */ import java.awt.image.SinglePixelPackedSampleModel;
/*      */ import java.awt.image.WritableRaster;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ 
/*      */ @Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/core/core.hpp>", "opencv_adapters.h"}, link={"opencv_core@.2.4"}, preload={"tbb"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, define={"_WIN32_WINNT 0x0502"}, includepath={"C:/opencv/build/include/"}, link={"opencv_core248"}, preload={"msvcr100", "msvcp100"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86"}, linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86_64"}, linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"})})
/*      */ public class opencv_core
/*      */ {
/*      */   public static final int CV_VERSION_EPOCH = 2;
/*      */   public static final int CV_VERSION_MAJOR = 4;
/*      */   public static final int CV_VERSION_MINOR = 8;
/*      */   public static final int CV_VERSION_REVISION = 0;
/*      */   public static final int CV_MAJOR_VERSION = 2;
/*      */   public static final int CV_MINOR_VERSION = 4;
/*      */   public static final int CV_SUBMINOR_VERSION = 8;
/*      */   public static final String CV_VERSION = "2.4.8.0";
/*      */   public static final int CV_StsOk = 0;
/*      */   public static final int CV_StsBackTrace = -1;
/*      */   public static final int CV_StsError = -2;
/*      */   public static final int CV_StsInternal = -3;
/*      */   public static final int CV_StsNoMem = -4;
/*      */   public static final int CV_StsBadArg = -5;
/*      */   public static final int CV_StsBadFunc = -6;
/*      */   public static final int CV_StsNoConv = -7;
/*      */   public static final int CV_StsAutoTrace = -8;
/*      */   public static final int CV_HeaderIsNull = -9;
/*      */   public static final int CV_BadImageSize = -10;
/*      */   public static final int CV_BadOffset = -11;
/*      */   public static final int CV_BadDataPtr = -12;
/*      */   public static final int CV_BadStep = -13;
/*      */   public static final int CV_BadModelOrChSeq = -14;
/*      */   public static final int CV_BadNumChannels = -15;
/*      */   public static final int CV_BadNumChannel1U = -16;
/*      */   public static final int CV_BadDepth = -17;
/*      */   public static final int CV_BadAlphaChannel = -18;
/*      */   public static final int CV_BadOrder = -19;
/*      */   public static final int CV_BadOrigin = -20;
/*      */   public static final int CV_BadAlign = -21;
/*      */   public static final int CV_BadCallBack = -22;
/*      */   public static final int CV_BadTileSize = -23;
/*      */   public static final int CV_BadCOI = -24;
/*      */   public static final int CV_BadROISize = -25;
/*      */   public static final int CV_MaskIsTiled = -26;
/*      */   public static final int CV_StsNullPtr = -27;
/*      */   public static final int CV_StsVecLengthErr = -28;
/*      */   public static final int CV_StsFilterStructContentErr = -29;
/*      */   public static final int CV_StsKernelStructContentErr = -30;
/*      */   public static final int CV_StsFilterOffsetErr = -31;
/*      */   public static final int CV_StsBadSize = -201;
/*      */   public static final int CV_StsDivByZero = -202;
/*      */   public static final int CV_StsInplaceNotSupported = -203;
/*      */   public static final int CV_StsObjectNotFound = -204;
/*      */   public static final int CV_StsUnmatchedFormats = -205;
/*      */   public static final int CV_StsBadFlag = -206;
/*      */   public static final int CV_StsBadPoint = -207;
/*      */   public static final int CV_StsBadMask = -208;
/*      */   public static final int CV_StsUnmatchedSizes = -209;
/*      */   public static final int CV_StsUnsupportedFormat = -210;
/*      */   public static final int CV_StsOutOfRange = -211;
/*      */   public static final int CV_StsParseError = -212;
/*      */   public static final int CV_StsNotImplemented = -213;
/*      */   public static final int CV_StsBadMemBlock = -214;
/*      */   public static final int CV_StsAssert = -215;
/*      */   public static final int CV_GpuNotSupported = -216;
/*      */   public static final int CV_GpuApiCallError = -217;
/*      */   public static final int CV_OpenGlNotSupported = -218;
/*      */   public static final int CV_OpenGlApiCallError = -219;
/*      */   public static final int CV_OpenCLDoubleNotSupported = -220;
/*      */   public static final int CV_OpenCLInitError = -221;
/*      */   public static final int CV_OpenCLNoAMDBlasFft = -222;
/*      */   public static final long CV_RNG_COEFF = 4164903690L;
/*      */   public static final int IPL_DEPTH_SIGN = -2147483648;
/*      */   public static final int IPL_DEPTH_1U = 1;
/*      */   public static final int IPL_DEPTH_8U = 8;
/*      */   public static final int IPL_DEPTH_16U = 16;
/*      */   public static final int IPL_DEPTH_32F = 32;
/*      */   public static final int IPL_DEPTH_8S = -2147483640;
/*      */   public static final int IPL_DEPTH_16S = -2147483632;
/*      */   public static final int IPL_DEPTH_32S = -2147483616;
/*      */   public static final int IPL_DEPTH_64F = 64;
/*      */   public static final int IPL_DATA_ORDER_PIXEL = 0;
/*      */   public static final int IPL_DATA_ORDER_PLANE = 1;
/*      */   public static final int IPL_ORIGIN_TL = 0;
/*      */   public static final int IPL_ORIGIN_BL = 1;
/*      */   public static final int IPL_ALIGN_4BYTES = 4;
/*      */   public static final int IPL_ALIGN_8BYTES = 8;
/*      */   public static final int IPL_ALIGN_16BYTES = 16;
/*      */   public static final int IPL_ALIGN_32BYTES = 32;
/*      */   public static final int IPL_ALIGN_DWORD = 4;
/*      */   public static final int IPL_ALIGN_QWORD = 8;
/*      */   public static final int IPL_BORDER_CONSTANT = 0;
/*      */   public static final int IPL_BORDER_REPLICATE = 1;
/*      */   public static final int IPL_BORDER_REFLECT = 2;
/*      */   public static final int IPL_BORDER_WRAP = 3;
/*      */   public static final int IPL_IMAGE_HEADER = 1;
/*      */   public static final int IPL_IMAGE_DATA = 2;
/*      */   public static final int IPL_IMAGE_ROI = 4;
/*      */   public static final int IPL_BORDER_REFLECT_101 = 4;
/*      */   public static final int IPL_BORDER_TRANSPARENT = 5;
/* 1259 */   public static final int IPL_IMAGE_MAGIC_VAL = Loader.load() == null ? 0 : Loader.sizeof(IplImage.class);
/*      */   public static final String CV_TYPE_NAME_IMAGE = "opencv-image";
/*      */   public static final int CV_CN_MAX = 512;
/*      */   public static final int CV_CN_SHIFT = 3;
/*      */   public static final int CV_DEPTH_MAX = 8;
/*      */   public static final int CV_8U = 0;
/*      */   public static final int CV_8S = 1;
/*      */   public static final int CV_16U = 2;
/*      */   public static final int CV_16S = 3;
/*      */   public static final int CV_32S = 4;
/*      */   public static final int CV_32F = 5;
/*      */   public static final int CV_64F = 6;
/*      */   public static final int CV_USRTYPE1 = 7;
/*      */   public static final int CV_MAT_DEPTH_MASK = 7;
/* 1299 */   public static final int CV_8UC1 = CV_MAKETYPE(0, 1);
/* 1300 */   public static final int CV_8UC2 = CV_MAKETYPE(0, 2);
/* 1301 */   public static final int CV_8UC3 = CV_MAKETYPE(0, 3);
/* 1302 */   public static final int CV_8UC4 = CV_MAKETYPE(0, 4);
/*      */ 
/* 1304 */   public static final int CV_8SC1 = CV_MAKETYPE(1, 1);
/* 1305 */   public static final int CV_8SC2 = CV_MAKETYPE(1, 2);
/* 1306 */   public static final int CV_8SC3 = CV_MAKETYPE(1, 3);
/* 1307 */   public static final int CV_8SC4 = CV_MAKETYPE(1, 4);
/*      */ 
/* 1309 */   public static final int CV_16UC1 = CV_MAKETYPE(2, 1);
/* 1310 */   public static final int CV_16UC2 = CV_MAKETYPE(2, 2);
/* 1311 */   public static final int CV_16UC3 = CV_MAKETYPE(2, 3);
/* 1312 */   public static final int CV_16UC4 = CV_MAKETYPE(2, 4);
/*      */ 
/* 1314 */   public static final int CV_16SC1 = CV_MAKETYPE(3, 1);
/* 1315 */   public static final int CV_16SC2 = CV_MAKETYPE(3, 2);
/* 1316 */   public static final int CV_16SC3 = CV_MAKETYPE(3, 3);
/* 1317 */   public static final int CV_16SC4 = CV_MAKETYPE(3, 4);
/*      */ 
/* 1319 */   public static final int CV_32SC1 = CV_MAKETYPE(4, 1);
/* 1320 */   public static final int CV_32SC2 = CV_MAKETYPE(4, 2);
/* 1321 */   public static final int CV_32SC3 = CV_MAKETYPE(4, 3);
/* 1322 */   public static final int CV_32SC4 = CV_MAKETYPE(4, 4);
/*      */ 
/* 1324 */   public static final int CV_32FC1 = CV_MAKETYPE(5, 1);
/* 1325 */   public static final int CV_32FC2 = CV_MAKETYPE(5, 2);
/* 1326 */   public static final int CV_32FC3 = CV_MAKETYPE(5, 3);
/* 1327 */   public static final int CV_32FC4 = CV_MAKETYPE(5, 4);
/*      */ 
/* 1329 */   public static final int CV_64FC1 = CV_MAKETYPE(6, 1);
/* 1330 */   public static final int CV_64FC2 = CV_MAKETYPE(6, 2);
/* 1331 */   public static final int CV_64FC3 = CV_MAKETYPE(6, 3);
/* 1332 */   public static final int CV_64FC4 = CV_MAKETYPE(6, 4);
/*      */   public static final int CV_AUTO_STEP = 2147483647;
/* 1335 */   public static final CvSlice CV_WHOLE_ARR = Loader.load() == null ? null : cvSlice(0, 1073741823);
/*      */   public static final int CV_MAT_CN_MASK = 4088;
/*      */   public static final int CV_MAT_TYPE_MASK = 4095;
/*      */   public static final int CV_MAT_CONT_FLAG_SHIFT = 14;
/*      */   public static final int CV_MAT_CONT_FLAG = 16384;
/*      */   public static final int CV_MAT_TEMP_FLAG_SHIFT = 15;
/*      */   public static final int CV_MAT_TEMP_FLAG = 32768;
/*      */   public static final int CV_MAGIC_MASK = -65536;
/*      */   public static final int CV_MAT_MAGIC_VAL = 1111621632;
/*      */   public static final String CV_TYPE_NAME_MAT = "opencv-matrix";
/*      */   public static final int CV_MATND_MAGIC_VAL = 1111687168;
/*      */   public static final String CV_TYPE_NAME_MATND = "opencv-nd-matrix";
/*      */   public static final int CV_MAX_DIM = 32;
/*      */   public static final int CV_MAX_DIM_HEAP = 1024;
/*      */   public static final int CV_SPARSE_MAT_MAGIC_VAL = 1111752704;
/*      */   public static final String CV_TYPE_NAME_SPARSE_MAT = "opencv-sparse-matrix";
/*      */   public static final int CV_TERMCRIT_ITER = 1;
/*      */   public static final int CV_TERMCRIT_NUMBER = 1;
/*      */   public static final int CV_TERMCRIT_EPS = 2;
/*      */   public static final int CV_WHOLE_SEQ_END_INDEX = 1073741823;
/* 2717 */   public static final CvSlice CV_WHOLE_SEQ = Loader.load() == null ? null : cvSlice(0, 1073741823);
/*      */   public static final int CV_STORAGE_MAGIC_VAL = 1116274688;
/*      */   public static final String CV_TYPE_NAME_SEQ = "opencv-sequence";
/*      */   public static final String CV_TYPE_NAME_SEQ_TREE = "opencv-sequence-tree";
/*      */   public static final int CV_SET_ELEM_IDX_MASK = 67108863;
/*      */   public static final int CV_SET_ELEM_FREE_FLAG = 128;
/*      */   public static final String CV_TYPE_NAME_GRAPH = "opencv-graph";
/*      */   public static final int CV_SEQ_MAGIC_VAL = 1117323264;
/*      */   public static final int CV_SET_MAGIC_VAL = 1117257728;
/*      */   public static final int CV_SEQ_ELTYPE_BITS = 12;
/*      */   public static final int CV_SEQ_ELTYPE_MASK = 4095;
/* 3102 */   public static final int CV_SEQ_ELTYPE_POINT = CV_32SC2;
/* 3103 */   public static final int CV_SEQ_ELTYPE_CODE = CV_8UC1;
/*      */   public static final int CV_SEQ_ELTYPE_GENERIC = 0;
/*      */   public static final int CV_SEQ_ELTYPE_PTR = 7;
/*      */   public static final int CV_SEQ_ELTYPE_PPOINT = 7;
/* 3107 */   public static final int CV_SEQ_ELTYPE_INDEX = CV_32SC1;
/*      */   public static final int CV_SEQ_ELTYPE_GRAPH_EDGE = 0;
/*      */   public static final int CV_SEQ_ELTYPE_GRAPH_VERTEX = 0;
/*      */   public static final int CV_SEQ_ELTYPE_TRIAN_ATR = 0;
/*      */   public static final int CV_SEQ_ELTYPE_CONNECTED_COMP = 0;
/* 3112 */   public static final int CV_SEQ_ELTYPE_POINT3D = CV_32FC3;
/*      */   public static final int CV_SEQ_KIND_BITS = 2;
/*      */   public static final int CV_SEQ_KIND_MASK = 12288;
/*      */   public static final int CV_SEQ_KIND_GENERIC = 0;
/*      */   public static final int CV_SEQ_KIND_CURVE = 4096;
/*      */   public static final int CV_SEQ_KIND_BIN_TREE = 8192;
/*      */   public static final int CV_SEQ_KIND_GRAPH = 4096;
/*      */   public static final int CV_SEQ_KIND_SUBDIV2D = 8192;
/*      */   public static final int CV_SEQ_FLAG_SHIFT = 14;
/*      */   public static final int CV_SEQ_FLAG_CLOSED = 16384;
/*      */   public static final int CV_SEQ_FLAG_SIMPLE = 0;
/*      */   public static final int CV_SEQ_FLAG_CONVEX = 0;
/*      */   public static final int CV_SEQ_FLAG_HOLE = 32768;
/*      */   public static final int CV_GRAPH_FLAG_ORIENTED = 16384;
/*      */   public static final int CV_GRAPH = 4096;
/*      */   public static final int CV_ORIENTED_GRAPH = 20480;
/* 3141 */   public static final int CV_SEQ_POINT_SET = 0x0 | CV_SEQ_ELTYPE_POINT;
/* 3142 */   public static final int CV_SEQ_POINT3D_SET = 0x0 | CV_SEQ_ELTYPE_POINT3D;
/* 3143 */   public static final int CV_SEQ_POLYLINE = 0x1000 | CV_SEQ_ELTYPE_POINT;
/* 3144 */   public static final int CV_SEQ_POLYGON = 0x4000 | CV_SEQ_POLYLINE;
/* 3145 */   public static final int CV_SEQ_CONTOUR = CV_SEQ_POLYGON;
/* 3146 */   public static final int CV_SEQ_SIMPLE_POLYGON = 0x0 | CV_SEQ_POLYGON;
/*      */ 
/* 3149 */   public static final int CV_SEQ_CHAIN = 0x1000 | CV_SEQ_ELTYPE_CODE;
/* 3150 */   public static final int CV_SEQ_CHAIN_CONTOUR = 0x4000 | CV_SEQ_CHAIN;
/*      */   public static final int CV_SEQ_POLYGON_TREE = 8192;
/*      */   public static final int CV_SEQ_CONNECTED_COMP = 0;
/* 3159 */   public static final int CV_SEQ_INDEX = 0x0 | CV_SEQ_ELTYPE_INDEX;
/*      */   public static final int CV_STORAGE_READ = 0;
/*      */   public static final int CV_STORAGE_WRITE = 1;
/*      */   public static final int CV_STORAGE_WRITE_TEXT = 1;
/*      */   public static final int CV_STORAGE_WRITE_BINARY = 1;
/*      */   public static final int CV_STORAGE_APPEND = 2;
/*      */   public static final int CV_STORAGE_MEMORY = 4;
/*      */   public static final int CV_STORAGE_FORMAT_MASK = 56;
/*      */   public static final int CV_STORAGE_FORMAT_AUTO = 0;
/*      */   public static final int CV_STORAGE_FORMAT_XML = 8;
/*      */   public static final int CV_STORAGE_FORMAT_YAML = 16;
/* 3341 */   public static final CvAttrList CV_ATTR_LIST_EMPTY = new CvAttrList();
/*      */   public static final int CV_NODE_NONE = 0;
/*      */   public static final int CV_NODE_INT = 1;
/*      */   public static final int CV_NODE_INTEGER = 1;
/*      */   public static final int CV_NODE_REAL = 2;
/*      */   public static final int CV_NODE_FLOAT = 2;
/*      */   public static final int CV_NODE_STR = 3;
/*      */   public static final int CV_NODE_STRING = 3;
/*      */   public static final int CV_NODE_REF = 4;
/*      */   public static final int CV_NODE_SEQ = 5;
/*      */   public static final int CV_NODE_MAP = 6;
/*      */   public static final int CV_NODE_TYPE_MASK = 7;
/*      */   public static final int CV_NODE_FLOW = 8;
/*      */   public static final int CV_NODE_USER = 16;
/*      */   public static final int CV_NODE_EMPTY = 32;
/*      */   public static final int CV_NODE_NAMED = 64;
/*      */   public static final int CV_NODE_SEQ_SIMPLE = 256;
/*      */   public static final int CV_AUTOSTEP = 2147483647;
/*      */   public static final int CV_MAX_ARR = 10;
/*      */   public static final int CV_NO_DEPTH_CHECK = 1;
/*      */   public static final int CV_NO_CN_CHECK = 2;
/*      */   public static final int CV_NO_SIZE_CHECK = 4;
/*      */   public static final int CV_CMP_EQ = 0;
/*      */   public static final int CV_CMP_GT = 1;
/*      */   public static final int CV_CMP_GE = 2;
/*      */   public static final int CV_CMP_LT = 3;
/*      */   public static final int CV_CMP_LE = 4;
/*      */   public static final int CV_CMP_NE = 5;
/*      */   public static final int CV_CHECK_RANGE = 1;
/*      */   public static final int CV_CHECK_QUIET = 2;
/*      */   public static final int CV_RAND_UNI = 0;
/*      */   public static final int CV_RAND_NORMAL = 1;
/*      */   public static final int CV_SORT_EVERY_ROW = 0;
/*      */   public static final int CV_SORT_EVERY_COLUMN = 1;
/*      */   public static final int CV_SORT_ASCENDING = 0;
/*      */   public static final int CV_SORT_DESCENDING = 16;
/*      */   public static final int CV_GEMM_A_T = 1;
/*      */   public static final int CV_GEMM_B_T = 2;
/*      */   public static final int CV_GEMM_C_T = 4;
/*      */   public static final int CV_SVD_MODIFY_A = 1;
/*      */   public static final int CV_SVD_U_T = 2;
/*      */   public static final int CV_SVD_V_T = 4;
/*      */   public static final int CV_LU = 0;
/*      */   public static final int CV_SVD = 1;
/*      */   public static final int CV_SVD_SYM = 2;
/*      */   public static final int CV_CHOLESKY = 3;
/*      */   public static final int CV_QR = 4;
/*      */   public static final int CV_LSQ = 8;
/*      */   public static final int CV_NORMAL = 16;
/*      */   public static final int CV_COVAR_SCRAMBLED = 0;
/*      */   public static final int CV_COVAR_NORMAL = 1;
/*      */   public static final int CV_COVAR_USE_AVG = 2;
/*      */   public static final int CV_COVAR_SCALE = 4;
/*      */   public static final int CV_COVAR_ROWS = 8;
/*      */   public static final int CV_COVAR_COLS = 16;
/*      */   public static final int CV_PCA_DATA_AS_ROW = 0;
/*      */   public static final int CV_PCA_DATA_AS_COL = 1;
/*      */   public static final int CV_PCA_USE_AVG = 2;
/*      */   public static final int CV_C = 1;
/*      */   public static final int CV_L1 = 2;
/*      */   public static final int CV_L2 = 4;
/*      */   public static final int CV_NORM_MASK = 7;
/*      */   public static final int CV_RELATIVE = 8;
/*      */   public static final int CV_DIFF = 16;
/*      */   public static final int CV_MINMAX = 32;
/*      */   public static final int CV_DIFF_C = 17;
/*      */   public static final int CV_DIFF_L1 = 18;
/*      */   public static final int CV_DIFF_L2 = 20;
/*      */   public static final int CV_RELATIVE_C = 9;
/*      */   public static final int CV_RELATIVE_L1 = 10;
/*      */   public static final int CV_RELATIVE_L2 = 12;
/*      */   public static final int CV_REDUCE_SUM = 0;
/*      */   public static final int CV_REDUCE_AVG = 1;
/*      */   public static final int CV_REDUCE_MAX = 2;
/*      */   public static final int CV_REDUCE_MIN = 3;
/*      */   public static final int CV_DXT_FORWARD = 0;
/*      */   public static final int CV_DXT_INVERSE = 1;
/*      */   public static final int CV_DXT_SCALE = 2;
/*      */   public static final int CV_DXT_INV_SCALE = 3;
/*      */   public static final int CV_DXT_INVERSE_SCALE = 3;
/*      */   public static final int CV_DXT_ROWS = 4;
/*      */   public static final int CV_DXT_MUL_CONJ = 8;
/*      */   public static final int CV_FRONT = 1;
/*      */   public static final int CV_BACK = 0;
/*      */   public static final int CV_GRAPH_VERTEX = 1;
/*      */   public static final int CV_GRAPH_TREE_EDGE = 2;
/*      */   public static final int CV_GRAPH_BACK_EDGE = 4;
/*      */   public static final int CV_GRAPH_FORWARD_EDGE = 8;
/*      */   public static final int CV_GRAPH_CROSS_EDGE = 16;
/*      */   public static final int CV_GRAPH_ANY_EDGE = 30;
/*      */   public static final int CV_GRAPH_NEW_TREE = 32;
/*      */   public static final int CV_GRAPH_BACKTRACKING = 64;
/*      */   public static final int CV_GRAPH_OVER = -1;
/*      */   public static final int CV_GRAPH_ALL_ITEMS = -1;
/*      */   public static final int CV_GRAPH_ITEM_VISITED_FLAG = 1073741824;
/*      */   public static final int CV_GRAPH_SEARCH_TREE_NODE_FLAG = 536870912;
/*      */   public static final int CV_GRAPH_FORWARD_EDGE_FLAG = 268435456;
/*      */   public static final int CV_FILLED = -1;
/*      */   public static final int CV_AA = 16;
/*      */   public static final int CV_FONT_HERSHEY_SIMPLEX = 0;
/*      */   public static final int CV_FONT_HERSHEY_PLAIN = 1;
/*      */   public static final int CV_FONT_HERSHEY_DUPLEX = 2;
/*      */   public static final int CV_FONT_HERSHEY_COMPLEX = 3;
/*      */   public static final int CV_FONT_HERSHEY_TRIPLEX = 4;
/*      */   public static final int CV_FONT_HERSHEY_COMPLEX_SMALL = 5;
/*      */   public static final int CV_FONT_HERSHEY_SCRIPT_SIMPLEX = 6;
/*      */   public static final int CV_FONT_HERSHEY_SCRIPT_COMPLEX = 7;
/*      */   public static final int CV_FONT_ITALIC = 16;
/*      */   public static final int CV_FONT_VECTOR0 = 0;
/*      */   public static final int CV_KMEANS_USE_INITIAL_LABELS = 1;
/*      */   public static final int CV_CPU_NONE = 0;
/*      */   public static final int CV_CPU_MMX = 1;
/*      */   public static final int CV_CPU_SSE = 2;
/*      */   public static final int CV_CPU_SSE2 = 3;
/*      */   public static final int CV_CPU_SSE3 = 4;
/*      */   public static final int CV_CPU_SSSE3 = 5;
/*      */   public static final int CV_CPU_SSE4_1 = 6;
/*      */   public static final int CV_CPU_SSE4_2 = 7;
/*      */   public static final int CV_CPU_POPCNT = 8;
/*      */   public static final int CV_CPU_AVX = 10;
/*      */   public static final int CV_HARDWARE_MAX_FEATURE = 255;
/*      */   public static final int CV_ErrModeLeaf = 0;
/*      */   public static final int CV_ErrModeParent = 1;
/*      */   public static final int CV_ErrModeSilent = 2;
/*      */   public static final int NORM_INF = 1;
/*      */   public static final int NORM_L1 = 2;
/*      */   public static final int NORM_L2 = 4;
/*      */   public static final int NORM_L2SQR = 5;
/*      */   public static final int NORM_HAMMING = 6;
/*      */   public static final int NORM_HAMMING2 = 7;
/*      */   public static final int NORM_TYPE_MASK = 7;
/*      */   public static final int NORM_RELATIVE = 8;
/*      */   public static final int NORM_MINMAX = 32;
/*      */ 
/*      */   public static native void SetLibraryPath(String paramString);
/*      */ 
/*      */   public static CvRNG cvRNG()
/*      */   {
/*  354 */     return cvRNG(-1L);
/*      */   }
/*      */   public static CvRNG cvRNG(long seed) {
/*  357 */     return (CvRNG)new CvRNG().put(seed != 0L ? seed : -1L);
/*      */   }
/*      */   public static int cvRandInt(CvRNG rng) {
/*  360 */     long temp = rng.get();
/*  361 */     temp = (temp & 0xFFFFFFFF) * 4164903690L + (temp >> 32 & 0xFFFFFFFF);
/*  362 */     rng.put(temp);
/*  363 */     return (int)temp;
/*      */   }
/*      */   public static double cvRandReal(CvRNG rng) {
/*  366 */     return (cvRandInt(rng) & 0xFFFFFFFF) * 2.328306436538696E-010D;
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_IMAGE_HDR(CvArr img)
/*      */   {
/* 1263 */     return (img != null) && (new IplImage(img).nSize() == Loader.sizeof(IplImage.class));
/*      */   }
/*      */   public static boolean CV_IS_IMAGE(CvArr img) {
/* 1266 */     return (CV_IS_IMAGE_HDR(img)) && (new IplImage(img).imageData() != null);
/*      */   }
/*      */ 
/*      */   public static int CV_MAT_DEPTH(int flags)
/*      */   {
/* 1285 */     return flags & 0x7;
/*      */   }
/* 1287 */   public static int CV_MAKETYPE(int depth, int cn) { return CV_MAT_DEPTH(depth) + (cn - 1 << 3); } 
/* 1288 */   public static int CV_MAKE_TYPE(int depth, int cn) { return CV_MAKETYPE(depth, cn); } 
/*      */   public static int CV_8UC(int n) {
/* 1290 */     return CV_MAKETYPE(0, n); } 
/* 1291 */   public static int CV_8SC(int n) { return CV_MAKETYPE(1, n); } 
/* 1292 */   public static int CV_16UC(int n) { return CV_MAKETYPE(0, n); } 
/* 1293 */   public static int CV_16SC(int n) { return CV_MAKETYPE(3, n); } 
/* 1294 */   public static int CV_32SC(int n) { return CV_MAKETYPE(4, n); } 
/* 1295 */   public static int CV_32FC(int n) { return CV_MAKETYPE(5, n); } 
/* 1296 */   public static int CV_64FC(int n) { return CV_MAKETYPE(6, n); }
/*      */ 
/*      */ 
/*      */   public static int CV_MAT_CN(int flags)
/*      */   {
/* 1344 */     return ((flags & 0xFF8) >> 3) + 1; } 
/* 1345 */   public static int CV_MAT_TYPE(int flags) { return flags & 0xFFF; } 
/* 1346 */   public static boolean CV_IS_MAT_CONT(int flags) { return (flags & 0x4000) != 0; } 
/* 1347 */   public static boolean CV_IS_CONT_MAT(int flags) { return CV_IS_MAT_CONT(flags); } 
/* 1348 */   public static boolean CV_IS_TEMP_MAT(int flags) { return (flags & 0x8000) != 0; }
/*      */ 
/*      */ 
/*      */   public static boolean CV_IS_MAT_HDR(CvArr mat)
/*      */   {
/* 1772 */     CvMat m = new CvMat(mat);
/* 1773 */     return (mat != null) && ((m.raw_type() & 0xFFFF0000) == 1111621632) && (m.cols() > 0) && (m.rows() > 0);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_MAT_HDR_Z(CvArr mat) {
/* 1777 */     CvMat m = new CvMat(mat);
/* 1778 */     return (mat != null) && ((m.raw_type() & 0xFFFF0000) == 1111621632) && (m.cols() >= 0) && (m.rows() >= 0);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_MAT(CvArr mat) {
/* 1782 */     return (CV_IS_MAT_HDR(mat)) && (new CvMat(mat).data_ptr() != null);
/*      */   }
/*      */   public static boolean CV_IS_MASK_ARR(CvMat mat) {
/* 1785 */     return (mat.raw_type() & (0xFFF & (CV_8SC1 ^ 0xFFFFFFFF))) == 0;
/*      */   }
/*      */   public static boolean CV_ARE_TYPES_EQ(CvMat mat1, CvMat mat2) {
/* 1788 */     return ((mat1.raw_type() ^ mat2.raw_type()) & 0xFFF) == 0;
/*      */   }
/*      */   public static boolean CV_ARE_CNS_EQ(CvMat mat1, CvMat mat2) {
/* 1791 */     return ((mat1.raw_type() ^ mat2.raw_type()) & 0xFF8) == 0;
/*      */   }
/*      */   public static boolean CV_ARE_DEPTHS_EQ(CvMat mat1, CvMat mat2) {
/* 1794 */     return ((mat1.raw_type() ^ mat2.raw_type()) & 0x7) == 0;
/*      */   }
/*      */   public static boolean CV_ARE_SIZES_EQ(CvMat mat1, CvMat mat2) {
/* 1797 */     return (mat1.rows() == mat2.rows()) && (mat1.cols() == mat2.cols());
/*      */   }
/*      */   public static boolean CV_IS_MAT_CONST(CvMat mat) {
/* 1800 */     return (mat.rows() | mat.cols()) == 1;
/*      */   }
/*      */   public static int CV_ELEM_SIZE1(int type) {
/* 1803 */     return (Loader.sizeof(SizeTPointer.class) << 28 | 0x8442211) >> CV_MAT_DEPTH(type) * 4 & 0xF;
/*      */   }
/*      */   public static int CV_ELEM_SIZE(int type) {
/* 1806 */     return CV_MAT_CN(type) << (((Loader.sizeof(SizeTPointer.class) / 4 + 1) * 16384 | 0x3A50) >> CV_MAT_DEPTH(type) * 2 & 0x3);
/*      */   }
/*      */   public static int IPL2CV_DEPTH(int depth) {
/* 1809 */     return 1125516576 >> ((depth & 0xF0) >> 2) + ((depth & 0x80000000) != 0 ? 20 : 0) & 0xF;
/*      */   }
/*      */ 
/*      */   public static CvMat cvMat(int rows, int cols, int type, Pointer data)
/*      */   {
/* 1815 */     CvMat m = new CvMat();
/*      */ 
/* 1817 */     assert ((CV_MAT_DEPTH(type) >= 0) && (CV_MAT_DEPTH(type) <= 6));
/* 1818 */     type = CV_MAT_TYPE(type);
/* 1819 */     m.raw_type(0x42424000 | type);
/* 1820 */     m.cols(cols);
/* 1821 */     m.rows(rows);
/* 1822 */     m.step(cols * CV_ELEM_SIZE(type));
/* 1823 */     m.data_ptr(new BytePointer(data));
/* 1824 */     m.refcount(null);
/* 1825 */     m.hdr_refcount(0);
/*      */ 
/* 1827 */     return m;
/*      */   }
/*      */ 
/*      */   public static int cvIplDepth(int type) {
/* 1831 */     int depth = CV_MAT_DEPTH(type);
/* 1832 */     return CV_ELEM_SIZE1(depth) * 8 | ((depth == 1) || (depth == 3) || (depth == 4) ? -2147483648 : 0);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_MATND_HDR(CvArr mat)
/*      */   {
/* 1902 */     return (mat != null) && ((new CvMatND(mat).type() & 0xFFFF0000) == 1111687168);
/*      */   }
/*      */   public static boolean CV_IS_MATND(CvArr mat) {
/* 1905 */     return (CV_IS_MATND_HDR(mat)) && (new CvMatND(mat).data_ptr() != null);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_SPARSE_MAT_HDR(CvArr mat)
/*      */   {
/* 1960 */     return (mat != null) && ((new CvSparseMat(mat).type() & 0xFFFF0000) == 1111752704);
/*      */   }
/*      */   public static boolean CV_IS_SPARSE_MAT(CvArr mat) {
/* 1963 */     return CV_IS_SPARSE_MAT_HDR(mat);
/*      */   }
/*      */ 
/*      */   public static Pointer CV_NODE_VAL(CvSparseMat mat, CvSparseNode node)
/*      */   {
/* 2000 */     return new BytePointer(node).position(mat.valoffset());
/*      */   }
/*      */   public static IntPointer CV_NODE_IDX(CvSparseMat mat, CvSparseNode node) {
/* 2003 */     return new IntPointer(new BytePointer(node).position(mat.idxoffset()));
/*      */   }
/*      */ 
/*      */   public static CvRect cvRect(int x, int y, int width, int height)
/*      */   {
/* 2047 */     return new CvRect().x(x).y(y).width(width).height(height);
/*      */   }
/*      */   public static IplROI cvRectToROI(CvRect rect, int coi) {
/* 2050 */     IplROI roi = new IplROI();
/* 2051 */     roi.xOffset(rect.x());
/* 2052 */     roi.yOffset(rect.y());
/* 2053 */     roi.width(rect.width());
/* 2054 */     roi.height(rect.height());
/* 2055 */     roi.coi(coi);
/* 2056 */     return roi;
/*      */   }
/*      */   public static CvRect cvROIToRect(IplROI roi) {
/* 2059 */     return cvRect(roi.xOffset(), roi.yOffset(), roi.width(), roi.height());
/*      */   }
/*      */ 
/*      */   public static CvTermCriteria cvTermCriteria(int type, int max_iter, double epsilon)
/*      */   {
/* 2088 */     return new CvTermCriteria().type(type).max_iter(max_iter).epsilon(epsilon);
/*      */   }
/*      */ 
/*      */   public static CvPoint cvPoint(int x, int y)
/*      */   {
/* 2197 */     return new CvPoint().x(x).y(y);
/*      */   }
/*      */ 
/*      */   public static CvPoint2D32f cvPoint2D32f(double x, double y)
/*      */   {
/* 2282 */     return new CvPoint2D32f().x((float)x).y((float)y);
/*      */   }
/*      */   public static CvPoint2D32f cvPointTo32f(CvPoint point) {
/* 2285 */     return cvPoint2D32f(point.x(), point.y());
/*      */   }
/*      */   public static CvPoint cvPointFrom32f(CvPoint2D32f point) {
/* 2288 */     CvPoint ipt = new CvPoint();
/* 2289 */     ipt.x(Math.round(point.x()));
/* 2290 */     ipt.y(Math.round(point.y()));
/* 2291 */     return ipt;
/*      */   }
/*      */ 
/*      */   public static CvPoint3D32f cvPoint3D32f(double x, double y, double z)
/*      */   {
/* 2378 */     return new CvPoint3D32f().x((float)x).y((float)y).z((float)z);
/*      */   }
/*      */ 
/*      */   public static CvPoint2D64f cvPoint2D64f(double x, double y)
/*      */   {
/* 2463 */     return new CvPoint2D64f().x(x).y(y);
/*      */   }
/*      */ 
/*      */   public static CvPoint3D64f cvPoint3D64f(double x, double y, double z)
/*      */   {
/* 2550 */     return new CvPoint3D64f().x(x).y(y).z(z);
/*      */   }
/*      */ 
/*      */   public static CvSize cvSize(int width, int height)
/*      */   {
/* 2592 */     return new CvSize().width(width).height(height);
/*      */   }
/*      */ 
/*      */   public static CvSize2D32f cvSize2D32f(double width, double height)
/*      */   {
/* 2633 */     return new CvSize2D32f().width((float)width).height((float)height);
/*      */   }
/*      */ 
/*      */   public static CvSlice cvSlice(int start, int end)
/*      */   {
/* 2714 */     return new CvSlice().start_index(start).end_index(end);
/*      */   }
/*      */ 
/*      */   public static CvScalar cvScalar(double val0, double val1, double val2, double val3)
/*      */   {
/* 2801 */     return new CvScalar().val(0, val0).val(1, val1).val(2, val2).val(3, val3);
/*      */   }
/*      */   public static CvScalar cvRealScalar(double val0) {
/* 2804 */     return new CvScalar().val(0, val0).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);
/*      */   }
/*      */   public static CvScalar cvScalarAll(double val0123) {
/* 2807 */     return new CvScalar().val(0, val0123).val(1, val0123).val(2, val0123).val(3, val0123);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_STORAGE(CvArr storage)
/*      */   {
/* 2869 */     return (storage != null) && ((new CvMemStorage(storage).signature() & 0xFFFF0000) == 1116274688);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_SET_ELEM(Pointer ptr)
/*      */   {
/* 2987 */     return new CvSetElem(ptr).flags() >= 0;
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_SEQ(CvArr seq)
/*      */   {
/* 3162 */     return (seq != null) && ((new CvSeq(seq).flags() & 0xFFFF0000) == 1117323264);
/*      */   }
/*      */   public static boolean CV_IS_SET(CvArr set) {
/* 3165 */     return (set != null) && ((new CvSet(set).flags() & 0xFFFF0000) == 1117257728);
/*      */   }
/*      */   public static int CV_SEQ_ELTYPE(CvSeq seq) {
/* 3168 */     return seq.flags() & 0xFFF; } 
/* 3169 */   public static int CV_SEQ_KIND(CvSeq seq) { return seq.flags() & 0x3000; } 
/*      */   public static boolean CV_IS_SEQ_INDEX(CvSeq seq) {
/* 3171 */     return (CV_SEQ_ELTYPE(seq) == CV_SEQ_ELTYPE_INDEX) && (CV_SEQ_KIND(seq) == 0);
/*      */   }
/*      */   public static boolean CV_IS_SEQ_CURVE(CvSeq seq) {
/* 3174 */     return CV_SEQ_KIND(seq) == 4096; } 
/* 3175 */   public static boolean CV_IS_SEQ_CLOSED(CvSeq seq) { return (seq.flags() & 0x4000) != 0; } 
/* 3176 */   public static boolean CV_IS_SEQ_CONVEX(CvSeq seq) { return false; } 
/* 3177 */   public static boolean CV_IS_SEQ_HOLE(CvSeq seq) { return (seq.flags() & 0x8000) != 0; } 
/* 3178 */   public static boolean CV_IS_SEQ_SIMPLE(CvSeq seq) { return true; }
/*      */ 
/*      */   public static boolean CV_IS_SEQ_POINT_SET(CvSeq seq) {
/* 3181 */     return (CV_SEQ_ELTYPE(seq) == CV_32SC2) || (CV_SEQ_ELTYPE(seq) == CV_32FC2);
/*      */   }
/*      */   public static boolean CV_IS_SEQ_POINT_SUBSET(CvSeq seq) {
/* 3184 */     return (CV_IS_SEQ_INDEX(seq)) || (CV_SEQ_ELTYPE(seq) == 7);
/*      */   }
/*      */   public static boolean CV_IS_SEQ_POLYLINE(CvSeq seq) {
/* 3187 */     return (CV_SEQ_KIND(seq) == 4096) && (CV_IS_SEQ_POINT_SET(seq));
/*      */   }
/*      */   public static boolean CV_IS_SEQ_POLYGON(CvSeq seq) {
/* 3190 */     return (CV_IS_SEQ_POLYLINE(seq)) && (CV_IS_SEQ_CLOSED(seq));
/*      */   }
/*      */   public static boolean CV_IS_SEQ_CHAIN(CvSeq seq) {
/* 3193 */     return (CV_SEQ_KIND(seq) == 4096) && (seq.elem_size() == 1);
/*      */   }
/*      */   public static boolean CV_IS_SEQ_CONTOUR(CvSeq seq) {
/* 3196 */     return (CV_IS_SEQ_CLOSED(seq)) && ((CV_IS_SEQ_POLYLINE(seq)) || (CV_IS_SEQ_CHAIN(seq)));
/*      */   }
/*      */   public static boolean CV_IS_SEQ_CHAIN_CONTOUR(CvSeq seq) {
/* 3199 */     return (CV_IS_SEQ_CHAIN(seq)) && (CV_IS_SEQ_CLOSED(seq));
/*      */   }
/*      */   public static boolean CV_IS_SEQ_POLYGON_TREE(CvSeq seq) {
/* 3202 */     return (CV_SEQ_ELTYPE(seq) == 0) && (CV_SEQ_KIND(seq) == 8192);
/*      */   }
/*      */ 
/*      */   public static boolean CV_IS_GRAPH(CvSeq seq) {
/* 3206 */     return (CV_IS_SET(seq)) && (CV_SEQ_KIND(seq) == 4096);
/*      */   }
/*      */   public static boolean CV_IS_GRAPH_ORIENTED(CvSeq seq) {
/* 3209 */     return (seq.flags() & 0x4000) != 0;
/*      */   }
/*      */   public static boolean CV_IS_SUBDIV2D(CvSeq seq) {
/* 3212 */     return (CV_IS_SET(seq)) && (CV_SEQ_KIND(seq) == 8192);
/*      */   }
/*      */ 
/*      */   public static native void CV_WRITE_SEQ_ELEM_VAR(Pointer paramPointer, @ByVal CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native void CV_WRITE_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native void CV_NEXT_SEQ_ELEM(int paramInt, @ByVal CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static native void CV_PREV_SEQ_ELEM(int paramInt, @ByVal CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static native void CV_READ_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static native void CV_REV_READ_SEQ_ELEM(@ByVal CvPoint paramCvPoint, @ByVal CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static CvPoint CV_CURRENT_POINT(CvSeqReader reader)
/*      */   {
/* 3272 */     return new CvPoint(reader.ptr()); } 
/* 3273 */   public static CvPoint CV_PREV_POINT(CvSeqReader reader) { return new CvPoint(reader.prev_elem()); } 
/*      */   public static void CV_READ_EDGE(CvPoint pt1, CvPoint pt2, CvSeqReader reader) {
/* 3275 */     assert (reader.seq().elem_size() == Loader.sizeof(CvPoint.class));
/* 3276 */     pt1 = CV_PREV_POINT(reader);
/* 3277 */     pt2 = CV_CURRENT_POINT(reader);
/* 3278 */     reader.prev_elem(reader.ptr());
/* 3279 */     CV_NEXT_SEQ_ELEM(Loader.sizeof(CvPoint.class), reader);
/*      */   }
/*      */   public static CvGraphEdge CV_NEXT_GRAPH_EDGE(CvGraphEdge edge, CvGraphVtx vertex) {
/* 3282 */     assert ((edge.vtx(0).equals(vertex)) || (edge.vtx(1).equals(vertex)));
/* 3283 */     return edge.next(edge.vtx(1).equals(vertex) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   public static CvAttrList cvAttrList(PointerPointer attr, CvAttrList next)
/*      */   {
/* 3343 */     return new CvAttrList().attr(attr).next(next);
/*      */   }
/*      */   public static CvAttrList cvAttrList() {
/* 3346 */     return new CvAttrList();
/*      */   }
/*      */ 
/*      */   public static int CV_NODE_TYPE(int flags)
/*      */   {
/* 3368 */     return flags & 0x7; } 
/* 3369 */   public static boolean CV_NODE_IS_INT(int flags) { return CV_NODE_TYPE(flags) == 1; } 
/* 3370 */   public static boolean CV_NODE_IS_REAL(int flags) { return CV_NODE_TYPE(flags) == 2; } 
/* 3371 */   public static boolean CV_NODE_IS_STRING(int flags) { return CV_NODE_TYPE(flags) == 3; } 
/* 3372 */   public static boolean CV_NODE_IS_SEQ(int flags) { return CV_NODE_TYPE(flags) == 5; } 
/* 3373 */   public static boolean CV_NODE_IS_MAP(int flags) { return CV_NODE_TYPE(flags) == 6; } 
/* 3374 */   public static boolean CV_NODE_IS_COLLECTION(int flags) { return CV_NODE_TYPE(flags) >= 5; } 
/* 3375 */   public static boolean CV_NODE_IS_FLOW(int flags) { return (flags & 0x8) != 0; } 
/* 3376 */   public static boolean CV_NODE_IS_EMPTY(int flags) { return (flags & 0x20) != 0; } 
/* 3377 */   public static boolean CV_NODE_IS_USER(int flags) { return (flags & 0x10) != 0; } 
/* 3378 */   public static boolean CV_NODE_HAS_NAME(int flags) { return (flags & 0x40) != 0; } 
/* 3379 */   public static boolean CV_NODE_SEQ_IS_SIMPLE(CvSeq seq) { return (seq.flags() & 0x100) != 0; }
/*      */ 
/*      */ 
/*      */   public static native Pointer cvAlloc(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void cvFree_(Pointer paramPointer);
/*      */ 
/*      */   public static void cvFree(Pointer ptr)
/*      */   {
/* 3553 */     cvFree_(ptr);
/* 3554 */     ptr.setNull(); } 
/*      */   public static native IplImage cvCreateImageHeader(@ByVal CvSize paramCvSize, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native IplImage cvInitImageHeader(IplImage paramIplImage, @ByVal CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native IplImage cvCreateImage(@ByVal CvSize paramCvSize, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvReleaseImageHeader(@ByPtrPtr IplImage paramIplImage);
/*      */ 
/*      */   public static native void cvReleaseImage(@ByPtrPtr IplImage paramIplImage);
/*      */ 
/*      */   public static native IplImage cvCloneImage(IplImage paramIplImage);
/*      */ 
/*      */   public static native void cvSetImageCOI(IplImage paramIplImage, int paramInt);
/*      */ 
/*      */   public static native int cvGetImageCOI(IplImage paramIplImage);
/*      */ 
/*      */   public static native void cvSetImageROI(IplImage paramIplImage, @ByVal CvRect paramCvRect);
/*      */ 
/*      */   public static native void cvResetImageROI(IplImage paramIplImage);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvRect cvGetImageROI(IplImage paramIplImage);
/*      */ 
/*      */   public static native CvMat cvCreateMatHeader(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native CvMat cvInitMatHeader(CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4);
/*      */ 
/*      */   public static native CvMat cvCreateMat(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvReleaseMat(@ByPtrPtr CvMat paramCvMat);
/*      */ 
/*      */   public static native CvMat cvCloneMat(CvMat paramCvMat);
/*      */ 
/*      */   public static native CvMat cvGetSubRect(CvArr paramCvArr, CvMat paramCvMat, @ByVal CvRect paramCvRect);
/*      */ 
/* 3581 */   public static CvMat cvGetSubArr(CvArr arr, CvMat submat, @ByVal CvRect rect) { return cvGetSubRect(arr, submat, rect); }
/*      */ 
/*      */   public static native CvMat cvGetRows(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static CvMat cvGetRow(CvArr arr, CvMat submat, int row) {
/* 3586 */     return cvGetRows(arr, submat, row, row + 1, 1);
/*      */   }
/*      */   public static native CvMat cvGetCols(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static CvMat cvGetCol(CvArr arr, CvMat submat, int col) {
/* 3591 */     return cvGetCols(arr, submat, col, col + 1);
/*      */   }
/*      */ 
/*      */   public static native CvMat cvGetDiag(CvArr paramCvArr, CvMat paramCvMat, int paramInt);
/*      */ 
/*      */   public static native void cvScalarToRawData(CvScalar paramCvScalar, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvRawDataToScalar(Pointer paramPointer, int paramInt, CvScalar paramCvScalar);
/*      */ 
/*      */   public static native CvMatND cvCreateMatNDHeader(int paramInt1, int[] paramArrayOfInt, int paramInt2);
/*      */ 
/*      */   public static native CvMatND cvCreateMatND(int paramInt1, int[] paramArrayOfInt, int paramInt2);
/*      */ 
/*      */   public static native CvMatND cvInitMatNDHeader(CvMatND paramCvMatND, int paramInt1, int[] paramArrayOfInt, int paramInt2, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvReleaseMatND(@ByPtrPtr CvMatND paramCvMatND);
/*      */ 
/*      */   public static native CvMatND cvCloneMatND(CvMatND paramCvMatND);
/*      */ 
/*      */   public static native CvSparseMat cvCreateSparseMat(int paramInt1, int[] paramArrayOfInt, int paramInt2);
/*      */ 
/*      */   public static native void cvReleaseSparseMat(@ByPtrPtr CvSparseMat paramCvSparseMat);
/*      */ 
/*      */   public static native CvSparseMat cvCloneSparseMat(CvSparseMat paramCvSparseMat);
/*      */ 
/*      */   public static native CvSparseNode cvInitSparseMatIterator(CvSparseMat paramCvSparseMat, CvSparseMatIterator paramCvSparseMatIterator);
/*      */ 
/*      */   public static native CvSparseNode cvGetNextSparseNode(CvSparseMatIterator paramCvSparseMatIterator);
/*      */ 
/*      */   public static int cvInitNArrayIterator(int count, CvArr[] arrs, CvArr mask, CvMatND stubs, CvNArrayIterator array_iterator, int flags)
/*      */   {
/* 3644 */     return cvInitNArrayIterator(count, new CvArrArray(arrs), mask, stubs, array_iterator, flags); } 
/*      */   public static native int cvInitNArrayIterator(int paramInt1, CvArrArray paramCvArrArray, CvArr paramCvArr, CvMatND paramCvMatND, CvNArrayIterator paramCvNArrayIterator, int paramInt2);
/*      */ 
/*      */   public static native int cvNextNArraySlice(CvNArrayIterator paramCvNArrayIterator);
/*      */ 
/*      */   public static native int cvGetElemType(CvArr paramCvArr);
/*      */ 
/*      */   public static native int cvGetDims(CvArr paramCvArr, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int cvGetDimSize(CvArr paramCvArr, int paramInt);
/*      */ 
/*      */   public static native Pointer cvPtr1D(CvArr paramCvArr, int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native Pointer cvPtr2D(CvArr paramCvArr, int paramInt1, int paramInt2, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native Pointer cvPtr3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native Pointer cvPtrND(CvArr paramCvArr, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, @Cast({"unsigned*"}) int[] paramArrayOfInt3);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvGet1D(CvArr paramCvArr, int paramInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvGet2D(CvArr paramCvArr, int paramInt1, int paramInt2);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvGet3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvGetND(CvArr paramCvArr, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native double cvGetReal1D(CvArr paramCvArr, int paramInt);
/*      */ 
/*      */   public static native double cvGetReal2D(CvArr paramCvArr, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native double cvGetReal3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native double cvGetRealND(CvArr paramCvArr, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void cvSet1D(CvArr paramCvArr, int paramInt, @ByVal CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvSet2D(CvArr paramCvArr, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvSet3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, @ByVal CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvSetND(CvArr paramCvArr, int[] paramArrayOfInt, @ByVal CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvSetReal1D(CvArr paramCvArr, int paramInt, double paramDouble);
/*      */ 
/*      */   public static native void cvSetReal2D(CvArr paramCvArr, int paramInt1, int paramInt2, double paramDouble);
/*      */ 
/*      */   public static native void cvSetReal3D(CvArr paramCvArr, int paramInt1, int paramInt2, int paramInt3, double paramDouble);
/*      */ 
/*      */   public static native void cvSetRealND(CvArr paramCvArr, int[] paramArrayOfInt, double paramDouble);
/*      */ 
/*      */   public static native void cvClearND(CvArr paramCvArr, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native CvMat cvGetMat(CvArr paramCvArr, CvMat paramCvMat, int[] paramArrayOfInt, int paramInt);
/*      */ 
/*      */   public static native IplImage cvGetImage(CvArr paramCvArr, IplImage paramIplImage);
/*      */ 
/*      */   public static native CvArr cvReshapeMatND(CvArr paramCvArr1, int paramInt1, CvArr paramCvArr2, int paramInt2, int paramInt3, int[] paramArrayOfInt);
/*      */ 
/* 3683 */   public static CvArr cvReshapeND(CvArr arr, CvArr header, int new_cn, int new_dims, int[] new_sizes) { return cvReshapeMatND(arr, Loader.sizeof(header.getClass()), header, new_cn, new_dims, new_sizes); } 
/*      */   public static native CvMat cvReshape(CvArr paramCvArr, CvMat paramCvMat, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvRepeat(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvCreateData(CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvReleaseData(CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvSetData(CvArr paramCvArr, Pointer paramPointer, int paramInt);
/*      */ 
/*      */   public static native void cvGetRawData(CvArr paramCvArr, @Cast({"uchar**"}) @ByPtrPtr BytePointer paramBytePointer, int[] paramArrayOfInt, CvSize paramCvSize);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvSize cvGetSize(CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvCopy(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/* 3699 */   public static void cvCopy(CvArr src, CvArr dst) { cvCopy(src, dst, null); } 
/*      */   public static native void cvSet(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2);
/*      */ 
/*      */   public static void cvSet(CvArr arr, CvScalar value) {
/* 3703 */     cvSet(arr, value, null);
/*      */   }
/*      */   public static native void cvSetZero(CvArr paramCvArr);
/*      */ 
/* 3707 */   public static void cvZero(CvArr arr) { cvSetZero(arr); }
/*      */ 
/*      */   public static native void cvSplit(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5);
/*      */ 
/*      */   public static native void cvMerge(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5);
/*      */ 
/*      */   public static void cvMixChannels(CvArr[] src, int src_count, CvArr[] dst, int dst_count, int[] from_to, int pair_count) {
/* 3714 */     cvMixChannels(new CvArrArray(src), src_count, new CvArrArray(dst), dst_count, from_to, pair_count);
/*      */   }
/*      */   public static native void cvMixChannels(@Const CvArrArray paramCvArrArray1, int paramInt1, CvArrArray paramCvArrArray2, int paramInt2, int[] paramArrayOfInt, int paramInt3);
/*      */ 
/*      */   public static native void cvConvertScale(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static void cvCvtScale(CvArr src, CvArr dst, double scale, double shift) {
/* 3721 */     cvConvertScale(src, dst, scale, shift);
/*      */   }
/*      */   public static void cvScale(CvArr src, CvArr dst, double scale, double shift) {
/* 3724 */     cvConvertScale(src, dst, scale, shift);
/*      */   }
/*      */   public static void cvConvert(CvArr src, CvArr dst) {
/* 3727 */     cvConvertScale(src, dst, 1.0D, 0.0D);
/*      */   }
/*      */   public static native void cvConvertScaleAbs(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2);
/*      */ 
/* 3731 */   public static void cvCvtScaleAbs(CvArr src, CvArr dst, double scale, double shift) { cvConvertScaleAbs(src, dst, scale, shift); } 
/*      */   @ByVal
/*      */   public static native CvTermCriteria cvCheckTermCriteria(@ByVal CvTermCriteria paramCvTermCriteria, double paramDouble, int paramInt);
/*      */ 
/*      */   public static native void cvAdd(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvAddS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvSub(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/* 3741 */   public static void cvSubS(CvArr src, CvScalar value, CvArr dst, CvArr mask) { cvAddS(src, cvScalar(-value.val(0), -value.val(1), -value.val(2), -value.val(3)), dst, mask); } 
/*      */   public static native void cvSubRS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvMul(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble);
/*      */ 
/*      */   public static native void cvDiv(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble);
/*      */ 
/*      */   public static native void cvScaleAdd(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/* 3748 */   public static void cvAXPY(CvArr A, double real_scalar, CvArr B, CvArr C) { cvScaleAdd(A, cvRealScalar(real_scalar), B, C); } 
/*      */   public static native void cvAddWeighted(CvArr paramCvArr1, double paramDouble1, CvArr paramCvArr2, double paramDouble2, double paramDouble3, CvArr paramCvArr3);
/*      */ 
/*      */   public static native double cvDotProduct(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvAnd(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvAndS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvOr(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvOrS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvXor(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvXorS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvNot(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvInRange(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvInRangeS(CvArr paramCvArr1, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvCmp(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
/*      */ 
/*      */   public static native void cvCmpS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native void cvMin(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvMax(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvMinS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvMaxS(CvArr paramCvArr1, double paramDouble, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvAbsDiff(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvAbsDiffS(CvArr paramCvArr1, CvArr paramCvArr2, @ByVal CvScalar paramCvScalar);
/*      */ 
/* 3779 */   public static void cvAbs(CvArr src, CvArr dst) { cvAbsDiffS(src, dst, cvScalarAll(0.0D)); }
/*      */ 
/*      */   public static native void cvCartToPolar(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
/*      */ 
/*      */   public static native void cvPolarToCart(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
/*      */ 
/*      */   public static native void cvPow(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble);
/*      */ 
/*      */   public static native void cvExp(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvLog(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native float cvFastArctan(float paramFloat1, float paramFloat2);
/*      */ 
/*      */   public static native float cvCbrt(float paramFloat);
/*      */ 
/*      */   public static native int cvCheckArr(CvArr paramCvArr, int paramInt, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static int cvCheckArray(CvArr arr, int flags, double min_val, double max_val) {
/* 3798 */     return cvCheckArr(arr, flags, min_val, max_val);
/*      */   }
/*      */ 
/*      */   public static native void cvRandArr(CvRNG paramCvRNG, CvArr paramCvArr, int paramInt, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2);
/*      */ 
/*      */   public static native void cvRandShuffle(CvArr paramCvArr, CvRNG paramCvRNG, double paramDouble);
/*      */ 
/*      */   public static native void cvSort(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
/*      */ 
/*      */   public static native int cvSolveCubic(CvMat paramCvMat1, CvMat paramCvMat2);
/*      */ 
/*      */   public static native void cvSolvePoly(CvMat paramCvMat1, CvMat paramCvMat2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvCrossProduct(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static void cvMatMulAdd(CvArr src1, CvArr src2, CvArr src3, CvArr dst)
/*      */   {
/* 3821 */     cvGEMM(src1, src2, 1.0D, src3, 1.0D, dst, 0);
/*      */   }
/*      */   public static void cvMatMul(CvArr src1, CvArr src2, CvArr dst) {
/* 3824 */     cvMatMulAdd(src1, src2, null, dst);
/*      */   }
/*      */ 
/*      */   public static native void cvGEMM(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, CvArr paramCvArr3, double paramDouble2, CvArr paramCvArr4, int paramInt);
/*      */ 
/*      */   public static void cvMatMulAddEx(CvArr srcA, CvArr srcB, double alpha, CvArr srcC, double beta, CvArr dst, int tABC)
/*      */   {
/* 3834 */     cvGEMM(srcA, srcB, alpha, srcC, beta, dst, tABC);
/*      */   }
/*      */   public static native void cvTransform(CvArr paramCvArr1, CvArr paramCvArr2, CvMat paramCvMat1, CvMat paramCvMat2);
/*      */ 
/* 3838 */   public static void cvMatMulAddS(CvArr src, CvArr dst, CvMat transmat, CvMat shiftvec) { cvTransform(src, dst, transmat, shiftvec); } 
/*      */   public static native void cvPerspectiveTransform(CvArr paramCvArr1, CvArr paramCvArr2, CvMat paramCvMat);
/*      */ 
/*      */   public static native void cvMulTransposed(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt, CvArr paramCvArr3, double paramDouble);
/*      */ 
/*      */   public static native void cvTranspose(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/* 3845 */   public static void cvT(CvArr src, CvArr dst) { cvTranspose(src, dst); } 
/*      */   public static native void cvCompleteSymm(CvMat paramCvMat, int paramInt);
/*      */ 
/*      */   public static native void cvFlip(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
/*      */ 
/* 3850 */   public static void cvMirror(CvArr src, CvArr dst, int flip_mode) { cvFlip(src, dst, flip_mode); }
/*      */ 
/*      */ 
/*      */   public static native void cvSVD(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
/*      */ 
/*      */   public static native void cvSVBkSb(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, CvArr paramCvArr5, int paramInt);
/*      */ 
/*      */   public static native double cvInvert(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static double cvInvert(CvArr src, CvArr dst)
/*      */   {
/* 3870 */     return cvInvert(src, dst, 0);
/*      */   }
/*      */   public static double cvInv(CvArr src, CvArr dst, int method) {
/* 3873 */     return cvInvert(src, dst, method);
/*      */   }
/*      */   public static double cvInv(CvArr src, CvArr dst) {
/* 3876 */     return cvInvert(src, dst, 0);
/*      */   }
/*      */   public static native int cvSolve(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
/*      */ 
/* 3880 */   public static int cvSolve(CvArr A, CvArr B, CvArr X) { return cvSolve(A, B, X, 0); } 
/*      */   public static native double cvDet(CvArr paramCvArr);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvTrace(CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvEigenVV(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, double paramDouble, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvSetIdentity(CvArr paramCvArr, @ByVal CvScalar paramCvScalar);
/*      */ 
/* 3891 */   public static void cvSetIdentity(CvArr mat, double value) { cvSetIdentity(mat, cvRealScalar(value)); }
/*      */ 
/*      */   public static void cvSetIdentity(CvArr mat) {
/* 3894 */     cvSetIdentity(mat, 1.0D);
/*      */   }
/*      */ 
/*      */   public static native CvArr cvRange(CvArr paramCvArr, double paramDouble1, double paramDouble2);
/*      */ 
/*      */   public static void cvCalcCovarMatrix(CvArr[] vects, int count, CvArr cov_mat, CvArr avg, int flags)
/*      */   {
/* 3906 */     cvCalcCovarMatrix(new CvArrArray(vects), count, cov_mat, avg, flags);
/*      */   }
/*      */ 
/*      */   public static native void cvCalcCovarMatrix(@Const CvArrArray paramCvArrArray, int paramInt1, CvArr paramCvArr1, CvArr paramCvArr2, int paramInt2);
/*      */ 
/*      */   public static native void cvCalcPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4, int paramInt);
/*      */ 
/*      */   public static native void cvProjectPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native void cvBackProjectPCA(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, CvArr paramCvArr4);
/*      */ 
/*      */   public static native double cvMahalanobis(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static double cvMahalonobis(CvArr vec1, CvArr vec2, CvArr mat)
/*      */   {
/* 3921 */     return cvMahalanobis(vec1, vec2, mat); } 
/*      */   @ByVal
/*      */   public static native CvScalar cvSum(CvArr paramCvArr);
/*      */ 
/*      */   public static native int cvCountNonZero(CvArr paramCvArr);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvAvg(CvArr paramCvArr1, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvAvgSdv(CvArr paramCvArr1, CvScalar paramCvScalar1, CvScalar paramCvScalar2, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvMinMaxLoc(CvArr paramCvArr1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, CvPoint paramCvPoint1, CvPoint paramCvPoint2, CvArr paramCvArr2);
/*      */ 
/*      */   public static native void cvMinMaxLoc(CvArr paramCvArr1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, @Cast({"CvPoint*"}) int[] paramArrayOfInt1, @Cast({"CvPoint*"}) int[] paramArrayOfInt2, CvArr paramCvArr2);
/*      */ 
/* 3934 */   public static void cvMinMaxLoc(CvArr arr, double[] min_val, double[] max_val) { cvMinMaxLoc(arr, min_val, max_val, (CvPoint)null, (CvPoint)null, null); }
/*      */ 
/*      */ 
/*      */   public static native double cvNorm(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt, CvArr paramCvArr3);
/*      */ 
/*      */   public static double cvNorm(CvArr arr1, CvArr arr2, int norm_type)
/*      */   {
/* 3956 */     return cvNorm(arr1, arr2, norm_type, null);
/*      */   }
/*      */   public static double cvNorm(CvArr arr1, CvArr arr2) {
/* 3959 */     return cvNorm(arr1, arr2, 4, null);
/*      */   }
/*      */   public static double cvNorm(CvArr arr1) {
/* 3962 */     return cvNorm(arr1, null, 4, null);
/*      */   }
/*      */ 
/*      */   public static native void cvNormalize(CvArr paramCvArr1, CvArr paramCvArr2, double paramDouble1, double paramDouble2, int paramInt, CvArr paramCvArr3);
/*      */ 
/*      */   public static void cvNormalize(CvArr src, CvArr dst) {
/* 3968 */     cvNormalize(src, dst, 1.0D, 0.0D, 4, null);
/*      */   }
/*      */ 
/*      */   public static native void cvReduce(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvDFT(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static void cvFFT(CvArr src, CvArr dst, int flags, int nonzero_rows)
/*      */   {
/* 3990 */     cvDFT(src, dst, flags, nonzero_rows); } 
/*      */   public static native void cvMulSpectrums(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3, int paramInt);
/*      */ 
/*      */   public static native int cvGetOptimalDFTSize(int paramInt);
/*      */ 
/*      */   public static native void cvDCT(CvArr paramCvArr1, CvArr paramCvArr2, int paramInt);
/*      */ 
/*      */   public static native int cvSliceLength(@ByVal CvSlice paramCvSlice, CvSeq paramCvSeq);
/*      */ 
/*      */   public static native CvMemStorage cvCreateMemStorage(int paramInt);
/*      */ 
/*      */   public static native CvMemStorage cvCreateChildMemStorage(CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native void cvReleaseMemStorage(@ByPtrPtr CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native void cvClearMemStorage(CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native void cvSaveMemStoragePos(CvMemStorage paramCvMemStorage, CvMemStoragePos paramCvMemStoragePos);
/*      */ 
/*      */   public static native void cvRestoreMemStoragePos(CvMemStorage paramCvMemStorage, CvMemStoragePos paramCvMemStoragePos);
/*      */ 
/*      */   public static native Pointer cvMemStorageAlloc(CvMemStorage paramCvMemStorage, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvString cvMemStorageAllocString(CvMemStorage paramCvMemStorage, String paramString, int paramInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvString cvMemStorageAllocString(CvMemStorage paramCvMemStorage, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native CvSeq cvCreateSeq(int paramInt1, @Cast({"size_t"}) long paramLong, int paramInt2, CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native void cvSetSeqBlockSize(CvSeq paramCvSeq, int paramInt);
/*      */ 
/*      */   @Cast({"schar*"})
/*      */   public static native BytePointer cvSeqPush(CvSeq paramCvSeq, Pointer paramPointer);
/*      */ 
/*      */   @Cast({"schar*"})
/*      */   public static native BytePointer cvSeqPushFront(CvSeq paramCvSeq, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvSeqPop(CvSeq paramCvSeq, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvSeqPopFront(CvSeq paramCvSeq, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvSeqPushMulti(CvSeq paramCvSeq, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvSeqPopMulti(CvSeq paramCvSeq, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native Pointer cvSeqInsert(CvSeq paramCvSeq, int paramInt, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvSeqRemove(CvSeq paramCvSeq, int paramInt);
/*      */ 
/*      */   public static native void cvClearSeq(CvSeq paramCvSeq);
/*      */ 
/*      */   public static native Pointer cvGetSeqElem(CvSeq paramCvSeq, int paramInt);
/*      */ 
/*      */   public static native int cvSeqElemIdx(CvSeq paramCvSeq, Pointer paramPointer, @ByPtrPtr CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */   public static native void cvStartAppendToSeq(CvSeq paramCvSeq, CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native void cvStartWriteSeq(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage, CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native CvSeq cvEndWriteSeq(CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native void cvFlushSeqWriter(CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native void cvStartReadSeq(CvSeq paramCvSeq, CvSeqReader paramCvSeqReader, int paramInt);
/*      */ 
/*      */   public static native int cvGetSeqReaderPos(CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static native void cvSetSeqReaderPos(CvSeqReader paramCvSeqReader, int paramInt1, int paramInt2);
/*      */ 
/* 4040 */   public static Pointer cvCvtSeqToArray(CvSeq seq, Pointer elements) { return cvCvtSeqToArray(seq, elements, CV_WHOLE_SEQ); } 
/*      */   public static native Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Pointer paramPointer, @ByVal CvSlice paramCvSlice);
/*      */ 
/*      */   public static Pointer cvCvtSeqToArray(CvSeq seq, Buffer elements) {
/* 4044 */     return cvCvtSeqToArray(seq, elements, CV_WHOLE_SEQ);
/*      */   }
/*      */   public static native Pointer cvCvtSeqToArray(CvSeq paramCvSeq, Buffer paramBuffer, @ByVal CvSlice paramCvSlice);
/*      */ 
/*      */   public static native CvSeq cvMakeSeqHeaderForArray(int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4, CvSeq paramCvSeq, CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */   public static native CvSeq cvSeqSlice(CvSeq paramCvSeq, @ByVal CvSlice paramCvSlice, CvMemStorage paramCvMemStorage, int paramInt);
/*      */ 
/* 4052 */   public static CvSeq cvCloneSeq(CvSeq seq, CvMemStorage storage) { return cvSeqSlice(seq, CV_WHOLE_SEQ, storage, 1); }
/*      */ 
/*      */ 
/*      */   public static native void cvSeqRemoveSlice(CvSeq paramCvSeq, @ByVal CvSlice paramCvSlice);
/*      */ 
/*      */   public static native void cvSeqInsertSlice(CvSeq paramCvSeq, int paramInt, CvArr paramCvArr);
/*      */ 
/*      */   public static native void cvSeqSort(CvSeq paramCvSeq, CvCmpFunc paramCvCmpFunc, Pointer paramPointer);
/*      */ 
/*      */   public static native Pointer cvSeqSearch(CvSeq paramCvSeq, Pointer paramPointer1, CvCmpFunc paramCvCmpFunc, int paramInt, int[] paramArrayOfInt, Pointer paramPointer2);
/*      */ 
/*      */   public static native void cvSeqInvert(CvSeq paramCvSeq);
/*      */ 
/*      */   public static native int cvSeqPartition(CvSeq paramCvSeq1, CvMemStorage paramCvMemStorage, @ByPtrPtr CvSeq paramCvSeq2, CvCmpFunc paramCvCmpFunc, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvChangeSeqBlock(CvSeqReader paramCvSeqReader, int paramInt);
/*      */ 
/*      */   public static native void cvCreateSeqBlock(CvSeqWriter paramCvSeqWriter);
/*      */ 
/*      */   public static native CvSet cvCreateSet(int paramInt1, int paramInt2, int paramInt3, CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native int cvSetAdd(CvSet paramCvSet, CvSetElem paramCvSetElem1, @ByPtrPtr CvSetElem paramCvSetElem2);
/*      */ 
/*      */   public CvSetElem cvSetNew(CvSet set_header)
/*      */   {
/* 4078 */     CvSetElem elem = set_header.free_elems();
/* 4079 */     if (elem != null) {
/* 4080 */       set_header.free_elems(elem.next_free());
/* 4081 */       elem.flags(elem.flags() & 0x3FFFFFF);
/* 4082 */       set_header.active_count(set_header.active_count() + 1);
/*      */     } else {
/* 4084 */       cvSetAdd(set_header, null, elem);
/*      */     }
/* 4086 */     return elem;
/*      */   }
/*      */   public void cvSetRemoveByPtr(CvSet set_header, CvSetElem elem) {
/* 4089 */     assert (elem.flags() >= 0);
/* 4090 */     elem.next_free(set_header.free_elems());
/* 4091 */     elem.flags(elem.flags() & 0x3FFFFFF | 0x80);
/* 4092 */     set_header.free_elems(elem);
/* 4093 */     set_header.active_count(set_header.active_count() - 1);
/*      */   }
/*      */   public static native void cvSetRemove(CvSet paramCvSet, int paramInt);
/*      */ 
/* 4097 */   public static CvSetElem cvGetSetElem(CvSet set_header, int index) { CvSetElem elem = new CvSetElem(cvGetSeqElem(set_header, index));
/* 4098 */     return (elem != null) && (CV_IS_SET_ELEM(elem)) ? elem : null; } 
/*      */   public static native void cvClearSet(CvSet paramCvSet);
/*      */ 
/*      */   public static native CvGraph cvCreateGraph(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native int cvGraphAddVtx(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, @ByPtrPtr CvGraphVtx paramCvGraphVtx2);
/*      */ 
/*      */   public static native int cvGraphRemoveVtx(CvGraph paramCvGraph, int paramInt);
/*      */ 
/*      */   public static native int cvGraphRemoveVtxByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx);
/*      */ 
/*      */   public static native int cvGraphAddEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2, CvGraphEdge paramCvGraphEdge1, @ByPtrPtr CvGraphEdge paramCvGraphEdge2);
/*      */ 
/*      */   public static native int cvGraphAddEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2, CvGraphEdge paramCvGraphEdge1, @ByPtrPtr CvGraphEdge paramCvGraphEdge2);
/*      */ 
/*      */   public static native void cvGraphRemoveEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void cvGraphRemoveEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2);
/*      */ 
/*      */   public static native CvGraphEdge cvFindGraphEdge(CvGraph paramCvGraph, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native CvGraphEdge cvFindGraphEdgeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx1, CvGraphVtx paramCvGraphVtx2);
/*      */ 
/* 4118 */   public static CvGraphEdge cvGraphFindEdge(CvGraph graph, int start_idx, int end_idx) { return cvFindGraphEdge(graph, start_idx, end_idx); }
/*      */ 
/*      */   public static CvGraphEdge cvGraphFindEdgeByPtr(CvGraph graph, CvGraphVtx start_vtx, CvGraphVtx end_vtx) {
/* 4121 */     return cvFindGraphEdgeByPtr(graph, start_vtx, end_vtx); } 
/*      */   public static native void cvClearGraph(CvGraph paramCvGraph);
/*      */ 
/*      */   public static native int cvGraphVtxDegree(CvGraph paramCvGraph, int paramInt);
/*      */ 
/*      */   public static native int cvGraphVtxDegreeByPtr(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx);
/*      */ 
/* 4127 */   public static CvGraphVtx cvGetGraphVtx(CvGraph graph, int idx) { return new CvGraphVtx(cvGetSetElem(graph, idx)); } 
/* 4128 */   public static int cvGraphVtxIdx(CvGraph graph, CvGraphVtx vtx) { return vtx.flags() & 0x3FFFFFF; } 
/* 4129 */   public static int cvGraphEdgeIdx(CvGraph graph, CvGraphEdge edge) { return edge.flags() & 0x3FFFFFF; } 
/* 4130 */   public static int cvGraphGetVtxCount(CvGraph graph) { return graph.active_count(); } 
/* 4131 */   public static int cvGraphGetEdgeCount(CvGraph graph) { return graph.edges().active_count(); }
/*      */ 
/*      */ 
/*      */   public static boolean CV_IS_GRAPH_EDGE_VISITED(CvGraphVtx vtx)
/*      */   {
/* 4151 */     return (vtx.flags() & 0x40000000) != 0;
/*      */   }
/*      */   public static boolean CV_IS_GRAPH_VERTEX_VISITED(CvGraphEdge edge) {
/* 4154 */     return (edge.flags() & 0x40000000) != 0;
/*      */   }
/*      */ 
/*      */   public static native CvGraphScanner cvCreateGraphScanner(CvGraph paramCvGraph, CvGraphVtx paramCvGraphVtx, int paramInt);
/*      */ 
/*      */   public static native void cvReleaseGraphScanner(@ByPtrPtr CvGraphScanner paramCvGraphScanner);
/*      */ 
/*      */   public static native int cvNextGraphItem(CvGraphScanner paramCvGraphScanner);
/*      */ 
/*      */   public static native CvGraph cvCloneGraph(CvGraph paramCvGraph, CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static CvScalar CV_RGB(double r, double g, double b)
/*      */   {
/* 4203 */     return cvScalar(b, g, r, 0.0D);
/*      */   }
/*      */ 
/*      */   public static native void cvLine(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvRectangle(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvRectangleR(CvArr paramCvArr, @ByVal CvRect paramCvRect, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvCircle(CvArr paramCvArr, @ByVal CvPoint paramCvPoint, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void cvEllipse(CvArr paramCvArr, @ByVal CvPoint paramCvPoint, @ByVal CvSize paramCvSize, double paramDouble1, double paramDouble2, double paramDouble3, @ByVal CvScalar paramCvScalar, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static void cvEllipseBox(CvArr img, @ByVal CvBox2D box, @ByVal CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4221 */     CvSize2D32f size = box.size();
/* 4222 */     CvSize axes = cvSize((int)Math.round(size.width() * 0.5D), (int)Math.round(size.height() * 0.5D));
/* 4223 */     cvEllipse(img, cvPointFrom32f(box.center()), axes, box.angle(), 0.0D, 360.0D, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static native void cvFillConvexPoly(CvArr paramCvArr, CvPoint paramCvPoint, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvFillConvexPoly(CvArr paramCvArr, @Cast({"CvPoint*"}) int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static void cvFillPoly(CvArr img, CvPoint[] pts, int[] npts, int contours, @ByVal CvScalar color, int line_type, int shift)
/*      */   {
/* 4232 */     cvFillPoly(img, new PointerPointer(pts), npts, contours, color, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static native void cvFillPoly(CvArr paramCvArr, @Cast({"CvPoint**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void cvFillPoly(CvArr paramCvArr, @ByPtrPtr CvPoint paramCvPoint, int[] paramArrayOfInt, int paramInt1, @ByVal CvScalar paramCvScalar, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static void cvPolyLine(CvArr img, CvPoint[] pts, int[] npts, int contours, int is_closed, @ByVal CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4241 */     cvPolyLine(img, new PointerPointer(pts), npts, contours, is_closed, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static native void cvPolyLine(CvArr paramCvArr, @Cast({"CvPoint**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native void cvPolyLine(CvArr paramCvArr, @ByPtrPtr CvPoint paramCvPoint, int[] paramArrayOfInt, int paramInt1, int paramInt2, @ByVal CvScalar paramCvScalar, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static void cvDrawRect(CvArr img, CvPoint pt1, CvPoint pt2, CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4252 */     cvRectangle(img, pt1, pt2, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawLine(CvArr img, CvPoint pt1, CvPoint pt2, CvScalar color, int thickness, int line_type, int shift) {
/* 4256 */     cvLine(img, pt1, pt2, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawCircle(CvArr img, CvPoint center, int radius, CvScalar color, int thickness, int line_type, int shift) {
/* 4260 */     cvCircle(img, center, radius, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawEllipse(CvArr img, CvPoint center, CvSize axes, double angle, double start_angle, double end_angle, CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4265 */     cvEllipse(img, center, axes, angle, start_angle, end_angle, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawPolyLine(CvArr img, CvPoint[] pts, int[] npts, int contours, int is_closed, CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4271 */     cvPolyLine(img, pts, npts, contours, is_closed, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawPolyLine(CvArr img, @Cast({"CvPoint**"}) PointerPointer pts, int[] npts, int contours, int is_closed, CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4276 */     cvPolyLine(img, pts, npts, contours, is_closed, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static void cvDrawPolyLine(CvArr img, @ByPtrPtr CvPoint pts, int[] npts, int contours, int is_closed, CvScalar color, int thickness, int line_type, int shift)
/*      */   {
/* 4281 */     cvPolyLine(img, pts, npts, contours, is_closed, color, thickness, line_type, shift);
/*      */   }
/*      */ 
/*      */   public static native int cvClipLine(@ByVal CvSize paramCvSize, CvPoint paramCvPoint1, CvPoint paramCvPoint2);
/*      */ 
/*      */   public static native int cvInitLineIterator(CvArr paramCvArr, @ByVal CvPoint paramCvPoint1, @ByVal CvPoint paramCvPoint2, CvLineIterator paramCvLineIterator, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void CV_NEXT_LINE_POINT(@ByVal CvLineIterator paramCvLineIterator);
/*      */ 
/*      */   public static native void cvInitFont(CvFont paramCvFont, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static CvFont cvFont(double scale, int thickness)
/*      */   {
/* 4342 */     CvFont font = new CvFont();
/* 4343 */     cvInitFont(font, 1, scale, scale, 0.0D, thickness, 16);
/* 4344 */     return font;
/*      */   }
/*      */ 
/*      */   public static native void cvPutText(CvArr paramCvArr, String paramString, @ByVal CvPoint paramCvPoint, CvFont paramCvFont, @ByVal CvScalar paramCvScalar);
/*      */ 
/*      */   public static native void cvGetTextSize(String paramString, CvFont paramCvFont, CvSize paramCvSize, int[] paramArrayOfInt);
/*      */ 
/*      */   @ByVal
/*      */   public static native CvScalar cvColorToScalar(double paramDouble, int paramInt);
/*      */ 
/*      */   public static native int cvEllipse2Poly(@ByVal CvPoint paramCvPoint1, @ByVal CvSize paramCvSize, int paramInt1, int paramInt2, int paramInt3, CvPoint paramCvPoint2, int paramInt4);
/*      */ 
/*      */   public static native void cvDrawContours(CvArr paramCvArr, CvSeq paramCvSeq, @ByVal CvScalar paramCvScalar1, @ByVal CvScalar paramCvScalar2, int paramInt1, int paramInt2, int paramInt3, @ByVal CvPoint paramCvPoint);
/*      */ 
/*      */   public static void cvDrawContours(CvArr img, CvSeq contour, @ByVal CvScalar external_color, @ByVal CvScalar hole_color, int max_level, int thickness, int line_type)
/*      */   {
/* 4361 */     cvDrawContours(img, contour, external_color, hole_color, max_level, thickness, line_type, CvPoint.ZERO);
/*      */   }
/*      */ 
/*      */   public static native void cvLUT(CvArr paramCvArr1, CvArr paramCvArr2, CvArr paramCvArr3);
/*      */ 
/*      */   public static native void cvInitTreeNodeIterator(CvTreeNodeIterator paramCvTreeNodeIterator, Pointer paramPointer, int paramInt);
/*      */ 
/*      */   public static native Pointer cvNextTreeNode(CvTreeNodeIterator paramCvTreeNodeIterator);
/*      */ 
/*      */   public static native Pointer cvPrevTreeNode(CvTreeNodeIterator paramCvTreeNodeIterator);
/*      */ 
/*      */   public static native void cvInsertNodeIntoTree(Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3);
/*      */ 
/*      */   public static native void cvRemoveNodeFromTree(Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */   public static native CvSeq cvTreeToNodeSeq(Pointer paramPointer, int paramInt, CvMemStorage paramCvMemStorage);
/*      */ 
/*      */   public static native int cvKMeans2(CvArr paramCvArr1, int paramInt1, CvArr paramCvArr2, @ByVal CvTermCriteria paramCvTermCriteria, int paramInt2, CvRNG paramCvRNG, int paramInt3, CvArr paramCvArr3, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int cvRegisterModule(CvModuleInfo paramCvModuleInfo);
/*      */ 
/*      */   public static native int cvUseOptimized(int paramInt);
/*      */ 
/*      */   public static native void cvGetModuleInfo(String paramString, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native void cvSetMemoryManager(CvAllocFunc paramCvAllocFunc, CvFreeFunc paramCvFreeFunc, Pointer paramPointer);
/*      */ 
/*      */   public static native void cvSetIPLAllocators(Cv_iplCreateImageHeader paramCv_iplCreateImageHeader, Cv_iplAllocateImageData paramCv_iplAllocateImageData, Cv_iplDeallocate paramCv_iplDeallocate, Cv_iplCreateROI paramCv_iplCreateROI, Cv_iplCloneImage paramCv_iplCloneImage);
/*      */ 
/*      */   public static native CvFileStorage cvOpenFileStorage(String paramString1, CvMemStorage paramCvMemStorage, int paramInt, String paramString2);
/*      */ 
/*      */   public static native void cvReleaseFileStorage(@ByPtrPtr CvFileStorage paramCvFileStorage);
/*      */ 
/*      */   public static native String cvAttrValue(CvAttrList paramCvAttrList, String paramString);
/*      */ 
/*      */   public static void cvStartWriteStruct(CvFileStorage fs, String name, int struct_flags, String type_name)
/*      */   {
/* 4474 */     cvStartWriteStruct(fs, name, struct_flags, type_name, CV_ATTR_LIST_EMPTY); } 
/*      */   public static native void cvStartWriteStruct(CvFileStorage paramCvFileStorage, String paramString1, int paramInt, String paramString2, @ByVal CvAttrList paramCvAttrList);
/*      */ 
/*      */   public static native void cvEndWriteStruct(CvFileStorage paramCvFileStorage);
/*      */ 
/*      */   public static native void cvWriteInt(CvFileStorage paramCvFileStorage, String paramString, int paramInt);
/*      */ 
/*      */   public static native void cvWriteReal(CvFileStorage paramCvFileStorage, String paramString, double paramDouble);
/*      */ 
/*      */   public static native void cvWriteString(CvFileStorage paramCvFileStorage, String paramString1, String paramString2, int paramInt);
/*      */ 
/*      */   public static native void cvWriteComment(CvFileStorage paramCvFileStorage, String paramString, int paramInt);
/*      */ 
/* 4484 */   public static void cvWrite(CvFileStorage fs, String name, Pointer ptr) { cvWrite(fs, name, ptr, CV_ATTR_LIST_EMPTY); } 
/*      */   public static native void cvWrite(CvFileStorage paramCvFileStorage, String paramString, Pointer paramPointer, @ByVal CvAttrList paramCvAttrList);
/*      */ 
/*      */   public static native void cvStartNextStream(CvFileStorage paramCvFileStorage);
/*      */ 
/*      */   public static native void cvWriteRawData(CvFileStorage paramCvFileStorage, Pointer paramPointer, int paramInt, String paramString);
/*      */ 
/*      */   public static native CvStringHashNode cvGetHashedKey(CvFileStorage paramCvFileStorage, String paramString, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native CvFileNode cvGetRootFileNode(CvFileStorage paramCvFileStorage, int paramInt);
/*      */ 
/*      */   public static native CvFileNode cvGetFileNode(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvStringHashNode paramCvStringHashNode, int paramInt);
/*      */ 
/*      */   public static native CvFileNode cvGetFileNodeByName(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, String paramString);
/*      */ 
/* 4496 */   public static int cvReadInt(CvFileNode node) { return cvReadInt(node, 0); }
/*      */ 
/*      */   public static int cvReadInt(CvFileNode node, int default_value) {
/* 4499 */     return CV_NODE_IS_REAL(node.tag()) ? (int)Math.round(node.data_f()) : CV_NODE_IS_INT(node.tag()) ? node.data_i() : node == null ? default_value : 2147483647;
/*      */   }
/*      */ 
/*      */   public static int cvReadIntByName(CvFileStorage fs, CvFileNode map, String name)
/*      */   {
/* 4504 */     return cvReadIntByName(fs, map, name, 0);
/*      */   }
/*      */   public static int cvReadIntByName(CvFileStorage fs, CvFileNode map, String name, int default_value) {
/* 4507 */     return cvReadInt(cvGetFileNodeByName(fs, map, name), default_value);
/*      */   }
/*      */   public static double cvReadReal(CvFileNode node) {
/* 4510 */     return cvReadReal(node, 0.0D);
/*      */   }
/*      */   public static double cvReadReal(CvFileNode node, double default_value) {
/* 4513 */     return CV_NODE_IS_REAL(node.tag()) ? node.data_f() : CV_NODE_IS_INT(node.tag()) ? node.data_i() : node == null ? default_value : 1.E+300D;
/*      */   }
/*      */ 
/*      */   public static double cvReadRealByName(CvFileStorage fs, CvFileNode map, String name)
/*      */   {
/* 4518 */     return cvReadRealByName(fs, map, name, 0.0D);
/*      */   }
/*      */   public static double cvReadRealByName(CvFileStorage fs, CvFileNode map, String name, double default_value) {
/* 4521 */     return cvReadReal(cvGetFileNodeByName(fs, map, name), default_value);
/*      */   }
/*      */   public static String cvReadString(CvFileNode node) {
/* 4524 */     return cvReadString(node, null);
/*      */   }
/*      */   public static String cvReadString(CvFileNode node, String default_value) {
/* 4527 */     if (node == null)
/* 4528 */       return default_value;
/* 4529 */     if (CV_NODE_IS_STRING(node.tag())) {
/* 4530 */       CvString str = node.data_str();
/* 4531 */       BytePointer pointer = str.ptr();
/* 4532 */       byte[] bytes = new byte[str.len()];
/* 4533 */       pointer.get(bytes);
/* 4534 */       return new String(bytes);
/*      */     }
/* 4536 */     return null;
/*      */   }
/*      */ 
/*      */   public static String cvReadStringByName(CvFileStorage fs, CvFileNode map, String name) {
/* 4540 */     return cvReadStringByName(fs, map, name, null);
/*      */   }
/*      */   public static String cvReadStringByName(CvFileStorage fs, CvFileNode map, String name, String default_value) {
/* 4543 */     return cvReadString(cvGetFileNodeByName(fs, map, name), default_value);
/*      */   }
/*      */   public static Pointer cvRead(CvFileStorage fs, CvFileNode node) {
/* 4546 */     return cvRead(fs, node, CV_ATTR_LIST_EMPTY);
/*      */   }
/*      */   public static native Pointer cvRead(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvAttrList paramCvAttrList);
/*      */ 
/* 4550 */   public static Pointer cvReadByName(CvFileStorage fs, CvFileNode map, String name) { return cvReadByName(fs, map, name, CV_ATTR_LIST_EMPTY); }
/*      */ 
/*      */   public static Pointer cvReadByName(CvFileStorage fs, CvFileNode map, String name, CvAttrList attributes) {
/* 4553 */     CvFileNode n = cvGetFileNodeByName(fs, map, name);
/* 4554 */     return cvRead(fs, n, attributes); } 
/*      */   public static native void cvStartReadRawData(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, CvSeqReader paramCvSeqReader);
/*      */ 
/*      */   public static native void cvReadRawDataSlice(CvFileStorage paramCvFileStorage, CvSeqReader paramCvSeqReader, int paramInt, Pointer paramPointer, String paramString);
/*      */ 
/*      */   public static native void cvReadRawData(CvFileStorage paramCvFileStorage, CvFileNode paramCvFileNode, Pointer paramPointer, String paramString);
/*      */ 
/*      */   public static native void cvWriteFileNode(CvFileStorage paramCvFileStorage, String paramString, CvFileNode paramCvFileNode, int paramInt);
/*      */ 
/*      */   public static native String cvGetFileNodeName(CvFileNode paramCvFileNode);
/*      */ 
/*      */   public static native void cvRegisterType(CvTypeInfo paramCvTypeInfo);
/*      */ 
/*      */   public static native void cvUnregisterType(String paramString);
/*      */ 
/*      */   public static native CvTypeInfo cvFirstType();
/*      */ 
/*      */   public static native CvTypeInfo cvFindType(String paramString);
/*      */ 
/*      */   public static native CvTypeInfo cvTypeOf(Pointer paramPointer);
/*      */ 
/*      */   public static native void cvRelease(PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native Pointer cvClone(Pointer paramPointer);
/*      */ 
/* 4574 */   public static void cvSave(String filename, Pointer struct_ptr) { cvSave(filename, struct_ptr, null, null, CV_ATTR_LIST_EMPTY); }
/*      */ 
/*      */   public static native void cvSave(String paramString1, Pointer paramPointer, String paramString2, String paramString3, @ByVal CvAttrList paramCvAttrList);
/*      */ 
/*      */   public static Pointer cvLoad(String filename) {
/* 4579 */     return cvLoad(filename, null, null, null);
/*      */   }
/*      */ 
/*      */   public static native Pointer cvLoad(String paramString1, CvMemStorage paramCvMemStorage, String paramString2, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer);
/*      */ 
/*      */   public static native long cvGetTickCount();
/*      */ 
/*      */   public static native double cvGetTickFrequency();
/*      */ 
/*      */   public static native int cvCheckHardwareSupport(int paramInt);
/*      */ 
/*      */   public static native int cvGetNumThreads();
/*      */ 
/*      */   public static native void cvSetNumThreads(int paramInt);
/*      */ 
/*      */   public static native int cvGetThreadNum();
/*      */ 
/*      */   public static native int cvGetErrStatus();
/*      */ 
/*      */   public static native void cvSetErrStatus(int paramInt);
/*      */ 
/*      */   public static native int cvGetErrMode();
/*      */ 
/*      */   public static native int cvSetErrMode(int paramInt);
/*      */ 
/*      */   public static native void cvError(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);
/*      */ 
/*      */   public static native String cvErrorStr(int paramInt);
/*      */ 
/*      */   public static native int cvGetErrInfo(@Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer2, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer3, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int cvErrorFromIppStatus(int paramInt);
/*      */ 
/*      */   public static native CvErrorCallback cvRedirectError(CvErrorCallback paramCvErrorCallback, Pointer paramPointer1, @Cast({"void**"}) @ByPtrPtr Pointer paramPointer2);
/*      */ 
/*      */   public static native int cvNulDevReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
/*      */ 
/*      */   public static native int cvStdErrReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
/*      */ 
/*      */   public static native int cvGuiBoxReport(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
/*      */ 
/*      */   @Namespace("cv")
/*      */   @ByRef
/*      */   public static native String getBuildInformation();
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static native void batchDistance(@InputArray CvArr paramCvArr1, @InputArray CvArr paramCvArr2, @OutputArray CvMat paramCvMat1, int paramInt1, @OutputArray CvMat paramCvMat2, int paramInt2, int paramInt3, @InputArray CvArr paramCvArr3, int paramInt4, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Name({"cv::partition<void*>"})
/*      */   public static native int partition(@StdVector PointerPointer paramPointerPointer, @StdVector IntPointer paramIntPointer, @ByRef Predicate paramPredicate);
/*      */ 
/*      */   static
/*      */   {
/*  134 */     if (Loader.load() != null) {
/*  135 */       String platformName = Loader.getPlatformName();
/*  136 */       if (platformName.equals("windows-x86"))
/*  137 */         SetLibraryPath("C:/opencv/build/x86/vc10/bin/");
/*  138 */       else if (platformName.equals("windows-x86_64"))
/*  139 */         SetLibraryPath("C:/opencv/build/x64/vc10/bin/");
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Predicate extends FunctionPointer
/*      */   {
/*      */     public Predicate(Pointer p)
/*      */     {
/* 4997 */       super(); } 
/* 4998 */     protected Predicate() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native boolean call(Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */     static
/*      */     {
/* 4996 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class Param extends Pointer
/*      */   {
/*      */     public static final int INT = 0;
/*      */     public static final int BOOLEAN = 1;
/*      */     public static final int REAL = 2;
/*      */     public static final int STRING = 3;
/*      */     public static final int MAT = 4;
/*      */     public static final int MAT_VECTOR = 5;
/*      */     public static final int ALGORITHM = 6;
/*      */     public static final int FLOAT = 7;
/*      */     public static final int UNSIGNED_INT = 8;
/*      */     public static final int UINT64 = 9;
/*      */     public static final int SHORT = 10;
/*      */     public static final int UCHAR = 11;
/*      */ 
/*      */     public Param()
/*      */     {
/* 4974 */       allocate();
/*      */     }
/*      */     public Param(int _type, @Cast({"bool"}) boolean _readonly, int _offset, opencv_core.Algorithm.Getter _getter, opencv_core.Algorithm.Setter _setter, String _help) {
/* 4977 */       allocate(_type, _readonly, _offset, _getter, _setter, _help);
/*      */     }
/* 4979 */     public Param(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2, opencv_core.Algorithm.Getter paramGetter, opencv_core.Algorithm.Setter paramSetter, String paramString);
/*      */ 
/*      */     public native int type();
/*      */ 
/*      */     public native Param type(int paramInt);
/*      */ 
/*      */     public native int offset();
/*      */ 
/*      */     public native Param offset(int paramInt);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean readonly();
/*      */ 
/*      */     public native Param readonly(boolean paramBoolean);
/*      */ 
/*      */     public native opencv_core.Algorithm.Getter getter();
/*      */ 
/*      */     public native Param getter(opencv_core.Algorithm.Getter paramGetter);
/*      */ 
/*      */     public native opencv_core.Algorithm.Setter setter();
/*      */ 
/*      */     public native Param setter(opencv_core.Algorithm.Setter paramSetter);
/*      */ 
/*      */     @ByRef
/*      */     public native String help();
/*      */ 
/*      */     public native Param help(String paramString);
/*      */ 
/*      */     static
/*      */     {
/* 4973 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class AlgorithmInfo extends Pointer
/*      */   {
/*      */     public AlgorithmInfo(String name, opencv_core.Algorithm.Constructor create)
/*      */     {
/* 4951 */       allocate(name, create); } 
/* 4952 */     public AlgorithmInfo(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate(String paramString, opencv_core.Algorithm.Constructor paramConstructor);
/*      */ 
/*      */     public native void get(opencv_core.Algorithm paramAlgorithm, String paramString, int paramInt, Pointer paramPointer);
/*      */ 
/*      */     public native void addParam_(@ByRef opencv_core.Algorithm paramAlgorithm, String paramString1, int paramInt, Pointer paramPointer, @Cast({"bool"}) boolean paramBoolean, opencv_core.Algorithm.Getter paramGetter, opencv_core.Algorithm.Setter paramSetter, String paramString2);
/*      */ 
/*      */     @ByRef
/*      */     public native String paramHelp(String paramString);
/*      */ 
/*      */     public native int paramType(String paramString);
/*      */ 
/*      */     public native void getParams(@ByRef opencv_core.StringVector paramStringVector);
/*      */ 
/*      */     public native void write(opencv_core.Algorithm paramAlgorithm, @Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void read(opencv_core.Algorithm paramAlgorithm, @Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     @ByRef
/*      */     public native String name();
/*      */ 
/*      */     static
/*      */     {
/* 4950 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Namespace("cv")
/*      */   public static class Algorithm extends Pointer
/*      */   {
/*      */     public Algorithm()
/*      */     {
/* 4896 */       allocate(); } 
/* 4897 */     public Algorithm(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     @ByRef
/*      */     public native String name();
/*      */ 
/*      */     public native int getInt(String paramString);
/*      */ 
/*      */     public native double getDouble(String paramString);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean getBool(String paramString);
/*      */ 
/*      */     @ByRef
/*      */     public native String getString(String paramString);
/*      */ 
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat getMat(String paramString);
/*      */ 
/*      */     @ByVal
/*      */     public native opencv_core.MatVector getMatVector(String paramString);
/*      */ 
/*      */     @Const
/*      */     @opencv_core.Ptr
/*      */     public native Algorithm getAlgorithm(String paramString);
/*      */ 
/*      */     public native void set(String paramString, int paramInt);
/*      */ 
/*      */     public native void set(String paramString, double paramDouble);
/*      */ 
/*      */     public native void set(String paramString, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void set(String paramString1, String paramString2);
/*      */ 
/*      */     public native void set(String paramString, opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     public native void set(String paramString, @ByRef opencv_core.MatVector paramMatVector);
/*      */ 
/*      */     public native void set(String paramString, @opencv_core.Ptr Algorithm paramAlgorithm);
/*      */ 
/*      */     @ByRef
/*      */     public native String paramHelp(String paramString);
/*      */ 
/*      */     public native int paramType(String paramString);
/*      */ 
/*      */     public native void getParams(@ByRef opencv_core.StringVector paramStringVector);
/*      */ 
/*      */     public native void write(@Const @Adapter("FileStorageAdapter") opencv_core.CvFileStorage paramCvFileStorage);
/*      */ 
/*      */     public native void read(@Const @Adapter(value="FileNodeAdapter", argc=2) opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     public static native void getList(@ByRef opencv_core.StringVector paramStringVector);
/*      */ 
/*      */     @opencv_core.Ptr
/*      */     public static native Algorithm _create(String paramString);
/*      */ 
/*      */     public native opencv_core.AlgorithmInfo info();
/*      */ 
/*      */     static
/*      */     {
/* 4895 */       Loader.load();
/*      */     }
/*      */ 
/*      */     @Namespace("cv::Algorithm")
/*      */     public static class Setter extends FunctionPointer
/*      */     {
/*      */       public Setter(Pointer p)
/*      */       {
/* 4942 */         super();
/*      */       }
/*      */ 
/*      */       public native void call(opencv_core.Algorithm paramAlgorithm, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 4941 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     @Namespace("cv::Algorithm")
/*      */     @Const
/*      */     public static class Getter extends FunctionPointer
/*      */     {
/*      */       public Getter(Pointer p)
/*      */       {
/* 4937 */         super();
/*      */       }
/*      */ 
/*      */       public native int call(opencv_core.Algorithm paramAlgorithm);
/*      */ 
/*      */       static
/*      */       {
/* 4936 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Constructor extends FunctionPointer
/*      */     {
/*      */       public Constructor(Pointer p)
/*      */       {
/* 4930 */         super(); } 
/* 4931 */       protected Constructor() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native opencv_core.Algorithm call();
/*      */ 
/*      */       static
/*      */       {
/* 4929 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @NoOffset
/*      */   @Namespace("cv")
/*      */   public static class KDTree extends Pointer
/*      */   {
/*      */     public KDTree()
/*      */     {
/* 4852 */       allocate(); } 
/* 4853 */     public KDTree(Pointer p) { super(); } 
/*      */     public KDTree(opencv_core.CvMat _points, boolean copyAndReorderPoints) {
/* 4855 */       allocate(_points, copyAndReorderPoints);
/*      */     }
/*      */     public KDTree(opencv_core.CvMat _points, opencv_core.CvMat _labels, boolean copyAndReorderPoints) {
/* 4858 */       allocate(_points, _labels, copyAndReorderPoints);
/*      */     }
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@opencv_core.InputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     private native void allocate(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void build(@opencv_core.InputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native void build(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */     public native int findNearest(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, int paramInt1, int paramInt2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3, @opencv_core.OutputArray opencv_core.CvMat paramCvMat4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat5);
/*      */ 
/*      */     public native int findNearest(@opencv_core.InputArray FloatPointer paramFloatPointer1, int paramInt1, int paramInt2, @opencv_core.OutputArray IntPointer paramIntPointer1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @opencv_core.OutputArray FloatPointer paramFloatPointer2, @opencv_core.OutputArray IntPointer paramIntPointer2);
/*      */ 
/*      */     public native void findOrthoRange(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.InputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3, @opencv_core.OutputArray opencv_core.CvMat paramCvMat4, @opencv_core.OutputArray opencv_core.CvMat paramCvMat5);
/*      */ 
/*      */     public native void findOrthoRange(@opencv_core.InputArray FloatPointer paramFloatPointer1, @opencv_core.InputArray FloatPointer paramFloatPointer2, @opencv_core.OutputArray IntPointer paramIntPointer1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @opencv_core.OutputArray IntPointer paramIntPointer2);
/*      */ 
/*      */     public native void getPoints(@opencv_core.InputArray opencv_core.CvMat paramCvMat1, @opencv_core.OutputArray opencv_core.CvMat paramCvMat2, @opencv_core.OutputArray opencv_core.CvMat paramCvMat3);
/*      */ 
/*      */     public native void getPoints(@opencv_core.InputArray FloatPointer paramFloatPointer, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @opencv_core.OutputArray IntPointer paramIntPointer);
/*      */ 
/*      */     @Const
/*      */     public native FloatPointer getPoint(int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */     public native int dims();
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native Node nodes();
/*      */ 
/*      */     public native KDTree nodes(Node paramNode);
/*      */ 
/*      */     @opencv_core.InputMat
/*      */     public native opencv_core.CvMat points();
/*      */ 
/*      */     public native KDTree points(opencv_core.CvMat paramCvMat);
/*      */ 
/*      */     @Const
/*      */     @StdVector
/*      */     public native IntPointer labels();
/*      */ 
/*      */     public native KDTree labels(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int maxDepth();
/*      */ 
/*      */     public native KDTree maxDepth(int paramInt);
/*      */ 
/*      */     public native int normType();
/*      */ 
/*      */     public native KDTree normType(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4830 */       Loader.load();
/*      */     }
/* 4833 */     @NoOffset
/*      */     public static class Node extends Pointer { public Node() { allocate(); } 
/* 4834 */       public Node(int size) { allocateArray(size); } 
/* 4835 */       public Node(Pointer p) { super(); } 
/*      */       public Node(int _idx, int _left, int _right, float _boundary) {
/* 4837 */         allocate(_idx, _left, _right, _boundary); } 
/*      */       private native void allocate();
/*      */ 
/*      */       private native void allocate(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
/*      */ 
/*      */       private native void allocateArray(int paramInt);
/*      */ 
/* 4844 */       public Node position(int position) { return (Node)super.position(position); }
/*      */ 
/*      */ 
/*      */       public native int idx();
/*      */ 
/*      */       public native Node idx(int paramInt);
/*      */ 
/*      */       public native int left();
/*      */ 
/*      */       public native Node left(int paramInt);
/*      */ 
/*      */       public native int right();
/*      */ 
/*      */       public native Node right(int paramInt);
/*      */ 
/*      */       public native float boundary();
/*      */ 
/*      */       public native Node boundary(float paramFloat);
/*      */ 
/*      */       static
/*      */       {
/* 4832 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::Rect> >"})
/*      */   public static class RectVectorVector extends Pointer
/*      */   {
/*      */     public RectVectorVector()
/*      */     {
/* 4805 */       allocate(); } 
/* 4806 */     public RectVectorVector(long n) { allocate(n); } 
/* 4807 */     public RectVectorVector(Pointer p) { super(); }
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
/*      */     @ByVal
/*      */     public native opencv_core.CvRect get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native RectVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     static
/*      */     {
/* 4804 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::Point2d> >"})
/*      */   public static class Point2dVectorVector extends Pointer
/*      */   {
/*      */     public Point2dVectorVector()
/*      */     {
/* 4787 */       allocate(); } 
/* 4788 */     public Point2dVectorVector(long n) { allocate(n); } 
/* 4789 */     public Point2dVectorVector(Pointer p) { super(); }
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
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native Point2dVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     static
/*      */     {
/* 4786 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::Point2f> >"})
/*      */   public static class Point2fVectorVector extends Pointer
/*      */   {
/*      */     public Point2fVectorVector()
/*      */     {
/* 4769 */       allocate(); } 
/* 4770 */     public Point2fVectorVector(long n) { allocate(n); } 
/* 4771 */     public Point2fVectorVector(Pointer p) { super(); }
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
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint2D32f get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native Point2fVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     static
/*      */     {
/* 4768 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<cv::Point> >"})
/*      */   public static class PointVectorVector extends Pointer
/*      */   {
/*      */     public PointVectorVector()
/*      */     {
/* 4751 */       allocate(); } 
/* 4752 */     public PointVectorVector(long n) { allocate(n); } 
/* 4753 */     public PointVectorVector(Pointer p) { super(); }
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
/*      */     @ByVal
/*      */     public native opencv_core.CvPoint get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native PointVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, opencv_core.CvPoint paramCvPoint);
/*      */ 
/*      */     static
/*      */     {
/* 4750 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<int> >"})
/*      */   public static class IntVectorVector extends Pointer
/*      */   {
/*      */     public IntVectorVector()
/*      */     {
/* 4733 */       allocate(); } 
/* 4734 */     public IntVectorVector(long n) { allocate(n); } 
/* 4735 */     public IntVectorVector(Pointer p) { super(); }
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
/*      */     public native int get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native IntVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4732 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::vector<char> >"})
/*      */   public static class ByteVectorVector extends Pointer
/*      */   {
/*      */     public ByteVectorVector()
/*      */     {
/* 4715 */       allocate(); } 
/* 4716 */     public ByteVectorVector(long n) { allocate(n); } 
/* 4717 */     public ByteVectorVector(Pointer p) { super(); }
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
/*      */     public native byte get(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */     public native ByteVectorVector put(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, byte paramByte);
/*      */ 
/*      */     static
/*      */     {
/* 4714 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<cv::Mat>"})
/*      */   public static class MatVector extends Pointer
/*      */   {
/*      */     public MatVector(opencv_core.CvArr[] array)
/*      */     {
/* 4688 */       this(array.length); put(array); } 
/* 4689 */     public MatVector() { allocate(); } 
/* 4690 */     public MatVector(long n) { allocate(n); } 
/* 4691 */     public MatVector(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     public native long size();
/*      */ 
/*      */     public native void resize(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     @ValueGetter
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMat getCvMat(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     @ValueGetter
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.CvMatND getCvMatND(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     @ValueGetter
/*      */     @opencv_core.OutputMat
/*      */     public native opencv_core.IplImage getIplImage(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     @ValueSetter
/*      */     public native MatVector put(@Cast({"size_t"}) long paramLong, @opencv_core.InputMat opencv_core.CvArr paramCvArr);
/*      */ 
/* 4704 */     public MatVector put(opencv_core.CvArr[] array) { if (size() < array.length) resize(array.length);
/* 4705 */       for (int i = 0; i < array.length; i++) {
/* 4706 */         put(i, array[i]);
/*      */       }
/* 4708 */       return this;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 4687 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"std::vector<std::string>"})
/*      */   public static class StringVector extends Pointer
/*      */   {
/*      */     public StringVector(String[] array)
/*      */     {
/* 4663 */       this(array.length); put(array); } 
/* 4664 */     public StringVector() { allocate(); } 
/* 4665 */     public StringVector(long n) { allocate(n); } 
/* 4666 */     public StringVector(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocate(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     public native long size();
/*      */ 
/*      */     public native void resize(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     @Index
/*      */     @ByRef
/*      */     public native String get(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */     public native StringVector put(@Cast({"size_t"}) long paramLong, String paramString);
/*      */ 
/* 4677 */     public StringVector put(String[] array) { if (size() < array.length) resize(array.length);
/* 4678 */       for (int i = 0; i < array.length; i++) {
/* 4679 */         put(i, array[i]);
/*      */       }
/* 4681 */       return this;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 4662 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
/*      */   @Cast({"cv::Ptr", "&"})
/*      */   @Adapter("PtrAdapter")
/*      */   public static @interface Ptr
/*      */   {
/*      */     public abstract String value();
/*      */   }
/*      */ 
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
/*      */   @Adapter("MatAdapter")
/*      */   public static @interface OutputMat
/*      */   {
/*      */   }
/*      */ 
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
/*      */   @Const
/*      */   @Adapter("MatAdapter")
/*      */   public static @interface InputMat
/*      */   {
/*      */   }
/*      */ 
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
/*      */   @Adapter("ArrayAdapter")
/*      */   public static @interface OutputArray
/*      */   {
/*      */   }
/*      */ 
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
/*      */   @Const
/*      */   @Adapter("ArrayAdapter")
/*      */   public static @interface InputArray
/*      */   {
/*      */   }
/*      */ 
/*      */   public static class CvErrorCallback extends FunctionPointer
/*      */   {
/*      */     public CvErrorCallback(Pointer p)
/*      */     {
/* 4626 */       super(); } 
/* 4627 */     protected CvErrorCallback() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/* 4625 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Convention("CV_STDCALL")
/*      */   public static class Cv_iplCloneImage extends FunctionPointer
/*      */   {
/*      */     public Cv_iplCloneImage(Pointer p)
/*      */     {
/* 4456 */       super(); } 
/* 4457 */     protected Cv_iplCloneImage() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native opencv_core.IplImage call(@Const opencv_core.IplImage paramIplImage);
/*      */ 
/*      */     static
/*      */     {
/* 4455 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Convention("CV_STDCALL")
/*      */   public static class Cv_iplCreateROI extends FunctionPointer
/*      */   {
/*      */     public Cv_iplCreateROI(Pointer p)
/*      */     {
/* 4448 */       super(); } 
/* 4449 */     protected Cv_iplCreateROI() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native opencv_core.IplROI call(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */     static
/*      */     {
/* 4447 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Convention("CV_STDCALL")
/*      */   public static class Cv_iplDeallocate extends FunctionPointer
/*      */   {
/*      */     public Cv_iplDeallocate(Pointer p)
/*      */     {
/* 4440 */       super(); } 
/* 4441 */     protected Cv_iplDeallocate() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(opencv_core.IplImage paramIplImage, int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4439 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Convention("CV_STDCALL")
/*      */   public static class Cv_iplAllocateImageData extends FunctionPointer
/*      */   {
/*      */     public Cv_iplAllocateImageData(Pointer p)
/*      */     {
/* 4432 */       super(); } 
/* 4433 */     protected Cv_iplAllocateImageData() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(opencv_core.IplImage paramIplImage, int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 4431 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Convention("CV_STDCALL")
/*      */   public static class Cv_iplCreateImageHeader extends FunctionPointer
/*      */   {
/*      */     public Cv_iplCreateImageHeader(Pointer p)
/*      */     {
/* 4422 */       super(); } 
/* 4423 */     protected Cv_iplCreateImageHeader() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native opencv_core.IplImage call(int paramInt1, int paramInt2, int paramInt3, @Cast({"char*"}) BytePointer paramBytePointer1, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, opencv_core.IplROI paramIplROI, opencv_core.IplImage paramIplImage, Pointer paramPointer, opencv_core.IplTileInfo paramIplTileInfo);
/*      */ 
/*      */     static
/*      */     {
/* 4421 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFreeFunc extends FunctionPointer
/*      */   {
/*      */     public CvFreeFunc(Pointer p)
/*      */     {
/* 4410 */       super(); } 
/* 4411 */     protected CvFreeFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */     static
/*      */     {
/* 4409 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvAllocFunc extends FunctionPointer
/*      */   {
/*      */     public CvAllocFunc(Pointer p)
/*      */     {
/* 4403 */       super(); } 
/* 4404 */     protected CvAllocFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native Pointer call(@Cast({"size_t"}) long paramLong, Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/* 4402 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvTreeNodeIterator extends Pointer
/*      */   {
/*      */     public CvTreeNodeIterator()
/*      */     {
/* 4368 */       allocate(); } 
/* 4369 */     public CvTreeNodeIterator(int size) { allocateArray(size); } 
/* 4370 */     public CvTreeNodeIterator(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4375 */     public CvTreeNodeIterator position(int position) { return (CvTreeNodeIterator)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Const
/*      */     public native Pointer node();
/*      */ 
/*      */     public native CvTreeNodeIterator node(Pointer paramPointer);
/*      */ 
/*      */     public native int level();
/*      */ 
/*      */     public native CvTreeNodeIterator level(int paramInt);
/*      */ 
/*      */     public native int max_level();
/*      */ 
/*      */     public native CvTreeNodeIterator max_level(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4367 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFont extends Pointer
/*      */   {
/*      */     public CvFont()
/*      */     {
/* 4305 */       allocate(); } 
/* 4306 */     public CvFont(int size) { allocateArray(size); } 
/* 4307 */     public CvFont(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4312 */     public CvFont position(int position) { return (CvFont)super.position(position); }
/*      */ 
/*      */ 
/*      */     public CvFont(int font_face, double hscale, double vscale, double shear, int thickness, int line_type)
/*      */     {
/* 4317 */       allocate();
/* 4318 */       opencv_core.cvInitFont(this, font_face, hscale, vscale, shear, thickness, line_type);
/*      */     }
/*      */     public CvFont(int font_face, double scale, int thickness) {
/* 4321 */       allocate();
/* 4322 */       opencv_core.cvInitFont(this, font_face, scale, scale, 0.0D, thickness, 16);
/*      */     }
/*      */ 
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer nameFont();
/*      */ 
/*      */     public native CvFont nameFont(BytePointer paramBytePointer);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvScalar color();
/*      */ 
/*      */     public native CvFont color(opencv_core.CvScalar paramCvScalar);
/*      */ 
/*      */     public native int font_face();
/*      */ 
/*      */     public native CvFont font_face(int paramInt);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer ascii();
/*      */ 
/*      */     public native CvFont ascii(IntPointer paramIntPointer);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer greek();
/*      */ 
/*      */     public native CvFont greek(IntPointer paramIntPointer);
/*      */ 
/*      */     @Const
/*      */     public native IntPointer cyrillic();
/*      */ 
/*      */     public native CvFont cyrillic(IntPointer paramIntPointer);
/*      */ 
/*      */     public native float hscale();
/*      */ 
/*      */     public native CvFont hscale(float paramFloat);
/*      */ 
/*      */     public native float vscale();
/*      */ 
/*      */     public native CvFont vscale(float paramFloat);
/*      */ 
/*      */     public native float shear();
/*      */ 
/*      */     public native CvFont shear(float paramFloat);
/*      */ 
/*      */     public native int thickness();
/*      */ 
/*      */     public native CvFont thickness(int paramInt);
/*      */ 
/*      */     public native float dx();
/*      */ 
/*      */     public native CvFont dx(float paramFloat);
/*      */ 
/*      */     public native int line_type();
/*      */ 
/*      */     public native CvFont line_type(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4304 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGraphScanner extends Pointer
/*      */   {
/*      */     public CvGraphScanner()
/*      */     {
/* 4159 */       allocate(); zero(); } 
/* 4160 */     public CvGraphScanner(int size) { allocateArray(size); zero(); } 
/* 4161 */     public CvGraphScanner(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4166 */     public CvGraphScanner position(int position) { return (CvGraphScanner)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvGraphScanner create(opencv_core.CvGraph graph, opencv_core.CvGraphVtx vtx, int mask)
/*      */     {
/* 4171 */       CvGraphScanner g = opencv_core.cvCreateGraphScanner(graph, vtx, mask);
/* 4172 */       if (g != null) {
/* 4173 */         g.deallocator(new ReleaseDeallocator(g));
/*      */       }
/* 4175 */       return g;
/*      */     }
/*      */     public void release() {
/* 4178 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native opencv_core.CvGraphVtx vtx();
/*      */ 
/*      */     public native CvGraphScanner vtx(opencv_core.CvGraphVtx paramCvGraphVtx);
/*      */ 
/*      */     public native opencv_core.CvGraphVtx dst();
/*      */ 
/*      */     public native CvGraphScanner dst(opencv_core.CvGraphVtx paramCvGraphVtx);
/*      */ 
/*      */     public native opencv_core.CvGraphEdge edge();
/*      */ 
/*      */     public native CvGraphScanner edge(opencv_core.CvGraphEdge paramCvGraphEdge);
/*      */ 
/*      */     public native opencv_core.CvGraph graph();
/*      */ 
/*      */     public native CvGraphScanner graph(opencv_core.CvGraph paramCvGraph);
/*      */ 
/*      */     public native opencv_core.CvSeq stack();
/*      */ 
/*      */     public native CvGraphScanner stack(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     public native int index();
/*      */ 
/*      */     public native CvGraphScanner index(int paramInt);
/*      */ 
/*      */     public native int mask();
/*      */ 
/*      */     public native CvGraphScanner mask(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4158 */       Loader.load();
/*      */     }
/*      */ 
/*      */     protected static class ReleaseDeallocator extends opencv_core.CvGraphScanner
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_core.CvGraphScanner p)
/*      */       {
/* 4181 */         super(); } 
/* 4182 */       public void deallocate() { opencv_core.cvReleaseGraphScanner(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCmpFunc extends FunctionPointer
/*      */   {
/*      */     public CvCmpFunc(Pointer p)
/*      */     {
/* 4058 */       super(); } 
/* 4059 */     protected CvCmpFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(@Const Pointer paramPointer1, @Const Pointer paramPointer2, Pointer paramPointer3);
/*      */ 
/*      */     static
/*      */     {
/* 4057 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvNArrayIterator extends Pointer
/*      */   {
/*      */     public CvNArrayIterator()
/*      */     {
/* 3617 */       allocate(); } 
/* 3618 */     public CvNArrayIterator(int size) { allocateArray(size); } 
/* 3619 */     public CvNArrayIterator(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3624 */     public CvNArrayIterator position(int position) { return (CvNArrayIterator)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int count();
/*      */ 
/*      */     public native CvNArrayIterator count(int paramInt);
/*      */ 
/*      */     public native int dims();
/*      */ 
/*      */     public native CvNArrayIterator dims(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvSize size();
/*      */ 
/*      */     public native CvNArrayIterator size(opencv_core.CvSize paramCvSize);
/*      */ 
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer ptr(int paramInt);
/*      */ 
/*      */     public native CvNArrayIterator ptr(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     public native int stack(int paramInt);
/*      */ 
/*      */     public native CvNArrayIterator stack(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native opencv_core.CvMatND hdr(int paramInt);
/*      */ 
/*      */     public native CvNArrayIterator hdr(int paramInt, opencv_core.CvMatND paramCvMatND);
/*      */ 
/*      */     static
/*      */     {
/* 3616 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvModuleInfo extends Pointer
/*      */   {
/*      */     public CvModuleInfo()
/*      */     {
/* 3531 */       allocate(); } 
/* 3532 */     public CvModuleInfo(int size) { allocateArray(size); } 
/* 3533 */     public CvModuleInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3538 */     public CvModuleInfo position(int position) { return (CvModuleInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvModuleInfo next();
/*      */ 
/*      */     public native CvModuleInfo next(CvModuleInfo paramCvModuleInfo);
/*      */ 
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     public native CvModuleInfo name(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer version();
/*      */ 
/*      */     public native CvModuleInfo version(BytePointer paramBytePointer);
/*      */ 
/*      */     public native opencv_core.CvPluginFuncInfo func_tab();
/*      */ 
/*      */     public native CvModuleInfo func_tab(opencv_core.CvPluginFuncInfo paramCvPluginFuncInfo);
/*      */ 
/*      */     static
/*      */     {
/* 3530 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPluginFuncInfo extends Pointer
/*      */   {
/*      */     public CvPluginFuncInfo()
/*      */     {
/* 3511 */       allocate(); } 
/* 3512 */     public CvPluginFuncInfo(int size) { allocateArray(size); } 
/* 3513 */     public CvPluginFuncInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3518 */     public CvPluginFuncInfo position(int position) { return (CvPluginFuncInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native PointerPointer func_addr();
/*      */ 
/*      */     public native CvPluginFuncInfo func_addr(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native Pointer default_func_addr();
/*      */ 
/*      */     public native CvPluginFuncInfo default_func_addr(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer func_names();
/*      */ 
/*      */     public native CvPluginFuncInfo func_names(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int search_modules();
/*      */ 
/*      */     public native CvPluginFuncInfo search_modules(int paramInt);
/*      */ 
/*      */     public native int loaded_from();
/*      */ 
/*      */     public native CvPluginFuncInfo loaded_from(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3510 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvTypeInfo extends Pointer
/*      */   {
/*      */     public CvTypeInfo()
/*      */     {
/* 3483 */       allocate(); } 
/* 3484 */     public CvTypeInfo(int size) { allocateArray(size); } 
/* 3485 */     public CvTypeInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3490 */     public CvTypeInfo position(int position) { return (CvTypeInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvTypeInfo flags(int paramInt);
/*      */ 
/*      */     public native int header_size();
/*      */ 
/*      */     public native CvTypeInfo header_size(int paramInt);
/*      */ 
/*      */     public native CvTypeInfo prev();
/*      */ 
/*      */     public native CvTypeInfo prev(CvTypeInfo paramCvTypeInfo);
/*      */ 
/*      */     public native CvTypeInfo next();
/*      */ 
/*      */     public native CvTypeInfo next(CvTypeInfo paramCvTypeInfo);
/*      */ 
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer type_name();
/*      */ 
/*      */     public native CvTypeInfo type_name(BytePointer paramBytePointer);
/*      */ 
/*      */     public native opencv_core.CvIsInstanceFunc is_instance();
/*      */ 
/*      */     public native CvTypeInfo is_instance(opencv_core.CvIsInstanceFunc paramCvIsInstanceFunc);
/*      */ 
/*      */     public native opencv_core.CvReleaseFunc release();
/*      */ 
/*      */     public native CvTypeInfo release(opencv_core.CvReleaseFunc paramCvReleaseFunc);
/*      */ 
/*      */     public native opencv_core.CvReadFunc read();
/*      */ 
/*      */     public native CvTypeInfo read(opencv_core.CvReadFunc paramCvReadFunc);
/*      */ 
/*      */     public native opencv_core.CvWriteFunc write();
/*      */ 
/*      */     public native CvTypeInfo write(opencv_core.CvWriteFunc paramCvWriteFunc);
/*      */ 
/*      */     public native opencv_core.CvCloneFunc clone();
/*      */ 
/*      */     public native CvTypeInfo clone(opencv_core.CvCloneFunc paramCvCloneFunc);
/*      */ 
/*      */     static
/*      */     {
/* 3482 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvCloneFunc extends FunctionPointer
/*      */   {
/*      */     public CvCloneFunc(Pointer p)
/*      */     {
/* 3476 */       super(); } 
/* 3477 */     protected CvCloneFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native Pointer call(@Const Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/* 3475 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvWriteFunc extends FunctionPointer
/*      */   {
/*      */     public CvWriteFunc(Pointer p)
/*      */     {
/* 3468 */       super(); } 
/* 3469 */     protected CvWriteFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(opencv_core.CvFileStorage paramCvFileStorage, String paramString, @Const Pointer paramPointer, @ByVal opencv_core.CvAttrList paramCvAttrList);
/*      */ 
/*      */     static
/*      */     {
/* 3467 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvReadFunc extends FunctionPointer
/*      */   {
/*      */     public CvReadFunc(Pointer p)
/*      */     {
/* 3461 */       super(); } 
/* 3462 */     protected CvReadFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native Pointer call(opencv_core.CvFileStorage paramCvFileStorage, opencv_core.CvFileNode paramCvFileNode);
/*      */ 
/*      */     static
/*      */     {
/* 3460 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvReleaseFunc extends FunctionPointer
/*      */   {
/*      */     public CvReleaseFunc(Pointer p)
/*      */     {
/* 3454 */       super(); } 
/* 3455 */     protected CvReleaseFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(PointerPointer paramPointerPointer);
/*      */ 
/*      */     static
/*      */     {
/* 3453 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvIsInstanceFunc extends FunctionPointer
/*      */   {
/*      */     public CvIsInstanceFunc(Pointer p)
/*      */     {
/* 3447 */       super(); } 
/* 3448 */     protected CvIsInstanceFunc() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(@Const Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/* 3446 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvFileNode extends Pointer
/*      */   {
/*      */     public CvFileNode()
/*      */     {
/* 3423 */       allocate(); } 
/* 3424 */     public CvFileNode(int size) { allocateArray(size); } 
/* 3425 */     public CvFileNode(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3430 */     public CvFileNode position(int position) { return (CvFileNode)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int tag();
/*      */ 
/*      */     public native CvFileNode tag(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvTypeInfo info();
/*      */ 
/*      */     public native CvFileNode info(opencv_core.CvTypeInfo paramCvTypeInfo);
/*      */ 
/*      */     @Name({"data.f"})
/*      */     public native double data_f();
/*      */ 
/*      */     public native CvFileNode data_f(double paramDouble);
/*      */ 
/*      */     @Name({"data.i"})
/*      */     public native int data_i();
/*      */ 
/*      */     public native CvFileNode data_i(int paramInt);
/*      */ 
/*      */     @Name({"data.str"})
/*      */     @ByRef
/*      */     public native opencv_core.CvString data_str();
/*      */ 
/*      */     public native CvFileNode data_str(opencv_core.CvString paramCvString);
/*      */ 
/*      */     @Name({"data.seq"})
/*      */     public native opencv_core.CvSeq data_seq();
/*      */ 
/*      */     public native CvFileNode data_seq(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     @Name({"data.map"})
/*      */     public native opencv_core.CvFileNodeHash data_map();
/*      */ 
/*      */     public native CvFileNode data_map(opencv_core.CvFileNodeHash paramCvFileNodeHash);
/*      */ 
/*      */     static
/*      */     {
/* 3422 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvFileNodeHash extends Pointer
/*      */   {
/*      */     public CvFileNodeHash()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFileNodeHash(Pointer p)
/*      */     {
/* 3418 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 3416 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvStringHashNode extends Pointer
/*      */   {
/*      */     public CvStringHashNode()
/*      */     {
/* 3400 */       allocate(); } 
/* 3401 */     public CvStringHashNode(int size) { allocateArray(size); } 
/* 3402 */     public CvStringHashNode(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3407 */     public CvStringHashNode position(int position) { return (CvStringHashNode)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int hashval();
/*      */ 
/*      */     public native CvStringHashNode hashval(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvString str();
/*      */ 
/*      */     public native CvStringHashNode str(opencv_core.CvString paramCvString);
/*      */ 
/*      */     public native CvStringHashNode next();
/*      */ 
/*      */     public native CvStringHashNode next(CvStringHashNode paramCvStringHashNode);
/*      */ 
/*      */     static
/*      */     {
/* 3399 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvString extends Pointer
/*      */   {
/*      */     public CvString()
/*      */     {
/* 3383 */       allocate(); } 
/* 3384 */     public CvString(int size) { allocateArray(size); } 
/* 3385 */     public CvString(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3390 */     public CvString position(int position) { return (CvString)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int len();
/*      */ 
/*      */     public native CvString len(int paramInt);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer ptr();
/*      */ 
/*      */     public native CvString ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 3382 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvAttrList extends Pointer
/*      */   {
/*      */     public CvAttrList()
/*      */     {
/* 3326 */       allocate(); } 
/* 3327 */     public CvAttrList(int size) { allocateArray(size); } 
/* 3328 */     public CvAttrList(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3333 */     public CvAttrList position(int position) { return (CvAttrList)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"const char**"})
/*      */     public native PointerPointer attr();
/*      */ 
/*      */     public native CvAttrList attr(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native CvAttrList next();
/*      */ 
/*      */     public native CvAttrList next(CvAttrList paramCvAttrList);
/*      */ 
/*      */     static
/*      */     {
/* 3325 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvFileStorage extends Pointer
/*      */   {
/*      */     public CvFileStorage()
/*      */     {
/*      */     }
/*      */ 
/*      */     public CvFileStorage(Pointer p)
/*      */     {
/* 3290 */       super();
/*      */     }
/*      */     public static CvFileStorage open(String filename, opencv_core.CvMemStorage memstorage, int flags) {
/* 3293 */       return open(filename, memstorage, flags, null);
/*      */     }
/*      */     public static CvFileStorage open(String filename, opencv_core.CvMemStorage memstorage, int flags, String encoding) {
/* 3296 */       CvFileStorage f = opencv_core.cvOpenFileStorage(filename, memstorage, flags, encoding);
/* 3297 */       if (f != null) {
/* 3298 */         f.deallocator(new ReleaseDeallocator(f));
/*      */       }
/* 3300 */       return f;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 3304 */       deallocate();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 3288 */       Loader.load();
/*      */     }
/*      */ 
/*      */     protected static class ReleaseDeallocator extends opencv_core.CvFileStorage
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_core.CvFileStorage p)
/*      */       {
/* 3307 */         super(); } 
/* 3308 */       public void deallocate() { opencv_core.cvReleaseFileStorage(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSeqReader extends Pointer
/*      */   {
/*      */     public CvSeqReader()
/*      */     {
/* 3241 */       allocate(); } 
/* 3242 */     public CvSeqReader(int size) { allocateArray(size); } 
/* 3243 */     public CvSeqReader(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3248 */     public CvSeqReader position(int position) { return (CvSeqReader)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int header_size();
/*      */ 
/*      */     public native CvSeqReader header_size(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvSeq seq();
/*      */ 
/*      */     public native CvSeqReader seq(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     public native opencv_core.CvSeqBlock block();
/*      */ 
/*      */     public native CvSeqReader block(opencv_core.CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer ptr();
/*      */ 
/*      */     public native CvSeqReader ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer block_min();
/*      */ 
/*      */     public native CvSeqReader block_min(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer block_max();
/*      */ 
/*      */     public native CvSeqReader block_max(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int delta_index();
/*      */ 
/*      */     public native CvSeqReader delta_index(int paramInt);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer prev_elem();
/*      */ 
/*      */     public native CvSeqReader prev_elem(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 3240 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSeqWriter extends Pointer
/*      */   {
/*      */     public CvSeqWriter()
/*      */     {
/* 3218 */       allocate(); } 
/* 3219 */     public CvSeqWriter(int size) { allocateArray(size); } 
/* 3220 */     public CvSeqWriter(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3225 */     public CvSeqWriter position(int position) { return (CvSeqWriter)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int header_size();
/*      */ 
/*      */     public native CvSeqWriter header_size(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvSeq seq();
/*      */ 
/*      */     public native CvSeqWriter seq(opencv_core.CvSeq paramCvSeq);
/*      */ 
/*      */     public native opencv_core.CvSeqBlock block();
/*      */ 
/*      */     public native CvSeqWriter block(opencv_core.CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer ptr();
/*      */ 
/*      */     public native CvSeqWriter ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer block_min();
/*      */ 
/*      */     public native CvSeqWriter block_min(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer block_max();
/*      */ 
/*      */     public native CvSeqWriter block_max(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 3217 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvContour extends opencv_core.CvSeq
/*      */   {
/*      */     public CvContour()
/*      */     {
/* 3076 */       allocate(); } 
/* 3077 */     public CvContour(int size) { allocateArray(size); } 
/* 3078 */     public CvContour(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3083 */     public CvContour position(int position) { return (CvContour)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvRect rect();
/*      */ 
/*      */     public native CvContour rect(opencv_core.CvRect paramCvRect);
/*      */ 
/*      */     public native int color();
/*      */ 
/*      */     public native CvContour color(int paramInt);
/*      */ 
/*      */     public native int reserved(int paramInt);
/*      */ 
/*      */     public native CvContour reserved(int paramInt1, int paramInt2);
/*      */   }
/*      */ 
/*      */   public static class CvChain extends opencv_core.CvSeq
/*      */   {
/*      */     public CvChain()
/*      */     {
/* 3062 */       allocate(); } 
/* 3063 */     public CvChain(int size) { allocateArray(size); } 
/* 3064 */     public CvChain(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3069 */     public CvChain position(int position) { return (CvChain)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint origin();
/*      */ 
/*      */     public native CvChain origin(opencv_core.CvPoint paramCvPoint);
/*      */   }
/*      */ 
/*      */   public static class CvGraph extends opencv_core.CvSet
/*      */   {
/*      */     public CvGraph()
/*      */     {
/* 3040 */       allocate(); zero(); } 
/* 3041 */     public CvGraph(int size) { allocateArray(size); zero(); } 
/* 3042 */     public CvGraph(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3047 */     public CvGraph position(int position) { return (CvGraph)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvGraph create(int graph_flags, int header_size, int vtx_size, int edge_size, opencv_core.CvMemStorage storage)
/*      */     {
/* 3052 */       return opencv_core.cvCreateGraph(graph_flags, header_size, vtx_size, edge_size, storage);
/*      */     }
/*      */ 
/*      */     public native opencv_core.CvSet edges();
/*      */ 
/*      */     public native CvGraph edges(opencv_core.CvSet paramCvSet);
/*      */   }
/*      */ 
/*      */   public static class CvGraphVtx2D extends opencv_core.CvGraphVtx
/*      */   {
/*      */     public CvGraphVtx2D()
/*      */     {
/* 3026 */       allocate(); } 
/* 3027 */     public CvGraphVtx2D(int size) { allocateArray(size); } 
/* 3028 */     public CvGraphVtx2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3033 */     public CvGraphVtx2D position(int position) { return (CvGraphVtx2D)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvPoint2D32f ptr();
/*      */ 
/*      */     public native CvGraphVtx2D ptr(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */   }
/*      */ 
/*      */   public static class CvGraphVtx extends Pointer
/*      */   {
/*      */     public CvGraphVtx()
/*      */     {
/* 3011 */       allocate(); } 
/* 3012 */     public CvGraphVtx(int size) { allocateArray(size); } 
/* 3013 */     public CvGraphVtx(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3018 */     public CvGraphVtx position(int position) { return (CvGraphVtx)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvGraphVtx flags(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvGraphEdge first();
/*      */ 
/*      */     public native CvGraphVtx first(opencv_core.CvGraphEdge paramCvGraphEdge);
/*      */ 
/*      */     static
/*      */     {
/* 3010 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvGraphEdge extends Pointer
/*      */   {
/*      */     public CvGraphEdge()
/*      */     {
/* 2993 */       allocate(); } 
/* 2994 */     public CvGraphEdge(int size) { allocateArray(size); } 
/* 2995 */     public CvGraphEdge(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3000 */     public CvGraphEdge position(int position) { return (CvGraphEdge)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvGraphEdge flags(int paramInt);
/*      */ 
/*      */     public native float weight();
/*      */ 
/*      */     public native CvGraphEdge weight(float paramFloat);
/*      */ 
/*      */     public native CvGraphEdge next(int paramInt);
/*      */ 
/*      */     public native CvGraphEdge next(int paramInt, CvGraphEdge paramCvGraphEdge);
/*      */ 
/*      */     public native opencv_core.CvGraphVtx vtx(int paramInt);
/*      */ 
/*      */     public native CvGraphEdge vtx(int paramInt, opencv_core.CvGraphVtx paramCvGraphVtx);
/*      */ 
/*      */     static
/*      */     {
/* 2992 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSet extends opencv_core.CvSeq
/*      */   {
/*      */     public CvSet()
/*      */     {
/* 2965 */       allocate(); zero(); } 
/* 2966 */     public CvSet(int size) { allocateArray(size); zero(); } 
/* 2967 */     public CvSet(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2972 */     public CvSet position(int position) { return (CvSet)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvSet create(int set_flags, int header_size, int elem_size, opencv_core.CvMemStorage storage)
/*      */     {
/* 2977 */       return opencv_core.cvCreateSet(set_flags, header_size, elem_size, storage);
/*      */     }
/*      */ 
/*      */     public native opencv_core.CvSetElem free_elems();
/*      */ 
/*      */     public native CvSet free_elems(opencv_core.CvSetElem paramCvSetElem);
/*      */ 
/*      */     public native int active_count();
/*      */ 
/*      */     public native CvSet active_count(int paramInt);
/*      */   }
/*      */ 
/*      */   public static class CvSetElem extends Pointer
/*      */   {
/*      */     public CvSetElem()
/*      */     {
/* 2950 */       allocate(); } 
/* 2951 */     public CvSetElem(int size) { allocateArray(size); } 
/* 2952 */     public CvSetElem(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2957 */     public CvSetElem position(int position) { return (CvSetElem)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvSetElem flags(int paramInt);
/*      */ 
/*      */     public native CvSetElem next_free();
/*      */ 
/*      */     public native CvSetElem next_free(CvSetElem paramCvSetElem);
/*      */ 
/*      */     static
/*      */     {
/* 2949 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSeq extends opencv_core.CvArr
/*      */   {
/*      */     public CvSeq()
/*      */     {
/* 2910 */       allocate(); zero(); } 
/* 2911 */     public CvSeq(int size) { allocateArray(size); zero(); } 
/* 2912 */     public CvSeq(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2917 */     public CvSeq position(int position) { return (CvSeq)super.position(position); }
/*      */ 
/*      */ 
/*      */     public static CvSeq create(int seq_flags, int header_size, int elem_size, opencv_core.CvMemStorage storage)
/*      */     {
/* 2922 */       return opencv_core.cvCreateSeq(seq_flags, header_size, elem_size, storage);
/*      */     }
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native CvSeq flags(int paramInt);
/*      */ 
/*      */     public native int header_size();
/*      */ 
/*      */     public native CvSeq header_size(int paramInt);
/*      */ 
/*      */     public native CvSeq h_prev();
/*      */ 
/*      */     public native CvSeq h_prev(CvSeq paramCvSeq);
/*      */ 
/*      */     public native CvSeq h_next();
/*      */ 
/*      */     public native CvSeq h_next(CvSeq paramCvSeq);
/*      */ 
/*      */     public native CvSeq v_prev();
/*      */ 
/*      */     public native CvSeq v_prev(CvSeq paramCvSeq);
/*      */ 
/*      */     public native CvSeq v_next();
/*      */ 
/*      */     public native CvSeq v_next(CvSeq paramCvSeq);
/*      */ 
/*      */     public native int total();
/*      */ 
/*      */     public native CvSeq total(int paramInt);
/*      */ 
/*      */     public native int elem_size();
/*      */ 
/*      */     public native CvSeq elem_size(int paramInt);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer block_max();
/*      */ 
/*      */     public native CvSeq block_max(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer ptr();
/*      */ 
/*      */     public native CvSeq ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int delta_elems();
/*      */ 
/*      */     public native CvSeq delta_elems(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvMemStorage storage();
/*      */ 
/*      */     public native CvSeq storage(opencv_core.CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native opencv_core.CvSeqBlock free_blocks();
/*      */ 
/*      */     public native CvSeq free_blocks(opencv_core.CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */     public native opencv_core.CvSeqBlock first();
/*      */ 
/*      */     public native CvSeq first(opencv_core.CvSeqBlock paramCvSeqBlock);
/*      */   }
/*      */ 
/*      */   public static class CvSeqBlock extends Pointer
/*      */   {
/*      */     public CvSeqBlock()
/*      */     {
/* 2891 */       allocate(); } 
/* 2892 */     public CvSeqBlock(int size) { allocateArray(size); } 
/* 2893 */     public CvSeqBlock(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2898 */     public CvSeqBlock position(int position) { return (CvSeqBlock)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvSeqBlock prev();
/*      */ 
/*      */     public native CvSeqBlock prev(CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */     public native CvSeqBlock next();
/*      */ 
/*      */     public native CvSeqBlock next(CvSeqBlock paramCvSeqBlock);
/*      */ 
/*      */     public native int start_index();
/*      */ 
/*      */     public native CvSeqBlock start_index(int paramInt);
/*      */ 
/*      */     public native int count();
/*      */ 
/*      */     public native CvSeqBlock count(int paramInt);
/*      */ 
/*      */     @Cast({"schar*"})
/*      */     public native BytePointer data();
/*      */ 
/*      */     public native CvSeqBlock data(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 2890 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMemStoragePos extends Pointer
/*      */   {
/*      */     public CvMemStoragePos()
/*      */     {
/* 2874 */       allocate(); } 
/* 2875 */     public CvMemStoragePos(int size) { allocateArray(size); } 
/* 2876 */     public CvMemStoragePos(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2881 */     public CvMemStoragePos position(int position) { return (CvMemStoragePos)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvMemBlock top();
/*      */ 
/*      */     public native CvMemStoragePos top(opencv_core.CvMemBlock paramCvMemBlock);
/*      */ 
/*      */     public native int free_space();
/*      */ 
/*      */     public native CvMemStoragePos free_space(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2873 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMemStorage extends Pointer
/*      */   {
/*      */     public CvMemStorage()
/*      */     {
/* 2831 */       allocate(); zero(); } 
/* 2832 */     public CvMemStorage(int size) { allocateArray(size); zero(); } 
/* 2833 */     public CvMemStorage(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2838 */     public CvMemStorage position(int position) { return (CvMemStorage)super.position(position); }
/*      */ 
/*      */     public static CvMemStorage create(int block_size)
/*      */     {
/* 2842 */       CvMemStorage m = opencv_core.cvCreateMemStorage(block_size);
/* 2843 */       if (m != null) {
/* 2844 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 2846 */       return m;
/*      */     }
/*      */     public static CvMemStorage create() {
/* 2849 */       return create(0);
/*      */     }
/*      */ 
/*      */     public void release() {
/* 2853 */       deallocate();
/*      */     }
/*      */ 
/*      */     public native int signature();
/*      */ 
/*      */     public native CvMemStorage signature(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvMemBlock bottom();
/*      */ 
/*      */     public native CvMemStorage bottom(opencv_core.CvMemBlock paramCvMemBlock);
/*      */ 
/*      */     public native opencv_core.CvMemBlock top();
/*      */ 
/*      */     public native CvMemStorage top(opencv_core.CvMemBlock paramCvMemBlock);
/*      */ 
/*      */     public native CvMemStorage parent();
/*      */ 
/*      */     public native CvMemStorage parent(CvMemStorage paramCvMemStorage);
/*      */ 
/*      */     public native int block_size();
/*      */ 
/*      */     public native CvMemStorage block_size(int paramInt);
/*      */ 
/*      */     public native int free_space();
/*      */ 
/*      */     public native CvMemStorage free_space(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2830 */       Loader.load();
/*      */     }
/*      */ 
/*      */     protected static class ReleaseDeallocator extends opencv_core.CvMemStorage
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_core.CvMemStorage p)
/*      */       {
/* 2856 */         super(); } 
/* 2857 */       public void deallocate() { opencv_core.cvReleaseMemStorage(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMemBlock extends Pointer
/*      */   {
/*      */     public CvMemBlock()
/*      */     {
/* 2813 */       allocate(); } 
/* 2814 */     public CvMemBlock(int size) { allocateArray(size); } 
/* 2815 */     public CvMemBlock(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2820 */     public CvMemBlock position(int position) { return (CvMemBlock)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native CvMemBlock prev();
/*      */ 
/*      */     public native CvMemBlock prev(CvMemBlock paramCvMemBlock);
/*      */ 
/*      */     public native CvMemBlock next();
/*      */ 
/*      */     public native CvMemBlock next(CvMemBlock paramCvMemBlock);
/*      */ 
/*      */     static
/*      */     {
/* 2812 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvScalar extends Pointer
/*      */   {
/* 2784 */     public static final CvScalar ZERO = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);
/* 2785 */     public static final CvScalar ONE = new CvScalar().val(0, 1.0D).val(1, 1.0D).val(2, 1.0D).val(3, 1.0D);
/* 2786 */     public static final CvScalar ONEHALF = new CvScalar().val(0, 0.5D).val(1, 0.5D).val(2, 0.5D).val(3, 0.5D);
/* 2787 */     public static final CvScalar ALPHA1 = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 1.0D);
/* 2788 */     public static final CvScalar ALPHA255 = new CvScalar().val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 255.0D);
/*      */ 
/* 2790 */     public static final CvScalar WHITE = opencv_core.CV_RGB(255.0D, 255.0D, 255.0D);
/* 2791 */     public static final CvScalar GRAY = opencv_core.CV_RGB(128.0D, 128.0D, 128.0D);
/* 2792 */     public static final CvScalar BLACK = opencv_core.CV_RGB(0.0D, 0.0D, 0.0D);
/* 2793 */     public static final CvScalar RED = opencv_core.CV_RGB(255.0D, 0.0D, 0.0D);
/* 2794 */     public static final CvScalar GREEN = opencv_core.CV_RGB(0.0D, 255.0D, 0.0D);
/* 2795 */     public static final CvScalar BLUE = opencv_core.CV_RGB(0.0D, 0.0D, 255.0D);
/* 2796 */     public static final CvScalar CYAN = opencv_core.CV_RGB(0.0D, 255.0D, 255.0D);
/* 2797 */     public static final CvScalar MAGENTA = opencv_core.CV_RGB(255.0D, 0.0D, 255.0D);
/* 2798 */     public static final CvScalar YELLOW = opencv_core.CV_RGB(255.0D, 255.0D, 0.0D);
/*      */ 
/*      */     public CvScalar()
/*      */     {
/* 2722 */       allocate(); } 
/* 2723 */     public CvScalar(int size) { allocateArray(size); } 
/* 2724 */     public CvScalar(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2729 */     public CvScalar position(int position) { return (CvScalar)super.position(position); }
/*      */ 
/*      */     public CvScalar(double val0, double val1, double val2, double val3)
/*      */     {
/* 2733 */       allocate(); val(0, val0).val(1, val1).val(2, val2).val(3, val3); } 
/*      */     public native double val(int paramInt);
/*      */ 
/*      */     public native CvScalar val(int paramInt, double paramDouble);
/*      */ 
/* 2737 */     public double getVal(int i) { return val(i); } 
/* 2738 */     public CvScalar setVal(int i, double val) { return val(i, val); } 
/*      */     @MemberGetter
/*      */     @Name({"val"})
/*      */     public native DoublePointer getDoublePointerVal();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"double*"})
/*      */     @Name({"val"})
/*      */     public native LongPointer getLongPointerVal();
/*      */ 
/* 2747 */     public void scale(double s) { for (int i = 0; i < 4; i++)
/* 2748 */         val(i, val(i) * s); }
/*      */ 
/*      */     public double red()
/*      */     {
/* 2752 */       return val(2); } 
/* 2753 */     public double green() { return val(1); } 
/* 2754 */     public double blue() { return val(0); } 
/* 2755 */     public CvScalar red(double r) { val(2, r); return this; } 
/* 2756 */     public CvScalar green(double g) { val(1, g); return this; } 
/* 2757 */     public CvScalar blue(double b) { val(0, b); return this; }
/*      */ 
/*      */     public double magnitude() {
/* 2760 */       return Math.sqrt(val(0) * val(0) + val(1) * val(1) + val(2) * val(2) + val(3) * val(3));
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2764 */       if (isNull()) {
/* 2765 */         return super.toString();
/*      */       }
/* 2767 */       if (capacity() == 0) {
/* 2768 */         return "(" + (float)val(0) + ", " + (float)val(1) + ", " + (float)val(2) + ", " + (float)val(3) + ")";
/*      */       }
/*      */ 
/* 2771 */       String s = "";
/* 2772 */       int p = position();
/* 2773 */       for (int i = 0; i < capacity(); i++) {
/* 2774 */         position(i);
/* 2775 */         s = s + (i == 0 ? "(" : " (") + (float)val(0) + ", " + (float)val(1) + ", " + (float)val(2) + ", " + (float)val(3) + ")";
/*      */       }
/*      */ 
/* 2778 */       position(p);
/* 2779 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2721 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSlice extends Pointer
/*      */   {
/*      */     public CvSlice()
/*      */     {
/* 2700 */       allocate(); } 
/* 2701 */     public CvSlice(int size) { allocateArray(size); } 
/* 2702 */     public CvSlice(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2707 */     public CvSlice position(int position) { return (CvSlice)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int start_index();
/*      */ 
/*      */     public native CvSlice start_index(int paramInt);
/*      */ 
/*      */     public native int end_index();
/*      */ 
/*      */     public native CvSlice end_index(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2699 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvLineIterator extends Pointer
/*      */   {
/*      */     public CvLineIterator()
/*      */     {
/* 2677 */       allocate(); } 
/* 2678 */     public CvLineIterator(int size) { allocateArray(size); } 
/* 2679 */     public CvLineIterator(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2684 */     public CvLineIterator position(int position) { return (CvLineIterator)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uchar*"})
/*      */     public native BytePointer ptr();
/*      */ 
/*      */     public native CvLineIterator ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int err();
/*      */ 
/*      */     public native CvLineIterator err(int paramInt);
/*      */ 
/*      */     public native int plus_delta();
/*      */ 
/*      */     public native CvLineIterator plus_delta(int paramInt);
/*      */ 
/*      */     public native int minus_delta();
/*      */ 
/*      */     public native CvLineIterator minus_delta(int paramInt);
/*      */ 
/*      */     public native int plus_step();
/*      */ 
/*      */     public native CvLineIterator plus_step(int paramInt);
/*      */ 
/*      */     public native int minus_step();
/*      */ 
/*      */     public native CvLineIterator minus_step(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 2676 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvBox2D extends Pointer
/*      */   {
/*      */     public CvBox2D()
/*      */     {
/* 2638 */       allocate(); } 
/* 2639 */     public CvBox2D(int size) { allocateArray(size); } 
/* 2640 */     public CvBox2D(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2645 */     public CvBox2D position(int position) { return (CvBox2D)super.position(position); }
/*      */ 
/*      */     public CvBox2D(opencv_core.CvPoint2D32f center, opencv_core.CvSize2D32f size, float angle)
/*      */     {
/* 2649 */       allocate(); center(center).size(size).angle(angle); } 
/*      */     @ByRef
/*      */     public native opencv_core.CvPoint2D32f center();
/*      */ 
/*      */     public native CvBox2D center(opencv_core.CvPoint2D32f paramCvPoint2D32f);
/*      */ 
/*      */     @ByRef
/*      */     public native opencv_core.CvSize2D32f size();
/*      */ 
/*      */     public native CvBox2D size(opencv_core.CvSize2D32f paramCvSize2D32f);
/*      */ 
/*      */     public native float angle();
/*      */ 
/*      */     public native CvBox2D angle(float paramFloat);
/*      */ 
/* 2657 */     public String toString() { if (isNull()) {
/* 2658 */         return super.toString();
/*      */       }
/* 2660 */       if (capacity() == 0) {
/* 2661 */         return "(" + center() + ", " + size() + ", " + angle() + ")";
/*      */       }
/* 2663 */       String s = "";
/* 2664 */       int p = position();
/* 2665 */       for (int i = 0; i < capacity(); i++) {
/* 2666 */         position(i);
/* 2667 */         s = s + (i == 0 ? "(" : " (") + center() + ", " + size() + ", " + angle() + ")";
/*      */       }
/* 2669 */       position(p);
/* 2670 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2637 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSize2D32f extends Pointer
/*      */   {
/*      */     public CvSize2D32f()
/*      */     {
/* 2597 */       allocate(); } 
/* 2598 */     public CvSize2D32f(int size) { allocateArray(size); } 
/* 2599 */     public CvSize2D32f(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2604 */     public CvSize2D32f position(int position) { return (CvSize2D32f)super.position(position); }
/*      */ 
/*      */     public CvSize2D32f(float width, float height)
/*      */     {
/* 2608 */       allocate(); width(width).height(height); } 
/*      */     public native float width();
/*      */ 
/*      */     public native CvSize2D32f width(float paramFloat);
/*      */ 
/*      */     public native float height();
/*      */ 
/*      */     public native CvSize2D32f height(float paramFloat);
/*      */ 
/* 2615 */     public String toString() { if (isNull()) {
/* 2616 */         return super.toString();
/*      */       }
/* 2618 */       if (capacity() == 0) {
/* 2619 */         return "(" + width() + ", " + height() + ")";
/*      */       }
/* 2621 */       String s = "";
/* 2622 */       int p = position();
/* 2623 */       for (int i = 0; i < capacity(); i++) {
/* 2624 */         position(i);
/* 2625 */         s = s + (i == 0 ? "(" : " (") + width() + ", " + height() + ")";
/*      */       }
/* 2627 */       position(p);
/* 2628 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2596 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSize extends Pointer
/*      */   {
/* 2589 */     public static final CvSize ZERO = new CvSize().width(0).height(0);
/*      */ 
/*      */     public CvSize()
/*      */     {
/* 2555 */       allocate(); } 
/* 2556 */     public CvSize(int size) { allocateArray(size); } 
/* 2557 */     public CvSize(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2562 */     public CvSize position(int position) { return (CvSize)super.position(position); }
/*      */ 
/*      */     public CvSize(int width, int height)
/*      */     {
/* 2566 */       allocate(); width(width).height(height); } 
/*      */     public native int width();
/*      */ 
/*      */     public native CvSize width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native CvSize height(int paramInt);
/*      */ 
/* 2573 */     public String toString() { if (isNull()) {
/* 2574 */         return super.toString();
/*      */       }
/* 2576 */       if (capacity() == 0) {
/* 2577 */         return "(" + width() + ", " + height() + ")";
/*      */       }
/* 2579 */       String s = "";
/* 2580 */       int p = position();
/* 2581 */       for (int i = 0; i < capacity(); i++) {
/* 2582 */         position(i);
/* 2583 */         s = s + (i == 0 ? "(" : " (") + width() + ", " + height() + ")";
/*      */       }
/* 2585 */       position(p);
/* 2586 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2554 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPoint3D64f extends Pointer
/*      */   {
/*      */     public CvPoint3D64f()
/*      */     {
/* 2468 */       allocate(); } 
/* 2469 */     public CvPoint3D64f(int size) { allocateArray(size); } 
/* 2470 */     public CvPoint3D64f(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2475 */     public CvPoint3D64f position(int position) { return (CvPoint3D64f)super.position(position); }
/*      */ 
/*      */     public CvPoint3D64f(double[] pts, int offset, int length)
/*      */     {
/* 2479 */       this(length / 3);
/* 2480 */       put(pts, offset, length);
/*      */     }
/*      */     public CvPoint3D64f(double[] pts) {
/* 2483 */       this(pts, 0, pts.length); } 
/*      */     public native double x();
/*      */ 
/*      */     public native CvPoint3D64f x(double paramDouble);
/*      */ 
/*      */     public native double y();
/*      */ 
/*      */     public native CvPoint3D64f y(double paramDouble);
/*      */ 
/*      */     public native double z();
/*      */ 
/*      */     public native CvPoint3D64f z(double paramDouble);
/*      */ 
/* 2491 */     public double[] get() { double[] pts = new double[this.capacity == 0 ? 3 : 3 * this.capacity];
/* 2492 */       get(pts);
/* 2493 */       return pts; }
/*      */ 
/*      */     public CvPoint3D64f get(double[] pts) {
/* 2496 */       return get(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint3D64f get(double[] pts, int offset, int length) {
/* 2499 */       for (int i = 0; i < length / 3; i++) {
/* 2500 */         position(i);
/* 2501 */         pts[(offset + i * 3)] = x();
/* 2502 */         pts[(offset + i * 3 + 1)] = y();
/* 2503 */         pts[(offset + i * 3 + 2)] = z();
/*      */       }
/* 2505 */       return position(0);
/*      */     }
/*      */ 
/*      */     public final CvPoint3D64f put(double[] pts, int offset, int length) {
/* 2509 */       for (int i = 0; i < length / 3; i++) {
/* 2510 */         position(i).put(pts[(offset + i * 3)], pts[(offset + i * 3 + 1)], pts[(offset + i * 3 + 2)]);
/*      */       }
/* 2512 */       return position(0);
/*      */     }
/*      */     public final CvPoint3D64f put(double[] pts) {
/* 2515 */       return put(pts, 0, pts.length);
/*      */     }
/*      */ 
/*      */     public CvPoint3D64f put(double x, double y, double z) {
/* 2519 */       return x(x()).y(y()).z(z());
/*      */     }
/*      */     public CvPoint3D64f put(opencv_core.CvPoint o) {
/* 2522 */       return x(o.x()).y(o.y()).z(0.0D);
/*      */     }
/*      */     public CvPoint3D64f put(opencv_core.CvPoint2D32f o) {
/* 2525 */       return x(o.x()).y(o.y()).z(0.0D);
/*      */     }
/*      */     public CvPoint3D64f put(opencv_core.CvPoint2D64f o) {
/* 2528 */       return x(o.x()).y(o.y()).z(0.0D);
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2532 */       if (isNull()) {
/* 2533 */         return super.toString();
/*      */       }
/* 2535 */       if (capacity() == 0) {
/* 2536 */         return "(" + (float)x() + ", " + (float)y() + ", " + (float)z() + ")";
/*      */       }
/* 2538 */       String s = "";
/* 2539 */       int p = position();
/* 2540 */       for (int i = 0; i < capacity(); i++) {
/* 2541 */         position(i);
/* 2542 */         s = s + (i == 0 ? "(" : " (") + (float)x() + ", " + (float)y() + ", " + (float)z() + ")";
/*      */       }
/* 2544 */       position(p);
/* 2545 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2467 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPoint2D64f extends Pointer
/*      */   {
/*      */     public CvPoint2D64f()
/*      */     {
/* 2383 */       allocate(); } 
/* 2384 */     public CvPoint2D64f(int size) { allocateArray(size); } 
/* 2385 */     public CvPoint2D64f(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2390 */     public CvPoint2D64f position(int position) { return (CvPoint2D64f)super.position(position); }
/*      */ 
/*      */     public CvPoint2D64f(double[] pts, int offset, int length)
/*      */     {
/* 2394 */       this(length / 2);
/* 2395 */       put(pts, offset, length);
/*      */     }
/*      */     public CvPoint2D64f(double[] pts) {
/* 2398 */       this(pts, 0, pts.length); } 
/*      */     public native double x();
/*      */ 
/*      */     public native CvPoint2D64f x(double paramDouble);
/*      */ 
/*      */     public native double y();
/*      */ 
/*      */     public native CvPoint2D64f y(double paramDouble);
/*      */ 
/* 2405 */     public double[] get() { double[] pts = new double[this.capacity == 0 ? 2 : 2 * this.capacity];
/* 2406 */       get(pts);
/* 2407 */       return pts; }
/*      */ 
/*      */     public CvPoint2D64f get(double[] pts) {
/* 2410 */       return get(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint2D64f get(double[] pts, int offset, int length) {
/* 2413 */       for (int i = 0; i < length / 2; i++) {
/* 2414 */         position(i);
/* 2415 */         pts[(offset + i * 2)] = x();
/* 2416 */         pts[(offset + i * 2 + 1)] = y();
/*      */       }
/* 2418 */       return position(0);
/*      */     }
/*      */ 
/*      */     public final CvPoint2D64f put(double[] pts, int offset, int length) {
/* 2422 */       for (int i = 0; i < length / 2; i++) {
/* 2423 */         position(i).put(pts[(offset + i * 2)], pts[(offset + i * 2 + 1)]);
/*      */       }
/* 2425 */       return position(0);
/*      */     }
/*      */     public final CvPoint2D64f put(double[] pts) {
/* 2428 */       return put(pts, 0, pts.length);
/*      */     }
/*      */ 
/*      */     public CvPoint2D64f put(double x, double y) {
/* 2432 */       return x(x).y(y);
/*      */     }
/*      */     public CvPoint2D64f put(opencv_core.CvPoint o) {
/* 2435 */       return x(o.x()).y(o.y());
/*      */     }
/*      */     public CvPoint2D64f put(opencv_core.CvPoint2D32f o) {
/* 2438 */       return x(o.x()).y(o.y());
/*      */     }
/*      */     public CvPoint2D64f put(CvPoint2D64f o) {
/* 2441 */       return x(o.x()).y(o.y());
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2445 */       if (isNull()) {
/* 2446 */         return super.toString();
/*      */       }
/* 2448 */       if (capacity() == 0) {
/* 2449 */         return "(" + (float)x() + ", " + (float)y() + ")";
/*      */       }
/* 2451 */       String s = "";
/* 2452 */       int p = position();
/* 2453 */       for (int i = 0; i < capacity(); i++) {
/* 2454 */         position(i);
/* 2455 */         s = s + (i == 0 ? "(" : " (") + (float)x() + ", " + (float)y() + ")";
/*      */       }
/* 2457 */       position(p);
/* 2458 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2382 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPoint3D32f extends Pointer
/*      */   {
/*      */     public CvPoint3D32f()
/*      */     {
/* 2296 */       allocate(); } 
/* 2297 */     public CvPoint3D32f(int size) { allocateArray(size); } 
/* 2298 */     public CvPoint3D32f(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2303 */     public CvPoint3D32f position(int position) { return (CvPoint3D32f)super.position(position); }
/*      */ 
/*      */     public CvPoint3D32f(double[] pts, int offset, int length)
/*      */     {
/* 2307 */       this(length / 3);
/* 2308 */       put(pts, offset, length);
/*      */     }
/*      */     public CvPoint3D32f(double[] pts) {
/* 2311 */       this(pts, 0, pts.length); } 
/*      */     public native float x();
/*      */ 
/*      */     public native CvPoint3D32f x(float paramFloat);
/*      */ 
/*      */     public native float y();
/*      */ 
/*      */     public native CvPoint3D32f y(float paramFloat);
/*      */ 
/*      */     public native float z();
/*      */ 
/*      */     public native CvPoint3D32f z(float paramFloat);
/*      */ 
/* 2319 */     public double[] get() { double[] pts = new double[this.capacity == 0 ? 3 : 3 * this.capacity];
/* 2320 */       get(pts);
/* 2321 */       return pts; }
/*      */ 
/*      */     public CvPoint3D32f get(double[] pts) {
/* 2324 */       return get(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint3D32f get(double[] pts, int offset, int length) {
/* 2327 */       for (int i = 0; i < length / 3; i++) {
/* 2328 */         position(i);
/* 2329 */         pts[(offset + i * 3)] = x();
/* 2330 */         pts[(offset + i * 3 + 1)] = y();
/* 2331 */         pts[(offset + i * 3 + 2)] = z();
/*      */       }
/* 2333 */       return position(0);
/*      */     }
/*      */ 
/*      */     public final CvPoint3D32f put(double[] pts, int offset, int length) {
/* 2337 */       for (int i = 0; i < length / 3; i++) {
/* 2338 */         position(i).put(pts[(offset + i * 3)], pts[(offset + i * 3 + 1)], pts[(offset + i * 3 + 2)]);
/*      */       }
/* 2340 */       return position(0);
/*      */     }
/*      */     public final CvPoint3D32f put(double[] pts) {
/* 2343 */       return put(pts, 0, pts.length);
/*      */     }
/*      */ 
/*      */     public CvPoint3D32f put(double x, double y, double z) {
/* 2347 */       return x((float)x).y((float)y).z((float)z);
/*      */     }
/*      */     public CvPoint3D32f put(opencv_core.CvPoint o) {
/* 2350 */       return x(o.x()).y(o.y()).z(0.0F);
/*      */     }
/*      */     public CvPoint3D32f put(opencv_core.CvPoint2D32f o) {
/* 2353 */       return x(o.x()).y(o.y()).z(0.0F);
/*      */     }
/*      */     public CvPoint3D32f put(opencv_core.CvPoint2D64f o) {
/* 2356 */       return x((float)o.x()).y((float)o.y()).z(0.0F);
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2360 */       if (isNull()) {
/* 2361 */         return super.toString();
/*      */       }
/* 2363 */       if (capacity() == 0) {
/* 2364 */         return "(" + x() + ", " + y() + ", " + z() + ")";
/*      */       }
/* 2366 */       String s = "";
/* 2367 */       int p = position();
/* 2368 */       for (int i = 0; i < capacity(); i++) {
/* 2369 */         position(i);
/* 2370 */         s = s + (i == 0 ? "(" : " (") + x() + ", " + y() + ", " + z() + ")";
/*      */       }
/* 2372 */       position(p);
/* 2373 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2295 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPoint2D32f extends Pointer
/*      */   {
/*      */     public CvPoint2D32f()
/*      */     {
/* 2202 */       allocate(); } 
/* 2203 */     public CvPoint2D32f(int size) { allocateArray(size); } 
/* 2204 */     public CvPoint2D32f(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2209 */     public CvPoint2D32f position(int position) { return (CvPoint2D32f)super.position(position); }
/*      */ 
/*      */     public CvPoint2D32f(double[] pts, int offset, int length)
/*      */     {
/* 2213 */       this(length / 2);
/* 2214 */       put(pts, offset, length);
/*      */     }
/*      */     public CvPoint2D32f(double[] pts) {
/* 2217 */       this(pts, 0, pts.length); } 
/*      */     public native float x();
/*      */ 
/*      */     public native CvPoint2D32f x(float paramFloat);
/*      */ 
/*      */     public native float y();
/*      */ 
/*      */     public native CvPoint2D32f y(float paramFloat);
/*      */ 
/* 2224 */     public double[] get() { double[] pts = new double[this.capacity == 0 ? 2 : 2 * this.capacity];
/* 2225 */       get(pts);
/* 2226 */       return pts; }
/*      */ 
/*      */     public CvPoint2D32f get(double[] pts) {
/* 2229 */       return get(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint2D32f get(double[] pts, int offset, int length) {
/* 2232 */       for (int i = 0; i < length / 2; i++) {
/* 2233 */         position(i);
/* 2234 */         pts[(offset + i * 2)] = x();
/* 2235 */         pts[(offset + i * 2 + 1)] = y();
/*      */       }
/* 2237 */       return position(0);
/*      */     }
/*      */ 
/*      */     public final CvPoint2D32f put(double[] pts, int offset, int length) {
/* 2241 */       for (int i = 0; i < length / 2; i++) {
/* 2242 */         position(i).put(pts[(offset + i * 2)], pts[(offset + i * 2 + 1)]);
/*      */       }
/* 2244 */       return position(0);
/*      */     }
/*      */     public final CvPoint2D32f put(double[] pts) {
/* 2247 */       return put(pts, 0, pts.length);
/*      */     }
/*      */ 
/*      */     public CvPoint2D32f put(double x, double y) {
/* 2251 */       return x((float)x).y((float)y);
/*      */     }
/*      */     public CvPoint2D32f put(opencv_core.CvPoint o) {
/* 2254 */       return x(o.x()).y(o.y());
/*      */     }
/*      */     public CvPoint2D32f put(CvPoint2D32f o) {
/* 2257 */       return x(o.x()).y(o.y());
/*      */     }
/*      */     public CvPoint2D32f put(opencv_core.CvPoint2D64f o) {
/* 2260 */       return x((float)o.x()).y((float)o.y());
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2264 */       if (isNull()) {
/* 2265 */         return super.toString();
/*      */       }
/* 2267 */       if (capacity() == 0) {
/* 2268 */         return "(" + x() + ", " + y() + ")";
/*      */       }
/* 2270 */       String s = "";
/* 2271 */       int p = position();
/* 2272 */       for (int i = 0; i < capacity(); i++) {
/* 2273 */         position(i);
/* 2274 */         s = s + (i == 0 ? "(" : " (") + x() + ", " + y() + ")";
/*      */       }
/* 2276 */       position(p);
/* 2277 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2201 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvPoint extends Pointer
/*      */   {
/* 2194 */     public static final CvPoint ZERO = new CvPoint().x(0).y(0);
/*      */ 
/*      */     public CvPoint()
/*      */     {
/* 2094 */       allocate(); } 
/* 2095 */     public CvPoint(int size) { allocateArray(size); } 
/* 2096 */     public CvPoint(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2101 */     public CvPoint position(int position) { return (CvPoint)super.position(position); }
/*      */ 
/*      */     public CvPoint(int[] pts, int offset, int length)
/*      */     {
/* 2105 */       this(length / 2);
/* 2106 */       put(pts, offset, length);
/*      */     }
/*      */     public CvPoint(int[] pts) {
/* 2109 */       this(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint(byte shift, double[] pts, int offset, int length) {
/* 2112 */       this(length / 2);
/* 2113 */       put(shift, pts, offset, length);
/*      */     }
/*      */     public CvPoint(byte shift, double[] pts) {
/* 2116 */       this(shift, pts, 0, pts.length); } 
/*      */     public native int x();
/*      */ 
/*      */     public native CvPoint x(int paramInt);
/*      */ 
/*      */     public native int y();
/*      */ 
/*      */     public native CvPoint y(int paramInt);
/*      */ 
/* 2123 */     public int[] get() { int[] pts = new int[this.capacity == 0 ? 2 : 2 * this.capacity];
/* 2124 */       get(pts);
/* 2125 */       return pts; }
/*      */ 
/*      */     public CvPoint get(int[] pts) {
/* 2128 */       return get(pts, 0, pts.length);
/*      */     }
/*      */     public CvPoint get(int[] pts, int offset, int length) {
/* 2131 */       for (int i = 0; i < length / 2; i++) {
/* 2132 */         position(i);
/* 2133 */         pts[(offset + i * 2)] = x();
/* 2134 */         pts[(offset + i * 2 + 1)] = y();
/*      */       }
/* 2136 */       return position(0);
/*      */     }
/*      */ 
/*      */     public final CvPoint put(int[] pts, int offset, int length) {
/* 2140 */       for (int i = 0; i < length / 2; i++) {
/* 2141 */         position(i).put(pts[(offset + i * 2)], pts[(offset + i * 2 + 1)]);
/*      */       }
/* 2143 */       return position(0);
/*      */     }
/*      */     public final CvPoint put(int[] pts) {
/* 2146 */       return put(pts, 0, pts.length);
/*      */     }
/*      */     public final CvPoint put(byte shift, double[] pts, int offset, int length) {
/* 2149 */       int[] a = new int[length];
/* 2150 */       for (int i = 0; i < length; i++) {
/* 2151 */         a[i] = ((int)Math.round(pts[(offset + i)] * (1 << shift)));
/*      */       }
/* 2153 */       return put(a, 0, length);
/*      */     }
/*      */     public final CvPoint put(byte shift, double[] pts) {
/* 2156 */       return put(shift, pts, 0, pts.length);
/*      */     }
/*      */ 
/*      */     public CvPoint put(int x, int y) {
/* 2160 */       return x(x).y(y);
/*      */     }
/*      */     public CvPoint put(CvPoint o) {
/* 2163 */       return x(o.x()).y(o.y());
/*      */     }
/*      */     public CvPoint put(byte shift, opencv_core.CvPoint2D32f o) {
/* 2166 */       x(Math.round(o.x() * (1 << shift)));
/* 2167 */       y(Math.round(o.y() * (1 << shift)));
/* 2168 */       return this;
/*      */     }
/*      */     public CvPoint put(byte shift, opencv_core.CvPoint2D64f o) {
/* 2171 */       x((int)Math.round(o.x() * (1 << shift)));
/* 2172 */       y((int)Math.round(o.y() * (1 << shift)));
/* 2173 */       return this;
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 2177 */       if (isNull()) {
/* 2178 */         return super.toString();
/*      */       }
/* 2180 */       if (capacity() == 0) {
/* 2181 */         return "(" + x() + ", " + y() + ")";
/*      */       }
/* 2183 */       String s = "";
/* 2184 */       int p = position();
/* 2185 */       for (int i = 0; i < capacity(); i++) {
/* 2186 */         position(i);
/* 2187 */         s = s + (i == 0 ? "(" : " (") + x() + ", " + y() + ")";
/*      */       }
/* 2189 */       position(p);
/* 2190 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2093 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvTermCriteria extends Pointer
/*      */   {
/*      */     public CvTermCriteria()
/*      */     {
/* 2069 */       allocate(); } 
/* 2070 */     public CvTermCriteria(int size) { allocateArray(size); } 
/* 2071 */     public CvTermCriteria(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2076 */     public CvTermCriteria position(int position) { return (CvTermCriteria)super.position(position); }
/*      */ 
/*      */     public CvTermCriteria(int type, int max_iter, double epsilon)
/*      */     {
/* 2080 */       allocate(); type(type).max_iter(max_iter).epsilon(epsilon);
/*      */     }
/*      */ 
/*      */     public native int type();
/*      */ 
/*      */     public native CvTermCriteria type(int paramInt);
/*      */ 
/*      */     public native int max_iter();
/*      */ 
/*      */     public native CvTermCriteria max_iter(int paramInt);
/*      */ 
/*      */     public native double epsilon();
/*      */ 
/*      */     public native CvTermCriteria epsilon(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/* 2068 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvRect extends Pointer
/*      */   {
/*      */     public CvRect()
/*      */     {
/* 2009 */       allocate(); } 
/* 2010 */     public CvRect(int size) { allocateArray(size); } 
/* 2011 */     public CvRect(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2016 */     public CvRect position(int position) { return (CvRect)super.position(position); }
/*      */ 
/*      */     public CvRect(int x, int y, int width, int height)
/*      */     {
/* 2020 */       allocate(); x(x).y(y).width(width).height(height); } 
/*      */     public native int x();
/*      */ 
/*      */     public native CvRect x(int paramInt);
/*      */ 
/*      */     public native int y();
/*      */ 
/*      */     public native CvRect y(int paramInt);
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native CvRect width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native CvRect height(int paramInt);
/*      */ 
/* 2029 */     public String toString() { if (isNull()) {
/* 2030 */         return super.toString();
/*      */       }
/* 2032 */       if (capacity() == 0) {
/* 2033 */         return "(" + x() + ", " + y() + "; " + width() + ", " + height() + ")";
/*      */       }
/* 2035 */       String s = "";
/* 2036 */       int p = position();
/* 2037 */       for (int i = 0; i < capacity(); i++) {
/* 2038 */         position(i);
/* 2039 */         s = s + (i == 0 ? "(" : " (") + x() + ", " + y() + "; " + width() + ", " + height() + ")";
/*      */       }
/* 2041 */       position(p);
/* 2042 */       return s;
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 2008 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSparseMatIterator extends Pointer
/*      */   {
/*      */     public CvSparseMatIterator()
/*      */     {
/* 1984 */       allocate(); } 
/* 1985 */     public CvSparseMatIterator(int size) { allocateArray(size); } 
/* 1986 */     public CvSparseMatIterator(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1991 */     public CvSparseMatIterator position(int position) { return (CvSparseMatIterator)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native opencv_core.CvSparseMat mat();
/*      */ 
/*      */     public native CvSparseMatIterator mat(opencv_core.CvSparseMat paramCvSparseMat);
/*      */ 
/*      */     public native opencv_core.CvSparseNode node();
/*      */ 
/*      */     public native CvSparseMatIterator node(opencv_core.CvSparseNode paramCvSparseNode);
/*      */ 
/*      */     public native int curidx();
/*      */ 
/*      */     public native CvSparseMatIterator curidx(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1983 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSparseNode extends Pointer
/*      */   {
/*      */     public CvSparseNode()
/*      */     {
/* 1968 */       allocate(); } 
/* 1969 */     public CvSparseNode(int size) { allocateArray(size); } 
/* 1970 */     public CvSparseNode(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1975 */     public CvSparseNode position(int position) { return (CvSparseNode)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int hashval();
/*      */ 
/*      */     public native CvSparseNode hashval(int paramInt);
/*      */ 
/*      */     public native CvSparseNode next();
/*      */ 
/*      */     public native CvSparseNode next(CvSparseNode paramCvSparseNode);
/*      */ 
/*      */     static
/*      */     {
/* 1967 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvSparseMat extends opencv_core.CvArr
/*      */   {
/*      */     public CvSparseMat()
/*      */     {
/* 1913 */       allocate(); zero(); } 
/* 1914 */     public CvSparseMat(int size) { allocateArray(size); zero(); } 
/* 1915 */     public CvSparseMat(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1920 */     public CvSparseMat position(int position) { return (CvSparseMat)super.position(position); }
/*      */ 
/*      */     public static CvSparseMat create(int dims, int[] sizes, int type)
/*      */     {
/* 1924 */       CvSparseMat m = opencv_core.cvCreateSparseMat(dims, sizes, type);
/* 1925 */       if (m != null) {
/* 1926 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1928 */       return m;
/*      */     }
/*      */ 
/*      */     public CvSparseMat clone() {
/* 1932 */       CvSparseMat m = opencv_core.cvCloneSparseMat(this);
/* 1933 */       if (m != null) {
/* 1934 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1936 */       return m;
/*      */     }
/*      */     public void release() {
/* 1939 */       deallocate(); } 
/*      */     public native int type();
/*      */ 
/*      */     public native CvSparseMat type(int paramInt);
/*      */ 
/*      */     public native int dims();
/*      */ 
/*      */     public native CvSparseMat dims(int paramInt);
/*      */ 
/*      */     public native IntPointer refcount();
/*      */ 
/*      */     public native CvSparseMat refcount(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int hdr_refcount();
/*      */ 
/*      */     public native CvSparseMat hdr_refcount(int paramInt);
/*      */ 
/*      */     public native opencv_core.CvSet heap();
/*      */ 
/*      */     public native CvSparseMat heap(opencv_core.CvSet paramCvSet);
/*      */ 
/*      */     public native PointerPointer hashtable();
/*      */ 
/*      */     public native CvSparseMat hashtable(PointerPointer paramPointerPointer);
/*      */ 
/*      */     public native int hashsize();
/*      */ 
/*      */     public native CvSparseMat hashsize(int paramInt);
/*      */ 
/*      */     public native int valoffset();
/*      */ 
/*      */     public native CvSparseMat valoffset(int paramInt);
/*      */ 
/*      */     public native int idxoffset();
/*      */ 
/*      */     public native CvSparseMat idxoffset(int paramInt);
/*      */ 
/*      */     public native int size(int paramInt);
/*      */ 
/*      */     public native CvSparseMat size(int paramInt1, int paramInt2);
/*      */ 
/* 1942 */     protected static class ReleaseDeallocator extends opencv_core.CvSparseMat implements Pointer.Deallocator { ReleaseDeallocator(opencv_core.CvSparseMat p) { super(); } 
/* 1943 */       public void deallocate() { opencv_core.cvReleaseSparseMat(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMatND extends opencv_core.CvArr
/*      */   {
/*      */     public CvMatND()
/*      */     {
/* 1845 */       allocate(); zero(); } 
/* 1846 */     public CvMatND(int size) { allocateArray(size); zero(); } 
/* 1847 */     public CvMatND(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1852 */     public CvMatND position(int position) { return (CvMatND)super.position(position); }
/*      */ 
/*      */     public static CvMatND create(int dims, int[] sizes, int type)
/*      */     {
/* 1856 */       CvMatND m = opencv_core.cvCreateMatND(dims, sizes, type);
/* 1857 */       if (m != null) {
/* 1858 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1860 */       return m;
/*      */     }
/*      */ 
/*      */     public CvMatND clone() {
/* 1864 */       CvMatND m = opencv_core.cvCloneMatND(this);
/* 1865 */       if (m != null) {
/* 1866 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1868 */       return m;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 1872 */       deallocate(); } 
/*      */     public native int type();
/*      */ 
/*      */     public native CvMatND type(int paramInt);
/*      */ 
/*      */     public native int dims();
/*      */ 
/*      */     public native CvMatND dims(int paramInt);
/*      */ 
/*      */     public native IntPointer refcount();
/*      */ 
/*      */     public native CvMatND refcount(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int hdr_refcount();
/*      */ 
/*      */     public native CvMatND hdr_refcount(int paramInt);
/*      */ 
/*      */     @Cast({"uchar*"})
/*      */     @Name({"data.ptr"})
/*      */     public native BytePointer data_ptr();
/*      */ 
/*      */     public native CvMatND data_ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     @Name({"data.fl"})
/*      */     public native FloatPointer data_fl();
/*      */ 
/*      */     public native CvMatND data_fl(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Name({"data.db"})
/*      */     public native DoublePointer data_db();
/*      */ 
/*      */     public native CvMatND data_db(DoublePointer paramDoublePointer);
/*      */ 
/*      */     @Name({"data.i"})
/*      */     public native IntPointer data_i();
/*      */ 
/*      */     public native CvMatND data_i(IntPointer paramIntPointer);
/*      */ 
/*      */     @Name({"data.s"})
/*      */     public native ShortPointer data_s();
/*      */ 
/*      */     public native CvMatND data_s(ShortPointer paramShortPointer);
/*      */ 
/*      */     @Name({"dim", ".size"})
/*      */     public native int dim_size(int paramInt);
/*      */ 
/*      */     public native CvMatND dim_size(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"dim", ".step"})
/*      */     public native int dim_step(int paramInt);
/*      */ 
/*      */     public native CvMatND dim_step(int paramInt1, int paramInt2);
/*      */ 
/* 1875 */     protected static class ReleaseDeallocator extends opencv_core.CvMatND implements Pointer.Deallocator { ReleaseDeallocator(opencv_core.CvMatND p) { super(); } 
/* 1876 */       public void deallocate() { opencv_core.cvReleaseMatND(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvMat extends opencv_core.CvArr
/*      */   {
/* 1512 */     private int fullSize = 0;
/*      */ 
/* 1514 */     private ByteBuffer byteBuffer = null;
/* 1515 */     private ShortBuffer shortBuffer = null;
/* 1516 */     private IntBuffer intBuffer = null;
/* 1517 */     private FloatBuffer floatBuffer = null;
/* 1518 */     private DoubleBuffer doubleBuffer = null;
/*      */ 
/*      */     public CvMat()
/*      */     {
/* 1356 */       allocate(); zero(); } 
/* 1357 */     public CvMat(int size) { allocateArray(size); zero(); } 
/* 1358 */     public CvMat(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1363 */     public CvMat position(int position) { return (CvMat)super.position(position); }
/*      */ 
/*      */     public static CvMat create(int rows, int cols, int type)
/*      */     {
/* 1367 */       CvMat m = opencv_core.cvCreateMat(rows, cols, type);
/* 1368 */       if (m != null) {
/* 1369 */         m.fullSize = m.size();
/* 1370 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1372 */       return m;
/*      */     }
/*      */     public static CvMat create(int rows, int cols, int depth, int channels) {
/* 1375 */       return create(rows, cols, opencv_core.CV_MAKETYPE(depth, channels));
/*      */     }
/*      */     public static CvMat create(int rows, int cols) {
/* 1378 */       return create(rows, cols, 6, 1);
/*      */     }
/*      */ 
/*      */     public static CvMat createHeader(int rows, int cols, int type) {
/* 1382 */       CvMat m = opencv_core.cvCreateMatHeader(rows, cols, type);
/* 1383 */       if (m != null) {
/* 1384 */         m.fullSize = m.size();
/* 1385 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1387 */       return m;
/*      */     }
/*      */     public static CvMat createHeader(int rows, int cols, int depth, int channels) {
/* 1390 */       return createHeader(rows, cols, opencv_core.CV_MAKETYPE(depth, channels));
/*      */     }
/*      */     public static CvMat createHeader(int rows, int cols) {
/* 1393 */       return createHeader(rows, cols, 6, 1);
/*      */     }
/*      */ 
/*      */     public static ThreadLocal<CvMat> createThreadLocal(int rows, final int cols, final int type) {
/* 1397 */       return new ThreadLocal() {
/* 1398 */         protected opencv_core.CvMat initialValue() { return opencv_core.CvMat.create(this.val$rows, cols, type); } } ;
/*      */     }
/*      */ 
/*      */     public static ThreadLocal<CvMat> createThreadLocal(int rows, int cols, int depth, int channels) {
/* 1402 */       return createThreadLocal(rows, cols, opencv_core.CV_MAKETYPE(depth, channels));
/*      */     }
/*      */     public static ThreadLocal<CvMat> createThreadLocal(int rows, int cols) {
/* 1405 */       return createThreadLocal(rows, cols, 6, 1);
/*      */     }
/*      */ 
/*      */     public static ThreadLocal<CvMat> createHeaderThreadLocal(int rows, final int cols, final int type) {
/* 1409 */       return new ThreadLocal() {
/* 1410 */         protected opencv_core.CvMat initialValue() { return opencv_core.CvMat.createHeader(this.val$rows, cols, type); } } ;
/*      */     }
/*      */ 
/*      */     public static ThreadLocal<CvMat> createHeaderThreadLocal(int rows, int cols, int depth, int channels) {
/* 1414 */       return createHeaderThreadLocal(rows, cols, opencv_core.CV_MAKETYPE(depth, channels));
/*      */     }
/*      */     public static ThreadLocal<CvMat> createHeaderThreadLocal(int rows, int cols) {
/* 1417 */       return createHeaderThreadLocal(rows, cols, 6, 1);
/*      */     }
/*      */ 
/*      */     public CvMat clone() {
/* 1421 */       CvMat m = opencv_core.cvCloneMat(this);
/* 1422 */       if (m != null) {
/* 1423 */         m.deallocator(new ReleaseDeallocator(m));
/*      */       }
/* 1425 */       return m;
/*      */     }
/*      */ 
/*      */     public void release() {
/* 1429 */       deallocate(); } 
/*      */     @Name({"type"})
/*      */     public native int raw_type();
/*      */ 
/*      */     public native CvMat raw_type(int paramInt);
/*      */ 
/*      */     public native int step();
/*      */ 
/*      */     public native CvMat step(int paramInt);
/*      */ 
/*      */     public native IntPointer refcount();
/*      */ 
/*      */     public native CvMat refcount(IntPointer paramIntPointer);
/*      */ 
/*      */     public native int hdr_refcount();
/*      */ 
/*      */     public native CvMat hdr_refcount(int paramInt);
/*      */ 
/*      */     @Cast({"uchar*"})
/*      */     @Name({"data.ptr"})
/*      */     public native BytePointer data_ptr();
/*      */ 
/*      */     public native CvMat data_ptr(BytePointer paramBytePointer);
/*      */ 
/*      */     @Name({"data.fl"})
/*      */     public native FloatPointer data_fl();
/*      */ 
/*      */     public native CvMat data_fl(FloatPointer paramFloatPointer);
/*      */ 
/*      */     @Name({"data.db"})
/*      */     public native DoublePointer data_db();
/*      */ 
/*      */     public native CvMat data_db(DoublePointer paramDoublePointer);
/*      */ 
/*      */     @Name({"data.i"})
/*      */     public native IntPointer data_i();
/*      */ 
/*      */     public native CvMat data_i(IntPointer paramIntPointer);
/*      */ 
/*      */     @Name({"data.s"})
/*      */     public native ShortPointer data_s();
/*      */ 
/*      */     public native CvMat data_s(ShortPointer paramShortPointer);
/*      */ 
/*      */     public native int rows();
/*      */ 
/*      */     public native CvMat rows(int paramInt);
/*      */ 
/*      */     public native int cols();
/*      */ 
/*      */     public native CvMat cols(int paramInt);
/*      */ 
/* 1456 */     public int type() { return opencv_core.CV_MAT_TYPE(raw_type()); }
/*      */ 
/*      */     public void type(int depth, int cn) {
/* 1459 */       raw_type(opencv_core.CV_MAKETYPE(depth, cn) | 0x42420000);
/*      */     }
/*      */     public int depth() {
/* 1462 */       return opencv_core.CV_MAT_DEPTH(type());
/*      */     }
/*      */     public int channels() {
/* 1465 */       return opencv_core.CV_MAT_CN(type());
/*      */     }
/*      */     public int nChannels() {
/* 1468 */       return opencv_core.CV_MAT_CN(type());
/*      */     }
/*      */     public boolean isContinuous() {
/* 1471 */       return opencv_core.CV_IS_MAT_CONT(type());
/*      */     }
/*      */     public int elemSize() {
/* 1474 */       switch (depth()) { case 0:
/*      */       case 1:
/* 1476 */         return 1;
/*      */       case 2:
/*      */       case 3:
/* 1478 */         return 2;
/*      */       case 4:
/*      */       case 5:
/* 1480 */         return 4;
/*      */       case 6:
/* 1481 */         return 8; }
/* 1482 */       if (!$assertionsDisabled) throw new AssertionError();
/*      */ 
/* 1484 */       return 0;
/*      */     }
/*      */     public int length() {
/* 1487 */       return rows() * cols();
/*      */     }
/*      */     public int total() {
/* 1490 */       return rows() * cols();
/*      */     }
/*      */     public boolean empty() {
/* 1493 */       return length() == 0;
/*      */     }
/*      */ 
/*      */     public int size() {
/* 1497 */       int rows = rows();
/* 1498 */       return cols() * elemSize() * channels() + (rows > 1 ? step() * (rows - 1) : 0);
/*      */     }
/*      */     public opencv_core.CvSize cvSize() {
/* 1501 */       return opencv_core.cvSize(cols(), rows());
/*      */     }
/*      */     public void reset() {
/* 1504 */       this.fullSize = 0;
/* 1505 */       this.byteBuffer = null;
/* 1506 */       this.shortBuffer = null;
/* 1507 */       this.intBuffer = null;
/* 1508 */       this.floatBuffer = null;
/* 1509 */       this.doubleBuffer = null;
/*      */     }
/*      */ 
/*      */     private int fullSize() {
/* 1513 */       return this.fullSize = size();
/*      */     }
/*      */ 
/*      */     public ByteBuffer getByteBuffer()
/*      */     {
/* 1520 */       if (this.byteBuffer == null) {
/* 1521 */         this.byteBuffer = data_ptr().capacity(fullSize()).asBuffer();
/*      */       }
/* 1523 */       this.byteBuffer.position(0);
/* 1524 */       return this.byteBuffer;
/*      */     }
/*      */     public ShortBuffer getShortBuffer() {
/* 1527 */       if (this.shortBuffer == null) {
/* 1528 */         this.shortBuffer = data_s().capacity(fullSize() / 2).asBuffer();
/*      */       }
/* 1530 */       this.shortBuffer.position(0);
/* 1531 */       return this.shortBuffer;
/*      */     }
/*      */     public IntBuffer getIntBuffer() {
/* 1534 */       if (this.intBuffer == null) {
/* 1535 */         this.intBuffer = data_i().capacity(fullSize() / 4).asBuffer();
/*      */       }
/* 1537 */       this.intBuffer.position(0);
/* 1538 */       return this.intBuffer;
/*      */     }
/*      */     public FloatBuffer getFloatBuffer() {
/* 1541 */       if (this.floatBuffer == null) {
/* 1542 */         this.floatBuffer = data_fl().capacity(fullSize() / 4).asBuffer();
/*      */       }
/* 1544 */       this.floatBuffer.position(0);
/* 1545 */       return this.floatBuffer;
/*      */     }
/*      */     public DoubleBuffer getDoubleBuffer() {
/* 1548 */       if (this.doubleBuffer == null) {
/* 1549 */         this.doubleBuffer = data_db().capacity(fullSize() / 8).asBuffer();
/*      */       }
/* 1551 */       this.doubleBuffer.position(0);
/* 1552 */       return this.doubleBuffer;
/*      */     }
/*      */ 
/*      */     public double get(int i) {
/* 1556 */       switch (depth()) { case 0:
/* 1557 */         return getByteBuffer().get(i) & 0xFF;
/*      */       case 1:
/* 1558 */         return getByteBuffer().get(i);
/*      */       case 2:
/* 1559 */         return getShortBuffer().get(i) & 0xFFFF;
/*      */       case 3:
/* 1560 */         return getShortBuffer().get(i);
/*      */       case 4:
/* 1561 */         return getIntBuffer().get(i);
/*      */       case 5:
/* 1562 */         return getFloatBuffer().get(i);
/*      */       case 6:
/* 1563 */         return getDoubleBuffer().get(i); }
/* 1564 */       if (!$assertionsDisabled) throw new AssertionError();
/*      */ 
/* 1566 */       return (0.0D / 0.0D);
/*      */     }
/*      */     public double get(int i, int j) {
/* 1569 */       return get(i * step() / elemSize() + j * channels());
/*      */     }
/*      */ 
/*      */     public double get(int i, int j, int k) {
/* 1573 */       return get(i * step() / elemSize() + j * channels() + k);
/*      */     }
/*      */     public synchronized CvMat get(int index, double[] vv, int offset, int length) {
/* 1576 */       int d = depth();
/* 1577 */       switch (d) {
/*      */       case 0:
/*      */       case 1:
/* 1580 */         ByteBuffer bb = getByteBuffer();
/* 1581 */         bb.position(index);
/* 1582 */         for (int i = 0; i < length; i++) {
/* 1583 */           if (d == 0)
/* 1584 */             vv[(i + offset)] = (bb.get(i) & 0xFF);
/*      */           else {
/* 1586 */             vv[(i + offset)] = bb.get(i);
/*      */           }
/*      */         }
/* 1589 */         break;
/*      */       case 2:
/*      */       case 3:
/* 1592 */         ShortBuffer sb = getShortBuffer();
/* 1593 */         sb.position(index);
/* 1594 */         for (int i = 0; i < length; i++) {
/* 1595 */           if (d == 2)
/* 1596 */             vv[(i + offset)] = (sb.get() & 0xFFFF);
/*      */           else {
/* 1598 */             vv[(i + offset)] = sb.get();
/*      */           }
/*      */         }
/* 1601 */         break;
/*      */       case 4:
/* 1603 */         IntBuffer ib = getIntBuffer();
/* 1604 */         ib.position(index);
/* 1605 */         for (int i = 0; i < length; i++) {
/* 1606 */           vv[(i + offset)] = ib.get();
/*      */         }
/* 1608 */         break;
/*      */       case 5:
/* 1610 */         FloatBuffer fb = getFloatBuffer();
/* 1611 */         fb.position(index);
/* 1612 */         for (int i = 0; i < length; i++) {
/* 1613 */           vv[(i + offset)] = fb.get();
/*      */         }
/* 1615 */         break;
/*      */       case 6:
/* 1617 */         getDoubleBuffer().position(index);
/* 1618 */         getDoubleBuffer().get(vv, offset, length);
/* 1619 */         break;
/*      */       default:
/* 1620 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*      */       }
/* 1622 */       return this;
/*      */     }
/*      */     public CvMat get(int index, double[] vv) {
/* 1625 */       return get(index, vv, 0, vv.length);
/*      */     }
/*      */     public CvMat get(double[] vv) {
/* 1628 */       return get(0, vv);
/*      */     }
/*      */     public double[] get() {
/* 1631 */       double[] vv = new double[fullSize() / elemSize()];
/* 1632 */       get(vv);
/* 1633 */       return vv;
/*      */     }
/*      */ 
/*      */     public CvMat put(int i, double v) {
/* 1637 */       switch (depth()) { case 0:
/*      */       case 1:
/* 1639 */         getByteBuffer().put(i, (byte)(int)v); break;
/*      */       case 2:
/*      */       case 3:
/* 1641 */         getShortBuffer().put(i, (short)(int)v); break;
/*      */       case 4:
/* 1642 */         getIntBuffer().put(i, (int)v); break;
/*      */       case 5:
/* 1643 */         getFloatBuffer().put(i, (float)v); break;
/*      */       case 6:
/* 1644 */         getDoubleBuffer().put(i, v); break;
/*      */       default:
/* 1645 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*      */       }
/* 1647 */       return this;
/*      */     }
/*      */     public CvMat put(int i, int j, double v) {
/* 1650 */       return put(i * step() / elemSize() + j * channels(), v);
/*      */     }
/*      */     public CvMat put(int i, int j, int k, double v) {
/* 1653 */       return put(i * step() / elemSize() + j * channels() + k, v);
/*      */     }
/*      */     public synchronized CvMat put(int index, double[] vv, int offset, int length) {
/* 1656 */       switch (depth()) {
/*      */       case 0:
/*      */       case 1:
/* 1659 */         ByteBuffer bb = getByteBuffer();
/* 1660 */         bb.position(index);
/* 1661 */         for (int i = 0; i < length; i++) {
/* 1662 */           bb.put((byte)(int)vv[(i + offset)]);
/*      */         }
/* 1664 */         break;
/*      */       case 2:
/*      */       case 3:
/* 1667 */         ShortBuffer sb = getShortBuffer();
/* 1668 */         sb.position(index);
/* 1669 */         for (int i = 0; i < length; i++) {
/* 1670 */           sb.put((short)(int)vv[(i + offset)]);
/*      */         }
/* 1672 */         break;
/*      */       case 4:
/* 1674 */         IntBuffer ib = getIntBuffer();
/* 1675 */         ib.position(index);
/* 1676 */         for (int i = 0; i < length; i++) {
/* 1677 */           ib.put((int)vv[(i + offset)]);
/*      */         }
/* 1679 */         break;
/*      */       case 5:
/* 1681 */         FloatBuffer fb = getFloatBuffer();
/* 1682 */         fb.position(index);
/* 1683 */         for (int i = 0; i < length; i++) {
/* 1684 */           fb.put((float)vv[(i + offset)]);
/*      */         }
/* 1686 */         break;
/*      */       case 6:
/* 1688 */         DoubleBuffer db = getDoubleBuffer();
/* 1689 */         db.position(index);
/* 1690 */         db.put(vv, offset, length);
/* 1691 */         break;
/*      */       default:
/* 1692 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*      */       }
/* 1694 */       return this;
/*      */     }
/*      */     public CvMat put(int index, double[] vv) {
/* 1697 */       return put(index, vv, 0, vv.length);
/*      */     }
/*      */     public CvMat put(double[] vv) {
/* 1700 */       return put(0, vv);
/*      */     }
/*      */ 
/*      */     public CvMat put(CvMat mat) {
/* 1704 */       return put(0, 0, 0, mat, 0, 0, 0);
/*      */     }
/*      */ 
/*      */     public synchronized CvMat put(int dsti, int dstj, int dstk, CvMat mat, int srci, int srcj, int srck) {
/* 1708 */       if ((rows() == mat.rows()) && (cols() == mat.cols()) && (step() == mat.step()) && (type() == mat.type()) && (dsti == 0) && (dstj == 0) && (dstk == 0) && (srci == 0) && (srcj == 0) && (srck == 0))
/*      */       {
/* 1710 */         getByteBuffer().clear();
/* 1711 */         mat.getByteBuffer().clear();
/* 1712 */         getByteBuffer().put(mat.getByteBuffer());
/*      */       } else {
/* 1714 */         int w = Math.min(rows() - dsti, mat.rows() - srci);
/* 1715 */         int h = Math.min(cols() - dstj, mat.cols() - srcj);
/* 1716 */         int d = Math.min(channels() - dstk, mat.channels() - srck);
/* 1717 */         for (int i = 0; i < w; i++) {
/* 1718 */           for (int j = 0; j < h; j++) {
/* 1719 */             for (int k = 0; k < d; k++) {
/* 1720 */               put(i + dsti, j + dstj, k + dstk, mat.get(i + srci, j + srcj, k + srck));
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/* 1725 */       return this;
/*      */     }
/*      */ 
/*      */     public opencv_core.IplImage asIplImage() {
/* 1729 */       opencv_core.IplImage image = new opencv_core.IplImage();
/* 1730 */       opencv_core.cvGetImage(this, image);
/* 1731 */       return image;
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 1735 */       return toString(0);
/*      */     }
/*      */     public String toString(int indent) {
/* 1738 */       StringBuilder s = new StringBuilder("[ ");
/* 1739 */       int channels = channels();
/* 1740 */       for (int i = 0; i < rows(); i++) {
/* 1741 */         for (int j = 0; j < cols(); j++) {
/* 1742 */           opencv_core.CvScalar v = opencv_core.cvGet2D(this, i, j);
/* 1743 */           if (channels > 1) {
/* 1744 */             s.append("(");
/*      */           }
/* 1746 */           for (int k = 0; k < channels; k++) {
/* 1747 */             s.append((float)v.val(k));
/* 1748 */             if (k < channels - 1) {
/* 1749 */               s.append(", ");
/*      */             }
/*      */           }
/* 1752 */           if (channels > 1) {
/* 1753 */             s.append(")");
/*      */           }
/* 1755 */           if (j < cols() - 1) {
/* 1756 */             s.append(", ");
/*      */           }
/*      */         }
/* 1759 */         if (i < rows() - 1) {
/* 1760 */           s.append("\n  ");
/* 1761 */           for (int j = 0; j < indent; j++) {
/* 1762 */             s.append(' ');
/*      */           }
/*      */         }
/*      */       }
/* 1766 */       s.append(" ]");
/* 1767 */       return s.toString();
/*      */     }
/*      */ 
/*      */     protected static class ReleaseDeallocator extends opencv_core.CvMat
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_core.CvMat m)
/*      */       {
/* 1432 */         super(); } 
/* 1433 */       public void deallocate() { opencv_core.cvReleaseMat(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class IplROI extends Pointer
/*      */   {
/*      */     public IplROI()
/*      */     {
/* 1234 */       allocate(); } 
/* 1235 */     public IplROI(int size) { allocateArray(size); } 
/* 1236 */     public IplROI(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1241 */     public IplROI position(int position) { return (IplROI)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int coi();
/*      */ 
/*      */     public native IplROI coi(int paramInt);
/*      */ 
/*      */     public native int xOffset();
/*      */ 
/*      */     public native IplROI xOffset(int paramInt);
/*      */ 
/*      */     public native int yOffset();
/*      */ 
/*      */     public native IplROI yOffset(int paramInt);
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native IplROI width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native IplROI height(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1233 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class IplTileInfo extends Pointer
/*      */   {
/*      */     public IplTileInfo()
/*      */     {
/*      */     }
/*      */ 
/*      */     public IplTileInfo(Pointer p)
/*      */     {
/* 1229 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/* 1227 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class IplImage extends opencv_core.CvArr
/*      */   {
/*      */     public static final byte[] gamma22;
/*      */     public static final byte[] gamma22inv;
/* 1081 */     private Object bufferedImage = null;
/*      */ 
/*      */     public IplImage()
/*      */     {
/*  403 */       allocate(); zero(); } 
/*  404 */     public IplImage(int size) { allocateArray(size); zero(); } 
/*  405 */     public IplImage(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  410 */     public IplImage position(int position) { return (IplImage)super.position(position); }
/*      */ 
/*      */     public static IplImage create(opencv_core.CvSize size, int depth, int channels)
/*      */     {
/*  414 */       IplImage i = opencv_core.cvCreateImage(size, depth, channels);
/*  415 */       if (i != null) {
/*  416 */         i.deallocator(new ReleaseDeallocator(i));
/*      */       }
/*  418 */       return i;
/*      */     }
/*      */     public static IplImage create(int width, int height, int depth, int channels) {
/*  421 */       return create(opencv_core.cvSize(width, height), depth, channels);
/*      */     }
/*      */     public static IplImage create(opencv_core.CvSize size, int depth, int channels, int origin) {
/*  424 */       IplImage i = create(size, depth, channels);
/*  425 */       if (i != null) {
/*  426 */         i.origin(origin);
/*      */       }
/*  428 */       return i;
/*      */     }
/*      */     public static IplImage create(int width, int height, int depth, int channels, int origin) {
/*  431 */       IplImage i = create(width, height, depth, channels);
/*  432 */       if (i != null) {
/*  433 */         i.origin(origin);
/*      */       }
/*  435 */       return i;
/*      */     }
/*      */ 
/*      */     public static IplImage createHeader(opencv_core.CvSize size, int depth, int channels) {
/*  439 */       IplImage i = opencv_core.cvCreateImageHeader(size, depth, channels);
/*  440 */       if (i != null) {
/*  441 */         i.deallocator(new HeaderReleaseDeallocator(i));
/*      */       }
/*  443 */       return i;
/*      */     }
/*      */     public static IplImage createHeader(int width, int height, int depth, int channels) {
/*  446 */       return createHeader(opencv_core.cvSize(width, height), depth, channels);
/*      */     }
/*      */     public static IplImage createHeader(opencv_core.CvSize size, int depth, int channels, int origin) {
/*  449 */       IplImage i = createHeader(size, depth, channels);
/*  450 */       if (i != null) {
/*  451 */         i.origin(origin);
/*      */       }
/*  453 */       return i;
/*      */     }
/*      */     public static IplImage createHeader(int width, int height, int depth, int channels, int origin) {
/*  456 */       IplImage i = createHeader(width, height, depth, channels);
/*  457 */       if (i != null) {
/*  458 */         i.origin(origin);
/*      */       }
/*  460 */       return i;
/*      */     }
/*      */ 
/*      */     public static IplImage createCompatible(IplImage template) {
/*  464 */       return createIfNotCompatible(null, template);
/*      */     }
/*      */     public static IplImage createIfNotCompatible(IplImage image, IplImage template) {
/*  467 */       if ((image == null) || (image.width() != template.width()) || (image.height() != template.height()) || (image.depth() != template.depth()) || (image.nChannels() != template.nChannels()))
/*      */       {
/*  469 */         image = create(template.width(), template.height(), template.depth(), template.nChannels(), template.origin());
/*      */ 
/*  471 */         if (template.bufferedImage != null) {
/*  472 */           image.bufferedImage = template.cloneBufferedImage();
/*      */         }
/*      */       }
/*  475 */       image.origin(template.origin());
/*  476 */       return image;
/*      */     }
/*      */ 
/*      */     public static IplImage createFrom(BufferedImage image) {
/*  480 */       return createFrom(image, 1.0D);
/*      */     }
/*      */     public static IplImage createFrom(BufferedImage image, double gamma) {
/*  483 */       return createFrom(image, gamma, false);
/*      */     }
/*      */     public static IplImage createFrom(BufferedImage image, double gamma, boolean flipChannels) {
/*  486 */       if (image == null) {
/*  487 */         return null;
/*      */       }
/*  489 */       SampleModel sm = image.getSampleModel();
/*  490 */       int depth = 0; int numChannels = sm.getNumBands();
/*  491 */       switch (image.getType()) {
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*  496 */         depth = 8;
/*  497 */         numChannels = 4;
/*      */       }
/*      */ 
/*  500 */       if ((depth == 0) || (numChannels == 0))
/*  501 */         switch (sm.getDataType()) { case 0:
/*  502 */           depth = 8; break;
/*      */         case 1:
/*  503 */           depth = 16; break;
/*      */         case 2:
/*  504 */           depth = -2147483632; break;
/*      */         case 3:
/*  505 */           depth = -2147483616; break;
/*      */         case 4:
/*  506 */           depth = 32; break;
/*      */         case 5:
/*  507 */           depth = 64; break;
/*      */         default:
/*  508 */           if (!$assertionsDisabled) throw new AssertionError();
/*      */           break;
/*      */         }
/*  511 */       IplImage i = create(image.getWidth(), image.getHeight(), depth, numChannels);
/*  512 */       i.copyFrom(image, gamma, flipChannels);
/*  513 */       return i;
/*      */     }
/*      */ 
/*      */     public IplImage clone() {
/*  517 */       IplImage i = opencv_core.cvCloneImage(this);
/*  518 */       if (i != null) {
/*  519 */         i.deallocator(new ReleaseDeallocator(i));
/*      */       }
/*  521 */       if (this.bufferedImage != null) {
/*  522 */         i.bufferedImage = cloneBufferedImage();
/*      */       }
/*  524 */       return i;
/*      */     }
/*      */ 
/*      */     protected BufferedImage cloneBufferedImage() {
/*  528 */       if (this.bufferedImage == null) {
/*  529 */         return null;
/*      */       }
/*  531 */       BufferedImage bi = (BufferedImage)this.bufferedImage;
/*  532 */       int type = bi.getType();
/*  533 */       if (type == 0) {
/*  534 */         return new BufferedImage(bi.getColorModel(), bi.copyData(null), bi.isAlphaPremultiplied(), null);
/*      */       }
/*      */ 
/*  537 */       return new BufferedImage(bi.getWidth(), bi.getHeight(), type);
/*      */     }
/*      */ 
/*      */     public void release()
/*      */     {
/*  542 */       deallocate(); } 
/*      */     public native int nSize();
/*      */ 
/*      */     public native IplImage nSize(int paramInt);
/*      */ 
/*      */     public native int ID();
/*      */ 
/*      */     public native IplImage ID(int paramInt);
/*      */ 
/*      */     public native int nChannels();
/*      */ 
/*      */     public native IplImage nChannels(int paramInt);
/*      */ 
/*      */     public native int alphaChannel();
/*      */ 
/*      */     public native IplImage alphaChannel(int paramInt);
/*      */ 
/*      */     public native int depth();
/*      */ 
/*      */     public native IplImage depth(int paramInt);
/*      */ 
/*      */     public native int colorModel(int paramInt);
/*      */ 
/*      */     public native IplImage colorModel(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int channelSeq(int paramInt);
/*      */ 
/*      */     public native IplImage channelSeq(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int dataOrder();
/*      */ 
/*      */     public native IplImage dataOrder(int paramInt);
/*      */ 
/*      */     public native int origin();
/*      */ 
/*      */     public native IplImage origin(int paramInt);
/*      */ 
/*      */     public native int align();
/*      */ 
/*      */     public native IplImage align(int paramInt);
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native IplImage width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native IplImage height(int paramInt);
/*      */ 
/*      */     public native opencv_core.IplROI roi();
/*      */ 
/*      */     public native IplImage roi(opencv_core.IplROI paramIplROI);
/*      */ 
/*      */     public native IplImage maskROI();
/*      */ 
/*      */     public native IplImage maskROI(IplImage paramIplImage);
/*      */ 
/*      */     public native Pointer imageId();
/*      */ 
/*      */     public native IplImage imageId(Pointer paramPointer);
/*      */ 
/*      */     public native opencv_core.IplTileInfo tileInfo();
/*      */ 
/*      */     public native IplImage tileInfo(opencv_core.IplTileInfo paramIplTileInfo);
/*      */ 
/*      */     public native int imageSize();
/*      */ 
/*      */     public native IplImage imageSize(int paramInt);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer imageData();
/*      */ 
/*      */     public native IplImage imageData(BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberSetter
/*      */     public native IplImage imageData(@Cast({"char*"}) ByteBuffer paramByteBuffer);
/*      */ 
/*      */     public native int widthStep();
/*      */ 
/*      */     public native IplImage widthStep(int paramInt);
/*      */ 
/*      */     public native int BorderMode(int paramInt);
/*      */ 
/*      */     public native IplImage BorderMode(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int BorderConst(int paramInt);
/*      */ 
/*      */     public native IplImage BorderConst(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer imageDataOrigin();
/*      */ 
/*      */     public native IplImage imageDataOrigin(BytePointer paramBytePointer);
/*      */ 
/*  582 */     public double highValue() { double highValue = 0.0D;
/*  583 */       switch (depth()) { case 8:
/*  584 */         highValue = 255.0D; break;
/*      */       case 16:
/*  585 */         highValue = 65535.0D; break;
/*      */       case -2147483640:
/*  586 */         highValue = 127.0D; break;
/*      */       case -2147483632:
/*  587 */         highValue = 32767.0D; break;
/*      */       case -2147483616:
/*  588 */         highValue = 2147483647.0D; break;
/*      */       case 1:
/*      */       case 32:
/*      */       case 64:
/*  591 */         highValue = 1.0D; break;
/*      */       default:
/*  592 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*      */       }
/*  594 */       return highValue; }
/*      */ 
/*      */     public opencv_core.CvSize cvSize() {
/*  597 */       return opencv_core.cvSize(width(), height());
/*      */     }
/*  599 */     public ByteBuffer getByteBuffer(int index) { return imageData().position(index).capacity(imageSize()).asByteBuffer(); } 
/*  600 */     public ShortBuffer getShortBuffer(int index) { return getByteBuffer(index * 2).asShortBuffer(); } 
/*  601 */     public IntBuffer getIntBuffer(int index) { return getByteBuffer(index * 4).asIntBuffer(); } 
/*  602 */     public FloatBuffer getFloatBuffer(int index) { return getByteBuffer(index * 4).asFloatBuffer(); } 
/*  603 */     public DoubleBuffer getDoubleBuffer(int index) { return getByteBuffer(index * 8).asDoubleBuffer(); } 
/*  604 */     public ByteBuffer getByteBuffer() { return getByteBuffer(0); } 
/*  605 */     public ShortBuffer getShortBuffer() { return getShortBuffer(0); } 
/*  606 */     public IntBuffer getIntBuffer() { return getIntBuffer(0); } 
/*  607 */     public FloatBuffer getFloatBuffer() { return getFloatBuffer(0); } 
/*  608 */     public DoubleBuffer getDoubleBuffer() { return getDoubleBuffer(0); }
/*      */ 
/*      */ 
/*      */     public static int decodeGamma22(int value)
/*      */     {
/*  620 */       return gamma22[(value & 0xFF)] & 0xFF;
/*      */     }
/*      */     public static int encodeGamma22(int value) {
/*  623 */       return gamma22inv[(value & 0xFF)] & 0xFF;
/*      */     }
/*      */ 
/*      */     public static void flipCopyWithGamma(ByteBuffer srcBuf, int srcStep, ByteBuffer dstBuf, int dstStep, boolean signed, double gamma, boolean flip, int channels) {
/*  627 */       assert (srcBuf != dstBuf);
/*  628 */       int w = Math.min(srcStep, dstStep);
/*  629 */       int srcLine = srcBuf.position(); int dstLine = dstBuf.position();
/*  630 */       byte[] buffer = new byte[channels];
/*  631 */       while ((srcLine < srcBuf.capacity()) && (dstLine < dstBuf.capacity())) {
/*  632 */         if (flip)
/*  633 */           srcBuf.position(srcBuf.capacity() - srcLine - srcStep);
/*      */         else {
/*  635 */           srcBuf.position(srcLine);
/*      */         }
/*  637 */         dstBuf.position(dstLine);
/*  638 */         w = Math.min(Math.min(w, srcBuf.remaining()), dstBuf.remaining());
/*  639 */         if (signed) {
/*  640 */           if (channels > 1) {
/*  641 */             for (int x = 0; x < w; x += channels) {
/*  642 */               for (int z = 0; z < channels; z++) {
/*  643 */                 int in = srcBuf.get();
/*      */                 byte out;
/*      */                 byte out;
/*  645 */                 if (gamma == 1.0D)
/*  646 */                   out = (byte)in;
/*      */                 else {
/*  648 */                   out = (byte)(int)Math.round(Math.pow(in / 127.0D, gamma) * 127.0D);
/*      */                 }
/*  650 */                 buffer[z] = out;
/*      */               }
/*  652 */               for (int z = channels - 1; z >= 0; z--)
/*  653 */                 dstBuf.put(buffer[z]);
/*      */             }
/*      */           }
/*      */           else {
/*  657 */             for (int x = 0; x < w; x++) {
/*  658 */               int in = srcBuf.get();
/*      */               byte out;
/*      */               byte out;
/*  660 */               if (gamma == 1.0D)
/*  661 */                 out = (byte)in;
/*      */               else {
/*  663 */                 out = (byte)(int)Math.round(Math.pow(in / 127.0D, gamma) * 127.0D);
/*      */               }
/*  665 */               dstBuf.put(out);
/*      */             }
/*      */           }
/*      */         }
/*  669 */         else if (channels > 1) {
/*  670 */           for (int x = 0; x < w; x += channels) {
/*  671 */             for (int z = 0; z < channels; z++)
/*      */             {
/*  673 */               int in = srcBuf.get() & 0xFF;
/*      */               byte out;
/*      */               byte out;
/*  674 */               if (gamma == 1.0D) {
/*  675 */                 out = (byte)in;
/*      */               }
/*      */               else
/*      */               {
/*      */                 byte out;
/*  676 */                 if (gamma == 2.2D) {
/*  677 */                   out = gamma22[in];
/*      */                 }
/*      */                 else
/*      */                 {
/*      */                   byte out;
/*  678 */                   if (gamma == 0.4545454545454545D)
/*  679 */                     out = gamma22inv[in];
/*      */                   else
/*  681 */                     out = (byte)(int)Math.round(Math.pow(in / 255.0D, gamma) * 255.0D); 
/*      */                 }
/*      */               }
/*  683 */               buffer[z] = out;
/*      */             }
/*  685 */             for (int z = channels - 1; z >= 0; z--)
/*  686 */               dstBuf.put(buffer[z]);
/*      */           }
/*      */         }
/*      */         else {
/*  690 */           for (int x = 0; x < w; x++)
/*      */           {
/*  692 */             int in = srcBuf.get() & 0xFF;
/*      */             byte out;
/*      */             byte out;
/*  693 */             if (gamma == 1.0D) {
/*  694 */               out = (byte)in;
/*      */             }
/*      */             else
/*      */             {
/*      */               byte out;
/*  695 */               if (gamma == 2.2D) {
/*  696 */                 out = gamma22[in];
/*      */               }
/*      */               else
/*      */               {
/*      */                 byte out;
/*  697 */                 if (gamma == 0.4545454545454545D)
/*  698 */                   out = gamma22inv[in];
/*      */                 else
/*  700 */                   out = (byte)(int)Math.round(Math.pow(in / 255.0D, gamma) * 255.0D); 
/*      */               }
/*      */             }
/*  702 */             dstBuf.put(out);
/*      */           }
/*      */         }
/*      */ 
/*  706 */         srcLine += srcStep;
/*  707 */         dstLine += dstStep;
/*      */       }
/*      */     }
/*      */ 
/*      */     public static void flipCopyWithGamma(ShortBuffer srcBuf, int srcStep, ShortBuffer dstBuf, int dstStep, boolean signed, double gamma, boolean flip, int channels) {
/*  712 */       assert (srcBuf != dstBuf);
/*  713 */       int w = Math.min(srcStep, dstStep);
/*  714 */       int srcLine = srcBuf.position(); int dstLine = dstBuf.position();
/*  715 */       short[] buffer = new short[channels];
/*  716 */       while ((srcLine < srcBuf.capacity()) && (dstLine < dstBuf.capacity())) {
/*  717 */         if (flip)
/*  718 */           srcBuf.position(srcBuf.capacity() - srcLine - srcStep);
/*      */         else {
/*  720 */           srcBuf.position(srcLine);
/*      */         }
/*  722 */         dstBuf.position(dstLine);
/*  723 */         w = Math.min(Math.min(w, srcBuf.remaining()), dstBuf.remaining());
/*  724 */         if (signed) {
/*  725 */           if (channels > 1) {
/*  726 */             for (int x = 0; x < w; x += channels) {
/*  727 */               for (int z = 0; z < channels; z++) {
/*  728 */                 int in = srcBuf.get();
/*      */                 short out;
/*      */                 short out;
/*  730 */                 if (gamma == 1.0D)
/*  731 */                   out = (short)in;
/*      */                 else {
/*  733 */                   out = (short)(int)Math.round(Math.pow(in / 32767.0D, gamma) * 32767.0D);
/*      */                 }
/*  735 */                 buffer[z] = out;
/*      */               }
/*  737 */               for (int z = channels - 1; z >= 0; z--)
/*  738 */                 dstBuf.put(buffer[z]);
/*      */             }
/*      */           }
/*      */           else {
/*  742 */             for (int x = 0; x < w; x++) {
/*  743 */               int in = srcBuf.get();
/*      */               short out;
/*      */               short out;
/*  745 */               if (gamma == 1.0D)
/*  746 */                 out = (short)in;
/*      */               else {
/*  748 */                 out = (short)(int)Math.round(Math.pow(in / 32767.0D, gamma) * 32767.0D);
/*      */               }
/*  750 */               dstBuf.put(out);
/*      */             }
/*      */           }
/*      */         }
/*  754 */         else if (channels > 1) {
/*  755 */           for (int x = 0; x < w; x += channels) {
/*  756 */             for (int z = 0; z < channels; z++) {
/*  757 */               int in = srcBuf.get();
/*      */               short out;
/*      */               short out;
/*  759 */               if (gamma == 1.0D)
/*  760 */                 out = (short)in;
/*      */               else {
/*  762 */                 out = (short)(int)Math.round(Math.pow(in / 65535.0D, gamma) * 65535.0D);
/*      */               }
/*  764 */               buffer[z] = out;
/*      */             }
/*  766 */             for (int z = channels - 1; z >= 0; z--)
/*  767 */               dstBuf.put(buffer[z]);
/*      */           }
/*      */         }
/*      */         else {
/*  771 */           for (int x = 0; x < w; x++) {
/*  772 */             int in = srcBuf.get() & 0xFFFF;
/*      */             short out;
/*      */             short out;
/*  774 */             if (gamma == 1.0D)
/*  775 */               out = (short)in;
/*      */             else {
/*  777 */               out = (short)(int)Math.round(Math.pow(in / 65535.0D, gamma) * 65535.0D);
/*      */             }
/*  779 */             dstBuf.put(out);
/*      */           }
/*      */         }
/*      */ 
/*  783 */         srcLine += srcStep;
/*  784 */         dstLine += dstStep;
/*      */       }
/*      */     }
/*      */ 
/*      */     public static void flipCopyWithGamma(IntBuffer srcBuf, int srcStep, IntBuffer dstBuf, int dstStep, double gamma, boolean flip, int channels) {
/*  789 */       assert (srcBuf != dstBuf);
/*  790 */       int w = Math.min(srcStep, dstStep);
/*  791 */       int srcLine = srcBuf.position(); int dstLine = dstBuf.position();
/*  792 */       int[] buffer = new int[channels];
/*  793 */       while ((srcLine < srcBuf.capacity()) && (dstLine < dstBuf.capacity())) {
/*  794 */         if (flip)
/*  795 */           srcBuf.position(srcBuf.capacity() - srcLine - srcStep);
/*      */         else {
/*  797 */           srcBuf.position(srcLine);
/*      */         }
/*  799 */         dstBuf.position(dstLine);
/*  800 */         w = Math.min(Math.min(w, srcBuf.remaining()), dstBuf.remaining());
/*  801 */         if (channels > 1) {
/*  802 */           for (int x = 0; x < w; x += channels) {
/*  803 */             for (int z = 0; z < channels; z++) {
/*  804 */               int in = srcBuf.get();
/*      */               int out;
/*      */               int out;
/*  806 */               if (gamma == 1.0D)
/*  807 */                 out = in;
/*      */               else {
/*  809 */                 out = (int)Math.round(Math.pow(in / 2147483647.0D, gamma) * 2147483647.0D);
/*      */               }
/*  811 */               buffer[z] = out;
/*      */             }
/*  813 */             for (int z = channels - 1; z >= 0; z--)
/*  814 */               dstBuf.put(buffer[z]);
/*      */           }
/*      */         }
/*      */         else {
/*  818 */           for (int x = 0; x < w; x++) {
/*  819 */             int in = srcBuf.get();
/*      */             int out;
/*      */             int out;
/*  821 */             if (gamma == 1.0D)
/*  822 */               out = in;
/*      */             else {
/*  824 */               out = (int)Math.round(Math.pow(in / 2147483647.0D, gamma) * 2147483647.0D);
/*      */             }
/*  826 */             dstBuf.put(out);
/*      */           }
/*      */         }
/*  829 */         srcLine += srcStep;
/*  830 */         dstLine += dstStep;
/*      */       }
/*      */     }
/*      */ 
/*      */     public static void flipCopyWithGamma(FloatBuffer srcBuf, int srcStep, FloatBuffer dstBuf, int dstStep, double gamma, boolean flip, int channels) {
/*  835 */       assert (srcBuf != dstBuf);
/*  836 */       int w = Math.min(srcStep, dstStep);
/*  837 */       int srcLine = srcBuf.position(); int dstLine = dstBuf.position();
/*  838 */       float[] buffer = new float[channels];
/*  839 */       while ((srcLine < srcBuf.capacity()) && (dstLine < dstBuf.capacity())) {
/*  840 */         if (flip)
/*  841 */           srcBuf.position(srcBuf.capacity() - srcLine - srcStep);
/*      */         else {
/*  843 */           srcBuf.position(srcLine);
/*      */         }
/*  845 */         dstBuf.position(dstLine);
/*  846 */         w = Math.min(Math.min(w, srcBuf.remaining()), dstBuf.remaining());
/*  847 */         if (channels > 1) {
/*  848 */           for (int x = 0; x < w; x += channels) {
/*  849 */             for (int z = 0; z < channels; z++) {
/*  850 */               float in = srcBuf.get();
/*      */               float out;
/*      */               float out;
/*  852 */               if (gamma == 1.0D)
/*  853 */                 out = in;
/*      */               else {
/*  855 */                 out = (float)Math.pow(in, gamma);
/*      */               }
/*  857 */               buffer[z] = out;
/*      */             }
/*  859 */             for (int z = channels - 1; z >= 0; z--)
/*  860 */               dstBuf.put(buffer[z]);
/*      */           }
/*      */         }
/*      */         else {
/*  864 */           for (int x = 0; x < w; x++) {
/*  865 */             float in = srcBuf.get();
/*      */             float out;
/*      */             float out;
/*  867 */             if (gamma == 1.0D)
/*  868 */               out = in;
/*      */             else {
/*  870 */               out = (float)Math.pow(in, gamma);
/*      */             }
/*  872 */             dstBuf.put(out);
/*      */           }
/*      */         }
/*  875 */         srcLine += srcStep;
/*  876 */         dstLine += dstStep;
/*      */       }
/*      */     }
/*      */ 
/*      */     public static void flipCopyWithGamma(DoubleBuffer srcBuf, int srcStep, DoubleBuffer dstBuf, int dstStep, double gamma, boolean flip, int channels) {
/*  881 */       assert (srcBuf != dstBuf);
/*  882 */       int w = Math.min(srcStep, dstStep);
/*  883 */       int srcLine = srcBuf.position(); int dstLine = dstBuf.position();
/*  884 */       double[] buffer = new double[channels];
/*  885 */       while ((srcLine < srcBuf.capacity()) && (dstLine < dstBuf.capacity())) {
/*  886 */         if (flip)
/*  887 */           srcBuf.position(srcBuf.capacity() - srcLine - srcStep);
/*      */         else {
/*  889 */           srcBuf.position(srcLine);
/*      */         }
/*  891 */         dstBuf.position(dstLine);
/*  892 */         w = Math.min(Math.min(w, srcBuf.remaining()), dstBuf.remaining());
/*  893 */         if (channels > 1) {
/*  894 */           for (int x = 0; x < w; x += channels) {
/*  895 */             for (int z = 0; z < channels; z++) {
/*  896 */               double in = srcBuf.get();
/*      */               double out;
/*      */               double out;
/*  898 */               if (gamma == 1.0D)
/*  899 */                 out = in;
/*      */               else {
/*  901 */                 out = Math.pow(in, gamma);
/*      */               }
/*  903 */               buffer[z] = out;
/*      */             }
/*  905 */             for (int z = channels - 1; z >= 0; z--)
/*  906 */               dstBuf.put(buffer[z]);
/*      */           }
/*      */         }
/*      */         else {
/*  910 */           for (int x = 0; x < w; x++) {
/*  911 */             double in = srcBuf.get();
/*      */             double out;
/*      */             double out;
/*  913 */             if (gamma == 1.0D)
/*  914 */               out = in;
/*      */             else {
/*  916 */               out = Math.pow(in, gamma);
/*      */             }
/*  918 */             dstBuf.put(out);
/*      */           }
/*      */         }
/*  921 */         srcLine += srcStep;
/*  922 */         dstLine += dstStep;
/*      */       }
/*      */     }
/*      */ 
/*  926 */     public void applyGamma(double gamma) { if (gamma == 1.0D) {
/*  927 */         return;
/*      */       }
/*  929 */       switch (depth()) {
/*      */       case 8:
/*  931 */         flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), false, gamma, false, 0);
/*  932 */         break;
/*      */       case -2147483640:
/*  934 */         flipCopyWithGamma(getByteBuffer(), widthStep(), getByteBuffer(), widthStep(), true, gamma, false, 0);
/*  935 */         break;
/*      */       case 16:
/*  937 */         flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, false, gamma, false, 0);
/*  938 */         break;
/*      */       case -2147483632:
/*  940 */         flipCopyWithGamma(getShortBuffer(), widthStep() / 2, getShortBuffer(), widthStep() / 2, true, gamma, false, 0);
/*  941 */         break;
/*      */       case -2147483616:
/*  943 */         flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, gamma, false, 0);
/*  944 */         break;
/*      */       case 32:
/*  946 */         flipCopyWithGamma(getFloatBuffer(), widthStep() / 4, getFloatBuffer(), widthStep() / 4, gamma, false, 0);
/*  947 */         break;
/*      */       case 64:
/*  949 */         flipCopyWithGamma(getDoubleBuffer(), widthStep() / 8, getDoubleBuffer(), widthStep() / 8, gamma, false, 0);
/*  950 */         break;
/*      */       default:
/*  952 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*      */       }
/*      */     }
/*      */ 
/*      */     public void copyTo(BufferedImage image)
/*      */     {
/*  958 */       copyTo(image, 1.0D);
/*      */     }
/*      */     public void copyTo(BufferedImage image, double gamma) {
/*  961 */       copyTo(image, gamma, false);
/*      */     }
/*      */     public void copyTo(BufferedImage image, double gamma, boolean flipChannels) {
/*  964 */       Rectangle r = null;
/*  965 */       opencv_core.IplROI roi = roi();
/*  966 */       if (roi != null) {
/*  967 */         r = new Rectangle(roi.xOffset(), roi.yOffset(), roi.width(), roi.height());
/*      */       }
/*  969 */       copyTo(image, gamma, flipChannels, r);
/*      */     }
/*      */     public void copyTo(BufferedImage image, double gamma, boolean flipChannels, Rectangle roi) {
/*  972 */       boolean flip = origin() == 1;
/*      */ 
/*  974 */       ByteBuffer in = getByteBuffer(roi == null ? 0 : roi.y * widthStep() + roi.x * nChannels());
/*  975 */       SampleModel sm = image.getSampleModel();
/*  976 */       Raster r = image.getRaster();
/*  977 */       DataBuffer out = r.getDataBuffer();
/*  978 */       int x = -r.getSampleModelTranslateX();
/*  979 */       int y = -r.getSampleModelTranslateY();
/*  980 */       int step = sm.getWidth() * sm.getNumBands();
/*  981 */       int channels = sm.getNumBands();
/*  982 */       if ((sm instanceof ComponentSampleModel)) {
/*  983 */         step = ((ComponentSampleModel)sm).getScanlineStride();
/*  984 */         channels = ((ComponentSampleModel)sm).getPixelStride();
/*  985 */       } else if ((sm instanceof SinglePixelPackedSampleModel)) {
/*  986 */         step = ((SinglePixelPackedSampleModel)sm).getScanlineStride();
/*  987 */         channels = 1;
/*  988 */       } else if ((sm instanceof MultiPixelPackedSampleModel)) {
/*  989 */         step = ((MultiPixelPackedSampleModel)sm).getScanlineStride();
/*  990 */         channels = ((MultiPixelPackedSampleModel)sm).getPixelBitStride() / 8;
/*      */       }
/*  992 */       int start = y * step + x * channels;
/*      */ 
/*  994 */       if ((out instanceof DataBufferByte)) {
/*  995 */         byte[] a = ((DataBufferByte)out).getData();
/*  996 */         flipCopyWithGamma(in, widthStep(), ByteBuffer.wrap(a, start, a.length - start), step, false, gamma, flip, flipChannels ? channels : 0);
/*  997 */       } else if ((out instanceof DataBufferDouble)) {
/*  998 */         double[] a = ((DataBufferDouble)out).getData();
/*  999 */         flipCopyWithGamma(in.asDoubleBuffer(), widthStep() / 8, DoubleBuffer.wrap(a, start, a.length - start), step, gamma, flip, flipChannels ? channels : 0);
/* 1000 */       } else if ((out instanceof DataBufferFloat)) {
/* 1001 */         float[] a = ((DataBufferFloat)out).getData();
/* 1002 */         flipCopyWithGamma(in.asFloatBuffer(), widthStep() / 4, FloatBuffer.wrap(a, start, a.length - start), step, gamma, flip, flipChannels ? channels : 0);
/* 1003 */       } else if ((out instanceof DataBufferInt)) {
/* 1004 */         int[] a = ((DataBufferInt)out).getData();
/* 1005 */         flipCopyWithGamma(in.asIntBuffer(), widthStep() / 4, IntBuffer.wrap(a, start, a.length - start), step, gamma, flip, flipChannels ? channels : 0);
/* 1006 */       } else if ((out instanceof DataBufferShort)) {
/* 1007 */         short[] a = ((DataBufferShort)out).getData();
/* 1008 */         flipCopyWithGamma(in.asShortBuffer(), widthStep() / 2, ShortBuffer.wrap(a, start, a.length - start), step, true, gamma, flip, flipChannels ? channels : 0);
/* 1009 */       } else if ((out instanceof DataBufferUShort)) {
/* 1010 */         short[] a = ((DataBufferUShort)out).getData();
/* 1011 */         flipCopyWithGamma(in.asShortBuffer(), widthStep() / 2, ShortBuffer.wrap(a, start, a.length - start), step, false, gamma, flip, flipChannels ? channels : 0);
/*      */       }
/* 1013 */       else if (!$assertionsDisabled) { throw new AssertionError(); }
/*      */     }
/*      */ 
/*      */     public void copyFrom(BufferedImage image)
/*      */     {
/* 1018 */       copyFrom(image, 1.0D);
/*      */     }
/*      */     public void copyFrom(BufferedImage image, double gamma) {
/* 1021 */       copyFrom(image, gamma, false);
/*      */     }
/*      */     public void copyFrom(BufferedImage image, double gamma, boolean flipChannels) {
/* 1024 */       Rectangle r = null;
/* 1025 */       opencv_core.IplROI roi = roi();
/* 1026 */       if (roi != null) {
/* 1027 */         r = new Rectangle(roi.xOffset(), roi.yOffset(), roi.width(), roi.height());
/*      */       }
/* 1029 */       copyFrom(image, gamma, flipChannels, r);
/*      */     }
/*      */     public void copyFrom(BufferedImage image, double gamma, boolean flipChannels, Rectangle roi) {
/* 1032 */       origin(0);
/*      */ 
/* 1034 */       ByteBuffer out = getByteBuffer(roi == null ? 0 : roi.y * widthStep() + roi.x);
/* 1035 */       SampleModel sm = image.getSampleModel();
/* 1036 */       Raster r = image.getRaster();
/* 1037 */       DataBuffer in = r.getDataBuffer();
/* 1038 */       int x = -r.getSampleModelTranslateX();
/* 1039 */       int y = -r.getSampleModelTranslateY();
/* 1040 */       int step = sm.getWidth() * sm.getNumBands();
/* 1041 */       int channels = sm.getNumBands();
/* 1042 */       if ((sm instanceof ComponentSampleModel)) {
/* 1043 */         step = ((ComponentSampleModel)sm).getScanlineStride();
/* 1044 */         channels = ((ComponentSampleModel)sm).getPixelStride();
/* 1045 */       } else if ((sm instanceof SinglePixelPackedSampleModel)) {
/* 1046 */         step = ((SinglePixelPackedSampleModel)sm).getScanlineStride();
/* 1047 */         channels = 1;
/* 1048 */       } else if ((sm instanceof MultiPixelPackedSampleModel)) {
/* 1049 */         step = ((MultiPixelPackedSampleModel)sm).getScanlineStride();
/* 1050 */         channels = ((MultiPixelPackedSampleModel)sm).getPixelBitStride() / 8;
/*      */       }
/* 1052 */       int start = y * step + x * channels;
/*      */ 
/* 1054 */       if ((in instanceof DataBufferByte)) {
/* 1055 */         byte[] a = ((DataBufferByte)in).getData();
/* 1056 */         flipCopyWithGamma(ByteBuffer.wrap(a, start, a.length - start), step, out, widthStep(), false, gamma, false, flipChannels ? channels : 0);
/* 1057 */       } else if ((in instanceof DataBufferDouble)) {
/* 1058 */         double[] a = ((DataBufferDouble)in).getData();
/* 1059 */         flipCopyWithGamma(DoubleBuffer.wrap(a, start, a.length - start), step, out.asDoubleBuffer(), widthStep() / 8, gamma, false, flipChannels ? channels : 0);
/* 1060 */       } else if ((in instanceof DataBufferFloat)) {
/* 1061 */         float[] a = ((DataBufferFloat)in).getData();
/* 1062 */         flipCopyWithGamma(FloatBuffer.wrap(a, start, a.length - start), step, out.asFloatBuffer(), widthStep() / 4, gamma, false, flipChannels ? channels : 0);
/* 1063 */       } else if ((in instanceof DataBufferInt)) {
/* 1064 */         int[] a = ((DataBufferInt)in).getData();
/* 1065 */         flipCopyWithGamma(IntBuffer.wrap(a, start, a.length - start), step, out.asIntBuffer(), widthStep() / 4, gamma, false, flipChannels ? channels : 0);
/* 1066 */       } else if ((in instanceof DataBufferShort)) {
/* 1067 */         short[] a = ((DataBufferShort)in).getData();
/* 1068 */         flipCopyWithGamma(ShortBuffer.wrap(a, start, a.length - start), step, out.asShortBuffer(), widthStep() / 2, true, gamma, false, flipChannels ? channels : 0);
/* 1069 */       } else if ((in instanceof DataBufferUShort)) {
/* 1070 */         short[] a = ((DataBufferUShort)in).getData();
/* 1071 */         flipCopyWithGamma(ShortBuffer.wrap(a, start, a.length - start), step, out.asShortBuffer(), widthStep() / 2, false, gamma, false, flipChannels ? channels : 0);
/*      */       }
/* 1073 */       else if (!$assertionsDisabled) { throw new AssertionError(); }
/*      */ 
/* 1075 */       if ((this.bufferedImage == null) && (roi == null) && (image.getWidth() == width()) && (image.getHeight() == height()))
/*      */       {
/* 1077 */         this.bufferedImage = image;
/*      */       }
/*      */     }
/*      */ 
/*      */     public int getBufferedImageType()
/*      */     {
/* 1089 */       int type = 0;
/* 1090 */       if (nChannels() == 1) {
/* 1091 */         if ((depth() == 8) || (depth() == -2147483640))
/* 1092 */           type = 10;
/* 1093 */         else if (depth() == 16)
/* 1094 */           type = 11;
/*      */       }
/* 1096 */       else if (nChannels() == 3) {
/* 1097 */         if ((depth() == 8) || (depth() == -2147483640))
/* 1098 */           type = 5;
/*      */       }
/* 1100 */       else if (nChannels() == 4)
/*      */       {
/* 1104 */         if ((depth() == 8) || (depth() == -2147483640)) {
/* 1105 */           type = 6;
/*      */         }
/*      */       }
/* 1108 */       return type;
/*      */     }
/*      */     public BufferedImage getBufferedImage() {
/* 1111 */       return getBufferedImage(1.0D);
/*      */     }
/*      */     public BufferedImage getBufferedImage(double gamma) {
/* 1114 */       return getBufferedImage(gamma, false);
/*      */     }
/*      */     public BufferedImage getBufferedImage(double gamma, boolean flipChannels) {
/* 1117 */       return getBufferedImage(gamma, flipChannels, null);
/*      */     }
/*      */     public BufferedImage getBufferedImage(double gamma, boolean flipChannels, ColorSpace cs) {
/* 1120 */       int type = getBufferedImageType();
/*      */ 
/* 1122 */       if ((this.bufferedImage == null) && (type != 0) && (cs == null)) {
/* 1123 */         this.bufferedImage = new BufferedImage(width(), height(), type);
/*      */       }
/*      */ 
/* 1126 */       if (this.bufferedImage == null) {
/* 1127 */         boolean alpha = false;
/* 1128 */         int[] offsets = null;
/* 1129 */         if (nChannels() == 1) {
/* 1130 */           alpha = false;
/* 1131 */           if (cs == null) {
/* 1132 */             cs = ColorSpace.getInstance(1003);
/*      */           }
/* 1134 */           offsets = new int[] { 0 };
/* 1135 */         } else if (nChannels() == 3) {
/* 1136 */           alpha = false;
/* 1137 */           if (cs == null) {
/* 1138 */             cs = ColorSpace.getInstance(1004);
/*      */           }
/*      */ 
/* 1141 */           offsets = new int[] { 2, 1, 0 };
/* 1142 */         } else if (nChannels() == 4) {
/* 1143 */           alpha = true;
/* 1144 */           if (cs == null) {
/* 1145 */             cs = ColorSpace.getInstance(1004);
/*      */           }
/*      */ 
/* 1148 */           offsets = new int[] { 0, 1, 2, 3 };
/*      */         }
/* 1150 */         else if (!$assertionsDisabled) { throw new AssertionError(); }
/*      */ 
/*      */ 
/* 1153 */         ColorModel cm = null;
/* 1154 */         WritableRaster wr = null;
/* 1155 */         if ((depth() == 8) || (depth() == -2147483640)) {
/* 1156 */           cm = new ComponentColorModel(cs, alpha, false, 1, 0);
/*      */ 
/* 1158 */           wr = Raster.createWritableRaster(new ComponentSampleModel(0, width(), height(), nChannels(), widthStep(), offsets), null);
/*      */         }
/* 1161 */         else if (depth() == 16) {
/* 1162 */           cm = new ComponentColorModel(cs, alpha, false, 1, 1);
/*      */ 
/* 1164 */           wr = Raster.createWritableRaster(new ComponentSampleModel(1, width(), height(), nChannels(), widthStep() / 2, offsets), null);
/*      */         }
/* 1167 */         else if (depth() == -2147483632) {
/* 1168 */           cm = new ComponentColorModel(cs, alpha, false, 1, 2);
/*      */ 
/* 1170 */           wr = Raster.createWritableRaster(new ComponentSampleModel(2, width(), height(), nChannels(), widthStep() / 2, offsets), null);
/*      */         }
/* 1173 */         else if (depth() == -2147483616) {
/* 1174 */           cm = new ComponentColorModel(cs, alpha, false, 1, 3);
/*      */ 
/* 1176 */           wr = Raster.createWritableRaster(new ComponentSampleModel(3, width(), height(), nChannels(), widthStep() / 4, offsets), null);
/*      */         }
/* 1179 */         else if (depth() == 32) {
/* 1180 */           cm = new ComponentColorModel(cs, alpha, false, 1, 4);
/*      */ 
/* 1182 */           wr = Raster.createWritableRaster(new ComponentSampleModel(4, width(), height(), nChannels(), widthStep() / 4, offsets), null);
/*      */         }
/* 1185 */         else if (depth() == 64) {
/* 1186 */           cm = new ComponentColorModel(cs, alpha, false, 1, 5);
/*      */ 
/* 1188 */           wr = Raster.createWritableRaster(new ComponentSampleModel(5, width(), height(), nChannels(), widthStep() / 8, offsets), null);
/*      */         }
/* 1192 */         else if (!$assertionsDisabled) { throw new AssertionError(); }
/*      */ 
/*      */ 
/* 1195 */         this.bufferedImage = new BufferedImage(cm, wr, false, null);
/*      */       }
/*      */ 
/* 1198 */       if (this.bufferedImage != null) {
/* 1199 */         opencv_core.IplROI roi = roi();
/* 1200 */         if (roi != null)
/* 1201 */           copyTo(((BufferedImage)this.bufferedImage).getSubimage(roi.xOffset(), roi.yOffset(), roi.width(), roi.height()), gamma, flipChannels);
/*      */         else {
/* 1203 */           copyTo((BufferedImage)this.bufferedImage, gamma, flipChannels);
/*      */         }
/*      */       }
/*      */ 
/* 1207 */       return (BufferedImage)this.bufferedImage;
/*      */     }
/*      */ 
/*      */     public opencv_core.CvMat asCvMat() {
/* 1211 */       opencv_core.CvMat mat = new opencv_core.CvMat();
/* 1212 */       opencv_core.cvGetMat(this, mat, null, 0);
/* 1213 */       return mat;
/*      */     }
/*      */ 
/*      */     public String toString() {
/* 1217 */       if (isNull()) {
/* 1218 */         return super.toString();
/*      */       }
/* 1220 */       return "IplImage[width=" + width() + ",height=" + height() + ",depth=" + depth() + ",nChannels=" + nChannels() + "]";
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  611 */       gamma22 = new byte[256];
/*  612 */       gamma22inv = new byte[256];
/*      */ 
/*  614 */       for (int i = 0; i < 256; i++) {
/*  615 */         gamma22[i] = ((byte)(int)Math.round(Math.pow(i / 255.0D, 2.2D) * 255.0D));
/*  616 */         gamma22inv[i] = ((byte)(int)Math.round(Math.pow(i / 255.0D, 0.4545454545454545D) * 255.0D));
/*      */       }
/*      */     }
/*      */ 
/*      */     protected static class HeaderReleaseDeallocator extends opencv_core.IplImage
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       HeaderReleaseDeallocator(opencv_core.IplImage p)
/*      */       {
/*  549 */         super(); } 
/*  550 */       public void deallocate() { opencv_core.cvReleaseImageHeader(this); }
/*      */ 
/*      */     }
/*      */ 
/*      */     protected static class ReleaseDeallocator extends opencv_core.IplImage
/*      */       implements Pointer.Deallocator
/*      */     {
/*      */       ReleaseDeallocator(opencv_core.IplImage p)
/*      */       {
/*  545 */         super(); } 
/*  546 */       public void deallocate() { opencv_core.cvReleaseImage(this); }
/*      */ 
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class CvRNG extends LongPointer
/*      */   {
/*      */     public CvRNG()
/*      */     {
/*  349 */       this(null); allocate(); } 
/*  350 */     public CvRNG(Pointer p) { super(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     static
/*      */     {
/*  348 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv64suf extends Pointer
/*      */   {
/*      */     public Cv64suf()
/*      */     {
/*  272 */       allocate(); } 
/*  273 */     public Cv64suf(int size) { allocateArray(size); } 
/*  274 */     public Cv64suf(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  279 */     public Cv64suf position(int position) { return (Cv64suf)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native long i();
/*      */ 
/*      */     public native Cv64suf i(long paramLong);
/*      */ 
/*      */     public native long u();
/*      */ 
/*      */     public native Cv64suf u(long paramLong);
/*      */ 
/*      */     public native double f();
/*      */ 
/*      */     public native Cv64suf f(double paramDouble);
/*      */ 
/*      */     static
/*      */     {
/*  271 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cv32suf extends Pointer
/*      */   {
/*      */     public Cv32suf()
/*      */     {
/*  255 */       allocate(); } 
/*  256 */     public Cv32suf(int size) { allocateArray(size); } 
/*  257 */     public Cv32suf(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  262 */     public Cv32suf position(int position) { return (Cv32suf)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int i();
/*      */ 
/*      */     public native Cv32suf i(int paramInt);
/*      */ 
/*      */     public native int u();
/*      */ 
/*      */     public native Cv32suf u(int paramInt);
/*      */ 
/*      */     public native float f();
/*      */ 
/*      */     public native Cv32suf f(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  254 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"IplImage*"})
/*      */   public static class IplImageArray extends opencv_core.CvArrArray
/*      */   {
/*      */     public IplImageArray(opencv_core.IplImage[] array)
/*      */     {
/*  232 */       this(array.length); put(array); position(0); } 
/*  233 */     public IplImageArray(int size) { super(); allocateArray(size); } 
/*  234 */     public IplImageArray(Pointer p) { super(); } 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public IplImageArray position(int position) {
/*  238 */       return (IplImageArray)super.position(position);
/*      */     }
/*      */     public IplImageArray put(opencv_core.CvArr[] array) {
/*  241 */       return (IplImageArray)super.put(array); } 
/*      */     @ValueGetter
/*      */     public native opencv_core.IplImage get();
/*      */ 
/*  245 */     public IplImageArray put(opencv_core.CvArr p) { if ((p instanceof opencv_core.IplImage)) {
/*  246 */         return (IplImageArray)super.put(p);
/*      */       }
/*  248 */       throw new ArrayStoreException(p.getClass().getName());
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"CvMatND*"})
/*      */   public static class CvMatNDArray extends opencv_core.CvArrArray
/*      */   {
/*      */     public CvMatNDArray(opencv_core.CvMatND[] array)
/*      */     {
/*  209 */       this(array.length); put(array); position(0); } 
/*  210 */     public CvMatNDArray(int size) { super(); allocateArray(size); } 
/*  211 */     public CvMatNDArray(Pointer p) { super(); } 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public CvMatNDArray position(int position) {
/*  215 */       return (CvMatNDArray)super.position(position);
/*      */     }
/*      */     public CvMatNDArray put(opencv_core.CvArr[] array) {
/*  218 */       return (CvMatNDArray)super.put(array); } 
/*      */     @ValueGetter
/*      */     public native opencv_core.CvMatND get();
/*      */ 
/*  222 */     public CvMatNDArray put(opencv_core.CvArr p) { if ((p instanceof opencv_core.CvMatND)) {
/*  223 */         return (CvMatNDArray)super.put(p);
/*      */       }
/*  225 */       throw new ArrayStoreException(p.getClass().getName());
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"CvMat*"})
/*      */   public static class CvMatArray extends opencv_core.CvArrArray
/*      */   {
/*      */     public CvMatArray(opencv_core.CvMat[] array)
/*      */     {
/*  186 */       this(array.length); put(array); position(0); } 
/*  187 */     public CvMatArray(int size) { super(); allocateArray(size); } 
/*  188 */     public CvMatArray(Pointer p) { super(); } 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public CvMatArray position(int position) {
/*  192 */       return (CvMatArray)super.position(position);
/*      */     }
/*      */     public CvMatArray put(opencv_core.CvArr[] array) {
/*  195 */       return (CvMatArray)super.put(array); } 
/*      */     @ValueGetter
/*      */     public native opencv_core.CvMat get();
/*      */ 
/*  199 */     public CvMatArray put(opencv_core.CvArr p) { if ((p instanceof opencv_core.CvMat)) {
/*  200 */         return (CvMatArray)super.put(p);
/*      */       }
/*  202 */       throw new ArrayStoreException(p.getClass().getName());
/*      */     }
/*      */   }
/*      */ 
/*      */   @Name({"CvArr*"})
/*      */   public static class CvArrArray extends Pointer
/*      */   {
/*      */     public CvArrArray(opencv_core.CvArr[] array)
/*      */     {
/*  164 */       this(array.length); put(array); position(0); } 
/*  165 */     public CvArrArray(int size) { allocateArray(size); } 
/*  166 */     public CvArrArray(Pointer p) { super(); } 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*      */     public CvArrArray position(int position) {
/*  170 */       return (CvArrArray)super.position(position);
/*      */     }
/*      */ 
/*      */     public CvArrArray put(opencv_core.CvArr[] array) {
/*  174 */       for (int i = 0; i < array.length; i++) {
/*  175 */         position(i).put(array[i]);
/*      */       }
/*  177 */       return this;
/*      */     }
/*      */ 
/*      */     public native opencv_core.CvArr get();
/*      */ 
/*      */     public native CvArrArray put(opencv_core.CvArr paramCvArr);
/*      */ 
/*      */     static
/*      */     {
/*  163 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class CvArr extends Pointer
/*      */     implements Cloneable
/*      */   {
/*      */     protected CvArr()
/*      */     {
/*      */     }
/*      */ 
/*      */     protected CvArr(Pointer p)
/*      */     {
/*  158 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  156 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_core
 * JD-Core Version:    0.6.2
 */