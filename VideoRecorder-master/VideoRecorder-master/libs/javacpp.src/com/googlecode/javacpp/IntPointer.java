/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ 
/*     */ public class IntPointer extends Pointer
/*     */ {
/*     */   public IntPointer(String s)
/*     */   {
/*  39 */     this(s.length() + 1);
/*  40 */     putString(s);
/*     */   }
/*     */ 
/*     */   public IntPointer(int[] array)
/*     */   {
/*  49 */     this(array.length);
/*  50 */     put(array);
/*     */   }
/*     */ 
/*     */   public IntPointer(IntBuffer buffer)
/*     */   {
/*  60 */     super(buffer);
/*  61 */     if ((buffer != null) && (buffer.hasArray())) {
/*  62 */       int[] array = buffer.array();
/*  63 */       allocateArray(array.length);
/*  64 */       put(array);
/*  65 */       position(buffer.position());
/*  66 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public IntPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  76 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  78 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  82 */   public IntPointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public IntPointer position(int position) {
/*  87 */     return (IntPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public IntPointer limit(int limit) {
/*  91 */     return (IntPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public IntPointer capacity(int capacity) {
/*  95 */     return (IntPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public int[] getStringCodePoints()
/*     */   {
/* 101 */     int[] buffer = new int[16];
/* 102 */     int i = 0; int j = position();
/* 103 */     while ((buffer[i] = position(j).get()) != 0) {
/* 104 */       i++; j++;
/* 105 */       if (i >= buffer.length) {
/* 106 */         int[] newbuffer = new int[2 * buffer.length];
/* 107 */         System.arraycopy(buffer, 0, newbuffer, 0, buffer.length);
/* 108 */         buffer = newbuffer;
/*     */       }
/*     */     }
/* 111 */     int[] newbuffer = new int[i];
/* 112 */     System.arraycopy(buffer, 0, newbuffer, 0, i);
/* 113 */     return newbuffer;
/*     */   }
/*     */ 
/*     */   public String getString() {
/* 117 */     int[] codePoints = getStringCodePoints();
/* 118 */     return new String(codePoints, 0, codePoints.length);
/*     */   }
/*     */ 
/*     */   public IntPointer putString(String s)
/*     */   {
/* 129 */     int[] codePoints = new int[s.length()];
/* 130 */     for (int i = 0; i < codePoints.length; i++) {
/* 131 */       codePoints[i] = s.codePointAt(i);
/*     */     }
/* 133 */     return put(codePoints).put(codePoints.length, 0);
/*     */   }
/*     */ 
/*     */   public int get() {
/* 137 */     return get(0);
/*     */   }
/*     */   public native int get(int paramInt);
/*     */ 
/* 141 */   public IntPointer put(int j) { return put(0, j); }
/*     */ 
/*     */ 
/*     */   public native IntPointer put(int paramInt1, int paramInt2);
/*     */ 
/*     */   public IntPointer get(int[] array)
/*     */   {
/* 152 */     return get(array, 0, array.length);
/*     */   }
/* 154 */   public IntPointer put(int[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native IntPointer get(int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native IntPointer put(int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final IntBuffer asBuffer()
/*     */   {
/* 176 */     return asByteBuffer().asIntBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.IntPointer
 * JD-Core Version:    0.6.2
 */