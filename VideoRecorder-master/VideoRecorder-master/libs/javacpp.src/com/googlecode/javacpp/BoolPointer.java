/*    */ package com.googlecode.javacpp;
/*    */ 
/*    */ import com.googlecode.javacpp.annotation.Cast;
/*    */ import com.googlecode.javacpp.annotation.Name;
/*    */ 
/*    */ @Name({"bool"})
/*    */ public class BoolPointer extends Pointer
/*    */ {
/*    */   public BoolPointer(int size)
/*    */   {
/*    */     try
/*    */     {
/* 43 */       allocateArray(size);
/*    */     } catch (UnsatisfiedLinkError e) {
/* 45 */       throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", e);
/*    */     }
/*    */   }
/*    */ 
/* 49 */   public BoolPointer(Pointer p) { super(p); }
/*    */ 
/*    */   private native void allocateArray(int paramInt);
/*    */ 
/*    */   public BoolPointer position(int position) {
/* 54 */     return (BoolPointer)super.position(position);
/*    */   }
/*    */ 
/*    */   public BoolPointer limit(int limit) {
/* 58 */     return (BoolPointer)super.limit(limit);
/*    */   }
/*    */ 
/*    */   public BoolPointer capacity(int capacity) {
/* 62 */     return (BoolPointer)super.capacity(capacity);
/*    */   }
/*    */ 
/*    */   public boolean get() {
/* 66 */     return get(0); } 
/*    */   @Cast({"bool"})
/*    */   public native boolean get(int paramInt);
/*    */ 
/* 70 */   public BoolPointer put(boolean b) { return put(0, b); }
/*    */ 
/*    */ 
/*    */   public native BoolPointer put(int paramInt, boolean paramBoolean);
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.BoolPointer
 * JD-Core Version:    0.6.2
 */