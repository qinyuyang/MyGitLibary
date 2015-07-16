/*    */ package com.googlecode.javacpp;
/*    */ 
/*    */ import com.googlecode.javacpp.annotation.Cast;
/*    */ import com.googlecode.javacpp.annotation.Name;
/*    */ 
/*    */ @Name({"size_t"})
/*    */ public class SizeTPointer extends Pointer
/*    */ {
/*    */   public SizeTPointer(int size)
/*    */   {
/*    */     try
/*    */     {
/* 43 */       allocateArray(size);
/*    */     } catch (UnsatisfiedLinkError e) {
/* 45 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*    */     }
/*    */   }
/*    */ 
/* 49 */   public SizeTPointer(Pointer p) { super(p); }
/*    */ 
/*    */   private native void allocateArray(int paramInt);
/*    */ 
/*    */   public SizeTPointer position(int position) {
/* 54 */     return (SizeTPointer)super.position(position);
/*    */   }
/*    */ 
/*    */   public SizeTPointer limit(int limit) {
/* 58 */     return (SizeTPointer)super.limit(limit);
/*    */   }
/*    */ 
/*    */   public SizeTPointer capacity(int capacity) {
/* 62 */     return (SizeTPointer)super.capacity(capacity);
/*    */   }
/*    */ 
/*    */   public long get() {
/* 66 */     return get(0); } 
/*    */   @Cast({"size_t"})
/*    */   public native long get(int paramInt);
/*    */ 
/* 70 */   public SizeTPointer put(long s) { return put(0, s); }
/*    */ 
/*    */ 
/*    */   public native SizeTPointer put(int paramInt, long paramLong);
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.SizeTPointer
 * JD-Core Version:    0.6.2
 */