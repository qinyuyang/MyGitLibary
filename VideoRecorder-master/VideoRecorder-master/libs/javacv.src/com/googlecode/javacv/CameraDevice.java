/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSeq;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ public class CameraDevice extends ProjectiveDevice
/*     */ {
/*     */   private Settings settings;
/*     */ 
/*     */   public CameraDevice(String name)
/*     */   {
/*  39 */     super(name);
/*     */   }
/*     */   public CameraDevice(String name, String filename) throws ProjectiveDevice.Exception {
/*  42 */     super(name, filename);
/*  43 */     this.settings.setImageWidth(this.imageWidth);
/*  44 */     this.settings.setImageHeight(this.imageHeight);
/*     */   }
/*     */   public CameraDevice(String name, opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/*  47 */     super(name, fs);
/*  48 */     this.settings.setImageWidth(this.imageWidth);
/*  49 */     this.settings.setImageHeight(this.imageHeight);
/*     */   }
/*     */   public CameraDevice(Settings settings) throws ProjectiveDevice.Exception {
/*  52 */     super((ProjectiveDevice.Settings)settings);
/*     */   }
/*     */ 
/*     */   public ProjectiveDevice.Settings getSettings()
/*     */   {
/* 455 */     return (ProjectiveDevice.Settings)this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 458 */     setSettings((ProjectiveDevice.Settings)settings);
/*     */   }
/*     */   public void setSettings(ProjectiveDevice.Settings settings) {
/* 461 */     super.setSettings(settings);
/* 462 */     if ((settings instanceof ProjectiveDevice.CalibrationSettings))
/* 463 */       this.settings = new CalibrationSettings((ProjectiveDevice.CalibrationSettings)settings);
/* 464 */     else if ((settings instanceof ProjectiveDevice.CalibratedSettings))
/* 465 */       this.settings = new CalibratedSettings((ProjectiveDevice.CalibratedSettings)settings);
/*     */     else {
/* 467 */       this.settings = new SettingsImplementation(settings);
/*     */     }
/* 469 */     if ((this.settings.getName() == null) || (this.settings.getName().length() == 0))
/* 470 */       this.settings.setName("Camera " + String.format("%2d", new Object[] { this.settings.getDeviceNumber() }));
/*     */   }
/*     */ 
/*     */   public FrameGrabber createFrameGrabber() throws FrameGrabber.Exception
/*     */   {
/*     */     try {
/* 476 */       this.settings.getFrameGrabber().getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
/*     */       FrameGrabber f;
/*     */       FrameGrabber f;
/* 478 */       if (this.settings.getDeviceFile() != null) {
/* 479 */         f = (FrameGrabber)this.settings.getFrameGrabber().getConstructor(new Class[] { File.class }).newInstance(new Object[] { this.settings.getDeviceFile() });
/*     */       }
/*     */       else
/*     */       {
/*     */         FrameGrabber f;
/* 480 */         if ((this.settings.getDevicePath() != null) && (this.settings.getDevicePath().length() > 0)) {
/* 481 */           f = (FrameGrabber)this.settings.getFrameGrabber().getConstructor(new Class[] { String.class }).newInstance(new Object[] { this.settings.getDevicePath() });
/*     */         } else {
/* 483 */           int number = this.settings.getDeviceNumber() == null ? 0 : this.settings.getDeviceNumber().intValue();
/*     */           try {
/* 485 */             f = (FrameGrabber)this.settings.getFrameGrabber().getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(number) });
/*     */           } catch (NoSuchMethodException e) {
/* 487 */             f = (FrameGrabber)this.settings.getFrameGrabber().getConstructor(new Class[] { Integer.class }).newInstance(new Object[] { Integer.valueOf(number) });
/*     */           }
/*     */         }
/*     */       }
/* 490 */       f.setFormat(this.settings.getFormat());
/* 491 */       f.setImageWidth(this.settings.getImageWidth());
/* 492 */       f.setImageHeight(this.settings.getImageHeight());
/* 493 */       f.setFrameRate(this.settings.getFrameRate());
/* 494 */       f.setTriggerMode(this.settings.isTriggerMode());
/* 495 */       f.setBitsPerPixel(this.settings.getBitsPerPixel());
/* 496 */       f.setImageMode(this.settings.getImageMode());
/* 497 */       f.setTimeout(this.settings.getTimeout());
/* 498 */       f.setNumBuffers(this.settings.getNumBuffers());
/* 499 */       f.setGamma(this.settings.getResponseGamma());
/* 500 */       f.setDeinterlace(this.settings.isDeinterlace());
/* 501 */       return f;
/*     */     } catch (Throwable t) {
/* 503 */       if ((t instanceof InvocationTargetException)) {
/* 504 */         t = ((InvocationTargetException)t).getCause();
/*     */       }
/* 506 */       if ((t instanceof FrameGrabber.Exception)) {
/* 507 */         throw ((FrameGrabber.Exception)t);
/*     */       }
/* 509 */       throw new FrameGrabber.Exception("Failed to create " + this.settings.getFrameGrabber(), t);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static CameraDevice[] read(String filename) throws ProjectiveDevice.Exception
/*     */   {
/* 515 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 0);
/* 516 */     CameraDevice[] devices = read(fs);
/* 517 */     fs.release();
/* 518 */     return devices;
/*     */   }
/*     */   public static CameraDevice[] read(opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/* 521 */     opencv_core.CvFileNode node = opencv_core.cvGetFileNodeByName(fs, null, "Cameras");
/* 522 */     opencv_core.CvSeq seq = node.data_seq();
/* 523 */     int count = seq.total();
/*     */ 
/* 525 */     CameraDevice[] devices = new CameraDevice[count];
/* 526 */     for (int i = 0; i < count; i++) {
/* 527 */       Pointer p = opencv_core.cvGetSeqElem(seq, i);
/* 528 */       if (p != null) {
/* 529 */         String name = opencv_core.cvReadString(new opencv_core.CvFileNode(p), null);
/* 530 */         devices[i] = new CameraDevice(name, fs);
/*     */       }
/*     */     }
/* 532 */     return devices;
/*     */   }
/*     */ 
/*     */   public static class CalibratedSettings extends ProjectiveDevice.CalibratedSettings
/*     */     implements CameraDevice.Settings
/*     */   {
/* 406 */     CameraDevice.SettingsImplementation si = new CameraDevice.SettingsImplementation() {
/*     */       public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
/* 408 */         CameraDevice.CalibratedSettings.this.firePropertyChange(propertyName, oldValue, newValue);
/*     */       }
/* 406 */     };
/*     */ 
/*     */     public CalibratedSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibratedSettings(ProjectiveDevice.CalibratedSettings settings)
/*     */     {
/* 401 */       super();
/* 402 */       if ((settings instanceof CalibratedSettings))
/* 403 */         this.si = new CameraDevice.SettingsImplementation(((CalibratedSettings)settings).si);
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/* 412 */       return this.si.getName(); } 
/* 413 */     public void setName(String name) { this.si.setName(name); } 
/* 414 */     public double getResponseGamma() { return this.si.getResponseGamma(); } 
/* 415 */     public void setResponseGamma(double responseGamma) { this.si.setResponseGamma(responseGamma); }
/*     */ 
/*     */     public Integer getDeviceNumber()
/*     */     {
/* 419 */       return this.si.getDeviceNumber(); } 
/* 420 */     public void setDeviceNumber(Integer deviceNumber) throws PropertyVetoException { this.si.setDeviceNumber(deviceNumber); } 
/* 421 */     public File getDeviceFile() { return this.si.getDeviceFile(); } 
/* 422 */     public void setDeviceFile(File deviceFile) throws PropertyVetoException { this.si.setDeviceFile(deviceFile); } 
/* 423 */     public String getDeviceFilename() { return this.si.getDeviceFilename(); } 
/* 424 */     public void setDeviceFilename(String deviceFilename) throws PropertyVetoException { this.si.setDeviceFilename(deviceFilename); } 
/* 425 */     public String getDevicePath() { return this.si.getDevicePath(); } 
/* 426 */     public void setDevicePath(String devicePath) throws PropertyVetoException { this.si.setDevicePath(devicePath); } 
/* 427 */     public Class<? extends FrameGrabber> getFrameGrabber() { return this.si.getFrameGrabber(); } 
/* 428 */     public void setFrameGrabber(Class<? extends FrameGrabber> frameGrabber) { this.si.setFrameGrabber(frameGrabber); } 
/* 429 */     public String getDescription() { return this.si.getDescription(); } 
/*     */     public String getFormat() {
/* 431 */       return this.si.getFormat(); } 
/* 432 */     public void setFormat(String format) { this.si.setFormat(format); } 
/* 433 */     public int getImageWidth() { return this.si.getImageWidth(); } 
/* 434 */     public void setImageWidth(int imageWidth) { this.si.setImageWidth(imageWidth); } 
/* 435 */     public int getImageHeight() { return this.si.getImageHeight(); } 
/* 436 */     public void setImageHeight(int imageHeight) { this.si.setImageHeight(imageHeight); } 
/* 437 */     public double getFrameRate() { return this.si.getFrameRate(); } 
/* 438 */     public void setFrameRate(double frameRate) { this.si.setFrameRate(frameRate); } 
/* 439 */     public boolean isTriggerMode() { return this.si.isTriggerMode(); } 
/* 440 */     public void setTriggerMode(boolean triggerMode) { this.si.setTriggerMode(triggerMode); } 
/* 441 */     public int getBitsPerPixel() { return this.si.getBitsPerPixel(); } 
/* 442 */     public void setBitsPerPixel(int bitsPerPixel) { this.si.setBitsPerPixel(bitsPerPixel); } 
/* 443 */     public FrameGrabber.ImageMode getImageMode() { return this.si.getImageMode(); } 
/* 444 */     public void setImageMode(FrameGrabber.ImageMode imageMode) { this.si.setImageMode(imageMode); } 
/* 445 */     public int getTimeout() { return this.si.getTimeout(); } 
/* 446 */     public void setTimeout(int timeout) { this.si.setTimeout(timeout); } 
/* 447 */     public int getNumBuffers() { return this.si.getNumBuffers(); } 
/* 448 */     public void setNumBuffers(int numBuffers) { this.si.setNumBuffers(numBuffers); } 
/* 449 */     public boolean isDeinterlace() { return this.si.isDeinterlace(); } 
/* 450 */     public void setDeinterlace(boolean deinterlace) { this.si.setDeinterlace(deinterlace); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class CalibrationSettings extends ProjectiveDevice.CalibrationSettings
/*     */     implements CameraDevice.Settings
/*     */   {
/* 351 */     CameraDevice.SettingsImplementation si = new CameraDevice.SettingsImplementation() {
/*     */       public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
/* 353 */         CameraDevice.CalibrationSettings.this.firePropertyChange(propertyName, oldValue, newValue);
/*     */       }
/* 351 */     };
/*     */ 
/*     */     public CalibrationSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibrationSettings(ProjectiveDevice.CalibrationSettings settings)
/*     */     {
/* 346 */       super();
/* 347 */       if ((settings instanceof CalibrationSettings))
/* 348 */         this.si = new CameraDevice.SettingsImplementation(((CalibrationSettings)settings).si);
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/* 357 */       return this.si.getName(); } 
/* 358 */     public void setName(String name) { this.si.setName(name); } 
/* 359 */     public double getResponseGamma() { return this.si.getResponseGamma(); } 
/* 360 */     public void setResponseGamma(double responseGamma) { this.si.setResponseGamma(responseGamma); }
/*     */ 
/*     */     public Integer getDeviceNumber()
/*     */     {
/* 364 */       return this.si.getDeviceNumber(); } 
/* 365 */     public void setDeviceNumber(Integer deviceNumber) throws PropertyVetoException { this.si.setDeviceNumber(deviceNumber); } 
/* 366 */     public File getDeviceFile() { return this.si.getDeviceFile(); } 
/* 367 */     public void setDeviceFile(File deviceFile) throws PropertyVetoException { this.si.setDeviceFile(deviceFile); } 
/* 368 */     public String getDeviceFilename() { return this.si.getDeviceFilename(); } 
/* 369 */     public void setDeviceFilename(String deviceFilename) throws PropertyVetoException { this.si.setDeviceFilename(deviceFilename); } 
/* 370 */     public String getDevicePath() { return this.si.getDevicePath(); } 
/* 371 */     public void setDevicePath(String devicePath) throws PropertyVetoException { this.si.setDevicePath(devicePath); } 
/* 372 */     public Class<? extends FrameGrabber> getFrameGrabber() { return this.si.getFrameGrabber(); } 
/* 373 */     public void setFrameGrabber(Class<? extends FrameGrabber> frameGrabber) { this.si.setFrameGrabber(frameGrabber); } 
/* 374 */     public String getDescription() { return this.si.getDescription(); } 
/*     */     public String getFormat() {
/* 376 */       return this.si.getFormat(); } 
/* 377 */     public void setFormat(String format) { this.si.setFormat(format); } 
/* 378 */     public int getImageWidth() { return this.si.getImageWidth(); } 
/* 379 */     public void setImageWidth(int imageWidth) { this.si.setImageWidth(imageWidth); } 
/* 380 */     public int getImageHeight() { return this.si.getImageHeight(); } 
/* 381 */     public void setImageHeight(int imageHeight) { this.si.setImageHeight(imageHeight); } 
/* 382 */     public double getFrameRate() { return this.si.getFrameRate(); } 
/* 383 */     public void setFrameRate(double frameRate) { this.si.setFrameRate(frameRate); } 
/* 384 */     public boolean isTriggerMode() { return this.si.isTriggerMode(); } 
/* 385 */     public void setTriggerMode(boolean triggerMode) { this.si.setTriggerMode(triggerMode); } 
/* 386 */     public int getBitsPerPixel() { return this.si.getBitsPerPixel(); } 
/* 387 */     public void setBitsPerPixel(int bitsPerPixel) { this.si.setBitsPerPixel(bitsPerPixel); } 
/* 388 */     public FrameGrabber.ImageMode getImageMode() { return this.si.getImageMode(); } 
/* 389 */     public void setImageMode(FrameGrabber.ImageMode imageMode) { this.si.setImageMode(imageMode); } 
/* 390 */     public int getTimeout() { return this.si.getTimeout(); } 
/* 391 */     public void setTimeout(int timeout) { this.si.setTimeout(timeout); } 
/* 392 */     public int getNumBuffers() { return this.si.getNumBuffers(); } 
/* 393 */     public void setNumBuffers(int numBuffers) { this.si.setNumBuffers(numBuffers); } 
/* 394 */     public boolean isDeinterlace() { return this.si.isDeinterlace(); } 
/* 395 */     public void setDeinterlace(boolean deinterlace) { this.si.setDeinterlace(deinterlace); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class SettingsImplementation extends ProjectiveDevice.Settings
/*     */     implements CameraDevice.Settings
/*     */   {
/* 121 */     Integer deviceNumber = null;
/* 122 */     File deviceFile = null;
/* 123 */     String devicePath = null;
/* 124 */     Class<? extends FrameGrabber> frameGrabber = null;
/*     */ 
/* 261 */     String format = "";
/* 262 */     int imageWidth = 0; int imageHeight = 0;
/* 263 */     double frameRate = 0.0D;
/* 264 */     boolean triggerMode = false;
/* 265 */     int bpp = 0;
/* 266 */     FrameGrabber.ImageMode imageMode = FrameGrabber.ImageMode.COLOR;
/* 267 */     int timeout = 10000;
/* 268 */     int numBuffers = 4;
/* 269 */     boolean deinterlace = false;
/*     */ 
/*     */     public SettingsImplementation()
/*     */     {
/*  99 */       this.name = "Camera  0";
/*     */     }
/* 101 */     public SettingsImplementation(ProjectiveDevice.Settings settings) { super();
/* 102 */       if ((settings instanceof SettingsImplementation)) {
/* 103 */         SettingsImplementation s = (SettingsImplementation)settings;
/* 104 */         this.deviceNumber = s.deviceNumber;
/* 105 */         this.deviceFile = s.deviceFile;
/* 106 */         this.devicePath = s.devicePath;
/* 107 */         this.frameGrabber = s.frameGrabber;
/* 108 */         this.format = s.format;
/* 109 */         this.imageWidth = s.imageWidth;
/* 110 */         this.imageHeight = s.imageHeight;
/* 111 */         this.frameRate = s.frameRate;
/* 112 */         this.triggerMode = s.triggerMode;
/* 113 */         this.bpp = s.bpp;
/* 114 */         this.imageMode = s.imageMode;
/* 115 */         this.timeout = s.timeout;
/* 116 */         this.numBuffers = s.numBuffers;
/* 117 */         this.deinterlace = s.deinterlace;
/*     */       }
/*     */     }
/*     */ 
/*     */     public Integer getDeviceNumber()
/*     */     {
/* 127 */       return this.deviceNumber;
/*     */     }
/*     */     public void setDeviceNumber(Integer deviceNumber) throws PropertyVetoException {
/* 130 */       if (deviceNumber != null) {
/*     */         try {
/* 132 */           if (this.frameGrabber != null) {
/*     */             try {
/* 134 */               this.frameGrabber.getConstructor(new Class[] { Integer.TYPE });
/*     */             } catch (NoSuchMethodException e) {
/* 136 */               this.frameGrabber.getConstructor(new Class[] { Integer.class });
/*     */             }
/*     */           }
/* 139 */           setDevicePath(null);
/* 140 */           setDeviceFile(null);
/*     */         } catch (NoSuchMethodException e) {
/* 142 */           throw new BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(this.frameGrabber.getSimpleName() + " does not accept a deviceNumber.", new PropertyChangeEvent(this, "deviceNumber", this.deviceNumber, this.deviceNumber = null));
/*     */         }
/*     */       }
/*     */ 
/* 146 */       String oldDescription = getDescription();
/* 147 */       firePropertyChange("deviceNumber", this.deviceNumber, this.deviceNumber = deviceNumber);
/* 148 */       firePropertyChange("description", oldDescription, getDescription());
/*     */     }
/*     */ 
/*     */     public File getDeviceFile() {
/* 152 */       return this.deviceFile;
/*     */     }
/*     */     public void setDeviceFile(File deviceFile) throws PropertyVetoException {
/* 155 */       if (deviceFile != null) {
/*     */         try {
/* 157 */           if (this.frameGrabber != null) {
/* 158 */             this.frameGrabber.getConstructor(new Class[] { File.class });
/*     */           }
/* 160 */           setDeviceNumber(null);
/* 161 */           setDevicePath(null);
/*     */         } catch (NoSuchMethodException e) {
/* 163 */           deviceFile = null;
/* 164 */           throw new BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(this.frameGrabber.getSimpleName() + " does not accept a deviceFile.", new PropertyChangeEvent(this, "deviceFile", this.deviceFile, this.deviceFile = null));
/*     */         }
/*     */       }
/*     */ 
/* 168 */       String oldDescription = getDescription();
/* 169 */       firePropertyChange("deviceFile", this.deviceFile, this.deviceFile = deviceFile);
/* 170 */       firePropertyChange("description", oldDescription, getDescription());
/*     */     }
/*     */     public String getDeviceFilename() {
/* 173 */       return getDeviceFile() == null ? "" : getDeviceFile().getPath();
/*     */     }
/*     */     public void setDeviceFilename(String deviceFilename) throws PropertyVetoException {
/* 176 */       setDeviceFile((deviceFilename == null) || (deviceFilename.length() == 0) ? null : new File(deviceFilename));
/*     */     }
/*     */ 
/*     */     public String getDevicePath()
/*     */     {
/* 181 */       return this.devicePath;
/*     */     }
/*     */     public void setDevicePath(String devicePath) throws PropertyVetoException {
/* 184 */       if (devicePath != null) {
/*     */         try {
/* 186 */           if (this.frameGrabber != null) {
/* 187 */             this.frameGrabber.getConstructor(new Class[] { String.class });
/*     */           }
/* 189 */           setDeviceNumber(null);
/* 190 */           setDeviceFile(null);
/*     */         } catch (NoSuchMethodException e) {
/* 192 */           devicePath = "";
/* 193 */           throw new BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(this.frameGrabber.getSimpleName() + " does not accept a devicePath.", new PropertyChangeEvent(this, "devicePath", this.devicePath, this.devicePath = null));
/*     */         }
/*     */       }
/*     */ 
/* 197 */       String oldDescription = getDescription();
/* 198 */       firePropertyChange("devicePath", this.devicePath, this.devicePath = devicePath);
/* 199 */       firePropertyChange("description", oldDescription, getDescription());
/*     */     }
/*     */ 
/*     */     public Class<? extends FrameGrabber> getFrameGrabber() {
/* 203 */       return this.frameGrabber;
/*     */     }
/*     */     public void setFrameGrabber(Class<? extends FrameGrabber> frameGrabber) {
/* 206 */       String oldDescription = getDescription();
/* 207 */       firePropertyChange("frameGrabber", this.frameGrabber, this.frameGrabber = frameGrabber);
/* 208 */       firePropertyChange("description", oldDescription, getDescription());
/*     */ 
/* 210 */       if (frameGrabber == null) {
/* 211 */         firePropertyChange("deviceNumber", this.deviceNumber, this.deviceNumber = null);
/* 212 */         firePropertyChange("deviceFile", this.deviceFile, this.deviceFile = null);
/* 213 */         firePropertyChange("devicePath", this.devicePath, this.devicePath = null);
/* 214 */         return;
/*     */       }
/*     */ 
/* 217 */       boolean hasDeviceNumber = false;
/*     */       try {
/* 219 */         frameGrabber.getConstructor(new Class[] { Integer.TYPE });
/* 220 */         hasDeviceNumber = true;
/*     */       } catch (NoSuchMethodException e) {
/*     */         try {
/* 223 */           frameGrabber.getConstructor(new Class[] { Integer.class });
/* 224 */           hasDeviceNumber = true;
/*     */         } catch (NoSuchMethodException e2) {
/* 226 */           firePropertyChange("deviceNumber", this.deviceNumber, this.deviceNumber = null);
/*     */         }
/*     */       }
/*     */       try {
/* 230 */         frameGrabber.getConstructor(new Class[] { File.class });
/*     */       } catch (NoSuchMethodException e) {
/* 232 */         firePropertyChange("deviceFile", this.deviceFile, this.deviceFile = null);
/*     */       }
/*     */       try {
/* 235 */         frameGrabber.getConstructor(new Class[] { String.class });
/*     */       } catch (NoSuchMethodException e) {
/* 237 */         firePropertyChange("devicePath", this.devicePath, this.devicePath = null);
/*     */       }
/*     */ 
/* 240 */       if ((hasDeviceNumber) && (this.deviceNumber == null) && (this.deviceFile == null) && (this.devicePath == null))
/*     */         try {
/* 242 */           setDeviceNumber(Integer.valueOf(0));
/*     */         } catch (PropertyVetoException e) {
/*     */         }
/*     */     }
/*     */ 
/*     */     public String getDescription() {
/* 248 */       String[] descriptions = null;
/*     */       try {
/* 250 */         Method m = this.frameGrabber.getMethod("getDeviceDescriptions", new Class[0]);
/* 251 */         descriptions = (String[])m.invoke(null, new Object[0]);
/*     */       } catch (Exception ex) {
/*     */       }
/* 254 */       if ((descriptions != null) && (this.deviceNumber != null) && (this.deviceNumber.intValue() < descriptions.length)) {
/* 255 */         return descriptions[this.deviceNumber.intValue()];
/*     */       }
/* 257 */       return "";
/*     */     }
/*     */ 
/*     */     public String getFormat()
/*     */     {
/* 272 */       return this.format;
/*     */     }
/*     */     public void setFormat(String format) {
/* 275 */       this.format = format;
/*     */     }
/*     */ 
/*     */     public int getImageWidth() {
/* 279 */       return this.imageWidth;
/*     */     }
/*     */     public void setImageWidth(int imageWidth) {
/* 282 */       this.imageWidth = imageWidth;
/*     */     }
/*     */ 
/*     */     public int getImageHeight() {
/* 286 */       return this.imageHeight;
/*     */     }
/*     */     public void setImageHeight(int imageHeight) {
/* 289 */       this.imageHeight = imageHeight;
/*     */     }
/*     */ 
/*     */     public double getFrameRate() {
/* 293 */       return this.frameRate;
/*     */     }
/*     */     public void setFrameRate(double frameRate) {
/* 296 */       this.frameRate = frameRate;
/*     */     }
/*     */ 
/*     */     public boolean isTriggerMode() {
/* 300 */       return this.triggerMode;
/*     */     }
/*     */     public void setTriggerMode(boolean triggerMode) {
/* 303 */       this.triggerMode = triggerMode;
/*     */     }
/*     */ 
/*     */     public int getBitsPerPixel() {
/* 307 */       return this.bpp;
/*     */     }
/*     */     public void setBitsPerPixel(int bitsPerPixel) {
/* 310 */       this.bpp = bitsPerPixel;
/*     */     }
/*     */ 
/*     */     public FrameGrabber.ImageMode getImageMode() {
/* 314 */       return this.imageMode;
/*     */     }
/*     */     public void setImageMode(FrameGrabber.ImageMode imageMode) {
/* 317 */       this.imageMode = imageMode;
/*     */     }
/*     */ 
/*     */     public int getTimeout() {
/* 321 */       return this.timeout;
/*     */     }
/*     */     public void setTimeout(int timeout) {
/* 324 */       this.timeout = timeout;
/*     */     }
/*     */ 
/*     */     public int getNumBuffers() {
/* 328 */       return this.numBuffers;
/*     */     }
/*     */     public void setNumBuffers(int numBuffers) {
/* 331 */       this.numBuffers = numBuffers;
/*     */     }
/*     */ 
/*     */     public boolean isDeinterlace() {
/* 335 */       return this.deinterlace;
/*     */     }
/*     */     public void setDeinterlace(boolean deinterlace) {
/* 338 */       this.deinterlace = deinterlace;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static abstract interface Settings
/*     */   {
/*     */     public abstract String getName();
/*     */ 
/*     */     public abstract void setName(String paramString);
/*     */ 
/*     */     public abstract double getResponseGamma();
/*     */ 
/*     */     public abstract void setResponseGamma(double paramDouble);
/*     */ 
/*     */     public abstract Integer getDeviceNumber();
/*     */ 
/*     */     public abstract void setDeviceNumber(Integer paramInteger)
/*     */       throws PropertyVetoException;
/*     */ 
/*     */     public abstract File getDeviceFile();
/*     */ 
/*     */     public abstract void setDeviceFile(File paramFile)
/*     */       throws PropertyVetoException;
/*     */ 
/*     */     public abstract String getDeviceFilename();
/*     */ 
/*     */     public abstract void setDeviceFilename(String paramString)
/*     */       throws PropertyVetoException;
/*     */ 
/*     */     public abstract String getDevicePath();
/*     */ 
/*     */     public abstract void setDevicePath(String paramString)
/*     */       throws PropertyVetoException;
/*     */ 
/*     */     public abstract Class<? extends FrameGrabber> getFrameGrabber();
/*     */ 
/*     */     public abstract void setFrameGrabber(Class<? extends FrameGrabber> paramClass);
/*     */ 
/*     */     public abstract String getDescription();
/*     */ 
/*     */     public abstract String getFormat();
/*     */ 
/*     */     public abstract void setFormat(String paramString);
/*     */ 
/*     */     public abstract int getImageWidth();
/*     */ 
/*     */     public abstract void setImageWidth(int paramInt);
/*     */ 
/*     */     public abstract int getImageHeight();
/*     */ 
/*     */     public abstract void setImageHeight(int paramInt);
/*     */ 
/*     */     public abstract double getFrameRate();
/*     */ 
/*     */     public abstract void setFrameRate(double paramDouble);
/*     */ 
/*     */     public abstract boolean isTriggerMode();
/*     */ 
/*     */     public abstract void setTriggerMode(boolean paramBoolean);
/*     */ 
/*     */     public abstract int getBitsPerPixel();
/*     */ 
/*     */     public abstract void setBitsPerPixel(int paramInt);
/*     */ 
/*     */     public abstract FrameGrabber.ImageMode getImageMode();
/*     */ 
/*     */     public abstract void setImageMode(FrameGrabber.ImageMode paramImageMode);
/*     */ 
/*     */     public abstract int getTimeout();
/*     */ 
/*     */     public abstract void setTimeout(int paramInt);
/*     */ 
/*     */     public abstract int getNumBuffers();
/*     */ 
/*     */     public abstract void setNumBuffers(int paramInt);
/*     */ 
/*     */     public abstract boolean isDeinterlace();
/*     */ 
/*     */     public abstract void setDeinterlace(boolean paramBoolean);
/*     */ 
/*     */     public abstract void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
/*     */ 
/*     */     public abstract void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.CameraDevice
 * JD-Core Version:    0.6.2
 */