/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplROI;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class GNImageAligner
/*     */   implements ImageAligner
/*     */ {
/*     */   protected Settings settings;
/*     */   protected final int n;
/*     */   protected opencv_core.IplImage[] template;
/*     */   protected opencv_core.IplImage[] target;
/*     */   protected opencv_core.IplImage[] transformed;
/*     */   protected opencv_core.IplImage[] residual;
/*     */   protected opencv_core.IplImage[] mask;
/* 221 */   protected opencv_core.IplImage[] images = new opencv_core.IplImage[5];
/*     */   protected opencv_core.CvMat srcRoiPts;
/*     */   protected opencv_core.CvMat dstRoiPts;
/*     */   protected opencv_core.CvPoint dstRoiPtsArray;
/*     */   protected opencv_core.CvRect roi;
/*     */   protected opencv_core.CvRect temproi;
/*     */   protected ImageTransformer transformer;
/*     */   protected ImageTransformer.Data[] hessianGradientTransformerData;
/*     */   protected ImageTransformer.Data[] residualTransformerData;
/*     */   protected ImageTransformer.Parameters parameters;
/*     */   protected ImageTransformer.Parameters[] parametersArray;
/*     */   protected ImageTransformer.Parameters[] tempParameters;
/*     */   protected ImageTransformer.Parameters priorParameters;
/*     */   protected opencv_core.CvMat hessian;
/*     */   protected opencv_core.CvMat gradient;
/*     */   protected opencv_core.CvMat update;
/*     */   protected opencv_core.CvMat prior;
/*     */   protected double[] constraintGrad;
/*     */   protected double[] subspaceResidual;
/*     */   protected double[][] subspaceJacobian;
/*     */   protected double[] updateScale;
/*     */   protected boolean[] subspaceCorrelated;
/*     */   protected int pyramidLevel;
/*     */   protected double RMSE;
/* 233 */   protected boolean residualUpdateNeeded = true;
/* 234 */   protected int lastLinePosition = 0;
/* 235 */   protected int trials = 0;
/*     */   protected double[] subspaceParameters;
/*     */   protected double[][] tempSubspaceParameters;
/*     */ 
/*     */   public GNImageAligner(ImageTransformer transformer, ImageTransformer.Parameters initialParameters, opencv_core.IplImage template0, double[] roiPts, opencv_core.IplImage target0)
/*     */   {
/*  37 */     this(transformer, initialParameters, template0, roiPts, target0, new Settings());
/*     */   }
/*     */ 
/*     */   public GNImageAligner(ImageTransformer transformer, ImageTransformer.Parameters initialParameters, opencv_core.IplImage template0, double[] roiPts, opencv_core.IplImage target0, Settings settings) {
/*  41 */     this(transformer, initialParameters);
/*  42 */     setSettings(settings);
/*     */ 
/*  44 */     int minLevel = settings.pyramidLevelMin;
/*  45 */     int maxLevel = settings.pyramidLevelMax;
/*     */ 
/*  47 */     this.template = new opencv_core.IplImage[maxLevel + 1];
/*  48 */     this.target = new opencv_core.IplImage[maxLevel + 1];
/*  49 */     this.transformed = new opencv_core.IplImage[maxLevel + 1];
/*  50 */     this.residual = new opencv_core.IplImage[maxLevel + 1];
/*  51 */     this.mask = new opencv_core.IplImage[maxLevel + 1];
/*  52 */     int w = template0 != null ? template0.width() : target0.width();
/*  53 */     int h = template0 != null ? template0.height() : target0.height();
/*  54 */     int c = template0 != null ? template0.nChannels() : target0.nChannels();
/*  55 */     int o = template0 != null ? template0.origin() : target0.origin();
/*  56 */     for (int i = minLevel; i <= maxLevel; i++) {
/*  57 */       if ((i == minLevel) && (template0 != null) && (template0.depth() == 32))
/*  58 */         this.template[i] = template0;
/*     */       else {
/*  60 */         this.template[i] = opencv_core.IplImage.create(w, h, 32, c, o);
/*     */       }
/*  62 */       if ((i == minLevel) && (target0 != null) && (target0.depth() == 32))
/*  63 */         this.target[i] = target0;
/*     */       else {
/*  65 */         this.target[i] = opencv_core.IplImage.create(w, h, 32, c, o);
/*     */       }
/*  67 */       this.transformed[i] = opencv_core.IplImage.create(w, h, 32, c, o);
/*  68 */       this.residual[i] = opencv_core.IplImage.create(w, h, 32, c, o);
/*  69 */       this.mask[i] = opencv_core.IplImage.create(w, h, 8, 1, o);
/*  70 */       w /= 2;
/*  71 */       h /= 2;
/*     */     }
/*     */ 
/*  74 */     this.hessianGradientTransformerData = new ImageTransformer.Data[this.n];
/*  75 */     for (int i = 0; i < this.n; i++) {
/*  76 */       this.hessianGradientTransformerData[i] = new ImageTransformer.Data(this.template[this.pyramidLevel], this.transformed[this.pyramidLevel], this.residual[this.pyramidLevel], this.mask[this.pyramidLevel], 0.0D, 0.0D, this.pyramidLevel, null, null, this.n);
/*     */     }
/*     */ 
/*  80 */     this.residualTransformerData = new ImageTransformer.Data[] { new ImageTransformer.Data(this.template[this.pyramidLevel], this.target[this.pyramidLevel], null, this.mask[this.pyramidLevel], 0.0D, 0.0D, this.pyramidLevel, this.transformed[this.pyramidLevel], this.residual[this.pyramidLevel], 1) };
/*     */ 
/*  84 */     setConstrained(settings.constrained);
/*  85 */     setTemplateImage(template0, roiPts);
/*  86 */     setTargetImage(target0);
/*     */   }
/*     */   protected GNImageAligner(ImageTransformer transformer, ImageTransformer.Parameters initialParameters) {
/*  89 */     this.n = initialParameters.size();
/*     */ 
/*  91 */     this.srcRoiPts = opencv_core.CvMat.create(4, 1, 6, 2);
/*  92 */     this.dstRoiPts = opencv_core.CvMat.create(4, 1, 6, 2);
/*  93 */     this.dstRoiPtsArray = new opencv_core.CvPoint(4);
/*  94 */     this.roi = new opencv_core.CvRect();
/*  95 */     this.temproi = new opencv_core.CvRect();
/*  96 */     this.transformer = transformer;
/*     */ 
/*  98 */     this.parameters = initialParameters.clone();
/*  99 */     this.parametersArray = new ImageTransformer.Parameters[] { this.parameters };
/* 100 */     this.tempParameters = new ImageTransformer.Parameters[this.n];
/* 101 */     for (int i = 0; i < this.tempParameters.length; i++) {
/* 102 */       this.tempParameters[i] = initialParameters.clone();
/*     */     }
/*     */ 
/* 105 */     this.subspaceParameters = this.parameters.getSubspace();
/* 106 */     if (this.subspaceParameters != null) {
/* 107 */       this.tempSubspaceParameters = new double[Parallel.getNumThreads()][];
/* 108 */       for (int i = 0; i < this.tempSubspaceParameters.length; i++)
/* 109 */         this.tempSubspaceParameters[i] = ((double[])this.subspaceParameters.clone());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Settings getSettings()
/*     */   {
/* 213 */     return this.settings;
/*     */   }
/*     */   public void setSettings(ImageAligner.Settings settings) {
/* 216 */     this.settings = ((Settings)settings);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTemplateImage()
/*     */   {
/* 241 */     return this.template[this.pyramidLevel];
/*     */   }
/*     */   public void setTemplateImage(opencv_core.IplImage template0, double[] roiPts) {
/* 244 */     int minLevel = this.settings.pyramidLevelMin;
/* 245 */     int maxLevel = this.settings.pyramidLevelMax;
/*     */ 
/* 247 */     if ((roiPts == null) && (template0 != null)) {
/* 248 */       int w = template0.width() << minLevel;
/* 249 */       int h = template0.height() << minLevel;
/* 250 */       this.srcRoiPts.put(new double[] { 0.0D, 0.0D, w, 0.0D, w, h, 0.0D, h });
/* 251 */     } else if (roiPts != null) {
/* 252 */       this.srcRoiPts.put(roiPts);
/*     */     }
/*     */ 
/* 255 */     if (template0 == null) {
/* 256 */       return;
/*     */     }
/*     */ 
/* 259 */     if (template0.depth() == 32)
/* 260 */       this.template[minLevel] = template0;
/*     */     else {
/* 262 */       opencv_core.cvConvertScale(template0, this.template[minLevel], 1.0D / template0.highValue(), 0.0D);
/*     */     }
/*     */ 
/* 265 */     for (int i = minLevel + 1; i <= maxLevel; i++) {
/* 266 */       opencv_imgproc.cvPyrDown(this.template[(i - 1)], this.template[i], 7);
/*     */     }
/* 268 */     setPyramidLevel(maxLevel);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTargetImage() {
/* 272 */     return this.target[this.pyramidLevel];
/*     */   }
/*     */   public void setTargetImage(opencv_core.IplImage target0) {
/* 275 */     int minLevel = this.settings.pyramidLevelMin;
/* 276 */     int maxLevel = this.settings.pyramidLevelMax;
/*     */ 
/* 278 */     if (target0 == null) {
/* 279 */       return;
/*     */     }
/*     */ 
/* 282 */     if (target0.depth() == 32) {
/* 283 */       this.target[minLevel] = target0;
/*     */     }
/*     */ 
/* 286 */     if (this.settings.displacementMax > 0.0D) {
/* 287 */       this.transformer.transform(this.srcRoiPts, this.dstRoiPts, this.parameters, false);
/* 288 */       double[] pts = this.dstRoiPts.get();
/* 289 */       for (int i = 0; i < pts.length; i++) {
/* 290 */         pts[i] /= (1 << minLevel);
/*     */       }
/* 292 */       int width = this.target[minLevel].width();
/* 293 */       int height = this.target[minLevel].height();
/* 294 */       this.temproi.x(0).y(0).width(width).height(height);
/* 295 */       int padX = (int)Math.round(this.settings.displacementMax * width);
/* 296 */       int padY = (int)Math.round(this.settings.displacementMax * height);
/* 297 */       int align = 1 << maxLevel + 1;
/*     */ 
/* 299 */       JavaCV.boundingRect(pts, this.temproi, padX + 3, padY + 3, align, align);
/* 300 */       opencv_core.cvSetImageROI(target0, this.temproi);
/* 301 */       opencv_core.cvSetImageROI(this.target[minLevel], this.temproi);
/*     */     } else {
/* 303 */       opencv_core.cvResetImageROI(target0);
/* 304 */       opencv_core.cvResetImageROI(this.target[minLevel]);
/*     */     }
/*     */ 
/* 307 */     if (target0.depth() != 32) {
/* 308 */       opencv_core.cvConvertScale(target0, this.target[minLevel], 1.0D / target0.highValue(), 0.0D);
/* 309 */       opencv_core.cvResetImageROI(target0);
/*     */     }
/*     */ 
/* 312 */     for (int i = minLevel + 1; i <= maxLevel; i++) {
/* 313 */       opencv_core.IplROI ir = this.target[(i - 1)].roi();
/* 314 */       if (ir != null) {
/* 315 */         this.temproi.x(ir.xOffset() / 2); this.temproi.width(ir.width() / 2);
/* 316 */         this.temproi.y(ir.yOffset() / 2); this.temproi.height(ir.height() / 2);
/* 317 */         opencv_core.cvSetImageROI(this.target[i], this.temproi);
/*     */       } else {
/* 319 */         opencv_core.cvResetImageROI(this.target[i]);
/*     */       }
/*     */ 
/* 326 */       opencv_imgproc.cvPyrDown(this.target[(i - 1)], this.target[i], 7);
/*     */     }
/*     */ 
/* 329 */     setPyramidLevel(maxLevel);
/*     */   }
/*     */ 
/*     */   public int getPyramidLevel() {
/* 333 */     return this.pyramidLevel;
/*     */   }
/*     */   public void setPyramidLevel(int pyramidLevel) {
/* 336 */     this.pyramidLevel = pyramidLevel;
/* 337 */     this.residualUpdateNeeded = true;
/* 338 */     this.trials = 0;
/*     */   }
/*     */ 
/*     */   public boolean isConstrained() {
/* 342 */     return this.settings.constrained;
/*     */   }
/*     */   public void setConstrained(boolean constrained) {
/* 345 */     if ((this.settings.constrained == constrained) && (this.hessian != null) && (this.gradient != null) && (this.update != null))
/*     */     {
/* 347 */       return;
/*     */     }
/* 349 */     this.settings.constrained = constrained;
/* 350 */     int m = constrained ? this.n + 1 : this.n;
/* 351 */     if ((this.subspaceParameters != null) && (this.settings.alphaSubspace != 0.0D)) {
/* 352 */       m += this.subspaceParameters.length;
/*     */     }
/* 354 */     this.hessian = opencv_core.CvMat.create(m, m);
/* 355 */     this.gradient = opencv_core.CvMat.create(m, 1);
/* 356 */     this.update = opencv_core.CvMat.create(m, 1);
/* 357 */     this.updateScale = new double[m];
/* 358 */     this.prior = opencv_core.CvMat.create(this.n, 1);
/*     */ 
/* 360 */     this.constraintGrad = new double[this.n];
/* 361 */     this.subspaceResidual = new double[this.n];
/* 362 */     this.subspaceJacobian = new double[m][this.n];
/* 363 */     this.subspaceCorrelated = new boolean[this.n];
/*     */   }
/*     */ 
/*     */   public ImageTransformer.Parameters getParameters() {
/* 367 */     return this.parameters;
/*     */   }
/*     */   public void setParameters(ImageTransformer.Parameters parameters) {
/* 370 */     this.parameters.set(parameters);
/* 371 */     this.subspaceParameters = parameters.getSubspace();
/* 372 */     if ((this.subspaceParameters != null) && (this.settings.alphaSubspace != 0.0D)) {
/* 373 */       for (int i = 0; i < this.tempSubspaceParameters.length; i++) {
/* 374 */         this.tempSubspaceParameters[i] = ((double[])this.subspaceParameters.clone());
/*     */       }
/*     */     }
/* 377 */     this.residualUpdateNeeded = true;
/*     */   }
/*     */ 
/*     */   public ImageTransformer.Parameters getPriorParameters() {
/* 381 */     return this.priorParameters;
/*     */   }
/*     */   public void setPriorParameters(ImageTransformer.Parameters priorParameters) {
/* 384 */     this.priorParameters.set(priorParameters);
/*     */   }
/*     */ 
/*     */   public double[] getTransformedRoiPts() {
/* 388 */     if (this.residualUpdateNeeded) {
/* 389 */       doRoi();
/* 390 */       doResidual();
/*     */     }
/* 392 */     return this.dstRoiPts.get();
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTransformedImage() {
/* 396 */     if (this.residualUpdateNeeded) {
/* 397 */       doRoi();
/* 398 */       doResidual();
/*     */     }
/* 400 */     return this.transformed[this.pyramidLevel];
/*     */   }
/*     */   public opencv_core.IplImage getResidualImage() {
/* 403 */     if (this.residualUpdateNeeded) {
/* 404 */       doRoi();
/* 405 */       doResidual();
/*     */     }
/* 407 */     return this.residual[this.pyramidLevel];
/*     */   }
/*     */   public opencv_core.IplImage getMaskImage() {
/* 410 */     return this.mask[this.pyramidLevel];
/*     */   }
/*     */ 
/*     */   public double getRMSE() {
/* 414 */     if (this.residualUpdateNeeded) {
/* 415 */       doRoi();
/* 416 */       doResidual();
/*     */     }
/* 418 */     return this.RMSE;
/*     */   }
/*     */ 
/*     */   public int getPixelCount() {
/* 422 */     if (this.residualUpdateNeeded) {
/* 423 */       doRoi();
/* 424 */       doResidual();
/*     */     }
/* 426 */     return this.residualTransformerData[0].dstCount;
/*     */   }
/*     */ 
/*     */   public int getOutlierCount() {
/* 430 */     return this.hessianGradientTransformerData[0].dstCountOutlier;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvRect getRoi() {
/* 434 */     if (this.residualUpdateNeeded) {
/* 435 */       doRoi();
/*     */     }
/* 437 */     return this.roi;
/*     */   }
/*     */   public int getLastLinePosition() {
/* 440 */     return this.lastLinePosition;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage[] getImages() {
/* 444 */     this.images[0] = getTemplateImage();
/* 445 */     this.images[1] = getTargetImage();
/* 446 */     this.images[2] = getTransformedImage();
/* 447 */     this.images[3] = getResidualImage();
/* 448 */     this.images[4] = getMaskImage();
/* 449 */     return this.images;
/*     */   }
/*     */ 
/*     */   public boolean iterate(double[] delta) {
/* 453 */     boolean converged = false;
/* 454 */     double prevRMSE = getRMSE();
/* 455 */     double[] prevParameters = this.parameters.get();
/* 456 */     double[] prevSubspaceParameters = this.subspaceParameters == null ? null : (double[])this.subspaceParameters.clone();
/*     */ 
/* 458 */     if ((this.trials == 0) && (this.parameters.preoptimize())) {
/* 459 */       setParameters(this.parameters);
/* 460 */       doResidual();
/*     */     }
/* 462 */     double[] resetParameters = this.parameters.get();
/* 463 */     double[] resetSubspaceParameters = this.subspaceParameters == null ? null : (double[])this.subspaceParameters.clone();
/*     */ 
/* 465 */     doHessianGradient(this.updateScale);
/*     */ 
/* 467 */     this.lastLinePosition = 0;
/*     */ 
/* 470 */     opencv_core.cvSolve(this.hessian, this.gradient, this.update, 1);
/* 471 */     for (int i = 0; i < this.n; i++) {
/* 472 */       this.parameters.set(i, this.parameters.get(i) + this.settings.lineSearch[0] * this.update.get(i) * this.updateScale[i]);
/*     */     }
/* 474 */     for (int i = this.n; i < this.update.length(); i++) {
/* 475 */       this.subspaceParameters[(i - this.n)] += this.settings.lineSearch[0] * this.update.get(i) * this.updateScale[i];
/*     */     }
/* 477 */     this.residualUpdateNeeded = true;
/*     */ 
/* 479 */     for (int j = 1; (j < this.settings.lineSearch.length) && (getRMSE() > prevRMSE); j++) {
/* 480 */       this.RMSE = prevRMSE;
/* 481 */       this.parameters.set(resetParameters);
/* 482 */       if (this.subspaceParameters != null) {
/* 483 */         System.arraycopy(resetSubspaceParameters, 0, this.subspaceParameters, 0, this.subspaceParameters.length);
/*     */       }
/* 485 */       this.lastLinePosition = j;
/* 486 */       for (int i = 0; i < this.n; i++) {
/* 487 */         this.parameters.set(i, this.parameters.get(i) + this.settings.lineSearch[j] * this.update.get(i) * this.updateScale[i]);
/*     */       }
/* 489 */       for (int i = this.n; i < this.update.length(); i++) {
/* 490 */         this.subspaceParameters[(i - this.n)] += this.settings.lineSearch[j] * this.update.get(i) * this.updateScale[i];
/*     */       }
/* 492 */       this.residualUpdateNeeded = true;
/*     */     }
/*     */ 
/* 495 */     double deltaNorm = 0.0D;
/* 496 */     if (delta != null) {
/* 497 */       for (int i = 0; (i < delta.length) && (i < this.updateScale.length); i++) {
/* 498 */         delta[i] = (this.settings.lineSearch[this.lastLinePosition] * this.update.get(i) * this.updateScale[i]);
/*     */       }
/* 500 */       deltaNorm = JavaCV.norm(Arrays.copyOf(delta, this.n));
/*     */     }
/*     */ 
/* 503 */     boolean invalid = (getRMSE() > prevRMSE) || (deltaNorm > this.settings.deltaMax) || (Double.isNaN(this.RMSE)) || (Double.isInfinite(this.RMSE));
/*     */ 
/* 505 */     if (invalid) {
/* 506 */       this.RMSE = prevRMSE;
/* 507 */       this.parameters.set(prevParameters);
/* 508 */       if (this.subspaceParameters != null) {
/* 509 */         System.arraycopy(prevSubspaceParameters, 0, this.subspaceParameters, 0, this.subspaceParameters.length);
/*     */       }
/* 511 */       this.residualUpdateNeeded = true;
/*     */     }
/* 513 */     if ((invalid) && (deltaNorm > this.settings.deltaMin) && (++this.trials < 2))
/* 514 */       return false;
/* 515 */     if ((invalid) || (deltaNorm < this.settings.deltaMin)) {
/* 516 */       this.trials = 0;
/* 517 */       if (this.pyramidLevel > this.settings.pyramidLevelMin)
/* 518 */         setPyramidLevel(this.pyramidLevel - 1);
/*     */       else
/* 520 */         converged = true;
/*     */     }
/*     */     else {
/* 523 */       this.trials = 0;
/*     */     }
/* 525 */     return converged;
/*     */   }
/*     */ 
/*     */   protected void doHessianGradient(double[] scale) {
/* 529 */     final double constraintError = this.parameters.getConstraintError();
/* 530 */     final double stepSize = this.settings.stepSize;
/*     */ 
/* 532 */     opencv_core.cvSetZero(this.gradient);
/* 533 */     opencv_core.cvSetZero(this.hessian);
/*     */ 
/* 535 */     Parallel.loop(0, this.n, new Parallel.Looper()
/*     */     {
/*     */       public void loop(int from, int to, int looperID) {
/* 538 */         for (int i = from; i < to; i++) {
/* 539 */           GNImageAligner.this.tempParameters[i].set(GNImageAligner.this.parameters);
/* 540 */           GNImageAligner.this.tempParameters[i].set(i, GNImageAligner.this.tempParameters[i].get(i) + stepSize);
/* 541 */           constraintError[i] = (GNImageAligner.this.tempParameters[i].get(i) - GNImageAligner.this.parameters.get(i));
/* 542 */           GNImageAligner.this.constraintGrad[i] = (GNImageAligner.this.tempParameters[i].getConstraintError() - this.val$constraintError);
/*     */         }
/*     */       }
/*     */     });
/* 546 */     for (int i = 0; i < this.n; i++) {
/* 547 */       ImageTransformer.Data d = this.hessianGradientTransformerData[i];
/* 548 */       d.srcImg = this.template[this.pyramidLevel];
/* 549 */       d.subImg = this.transformed[this.pyramidLevel];
/* 550 */       d.srcDotImg = this.residual[this.pyramidLevel];
/* 551 */       d.transImg = null;
/* 552 */       d.dstImg = null;
/* 553 */       d.mask = this.mask[this.pyramidLevel];
/* 554 */       d.zeroThreshold = this.settings.thresholdsZero[Math.min(this.settings.thresholdsZero.length - 1, this.pyramidLevel)];
/* 555 */       d.outlierThreshold = this.settings.thresholdsOutlier[Math.min(this.settings.thresholdsOutlier.length - 1, this.pyramidLevel)];
/* 556 */       if (this.settings.thresholdsMulRMSE) {
/* 557 */         d.zeroThreshold *= this.RMSE;
/* 558 */         d.outlierThreshold *= this.RMSE;
/*     */       }
/* 560 */       d.pyramidLevel = this.pyramidLevel;
/*     */     }
/* 562 */     this.transformer.transform(this.hessianGradientTransformerData, this.roi, this.tempParameters, null);
/*     */ 
/* 567 */     for (int i = 0; i < this.n; i++) {
/* 568 */       ImageTransformer.Data d = this.hessianGradientTransformerData[i];
/* 569 */       this.gradient.put(i, this.gradient.get(i) - d.srcDstDot);
/* 570 */       for (int j = 0; j < this.n; j++) {
/* 571 */         this.hessian.put(i, j, this.hessian.get(i, j) + d.dstDstDot.get(j));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 577 */     doRegularization(this.updateScale);
/*     */   }
/*     */ 
/*     */   protected void doRegularization(final double[] scale) {
/* 581 */     double constraintError = this.parameters.getConstraintError();
/* 582 */     final double stepSize = this.settings.stepSize;
/*     */ 
/* 586 */     if (((this.settings.gammaTgamma != null) || (this.settings.alphaTikhonov != 0.0D)) && (this.prior != null) && (this.priorParameters != null))
/*     */     {
/* 588 */       for (int i = 0; i < this.n; i++) {
/* 589 */         this.prior.put(i, this.parameters.get(i) - this.priorParameters.get(i));
/*     */       }
/* 591 */       opencv_core.cvMatMul(this.hessian, this.prior, this.prior);
/*     */ 
/* 594 */       for (int i = 0; i < this.n; i++) {
/* 595 */         this.gradient.put(i, this.gradient.get(i) + this.prior.get(i));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 600 */     if (this.settings.constrained)
/*     */     {
/* 603 */       double constraintGradSum = 0.0D;
/* 604 */       for (double d : this.constraintGrad) {
/* 605 */         constraintGradSum += d;
/*     */       }
/* 607 */       scale[this.n] = (this.n * constraintGradSum);
/*     */ 
/* 609 */       for (int i = 0; i < this.n; i++) {
/* 610 */         double c = this.constraintGrad[i] * scale[this.n];
/* 611 */         this.hessian.put(i, this.n, c);
/* 612 */         this.hessian.put(this.n, i, c);
/*     */       }
/* 614 */       this.gradient.put(this.n, -constraintError * scale[this.n]);
/*     */     }
/*     */ 
/* 617 */     if ((this.subspaceParameters != null) && (this.subspaceParameters.length > 0) && (this.settings.alphaSubspace != 0.0D))
/*     */     {
/* 619 */       final int m = this.subspaceParameters.length;
/*     */ 
/* 623 */       Arrays.fill(this.subspaceCorrelated, false);
/* 624 */       this.tempParameters[0].set(this.parameters);
/* 625 */       this.tempParameters[0].setSubspace(this.subspaceParameters);
/* 626 */       Parallel.loop(0, this.n + m, this.tempSubspaceParameters.length, new Parallel.Looper()
/*     */       {
/*     */         public void loop(int from, int to, int looperID)
/*     */         {
/* 630 */           for (int i = from; i < to; i++)
/* 631 */             if (i < GNImageAligner.this.n) {
/* 632 */               Arrays.fill(GNImageAligner.this.subspaceJacobian[i], 0.0D);
/* 633 */               GNImageAligner.this.subspaceJacobian[i][i] = scale[i];
/*     */             } else {
/* 635 */               System.arraycopy(GNImageAligner.this.subspaceParameters, 0, GNImageAligner.this.tempSubspaceParameters[looperID], 0, m);
/* 636 */               GNImageAligner.this.tempSubspaceParameters[looperID][(i - GNImageAligner.this.n)] += stepSize;
/* 637 */               GNImageAligner.this.tempParameters[(i - GNImageAligner.this.n + 1)].set(GNImageAligner.this.parameters);
/* 638 */               GNImageAligner.this.tempParameters[(i - GNImageAligner.this.n + 1)].setSubspace(GNImageAligner.this.tempSubspaceParameters[looperID]);
/* 639 */               scale[i] = (GNImageAligner.this.tempSubspaceParameters[looperID][(i - GNImageAligner.this.n)] - GNImageAligner.this.subspaceParameters[(i - GNImageAligner.this.n)]);
/* 640 */               for (int j = 0; j < GNImageAligner.this.n; j++) {
/* 641 */                 GNImageAligner.this.subspaceJacobian[i][j] = (GNImageAligner.this.tempParameters[0].get(j) - GNImageAligner.this.tempParameters[(i - GNImageAligner.this.n + 1)].get(j));
/* 642 */                 GNImageAligner.this.subspaceCorrelated[j] |= (GNImageAligner.this.subspaceJacobian[i][j] != 0.0D ? 1 : 0);
/*     */               }
/*     */             }
/*     */         }
/*     */       });
/* 647 */       int subspaceCorrelatedCount = 0;
/*     */ 
/* 649 */       for (int i = 0; i < this.n; i++) {
/* 650 */         this.subspaceResidual[i] = (this.parameters.get(i) - this.tempParameters[0].get(i));
/*     */ 
/* 653 */         if (this.subspaceCorrelated[i] != 0) {
/* 654 */           subspaceCorrelatedCount++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 659 */       final double K = this.settings.alphaSubspace * this.settings.alphaSubspace * this.RMSE * this.RMSE / subspaceCorrelatedCount;
/*     */ 
/* 662 */       Parallel.loop(0, this.n + m, new Parallel.Looper()
/*     */       {
/*     */         public void loop(int from, int to, int looperID)
/*     */         {
/* 666 */           for (int i = from; i < to; i++)
/* 667 */             if ((i >= GNImageAligner.this.n) || (GNImageAligner.this.subspaceCorrelated[i] != 0))
/*     */             {
/* 671 */               for (int j = i; j < GNImageAligner.this.n + m; j++) {
/* 672 */                 if ((j >= GNImageAligner.this.n) || (GNImageAligner.this.subspaceCorrelated[j] != 0))
/*     */                 {
/* 675 */                   double h = 0.0D;
/* 676 */                   for (int k = 0; k < GNImageAligner.this.n; k++) {
/* 677 */                     h += GNImageAligner.this.subspaceJacobian[i][k] * GNImageAligner.this.subspaceJacobian[j][k];
/*     */                   }
/*     */ 
/* 680 */                   h = GNImageAligner.this.hessian.get(i, j) + K * h;
/* 681 */                   GNImageAligner.this.hessian.put(i, j, h);
/* 682 */                   GNImageAligner.this.hessian.put(j, i, h);
/*     */                 }
/*     */               }
/* 685 */               double g = 0.0D;
/* 686 */               for (int k = 0; k < GNImageAligner.this.n; k++) {
/* 687 */                 g -= GNImageAligner.this.subspaceJacobian[i][k] * GNImageAligner.this.subspaceResidual[k];
/*     */               }
/*     */ 
/* 690 */               g = GNImageAligner.this.gradient.get(i) + K * g;
/* 691 */               GNImageAligner.this.gradient.put(i, g);
/*     */             }
/*     */         }
/*     */       });
/*     */     }
/* 696 */     int rows = this.hessian.rows(); int cols = this.hessian.cols();
/* 697 */     for (int i = 0; i < rows; i++)
/* 698 */       for (int j = 0; j < cols; j++) {
/* 699 */         double h = this.hessian.get(i, j);
/* 700 */         double g = 0.0D;
/* 701 */         if ((this.settings.gammaTgamma != null) && (i < this.settings.gammaTgamma.rows()) && (j < this.settings.gammaTgamma.cols())) {
/* 702 */           g = this.settings.gammaTgamma.get(i, j);
/*     */         }
/* 704 */         double a = 0.0D;
/* 705 */         if ((i == j) && (i < this.n)) {
/* 706 */           a = this.settings.alphaTikhonov * this.settings.alphaTikhonov;
/*     */         }
/* 708 */         this.hessian.put(i, j, h + g + a);
/*     */       }
/*     */   }
/*     */ 
/*     */   protected void doRoi()
/*     */   {
/* 714 */     this.transformer.transform(this.srcRoiPts, this.dstRoiPts, this.parameters, false);
/* 715 */     double[] pts = this.dstRoiPts.get();
/* 716 */     for (int i = 0; i < pts.length; i++) {
/* 717 */       pts[i] /= (1 << this.pyramidLevel);
/*     */     }
/* 719 */     this.roi.x(0).y(0).width(this.mask[this.pyramidLevel].width()).height(this.mask[this.pyramidLevel].height());
/*     */ 
/* 723 */     JavaCV.boundingRect(pts, this.roi, 3, 3, 16, 1);
/*     */ 
/* 726 */     opencv_core.cvSetZero(this.mask[this.pyramidLevel]);
/* 727 */     this.dstRoiPtsArray.put((byte)16, pts);
/* 728 */     opencv_core.cvFillConvexPoly(this.mask[this.pyramidLevel], this.dstRoiPtsArray, 4, opencv_core.CvScalar.WHITE, 8, 16);
/*     */   }
/*     */ 
/*     */   protected void doResidual() {
/* 732 */     this.parameters.getConstraintError();
/*     */ 
/* 735 */     ImageTransformer.Data d = this.residualTransformerData[0];
/* 736 */     d.srcImg = this.template[this.pyramidLevel];
/* 737 */     d.subImg = this.target[this.pyramidLevel];
/* 738 */     d.srcDotImg = null;
/* 739 */     d.transImg = this.transformed[this.pyramidLevel];
/* 740 */     d.dstImg = this.residual[this.pyramidLevel];
/* 741 */     d.mask = this.mask[this.pyramidLevel];
/*     */ 
/* 744 */     d.zeroThreshold = this.settings.thresholdsZero[Math.min(this.settings.thresholdsZero.length - 1, this.pyramidLevel)];
/* 745 */     d.outlierThreshold = this.settings.thresholdsOutlier[Math.min(this.settings.thresholdsOutlier.length - 1, this.pyramidLevel)];
/* 746 */     if (this.settings.thresholdsMulRMSE) {
/* 747 */       d.zeroThreshold *= this.RMSE;
/* 748 */       d.outlierThreshold *= this.RMSE;
/*     */     }
/* 750 */     d.pyramidLevel = this.pyramidLevel;
/*     */ 
/* 752 */     this.transformer.transform(this.residualTransformerData, this.roi, this.parametersArray, null);
/*     */ 
/* 754 */     double dstDstDot = this.residualTransformerData[0].dstDstDot.get(0);
/* 755 */     int dstCount = this.residualTransformerData[0].dstCount;
/* 756 */     this.RMSE = (dstCount < this.n ? (0.0D / 0.0D) : Math.sqrt(dstDstDot / dstCount));
/*     */ 
/* 760 */     this.residualUpdateNeeded = false;
/*     */   }
/*     */ 
/*     */   public static class Settings extends ImageAligner.Settings
/*     */     implements Cloneable
/*     */   {
/* 133 */     double stepSize = 0.1D;
/* 134 */     double[] lineSearch = { 1.0D, 0.25D };
/* 135 */     double deltaMin = 10.0D;
/* 136 */     double deltaMax = 300.0D;
/* 137 */     double displacementMax = 0.2D;
/* 138 */     double alphaSubspace = 0.1D;
/* 139 */     double alphaTikhonov = 0.0D;
/* 140 */     opencv_core.CvMat gammaTgamma = null;
/* 141 */     boolean constrained = false;
/*     */ 
/*     */     public Settings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Settings(Settings s)
/*     */     {
/* 121 */       super();
/* 122 */       this.stepSize = s.stepSize;
/* 123 */       this.lineSearch = s.lineSearch;
/* 124 */       this.deltaMin = s.deltaMin;
/* 125 */       this.deltaMax = s.deltaMax;
/* 126 */       this.displacementMax = s.displacementMax;
/* 127 */       this.alphaSubspace = s.alphaSubspace;
/* 128 */       this.alphaTikhonov = s.alphaTikhonov;
/* 129 */       this.gammaTgamma = s.gammaTgamma;
/* 130 */       this.constrained = s.constrained;
/*     */     }
/*     */ 
/*     */     public double getStepSize()
/*     */     {
/* 144 */       return this.stepSize;
/*     */     }
/*     */     public void setStepSize(double stepSize) {
/* 147 */       this.stepSize = stepSize;
/*     */     }
/*     */ 
/*     */     public double[] getLineSearch() {
/* 151 */       return this.lineSearch;
/*     */     }
/*     */     public void setLineSearch(double[] lineSearch) {
/* 154 */       this.lineSearch = lineSearch;
/*     */     }
/*     */ 
/*     */     public double getDeltaMin() {
/* 158 */       return this.deltaMin;
/*     */     }
/*     */     public void setDeltaMin(double deltaMin) {
/* 161 */       this.deltaMin = deltaMin;
/*     */     }
/*     */ 
/*     */     public double getDeltaMax() {
/* 165 */       return this.deltaMax;
/*     */     }
/*     */     public void setDeltaMax(double deltaMax) {
/* 168 */       this.deltaMax = deltaMax;
/*     */     }
/*     */ 
/*     */     public double getDisplacementMax() {
/* 172 */       return this.displacementMax;
/*     */     }
/*     */     public void setDisplacementMax(double displacementMax) {
/* 175 */       this.displacementMax = displacementMax;
/*     */     }
/*     */ 
/*     */     public double getAlphaSubspace() {
/* 179 */       return this.alphaSubspace;
/*     */     }
/*     */     public void setAlphaSubspace(double alphaSubspace) {
/* 182 */       this.alphaSubspace = alphaSubspace;
/*     */     }
/*     */ 
/*     */     public double getAlphaTikhonov() {
/* 186 */       return this.alphaTikhonov;
/*     */     }
/*     */     public void setAlphaTikhonov(double alphaTikhonov) {
/* 189 */       this.alphaTikhonov = alphaTikhonov;
/*     */     }
/*     */ 
/*     */     public opencv_core.CvMat getGammaTgamma() {
/* 193 */       return this.gammaTgamma;
/*     */     }
/*     */     public void setGammaTgamma(opencv_core.CvMat gammaTgamma) {
/* 196 */       this.gammaTgamma = gammaTgamma;
/*     */     }
/*     */ 
/*     */     public Settings clone()
/*     */     {
/* 207 */       return new Settings(this);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.GNImageAligner
 * JD-Core Version:    0.6.2
 */