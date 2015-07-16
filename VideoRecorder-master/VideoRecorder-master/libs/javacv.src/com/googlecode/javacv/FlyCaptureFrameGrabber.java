/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.PGRFlyCapture;
/*     */ import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureContext;
/*     */ import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureImage;
/*     */ import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureInfoEx;
/*     */ import com.googlecode.javacv.cpp.PGRFlyCapture.FlyCaptureTimestamp;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ 
/*     */ public class FlyCaptureFrameGrabber extends FrameGrabber
/*     */ {
/*  71 */   private static FrameGrabber.Exception loadingException = null;
/*     */   public static final int INITIALIZE = 0;
/*     */   public static final int TRIGGER_INQ = 1328;
/*     */   public static final int IS_CAMERA_POWER = 1024;
/*     */   public static final int CAMERA_POWER = 1552;
/*     */   public static final int SOFTWARE_TRIGGER = 1580;
/*     */   public static final int SOFT_ASYNC_TRIGGER = 4140;
/*     */   public static final int IMAGE_DATA_FORMAT = 4168;
/* 118 */   private PGRFlyCapture.FlyCaptureContext context = new PGRFlyCapture.FlyCaptureContext(null);
/* 119 */   private PGRFlyCapture.FlyCaptureImage raw_image = new PGRFlyCapture.FlyCaptureImage();
/* 120 */   private PGRFlyCapture.FlyCaptureImage conv_image = new PGRFlyCapture.FlyCaptureImage();
/*     */   private opencv_core.IplImage temp_image;
/* 121 */   private opencv_core.IplImage return_image = null;
/* 122 */   private final int[] regOut = new int[1];
/* 123 */   private final float[] outFloat = new float[1];
/* 124 */   private final float[] gammaOut = new float[1];
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  40 */     tryLoad();
/*     */ 
/*  42 */     int[] count = new int[1];
/*  43 */     int error = PGRFlyCapture.flycaptureBusCameraCount(count);
/*  44 */     if (error != 0) {
/*  45 */       throw new FrameGrabber.Exception("flycaptureBusCameraCount() Error " + error);
/*     */     }
/*  47 */     int c = count[0];
/*  48 */     String[] descriptions = new String[c];
/*     */ 
/*  50 */     if (c > 0) {
/*  51 */       PGRFlyCapture.FlyCaptureInfoEx info = new PGRFlyCapture.FlyCaptureInfoEx(c);
/*  52 */       error = PGRFlyCapture.flycaptureBusEnumerateCamerasEx(info, count);
/*  53 */       if (error != 0) {
/*  54 */         throw new FrameGrabber.Exception("flycaptureBusEnumerateCamerasEx() Error " + error);
/*     */       }
/*     */ 
/*  57 */       for (int i = 0; i < descriptions.length; i++) {
/*  58 */         info.position(i);
/*  59 */         descriptions[i] = (info.pszVendorName() + " " + info.pszModelName() + " " + info.SerialNumber());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  64 */     return descriptions;
/*     */   }
/*     */   public static FlyCaptureFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  67 */     return null; } 
/*  68 */   public static FlyCaptureFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return null; } 
/*  69 */   public static FlyCaptureFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new FlyCaptureFrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  73 */     if (loadingException != null)
/*  74 */       throw loadingException;
/*     */     try
/*     */     {
/*  77 */       Loader.load(PGRFlyCapture.class);
/*     */     } catch (Throwable t) {
/*  79 */       throw (FlyCaptureFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + FlyCaptureFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public FlyCaptureFrameGrabber(int deviceNumber) throws FrameGrabber.Exception
/*     */   {
/*  85 */     int error = PGRFlyCapture.flycaptureCreateContext(this.context);
/*  86 */     if (error != 0) {
/*  87 */       throw new FrameGrabber.Exception("flycaptureCreateContext() Error " + error);
/*     */     }
/*  89 */     error = PGRFlyCapture.flycaptureInitializePlus(this.context, deviceNumber, this.numBuffers, null);
/*  90 */     if (error != 0)
/*  91 */       throw new FrameGrabber.Exception("flycaptureInitialize() Error " + error);
/*     */   }
/*     */ 
/*     */   public void release() throws FrameGrabber.Exception {
/*  95 */     if (this.context != null) {
/*  96 */       stop();
/*  97 */       int error = PGRFlyCapture.flycaptureDestroyContext(this.context);
/*  98 */       this.context = null;
/*  99 */       if (error != 0)
/* 100 */         throw new FrameGrabber.Exception("flycaptureDestroyContext() Error " + error);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void finalize() throws Throwable {
/* 105 */     super.finalize();
/* 106 */     release();
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/* 127 */     return (Float.isNaN(this.gammaOut[0])) || (Float.isInfinite(this.gammaOut[0])) || (this.gammaOut[0] == 0.0F) ? 2.2D : this.gammaOut[0];
/*     */   }
/*     */ 
/*     */   public int getImageWidth() {
/* 131 */     return this.return_image == null ? super.getImageWidth() : this.return_image.width();
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/* 135 */     return this.return_image == null ? super.getImageHeight() : this.return_image.height();
/*     */   }
/*     */ 
/*     */   public double getFrameRate() {
/* 139 */     if ((this.context == null) || (this.context.isNull())) {
/* 140 */       return super.getFrameRate();
/*     */     }
/* 142 */     PGRFlyCapture.flycaptureGetCameraAbsProperty(this.context, 15, this.outFloat);
/* 143 */     return this.outFloat[0];
/*     */   }
/*     */ 
/*     */   public void setImageMode(FrameGrabber.ImageMode imageMode)
/*     */   {
/* 148 */     if (imageMode != this.imageMode) {
/* 149 */       this.temp_image = null;
/* 150 */       this.return_image = null;
/*     */     }
/* 152 */     super.setImageMode(imageMode);
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/* 156 */     int f = 11;
/* 157 */     if (this.frameRate <= 0.0D)
/* 158 */       f = 11;
/* 159 */     else if (this.frameRate <= 1.876D)
/* 160 */       f = 0;
/* 161 */     else if (this.frameRate <= 3.76D)
/* 162 */       f = 1;
/* 163 */     else if (this.frameRate <= 7.51D)
/* 164 */       f = 2;
/* 165 */     else if (this.frameRate <= 15.01D)
/* 166 */       f = 3;
/* 167 */     else if (this.frameRate <= 30.010000000000002D)
/* 168 */       f = 4;
/* 169 */     else if (this.frameRate <= 60.009999999999998D)
/* 170 */       f = 6;
/* 171 */     else if (this.frameRate <= 120.01000000000001D)
/* 172 */       f = 7;
/* 173 */     else if (this.frameRate <= 240.00999999999999D) {
/* 174 */       f = 8;
/*     */     }
/*     */ 
/* 177 */     int c = 16;
/* 178 */     if ((this.imageMode == FrameGrabber.ImageMode.COLOR) || (this.imageMode == FrameGrabber.ImageMode.RAW)) {
/* 179 */       if ((this.imageWidth <= 0) || (this.imageHeight <= 0))
/* 180 */         c = 16;
/* 181 */       else if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
/* 182 */         c = 4;
/* 183 */       else if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
/* 184 */         c = 18;
/* 185 */       else if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
/* 186 */         c = 21;
/* 187 */       else if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
/* 188 */         c = 23;
/* 189 */       else if ((this.imageWidth <= 1600) && (this.imageHeight <= 1200))
/* 190 */         c = 51;
/*     */     }
/* 192 */     else if (this.imageMode == FrameGrabber.ImageMode.GRAY) {
/* 193 */       if ((this.imageWidth <= 0) || (this.imageHeight <= 0))
/* 194 */         c = 16;
/* 195 */       else if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
/* 196 */         c = this.bpp > 8 ? 6 : 5;
/* 197 */       else if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
/* 198 */         c = this.bpp > 8 ? 19 : 7;
/* 199 */       else if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
/* 200 */         c = this.bpp > 8 ? 9 : 8;
/* 201 */       else if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
/* 202 */         c = this.bpp > 8 ? 24 : 10;
/* 203 */       else if ((this.imageWidth <= 1600) && (this.imageHeight <= 1200)) {
/* 204 */         c = this.bpp > 8 ? 52 : 11;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 209 */     int[] iPolarity = new int[1];
/* 210 */     int[] iSource = new int[1];
/* 211 */     int[] iRawValue = new int[1];
/* 212 */     int[] iMode = new int[1];
/* 213 */     int error = PGRFlyCapture.flycaptureGetTrigger(this.context, null, iPolarity, iSource, iRawValue, iMode, null);
/* 214 */     if (error != 0) {
/* 215 */       throw new FrameGrabber.Exception("flycaptureGetTrigger() Error " + error);
/*     */     }
/* 217 */     error = PGRFlyCapture.flycaptureSetTrigger(this.context, this.triggerMode, iPolarity[0], 7, 14, 0);
/* 218 */     if (error != 0)
/*     */     {
/* 220 */       error = PGRFlyCapture.flycaptureSetTrigger(this.context, true, iPolarity[0], 7, 0, 0);
/*     */     }
/* 222 */     if (error != 0) {
/* 223 */       throw new FrameGrabber.Exception("flycaptureSetTrigger() Error " + error);
/*     */     }
/* 225 */     if (this.triggerMode) {
/* 226 */       waitForTriggerReady();
/*     */     }
/*     */ 
/* 230 */     error = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 4168, this.regOut);
/* 231 */     if (error != 0)
/* 232 */       throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + error);
/*     */     int reg;
/*     */     int reg;
/* 235 */     if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN))
/* 236 */       reg = this.regOut[0] | 0x1;
/*     */     else {
/* 238 */       reg = this.regOut[0] & 0xFFFFFFFE;
/*     */     }
/* 240 */     error = PGRFlyCapture.flycaptureSetCameraRegister(this.context, 4168, reg);
/* 241 */     if (error != 0) {
/* 242 */       throw new FrameGrabber.Exception("flycaptureSetCameraRegister() Error " + error);
/*     */     }
/*     */ 
/* 245 */     error = PGRFlyCapture.flycaptureSetBusSpeed(this.context, 7, 7);
/* 246 */     if (error != 0) {
/* 247 */       error = PGRFlyCapture.flycaptureSetBusSpeed(this.context, 8, 8);
/*     */ 
/* 249 */       if (error != 0) {
/* 250 */         throw new FrameGrabber.Exception("flycaptureSetBusSpeed() Error " + error);
/*     */       }
/*     */     }
/*     */ 
/* 254 */     if (this.gamma != 0.0D) {
/* 255 */       error = PGRFlyCapture.flycaptureSetCameraAbsProperty(this.context, 6, (float)this.gamma);
/* 256 */       if (error != 0) {
/* 257 */         throw new FrameGrabber.Exception("flycaptureSetCameraAbsProperty() Error " + error + ": Could not set gamma.");
/*     */       }
/*     */     }
/* 260 */     error = PGRFlyCapture.flycaptureGetCameraAbsProperty(this.context, 6, this.gammaOut);
/* 261 */     if (error != 0) {
/* 262 */       this.gammaOut[0] = 2.2F;
/*     */     }
/*     */ 
/* 265 */     error = PGRFlyCapture.flycaptureStart(this.context, c, f);
/* 266 */     if (error != 0) {
/* 267 */       throw new FrameGrabber.Exception("flycaptureStart() Error " + error);
/*     */     }
/* 269 */     error = PGRFlyCapture.flycaptureSetGrabTimeoutEx(this.context, this.timeout);
/* 270 */     if (error != 0)
/* 271 */       throw new FrameGrabber.Exception("flycaptureSetGrabTimeoutEx() Error " + error);
/*     */   }
/*     */ 
/*     */   private void waitForTriggerReady()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 277 */     long time = System.currentTimeMillis();
/*     */     do {
/* 279 */       int error = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 1580, this.regOut);
/* 280 */       if (error != 0)
/* 281 */         throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + error);
/*     */     }
/* 283 */     while ((System.currentTimeMillis() - time <= this.timeout) && 
/* 287 */       (this.regOut[0] >>> 31 != 0));
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception {
/* 291 */     int error = PGRFlyCapture.flycaptureStop(this.context);
/* 292 */     if ((error != 0) && (error != 1)) {
/* 293 */       throw new FrameGrabber.Exception("flycaptureStop() Error " + error);
/*     */     }
/* 295 */     this.temp_image = null;
/* 296 */     this.return_image = null;
/* 297 */     this.timestamp = 0L;
/* 298 */     this.frameNumber = 0;
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 302 */     waitForTriggerReady();
/* 303 */     int error = PGRFlyCapture.flycaptureSetCameraRegister(this.context, 4140, -2147483648);
/* 304 */     if (error != 0)
/* 305 */       throw new FrameGrabber.Exception("flycaptureSetCameraRegister() Error " + error);
/*     */   }
/*     */ 
/*     */   private int getNumChannels(int pixelFormat)
/*     */   {
/* 310 */     switch (pixelFormat) {
/*     */     case 16:
/*     */     case 64:
/*     */     case 256:
/*     */     case 268435457:
/* 315 */       return 3;
/*     */     case 1:
/*     */     case 32:
/*     */     case 128:
/*     */     case 512:
/*     */     case 1024:
/* 322 */       return 1;
/*     */     case 268435458:
/* 325 */       return 4;
/*     */     case 2:
/*     */     case 4:
/*     */     case 8:
/*     */     }
/*     */ 
/* 331 */     return -1;
/*     */   }
/*     */ 
/*     */   private int getDepth(int pixelFormat) {
/* 335 */     switch (pixelFormat) {
/*     */     case 1:
/*     */     case 16:
/*     */     case 512:
/*     */     case 268435457:
/*     */     case 268435458:
/* 341 */       return 8;
/*     */     case 32:
/*     */     case 64:
/*     */     case 1024:
/* 346 */       return 16;
/*     */     case 128:
/*     */     case 256:
/* 350 */       return -2147483632;
/*     */     case 2:
/*     */     case 4:
/*     */     case 8:
/*     */     }
/*     */ 
/* 356 */     return 8;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception
/*     */   {
/* 361 */     int error = PGRFlyCapture.flycaptureGrabImage2(this.context, this.raw_image);
/* 362 */     if (error != 0) {
/* 363 */       throw new FrameGrabber.Exception("flycaptureGrabImage2() Error " + error + " (Has start() been called?)");
/*     */     }
/*     */ 
/* 366 */     int w = this.raw_image.iCols();
/* 367 */     int h = this.raw_image.iRows();
/* 368 */     int format = this.raw_image.pixelFormat();
/* 369 */     int depth = getDepth(format);
/* 370 */     int stride = this.raw_image.iRowInc();
/* 371 */     int size = h * stride;
/* 372 */     int numChannels = getNumChannels(format);
/* 373 */     error = PGRFlyCapture.flycaptureGetCameraRegister(this.context, 4168, this.regOut);
/* 374 */     if (error != 0) {
/* 375 */       throw new FrameGrabber.Exception("flycaptureGetCameraRegister() Error " + error);
/*     */     }
/* 377 */     ByteOrder frameEndian = (this.regOut[0] & 0x1) != 0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
/*     */ 
/* 379 */     boolean alreadySwapped = false;
/* 380 */     boolean colorbayer = this.raw_image.bStippled();
/* 381 */     boolean colorrgb = (format == 16) || (format == 64) || (format == 268435457) || (format == 268435458);
/*     */ 
/* 383 */     boolean coloryuv = (format == 2) || (format == 4) || (format == 8);
/*     */ 
/* 385 */     BytePointer imageData = this.raw_image.pData();
/*     */ 
/* 387 */     if (((depth == 8) || (frameEndian.equals(ByteOrder.nativeOrder()))) && ((this.imageMode == FrameGrabber.ImageMode.RAW) || ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 3)) || ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (numChannels == 1) && (!colorbayer))))
/*     */     {
/* 390 */       if (this.return_image == null) {
/* 391 */         this.return_image = opencv_core.IplImage.createHeader(w, h, depth, numChannels);
/*     */       }
/* 393 */       this.return_image.widthStep(stride);
/* 394 */       this.return_image.imageSize(size);
/* 395 */       this.return_image.imageData(imageData);
/*     */     } else {
/* 397 */       if (this.return_image == null) {
/* 398 */         this.return_image = opencv_core.IplImage.create(w, h, depth, this.imageMode == FrameGrabber.ImageMode.COLOR ? 3 : 1);
/*     */       }
/* 400 */       if (this.temp_image == null) {
/* 401 */         if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && ((numChannels > 1) || (depth > 8)) && (!coloryuv) && (!colorbayer))
/*     */         {
/* 403 */           this.temp_image = opencv_core.IplImage.create(w, h, depth, numChannels);
/* 404 */         } else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (colorbayer))
/* 405 */           this.temp_image = opencv_core.IplImage.create(w, h, depth, 3);
/* 406 */         else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (colorrgb))
/* 407 */           this.temp_image = opencv_core.IplImage.createHeader(w, h, depth, 3);
/* 408 */         else if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer))
/* 409 */           this.temp_image = opencv_core.IplImage.createHeader(w, h, depth, 1);
/*     */         else {
/* 411 */           this.temp_image = this.return_image;
/*     */         }
/*     */       }
/* 414 */       this.conv_image.iRowInc(this.temp_image.widthStep());
/* 415 */       this.conv_image.pData(this.temp_image.imageData());
/* 416 */       if (depth == 8) {
/* 417 */         this.conv_image.pixelFormat(this.temp_image.nChannels() == 1 ? 1 : this.imageMode == FrameGrabber.ImageMode.RAW ? 512 : 268435457);
/*     */       }
/*     */       else {
/* 420 */         this.conv_image.pixelFormat(this.temp_image.nChannels() == 1 ? 32 : this.imageMode == FrameGrabber.ImageMode.RAW ? 1024 : 64);
/*     */       }
/*     */ 
/* 424 */       if ((depth != 8) && (this.conv_image.pixelFormat() == format) && (this.conv_image.iRowInc() == stride))
/*     */       {
/* 426 */         ShortBuffer in = this.raw_image.getByteBuffer().order(frameEndian).asShortBuffer();
/* 427 */         ShortBuffer out = this.temp_image.getByteBuffer().order(ByteOrder.nativeOrder()).asShortBuffer();
/* 428 */         out.put(in);
/* 429 */         alreadySwapped = true;
/* 430 */       } else if (((this.imageMode == FrameGrabber.ImageMode.GRAY) && (colorrgb)) || ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer)))
/*     */       {
/* 432 */         this.temp_image.widthStep(stride);
/* 433 */         this.temp_image.imageSize(size);
/* 434 */         this.temp_image.imageData(imageData);
/* 435 */       } else if ((!colorrgb) && ((colorbayer) || (coloryuv) || (numChannels > 1))) {
/* 436 */         error = PGRFlyCapture.flycaptureConvertImage(this.context, this.raw_image, this.conv_image);
/* 437 */         if (error != 0) {
/* 438 */           throw new FrameGrabber.Exception("flycaptureConvertImage() Error " + error);
/*     */         }
/*     */       }
/*     */ 
/* 442 */       if ((!alreadySwapped) && (depth != 8) && (!frameEndian.equals(ByteOrder.nativeOrder())))
/*     */       {
/* 446 */         ByteBuffer bb = this.temp_image.getByteBuffer();
/* 447 */         ShortBuffer in = bb.order(frameEndian).asShortBuffer();
/* 448 */         ShortBuffer out = bb.order(ByteOrder.nativeOrder()).asShortBuffer();
/* 449 */         out.put(in);
/*     */       }
/*     */ 
/* 452 */       if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer))
/* 453 */         opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 8);
/* 454 */       else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && ((colorbayer) || (colorrgb))) {
/* 455 */         opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 6);
/*     */       }
/*     */     }
/*     */ 
/* 459 */     error = PGRFlyCapture.flycaptureGetColorTileFormat(this.context, this.regOut);
/* 460 */     if (error != 0)
/* 461 */       this.sensorPattern = -1L;
/* 462 */     else switch (this.regOut[0]) { case 0:
/* 463 */         this.sensorPattern = 4294967297L; break;
/*     */       case 1:
/* 464 */         this.sensorPattern = 4294967296L; break;
/*     */       case 2:
/* 465 */         this.sensorPattern = 1L; break;
/*     */       case 3:
/* 466 */         this.sensorPattern = 0L; break;
/*     */       default:
/* 467 */         this.sensorPattern = -1L;
/*     */       }
/*     */ 
/* 470 */     PGRFlyCapture.FlyCaptureTimestamp timeStamp = this.raw_image.timeStamp();
/* 471 */     this.timestamp = (timeStamp.ulSeconds() * 1000000L + timeStamp.ulMicroSeconds());
/* 472 */     return this.return_image;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.FlyCaptureFrameGrabber
 * JD-Core Version:    0.6.2
 */