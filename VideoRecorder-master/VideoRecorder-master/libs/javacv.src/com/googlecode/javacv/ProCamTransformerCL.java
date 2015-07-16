/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.jogamp.common.os.Platform;
/*     */ import com.jogamp.opencl.CLBuffer;
/*     */ import com.jogamp.opencl.CLContext;
/*     */ import com.jogamp.opencl.CLEventList;
/*     */ import com.jogamp.opencl.CLImage2d;
/*     */ import com.jogamp.opencl.CLImageFormat;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelOrder;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelType;
/*     */ import com.jogamp.opencl.CLKernel;
/*     */ import com.jogamp.opencl.CLMemory.Mem;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.FloatBuffer;
/*     */ 
/*     */ public class ProCamTransformerCL extends ProCamTransformer
/*     */   implements ImageTransformerCL
/*     */ {
/*  67 */   private static final ThreadLocal<opencv_core.CvMat> H13x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*  68 */   private static final ThreadLocal<opencv_core.CvMat> H23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*  69 */   private static final ThreadLocal<opencv_core.CvMat> X4x4 = opencv_core.CvMat.createThreadLocal(4, 4);
/*     */   protected final JavaCVCL context;
/*     */   protected final int nullSize;
/*     */   protected final CLBuffer<FloatBuffer> H1Buffer;
/*     */   protected final CLBuffer<FloatBuffer> H2Buffer;
/*     */   protected final CLBuffer<FloatBuffer> XBuffer;
/*  74 */   protected CLImage2d[] projectorImageCL = null; protected CLImage2d[] surfaceImageCL = null;
/*     */   private CLKernel oneKernel;
/*     */   private CLKernel subKernel;
/*     */   private CLKernel dotKernel;
/*     */   private CLKernel reduceKernel;
/*     */ 
/*     */   public ProCamTransformerCL(JavaCVCL context, double[] referencePoints, CameraDevice camera, ProjectorDevice projector)
/*     */   {
/*  41 */     this(context, referencePoints, camera, projector, null);
/*     */   }
/*     */ 
/*     */   public ProCamTransformerCL(JavaCVCL context, double[] referencePoints, CameraDevice camera, ProjectorDevice projector, opencv_core.CvMat n) {
/*  45 */     super(referencePoints, camera, projector, n);
/*  46 */     int dotSize = createParameters().size();
/*  47 */     this.context = context;
/*  48 */     this.nullSize = (Platform.is32Bit() ? 4 : 8);
/*  49 */     this.H1Buffer = (this.surfaceTransformer == null ? null : context.getCLContext().createFloatBuffer(dotSize * 9, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY }));
/*     */ 
/*  51 */     this.H2Buffer = context.getCLContext().createFloatBuffer(dotSize * 9, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*  52 */     this.XBuffer = context.getCLContext().createFloatBuffer(dotSize * 16, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*  53 */     if (getClass() == ProCamTransformerCL.class) {
/*  54 */       CLKernel[] kernels = context.buildKernels("-cl-fast-relaxed-math -cl-mad-enable -cl-nv-maxrregcount=32 -DDOT_SIZE=" + dotSize, "ImageTransformer.cl:ProCamTransformer.cl", new String[] { "transformOne", "transformSub", "transformDot", "reduceOutputData" });
/*     */ 
/*  59 */       this.oneKernel = kernels[0];
/*  60 */       this.subKernel = kernels[1];
/*  61 */       this.dotKernel = kernels[2];
/*  62 */       this.reduceKernel = kernels[3];
/*     */     }
/*     */   }
/*     */ 
/*     */   public JavaCVCL getContext()
/*     */   {
/*  78 */     return this.context;
/*     */   }
/*     */ 
/*     */   public ProjectiveColorTransformerCL getSurfaceTransformerCL() {
/*  82 */     return (ProjectiveColorTransformerCL)this.surfaceTransformer;
/*     */   }
/*     */   public ProjectiveColorTransformerCL getProjectorTransformerCL() {
/*  85 */     return (ProjectiveColorTransformerCL)this.projectorTransformer;
/*     */   }
/*     */ 
/*     */   public CLImage2d getProjectorImageCL(int pyramidLevel) {
/*  89 */     return this.projectorImageCL[pyramidLevel];
/*     */   }
/*     */   public void setProjectorImageCL(CLImage2d projectorImage0, int minPyramidLevel, int maxPyramidLevel) {
/*  92 */     if ((this.projectorImageCL == null) || (this.projectorImageCL.length != maxPyramidLevel + 1)) {
/*  93 */       this.projectorImageCL = new CLImage2d[maxPyramidLevel + 1];
/*     */     }
/*  95 */     this.projectorImageCL[minPyramidLevel] = projectorImage0;
/*  96 */     for (int i = minPyramidLevel + 1; i <= maxPyramidLevel; i++) {
/*  97 */       if (this.projectorImageCL[i] == null) {
/*  98 */         int w = this.projectorImageCL[(i - 1)].width / 2;
/*  99 */         int h = this.projectorImageCL[(i - 1)].height / 2;
/* 100 */         CLImageFormat format = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
/* 101 */         this.projectorImageCL[i] = this.context.getCLContext().createImage2d(w, h, format, new CLMemory.Mem[0]);
/*     */       }
/* 103 */       this.context.pyrDown(this.projectorImageCL[(i - 1)], this.projectorImageCL[i]);
/*     */     }
/*     */   }
/*     */ 
/* 107 */   public CLImage2d getSurfaceImageCL(int pyramidLevel) { return this.surfaceImageCL[pyramidLevel]; }
/*     */ 
/*     */   public void setSurfaceImageCL(CLImage2d surfaceImage0, int pyramidLevels) {
/* 110 */     if ((this.surfaceImageCL == null) || (this.surfaceImageCL.length != pyramidLevels)) {
/* 111 */       this.surfaceImageCL = new CLImage2d[pyramidLevels];
/*     */     }
/* 113 */     this.surfaceImageCL[0] = surfaceImage0;
/* 114 */     for (int i = 1; i < pyramidLevels; i++) {
/* 115 */       if (this.surfaceImageCL[i] == null) {
/* 116 */         int w = this.surfaceImageCL[(i - 1)].width / 2;
/* 117 */         int h = this.surfaceImageCL[(i - 1)].height / 2;
/* 118 */         CLImageFormat format = new CLImageFormat(CLImageFormat.ChannelOrder.RGBA, CLImageFormat.ChannelType.FLOAT);
/* 119 */         this.surfaceImageCL[i] = this.context.getCLContext().createImage2d(w, h, format, new CLMemory.Mem[0]);
/*     */       }
/* 121 */       this.context.pyrDown(this.surfaceImageCL[(i - 1)], this.surfaceImageCL[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void prepareTransforms(CLBuffer H1Buffer, CLBuffer H2Buffer, CLBuffer XBuffer, int pyramidLevel, ImageTransformer.Parameters[] parameters)
/*     */   {
/* 127 */     FloatBuffer floatH1 = this.surfaceTransformer == null ? null : (FloatBuffer)H1Buffer.getBuffer().rewind();
/* 128 */     FloatBuffer floatH2 = (FloatBuffer)H2Buffer.getBuffer().rewind();
/* 129 */     FloatBuffer floatX = (FloatBuffer)XBuffer.getBuffer().rewind();
/* 130 */     opencv_core.CvMat H1 = (opencv_core.CvMat)H13x3.get();
/* 131 */     opencv_core.CvMat H2 = (opencv_core.CvMat)H23x3.get();
/* 132 */     opencv_core.CvMat X = (opencv_core.CvMat)X4x4.get();
/* 133 */     for (int i = 0; i < parameters.length; i++) {
/* 134 */       prepareTransforms(this.surfaceTransformer == null ? null : H1, H2, X, pyramidLevel, (ProCamTransformer.Parameters)parameters[i]);
/*     */ 
/* 136 */       for (int j = 0; j < 9; j++) {
/* 137 */         if (this.surfaceTransformer != null) {
/* 138 */           floatH1.put((float)H1.get(j));
/*     */         }
/* 140 */         floatH2.put((float)H2.get(j));
/*     */       }
/* 142 */       for (int j = 0; j < 16; j++) {
/* 143 */         floatX.put((float)X.get(j));
/*     */       }
/*     */     }
/* 146 */     if (this.surfaceTransformer != null) {
/* 147 */       floatH1.rewind();
/*     */     }
/* 149 */     floatH2.rewind();
/* 150 */     floatX.rewind();
/*     */   }
/*     */ 
/*     */   public void transform(CLImage2d srcImg, CLImage2d subImg, CLImage2d srcDotImg, CLImage2d transImg, CLImage2d dstImg, CLImage2d maskImg, ImageTransformer.Parameters[] parameters, boolean[] inverses, ImageTransformerCL.InputData inputData, ImageTransformerCL.OutputData outputData)
/*     */   {
/* 157 */     if (inverses != null) {
/* 158 */       for (int i = 0; i < inverses.length; i++) {
/* 159 */         if (inverses[i] != 0) {
/* 160 */           throw new UnsupportedOperationException("Inverse transform not supported.");
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 165 */     prepareTransforms(this.H1Buffer, this.H2Buffer, this.XBuffer, inputData.pyramidLevel, parameters);
/*     */ 
/* 167 */     int dotSize = parameters[0].size();
/* 168 */     int localSize = inputData.roiWidth > 32 ? 64 : parameters.length > 1 ? parameters.length : 32;
/* 169 */     int globalSize = JavaCVCL.alignCeil(inputData.roiWidth, localSize);
/* 170 */     int reduceSize = globalSize / localSize;
/*     */ 
/* 173 */     CLBuffer inputBuffer = inputData.getBuffer(this.context);
/* 174 */     CLBuffer outputBuffer = outputData.getBuffer(this.context, dotSize, reduceSize);
/*     */ 
/* 176 */     CLEventList list = new CLEventList(1);
/*     */ 
/* 179 */     if (this.surfaceTransformer != null) {
/* 180 */       this.context.writeBuffer(this.H1Buffer, false);
/*     */     }
/* 182 */     this.context.writeBuffer(this.H2Buffer, false);
/* 183 */     this.context.writeBuffer(this.XBuffer, false);
/* 184 */     if (inputData.autoWrite) {
/* 185 */       inputData.writeBuffer(this.context);
/*     */     }
/* 187 */     CLImage2d srcImg2 = this.projectorImageCL[inputData.pyramidLevel];
/* 188 */     CLKernel kernel = null;
/* 189 */     if (subImg == null) {
/* 190 */       assert (parameters.length == 1);
/* 191 */       kernel = this.oneKernel.putArg(srcImg2).putArg(srcImg).putArg(dstImg == null ? transImg : dstImg).putArg(maskImg).putArg(this.H2Buffer);
/* 192 */     } else if (srcDotImg == null) {
/* 193 */       assert (parameters.length == 1);
/* 194 */       kernel = this.subKernel.putArg(srcImg2).putArg(srcImg).putArg(subImg).putArg(transImg).putArg(dstImg).putArg(maskImg).putArg(this.H2Buffer);
/*     */     } else {
/* 196 */       assert (parameters.length == dotSize);
/* 197 */       kernel = this.dotKernel.putArg(srcImg2).putArg(srcImg).putArg(subImg).putArg(srcDotImg).putArg(maskImg).putArg(this.H2Buffer);
/*     */     }
/*     */ 
/* 200 */     if (this.H1Buffer != null) kernel.putArg(this.H1Buffer); else kernel.putNullArg(this.nullSize);
/* 201 */     kernel.putArg(this.XBuffer).putArg(inputBuffer).putArg(outputBuffer).rewind();
/* 202 */     this.context.executeKernel(kernel, inputData.roiX, 0L, 0L, globalSize, 1L, parameters.length, localSize, 1L, parameters.length, list);
/*     */ 
/* 205 */     if (reduceSize > 1) {
/* 206 */       this.reduceKernel.putArg(outputBuffer).rewind();
/* 207 */       this.context.executeKernel(this.reduceKernel, 0L, reduceSize, reduceSize);
/*     */     }
/* 209 */     if (outputData.autoRead)
/* 210 */       outputData.readBuffer(this.context);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProCamTransformerCL
 * JD-Core Version:    0.6.2
 */