/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ 
/*    */ public class ProjectorSettings extends BaseSettings
/*    */ {
/* 38 */   boolean calibrated = false;
/*    */ 
/*    */   public ProjectorSettings()
/*    */   {
/* 32 */     this(false);
/*    */   }
/*    */   public ProjectorSettings(boolean calibrated) {
/* 35 */     this.calibrated = calibrated;
/*    */   }
/*    */ 
/*    */   public int getQuantity()
/*    */   {
/* 41 */     return size();
/*    */   }
/*    */   public void setQuantity(int quantity) {
/* 44 */     Object[] a = toArray();
/* 45 */     int i = a.length;
/* 46 */     while (i > quantity) {
/* 47 */       remove(a[(i - 1)]);
/* 48 */       i--;
/*    */     }
/* 50 */     while (i < quantity) {
/* 51 */       ProjectorDevice.Settings c = (ProjectorDevice.Settings)(this.calibrated ? new ProjectorDevice.CalibratedSettings() : new ProjectorDevice.CalibrationSettings());
/*    */ 
/* 53 */       c.setName("Projector " + String.format("%2d", new Object[] { Integer.valueOf(i) }));
/* 54 */       c.setScreenNumber(c.getScreenNumber() + i);
/* 55 */       add(c);
/* 56 */       for (PropertyChangeListener l : this.pcSupport.getPropertyChangeListeners()) {
/* 57 */         ((BaseChildSettings)c).addPropertyChangeListener(l);
/*    */       }
/* 59 */       i++;
/*    */     }
/* 61 */     this.pcSupport.firePropertyChange("quantity", a.length, quantity);
/*    */   }
/*    */ 
/*    */   public ProjectorDevice.Settings[] toArray() {
/* 65 */     return (ProjectorDevice.Settings[])toArray(new ProjectorDevice.Settings[size()]);
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectorSettings
 * JD-Core Version:    0.6.2
 */