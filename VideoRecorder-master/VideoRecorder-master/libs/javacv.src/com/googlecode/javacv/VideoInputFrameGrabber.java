/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import com.googlecode.javacv.cpp.videoInputLib;
/*     */ import com.googlecode.javacv.cpp.videoInputLib.videoInput;
/*     */ import java.io.File;
/*     */ 
/*     */ public class VideoInputFrameGrabber extends FrameGrabber
/*     */ {
/*  51 */   private static FrameGrabber.Exception loadingException = null;
/*     */ 
/*  75 */   private int deviceNumber = 0;
/*  76 */   private videoInputLib.videoInput myVideoInput = null;
/*  77 */   private opencv_core.IplImage bgrImage = null; private opencv_core.IplImage grayImage = null;
/*  78 */   private BytePointer bgrImageData = null;
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  37 */     tryLoad();
/*     */ 
/*  39 */     int count = videoInputLib.videoInput.listDevices();
/*  40 */     String[] descriptions = new String[count];
/*  41 */     for (int i = 0; i < descriptions.length; i++) {
/*  42 */       descriptions[i] = videoInputLib.videoInput.getDeviceName(i);
/*     */     }
/*  44 */     return descriptions;
/*     */   }
/*     */   public static VideoInputFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  47 */     return null; } 
/*  48 */   public static VideoInputFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return null; } 
/*  49 */   public static VideoInputFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new VideoInputFrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  53 */     if (loadingException != null)
/*  54 */       throw loadingException;
/*     */     try
/*     */     {
/*  57 */       Loader.load(videoInputLib.class);
/*     */     } catch (Throwable t) {
/*  59 */       throw (VideoInputFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + VideoInputFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public VideoInputFrameGrabber(int deviceNumber)
/*     */   {
/*  65 */     this.deviceNumber = deviceNumber;
/*     */   }
/*     */   public void release() throws FrameGrabber.Exception {
/*  68 */     stop();
/*     */   }
/*     */   protected void finalize() throws Throwable {
/*  71 */     super.finalize();
/*  72 */     release();
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/*  82 */     if (this.gamma == 0.0D) {
/*  83 */       return 2.2D;
/*     */     }
/*  85 */     return this.gamma;
/*     */   }
/*     */ 
/*     */   public int getImageWidth()
/*     */   {
/*  90 */     return this.myVideoInput == null ? super.getImageWidth() : this.myVideoInput.getWidth(this.deviceNumber);
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/*  94 */     return this.myVideoInput == null ? super.getImageHeight() : this.myVideoInput.getHeight(this.deviceNumber);
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/*  98 */     start(-1);
/*     */   }
/*     */   public void start(int connection) throws FrameGrabber.Exception {
/* 101 */     this.myVideoInput = new videoInputLib.videoInput();
/* 102 */     if (this.frameRate > 0.0D) {
/* 103 */       this.myVideoInput.setIdealFramerate(this.deviceNumber, (int)this.frameRate);
/*     */     }
/* 105 */     if (!this.myVideoInput.setupDevice(this.deviceNumber, this.imageWidth > 0 ? this.imageWidth : 640, this.imageHeight > 0 ? this.imageHeight : 480, connection))
/*     */     {
/* 107 */       this.myVideoInput = null;
/* 108 */       throw new FrameGrabber.Exception("videoInput.setupDevice() Error: Could not setup device.");
/*     */     }
/* 110 */     if ((this.format != null) && (this.format.length() > 0)) {
/* 111 */       int f = this.format.equals("VI_NTSC_433") ? 17 : this.format.equals("VI_NTSC_M_J") ? 16 : this.format.equals("VI_SECAM_L") ? 15 : this.format.equals("VI_SECAM_K1") ? 14 : this.format.equals("VI_SECAM_K") ? 13 : this.format.equals("VI_SECAM_H") ? 12 : this.format.equals("VI_SECAM_G") ? 11 : this.format.equals("VI_SECAM_D") ? 10 : this.format.equals("VI_SECAM_B") ? 9 : this.format.equals("VI_PAL_NC") ? 8 : this.format.equals("VI_PAL_N") ? 7 : this.format.equals("VI_PAL_M") ? 6 : this.format.equals("VI_PAL_I") ? 5 : this.format.equals("VI_PAL_H") ? 4 : this.format.equals("VI_PAL_G") ? 3 : this.format.equals("VI_PAL_D") ? 2 : this.format.equals("VI_PAL_B") ? 1 : this.format.equals("VI_NTSC_M") ? 0 : -1;
/*     */ 
/* 129 */       if ((f >= 0) && (!this.myVideoInput.setFormat(this.deviceNumber, f)))
/* 130 */         throw new FrameGrabber.Exception("videoInput.setFormat() Error: Could not set format " + this.format + ".");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception
/*     */   {
/* 136 */     if (this.myVideoInput != null) {
/* 137 */       this.myVideoInput.stopDevice(this.deviceNumber);
/* 138 */       this.myVideoInput = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 143 */     if (this.myVideoInput == null) {
/* 144 */       throw new FrameGrabber.Exception("videoInput is null. (Has start() been called?)");
/*     */     }
/* 146 */     int w = this.myVideoInput.getWidth(this.deviceNumber); int h = this.myVideoInput.getHeight(this.deviceNumber);
/* 147 */     if ((this.bgrImage == null) || (this.bgrImage.width() != w) || (this.bgrImage.height() != h)) {
/* 148 */       this.bgrImage = opencv_core.IplImage.create(w, h, 8, 3);
/* 149 */       this.bgrImageData = this.bgrImage.imageData();
/*     */     }
/*     */ 
/* 152 */     for (int i = 0; i < this.numBuffers + 1; i++)
/* 153 */       this.myVideoInput.getPixels(this.deviceNumber, this.bgrImageData, false, true);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception
/*     */   {
/* 158 */     if (this.myVideoInput == null) {
/* 159 */       throw new FrameGrabber.Exception("videoInput is null. (Has start() been called?)");
/*     */     }
/* 161 */     int w = this.myVideoInput.getWidth(this.deviceNumber); int h = this.myVideoInput.getHeight(this.deviceNumber);
/* 162 */     if ((this.bgrImage == null) || (this.bgrImage.width() != w) || (this.bgrImage.height() != h)) {
/* 163 */       this.bgrImage = opencv_core.IplImage.create(w, h, 8, 3);
/* 164 */       this.bgrImageData = this.bgrImage.imageData();
/*     */     }
/*     */ 
/* 167 */     if (!this.myVideoInput.getPixels(this.deviceNumber, this.bgrImageData, false, true)) {
/* 168 */       throw new FrameGrabber.Exception("videoInput.getPixels() Error: Could not get pixels.");
/*     */     }
/* 170 */     this.timestamp = (System.nanoTime() / 1000L);
/*     */ 
/* 172 */     if (this.imageMode == FrameGrabber.ImageMode.GRAY) {
/* 173 */       if (this.grayImage == null) {
/* 174 */         this.grayImage = opencv_core.IplImage.create(w, h, 8, 1);
/*     */       }
/* 176 */       opencv_imgproc.cvCvtColor(this.bgrImage, this.grayImage, 6);
/* 177 */       return this.grayImage;
/*     */     }
/* 179 */     return this.bgrImage;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.VideoInputFrameGrabber
 * JD-Core Version:    0.6.2
 */