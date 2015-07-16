/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ 
/*     */ public class OpenCVFrameGrabber extends FrameGrabber
/*     */ {
/*  44 */   private static FrameGrabber.Exception loadingException = null;
/*     */ 
/*  74 */   private int deviceNumber = 0;
/*  75 */   private String filename = null;
/*  76 */   private opencv_highgui.CvCapture capture = null;
/*  77 */   private opencv_core.IplImage return_image = null;
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  36 */     tryLoad();
/*  37 */     throw new UnsupportedOperationException("Device enumeration not support by OpenCV.");
/*     */   }
/*     */   public static OpenCVFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  40 */     return new OpenCVFrameGrabber(deviceFile); } 
/*  41 */   public static OpenCVFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return new OpenCVFrameGrabber(devicePath); } 
/*  42 */   public static OpenCVFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new OpenCVFrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  46 */     if (loadingException != null)
/*  47 */       throw loadingException;
/*     */     try
/*     */     {
/*  50 */       Loader.load(opencv_highgui.class);
/*     */     } catch (Throwable t) {
/*  52 */       throw (OpenCVFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + OpenCVFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public OpenCVFrameGrabber(int deviceNumber)
/*     */   {
/*  58 */     this.deviceNumber = deviceNumber;
/*     */   }
/*     */   public OpenCVFrameGrabber(File file) {
/*  61 */     this(file.getAbsolutePath());
/*     */   }
/*     */   public OpenCVFrameGrabber(String filename) {
/*  64 */     this.filename = filename;
/*     */   }
/*     */   public void release() throws FrameGrabber.Exception {
/*  67 */     stop();
/*     */   }
/*     */   protected void finalize() throws Throwable {
/*  70 */     super.finalize();
/*  71 */     release();
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/*  81 */     if (this.gamma == 0.0D) {
/*  82 */       return 2.2D;
/*     */     }
/*  84 */     return this.gamma;
/*     */   }
/*     */ 
/*     */   public String getFormat()
/*     */   {
/*  89 */     if (this.capture == null) {
/*  90 */       return super.getFormat();
/*     */     }
/*  92 */     int fourcc = (int)opencv_highgui.cvGetCaptureProperty(this.capture, 6);
/*  93 */     return "" + (char)(fourcc & 0xFF) + (char)(fourcc >> 8 & 0xFF) + (char)(fourcc >> 16 & 0xFF) + (char)(fourcc >> 24 & 0xFF);
/*     */   }
/*     */ 
/*     */   public int getImageWidth()
/*     */   {
/* 101 */     if (this.return_image != null) {
/* 102 */       return this.return_image.width();
/*     */     }
/* 104 */     return this.capture == null ? super.getImageWidth() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 3);
/*     */   }
/*     */ 
/*     */   public int getImageHeight()
/*     */   {
/* 109 */     if (this.return_image != null) {
/* 110 */       return this.return_image.height();
/*     */     }
/* 112 */     return this.capture == null ? super.getImageHeight() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 4);
/*     */   }
/*     */ 
/*     */   public int getPixelFormat()
/*     */   {
/* 117 */     return this.capture == null ? super.getPixelFormat() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 16);
/*     */   }
/*     */ 
/*     */   public double getFrameRate() {
/* 121 */     return this.capture == null ? super.getFrameRate() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 5);
/*     */   }
/*     */ 
/*     */   public void setImageMode(FrameGrabber.ImageMode imageMode) {
/* 125 */     if (imageMode != this.imageMode) {
/* 126 */       this.return_image = null;
/*     */     }
/* 128 */     super.setImageMode(imageMode);
/*     */   }
/*     */ 
/*     */   public int getFrameNumber() {
/* 132 */     return this.capture == null ? super.getFrameNumber() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 1);
/*     */   }
/*     */ 
/*     */   public void setFrameNumber(int frameNumber) throws FrameGrabber.Exception {
/* 136 */     if (this.capture == null) {
/* 137 */       super.setFrameNumber(frameNumber);
/*     */     }
/* 139 */     else if (opencv_highgui.cvSetCaptureProperty(this.capture, 1, frameNumber) == 0)
/* 140 */       throw new FrameGrabber.Exception("cvSetCaptureProperty() Error: Could not set CV_CAP_PROP_POS_FRAMES to " + frameNumber + ".");
/*     */   }
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 146 */     return this.capture == null ? super.getTimestamp() : Math.round(opencv_highgui.cvGetCaptureProperty(this.capture, 0) * 1000.0D);
/*     */   }
/*     */ 
/*     */   public void setTimestamp(long timestamp) throws FrameGrabber.Exception {
/* 150 */     if (this.capture == null) {
/* 151 */       super.setTimestamp(timestamp);
/*     */     }
/* 153 */     else if (opencv_highgui.cvSetCaptureProperty(this.capture, 0, timestamp / 1000.0D) == 0)
/* 154 */       throw new FrameGrabber.Exception("cvSetCaptureProperty() Error: Could not set CV_CAP_PROP_POS_MSEC to " + timestamp / 1000.0D + ".");
/*     */   }
/*     */ 
/*     */   public int getLengthInFrames()
/*     */   {
/* 160 */     return this.capture == null ? super.getLengthInFrames() : (int)opencv_highgui.cvGetCaptureProperty(this.capture, 7);
/*     */   }
/*     */ 
/*     */   public long getLengthInTime() {
/* 164 */     return Math.round(getLengthInFrames() * 1000000L / getFrameRate());
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/* 168 */     if ((this.filename != null) && (this.filename.length() > 0)) {
/* 169 */       this.capture = opencv_highgui.cvCreateFileCapture(this.filename);
/* 170 */       if (this.capture == null)
/* 171 */         throw new FrameGrabber.Exception("cvCreateFileCapture() Error: Could not create camera capture.");
/*     */     }
/*     */     else {
/* 174 */       this.capture = opencv_highgui.cvCreateCameraCapture(this.deviceNumber);
/* 175 */       if (this.capture == null) {
/* 176 */         throw new FrameGrabber.Exception("cvCreateCameraCapture() Error: Could not create camera capture.");
/*     */       }
/*     */     }
/* 179 */     if ((this.imageWidth > 0) && 
/* 180 */       (opencv_highgui.cvSetCaptureProperty(this.capture, 3, this.imageWidth) == 0)) {
/* 181 */       opencv_highgui.cvSetCaptureProperty(this.capture, 9, this.imageWidth);
/*     */     }
/*     */ 
/* 184 */     if ((this.imageHeight > 0) && 
/* 185 */       (opencv_highgui.cvSetCaptureProperty(this.capture, 4, this.imageHeight) == 0)) {
/* 186 */       opencv_highgui.cvSetCaptureProperty(this.capture, 9, this.imageHeight);
/*     */     }
/*     */ 
/* 189 */     if (this.frameRate > 0.0D) {
/* 190 */       opencv_highgui.cvSetCaptureProperty(this.capture, 5, this.frameRate);
/*     */     }
/* 192 */     if (this.bpp > 0) {
/* 193 */       opencv_highgui.cvSetCaptureProperty(this.capture, 8, this.bpp);
/*     */     }
/* 195 */     opencv_highgui.cvSetCaptureProperty(this.capture, 16, this.imageMode == FrameGrabber.ImageMode.COLOR ? 1.0D : 0.0D);
/*     */ 
/* 201 */     int count = 0;
/* 202 */     while ((count++ < 100) && (opencv_highgui.cvGrabFrame(this.capture) != 0) && (opencv_highgui.cvRetrieveFrame(this.capture) == null))
/*     */       try {
/* 204 */         Thread.sleep(100L);
/*     */       }
/*     */       catch (InterruptedException ex) {
/*     */       }
/* 208 */     if (!this.triggerMode) {
/* 209 */       int err = opencv_highgui.cvGrabFrame(this.capture);
/* 210 */       if (err == 0)
/* 211 */         throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception
/*     */   {
/* 217 */     if (this.capture != null) {
/* 218 */       opencv_highgui.cvReleaseCapture(this.capture);
/* 219 */       this.capture = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 224 */     for (int i = 0; i < this.numBuffers + 1; i++) {
/* 225 */       opencv_highgui.cvQueryFrame(this.capture);
/*     */     }
/* 227 */     int err = opencv_highgui.cvGrabFrame(this.capture);
/* 228 */     if (err == 0)
/* 229 */       throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception
/*     */   {
/* 234 */     opencv_core.IplImage image = opencv_highgui.cvRetrieveFrame(this.capture);
/* 235 */     if (image == null) {
/* 236 */       throw new FrameGrabber.Exception("cvRetrieveFrame() Error: Could not retrieve frame. (Has start() been called?)");
/*     */     }
/* 238 */     if (!this.triggerMode) {
/* 239 */       int err = opencv_highgui.cvGrabFrame(this.capture);
/* 240 */       if (err == 0) {
/* 241 */         throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
/*     */       }
/*     */     }
/*     */ 
/* 245 */     if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (image.nChannels() > 1)) {
/* 246 */       if (this.return_image == null) {
/* 247 */         this.return_image = opencv_core.IplImage.create(image.width(), image.height(), image.depth(), 1);
/*     */       }
/* 249 */       opencv_imgproc.cvCvtColor(image, this.return_image, 6);
/* 250 */     } else if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (image.nChannels() == 1)) {
/* 251 */       if (this.return_image == null) {
/* 252 */         this.return_image = opencv_core.IplImage.create(image.width(), image.height(), image.depth(), 3);
/*     */       }
/* 254 */       opencv_imgproc.cvCvtColor(image, this.return_image, 8);
/*     */     } else {
/* 256 */       this.return_image = image;
/*     */     }
/* 258 */     return this.return_image;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.OpenCVFrameGrabber
 * JD-Core Version:    0.6.2
 */