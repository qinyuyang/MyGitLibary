/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class BytePointer extends Pointer
/*     */ {
/*     */   public BytePointer(String s, String charsetName)
/*     */     throws UnsupportedEncodingException
/*     */   {
/*  44 */     this(s.getBytes(charsetName).length + 1);
/*  45 */     putString(s, charsetName);
/*     */   }
/*     */ 
/*     */   public BytePointer(String s)
/*     */   {
/*  55 */     this(s.getBytes().length + 1);
/*  56 */     putString(s);
/*     */   }
/*     */ 
/*     */   public BytePointer(byte[] array)
/*     */   {
/*  65 */     this(array.length);
/*  66 */     put(array);
/*     */   }
/*     */ 
/*     */   public BytePointer(ByteBuffer buffer)
/*     */   {
/*  76 */     super(buffer);
/*  77 */     if ((buffer != null) && (buffer.hasArray())) {
/*  78 */       byte[] array = buffer.array();
/*  79 */       allocateArray(array.length);
/*  80 */       put(array);
/*  81 */       position(buffer.position());
/*  82 */       limit(buffer.limit());
/*     */     }
/*     */   }
/*     */ 
/*     */   public BytePointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  92 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  94 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/*  98 */   public BytePointer(Pointer p) { super(p); }
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public BytePointer position(int position) {
/* 103 */     return (BytePointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public BytePointer limit(int limit) {
/* 107 */     return (BytePointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public BytePointer capacity(int capacity) {
/* 111 */     return (BytePointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public byte[] getStringBytes()
/*     */   {
/* 117 */     byte[] buffer = new byte[16];
/* 118 */     int i = 0; int j = position();
/* 119 */     while ((buffer[i] = position(j).get()) != 0) {
/* 120 */       i++; j++;
/* 121 */       if (i >= buffer.length) {
/* 122 */         byte[] newbuffer = new byte[2 * buffer.length];
/* 123 */         System.arraycopy(buffer, 0, newbuffer, 0, buffer.length);
/* 124 */         buffer = newbuffer;
/*     */       }
/*     */     }
/* 127 */     byte[] newbuffer = new byte[i];
/* 128 */     System.arraycopy(buffer, 0, newbuffer, 0, i);
/* 129 */     return newbuffer;
/*     */   }
/*     */ 
/*     */   public String getString(String charsetName)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 139 */     return new String(getStringBytes(), charsetName);
/*     */   }
/*     */ 
/*     */   public String getString()
/*     */   {
/* 146 */     return new String(getStringBytes());
/*     */   }
/*     */ 
/*     */   public BytePointer putString(String s, String charsetName)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 162 */     byte[] bytes = s.getBytes(charsetName);
/*     */ 
/* 164 */     put(bytes).put(bytes.length, (byte)0);
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */   public BytePointer putString(String s)
/*     */   {
/* 177 */     byte[] bytes = s.getBytes();
/* 178 */     return put(bytes).put(bytes.length, (byte)0);
/*     */   }
/*     */ 
/*     */   public byte get() {
/* 182 */     return get(0);
/*     */   }
/*     */   public native byte get(int paramInt);
/*     */ 
/* 186 */   public BytePointer put(byte b) { return put(0, b); }
/*     */ 
/*     */ 
/*     */   public native BytePointer put(int paramInt, byte paramByte);
/*     */ 
/*     */   public BytePointer get(byte[] array)
/*     */   {
/* 197 */     return get(array, 0, array.length);
/*     */   }
/* 199 */   public BytePointer put(byte[] array) { return put(array, 0, array.length); }
/*     */ 
/*     */ 
/*     */   public native BytePointer get(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*     */ 
/*     */   public native BytePointer put(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*     */ 
/*     */   public final ByteBuffer asBuffer()
/*     */   {
/* 221 */     return asByteBuffer();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.BytePointer
 * JD-Core Version:    0.6.2
 */