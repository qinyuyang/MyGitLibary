/*    */ package com.googlecode.javacv;
/*    */ 
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import java.beans.PropertyVetoException;
/*    */ 
/*    */ public class CameraSettings extends BaseSettings
/*    */ {
/* 38 */   boolean calibrated = false;
/* 39 */   double monitorWindowsScale = 1.0D;
/* 40 */   Class<? extends FrameGrabber> frameGrabber = null;
/*    */ 
/*    */   public CameraSettings()
/*    */   {
/* 32 */     this(false);
/*    */   }
/*    */   public CameraSettings(boolean calibrated) {
/* 35 */     this.calibrated = calibrated;
/*    */   }
/*    */ 
/*    */   public int getQuantity()
/*    */   {
/* 43 */     return size();
/*    */   }
/*    */   public void setQuantity(int quantity) throws PropertyVetoException {
/* 46 */     quantity = Math.max(1, quantity);
/* 47 */     Object[] a = toArray();
/* 48 */     int i = a.length;
/* 49 */     while (i > quantity) {
/* 50 */       remove(a[(i - 1)]);
/* 51 */       i--;
/*    */     }
/* 53 */     while (i < quantity) {
/* 54 */       CameraDevice.Settings c = (CameraDevice.Settings)(this.calibrated ? new CameraDevice.CalibratedSettings() : new CameraDevice.CalibrationSettings());
/*    */ 
/* 56 */       c.setName("Camera " + String.format("%2d", new Object[] { Integer.valueOf(i) }));
/* 57 */       c.setDeviceNumber(Integer.valueOf(i));
/* 58 */       c.setFrameGrabber(this.frameGrabber);
/* 59 */       add(c);
/* 60 */       i++;
/*    */     }
/* 62 */     this.pcSupport.firePropertyChange("quantity", a.length, quantity);
/*    */   }
/*    */ 
/*    */   public double getMonitorWindowsScale() {
/* 66 */     return this.monitorWindowsScale;
/*    */   }
/*    */   public void setMonitorWindowsScale(double monitorWindowsScale) {
/* 69 */     this.monitorWindowsScale = monitorWindowsScale;
/*    */   }
/*    */ 
/*    */   public Class<? extends FrameGrabber> getFrameGrabber() {
/* 73 */     return this.frameGrabber;
/*    */   }
/*    */   public void setFrameGrabber(Class<? extends FrameGrabber> frameGrabber) {
/* 76 */     this.pcSupport.firePropertyChange("frameGrabber", this.frameGrabber, this.frameGrabber = frameGrabber);
/*    */   }
/*    */ 
/*    */   public CameraDevice.Settings[] toArray() {
/* 80 */     return (CameraDevice.Settings[])toArray(new CameraDevice.Settings[size()]);
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.CameraSettings
 * JD-Core Version:    0.6.2
 */