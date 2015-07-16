/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.cvkernels;
/*     */ import com.googlecode.javacv.cpp.cvkernels.KernelData;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class ProjectiveColorTransformer extends ProjectiveTransformer
/*     */ {
/*  45 */   protected static ThreadLocal<opencv_core.CvMat> X24x4 = opencv_core.CvMat.createThreadLocal(4, 4);
/*  46 */   protected static ThreadLocal<opencv_core.CvMat> temp3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*     */ 
/*  48 */   protected opencv_core.CvMat X = null;
/*  49 */   protected int numGains = 0; protected int numBiases = 0;
/*     */ 
/*  51 */   protected opencv_core.CvMat[] X2 = null;
/*     */ 
/*     */   public ProjectiveColorTransformer(opencv_core.CvMat K1, opencv_core.CvMat K2, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2, opencv_core.CvMat X, int numGains, int numBiases)
/*     */   {
/*  36 */     super(K1, K2, R, t, n, referencePoints1, referencePoints2);
/*     */ 
/*  38 */     this.X = (X == null ? null : X.clone());
/*     */ 
/*  40 */     this.numGains = numGains;
/*  41 */     this.numBiases = numBiases;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat getX()
/*     */   {
/*  54 */     return this.X;
/*     */   }
/*     */   public int getNumGains() {
/*  57 */     return this.numGains;
/*     */   }
/*     */   public int getNumBiases() {
/*  60 */     return this.numBiases;
/*     */   }
/*     */ 
/*     */   public void transformColor(opencv_core.IplImage srcImage, opencv_core.IplImage dstImage, opencv_core.CvRect roi, int pyramidLevel, ImageTransformer.Parameters parameters, boolean inverse)
/*     */   {
/*  65 */     Parameters p = (Parameters)parameters;
/*     */ 
/*  67 */     if (((Arrays.equals(p.getColorParameters(), p.getIdentityColorParameters())) && ((this.X == null) || (p.fakeIdentity))) || ((this.X == null) && (this.numGains == 0) && (this.numBiases == 0)))
/*     */     {
/*  69 */       if (srcImage != dstImage) {
/*  70 */         opencv_core.cvCopy(srcImage, dstImage);
/*     */       }
/*  72 */       return;
/*     */     }
/*     */ 
/*  75 */     opencv_core.CvMat X2 = (opencv_core.CvMat)X24x4.get();
/*  76 */     prepareColorTransform(X2, pyramidLevel, p, inverse);
/*  77 */     X2.rows(3);
/*     */ 
/*  79 */     if (roi == null)
/*  80 */       opencv_core.cvResetImageROI(dstImage);
/*     */     else {
/*  82 */       opencv_core.cvSetImageROI(dstImage, roi);
/*     */     }
/*  84 */     X2.put(0, 3, X2.get(0, 3) * dstImage.highValue());
/*  85 */     X2.put(1, 3, X2.get(1, 3) * dstImage.highValue());
/*  86 */     X2.put(2, 3, X2.get(2, 3) * dstImage.highValue());
/*  87 */     opencv_core.cvTransform(srcImage, dstImage, X2, null);
/*  88 */     X2.rows(4);
/*     */   }
/*     */ 
/*     */   protected void prepareColorTransform(opencv_core.CvMat X2, int pyramidLevel, Parameters p, boolean inverse) {
/*  92 */     opencv_core.CvMat A = p.getA(); opencv_core.CvMat b = p.getB();
/*     */ 
/*  94 */     opencv_core.cvSetIdentity(X2);
/*     */ 
/*  96 */     X2.rows(3); X2.cols(3);
/*  97 */     if ((p.fakeIdentity) && (!inverse))
/*  98 */       X2.put(A);
/*  99 */     else if ((A != null) && (this.X != null))
/* 100 */       opencv_core.cvMatMul(this.X, A, X2);
/* 101 */     else if (this.X == null)
/* 102 */       X2.put(A);
/* 103 */     else if (A == null) {
/* 104 */       X2.put(this.X);
/*     */     }
/*     */ 
/* 107 */     X2.rows(4); X2.cols(4);
/* 108 */     if (b != null) {
/* 109 */       X2.put(0, 3, b.get(0));
/* 110 */       X2.put(1, 3, b.get(1));
/* 111 */       X2.put(2, 3, b.get(2));
/*     */     }
/*     */ 
/* 114 */     if (inverse)
/*     */     {
/* 116 */       opencv_core.cvInvert(X2, X2, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void transform(ImageTransformer.Data[] data, opencv_core.CvRect roi, ImageTransformer.Parameters[] parameters, boolean[] inverses) {
/* 121 */     assert (data.length == parameters.length);
/* 122 */     if ((this.kernelData == null) || (this.kernelData.capacity() < data.length)) {
/* 123 */       this.kernelData = new cvkernels.KernelData(data.length);
/*     */     }
/* 125 */     if ((this.H == null) || (this.H.length < data.length)) {
/* 126 */       this.H = new opencv_core.CvMat[data.length];
/* 127 */       for (int i = 0; i < this.H.length; i++) {
/* 128 */         this.H[i] = opencv_core.CvMat.create(3, 3);
/*     */       }
/*     */     }
/* 131 */     if ((this.X2 == null) || (this.X2.length < data.length)) {
/* 132 */       this.X2 = new opencv_core.CvMat[data.length];
/* 133 */       for (int i = 0; i < this.X2.length; i++) {
/* 134 */         this.X2[i] = opencv_core.CvMat.create(4, 4);
/*     */       }
/*     */     }
/*     */ 
/* 138 */     for (int i = 0; i < data.length; i++) {
/* 139 */       this.kernelData.position(i);
/*     */ 
/* 141 */       this.kernelData.srcImg(data[i].srcImg);
/* 142 */       this.kernelData.srcImg2(null);
/* 143 */       this.kernelData.subImg(data[i].subImg);
/* 144 */       this.kernelData.srcDotImg(data[i].srcDotImg);
/* 145 */       this.kernelData.mask(data[i].mask);
/* 146 */       this.kernelData.zeroThreshold(data[i].zeroThreshold);
/* 147 */       this.kernelData.outlierThreshold(data[i].outlierThreshold);
/*     */ 
/* 149 */       boolean inverse = inverses == null ? 0 : inverses[i];
/* 150 */       prepareHomography(this.H[i], data[i].pyramidLevel, (Parameters)parameters[i], inverse);
/* 151 */       prepareColorTransform(this.X2[i], data[i].pyramidLevel, (Parameters)parameters[i], inverse);
/*     */ 
/* 153 */       this.kernelData.H1(this.H[i]);
/* 154 */       this.kernelData.H2(null);
/* 155 */       this.kernelData.X(this.X2[i]);
/*     */ 
/* 157 */       this.kernelData.transImg(data[i].transImg);
/* 158 */       this.kernelData.dstImg(data[i].dstImg);
/* 159 */       this.kernelData.dstDstDot(data[i].dstDstDot);
/*     */     }
/*     */ 
/* 162 */     int fullCapacity = this.kernelData.capacity();
/* 163 */     this.kernelData.capacity(data.length);
/* 164 */     cvkernels.multiWarpColorTransform(this.kernelData, roi, getFillColor());
/* 165 */     this.kernelData.capacity(fullCapacity);
/*     */ 
/* 167 */     for (int i = 0; i < data.length; i++) {
/* 168 */       this.kernelData.position(i);
/* 169 */       data[i].dstCount = this.kernelData.dstCount();
/* 170 */       data[i].dstCountZero = this.kernelData.dstCountZero();
/* 171 */       data[i].dstCountOutlier = this.kernelData.dstCountOutlier();
/* 172 */       data[i].srcDstDot = this.kernelData.srcDstDot();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Parameters createParameters() {
/* 177 */     return new Parameters();
/*     */   }
/*     */ 
/*     */   public class Parameters extends ProjectiveTransformer.Parameters
/*     */   {
/* 213 */     protected double[] colorParameters = null; protected double[] identityColorParameters = null;
/* 214 */     private opencv_core.CvMat A = null; private opencv_core.CvMat b = null;
/*     */ 
/*     */     protected Parameters()
/*     */     {
/* 181 */       super();
/* 182 */       this.identityColorParameters = new double[ProjectiveColorTransformer.this.numGains + ProjectiveColorTransformer.this.numBiases];
/* 183 */       if (ProjectiveColorTransformer.this.numGains > 0) {
/* 184 */         this.A = opencv_core.CvMat.create(3, 3);
/* 185 */         opencv_core.cvSetIdentity(this.A);
/*     */       }
/* 187 */       if (ProjectiveColorTransformer.this.numBiases > 0) {
/* 188 */         this.b = opencv_core.CvMat.create(3, 1);
/* 189 */         opencv_core.cvSetZero(this.b);
/*     */       }
/*     */ 
/* 192 */       switch (ProjectiveColorTransformer.this.numGains) { case 0:
/* 193 */         if ((!$assertionsDisabled) && (this.A != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 194 */         this.identityColorParameters[0] = ((this.A.get(0) + this.A.get(4) + this.A.get(8)) / 3.0D);
/* 195 */         break;
/*     */       case 3:
/* 196 */         this.identityColorParameters[0] = this.A.get(0);
/* 197 */         this.identityColorParameters[1] = this.A.get(4);
/* 198 */         this.identityColorParameters[2] = this.A.get(8); break;
/*     */       case 9:
/* 199 */         this.A.get(0, this.identityColorParameters, 0, 9); break;
/*     */       case 2:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       default:
/* 200 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/* 202 */       switch (ProjectiveColorTransformer.this.numBiases) { case 0:
/* 203 */         if ((!$assertionsDisabled) && (this.b != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 204 */         this.identityColorParameters[ProjectiveColorTransformer.this.numGains] = ((this.b.get(0) + this.b.get(1) + this.b.get(2)) / 3.0D);
/* 205 */         break;
/*     */       case 3:
/* 206 */         this.b.get(0, this.identityColorParameters, ProjectiveColorTransformer.this.numGains, 3); break;
/*     */       case 2:
/*     */       default:
/* 207 */         if (!$assertionsDisabled) throw new AssertionError();
/*     */         break;
/*     */       }
/* 210 */       reset(false);
/*     */     }
/*     */ 
/*     */     public double[] getColorParameters()
/*     */     {
/* 217 */       return this.colorParameters;
/*     */     }
/*     */     public double[] getIdentityColorParameters() {
/* 220 */       return this.identityColorParameters;
/*     */     }
/*     */ 
/*     */     public int size() {
/* 224 */       return super.size() + ProjectiveColorTransformer.this.numGains + ProjectiveColorTransformer.this.numBiases;
/*     */     }
/*     */     public double get(int i) {
/* 227 */       int s = super.size();
/* 228 */       if (i < s) {
/* 229 */         return super.get(i);
/*     */       }
/* 231 */       return this.colorParameters[(i - s)];
/*     */     }
/*     */ 
/*     */     public void set(int i, double p) {
/* 235 */       int s = super.size();
/* 236 */       if (i < s) {
/* 237 */         super.set(i, p);
/*     */       }
/* 239 */       else if (this.colorParameters[(i - s)] != p) {
/* 240 */         this.colorParameters[(i - s)] = p;
/* 241 */         setUpdateNeeded(true);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void reset(boolean asIdentity) {
/* 246 */       super.reset(asIdentity);
/* 247 */       resetColor(asIdentity);
/*     */     }
/*     */     public void resetColor(boolean asIdentity) {
/* 250 */       if ((this.identityColorParameters != null) && (
/* 251 */         (!Arrays.equals(this.colorParameters, this.identityColorParameters)) || (this.fakeIdentity != asIdentity)))
/*     */       {
/* 253 */         this.fakeIdentity = asIdentity;
/* 254 */         this.colorParameters = ((double[])this.identityColorParameters.clone());
/* 255 */         setUpdateNeeded(true);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void compose(ImageTransformer.Parameters p1, boolean inverse1, ImageTransformer.Parameters p2, boolean inverse2)
/*     */     {
/* 276 */       super.compose(p1, inverse1, p2, inverse2);
/* 277 */       composeColor(p1, inverse1, p2, inverse2);
/*     */     }
/*     */ 
/*     */     public void composeColor(ImageTransformer.Parameters p1, boolean inverse1, ImageTransformer.Parameters p2, boolean inverse2) {
/* 281 */       assert ((!inverse1) && (!inverse2));
/*     */ 
/* 283 */       Parameters pp1 = (Parameters)p1; Parameters pp2 = (Parameters)p2;
/* 284 */       opencv_core.CvMat A1 = pp1.getA(); opencv_core.CvMat b1 = pp1.getB();
/* 285 */       opencv_core.CvMat A2 = pp2.getA(); opencv_core.CvMat b2 = pp2.getB();
/*     */ 
/* 287 */       if (this.b != null) {
/* 288 */         if ((pp1.fakeIdentity) && (ProjectiveColorTransformer.this.X != null)) {
/* 289 */           opencv_core.CvMat temp = (opencv_core.CvMat)ProjectiveColorTransformer.temp3x1.get();
/* 290 */           opencv_core.cvMatMul(ProjectiveColorTransformer.this.X, b1, temp);
/* 291 */           b1 = temp;
/*     */         }
/*     */ 
/* 294 */         if ((A2 == null) && (b2 == null))
/* 295 */           opencv_core.cvCopy(b1, this.b);
/* 296 */         else if (b1 == null)
/* 297 */           opencv_core.cvCopy(b2, this.b);
/* 298 */         else if (b2 == null)
/* 299 */           opencv_core.cvMatMul(A2, b1, this.b);
/*     */         else {
/* 301 */           opencv_core.cvGEMM(A2, b1, 1.0D, b2, 1.0D, this.b, 0);
/*     */         }
/*     */       }
/*     */ 
/* 305 */       if (this.A != null) {
/* 306 */         if (A1 == null)
/* 307 */           opencv_core.cvCopy(A2, this.A);
/* 308 */         else if (A2 == null)
/* 309 */           opencv_core.cvCopy(A1, this.A);
/*     */         else {
/* 311 */           opencv_core.cvMatMul(A2, A1, this.A);
/*     */         }
/*     */       }
/*     */ 
/* 315 */       switch (ProjectiveColorTransformer.this.numGains) { case 0:
/* 316 */         if ((!$assertionsDisabled) && (this.A != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 317 */         this.colorParameters[0] = ((this.A.get(0) + this.A.get(4) + this.A.get(8)) / 3.0D);
/* 318 */         break;
/*     */       case 3:
/* 319 */         this.colorParameters[0] = this.A.get(0);
/* 320 */         this.colorParameters[1] = this.A.get(4);
/* 321 */         this.colorParameters[2] = this.A.get(8); break;
/*     */       case 9:
/* 322 */         this.A.get(0, this.colorParameters, 0, 9); break;
/*     */       case 2:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       default:
/* 323 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/* 325 */       switch (ProjectiveColorTransformer.this.numBiases) { case 0:
/* 326 */         if ((!$assertionsDisabled) && (this.b != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 327 */         this.colorParameters[ProjectiveColorTransformer.this.numGains] = ((this.b.get(0) + this.b.get(1) + this.b.get(2)) / 3.0D);
/* 328 */         break;
/*     */       case 3:
/* 329 */         this.b.get(0, this.colorParameters, ProjectiveColorTransformer.this.numGains, 3); break;
/*     */       case 2:
/*     */       default:
/* 330 */         if (!$assertionsDisabled) throw new AssertionError(); break; }
/*     */     }
/*     */ 
/*     */     public opencv_core.CvMat getA()
/*     */     {
/* 335 */       update();
/* 336 */       return this.A;
/*     */     }
/*     */     public opencv_core.CvMat getB() {
/* 339 */       update();
/* 340 */       return this.b;
/*     */     }
/*     */ 
/*     */     protected void update() {
/* 344 */       if (!isUpdateNeeded()) {
/* 345 */         return;
/*     */       }
/*     */ 
/* 348 */       switch (ProjectiveColorTransformer.this.numGains) { case 0:
/* 349 */         if ((!$assertionsDisabled) && (this.A != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 350 */         this.A.put(0, this.colorParameters[0]);
/* 351 */         this.A.put(4, this.colorParameters[0]);
/* 352 */         this.A.put(8, this.colorParameters[0]); break;
/*     */       case 3:
/* 353 */         this.A.put(0, this.colorParameters[0]);
/* 354 */         this.A.put(4, this.colorParameters[1]);
/* 355 */         this.A.put(8, this.colorParameters[2]); break;
/*     */       case 9:
/* 356 */         this.A.put(0, this.colorParameters, 0, 9); break;
/*     */       case 2:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       default:
/* 357 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/* 359 */       switch (ProjectiveColorTransformer.this.numBiases) { case 0:
/* 360 */         if ((!$assertionsDisabled) && (this.b != null)) throw new AssertionError(); break;
/*     */       case 1:
/* 361 */         this.b.put(0, this.colorParameters[ProjectiveColorTransformer.this.numGains]);
/* 362 */         this.b.put(1, this.colorParameters[ProjectiveColorTransformer.this.numGains]);
/* 363 */         this.b.put(2, this.colorParameters[ProjectiveColorTransformer.this.numGains]); break;
/*     */       case 3:
/* 364 */         this.b.put(0, this.colorParameters, ProjectiveColorTransformer.this.numGains, 3); break;
/*     */       case 2:
/*     */       default:
/* 365 */         if (!$assertionsDisabled) throw new AssertionError();
/*     */         break;
/*     */       }
/* 368 */       super.update();
/* 369 */       setUpdateNeeded(false);
/*     */     }
/*     */ 
/*     */     public Parameters clone() {
/* 373 */       Parameters p = new Parameters(ProjectiveColorTransformer.this);
/* 374 */       p.set(this);
/* 375 */       return p;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectiveColorTransformer
 * JD-Core Version:    0.6.2
 */