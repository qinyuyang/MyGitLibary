/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ public class PointerPointer extends Pointer
/*     */ {
/*     */   private Pointer[] pointerArray;
/*     */ 
/*     */   public PointerPointer(Pointer[] array)
/*     */   {
/*  39 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(byte[][] array)
/*     */   {
/*  46 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(short[][] array)
/*     */   {
/*  53 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(int[][] array)
/*     */   {
/*  60 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(long[][] array)
/*     */   {
/*  67 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(float[][] array)
/*     */   {
/*  74 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(double[][] array)
/*     */   {
/*  81 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(char[][] array)
/*     */   {
/*  88 */     this(array.length); put(array);
/*     */   }
/*     */ 
/*     */   public PointerPointer(int size)
/*     */   {
/*     */     try
/*     */     {
/*  96 */       allocateArray(size);
/*     */     } catch (UnsatisfiedLinkError e) {
/*  98 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*     */     }
/*     */   }
/*     */ 
/* 102 */   public PointerPointer(Pointer p) { super(p); }
/*     */ 
/*     */ 
/*     */   private native void allocateArray(int paramInt);
/*     */ 
/*     */   public PointerPointer position(int position)
/*     */   {
/* 110 */     return (PointerPointer)super.position(position);
/*     */   }
/*     */ 
/*     */   public PointerPointer limit(int limit) {
/* 114 */     return (PointerPointer)super.limit(limit);
/*     */   }
/*     */ 
/*     */   public PointerPointer capacity(int capacity) {
/* 118 */     return (PointerPointer)super.capacity(capacity);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(Pointer[] array)
/*     */   {
/* 128 */     for (int i = 0; i < array.length; i++) {
/* 129 */       put(i, array[i]);
/*     */     }
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   public PointerPointer put(byte[][] array)
/*     */   {
/* 141 */     this.pointerArray = new Pointer[array.length];
/* 142 */     for (int i = 0; i < array.length; i++) {
/* 143 */       this.pointerArray[i] = new BytePointer(array[i]);
/*     */     }
/* 145 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(short[][] array)
/*     */   {
/* 155 */     this.pointerArray = new Pointer[array.length];
/* 156 */     for (int i = 0; i < array.length; i++) {
/* 157 */       this.pointerArray[i] = new ShortPointer(array[i]);
/*     */     }
/* 159 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(int[][] array)
/*     */   {
/* 169 */     this.pointerArray = new Pointer[array.length];
/* 170 */     for (int i = 0; i < array.length; i++) {
/* 171 */       this.pointerArray[i] = new IntPointer(array[i]);
/*     */     }
/* 173 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(long[][] array)
/*     */   {
/* 183 */     this.pointerArray = new Pointer[array.length];
/* 184 */     for (int i = 0; i < array.length; i++) {
/* 185 */       this.pointerArray[i] = new LongPointer(array[i]);
/*     */     }
/* 187 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(float[][] array)
/*     */   {
/* 197 */     this.pointerArray = new Pointer[array.length];
/* 198 */     for (int i = 0; i < array.length; i++) {
/* 199 */       this.pointerArray[i] = new FloatPointer(array[i]);
/*     */     }
/* 201 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(double[][] array)
/*     */   {
/* 211 */     this.pointerArray = new Pointer[array.length];
/* 212 */     for (int i = 0; i < array.length; i++) {
/* 213 */       this.pointerArray[i] = new DoublePointer(array[i]);
/*     */     }
/* 215 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public PointerPointer put(char[][] array)
/*     */   {
/* 225 */     this.pointerArray = new Pointer[array.length];
/* 226 */     for (int i = 0; i < array.length; i++) {
/* 227 */       this.pointerArray[i] = new CharPointer(array[i]);
/*     */     }
/* 229 */     return put(this.pointerArray);
/*     */   }
/*     */ 
/*     */   public Pointer get() {
/* 233 */     return get(0);
/*     */   }
/*     */   public native Pointer get(int paramInt);
/*     */ 
/* 237 */   public PointerPointer put(Pointer p) { return put(0, p); }
/*     */ 
/*     */ 
/*     */   public native PointerPointer put(int paramInt, Pointer paramPointer);
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.PointerPointer
 * JD-Core Version:    0.6.2
 */