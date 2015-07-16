/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*    */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*    */ 
/*    */ public abstract interface ImageAligner
/*    */ {
/*    */   public abstract Settings getSettings();
/*    */ 
/*    */   public abstract void setSettings(Settings paramSettings);
/*    */ 
/*    */   public abstract opencv_core.IplImage getTemplateImage();
/*    */ 
/*    */   public abstract void setTemplateImage(opencv_core.IplImage paramIplImage, double[] paramArrayOfDouble);
/*    */ 
/*    */   public abstract opencv_core.IplImage getTargetImage();
/*    */ 
/*    */   public abstract void setTargetImage(opencv_core.IplImage paramIplImage);
/*    */ 
/*    */   public abstract int getPyramidLevel();
/*    */ 
/*    */   public abstract void setPyramidLevel(int paramInt);
/*    */ 
/*    */   public abstract ImageTransformer.Parameters getParameters();
/*    */ 
/*    */   public abstract void setParameters(ImageTransformer.Parameters paramParameters);
/*    */ 
/*    */   public abstract double[] getTransformedRoiPts();
/*    */ 
/*    */   public abstract opencv_core.IplImage getTransformedImage();
/*    */ 
/*    */   public abstract opencv_core.IplImage getResidualImage();
/*    */ 
/*    */   public abstract opencv_core.IplImage getMaskImage();
/*    */ 
/*    */   public abstract double getRMSE();
/*    */ 
/*    */   public abstract opencv_core.CvRect getRoi();
/*    */ 
/*    */   public abstract opencv_core.IplImage[] getImages();
/*    */ 
/*    */   public abstract boolean iterate(double[] paramArrayOfDouble);
/*    */ 
/*    */   public static class Settings extends BaseChildSettings
/*    */     implements Cloneable
/*    */   {
/* 43 */     int pyramidLevelMin = 0;
/* 44 */     int pyramidLevelMax = 4;
/* 45 */     double[] thresholdsZero = { 0.04D, 0.03D, 0.02D, 0.01D, 0.0D };
/* 46 */     double[] thresholdsOutlier = { 0.2D };
/* 47 */     boolean thresholdsMulRMSE = false;
/*    */ 
/*    */     public Settings()
/*    */     {
/*    */     }
/*    */ 
/*    */     public Settings(Settings s)
/*    */     {
/* 36 */       this.pyramidLevelMin = s.pyramidLevelMin;
/* 37 */       this.pyramidLevelMax = s.pyramidLevelMax;
/* 38 */       this.thresholdsZero = s.thresholdsZero;
/* 39 */       this.thresholdsOutlier = s.thresholdsOutlier;
/* 40 */       this.thresholdsMulRMSE = s.thresholdsMulRMSE;
/*    */     }
/*    */ 
/*    */     public int getPyramidLevelMin()
/*    */     {
/* 50 */       return this.pyramidLevelMin;
/*    */     }
/*    */     public void setPyramidLevelMin(int pyramidLevelMin) {
/* 53 */       this.pyramidLevelMin = pyramidLevelMin;
/*    */     }
/*    */ 
/*    */     public int getPyramidLevelMax() {
/* 57 */       return this.pyramidLevelMax;
/*    */     }
/*    */     public void setPyramidLevelMax(int pyramidLevelMax) {
/* 60 */       this.pyramidLevelMax = pyramidLevelMax;
/*    */     }
/*    */ 
/*    */     public double[] getThresholdsZero() {
/* 64 */       return this.thresholdsZero;
/*    */     }
/*    */     public void setThresholdsZero(double[] thresholdsZero) {
/* 67 */       this.thresholdsZero = thresholdsZero;
/*    */     }
/*    */ 
/*    */     public double[] getThresholdsOutlier() {
/* 71 */       return this.thresholdsOutlier;
/*    */     }
/*    */     public void setThresholdsOutlier(double[] thresholdsOutlier) {
/* 74 */       this.thresholdsOutlier = thresholdsOutlier;
/*    */     }
/*    */ 
/*    */     public boolean isThresholdsMulRMSE() {
/* 78 */       return this.thresholdsMulRMSE;
/*    */     }
/*    */     public void setThresholdsMulRMSE(boolean thresholdsMulRMSE) {
/* 81 */       this.thresholdsMulRMSE = thresholdsMulRMSE;
/*    */     }
/*    */ 
/*    */     public Settings clone() {
/* 85 */       return new Settings(this);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ImageAligner
 * JD-Core Version:    0.6.2
 */