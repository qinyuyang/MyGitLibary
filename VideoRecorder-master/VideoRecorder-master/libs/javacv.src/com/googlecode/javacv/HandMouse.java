/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvContour;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSeq;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ 
/*     */ public class HandMouse
/*     */ {
/*     */   private Settings settings;
/* 139 */   private opencv_core.IplImage relativeResidual = null; private opencv_core.IplImage binaryImage = null;
/* 140 */   private opencv_core.CvRect roi = null;
/* 141 */   private opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();
/* 142 */   private int contourPointsSize = 0;
/* 143 */   private opencv_core.CvPoint contourPoints = null;
/* 144 */   private IntBuffer contourPointsBuffer = null;
/* 145 */   private opencv_imgproc.CvMoments moments = new opencv_imgproc.CvMoments();
/* 146 */   private double edgeX = 0.0D; private double edgeY = 0.0D; private double centerX = 0.0D; private double centerY = 0.0D;
/* 147 */   private double imageTipX = -1.0D; private double tipX = -1.0D; private double prevTipX = -1.0D;
/* 148 */   private double imageTipY = -1.0D; private double tipY = -1.0D; private double prevTipY = -1.0D;
/* 149 */   private long tipTime = 0L; private long prevTipTime = 0L;
/* 150 */   private opencv_core.CvPoint pt1 = new opencv_core.CvPoint(); private opencv_core.CvPoint pt2 = new opencv_core.CvPoint();
/* 151 */   private boolean imageUpdateNeeded = false;
/*     */ 
/*     */   public HandMouse()
/*     */   {
/*  37 */     this(new Settings());
/*     */   }
/*     */   public HandMouse(Settings settings) {
/*  40 */     setSettings(settings);
/*     */   }
/*     */ 
/*     */   public Settings getSettings()
/*     */   {
/* 133 */     return this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 136 */     this.settings = settings;
/*     */   }
/*     */ 
/*     */   public void reset()
/*     */   {
/* 154 */     this.tipX = (this.tipY = this.prevTipX = this.prevTipY = -1.0D);
/*     */   }
/*     */ 
/*     */   public void update(opencv_core.IplImage[] images, int pyramidLevel, opencv_core.CvRect roi, double[] roiPts) {
/* 158 */     this.roi = roi;
/*     */ 
/* 163 */     opencv_core.IplImage target = images[1];
/* 164 */     opencv_core.IplImage transformed = images[2];
/* 165 */     opencv_core.IplImage residual = images[3];
/* 166 */     opencv_core.IplImage mask = images[4];
/* 167 */     int width = roi.width();
/* 168 */     int height = roi.height();
/* 169 */     int channels = residual.nChannels();
/* 170 */     this.relativeResidual = opencv_core.IplImage.createIfNotCompatible(this.relativeResidual, mask);
/* 171 */     this.binaryImage = opencv_core.IplImage.createIfNotCompatible(this.binaryImage, mask);
/* 172 */     opencv_core.cvResetImageROI(this.relativeResidual);
/* 173 */     opencv_core.cvResetImageROI(this.binaryImage);
/*     */ 
/* 175 */     double brightnessMin = (channels > 3 ? 3 : channels) * this.settings.brightnessMin;
/* 176 */     double contourEdgeAreaMax = (width + height) / 2 * width * height * this.settings.edgeAreaMax;
/* 177 */     double contourEdgeAreaMin = (width + height) / 2 * width * height * this.settings.edgeAreaMin;
/* 178 */     ByteBuffer maskBuf = mask.getByteBuffer();
/* 179 */     FloatBuffer residualBuf = residual.getFloatBuffer();
/* 180 */     FloatBuffer targetBuf = target.getFloatBuffer();
/* 181 */     FloatBuffer transformedBuf = transformed.getFloatBuffer();
/* 182 */     ByteBuffer relResBuf = this.relativeResidual.getByteBuffer();
/*     */ 
/* 184 */     while ((maskBuf.hasRemaining()) && (residualBuf.hasRemaining()) && (targetBuf.hasRemaining()) && (transformedBuf.hasRemaining()) && (relResBuf.hasRemaining()))
/*     */     {
/* 186 */       byte m = maskBuf.get();
/* 187 */       if (m == 0) {
/* 188 */         residualBuf.position(residualBuf.position() + channels);
/* 189 */         targetBuf.position(targetBuf.position() + channels);
/* 190 */         transformedBuf.position(transformedBuf.position() + channels);
/* 191 */         relResBuf.put((byte)0);
/*     */       } else {
/* 193 */         double relativeNorm = 0.0D;
/* 194 */         double brightness = 0.0D;
/* 195 */         for (int z = 0; z < channels; z++) {
/* 196 */           float r = Math.abs(residualBuf.get());
/* 197 */           float c = targetBuf.get();
/* 198 */           float t = transformedBuf.get();
/* 199 */           if (z < 3) {
/* 200 */             float maxct = Math.max(c, t);
/* 201 */             brightness += maxct;
/* 202 */             relativeNorm = Math.max(r / maxct, relativeNorm);
/*     */           }
/*     */         }
/* 205 */         if (brightness < brightnessMin)
/* 206 */           relResBuf.put((byte)0);
/*     */         else {
/* 208 */           relResBuf.put((byte)(int)Math.round(255.0D / this.settings.thresholdHigh * Math.min(relativeNorm, this.settings.thresholdHigh)));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 214 */     JavaCV.hysteresisThreshold(this.relativeResidual, this.binaryImage, 255.0D, 255.0D * this.settings.thresholdLow / this.settings.thresholdHigh, 255.0D);
/*     */ 
/* 217 */     int roiX = roi.x(); int roiY = roi.y();
/* 218 */     opencv_core.cvSetImageROI(this.binaryImage, roi);
/*     */ 
/* 220 */     if (this.settings.mopIterations > 0) {
/* 221 */       opencv_imgproc.cvMorphologyEx(this.binaryImage, this.binaryImage, null, null, 2, this.settings.mopIterations);
/* 222 */       opencv_imgproc.cvMorphologyEx(this.binaryImage, this.binaryImage, null, null, 3, this.settings.mopIterations);
/*     */     }
/* 224 */     opencv_core.CvSeq contour = new opencv_core.CvContour(null);
/* 225 */     opencv_imgproc.cvFindContours(this.binaryImage, this.storage, contour, Loader.sizeof(opencv_core.CvContour.class), 0, 1);
/*     */ 
/* 227 */     double largestContourEdgeArea = 0.0D;
/* 228 */     opencv_core.CvSeq largestContour = null;
/* 229 */     while ((contour != null) && (!contour.isNull())) {
/* 230 */       this.contourPointsSize = contour.total();
/* 231 */       if ((this.contourPoints == null) || (this.contourPoints.capacity() < this.contourPointsSize)) {
/* 232 */         this.contourPoints = new opencv_core.CvPoint(this.contourPointsSize);
/* 233 */         this.contourPointsBuffer = this.contourPoints.asByteBuffer().asIntBuffer();
/*     */       }
/* 235 */       opencv_core.cvCvtSeqToArray(contour, this.contourPoints.position(0));
/*     */ 
/* 237 */       double[] edgePts = new double[roiPts.length];
/* 238 */       for (int i = 0; i < roiPts.length / 2; i++) {
/* 239 */         edgePts[(2 * i)] = (roiPts[(2 * i)] / (1 << pyramidLevel) - roiX);
/* 240 */         edgePts[(2 * i + 1)] = (roiPts[(2 * i + 1)] / (1 << pyramidLevel) - roiY);
/*     */       }
/*     */ 
/* 243 */       double m00 = 0.0D; double m10 = 0.0D; double m01 = 0.0D;
/* 244 */       for (int i = 0; i < this.contourPointsSize; i++) {
/* 245 */         int x = this.contourPointsBuffer.get(2 * i);
/* 246 */         int y = this.contourPointsBuffer.get(2 * i + 1);
/* 247 */         for (int j = 0; j < roiPts.length / 2; j++) {
/* 248 */           double x1 = edgePts[(2 * j)];
/* 249 */           double y1 = edgePts[(2 * j + 1)];
/* 250 */           double x2 = edgePts[((2 * j + 2) % edgePts.length)];
/* 251 */           double y2 = edgePts[((2 * j + 3) % edgePts.length)];
/* 252 */           double dx = x2 - x1;
/* 253 */           double dy = y2 - y1;
/* 254 */           double d2 = dx * dx + dy * dy;
/* 255 */           double u = ((x - x1) * dx + (y - y1) * dy) / d2;
/*     */ 
/* 257 */           double px = x1 + u * dx;
/* 258 */           double py = y1 + u * dy;
/*     */ 
/* 260 */           dx = px - x;
/* 261 */           dy = py - y;
/* 262 */           d2 = dx * dx + dy * dy;
/* 263 */           if (d2 < 2.0D) {
/* 264 */             m00 += 1.0D;
/* 265 */             m10 += x;
/* 266 */             m01 += y;
/* 267 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 271 */       double contourEdgeArea = m00 * Math.abs(opencv_imgproc.cvContourArea(contour, opencv_core.CV_WHOLE_SEQ, 0));
/* 272 */       if ((contourEdgeArea > contourEdgeAreaMin) && (contourEdgeArea < contourEdgeAreaMax) && (contourEdgeArea > largestContourEdgeArea))
/*     */       {
/* 274 */         largestContourEdgeArea = contourEdgeArea;
/* 275 */         largestContour = contour;
/*     */ 
/* 277 */         double inv_m00 = 1.0D / m00;
/* 278 */         this.edgeX = (m10 * inv_m00);
/* 279 */         this.edgeY = (m01 * inv_m00);
/*     */       }
/* 281 */       contour = contour.h_next();
/*     */     }
/*     */ 
/* 284 */     if (isClick()) {
/* 285 */       this.prevTipX = -1.0D;
/* 286 */       this.prevTipY = -1.0D;
/* 287 */       this.prevTipTime = 0L;
/* 288 */     } else if (!isSteady()) {
/* 289 */       this.prevTipX = this.tipX;
/* 290 */       this.prevTipY = this.tipY;
/* 291 */       this.prevTipTime = System.currentTimeMillis();
/*     */     }
/*     */ 
/* 294 */     if (largestContour == null) {
/* 295 */       this.tipX = -1.0D;
/* 296 */       this.tipY = -1.0D;
/* 297 */       this.tipTime = 0L;
/* 298 */       this.imageUpdateNeeded = false;
/*     */     } else {
/* 300 */       opencv_imgproc.cvMoments(largestContour, this.moments, 0);
/* 301 */       double inv_m00 = 1.0D / this.moments.m00();
/* 302 */       this.centerX = (this.moments.m10() * inv_m00);
/* 303 */       this.centerY = (this.moments.m01() * inv_m00);
/*     */ 
/* 305 */       this.contourPointsSize = largestContour.total();
/* 306 */       opencv_core.cvCvtSeqToArray(largestContour, this.contourPoints.position(0));
/*     */ 
/* 308 */       double tipDist2 = 0.0D;
/* 309 */       int tipIndex = 0;
/* 310 */       for (int i = 0; i < this.contourPointsSize; i++) {
/* 311 */         int x = this.contourPointsBuffer.get(2 * i);
/* 312 */         int y = this.contourPointsBuffer.get(2 * i + 1);
/* 313 */         double dx = this.centerX - this.edgeX;
/* 314 */         double dy = this.centerY - this.edgeY;
/* 315 */         double d2 = dx * dx + dy * dy;
/* 316 */         double u = ((x - this.edgeX) * dx + (y - this.edgeY) * dy) / d2;
/*     */ 
/* 318 */         double px = this.edgeX + u * dx;
/* 319 */         double py = this.edgeY + u * dy;
/*     */ 
/* 321 */         dx = px - this.edgeX;
/* 322 */         dy = py - this.edgeY;
/* 323 */         d2 = dx * dx + dy * dy;
/* 324 */         if (d2 > tipDist2) {
/* 325 */           tipIndex = i;
/* 326 */           tipDist2 = d2;
/*     */         }
/*     */       }
/* 329 */       double a = (this.imageTipX < 0.0D) || (this.imageTipY < 0.0D) ? 1.0D : this.settings.updateAlpha;
/* 330 */       this.imageTipX = (a * this.contourPointsBuffer.get(2 * tipIndex) + (1.0D - a) * this.imageTipX);
/* 331 */       this.imageTipY = (a * this.contourPointsBuffer.get(2 * tipIndex + 1) + (1.0D - a) * this.imageTipY);
/* 332 */       this.tipX = ((this.imageTipX + roiX) * (1 << pyramidLevel));
/* 333 */       this.tipY = ((this.imageTipY + roiY) * (1 << pyramidLevel));
/* 334 */       this.tipTime = System.currentTimeMillis();
/* 335 */       this.imageUpdateNeeded = true;
/*     */     }
/*     */ 
/* 338 */     opencv_core.cvClearMemStorage(this.storage);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getRelativeResidual() {
/* 342 */     return this.relativeResidual;
/*     */   }
/*     */   public opencv_core.IplImage getResultImage() {
/* 345 */     if (this.imageUpdateNeeded) {
/* 346 */       opencv_core.cvSetZero(this.binaryImage);
/* 347 */       opencv_core.cvFillPoly(this.binaryImage, this.contourPoints, new int[] { this.contourPointsSize }, 1, opencv_core.CvScalar.WHITE, 8, 0);
/*     */ 
/* 349 */       this.pt1.put((byte)16, new double[] { this.edgeX, this.edgeY });
/* 350 */       opencv_core.cvCircle(this.binaryImage, this.pt1, 327680, opencv_core.CvScalar.GRAY, 2, 8, 16);
/*     */ 
/* 352 */       this.pt1.put((byte)16, new double[] { this.centerX - 5.0D, this.centerY - 5.0D }); this.pt2.put((byte)16, new double[] { this.centerX + 5.0D, this.centerY + 5.0D });
/* 353 */       opencv_core.cvRectangle(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
/*     */ 
/* 355 */       this.pt1.put((byte)16, new double[] { this.imageTipX - 5.0D, this.imageTipY - 5.0D }); this.pt2.put((byte)16, new double[] { this.imageTipX + 5.0D, this.imageTipY + 5.0D });
/* 356 */       opencv_core.cvLine(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
/* 357 */       this.pt1.put((byte)16, new double[] { this.imageTipX - 5.0D, this.imageTipY + 5.0D }); this.pt2.put((byte)16, new double[] { this.imageTipX + 5.0D, this.imageTipY - 5.0D });
/* 358 */       opencv_core.cvLine(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
/*     */ 
/* 360 */       opencv_core.cvResetImageROI(this.binaryImage);
/* 361 */       this.imageUpdateNeeded = false;
/*     */     }
/* 363 */     return this.binaryImage;
/*     */   }
/*     */ 
/*     */   public double getX() {
/* 367 */     return this.tipX;
/*     */   }
/*     */   public double getY() {
/* 370 */     return this.tipY;
/*     */   }
/*     */ 
/*     */   public boolean isSteady() {
/* 374 */     if ((this.tipX >= 0.0D) && (this.tipY >= 0.0D) && (this.prevTipX >= 0.0D) && (this.prevTipY >= 0.0D)) {
/* 375 */       double dx = this.tipX - this.prevTipX;
/* 376 */       double dy = this.tipY - this.prevTipY;
/* 377 */       int imageSize = (this.roi.width() + this.roi.height()) / 2;
/* 378 */       double steadySize = this.settings.clickSteadySize * imageSize;
/* 379 */       return dx * dx + dy * dy < steadySize * steadySize;
/*     */     }
/* 381 */     return false;
/*     */   }
/*     */   public boolean isClick() {
/* 384 */     return (isSteady()) && (this.tipTime - this.prevTipTime > this.settings.clickSteadyTime);
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  57 */     int mopIterations = 1;
/*  58 */     double clickSteadySize = 0.05D;
/*  59 */     long clickSteadyTime = 250L;
/*  60 */     double edgeAreaMin = 0.001D;
/*  61 */     double edgeAreaMax = 0.1D;
/*  62 */     double thresholdHigh = 0.5D;
/*  63 */     double thresholdLow = 0.25D;
/*  64 */     double brightnessMin = 0.1D;
/*  65 */     double updateAlpha = 0.5D;
/*     */ 
/*     */     public Settings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Settings(Settings s)
/*     */     {
/*  46 */       s.mopIterations = this.mopIterations;
/*  47 */       s.clickSteadySize = this.clickSteadySize;
/*  48 */       s.clickSteadyTime = this.clickSteadyTime;
/*  49 */       s.edgeAreaMin = this.edgeAreaMin;
/*  50 */       s.edgeAreaMax = this.edgeAreaMax;
/*  51 */       s.thresholdHigh = this.thresholdHigh;
/*  52 */       s.thresholdLow = this.thresholdLow;
/*  53 */       s.brightnessMin = this.brightnessMin;
/*  54 */       s.updateAlpha = this.updateAlpha;
/*     */     }
/*     */ 
/*     */     public int getMopIterations()
/*     */     {
/*  68 */       return this.mopIterations;
/*     */     }
/*     */     public void setMopIterations(int mopIterations) {
/*  71 */       this.mopIterations = mopIterations;
/*     */     }
/*     */ 
/*     */     public double getClickSteadySize() {
/*  75 */       return this.clickSteadySize;
/*     */     }
/*     */     public void setClickSteadySize(double clickSteadySize) {
/*  78 */       this.clickSteadySize = clickSteadySize;
/*     */     }
/*     */ 
/*     */     public long getClickSteadyTime() {
/*  82 */       return this.clickSteadyTime;
/*     */     }
/*     */     public void setClickSteadyTime(long clickSteadyTime) {
/*  85 */       this.clickSteadyTime = clickSteadyTime;
/*     */     }
/*     */ 
/*     */     public double getEdgeAreaMin() {
/*  89 */       return this.edgeAreaMin;
/*     */     }
/*     */     public void setEdgeAreaMin(double edgeAreaMin) {
/*  92 */       this.edgeAreaMin = edgeAreaMin;
/*     */     }
/*     */ 
/*     */     public double getEdgeAreaMax() {
/*  96 */       return this.edgeAreaMax;
/*     */     }
/*     */     public void setEdgeAreaMax(double edgeAreaMax) {
/*  99 */       this.edgeAreaMax = edgeAreaMax;
/*     */     }
/*     */ 
/*     */     public double getThresholdHigh() {
/* 103 */       return this.thresholdHigh;
/*     */     }
/*     */     public void setThresholdHigh(double thresholdHigh) {
/* 106 */       this.thresholdHigh = thresholdHigh;
/*     */     }
/*     */ 
/*     */     public double getThresholdLow() {
/* 110 */       return this.thresholdLow;
/*     */     }
/*     */     public void setThresholdLow(double thresholdLow) {
/* 113 */       this.thresholdLow = thresholdLow;
/*     */     }
/*     */ 
/*     */     public double getBrightnessMin() {
/* 117 */       return this.brightnessMin;
/*     */     }
/*     */     public void setBrightnessMin(double brightnessMin) {
/* 120 */       this.brightnessMin = brightnessMin;
/*     */     }
/*     */ 
/*     */     public double getUpdateAlpha() {
/* 124 */       return this.updateAlpha;
/*     */     }
/*     */     public void setUpdateAlpha(double updateAlpha) {
/* 127 */       this.updateAlpha = updateAlpha;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.HandMouse
 * JD-Core Version:    0.6.2
 */