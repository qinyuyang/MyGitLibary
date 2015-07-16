/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ public class BufferRing<B extends ReleasableBuffer>
/*    */ {
/*    */   private Object[] buffers;
/*    */   private int position;
/*    */ 
/*    */   public BufferRing(BufferFactory<B> factory, int size)
/*    */   {
/* 29 */     this.buffers = new Object[size];
/* 30 */     for (int i = 0; i < size; i++) {
/* 31 */       this.buffers[i] = factory.create();
/*    */     }
/* 33 */     this.position = 0;
/*    */   }
/*    */ 
/*    */   public int capacity()
/*    */   {
/* 48 */     return this.buffers.length;
/*    */   }
/*    */ 
/*    */   public int position() {
/* 52 */     return this.position;
/*    */   }
/*    */   public BufferRing position(int position) {
/* 55 */     this.position = ((position % this.buffers.length + this.buffers.length) % this.buffers.length);
/* 56 */     return this;
/*    */   }
/*    */ 
/*    */   public B get()
/*    */   {
/* 61 */     return (ReleasableBuffer)this.buffers[this.position];
/*    */   }
/*    */ 
/*    */   public B get(int offset)
/*    */   {
/* 66 */     return (ReleasableBuffer)this.buffers[(((this.position + offset) % this.buffers.length + this.buffers.length) % this.buffers.length)];
/*    */   }
/*    */ 
/*    */   public void release()
/*    */   {
/* 71 */     for (int i = 0; i < this.buffers.length; i++) {
/* 72 */       ((ReleasableBuffer)this.buffers[i]).release();
/*    */     }
/* 74 */     this.buffers = null;
/*    */   }
/*    */ 
/*    */   public static abstract interface ReleasableBuffer
/*    */   {
/*    */     public abstract void release();
/*    */   }
/*    */ 
/*    */   public static abstract interface BufferFactory<B extends BufferRing.ReleasableBuffer>
/*    */   {
/*    */     public abstract B create();
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.BufferRing
 * JD-Core Version:    0.6.2
 */