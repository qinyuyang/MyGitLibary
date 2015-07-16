/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacv.cpp.freenect;
/*     */ import com.googlecode.javacv.cpp.freenect.freenect_context;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ 
/*     */ public class OpenKinectFrameGrabber extends FrameGrabber
/*     */ {
/*  70 */   private static FrameGrabber.Exception loadingException = null;
/*     */ 
/*  94 */   private int deviceNumber = 0;
/*  95 */   private boolean depth = false;
/*  96 */   private BytePointer rawDepthImageData = new BytePointer((Pointer)null); private BytePointer rawVideoImageData = new BytePointer((Pointer)null);
/*     */ 
/*  98 */   private opencv_core.IplImage rawDepthImage = null; private opencv_core.IplImage rawVideoImage = null; private opencv_core.IplImage returnImage = null;
/*  99 */   private int[] timestamp = { 0 };
/* 100 */   private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
/* 101 */   private int depthFormat = -1;
/* 102 */   private int videoFormat = -1;
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  41 */     tryLoad();
/*     */ 
/*  43 */     freenect.freenect_context ctx = new freenect.freenect_context(null);
/*  44 */     int err = freenect.freenect_init(ctx, null);
/*  45 */     if (err < 0) {
/*  46 */       throw new FrameGrabber.Exception("freenect_init() Error " + err + ": Failed to init context.");
/*     */     }
/*     */ 
/*  49 */     int count = freenect.freenect_num_devices(ctx);
/*  50 */     if (count < 0) {
/*  51 */       throw new FrameGrabber.Exception("freenect_num_devices() Error " + err + ": Failed to get number of devices.");
/*     */     }
/*  53 */     String[] descriptions = new String[count];
/*  54 */     for (int i = 0; i < descriptions.length; i++) {
/*  55 */       descriptions[i] = ("Kinect #" + i);
/*     */     }
/*     */ 
/*  58 */     err = freenect.freenect_shutdown(ctx);
/*  59 */     if (err < 0) {
/*  60 */       throw new FrameGrabber.Exception("freenect_shutdown() Error " + err + ": Failed to shutdown context.");
/*     */     }
/*     */ 
/*  63 */     return descriptions;
/*     */   }
/*     */   public static OpenKinectFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  66 */     return null; } 
/*  67 */   public static OpenKinectFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return null; } 
/*  68 */   public static OpenKinectFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new OpenKinectFrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  72 */     if (loadingException != null)
/*  73 */       throw loadingException;
/*     */     try
/*     */     {
/*  76 */       Loader.load(freenect.class);
/*     */     } catch (Throwable t) {
/*  78 */       throw (OpenKinectFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + OpenKinectFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public OpenKinectFrameGrabber(int deviceNumber)
/*     */   {
/*  84 */     this.deviceNumber = deviceNumber;
/*     */   }
/*     */   public void release() throws FrameGrabber.Exception {
/*  87 */     stop();
/*     */   }
/*     */   protected void finalize() throws Throwable {
/*  90 */     super.finalize();
/*  91 */     release();
/*     */   }
/*     */ 
/*     */   public ByteOrder getByteOrder()
/*     */   {
/* 105 */     return this.byteOrder;
/*     */   }
/*     */   public void setByteOrder(ByteOrder byteOrder) {
/* 108 */     this.byteOrder = byteOrder;
/*     */   }
/*     */ 
/*     */   public int getDepthFormat() {
/* 112 */     return this.depthFormat;
/*     */   }
/*     */   public void setDepthFormat(int depthFormat) {
/* 115 */     this.depthFormat = depthFormat;
/*     */   }
/*     */ 
/*     */   public int getVideoFormat() {
/* 119 */     return this.videoFormat;
/*     */   }
/*     */   public void setVideoFormat(int videoFormat) {
/* 122 */     this.videoFormat = videoFormat;
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/* 127 */     if (this.gamma == 0.0D) {
/* 128 */       return 2.2D;
/*     */     }
/* 130 */     return this.gamma;
/*     */   }
/*     */ 
/*     */   public void setImageMode(FrameGrabber.ImageMode imageMode)
/*     */   {
/* 135 */     if (imageMode != this.imageMode) {
/* 136 */       this.returnImage = null;
/*     */     }
/* 138 */     super.setImageMode(imageMode);
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/* 142 */     this.depth = "depth".equalsIgnoreCase(this.format);
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception {
/* 146 */     freenect.freenect_sync_stop();
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 150 */     for (int i = 0; i < this.numBuffers + 1; i++)
/* 151 */       if (this.depth) {
/* 152 */         int fmt = this.depthFormat < 0 ? this.bpp : this.depthFormat;
/* 153 */         int err = freenect.freenect_sync_get_depth(this.rawDepthImageData, this.timestamp, this.deviceNumber, fmt);
/* 154 */         if (err != 0)
/* 155 */           throw new FrameGrabber.Exception("freenect_sync_get_depth() Error " + err + ": Failed to get depth synchronously.");
/*     */       }
/*     */       else {
/* 158 */         int fmt = this.videoFormat < 0 ? this.bpp : this.videoFormat;
/* 159 */         int err = freenect.freenect_sync_get_video(this.rawVideoImageData, this.timestamp, this.deviceNumber, fmt);
/* 160 */         if (err != 0)
/* 161 */           throw new FrameGrabber.Exception("freenect_sync_get_video() Error " + err + ": Failed to get video synchronously.");
/*     */       }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grabDepth()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 168 */     int fmt = this.depthFormat < 0 ? this.bpp : this.depthFormat;
/* 169 */     int iplDepth = 16; int channels = 1;
/* 170 */     switch (fmt) { case 0:
/*     */     case 1:
/*     */     case 4:
/*     */     case 5:
/* 174 */       iplDepth = 16; channels = 1; break;
/*     */     case 2:
/*     */     case 3:
/*     */     default:
/* 177 */       if (!$assertionsDisabled) throw new AssertionError();
/*     */       break;
/*     */     }
/* 180 */     int err = freenect.freenect_sync_get_depth(this.rawDepthImageData, this.timestamp, this.deviceNumber, fmt);
/* 181 */     if (err != 0) {
/* 182 */       throw new FrameGrabber.Exception("freenect_sync_get_depth() Error " + err + ": Failed to get depth synchronously.");
/*     */     }
/*     */ 
/* 185 */     int w = 640; int h = 480;
/* 186 */     if ((this.rawDepthImage == null) || (this.rawDepthImage.width() != w) || (this.rawDepthImage.height() != h)) {
/* 187 */       this.rawDepthImage = opencv_core.IplImage.createHeader(w, h, iplDepth, channels);
/*     */     }
/* 189 */     opencv_core.cvSetData(this.rawDepthImage, this.rawDepthImageData, w * channels * iplDepth / 8);
/*     */ 
/* 191 */     if ((iplDepth > 8) && (!ByteOrder.nativeOrder().equals(this.byteOrder)))
/*     */     {
/* 194 */       ByteBuffer bb = this.rawDepthImage.getByteBuffer();
/* 195 */       ShortBuffer in = bb.order(ByteOrder.BIG_ENDIAN).asShortBuffer();
/* 196 */       ShortBuffer out = bb.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
/* 197 */       out.put(in);
/*     */     }
/*     */ 
/* 200 */     this.timestamp = this.timestamp[0];
/* 201 */     return this.rawDepthImage;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grabVideo() throws FrameGrabber.Exception {
/* 205 */     int fmt = this.videoFormat < 0 ? this.bpp : this.videoFormat;
/* 206 */     int iplDepth = 8; int channels = 3;
/* 207 */     switch (fmt) { case 0:
/* 208 */       iplDepth = 8; channels = 3; break;
/*     */     case 1:
/*     */     case 2:
/* 210 */       iplDepth = 8; channels = 1; break;
/*     */     case 3:
/* 211 */       iplDepth = 16; channels = 1; break;
/*     */     case 5:
/* 212 */       iplDepth = 8; channels = 3; break;
/*     */     case 6:
/* 213 */       iplDepth = 8; channels = 2; break;
/*     */     case 4:
/*     */     default:
/* 215 */       if (!$assertionsDisabled) throw new AssertionError();
/*     */       break;
/*     */     }
/* 218 */     int err = freenect.freenect_sync_get_video(this.rawVideoImageData, this.timestamp, this.deviceNumber, fmt);
/* 219 */     if (err != 0) {
/* 220 */       throw new FrameGrabber.Exception("freenect_sync_get_video() Error " + err + ": Failed to get video synchronously.");
/*     */     }
/*     */ 
/* 223 */     int w = 640; int h = 480;
/* 224 */     if ((this.rawVideoImage == null) || (this.rawVideoImage.width() != w) || (this.rawVideoImage.height() != h)) {
/* 225 */       this.rawVideoImage = opencv_core.IplImage.createHeader(w, h, iplDepth, channels);
/*     */     }
/* 227 */     opencv_core.cvSetData(this.rawVideoImage, this.rawVideoImageData, w * channels * iplDepth / 8);
/*     */ 
/* 229 */     if ((iplDepth > 8) && (!ByteOrder.nativeOrder().equals(this.byteOrder)))
/*     */     {
/* 232 */       ByteBuffer bb = this.rawVideoImage.getByteBuffer();
/* 233 */       ShortBuffer in = bb.order(ByteOrder.BIG_ENDIAN).asShortBuffer();
/* 234 */       ShortBuffer out = bb.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
/* 235 */       out.put(in);
/*     */     }
/*     */ 
/* 238 */     if (channels == 3) {
/* 239 */       opencv_imgproc.cvCvtColor(this.rawVideoImage, this.rawVideoImage, 4);
/*     */     }
/* 241 */     this.timestamp = this.timestamp[0];
/* 242 */     return this.rawVideoImage;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception {
/* 246 */     opencv_core.IplImage image = this.depth ? grabDepth() : grabVideo();
/* 247 */     int w = image.width();
/* 248 */     int h = image.height();
/* 249 */     int iplDepth = image.depth();
/* 250 */     int channels = image.nChannels();
/*     */ 
/* 252 */     if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (channels == 1)) {
/* 253 */       if (this.returnImage == null) {
/* 254 */         this.returnImage = opencv_core.IplImage.create(w, h, iplDepth, 3);
/*     */       }
/* 256 */       opencv_imgproc.cvCvtColor(image, this.returnImage, 8);
/* 257 */       return this.returnImage;
/* 258 */     }if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (channels == 3)) {
/* 259 */       if (this.returnImage == null) {
/* 260 */         this.returnImage = opencv_core.IplImage.create(w, h, iplDepth, 1);
/*     */       }
/* 262 */       opencv_imgproc.cvCvtColor(image, this.returnImage, 6);
/* 263 */       return this.returnImage;
/*     */     }
/* 265 */     return image;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.OpenKinectFrameGrabber
 * JD-Core Version:    0.6.2
 */