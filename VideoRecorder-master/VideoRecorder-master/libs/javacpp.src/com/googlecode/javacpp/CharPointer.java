/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ 
/*     */ public class CharPointer extends Pointer
/*     */ {
/*     */   public CharPointer(String s)
/*     */   {
/*  39 */     this(s.toCharArray().length + 1);
/*  40 */     putString(s);
/*     */   }
/*     */ 
/*     */   public CharPointer(char[] array)
/*     */   {
/*  49 */     this(array.length);
/*  50 */     put(array);
/*     */   }
/*     */ 
/*     */   public CharPointer(CharBuffer buffer)
/*     */   {
/*  60 */     super(buffer);
/*  61 */     if ((buffer != null) && (buffer.hasArray())) {
/*  62 */       char[] array = buffer.array();
/*  63 */       allocateArray(array.length);
/*  64 */       put(array);
/*  65 */       position(buffer.position());
/*  66 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public CharPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  76 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  78 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  82 */   public CharPointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public CharPointer position(int position) {
/*  87 */     return (CharPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public CharPointer limit(int limit) {
/*  91 */     return (CharPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public CharPointer capacity(int capacity) {
/*  95 */     return (CharPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public char[] getStringChars()
/*     */   {
/* 101 */     char[] buffer = new char[16];
/* 102 */     int i = 0; int j = position();
/* 103 */     while ((buffer[i] = position(j).get()) != 0) {
/* 104 */       i++; j++;
/* 105 */       if (i >= buffer.length) {
/* 106 */         char[] newbuffer = new char[2 * buffer.length];
/* 107 */         System.arraycopy(buffer, 0, newbuffer, 0, buffer.length);
/* 108 */         buffer = newbuffer;
/*     */       }
/*     */     }
/* 111 */     char[] newbuffer = new char[i];
/* 112 */     System.arraycopy(buffer, 0, newbuffer, 0, i);
/* 113 */     return newbuffer;
/*     */   }
/*     */ 
/*     */   public String getString() {
/* 117 */     return new String(getStringChars());
/*     */   }
/*     */ 
/*     */   public CharPointer putString(String s)
/*     */   {
/* 128 */     char[] chars = s.toCharArray();
/* 129 */     return put(chars).put(chars.length, '\000');
/*     */   }
/*     */ 
/*     */   public char get() {
/* 133 */     return get(0);
/*     */   }
/*     */   public native char get(int paramInt);
/*     */ 
/* 137 */   public CharPointer put(char c) { return put(0, c); }
/*     */ 
/*     */ 
/*     */   public native CharPointer put(int paramInt, char paramChar);
/*     */ 
/*     */   public CharPointer get(char[] array)
/*     */   {
/* 148 */     return get(array, 0, array.length);
/*     */   }
/* 150 */   public CharPointer put(char[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native CharPointer get(char[] paramArrayOfChar, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native CharPointer put(char[] paramArrayOfChar, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final CharBuffer asBuffer()
/*     */   {
/* 172 */     return asByteBuffer().asCharBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.CharPointer
 * JD-Core Version:    0.6.2
 */