/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class ProCamGeometricCalibrator
/*     */ {
/* 105 */   private final int MSB_IMAGE_SHIFT = 8; private final int LSB_IMAGE_SHIFT = 7;
/*     */   private Settings settings;
/*     */   private MarkerDetector.Settings detectorSettings;
/*     */   private GeometricCalibrator[] cameraCalibrators;
/*     */   private MarkerDetector[] markerDetectors;
/*     */   LinkedList<Marker[]>[] allImagedBoardMarkers;
/*     */   private opencv_core.IplImage[] grayscaleImage;
/*     */   private opencv_core.IplImage[] tempImage1;
/*     */   private opencv_core.IplImage[] tempImage2;
/*     */   private Marker[][] lastDetectedMarkers1;
/*     */   private Marker[][] lastDetectedMarkers2;
/*     */   private double[] rmseBoardWarp;
/*     */   private double[] rmseProjWarp;
/*     */   private opencv_core.CvMat[] boardWarp;
/*     */   private opencv_core.CvMat[] projWarp;
/*     */   private opencv_core.CvMat[] prevBoardWarp;
/*     */   private opencv_core.CvMat[] lastBoardWarp;
/*     */   private opencv_core.CvMat[] tempPts1;
/*     */   private opencv_core.CvMat[] tempPts2;
/* 153 */   private boolean updatePrewarp = false;
/*     */   private final MarkedPlane boardPlane;
/*     */   private final MarkedPlane projectorPlane;
/*     */   private final GeometricCalibrator projectorCalibrator;
/*     */   private final opencv_core.CvMat boardWarpSrcPts;
/* 310 */   private static ThreadLocal<opencv_core.CvMat> tempWarp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/*     */   public ProCamGeometricCalibrator(Settings settings, MarkerDetector.Settings detectorSettings, MarkedPlane boardPlane, MarkedPlane projectorPlane, ProjectiveDevice camera, ProjectiveDevice projector)
/*     */   {
/*  38 */     this(settings, detectorSettings, boardPlane, projectorPlane, new GeometricCalibrator[] { new GeometricCalibrator(settings, detectorSettings, boardPlane, camera) }, new GeometricCalibrator(settings, detectorSettings, projectorPlane, projector));
/*     */   }
/*     */ 
/*     */   public ProCamGeometricCalibrator(Settings settings, MarkerDetector.Settings detectorSettings, MarkedPlane boardPlane, MarkedPlane projectorPlane, GeometricCalibrator[] cameraCalibrators, GeometricCalibrator projectorCalibrator)
/*     */   {
/*  47 */     this.settings = settings;
/*  48 */     this.detectorSettings = detectorSettings;
/*  49 */     this.boardPlane = boardPlane;
/*  50 */     this.projectorPlane = projectorPlane;
/*     */ 
/*  52 */     this.cameraCalibrators = cameraCalibrators;
/*  53 */     int n = cameraCalibrators.length;
/*  54 */     this.markerDetectors = new MarkerDetector[n];
/*     */ 
/*  56 */     this.allImagedBoardMarkers = new LinkedList[n];
/*  57 */     this.grayscaleImage = new opencv_core.IplImage[n];
/*  58 */     this.tempImage1 = new opencv_core.IplImage[n];
/*  59 */     this.tempImage2 = new opencv_core.IplImage[n];
/*  60 */     this.lastDetectedMarkers1 = new Marker[n][];
/*  61 */     this.lastDetectedMarkers2 = new Marker[n][];
/*  62 */     this.rmseBoardWarp = new double[n];
/*  63 */     this.rmseProjWarp = new double[n];
/*  64 */     this.boardWarp = new opencv_core.CvMat[n];
/*  65 */     this.projWarp = new opencv_core.CvMat[n];
/*  66 */     this.prevBoardWarp = new opencv_core.CvMat[n];
/*  67 */     this.lastBoardWarp = new opencv_core.CvMat[n];
/*  68 */     this.tempPts1 = new opencv_core.CvMat[n];
/*  69 */     this.tempPts2 = new opencv_core.CvMat[n];
/*  70 */     for (int i = 0; i < n; i++) {
/*  71 */       this.markerDetectors[i] = new MarkerDetector(detectorSettings);
/*  72 */       this.allImagedBoardMarkers[i] = new LinkedList();
/*  73 */       this.grayscaleImage[i] = null;
/*  74 */       this.tempImage1[i] = null;
/*  75 */       this.tempImage2[i] = null;
/*  76 */       this.lastDetectedMarkers1[i] = null;
/*  77 */       this.lastDetectedMarkers2[i] = null;
/*  78 */       this.rmseBoardWarp[i] = (1.0D / 0.0D);
/*  79 */       this.rmseProjWarp[i] = (1.0D / 0.0D);
/*  80 */       this.boardWarp[i] = opencv_core.CvMat.create(3, 3);
/*  81 */       this.projWarp[i] = opencv_core.CvMat.create(3, 3);
/*  82 */       this.prevBoardWarp[i] = opencv_core.CvMat.create(3, 3);
/*  83 */       this.lastBoardWarp[i] = opencv_core.CvMat.create(3, 3);
/*  84 */       opencv_core.cvSetIdentity(this.prevBoardWarp[i]);
/*  85 */       opencv_core.cvSetIdentity(this.lastBoardWarp[i]);
/*  86 */       this.tempPts1[i] = opencv_core.CvMat.create(1, 4, 6, 2);
/*  87 */       this.tempPts2[i] = opencv_core.CvMat.create(1, 4, 6, 2);
/*     */     }
/*  89 */     this.projectorCalibrator = projectorCalibrator;
/*     */ 
/*  91 */     this.boardWarpSrcPts = opencv_core.CvMat.create(1, 4, 6, 2);
/*  92 */     if (boardPlane != null) {
/*  93 */       int w = boardPlane.getImage().width();
/*  94 */       int h = boardPlane.getImage().height();
/*  95 */       this.boardWarpSrcPts.put(new double[] { 0.0D, 0.0D, w, 0.0D, w, h, 0.0D, h });
/*     */     }
/*  97 */     if (projectorPlane != null) {
/*  98 */       int w = projectorPlane.getImage().width();
/*  99 */       int h = projectorPlane.getImage().height();
/* 100 */       projectorCalibrator.getProjectiveDevice().imageWidth = w;
/* 101 */       projectorCalibrator.getProjectiveDevice().imageHeight = h;
/*     */     }
/*     */   }
/*     */ 
/*     */   public MarkedPlane getBoardPlane()
/*     */   {
/* 159 */     return this.boardPlane;
/*     */   }
/*     */   public MarkedPlane getProjectorPlane() {
/* 162 */     return this.projectorPlane;
/*     */   }
/*     */   public GeometricCalibrator[] getCameraCalibrators() {
/* 165 */     return this.cameraCalibrators;
/*     */   }
/*     */   public GeometricCalibrator getProjectorCalibrator() {
/* 168 */     return this.projectorCalibrator;
/*     */   }
/*     */   public int getImageCount() {
/* 171 */     int n = this.projectorCalibrator.getImageCount() / this.cameraCalibrators.length;
/* 172 */     for (GeometricCalibrator c : this.cameraCalibrators) {
/* 173 */       assert (c.getImageCount() == n);
/*     */     }
/* 175 */     return n;
/*     */   }
/*     */ 
/*     */   public Marker[][] processCameraImage(opencv_core.IplImage cameraImage) {
/* 179 */     return processCameraImage(cameraImage, 0);
/*     */   }
/*     */   public Marker[][] processCameraImage(opencv_core.IplImage cameraImage, final int cameraNumber) {
/* 182 */     this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageWidth = cameraImage.width();
/* 183 */     this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageHeight = cameraImage.height();
/*     */ 
/* 185 */     if (cameraImage.nChannels() > 1) {
/* 186 */       if ((this.grayscaleImage[cameraNumber] == null) || (this.grayscaleImage[cameraNumber].width() != cameraImage.width()) || (this.grayscaleImage[cameraNumber].height() != cameraImage.height()) || (this.grayscaleImage[cameraNumber].depth() != cameraImage.depth()))
/*     */       {
/* 190 */         this.grayscaleImage[cameraNumber] = opencv_core.IplImage.create(cameraImage.width(), cameraImage.height(), cameraImage.depth(), 1, cameraImage.origin());
/*     */       }
/*     */ 
/* 193 */       opencv_imgproc.cvCvtColor(cameraImage, this.grayscaleImage[cameraNumber], 6);
/*     */     } else {
/* 195 */       this.grayscaleImage[cameraNumber] = cameraImage;
/*     */     }
/*     */ 
/* 198 */     final boolean boardWhiteMarkers = this.boardPlane.getForegroundColor().magnitude() > this.boardPlane.getBackgroundColor().magnitude();
/*     */ 
/* 200 */     final boolean projWhiteMarkers = this.projectorPlane.getForegroundColor().magnitude() > this.projectorPlane.getBackgroundColor().magnitude();
/*     */ 
/* 202 */     if (this.grayscaleImage[cameraNumber].depth() > 8) {
/* 203 */       if ((this.tempImage1[cameraNumber] == null) || (this.tempImage1[cameraNumber].width() != this.grayscaleImage[cameraNumber].width()) || (this.tempImage1[cameraNumber].height() != this.grayscaleImage[cameraNumber].height()))
/*     */       {
/* 206 */         this.tempImage1[cameraNumber] = opencv_core.IplImage.create(this.grayscaleImage[cameraNumber].width(), this.grayscaleImage[cameraNumber].height(), 8, 1, this.grayscaleImage[cameraNumber].origin());
/*     */ 
/* 209 */         this.tempImage2[cameraNumber] = opencv_core.IplImage.create(this.grayscaleImage[cameraNumber].width(), this.grayscaleImage[cameraNumber].height(), 8, 1, this.grayscaleImage[cameraNumber].origin());
/*     */       }
/*     */ 
/* 213 */       Parallel.run(new Runnable[] { new Runnable() {
/* 214 */         public void run() { opencv_core.cvConvertScale(ProCamGeometricCalibrator.this.grayscaleImage[cameraNumber], ProCamGeometricCalibrator.this.tempImage1[cameraNumber], 0.0078125D, 0.0D);
/*     */ 
/* 216 */           ProCamGeometricCalibrator.this.lastDetectedMarkers1[cameraNumber] = ProCamGeometricCalibrator.this.cameraCalibrators[cameraNumber].markerDetector.detect(ProCamGeometricCalibrator.this.tempImage1[cameraNumber], boardWhiteMarkers);
/*     */         }
/*     */       }
/*     */       , new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 219 */           opencv_core.cvConvertScale(ProCamGeometricCalibrator.this.grayscaleImage[cameraNumber], ProCamGeometricCalibrator.this.tempImage2[cameraNumber], 0.00390625D, 0.0D);
/*     */ 
/* 221 */           ProCamGeometricCalibrator.this.lastDetectedMarkers2[cameraNumber] = ProCamGeometricCalibrator.this.markerDetectors[cameraNumber].detect(ProCamGeometricCalibrator.this.tempImage2[cameraNumber], projWhiteMarkers);
/*     */         }
/*     */       }
/*     */        });
/*     */     } else { Parallel.run(new Runnable[] { new Runnable() {
/* 226 */         public void run() { ProCamGeometricCalibrator.this.lastDetectedMarkers1[cameraNumber] = ProCamGeometricCalibrator.this.cameraCalibrators[cameraNumber].markerDetector.detect(ProCamGeometricCalibrator.this.grayscaleImage[cameraNumber], boardWhiteMarkers); }
/*     */ 
/*     */       }
/*     */       , new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 229 */           ProCamGeometricCalibrator.this.lastDetectedMarkers2[cameraNumber] = ProCamGeometricCalibrator.this.markerDetectors[cameraNumber].detect(ProCamGeometricCalibrator.this.grayscaleImage[cameraNumber], projWhiteMarkers);
/*     */         }
/*     */       }
/*     */        });
/*     */     }
/* 234 */     return processMarkers(cameraNumber) ? new Marker[][] { this.lastDetectedMarkers1[cameraNumber], this.lastDetectedMarkers2[cameraNumber] } : (Marker[][])null;
/*     */   }
/*     */ 
/*     */   public void drawMarkers(opencv_core.IplImage image)
/*     */   {
/* 240 */     drawMarkers(image, 0);
/*     */   }
/*     */   public void drawMarkers(opencv_core.IplImage image, int cameraNumber) {
/* 243 */     this.cameraCalibrators[cameraNumber].markerDetector.draw(image, this.lastDetectedMarkers1[cameraNumber]);
/*     */ 
/* 245 */     this.projectorCalibrator.markerDetector.draw(image, this.lastDetectedMarkers2[cameraNumber]);
/*     */   }
/*     */ 
/*     */   public boolean processMarkers()
/*     */   {
/* 250 */     return processMarkers(0);
/*     */   }
/*     */   public boolean processMarkers(int cameraNumber) {
/* 253 */     return processMarkers(this.lastDetectedMarkers1[cameraNumber], this.lastDetectedMarkers2[cameraNumber], cameraNumber);
/*     */   }
/*     */ 
/*     */   public boolean processMarkers(Marker[] imagedBoardMarkers, Marker[] imagedProjectorMarkers) {
/* 257 */     return processMarkers(imagedBoardMarkers, imagedProjectorMarkers, 0);
/*     */   }
/*     */ 
/*     */   public boolean processMarkers(Marker[] imagedBoardMarkers, Marker[] imagedProjectorMarkers, int cameraNumber) {
/* 261 */     this.rmseBoardWarp[cameraNumber] = this.boardPlane.getTotalWarp(imagedBoardMarkers, this.boardWarp[cameraNumber]);
/* 262 */     this.rmseProjWarp[cameraNumber] = this.projectorPlane.getTotalWarp(imagedProjectorMarkers, this.projWarp[cameraNumber]);
/*     */ 
/* 264 */     int imageSize = (this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageWidth + this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageHeight) / 2;
/*     */ 
/* 266 */     if ((this.rmseBoardWarp[cameraNumber] <= this.settings.prewarpUpdateErrorMax * imageSize) && (this.rmseProjWarp[cameraNumber] <= this.settings.prewarpUpdateErrorMax * imageSize))
/*     */     {
/* 268 */       this.updatePrewarp = true;
/*     */     }
/*     */     else {
/* 271 */       return false;
/*     */     }
/*     */ 
/* 275 */     if ((imagedBoardMarkers.length < this.boardPlane.getMarkers().length * this.settings.detectedBoardMin) || (imagedProjectorMarkers.length < this.projectorPlane.getMarkers().length * this.settings.detectedProjectorMin))
/*     */     {
/* 277 */       return false;
/*     */     }
/*     */ 
/* 281 */     opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts1[cameraNumber], this.boardWarp[cameraNumber]);
/* 282 */     opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts2[cameraNumber], this.prevBoardWarp[cameraNumber]);
/* 283 */     double rmsePrev = opencv_core.cvNorm(this.tempPts1[cameraNumber], this.tempPts2[cameraNumber]);
/* 284 */     opencv_core.cvPerspectiveTransform(this.boardWarpSrcPts, this.tempPts2[cameraNumber], this.lastBoardWarp[cameraNumber]);
/* 285 */     double rmseLast = opencv_core.cvNorm(this.tempPts1[cameraNumber], this.tempPts2[cameraNumber]);
/*     */ 
/* 289 */     opencv_core.cvCopy(this.boardWarp[cameraNumber], this.prevBoardWarp[cameraNumber]);
/*     */ 
/* 292 */     if ((rmsePrev < this.settings.patternSteadySize * imageSize) && (rmseLast > this.settings.patternMovedSize * imageSize))
/*     */     {
/* 294 */       return true;
/*     */     }
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */   public void addMarkers()
/*     */   {
/* 301 */     addMarkers(0);
/*     */   }
/*     */   public void addMarkers(int cameraNumber) {
/* 304 */     addMarkers(this.lastDetectedMarkers1[cameraNumber], this.lastDetectedMarkers2[cameraNumber], cameraNumber);
/*     */   }
/*     */   public void addMarkers(Marker[] imagedBoardMarkers, Marker[] imagedProjectorMarkers) {
/* 307 */     addMarkers(imagedBoardMarkers, imagedProjectorMarkers, 0);
/*     */   }
/*     */ 
/*     */   public void addMarkers(Marker[] imagedBoardMarkers, Marker[] imagedProjectorMarkers, int cameraNumber)
/*     */   {
/* 313 */     opencv_core.CvMat tempWarp = (opencv_core.CvMat)tempWarp3x3.get();
/*     */ 
/* 315 */     if (!this.settings.useOnlyIntersection) {
/* 316 */       this.cameraCalibrators[cameraNumber].addMarkers(this.boardPlane.getMarkers(), imagedBoardMarkers);
/*     */ 
/* 318 */       this.allImagedBoardMarkers[cameraNumber].add(imagedBoardMarkers);
/*     */     }
/*     */     else {
/* 321 */       Marker[] inProjectorBoardMarkers = new Marker[imagedBoardMarkers.length];
/* 322 */       for (int i = 0; i < inProjectorBoardMarkers.length; i++) {
/* 323 */         inProjectorBoardMarkers[i] = imagedBoardMarkers[i].clone();
/*     */       }
/* 325 */       opencv_core.cvInvert(this.projWarp[cameraNumber], tempWarp);
/* 326 */       Marker.applyWarp(inProjectorBoardMarkers, tempWarp);
/*     */ 
/* 329 */       int w = this.projectorPlane.getImage().width();
/* 330 */       int h = this.projectorPlane.getImage().height();
/* 331 */       Marker[] boardMarkersToAdd = new Marker[imagedBoardMarkers.length];
/* 332 */       int totalToAdd = 0;
/* 333 */       for (int i = 0; i < inProjectorBoardMarkers.length; i++) {
/* 334 */         double[] c = inProjectorBoardMarkers[i].corners;
/* 335 */         boolean outside = false;
/* 336 */         for (int j = 0; j < 4; j++) {
/* 337 */           int margin = this.detectorSettings.subPixelWindow / 2;
/* 338 */           if ((c[(2 * j)] < margin) || (c[(2 * j)] >= w - margin) || (c[(2 * j + 1)] < margin) || (c[(2 * j + 1)] >= h - margin))
/*     */           {
/* 340 */             outside = true;
/* 341 */             break;
/*     */           }
/*     */         }
/* 344 */         if (!outside) {
/* 345 */           boardMarkersToAdd[(totalToAdd++)] = imagedBoardMarkers[i];
/*     */         }
/*     */       }
/* 348 */       Marker[] a = (Marker[])Arrays.copyOf(boardMarkersToAdd, totalToAdd);
/* 349 */       this.cameraCalibrators[cameraNumber].addMarkers(this.boardPlane.getMarkers(), a);
/* 350 */       this.allImagedBoardMarkers[cameraNumber].add(a);
/*     */     }
/*     */ 
/* 354 */     Marker[] prewrappedProjMarkers = new Marker[this.projectorPlane.getMarkers().length];
/* 355 */     for (int i = 0; i < prewrappedProjMarkers.length; i++) {
/* 356 */       prewrappedProjMarkers[i] = this.projectorPlane.getMarkers()[i].clone();
/*     */     }
/*     */ 
/* 359 */     Marker.applyWarp(prewrappedProjMarkers, this.projectorPlane.getPrewarp());
/* 360 */     synchronized (this.projectorCalibrator)
/*     */     {
/* 362 */       while (this.projectorCalibrator.getImageCount() % this.cameraCalibrators.length < cameraNumber)
/*     */         try {
/* 364 */           this.projectorCalibrator.wait();
/*     */         } catch (InterruptedException ex) {
/*     */         }
/* 367 */       this.projectorCalibrator.addMarkers(imagedProjectorMarkers, prewrappedProjMarkers);
/* 368 */       this.projectorCalibrator.notify();
/*     */     }
/*     */ 
/* 372 */     opencv_core.cvCopy(this.boardWarp[cameraNumber], this.lastBoardWarp[cameraNumber]);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getProjectorImage() {
/* 376 */     if (this.updatePrewarp)
/*     */     {
/* 378 */       double minRmse = 1.7976931348623157E+308D;
/* 379 */       int minCameraNumber = 0;
/* 380 */       for (int i = 0; i < this.cameraCalibrators.length; i++) {
/* 381 */         double rmse = this.rmseBoardWarp[i] + this.rmseProjWarp[i];
/* 382 */         if (rmse < minRmse) {
/* 383 */           minRmse = rmse;
/* 384 */           minCameraNumber = i;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 389 */       opencv_core.CvMat prewarp = this.projectorPlane.getPrewarp();
/* 390 */       opencv_core.cvInvert(this.projWarp[minCameraNumber], prewarp);
/* 391 */       opencv_core.cvMatMul(prewarp, this.boardWarp[minCameraNumber], prewarp);
/* 392 */       this.projectorPlane.setPrewarp(prewarp);
/*     */     }
/*     */ 
/* 395 */     return this.projectorPlane.getImage();
/*     */   }
/*     */ 
/*     */   public double[] calibrate(boolean useCenters, boolean calibrateCameras) {
/* 399 */     return calibrate(useCenters, calibrateCameras);
/*     */   }
/*     */ 
/*     */   public double[] calibrate(boolean useCenters, boolean calibrateCameras, int cameraAtOrigin) {
/* 403 */     GeometricCalibrator calibratorAtOrigin = this.cameraCalibrators[cameraAtOrigin];
/*     */ 
/* 406 */     if (calibrateCameras) {
/* 407 */       for (int cameraNumber = 0; cameraNumber < this.cameraCalibrators.length; cameraNumber++) {
/* 408 */         this.cameraCalibrators[cameraNumber].calibrate(useCenters);
/* 409 */         if (this.cameraCalibrators[cameraNumber] != calibratorAtOrigin) {
/* 410 */           calibratorAtOrigin.calibrateStereo(useCenters, this.cameraCalibrators[cameraNumber]);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 420 */     LinkedList allDistortedProjectorMarkers = this.projectorCalibrator.getAllObjectMarkers();
/* 421 */     LinkedList distortedProjectorMarkersAtOrigin = new LinkedList();
/* 422 */     LinkedList allUndistortedProjectorMarkers = new LinkedList();
/* 423 */     LinkedList undistortedProjectorMarkersAtOrigin = new LinkedList();
/* 424 */     Iterator ip = allDistortedProjectorMarkers.iterator();
/*     */ 
/* 426 */     Iterator[] ib = new Iterator[this.cameraCalibrators.length];
/* 427 */     for (int cameraNumber = 0; cameraNumber < this.cameraCalibrators.length; cameraNumber++) {
/* 428 */       ib[cameraNumber] = this.allImagedBoardMarkers[cameraNumber].iterator();
/*     */     }
/*     */ 
/* 433 */     while (ip.hasNext()) {
/* 434 */       for (int cameraNumber = 0; cameraNumber < this.cameraCalibrators.length; cameraNumber++) {
/* 435 */         double maxError = this.settings.prewarpUpdateErrorMax * (this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageWidth + this.cameraCalibrators[cameraNumber].getProjectiveDevice().imageHeight) / 2.0D;
/*     */ 
/* 439 */         Marker[] distortedBoardMarkers = (Marker[])ib[cameraNumber].next();
/* 440 */         Marker[] distortedProjectorMarkers = (Marker[])ip.next();
/* 441 */         Marker[] undistortedBoardMarkers = new Marker[distortedBoardMarkers.length];
/* 442 */         Marker[] undistortedProjectorMarkers = new Marker[distortedProjectorMarkers.length];
/*     */ 
/* 445 */         for (int i = 0; i < distortedBoardMarkers.length; i++) {
/* 446 */           Marker m = undistortedBoardMarkers[i] =  = distortedBoardMarkers[i].clone();
/* 447 */           m.corners = this.cameraCalibrators[cameraNumber].getProjectiveDevice().undistort(m.corners);
/*     */         }
/* 449 */         for (int i = 0; i < distortedProjectorMarkers.length; i++) {
/* 450 */           Marker m = undistortedProjectorMarkers[i] =  = distortedProjectorMarkers[i].clone();
/* 451 */           m.corners = this.cameraCalibrators[cameraNumber].getProjectiveDevice().undistort(m.corners);
/*     */         }
/*     */ 
/* 456 */         if ((this.boardPlane.getTotalWarp(undistortedBoardMarkers, this.boardWarp[cameraNumber]) > maxError) && 
/* 457 */           (!$assertionsDisabled)) throw new AssertionError();
/*     */ 
/* 459 */         opencv_core.cvInvert(this.boardWarp[cameraNumber], this.boardWarp[cameraNumber]);
/* 460 */         Marker.applyWarp(undistortedProjectorMarkers, this.boardWarp[cameraNumber]);
/*     */ 
/* 463 */         allUndistortedProjectorMarkers.add(undistortedProjectorMarkers);
/* 464 */         if (this.cameraCalibrators[cameraNumber] == calibratorAtOrigin) {
/* 465 */           undistortedProjectorMarkersAtOrigin.add(undistortedProjectorMarkers);
/* 466 */           distortedProjectorMarkersAtOrigin.add(distortedProjectorMarkers);
/*     */         } else {
/* 468 */           undistortedProjectorMarkersAtOrigin.add(new Marker[0]);
/* 469 */           distortedProjectorMarkersAtOrigin.add(new Marker[0]);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 475 */     this.projectorCalibrator.setAllObjectMarkers(allUndistortedProjectorMarkers);
/* 476 */     double[] reprojErr = this.projectorCalibrator.calibrate(useCenters);
/*     */ 
/* 482 */     LinkedList om = calibratorAtOrigin.getAllObjectMarkers();
/* 483 */     LinkedList im = calibratorAtOrigin.getAllImageMarkers();
/* 484 */     calibratorAtOrigin.setAllObjectMarkers(undistortedProjectorMarkersAtOrigin);
/* 485 */     calibratorAtOrigin.setAllImageMarkers(distortedProjectorMarkersAtOrigin);
/* 486 */     double[] epipolarErr = calibratorAtOrigin.calibrateStereo(useCenters, this.projectorCalibrator);
/*     */ 
/* 490 */     this.projectorCalibrator.setAllObjectMarkers(allDistortedProjectorMarkers);
/* 491 */     calibratorAtOrigin.setAllObjectMarkers(om);
/* 492 */     calibratorAtOrigin.setAllImageMarkers(im);
/*     */ 
/* 494 */     return new double[] { reprojErr[0], reprojErr[1], epipolarErr[0], epipolarErr[1] };
/*     */   }
/*     */ 
/*     */   public static class Settings extends GeometricCalibrator.Settings
/*     */   {
/* 110 */     double detectedProjectorMin = 0.5D;
/* 111 */     boolean useOnlyIntersection = true;
/* 112 */     double prewarpUpdateErrorMax = 0.01D;
/*     */ 
/*     */     public double getDetectedProjectorMin() {
/* 115 */       return this.detectedProjectorMin;
/*     */     }
/*     */     public void setDetectedProjectorMin(double detectedProjectorMin) {
/* 118 */       this.detectedProjectorMin = detectedProjectorMin;
/*     */     }
/*     */ 
/*     */     public boolean isUseOnlyIntersection() {
/* 122 */       return this.useOnlyIntersection;
/*     */     }
/*     */     public void setUseOnlyIntersection(boolean useOnlyIntersection) {
/* 125 */       this.useOnlyIntersection = useOnlyIntersection;
/*     */     }
/*     */ 
/*     */     public double getPrewarpUpdateErrorMax() {
/* 129 */       return this.prewarpUpdateErrorMax;
/*     */     }
/*     */     public void setPrewarpUpdateErrorMax(double prewarpUpdateErrorMax) {
/* 132 */       this.prewarpUpdateErrorMax = prewarpUpdateErrorMax;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProCamGeometricCalibrator
 * JD-Core Version:    0.6.2
 */