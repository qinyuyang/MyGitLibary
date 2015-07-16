/*    */ package com.googlecode.javacpp;
/*    */ 
/*    */ import com.googlecode.javacpp.annotation.Cast;
/*    */ import com.googlecode.javacpp.annotation.Name;
/*    */ 
/*    */ @Name({"long"})
/*    */ public class CLongPointer extends Pointer
/*    */ {
/*    */   public CLongPointer(int size)
/*    */   {
/*    */     try
/*    */     {
/* 44 */       allocateArray(size);
/*    */     } catch (UnsatisfiedLinkError e) {
/* 46 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*    */     }
/*    */   }
/*    */ 
/* 50 */   public CLongPointer(Pointer p) { super(p); }
/*    */ 
/*    */   private native void allocateArray(int paramInt);
/*    */ 
/*    */   public CLongPointer position(int position) {
/* 55 */     return (CLongPointer)super.position(position);
/*    */   }
/*    */ 
/*    */   public CLongPointer limit(int limit) {
/* 59 */     return (CLongPointer)super.limit(limit);
/*    */   }
/*    */ 
/*    */   public CLongPointer capacity(int capacity) {
/* 63 */     return (CLongPointer)super.capacity(capacity);
/*    */   }
/*    */ 
/*    */   public long get() {
/* 67 */     return get(0); } 
/*    */   @Cast({"long"})
/*    */   public native long get(int paramInt);
/*    */ 
/* 71 */   public CLongPointer put(long l) { return put(0, l); }
/*    */ 
/*    */ 
/*    */   public native CLongPointer put(int paramInt, long paramLong);
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.CLongPointer
 * JD-Core Version:    0.6.2
 */