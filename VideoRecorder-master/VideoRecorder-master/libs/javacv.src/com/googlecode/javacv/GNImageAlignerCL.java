/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.jogamp.opencl.CLImage2d;
/*     */ import com.jogamp.opencl.CLImageFormat;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelOrder;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelType;
/*     */ import com.jogamp.opencl.CLMemory.Mem;
/*     */ import com.jogamp.opencl.gl.CLGLContext;
/*     */ import com.jogamp.opencl.gl.CLGLImage2d;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.Arrays;
/*     */ import javax.media.opengl.GL2;
/*     */ import javax.media.opengl.GLContext;
/*     */ import javax.media.opengl.glu.GLU;
/*     */ 
/*     */ public class GNImageAlignerCL extends GNImageAligner
/*     */   implements ImageAlignerCL
/*     */ {
/*     */   private final JavaCVCL context;
/*     */   private CLImage2d[] templateCL;
/*     */   private CLImage2d[] targetCL;
/*     */   private CLImage2d[] transformedCL;
/*     */   private CLImage2d[] residualCL;
/*     */   private CLGLImage2d[] maskCL;
/*     */   private int[] maskrb;
/*     */   private int[] maskfb;
/* 138 */   private CLImage2d[] imagesCL = new CLImage2d[5];
/*     */   private ImageTransformerCL.InputData inputData;
/*     */   private ImageTransformerCL.OutputData outputData;
/*     */   private boolean[] templateChanged;
/*     */ 
/*     */   public GNImageAlignerCL(ImageTransformerCL transformer, ImageTransformer.Parameters initialParameters, CLImage2d template0, double[] roiPts, CLImage2d target0)
/*     */   {
/*  42 */     this(transformer, initialParameters, template0, roiPts, target0, new GNImageAligner.Settings());
/*     */   }
/*     */ 
/*     */   public GNImageAlignerCL(ImageTransformerCL transformer, ImageTransformer.Parameters initialParameters, CLImage2d template0, double[] roiPts, CLImage2d target0, GNImageAligner.Settings settings) {
/*  46 */     super(transformer, initialParameters);
/*  47 */     setSettings(settings);
/*  48 */     this.context = transformer.getContext();
/*     */ 
/*  50 */     int minLevel = settings.pyramidLevelMin;
/*  51 */     int maxLevel = settings.pyramidLevelMax;
/*     */ 
/*  53 */     this.template = new opencv_core.IplImage[maxLevel + 1];
/*  54 */     this.target = new opencv_core.IplImage[maxLevel + 1];
/*  55 */     this.transformed = new opencv_core.IplImage[maxLevel + 1];
/*  56 */     this.residual = new opencv_core.IplImage[maxLevel + 1];
/*  57 */     this.mask = new opencv_core.IplImage[maxLevel + 1];
/*     */ 
/*  59 */     this.templateCL = new CLImage2d[maxLevel + 1];
/*  60 */     this.targetCL = new CLImage2d[maxLevel + 1];
/*  61 */     this.transformedCL = new CLImage2d[maxLevel + 1];
/*  62 */     this.residualCL = new CLImage2d[maxLevel + 1];
/*  63 */     this.maskCL = new CLGLImage2d[maxLevel + 1];
/*  64 */     this.maskrb = new int[maxLevel + 1];
/*  65 */     this.maskfb = new int[maxLevel + 1];
/*  66 */     int w = template0 != null ? template0.width : target0.width;
/*  67 */     int h = template0 != null ? template0.height : target0.height;
/*  68 */     CLGLContext c = this.context.getCLGLContext();
/*     */ 
/*  71 */     GL2 gl = this.context.getGL2();
/*  72 */     gl.glGenRenderbuffers(maxLevel + 1, this.maskrb, 0);
/*  73 */     gl.glGenFramebuffers(maxLevel + 1, this.maskfb, 0);
/*  74 */     CLImageFormat f = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
/*  75 */     for (int i = minLevel; i <= maxLevel; i++) {
/*  76 */       this.templateCL[i] = ((i == minLevel) && (template0 != null) ? template0 : c.createImage2d(w, h, f, new CLMemory.Mem[0]));
/*  77 */       this.targetCL[i] = ((i == minLevel) && (target0 != null) ? target0 : c.createImage2d(w, h, f, new CLMemory.Mem[0]));
/*  78 */       this.transformedCL[i] = c.createImage2d(w, h, f, new CLMemory.Mem[0]);
/*  79 */       this.residualCL[i] = c.createImage2d(w, h, f, new CLMemory.Mem[0]);
/*  80 */       gl.glBindRenderbuffer(36161, this.maskrb[i]);
/*  81 */       gl.glBindFramebuffer(36160, this.maskfb[i]);
/*  82 */       gl.glRenderbufferStorage(36161, 32832, w, h);
/*  83 */       gl.glFramebufferRenderbuffer(36160, 36064, 36161, this.maskrb[i]);
/*  84 */       assert (gl.glCheckFramebufferStatus(36160) == 36053);
/*  85 */       this.maskCL[i] = c.createFromGLRenderbuffer(this.maskrb[i], new CLMemory.Mem[0]);
/*  86 */       System.out.println(this.maskCL[i] + " " + this.maskCL[i].getElementSize() + " " + this.maskCL[i].getFormat());
/*  87 */       w /= 2;
/*  88 */       h /= 2;
/*     */     }
/*     */ 
/*  92 */     this.inputData = new ImageTransformerCL.InputData();
/*  93 */     this.outputData = new ImageTransformerCL.OutputData(false);
/*  94 */     this.templateChanged = new boolean[maxLevel + 1];
/*  95 */     Arrays.fill(this.templateChanged, true);
/*     */ 
/*  97 */     setConstrained(settings.constrained);
/*  98 */     setTemplateImageCL(template0, roiPts);
/*  99 */     setTargetImageCL(target0);
/*     */   }
/*     */   public void release() {
/* 102 */     int minLevel = this.settings.pyramidLevelMin;
/* 103 */     int maxLevel = this.settings.pyramidLevelMax;
/*     */ 
/* 105 */     if ((this.templateCL != null) && (this.targetCL != null) && (this.transformedCL != null) && (this.residualCL != null) && (this.maskCL != null))
/*     */     {
/* 107 */       for (int i = minLevel; i <= maxLevel; i++) {
/* 108 */         if (i > minLevel) this.templateCL[i].release();
/* 109 */         if (i > minLevel) this.targetCL[i].release();
/* 110 */         this.transformedCL[i].release();
/* 111 */         this.residualCL[i].release();
/* 112 */         this.maskCL[i].release();
/*     */       }
/* 114 */       this.templateCL = (this.targetCL = this.transformedCL = this.residualCL = this.maskCL = null);
/*     */     }
/*     */ 
/* 118 */     this.context.getGLContext().makeCurrent();
/* 119 */     GL2 gl = this.context.getGL2();
/* 120 */     if (this.maskfb != null) {
/* 121 */       gl.glDeleteFramebuffers(maxLevel + 1, this.maskfb, 0);
/* 122 */       this.maskfb = null;
/*     */     }
/* 124 */     if (this.maskrb != null) {
/* 125 */       gl.glDeleteRenderbuffers(maxLevel + 1, this.maskrb, 0);
/* 126 */       this.maskrb = null;
/*     */     }
/*     */   }
/*     */ 
/* 130 */   protected void finalize() throws Throwable { super.finalize();
/* 131 */     release();
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTemplateImage()
/*     */   {
/* 144 */     return getTemplateImage(true);
/*     */   }
/*     */   public opencv_core.IplImage getTemplateImage(boolean blocking) {
/* 147 */     if (this.templateChanged[this.pyramidLevel] != 0) {
/* 148 */       this.templateChanged[this.pyramidLevel] = false;
/* 149 */       return this.template[this.pyramidLevel] =  = this.context.readImage(getTemplateImageCL(), this.template[this.pyramidLevel], blocking);
/*     */     }
/* 151 */     return this.template[this.pyramidLevel];
/*     */   }
/*     */ 
/*     */   public void setTemplateImage(opencv_core.IplImage template0, double[] roiPts) {
/* 155 */     this.context.writeImage(this.templateCL[this.settings.pyramidLevelMin], template0, false);
/* 156 */     setTemplateImageCL(this.templateCL[this.settings.pyramidLevelMin], roiPts);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTargetImage() {
/* 160 */     return getTargetImage(true);
/*     */   }
/*     */   public opencv_core.IplImage getTargetImage(boolean blocking) {
/* 163 */     return this.target[this.pyramidLevel] =  = this.context.readImage(getTargetImageCL(), this.target[this.pyramidLevel], blocking);
/*     */   }
/*     */   public void setTargetImage(opencv_core.IplImage target0) {
/* 166 */     this.context.writeImage(this.targetCL[this.settings.pyramidLevelMin], target0, false);
/* 167 */     setTargetImageCL(this.targetCL[this.settings.pyramidLevelMin]);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getTransformedImage() {
/* 171 */     return getTransformedImage(true);
/*     */   }
/*     */   public opencv_core.IplImage getTransformedImage(boolean blocking) {
/* 174 */     return this.transformed[this.pyramidLevel] =  = this.context.readImage(getTransformedImageCL(), this.transformed[this.pyramidLevel], blocking);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getResidualImage() {
/* 178 */     return getResidualImage(true);
/*     */   }
/*     */   public opencv_core.IplImage getResidualImage(boolean blocking) {
/* 181 */     return this.residual[this.pyramidLevel] =  = this.context.readImage(getResidualImageCL(), this.residual[this.pyramidLevel], blocking);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getMaskImage() {
/* 185 */     return getMaskImage(true);
/*     */   }
/*     */   public opencv_core.IplImage getMaskImage(boolean blocking) {
/* 188 */     this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
/* 189 */     this.mask[this.pyramidLevel] = this.context.readImage(getMaskImageCL(), this.mask[this.pyramidLevel], blocking);
/* 190 */     this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
/* 191 */     return this.mask[this.pyramidLevel];
/*     */   }
/*     */ 
/*     */   public double getRMSE() {
/* 195 */     if (this.residualUpdateNeeded) {
/* 196 */       doRoi();
/* 197 */       doResidual();
/*     */     }
/* 199 */     return this.RMSE;
/*     */   }
/*     */ 
/*     */   public int getPixelCount() {
/* 203 */     if (this.residualUpdateNeeded) {
/* 204 */       doRoi();
/* 205 */       doResidual();
/*     */     }
/* 207 */     return this.outputData.dstCount;
/*     */   }
/*     */ 
/*     */   public int getOutlierCount() {
/* 211 */     return this.outputData.dstCountOutlier;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvRect getRoi() {
/* 215 */     if (this.residualUpdateNeeded) {
/* 216 */       doRoi();
/*     */     }
/* 218 */     return this.roi.x(this.inputData.roiX).y(this.inputData.roiY).width(this.inputData.roiWidth).height(this.inputData.roiHeight);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage[] getImages()
/*     */   {
/* 223 */     return getImages(true);
/*     */   }
/*     */   public opencv_core.IplImage[] getImages(boolean blocking) {
/* 226 */     this.images[0] = getTemplateImage(false);
/* 227 */     this.images[1] = getTargetImage(false);
/* 228 */     this.images[2] = getTransformedImage(false);
/* 229 */     this.images[3] = getResidualImage(false);
/* 230 */     this.images[4] = getMaskImage(blocking);
/* 231 */     return this.images;
/*     */   }
/*     */ 
/*     */   public CLImage2d getTemplateImageCL() {
/* 235 */     return this.templateCL[this.pyramidLevel];
/*     */   }
/*     */   public void setTemplateImageCL(CLImage2d template0, double[] roiPts) {
/* 238 */     int minLevel = this.settings.pyramidLevelMin;
/* 239 */     int maxLevel = this.settings.pyramidLevelMax;
/*     */ 
/* 241 */     if ((roiPts == null) && (template0 != null)) {
/* 242 */       int w = template0.width << minLevel;
/* 243 */       int h = template0.height << minLevel;
/* 244 */       this.srcRoiPts.put(new double[] { 0.0D, 0.0D, w, 0.0D, w, h, 0.0D, h });
/*     */     } else {
/* 246 */       this.srcRoiPts.put(roiPts);
/*     */     }
/*     */ 
/* 249 */     if (template0 == null) {
/* 250 */       return;
/*     */     }
/*     */ 
/* 256 */     this.templateCL[minLevel] = template0;
/* 257 */     for (int i = minLevel + 1; i <= maxLevel; i++)
/*     */     {
/* 264 */       this.context.pyrDown(this.templateCL[(i - 1)], this.templateCL[i]);
/*     */     }
/* 266 */     setPyramidLevel(maxLevel);
/* 267 */     Arrays.fill(this.templateChanged, true);
/*     */   }
/*     */ 
/*     */   public CLImage2d getTargetImageCL() {
/* 271 */     return this.targetCL[this.pyramidLevel];
/*     */   }
/*     */   public void setTargetImageCL(CLImage2d target0) {
/* 274 */     int minLevel = this.settings.pyramidLevelMin;
/* 275 */     int maxLevel = this.settings.pyramidLevelMax;
/*     */ 
/* 280 */     this.targetCL[minLevel] = target0;
/* 281 */     for (int i = minLevel + 1; i <= maxLevel; i++)
/*     */     {
/* 288 */       this.context.pyrDown(this.targetCL[(i - 1)], this.targetCL[i]);
/*     */     }
/* 290 */     setPyramidLevel(maxLevel);
/*     */   }
/*     */ 
/*     */   public CLImage2d getTransformedImageCL() {
/* 294 */     if (this.residualUpdateNeeded) {
/* 295 */       doRoi();
/* 296 */       doResidual();
/*     */     }
/* 298 */     return this.transformedCL[this.pyramidLevel];
/*     */   }
/*     */   public CLImage2d getResidualImageCL() {
/* 301 */     if (this.residualUpdateNeeded) {
/* 302 */       doRoi();
/* 303 */       doResidual();
/*     */     }
/* 305 */     return this.residualCL[this.pyramidLevel];
/*     */   }
/*     */   public CLImage2d getMaskImageCL() {
/* 308 */     return this.maskCL[this.pyramidLevel];
/*     */   }
/*     */ 
/*     */   public CLImage2d[] getImagesCL() {
/* 312 */     this.imagesCL[0] = this.templateCL[this.pyramidLevel];
/* 313 */     this.imagesCL[1] = this.targetCL[this.pyramidLevel];
/* 314 */     this.imagesCL[2] = this.transformedCL[this.pyramidLevel];
/* 315 */     this.imagesCL[3] = this.residualCL[this.pyramidLevel];
/* 316 */     this.imagesCL[4] = this.maskCL[this.pyramidLevel];
/* 317 */     return this.imagesCL;
/*     */   }
/*     */ 
/*     */   protected void doHessianGradient(double[] scale) {
/* 321 */     final double constraintError = this.parameters.getConstraintError();
/* 322 */     final double stepSize = this.settings.stepSize;
/*     */ 
/* 324 */     opencv_core.cvSetZero(this.gradient);
/* 325 */     opencv_core.cvSetZero(this.hessian);
/*     */ 
/* 327 */     Parallel.loop(0, this.n, new Parallel.Looper()
/*     */     {
/*     */       public void loop(int from, int to, int looperID) {
/* 330 */         for (int i = from; i < to; i++) {
/* 331 */           GNImageAlignerCL.this.tempParameters[i].set(GNImageAlignerCL.this.parameters);
/* 332 */           GNImageAlignerCL.this.tempParameters[i].set(i, GNImageAlignerCL.this.tempParameters[i].get(i) + stepSize);
/* 333 */           constraintError[i] = (GNImageAlignerCL.this.tempParameters[i].get(i) - GNImageAlignerCL.this.parameters.get(i));
/* 334 */           GNImageAlignerCL.this.constraintGrad[i] = (GNImageAlignerCL.this.tempParameters[i].getConstraintError() - this.val$constraintError);
/*     */         }
/*     */       }
/*     */     });
/* 337 */     this.inputData.zeroThreshold = this.settings.thresholdsZero[Math.min(this.settings.thresholdsZero.length - 1, this.pyramidLevel)];
/* 338 */     this.inputData.outlierThreshold = this.settings.thresholdsOutlier[Math.min(this.settings.thresholdsOutlier.length - 1, this.pyramidLevel)];
/* 339 */     if (this.settings.thresholdsMulRMSE) {
/* 340 */       this.inputData.zeroThreshold *= this.RMSE;
/* 341 */       this.inputData.outlierThreshold *= this.RMSE;
/*     */     }
/* 343 */     this.inputData.pyramidLevel = this.pyramidLevel;
/* 344 */     this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
/* 345 */     ((ImageTransformerCL)this.transformer).transform(this.templateCL[this.pyramidLevel], this.transformedCL[this.pyramidLevel], this.residualCL[this.pyramidLevel], null, null, this.maskCL[this.pyramidLevel], this.tempParameters, null, this.inputData, this.outputData);
/*     */ 
/* 348 */     this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
/*     */ 
/* 350 */     doRegularization(this.updateScale);
/*     */ 
/* 352 */     this.outputData.readBuffer(this.context);
/* 353 */     for (int i = 0; i < this.n; i++) {
/* 354 */       this.gradient.put(i, this.gradient.get(i) - this.outputData.srcDstDot.get(i));
/* 355 */       for (int j = 0; j < this.n; j++)
/* 356 */         this.hessian.put(i, j, this.hessian.get(i, j) + this.outputData.dstDstDot.get(i * this.n + j));
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void doRoi()
/*     */   {
/* 362 */     this.transformer.transform(this.srcRoiPts, this.dstRoiPts, this.parameters, false);
/* 363 */     double[] pts = this.dstRoiPts.get();
/* 364 */     for (int i = 0; i < pts.length; i++) {
/* 365 */       pts[i] /= (1 << this.pyramidLevel);
/*     */     }
/* 367 */     this.roi.x(0).y(0).width(this.maskCL[this.pyramidLevel].width).height(this.maskCL[this.pyramidLevel].height);
/*     */ 
/* 371 */     JavaCV.boundingRect(pts, this.roi, 3, 3, 16, 1);
/*     */ 
/* 373 */     this.inputData.roiX = this.roi.x();
/* 374 */     this.inputData.roiY = this.roi.y();
/* 375 */     this.inputData.roiWidth = this.roi.width();
/* 376 */     this.inputData.roiHeight = this.roi.height();
/*     */ 
/* 380 */     GL2 gl = this.context.getGL2();
/* 381 */     gl.glBindFramebuffer(36160, this.maskfb[this.pyramidLevel]);
/*     */ 
/* 383 */     gl.glMatrixMode(5889);
/* 384 */     gl.glLoadIdentity();
/* 385 */     this.context.getGLU().gluOrtho2D(0.0F, this.maskCL[this.pyramidLevel].width, 0.0F, this.maskCL[this.pyramidLevel].height);
/*     */ 
/* 387 */     gl.glMatrixMode(5888);
/* 388 */     gl.glLoadIdentity();
/* 389 */     gl.glViewport(0, 0, this.maskCL[this.pyramidLevel].width, this.maskCL[this.pyramidLevel].height);
/*     */ 
/* 391 */     gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 392 */     gl.glClear(16384);
/* 393 */     gl.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 394 */     gl.glBegin(9);
/*     */ 
/* 396 */     gl.glVertex2d(pts[0], pts[1]);
/* 397 */     gl.glVertex2d(pts[2] + 1.0D, pts[3]);
/* 398 */     gl.glVertex2d(pts[4] + 1.0D, pts[5] + 1.0D);
/* 399 */     gl.glVertex2d(pts[6], pts[7] + 1.0D);
/* 400 */     gl.glEnd();
/*     */   }
/*     */ 
/*     */   protected void doResidual()
/*     */   {
/* 406 */     this.parameters.getConstraintError();
/*     */ 
/* 410 */     this.inputData.zeroThreshold = this.settings.thresholdsZero[Math.min(this.settings.thresholdsZero.length - 1, this.pyramidLevel)];
/* 411 */     this.inputData.outlierThreshold = this.settings.thresholdsOutlier[Math.min(this.settings.thresholdsOutlier.length - 1, this.pyramidLevel)];
/* 412 */     if (this.settings.thresholdsMulRMSE) {
/* 413 */       this.inputData.zeroThreshold *= this.RMSE;
/* 414 */       this.inputData.outlierThreshold *= this.RMSE;
/*     */     }
/* 416 */     this.inputData.pyramidLevel = this.pyramidLevel;
/* 417 */     this.context.acquireGLObject(this.maskCL[this.pyramidLevel]);
/* 418 */     ((ImageTransformerCL)this.transformer).transform(this.templateCL[this.pyramidLevel], this.targetCL[this.pyramidLevel], null, this.transformedCL[this.pyramidLevel], this.residualCL[this.pyramidLevel], this.maskCL[this.pyramidLevel], this.parametersArray, null, this.inputData, this.outputData);
/*     */ 
/* 421 */     this.context.releaseGLObject(this.maskCL[this.pyramidLevel]);
/*     */ 
/* 423 */     this.outputData.readBuffer(this.context);
/* 424 */     double dstDstDot = this.outputData.dstDstDot.get(0);
/* 425 */     int dstCount = this.outputData.dstCount;
/* 426 */     this.RMSE = (dstCount < this.n ? (0.0D / 0.0D) : Math.sqrt(dstDstDot / dstCount));
/*     */ 
/* 430 */     this.residualUpdateNeeded = false;
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.GNImageAlignerCL
 * JD-Core Version:    0.6.2
 */