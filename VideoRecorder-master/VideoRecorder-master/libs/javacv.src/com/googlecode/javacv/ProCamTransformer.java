/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.cvkernels;
/*     */ import com.googlecode.javacv.cpp.cvkernels.KernelData;
/*     */ import com.googlecode.javacv.cpp.opencv_calib3d;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplROI;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ 
/*     */ public class ProCamTransformer
/*     */   implements ImageTransformer
/*     */ {
/*  68 */   protected CameraDevice camera = null;
/*  69 */   protected ProjectorDevice projector = null;
/*  70 */   protected ProjectiveColorTransformer surfaceTransformer = null;
/*  71 */   protected ProjectiveColorTransformer projectorTransformer = null;
/*  72 */   protected opencv_core.IplImage[] projectorImage = null; protected opencv_core.IplImage[] surfaceImage = null;
/*  73 */   protected opencv_core.CvScalar fillColor = opencv_core.cvScalar(0.0D, 0.0D, 0.0D, 1.0D);
/*  74 */   protected opencv_core.CvRect roi = new opencv_core.CvRect();
/*  75 */   protected opencv_core.CvMat frontoParallelH = null; protected opencv_core.CvMat invFrontoParallelH = null;
/*  76 */   protected opencv_core.CvMat invCameraMatrix = null;
/*     */ 
/*  78 */   protected cvkernels.KernelData kernelData = null;
/*  79 */   protected opencv_core.CvMat[] H1 = null;
/*  80 */   protected opencv_core.CvMat[] H2 = null;
/*  81 */   protected opencv_core.CvMat[] X = null;
/*     */ 
/*     */   public ProCamTransformer(double[] referencePoints, CameraDevice camera, ProjectorDevice projector)
/*     */   {
/*  35 */     this(referencePoints, camera, projector, null);
/*     */   }
/*     */ 
/*     */   public ProCamTransformer(double[] referencePoints, CameraDevice camera, ProjectorDevice projector, opencv_core.CvMat n) {
/*  39 */     this.camera = camera;
/*  40 */     this.projector = projector;
/*     */ 
/*  42 */     if (referencePoints != null) {
/*  43 */       this.surfaceTransformer = new ProjectiveColorTransformer(camera.cameraMatrix, camera.cameraMatrix, null, null, n, referencePoints, null, null, 3, 0);
/*     */     }
/*     */ 
/*  47 */     double[] referencePoints1 = { 0.0D, 0.0D, camera.imageWidth / 2, camera.imageHeight, camera.imageWidth, 0.0D };
/*  48 */     double[] referencePoints2 = { 0.0D, 0.0D, projector.imageWidth / 2, projector.imageHeight, projector.imageWidth, 0.0D };
/*  49 */     if (n != null) {
/*  50 */       this.invCameraMatrix = opencv_core.CvMat.create(3, 3);
/*  51 */       opencv_core.cvInvert(camera.cameraMatrix, this.invCameraMatrix);
/*  52 */       JavaCV.perspectiveTransform(referencePoints2, referencePoints1, this.invCameraMatrix, projector.cameraMatrix, projector.R, projector.T, n, true);
/*     */     }
/*     */ 
/*  55 */     this.projectorTransformer = new ProjectiveColorTransformer(camera.cameraMatrix, projector.cameraMatrix, projector.R, projector.T, null, referencePoints1, referencePoints2, projector.colorMixingMatrix, 1, 3);
/*     */ 
/*  61 */     if ((referencePoints != null) && (n != null)) {
/*  62 */       this.frontoParallelH = camera.getFrontoParallelH(referencePoints, n, opencv_core.CvMat.create(3, 3));
/*  63 */       this.invFrontoParallelH = this.frontoParallelH.clone();
/*  64 */       opencv_core.cvInvert(this.frontoParallelH, this.invFrontoParallelH);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getNumGains()
/*     */   {
/*  84 */     return this.projectorTransformer.getNumGains();
/*     */   }
/*     */   public int getNumBiases() {
/*  87 */     return this.projectorTransformer.getNumBiases();
/*     */   }
/*     */ 
/*     */   public opencv_core.CvScalar getFillColor() {
/*  91 */     return this.fillColor;
/*     */   }
/*     */   public void setFillColor(opencv_core.CvScalar fillColor) {
/*  94 */     this.fillColor = fillColor;
/*     */   }
/*     */ 
/*     */   public ProjectiveColorTransformer getSurfaceTransformer() {
/*  98 */     return this.surfaceTransformer;
/*     */   }
/*     */   public ProjectiveColorTransformer getProjectorTransformer() {
/* 101 */     return this.projectorTransformer;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getProjectorImage(int pyramidLevel) {
/* 105 */     return this.projectorImage[pyramidLevel];
/*     */   }
/*     */   public void setProjectorImage(opencv_core.IplImage projectorImage0, int minLevel, int maxLevel) {
/* 108 */     setProjectorImage(projectorImage0, minLevel, maxLevel, true);
/*     */   }
/*     */   public void setProjectorImage(opencv_core.IplImage projectorImage0, int minLevel, int maxLevel, boolean convertToFloat) {
/* 111 */     if ((this.projectorImage == null) || (this.projectorImage.length != maxLevel + 1)) {
/* 112 */       this.projectorImage = new opencv_core.IplImage[maxLevel + 1];
/*     */     }
/*     */ 
/* 115 */     if ((projectorImage0.depth() == 32) || (!convertToFloat)) {
/* 116 */       this.projectorImage[minLevel] = projectorImage0;
/*     */     } else {
/* 118 */       if (this.projectorImage[minLevel] == null) {
/* 119 */         this.projectorImage[minLevel] = opencv_core.IplImage.create(projectorImage0.width(), projectorImage0.height(), 32, projectorImage0.nChannels(), projectorImage0.origin());
/*     */       }
/*     */ 
/* 122 */       opencv_core.IplROI ir = projectorImage0.roi();
/* 123 */       if (ir != null) {
/* 124 */         int align = 1 << maxLevel + 1;
/* 125 */         this.roi.x(Math.max(0, (int)Math.floor(ir.xOffset() / align) * align));
/* 126 */         this.roi.y(Math.max(0, (int)Math.floor(ir.yOffset() / align) * align));
/* 127 */         this.roi.width(Math.min(projectorImage0.width(), (int)Math.ceil(ir.width() / align) * align));
/* 128 */         this.roi.height(Math.min(projectorImage0.height(), (int)Math.ceil(ir.height() / align) * align));
/* 129 */         opencv_core.cvSetImageROI(projectorImage0, this.roi);
/* 130 */         opencv_core.cvSetImageROI(this.projectorImage[minLevel], this.roi);
/*     */       } else {
/* 132 */         opencv_core.cvResetImageROI(projectorImage0);
/* 133 */         opencv_core.cvResetImageROI(this.projectorImage[minLevel]);
/*     */       }
/* 135 */       opencv_core.cvConvertScale(projectorImage0, this.projectorImage[minLevel], 0.00392156862745098D, 0.0D);
/*     */     }
/*     */ 
/* 141 */     for (int i = minLevel + 1; i <= maxLevel; i++) {
/* 142 */       int w = this.projectorImage[(i - 1)].width() / 2;
/* 143 */       int h = this.projectorImage[(i - 1)].height() / 2;
/* 144 */       int d = this.projectorImage[(i - 1)].depth();
/* 145 */       int c = this.projectorImage[(i - 1)].nChannels();
/* 146 */       int o = this.projectorImage[(i - 1)].origin();
/* 147 */       if (this.projectorImage[i] == null) {
/* 148 */         this.projectorImage[i] = opencv_core.IplImage.create(w, h, d, c, o);
/*     */       }
/*     */ 
/* 151 */       opencv_core.IplROI ir = this.projectorImage[(i - 1)].roi();
/* 152 */       if (ir != null) {
/* 153 */         this.roi.x(ir.xOffset() / 2); this.roi.width(ir.width() / 2);
/* 154 */         this.roi.y(ir.yOffset() / 2); this.roi.height(ir.height() / 2);
/* 155 */         opencv_core.cvSetImageROI(this.projectorImage[i], this.roi);
/*     */       } else {
/* 157 */         opencv_core.cvResetImageROI(this.projectorImage[i]);
/*     */       }
/* 159 */       opencv_imgproc.cvPyrDown(this.projectorImage[(i - 1)], this.projectorImage[i], 7);
/* 160 */       opencv_core.cvResetImageROI(this.projectorImage[(i - 1)]);
/*     */     }
/*     */   }
/*     */ 
/* 164 */   public opencv_core.IplImage getSurfaceImage(int pyramidLevel) { return this.surfaceImage[pyramidLevel]; }
/*     */ 
/*     */   public void setSurfaceImage(opencv_core.IplImage surfaceImage0, int pyramidLevels) {
/* 167 */     if ((this.surfaceImage == null) || (this.surfaceImage.length != pyramidLevels)) {
/* 168 */       this.surfaceImage = new opencv_core.IplImage[pyramidLevels];
/*     */     }
/* 170 */     this.surfaceImage[0] = surfaceImage0;
/* 171 */     opencv_core.cvResetImageROI(surfaceImage0);
/* 172 */     for (int i = 1; i < pyramidLevels; i++) {
/* 173 */       int w = this.surfaceImage[(i - 1)].width() / 2;
/* 174 */       int h = this.surfaceImage[(i - 1)].height() / 2;
/* 175 */       int d = this.surfaceImage[(i - 1)].depth();
/* 176 */       int c = this.surfaceImage[(i - 1)].nChannels();
/* 177 */       int o = this.surfaceImage[(i - 1)].origin();
/* 178 */       if (this.surfaceImage[i] == null)
/* 179 */         this.surfaceImage[i] = opencv_core.IplImage.create(w, h, d, c, o);
/*     */       else {
/* 181 */         opencv_core.cvResetImageROI(this.surfaceImage[i]);
/*     */       }
/* 183 */       opencv_imgproc.cvPyrDown(this.surfaceImage[(i - 1)], this.surfaceImage[i], 7);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void prepareTransforms(opencv_core.CvMat H1, opencv_core.CvMat H2, opencv_core.CvMat X, int pyramidLevel, Parameters p) {
/* 188 */     ProjectiveColorTransformer.Parameters cameraParameters = p.getSurfaceParameters();
/* 189 */     ProjectiveColorTransformer.Parameters projectorParameters = p.getProjectorParameters();
/*     */ 
/* 191 */     if (this.surfaceTransformer != null) {
/* 192 */       opencv_core.cvInvert(cameraParameters.getH(), H1);
/*     */     }
/* 194 */     opencv_core.cvInvert(projectorParameters.getH(), H2);
/*     */ 
/* 197 */     if (pyramidLevel > 0) {
/* 198 */       int scale = 1 << pyramidLevel;
/* 199 */       if (this.surfaceTransformer != null) {
/* 200 */         H1.put(2, H1.get(2) / scale);
/* 201 */         H1.put(5, H1.get(5) / scale);
/* 202 */         H1.put(6, H1.get(6) * scale);
/* 203 */         H1.put(7, H1.get(7) * scale);
/*     */       }
/*     */ 
/* 206 */       H2.put(2, H2.get(2) / scale);
/* 207 */       H2.put(5, H2.get(5) / scale);
/* 208 */       H2.put(6, H2.get(6) * scale);
/* 209 */       H2.put(7, H2.get(7) * scale);
/*     */     }
/*     */ 
/* 212 */     double[] x = this.projector.colorMixingMatrix.get();
/* 213 */     double[] a = projectorParameters.getColorParameters();
/* 214 */     double a2 = a[0];
/* 215 */     X.put(new double[] { a2 * x[0], a2 * x[1], a2 * x[2], a[1], a2 * x[3], a2 * x[4], a2 * x[5], a[2], a2 * x[6], a2 * x[7], a2 * x[8], a[3], 0.0D, 0.0D, 0.0D, 1.0D });
/*     */   }
/*     */ 
/*     */   public void transform(opencv_core.IplImage srcImage, opencv_core.IplImage dstImage, opencv_core.CvRect roi, int pyramidLevel, ImageTransformer.Parameters parameters, boolean inverse)
/*     */   {
/* 223 */     if (inverse) {
/* 224 */       throw new UnsupportedOperationException("Inverse transform not supported.");
/*     */     }
/* 226 */     Parameters p = (Parameters)parameters;
/* 227 */     ProjectiveTransformer.Parameters cameraParameters = p.getSurfaceParameters();
/* 228 */     ProjectiveTransformer.Parameters projectorParameters = p.getProjectorParameters();
/*     */ 
/* 230 */     if ((p.tempImage == null) || (p.tempImage.length <= pyramidLevel)) {
/* 231 */       p.tempImage = new opencv_core.IplImage[pyramidLevel + 1];
/*     */     }
/* 233 */     p.tempImage[pyramidLevel] = opencv_core.IplImage.createIfNotCompatible(p.tempImage[pyramidLevel], dstImage);
/* 234 */     if (roi == null)
/* 235 */       opencv_core.cvResetImageROI(p.tempImage[pyramidLevel]);
/*     */     else {
/* 237 */       opencv_core.cvSetImageROI(p.tempImage[pyramidLevel], roi);
/*     */     }
/*     */ 
/* 242 */     if (this.surfaceTransformer != null) {
/* 243 */       this.surfaceTransformer.transform(srcImage, p.tempImage[pyramidLevel], roi, pyramidLevel, cameraParameters, false);
/*     */     }
/*     */ 
/* 247 */     this.projectorTransformer.transform(this.projectorImage[pyramidLevel], dstImage, roi, pyramidLevel, projectorParameters, false);
/*     */ 
/* 251 */     if (this.surfaceTransformer != null)
/* 252 */       opencv_core.cvMul(dstImage, p.tempImage[pyramidLevel], dstImage, 1.0D / dstImage.highValue());
/*     */     else
/* 254 */       opencv_core.cvCopy(p.tempImage[pyramidLevel], dstImage);
/*     */   }
/*     */ 
/*     */   public void transform(opencv_core.CvMat srcPts, opencv_core.CvMat dstPts, ImageTransformer.Parameters parameters, boolean inverse)
/*     */   {
/* 259 */     if (this.surfaceTransformer != null)
/* 260 */       this.surfaceTransformer.transform(srcPts, dstPts, ((Parameters)parameters).surfaceParameters, inverse);
/* 261 */     else if (dstPts != srcPts)
/* 262 */       dstPts.put(srcPts);
/*     */   }
/*     */ 
/*     */   public void transform(ImageTransformer.Data[] data, opencv_core.CvRect roi, ImageTransformer.Parameters[] parameters, boolean[] inverses)
/*     */   {
/* 267 */     assert (data.length == parameters.length);
/* 268 */     if ((this.kernelData == null) || (this.kernelData.capacity() < data.length)) {
/* 269 */       this.kernelData = new cvkernels.KernelData(data.length);
/*     */     }
/* 271 */     if (((this.H1 == null) || (this.H1.length < data.length)) && (this.surfaceTransformer != null)) {
/* 272 */       this.H1 = new opencv_core.CvMat[data.length];
/* 273 */       for (int i = 0; i < this.H1.length; i++) {
/* 274 */         this.H1[i] = opencv_core.CvMat.create(3, 3);
/*     */       }
/*     */     }
/* 277 */     if ((this.H2 == null) || (this.H2.length < data.length)) {
/* 278 */       this.H2 = new opencv_core.CvMat[data.length];
/* 279 */       for (int i = 0; i < this.H2.length; i++) {
/* 280 */         this.H2[i] = opencv_core.CvMat.create(3, 3);
/*     */       }
/*     */     }
/* 283 */     if ((this.X == null) || (this.X.length < data.length)) {
/* 284 */       this.X = new opencv_core.CvMat[data.length];
/* 285 */       for (int i = 0; i < this.X.length; i++) {
/* 286 */         this.X[i] = opencv_core.CvMat.create(4, 4);
/*     */       }
/*     */     }
/*     */ 
/* 290 */     for (int i = 0; i < data.length; i++) {
/* 291 */       this.kernelData.position(i);
/*     */ 
/* 293 */       this.kernelData.srcImg(this.projectorImage[data[i].pyramidLevel]);
/* 294 */       this.kernelData.srcImg2(this.surfaceTransformer == null ? null : data[i].srcImg);
/* 295 */       this.kernelData.subImg(data[i].subImg);
/* 296 */       this.kernelData.srcDotImg(data[i].srcDotImg);
/* 297 */       this.kernelData.mask(data[i].mask);
/* 298 */       this.kernelData.zeroThreshold(data[i].zeroThreshold);
/* 299 */       this.kernelData.outlierThreshold(data[i].outlierThreshold);
/*     */ 
/* 301 */       if ((inverses != null) && (inverses[i] != 0)) {
/* 302 */         throw new UnsupportedOperationException("Inverse transform not supported.");
/*     */       }
/* 304 */       prepareTransforms(this.surfaceTransformer == null ? null : this.H1[i], this.H2[i], this.X[i], data[i].pyramidLevel, (Parameters)parameters[i]);
/*     */ 
/* 307 */       this.kernelData.H1(this.H2[i]);
/* 308 */       this.kernelData.H2(this.surfaceTransformer == null ? null : this.H1[i]);
/* 309 */       this.kernelData.X(this.X[i]);
/*     */ 
/* 311 */       this.kernelData.transImg(data[i].transImg);
/* 312 */       this.kernelData.dstImg(data[i].dstImg);
/* 313 */       this.kernelData.dstDstDot(data[i].dstDstDot);
/*     */     }
/*     */ 
/* 316 */     int fullCapacity = this.kernelData.capacity();
/* 317 */     this.kernelData.capacity(data.length);
/* 318 */     cvkernels.multiWarpColorTransform(this.kernelData, roi, getFillColor());
/* 319 */     this.kernelData.capacity(fullCapacity);
/*     */ 
/* 321 */     for (int i = 0; i < data.length; i++) {
/* 322 */       this.kernelData.position(i);
/* 323 */       data[i].dstCount = this.kernelData.dstCount();
/* 324 */       data[i].dstCountZero = this.kernelData.dstCountZero();
/* 325 */       data[i].dstCountOutlier = this.kernelData.dstCountOutlier();
/* 326 */       data[i].srcDstDot = this.kernelData.srcDstDot();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Parameters createParameters()
/*     */   {
/* 336 */     return new Parameters();
/*     */   }
/*     */ 
/*     */   public class Parameters
/*     */     implements ImageTransformer.Parameters
/*     */   {
/* 348 */     private ProjectiveColorTransformer.Parameters surfaceParameters = null;
/* 349 */     private ProjectiveColorTransformer.Parameters projectorParameters = null;
/* 350 */     private opencv_core.IplImage[] tempImage = null;
/* 351 */     private opencv_core.CvMat H = opencv_core.CvMat.create(3, 3); private opencv_core.CvMat R = opencv_core.CvMat.create(3, 3); private opencv_core.CvMat n = opencv_core.CvMat.create(3, 1); private opencv_core.CvMat t = opencv_core.CvMat.create(3, 1);
/*     */ 
/*     */     protected Parameters()
/*     */     {
/* 341 */       reset(false);
/*     */     }
/*     */ 
/*     */     protected Parameters(ProjectiveColorTransformer.Parameters surfaceParameters, ProjectiveColorTransformer.Parameters projectorParameters) {
/* 345 */       reset(surfaceParameters, projectorParameters);
/*     */     }
/*     */ 
/*     */     public ProjectiveColorTransformer.Parameters getSurfaceParameters()
/*     */     {
/* 355 */       return this.surfaceParameters;
/*     */     }
/*     */     public ProjectiveColorTransformer.Parameters getProjectorParameters() {
/* 358 */       return this.projectorParameters;
/*     */     }
/*     */ 
/*     */     private int getSizeForSurface() {
/* 362 */       return ProCamTransformer.this.surfaceTransformer == null ? 0 : this.surfaceParameters.size() - ProCamTransformer.this.surfaceTransformer.getNumGains() - ProCamTransformer.this.surfaceTransformer.getNumBiases();
/*     */     }
/*     */ 
/*     */     private int getSizeForProjector() {
/* 366 */       return this.projectorParameters.size();
/*     */     }
/*     */     public int size() {
/* 369 */       return getSizeForSurface() + getSizeForProjector();
/*     */     }
/*     */     public double[] get() {
/* 372 */       double[] p = new double[size()];
/* 373 */       for (int i = 0; i < p.length; i++) {
/* 374 */         p[i] = get(i);
/*     */       }
/* 376 */       return p;
/*     */     }
/*     */     public double get(int i) {
/* 379 */       if (i < getSizeForSurface()) {
/* 380 */         return this.surfaceParameters.get(i);
/*     */       }
/* 382 */       return this.projectorParameters.get(i - getSizeForSurface());
/*     */     }
/*     */ 
/*     */     public void set(double[] p) {
/* 386 */       for (int i = 0; i < p.length; i++)
/* 387 */         set(i, p[i]);
/*     */     }
/*     */ 
/*     */     public void set(int i, double p) {
/* 391 */       if (i < getSizeForSurface())
/* 392 */         this.surfaceParameters.set(i, p);
/*     */       else
/* 394 */         this.projectorParameters.set(i - getSizeForSurface(), p);
/*     */     }
/*     */ 
/*     */     public void set(ImageTransformer.Parameters p) {
/* 398 */       Parameters pcp = (Parameters)p;
/* 399 */       if (ProCamTransformer.this.surfaceTransformer != null) {
/* 400 */         this.surfaceParameters.set(pcp.getSurfaceParameters());
/* 401 */         this.surfaceParameters.resetColor(false);
/*     */       }
/* 403 */       this.projectorParameters.set(pcp.getProjectorParameters());
/*     */     }
/*     */     public void reset(boolean asIdentity) {
/* 406 */       reset(null, null);
/*     */     }
/*     */ 
/*     */     public void reset(ProjectiveColorTransformer.Parameters surfaceParameters, ProjectiveColorTransformer.Parameters projectorParameters) {
/* 410 */       if ((surfaceParameters == null) && (ProCamTransformer.this.surfaceTransformer != null)) {
/* 411 */         surfaceParameters = ProCamTransformer.this.surfaceTransformer.createParameters();
/*     */       }
/* 413 */       if (projectorParameters == null) {
/* 414 */         projectorParameters = ProCamTransformer.this.projectorTransformer.createParameters();
/*     */       }
/* 416 */       this.surfaceParameters = surfaceParameters;
/* 417 */       this.projectorParameters = projectorParameters;
/*     */ 
/* 419 */       setSubspace(getSubspace());
/*     */     }
/*     */ 
/*     */     public double getConstraintError()
/*     */     {
/* 439 */       double error = ProCamTransformer.this.surfaceTransformer == null ? 0.0D : this.surfaceParameters.getConstraintError();
/* 440 */       this.projectorParameters.update();
/* 441 */       return error;
/*     */     }
/*     */ 
/*     */     public void compose(ImageTransformer.Parameters p1, boolean inverse1, ImageTransformer.Parameters p2, boolean inverse2) {
/* 445 */       throw new UnsupportedOperationException("Compose operation not supported.");
/*     */     }
/*     */ 
/*     */     public boolean preoptimize() {
/* 449 */       double[] p = setSubspaceInternal(getSubspaceInternal());
/* 450 */       if (p != null) {
/* 451 */         set(8, p[8]);
/* 452 */         set(9, p[9]);
/* 453 */         set(10, p[10]);
/* 454 */         return true;
/*     */       }
/* 456 */       return false;
/*     */     }
/*     */     public void setSubspace(double[] p) {
/* 459 */       double[] dst = setSubspaceInternal(p);
/* 460 */       if (dst != null)
/* 461 */         set(dst);
/*     */     }
/*     */ 
/*     */     public double[] getSubspace() {
/* 465 */       return getSubspaceInternal();
/*     */     }
/*     */ 
/*     */     private double[] setSubspaceInternal(double[] p) {
/* 469 */       if (ProCamTransformer.this.invFrontoParallelH == null) {
/* 470 */         return null;
/*     */       }
/* 472 */       double[] dst = new double[11];
/* 473 */       this.t.put(new double[] { p[0], p[1], p[2] });
/* 474 */       opencv_calib3d.cvRodrigues2(this.t, this.R, null);
/* 475 */       this.t.put(new double[] { p[3], p[4], p[5] });
/*     */ 
/* 478 */       this.H.put(new double[] { this.R.get(0), this.R.get(1), this.t.get(0), this.R.get(3), this.R.get(4), this.t.get(1), this.R.get(6), this.R.get(7), this.t.get(2) });
/*     */ 
/* 481 */       opencv_core.cvMatMul(this.H, ProCamTransformer.this.invFrontoParallelH, this.H);
/* 482 */       opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getK2(), this.H, this.H);
/* 483 */       opencv_core.cvMatMul(this.H, ProCamTransformer.this.surfaceTransformer.getInvK1(), this.H);
/*     */ 
/* 486 */       opencv_core.cvGEMM(this.R, this.t, 1.0D, null, 0.0D, this.t, 1);
/* 487 */       double scale = 1.0D / this.t.get(2);
/* 488 */       this.n.put(new double[] { 0.0D, 0.0D, 1.0D });
/* 489 */       opencv_core.cvGEMM(this.R, this.n, scale, null, 0.0D, this.n, 0);
/*     */ 
/* 492 */       double[] src = ProCamTransformer.this.projectorTransformer.getReferencePoints2();
/* 493 */       JavaCV.perspectiveTransform(src, dst, ProCamTransformer.this.projectorTransformer.getInvK1(), ProCamTransformer.this.projectorTransformer.getK2(), ProCamTransformer.this.projectorTransformer.getR(), ProCamTransformer.this.projectorTransformer.getT(), this.n, true);
/*     */ 
/* 496 */       dst[8] = dst[0];
/* 497 */       dst[9] = dst[2];
/* 498 */       dst[10] = dst[4];
/*     */ 
/* 501 */       JavaCV.perspectiveTransform(ProCamTransformer.this.surfaceTransformer.getReferencePoints1(), dst, this.H);
/*     */ 
/* 503 */       return dst;
/*     */     }
/*     */ 
/*     */     private double[] getSubspaceInternal() {
/* 507 */       if (ProCamTransformer.this.frontoParallelH == null) {
/* 508 */         return null;
/*     */       }
/* 510 */       opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getK1(), ProCamTransformer.this.frontoParallelH, this.H);
/* 511 */       opencv_core.cvMatMul(this.surfaceParameters.getH(), this.H, this.H);
/* 512 */       opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getInvK2(), this.H, this.H);
/*     */ 
/* 514 */       JavaCV.HtoRt(this.H, this.R, this.t);
/* 515 */       opencv_calib3d.cvRodrigues2(this.R, this.n, null);
/* 516 */       double[] p = { this.n.get(0), this.n.get(1), this.n.get(2), this.t.get(0), this.t.get(1), this.t.get(2) };
/*     */ 
/* 518 */       return p;
/*     */     }
/*     */ 
/*     */     public opencv_core.CvMat getN() {
/* 522 */       double[] src = ProCamTransformer.this.projectorTransformer.getReferencePoints2();
/* 523 */       double[] dst = (double[])ProCamTransformer.this.projectorTransformer.getReferencePoints1().clone();
/* 524 */       dst[0] = this.projectorParameters.get(0);
/* 525 */       dst[2] = this.projectorParameters.get(1);
/* 526 */       dst[4] = this.projectorParameters.get(2);
/*     */ 
/* 531 */       opencv_core.cvTranspose(ProCamTransformer.this.projectorTransformer.getR(), this.R);
/* 532 */       opencv_core.cvGEMM(this.R, ProCamTransformer.this.projectorTransformer.getT(), -1.0D, null, 0.0D, this.t, 0);
/* 533 */       JavaCV.getPlaneParameters(src, dst, ProCamTransformer.this.projectorTransformer.getInvK2(), ProCamTransformer.this.projectorTransformer.getK1(), this.R, this.t, this.n);
/*     */ 
/* 535 */       double d = 1.0D + opencv_core.cvDotProduct(this.n, ProCamTransformer.this.projectorTransformer.getT());
/* 536 */       opencv_core.cvGEMM(this.R, this.n, 1.0D / d, null, 0.0D, this.n, 0);
/*     */ 
/* 538 */       return this.n;
/*     */     }
/*     */ 
/*     */     public opencv_core.CvMat getN0() {
/* 542 */       this.n = getN();
/* 543 */       if (ProCamTransformer.this.surfaceTransformer == null) {
/* 544 */         return this.n;
/*     */       }
/*     */ 
/* 549 */       ProCamTransformer.this.camera.getFrontoParallelH(this.surfaceParameters.get(), this.n, this.R);
/* 550 */       opencv_core.cvInvert(this.surfaceParameters.getH(), this.H);
/* 551 */       opencv_core.cvMatMul(this.H, ProCamTransformer.this.surfaceTransformer.getK2(), this.H);
/* 552 */       opencv_core.cvMatMul(this.H, this.R, this.H);
/* 553 */       opencv_core.cvMatMul(ProCamTransformer.this.surfaceTransformer.getInvK1(), this.H, this.H);
/*     */ 
/* 555 */       JavaCV.HtoRt(this.H, this.R, this.t);
/*     */ 
/* 558 */       opencv_core.cvGEMM(this.R, this.t, 1.0D, null, 0.0D, this.t, 1);
/* 559 */       double scale = 1.0D / this.t.get(2);
/* 560 */       this.n.put(new double[] { 0.0D, 0.0D, 1.0D });
/* 561 */       opencv_core.cvGEMM(this.R, this.n, scale, null, 0.0D, this.n, 0);
/*     */ 
/* 563 */       return this.n;
/*     */     }
/*     */ 
/*     */     public Parameters clone() {
/* 567 */       Parameters p = new Parameters(ProCamTransformer.this);
/* 568 */       p.surfaceParameters = (this.surfaceParameters == null ? null : this.surfaceParameters.clone());
/* 569 */       p.projectorParameters = this.projectorParameters.clone();
/* 570 */       return p;
/*     */     }
/*     */ 
/*     */     public String toString() {
/* 574 */       if (this.surfaceParameters != null) {
/* 575 */         return this.surfaceParameters.toString() + this.projectorParameters.toString();
/*     */       }
/* 577 */       return this.projectorParameters.toString();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProCamTransformer
 * JD-Core Version:    0.6.2
 */