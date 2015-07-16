/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSeq;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.DisplayMode;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ 
/*     */ public class ProjectorDevice extends ProjectiveDevice
/*     */ {
/*     */   private Settings settings;
/* 339 */   private static ThreadLocal<opencv_core.CvMat> B4x3 = opencv_core.CvMat.createThreadLocal(4, 3);
/* 340 */   private static ThreadLocal<opencv_core.CvMat> x23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 341 */   private static ThreadLocal<opencv_core.CvMat> x34x1 = opencv_core.CvMat.createThreadLocal(4, 1);
/*     */ 
/*     */   public ProjectorDevice(String name)
/*     */   {
/*  37 */     super(name);
/*     */   }
/*     */   public ProjectorDevice(String name, String filename) throws ProjectiveDevice.Exception {
/*  40 */     super(name, filename);
/*  41 */     this.settings.setImageWidth(this.imageWidth);
/*  42 */     this.settings.setImageHeight(this.imageHeight);
/*     */   }
/*     */   public ProjectorDevice(String name, opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/*  45 */     super(name, fs);
/*  46 */     this.settings.setImageWidth(this.imageWidth);
/*  47 */     this.settings.setImageHeight(this.imageHeight);
/*     */   }
/*     */   public ProjectorDevice(Settings settings) throws ProjectiveDevice.Exception {
/*  50 */     super((ProjectiveDevice.Settings)settings);
/*     */   }
/*     */ 
/*     */   public ProjectiveDevice.Settings getSettings()
/*     */   {
/* 277 */     return (ProjectiveDevice.Settings)this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 280 */     setSettings((ProjectiveDevice.Settings)settings);
/*     */   }
/*     */   public void setSettings(ProjectiveDevice.Settings settings) {
/* 283 */     super.setSettings(settings);
/* 284 */     if ((settings instanceof ProjectiveDevice.CalibrationSettings))
/* 285 */       this.settings = new CalibrationSettings((ProjectiveDevice.CalibrationSettings)settings);
/* 286 */     else if ((settings instanceof ProjectiveDevice.CalibratedSettings))
/* 287 */       this.settings = new CalibratedSettings((ProjectiveDevice.CalibratedSettings)settings);
/*     */     else {
/* 289 */       this.settings = new SettingsImplementation(settings);
/*     */     }
/* 291 */     if ((this.settings.getName() == null) || (this.settings.getName().length() == 0))
/* 292 */       this.settings.setName("Projector " + String.format("%2d", new Object[] { Integer.valueOf(this.settings.getScreenNumber()) }));
/*     */   }
/*     */ 
/*     */   public CanvasFrame createCanvasFrame() throws CanvasFrame.Exception
/*     */   {
/* 297 */     if (this.settings.getScreenNumber() < 0) {
/* 298 */       return null;
/*     */     }
/* 300 */     DisplayMode d = new DisplayMode(this.settings.getImageWidth(), this.settings.getImageHeight(), this.settings.getBitDepth(), this.settings.getRefreshRate());
/*     */ 
/* 302 */     CanvasFrame c = null;
/* 303 */     Throwable cause = null;
/*     */     try {
/* 305 */       c = (CanvasFrame)Class.forName(CanvasFrame.class.getPackage().getName() + (this.settings.isUseOpenGL() ? ".GLCanvasFrame" : ".CanvasFrame")).asSubclass(CanvasFrame.class).getConstructor(new Class[] { String.class, Integer.TYPE, DisplayMode.class, Double.TYPE }).newInstance(new Object[] { this.settings.getName(), Integer.valueOf(this.settings.getScreenNumber()), d, Double.valueOf(this.settings.getResponseGamma()) });
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 309 */       cause = ex;
/*     */     } catch (InstantiationException ex) {
/* 311 */       cause = ex;
/*     */     } catch (IllegalAccessException ex) {
/* 313 */       cause = ex;
/*     */     } catch (IllegalArgumentException ex) {
/* 315 */       cause = ex;
/*     */     } catch (NoSuchMethodException ex) {
/* 317 */       cause = ex;
/*     */     } catch (InvocationTargetException ex) {
/* 319 */       cause = ex.getCause();
/*     */     }
/* 321 */     if (cause != null) {
/* 322 */       if ((cause instanceof CanvasFrame.Exception)) {
/* 323 */         throw ((CanvasFrame.Exception)cause);
/*     */       }
/* 325 */       throw new CanvasFrame.Exception("Failed to create CanvasFrame", cause);
/*     */     }
/*     */ 
/* 328 */     c.setLatency(this.settings.getLatency());
/*     */ 
/* 330 */     Dimension size = c.getCanvasSize();
/* 331 */     if ((size.width != this.imageWidth) || (size.height != this.imageHeight)) {
/* 332 */       rescale(size.width, size.height);
/*     */     }
/*     */ 
/* 335 */     return c;
/*     */   }
/*     */ 
/*     */   public double getAttenuation(double x, double y, opencv_core.CvMat n, double d)
/*     */   {
/* 343 */     opencv_core.CvMat B = (opencv_core.CvMat)B4x3.get();
/* 344 */     opencv_core.CvMat x2 = (opencv_core.CvMat)x23x1.get();
/* 345 */     opencv_core.CvMat x3 = (opencv_core.CvMat)x34x1.get();
/*     */ 
/* 347 */     getBackProjectionMatrix(n, d, B);
/* 348 */     x2.put(new double[] { x, y, 1.0D });
/* 349 */     opencv_core.cvMatMul(B, x2, x3);
/*     */ 
/* 356 */     opencv_core.cvGEMM(this.R, this.T, -1.0D, null, 0.0D, x2, 1);
/* 357 */     x3.rows(3);
/* 358 */     opencv_core.cvAddWeighted(x3, 1.0D / x3.get(3), x2, -1.0D, 0.0D, x2);
/* 359 */     double distance2 = opencv_core.cvDotProduct(x2, x2);
/* 360 */     double distance = Math.sqrt(distance2);
/* 361 */     double cosangle = -Math.signum(d) * opencv_core.cvDotProduct(x2, n) / (distance * Math.sqrt(opencv_core.cvDotProduct(n, n)));
/*     */ 
/* 363 */     double attenuation = cosangle / distance2;
/*     */ 
/* 365 */     x3.rows(4);
/*     */ 
/* 367 */     return attenuation;
/*     */   }
/*     */ 
/*     */   public static ProjectorDevice[] read(String filename) throws ProjectiveDevice.Exception {
/* 371 */     opencv_core.CvFileStorage fs = opencv_core.CvFileStorage.open(filename, null, 0);
/* 372 */     ProjectorDevice[] devices = read(fs);
/* 373 */     fs.release();
/* 374 */     return devices;
/*     */   }
/*     */   public static ProjectorDevice[] read(opencv_core.CvFileStorage fs) throws ProjectiveDevice.Exception {
/* 377 */     opencv_core.CvFileNode node = opencv_core.cvGetFileNodeByName(fs, null, "Projectors");
/* 378 */     opencv_core.CvSeq seq = node.data_seq();
/* 379 */     int count = seq.total();
/*     */ 
/* 381 */     ProjectorDevice[] devices = new ProjectorDevice[count];
/* 382 */     for (int i = 0; i < count; i++) {
/* 383 */       Pointer p = opencv_core.cvGetSeqElem(seq, i);
/* 384 */       if (p != null) {
/* 385 */         String name = opencv_core.cvReadString(new opencv_core.CvFileNode(p), null);
/* 386 */         devices[i] = new ProjectorDevice(name, fs);
/*     */       }
/*     */     }
/* 388 */     return devices;
/*     */   }
/*     */ 
/*     */   public static class CalibratedSettings extends ProjectiveDevice.CalibratedSettings
/*     */     implements ProjectorDevice.Settings
/*     */   {
/* 243 */     ProjectorDevice.SettingsImplementation si = new ProjectorDevice.SettingsImplementation() {
/*     */       public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
/* 245 */         ProjectorDevice.CalibratedSettings.this.firePropertyChange(propertyName, oldValue, newValue);
/*     */       }
/* 243 */     };
/*     */ 
/*     */     public CalibratedSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibratedSettings(ProjectiveDevice.CalibratedSettings settings)
/*     */     {
/* 238 */       super();
/* 239 */       if ((settings instanceof CalibratedSettings))
/* 240 */         this.si = new ProjectorDevice.SettingsImplementation(((CalibratedSettings)settings).si);
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/* 249 */       return this.si.getName(); } 
/* 250 */     public void setName(String name) { this.si.setName(name); } 
/* 251 */     public double getResponseGamma() { return this.si.getResponseGamma(); } 
/* 252 */     public void setResponseGamma(double responseGamma) { this.si.setResponseGamma(responseGamma); }
/*     */ 
/*     */     public int getScreenNumber()
/*     */     {
/* 256 */       return this.si.getScreenNumber(); } 
/* 257 */     public void setScreenNumber(int screenNumber) { this.si.setScreenNumber(screenNumber); } 
/* 258 */     public long getLatency() { return this.si.getLatency(); } 
/* 259 */     public void setLatency(long latency) { this.si.setLatency(latency); } 
/* 260 */     public String getDescription() { return this.si.getDescription(); } 
/*     */     public int getImageWidth() {
/* 262 */       return this.si.getImageWidth(); } 
/* 263 */     public void setImageWidth(int imageWidth) { this.si.setImageWidth(imageWidth); } 
/* 264 */     public int getImageHeight() { return this.si.getImageHeight(); } 
/* 265 */     public void setImageHeight(int imageHeight) { this.si.setImageHeight(imageHeight); } 
/* 266 */     public int getBitDepth() { return this.si.getBitDepth(); } 
/* 267 */     public void setBitDepth(int bitDepth) { this.si.setBitDepth(bitDepth); } 
/* 268 */     public int getRefreshRate() { return this.si.getRefreshRate(); } 
/* 269 */     public void setRefreshRate(int refreshRate) { this.si.setRefreshRate(refreshRate); } 
/*     */     public boolean isUseOpenGL() {
/* 271 */       return this.si.isUseOpenGL(); } 
/* 272 */     public void setUseOpenGL(boolean useOpenGL) { this.si.setUseOpenGL(useOpenGL); }
/*     */ 
/*     */   }
/*     */ 
/*     */   public static class CalibrationSettings extends ProjectiveDevice.CalibrationSettings
/*     */     implements ProjectorDevice.Settings
/*     */   {
/* 185 */     ProjectorDevice.SettingsImplementation si = new ProjectorDevice.SettingsImplementation() {
/*     */       public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
/* 187 */         ProjectorDevice.CalibrationSettings.this.firePropertyChange(propertyName, oldValue, newValue);
/*     */       }
/* 185 */     };
/*     */ 
/* 216 */     double brightnessBackground = 0.0D; double brightnessForeground = 1.0D;
/*     */ 
/*     */     public CalibrationSettings()
/*     */     {
/*     */     }
/*     */ 
/*     */     public CalibrationSettings(ProjectiveDevice.CalibrationSettings settings)
/*     */     {
/* 177 */       super();
/* 178 */       if ((settings instanceof CalibrationSettings)) {
/* 179 */         CalibrationSettings s = (CalibrationSettings)settings;
/* 180 */         this.si = new ProjectorDevice.SettingsImplementation(s.si);
/* 181 */         this.brightnessBackground = s.brightnessBackground;
/* 182 */         this.brightnessForeground = s.brightnessForeground;
/*     */       }
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/* 191 */       return this.si.getName(); } 
/* 192 */     public void setName(String name) { this.si.setName(name); } 
/* 193 */     public double getResponseGamma() { return this.si.getResponseGamma(); } 
/* 194 */     public void setResponseGamma(double responseGamma) { this.si.setResponseGamma(responseGamma); }
/*     */ 
/*     */     public int getScreenNumber()
/*     */     {
/* 198 */       return this.si.getScreenNumber(); } 
/* 199 */     public void setScreenNumber(int screenNumber) { this.si.setScreenNumber(screenNumber); } 
/* 200 */     public long getLatency() { return this.si.getLatency(); } 
/* 201 */     public void setLatency(long latency) { this.si.setLatency(latency); } 
/* 202 */     public String getDescription() { return this.si.getDescription(); } 
/*     */     public int getImageWidth() {
/* 204 */       return this.si.getImageWidth(); } 
/* 205 */     public void setImageWidth(int imageWidth) { this.si.setImageWidth(imageWidth); } 
/* 206 */     public int getImageHeight() { return this.si.getImageHeight(); } 
/* 207 */     public void setImageHeight(int imageHeight) { this.si.setImageHeight(imageHeight); } 
/* 208 */     public int getBitDepth() { return this.si.getBitDepth(); } 
/* 209 */     public void setBitDepth(int bitDepth) { this.si.setBitDepth(bitDepth); } 
/* 210 */     public int getRefreshRate() { return this.si.getRefreshRate(); } 
/* 211 */     public void setRefreshRate(int refreshRate) { this.si.setRefreshRate(refreshRate); } 
/*     */     public boolean isUseOpenGL() {
/* 213 */       return this.si.isUseOpenGL(); } 
/* 214 */     public void setUseOpenGL(boolean useOpenGL) { this.si.setUseOpenGL(useOpenGL); }
/*     */ 
/*     */ 
/*     */     public double getBrightnessBackground()
/*     */     {
/* 219 */       return this.brightnessBackground;
/*     */     }
/*     */     public void setBrightnessBackground(double brightnessBackground) {
/* 222 */       firePropertyChange("brightnessBackground", Double.valueOf(this.brightnessBackground), Double.valueOf(this.brightnessBackground = brightnessBackground));
/*     */     }
/*     */ 
/*     */     public double getBrightnessForeground()
/*     */     {
/* 227 */       return this.brightnessForeground;
/*     */     }
/*     */     public void setBrightnessForeground(double brightnessForeground) {
/* 230 */       firePropertyChange("brightnessForeground", Double.valueOf(this.brightnessForeground), Double.valueOf(this.brightnessForeground = brightnessForeground));
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class SettingsImplementation extends ProjectiveDevice.Settings
/*     */     implements ProjectorDevice.Settings
/*     */   {
/*  97 */     int screenNumber = CanvasFrame.getScreenDevices().length > 1 ? 1 : 0;
/*  98 */     long latency = 200L;
/*     */ 
/* 133 */     int imageWidth = 0; int imageHeight = 0; int bitDepth = 0; int refreshRate = 0;
/*     */ 
/* 163 */     private boolean useOpenGL = false;
/*     */ 
/*     */     public SettingsImplementation()
/*     */     {
/*  82 */       this.name = "Projector  0"; setScreenNumber(this.screenNumber);
/*     */     }
/*  84 */     public SettingsImplementation(ProjectiveDevice.Settings settings) { super();
/*  85 */       if ((settings instanceof SettingsImplementation)) {
/*  86 */         SettingsImplementation s = (SettingsImplementation)settings;
/*  87 */         this.screenNumber = s.screenNumber;
/*  88 */         this.latency = s.latency;
/*  89 */         this.imageWidth = s.imageWidth;
/*  90 */         this.imageHeight = s.imageHeight;
/*  91 */         this.bitDepth = s.bitDepth;
/*  92 */         this.refreshRate = s.refreshRate;
/*  93 */         this.useOpenGL = s.useOpenGL;
/*     */       }
/*     */     }
/*     */ 
/*     */     public int getScreenNumber()
/*     */     {
/* 101 */       return this.screenNumber;
/*     */     }
/*     */     public void setScreenNumber(int screenNumber) {
/* 104 */       DisplayMode d = CanvasFrame.getDisplayMode(screenNumber);
/* 105 */       String oldDescription = getDescription();
/* 106 */       firePropertyChange("screenNumber", Integer.valueOf(this.screenNumber), Integer.valueOf(this.screenNumber = screenNumber));
/* 107 */       firePropertyChange("description", oldDescription, getDescription());
/* 108 */       firePropertyChange("imageWidth", Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageWidth = d == null ? 0 : d.getWidth()));
/* 109 */       firePropertyChange("imageHeight", Integer.valueOf(this.imageHeight), Integer.valueOf(this.imageHeight = d == null ? 0 : d.getHeight()));
/* 110 */       firePropertyChange("bitDepth", Integer.valueOf(this.bitDepth), Integer.valueOf(this.bitDepth = d == null ? 0 : d.getBitDepth()));
/* 111 */       firePropertyChange("refreshRate", Integer.valueOf(this.refreshRate), Integer.valueOf(this.refreshRate = d == null ? 0 : d.getRefreshRate()));
/* 112 */       firePropertyChange("responseGamma", Double.valueOf(this.responseGamma), Double.valueOf(this.responseGamma = CanvasFrame.getGamma(screenNumber)));
/*     */     }
/*     */ 
/*     */     public long getLatency() {
/* 116 */       return this.latency;
/*     */     }
/*     */     public void setLatency(long latency) {
/* 119 */       this.latency = latency;
/*     */     }
/*     */ 
/*     */     public String getDescription() {
/* 123 */       String[] descriptions = null;
/* 124 */       descriptions = CanvasFrame.getScreenDescriptions();
/*     */ 
/* 126 */       if ((descriptions != null) && (this.screenNumber >= 0) && (this.screenNumber < descriptions.length)) {
/* 127 */         return descriptions[this.screenNumber];
/*     */       }
/* 129 */       return "";
/*     */     }
/*     */ 
/*     */     public int getImageWidth()
/*     */     {
/* 136 */       return this.imageWidth;
/*     */     }
/*     */     public void setImageWidth(int imageWidth) {
/* 139 */       firePropertyChange("imageWidth", Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageWidth = imageWidth));
/*     */     }
/*     */ 
/*     */     public int getImageHeight() {
/* 143 */       return this.imageHeight;
/*     */     }
/*     */     public void setImageHeight(int imageHeight) {
/* 146 */       firePropertyChange("imageHeight", Integer.valueOf(this.imageHeight), Integer.valueOf(this.imageHeight = imageHeight));
/*     */     }
/*     */ 
/*     */     public int getBitDepth() {
/* 150 */       return this.bitDepth;
/*     */     }
/*     */     public void setBitDepth(int bitDepth) {
/* 153 */       this.bitDepth = bitDepth;
/*     */     }
/*     */ 
/*     */     public int getRefreshRate() {
/* 157 */       return this.refreshRate;
/*     */     }
/*     */     public void setRefreshRate(int refreshRate) {
/* 160 */       this.refreshRate = refreshRate;
/*     */     }
/*     */ 
/*     */     public boolean isUseOpenGL()
/*     */     {
/* 166 */       return this.useOpenGL;
/*     */     }
/*     */     public void setUseOpenGL(boolean useOpenGL) {
/* 169 */       this.useOpenGL = useOpenGL;
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
/*     */     public abstract int getScreenNumber();
/*     */ 
/*     */     public abstract void setScreenNumber(int paramInt);
/*     */ 
/*     */     public abstract long getLatency();
/*     */ 
/*     */     public abstract void setLatency(long paramLong);
/*     */ 
/*     */     public abstract String getDescription();
/*     */ 
/*     */     public abstract int getImageWidth();
/*     */ 
/*     */     public abstract void setImageWidth(int paramInt);
/*     */ 
/*     */     public abstract int getImageHeight();
/*     */ 
/*     */     public abstract void setImageHeight(int paramInt);
/*     */ 
/*     */     public abstract int getBitDepth();
/*     */ 
/*     */     public abstract void setBitDepth(int paramInt);
/*     */ 
/*     */     public abstract int getRefreshRate();
/*     */ 
/*     */     public abstract void setRefreshRate(int paramInt);
/*     */ 
/*     */     public abstract boolean isUseOpenGL();
/*     */ 
/*     */     public abstract void setUseOpenGL(boolean paramBoolean);
/*     */ 
/*     */     public abstract void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
/*     */ 
/*     */     public abstract void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProjectorDevice
 * JD-Core Version:    0.6.2
 */