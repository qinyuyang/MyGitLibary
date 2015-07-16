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
/*     */ public class ProjectiveTransformerCL extends ProjectiveTransformer
/*     */   implements ImageTransformerCL
/*     */ {
/*     */   protected final JavaCVCL context;
/*     */   protected final CLBuffer<FloatBuffer> HBuffer;
/*     */   private CLKernel oneKernel;
/*     */   private CLKernel subKernel;
/*     */   private CLKernel dotKernel;
/*     */   private CLKernel reduceKernel;
/*     */ 
/*     */   public ProjectiveTransformerCL(JavaCVCL context)
/*     */   {
/*  37 */     this(context, null, null, null, null, null, new double[0], null);
/*     */   }
/*     */   public ProjectiveTransformerCL(JavaCVCL context, double[] referencePoints) {
/*  40 */     this(context, null, null, null, null, null, referencePoints, null);
/*     */   }
/*     */ 
/*     */   public ProjectiveTransformerCL(JavaCVCL context, ProjectiveDevice d1, ProjectiveDevice d2, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2)
/*     */   {
/*  45 */     this(context, d1.cameraMatrix, d2.cameraMatrix, d2.R, d2.T, n, referencePoints1, referencePoints2);
/*     */   }
/*     */ 
/*     */   public ProjectiveTransformerCL(JavaCVCL context, opencv_core.CvMat K1, opencv_core.CvMat K2, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n, double[] referencePoints1, double[] referencePoints2) {
/*  49 */     super(K1, K2, R, t, n, referencePoints1, referencePoints2);
/*  50 */     int dotSize = createParameters().size();
/*  51 */     this.context = context;
/*  52 */     this.HBuffer = context.getCLContext().createFloatBuffer(dotSize * 9, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*  53 */     if (getClass() == ProjectiveTransformerCL.class) {
/*  54 */       CLKernel[] kernels = context.buildKernels("-cl-fast-relaxed-math -cl-mad-enable -DDOT_SIZE=" + dotSize, "ImageTransformer.cl:ProjectiveTransformer.cl", new String[] { "transformOne", "transformSub", "transformDot", "reduceOutputData" });
/*     */ 
/*  58 */       this.oneKernel = kernels[0];
/*  59 */       this.subKernel = kernels[1];
/*  60 */       this.dotKernel = kernels[2];
/*  61 */       this.reduceKernel = kernels[3];
/*     */     }
/*     */   }
/*     */ 
/*     */   public JavaCVCL getContext()
/*     */   {
/*  70 */     return this.context;
/*     */   }
/*     */ 
/*     */   protected void prepareHomographies(CLBuffer HBuffer, int pyramidLevel, ImageTransformer.Parameters[] parameters, boolean[] inverses)
/*     */   {
/*  75 */     FloatBuffer floatH = (FloatBuffer)HBuffer.getBuffer().rewind();
/*  76 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/*  77 */     for (int i = 0; i < parameters.length; i++) {
/*  78 */       prepareHomography(H, pyramidLevel, (ProjectiveTransformer.Parameters)parameters[i], inverses == null ? 0 : inverses[i]);
/*     */ 
/*  80 */       for (int j = 0; j < 9; j++) {
/*  81 */         floatH.put((float)H.get(j));
/*     */       }
/*     */     }
/*  84 */     floatH.rewind();
/*     */   }
/*     */ 
/*     */   public void transform(CLImage2d srcImg, CLImage2d subImg, CLImage2d srcDotImg, CLImage2d transImg, CLImage2d dstImg, CLImage2d maskImg, ImageTransformer.Parameters[] parameters, boolean[] inverses, ImageTransformerCL.InputData inputData, ImageTransformerCL.OutputData outputData)
/*     */   {
/*  91 */     prepareHomographies(this.HBuffer, inputData.pyramidLevel, parameters, inverses);
/*     */ 
/*  93 */     int dotSize = parameters[0].size();
/*  94 */     int localSize = inputData.roiWidth > 32 ? 64 : parameters.length > 1 ? parameters.length : 32;
/*  95 */     int globalSize = JavaCVCL.alignCeil(inputData.roiWidth, localSize);
/*  96 */     int reduceSize = globalSize / localSize;
/*     */ 
/*  99 */     CLBuffer inputBuffer = inputData.getBuffer(this.context);
/* 100 */     CLBuffer outputBuffer = outputData.getBuffer(this.context, dotSize, reduceSize);
/*     */ 
/* 102 */     CLEventList list = new CLEventList(1);
/*     */ 
/* 105 */     this.context.writeBuffer(this.HBuffer, false);
/* 106 */     if (inputData.autoWrite) {
/* 107 */       inputData.writeBuffer(this.context);
/*     */     }
/* 109 */     CLKernel kernel = null;
/* 110 */     if (subImg == null) {
/* 111 */       assert (parameters.length == 1);
/* 112 */       kernel = this.oneKernel.putArg(srcImg).putArg(dstImg == null ? transImg : dstImg).putArg(maskImg).putArg(this.HBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/* 114 */     else if (srcDotImg == null) {
/* 115 */       assert (parameters.length == 1);
/* 116 */       kernel = this.subKernel.putArg(srcImg).putArg(subImg).putArg(transImg).putArg(dstImg).putArg(maskImg).putArg(this.HBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/*     */     else {
/* 119 */       assert (parameters.length == dotSize);
/* 120 */       kernel = this.dotKernel.putArg(srcImg).putArg(subImg).putArg(srcDotImg).putArg(maskImg).putArg(this.HBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/*     */     }
/*     */ 
/* 123 */     this.context.executeKernel(kernel, inputData.roiX, 0L, 0L, globalSize, 1L, parameters.length, localSize, 1L, parameters.length, list);
/*     */ 
/* 126 */     if (reduceSize > 1) {
/* 127 */       this.reduceKernel.putArg(outputBuffer).rewind();
/* 128 */       this.context.executeKernel(this.reduceKernel, 0L, reduceSize, reduceSize);
/*     */     }
/* 130 */     if (outputData.autoRead)
/* 131 */       outputData.readBuffer(this.context);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectiveTransformerCL
 * JD-Core Version:    0.6.2
 */