/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacv.cpp.opencv_calib3d;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvAttrList;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSize;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.io.File;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class ProjectiveDevice
/*     */ {
/*     */   private Settings settings;
/* 299 */   public int imageWidth = 0; public int imageHeight = 0;
/*     */ 
/* 301 */   public opencv_core.CvMat cameraMatrix = null; public opencv_core.CvMat distortionCoeffs = null; public opencv_core.CvMat extrParams = null; public opencv_core.CvMat reprojErrs = null;
/*     */   public double avgReprojErr;
/*     */   public double maxReprojErr;
/* 306 */   public opencv_core.CvMat R = null; public opencv_core.CvMat T = null; public opencv_core.CvMat E = null; public opencv_core.CvMat F = null;
/*     */   public double avgEpipolarErr;
/*     */   public double maxEpipolarErr;
/* 309 */   public String colorOrder = "BGR";
/* 310 */   public opencv_core.CvMat colorMixingMatrix = null; public opencv_core.CvMat additiveLight = null;
/*     */   public double avgColorErr;
/* 311 */   public double colorR2 = 1.0D;
/*     */ 
/* 465 */   private boolean fixedPointMaps = false;
/* 466 */   private int mapsPyramidLevel = 0;
/* 467 */   private opencv_core.IplImage[] undistortMaps1 = { null }; private opencv_core.IplImage[] undistortMaps2 = { null };
/* 468 */   private opencv_core.IplImage[] distortMaps1 = { null }; private opencv_core.IplImage[] distortMaps2 = { null };
/* 469 */   private opencv_core.IplImage tempImage = null;
/*     */ 
/* 649 */   private static ThreadLocal<opencv_core.CvMat> temp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/* 676 */   private static ThreadLocal<opencv_core.CvMat> B4x3 = opencv_core.CvMat.createThreadLocal(4, 3);
/* 677 */   private static ThreadLocal<opencv_core.CvMat> a4x1 = opencv_core.CvMat.createThreadLocal(4, 1);
/* 678 */   private static ThreadLocal<opencv_core.CvMat> t3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*     */ 
/* 719 */   private static ThreadLocal<opencv_core.CvMat> relativeR3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 720 */   private static ThreadLocal<opencv_core.CvMat> relativeT3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 721 */   private static ThreadLocal<opencv_core.CvMat> R13x3 = opencv_core.CvMat.createThreadLocal(3, 3); private static ThreadLocal<opencv_core.CvMat> P13x4 = opencv_core.CvMat.createThreadLocal(3, 4);
/* 722 */   private static ThreadLocal<opencv_core.CvMat> R23x3 = opencv_core.CvMat.createThreadLocal(3, 3); private static ThreadLocal<opencv_core.CvMat> P23x4 = opencv_core.CvMat.createThreadLocal(3, 4);
/*     */ 
/*     */   public ProjectiveDevice(String name)
/*     */   {
/*  38 */     Settings s = new Settings();
/*  39 */     s.name = name;
/*  40 */     setSettings(s);
/*     */   }
/*     */   public ProjectiveDevice(String name, File file) throws ProjectiveDevice.Exception {
/*  43 */     this(name);
/*  44 */     readParameters(file);
/*     */   }
/*     */   public ProjectiveDevice(String name, String filename) throws ProjectiveDevice.Exception {
/*  47 */     this(name);
/*  48 */     readParameters(filename);
/*     */   }
/*     */   public ProjectiveDevice(String name, opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/*  51 */     this(name);
/*  52 */     readParameters(fs);
/*     */   }
/*     */   public ProjectiveDevice(Settings settings) throws ProjectiveDevice.Exception {
/*  55 */     setSettings(settings);
/*  56 */     if ((settings instanceof CalibratedSettings))
/*  57 */       readParameters(((CalibratedSettings)settings).parametersFile);
/*     */   }
/*     */ 
/*     */   public Settings getSettings()
/*     */   {
/* 293 */     return this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 296 */     this.settings = settings;
/*     */   }
/*     */ 
/*     */   public void rescale(int imageWidth, int imageHeight)
/*     */   {
/* 314 */     if (((imageWidth != this.imageWidth) || (imageHeight != this.imageHeight)) && (this.cameraMatrix != null))
/*     */     {
/* 316 */       double sx = imageWidth / this.imageWidth;
/* 317 */       double sy = imageHeight / this.imageHeight;
/* 318 */       this.cameraMatrix.put(0, sx * this.cameraMatrix.get(0));
/* 319 */       this.cameraMatrix.put(1, sx * this.cameraMatrix.get(1));
/* 320 */       this.cameraMatrix.put(2, sx * this.cameraMatrix.get(2));
/* 321 */       this.cameraMatrix.put(3, sy * this.cameraMatrix.get(3));
/* 322 */       this.cameraMatrix.put(4, sy * this.cameraMatrix.get(4));
/* 323 */       this.cameraMatrix.put(5, sy * this.cameraMatrix.get(5));
/* 324 */       this.imageWidth = imageWidth;
/* 325 */       this.imageHeight = imageHeight;
/* 326 */       int p = this.mapsPyramidLevel;
/*     */        tmp204_203 = (this.distortMaps1[p] =  = this.distortMaps2[p] =  = null); this.undistortMaps2[p] = tmp204_203; this.undistortMaps1[p] = tmp204_203;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int[] getRGBColorOrder() {
/* 332 */     int[] order = new int[3];
/* 333 */     for (int i = 0; i < 3; i++)
/* 334 */       switch (Character.toUpperCase(this.colorOrder.charAt(i))) { case 'B':
/* 335 */         order[i] = 2; break;
/*     */       case 'G':
/* 336 */         order[i] = 1; break;
/*     */       case 'R':
/* 337 */         order[i] = 0; break;
/*     */       default:
/* 338 */         if (!$assertionsDisabled) throw new AssertionError();
/*     */         break;
/*     */       }
/* 341 */     return order;
/*     */   }
/*     */ 
/*     */   public static double[] undistort(double[] xd, double[] k)
/*     */   {
/* 371 */     double k1 = k[0];
/* 372 */     double k2 = k[1];
/* 373 */     double k3 = k.length > 4 ? k[4] : 0.0D;
/*     */ 
/* 375 */     double k4 = k.length > 5 ? k[5] : 0.0D;
/* 376 */     double k5 = k.length > 6 ? k[6] : 0.0D;
/* 377 */     double k6 = k.length > 7 ? k[7] : 0.0D;
/* 378 */     double p1 = k[2];
/* 379 */     double p2 = k[3];
/*     */ 
/* 381 */     double[] xu = (double[])xd.clone();
/*     */ 
/* 383 */     for (int i = 0; i < xd.length / 2; i++) {
/* 384 */       double x = xu[(i * 2)]; double y = xu[(i * 2 + 1)];
/* 385 */       double xo = xd[(i * 2)]; double yo = xd[(i * 2 + 1)];
/* 386 */       for (int j = 0; j < 20; j++) {
/* 387 */         double r_2 = x * x + y * y;
/* 388 */         double k_radial = 1.0D + k1 * r_2 + k2 * r_2 * r_2 + k3 * r_2 * r_2 * r_2;
/* 389 */         double delta_x = 2.0D * p1 * x * y + p2 * (r_2 + 2.0D * x * x);
/* 390 */         double delta_y = p1 * (r_2 + 2.0D * y * y) + 2.0D * p2 * x * y;
/* 391 */         x = (xo - delta_x) / k_radial;
/* 392 */         y = (yo - delta_y) / k_radial;
/*     */       }
/* 394 */       xu[(i * 2)] = x; xu[(i * 2 + 1)] = y;
/*     */     }
/* 396 */     return xu;
/*     */   }
/*     */   public double[] undistort(double[] x) {
/* 399 */     double[] xn = normalize(x, this.cameraMatrix);
/* 400 */     double[] xu = undistort(xn, this.distortionCoeffs.get());
/* 401 */     return unnormalize(xu, this.cameraMatrix);
/*     */   }
/*     */ 
/*     */   public static double[] distort(double[] xu, double[] k) {
/* 405 */     double k1 = k[0];
/* 406 */     double k2 = k[1];
/* 407 */     double k3 = k.length > 4 ? k[4] : 0.0D;
/*     */ 
/* 409 */     double k4 = k.length > 5 ? k[5] : 0.0D;
/* 410 */     double k5 = k.length > 6 ? k[6] : 0.0D;
/* 411 */     double k6 = k.length > 7 ? k[7] : 0.0D;
/* 412 */     double p1 = k[2];
/* 413 */     double p2 = k[3];
/*     */ 
/* 415 */     double[] xd = (double[])xu.clone();
/*     */ 
/* 417 */     for (int i = 0; i < xu.length / 2; i++) {
/* 418 */       double x = xu[(i * 2)];
/* 419 */       double y = xu[(i * 2 + 1)];
/* 420 */       double r_2 = x * x + y * y;
/* 421 */       double k_radial = 1.0D + k1 * r_2 + k2 * r_2 * r_2 + k3 * r_2 * r_2 * r_2;
/* 422 */       double delta_x = 2.0D * p1 * x * y + p2 * (r_2 + 2.0D * x * x);
/* 423 */       double delta_y = p1 * (r_2 + 2.0D * y * y) + 2.0D * p2 * x * y;
/* 424 */       xd[(i * 2)] = (x * k_radial + delta_x);
/* 425 */       xd[(i * 2 + 1)] = (y * k_radial + delta_y);
/*     */     }
/* 427 */     return xd;
/*     */   }
/*     */   public double[] distort(double[] x) {
/* 430 */     double[] xn = normalize(x, this.cameraMatrix);
/* 431 */     double[] xd = distort(xn, this.distortionCoeffs.get());
/* 432 */     return unnormalize(xd, this.cameraMatrix);
/*     */   }
/*     */ 
/*     */   public static double[] normalize(double[] xu, opencv_core.CvMat K) {
/* 436 */     double[] xn = (double[])xu.clone();
/*     */ 
/* 438 */     double fx = K.get(0) / K.get(8);
/* 439 */     double fy = K.get(4) / K.get(8);
/* 440 */     double dx = K.get(2) / K.get(8);
/* 441 */     double dy = K.get(5) / K.get(8);
/* 442 */     double s = K.get(1) / K.get(8);
/* 443 */     for (int i = 0; i < xu.length / 2; i++) {
/* 444 */       xn[(i * 2)] = ((xu[(i * 2)] - dx) / fx - s * (xu[(i * 2 + 1)] + dy) / (fx * fy));
/* 445 */       xn[(i * 2 + 1)] = ((xu[(i * 2 + 1)] - dy) / fy);
/*     */     }
/* 447 */     return xn;
/*     */   }
/*     */   public static double[] unnormalize(double[] xn, opencv_core.CvMat K) {
/* 450 */     double[] xu = (double[])xn.clone();
/*     */ 
/* 452 */     double fx = K.get(0) / K.get(8);
/* 453 */     double fy = K.get(4) / K.get(8);
/* 454 */     double dx = K.get(2) / K.get(8);
/* 455 */     double dy = K.get(5) / K.get(8);
/* 456 */     double s = K.get(1) / K.get(8);
/* 457 */     for (int i = 0; i < xn.length / 2; i++) {
/* 458 */       xu[(i * 2)] = (fx * xn[(i * 2)] + dx + s * xn[(i * 2 + 1)]);
/* 459 */       xu[(i * 2 + 1)] = (fy * xn[(i * 2 + 1)] + dy);
/*     */     }
/* 461 */     return xu;
/*     */   }
/*     */ 
/*     */   public boolean isFixedPointMaps()
/*     */   {
/* 472 */     return this.fixedPointMaps;
/*     */   }
/*     */   public void setFixedPointMaps(boolean fixedPointMaps) {
/* 475 */     if (this.fixedPointMaps != fixedPointMaps) {
/* 476 */       this.fixedPointMaps = fixedPointMaps;
/* 477 */       int p = this.mapsPyramidLevel;
/*     */        tmp43_42 = (this.distortMaps1[p] =  = this.distortMaps2[p] =  = null); this.undistortMaps2[p] = tmp43_42; this.undistortMaps1[p] = tmp43_42;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getMapsPyramidLevel() {
/* 483 */     return this.mapsPyramidLevel;
/*     */   }
/*     */   public void setMapsPyramidLevel(int mapsPyramidLevel) {
/* 486 */     if (this.mapsPyramidLevel != mapsPyramidLevel) {
/* 487 */       this.mapsPyramidLevel = mapsPyramidLevel;
/* 488 */       int p = mapsPyramidLevel;
/* 489 */       if ((p >= this.undistortMaps1.length) || (p >= this.undistortMaps2.length) || (p >= this.distortMaps1.length) || (p >= this.distortMaps2.length))
/*     */       {
/* 491 */         this.undistortMaps1 = ((opencv_core.IplImage[])Arrays.copyOf(this.undistortMaps1, p + 1));
/* 492 */         this.undistortMaps2 = ((opencv_core.IplImage[])Arrays.copyOf(this.undistortMaps2, p + 1));
/* 493 */         this.distortMaps1 = ((opencv_core.IplImage[])Arrays.copyOf(this.distortMaps1, p + 1));
/* 494 */         this.distortMaps2 = ((opencv_core.IplImage[])Arrays.copyOf(this.distortMaps2, p + 1));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initUndistortMaps()
/*     */   {
/* 501 */     int p = this.mapsPyramidLevel;
/* 502 */     if ((this.undistortMaps1[p] == null) || (this.undistortMaps2[p] == null)) {
/* 503 */       if (this.fixedPointMaps) {
/* 504 */         this.undistortMaps1[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, -2147483632, 2);
/* 505 */         this.undistortMaps2[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 16, 1);
/*     */       } else {
/* 507 */         this.undistortMaps1[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
/* 508 */         this.undistortMaps2[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
/*     */       }
/* 510 */       opencv_imgproc.cvInitUndistortMap(this.cameraMatrix, this.distortionCoeffs, this.undistortMaps1[p], this.undistortMaps2[p]);
/* 511 */       if (this.mapsPyramidLevel > 0) {
/* 512 */         opencv_core.IplImage map1 = this.undistortMaps1[p];
/* 513 */         opencv_core.IplImage map2 = this.undistortMaps2[p];
/* 514 */         int w = this.imageWidth >> p;
/* 515 */         int h = this.imageHeight >> p;
/* 516 */         this.undistortMaps1[p] = opencv_core.IplImage.create(w, h, map1.depth(), map1.nChannels());
/* 517 */         this.undistortMaps2[p] = opencv_core.IplImage.create(w, h, map2.depth(), map2.nChannels());
/* 518 */         opencv_imgproc.cvResize(map1, this.undistortMaps1[p], 0);
/* 519 */         opencv_imgproc.cvResize(map2, this.undistortMaps2[p], 0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getUndistortMap1()
/*     */   {
/* 554 */     initUndistortMaps();
/* 555 */     return this.undistortMaps1[this.mapsPyramidLevel];
/*     */   }
/*     */   public opencv_core.IplImage getUndistortMap2() {
/* 558 */     initUndistortMaps();
/* 559 */     return this.undistortMaps2[this.mapsPyramidLevel];
/*     */   }
/*     */   public void undistort(opencv_core.IplImage src, opencv_core.IplImage dst) {
/* 562 */     if ((src != null) && (dst != null)) {
/* 563 */       initUndistortMaps();
/* 564 */       opencv_imgproc.cvRemap(src, dst, this.undistortMaps1[this.mapsPyramidLevel], this.undistortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
/*     */     }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage undistort(opencv_core.IplImage image) {
/* 569 */     if (image != null) {
/* 570 */       initUndistortMaps();
/* 571 */       this.tempImage = opencv_core.IplImage.createIfNotCompatible(this.tempImage, image);
/* 572 */       opencv_core.cvResetImageROI(this.tempImage);
/* 573 */       opencv_imgproc.cvRemap(image, this.tempImage, this.undistortMaps1[this.mapsPyramidLevel], this.undistortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
/*     */ 
/* 575 */       return this.tempImage;
/*     */     }
/* 577 */     return null;
/*     */   }
/*     */ 
/*     */   private void initDistortMaps() {
/* 581 */     int p = this.mapsPyramidLevel;
/* 582 */     if ((this.distortMaps1[p] == null) || (this.distortMaps2[p] == null)) {
/* 583 */       opencv_core.IplImage mapx = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
/* 584 */       opencv_core.IplImage mapy = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
/* 585 */       FloatBuffer bufx = mapx.getFloatBuffer();
/* 586 */       FloatBuffer bufy = mapy.getFloatBuffer();
/* 587 */       int width = mapx.width();
/* 588 */       int height = mapx.height();
/* 589 */       for (int y = 0; y < height; y++) {
/* 590 */         for (int x = 0; x < width; x++) {
/* 591 */           double[] distxy = undistort(new double[] { x, y });
/* 592 */           bufx.put((float)distxy[0]);
/* 593 */           bufy.put((float)distxy[1]);
/*     */         }
/*     */       }
/* 596 */       if (this.fixedPointMaps) {
/* 597 */         this.distortMaps1[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, -2147483632, 2);
/* 598 */         this.distortMaps2[p] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 16, 1);
/* 599 */         opencv_imgproc.cvConvertMaps(mapx, mapy, this.distortMaps1[p], this.distortMaps2[p]);
/* 600 */         mapx.release();
/* 601 */         mapy.release();
/*     */       } else {
/* 603 */         this.distortMaps1[p] = mapx;
/* 604 */         this.distortMaps2[p] = mapy;
/*     */       }
/* 606 */       if (this.mapsPyramidLevel > 0) {
/* 607 */         opencv_core.IplImage map1 = this.distortMaps1[p];
/* 608 */         opencv_core.IplImage map2 = this.distortMaps2[p];
/* 609 */         int w = this.imageWidth >> p;
/* 610 */         int h = this.imageHeight >> p;
/* 611 */         this.distortMaps1[p] = opencv_core.IplImage.create(w, h, map1.depth(), map1.nChannels());
/* 612 */         this.distortMaps2[p] = opencv_core.IplImage.create(w, h, map2.depth(), map2.nChannels());
/* 613 */         opencv_imgproc.cvResize(map1, this.distortMaps1[p], 0);
/* 614 */         opencv_imgproc.cvResize(map2, this.distortMaps2[p], 0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/* 619 */   public opencv_core.IplImage getDistortMap1() { initDistortMaps();
/* 620 */     return this.distortMaps1[this.mapsPyramidLevel]; }
/*     */ 
/*     */   public opencv_core.IplImage getDistortMap2() {
/* 623 */     initDistortMaps();
/* 624 */     return this.distortMaps2[this.mapsPyramidLevel];
/*     */   }
/*     */   public void distort(opencv_core.IplImage src, opencv_core.IplImage dst) {
/* 627 */     if ((src != null) && (dst != null)) {
/* 628 */       initDistortMaps();
/* 629 */       opencv_imgproc.cvRemap(src, dst, this.distortMaps1[this.mapsPyramidLevel], this.distortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
/*     */     }
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage distort(opencv_core.IplImage image) {
/* 634 */     if (image != null) {
/* 635 */       initDistortMaps();
/* 636 */       this.tempImage = opencv_core.IplImage.createIfNotCompatible(this.tempImage, image);
/* 637 */       opencv_imgproc.cvRemap(image, this.tempImage, this.distortMaps1[this.mapsPyramidLevel], this.distortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
/*     */ 
/* 639 */       return this.tempImage;
/*     */     }
/* 641 */     return null;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat getBackProjectionMatrix(opencv_core.CvMat n, double d, opencv_core.CvMat B)
/*     */   {
/* 651 */     opencv_core.CvMat temp = (opencv_core.CvMat)temp3x3.get();
/*     */ 
/* 653 */     temp.cols(1); temp.step(temp.step() / 3);
/* 654 */     B.rows(3);
/* 655 */     opencv_core.cvGEMM(this.R, this.T, -1.0D, null, 0.0D, temp, 1);
/* 656 */     opencv_core.cvGEMM(temp, n, 1.0D, null, 0.0D, B, 2);
/* 657 */     double a = opencv_core.cvDotProduct(n, temp) + d;
/* 658 */     B.put(0, B.get(0) - a);
/* 659 */     B.put(4, B.get(4) - a);
/* 660 */     B.put(8, B.get(8) - a);
/* 661 */     B.rows(4);
/* 662 */     temp.cols(3); temp.step(temp.step() * 3);
/*     */ 
/* 664 */     B.put(9, n.get());
/*     */ 
/* 666 */     opencv_core.cvMatMul(this.cameraMatrix, this.R, temp);
/* 667 */     opencv_core.cvInvert(temp, temp, 0);
/*     */ 
/* 669 */     opencv_core.cvMatMul(B, temp, B);
/* 670 */     opencv_core.cvConvertScale(B, B, 1.0D / B.get(11), 0.0D);
/*     */ 
/* 672 */     return B;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat getFrontoParallelH(double[] roipts, opencv_core.CvMat n, opencv_core.CvMat H)
/*     */   {
/* 680 */     opencv_core.CvMat B = (opencv_core.CvMat)B4x3.get(); opencv_core.CvMat a = (opencv_core.CvMat)a4x1.get(); opencv_core.CvMat t = (opencv_core.CvMat)t3x1.get();
/*     */ 
/* 683 */     double s = Math.signum(n.get(2));
/* 684 */     double[] dir = JavaCV.unitize(-s * n.get(1), s * n.get(0));
/* 685 */     double theta = Math.acos(s * n.get(2) / JavaCV.norm(n.get()));
/* 686 */     t.put(new double[] { theta * dir[0], theta * dir[1], 0.0D });
/* 687 */     opencv_calib3d.cvRodrigues2(t, H, null);
/*     */ 
/* 690 */     opencv_core.cvMatMul(this.R, H, H);
/*     */ 
/* 692 */     double x = 0.0D; double y = 0.0D;
/* 693 */     if (roipts != null)
/*     */     {
/* 695 */       double x1 = roipts[0]; double y1 = roipts[1];
/* 696 */       double x2 = roipts[4]; double y2 = roipts[5];
/* 697 */       double x3 = roipts[2]; double y3 = roipts[3];
/* 698 */       double x4 = roipts[6]; double y4 = roipts[7];
/* 699 */       double u = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
/*     */ 
/* 701 */       x = x1 + u * (x2 - x1);
/* 702 */       y = y1 + u * (y2 - y1);
/*     */     }
/*     */ 
/* 707 */     getBackProjectionMatrix(n, -1.0D, B);
/* 708 */     t.put(new double[] { x, y, 1.0D });
/* 709 */     opencv_core.cvMatMul(B, t, a);
/* 710 */     H.put(2, a.get(0) / a.get(3));
/* 711 */     H.put(5, a.get(1) / a.get(3));
/* 712 */     H.put(8, a.get(2) / a.get(3));
/*     */ 
/* 714 */     return H;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat getRectifyingHomography(ProjectiveDevice peer, opencv_core.CvMat H)
/*     */   {
/* 724 */     opencv_core.CvMat relativeR = (opencv_core.CvMat)relativeR3x3.get(); opencv_core.CvMat relativeT = (opencv_core.CvMat)relativeT3x1.get();
/* 725 */     opencv_core.cvGEMM(this.R, peer.R, 1.0D, null, 0.0D, relativeR, 2);
/* 726 */     opencv_core.cvGEMM(relativeR, peer.T, -1.0D, this.T, 1.0D, relativeT, 0);
/*     */ 
/* 728 */     opencv_core.CvMat R1 = (opencv_core.CvMat)R13x3.get(); opencv_core.CvMat P1 = (opencv_core.CvMat)P13x4.get();
/* 729 */     opencv_core.CvMat R2 = (opencv_core.CvMat)R23x3.get(); opencv_core.CvMat P2 = (opencv_core.CvMat)P23x4.get();
/* 730 */     opencv_core.CvSize imageSize = opencv_core.cvSize((peer.imageWidth + this.imageWidth) / 2, (peer.imageHeight + this.imageHeight) / 2);
/*     */ 
/* 732 */     opencv_calib3d.cvStereoRectify(peer.cameraMatrix, this.cameraMatrix, peer.distortionCoeffs, this.distortionCoeffs, imageSize, relativeR, relativeT, R1, R2, P1, P2, null, 0, -1.0D, opencv_core.CvSize.ZERO, null, null);
/*     */ 
/* 736 */     opencv_core.cvMatMul(this.cameraMatrix, R2, R2);
/* 737 */     opencv_core.cvInvert(this.cameraMatrix, R1);
/* 738 */     opencv_core.cvMatMul(R2, R1, H);
/*     */ 
/* 740 */     return H;
/*     */   }
/*     */ 
/*     */   public static ProjectiveDevice[] read(String filename)
/*     */     throws ProjectiveDevice.Exception
/*     */   {
/* 749 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 0);
/* 750 */     CameraDevice[] cameraDevices = CameraDevice.read(fs);
/* 751 */     ProjectorDevice[] projectorDevices = ProjectorDevice.read(fs);
/* 752 */     ProjectiveDevice[] devices = new ProjectiveDevice[cameraDevices.length + projectorDevices.length];
/* 753 */     int i = 0;
/* 754 */     for (ProjectiveDevice d : cameraDevices) {
/* 755 */       devices[(i++)] = d;
/*     */     }
/* 757 */     for (ProjectiveDevice d : projectorDevices) {
/* 758 */       devices[(i++)] = d;
/*     */     }
/* 760 */     fs.release();
/* 761 */     return devices;
/*     */   }
/*     */ 
/*     */   public static void write(String filename, ProjectiveDevice[][] devices) {
/* 765 */     int totalLength = 0;
/* 766 */     for (ProjectiveDevice[] ds : devices) {
/* 767 */       totalLength += ds.length;
/*     */     }
/* 769 */     ProjectiveDevice[] allDevices = new ProjectiveDevice[totalLength];
/* 770 */     int i = 0;
/* 771 */     for (ProjectiveDevice[] ds : devices) {
/* 772 */       for (ProjectiveDevice d : ds) {
/* 773 */         allDevices[(i++)] = d;
/*     */       }
/*     */     }
/* 776 */     write(filename, allDevices);
/*     */   }
/*     */   public static void write(String filename, ProjectiveDevice[] devices) {
/* 779 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 1);
/* 780 */     opencv_core.CvAttrList a = opencv_core.cvAttrList();
/*     */ 
/* 782 */     opencv_core.cvStartWriteStruct(fs, "Cameras", 5, null, a);
/* 783 */     for (ProjectiveDevice d : devices) {
/* 784 */       if ((d instanceof CameraDevice)) {
/* 785 */         opencv_core.cvWriteString(fs, null, d.getSettings().getName(), 0);
/*     */       }
/*     */     }
/* 788 */     opencv_core.cvEndWriteStruct(fs);
/*     */ 
/* 790 */     opencv_core.cvStartWriteStruct(fs, "Projectors", 5, null, a);
/* 791 */     for (ProjectiveDevice d : devices) {
/* 792 */       if ((d instanceof ProjectorDevice)) {
/* 793 */         opencv_core.cvWriteString(fs, null, d.getSettings().getName(), 0);
/*     */       }
/*     */     }
/* 796 */     opencv_core.cvEndWriteStruct(fs);
/*     */ 
/* 798 */     for (ProjectiveDevice d : devices) {
/* 799 */       d.writeParameters(fs);
/*     */     }
/* 801 */     fs.release();
/*     */   }
/*     */ 
/*     */   public void writeParameters(File file) {
/* 805 */     writeParameters(file.getAbsolutePath());
/*     */   }
/*     */   public void writeParameters(String filename) {
/* 808 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 1);
/* 809 */     writeParameters(fs);
/* 810 */     fs.release();
/*     */   }
/*     */   public void writeParameters(opencv_core.CvFileStorage fs) {
/* 813 */     opencv_core.CvAttrList a = opencv_core.cvAttrList();
/*     */ 
/* 815 */     opencv_core.cvStartWriteStruct(fs, getSettings().getName(), 6, null, a);
/*     */ 
/* 817 */     opencv_core.cvWriteInt(fs, "imageWidth", this.imageWidth);
/* 818 */     opencv_core.cvWriteInt(fs, "imageHeight", this.imageHeight);
/* 819 */     opencv_core.cvWriteReal(fs, "responseGamma", getSettings().getResponseGamma());
/*     */ 
/* 822 */     if (this.cameraMatrix != null)
/* 823 */       opencv_core.cvWrite(fs, "cameraMatrix", this.cameraMatrix, a);
/* 824 */     if (this.distortionCoeffs != null)
/* 825 */       opencv_core.cvWrite(fs, "distortionCoeffs", this.distortionCoeffs, a);
/* 826 */     if (this.extrParams != null)
/* 827 */       opencv_core.cvWrite(fs, "extrParams", this.extrParams, a);
/* 828 */     if (this.reprojErrs != null)
/* 829 */       opencv_core.cvWrite(fs, "reprojErrs", this.reprojErrs, a);
/* 830 */     opencv_core.cvWriteReal(fs, "avgReprojErr", this.avgReprojErr);
/* 831 */     opencv_core.cvWriteReal(fs, "maxReprojErr", this.maxReprojErr);
/*     */ 
/* 833 */     if (this.R != null)
/* 834 */       opencv_core.cvWrite(fs, "R", this.R, a);
/* 835 */     if (this.T != null)
/* 836 */       opencv_core.cvWrite(fs, "T", this.T, a);
/* 837 */     if (this.E != null)
/* 838 */       opencv_core.cvWrite(fs, "E", this.E, a);
/* 839 */     if (this.F != null)
/* 840 */       opencv_core.cvWrite(fs, "F", this.F, a);
/* 841 */     opencv_core.cvWriteReal(fs, "avgEpipolarErr", this.avgEpipolarErr);
/* 842 */     opencv_core.cvWriteReal(fs, "maxEpipolarErr", this.maxEpipolarErr);
/*     */ 
/* 844 */     opencv_core.cvWriteString(fs, "colorOrder", this.colorOrder, 0);
/* 845 */     if (this.colorMixingMatrix != null)
/* 846 */       opencv_core.cvWrite(fs, "colorMixingMatrix", this.colorMixingMatrix, a);
/* 847 */     if (this.additiveLight != null)
/* 848 */       opencv_core.cvWrite(fs, "additiveLight", this.additiveLight, a);
/* 849 */     opencv_core.cvWriteReal(fs, "avgColorErr", this.avgColorErr);
/* 850 */     opencv_core.cvWriteReal(fs, "colorR2", this.colorR2);
/*     */ 
/* 852 */     opencv_core.cvEndWriteStruct(fs);
/*     */   }
/*     */ 
/*     */   public void readParameters(File file) throws ProjectiveDevice.Exception {
/* 856 */     readParameters(file.getAbsolutePath());
/*     */   }
/*     */   public void readParameters(String filename) throws ProjectiveDevice.Exception {
/* 859 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 0);
/* 860 */     readParameters(fs);
/* 861 */     fs.release();
/*     */   }
/*     */   public void readParameters(opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/* 864 */     if (fs == null) {
/* 865 */       throw new Exception("Error: CvFileStorage is null, cannot read parameters for device " + getSettings().getName() + ". Is the parametersFile correct?");
/*     */     }
/*     */ 
/* 868 */     opencv_core.CvAttrList a = opencv_core.cvAttrList();
/*     */ 
/* 870 */     opencv_core.CvFileNode fn = opencv_core.cvGetFileNodeByName(fs, null, getSettings().getName());
/* 871 */     if (fn == null) {
/* 872 */       throw new Exception("Error: CvFileNode is null, cannot read parameters for device " + getSettings().getName() + ". Is the name correct?");
/*     */     }
/*     */ 
/* 876 */     this.imageWidth = opencv_core.cvReadIntByName(fs, fn, "imageWidth", this.imageWidth);
/* 877 */     this.imageHeight = opencv_core.cvReadIntByName(fs, fn, "imageHeight", this.imageHeight);
/* 878 */     getSettings().setResponseGamma(opencv_core.cvReadRealByName(fs, fn, "gamma", getSettings().getResponseGamma()));
/*     */ 
/* 881 */     Pointer p = opencv_core.cvReadByName(fs, fn, "cameraMatrix", a);
/* 882 */     this.cameraMatrix = (p == null ? null : new opencv_core.CvMat(p));
/* 883 */     p = opencv_core.cvReadByName(fs, fn, "distortionCoeffs", a);
/* 884 */     this.distortionCoeffs = (p == null ? null : new opencv_core.CvMat(p));
/* 885 */     p = opencv_core.cvReadByName(fs, fn, "extrParams", a);
/* 886 */     this.extrParams = (p == null ? null : new opencv_core.CvMat(p));
/* 887 */     p = opencv_core.cvReadByName(fs, fn, "reprojErrs", a);
/* 888 */     this.reprojErrs = (p == null ? null : new opencv_core.CvMat(p));
/* 889 */     this.avgReprojErr = opencv_core.cvReadRealByName(fs, fn, "avgReprojErr", this.avgReprojErr);
/* 890 */     this.maxReprojErr = opencv_core.cvReadRealByName(fs, fn, "maxReprojErr", this.maxReprojErr);
/*     */ 
/* 892 */     p = opencv_core.cvReadByName(fs, fn, "R", a);
/* 893 */     this.R = (p == null ? null : new opencv_core.CvMat(p));
/* 894 */     p = opencv_core.cvReadByName(fs, fn, "T", a);
/* 895 */     this.T = (p == null ? null : new opencv_core.CvMat(p));
/* 896 */     p = opencv_core.cvReadByName(fs, fn, "E", a);
/* 897 */     this.E = (p == null ? null : new opencv_core.CvMat(p));
/* 898 */     p = opencv_core.cvReadByName(fs, fn, "F", a);
/* 899 */     this.F = (p == null ? null : new opencv_core.CvMat(p));
/* 900 */     this.avgEpipolarErr = opencv_core.cvReadRealByName(fs, fn, "avgEpipolarErr", this.avgEpipolarErr);
/* 901 */     this.maxEpipolarErr = opencv_core.cvReadRealByName(fs, fn, "maxEpipolarErr", this.maxEpipolarErr);
/*     */ 
/* 903 */     this.colorOrder = opencv_core.cvReadStringByName(fs, fn, "colorOrder", this.colorOrder);
/* 904 */     p = opencv_core.cvReadByName(fs, fn, "colorMixingMatrix", a);
/* 905 */     this.colorMixingMatrix = (p == null ? null : new opencv_core.CvMat(p));
/* 906 */     p = opencv_core.cvReadByName(fs, fn, "additiveLight", a);
/* 907 */     this.additiveLight = (p == null ? null : new opencv_core.CvMat(p));
/* 908 */     this.avgColorErr = opencv_core.cvReadRealByName(fs, fn, "avgColorErr", this.avgColorErr);
/* 909 */     this.colorR2 = opencv_core.cvReadRealByName(fs, fn, "colorR2", this.colorR2);
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 913 */     String s = getSettings().getName() + " (" + this.imageWidth + " x " + this.imageHeight + ")\n";
/*     */ 
/* 915 */     for (int i = 0; i < getSettings().getName().length(); i++) {
/* 916 */       s = s + "=";
/*     */     }
/* 918 */     s = s + "\nIntrinsics\n----------\ncamera matrix = " + (this.cameraMatrix == null ? "null" : this.cameraMatrix.toString(16)) + "\n" + "distortion coefficients = " + (this.distortionCoeffs == null ? "null" : this.distortionCoeffs) + "\n" + "reprojection RMS/max error (pixels) = " + (float)this.avgReprojErr + " / " + (float)this.maxReprojErr + "\n\n" + "Extrinsics\n" + "----------\n" + "rotation = " + (this.R == null ? "null" : this.R.toString(11)) + "\n" + "translation = " + (this.T == null ? "null" : this.T.toString(14)) + "\n" + "epipolar RMS/max error (pixels) = " + (float)this.avgEpipolarErr + " / " + (float)this.maxEpipolarErr + "\n\n" + "Color\n" + "-----\n" + "order = " + this.colorOrder + "\n" + "mixing matrix = " + (this.colorMixingMatrix == null ? "null" : this.colorMixingMatrix.toString(16)) + "\n" + "additive light = " + (this.additiveLight == null ? "null" : this.additiveLight.toString(17)) + "\n" + "normalized RMSE (intensity) = " + (float)this.avgColorErr + "\n" + "R^2 (intensity) = " + (float)this.colorR2;
/*     */ 
/* 939 */     return s;
/*     */   }
/*     */ 
/*     */   public static class Exception extends Exception
/*     */   {
/*     */     public Exception(String message)
/*     */     {
/* 744 */       super(); } 
/* 745 */     public Exception(String message, Throwable cause) { super(cause); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class CalibratedSettings extends ProjectiveDevice.Settings
/*     */   {
/* 274 */     File parametersFile = new File("calibration.yaml");
/*     */ 
/*     */     public CalibratedSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibratedSettings(CalibratedSettings settings)
/*     */     {
/* 271 */       super();
/* 272 */       this.parametersFile = settings.parametersFile;
/*     */     }
/*     */ 
/*     */     public File getParametersFile()
/*     */     {
/* 277 */       return this.parametersFile;
/*     */     }
/*     */     public void setParametersFile(File parametersFile) {
/* 280 */       this.parametersFile = parametersFile;
/*     */     }
/*     */     public String getParametersFilename() {
/* 283 */       return this.parametersFile == null ? "" : this.parametersFile.getPath();
/*     */     }
/*     */     public void setParametersFilename(String parametersFilename) {
/* 286 */       this.parametersFile = ((parametersFilename == null) || (parametersFilename.length() == 0) ? null : new File(parametersFilename));
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CalibrationSettings extends ProjectiveDevice.Settings
/*     */   {
/* 102 */     double initAspectRatio = 1.0D;
/* 103 */     int flags = 14720;
/*     */ 
/*     */     public CalibrationSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibrationSettings(CalibrationSettings settings)
/*     */     {
/*  97 */       super();
/*  98 */       this.initAspectRatio = settings.initAspectRatio;
/*  99 */       this.flags = settings.flags;
/*     */     }
/*     */ 
/*     */     public double getInitAspectRatio()
/*     */     {
/* 107 */       return this.initAspectRatio;
/*     */     }
/*     */     public void setInitAspectRatio(double initAspectRatio) {
/* 110 */       this.initAspectRatio = initAspectRatio;
/*     */     }
/*     */ 
/*     */     public boolean isUseIntrinsicGuess() {
/* 114 */       return (this.flags & 0x1) != 0;
/*     */     }
/*     */     public void setUseIntrinsicGuess(boolean useIntrinsicGuess) {
/* 117 */       if (useIntrinsicGuess)
/* 118 */         this.flags |= 1;
/*     */       else
/* 120 */         this.flags &= -2;
/*     */     }
/*     */ 
/*     */     public boolean isFixAspectRatio()
/*     */     {
/* 125 */       return (this.flags & 0x2) != 0;
/*     */     }
/*     */     public void setFixAspectRatio(boolean fixAspectRatio) {
/* 128 */       if (fixAspectRatio)
/* 129 */         this.flags |= 2;
/*     */       else
/* 131 */         this.flags &= -3;
/*     */     }
/*     */ 
/*     */     public boolean isFixPrincipalPoint()
/*     */     {
/* 136 */       return (this.flags & 0x4) != 0;
/*     */     }
/*     */     public void setFixPrincipalPoint(boolean fixPrincipalPoint) {
/* 139 */       if (fixPrincipalPoint)
/* 140 */         this.flags |= 4;
/*     */       else
/* 142 */         this.flags &= -5;
/*     */     }
/*     */ 
/*     */     public boolean isZeroTangentDist()
/*     */     {
/* 147 */       return (this.flags & 0x8) != 0;
/*     */     }
/*     */     public void setZeroTangentDist(boolean zeroTangentDist) {
/* 150 */       if (zeroTangentDist)
/* 151 */         this.flags |= 8;
/*     */       else
/* 153 */         this.flags &= -9;
/*     */     }
/*     */ 
/*     */     public boolean isFixFocalLength()
/*     */     {
/* 158 */       return (this.flags & 0x10) != 0;
/*     */     }
/*     */     public void setFixFocalLength(boolean fixFocalLength) {
/* 161 */       if (fixFocalLength)
/* 162 */         this.flags |= 16;
/*     */       else
/* 164 */         this.flags &= -17;
/*     */     }
/*     */ 
/*     */     public boolean isFixK1()
/*     */     {
/* 169 */       return (this.flags & 0x20) != 0;
/*     */     }
/*     */     public void setFixK1(boolean fixK1) {
/* 172 */       if (fixK1)
/* 173 */         this.flags |= 32;
/*     */       else
/* 175 */         this.flags &= -33;
/*     */     }
/*     */ 
/*     */     public boolean isFixK2()
/*     */     {
/* 180 */       return (this.flags & 0x40) != 0;
/*     */     }
/*     */     public void setFixK2(boolean fixK2) {
/* 183 */       if (fixK2)
/* 184 */         this.flags |= 64;
/*     */       else
/* 186 */         this.flags &= -65;
/*     */     }
/*     */ 
/*     */     public boolean isFixK3()
/*     */     {
/* 191 */       return (this.flags & 0x80) != 0;
/*     */     }
/*     */     public void setFixK3(boolean fixK3) {
/* 194 */       if (fixK3)
/* 195 */         this.flags |= 128;
/*     */       else
/* 197 */         this.flags &= -129;
/*     */     }
/*     */ 
/*     */     public boolean isFixK4()
/*     */     {
/* 202 */       return (this.flags & 0x800) != 0;
/*     */     }
/*     */     public void setFixK4(boolean fixK4) {
/* 205 */       if (fixK4)
/* 206 */         this.flags |= 2048;
/*     */       else
/* 208 */         this.flags &= -2049;
/*     */     }
/*     */ 
/*     */     public boolean isFixK5()
/*     */     {
/* 213 */       return (this.flags & 0x1000) != 0;
/*     */     }
/*     */     public void setFixK5(boolean fixK5) {
/* 216 */       if (fixK5)
/* 217 */         this.flags |= 4096;
/*     */       else
/* 219 */         this.flags &= -4097;
/*     */     }
/*     */ 
/*     */     public boolean isFixK6()
/*     */     {
/* 224 */       return (this.flags & 0x2000) != 0;
/*     */     }
/*     */     public void setFixK6(boolean fixK6) {
/* 227 */       if (fixK6)
/* 228 */         this.flags |= 8192;
/*     */       else
/* 230 */         this.flags &= -8193;
/*     */     }
/*     */ 
/*     */     public boolean isRationalModel()
/*     */     {
/* 235 */       return (this.flags & 0x4000) != 0;
/*     */     }
/*     */     public void setRationalModel(boolean rationalModel) {
/* 238 */       if (rationalModel)
/* 239 */         this.flags |= 16384;
/*     */       else
/* 241 */         this.flags &= -16385;
/*     */     }
/*     */ 
/*     */     public boolean isStereoFixIntrinsic()
/*     */     {
/* 246 */       return (this.flags & 0x100) != 0;
/*     */     }
/*     */     public void setStereoFixIntrinsic(boolean stereoFixIntrinsic) {
/* 249 */       if (stereoFixIntrinsic)
/* 250 */         this.flags |= 256;
/*     */       else
/* 252 */         this.flags &= -257;
/*     */     }
/*     */ 
/*     */     public boolean isStereoSameFocalLength()
/*     */     {
/* 257 */       return (this.flags & 0x200) != 0;
/*     */     }
/*     */     public void setStereoSameFocalLength(boolean stereoSameFocalLength) {
/* 260 */       if (stereoSameFocalLength)
/* 261 */         this.flags |= 512;
/*     */       else
/* 263 */         this.flags &= -513;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  68 */     String name = "";
/*  69 */     double responseGamma = 0.0D;
/*     */ 
/*     */     public Settings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Settings(Settings settings)
/*     */     {
/*  64 */       this.name = settings.name;
/*  65 */       this.responseGamma = settings.responseGamma;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/*  73 */       return this.name;
/*     */     }
/*     */     public void setName(String name) {
/*  76 */       firePropertyChange("name", this.name, this.name = name);
/*     */     }
/*     */ 
/*     */     public double getResponseGamma() {
/*  80 */       return this.responseGamma;
/*     */     }
/*     */     public void setResponseGamma(double responseGamma) {
/*  83 */       this.responseGamma = responseGamma;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectiveDevice
 * JD-Core Version:    0.6.2
 */