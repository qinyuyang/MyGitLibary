/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.annotation.ByRef;
/*     */ import com.googlecode.javacpp.annotation.MemberSetter;
/*     */ import com.googlecode.javacpp.annotation.Name;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ import com.googlecode.javacv.Parallel;
/*     */ import com.googlecode.javacv.Parallel.Looper;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @Properties(inherit={opencv_core.class}, value={@com.googlecode.javacpp.annotation.Platform(define={"MAX_SIZE 16", "CV_INLINE static inline"}, include={"cvkernels.h"}, options={"fastfpu"})})
/*     */ public class cvkernels
/*     */ {
/* 103 */   private static ThreadLocal<ParallelData[]> parallelData = new ThreadLocal() {
/*     */     protected cvkernels.ParallelData[] initialValue() {
/* 105 */       cvkernels.ParallelData[] pd = new cvkernels.ParallelData[Parallel.getNumThreads()];
/* 106 */       for (int i = 0; i < pd.length; i++) {
/* 107 */         pd[i] = new cvkernels.ParallelData(null);
/*     */       }
/* 109 */       return pd;
/*     */     }
/* 103 */   };
/*     */ 
/*     */   public static native void multiWarpColorTransform32F(KernelData paramKernelData, int paramInt, opencv_core.CvRect paramCvRect, opencv_core.CvScalar paramCvScalar);
/*     */ 
/*     */   public static native void multiWarpColorTransform8U(KernelData paramKernelData, int paramInt, opencv_core.CvRect paramCvRect, opencv_core.CvScalar paramCvScalar);
/*     */ 
/*     */   public static void multiWarpColorTransform(KernelData data, opencv_core.CvRect roi, final opencv_core.CvScalar fillColor)
/*     */   {
/* 116 */     final int size = data.capacity();
/* 117 */     ParallelData[] pd = (ParallelData[])parallelData.get();
/*     */ 
/* 120 */     for (int i = 0; i < pd.length; i++) {
/* 121 */       if ((pd[i].data == null) || (pd[i].data.capacity() < size)) {
/* 122 */         pd[i].data = new KernelData(size);
/* 123 */         for (int j = 0; j < size; j++) {
/* 124 */           KernelData d = pd[i].data.position(j);
/* 125 */           data.position(j);
/* 126 */           if (data.dstDstDot() != null) {
/* 127 */             d.dstDstDot(ByteBuffer.allocateDirect(data.dstDstDot().capacity() * 8).order(ByteOrder.nativeOrder()).asDoubleBuffer());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 132 */       for (int j = 0; j < size; j++) {
/* 133 */         KernelData d = pd[i].data.position(j);
/* 134 */         d.put(data.position(j));
/* 135 */         d.dstDstDot(d.dstDstDot());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 140 */     opencv_core.IplImage img = data.position(0).srcImg();
/* 141 */     final int depth = img.depth();
/*     */     int h;
/*     */     final int x;
/*     */     int y;
/*     */     final int w;
/*     */     int h;
/* 143 */     if (roi != null) {
/* 144 */       int x = roi.x(); int y = roi.y();
/* 145 */       int w = roi.width(); h = roi.height();
/*     */     } else {
/* 147 */       x = 0; y = 0;
/* 148 */       w = img.width(); h = img.height();
/*     */     }
/* 150 */     Parallel.loop(y, y + h, pd.length, new Parallel.Looper() {
/*     */       public void loop(int from, int to, int looperID) {
/* 152 */         opencv_core.CvRect r = this.val$pd[looperID].roi.x(x).y(from).width(w).height(to - from);
/* 153 */         if (depth == 32)
/* 154 */           cvkernels.multiWarpColorTransform32F(this.val$pd[looperID].data.position(0), size, r, fillColor);
/* 155 */         else if (depth == 8) {
/* 156 */           cvkernels.multiWarpColorTransform8U(this.val$pd[looperID].data.position(0), size, r, fillColor);
/*     */         }
/* 158 */         else if (!$assertionsDisabled) throw new AssertionError();
/*     */       }
/*     */     });
/* 163 */     for (int i = 0; i < size; i++) {
/* 164 */       int dstCount = 0;
/* 165 */       int dstCountZero = 0;
/* 166 */       int dstCountOutlier = 0;
/* 167 */       double srcDstDot = 0.0D;
/* 168 */       double[] dstDstDot = null;
/* 169 */       if (data.dstDstDot() != null) {
/* 170 */         dstDstDot = new double[data.dstDstDot().capacity()];
/*     */       }
/* 172 */       for (int j = 0; j < pd.length; j++) {
/* 173 */         KernelData d = pd[j].data.position(i);
/* 174 */         dstCount += d.dstCount();
/* 175 */         dstCountZero += d.dstCountZero();
/* 176 */         dstCountOutlier += d.dstCountOutlier();
/* 177 */         srcDstDot += d.srcDstDot();
/* 178 */         if ((dstDstDot != null) && (d.dstDstDot() != null)) {
/* 179 */           for (int k = 0; k < dstDstDot.length; k++) {
/* 180 */             dstDstDot[k] += d.dstDstDot().get(k);
/*     */           }
/*     */         }
/*     */       }
/* 184 */       data.position(i);
/* 185 */       data.dstCount(dstCount);
/* 186 */       data.dstCountZero(dstCountZero);
/* 187 */       data.dstCountOutlier(dstCountOutlier);
/* 188 */       data.srcDstDot(srcDstDot);
/* 189 */       if ((dstDstDot != null) && (data.dstDstDot() != null)) {
/* 190 */         data.dstDstDot().position(0);
/* 191 */         data.dstDstDot().put(dstDstDot);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  46 */     Loader.load();
/*     */   }
/*     */ 
/*     */   private static class ParallelData
/*     */   {
/* 100 */     cvkernels.KernelData data = null;
/* 101 */     opencv_core.CvRect roi = new opencv_core.CvRect();
/*     */   }
/*     */ 
/*     */   public static class KernelData extends Pointer
/*     */   {
/*  84 */     private DoubleBuffer[] dstDstDotBuffers = new DoubleBuffer[1];
/*     */ 
/*     */     public KernelData()
/*     */     {
/*  50 */       allocate(); } 
/*  51 */     public KernelData(int size) { allocateArray(size); } 
/*  52 */     public KernelData(Pointer p) { super(); } 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*  57 */     public KernelData position(int position) { return (KernelData)super.position(position); } 
/*     */     public native opencv_core.IplImage srcImg();
/*     */ 
/*     */     public native KernelData srcImg(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native opencv_core.IplImage srcImg2();
/*     */ 
/*     */     public native KernelData srcImg2(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native opencv_core.IplImage subImg();
/*     */ 
/*     */     public native KernelData subImg(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native opencv_core.IplImage srcDotImg();
/*     */ 
/*     */     public native KernelData srcDotImg(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native opencv_core.IplImage mask();
/*     */ 
/*     */     public native KernelData mask(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native double zeroThreshold();
/*     */ 
/*     */     public native KernelData zeroThreshold(double paramDouble);
/*     */ 
/*     */     public native double outlierThreshold();
/*     */ 
/*     */     public native KernelData outlierThreshold(double paramDouble);
/*     */ 
/*     */     public native opencv_core.CvMat H1();
/*     */ 
/*     */     public native KernelData H1(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat H2();
/*     */ 
/*     */     public native KernelData H2(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.CvMat X();
/*     */ 
/*     */     public native KernelData X(opencv_core.CvMat paramCvMat);
/*     */ 
/*     */     public native opencv_core.IplImage transImg();
/*     */ 
/*     */     public native KernelData transImg(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native opencv_core.IplImage dstImg();
/*     */ 
/*     */     public native KernelData dstImg(opencv_core.IplImage paramIplImage);
/*     */ 
/*     */     public native int dstCount();
/*     */ 
/*     */     public native KernelData dstCount(int paramInt);
/*     */ 
/*     */     public native int dstCountZero();
/*     */ 
/*     */     public native KernelData dstCountZero(int paramInt);
/*     */ 
/*     */     public native int dstCountOutlier();
/*     */ 
/*     */     public native KernelData dstCountOutlier(int paramInt);
/*     */ 
/*     */     public native double srcDstDot();
/*     */ 
/*     */     public native KernelData srcDstDot(double paramDouble);
/*     */ 
/*     */     @MemberSetter
/*     */     @Name({"dstDstDot"})
/*     */     private native KernelData setDstDstDot(DoubleBuffer paramDoubleBuffer);
/*     */ 
/*  86 */     public DoubleBuffer dstDstDot() { return this.dstDstDotBuffers[this.position]; }
/*     */ 
/*     */     public KernelData dstDstDot(DoubleBuffer dstDstDot) {
/*  89 */       if (this.dstDstDotBuffers.length < this.capacity) {
/*  90 */         this.dstDstDotBuffers = ((DoubleBuffer[])Arrays.copyOf(this.dstDstDotBuffers, this.capacity));
/*     */       }
/*  92 */       this.dstDstDotBuffers[this.position] = dstDstDot;
/*  93 */       return setDstDstDot(dstDstDot);
/*     */     }
/*     */ 
/*     */     @Name({"operator="})
/*     */     @ByRef
/*     */     private native KernelData put(@ByRef KernelData paramKernelData);
/*     */ 
/*     */     static
/*     */     {
/*  49 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.cvkernels
 * JD-Core Version:    0.6.2
 */