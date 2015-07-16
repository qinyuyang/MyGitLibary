/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import cl.eye.CLCamera;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.IntBuffer;
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ public class PS3EyeFrameGrabber extends FrameGrabber
/*     */ {
/*  80 */   private static FrameGrabber.Exception loadingException = null;
/*     */   CLCamera camera;
/*  94 */   int cameraIndex = 0;
/*  95 */   int[] ps3_frame = null;
/*  96 */   byte[] ipl_frame = null;
/*     */ 
/*  98 */   opencv_core.IplImage image_4ch = null;
/*  99 */   opencv_core.IplImage image_1ch = null;
/*     */   String stat;
/*     */   String uuid;
/* 107 */   protected Triggered triggered = Triggered.NO_TRIGGER;
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  68 */     tryLoad();
/*  69 */     String[] descriptions = new String[CLCamera.cameraCount()];
/*  70 */     for (int i = 0; i < descriptions.length; i++) {
/*  71 */       descriptions[i] = CLCamera.cameraUUID(i);
/*     */     }
/*  73 */     return descriptions;
/*     */   }
/*     */   public static PS3EyeFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  76 */     return null; } 
/*  77 */   public static PS3EyeFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return null; } 
/*  78 */   public static PS3EyeFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return new PS3EyeFrameGrabber(deviceNumber); }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  82 */     if (loadingException != null)
/*  83 */       throw loadingException;
/*     */     try
/*     */     {
/*  86 */       CLCamera.IsLibraryLoaded();
/*     */     } catch (Throwable t) {
/*  88 */       throw (PS3EyeFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + PS3EyeFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public PS3EyeFrameGrabber()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 114 */     this(0);
/*     */   }
/*     */ 
/*     */   public PS3EyeFrameGrabber(int cameraIndex)
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 121 */     this(cameraIndex, 640, 480, 60);
/*     */   }
/*     */ 
/*     */   public PS3EyeFrameGrabber(int cameraIndex, int imageWidth, int imageHeight, int framerate) throws FrameGrabber.Exception {
/* 125 */     this(cameraIndex, 640, 480, 60, null);
/*     */   }
/*     */ 
/*     */   public PS3EyeFrameGrabber(int cameraIndex, int imageWidth, int imageHeight, int framerate, Object applet)
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 138 */     this.camera = null;
/*     */ 
/* 140 */     if (!CLCamera.IsLibraryLoaded()) {
/* 141 */       throw new FrameGrabber.Exception("CLEye multicam dll not loaded");
/*     */     }
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/* 147 */         this.camera = ((CLCamera)CLCamera.class.newInstance());
/*     */       } catch (Throwable t) {
/* 149 */         if (applet == null)
/*     */         {
/* 152 */           Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
/* 153 */           unsafeField.setAccessible(true);
/* 154 */           Unsafe unsafe = (Unsafe)unsafeField.get(null);
/* 155 */           this.camera = ((CLCamera)unsafe.allocateInstance(CLCamera.class));
/*     */         } else {
/* 157 */           this.camera = ((CLCamera)CLCamera.class.getConstructors()[0].newInstance(new Object[] { applet }));
/*     */         }
/*     */       }
/*     */     } catch (Throwable t) {
/* 161 */       throw new FrameGrabber.Exception("Failed to construct " + PS3EyeFrameGrabber.class, t);
/*     */     }
/* 163 */     this.cameraIndex = cameraIndex;
/*     */ 
/* 165 */     this.stat = "created";
/* 166 */     this.uuid = CLCamera.cameraUUID(cameraIndex);
/*     */ 
/* 168 */     if (((imageWidth == 640) && (imageHeight == 480)) || ((imageWidth == 320) && (imageHeight == 240)))
/*     */     {
/* 170 */       setImageWidth(imageWidth);
/* 171 */       setImageHeight(imageHeight);
/*     */     } else {
/* 173 */       throw new FrameGrabber.Exception("Only 640x480 or 320x240 images supported");
/*     */     }
/* 175 */     setImageMode(FrameGrabber.ImageMode.COLOR);
/* 176 */     setFrameRate(framerate);
/* 177 */     setTimeout(1 + 1000 / framerate);
/* 178 */     setBitsPerPixel(8);
/* 179 */     setTriggerMode(false);
/* 180 */     setNumBuffers(4);
/*     */   }
/*     */ 
/*     */   public static int getCameraCount()
/*     */   {
/* 187 */     return CLCamera.cameraCount();
/*     */   }
/*     */ 
/*     */   public static String[] listPS3Cameras()
/*     */   {
/* 196 */     int no = getCameraCount();
/*     */ 
/* 198 */     if (no > 0) {
/* 199 */       String[] uuids = new String[no];
/* 200 */       for (no--; no >= 0; no--) uuids[no] = CLCamera.cameraUUID(no);
/* 201 */       return uuids;
/*     */     }
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage makeImage(int[] frame)
/*     */   {
/* 214 */     this.image_4ch.getIntBuffer().put(this.ps3_frame);
/* 215 */     return this.image_4ch;
/*     */   }
/*     */ 
/*     */   public int[] grab_raw()
/*     */   {
/* 224 */     if (this.camera.getCameraFrame(this.ps3_frame, this.timeout)) {
/* 225 */       return this.ps3_frame;
/*     */     }
/* 227 */     return null;
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 231 */     for (int i = 0; i < this.numBuffers + 1; i++) {
/* 232 */       grab_raw();
/*     */     }
/*     */ 
/* 235 */     if ((this.ps3_frame = grab_raw()) != null) {
/* 236 */       this.triggered = Triggered.HAS_FRAME;
/* 237 */       this.timestamp = (System.nanoTime() / 1000L);
/*     */     }
/*     */     else {
/* 240 */       this.triggered = Triggered.NO_FRAME;
/*     */     }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab_RGB4()
/*     */   {
/* 253 */     if (this.camera.getCameraFrame(this.ps3_frame, this.timeout)) {
/* 254 */       this.timestamp = (System.nanoTime() / 1000L);
/* 255 */       this.image_4ch.getIntBuffer().put(this.ps3_frame);
/* 256 */       return this.image_4ch;
/*     */     }
/* 258 */     return null;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 269 */     opencv_core.IplImage img = null;
/* 270 */     switch (1.$SwitchMap$com$googlecode$javacv$PS3EyeFrameGrabber$Triggered[this.triggered.ordinal()]) {
/*     */     case 1:
/* 272 */       img = grab_RGB4();
/* 273 */       break;
/*     */     case 2:
/* 275 */       this.triggered = Triggered.NO_TRIGGER;
/* 276 */       img = makeImage(this.ps3_frame);
/* 277 */       break;
/*     */     case 3:
/* 279 */       this.triggered = Triggered.NO_TRIGGER;
/* 280 */       return null;
/*     */     default:
/* 282 */       throw new FrameGrabber.Exception("Int. error - unknown triggering state");
/*     */     }
/* 284 */     if ((img != null) && (this.imageMode == FrameGrabber.ImageMode.GRAY)) {
/* 285 */       opencv_imgproc.cvCvtColor(img, this.image_1ch, 7);
/* 286 */       img = this.image_1ch;
/*     */     }
/* 288 */     return img;
/*     */   }
/*     */ 
/*     */   public void start()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 299 */     if (this.ps3_frame == null) {
/* 300 */       this.ps3_frame = new int[this.imageWidth * this.imageHeight];
/* 301 */       this.image_4ch = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 8, 4);
/* 302 */       this.image_1ch = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 8, 1);
/*     */     }
/*     */ 
/* 305 */     boolean b = this.camera.createCamera(this.cameraIndex, this.imageMode == FrameGrabber.ImageMode.GRAY ? CLCamera.CLEYE_MONO_PROCESSED : CLCamera.CLEYE_COLOR_PROCESSED, (this.imageWidth == 320) && (this.imageHeight == 240) ? CLCamera.CLEYE_QVGA : CLCamera.CLEYE_VGA, (int)this.frameRate);
/*     */ 
/* 311 */     if (!b) throw new FrameGrabber.Exception("Low level createCamera() failed");
/*     */ 
/* 313 */     b = this.camera.startCamera();
/* 314 */     if (!b) throw new FrameGrabber.Exception("Camera start() failed");
/* 315 */     this.stat = "started";
/*     */   }
/*     */ 
/*     */   public void stop()
/*     */     throws FrameGrabber.Exception
/*     */   {
/* 324 */     boolean b = this.camera.stopCamera();
/* 325 */     if (b) this.stat = "stopped"; else
/* 326 */       throw new FrameGrabber.Exception("Camera stop() failed");
/*     */   }
/*     */ 
/*     */   public void release()
/*     */   {
/* 336 */     if (this.camera != null) {
/* 337 */       this.camera.dispose();
/* 338 */       this.camera = null;
/*     */     }
/*     */ 
/* 341 */     if (this.image_4ch != null) {
/* 342 */       this.image_4ch.release();
/* 343 */       this.image_4ch = null;
/*     */     }
/*     */ 
/* 346 */     if (this.image_1ch != null) {
/* 347 */       this.image_1ch.release();
/* 348 */       this.image_1ch = null;
/*     */     }
/*     */ 
/* 351 */     if (this.ipl_frame != null) this.ipl_frame = null;
/* 352 */     if (this.ps3_frame != null) this.ps3_frame = null;
/*     */ 
/* 354 */     this.stat = "released";
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/* 360 */     release();
/*     */   }
/*     */ 
/*     */   protected void finalize() throws Throwable {
/* 364 */     super.finalize();
/* 365 */     release();
/*     */   }
/*     */ 
/*     */   public CLCamera getCamera()
/*     */   {
/* 375 */     return this.camera;
/*     */   }
/* 377 */   public String getUUID() { return this.uuid; }
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 383 */     return "UUID=" + this.uuid + "; status=" + this.stat + "; timeout=" + this.timeout + "; " + (this.camera != null ? this.camera.toString() : "<no camera>");
/*     */   }
/*     */ 
/*     */   public static void main(String[] argv)
/*     */   {
/* 396 */     String[] uuids = listPS3Cameras();
/* 397 */     for (int i = 0; i < uuids.length; i++)
/* 398 */       System.out.println(i + ": " + uuids[i]);
/*     */   }
/*     */ 
/*     */   protected static enum Triggered
/*     */   {
/* 106 */     NO_TRIGGER, HAS_FRAME, NO_FRAME;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.PS3EyeFrameGrabber
 * JD-Core Version:    0.6.2
 */