/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ 
/*     */ public class DoublePointer extends Pointer
/*     */ {
/*     */   public DoublePointer(double[] array)
/*     */   {
/*  39 */     this(array.length);
/*  40 */     put(array);
/*     */   }
/*     */ 
/*     */   public DoublePointer(DoubleBuffer buffer)
/*     */   {
/*  50 */     super(buffer);
/*  51 */     if ((buffer != null) && (buffer.hasArray())) {
/*  52 */       double[] array = buffer.array();
/*  53 */       allocateArray(array.length);
/*  54 */       put(array);
/*  55 */       position(buffer.position());
/*  56 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public DoublePointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  66 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  68 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  72 */   public DoublePointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public DoublePointer position(int position) {
/*  77 */     return (DoublePointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public DoublePointer limit(int limit) {
/*  81 */     return (DoublePointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public DoublePointer capacity(int capacity) {
/*  85 */     return (DoublePointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public double get() {
/*  89 */     return get(0);
/*     */   }
/*     */   public native double get(int paramInt);
/*     */ 
/*  93 */   public DoublePointer put(double d) { return put(0, d); }
/*     */ 
/*     */ 
/*     */   public native DoublePointer put(int paramInt, double paramDouble);
/*     */ 
/*     */   public DoublePointer get(double[] array)
/*     */   {
/* 104 */     return get(array, 0, array.length);
/*     */   }
/* 106 */   public DoublePointer put(double[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native DoublePointer get(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native DoublePointer put(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final DoubleBuffer asBuffer()
/*     */   {
/* 128 */     return asByteBuffer().asDoubleBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.DoublePointer
 * JD-Core Version:    0.6.2
 */