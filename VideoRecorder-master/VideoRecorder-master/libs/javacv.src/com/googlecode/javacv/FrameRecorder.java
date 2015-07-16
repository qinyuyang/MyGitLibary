/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.Buffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class FrameRecorder
/*     */ {
/*  39 */   public static final List<String> list = new LinkedList(Arrays.asList(new String[] { "FFmpeg", "OpenCV" }));
/*     */   protected String format;
/*     */   protected String videoCodecName;
/*     */   protected String audioCodecName;
/*     */   protected int imageWidth;
/*     */   protected int imageHeight;
/*     */   protected int audioChannels;
/*     */   protected int pixelFormat;
/*     */   protected int videoCodec;
/*     */   protected int videoBitrate;
/*     */   protected double frameRate;
/*     */   protected double videoQuality;
/*     */   protected int sampleFormat;
/*     */   protected int audioCodec;
/*     */   protected int audioBitrate;
/*     */   protected int sampleRate;
/*     */   protected double audioQuality;
/*     */   protected boolean interleaved;
/*     */   protected HashMap<String, String> videoOptions;
/*     */   protected HashMap<String, String> audioOptions;
/*     */   protected int frameNumber;
/*     */   protected long timestamp;
/*     */ 
/*     */   public FrameRecorder()
/*     */   {
/* 108 */     this.videoQuality = -1.0D;
/*     */ 
/* 110 */     this.audioQuality = -1.0D;
/*     */ 
/* 112 */     this.videoOptions = new HashMap();
/* 113 */     this.audioOptions = new HashMap();
/* 114 */     this.frameNumber = 0;
/* 115 */     this.timestamp = 0L;
/*     */   }
/*     */ 
/*     */   public static void init()
/*     */   {
/*  41 */     for (String name : list)
/*     */       try {
/*  43 */         Class c = get(name);
/*  44 */         c.getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
/*     */       } catch (Throwable t) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public static Class<? extends FrameRecorder> getDefault() {
/*  50 */     for (String name : list)
/*     */       try {
/*  52 */         Class c = get(name);
/*  53 */         c.getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
/*  54 */         return c;
/*     */       } catch (Throwable t) {
/*     */       }
/*  57 */     return null;
/*     */   }
/*     */   public static Class<? extends FrameRecorder> get(String className) throws FrameRecorder.Exception {
/*  60 */     className = FrameRecorder.class.getPackage().getName() + "." + className;
/*     */     try {
/*  62 */       return Class.forName(className).asSubclass(FrameRecorder.class);
/*     */     } catch (ClassNotFoundException e) {
/*  64 */       String className2 = className + "FrameRecorder";
/*     */       try {
/*  66 */         return Class.forName(className2).asSubclass(FrameRecorder.class); } catch (ClassNotFoundException ex) {
/*     */       }
/*  68 */       throw new Exception("Could not get FrameRecorder class for " + className + " or " + className2, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static FrameRecorder create(Class<? extends FrameRecorder> c, Class p, Object o, int w, int h) throws FrameRecorder.Exception
/*     */   {
/*  74 */     Throwable cause = null;
/*     */     try {
/*  76 */       return (FrameRecorder)c.getConstructor(new Class[] { p, Integer.TYPE, Integer.TYPE }).newInstance(new Object[] { o, Integer.valueOf(w), Integer.valueOf(h) });
/*     */     } catch (InstantiationException ex) {
/*  78 */       cause = ex;
/*     */     } catch (IllegalAccessException ex) {
/*  80 */       cause = ex;
/*     */     } catch (IllegalArgumentException ex) {
/*  82 */       cause = ex;
/*     */     } catch (NoSuchMethodException ex) {
/*  84 */       cause = ex;
/*     */     } catch (InvocationTargetException ex) {
/*  86 */       cause = ex.getCause();
/*     */     }
/*  88 */     throw new Exception("Could not create new " + c.getSimpleName() + "(" + o + ", " + w + ", " + h + ")", cause);
/*     */   }
/*     */ 
/*     */   public static FrameRecorder createDefault(File file, int width, int height) throws FrameRecorder.Exception {
/*  92 */     return create(getDefault(), File.class, file, width, height);
/*     */   }
/*     */   public static FrameRecorder createDefault(String filename, int width, int height) throws FrameRecorder.Exception {
/*  95 */     return create(getDefault(), String.class, filename, width, height);
/*     */   }
/*     */ 
/*     */   public static FrameRecorder create(String className, File file, int width, int height) throws FrameRecorder.Exception {
/*  99 */     return create(get(className), File.class, file, width, height);
/*     */   }
/*     */   public static FrameRecorder create(String className, String filename, int width, int height) throws FrameRecorder.Exception {
/* 102 */     return create(get(className), String.class, filename, width, height);
/*     */   }
/*     */ 
/*     */   public String getFormat()
/*     */   {
/* 118 */     return this.format;
/*     */   }
/*     */   public void setFormat(String format) {
/* 121 */     this.format = format;
/*     */   }
/*     */ 
/*     */   public String getVideoCodecName() {
/* 125 */     return this.videoCodecName;
/*     */   }
/*     */   public void setVideoCodecName(String videoCodecName) {
/* 128 */     this.videoCodecName = videoCodecName;
/*     */   }
/*     */ 
/*     */   public String getAudioCodecName() {
/* 132 */     return this.audioCodecName;
/*     */   }
/*     */   public void setAudioCodecName(String audioCodecName) {
/* 135 */     this.audioCodecName = audioCodecName;
/*     */   }
/*     */ 
/*     */   public int getImageWidth() {
/* 139 */     return this.imageWidth;
/*     */   }
/*     */   public void setImageWidth(int imageWidth) {
/* 142 */     this.imageWidth = imageWidth;
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/* 146 */     return this.imageHeight;
/*     */   }
/*     */   public void setImageHeight(int imageHeight) {
/* 149 */     this.imageHeight = imageHeight;
/*     */   }
/*     */ 
/*     */   public int getAudioChannels() {
/* 153 */     return this.audioChannels;
/*     */   }
/*     */   public void setAudioChannels(int audioChannels) {
/* 156 */     this.audioChannels = audioChannels;
/*     */   }
/*     */ 
/*     */   public int getPixelFormat() {
/* 160 */     return this.pixelFormat;
/*     */   }
/*     */   public void setPixelFormat(int pixelFormat) {
/* 163 */     this.pixelFormat = pixelFormat;
/*     */   }
/*     */ 
/*     */   public int getVideoCodec() {
/* 167 */     return this.videoCodec;
/*     */   }
/*     */   public void setVideoCodec(int videoCodec) {
/* 170 */     this.videoCodec = videoCodec;
/*     */   }
/*     */ 
/*     */   public int getVideoBitrate() {
/* 174 */     return this.videoBitrate;
/*     */   }
/*     */   public void setVideoBitrate(int videoBitrate) {
/* 177 */     this.videoBitrate = videoBitrate;
/*     */   }
/*     */ 
/*     */   public double getFrameRate() {
/* 181 */     return this.frameRate;
/*     */   }
/*     */   public void setFrameRate(double frameRate) {
/* 184 */     this.frameRate = frameRate;
/*     */   }
/*     */ 
/*     */   public double getVideoQuality() {
/* 188 */     return this.videoQuality;
/*     */   }
/*     */   public void setVideoQuality(double videoQuality) {
/* 191 */     this.videoQuality = videoQuality;
/*     */   }
/*     */ 
/*     */   public int getSampleFormat() {
/* 195 */     return this.sampleFormat;
/*     */   }
/*     */   public void setSampleFormat(int sampleFormat) {
/* 198 */     this.sampleFormat = sampleFormat;
/*     */   }
/*     */ 
/*     */   public int getAudioCodec() {
/* 202 */     return this.audioCodec;
/*     */   }
/*     */   public void setAudioCodec(int audioCodec) {
/* 205 */     this.audioCodec = audioCodec;
/*     */   }
/*     */ 
/*     */   public int getAudioBitrate() {
/* 209 */     return this.audioBitrate;
/*     */   }
/*     */   public void setAudioBitrate(int audioBitrate) {
/* 212 */     this.audioBitrate = audioBitrate;
/*     */   }
/*     */ 
/*     */   public int getSampleRate() {
/* 216 */     return this.sampleRate;
/*     */   }
/*     */   public void setSampleRate(int sampleRate) {
/* 219 */     this.sampleRate = sampleRate;
/*     */   }
/*     */ 
/*     */   public double getAudioQuality() {
/* 223 */     return this.audioQuality;
/*     */   }
/*     */   public void setAudioQuality(double audioQuality) {
/* 226 */     this.audioQuality = audioQuality;
/*     */   }
/*     */ 
/*     */   public boolean isInterleaved() {
/* 230 */     return this.interleaved;
/*     */   }
/*     */   public void setInterleaved(boolean interleaved) {
/* 233 */     this.interleaved = interleaved;
/*     */   }
/*     */ 
/*     */   public String getVideoOption(String key) {
/* 237 */     return (String)this.videoOptions.get(key);
/*     */   }
/*     */   public void setVideoOption(String key, String value) {
/* 240 */     this.videoOptions.put(key, value);
/*     */   }
/*     */ 
/*     */   public String getAudioOption(String key) {
/* 244 */     return (String)this.audioOptions.get(key);
/*     */   }
/*     */   public void setAudioOption(String key, String value) {
/* 247 */     this.audioOptions.put(key, value);
/*     */   }
/*     */ 
/*     */   public int getFrameNumber() {
/* 251 */     return this.frameNumber;
/*     */   }
/*     */   public void setFrameNumber(int frameNumber) {
/* 254 */     this.frameNumber = frameNumber;
/*     */   }
/*     */ 
/*     */   public long getTimestamp() {
/* 258 */     return this.timestamp;
/*     */   }
/*     */   public void setTimestamp(long timestamp) {
/* 261 */     this.timestamp = timestamp;
/*     */   }
/*     */ 
/*     */   public abstract void start()
/*     */     throws FrameRecorder.Exception;
/*     */ 
/*     */   public abstract void stop() throws FrameRecorder.Exception;
/*     */ 
/*     */   public abstract boolean record(opencv_core.IplImage paramIplImage) throws FrameRecorder.Exception;
/*     */ 
/*     */   public boolean record(Buffer[] samples) throws FrameRecorder.Exception
/*     */   {
/* 273 */     return record(0, samples);
/*     */   }
/*     */   public boolean record(int sampleRate, Buffer[] samples) throws FrameRecorder.Exception {
/* 276 */     throw new UnsupportedOperationException("This FrameRecorder does not support audio.");
/*     */   }
/*     */   public void record(Frame frame) throws FrameRecorder.Exception {
/* 279 */     if ((frame == null) || ((frame.image == null) && (frame.samples == null))) {
/* 280 */       record((opencv_core.IplImage)null);
/*     */     } else {
/* 282 */       if (frame.image != null) {
/* 283 */         frame.keyFrame = record(frame.image);
/*     */       }
/* 285 */       if (frame.samples != null)
/* 286 */         frame.keyFrame = record(frame.sampleRate, frame.samples);
/*     */     }
/*     */   }
/*     */ 
/*     */   public abstract void release()
/*     */     throws FrameRecorder.Exception;
/*     */ 
/*     */   public static class Exception extends Exception
/*     */   {
/*     */     public Exception(String message)
/*     */     {
/* 265 */       super(); } 
/* 266 */     public Exception(String message, Throwable cause) { super(cause); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.FrameRecorder
 * JD-Core Version:    0.6.2
 */