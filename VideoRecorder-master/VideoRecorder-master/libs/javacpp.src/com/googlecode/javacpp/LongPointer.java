/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ 
/*     */ public class LongPointer extends Pointer
/*     */ {
/*     */   public LongPointer(long[] array)
/*     */   {
/*  39 */     this(array.length);
/*  40 */     put(array);
/*     */   }
/*     */ 
/*     */   public LongPointer(LongBuffer buffer)
/*     */   {
/*  50 */     super(buffer);
/*  51 */     if ((buffer != null) && (buffer.hasArray())) {
/*  52 */       long[] array = buffer.array();
/*  53 */       allocateArray(array.length);
/*  54 */       put(array);
/*  55 */       position(buffer.position());
/*  56 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public LongPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  66 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  68 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  72 */   public LongPointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public LongPointer position(int position) {
/*  77 */     return (LongPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public LongPointer limit(int limit) {
/*  81 */     return (LongPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public LongPointer capacity(int capacity) {
/*  85 */     return (LongPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public long get() {
/*  89 */     return get(0);
/*     */   }
/*     */   public native long get(int paramInt);
/*     */ 
/*  93 */   public LongPointer put(long l) { return put(0, l); }
/*     */ 
/*     */ 
/*     */   public native LongPointer put(int paramInt, long paramLong);
/*     */ 
/*     */   public LongPointer get(long[] array)
/*     */   {
/* 104 */     return get(array, 0, array.length);
/*     */   }
/* 106 */   public LongPointer put(long[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native LongPointer get(long[] paramArrayOfLong, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native LongPointer put(long[] paramArrayOfLong, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final LongBuffer asBuffer()
/*     */   {
/* 128 */     return asByteBuffer().asLongBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.LongPointer
 * JD-Core Version:    0.6.2
 */