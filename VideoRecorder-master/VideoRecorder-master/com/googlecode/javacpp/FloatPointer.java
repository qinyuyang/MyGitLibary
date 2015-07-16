/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ 
/*     */ public class FloatPointer extends Pointer
/*     */ {
/*     */   public FloatPointer(float[] array)
/*     */   {
/*  39 */     this(array.length);
/*  40 */     put(array);
/*     */   }
/*     */ 
/*     */   public FloatPointer(FloatBuffer buffer)
/*     */   {
/*  50 */     super(buffer);
/*  51 */     if ((buffer != null) && (buffer.hasArray())) {
/*  52 */       float[] array = buffer.array();
/*  53 */       allocateArray(array.length);
/*  54 */       put(array);
/*  55 */       position(buffer.position());
/*  56 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public FloatPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  66 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  68 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  72 */   public FloatPointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public FloatPointer position(int position) {
/*  77 */     return (FloatPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public FloatPointer limit(int limit) {
/*  81 */     return (FloatPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public FloatPointer capacity(int capacity) {
/*  85 */     return (FloatPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public float get() {
/*  89 */     return get(0);
/*     */   }
/*     */   public native float get(int paramInt);
/*     */ 
/*  93 */   public FloatPointer put(float f) { return put(0, f); }
/*     */ 
/*     */ 
/*     */   public native FloatPointer put(int paramInt, float paramFloat);
/*     */ 
/*     */   public FloatPointer get(float[] array)
/*     */   {
/* 104 */     return get(array, 0, array.length);
/*     */   }
/* 106 */   public FloatPointer put(float[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native FloatPointer get(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native FloatPointer put(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final FloatBuffer asBuffer()
/*     */   {
/* 128 */     return asByteBuffer().asFloatBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.FloatPointer
 * JD-Core Version:    0.6.2
 */