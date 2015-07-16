/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ 
/*     */ public class Parallel
/*     */ {
/*  32 */   private static final ExecutorService threadPool = Executors.newCachedThreadPool();
/*     */   public static final String NUM_THREADS = "com.googlecode.javacv.numthreads";
/*     */ 
/*     */   public static int getNumThreads()
/*     */   {
/*     */     try
/*     */     {
/*  37 */       String s = System.getProperty("com.googlecode.javacv.numthreads");
/*  38 */       if (s != null)
/*  39 */         return Integer.valueOf(s).intValue();
/*     */     }
/*     */     catch (NumberFormatException e) {
/*  42 */       throw new RuntimeException(e);
/*     */     }
/*  44 */     return getNumCores();
/*     */   }
/*     */   public static void setNumThreads(int numThreads) {
/*  47 */     System.setProperty("com.googlecode.javacv.numthreads", Integer.toString(numThreads));
/*     */   }
/*     */ 
/*     */   public static int getNumCores() {
/*  51 */     return Runtime.getRuntime().availableProcessors();
/*     */   }
/*     */ 
/*     */   public static void run(Runnable[] runnables) {
/*  55 */     if (runnables.length == 1) {
/*  56 */       runnables[0].run();
/*  57 */       return;
/*     */     }
/*     */ 
/*  60 */     Future[] futures = new Future[runnables.length];
/*  61 */     for (int i = 0; i < runnables.length; i++) {
/*  62 */       futures[i] = threadPool.submit(runnables[i]);
/*     */     }
/*     */ 
/*  65 */     Throwable error = null;
/*     */     try {
/*  67 */       for (Future f : futures)
/*  68 */         if (!f.isDone())
/*  69 */           f.get();
/*     */     }
/*     */     catch (Throwable t)
/*     */     {
/*  73 */       error = t;
/*     */     }
/*     */ 
/*  76 */     if (error != null) {
/*  77 */       for (Future f : futures) {
/*  78 */         f.cancel(true);
/*     */       }
/*  80 */       throw new RuntimeException(error);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void loop(int from, int to, Looper looper)
/*     */   {
/*  89 */     loop(from, to, getNumThreads(), looper);
/*     */   }
/*     */   public static void loop(int from, int to, int numThreads, Looper looper) {
/*  92 */     int numLoopers = Math.min(to - from, numThreads > 0 ? numThreads : getNumCores());
/*  93 */     Runnable[] runnables = new Runnable[numLoopers];
/*  94 */     for (int i = 0; i < numLoopers; i++) {
/*  95 */       final int subFrom = (to - from) * i / numLoopers + from;
/*  96 */       final int subTo = (to - from) * (i + 1) / numLoopers + from;
/*  97 */       final int looperID = i;
/*  98 */       runnables[i] = new Runnable() {
/*     */         public void run() {
/* 100 */           this.val$looper.loop(subFrom, subTo, looperID);
/*     */         }
/*     */       };
/*     */     }
/* 104 */     run(runnables);
/*     */   }
/*     */ 
/*     */   public static abstract interface Looper
/*     */   {
/*     */     public abstract void loop(int paramInt1, int paramInt2, int paramInt3);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.Parallel
 * JD-Core Version:    0.6.2
 */