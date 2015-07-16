/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_calib3d;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class GeometricCalibrator
/*     */ {
/*     */   private Settings settings;
/*     */   MarkerDetector markerDetector;
/*     */   private MarkedPlane markedPlane;
/*     */   private ProjectiveDevice projectiveDevice;
/*  88 */   private LinkedList<Marker[]> allObjectMarkers = new LinkedList();
/*  89 */   private LinkedList<Marker[]> allImageMarkers = new LinkedList();
/*  90 */   private opencv_core.IplImage tempImage = null;
/*  91 */   private Marker[] lastDetectedMarkers = null;
/*  92 */   private opencv_core.CvMat warp = opencv_core.CvMat.create(3, 3);
/*  93 */   private opencv_core.CvMat prevWarp = opencv_core.CvMat.create(3, 3);
/*  94 */   private opencv_core.CvMat lastWarp = opencv_core.CvMat.create(3, 3);
/*  95 */   private opencv_core.CvMat warpSrcPts = opencv_core.CvMat.create(1, 4, 6, 2);
/*  96 */   private opencv_core.CvMat warpDstPts = opencv_core.CvMat.create(1, 4, 6, 2);
/*  97 */   private opencv_core.CvMat tempPts = opencv_core.CvMat.create(1, 4, 6, 2);
/*     */ 
/*     */   public GeometricCalibrator(Settings settings, MarkerDetector.Settings detectorSettings, MarkedPlane markedPlane, ProjectiveDevice projectiveDevice)
/*     */   {
/*  41 */     this.settings = settings;
/*  42 */     this.markerDetector = new MarkerDetector(detectorSettings);
/*  43 */     this.markedPlane = markedPlane;
/*  44 */     this.projectiveDevice = projectiveDevice;
/*     */ 
/*  46 */     opencv_core.cvSetIdentity(this.prevWarp);
/*  47 */     opencv_core.cvSetIdentity(this.lastWarp);
/*     */ 
/*  49 */     if (markedPlane != null) {
/*  50 */       int w = markedPlane.getImage().width();
/*  51 */       int h = markedPlane.getImage().height();
/*  52 */       this.warpSrcPts.put(new double[] { 0.0D, 0.0D, w, 0.0D, w, h, 0.0D, h });
/*     */     }
/*     */   }
/*     */ 
/*     */   public MarkerDetector getMarkerDetector()
/*     */   {
/* 100 */     return this.markerDetector;
/*     */   }
/*     */   public MarkedPlane getMarkedPlane() {
/* 103 */     return this.markedPlane;
/*     */   }
/*     */   public ProjectiveDevice getProjectiveDevice() {
/* 106 */     return this.projectiveDevice;
/*     */   }
/*     */ 
/*     */   public LinkedList<Marker[]> getAllObjectMarkers() {
/* 110 */     return this.allObjectMarkers;
/*     */   }
/*     */   public void setAllObjectMarkers(LinkedList<Marker[]> allObjectMarkers) {
/* 113 */     this.allObjectMarkers = allObjectMarkers;
/*     */   }
/*     */ 
/*     */   public LinkedList<Marker[]> getAllImageMarkers() {
/* 117 */     return this.allImageMarkers;
/*     */   }
/*     */   public void setAllImageMarkers(LinkedList<Marker[]> allImageMarkers) {
/* 120 */     this.allImageMarkers = allImageMarkers;
/*     */   }
/*     */ 
/*     */   public Marker[] processImage(opencv_core.IplImage image) {
/* 124 */     this.projectiveDevice.imageWidth = image.width();
/* 125 */     this.projectiveDevice.imageHeight = image.height();
/*     */ 
/* 127 */     boolean whiteMarkers = this.markedPlane.getForegroundColor().magnitude() > this.markedPlane.getBackgroundColor().magnitude();
/*     */ 
/* 129 */     if (image.depth() > 8) {
/* 130 */       if ((this.tempImage == null) || (this.tempImage.width() != image.width()) || (this.tempImage.height() != image.height()))
/*     */       {
/* 133 */         this.tempImage = opencv_core.IplImage.create(image.width(), image.height(), 8, 1, image.origin());
/*     */       }
/*     */ 
/* 136 */       opencv_core.cvConvertScale(image, this.tempImage, 0.00390625D, 0.0D);
/* 137 */       this.lastDetectedMarkers = this.markerDetector.detect(this.tempImage, whiteMarkers);
/*     */     } else {
/* 139 */       this.lastDetectedMarkers = this.markerDetector.detect(image, whiteMarkers);
/*     */     }
/*     */ 
/* 143 */     if (this.lastDetectedMarkers.length < this.markedPlane.getMarkers().length * this.settings.detectedBoardMin) {
/* 144 */       return null;
/*     */     }
/*     */ 
/* 148 */     this.markedPlane.getTotalWarp(this.lastDetectedMarkers, this.warp);
/* 149 */     opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.warpDstPts, this.warp);
/* 150 */     opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.tempPts, this.prevWarp);
/* 151 */     double rmsePrev = opencv_core.cvNorm(this.warpDstPts, this.tempPts);
/* 152 */     opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.tempPts, this.lastWarp);
/* 153 */     double rmseLast = opencv_core.cvNorm(this.warpDstPts, this.tempPts);
/*     */ 
/* 156 */     opencv_core.cvCopy(this.warp, this.prevWarp);
/*     */ 
/* 159 */     int imageSize = (image.width() + image.height()) / 2;
/* 160 */     if ((rmsePrev < this.settings.patternSteadySize * imageSize) && (rmseLast > this.settings.patternMovedSize * imageSize))
/*     */     {
/* 162 */       return this.lastDetectedMarkers;
/*     */     }
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   public void drawMarkers(opencv_core.IplImage image)
/*     */   {
/* 169 */     this.markerDetector.draw(image, this.lastDetectedMarkers);
/*     */   }
/*     */ 
/*     */   public void addMarkers() {
/* 173 */     addMarkers(this.markedPlane.getMarkers(), this.lastDetectedMarkers);
/*     */   }
/*     */   public void addMarkers(Marker[] imageMarkers) {
/* 176 */     addMarkers(this.markedPlane.getMarkers(), imageMarkers);
/*     */   }
/*     */ 
/*     */   public void addMarkers(Marker[] objectMarkers, Marker[] imageMarkers) {
/* 180 */     int maxLength = Math.min(objectMarkers.length, imageMarkers.length);
/* 181 */     Marker[] om = new Marker[maxLength];
/* 182 */     Marker[] im = new Marker[maxLength];
/* 183 */     int i = 0;
/* 184 */     for (Marker m1 : objectMarkers) {
/* 185 */       for (Marker m2 : imageMarkers) {
/* 186 */         if (m1.id == m2.id) {
/* 187 */           om[i] = m1;
/* 188 */           im[i] = m2;
/* 189 */           i++;
/* 190 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 194 */     if (i < maxLength) {
/* 195 */       om = (Marker[])Arrays.copyOf(om, i);
/* 196 */       im = (Marker[])Arrays.copyOf(im, i);
/*     */     }
/* 198 */     this.allObjectMarkers.add(om);
/* 199 */     this.allImageMarkers.add(im);
/*     */ 
/* 202 */     opencv_core.cvCopy(this.prevWarp, this.lastWarp);
/*     */   }
/*     */ 
/*     */   public int getImageCount() {
/* 206 */     assert (this.allObjectMarkers.size() == this.allImageMarkers.size());
/* 207 */     return this.allObjectMarkers.size();
/*     */   }
/*     */ 
/*     */   private opencv_core.CvMat[] getPoints(boolean useCenters)
/*     */   {
/* 213 */     assert (this.allObjectMarkers.size() == this.allImageMarkers.size());
/* 214 */     Iterator i1 = this.allObjectMarkers.iterator();
/* 215 */     Iterator i2 = this.allImageMarkers.iterator();
/* 216 */     opencv_core.CvMat pointCounts = opencv_core.CvMat.create(1, this.allImageMarkers.size(), 4, 1);
/* 217 */     IntBuffer pointCountsBuf = pointCounts.getIntBuffer();
/* 218 */     int totalPointCount = 0;
/* 219 */     while ((i1.hasNext()) && (i2.hasNext())) {
/* 220 */       Marker[] m1 = (Marker[])i1.next();
/* 221 */       Marker[] m2 = (Marker[])i2.next();
/* 222 */       assert (m1.length == m2.length);
/* 223 */       int n = m1.length * (useCenters ? 1 : 4);
/* 224 */       pointCountsBuf.put(n);
/* 225 */       totalPointCount += n;
/*     */     }
/* 227 */     i1 = this.allObjectMarkers.iterator();
/* 228 */     i2 = this.allImageMarkers.iterator();
/* 229 */     opencv_core.CvMat objectPoints = opencv_core.CvMat.create(1, totalPointCount, 5, 3);
/* 230 */     opencv_core.CvMat imagePoints = opencv_core.CvMat.create(1, totalPointCount, 5, 2);
/* 231 */     FloatBuffer objectPointsBuf = objectPoints.getFloatBuffer();
/* 232 */     FloatBuffer imagePointsBuf = imagePoints.getFloatBuffer();
/* 233 */     while ((i1.hasNext()) && (i2.hasNext())) {
/* 234 */       Marker[] m1 = (Marker[])i1.next();
/* 235 */       Marker[] m2 = (Marker[])i2.next();
/* 236 */       for (int j = 0; j < m1.length; j++) {
/* 237 */         if (useCenters) {
/* 238 */           double[] c1 = m1[j].getCenter();
/* 239 */           objectPointsBuf.put((float)c1[0]);
/* 240 */           objectPointsBuf.put((float)c1[1]);
/* 241 */           objectPointsBuf.put(0.0F);
/*     */ 
/* 243 */           double[] c2 = m2[j].getCenter();
/* 244 */           imagePointsBuf.put((float)c2[0]);
/* 245 */           imagePointsBuf.put((float)c2[1]);
/*     */         } else {
/* 247 */           for (int k = 0; k < 4; k++) {
/* 248 */             objectPointsBuf.put((float)m1[j].corners[(2 * k)]);
/* 249 */             objectPointsBuf.put((float)m1[j].corners[(2 * k + 1)]);
/* 250 */             objectPointsBuf.put(0.0F);
/*     */ 
/* 252 */             imagePointsBuf.put((float)m2[j].corners[(2 * k)]);
/* 253 */             imagePointsBuf.put((float)m2[j].corners[(2 * k + 1)]);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 259 */     return new opencv_core.CvMat[] { objectPoints, imagePoints, pointCounts };
/*     */   }
/*     */ 
/*     */   public static double[] computeReprojectionError(opencv_core.CvMat object_points, opencv_core.CvMat image_points, opencv_core.CvMat point_counts, opencv_core.CvMat camera_matrix, opencv_core.CvMat dist_coeffs, opencv_core.CvMat rot_vects, opencv_core.CvMat trans_vects, opencv_core.CvMat per_view_errors)
/*     */   {
/* 266 */     opencv_core.CvMat image_points2 = opencv_core.CvMat.create(image_points.rows(), image_points.cols(), image_points.type());
/*     */ 
/* 269 */     int image_count = rot_vects.rows(); int points_so_far = 0;
/* 270 */     double total_err = 0.0D; double max_err = 0.0D;
/*     */ 
/* 272 */     opencv_core.CvMat object_points_i = new opencv_core.CvMat();
/* 273 */     opencv_core.CvMat image_points_i = new opencv_core.CvMat();
/* 274 */     opencv_core.CvMat image_points2_i = new opencv_core.CvMat();
/* 275 */     IntBuffer point_counts_buf = point_counts.getIntBuffer();
/* 276 */     opencv_core.CvMat rot_vect = new opencv_core.CvMat(); opencv_core.CvMat trans_vect = new opencv_core.CvMat();
/*     */ 
/* 278 */     for (int i = 0; i < image_count; i++) {
/* 279 */       object_points_i.reset();
/* 280 */       image_points_i.reset();
/* 281 */       image_points2_i.reset();
/* 282 */       int point_count = point_counts_buf.get(i);
/*     */ 
/* 284 */       opencv_core.cvGetCols(object_points, object_points_i, points_so_far, points_so_far + point_count);
/*     */ 
/* 286 */       opencv_core.cvGetCols(image_points, image_points_i, points_so_far, points_so_far + point_count);
/*     */ 
/* 288 */       opencv_core.cvGetCols(image_points2, image_points2_i, points_so_far, points_so_far + point_count);
/*     */ 
/* 290 */       points_so_far += point_count;
/*     */ 
/* 292 */       opencv_core.cvGetRows(rot_vects, rot_vect, i, i + 1, 1);
/* 293 */       opencv_core.cvGetRows(trans_vects, trans_vect, i, i + 1, 1);
/*     */ 
/* 295 */       opencv_calib3d.cvProjectPoints2(object_points_i, rot_vect, trans_vect, camera_matrix, dist_coeffs, image_points2_i);
/*     */ 
/* 297 */       double err = opencv_core.cvNorm(image_points_i, image_points2_i);
/* 298 */       err *= err;
/* 299 */       if (per_view_errors != null)
/* 300 */         per_view_errors.put(i, Math.sqrt(err / point_count));
/* 301 */       total_err += err;
/*     */ 
/* 303 */       for (int j = 0; j < point_count; j++) {
/* 304 */         double x1 = image_points_i.get(0, j, 0);
/* 305 */         double y1 = image_points_i.get(0, j, 1);
/* 306 */         double x2 = image_points2_i.get(0, j, 0);
/* 307 */         double y2 = image_points2_i.get(0, j, 1);
/* 308 */         double dx = x1 - x2;
/* 309 */         double dy = y1 - y2;
/* 310 */         err = Math.sqrt(dx * dx + dy * dy);
/* 311 */         if (err > max_err) {
/* 312 */           max_err = err;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 317 */     return new double[] { Math.sqrt(total_err / points_so_far), max_err };
/*     */   }
/*     */ 
/*     */   public double[] calibrate(boolean useCenters) {
/* 321 */     ProjectiveDevice d = this.projectiveDevice;
/* 322 */     ProjectiveDevice.CalibrationSettings dsettings = (ProjectiveDevice.CalibrationSettings)d.getSettings();
/*     */ 
/* 324 */     if (d.cameraMatrix == null) {
/* 325 */       d.cameraMatrix = opencv_core.CvMat.create(3, 3);
/* 326 */       opencv_core.cvSetZero(d.cameraMatrix);
/* 327 */       if ((dsettings.flags & 0x2) != 0) {
/* 328 */         d.cameraMatrix.put(0, dsettings.initAspectRatio);
/* 329 */         d.cameraMatrix.put(4, 1.0D);
/*     */       }
/*     */     }
/* 332 */     int kn = dsettings.isFixK3() ? 4 : 5;
/* 333 */     if ((dsettings.isRationalModel()) && (!dsettings.isFixK4()) && (!dsettings.isFixK4()) && (!dsettings.isFixK5()))
/*     */     {
/* 335 */       kn = 8;
/*     */     }
/* 337 */     if ((d.distortionCoeffs == null) || (d.distortionCoeffs.cols() != kn)) {
/* 338 */       d.distortionCoeffs = opencv_core.CvMat.create(1, kn);
/* 339 */       opencv_core.cvSetZero(d.distortionCoeffs);
/*     */     }
/*     */ 
/* 342 */     opencv_core.CvMat rotVects = new opencv_core.CvMat(); opencv_core.CvMat transVects = new opencv_core.CvMat();
/* 343 */     d.extrParams = opencv_core.CvMat.create(this.allImageMarkers.size(), 6);
/* 344 */     opencv_core.cvGetCols(d.extrParams, rotVects, 0, 3);
/* 345 */     opencv_core.cvGetCols(d.extrParams, transVects, 3, 6);
/*     */ 
/* 347 */     opencv_core.CvMat[] points = getPoints(useCenters);
/* 348 */     opencv_calib3d.cvCalibrateCamera2(points[0], points[1], points[2], opencv_core.cvSize(d.imageWidth, d.imageHeight), d.cameraMatrix, d.distortionCoeffs, rotVects, transVects, dsettings.flags);
/*     */ 
/* 353 */     if ((opencv_core.cvCheckArr(d.cameraMatrix, 2, 0.0D, 0.0D) != 0) && (opencv_core.cvCheckArr(d.distortionCoeffs, 2, 0.0D, 0.0D) != 0) && (opencv_core.cvCheckArr(d.extrParams, 2, 0.0D, 0.0D) != 0))
/*     */     {
/* 357 */       d.reprojErrs = opencv_core.CvMat.create(1, this.allImageMarkers.size());
/* 358 */       double[] err = computeReprojectionError(points[0], points[1], points[2], d.cameraMatrix, d.distortionCoeffs, rotVects, transVects, d.reprojErrs);
/*     */ 
/* 360 */       d.avgReprojErr = err[0];
/* 361 */       d.maxReprojErr = err[1];
/*     */ 
/* 363 */       return err;
/*     */     }
/* 365 */     d.cameraMatrix = null;
/* 366 */     d.avgReprojErr = -1.0D;
/* 367 */     d.maxReprojErr = -1.0D;
/* 368 */     return null;
/*     */   }
/*     */ 
/*     */   public static double[] computeStereoError(opencv_core.CvMat imagePoints1, opencv_core.CvMat imagePoints2, opencv_core.CvMat M1, opencv_core.CvMat D1, opencv_core.CvMat M2, opencv_core.CvMat D2, opencv_core.CvMat F)
/*     */   {
/* 379 */     int N = imagePoints1.cols();
/* 380 */     opencv_core.CvMat L1 = opencv_core.CvMat.create(1, N, 5, 3);
/* 381 */     opencv_core.CvMat L2 = opencv_core.CvMat.create(1, N, 5, 3);
/*     */ 
/* 383 */     opencv_imgproc.cvUndistortPoints(imagePoints1, imagePoints1, M1, D1, null, M1);
/* 384 */     opencv_imgproc.cvUndistortPoints(imagePoints2, imagePoints2, M2, D2, null, M2);
/*     */ 
/* 387 */     opencv_calib3d.cvComputeCorrespondEpilines(imagePoints1, 1, F, L1);
/* 388 */     opencv_calib3d.cvComputeCorrespondEpilines(imagePoints2, 2, F, L2);
/* 389 */     double avgErr = 0.0D; double maxErr = 0.0D;
/* 390 */     opencv_core.CvMat p1 = imagePoints1; opencv_core.CvMat p2 = imagePoints2;
/* 391 */     for (int i = 0; i < N; i++) {
/* 392 */       double e1 = p1.get(0, i, 0) * L2.get(0, i, 0) + p1.get(0, i, 1) * L2.get(0, i, 1) + L2.get(0, i, 2);
/*     */ 
/* 394 */       double e2 = p2.get(0, i, 0) * L1.get(0, i, 0) + p2.get(0, i, 1) * L1.get(0, i, 1) + L1.get(0, i, 2);
/*     */ 
/* 396 */       double err = e1 * e1 + e2 * e2;
/* 397 */       avgErr += err;
/*     */ 
/* 399 */       err = Math.sqrt(err);
/* 400 */       if (err > maxErr) {
/* 401 */         maxErr = err;
/*     */       }
/*     */     }
/* 404 */     return new double[] { Math.sqrt(avgErr / N), maxErr };
/*     */   }
/*     */ 
/*     */   public double[] calibrateStereo(boolean useCenters, GeometricCalibrator peer) {
/* 408 */     ProjectiveDevice d = this.projectiveDevice;
/* 409 */     ProjectiveDevice dp = peer.projectiveDevice;
/* 410 */     ProjectiveDevice.CalibrationSettings dsettings = (ProjectiveDevice.CalibrationSettings)d.getSettings();
/* 411 */     ProjectiveDevice.CalibrationSettings dpsettings = (ProjectiveDevice.CalibrationSettings)dp.getSettings();
/*     */ 
/* 413 */     opencv_core.CvMat[] points1 = getPoints(useCenters);
/* 414 */     opencv_core.CvMat[] points2 = peer.getPoints(useCenters);
/*     */ 
/* 418 */     FloatBuffer objPts1 = points1[0].getFloatBuffer();
/* 419 */     FloatBuffer imgPts1 = points1[1].getFloatBuffer();
/* 420 */     IntBuffer imgCount1 = points1[2].getIntBuffer();
/* 421 */     FloatBuffer objPts2 = points2[0].getFloatBuffer();
/* 422 */     FloatBuffer imgPts2 = points2[1].getFloatBuffer();
/* 423 */     IntBuffer imgCount2 = points2[2].getIntBuffer();
/* 424 */     assert (imgCount1.capacity() == imgCount2.capacity());
/*     */ 
/* 426 */     opencv_core.CvMat objectPointsMat = opencv_core.CvMat.create(1, Math.min(objPts1.capacity(), objPts2.capacity()), 5, 3);
/* 427 */     opencv_core.CvMat imagePoints1Mat = opencv_core.CvMat.create(1, Math.min(imgPts1.capacity(), imgPts2.capacity()), 5, 2);
/* 428 */     opencv_core.CvMat imagePoints2Mat = opencv_core.CvMat.create(1, Math.min(imgPts1.capacity(), imgPts2.capacity()), 5, 2);
/* 429 */     opencv_core.CvMat pointCountsMat = opencv_core.CvMat.create(1, imgCount1.capacity(), 4, 1);
/* 430 */     FloatBuffer objectPoints = objectPointsMat.getFloatBuffer();
/* 431 */     FloatBuffer imagePoints1 = imagePoints1Mat.getFloatBuffer();
/* 432 */     FloatBuffer imagePoints2 = imagePoints2Mat.getFloatBuffer();
/* 433 */     IntBuffer pointCounts = pointCountsMat.getIntBuffer();
/*     */ 
/* 435 */     int end1 = 0; int end2 = 0;
/* 436 */     for (int i = 0; i < imgCount1.capacity(); i++) {
/* 437 */       int start1 = end1;
/* 438 */       int start2 = end2;
/* 439 */       end1 = start1 + imgCount1.get(i);
/* 440 */       end2 = start2 + imgCount2.get(i);
/*     */ 
/* 442 */       int count = 0;
/* 443 */       for (int j = start1; j < end1; j++) {
/* 444 */         float x1 = objPts1.get(j * 3);
/* 445 */         float y1 = objPts1.get(j * 3 + 1);
/* 446 */         float z1 = objPts1.get(j * 3 + 2);
/* 447 */         for (int k = start2; k < end2; k++) {
/* 448 */           float x2 = objPts2.get(k * 3);
/* 449 */           float y2 = objPts2.get(k * 3 + 1);
/* 450 */           float z2 = objPts2.get(k * 3 + 2);
/* 451 */           if ((x1 == x2) && (y1 == y2) && (z1 == z2)) {
/* 452 */             objectPoints.put(x1);
/* 453 */             objectPoints.put(y1);
/* 454 */             objectPoints.put(z1);
/*     */ 
/* 456 */             imagePoints1.put(imgPts1.get(j * 2));
/* 457 */             imagePoints1.put(imgPts1.get(j * 2 + 1));
/*     */ 
/* 459 */             imagePoints2.put(imgPts2.get(k * 2));
/* 460 */             imagePoints2.put(imgPts2.get(k * 2 + 1));
/*     */ 
/* 462 */             count++;
/* 463 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 467 */       if (count > 0) {
/* 468 */         pointCounts.put(count);
/*     */       }
/*     */     }
/* 471 */     objectPointsMat.cols(objectPoints.position() / 3);
/* 472 */     imagePoints1Mat.cols(imagePoints1.position() / 2);
/* 473 */     imagePoints2Mat.cols(imagePoints2.position() / 2);
/* 474 */     pointCountsMat.cols(pointCounts.position());
/*     */ 
/* 478 */     d.R = opencv_core.CvMat.create(3, 3); d.R.put(new double[] { 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D });
/* 479 */     d.T = opencv_core.CvMat.create(3, 1); d.T.put(new double[] { 0.0D, 0.0D, 0.0D });
/* 480 */     d.E = opencv_core.CvMat.create(3, 3); opencv_core.cvSetZero(d.E);
/* 481 */     d.F = opencv_core.CvMat.create(3, 3); opencv_core.cvSetZero(d.F);
/*     */ 
/* 483 */     dp.R = opencv_core.CvMat.create(3, 3);
/* 484 */     dp.T = opencv_core.CvMat.create(3, 1);
/* 485 */     dp.E = opencv_core.CvMat.create(3, 3);
/* 486 */     dp.F = opencv_core.CvMat.create(3, 3);
/*     */ 
/* 488 */     opencv_calib3d.cvStereoCalibrate(objectPointsMat, imagePoints1Mat, imagePoints2Mat, pointCountsMat, d.cameraMatrix, d.distortionCoeffs, dp.cameraMatrix, dp.distortionCoeffs, opencv_core.cvSize(d.imageWidth, d.imageHeight), dp.R, dp.T, dp.E, dp.F, opencv_core.cvTermCriteria(3, 100, 1.0E-006D), dpsettings.flags);
/*     */ 
/* 495 */     d.avgEpipolarErr = 0.0D;
/* 496 */     d.maxEpipolarErr = 0.0D;
/* 497 */     double[] err = computeStereoError(imagePoints1Mat, imagePoints2Mat, d.cameraMatrix, d.distortionCoeffs, dp.cameraMatrix, dp.distortionCoeffs, dp.F);
/*     */ 
/* 500 */     dp.avgEpipolarErr = err[0];
/* 501 */     dp.maxEpipolarErr = err[1];
/*     */ 
/* 503 */     return err;
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  57 */     double detectedBoardMin = 0.5D;
/*  58 */     double patternSteadySize = 0.005D;
/*  59 */     double patternMovedSize = 0.05D;
/*     */ 
/*     */     public double getDetectedBoardMin() {
/*  62 */       return this.detectedBoardMin;
/*     */     }
/*     */     public void setDetectedBoardMin(double detectedBoardMin) {
/*  65 */       this.detectedBoardMin = detectedBoardMin;
/*     */     }
/*     */ 
/*     */     public double getPatternSteadySize() {
/*  69 */       return this.patternSteadySize;
/*     */     }
/*     */     public void setPatternSteadySize(double patternSteadySize) {
/*  72 */       this.patternSteadySize = patternSteadySize;
/*     */     }
/*     */ 
/*     */     public double getPatternMovedSize() {
/*  76 */       return this.patternMovedSize;
/*     */     }
/*     */     public void setPatternMovedSize(double patternMovedSize) {
/*  79 */       this.patternMovedSize = patternMovedSize;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.GeometricCalibrator
 * JD-Core Version:    0.6.2
 */