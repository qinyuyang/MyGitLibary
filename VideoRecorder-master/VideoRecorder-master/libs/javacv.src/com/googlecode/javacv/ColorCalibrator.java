/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import java.awt.Color;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ColorCalibrator
/*     */ {
/*     */   private ProjectiveDevice device;
/*     */ 
/*     */   public ColorCalibrator(ProjectiveDevice device)
/*     */   {
/*  33 */     this.device = device;
/*     */   }
/*     */ 
/*     */   public double calibrate(Color[] referenceColors, Color[] deviceColors)
/*     */   {
/*  39 */     assert (referenceColors.length == deviceColors.length);
/*     */ 
/*  41 */     int[] order = this.device.getRGBColorOrder();
/*     */ 
/*  44 */     opencv_core.CvMat A = opencv_core.CvMat.create(referenceColors.length * 3, 12);
/*  45 */     opencv_core.CvMat b = opencv_core.CvMat.create(referenceColors.length * 3, 1);
/*  46 */     opencv_core.CvMat x = opencv_core.CvMat.create(12, 1);
/*     */ 
/*  48 */     double gamma = this.device.getSettings().getResponseGamma();
/*     */ 
/*  50 */     for (int i = 0; i < referenceColors.length; i++) {
/*  51 */       float[] dc = deviceColors[i].getRGBColorComponents(null);
/*  52 */       float[] rc = referenceColors[i].getRGBColorComponents(null);
/*     */ 
/*  54 */       double dc1 = Math.pow(dc[order[0]], gamma);
/*  55 */       double dc2 = Math.pow(dc[order[1]], gamma);
/*  56 */       double dc3 = Math.pow(dc[order[2]], gamma);
/*  57 */       for (int j = 0; j < 3; j++) {
/*  58 */         int k = i * 36 + j * 16;
/*  59 */         A.put(k, dc1);
/*  60 */         A.put(k + 1, dc2);
/*  61 */         A.put(k + 2, dc3);
/*  62 */         A.put(k + 3, 1.0D);
/*  63 */         if (j < 2) {
/*  64 */           for (int m = 0; m < 12; m++) {
/*  65 */             A.put(k + 4 + m, 0.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*  70 */       b.put(i * 3, rc[order[0]]);
/*  71 */       b.put(i * 3 + 1, rc[order[1]]);
/*  72 */       b.put(i * 3 + 2, rc[order[2]]);
/*     */     }
/*     */ 
/*  79 */     if (opencv_core.cvSolve(A, b, x, 1) != 1.0D) {
/*  80 */       System.out.println("Error solving.");
/*     */     }
/*     */ 
/*  84 */     opencv_core.CvMat b2 = opencv_core.CvMat.create(b.rows(), 1);
/*  85 */     opencv_core.cvMatMul(A, x, b2);
/*  86 */     double MSE = opencv_core.cvNorm(b, b2) * opencv_core.cvNorm(b, b2) / b.rows();
/*  87 */     double RMSE = Math.sqrt(MSE);
/*  88 */     opencv_core.CvScalar mean = new opencv_core.CvScalar(); opencv_core.CvScalar stddev = new opencv_core.CvScalar();
/*  89 */     opencv_core.cvAvgSdv(b, mean, stddev, null);
/*  90 */     double R2 = 1.0D - MSE / (stddev.val(0) * stddev.val(0));
/*     */ 
/*  94 */     this.device.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
/*  95 */     this.device.additiveLight = opencv_core.CvMat.create(3, 1);
/*  96 */     for (int i = 0; i < 3; i++) {
/*  97 */       double x0 = x.get(i * 4);
/*  98 */       double x1 = x.get(i * 4 + 1);
/*  99 */       double x2 = x.get(i * 4 + 2);
/* 100 */       double x3 = x.get(i * 4 + 3);
/* 101 */       this.device.colorMixingMatrix.put(i * 3, x0);
/* 102 */       this.device.colorMixingMatrix.put(i * 3 + 1, x1);
/* 103 */       this.device.colorMixingMatrix.put(i * 3 + 2, x2);
/* 104 */       this.device.additiveLight.put(i, x3);
/*     */     }
/*     */ 
/* 110 */     this.device.colorR2 = R2;
/* 111 */     return this.device.avgColorErr = RMSE;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ColorCalibrator
 * JD-Core Version:    0.6.2
 */