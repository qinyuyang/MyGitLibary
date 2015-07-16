/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByPtrRef;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Const;
/*     */ import com.googlecode.javacpp.annotation.MemberGetter;
/*     */ import com.googlecode.javacpp.annotation.Namespace;
/*     */ import com.googlecode.javacpp.annotation.NoOffset;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacpp.annotation.StdString;
/*     */ import com.googlecode.javacpp.annotation.StdVector;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ @Properties({@com.googlecode.javacpp.annotation.Platform(include={"ARToolKitPlus_plus.h"}, link={"ARToolKitPlus"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86"}, includepath={"C:/Program Files (x86)/ARToolKitPlus/include/"}, linkpath={"C:/Program Files (x86)/ARToolKitPlus/lib/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86_64"}, includepath={"C:/Program Files/ARToolKitPlus/include/"}, linkpath={"C:/Program Files/ARToolKitPlus/lib/"})})
/*     */ @Namespace("ARToolKitPlus")
/*     */ public class ARToolKitPlus
/*     */ {
/*     */   public static final int ARTOOLKITPLUS_VERSION_MAJOR = 2;
/*     */   public static final int ARTOOLKITPLUS_VERSION_MINOR = 2;
/*     */   public static final int PIXEL_FORMAT_ABGR = 1;
/*     */   public static final int PIXEL_FORMAT_BGRA = 2;
/*     */   public static final int PIXEL_FORMAT_BGR = 3;
/*     */   public static final int PIXEL_FORMAT_RGBA = 4;
/*     */   public static final int PIXEL_FORMAT_RGB = 5;
/*     */   public static final int PIXEL_FORMAT_RGB565 = 6;
/*     */   public static final int PIXEL_FORMAT_LUM = 7;
/*     */   public static final int UNDIST_NONE = 0;
/*     */   public static final int UNDIST_STD = 1;
/*     */   public static final int UNDIST_LUT = 2;
/*     */   public static final int IMAGE_HALF_RES = 0;
/*     */   public static final int IMAGE_FULL_RES = 1;
/*     */   public static final int HULL_OFF = 0;
/*     */   public static final int HULL_FOUR = 1;
/*     */   public static final int HULL_FULL = 2;
/*     */   public static final int VERSION_MAJOR = 2;
/*     */   public static final int VERSION_MINOR = 2;
/*     */   public static final int MARKER_TEMPLATE = 0;
/*     */   public static final int MARKER_ID_SIMPLE = 1;
/*     */   public static final int MARKER_ID_BCH = 2;
/*     */   public static final int POSE_ESTIMATOR_ORIGINAL = 0;
/*     */   public static final int POSE_ESTIMATOR_ORIGINAL_CONT = 1;
/*     */   public static final int POSE_ESTIMATOR_RPP = 2;
/*     */ 
/*     */   public static native void createImagePatternBCH(int paramInt, @Cast({"uint8_t*"}) byte[] paramArrayOfByte);
/*     */ 
/*     */   public static native void createImagePatternBCH(int paramInt, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer);
/*     */ 
/*     */   public static native void createImagePatternSimple(int paramInt, @Cast({"uint8_t*"}) byte[] paramArrayOfByte);
/*     */ 
/*     */   public static native void createImagePatternSimple(int paramInt, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer);
/*     */ 
/*     */   static
/*     */   {
/*  84 */     Loader.load();
/*     */   }
/*     */ 
/*     */   public static class TrackerMultiMarker extends ARToolKitPlus.Tracker
/*     */   {
/*     */     public TrackerMultiMarker(int width, int height, int maxImagePatterns, int pattWidth, int pattHeight, int pattSamples, int maxLoadPatterns)
/*     */     {
/* 401 */       allocate(width, height, maxImagePatterns, pattWidth, pattHeight, pattSamples, maxLoadPatterns);
/*     */     }
/* 403 */     public TrackerMultiMarker(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */ 
/*     */     public native boolean init(String paramString1, String paramString2, float paramFloat1, float paramFloat2);
/*     */ 
/*     */     public native int calc(@Cast({"uint8_t*"}) byte[] paramArrayOfByte);
/*     */ 
/*     */     public native int calc(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer);
/*     */ 
/*     */     public native int calc(@Cast({"uint8_t*"}) BytePointer paramBytePointer);
/*     */ 
/*     */     public native int getNumDetectedMarkers();
/*     */ 
/*     */     public native void setUseDetectLite(boolean paramBoolean);
/*     */ 
/*     */     public native void getDetectedMarkers(@ByPtrRef IntPointer paramIntPointer);
/*     */ 
/*     */     @Const
/*     */     @ByRef
/*     */     public native ARToolKitPlus.ARMarkerInfo getDetectedMarker(int paramInt);
/*     */ 
/*     */     @Const
/*     */     public native ARToolKitPlus.ARMultiMarkerInfoT getMultiMarkerConfig();
/*     */ 
/*     */     public native void getARMatrix(@Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat);
/*     */ 
/*     */     static
/*     */     {
/* 398 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class TrackerSingleMarker extends ARToolKitPlus.Tracker
/*     */   {
/*     */     public TrackerSingleMarker(int width, int height, int maxImagePatterns, int pattWidth, int pattHeight, int pattSamples, int maxLoadPatterns)
/*     */     {
/* 380 */       allocate(width, height, maxImagePatterns, pattWidth, pattHeight, pattSamples, maxLoadPatterns);
/*     */     }
/* 382 */     public TrackerSingleMarker(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */ 
/*     */     public native boolean init(String paramString, float paramFloat1, float paramFloat2);
/*     */ 
/*     */     public native int addPattern(String paramString);
/*     */ 
/*     */     @StdVector
/*     */     public native int[] calc(@Cast({"uint8_t*"}) int[] paramArrayOfInt1, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt2);
/*     */ 
/*     */     public native void selectDetectedMarker(int paramInt);
/*     */ 
/*     */     public native int selectBestMarkerByCf();
/*     */ 
/*     */     public native void setPatternWidth(float paramFloat);
/*     */ 
/*     */     public native void getARMatrix(@Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat);
/*     */ 
/*     */     public native float getConfidence();
/*     */ 
/*     */     static
/*     */     {
/* 377 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class MultiTracker extends ARToolKitPlus.TrackerMultiMarker
/*     */   {
/*     */     public MultiTracker(int width, int height)
/*     */     {
/* 371 */       super(); allocate(width, height); } 
/* 372 */     public MultiTracker(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2);
/*     */ 
/*     */     static
/*     */     {
/* 370 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class SingleTracker extends ARToolKitPlus.TrackerSingleMarker
/*     */   {
/*     */     public SingleTracker(int width, int height)
/*     */     {
/* 364 */       super(); allocate(width, height); } 
/* 365 */     public SingleTracker(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2);
/*     */ 
/*     */     static
/*     */     {
/* 363 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Tracker extends Pointer
/*     */   {
/*     */     public Tracker()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Tracker(Pointer p)
/*     */     {
/* 286 */       super();
/*     */     }
/*     */ 
/*     */     public native boolean setPixelFormat(@Cast({"ARToolKitPlus::PIXEL_FORMAT"}) int paramInt);
/*     */ 
/*     */     public native boolean loadCameraFile(String paramString, float paramFloat1, float paramFloat2);
/*     */ 
/*     */     public native void setLoadUndistLUT(boolean paramBoolean);
/*     */ 
/*     */     public native int arDetectMarker(@Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native int arDetectMarker(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native int arDetectMarker(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native int arDetectMarkerLite(@Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native int arDetectMarkerLite(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native int arDetectMarkerLite(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
/*     */ 
/*     */     public native float arMultiGetTransMat(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int paramInt, ARToolKitPlus.ARMultiMarkerInfoT paramARMultiMarkerInfoT);
/*     */ 
/*     */     public native float arMultiGetTransMatHull(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int paramInt, ARToolKitPlus.ARMultiMarkerInfoT paramARMultiMarkerInfoT);
/*     */ 
/*     */     public native float arGetTransMat(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, float[] paramArrayOfFloat1, float paramFloat, @Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native float arGetTransMatCont(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, @Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat, @Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat3);
/*     */ 
/*     */     public native float rppMultiGetTransMat(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int paramInt, ARToolKitPlus.ARMultiMarkerInfoT paramARMultiMarkerInfoT);
/*     */ 
/*     */     public native float rppGetTransMat(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, float[] paramArrayOfFloat1, float paramFloat, @Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native int arLoadPatt(@Cast({"char*"}) String paramString);
/*     */ 
/*     */     public native int arFreePatt(int paramInt);
/*     */ 
/*     */     public native int arMultiFreeConfig(ARToolKitPlus.ARMultiMarkerInfoT paramARMultiMarkerInfoT);
/*     */ 
/*     */     public native ARToolKitPlus.ARMultiMarkerInfoT arMultiReadConfigFile(String paramString);
/*     */ 
/*     */     public native void activateBinaryMarker(int paramInt);
/*     */ 
/*     */     public native void setMarkerMode(@Cast({"ARToolKitPlus::MARKER_MODE"}) int paramInt);
/*     */ 
/*     */     public native void activateVignettingCompensation(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */     public static native boolean calcCameraMatrix(String paramString, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat);
/*     */ 
/*     */     public native void changeCameraSize(int paramInt1, int paramInt2);
/*     */ 
/*     */     public native void setUndistortionMode(@Cast({"ARToolKitPlus::UNDIST_MODE"}) int paramInt);
/*     */ 
/*     */     public native boolean setPoseEstimator(@Cast({"ARToolKitPlus::POSE_ESTIMATOR"}) int paramInt);
/*     */ 
/*     */     public native void setHullMode(@Cast({"ARToolKitPlus::HULL_TRACKING_MODE"}) int paramInt);
/*     */ 
/*     */     public native void setBorderWidth(float paramFloat);
/*     */ 
/*     */     public native void setThreshold(int paramInt);
/*     */ 
/*     */     public native int getThreshold();
/*     */ 
/*     */     public native void activateAutoThreshold(boolean paramBoolean);
/*     */ 
/*     */     public native boolean isAutoThresholdActivated();
/*     */ 
/*     */     public native void setNumAutoThresholdRetries(int paramInt);
/*     */ 
/*     */     public native void setImageProcessingMode(@Cast({"ARToolKitPlus::IMAGE_PROC_MODE"}) int paramInt);
/*     */ 
/*     */     @Const
/*     */     public native FloatPointer getModelViewMatrix();
/*     */ 
/*     */     @Const
/*     */     public native FloatPointer getProjectionMatrix();
/*     */ 
/*     */     @Cast({"ARToolKitPlus::PIXEL_FORMAT"})
/*     */     public native int getPixelFormat();
/*     */ 
/*     */     public native int getBitsPerPixel();
/*     */ 
/*     */     public native int getNumLoadablePatterns();
/*     */ 
/*     */     public native ARToolKitPlus.Camera getCamera();
/*     */ 
/*     */     public native void setCamera(ARToolKitPlus.Camera paramCamera);
/*     */ 
/*     */     public native void setCamera(ARToolKitPlus.Camera paramCamera, float paramFloat1, float paramFloat2);
/*     */ 
/*     */     public native float calcOpenGLMatrixFromMarker(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, float[] paramArrayOfFloat1, float paramFloat, float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native float executeSingleMarkerPoseEstimator(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, float[] paramArrayOfFloat1, float paramFloat, @Cast({"ARFloat(*)[4]"}) float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native float executeMultiMarkerPoseEstimator(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int paramInt, ARToolKitPlus.ARMultiMarkerInfoT paramARMultiMarkerInfoT);
/*     */ 
/*     */     @Const
/*     */     @StdVector
/*     */     public native ARToolKitPlus.CornerPoint getTrackedCorners();
/*     */ 
/*     */     static
/*     */     {
/* 284 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   public static class Camera extends Pointer
/*     */   {
/*     */     public Camera()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Camera(Pointer p)
/*     */     {
/* 265 */       super();
/*     */     }
/*     */ 
/*     */     public native int xsize();
/*     */ 
/*     */     public native Camera xsize(int paramInt);
/*     */ 
/*     */     public native int ysize();
/*     */ 
/*     */     public native Camera ysize(int paramInt);
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[4]"})
/*     */     public native FloatPointer mat();
/*     */ 
/*     */     @MemberGetter
/*     */     public native FloatPointer kc();
/*     */ 
/*     */     public native void observ2Ideal(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native void ideal2Observ(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
/*     */ 
/*     */     public native boolean loadFromFile(@StdString String paramString);
/*     */ 
/*     */     public native Camera clone();
/*     */ 
/*     */     public native boolean changeFrameSize(int paramInt1, int paramInt2);
/*     */ 
/*     */     public native void printSettings();
/*     */ 
/*     */     @StdString
/*     */     public native String getFileName();
/*     */ 
/*     */     static
/*     */     {
/* 263 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class ARMultiMarkerInfoT extends Pointer
/*     */   {
/*     */     public ARMultiMarkerInfoT()
/*     */     {
/* 243 */       allocate(); } 
/* 244 */     public ARMultiMarkerInfoT(int size) { allocateArray(size); } 
/* 245 */     public ARMultiMarkerInfoT(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 250 */     public ARMultiMarkerInfoT position(int position) { return (ARMultiMarkerInfoT)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native ARToolKitPlus.ARMultiEachMarkerInfoT marker();
/*     */ 
/*     */     public native ARMultiMarkerInfoT marker(ARToolKitPlus.ARMultiEachMarkerInfoT paramARMultiEachMarkerInfoT);
/*     */ 
/*     */     public native int marker_num();
/*     */ 
/*     */     public native ARMultiMarkerInfoT marker_num(int paramInt);
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[4]"})
/*     */     public native FloatPointer trans();
/*     */ 
/*     */     public native int prevF();
/*     */ 
/*     */     public native ARMultiMarkerInfoT prevF(int paramInt);
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[4]"})
/*     */     public native FloatPointer transR();
/*     */ 
/*     */     static
/*     */     {
/* 242 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class ARMultiEachMarkerInfoT extends Pointer
/*     */   {
/*     */     public ARMultiEachMarkerInfoT()
/*     */     {
/* 216 */       allocate(); } 
/* 217 */     public ARMultiEachMarkerInfoT(int size) { allocateArray(size); } 
/* 218 */     public ARMultiEachMarkerInfoT(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 223 */     public ARMultiEachMarkerInfoT position(int position) { return (ARMultiEachMarkerInfoT)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int patt_id();
/*     */ 
/*     */     public native ARMultiEachMarkerInfoT patt_id(int paramInt);
/*     */ 
/*     */     public native float width();
/*     */ 
/*     */     public native ARMultiEachMarkerInfoT width(float paramFloat);
/*     */ 
/*     */     @MemberGetter
/*     */     public native FloatPointer center();
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[4]"})
/*     */     public native FloatPointer trans();
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[4]"})
/*     */     public native FloatPointer itrans();
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[3]"})
/*     */     public native FloatPointer pos3d();
/*     */ 
/*     */     public native int visible();
/*     */ 
/*     */     public native ARMultiEachMarkerInfoT visible(int paramInt);
/*     */ 
/*     */     public native int visibleR();
/*     */ 
/*     */     public native ARMultiEachMarkerInfoT visibleR(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 215 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class arPrevInfo extends Pointer
/*     */   {
/*     */     public arPrevInfo()
/*     */     {
/* 199 */       allocate(); } 
/* 200 */     public arPrevInfo(int size) { allocateArray(size); } 
/* 201 */     public arPrevInfo(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 206 */     public ARToolKitPlus.ARMarkerInfo position(int position) { return (ARToolKitPlus.ARMarkerInfo)super.position(position); }
/*     */ 
/*     */ 
/*     */     @ByRef
/*     */     public native ARToolKitPlus.ARMarkerInfo marker();
/*     */ 
/*     */     public native arPrevInfo marker(ARToolKitPlus.ARMarkerInfo paramARMarkerInfo);
/*     */ 
/*     */     public native int count();
/*     */ 
/*     */     public native arPrevInfo count(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 198 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class ARMarkerInfo2 extends Pointer
/*     */   {
/*     */     public ARMarkerInfo2()
/*     */     {
/* 179 */       allocate(); } 
/* 180 */     public ARMarkerInfo2(int size) { allocateArray(size); } 
/* 181 */     public ARMarkerInfo2(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 186 */     public ARToolKitPlus.ARMarkerInfo position(int position) { return (ARToolKitPlus.ARMarkerInfo)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int area();
/*     */ 
/*     */     public native ARMarkerInfo2 area(int paramInt);
/*     */ 
/*     */     @MemberGetter
/*     */     public native FloatPointer pos();
/*     */ 
/*     */     public native int coord_num();
/*     */ 
/*     */     public native ARMarkerInfo2 coord_num(int paramInt);
/*     */ 
/*     */     @MemberGetter
/*     */     public native IntPointer x_coord();
/*     */ 
/*     */     @MemberGetter
/*     */     public native IntPointer y_coord();
/*     */ 
/*     */     @MemberGetter
/*     */     public native IntPointer vertex();
/*     */ 
/*     */     static
/*     */     {
/* 178 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class ARMarkerInfo extends Pointer
/*     */   {
/*     */     public ARMarkerInfo()
/*     */     {
/* 155 */       allocate(); } 
/* 156 */     public ARMarkerInfo(int size) { allocateArray(size); } 
/* 157 */     public ARMarkerInfo(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/* 162 */     public ARMarkerInfo position(int position) { return (ARMarkerInfo)super.position(position); }
/*     */ 
/*     */ 
/*     */     public native int area();
/*     */ 
/*     */     public native ARMarkerInfo area(int paramInt);
/*     */ 
/*     */     public native int id();
/*     */ 
/*     */     public native ARMarkerInfo id(int paramInt);
/*     */ 
/*     */     public native int dir();
/*     */ 
/*     */     public native ARMarkerInfo dir(int paramInt);
/*     */ 
/*     */     public native float cf();
/*     */ 
/*     */     public native ARMarkerInfo cf(float paramFloat);
/*     */ 
/*     */     @MemberGetter
/*     */     public native FloatPointer pos();
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[3]"})
/*     */     public native FloatPointer line();
/*     */ 
/*     */     @MemberGetter
/*     */     @Cast({"ARFloat(*)[2]"})
/*     */     public native FloatPointer vertex();
/*     */ 
/*     */     static
/*     */     {
/* 154 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @NoOffset
/*     */   public static class CornerPoint extends Pointer
/*     */   {
/*     */     public CornerPoint()
/*     */     {
/* 141 */       allocate(); } 
/* 142 */     public CornerPoint(int nX, int nY) { allocate(nX, nY); } 
/* 143 */     public CornerPoint(int size) { allocateArray(size); } 
/* 144 */     public CornerPoint(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocate(int paramInt1, int paramInt2);
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native short x();
/*     */ 
/*     */     public native CornerPoint x(short paramShort);
/*     */ 
/*     */     public native short y();
/*     */ 
/*     */     public native CornerPoint y(short paramShort);
/*     */ 
/*     */     static
/*     */     {
/* 140 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.ARToolKitPlus
 * JD-Core Version:    0.6.2
 */