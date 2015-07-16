/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import com.jogamp.opencl.CLBuffer;
/*    */ import com.jogamp.opencl.CLContext;
/*    */ import com.jogamp.opencl.CLImage2d;
/*    */ import com.jogamp.opencl.CLMemory.Mem;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.FloatBuffer;
/*    */ 
/*    */ public abstract interface ImageTransformerCL extends ImageTransformer
/*    */ {
/*    */   public abstract JavaCVCL getContext();
/*    */ 
/*    */   public abstract void transform(CLImage2d paramCLImage2d1, CLImage2d paramCLImage2d2, CLImage2d paramCLImage2d3, CLImage2d paramCLImage2d4, CLImage2d paramCLImage2d5, CLImage2d paramCLImage2d6, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean, InputData paramInputData, OutputData paramOutputData);
/*    */ 
/*    */   public static class OutputData
/*    */   {
/* 68 */     public int dstCount = 0; public int dstCountZero = 0; public int dstCountOutlier = 0;
/* 69 */     public FloatBuffer srcDstDot = null; public FloatBuffer dstDstDot = null;
/*    */ 
/* 71 */     CLBuffer<ByteBuffer> buffer = null;
/* 72 */     boolean autoRead = true;
/*    */ 
/*    */     public OutputData()
/*    */     {
/* 65 */       this(true); } 
/* 66 */     public OutputData(boolean autoRead) { this.autoRead = autoRead; }
/*    */ 
/*    */ 
/*    */     CLBuffer<ByteBuffer> getBuffer(JavaCVCL context, int dotSize, int reduceSize)
/*    */     {
/* 75 */       int structSize = 4 * (4 + dotSize + dotSize * dotSize);
/* 76 */       if ((this.buffer == null) || (this.buffer.getCLSize() < structSize * reduceSize)) {
/* 77 */         if (this.buffer != null) this.buffer.release();
/* 78 */         this.buffer = context.getCLContext().createByteBuffer(structSize * reduceSize, new CLMemory.Mem[0]);
/* 79 */         ByteBuffer byteBuffer = (ByteBuffer)this.buffer.getBuffer();
/* 80 */         byteBuffer.position(16); this.srcDstDot = byteBuffer.asFloatBuffer();
/* 81 */         byteBuffer.position(4 * (4 + dotSize)); this.dstDstDot = byteBuffer.asFloatBuffer();
/* 82 */         byteBuffer.rewind();
/*    */       }
/* 84 */       return this.buffer;
/*    */     }
/*    */ 
/*    */     public CLBuffer<ByteBuffer> readBuffer(JavaCVCL context)
/*    */     {
/* 89 */       context.readBuffer(this.buffer, true);
/* 90 */       ByteBuffer byteBuffer = (ByteBuffer)this.buffer.getBuffer();
/* 91 */       this.dstCount = byteBuffer.getInt(4);
/* 92 */       this.dstCountZero = byteBuffer.getInt(8);
/* 93 */       this.dstCountOutlier = byteBuffer.getInt(12);
/* 94 */       return this.buffer;
/*    */     }
/*    */   }
/*    */ 
/*    */   public static class InputData
/*    */   {
/* 38 */     public int pyramidLevel = 0;
/* 39 */     public int roiX = 0; public int roiY = 0; public int roiWidth = 0; public int roiHeight = 0;
/* 40 */     public double zeroThreshold = 0.0D; public double outlierThreshold = 0.0D;
/*    */ 
/* 42 */     CLBuffer<ByteBuffer> buffer = null;
/* 43 */     boolean autoWrite = true;
/*    */ 
/*    */     public InputData()
/*    */     {
/* 35 */       this(true); } 
/* 36 */     public InputData(boolean autoWrite) { this.autoWrite = autoWrite; }
/*    */ 
/*    */ 
/*    */     CLBuffer<ByteBuffer> getBuffer(JavaCVCL context)
/*    */     {
/* 46 */       int structSize = 16;
/* 47 */       if ((this.buffer == null) || (this.buffer.getCLSize() < structSize)) {
/* 48 */         if (this.buffer != null) this.buffer.release();
/* 49 */         this.buffer = context.getCLContext().createByteBuffer(structSize, new CLMemory.Mem[] { CLMemory.Mem.READ_ONLY });
/*    */       }
/* 51 */       return this.buffer;
/*    */     }
/*    */ 
/*    */     public CLBuffer<ByteBuffer> writeBuffer(JavaCVCL context) {
/* 55 */       getBuffer(context);
/* 56 */       ByteBuffer byteBuffer = (ByteBuffer)((ByteBuffer)this.buffer.getBuffer()).rewind();
/* 57 */       byteBuffer.putInt(this.roiY).putInt(this.roiHeight).putFloat((float)this.zeroThreshold).putFloat((float)this.outlierThreshold).rewind();
/*    */ 
/* 59 */       context.writeBuffer(this.buffer, false);
/* 60 */       return this.buffer;
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ImageTransformerCL
 * JD-Core Version:    0.6.2
 */