/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import java.beans.PropertyVetoException;
/*    */ import java.beans.beancontext.BeanContextChildSupport;
/*    */ import java.util.ListResourceBundle;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.LogRecord;
/*    */ 
/*    */ public class BaseChildSettings extends BeanContextChildSupport
/*    */   implements Comparable<BaseChildSettings>
/*    */ {
/*    */   public void addPropertyChangeListener(PropertyChangeListener listener)
/*    */   {
/* 39 */     this.pcSupport.addPropertyChangeListener(listener);
/*    */   }
/*    */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 42 */     this.pcSupport.removePropertyChangeListener(listener);
/*    */   }
/*    */ 
/*    */   public int compareTo(BaseChildSettings o) {
/* 46 */     return getName().compareTo(o.getName());
/*    */   }
/*    */ 
/*    */   protected String getName() {
/* 50 */     return "";
/*    */   }
/*    */ 
/*    */   public static class PropertyVetoExceptionThatNetBeansLikes extends PropertyVetoException implements Callable {
/*    */     public PropertyVetoExceptionThatNetBeansLikes(String mess, PropertyChangeEvent evt) {
/* 55 */       super(evt);
/*    */     }
/*    */     public Object call() throws Exception {
/* 58 */       LogRecord lg = new LogRecord(Level.ALL, getMessage());
/* 59 */       lg.setResourceBundle(new ListResourceBundle() {
/*    */         protected Object[][] getContents() {
/* 61 */           return new Object[][] { { BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes.this.getMessage(), BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes.this.getMessage() } };
/*    */         }
/*    */       });
/* 64 */       return new LogRecord[] { lg };
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.BaseChildSettings
 * JD-Core Version:    0.6.2
 */