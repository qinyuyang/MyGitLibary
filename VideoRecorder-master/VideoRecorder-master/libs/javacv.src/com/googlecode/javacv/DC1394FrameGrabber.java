/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.dc1394;
/*     */ import com.googlecode.javacv.cpp.dc1394.dc1394_t;
/*     */ import com.googlecode.javacv.cpp.dc1394.dc1394camera_id_t;
/*     */ import com.googlecode.javacv.cpp.dc1394.dc1394camera_list_t;
/*     */ import com.googlecode.javacv.cpp.dc1394.dc1394camera_t;
/*     */ import com.googlecode.javacv.cpp.dc1394.dc1394video_frame_t;
/*     */ import com.googlecode.javacv.cpp.dc1394.pollfd;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ 
/*     */ public class DC1394FrameGrabber extends FrameGrabber
/*     */ {
/*  78 */   private static FrameGrabber.Exception loadingException = null;
/*     */ 
/* 128 */   private static final boolean linux = Loader.getPlatformName().startsWith("linux");
/* 129 */   private dc1394.dc1394_t d = null;
/* 130 */   private dc1394.dc1394camera_t camera = null;
/* 131 */   private dc1394.pollfd fds = new dc1394.pollfd();
/* 132 */   private boolean oneShotMode = false;
/* 133 */   private boolean resetDone = false;
/* 134 */   private dc1394.dc1394video_frame_t[] raw_image = { new dc1394.dc1394video_frame_t(null), new dc1394.dc1394video_frame_t(null) };
/*     */ 
/* 136 */   private dc1394.dc1394video_frame_t conv_image = new dc1394.dc1394video_frame_t();
/* 137 */   private dc1394.dc1394video_frame_t frame = null;
/* 138 */   private dc1394.dc1394video_frame_t enqueue_image = null;
/*     */   private opencv_core.IplImage temp_image;
/* 139 */   private opencv_core.IplImage return_image = null;
/* 140 */   private final int[] out = new int[1];
/* 141 */   private final float[] outFloat = new float[1];
/* 142 */   private final float[] gammaOut = new float[1];
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  40 */     tryLoad();
/*     */ 
/*  42 */     dc1394.dc1394_t d = dc1394.dc1394_new();
/*  43 */     if (d == null) {
/*  44 */       throw new FrameGrabber.Exception("dc1394_new() Error: Failed to initialize libdc1394.");
/*     */     }
/*  46 */     dc1394.dc1394camera_list_t list = new dc1394.dc1394camera_list_t(null);
/*  47 */     int err = dc1394.dc1394_camera_enumerate(d, list);
/*  48 */     if (err != 0) {
/*  49 */       throw new FrameGrabber.Exception("dc1394_camera_enumerate() Error " + err + ": Failed to enumerate cameras.");
/*     */     }
/*  51 */     int num = list.num();
/*  52 */     String[] descriptions = new String[num];
/*     */ 
/*  54 */     if (num > 0) {
/*  55 */       dc1394.dc1394camera_id_t ids = list.ids();
/*  56 */       for (int i = 0; i < num; i++) {
/*  57 */         ids.position(i);
/*  58 */         dc1394.dc1394camera_t camera = dc1394.dc1394_camera_new_unit(d, ids.guid(), ids.unit());
/*  59 */         if (camera == null) {
/*  60 */           throw new FrameGrabber.Exception("dc1394_camera_new_unit() Error: Failed to initialize camera with GUID 0x" + Long.toHexString(ids.guid()) + " / " + camera.unit() + ".");
/*     */         }
/*     */ 
/*  63 */         descriptions[i] = (camera.vendor().getString() + " " + camera.model().getString() + " 0x" + Long.toHexString(camera.guid()) + " / " + camera.unit());
/*     */ 
/*  65 */         dc1394.dc1394_camera_free(camera);
/*     */       }
/*     */     }
/*     */ 
/*  69 */     dc1394.dc1394_camera_free_list(list);
/*  70 */     dc1394.dc1394_free(d);
/*  71 */     return descriptions;
/*     */   }
/*     */   public static DC1394FrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  74 */     return null; } 
/*  75 */   public static DC1394FrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return null; } 
/*  76 */   public static DC1394FrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new DC1394FrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  80 */     if (loadingException != null)
/*  81 */       throw loadingException;
/*     */     try
/*     */     {
/*  84 */       Loader.load(dc1394.class);
/*     */     } catch (Throwable t) {
/*  86 */       throw (DC1394FrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + DC1394FrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public DC1394FrameGrabber(int deviceNumber) throws FrameGrabber.Exception
/*     */   {
/*  92 */     this.d = dc1394.dc1394_new();
/*  93 */     dc1394.dc1394camera_list_t list = new dc1394.dc1394camera_list_t(null);
/*  94 */     int err = dc1394.dc1394_camera_enumerate(this.d, list);
/*  95 */     if (err != 0) {
/*  96 */       throw new FrameGrabber.Exception("dc1394_camera_enumerate() Error " + err + ": Failed to enumerate cameras.");
/*     */     }
/*  98 */     int num = list.num();
/*  99 */     if (num <= deviceNumber) {
/* 100 */       throw new FrameGrabber.Exception("DC1394Grabber() Error: Camera number " + deviceNumber + " not found. There are only " + num + " devices.");
/*     */     }
/*     */ 
/* 103 */     dc1394.dc1394camera_id_t ids = list.ids().position(deviceNumber);
/* 104 */     this.camera = dc1394.dc1394_camera_new_unit(this.d, ids.guid(), ids.unit());
/* 105 */     if (this.camera == null) {
/* 106 */       throw new FrameGrabber.Exception("dc1394_camera_new_unit() Error: Failed to initialize camera with GUID 0x" + Long.toHexString(ids.guid()) + " / " + this.camera.unit() + ".");
/*     */     }
/*     */ 
/* 109 */     dc1394.dc1394_camera_free_list(list);
/*     */   }
/*     */ 
/*     */   public void release() throws FrameGrabber.Exception {
/* 113 */     if (this.camera != null) {
/* 114 */       stop();
/* 115 */       dc1394.dc1394_camera_free(this.camera);
/* 116 */       this.camera = null;
/*     */     }
/* 118 */     if (this.d != null) {
/* 119 */       dc1394.dc1394_free(this.d);
/* 120 */       this.d = null;
/*     */     }
/*     */   }
/*     */ 
/* 124 */   protected void finalize() throws Throwable { super.finalize();
/* 125 */     release();
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/* 145 */     return (Float.isNaN(this.gammaOut[0])) || (Float.isInfinite(this.gammaOut[0])) || (this.gammaOut[0] == 0.0F) ? 2.2D : this.gammaOut[0];
/*     */   }
/*     */ 
/*     */   public int getImageWidth() {
/* 149 */     return this.return_image == null ? super.getImageWidth() : this.return_image.width();
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/* 153 */     return this.return_image == null ? super.getImageHeight() : this.return_image.height();
/*     */   }
/*     */ 
/*     */   public double getFrameRate() {
/* 157 */     if (this.camera == null) {
/* 158 */       return super.getFrameRate();
/*     */     }
/* 160 */     if (dc1394.dc1394_feature_get_absolute_value(this.camera, 431, this.outFloat) != 0)
/*     */     {
/* 162 */       dc1394.dc1394_video_get_framerate(this.camera, this.out);
/* 163 */       dc1394.dc1394_framerate_as_float(this.out[0], this.outFloat);
/*     */     }
/* 165 */     return this.outFloat[0];
/*     */   }
/*     */ 
/*     */   public void setImageMode(FrameGrabber.ImageMode imageMode)
/*     */   {
/* 170 */     if (imageMode != this.imageMode) {
/* 171 */       this.temp_image = null;
/* 172 */       this.return_image = null;
/*     */     }
/* 174 */     super.setImageMode(imageMode);
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/* 178 */     start(true, true);
/*     */   }
/*     */   public void start(boolean tryReset, boolean try1394b) throws FrameGrabber.Exception {
/* 181 */     int c = -1;
/* 182 */     if ((this.imageMode == FrameGrabber.ImageMode.COLOR) || (this.imageMode == FrameGrabber.ImageMode.RAW)) {
/* 183 */       if ((this.imageWidth <= 0) || (this.imageHeight <= 0))
/* 184 */         c = -1;
/* 185 */       else if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
/* 186 */         c = 68;
/* 187 */       else if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
/* 188 */         c = 72;
/* 189 */       else if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
/* 190 */         c = 75;
/* 191 */       else if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
/* 192 */         c = 80;
/* 193 */       else if ((this.imageWidth <= 1600) && (this.imageHeight <= 1200))
/* 194 */         c = 83;
/*     */     }
/* 196 */     else if (this.imageMode == FrameGrabber.ImageMode.GRAY) {
/* 197 */       if ((this.imageWidth <= 0) || (this.imageHeight <= 0))
/* 198 */         c = -1;
/* 199 */       else if ((this.imageWidth <= 640) && (this.imageHeight <= 480))
/* 200 */         c = this.bpp > 8 ? 70 : 69;
/* 201 */       else if ((this.imageWidth <= 800) && (this.imageHeight <= 600))
/* 202 */         c = this.bpp > 8 ? 77 : 73;
/* 203 */       else if ((this.imageWidth <= 1024) && (this.imageHeight <= 768))
/* 204 */         c = this.bpp > 8 ? 78 : 76;
/* 205 */       else if ((this.imageWidth <= 1280) && (this.imageHeight <= 960))
/* 206 */         c = this.bpp > 8 ? 85 : 81;
/* 207 */       else if ((this.imageWidth <= 1600) && (this.imageHeight <= 1200)) {
/* 208 */         c = this.bpp > 8 ? 86 : 84;
/*     */       }
/*     */     }
/*     */ 
/* 212 */     if (c == -1)
/*     */     {
/* 214 */       dc1394.dc1394_video_get_mode(this.camera, this.out);
/* 215 */       c = this.out[0];
/*     */     }
/*     */ 
/* 218 */     int f = -1;
/* 219 */     if (this.frameRate <= 0.0D)
/* 220 */       f = -1;
/* 221 */     else if (this.frameRate <= 1.876D)
/* 222 */       f = 32;
/* 223 */     else if (this.frameRate <= 3.76D)
/* 224 */       f = 33;
/* 225 */     else if (this.frameRate <= 7.51D)
/* 226 */       f = 34;
/* 227 */     else if (this.frameRate <= 15.01D)
/* 228 */       f = 35;
/* 229 */     else if (this.frameRate <= 30.010000000000002D)
/* 230 */       f = 36;
/* 231 */     else if (this.frameRate <= 60.009999999999998D)
/* 232 */       f = 37;
/* 233 */     else if (this.frameRate <= 120.01000000000001D)
/* 234 */       f = 38;
/* 235 */     else if (this.frameRate <= 240.00999999999999D) {
/* 236 */       f = 39;
/*     */     }
/*     */ 
/* 239 */     if (f == -1)
/*     */     {
/* 241 */       dc1394.dc1394_video_get_framerate(this.camera, this.out);
/* 242 */       f = this.out[0];
/*     */     }
/*     */     try
/*     */     {
/* 246 */       this.oneShotMode = false;
/* 247 */       if (this.triggerMode) {
/* 248 */         int err = dc1394.dc1394_external_trigger_set_power(this.camera, 1);
/* 249 */         if (err != 0)
/*     */         {
/* 251 */           this.oneShotMode = true;
/*     */         } else {
/* 253 */           err = dc1394.dc1394_external_trigger_set_mode(this.camera, 390);
/* 254 */           if (err != 0)
/*     */           {
/* 256 */             err = dc1394.dc1394_external_trigger_set_mode(this.camera, 384);
/*     */           }
/* 258 */           err = dc1394.dc1394_external_trigger_set_source(this.camera, 580);
/* 259 */           if (err != 0)
/*     */           {
/* 261 */             this.oneShotMode = true;
/* 262 */             dc1394.dc1394_external_trigger_set_power(this.camera, 0);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 267 */       int err = dc1394.dc1394_video_set_operation_mode(this.camera, 480);
/* 268 */       if (try1394b) {
/* 269 */         err = dc1394.dc1394_video_set_operation_mode(this.camera, 481);
/* 270 */         if (err == 0) {
/* 271 */           err = dc1394.dc1394_video_set_iso_speed(this.camera, 3);
/*     */         }
/*     */       }
/* 274 */       if ((err != 0) || (!try1394b)) {
/* 275 */         err = dc1394.dc1394_video_set_iso_speed(this.camera, 2);
/* 276 */         if (err != 0) {
/* 277 */           throw new FrameGrabber.Exception("dc1394_video_set_iso_speed() Error " + err + ": Could not set maximum iso speed.");
/*     */         }
/*     */       }
/*     */ 
/* 281 */       err = dc1394.dc1394_video_set_mode(this.camera, c);
/* 282 */       if (err != 0) {
/* 283 */         throw new FrameGrabber.Exception("dc1394_video_set_mode() Error " + err + ": Could not set video mode.");
/*     */       }
/*     */ 
/* 286 */       if (dc1394.dc1394_is_video_mode_scalable(c) == 1) {
/* 287 */         err = dc1394.dc1394_format7_set_roi(this.camera, c, -1, -1, -1, -1, -1, -1);
/*     */ 
/* 291 */         if (err != 0)
/* 292 */           throw new FrameGrabber.Exception("dc1394_format7_set_roi() Error " + err + ": Could not set format7 mode.");
/*     */       }
/*     */       else {
/* 295 */         err = dc1394.dc1394_video_set_framerate(this.camera, f);
/* 296 */         if (err != 0) {
/* 297 */           throw new FrameGrabber.Exception("dc1394_video_set_framerate() Error " + err + ": Could not set framerate.");
/*     */         }
/*     */       }
/*     */ 
/* 301 */       err = dc1394.dc1394_capture_setup(this.camera, this.numBuffers, 4);
/* 302 */       if (err != 0) {
/* 303 */         throw new FrameGrabber.Exception("dc1394_capture_setup() Error " + err + ": Could not setup camera-\n" + "make sure that the video mode and framerate are\nsupported by your camera.");
/*     */       }
/*     */ 
/* 307 */       if (this.gamma != 0.0D) {
/* 308 */         err = dc1394.dc1394_feature_set_absolute_value(this.camera, 422, (float)this.gamma);
/* 309 */         if (err != 0) {
/* 310 */           throw new FrameGrabber.Exception("dc1394_feature_set_absolute_value() Error " + err + ": Could not set gamma.");
/*     */         }
/*     */       }
/* 313 */       err = dc1394.dc1394_feature_get_absolute_value(this.camera, 422, this.gammaOut);
/* 314 */       if (err != 0) {
/* 315 */         this.gammaOut[0] = 2.2F;
/*     */       }
/*     */ 
/* 318 */       if (linux) {
/* 319 */         this.fds.fd(dc1394.dc1394_capture_get_fileno(this.camera));
/*     */       }
/*     */ 
/* 322 */       if (!this.oneShotMode) {
/* 323 */         err = dc1394.dc1394_video_set_transmission(this.camera, 1);
/* 324 */         if (err != 0)
/* 325 */           throw new FrameGrabber.Exception("dc1394_video_set_transmission() Error " + err + ": Could not start camera iso transmission.");
/*     */       }
/*     */     }
/*     */     catch (FrameGrabber.Exception e)
/*     */     {
/* 330 */       if ((tryReset) && (!this.resetDone)) {
/* 331 */         dc1394.dc1394_reset_bus(this.camera);
/*     */         try {
/* 333 */           Thread.sleep(100L); } catch (InterruptedException ex) {
/*     */         }
/* 335 */         this.resetDone = true;
/* 336 */         start(false, try1394b);
/*     */       } else {
/* 338 */         throw e;
/*     */       }
/*     */     } finally {
/* 341 */       this.resetDone = false;
/*     */     }
/*     */ 
/* 344 */     if ((linux) && (try1394b)) {
/* 345 */       if (this.triggerMode) {
/* 346 */         trigger();
/*     */       }
/* 348 */       this.fds.events((short)1);
/* 349 */       if (dc1394.poll(this.fds, 1L, this.timeout) == 0)
/*     */       {
/* 352 */         stop();
/* 353 */         start(tryReset, false);
/* 354 */       } else if (this.triggerMode) {
/* 355 */         grab();
/* 356 */         enqueue();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception {
/* 362 */     this.enqueue_image = null;
/* 363 */     this.temp_image = null;
/* 364 */     this.return_image = null;
/* 365 */     this.timestamp = 0L;
/* 366 */     this.frameNumber = 0;
/*     */ 
/* 368 */     int err = dc1394.dc1394_video_set_transmission(this.camera, 0);
/* 369 */     if (err != 0) {
/* 370 */       throw new FrameGrabber.Exception("dc1394_video_set_transmission() Error " + err + ": Could not stop the camera?");
/*     */     }
/* 372 */     err = dc1394.dc1394_capture_stop(this.camera);
/* 373 */     if ((err != 0) && (err != -10)) {
/* 374 */       throw new FrameGrabber.Exception("dc1394_capture_stop() Error " + err + ": Could not stop the camera?");
/*     */     }
/* 376 */     err = dc1394.dc1394_external_trigger_get_mode(this.camera, this.out);
/* 377 */     if ((err == 0) && (this.out[0] >= 384)) {
/* 378 */       err = dc1394.dc1394_external_trigger_set_power(this.camera, 0);
/* 379 */       if (err != 0)
/* 380 */         throw new FrameGrabber.Exception("dc1394_external_trigger_set_power() Error " + err + ": Could not switch off external trigger.");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void enqueue() throws FrameGrabber.Exception
/*     */   {
/* 386 */     enqueue(this.enqueue_image);
/* 387 */     this.enqueue_image = null;
/*     */   }
/*     */   private void enqueue(dc1394.dc1394video_frame_t image) throws FrameGrabber.Exception {
/* 390 */     if (image != null) {
/* 391 */       int err = dc1394.dc1394_capture_enqueue(this.camera, image);
/* 392 */       if (err != 0)
/* 393 */         throw new FrameGrabber.Exception("dc1394_capture_enqueue() Error " + err + ": Could not release a frame.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception
/*     */   {
/* 399 */     enqueue();
/* 400 */     if (this.oneShotMode) {
/* 401 */       int err = dc1394.dc1394_video_set_one_shot(this.camera, 1);
/* 402 */       if (err != 0)
/* 403 */         throw new FrameGrabber.Exception("dc1394_video_set_one_shot() Error " + err + ": Could not set camera into one-shot mode.");
/*     */     }
/*     */     else {
/* 406 */       long time = System.currentTimeMillis();
/*     */       do
/* 408 */         dc1394.dc1394_software_trigger_get_power(this.camera, this.out);
/* 409 */       while ((System.currentTimeMillis() - time <= this.timeout) && 
/* 413 */         (this.out[0] == 1));
/* 414 */       int err = dc1394.dc1394_software_trigger_set_power(this.camera, 1);
/* 415 */       if (err != 0)
/* 416 */         throw new FrameGrabber.Exception("dc1394_software_trigger_set_power() Error " + err + ": Could not trigger camera.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception
/*     */   {
/* 422 */     enqueue();
/* 423 */     if (linux) {
/* 424 */       this.fds.events((short)1);
/* 425 */       if (dc1394.poll(this.fds, 1L, this.timeout) == 0) {
/* 426 */         throw new FrameGrabber.Exception("poll() Error: Timeout occured. (Has start() been called?)");
/*     */       }
/*     */     }
/* 429 */     int i = 0;
/* 430 */     int err = dc1394.dc1394_capture_dequeue(this.camera, 672, this.raw_image[i]);
/* 431 */     if (err != 0) {
/* 432 */       throw new FrameGrabber.Exception("dc1394_capture_dequeue(WAIT) Error " + err + ": Could not capture a frame. (Has start() been called?)");
/*     */     }
/*     */ 
/* 435 */     int numDequeued = 0;
/* 436 */     while (!this.raw_image[i].isNull()) {
/* 437 */       enqueue();
/* 438 */       this.enqueue_image = this.raw_image[i];
/* 439 */       i = (i + 1) % 2;
/* 440 */       numDequeued++;
/* 441 */       err = dc1394.dc1394_capture_dequeue(this.camera, 673, this.raw_image[i]);
/* 442 */       if (err != 0) {
/* 443 */         throw new FrameGrabber.Exception("dc1394_capture_dequeue(POLL) Error " + err + ": Could not capture a frame.");
/*     */       }
/*     */     }
/* 446 */     this.frame = this.raw_image[((i + 1) % 2)];
/* 447 */     int w = this.frame.size(0);
/* 448 */     int h = this.frame.size(1);
/* 449 */     int depth = this.frame.data_depth();
/* 450 */     int iplDepth = 0;
/* 451 */     switch (depth) { case 8:
/* 452 */       iplDepth = 8; break;
/*     */     case 16:
/* 453 */       iplDepth = 16; break;
/*     */     default:
/* 454 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 456 */     int stride = this.frame.stride();
/* 457 */     int size = this.frame.image_bytes();
/* 458 */     int numChannels = stride / w * 8 / depth;
/* 459 */     ByteOrder frameEndian = this.frame.little_endian() != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
/*     */ 
/* 461 */     boolean alreadySwapped = false;
/* 462 */     int color_coding = this.frame.color_coding();
/* 463 */     boolean colorbayer = (color_coding == 361) || (color_coding == 362);
/*     */ 
/* 465 */     boolean colorrgb = (color_coding == 356) || (color_coding == 358);
/*     */ 
/* 467 */     boolean coloryuv = (color_coding == 353) || (color_coding == 354) || (color_coding == 355);
/*     */ 
/* 470 */     BytePointer imageData = this.frame.image();
/*     */ 
/* 472 */     if (((depth <= 8) || (frameEndian.equals(ByteOrder.nativeOrder()))) && (!coloryuv) && ((this.imageMode == FrameGrabber.ImageMode.RAW) || ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 3)) || ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (numChannels == 1) && (!colorbayer))))
/*     */     {
/* 475 */       if (this.return_image == null) {
/* 476 */         this.return_image = opencv_core.IplImage.createHeader(w, h, iplDepth, numChannels);
/*     */       }
/* 478 */       this.return_image.widthStep(stride);
/* 479 */       this.return_image.imageSize(size);
/* 480 */       this.return_image.imageData(imageData);
/*     */     }
/*     */     else
/*     */     {
/* 484 */       int padding_bytes = this.frame.padding_bytes();
/* 485 */       int padding1 = (int)Math.ceil(padding_bytes / (w * depth / 8));
/* 486 */       int padding3 = (int)Math.ceil(padding_bytes / (w * 3 * depth / 8));
/* 487 */       if (this.return_image == null) {
/* 488 */         int c = this.imageMode == FrameGrabber.ImageMode.COLOR ? 3 : 1;
/* 489 */         int padding = this.imageMode == FrameGrabber.ImageMode.COLOR ? padding3 : padding1;
/* 490 */         this.return_image = opencv_core.IplImage.create(w, h + padding, iplDepth, c);
/* 491 */         this.return_image.height(this.return_image.height() - padding);
/*     */       }
/* 493 */       if (this.temp_image == null) {
/* 494 */         if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && ((numChannels > 1) || (depth > 8)) && (!coloryuv) && (!colorbayer))
/*     */         {
/* 496 */           this.temp_image = opencv_core.IplImage.create(w, h + padding1, iplDepth, numChannels);
/* 497 */           this.temp_image.height(this.temp_image.height() - padding1);
/* 498 */         } else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && ((coloryuv) || (colorbayer) || ((colorrgb) && (depth > 8))))
/*     */         {
/* 500 */           this.temp_image = opencv_core.IplImage.create(w, h + padding3, iplDepth, 3);
/* 501 */           this.temp_image.height(this.temp_image.height() - padding3);
/* 502 */         } else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (colorrgb)) {
/* 503 */           this.temp_image = opencv_core.IplImage.createHeader(w, h, iplDepth, 3);
/* 504 */         } else if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer)) {
/* 505 */           this.temp_image = opencv_core.IplImage.createHeader(w, h, iplDepth, 1);
/*     */         } else {
/* 507 */           this.temp_image = this.return_image;
/*     */         }
/*     */       }
/* 510 */       this.conv_image.size(0, this.temp_image.width());
/* 511 */       this.conv_image.size(1, this.temp_image.height());
/* 512 */       if (depth > 8) {
/* 513 */         this.conv_image.color_coding(this.temp_image.nChannels() == 1 ? 357 : this.imageMode == FrameGrabber.ImageMode.RAW ? 362 : 358);
/*     */ 
/* 516 */         this.conv_image.data_depth(16);
/*     */       } else {
/* 518 */         this.conv_image.color_coding(this.temp_image.nChannels() == 1 ? 352 : this.imageMode == FrameGrabber.ImageMode.RAW ? 361 : 356);
/*     */ 
/* 521 */         this.conv_image.data_depth(8);
/*     */       }
/* 523 */       this.conv_image.stride(this.temp_image.widthStep());
/* 524 */       int temp_size = this.temp_image.imageSize();
/* 525 */       this.conv_image.allocated_image_bytes(temp_size).total_bytes(temp_size).image_bytes(temp_size);
/*     */ 
/* 527 */       this.conv_image.image(this.temp_image.imageData());
/*     */ 
/* 529 */       if (colorbayer)
/*     */       {
/* 532 */         int c = this.frame.color_filter();
/* 533 */         if (c == 512)
/* 534 */           this.frame.color_filter(515);
/* 535 */         else if (c == 513)
/* 536 */           this.frame.color_filter(514);
/* 537 */         else if (c == 514)
/* 538 */           this.frame.color_filter(513);
/* 539 */         else if (c == 515) {
/* 540 */           this.frame.color_filter(512);
/*     */         }
/* 542 */         else if (!$assertionsDisabled) throw new AssertionError();
/*     */ 
/* 545 */         err = dc1394.dc1394_debayer_frames(this.frame, this.conv_image, 1);
/* 546 */         this.frame.color_filter(c);
/* 547 */         if (err != 0)
/* 548 */           throw new FrameGrabber.Exception("dc1394_debayer_frames() Error " + err + ": Could not debayer frame.");
/*     */       }
/* 550 */       else if ((depth > 8) && (this.frame.data_depth() == this.conv_image.data_depth()) && (this.frame.color_coding() == this.conv_image.color_coding()) && (this.frame.stride() == this.conv_image.stride()))
/*     */       {
/* 555 */         ShortBuffer in = this.frame.getByteBuffer().order(frameEndian).asShortBuffer();
/* 556 */         ShortBuffer out = this.temp_image.getByteBuffer().order(ByteOrder.nativeOrder()).asShortBuffer();
/* 557 */         out.put(in);
/* 558 */         alreadySwapped = true;
/* 559 */       } else if (((this.imageMode == FrameGrabber.ImageMode.GRAY) && (colorrgb)) || ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer)))
/*     */       {
/* 561 */         this.temp_image.widthStep(stride);
/* 562 */         this.temp_image.imageSize(size);
/* 563 */         this.temp_image.imageData(imageData);
/* 564 */       } else if ((!colorrgb) && ((colorbayer) || (coloryuv) || (numChannels > 1)))
/*     */       {
/* 566 */         err = dc1394.dc1394_convert_frames(this.frame, this.conv_image);
/* 567 */         if (err != 0) {
/* 568 */           throw new FrameGrabber.Exception("dc1394_convert_frames() Error " + err + ": Could not convert frame.");
/*     */         }
/*     */       }
/*     */ 
/* 572 */       if ((!alreadySwapped) && (depth > 8) && (!frameEndian.equals(ByteOrder.nativeOrder())))
/*     */       {
/* 575 */         ByteBuffer bb = this.temp_image.getByteBuffer();
/* 576 */         ShortBuffer in = bb.order(frameEndian).asShortBuffer();
/* 577 */         ShortBuffer out = bb.order(ByteOrder.nativeOrder()).asShortBuffer();
/* 578 */         out.put(in);
/*     */       }
/*     */ 
/* 582 */       if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (numChannels == 1) && (!coloryuv) && (!colorbayer))
/* 583 */         opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 8);
/* 584 */       else if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && ((colorbayer) || (colorrgb) || (coloryuv))) {
/* 585 */         opencv_imgproc.cvCvtColor(this.temp_image, this.return_image, 6);
/*     */       }
/*     */     }
/*     */ 
/* 589 */     switch (this.frame.color_filter()) { case 512:
/* 590 */       this.sensorPattern = 0L; break;
/*     */     case 513:
/* 591 */       this.sensorPattern = 4294967296L; break;
/*     */     case 514:
/* 592 */       this.sensorPattern = 1L; break;
/*     */     case 515:
/* 593 */       this.sensorPattern = 4294967297L; break;
/*     */     default:
/* 594 */       this.sensorPattern = -1L;
/*     */     }
/*     */ 
/* 597 */     this.enqueue_image = this.frame;
/* 598 */     this.timestamp = this.frame.timestamp();
/* 599 */     this.frameNumber += numDequeued;
/*     */ 
/* 604 */     return this.return_image;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.DC1394FrameGrabber
 * JD-Core Version:    0.6.2
 */