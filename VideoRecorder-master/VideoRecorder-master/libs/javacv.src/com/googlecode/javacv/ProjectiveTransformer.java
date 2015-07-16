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
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ 
/*     */ public class ProjectiveTransformer
/*     */   implements ImageTransformer
/*     */ {
/*  65 */   protected static ThreadLocal<opencv_core.CvMat> H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*  66 */   protected static ThreadLocal<opencv_core.CvMat> pts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
/*     */ 
/*  68 */   protected opencv_core.CvMat K1 = null; protected opencv_core.CvMat K2 = null; protected opencv_core.CvMat invK1 = null; protected opencv_core.CvMat invK2 = null; protected opencv_core.CvMat R = null; protected opencv_core.CvMat t = null; protected opencv_core.CvMat n = null;
/*  69 */   protected double[] referencePoints1 = null; protected double[] referencePoints2 = null;
/*  70 */   protected opencv_core.CvScalar fillColor = opencv_core.cvScalar(0.0D, 0.0D, 0.0D, 1.0D);
/*     */ 
/*  72 */   protected cvkernels.KernelData kernelData = null;
/*  73 */   protected opencv_core.CvMat[] H = null;
/*     */ 
/*     */   public ProjectiveTransformer()
/*     */   {
/*  34 */     this(null, null, null, null, null, new double[0], null);
/*     */   }
/*     */   public ProjectiveTransformer(double[] referencePoints) {
/*  37 */     this(null, null, null, null, null, referencePoints, null);
/*     */   }
/*     */ 
/*     */   public ProjectiveTransformer(ProjectiveDevice d1, ProjectiveDevice d2, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2)
/*     */   {
/*  42 */     this(d1.cameraMatrix, d2.cameraMatrix, d2.R, d2.T, n, referencePoints1, referencePoints2);
/*     */   }
/*     */ 
/*     */   public ProjectiveTransformer(opencv_core.CvMat K1, opencv_core.CvMat K2, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2) {
/*  46 */     this.K1 = (K1 == null ? null : K1.clone());
/*  47 */     this.K2 = (K2 == null ? null : K2.clone());
/*  48 */     this.invK1 = (K1 == null ? null : K1.clone());
/*  49 */     this.invK2 = (K2 == null ? null : K2.clone());
/*  50 */     if (K1 != null) {
/*  51 */       opencv_core.cvInvert(K1, this.invK1);
/*     */     }
/*  53 */     if (K2 != null) {
/*  54 */       opencv_core.cvInvert(K2, this.invK2);
/*     */     }
/*  56 */     this.R = (R == null ? null : R.clone());
/*  57 */     this.t = (t == null ? null : t.clone());
/*  58 */     this.n = (n == null ? null : n.clone());
/*     */ 
/*  60 */     this.referencePoints1 = (referencePoints1 == null ? null : (double[])referencePoints1.clone());
/*  61 */     this.referencePoints2 = (referencePoints2 == null ? null : (double[])referencePoints2.clone());
/*     */   }
/*     */ 
/*     */   public opencv_core.CvScalar getFillColor()
/*     */   {
/*  76 */     return this.fillColor;
/*     */   }
/*     */   public void setFillColor(opencv_core.CvScalar fillColor) {
/*  79 */     this.fillColor = fillColor;
/*     */   }
/*     */ 
/*     */   public double[] getReferencePoints1() {
/*  83 */     return this.referencePoints1;
/*     */   }
/*     */   public double[] getReferencePoints2() {
/*  86 */     return this.referencePoints2;
/*     */   }
/*     */   public opencv_core.CvMat getK1() {
/*  89 */     return this.K1;
/*     */   }
/*     */   public opencv_core.CvMat getK2() {
/*  92 */     return this.K2;
/*     */   }
/*     */   public opencv_core.CvMat getInvK1() {
/*  95 */     return this.invK1;
/*     */   }
/*     */   public opencv_core.CvMat getInvK2() {
/*  98 */     return this.invK2;
/*     */   }
/*     */   public opencv_core.CvMat getR() {
/* 101 */     return this.R;
/*     */   }
/*     */   public opencv_core.CvMat getT() {
/* 104 */     return this.t;
/*     */   }
/*     */   public opencv_core.CvMat getN() {
/* 107 */     return this.n;
/*     */   }
/*     */ 
/*     */   protected void prepareHomography(opencv_core.CvMat H, int pyramidLevel, Parameters p, boolean inverse) {
/* 111 */     if ((this.K2 != null) && (this.invK1 != null) && (this.R != null) && (this.t != null) && (p.fakeIdentity))
/*     */     {
/* 114 */       opencv_core.cvSetIdentity(H);
/* 115 */       return;
/*     */     }
/*     */ 
/* 118 */     if (inverse)
/* 119 */       H.put(p.getH());
/*     */     else {
/* 121 */       opencv_core.cvInvert(p.getH(), H);
/*     */     }
/*     */ 
/* 125 */     if (pyramidLevel > 0) {
/* 126 */       int scale = 1 << pyramidLevel;
/* 127 */       H.put(2, H.get(2) / scale);
/* 128 */       H.put(5, H.get(5) / scale);
/* 129 */       H.put(6, H.get(6) * scale);
/* 130 */       H.put(7, H.get(7) * scale);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void transform(opencv_core.IplImage srcImage, opencv_core.IplImage dstImage, opencv_core.CvRect roi, int pyramidLevel, ImageTransformer.Parameters parameters, boolean inverse)
/*     */   {
/* 136 */     Parameters p = (Parameters)parameters;
/* 137 */     if ((this.K2 != null) && (this.invK1 != null) && (this.R != null) && (this.t != null) && (p.fakeIdentity))
/*     */     {
/* 140 */       if (srcImage != dstImage) {
/* 141 */         opencv_core.cvCopy(srcImage, dstImage);
/*     */       }
/* 143 */       return;
/*     */     }
/*     */ 
/* 146 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/* 147 */     prepareHomography(H, pyramidLevel, p, true);
/*     */ 
/* 152 */     if ((roi != null) && ((roi.x() != 0) || (roi.y() != 0))) {
/* 153 */       int x = roi.x(); int y = roi.y();
/* 154 */       if (inverse) {
/* 155 */         H.put(2, H.get(0) * x + H.get(1) * y + H.get(2));
/* 156 */         H.put(5, H.get(3) * x + H.get(4) * y + H.get(5));
/* 157 */         H.put(8, H.get(6) * x + H.get(7) * y + H.get(8));
/*     */       } else {
/* 159 */         H.put(0, H.get(0) - x * H.get(6));
/* 160 */         H.put(1, H.get(1) - x * H.get(7));
/* 161 */         H.put(2, H.get(2) - x * H.get(8));
/* 162 */         H.put(3, H.get(3) - y * H.get(6));
/* 163 */         H.put(4, H.get(4) - y * H.get(7));
/* 164 */         H.put(5, H.get(5) - y * H.get(8));
/*     */       }
/*     */     }
/*     */ 
/* 168 */     dstImage.origin(srcImage.origin());
/*     */ 
/* 170 */     if (roi == null)
/* 171 */       opencv_core.cvResetImageROI(dstImage);
/*     */     else {
/* 173 */       opencv_core.cvSetImageROI(dstImage, roi);
/*     */     }
/* 175 */     opencv_imgproc.cvWarpPerspective(srcImage, dstImage, H, 0x9 | (inverse ? 16 : 0), getFillColor());
/*     */   }
/*     */ 
/*     */   public void transform(opencv_core.CvMat srcPts, opencv_core.CvMat dstPts, ImageTransformer.Parameters parameters, boolean inverse)
/*     */   {
/* 181 */     Parameters p = (Parameters)parameters;
/*     */     opencv_core.CvMat H;
/* 183 */     if (inverse) {
/* 184 */       opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/* 185 */       opencv_core.cvInvert(p.getH(), H);
/*     */     } else {
/* 187 */       H = p.getH();
/*     */     }
/* 189 */     opencv_core.cvPerspectiveTransform(srcPts, dstPts, H);
/*     */   }
/*     */ 
/*     */   public void transform(ImageTransformer.Data[] data, opencv_core.CvRect roi, ImageTransformer.Parameters[] parameters, boolean[] inverses) {
/* 193 */     assert (data.length == parameters.length);
/* 194 */     if ((this.kernelData == null) || (this.kernelData.capacity() < data.length)) {
/* 195 */       this.kernelData = new cvkernels.KernelData(data.length);
/*     */     }
/* 197 */     if ((this.H == null) || (this.H.length < data.length)) {
/* 198 */       this.H = new opencv_core.CvMat[data.length];
/* 199 */       for (int i = 0; i < this.H.length; i++) {
/* 200 */         this.H[i] = opencv_core.CvMat.create(3, 3);
/*     */       }
/*     */     }
/*     */ 
/* 204 */     for (int i = 0; i < data.length; i++) {
/* 205 */       this.kernelData.position(i);
/*     */ 
/* 207 */       this.kernelData.srcImg(data[i].srcImg);
/* 208 */       this.kernelData.srcImg2(null);
/* 209 */       this.kernelData.subImg(data[i].subImg);
/* 210 */       this.kernelData.srcDotImg(data[i].srcDotImg);
/* 211 */       this.kernelData.mask(data[i].mask);
/* 212 */       this.kernelData.zeroThreshold(data[i].zeroThreshold);
/* 213 */       this.kernelData.outlierThreshold(data[i].outlierThreshold);
/*     */ 
/* 215 */       prepareHomography(this.H[i], data[i].pyramidLevel, (Parameters)parameters[i], inverses == null ? 0 : inverses[i]);
/*     */ 
/* 218 */       this.kernelData.H1(this.H[i]);
/* 219 */       this.kernelData.H2(null);
/* 220 */       this.kernelData.X(null);
/*     */ 
/* 222 */       this.kernelData.transImg(data[i].transImg);
/* 223 */       this.kernelData.dstImg(data[i].dstImg);
/* 224 */       this.kernelData.dstDstDot(data[i].dstDstDot);
/*     */     }
/*     */ 
/* 227 */     int fullCapacity = this.kernelData.capacity();
/* 228 */     this.kernelData.capacity(data.length);
/* 229 */     cvkernels.multiWarpColorTransform(this.kernelData, roi, getFillColor());
/* 230 */     this.kernelData.capacity(fullCapacity);
/*     */ 
/* 232 */     for (int i = 0; i < data.length; i++) {
/* 233 */       this.kernelData.position(i);
/* 234 */       data[i].dstCount = this.kernelData.dstCount();
/* 235 */       data[i].dstCountZero = this.kernelData.dstCountZero();
/* 236 */       data[i].dstCountOutlier = this.kernelData.dstCountOutlier();
/* 237 */       data[i].srcDstDot = this.kernelData.srcDstDot();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Parameters createParameters() {
/* 242 */     return new Parameters();
/*     */   }
/*     */ 
/*     */   public class Parameters
/*     */     implements ImageTransformer.Parameters
/*     */   {
/* 250 */     protected double[] projectiveParameters = null;
/* 251 */     private opencv_core.CvMat H = opencv_core.CvMat.create(3, 3); private opencv_core.CvMat n2 = null; private opencv_core.CvMat R2 = null; private opencv_core.CvMat t2 = null;
/* 252 */     private double constraintError = 0.0D;
/* 253 */     private boolean updateNeeded = true;
/* 254 */     protected boolean fakeIdentity = false;
/*     */ 
/*     */     protected Parameters()
/*     */     {
/* 247 */       reset(false);
/*     */     }
/*     */ 
/*     */     public boolean isUpdateNeeded()
/*     */     {
/* 257 */       return this.updateNeeded;
/*     */     }
/*     */     public void setUpdateNeeded(boolean updateNeeded) {
/* 260 */       this.updateNeeded = updateNeeded;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 264 */       return this.projectiveParameters.length;
/*     */     }
/*     */     public double[] get() {
/* 267 */       double[] p = new double[size()];
/* 268 */       for (int i = 0; i < p.length; i++) {
/* 269 */         p[i] = get(i);
/*     */       }
/* 271 */       return p;
/*     */     }
/*     */     public double get(int i) {
/* 274 */       return this.projectiveParameters[i];
/*     */     }
/*     */     public void set(double[] p) {
/* 277 */       for (int i = 0; i < p.length; i++)
/* 278 */         set(i, p[i]);
/*     */     }
/*     */ 
/*     */     public void set(int i, double p) {
/* 282 */       if (this.projectiveParameters[i] != p) {
/* 283 */         this.projectiveParameters[i] = p;
/* 284 */         setUpdateNeeded(true);
/*     */       }
/*     */     }
/*     */ 
/* 288 */     public void set(ImageTransformer.Parameters p) { set(p.get());
/* 289 */       this.fakeIdentity = ((Parameters)p).fakeIdentity; }
/*     */ 
/*     */     public void reset(boolean asIdentity) {
/* 292 */       setUpdateNeeded(true);
/* 293 */       if ((ProjectiveTransformer.this.referencePoints1 != null) && ((ProjectiveTransformer.this.referencePoints1.length == 0) || (ProjectiveTransformer.this.referencePoints1.length == 8))) {
/* 294 */         if (ProjectiveTransformer.this.referencePoints1.length == 0)
/*     */         {
/* 298 */           this.projectiveParameters = new double[] { 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D };
/*     */         }
/*     */         else
/*     */         {
/* 304 */           this.projectiveParameters = ((double[])ProjectiveTransformer.this.referencePoints1.clone());
/*     */         }
/*     */       }
/* 307 */       else if ((ProjectiveTransformer.this.K2 != null) && (ProjectiveTransformer.this.invK1 != null))
/* 308 */         if ((ProjectiveTransformer.this.R != null) && (ProjectiveTransformer.this.t != null))
/*     */         {
/* 311 */           this.projectiveParameters = new double[] { ProjectiveTransformer.this.referencePoints1[0], ProjectiveTransformer.this.referencePoints1[2], ProjectiveTransformer.this.referencePoints1[4] };
/*     */         }
/* 313 */         else if (ProjectiveTransformer.this.n != null)
/* 314 */           this.projectiveParameters = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*     */         else
/* 316 */           this.projectiveParameters = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*     */     }
/*     */ 
/*     */     public double getConstraintError()
/*     */     {
/* 344 */       update();
/* 345 */       return this.constraintError;
/*     */     }
/*     */     public void set(opencv_core.CvMat setH, boolean inverse) {
/* 348 */       if ((this.projectiveParameters.length == 8) && (ProjectiveTransformer.this.referencePoints1 != null)) {
/* 349 */         if (inverse)
/* 350 */           opencv_core.cvInvert(setH, this.H);
/* 351 */         else if (setH != this.H) {
/* 352 */           opencv_core.cvCopy(setH, this.H);
/*     */         }
/* 354 */         if (ProjectiveTransformer.this.referencePoints1.length == 0)
/*     */         {
/* 356 */           for (int i = 0; i < 8; i++)
/* 357 */             this.projectiveParameters[i] = (this.H.get(i) / this.H.get(8));
/*     */         }
/*     */         else
/*     */         {
/* 361 */           opencv_core.CvMat pts = ((opencv_core.CvMat)ProjectiveTransformer.pts4x1.get()).put(ProjectiveTransformer.this.referencePoints1);
/* 362 */           opencv_core.cvPerspectiveTransform(pts, pts, this.H);
/* 363 */           pts.get(this.projectiveParameters);
/*     */         }
/* 365 */         setUpdateNeeded(true);
/*     */       } else {
/* 367 */         throw new UnsupportedOperationException("Set homography operation not supported.");
/*     */       }
/*     */     }
/*     */ 
/*     */     public void compose(ImageTransformer.Parameters p1, boolean inverse1, ImageTransformer.Parameters p2, boolean inverse2) {
/* 372 */       Parameters pp1 = (Parameters)p1; Parameters pp2 = (Parameters)p2;
/* 373 */       if ((ProjectiveTransformer.this.K2 != null) && (ProjectiveTransformer.this.invK1 != null) && (ProjectiveTransformer.this.R != null) && (ProjectiveTransformer.this.t != null) && (pp1.fakeIdentity))
/*     */       {
/* 376 */         return;
/*     */       }
/*     */ 
/* 379 */       compose(pp1.getH(), inverse1, pp2.getH(), inverse2);
/*     */     }
/*     */     public void compose(opencv_core.CvMat H1, boolean inverse1, opencv_core.CvMat H2, boolean inverse2) {
/* 382 */       if ((inverse1) && (inverse2)) {
/* 383 */         opencv_core.cvMatMul(H2, H1, this.H);
/* 384 */         opencv_core.cvInvert(this.H, this.H);
/* 385 */       } else if (inverse1) {
/* 386 */         opencv_core.cvInvert(H1, this.H);
/* 387 */         opencv_core.cvMatMul(this.H, H2, this.H);
/* 388 */       } else if (inverse2) {
/* 389 */         opencv_core.cvInvert(H2, this.H);
/* 390 */         opencv_core.cvMatMul(H1, this.H, this.H);
/*     */       } else {
/* 392 */         opencv_core.cvMatMul(H1, H2, this.H);
/*     */       }
/* 394 */       set(this.H, false);
/*     */     }
/*     */ 
/*     */     public opencv_core.CvMat getH() {
/* 398 */       update();
/* 399 */       return this.H;
/*     */     }
/*     */     public opencv_core.CvMat getN() {
/* 402 */       update();
/* 403 */       return this.n2;
/*     */     }
/*     */     public opencv_core.CvMat getR() {
/* 406 */       update();
/* 407 */       return this.R2;
/*     */     }
/*     */     public opencv_core.CvMat getT() {
/* 410 */       update();
/* 411 */       return this.t2;
/*     */     }
/*     */ 
/*     */     protected void update() {
/* 415 */       if (!isUpdateNeeded()) {
/* 416 */         return;
/*     */       }
/*     */ 
/* 419 */       if ((ProjectiveTransformer.this.referencePoints1 != null) && ((ProjectiveTransformer.this.referencePoints1.length == 0) || (ProjectiveTransformer.this.referencePoints1.length == 8))) {
/* 420 */         if (ProjectiveTransformer.this.referencePoints1.length == 0)
/*     */         {
/* 422 */           this.H.put(0, this.projectiveParameters, 0, 8);
/* 423 */           this.H.put(8, 1.0D);
/*     */         }
/*     */         else {
/* 426 */           JavaCV.getPerspectiveTransform(ProjectiveTransformer.this.referencePoints1, this.projectiveParameters, this.H);
/*     */         }
/*     */ 
/*     */       }
/* 446 */       else if ((ProjectiveTransformer.this.K2 != null) && (ProjectiveTransformer.this.invK1 != null)) {
/* 447 */         if ((ProjectiveTransformer.this.R != null) && (ProjectiveTransformer.this.t != null))
/*     */         {
/* 452 */           double[] src = ProjectiveTransformer.this.referencePoints2;
/* 453 */           double[] dst = { this.projectiveParameters[0], ProjectiveTransformer.this.referencePoints1[1], this.projectiveParameters[1], ProjectiveTransformer.this.referencePoints1[3], this.projectiveParameters[2], ProjectiveTransformer.this.referencePoints1[5] };
/*     */ 
/* 456 */           if (this.R2 == null) {
/* 457 */             this.R2 = opencv_core.CvMat.create(3, 3);
/*     */           }
/* 459 */           if (this.t2 == null) {
/* 460 */             this.t2 = opencv_core.CvMat.create(3, 1);
/*     */           }
/* 462 */           opencv_core.cvTranspose(ProjectiveTransformer.this.R, this.R2);
/* 463 */           opencv_core.cvGEMM(this.R2, ProjectiveTransformer.this.t, -1.0D, null, 0.0D, this.t2, 0);
/* 464 */           JavaCV.getPerspectiveTransform(src, dst, ProjectiveTransformer.this.invK2, ProjectiveTransformer.this.K1, this.R2, this.t2, this.H);
/*     */         }
/*     */         else
/*     */         {
/* 473 */           if (ProjectiveTransformer.this.n != null) {
/* 474 */             this.n2 = ProjectiveTransformer.this.n;
/*     */           } else {
/* 476 */             if (this.n2 == null) {
/* 477 */               this.n2 = opencv_core.CvMat.create(3, 1);
/*     */             }
/* 479 */             this.n2.put(0, this.projectiveParameters, 8, 3);
/*     */           }
/*     */ 
/* 483 */           if (this.R2 == null) {
/* 484 */             this.R2 = opencv_core.CvMat.create(3, 3);
/*     */           }
/* 486 */           if (this.t2 == null) {
/* 487 */             this.t2 = opencv_core.CvMat.create(3, 1);
/*     */           }
/* 489 */           this.t2.put(0, this.projectiveParameters, 0, 3);
/* 490 */           opencv_calib3d.cvRodrigues2(this.t2, this.R2, null);
/* 491 */           this.t2.put(0, this.projectiveParameters, 3, 3);
/*     */ 
/* 494 */           opencv_core.cvGEMM(this.t2, this.n2, -1.0D, this.R2, 1.0D, this.H, 2);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 501 */       setUpdateNeeded(false);
/*     */     }
/*     */ 
/*     */     public boolean preoptimize()
/*     */     {
/* 520 */       return false;
/*     */     }
/*     */     public double[] getSubspace() {
/* 523 */       return null;
/*     */     }
/*     */     public void setSubspace(double[] p) {
/*     */     }
/*     */ 
/*     */     public Parameters clone() {
/* 529 */       Parameters p = new Parameters(ProjectiveTransformer.this);
/* 530 */       p.set(this);
/* 531 */       return p;
/*     */     }
/*     */ 
/*     */     public String toString() {
/* 535 */       String s = "[";
/* 536 */       double[] p = get();
/* 537 */       for (int i = 0; i < p.length; i++) {
/* 538 */         s = s + (float)p[i];
/* 539 */         if (i < p.length - 1) {
/* 540 */           s = s + ", ";
/*     */         }
/*     */       }
/* 543 */       s = s + "]";
/* 544 */       return s;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectiveTransformer
 * JD-Core Version:    0.6.2
 */