/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.jogamp.opencl.CLBuffer;
/*     */ import com.jogamp.opencl.CLContext;
/*     */ import com.jogamp.opencl.CLEventList;
/*     */ import com.jogamp.opencl.CLImage2d;
/*     */ import com.jogamp.opencl.CLKernel;
/*     */ import com.jogamp.opencl.CLMemory.Mem;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.FloatBuffer;
/*     */ 
/*     */ public class ProjectiveColorTransformerCL extends ProjectiveColorTransformer
/*     */   implements ImageTransformerCL
/*     */ {
/*     */   protected final JavaCVCL context;
/*     */   protected final CLBuffer<FloatBuffer> HBuffer;
/*     */   protected final CLBuffer<FloatBuffer> XBuffer;
/*     */   private CLKernel oneKernel;
/*     */   private CLKernel subKernel;
/*     */   private CLKernel dotKernel;
/*     */   private CLKernel reduceKernel;
/*     */ 
/*     */   public ProjectiveColorTransformerCL(JavaCVCL context, opencv_core.CvMat K1, opencv_core.CvMat K2, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2, opencv_core.CvMat X, int numGains, int numBiases)
/*     */   {
/*  39 */     super(K1, K2, R, t, n, referencePoints1, referencePoints2, X, numGains, numBiases);
/*  40 */     int dotSize = createParameters().size();
/*  41 */     this.context = context;
/*  42 */     this.HBuffer = context.getCLContext().createFloatBuffer(dotSize * 9, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*  43 */     this.XBuffer = context.getCLContext().createFloatBuffer(dotSize * 16, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*  44 */     if (getClass() == ProjectiveColorTransformerCL.class) {
/*  45 */       CLKernel[] kernels = context.buildKernels("-cl-fast-relaxed-math -cl-mad-enable -DDOT_SIZE=" + dotSize, "ImageTransformer.cl:ProjectiveColorTransformer.cl", new String[] { "transformOne", "transformSub", "transformDot", "reduceOutputData" });
/*     */ 
/*  49 */       this.oneKernel = kernels[0];
/*  50 */       this.subKernel = kernels[1];
/*  51 */       this.dotKernel = kernels[2];
/*  52 */       this.reduceKernel = kernels[3];
/*     */     }
/*     */   }
/*     */ 
/*     */   public JavaCVCL getContext()
/*     */   {
/*  61 */     return this.context;
/*     */   }
/*     */ 
/*     */   protected void prepareHomographies(CLBuffer HBuffer, int pyramidLevel, ImageTransformer.Parameters[] parameters, boolean[] inverses)
/*     */   {
/*  66 */     FloatBuffer floatH = (FloatBuffer)HBuffer.getBuffer().rewind();
/*  67 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/*  68 */     for (int i = 0; i < parameters.length; i++) {
/*  69 */       prepareHomography(H, pyramidLevel, (ProjectiveColorTransformer.Parameters)parameters[i], inverses == null ? 0 : inverses[i]);
/*     */ 
/*  71 */       for (int j = 0; j < 9; j++) {
/*  72 */         floatH.put((float)H.get(j));
/*     */       }
/*     */     }
/*  75 */     floatH.rewind();
/*     */   }
/*     */ 
/*     */   protected void prepareColorTransforms(CLBuffer XBuffer, int pyramidLevel, ImageTransformer.Parameters[] parameters, boolean[] inverses)
/*     */   {
/*  80 */     FloatBuffer floatX = (FloatBuffer)XBuffer.getBuffer().rewind();
/*  81 */     opencv_core.CvMat X2 = (opencv_core.CvMat)X24x4.get();
/*  82 */     for (int i = 0; i < parameters.length; i++) {
/*  83 */       prepareColorTransform(X2, pyramidLevel, (ProjectiveColorTransformer.Parameters)parameters[i], inverses == null ? 0 : inverses[i]);
/*     */ 
/*  85 */       for (int j = 0; j < 16; j++) {
/*  86 */         floatX.put((float)X2.get(j));
/*     */       }
/*     */     }
/*  89 */     floatX.rewind();
/*     */   }
/*     */ 
/*     */   public void transform(CLImage2d srcImg, CLImage2d subImg, CLImage2d srcDotImg, CLImage2d transImg, CLImage2d dstImg, CLImage2d maskImg, ImageTransformer.Parameters[] parameters, boolean[] inverses, ImageTransformerCL.InputData inputData, ImageTransformerCL.OutputData outputData)
/*     */   {
/*  96 */     prepareHomographies(this.HBuffer, inputData.pyramidLevel, parameters, inverses);
/*  97 */     prepareColorTransforms(this.XBuffer, inputData.pyramidLevel, parameters, inverses);
/*     */ 
/*  99 */     int dotSize = parameters[0].size();
/* 100 */     int localSize = inputData.roiWidth > 32 ? 64 : parameters.length > 1 ? parameters.length : 32;
/* 101 */     int globalSize = JavaCVCL.alignCeil(inputData.roiWidth, localSize);
/* 102 */     int reduceSize = globalSize / localSize;
/*     */ 
/* 105 */     CLBuffer inputBuffer = inputData.getBuffer(this.context);
/* 106 */     CLBuffer outputBuffer = outputData.getBuffer(this.context, dotSize, reduceSize);
/*     */ 
/* 108 */     CLEventList list = new CLEventList(1);
/*     */ 
/* 111 */     this.context.writeBuffer(this.HBuffer, false);
/* 112 */     this.context.writeBuffer(this.XBuffer, false);
/* 113 */     if (inputData.autoWrite) {
/* 114 */       inputData.writeBuffer(this.context);
/*     */     }
/* 116 */     CLKernel kernel = null;
/* 117 */     if (subImg == null) {
/* 118 */       assert (parameters.length == 1);
/* 119 */       kernel = this.oneKernel.putArg(srcImg).putArg(dstImg == null ? transImg : dstImg).putArg(maskImg).putArg(this.HBuffer).putArg(this.XBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/* 121 */     else if (srcDotImg == null) {
/* 122 */       assert (parameters.length == 1);
/* 123 */       kernel = this.subKernel.putArg(srcImg).putArg(subImg).putArg(transImg).putArg(dstImg).putArg(maskImg).putArg(this.HBuffer).putArg(this.XBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/*     */     else {
/* 126 */       assert (parameters.length == dotSize);
/* 127 */       kernel = this.dotKernel.putArg(srcImg).putArg(subImg).putArg(srcDotImg).putArg(maskImg).putArg(this.HBuffer).putArg(this.XBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/*     */ 
/* 130 */     this.context.executeKernel(kernel, inputData.roiX, 0L, 0L, globalSize, 1L, parameters.length, localSize, 1L, parameters.length, list);
/*     */ 
/* 133 */     if (reduceSize > 1) {
/* 134 */       this.reduceKernel.putArg(outputBuffer).rewind();
/* 135 */       this.context.executeKernel(this.reduceKernel, 0L, reduceSize, reduceSize);
/*     */     }
/* 137 */     if (outputData.autoRead)
/* 138 */       outputData.readBuffer(this.context);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectiveColorTransformerCL
 * JD-Core Version:    0.6.2
 */