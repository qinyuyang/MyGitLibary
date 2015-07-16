/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_calib3d;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ 
/*     */ public class MarkedPlane
/*     */ {
/*  97 */   private Marker[] markers = null;
/*     */   private opencv_core.CvMat prewarp;
/* 102 */   private opencv_core.IplImage planeImage = null; private opencv_core.IplImage superPlaneImage = null;
/*     */   private opencv_core.CvScalar foregroundColor;
/*     */   private opencv_core.CvScalar backgroundColor;
/*     */   private ThreadLocal<opencv_core.CvMat> localSrcPts;
/*     */   private ThreadLocal<opencv_core.CvMat> localDstPts;
/* 170 */   private static ThreadLocal<opencv_core.CvMat> tempWarp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/*     */   public MarkedPlane(int width, int height, Marker[] planeMarkers, double superScale)
/*     */   {
/*  34 */     this(width, height, planeMarkers, false, opencv_core.CvScalar.BLACK, opencv_core.CvScalar.WHITE, superScale);
/*     */   }
/*     */ 
/*     */   public MarkedPlane(int width, int height, Marker[] markers, boolean initPrewarp, opencv_core.CvScalar foregroundColor, opencv_core.CvScalar backgroundColor, double superScale) {
/*  38 */     this.markers = markers;
/*  39 */     this.foregroundColor = foregroundColor;
/*  40 */     this.backgroundColor = backgroundColor;
/*     */ 
/*  45 */     this.prewarp = null;
/*     */ 
/*  49 */     if (initPrewarp) {
/*  50 */       this.prewarp = opencv_core.CvMat.create(3, 3);
/*  51 */       double minx = 1.7976931348623157E+308D; double miny = 1.7976931348623157E+308D;
/*  52 */       double maxx = 4.9E-324D; double maxy = 4.9E-324D;
/*  53 */       for (Marker m : markers) {
/*  54 */         double[] c = m.corners;
/*  55 */         minx = Math.min(Math.min(Math.min(Math.min(minx, c[0]), c[2]), c[4]), c[6]);
/*  56 */         miny = Math.min(Math.min(Math.min(Math.min(miny, c[1]), c[3]), c[5]), c[7]);
/*  57 */         maxx = Math.max(Math.max(Math.max(Math.max(maxx, c[0]), c[2]), c[4]), c[6]);
/*  58 */         maxy = Math.max(Math.max(Math.max(Math.max(maxy, c[1]), c[3]), c[5]), c[7]);
/*     */       }
/*  60 */       double aspect = (maxx - minx) / (maxy - miny);
/*  61 */       if (aspect > width / height) {
/*  62 */         double h = width / aspect;
/*     */ 
/*  67 */         JavaCV.getPerspectiveTransform(new double[] { minx, miny, maxx, miny, maxx, maxy, minx, maxy }, new double[] { 0.0D, height - h, width, height - h, width, height, 0.0D, height }, this.prewarp);
/*     */       }
/*     */       else
/*     */       {
/*  71 */         double w = height * aspect;
/*     */ 
/*  76 */         JavaCV.getPerspectiveTransform(new double[] { minx, miny, maxx, miny, maxx, maxy, minx, maxy }, new double[] { 0.0D, 0.0D, w, 0.0D, w, height, 0.0D, height }, this.prewarp);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  82 */     if ((width > 0) && (height > 0)) {
/*  83 */       this.planeImage = opencv_core.IplImage.create(width, height, 8, 1);
/*  84 */       if (superScale == 1.0D)
/*  85 */         this.superPlaneImage = null;
/*     */       else {
/*  87 */         this.superPlaneImage = opencv_core.IplImage.create((int)Math.ceil(width * superScale), (int)Math.ceil(height * superScale), 8, 1);
/*     */       }
/*     */ 
/*  90 */       setPrewarp(this.prewarp);
/*     */     }
/*     */ 
/*  93 */     this.localSrcPts = opencv_core.CvMat.createThreadLocal(markers.length * 4, 2);
/*  94 */     this.localDstPts = opencv_core.CvMat.createThreadLocal(markers.length * 4, 2);
/*     */   }
/*     */ 
/*     */   public opencv_core.CvScalar getForegroundColor()
/*     */   {
/* 108 */     return this.foregroundColor;
/*     */   }
/*     */   public void setForegroundColor(opencv_core.CvScalar foregroundColor) {
/* 111 */     this.foregroundColor = foregroundColor;
/* 112 */     setPrewarp(this.prewarp);
/*     */   }
/*     */ 
/*     */   public opencv_core.CvScalar getBackgroundColor() {
/* 116 */     return this.backgroundColor;
/*     */   }
/*     */   public void setBackgroundColor(opencv_core.CvScalar backgroundColor) {
/* 119 */     this.backgroundColor = backgroundColor;
/* 120 */     setPrewarp(this.prewarp);
/*     */   }
/*     */ 
/*     */   public Marker[] getMarkers() {
/* 124 */     return this.markers;
/*     */   }
/*     */   public void setColors(opencv_core.CvScalar foregroundColor, opencv_core.CvScalar backgroundColor) {
/* 127 */     this.foregroundColor = foregroundColor;
/* 128 */     this.backgroundColor = backgroundColor;
/* 129 */     setPrewarp(this.prewarp);
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat getPrewarp() {
/* 133 */     return this.prewarp;
/*     */   }
/*     */   public void setPrewarp(opencv_core.CvMat prewarp) {
/* 136 */     this.prewarp = prewarp;
/* 137 */     if (this.superPlaneImage == null)
/* 138 */       opencv_core.cvSet(this.planeImage, this.backgroundColor);
/*     */     else {
/* 140 */       opencv_core.cvSet(this.superPlaneImage, this.backgroundColor);
/*     */     }
/* 142 */     for (int i = 0; i < this.markers.length; i++) {
/* 143 */       if (this.superPlaneImage == null)
/* 144 */         this.markers[i].draw(this.planeImage, this.foregroundColor, 1.0D, prewarp);
/*     */       else {
/* 146 */         this.markers[i].draw(this.superPlaneImage, this.foregroundColor, this.superPlaneImage.width() / this.planeImage.width(), prewarp);
/*     */       }
/*     */     }
/*     */ 
/* 150 */     if (this.superPlaneImage != null)
/* 151 */       opencv_imgproc.cvResize(this.superPlaneImage, this.planeImage, 3);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getImage()
/*     */   {
/* 157 */     return this.planeImage;
/*     */   }
/*     */   public int getWidth() {
/* 160 */     return this.planeImage.width();
/*     */   }
/*     */   public int getHeight() {
/* 163 */     return this.planeImage.height();
/*     */   }
/*     */ 
/*     */   public double getTotalWarp(Marker[] imagedMarkers, opencv_core.CvMat totalWarp) {
/* 167 */     return getTotalWarp(imagedMarkers, totalWarp, false);
/*     */   }
/*     */ 
/*     */   public double getTotalWarp(Marker[] imagedMarkers, opencv_core.CvMat totalWarp, boolean useCenters)
/*     */   {
/* 172 */     double rmse = (1.0D / 0.0D);
/* 173 */     int pointsPerMarker = useCenters ? 1 : 4;
/*     */ 
/* 175 */     opencv_core.CvMat srcPts = (opencv_core.CvMat)this.localSrcPts.get(); srcPts.rows(this.markers.length * pointsPerMarker);
/* 176 */     opencv_core.CvMat dstPts = (opencv_core.CvMat)this.localDstPts.get(); dstPts.rows(this.markers.length * pointsPerMarker);
/*     */ 
/* 178 */     int numPoints = 0;
/* 179 */     for (Marker m1 : this.markers) {
/* 180 */       for (Marker m2 : imagedMarkers) {
/* 181 */         if (m1.id == m2.id) {
/* 182 */           if (useCenters) {
/* 183 */             srcPts.put(numPoints * 2, m1.getCenter());
/* 184 */             dstPts.put(numPoints * 2, m2.getCenter());
/*     */           } else {
/* 186 */             srcPts.put(numPoints * 2, m1.corners);
/* 187 */             dstPts.put(numPoints * 2, m2.corners);
/*     */           }
/* 189 */           numPoints += pointsPerMarker;
/* 190 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 195 */     if ((numPoints > 4) || ((srcPts.rows() == 4) && (numPoints == 4)))
/*     */     {
/* 197 */       srcPts.rows(numPoints); dstPts.rows(numPoints);
/* 198 */       if (numPoints == 4)
/* 199 */         JavaCV.getPerspectiveTransform(srcPts.get(), dstPts.get(), totalWarp);
/*     */       else {
/* 201 */         opencv_calib3d.cvFindHomography(srcPts, dstPts, totalWarp);
/*     */       }
/*     */ 
/* 205 */       srcPts.cols(1); srcPts.type(6, 2);
/* 206 */       dstPts.cols(1); dstPts.type(6, 2);
/* 207 */       opencv_core.cvPerspectiveTransform(srcPts, srcPts, totalWarp);
/* 208 */       srcPts.cols(2); srcPts.type(6, 1);
/* 209 */       dstPts.cols(2); dstPts.type(6, 1);
/*     */ 
/* 211 */       rmse = 0.0D;
/* 212 */       for (int i = 0; i < numPoints; i++) {
/* 213 */         double dx = dstPts.get(i * 2) - srcPts.get(i * 2);
/* 214 */         double dy = dstPts.get(i * 2 + 1) - srcPts.get(i * 2 + 1);
/* 215 */         rmse += dx * dx + dy * dy;
/*     */       }
/* 217 */       rmse = Math.sqrt(rmse / numPoints);
/*     */ 
/* 220 */       if (this.prewarp != null)
/*     */       {
/* 222 */         opencv_core.CvMat tempWarp = (opencv_core.CvMat)tempWarp3x3.get();
/* 223 */         opencv_core.cvInvert(this.prewarp, tempWarp);
/* 224 */         opencv_core.cvMatMul(totalWarp, tempWarp, totalWarp);
/*     */       }
/*     */     }
/*     */ 
/* 228 */     return rmse;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.MarkedPlane
 * JD-Core Version:    0.6.2
 */