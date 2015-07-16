/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import com.googlecode.javacpp.Loader;
/*    */ import com.googlecode.javacv.cpp.opencv_core;
/*    */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*    */ import com.googlecode.javacv.cpp.opencv_highgui;
/*    */ import com.googlecode.javacv.cpp.opencv_highgui.CvVideoWriter;
/*    */ import java.io.File;
/*    */ 
/*    */ public class OpenCVFrameRecorder extends FrameRecorder
/*    */ {
/* 37 */   private static FrameRecorder.Exception loadingException = null;
/*    */ 
/* 73 */   private static final boolean windows = Loader.getPlatformName().startsWith("windows");
/*    */   private String filename;
/* 75 */   private opencv_highgui.CvVideoWriter writer = null;
/*    */ 
/*    */   public static OpenCVFrameRecorder createDefault(File f, int w, int h)
/*    */     throws FrameRecorder.Exception
/*    */   {
/* 34 */     return new OpenCVFrameRecorder(f, w, h); } 
/* 35 */   public static OpenCVFrameRecorder createDefault(String f, int w, int h) throws FrameRecorder.Exception { return new OpenCVFrameRecorder(f, w, h); }
/*    */ 
/*    */   public static void tryLoad() throws FrameRecorder.Exception
/*    */   {
/* 39 */     if (loadingException != null)
/* 40 */       throw loadingException;
/*    */     try
/*    */     {
/* 43 */       Loader.load(opencv_highgui.class);
/*    */     } catch (Throwable t) {
/* 45 */       throw (OpenCVFrameRecorder.loadingException = new FrameRecorder.Exception("Failed to load " + OpenCVFrameRecorder.class, t));
/*    */     }
/*    */   }
/*    */ 
/*    */   public OpenCVFrameRecorder(File file, int imageWidth, int imageHeight)
/*    */   {
/* 51 */     this(file.getAbsolutePath(), imageWidth, imageHeight);
/*    */   }
/*    */   public OpenCVFrameRecorder(String filename, int imageWidth, int imageHeight) {
/* 54 */     this.filename = filename;
/* 55 */     this.imageWidth = imageWidth;
/* 56 */     this.imageHeight = imageHeight;
/*    */ 
/* 58 */     this.pixelFormat = 1;
/* 59 */     this.videoCodec = (windows ? -1 : opencv_highgui.CV_FOURCC_DEFAULT);
/* 60 */     this.frameRate = 30.0D;
/*    */   }
/*    */   public void release() throws FrameRecorder.Exception {
/* 63 */     if (this.writer != null) {
/* 64 */       opencv_highgui.cvReleaseVideoWriter(this.writer);
/* 65 */       this.writer = null;
/*    */     }
/*    */   }
/*    */ 
/* 69 */   protected void finalize() throws Throwable { super.finalize();
/* 70 */     release();
/*    */   }
/*    */ 
/*    */   public void start()
/*    */     throws FrameRecorder.Exception
/*    */   {
/* 78 */     this.writer = opencv_highgui.cvCreateVideoWriter(this.filename, this.videoCodec, this.frameRate, opencv_core.cvSize(this.imageWidth, this.imageHeight), this.pixelFormat);
/* 79 */     if (this.writer == null)
/* 80 */       throw new FrameRecorder.Exception("cvCreateVideoWriter(): Could not create a writer");
/*    */   }
/*    */ 
/*    */   public void stop() throws FrameRecorder.Exception
/*    */   {
/* 85 */     release();
/*    */   }
/*    */ 
/*    */   public boolean record(opencv_core.IplImage frame) throws FrameRecorder.Exception {
/* 89 */     if (this.writer != null) {
/* 90 */       if (opencv_highgui.cvWriteFrame(this.writer, frame) == 0)
/* 91 */         throw new FrameRecorder.Exception("cvWriteFrame(): Could not record frame");
/*    */     }
/*    */     else {
/* 94 */       throw new FrameRecorder.Exception("Cannot record: There is no writer (Has start() been called?)");
/*    */     }
/* 96 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.OpenCVFrameRecorder
 * JD-Core Version:    0.6.2
 */