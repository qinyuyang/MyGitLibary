/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import java.nio.ByteBuffer;
/*      */ 
/*      */ @Properties({@com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"PGRFlyCapture"}, preload={"FlyCapture2"}, include={"<windows.h>", "<PGRFlyCapture.h>", "<PGRFlyCapturePlus.h>", "<PGRFlyCaptureMessaging.h>"}, includepath={"C:/Program Files/Point Grey Research/PGR FlyCapture/include/", "C:/Program Files/Point Grey Research/FlyCapture2/include/FC1/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86"}, linkpath={"C:/Program Files/Point Grey Research/PGR FlyCapture/lib/", "C:/Program Files/Point Grey Research/FlyCapture2/lib/FC1/"}, preloadpath={"C:/Program Files/Point Grey Research/PGR FlyCapture/bin/", "C:/Program Files/Point Grey Research/FlyCapture2/bin/", "C:/Program Files/Point Grey Research/FlyCapture2/bin/FC1/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86_64"}, linkpath={"C:/Program Files/Point Grey Research/PGR FlyCapture/lib64/", "C:/Program Files/Point Grey Research/FlyCapture2/lib64/FC1/"}, preloadpath={"C:/Program Files/Point Grey Research/PGR FlyCapture/bin64/", "C:/Program Files/Point Grey Research/FlyCapture2/bin64/", "C:/Program Files/Point Grey Research/FlyCapture2/bin64/FC1/"})})
/*      */ public class PGRFlyCapture
/*      */ {
/*      */   public static final int FLYCAPTURE_OK = 0;
/*      */   public static final int FLYCAPTURE_FAILED = 1;
/*      */   public static final int FLYCAPTURE_INVALID_ARGUMENT = 2;
/*      */   public static final int FLYCAPTURE_INVALID_CONTEXT = 3;
/*      */   public static final int FLYCAPTURE_NOT_IMPLEMENTED = 4;
/*      */   public static final int FLYCAPTURE_ALREADY_INITIALIZED = 5;
/*      */   public static final int FLYCAPTURE_ALREADY_STARTED = 6;
/*      */   public static final int FLYCAPTURE_CALLBACK_NOT_REGISTERED = 7;
/*      */   public static final int FLYCAPTURE_CALLBACK_ALREADY_REGISTERED = 8;
/*      */   public static final int FLYCAPTURE_CAMERACONTROL_PROBLEM = 9;
/*      */   public static final int FLYCAPTURE_COULD_NOT_OPEN_FILE = 10;
/*      */   public static final int FLYCAPTURE_COULD_NOT_OPEN_DEVICE_HANDLE = 11;
/*      */   public static final int FLYCAPTURE_MEMORY_ALLOC_ERROR = 12;
/*      */   public static final int FLYCAPTURE_NO_IMAGE = 13;
/*      */   public static final int FLYCAPTURE_NOT_INITIALIZED = 14;
/*      */   public static final int FLYCAPTURE_NOT_STARTED = 15;
/*      */   public static final int FLYCAPTURE_MAX_BANDWIDTH_EXCEEDED = 16;
/*      */   public static final int FLYCAPTURE_NON_PGR_CAMERA = 17;
/*      */   public static final int FLYCAPTURE_INVALID_MODE = 18;
/*      */   public static final int FLYCAPTURE_ERROR_UNKNOWN = 19;
/*      */   public static final int FLYCAPTURE_INVALID_CUSTOM_SIZE = 20;
/*      */   public static final int FLYCAPTURE_TIMEOUT = 21;
/*      */   public static final int FLYCAPTURE_TOO_MANY_LOCKED_BUFFERS = 22;
/*      */   public static final int FLYCAPTURE_VERSION_MISMATCH = 23;
/*      */   public static final int FLYCAPTURE_DEVICE_BUSY = 24;
/*      */   public static final int FLYCAPTURE_DEPRECATED = 25;
/*      */   public static final int FLYCAPTURE_BUFFER_SIZE_TOO_SMALL = 26;
/*      */   public static final int FLYCAPTURE_BRIGHTNESS = 0;
/*      */   public static final int FLYCAPTURE_AUTO_EXPOSURE = 1;
/*      */   public static final int FLYCAPTURE_SHARPNESS = 2;
/*      */   public static final int FLYCAPTURE_WHITE_BALANCE = 3;
/*      */   public static final int FLYCAPTURE_HUE = 4;
/*      */   public static final int FLYCAPTURE_SATURATION = 5;
/*      */   public static final int FLYCAPTURE_GAMMA = 6;
/*      */   public static final int FLYCAPTURE_IRIS = 7;
/*      */   public static final int FLYCAPTURE_FOCUS = 8;
/*      */   public static final int FLYCAPTURE_ZOOM = 9;
/*      */   public static final int FLYCAPTURE_PAN = 10;
/*      */   public static final int FLYCAPTURE_TILT = 11;
/*      */   public static final int FLYCAPTURE_SHUTTER = 12;
/*      */   public static final int FLYCAPTURE_GAIN = 13;
/*      */   public static final int FLYCAPTURE_TRIGGER_DELAY = 14;
/*      */   public static final int FLYCAPTURE_FRAME_RATE = 15;
/*      */   public static final int FLYCAPTURE_SOFTWARE_WHITEBALANCE = 16;
/*      */   public static final int FLYCAPTURE_TEMPERATURE = 17;
/*      */   public static final int FLYCAPTURE_MESSAGE_BUS_RESET = 2;
/*      */   public static final int FLYCAPTURE_MESSAGE_DEVICE_ARRIVAL = 3;
/*      */   public static final int FLYCAPTURE_MESSAGE_DEVICE_REMOVAL = 4;
/*      */   public static final int FLYCAPTURE_INFINITE = -1;
/*      */   public static final int FLYCAPTURE_FRAMERATE_1_875 = 0;
/*      */   public static final int FLYCAPTURE_FRAMERATE_3_75 = 1;
/*      */   public static final int FLYCAPTURE_FRAMERATE_7_5 = 2;
/*      */   public static final int FLYCAPTURE_FRAMERATE_15 = 3;
/*      */   public static final int FLYCAPTURE_FRAMERATE_30 = 4;
/*      */   public static final int FLYCAPTURE_FRAMERATE_UNUSED = 5;
/*      */   public static final int FLYCAPTURE_FRAMERATE_60 = 6;
/*      */   public static final int FLYCAPTURE_FRAMERATE_120 = 7;
/*      */   public static final int FLYCAPTURE_FRAMERATE_240 = 8;
/*      */   public static final int FLYCAPTURE_NUM_FRAMERATES = 9;
/*      */   public static final int FLYCAPTURE_FRAMERATE_CUSTOM = 10;
/*      */   public static final int FLYCAPTURE_FRAMERATE_ANY = 11;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_160x120YUV444 = 0;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_320x240YUV422 = 1;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_640x480YUV411 = 2;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_640x480YUV422 = 3;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_640x480RGB = 4;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_640x480Y8 = 5;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_640x480Y16 = 6;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_800x600YUV422 = 17;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_800x600RGB = 18;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_800x600Y8 = 7;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_800x600Y16 = 19;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1024x768YUV422 = 20;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1024x768RGB = 21;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1024x768Y8 = 8;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1024x768Y16 = 9;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1280x960YUV422 = 22;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1280x960RGB = 23;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1280x960Y8 = 10;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1280x960Y16 = 24;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1600x1200YUV422 = 50;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1600x1200RGB = 51;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1600x1200Y8 = 11;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_1600x1200Y16 = 52;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_CUSTOM = 15;
/*      */   public static final int FLYCAPTURE_VIDEOMODE_ANY = 16;
/*      */   public static final int FLYCAPTURE_NUM_VIDEOMODES = 23;
/*      */   public static final int FLYCAPTURE_FIREFLY = 0;
/*      */   public static final int FLYCAPTURE_DRAGONFLY = 1;
/*      */   public static final int FLYCAPTURE_AIM = 2;
/*      */   public static final int FLYCAPTURE_SCORPION = 3;
/*      */   public static final int FLYCAPTURE_TYPHOON = 4;
/*      */   public static final int FLYCAPTURE_FLEA = 5;
/*      */   public static final int FLYCAPTURE_DRAGONFLY_EXPRESS = 6;
/*      */   public static final int FLYCAPTURE_FLEA2 = 7;
/*      */   public static final int FLYCAPTURE_FIREFLY_MV = 8;
/*      */   public static final int FLYCAPTURE_DRAGONFLY2 = 9;
/*      */   public static final int FLYCAPTURE_BUMBLEBEE = 10;
/*      */   public static final int FLYCAPTURE_BUMBLEBEE2 = 11;
/*      */   public static final int FLYCAPTURE_BUMBLEBEEXB3 = 12;
/*      */   public static final int FLYCAPTURE_GRASSHOPPER = 13;
/*      */   public static final int FLYCAPTURE_CHAMELEON = 14;
/*      */   public static final int FLYCAPTURE_UNKNOWN = -1;
/*      */   public static final int FLYCAPTURE_BLACK_AND_WHITE = 0;
/*      */   public static final int FLYCAPTURE_COLOR = 1;
/*      */   public static final int FLYCAPTURE_S100 = 0;
/*      */   public static final int FLYCAPTURE_S200 = 1;
/*      */   public static final int FLYCAPTURE_S400 = 2;
/*      */   public static final int FLYCAPTURE_S480 = 3;
/*      */   public static final int FLYCAPTURE_S800 = 4;
/*      */   public static final int FLYCAPTURE_S1600 = 5;
/*      */   public static final int FLYCAPTURE_S3200 = 6;
/*      */   public static final int FLYCAPTURE_S_FASTEST = 7;
/*      */   public static final int FLYCAPTURE_ANY = 8;
/*      */   public static final int FLYCAPTURE_SPEED_UNKNOWN = -1;
/*      */   public static final int FLYCAPTURE_DISABLE = 0;
/*      */   public static final int FLYCAPTURE_EDGE_SENSING = 1;
/*      */   public static final int FLYCAPTURE_NEAREST_NEIGHBOR = 2;
/*      */   public static final int FLYCAPTURE_NEAREST_NEIGHBOR_FAST = 3;
/*      */   public static final int FLYCAPTURE_RIGOROUS = 4;
/*      */   public static final int FLYCAPTURE_HQLINEAR = 5;
/*      */   public static final int FLYCAPTURE_STIPPLEDFORMAT_BGGR = 0;
/*      */   public static final int FLYCAPTURE_STIPPLEDFORMAT_GBRG = 1;
/*      */   public static final int FLYCAPTURE_STIPPLEDFORMAT_GRBG = 2;
/*      */   public static final int FLYCAPTURE_STIPPLEDFORMAT_RGGB = 3;
/*      */   public static final int FLYCAPTURE_STIPPLEDFORMAT_DEFAULT = 4;
/*      */   public static final int FLYCAPTURE_MONO8 = 1;
/*      */   public static final int FLYCAPTURE_411YUV8 = 2;
/*      */   public static final int FLYCAPTURE_422YUV8 = 4;
/*      */   public static final int FLYCAPTURE_444YUV8 = 8;
/*      */   public static final int FLYCAPTURE_RGB8 = 16;
/*      */   public static final int FLYCAPTURE_MONO16 = 32;
/*      */   public static final int FLYCAPTURE_RGB16 = 64;
/*      */   public static final int FLYCAPTURE_S_MONO16 = 128;
/*      */   public static final int FLYCAPTURE_S_RGB16 = 256;
/*      */   public static final int FLYCAPTURE_RAW8 = 512;
/*      */   public static final int FLYCAPTURE_RAW16 = 1024;
/*      */   public static final int FLYCAPTURE_BGR = 268435457;
/*      */   public static final int FLYCAPTURE_BGRU = 268435458;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_PGM = 0;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_PPM = 1;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_BMP = 2;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_JPG = 3;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_PNG = 4;
/*      */   public static final int FLYCAPTURE_FILEFORMAT_RAW = 5;
/*      */   public static final int FLYCAPTURE_IMAGE_FILTER_NONE = 0;
/*      */   public static final int FLYCAPTURE_IMAGE_FILTER_SCORPION_CROSSTALK = 1;
/*      */   public static final int FLYCAPTURE_IMAGE_FILTER_ALL = -1;
/*      */   public static final int FLYCAPTURE_BUS_MESSAGE = 999999999;
/*      */   public static final int FLYCAPTURE_BUS_RESET = 0;
/*      */   public static final int FLYCAPTURE_DEVICE_ARRIVAL = 1;
/*      */   public static final int FLYCAPTURE_DEVICE_REMOVAL = 2;
/*      */   public static final int FLYCAPTURE_BUS_ERROR = 3;
/*      */   public static final int FLYCAPTURE_GRABBED_IMAGE = 4;
/*      */   public static final int FLYCAPTURE_REGISTER_READ = 5;
/*      */   public static final int FLYCAPTURE_REGISTER_READ_BLOCK = 6;
/*      */   public static final int FLYCAPTURE_REGISTER_WRITE = 7;
/*      */   public static final int FLYCAPTURE_REGISTER_WRITE_BLOCK = 8;
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureBusCameraCount(@Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureBusEnumerateCamerasEx(FlyCaptureInfoEx paramFlyCaptureInfoEx, @Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureModifyCallback(FlyCaptureContext paramFlyCaptureContext, FlyCaptureCallback paramFlyCaptureCallback, Pointer paramPointer, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureCreateContext(@Cast({"FlyCaptureContext*"}) @ByPtrPtr FlyCaptureContext paramFlyCaptureContext);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureDestroyContext(FlyCaptureContext paramFlyCaptureContext);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInitialize(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInitializeFromSerialNumber(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureCameraSerialNumber"}) long paramLong);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraInfo(FlyCaptureContext paramFlyCaptureContext, FlyCaptureInfoEx paramFlyCaptureInfoEx);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetBusSpeed(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureBusSpeed*"}) int[] paramArrayOfInt1, @Cast({"FlyCaptureBusSpeed*"}) int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetBusSpeed(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureBusSpeed"}) int paramInt1, @Cast({"FlyCaptureBusSpeed"}) int paramInt2);
/*      */ 
/*      */   public static native int flycaptureGetLibraryVersion();
/*      */ 
/*      */   public static native String flycaptureErrorToString(@Cast({"FlyCaptureError"}) int paramInt);
/*      */ 
/*      */   public static native String flycaptureRegisterToString(@Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureCheckVideoMode(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureVideoMode"}) int paramInt1, @Cast({"FlyCaptureFrameRate"}) int paramInt2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCurrentVideoMode(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureVideoMode*"}) int[] paramArrayOfInt1, @Cast({"FlyCaptureFrameRate*"}) int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCurrentCustomImage(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3, @Cast({"unsigned int*"}) int[] paramArrayOfInt4, @Cast({"unsigned int*"}) int[] paramArrayOfInt5, @Cast({"unsigned int*"}) int[] paramArrayOfInt6, float[] paramArrayOfFloat, @Cast({"FlyCapturePixelFormat*"}) int[] paramArrayOfInt7);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetColorProcessingMethod(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureColorMethod*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetColorProcessingMethod(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureColorMethod"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetColorTileFormat(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureStippledFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetColorTileFormat(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureStippledFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStart(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureVideoMode"}) int paramInt1, @Cast({"FlyCaptureFrameRate"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureQueryCustomImage(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3, @Cast({"unsigned int*"}) int[] paramArrayOfInt4, @Cast({"unsigned int*"}) int[] paramArrayOfInt5);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureQueryCustomImageEx(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3, @Cast({"unsigned int*"}) int[] paramArrayOfInt4, @Cast({"unsigned int*"}) int[] paramArrayOfInt5, @Cast({"unsigned int*"}) int[] paramArrayOfInt6, @Cast({"unsigned int*"}) int[] paramArrayOfInt7);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStartCustomImage(FlyCaptureContext paramFlyCaptureContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, @Cast({"FlyCapturePixelFormat"}) int paramInt6);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStop(FlyCaptureContext paramFlyCaptureContext);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetGrabTimeoutEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   public static int flycaptureGrabImage(FlyCaptureContext context, BytePointer[] ppImageBuffer, int[] piRows, int[] piCols, int[] piRowInc, int[] pVideoMode)
/*      */   {
/* 1422 */     return flycaptureGrabImage(context, new PointerPointer(ppImageBuffer), piRows, piCols, piRowInc, pVideoMode);
/*      */   }
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGrabImage(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned char**"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, @Cast({"FlyCaptureVideoMode*"}) int[] paramArrayOfInt4);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGrabImage2(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImage paramFlyCaptureImage);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSaveImage(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImage paramFlyCaptureImage, String paramString, @Cast({"FlyCaptureImageFileFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetJPEGCompressionQuality(FlyCaptureContext paramFlyCaptureContext, int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureConvertImage(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImage paramFlyCaptureImage1, FlyCaptureImage paramFlyCaptureImage2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInplaceRGB24toBGR24(@Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInplaceWhiteBalance(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraPropertyRange(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"long*"}) int[] paramArrayOfInt1, @Cast({"long*"}) int[] paramArrayOfInt2, @Cast({"long*"}) int[] paramArrayOfInt3, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraProperty(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"long*"}) int[] paramArrayOfInt1, @Cast({"long*"}) int[] paramArrayOfInt2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraProperty(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt1, @Cast({"long"}) int paramInt2, @Cast({"long"}) int paramInt3, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraPropertyBroadcast(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt1, @Cast({"long"}) int paramInt2, @Cast({"long"}) int paramInt3, boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraPropertyRangeEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3, @Cast({"bool*"}) boolean[] paramArrayOfBoolean4, @Cast({"bool*"}) boolean[] paramArrayOfBoolean5, @Cast({"bool*"}) boolean[] paramArrayOfBoolean6, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraPropertyEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraPropertyEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt1, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, @Cast({"bool"}) boolean paramBoolean3, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraPropertyBroadcastEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt1, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, @Cast({"bool"}) boolean paramBoolean3, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraAbsPropertyRange(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraAbsProperty(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, float[] paramArrayOfFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraAbsPropertyEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3, float[] paramArrayOfFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraAbsProperty(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, float paramFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraAbsPropertyEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, @Cast({"bool"}) boolean paramBoolean3, float paramFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraAbsPropertyBroadcastEx(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, @Cast({"bool"}) boolean paramBoolean3, float paramFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraAbsPropertyBroadcast(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureProperty"}) int paramInt, float paramFloat);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraRegister(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt, @Cast({"unsigned long*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraRegister(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraRegisterBroadcast(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetMemoryChannel(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSaveToMemoryChannel(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureRestoreFromMemoryChannel(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCameraTrigger(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3, @Cast({"unsigned int*"}) int[] paramArrayOfInt4);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraTrigger(FlyCaptureContext paramFlyCaptureContext, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetCameraTriggerBroadcast(FlyCaptureContext paramFlyCaptureContext, byte paramByte1, byte paramByte2, byte paramByte3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureQueryTrigger(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3, @Cast({"bool*"}) boolean[] paramArrayOfBoolean4, @Cast({"bool*"}) boolean[] paramArrayOfBoolean5, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean6, @Cast({"unsigned int*"}) int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetTrigger(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool*"}) boolean[] paramArrayOfBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetTrigger(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool"}) boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetTriggerBroadcast(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool"}) boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetStrobe(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetStrobe(FlyCaptureContext paramFlyCaptureContext, int paramInt1, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetStrobeBroadcast(FlyCaptureContext paramFlyCaptureContext, int paramInt1, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureQueryStrobe(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"bool*"}) boolean[] paramArrayOfBoolean3, @Cast({"bool*"}) boolean[] paramArrayOfBoolean4, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureQueryLookUpTable(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool*"}) boolean[] paramArrayOfBoolean1, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"bool*"}) boolean[] paramArrayOfBoolean2, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureEnableLookUpTable(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetLookUpTableChannel(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetLookUpTableChannel(FlyCaptureContext paramFlyCaptureContext, int paramInt, @Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInitializePlus(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2, @Cast({"unsigned char**"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStartCustomImagePacket(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2, @Cast({"unsigned long"}) int paramInt3, @Cast({"unsigned long"}) int paramInt4, @Cast({"unsigned long"}) int paramInt5, @Cast({"unsigned long"}) int paramInt6, @Cast({"FlyCapturePixelFormat"}) int paramInt7);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStartLockNext(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureVideoMode"}) int paramInt1, @Cast({"FlyCaptureFrameRate"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStartLockNextCustomImage(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2, @Cast({"unsigned long"}) int paramInt3, @Cast({"unsigned long"}) int paramInt4, @Cast({"unsigned long"}) int paramInt5, float paramFloat, @Cast({"FlyCapturePixelFormat"}) int paramInt6);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureStartLockNextCustomImagePacket(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) long paramLong1, @Cast({"unsigned long"}) long paramLong2, @Cast({"unsigned long"}) long paramLong3, @Cast({"unsigned long"}) long paramLong4, @Cast({"unsigned long"}) long paramLong5, @Cast({"unsigned long"}) long paramLong6, @Cast({"FlyCapturePixelFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSyncForLockNext(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureLockNext(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImagePlus paramFlyCaptureImagePlus);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureLockLatest(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImagePlus paramFlyCaptureImagePlus);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureUnlock(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureUnlockAll(FlyCaptureContext paramFlyCaptureContext);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetImageFilters(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned int*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetImageFilters(FlyCaptureContext paramFlyCaptureContext, int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetImageTimestamping(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetImageTimestamping(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureParseImageTimestamp(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned char*"}) BytePointer paramBytePointer, @Cast({"unsigned int*"}) int[] paramArrayOfInt1, @Cast({"unsigned int*"}) int[] paramArrayOfInt2, @Cast({"unsigned int*"}) int[] paramArrayOfInt3);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureWaitForImageEvent(FlyCaptureContext paramFlyCaptureContext, FlyCaptureImageEvent paramFlyCaptureImageEvent, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetPacketInfo(FlyCaptureContext paramFlyCaptureContext, @Cast({"FlyCaptureVideoMode"}) int paramInt1, @Cast({"FlyCaptureFrameRate"}) int paramInt2, FlyCapturePacketInfo paramFlyCapturePacketInfo);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetCustomImagePacketInfo(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long"}) int paramInt2, @Cast({"unsigned long"}) int paramInt3, @Cast({"FlyCapturePixelFormat"}) int paramInt4, FlyCapturePacketInfo paramFlyCapturePacketInfo);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureReadRegisterBlock(FlyCaptureContext paramFlyCaptureContext, short paramShort, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long*"}) int[] paramArrayOfInt, @Cast({"unsigned long"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureWriteRegisterBlock(FlyCaptureContext paramFlyCaptureContext, short paramShort, @Cast({"unsigned long"}) int paramInt1, @Cast({"unsigned long*"}) int[] paramArrayOfInt, @Cast({"unsigned long"}) int paramInt2);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureSetMessageLoggingStatus(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool"}) boolean paramBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureGetMessageLoggingStatus(FlyCaptureContext paramFlyCaptureContext, @Cast({"bool*"}) boolean[] paramArrayOfBoolean);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureInitializeMessaging(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureCloseMessaging(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   @Cast({"FlyCaptureError"})
/*      */   public static native int flycaptureReceiveMessage(FlyCaptureContext paramFlyCaptureContext, @Cast({"unsigned long"}) int paramInt, FlyCaptureMessage paramFlyCaptureMessage, @Cast({"OVERLAPPED*"}) Pointer paramPointer);
/*      */ 
/*      */   public static native String flycaptureBusErrorToString(@Cast({"unsigned long"}) int paramInt);
/*      */ 
/*      */   static
/*      */   {
/*   86 */     Loader.load();
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureMessage extends Pointer
/*      */   {
/*      */     public FlyCaptureMessage()
/*      */     {
/* 3431 */       allocate(); } 
/* 3432 */     public FlyCaptureMessage(int size) { allocateArray(size); } 
/* 3433 */     public FlyCaptureMessage(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3438 */     public FlyCaptureMessage position(int position) { return (FlyCaptureMessage)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"FlyCaptureMessageType"})
/*      */     public native int msgType();
/*      */ 
/*      */     public native FlyCaptureMessage msgType(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Reset.iBusNumber"})
/*      */     public native int Msg_Reset_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Reset_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Reset.stTimeStamp"})
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureSystemTime Msg_Reset_stTimeStamp();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Reset_stTimeStamp(PGRFlyCapture.FlyCaptureSystemTime paramFlyCaptureSystemTime);
/*      */ 
/*      */     @Name({"Msg.Arrival.szDevice"})
/*      */     public native String Msg_Arrival_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Arrival_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.Arrival.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Arrival_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Arrival_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Arrival.iBusNumber"})
/*      */     public native int Msg_Arrival_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Arrival_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Arrival.iNodeNumber"})
/*      */     public native int Msg_Arrival_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Arrival_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Arrival.stTimeStamp"})
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureSystemTime Msg_Arrival_stTimeStamp();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Arrival_stTimeStamp(PGRFlyCapture.FlyCaptureSystemTime paramFlyCaptureSystemTime);
/*      */ 
/*      */     @Name({"Msg.Removal.szDevice"})
/*      */     public native String Msg_Removal_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Removal_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.Removal.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Removal_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Removal_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Removal.iBusNumber"})
/*      */     public native int Msg_Removal_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Removal_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Removal.iNodeNumber"})
/*      */     public native int Msg_Removal_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Removal_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Removal.stTimeStamp"})
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureSystemTime Msg_Removal_stTimeStamp();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Removal_stTimeStamp(PGRFlyCapture.FlyCaptureSystemTime paramFlyCaptureSystemTime);
/*      */ 
/*      */     @Name({"Msg.BusError.szDevice"})
/*      */     public native String Msg_BusError_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.BusError.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_BusError_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.BusError.iBusNumber"})
/*      */     public native int Msg_BusError_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.BusError.iNodeNumber"})
/*      */     public native int Msg_BusError_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.BusError.stTimeStamp"})
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureSystemTime Msg_BusError_stTimeStamp();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_stTimeStamp(PGRFlyCapture.FlyCaptureSystemTime paramFlyCaptureSystemTime);
/*      */ 
/*      */     @Name({"Msg.BusError.ulErrorCode"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_BusError_ulErrorCode();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_BusError_ulErrorCode(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.szDevice"})
/*      */     public native String Msg_Image_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.Image.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Image_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.iBusNumber"})
/*      */     public native int Msg_Image_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.iNodeNumber"})
/*      */     public native int Msg_Image_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.ulSequence"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Image_ulSequence();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_ulSequence(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.ulBytes"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Image_ulBytes();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_ulBytes(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Image.stTimeStamp"})
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureSystemTime Msg_Image_stTimeStamp();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Image_stTimeStamp(PGRFlyCapture.FlyCaptureSystemTime paramFlyCaptureSystemTime);
/*      */ 
/*      */     @Name({"Msg.Register.szDevice"})
/*      */     public native String Msg_Register_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.Register.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Register_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Register.iBusNumber"})
/*      */     public native int Msg_Register_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Register.iNodeNumber"})
/*      */     public native int Msg_Register_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Register.ulRegister"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Register_ulRegister();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_ulRegister(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Register.ulValue"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_Register_ulValue();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_ulValue(int paramInt);
/*      */ 
/*      */     @Name({"Msg.Register.szError"})
/*      */     public native String Msg_Register_szError();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_Register_szError(String paramString);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.szDevice"})
/*      */     public native String Msg_RegisterBlock_szDevice();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_szDevice(String paramString);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.ulSerialNumber"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_RegisterBlock_ulSerialNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_ulSerialNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.iBusNumber"})
/*      */     public native int Msg_RegisterBlock_iBusNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_iBusNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.iNodeNumber"})
/*      */     public native int Msg_RegisterBlock_iNodeNumber();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_iNodeNumber(int paramInt);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.ulRegister"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_RegisterBlock_ulRegister();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_ulRegister(int paramInt);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.ulNumberOfQuadlets"})
/*      */     @Cast({"unsigned long"})
/*      */     public native int Msg_RegisterBlock_ulNumberOfQuadlets();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_ulNumberOfQuadlets(int paramInt);
/*      */ 
/*      */     @Name({"Msg.RegisterBlock.szError"})
/*      */     public native String Msg_RegisterBlock_szError();
/*      */ 
/*      */     public native FlyCaptureMessage Msg_RegisterBlock_szError(String paramString);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCaptureMessage ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 3430 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureSystemTime extends Pointer
/*      */   {
/*      */     public FlyCaptureSystemTime()
/*      */     {
/* 3383 */       allocate(); } 
/* 3384 */     public FlyCaptureSystemTime(int size) { allocateArray(size); } 
/* 3385 */     public FlyCaptureSystemTime(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3390 */     public FlyCaptureSystemTime position(int position) { return (FlyCaptureSystemTime)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native short usHour();
/*      */ 
/*      */     public native FlyCaptureSystemTime usHour(short paramShort);
/*      */ 
/*      */     public native short usMinute();
/*      */ 
/*      */     public native FlyCaptureSystemTime usMinute(short paramShort);
/*      */ 
/*      */     public native short usSecond();
/*      */ 
/*      */     public native FlyCaptureSystemTime usSecond(short paramShort);
/*      */ 
/*      */     public native short usMilliseconds();
/*      */ 
/*      */     public native FlyCaptureSystemTime usMilliseconds(short paramShort);
/*      */ 
/*      */     static
/*      */     {
/* 3382 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCapturePacketInfo extends Pointer
/*      */   {
/*      */     public FlyCapturePacketInfo()
/*      */     {
/* 2602 */       allocate(); } 
/* 2603 */     public FlyCapturePacketInfo(int size) { allocateArray(size); } 
/* 2604 */     public FlyCapturePacketInfo(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2609 */     public FlyCapturePacketInfo position(int position) { return (FlyCapturePacketInfo)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int uiMinSizeBytes();
/*      */ 
/*      */     public native FlyCapturePacketInfo uiMinSizeBytes(int paramInt);
/*      */ 
/*      */     public native int uiMaxSizeBytes();
/*      */ 
/*      */     public native FlyCapturePacketInfo uiMaxSizeBytes(int paramInt);
/*      */ 
/*      */     public native int uiMaxSizeEventBytes();
/*      */ 
/*      */     public native FlyCapturePacketInfo uiMaxSizeEventBytes(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCapturePacketInfo ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 2601 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureImageEvent extends Pointer
/*      */   {
/*      */     public FlyCaptureImageEvent()
/*      */     {
/* 2540 */       allocate(); } 
/* 2541 */     public FlyCaptureImageEvent(int size) { allocateArray(size); } 
/* 2542 */     public FlyCaptureImageEvent(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2547 */     public FlyCaptureImageEvent position(int position) { return (FlyCaptureImageEvent)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer pBuffer();
/*      */ 
/*      */     public native FlyCaptureImageEvent pBuffer(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int uiSizeBytes();
/*      */ 
/*      */     public native FlyCaptureImageEvent uiSizeBytes(int paramInt);
/*      */ 
/*      */     public native int uiSeqNum();
/*      */ 
/*      */     public native FlyCaptureImageEvent uiSeqNum(int paramInt);
/*      */ 
/*      */     public native int uiBufferIndex();
/*      */ 
/*      */     public native FlyCaptureImageEvent uiBufferIndex(int paramInt);
/*      */ 
/*      */     public native Pointer pInternal();
/*      */ 
/*      */     public native FlyCaptureImageEvent pInternal(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCaptureImageEvent ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 2539 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureImagePlus extends Pointer
/*      */   {
/*      */     public FlyCaptureImagePlus()
/*      */     {
/* 2479 */       allocate(); } 
/* 2480 */     public FlyCaptureImagePlus(int size) { allocateArray(size); } 
/* 2481 */     public FlyCaptureImagePlus(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2486 */     public FlyCaptureImagePlus position(int position) { return (FlyCaptureImagePlus)super.position(position); }
/*      */ 
/*      */ 
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureImage image();
/*      */ 
/*      */     public native FlyCaptureImagePlus image(PGRFlyCapture.FlyCaptureImage paramFlyCaptureImage);
/*      */ 
/*      */     public native int uiSeqNum();
/*      */ 
/*      */     public native FlyCaptureImagePlus uiSeqNum(int paramInt);
/*      */ 
/*      */     public native int uiBufferIndex();
/*      */ 
/*      */     public native FlyCaptureImagePlus uiBufferIndex(int paramInt);
/*      */ 
/*      */     public native int uiBufSeqNum();
/*      */ 
/*      */     public native FlyCaptureImagePlus uiBufSeqNum(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCaptureImagePlus ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 2478 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureImage extends Pointer
/*      */   {
/*      */     public FlyCaptureImage()
/*      */     {
/*  665 */       allocate(); } 
/*  666 */     public FlyCaptureImage(int size) { allocateArray(size); } 
/*  667 */     public FlyCaptureImage(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  672 */     public FlyCaptureImage position(int position) { return (FlyCaptureImage)super.position(position); } 
/*      */     public native int iRows();
/*      */ 
/*      */     public native FlyCaptureImage iRows(int paramInt);
/*      */ 
/*      */     public native int iCols();
/*      */ 
/*      */     public native FlyCaptureImage iCols(int paramInt);
/*      */ 
/*      */     public native int iRowInc();
/*      */ 
/*      */     public native FlyCaptureImage iRowInc(int paramInt);
/*      */ 
/*      */     @Cast({"FlyCaptureVideoMode"})
/*      */     public native int videoMode();
/*      */ 
/*      */     public native FlyCaptureImage videoMode(int paramInt);
/*      */ 
/*      */     @ByRef
/*      */     public native PGRFlyCapture.FlyCaptureTimestamp timeStamp();
/*      */ 
/*      */     public native FlyCaptureImage timeStamp(PGRFlyCapture.FlyCaptureTimestamp paramFlyCaptureTimestamp);
/*      */ 
/*      */     @Cast({"unsigned char*"})
/*      */     public native BytePointer pData();
/*      */ 
/*      */     public native FlyCaptureImage pData(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"bool"})
/*      */     public native boolean bStippled();
/*      */ 
/*      */     public native FlyCaptureImage bStippled(boolean paramBoolean);
/*      */ 
/*      */     @Cast({"FlyCapturePixelFormat"})
/*      */     public native int pixelFormat();
/*      */ 
/*      */     public native FlyCaptureImage pixelFormat(int paramInt);
/*      */ 
/*      */     public native int iNumImages();
/*      */ 
/*      */     public native FlyCaptureImage iNumImages(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCaptureImage ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*  713 */     public ByteBuffer getByteBuffer() { return pData().capacity(iRowInc() * iRows()).asByteBuffer(); }
/*      */ 
/*      */ 
/*      */     static
/*      */     {
/*  664 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureTimestamp extends Pointer
/*      */   {
/*      */     public FlyCaptureTimestamp()
/*      */     {
/*  632 */       allocate(); } 
/*  633 */     public FlyCaptureTimestamp(int size) { allocateArray(size); } 
/*  634 */     public FlyCaptureTimestamp(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  639 */     public FlyCaptureTimestamp position(int position) { return (FlyCaptureTimestamp)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulSeconds();
/*      */ 
/*      */     public native FlyCaptureTimestamp ulSeconds(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulMicroSeconds();
/*      */ 
/*      */     public native FlyCaptureTimestamp ulMicroSeconds(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulCycleSeconds();
/*      */ 
/*      */     public native FlyCaptureTimestamp ulCycleSeconds(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulCycleCount();
/*      */ 
/*      */     public native FlyCaptureTimestamp ulCycleCount(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulCycleOffset();
/*      */ 
/*      */     public native FlyCaptureTimestamp ulCycleOffset(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  631 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureInfoEx extends Pointer
/*      */   {
/*      */     public FlyCaptureInfoEx()
/*      */     {
/*  433 */       allocate(); } 
/*  434 */     public FlyCaptureInfoEx(int size) { allocateArray(size); } 
/*  435 */     public FlyCaptureInfoEx(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  440 */     public FlyCaptureInfoEx position(int position) { return (FlyCaptureInfoEx)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"FlyCaptureCameraSerialNumber"})
/*      */     public native int SerialNumber();
/*      */ 
/*      */     public native FlyCaptureInfoEx SerialNumber(int paramInt);
/*      */ 
/*      */     @Cast({"FlyCaptureCameraType"})
/*      */     public native int CameraType();
/*      */ 
/*      */     public native FlyCaptureInfoEx CameraType(int paramInt);
/*      */ 
/*      */     @Cast({"FlyCaptureCameraModel"})
/*      */     public native int CameraModel();
/*      */ 
/*      */     public native FlyCaptureInfoEx CameraModel(int paramInt);
/*      */ 
/*      */     public native String pszModelName();
/*      */ 
/*      */     public native FlyCaptureInfoEx pszModelName(String paramString);
/*      */ 
/*      */     public native String pszVendorName();
/*      */ 
/*      */     public native FlyCaptureInfoEx pszVendorName(String paramString);
/*      */ 
/*      */     public native String pszSensorInfo();
/*      */ 
/*      */     public native FlyCaptureInfoEx pszSensorInfo(String paramString);
/*      */ 
/*      */     public native int iDCAMVer();
/*      */ 
/*      */     public native FlyCaptureInfoEx iDCAMVer(int paramInt);
/*      */ 
/*      */     public native int iNodeNum();
/*      */ 
/*      */     public native FlyCaptureInfoEx iNodeNum(int paramInt);
/*      */ 
/*      */     public native int iBusNum();
/*      */ 
/*      */     public native FlyCaptureInfoEx iBusNum(int paramInt);
/*      */ 
/*      */     @Cast({"FlyCaptureBusSpeed"})
/*      */     public native int CameraMaxBusSpeed();
/*      */ 
/*      */     public native FlyCaptureInfoEx CameraMaxBusSpeed(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned long"})
/*      */     public native int ulReserved(int paramInt);
/*      */ 
/*      */     public native FlyCaptureInfoEx ulReserved(int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  432 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FlyCaptureCallback extends FunctionPointer
/*      */   {
/*      */     public FlyCaptureCallback(Pointer p)
/*      */     {
/*  255 */       super(); } 
/*  256 */     protected FlyCaptureCallback() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer, int paramInt1, @Cast({"unsigned long"}) int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/*  254 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class FlyCaptureContext extends Pointer
/*      */   {
/*      */     public FlyCaptureContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FlyCaptureContext(Pointer p)
/*      */     {
/*  106 */       super();
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  104 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.PGRFlyCapture
 * JD-Core Version:    0.6.2
 */