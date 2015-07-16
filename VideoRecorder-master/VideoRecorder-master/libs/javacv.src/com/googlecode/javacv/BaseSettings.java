/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import java.beans.beancontext.BeanContextSupport;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class BaseSettings extends BeanContextSupport
/*    */   implements Comparable<BaseSettings>
/*    */ {
/*    */   public void addPropertyChangeListener(PropertyChangeListener listener)
/*    */   {
/* 34 */     this.pcSupport.addPropertyChangeListener(listener);
/* 35 */     for (Object s : toArray())
/* 36 */       if ((s instanceof BaseChildSettings))
/* 37 */         ((BaseChildSettings)s).addPropertyChangeListener(listener);
/* 38 */       else if ((s instanceof BaseSettings))
/* 39 */         ((BaseSettings)s).addPropertyChangeListener(listener);
/*    */   }
/*    */ 
/*    */   public void removePropertyChangeListener(PropertyChangeListener listener)
/*    */   {
/* 44 */     this.pcSupport.removePropertyChangeListener(listener);
/* 45 */     for (Object s : toArray())
/* 46 */       if ((s instanceof BaseChildSettings))
/* 47 */         ((BaseChildSettings)s).removePropertyChangeListener(listener);
/* 48 */       else if ((s instanceof BaseSettings))
/* 49 */         ((BaseSettings)s).addPropertyChangeListener(listener);
/*    */   }
/*    */ 
/*    */   public int compareTo(BaseSettings o)
/*    */   {
/* 55 */     return getName().compareTo(o.getName());
/*    */   }
/*    */ 
/*    */   protected String getName() {
/* 59 */     return "";
/*    */   }
/*    */ 
/*    */   public Object[] toArray() {
/* 63 */     Object[] a = super.toArray();
/* 64 */     Arrays.sort(a);
/* 65 */     return a;
/*    */   }
/*    */   public Object[] toArray(Object[] a) {
/* 68 */     a = super.toArray(a);
/* 69 */     Arrays.sort(a);
/* 70 */     return a;
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.BaseSettings
 * JD-Core Version:    0.6.2
 */