/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*    */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*    */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.ByteOrder;
/*    */ import java.nio.DoubleBuffer;
/*    */ 
/*    */ public abstract interface ImageTransformer
/*    */ {
/*    */   public abstract Parameters createParameters();
/*    */ 
/*    */   public abstract void transform(Data[] paramArrayOfData, opencv_core.CvRect paramCvRect, Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean);
/*    */ 
/*    */   public abstract void transform(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, Parameters paramParameters, boolean paramBoolean);
/*    */ 
/*    */   public static abstract interface Parameters extends Cloneable
/*    */   {
/*    */     public abstract int size();
/*    */ 
/*    */     public abstract double[] get();
/*    */ 
/*    */     public abstract double get(int paramInt);
/*    */ 
/*    */     public abstract void set(double[] paramArrayOfDouble);
/*    */ 
/*    */     public abstract void set(int paramInt, double paramDouble);
/*    */ 
/*    */     public abstract void set(Parameters paramParameters);
/*    */ 
/*    */     public abstract void reset(boolean paramBoolean);
/*    */ 
/*    */     public abstract double getConstraintError();
/*    */ 
/*    */     public abstract void compose(Parameters paramParameters1, boolean paramBoolean1, Parameters paramParameters2, boolean paramBoolean2);
/*    */ 
/*    */     public abstract boolean preoptimize();
/*    */ 
/*    */     public abstract double[] getSubspace();
/*    */ 
/*    */     public abstract void setSubspace(double[] paramArrayOfDouble);
/*    */ 
/*    */     public abstract Parameters clone();
/*    */   }
/*    */ 
/*    */   public static class Data
/*    */   {
/*    */     public opencv_core.IplImage srcImg;
/*    */     public opencv_core.IplImage subImg;
/*    */     public opencv_core.IplImage srcDotImg;
/*    */     public opencv_core.IplImage mask;
/*    */     public double zeroThreshold;
/*    */     public double outlierThreshold;
/*    */     public int pyramidLevel;
/*    */     public opencv_core.IplImage transImg;
/*    */     public opencv_core.IplImage dstImg;
/*    */     public int dstCount;
/*    */     public int dstCountZero;
/*    */     public int dstCountOutlier;
/*    */     public double srcDstDot;
/*    */     public DoubleBuffer dstDstDot;
/*    */ 
/*    */     public Data()
/*    */     {
/* 36 */       this(null, null, null, null, 0.0D, 0.0D, 0, null, null, 0);
/*    */     }
/*    */ 
/*    */     public Data(opencv_core.IplImage srcImg, opencv_core.IplImage subImg, opencv_core.IplImage srcDotImg, opencv_core.IplImage mask, double zeroThreshold, double outlierThreshold, int pyramidLevel, opencv_core.IplImage transImg, opencv_core.IplImage dstImg, int dstDstDotLength) {
/* 40 */       this.srcImg = srcImg;
/* 41 */       this.subImg = subImg;
/* 42 */       this.srcDotImg = srcDotImg;
/* 43 */       this.mask = mask;
/* 44 */       this.zeroThreshold = zeroThreshold;
/* 45 */       this.outlierThreshold = outlierThreshold;
/* 46 */       this.pyramidLevel = pyramidLevel;
/* 47 */       this.transImg = transImg;
/* 48 */       this.dstImg = dstImg;
/* 49 */       this.dstDstDot = (dstDstDotLength == 0 ? null : ByteBuffer.allocateDirect(dstDstDotLength * 8).order(ByteOrder.nativeOrder()).asDoubleBuffer());
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ImageTransformer
 * JD-Core Version:    0.6.2
 */