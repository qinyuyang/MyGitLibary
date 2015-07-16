/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ 
/*     */ public class ShortPointer extends Pointer
/*     */ {
/*     */   public ShortPointer(short[] array)
/*     */   {
/*  39 */     this(array.length);
/*  40 */     put(array);
/*     */   }
/*     */ 
/*     */   public ShortPointer(ShortBuffer buffer)
/*     */   {
/*  50 */     super(buffer);
/*  51 */     if ((buffer != null) && (buffer.hasArray())) {
/*  52 */       short[] array = buffer.array();
/*  53 */       allocateArray(array.length);
/*  54 */       put(array);
/*  55 */       position(buffer.position());
/*  56 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public ShortPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  66 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  68 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  72 */   public ShortPointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public ShortPointer position(int position) {
/*  77 */     return (ShortPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public ShortPointer limit(int limit) {
/*  81 */     return (ShortPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public ShortPointer capacity(int capacity) {
/*  85 */     return (ShortPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public short get() {
/*  89 */     return get(0);
/*     */   }
/*     */   public native short get(int paramInt);
/*     */ 
/*  93 */   public ShortPointer put(short s) { return put(0, s); }
/*     */ 
/*     */ 
/*     */   public native ShortPointer put(int paramInt, short paramShort);
/*     */ 
/*     */   public ShortPointer get(short[] array)
/*     */   {
/* 104 */     return get(array, 0, array.length);
/*     */   }
/* 106 */   public ShortPointer put(short[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native ShortPointer get(short[] paramArrayOfShort, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native ShortPointer put(short[] paramArrayOfShort, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final ShortBuffer asBuffer()
/*     */   {
/* 128 */     return asByteBuffer().asShortBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.ShortPointer
 * JD-Core Version:    0.6.2
 */