/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.FunctionPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.PointerPointer;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Opaque;
/*     */ import com.googlecode.javacpp.annotation.Platform;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ 
/*     */ @Properties(inherit={opencv_imgproc.class}, value={@Platform(include={"<opencv2/highgui/highgui_c.h>"}, link={"opencv_highgui@.2.4"}), @Platform(value={"windows"}, link={"opencv_highgui248"}, preload={"opencv_ffmpeg248", "opencv_ffmpeg248_64"})})
/*     */ public class opencv_highgui
/*     */ {
/*     */   public static final int CV_FONT_LIGHT = 25;
/*     */   public static final int CV_FONT_NORMAL = 50;
/*     */   public static final int CV_FONT_DEMIBOLD = 63;
/*     */   public static final int CV_FONT_BOLD = 75;
/*     */   public static final int CV_FONT_BLACK = 87;
/*     */   public static final int CV_STYLE_NORMAL = 0;
/*     */   public static final int CV_STYLE_ITALIC = 1;
/*     */   public static final int CV_STYLE_OBLIQUE = 2;
/* 130 */   public static int CV_PUSH_BUTTON = 0; public static int CV_CHECKBOX = 1; public static int CV_RADIOBOX = 2;
/*     */   public static final int CV_WND_PROP_FULLSCREEN = 0;
/*     */   public static final int CV_WND_PROP_AUTOSIZE = 1;
/*     */   public static final int CV_WND_PROP_ASPECTRATIO = 2;
/*     */   public static final int CV_WND_PROP_OPENGL = 3;
/*     */   public static final int CV_WINDOW_NORMAL = 0;
/*     */   public static final int CV_WINDOW_AUTOSIZE = 1;
/*     */   public static final int CV_WINDOW_OPENGL = 4096;
/*     */   public static final int CV_GUI_EXPANDED = 0;
/*     */   public static final int CV_GUI_NORMAL = 16;
/*     */   public static final int CV_WINDOW_FULLSCREEN = 1;
/*     */   public static final int CV_WINDOW_FREERATIO = 256;
/*     */   public static final int CV_WINDOW_KEEPRATIO = 0;
/*     */   public static final int CV_EVENT_MOUSEMOVE = 0;
/*     */   public static final int CV_EVENT_LBUTTONDOWN = 1;
/*     */   public static final int CV_EVENT_RBUTTONDOWN = 2;
/*     */   public static final int CV_EVENT_MBUTTONDOWN = 3;
/*     */   public static final int CV_EVENT_LBUTTONUP = 4;
/*     */   public static final int CV_EVENT_RBUTTONUP = 5;
/*     */   public static final int CV_EVENT_MBUTTONUP = 6;
/*     */   public static final int CV_EVENT_LBUTTONDBLCLK = 7;
/*     */   public static final int CV_EVENT_RBUTTONDBLCLK = 8;
/*     */   public static final int CV_EVENT_MBUTTONDBLCLK = 9;
/*     */   public static final int CV_EVENT_FLAG_LBUTTON = 1;
/*     */   public static final int CV_EVENT_FLAG_RBUTTON = 2;
/*     */   public static final int CV_EVENT_FLAG_MBUTTON = 4;
/*     */   public static final int CV_EVENT_FLAG_CTRLKEY = 8;
/*     */   public static final int CV_EVENT_FLAG_SHIFTKEY = 16;
/*     */   public static final int CV_EVENT_FLAG_ALTKEY = 32;
/*     */   public static final int CV_LOAD_IMAGE_UNCHANGED = -1;
/*     */   public static final int CV_LOAD_IMAGE_GRAYSCALE = 0;
/*     */   public static final int CV_LOAD_IMAGE_COLOR = 1;
/*     */   public static final int CV_LOAD_IMAGE_ANYDEPTH = 2;
/*     */   public static final int CV_LOAD_IMAGE_ANYCOLOR = 4;
/*     */   public static final int CV_IMWRITE_JPEG_QUALITY = 1;
/*     */   public static final int CV_IMWRITE_PNG_COMPRESSION = 16;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY = 17;
/*     */   public static final int CV_IMWRITE_PNG_BILEVEL = 18;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY_DEFAULT = 0;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY_FILTERED = 1;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY = 2;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY_RLE = 3;
/*     */   public static final int CV_IMWRITE_PNG_STRATEGY_FIXED = 4;
/*     */   public static final int CV_IMWRITE_PXM_BINARY = 32;
/*     */   public static final int CV_CVTIMG_FLIP = 1;
/*     */   public static final int CV_CVTIMG_SWAP_RB = 2;
/*     */   public static final int CV_CAP_ANY = 0;
/*     */   public static final int CV_CAP_MIL = 100;
/*     */   public static final int CV_CAP_VFW = 200;
/*     */   public static final int CV_CAP_V4L = 200;
/*     */   public static final int CV_CAP_V4L2 = 200;
/*     */   public static final int CV_CAP_FIREWARE = 300;
/*     */   public static final int CV_CAP_FIREWIRE = 300;
/*     */   public static final int CV_CAP_IEEE1394 = 300;
/*     */   public static final int CV_CAP_DC1394 = 300;
/*     */   public static final int CV_CAP_CMU1394 = 300;
/*     */   public static final int CV_CAP_STEREO = 400;
/*     */   public static final int CV_CAP_TYZX = 400;
/*     */   public static final int CV_TYZX_LEFT = 400;
/*     */   public static final int CV_TYZX_RIGHT = 401;
/*     */   public static final int CV_TYZX_COLOR = 402;
/*     */   public static final int CV_TYZX_Z = 403;
/*     */   public static final int CV_CAP_QT = 500;
/*     */   public static final int CV_CAP_UNICAP = 600;
/*     */   public static final int CV_CAP_DSHOW = 700;
/*     */   public static final int CV_CAP_MSMF = 1400;
/*     */   public static final int CV_CAP_PVAPI = 800;
/*     */   public static final int CV_CAP_OPENNI = 900;
/*     */   public static final int CV_CAP_OPENNI_ASUS = 910;
/*     */   public static final int CV_CAP_ANDROID = 1000;
/*     */   public static final int CV_CAP_ANDROID_BACK = 1099;
/*     */   public static final int CV_CAP_ANDROID_FRONT = 1098;
/*     */   public static final int CV_CAP_XIAPI = 1100;
/*     */   public static final int CV_CAP_AVFOUNDATION = 1200;
/*     */   public static final int CV_CAP_GIGANETIX = 1300;
/*     */   public static final int CV_CAP_INTELPERC = 1500;
/*     */   public static final int CV_CAP_PROP_DC1394_OFF = -4;
/*     */   public static final int CV_CAP_PROP_DC1394_MODE_MANUAL = -3;
/*     */   public static final int CV_CAP_PROP_DC1394_MODE_AUTO = -2;
/*     */   public static final int CV_CAP_PROP_DC1394_MODE_ONE_PUSH_AUTO = -1;
/*     */   public static final int CV_CAP_PROP_POS_MSEC = 0;
/*     */   public static final int CV_CAP_PROP_POS_FRAMES = 1;
/*     */   public static final int CV_CAP_PROP_POS_AVI_RATIO = 2;
/*     */   public static final int CV_CAP_PROP_FRAME_WIDTH = 3;
/*     */   public static final int CV_CAP_PROP_FRAME_HEIGHT = 4;
/*     */   public static final int CV_CAP_PROP_FPS = 5;
/*     */   public static final int CV_CAP_PROP_FOURCC = 6;
/*     */   public static final int CV_CAP_PROP_FRAME_COUNT = 7;
/*     */   public static final int CV_CAP_PROP_FORMAT = 8;
/*     */   public static final int CV_CAP_PROP_MODE = 9;
/*     */   public static final int CV_CAP_PROP_BRIGHTNESS = 10;
/*     */   public static final int CV_CAP_PROP_CONTRAST = 11;
/*     */   public static final int CV_CAP_PROP_SATURATION = 12;
/*     */   public static final int CV_CAP_PROP_HUE = 13;
/*     */   public static final int CV_CAP_PROP_GAIN = 14;
/*     */   public static final int CV_CAP_PROP_EXPOSURE = 15;
/*     */   public static final int CV_CAP_PROP_CONVERT_RGB = 16;
/*     */   public static final int CV_CAP_PROP_WHITE_BALANCE_BLUE_U = 17;
/*     */   public static final int CV_CAP_PROP_RECTIFICATION = 18;
/*     */   public static final int CV_CAP_PROP_MONOCROME = 19;
/*     */   public static final int CV_CAP_PROP_SHARPNESS = 20;
/*     */   public static final int CV_CAP_PROP_AUTO_EXPOSURE = 21;
/*     */   public static final int CV_CAP_PROP_GAMMA = 22;
/*     */   public static final int CV_CAP_PROP_TEMPERATURE = 23;
/*     */   public static final int CV_CAP_PROP_TRIGGER = 24;
/*     */   public static final int CV_CAP_PROP_TRIGGER_DELAY = 25;
/*     */   public static final int CV_CAP_PROP_WHITE_BALANCE_RED_V = 26;
/*     */   public static final int CV_CAP_PROP_ZOOM = 27;
/*     */   public static final int CV_CAP_PROP_FOCUS = 28;
/*     */   public static final int CV_CAP_PROP_GUID = 29;
/*     */   public static final int CV_CAP_PROP_ISO_SPEED = 30;
/*     */   public static final int CV_CAP_PROP_MAX_DC1394 = 31;
/*     */   public static final int CV_CAP_PROP_BACKLIGHT = 32;
/*     */   public static final int CV_CAP_PROP_PAN = 33;
/*     */   public static final int CV_CAP_PROP_TILT = 34;
/*     */   public static final int CV_CAP_PROP_ROLL = 35;
/*     */   public static final int CV_CAP_PROP_IRIS = 36;
/*     */   public static final int CV_CAP_PROP_SETTINGS = 37;
/*     */   public static final int CV_CAP_PROP_AUTOGRAB = 1024;
/*     */   public static final int CV_CAP_PROP_SUPPORTED_PREVIEW_SIZES_STRING = 1025;
/*     */   public static final int CV_CAP_PROP_PREVIEW_FORMAT = 1025;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_GENERATOR = -2147483648;
/*     */   public static final int CV_CAP_OPENNI_IMAGE_GENERATOR = 1073741824;
/*     */   public static final int CV_CAP_OPENNI_GENERATORS_MASK = -1073741824;
/*     */   public static final int CV_CAP_PROP_OPENNI_OUTPUT_MODE = 100;
/*     */   public static final int CV_CAP_PROP_OPENNI_FRAME_MAX_DEPTH = 101;
/*     */   public static final int CV_CAP_PROP_OPENNI_BASELINE = 102;
/*     */   public static final int CV_CAP_PROP_OPENNI_FOCAL_LENGTH = 103;
/*     */   public static final int CV_CAP_PROP_OPENNI_REGISTRATION = 104;
/*     */   public static final int CV_CAP_PROP_OPENNI_REGISTRATION_ON = 104;
/*     */   public static final int CV_CAP_PROP_OPENNI_APPROX_FRAME_SYNC = 105;
/*     */   public static final int CV_CAP_PROP_OPENNI_MAX_BUFFER_SIZE = 106;
/*     */   public static final int CV_CAP_PROP_OPENNI_CIRCLE_BUFFER = 107;
/*     */   public static final int CV_CAP_PROP_OPENNI_MAX_TIME_DURATION = 108;
/*     */   public static final int CV_CAP_PROP_OPENNI_GENERATOR_PRESENT = 109;
/*     */   public static final int CV_CAP_OPENNI_IMAGE_GENERATOR_PRESENT = 1073741933;
/*     */   public static final int CV_CAP_OPENNI_IMAGE_GENERATOR_OUTPUT_MODE = 1073741924;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_BASELINE = -2147483546;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_FOCAL_LENGTH = -2147483545;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION = -2147483544;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION_ON = -2147483544;
/*     */   public static final int CV_CAP_GSTREAMER_QUEUE_LENGTH = 200;
/*     */   public static final int CV_CAP_PROP_PVAPI_MULTICASTIP = 300;
/*     */   public static final int CV_CAP_PROP_XI_DOWNSAMPLING = 400;
/*     */   public static final int CV_CAP_PROP_XI_DATA_FORMAT = 401;
/*     */   public static final int CV_CAP_PROP_XI_OFFSET_X = 402;
/*     */   public static final int CV_CAP_PROP_XI_OFFSET_Y = 403;
/*     */   public static final int CV_CAP_PROP_XI_TRG_SOURCE = 404;
/*     */   public static final int CV_CAP_PROP_XI_TRG_SOFTWARE = 405;
/*     */   public static final int CV_CAP_PROP_XI_GPI_SELECTOR = 406;
/*     */   public static final int CV_CAP_PROP_XI_GPI_MODE = 407;
/*     */   public static final int CV_CAP_PROP_XI_GPI_LEVEL = 408;
/*     */   public static final int CV_CAP_PROP_XI_GPO_SELECTOR = 409;
/*     */   public static final int CV_CAP_PROP_XI_GPO_MODE = 410;
/*     */   public static final int CV_CAP_PROP_XI_LED_SELECTOR = 411;
/*     */   public static final int CV_CAP_PROP_XI_LED_MODE = 412;
/*     */   public static final int CV_CAP_PROP_XI_MANUAL_WB = 413;
/*     */   public static final int CV_CAP_PROP_XI_AUTO_WB = 414;
/*     */   public static final int CV_CAP_PROP_XI_AEAG = 415;
/*     */   public static final int CV_CAP_PROP_XI_EXP_PRIORITY = 416;
/*     */   public static final int CV_CAP_PROP_XI_AE_MAX_LIMIT = 417;
/*     */   public static final int CV_CAP_PROP_XI_AG_MAX_LIMIT = 418;
/*     */   public static final int CV_CAP_PROP_XI_AEAG_LEVEL = 419;
/*     */   public static final int CV_CAP_PROP_XI_TIMEOUT = 420;
/*     */   public static final int CV_CAP_PROP_ANDROID_FLASH_MODE = 8001;
/*     */   public static final int CV_CAP_PROP_ANDROID_FOCUS_MODE = 8002;
/*     */   public static final int CV_CAP_PROP_ANDROID_WHITE_BALANCE = 8003;
/*     */   public static final int CV_CAP_PROP_ANDROID_ANTIBANDING = 8004;
/*     */   public static final int CV_CAP_PROP_ANDROID_FOCAL_LENGTH = 8005;
/*     */   public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_NEAR = 8006;
/*     */   public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_OPTIMAL = 8007;
/*     */   public static final int CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_FAR = 8008;
/*     */   public static final int CV_CAP_PROP_IOS_DEVICE_FOCUS = 9001;
/*     */   public static final int CV_CAP_PROP_IOS_DEVICE_EXPOSURE = 9002;
/*     */   public static final int CV_CAP_PROP_IOS_DEVICE_FLASH = 9003;
/*     */   public static final int CV_CAP_PROP_IOS_DEVICE_WHITEBALANCE = 9004;
/*     */   public static final int CV_CAP_PROP_IOS_DEVICE_TORCH = 9005;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_OFFSET_X = 10001;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_OFFSET_Y = 10002;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_WIDTH_MAX = 10003;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_HEIGH_MAX = 10004;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_SENS_WIDTH = 10005;
/*     */   public static final int CV_CAP_PROP_GIGA_FRAME_SENS_HEIGH = 10006;
/*     */   public static final int CV_CAP_PROP_INTELPERC_PROFILE_COUNT = 11001;
/*     */   public static final int CV_CAP_PROP_INTELPERC_PROFILE_IDX = 11002;
/*     */   public static final int CV_CAP_PROP_INTELPERC_DEPTH_LOW_CONFIDENCE_VALUE = 11003;
/*     */   public static final int CV_CAP_PROP_INTELPERC_DEPTH_SATURATION_VALUE = 11004;
/*     */   public static final int CV_CAP_PROP_INTELPERC_DEPTH_CONFIDENCE_THRESHOLD = 11005;
/*     */   public static final int CV_CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_HORZ = 11006;
/*     */   public static final int CV_CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_VERT = 11007;
/*     */   public static final int CV_CAP_INTELPERC_DEPTH_GENERATOR = 536870912;
/*     */   public static final int CV_CAP_INTELPERC_IMAGE_GENERATOR = 268435456;
/*     */   public static final int CV_CAP_INTELPERC_GENERATORS_MASK = 805306368;
/*     */   public static final int CV_CAP_OPENNI_DEPTH_MAP = 0;
/*     */   public static final int CV_CAP_OPENNI_POINT_CLOUD_MAP = 1;
/*     */   public static final int CV_CAP_OPENNI_DISPARITY_MAP = 2;
/*     */   public static final int CV_CAP_OPENNI_DISPARITY_MAP_32F = 3;
/*     */   public static final int CV_CAP_OPENNI_VALID_DEPTH_MASK = 4;
/*     */   public static final int CV_CAP_OPENNI_BGR_IMAGE = 5;
/*     */   public static final int CV_CAP_OPENNI_GRAY_IMAGE = 6;
/*     */   public static final int CV_CAP_OPENNI_VGA_30HZ = 0;
/*     */   public static final int CV_CAP_OPENNI_SXGA_15HZ = 1;
/*     */   public static final int CV_CAP_OPENNI_SXGA_30HZ = 2;
/*     */   public static final int CV_CAP_OPENNI_QVGA_30HZ = 3;
/*     */   public static final int CV_CAP_OPENNI_QVGA_60HZ = 4;
/*     */   public static final int CV_CAP_ANDROID_COLOR_FRAME_BGR = 0;
/*     */   public static final int CV_CAP_ANDROID_COLOR_FRAME = 0;
/*     */   public static final int CV_CAP_ANDROID_GREY_FRAME = 1;
/*     */   public static final int CV_CAP_ANDROID_COLOR_FRAME_RGB = 2;
/*     */   public static final int CV_CAP_ANDROID_COLOR_FRAME_BGRA = 3;
/*     */   public static final int CV_CAP_ANDROID_COLOR_FRAME_RGBA = 4;
/*     */   public static final int CV_CAP_ANDROID_FLASH_MODE_AUTO = 0;
/*     */   public static final int CV_CAP_ANDROID_FLASH_MODE_OFF = 1;
/*     */   public static final int CV_CAP_ANDROID_FLASH_MODE_ON = 2;
/*     */   public static final int CV_CAP_ANDROID_FLASH_MODE_RED_EYE = 3;
/*     */   public static final int CV_CAP_ANDROID_FLASH_MODE_TORCH = 4;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_AUTO = 0;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_CONTINUOUS_VIDEO = 1;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_EDOF = 2;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_FIXED = 3;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_INFINITY = 4;
/*     */   public static final int CV_CAP_ANDROID_FOCUS_MODE_MACRO = 5;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_AUTO = 0;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_CLOUDY_DAYLIGHT = 1;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_DAYLIGHT = 2;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_FLUORESCENT = 3;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_INCANDESCENT = 4;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_SHADE = 5;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_TWILIGHT = 6;
/*     */   public static final int CV_CAP_ANDROID_WHITE_BALANCE_WARM_FLUORESCENT = 7;
/*     */   public static final int CV_CAP_ANDROID_ANTIBANDING_50HZ = 0;
/*     */   public static final int CV_CAP_ANDROID_ANTIBANDING_60HZ = 1;
/*     */   public static final int CV_CAP_ANDROID_ANTIBANDING_AUTO = 2;
/*     */   public static final int CV_CAP_ANDROID_ANTIBANDING_OFF = 3;
/*     */   public static final int CV_CAP_INTELPERC_DEPTH_MAP = 0;
/*     */   public static final int CV_CAP_INTELPERC_UVDEPTH_MAP = 1;
/*     */   public static final int CV_CAP_INTELPERC_IR_MAP = 2;
/*     */   public static final int CV_CAP_INTELPERC_IMAGE = 3;
/*     */   public static final int CV_FOURCC_PROMPT = -1;
/* 571 */   public static final int CV_FOURCC_DEFAULT = CV_FOURCC('I', 'Y', 'U', 'V');
/*     */ 
/*     */   @Platform({"linux"})
/*     */   @ByVal
/*     */   public static native opencv_core.CvFont cvFontQt(String paramString, int paramInt1, @ByVal opencv_core.CvScalar paramCvScalar, int paramInt2, int paramInt3, int paramInt4);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvAddText(opencv_core.CvArr paramCvArr, String paramString, @ByVal opencv_core.CvPoint paramCvPoint, opencv_core.CvFont paramCvFont);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvDisplayOverlay(String paramString1, String paramString2, int paramInt);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvDisplayStatusBar(String paramString1, String paramString2, int paramInt);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvSaveWindowParameters(String paramString);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvLoadWindowParameters(String paramString);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native int cvStartLoop(Pt2Func paramPt2Func, int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native void cvStopLoop();
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static native int cvCreateButton(String paramString, CvButtonCallback paramCvButtonCallback, Pointer paramPointer, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native int cvInitSystem(int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
/*     */ 
/*     */   public static native int cvStartWindowThread();
/*     */ 
/*     */   public static int cvNamedWindow(String name)
/*     */   {
/* 156 */     return cvNamedWindow(name, 1);
/*     */   }
/*     */ 
/*     */   public static native int cvNamedWindow(String paramString, int paramInt);
/*     */ 
/*     */   public static native void cvSetWindowProperty(String paramString, int paramInt, double paramDouble);
/*     */ 
/*     */   public static native double cvGetWindowProperty(String paramString, int paramInt);
/*     */ 
/*     */   public static native void cvShowImage(String paramString, opencv_core.CvArr paramCvArr);
/*     */ 
/*     */   public static native void cvResizeWindow(String paramString, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native void cvMoveWindow(String paramString, int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native void cvDestroyWindow(String paramString);
/*     */ 
/*     */   public static native void cvDestroyAllWindows();
/*     */ 
/*     */   public static native Pointer cvGetWindowHandle(String paramString);
/*     */ 
/*     */   public static native String cvGetWindowName(Pointer paramPointer);
/*     */ 
/*     */   public static native int cvCreateTrackbar(String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, CvTrackbarCallback paramCvTrackbarCallback);
/*     */ 
/*     */   public static native int cvCreateTrackbar2(String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, CvTrackbarCallback2 paramCvTrackbarCallback2, Pointer paramPointer);
/*     */ 
/*     */   public static native int cvGetTrackbarPos(String paramString1, String paramString2);
/*     */ 
/*     */   public static native void cvSetTrackbarPos(String paramString1, String paramString2, int paramInt);
/*     */ 
/*     */   public static native void cvSetMouseCallback(String paramString, CvMouseCallback paramCvMouseCallback, Pointer paramPointer);
/*     */ 
/*     */   public static opencv_core.IplImage cvLoadImage(String filename)
/*     */   {
/* 235 */     return cvLoadImage(filename, 1); } 
/*     */   public static native opencv_core.IplImage cvLoadImage(String paramString, int paramInt);
/*     */ 
/* 237 */   public static opencv_core.CvMat cvLoadImageM(String filename) { return cvLoadImageM(filename, 1); } 
/*     */   public static native opencv_core.CvMat cvLoadImageM(String paramString, int paramInt);
/*     */ 
/*     */   public static opencv_core.IplImage cvLoadImageBGRA(String filename) {
/* 241 */     opencv_core.IplImage imageBGR = cvLoadImage(filename, 1);
/* 242 */     if (imageBGR == null) {
/* 243 */       return null;
/*     */     }
/* 245 */     opencv_core.IplImage imageBGRA = opencv_core.cvCreateImage(opencv_core.cvGetSize(imageBGR), imageBGR.depth(), 4);
/* 246 */     opencv_imgproc.cvCvtColor(imageBGR, imageBGRA, 0);
/* 247 */     opencv_core.cvReleaseImage(imageBGR);
/* 248 */     return imageBGRA;
/*     */   }
/*     */ 
/*     */   public static opencv_core.IplImage cvLoadImageRGBA(String filename)
/*     */   {
/* 253 */     opencv_core.IplImage imageBGR = cvLoadImage(filename, 1);
/* 254 */     if (imageBGR == null) {
/* 255 */       return null;
/*     */     }
/* 257 */     opencv_core.IplImage imageRGBA = opencv_core.cvCreateImage(opencv_core.cvGetSize(imageBGR), imageBGR.depth(), 4);
/* 258 */     opencv_imgproc.cvCvtColor(imageBGR, imageRGBA, 2);
/* 259 */     opencv_core.cvReleaseImage(imageBGR);
/* 260 */     return imageRGBA;
/*     */   }
/*     */ 
/*     */   public static int cvSaveImage(String filename, opencv_core.CvArr image)
/*     */   {
/* 276 */     return cvSaveImage(filename, image, null); } 
/*     */   public static native int cvSaveImage(String paramString, opencv_core.CvArr paramCvArr, int[] paramArrayOfInt);
/*     */ 
/* 279 */   public static opencv_core.IplImage cvDecodeImage(opencv_core.CvMat buf) { return cvDecodeImage(buf, 1); } 
/*     */   public static native opencv_core.IplImage cvDecodeImage(opencv_core.CvMat paramCvMat, int paramInt);
/*     */ 
/* 281 */   public static opencv_core.CvMat cvDecodeImageM(opencv_core.CvMat buf) { return cvDecodeImageM(buf, 1); } 
/*     */   public static native opencv_core.CvMat cvDecodeImageM(opencv_core.CvMat paramCvMat, int paramInt);
/*     */ 
/* 283 */   public static opencv_core.CvMat cvEncodeImage(String ext, opencv_core.CvArr image) { return cvEncodeImage(ext, image, null); }
/*     */ 
/*     */ 
/*     */   public static native opencv_core.CvMat cvEncodeImage(String paramString, opencv_core.CvArr paramCvArr, int[] paramArrayOfInt);
/*     */ 
/*     */   public static native void cvConvertImage(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, int paramInt);
/*     */ 
/*     */   public static int cvWaitKey()
/*     */   {
/* 292 */     return cvWaitKey(0);
/*     */   }
/*     */ 
/*     */   public static native int cvWaitKey(int paramInt);
/*     */ 
/*     */   public static native void cvSetOpenGlDrawCallback(String paramString, CvOpenGLCallback paramCvOpenGLCallback, Pointer paramPointer);
/*     */ 
/*     */   public static native void cvSetOpenGlContext(String paramString);
/*     */ 
/*     */   public static native void cvUpdateWindow(String paramString);
/*     */ 
/*     */   public static native CvCapture cvCreateFileCapture(String paramString);
/*     */ 
/*     */   public static native CvCapture cvCreateCameraCapture(int paramInt);
/*     */ 
/*     */   public static native int cvGrabFrame(CvCapture paramCvCapture);
/*     */ 
/*     */   public static opencv_core.IplImage cvRetrieveFrame(CvCapture capture)
/*     */   {
/* 363 */     return cvRetrieveFrame(capture, 0);
/*     */   }
/*     */ 
/*     */   public static native opencv_core.IplImage cvRetrieveFrame(CvCapture paramCvCapture, int paramInt);
/*     */ 
/*     */   public static native opencv_core.IplImage cvQueryFrame(CvCapture paramCvCapture);
/*     */ 
/*     */   public static native void cvReleaseCapture(@ByPtrPtr CvCapture paramCvCapture);
/*     */ 
/*     */   public static native double cvGetCaptureProperty(CvCapture paramCvCapture, int paramInt);
/*     */ 
/*     */   public static native int cvSetCaptureProperty(CvCapture paramCvCapture, int paramInt, double paramDouble);
/*     */ 
/*     */   public static native int cvGetCaptureDomain(CvCapture paramCvCapture);
/*     */ 
/*     */   public static int CV_FOURCC(byte c1, byte c2, byte c3, byte c4)
/*     */   {
/* 563 */     return (c1 & 0xFF) + ((c2 & 0xFF) << 8) + ((c3 & 0xFF) << 16) + ((c4 & 0xFF) << 24);
/*     */   }
/*     */   public static int CV_FOURCC(char c1, char c2, char c3, char c4) {
/* 566 */     return CV_FOURCC((byte)c1, (byte)c2, (byte)c3, (byte)c4);
/*     */   }
/*     */ 
/*     */   public static native CvVideoWriter cvCreateVideoWriter(String paramString, int paramInt1, double paramDouble, @ByVal opencv_core.CvSize paramCvSize, int paramInt2);
/*     */ 
/*     */   public static native int cvWriteFrame(CvVideoWriter paramCvVideoWriter, opencv_core.IplImage paramIplImage);
/*     */ 
/*     */   public static native void cvReleaseVideoWriter(@ByPtrPtr CvVideoWriter paramCvVideoWriter);
/*     */ 
/*     */   static
/*     */   {
/*  79 */     Loader.load();
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class CvVideoWriter extends Pointer
/*     */   {
/*     */     public CvVideoWriter()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CvVideoWriter(Pointer p)
/*     */     {
/* 559 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 557 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class CvCapture extends Pointer
/*     */   {
/*     */     public CvCapture()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CvCapture(Pointer p)
/*     */     {
/* 311 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 309 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvOpenGLCallback extends FunctionPointer
/*     */   {
/*     */     public CvOpenGLCallback(Pointer p)
/*     */     {
/* 297 */       super(); } 
/* 298 */     protected CvOpenGLCallback() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(Pointer paramPointer);
/*     */ 
/*     */     static
/*     */     {
/* 296 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvMouseCallback extends FunctionPointer
/*     */   {
/*     */     public CvMouseCallback(Pointer p)
/*     */     {
/* 219 */       super(); } 
/* 220 */     protected CvMouseCallback() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Pointer paramPointer);
/*     */ 
/*     */     static
/*     */     {
/* 218 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvTrackbarCallback2 extends FunctionPointer
/*     */   {
/*     */     public CvTrackbarCallback2(Pointer p)
/*     */     {
/* 186 */       super(); } 
/* 187 */     protected CvTrackbarCallback2() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(int paramInt, Pointer paramPointer);
/*     */ 
/*     */     static
/*     */     {
/* 185 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CvTrackbarCallback extends FunctionPointer
/*     */   {
/*     */     public CvTrackbarCallback(Pointer p)
/*     */     {
/* 176 */       super(); } 
/* 177 */     protected CvTrackbarCallback() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 175 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static class CvButtonCallback extends FunctionPointer
/*     */   {
/*     */     public CvButtonCallback(Pointer p)
/*     */     {
/* 125 */       super(); } 
/* 126 */     protected CvButtonCallback() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(int paramInt, Pointer paramPointer);
/*     */ 
/*     */     static
/*     */     {
/* 124 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Platform({"linux"})
/*     */   public static class Pt2Func extends FunctionPointer
/*     */   {
/*     */     public Pt2Func(Pointer p)
/*     */     {
/* 112 */       super(); } 
/* 113 */     protected Pt2Func() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native int call(int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer);
/*     */ 
/*     */     static
/*     */     {
/* 111 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.opencv_highgui
 * JD-Core Version:    0.6.2
 */