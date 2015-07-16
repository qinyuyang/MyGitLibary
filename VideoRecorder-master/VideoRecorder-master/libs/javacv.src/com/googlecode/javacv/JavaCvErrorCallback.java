/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import com.googlecode.javacpp.Pointer;
/*    */ import com.googlecode.javacv.cpp.opencv_core;
/*    */ import com.googlecode.javacv.cpp.opencv_core.CvErrorCallback;
/*    */ import java.awt.Component;
/*    */ import java.awt.EventQueue;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class JavaCvErrorCallback extends opencv_core.CvErrorCallback
/*    */ {
/* 53 */   private long lastErrorTime = 0L;
/*    */   private Component parent;
/*    */   private boolean showDialog;
/*    */   private int rc;
/*    */ 
/*    */   public JavaCvErrorCallback()
/*    */   {
/* 39 */     this(false);
/*    */   }
/*    */   public JavaCvErrorCallback(boolean showDialog) {
/* 42 */     this(showDialog, null);
/*    */   }
/*    */   public JavaCvErrorCallback(boolean showDialog, Component parent) {
/* 45 */     this(showDialog, parent, 0);
/*    */   }
/*    */   public JavaCvErrorCallback(boolean showDialog, Component parent, int rc) {
/* 48 */     this.parent = parent;
/* 49 */     this.showDialog = showDialog;
/* 50 */     this.rc = rc;
/*    */   }
/*    */ 
/*    */   public int call(int status, String func_name, String err_msg, String file_name, int line, Pointer userdata)
/*    */   {
/* 60 */     String title = "OpenCV Error";
/* 61 */     final String message = opencv_core.cvErrorStr(status) + " (" + err_msg + ")\nin function " + func_name + ", " + file_name + "(" + line + ")";
/*    */ 
/* 64 */     Logger.getLogger(JavaCvErrorCallback.class.getName()).log(Level.SEVERE, "OpenCV Error: " + message, new Exception("Strack trace"));
/*    */ 
/* 66 */     if (this.showDialog)
/*    */     {
/* 70 */       if (System.currentTimeMillis() - this.lastErrorTime > 1000L) {
/* 71 */         EventQueue.invokeLater(new Runnable() {
/*    */           public void run() {
/* 73 */             JOptionPane.showMessageDialog(JavaCvErrorCallback.this.parent, message, "OpenCV Error", 0);
/*    */           }
/*    */         });
/*    */       }
/*    */ 
/* 78 */       this.lastErrorTime = System.currentTimeMillis();
/*    */     }
/* 80 */     return this.rc;
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.JavaCvErrorCallback
 * JD-Core Version:    0.6.2
 */