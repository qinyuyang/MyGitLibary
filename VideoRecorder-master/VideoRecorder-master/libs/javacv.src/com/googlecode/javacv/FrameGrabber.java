/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ 
/*     */ public abstract class FrameGrabber
/*     */ {
/*  44 */   public static final List<String> list = new LinkedList(Arrays.asList(new String[] { "DC1394", "FlyCapture", "OpenKinect", "PS3Eye", "VideoInput", "OpenCV", "FFmpeg" }));
/*     */   public static final long SENSOR_PATTERN_RGGB = 0L;
/*     */   public static final long SENSOR_PATTERN_GBRG = 4294967296L;
/*     */   public static final long SENSOR_PATTERN_GRBG = 1L;
/*     */   public static final long SENSOR_PATTERN_BGGR = 4294967297L;
/*     */   protected String format;
/*     */   protected int imageWidth;
/*     */   protected int imageHeight;
/*     */   protected int audioChannels;
/*     */   protected ImageMode imageMode;
/*     */   protected long sensorPattern;
/*     */   protected int pixelFormat;
/*     */   protected double frameRate;
/*     */   protected int sampleFormat;
/*     */   protected int sampleRate;
/*     */   protected boolean triggerMode;
/*     */   protected int bpp;
/*     */   protected int timeout;
/*     */   protected int numBuffers;
/*     */   protected double gamma;
/*     */   protected boolean deinterlace;
/*     */   protected int frameNumber;
/*     */   protected long timestamp;
/*     */   private ExecutorService executor;
/*     */   private Future<Void> future;
/*     */   private opencv_core.IplImage delayedImage;
/*     */   private long delayedTime;
/*     */ 
/*     */   public FrameGrabber()
/*     */   {
/* 169 */     this.format = null;
/* 170 */     this.imageWidth = 0; this.imageHeight = 0; this.audioChannels = 0;
/* 171 */     this.imageMode = ImageMode.COLOR;
/* 172 */     this.sensorPattern = -1L;
/* 173 */     this.pixelFormat = -1;
/* 174 */     this.frameRate = 0.0D;
/* 175 */     this.sampleFormat = 0; this.sampleRate = 0;
/* 176 */     this.triggerMode = false;
/* 177 */     this.bpp = 0;
/* 178 */     this.timeout = 10000;
/* 179 */     this.numBuffers = 4;
/* 180 */     this.gamma = 0.0D;
/* 181 */     this.deinterlace = false;
/* 182 */     this.frameNumber = 0;
/* 183 */     this.timestamp = 0L;
/*     */ 
/* 342 */     this.executor = Executors.newSingleThreadExecutor();
/* 343 */     this.future = null;
/* 344 */     this.delayedImage = null;
/* 345 */     this.delayedTime = 0L;
/*     */   }
/*     */ 
/*     */   public static void init()
/*     */   {
/*  47 */     for (String name : list)
/*     */       try {
/*  49 */         Class c = get(name);
/*  50 */         c.getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
/*     */       } catch (Throwable t) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public static Class<? extends FrameGrabber> getDefault() {
/*  56 */     for (String name : list)
/*     */       try {
/*  58 */         Class c = get(name);
/*  59 */         c.getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
/*  60 */         boolean mayContainCameras = false;
/*     */         try {
/*  62 */           String[] s = (String[])c.getMethod("getDeviceDescriptions", new Class[0]).invoke(null, new Object[0]);
/*  63 */           if (s.length > 0)
/*  64 */             mayContainCameras = true;
/*     */         }
/*     */         catch (Throwable t) {
/*  67 */           if ((t.getCause() instanceof UnsupportedOperationException)) {
/*  68 */             mayContainCameras = true;
/*     */           }
/*     */         }
/*  71 */         if (mayContainCameras)
/*  72 */           return c;
/*     */       }
/*     */       catch (Throwable t) {
/*     */       }
/*  76 */     return null;
/*     */   }
/*     */   public static Class<? extends FrameGrabber> get(String className) throws FrameGrabber.Exception {
/*  79 */     className = FrameGrabber.class.getPackage().getName() + "." + className;
/*     */     try {
/*  81 */       return Class.forName(className).asSubclass(FrameGrabber.class);
/*     */     } catch (ClassNotFoundException e) {
/*  83 */       String className2 = className + "FrameGrabber";
/*     */       try {
/*  85 */         return Class.forName(className2).asSubclass(FrameGrabber.class); } catch (ClassNotFoundException ex) {
/*     */       }
/*  87 */       throw new Exception("Could not get FrameGrabber class for " + className + " or " + className2, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static FrameGrabber create(Class<? extends FrameGrabber> c, Class p, Object o) throws FrameGrabber.Exception
/*     */   {
/*  93 */     Throwable cause = null;
/*     */     try {
/*  95 */       return (FrameGrabber)c.getConstructor(new Class[] { p }).newInstance(new Object[] { o });
/*     */     } catch (InstantiationException ex) {
/*  97 */       cause = ex;
/*     */     } catch (IllegalAccessException ex) {
/*  99 */       cause = ex;
/*     */     } catch (IllegalArgumentException ex) {
/* 101 */       cause = ex;
/*     */     } catch (NoSuchMethodException ex) {
/* 103 */       cause = ex;
/*     */     } catch (InvocationTargetException ex) {
/* 105 */       cause = ex.getCause();
/*     */     }
/* 107 */     throw new Exception("Could not create new " + c.getSimpleName() + "(" + o + ")", cause);
/*     */   }
/*     */ 
/*     */   public static FrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/* 111 */     return create(getDefault(), File.class, deviceFile);
/*     */   }
/*     */   public static FrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception {
/* 114 */     return create(getDefault(), String.class, devicePath);
/*     */   }
/*     */   public static FrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception {
/*     */     try {
/* 118 */       return create(getDefault(), Integer.TYPE, Integer.valueOf(deviceNumber)); } catch (Exception ex) {
/*     */     }
/* 120 */     return create(getDefault(), Integer.class, Integer.valueOf(deviceNumber));
/*     */   }
/*     */ 
/*     */   public static FrameGrabber create(String className, File deviceFile) throws FrameGrabber.Exception
/*     */   {
/* 125 */     return create(get(className), File.class, deviceFile);
/*     */   }
/*     */   public static FrameGrabber create(String className, String devicePath) throws FrameGrabber.Exception {
/* 128 */     return create(get(className), String.class, devicePath);
/*     */   }
/*     */   public static FrameGrabber create(String className, int deviceNumber) throws FrameGrabber.Exception {
/*     */     try {
/* 132 */       return create(get(className), Integer.TYPE, Integer.valueOf(deviceNumber)); } catch (Exception ex) {
/*     */     }
/* 134 */     return create(get(className), Integer.class, Integer.valueOf(deviceNumber));
/*     */   }
/*     */ 
/*     */   public String getFormat()
/*     */   {
/* 186 */     return this.format;
/*     */   }
/*     */   public void setFormat(String format) {
/* 189 */     this.format = format;
/*     */   }
/*     */ 
/*     */   public int getImageWidth() {
/* 193 */     return this.imageWidth;
/*     */   }
/*     */   public void setImageWidth(int imageWidth) {
/* 196 */     this.imageWidth = imageWidth;
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/* 200 */     return this.imageHeight;
/*     */   }
/*     */   public void setImageHeight(int imageHeight) {
/* 203 */     this.imageHeight = imageHeight;
/*     */   }
/*     */ 
/*     */   public int getAudioChannels() {
/* 207 */     return this.audioChannels;
/*     */   }
/*     */   public void setAudioChannels(int audioChannels) {
/* 210 */     this.audioChannels = audioChannels;
/*     */   }
/*     */ 
/*     */   public ImageMode getImageMode() {
/* 214 */     return this.imageMode;
/*     */   }
/*     */   public void setImageMode(ImageMode imageMode) {
/* 217 */     this.imageMode = imageMode;
/*     */   }
/*     */ 
/*     */   public long getSensorPattern() {
/* 221 */     return this.sensorPattern;
/*     */   }
/*     */   public void setSensorPattern(long sensorPattern) {
/* 224 */     this.sensorPattern = sensorPattern;
/*     */   }
/*     */ 
/*     */   public int getPixelFormat() {
/* 228 */     return this.pixelFormat;
/*     */   }
/*     */   public void setPixelFormat(int pixelFormat) {
/* 231 */     this.pixelFormat = pixelFormat;
/*     */   }
/*     */ 
/*     */   public double getFrameRate() {
/* 235 */     return this.frameRate;
/*     */   }
/*     */   public void setFrameRate(double frameRate) {
/* 238 */     this.frameRate = frameRate;
/*     */   }
/*     */ 
/*     */   public int getSampleFormat() {
/* 242 */     return this.sampleFormat;
/*     */   }
/*     */   public void setSampleFormat(int sampleFormat) {
/* 245 */     this.sampleFormat = sampleFormat;
/*     */   }
/*     */ 
/*     */   public int getSampleRate() {
/* 249 */     return this.sampleRate;
/*     */   }
/*     */   public void setSampleRate(int sampleRate) {
/* 252 */     this.sampleRate = sampleRate;
/*     */   }
/*     */ 
/*     */   public boolean isTriggerMode() {
/* 256 */     return this.triggerMode;
/*     */   }
/*     */   public void setTriggerMode(boolean triggerMode) {
/* 259 */     this.triggerMode = triggerMode;
/*     */   }
/*     */ 
/*     */   public int getBitsPerPixel() {
/* 263 */     return this.bpp;
/*     */   }
/*     */   public void setBitsPerPixel(int bitsPerPixel) {
/* 266 */     this.bpp = bitsPerPixel;
/*     */   }
/*     */ 
/*     */   public int getTimeout() {
/* 270 */     return this.timeout;
/*     */   }
/*     */   public void setTimeout(int timeout) {
/* 273 */     this.timeout = timeout;
/*     */   }
/*     */ 
/*     */   public int getNumBuffers() {
/* 277 */     return this.numBuffers;
/*     */   }
/*     */   public void setNumBuffers(int numBuffers) {
/* 280 */     this.numBuffers = numBuffers;
/*     */   }
/*     */ 
/*     */   public double getGamma() {
/* 284 */     return this.gamma;
/*     */   }
/*     */   public void setGamma(double gamma) {
/* 287 */     this.gamma = gamma;
/*     */   }
/*     */ 
/*     */   public boolean isDeinterlace() {
/* 291 */     return this.deinterlace;
/*     */   }
/*     */   public void setDeinterlace(boolean deinterlace) {
/* 294 */     this.deinterlace = deinterlace;
/*     */   }
/*     */ 
/*     */   public int getFrameNumber() {
/* 298 */     return this.frameNumber;
/*     */   }
/*     */   public void setFrameNumber(int frameNumber) throws FrameGrabber.Exception {
/* 301 */     this.frameNumber = frameNumber;
/*     */   }
/*     */ 
/*     */   public long getTimestamp() {
/* 305 */     return this.timestamp;
/*     */   }
/*     */   public void setTimestamp(long timestamp) throws FrameGrabber.Exception {
/* 308 */     this.timestamp = timestamp;
/*     */   }
/*     */ 
/*     */   public int getLengthInFrames() {
/* 312 */     return 0;
/*     */   }
/*     */   public long getLengthInTime() {
/* 315 */     return 0L;
/*     */   }
/*     */ 
/*     */   public abstract void start() throws FrameGrabber.Exception;
/*     */ 
/*     */   public abstract void stop() throws FrameGrabber.Exception;
/*     */ 
/*     */   public abstract void trigger() throws FrameGrabber.Exception;
/*     */ 
/*     */   public abstract opencv_core.IplImage grab() throws FrameGrabber.Exception;
/*     */ 
/*     */   public Frame grabFrame() throws FrameGrabber.Exception
/*     */   {
/* 328 */     throw new UnsupportedOperationException("This FrameGrabber does not support audio.");
/*     */   }
/*     */   public abstract void release() throws FrameGrabber.Exception;
/*     */ 
/*     */   public void restart() throws FrameGrabber.Exception {
/* 333 */     stop();
/* 334 */     start();
/*     */   }
/*     */   public void flush() throws FrameGrabber.Exception {
/* 337 */     for (int i = 0; i < this.numBuffers + 1; i++)
/* 338 */       grab();
/*     */   }
/*     */ 
/*     */   public void delayedGrab(long delayTime)
/*     */   {
/* 347 */     this.delayedImage = null;
/* 348 */     this.delayedTime = 0L;
/* 349 */     final long start = System.nanoTime() / 1000L;
/* 350 */     if ((this.future != null) && (!this.future.isDone())) {
/* 351 */       return;
/*     */     }
/* 353 */     this.future = this.executor.submit(new Callable() {
/*     */       public Void call() throws FrameGrabber.Exception {
/*     */         do { FrameGrabber.this.delayedImage = FrameGrabber.this.grab();
/* 356 */           FrameGrabber.this.delayedTime = (System.nanoTime() / 1000L - start); }
/* 357 */         while (FrameGrabber.this.delayedTime < this.val$delayTime);
/* 358 */         return null;
/*     */       } } );
/*     */   }
/*     */ 
/* 362 */   public long getDelayedTime() throws InterruptedException, ExecutionException { if (this.future == null) {
/* 363 */       return 0L;
/*     */     }
/* 365 */     this.future.get();
/* 366 */     return this.delayedTime; }
/*     */ 
/*     */   public opencv_core.IplImage getDelayedImage() throws InterruptedException, ExecutionException {
/* 369 */     if (this.future == null) {
/* 370 */       return null;
/*     */     }
/* 372 */     this.future.get();
/* 373 */     return this.delayedImage;
/*     */   }
/*     */ 
/*     */   public Array createArray(FrameGrabber[] frameGrabbers)
/*     */   {
/* 515 */     return new Array(frameGrabbers);
/*     */   }
/*     */ 
/*     */   public static class Array
/*     */   {
/* 383 */     private opencv_core.IplImage[] grabbedImages = null;
/* 384 */     private long[] latencies = null;
/* 385 */     private long[] bestLatencies = null;
/* 386 */     private long lastNewestTimestamp = 0L;
/* 387 */     private long bestInterval = 9223372036854775807L;
/*     */ 
/* 389 */     protected FrameGrabber[] frameGrabbers = null;
/*     */ 
/*     */     protected Array(FrameGrabber[] frameGrabbers)
/*     */     {
/* 380 */       setFrameGrabbers(frameGrabbers);
/*     */     }
/*     */ 
/*     */     public FrameGrabber[] getFrameGrabbers()
/*     */     {
/* 391 */       return this.frameGrabbers;
/*     */     }
/*     */     public void setFrameGrabbers(FrameGrabber[] frameGrabbers) {
/* 394 */       this.frameGrabbers = frameGrabbers;
/* 395 */       this.grabbedImages = new opencv_core.IplImage[frameGrabbers.length];
/* 396 */       this.latencies = new long[frameGrabbers.length];
/* 397 */       this.bestLatencies = null;
/* 398 */       this.lastNewestTimestamp = 0L;
/*     */     }
/*     */     public int size() {
/* 401 */       return this.frameGrabbers.length;
/*     */     }
/*     */ 
/*     */     public void start() throws FrameGrabber.Exception {
/* 405 */       for (FrameGrabber f : this.frameGrabbers)
/* 406 */         f.start();
/*     */     }
/*     */ 
/*     */     public void stop() throws FrameGrabber.Exception {
/* 410 */       for (FrameGrabber f : this.frameGrabbers)
/* 411 */         f.stop();
/*     */     }
/*     */ 
/*     */     public void trigger() throws FrameGrabber.Exception
/*     */     {
/* 416 */       for (FrameGrabber f : this.frameGrabbers)
/* 417 */         if (f.isTriggerMode())
/* 418 */           f.trigger();
/*     */     }
/*     */ 
/*     */     public opencv_core.IplImage[] grab()
/*     */       throws FrameGrabber.Exception
/*     */     {
/* 424 */       if (this.frameGrabbers.length == 1) {
/* 425 */         this.grabbedImages[0] = this.frameGrabbers[0].grab();
/* 426 */         return this.grabbedImages;
/*     */       }
/*     */ 
/* 433 */       long newestTimestamp = 0L;
/* 434 */       boolean unsynchronized = false;
/* 435 */       for (int i = 0; i < this.frameGrabbers.length; i++) {
/* 436 */         this.grabbedImages[i] = this.frameGrabbers[i].grab();
/* 437 */         if (this.grabbedImages[i] != null) {
/* 438 */           newestTimestamp = Math.max(newestTimestamp, this.frameGrabbers[i].getTimestamp());
/*     */         }
/* 440 */         if (this.frameGrabbers[i].getClass() != this.frameGrabbers[((i + 1) % this.frameGrabbers.length)].getClass())
/*     */         {
/* 442 */           unsynchronized = true;
/*     */         }
/*     */       }
/* 445 */       if (unsynchronized) {
/* 446 */         return this.grabbedImages;
/*     */       }
/* 448 */       for (int i = 0; i < this.frameGrabbers.length; i++) {
/* 449 */         if (this.grabbedImages[i] != null) {
/* 450 */           this.latencies[i] = (newestTimestamp - Math.max(0L, this.frameGrabbers[i].getTimestamp()));
/*     */         }
/*     */       }
/* 453 */       if (this.bestLatencies == null) {
/* 454 */         this.bestLatencies = Arrays.copyOf(this.latencies, this.latencies.length);
/*     */       } else {
/* 456 */         int sum1 = 0; int sum2 = 0;
/* 457 */         for (int i = 0; i < this.frameGrabbers.length; i++) {
/* 458 */           sum1 = (int)(sum1 + this.latencies[i]);
/* 459 */           sum2 = (int)(sum2 + this.bestLatencies[i]);
/*     */         }
/* 461 */         if (sum1 < sum2) {
/* 462 */           this.bestLatencies = Arrays.copyOf(this.latencies, this.latencies.length);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 468 */       this.bestInterval = Math.min(this.bestInterval, newestTimestamp - this.lastNewestTimestamp);
/* 469 */       for (int i = 0; i < this.bestLatencies.length; i++) {
/* 470 */         this.bestLatencies[i] = Math.min(this.bestLatencies[i], this.bestInterval * 9L / 10L);
/*     */       }
/*     */ 
/* 475 */       for (int j = 0; j < 2; j++) {
/* 476 */         for (int i = 0; i < this.frameGrabbers.length; i++) {
/* 477 */           if ((!this.frameGrabbers[i].isTriggerMode()) && (this.grabbedImages[i] != null))
/*     */           {
/* 480 */             int latency = (int)(newestTimestamp - Math.max(0L, this.frameGrabbers[i].getTimestamp()));
/* 481 */             while (latency - this.bestLatencies[i] > 0.1D * this.bestLatencies[i]) {
/* 482 */               this.grabbedImages[i] = this.frameGrabbers[i].grab();
/* 483 */               if (this.grabbedImages[i] != null)
/*     */               {
/* 486 */                 latency = (int)(newestTimestamp - Math.max(0L, this.frameGrabbers[i].getTimestamp()));
/* 487 */                 if (latency < 0)
/*     */                 {
/* 490 */                   newestTimestamp = Math.max(0L, this.frameGrabbers[i].getTimestamp());
/*     */                 }
/*     */ 
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 503 */       this.lastNewestTimestamp = newestTimestamp;
/*     */ 
/* 505 */       return this.grabbedImages;
/*     */     }
/*     */     public void release() throws FrameGrabber.Exception {
/* 508 */       for (FrameGrabber f : this.frameGrabbers)
/* 509 */         f.release();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Exception extends Exception
/*     */   {
/*     */     public Exception(String message)
/*     */     {
/* 319 */       super(); } 
/* 320 */     public Exception(String message, Throwable cause) { super(cause); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static enum ImageMode
/*     */   {
/* 160 */     COLOR, GRAY, RAW;
/*     */   }
/*     */ 
/*     */   public static class PropertyEditor extends PropertyEditorSupport
/*     */   {
/*     */     public String getAsText()
/*     */     {
/* 140 */       Class c = (Class)getValue();
/* 141 */       return c == null ? "null" : c.getSimpleName().split("FrameGrabber")[0];
/*     */     }
/*     */     public void setAsText(String s) {
/* 144 */       if (s == null)
/* 145 */         setValue(null);
/*     */       try
/*     */       {
/* 148 */         setValue(FrameGrabber.get(s));
/*     */       } catch (FrameGrabber.Exception ex) {
/* 150 */         throw new IllegalArgumentException(ex);
/*     */       }
/*     */     }
/*     */ 
/* 154 */     public String[] getTags() { return (String[])FrameGrabber.list.toArray(new String[FrameGrabber.list.size()]); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.FrameGrabber
 * JD-Core Version:    0.6.2
 */