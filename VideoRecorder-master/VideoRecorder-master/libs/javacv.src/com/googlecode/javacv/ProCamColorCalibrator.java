/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.awt.Color;
/*     */ 
/*     */ public class ProCamColorCalibrator
/*     */ {
/*     */   private Settings settings;
/*  93 */   private MarkerDetector markerDetector = null;
/*  94 */   private MarkedPlane boardPlane = null;
/*  95 */   private CameraDevice camera = null;
/*  96 */   private ProjectorDevice projector = null;
/*  97 */   private Color[] projectorColors = null; private Color[] cameraColors = null;
/*  98 */   private int counter = 0;
/*     */   private opencv_core.CvMat boardSrcPts;
/*     */   private opencv_core.CvMat boardDstPts;
/*     */   private opencv_core.CvMat projSrcPts;
/*     */   private opencv_core.CvMat projDstPts;
/*     */   private opencv_core.CvMat camKinv;
/*     */   private opencv_core.IplImage mask;
/*     */   private opencv_core.IplImage mask2;
/*     */   private opencv_core.IplImage undistImage;
/* 190 */   private static ThreadLocal<opencv_core.CvMat> H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 191 */   private static ThreadLocal<opencv_core.CvMat> R3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 192 */   private static ThreadLocal<opencv_core.CvMat> t3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 193 */   private static ThreadLocal<opencv_core.CvMat> n3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 194 */   private static ThreadLocal<opencv_core.CvMat> z3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*     */ 
/*     */   public ProCamColorCalibrator(Settings settings, MarkerDetector.Settings detectorSettings, MarkedPlane boardPlane, CameraDevice camera, ProjectorDevice projector)
/*     */   {
/*  36 */     this.settings = settings;
/*  37 */     this.markerDetector = new MarkerDetector(detectorSettings);
/*  38 */     this.boardPlane = boardPlane;
/*  39 */     this.camera = camera;
/*  40 */     this.projector = projector;
/*     */ 
/*  42 */     Marker[] boardMarkers = boardPlane.getMarkers();
/*  43 */     this.boardSrcPts = opencv_core.CvMat.create(4 + boardMarkers.length * 4, 1, 6, 2);
/*  44 */     this.boardDstPts = opencv_core.CvMat.create(4 + boardMarkers.length * 4, 1, 6, 2);
/*  45 */     this.boardSrcPts.put(new double[] { 0.0D, 0.0D, boardPlane.getWidth(), 0.0D, boardPlane.getWidth(), boardPlane.getHeight(), 0.0D, boardPlane.getHeight() });
/*     */ 
/*  49 */     for (int i = 0; i < boardMarkers.length; i++) {
/*  50 */       this.boardSrcPts.put(8 + i * 8, boardMarkers[i].corners);
/*     */     }
/*  52 */     this.projSrcPts = opencv_core.CvMat.create(4, 1, 6, 2);
/*  53 */     this.projDstPts = opencv_core.CvMat.create(4, 1, 6, 2);
/*  54 */     this.projSrcPts.put(new double[] { 0.0D, 0.0D, projector.imageWidth - 1, 0.0D, projector.imageWidth - 1, projector.imageHeight - 1, 0.0D, projector.imageHeight - 1 });
/*     */ 
/*  58 */     this.camKinv = opencv_core.CvMat.create(3, 3);
/*     */ 
/*  60 */     opencv_core.cvInvert(camera.cameraMatrix, this.camKinv);
/*     */   }
/*     */ 
/*     */   public int getColorCount()
/*     */   {
/* 106 */     return this.counter;
/*     */   }
/*     */ 
/*     */   public Color[] getProjectorColors() {
/* 110 */     double invgamma = 1.0D / this.projector.getSettings().getResponseGamma();
/* 111 */     int s = this.settings.samplesPerChannel;
/* 112 */     if (this.projectorColors == null) {
/* 113 */       this.projectorColors = new Color[s * s * s];
/* 114 */       this.cameraColors = new Color[s * s * s];
/* 115 */       for (int i = 0; i < this.projectorColors.length; i++) {
/* 116 */         int j = i / s;
/* 117 */         int k = j / s;
/* 118 */         double r = Math.pow(i % s / (s - 1), invgamma);
/* 119 */         double g = Math.pow(j % s / (s - 1), invgamma);
/* 120 */         double b = Math.pow(k % s / (s - 1), invgamma);
/* 121 */         this.projectorColors[i] = new Color((float)r, (float)g, (float)b);
/*     */       }
/*     */     }
/* 124 */     return this.projectorColors;
/*     */   }
/*     */   public Color getProjectorColor() {
/* 127 */     return getProjectorColors()[this.counter];
/*     */   }
/*     */ 
/*     */   public Color[] getCameraColors() {
/* 131 */     return this.cameraColors;
/*     */   }
/*     */   public Color getCameraColor() {
/* 134 */     return getCameraColors()[this.counter];
/*     */   }
/*     */ 
/*     */   public void addCameraColor() {
/* 138 */     this.counter += 1;
/*     */   }
/*     */   public void addCameraColor(Color color) {
/* 141 */     this.cameraColors[(this.counter++)] = color;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getMaskImage() {
/* 145 */     return this.mask;
/*     */   }
/*     */   public opencv_core.IplImage getUndistortedCameraImage() {
/* 148 */     return this.undistImage;
/*     */   }
/*     */ 
/*     */   public boolean processCameraImage(opencv_core.IplImage cameraImage)
/*     */   {
/* 196 */     if ((this.undistImage == null) || (this.undistImage.width() != cameraImage.width()) || (this.undistImage.height() != cameraImage.height()) || (this.undistImage.depth() != cameraImage.depth()))
/*     */     {
/* 200 */       this.undistImage = cameraImage.clone();
/*     */     }
/*     */ 
/* 203 */     if ((this.mask == null) || (this.mask2 == null) || (this.mask.width() != cameraImage.width()) || (this.mask2.width() != cameraImage.width()) || (this.mask.height() != cameraImage.height()) || (this.mask2.height() != cameraImage.width()))
/*     */     {
/* 206 */       this.mask = opencv_core.IplImage.create(cameraImage.width(), cameraImage.height(), 8, 1, cameraImage.origin());
/*     */ 
/* 208 */       this.mask2 = opencv_core.IplImage.create(cameraImage.width(), cameraImage.height(), 8, 1, cameraImage.origin());
/*     */     }
/*     */ 
/* 212 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/* 213 */     opencv_core.CvMat R = (opencv_core.CvMat)R3x3.get();
/* 214 */     opencv_core.CvMat t = (opencv_core.CvMat)t3x1.get();
/* 215 */     opencv_core.CvMat n = (opencv_core.CvMat)n3x1.get();
/* 216 */     opencv_core.CvMat z = (opencv_core.CvMat)z3x1.get();
/* 217 */     z.put(new double[] { 0.0D, 0.0D, 1.0D });
/*     */ 
/* 222 */     this.camera.undistort(cameraImage, this.undistImage);
/* 223 */     Marker[] detectedBoardMarkers = this.markerDetector.detect(this.undistImage, false);
/* 224 */     if (detectedBoardMarkers.length >= this.boardPlane.getMarkers().length * this.settings.detectedBoardMin)
/*     */     {
/* 228 */       this.boardPlane.getTotalWarp(detectedBoardMarkers, H);
/* 229 */       opencv_core.cvPerspectiveTransform(this.boardSrcPts, this.boardDstPts, H);
/* 230 */       double[] boardPts = this.boardDstPts.get();
/*     */ 
/* 234 */       opencv_core.cvMatMul(this.camKinv, H, R);
/* 235 */       double error = JavaCV.HnToRt(R, z, R, t);
/*     */ 
/* 241 */       opencv_core.cvMatMul(R, z, n);
/* 242 */       double d = opencv_core.cvDotProduct(t, z);
/*     */ 
/* 246 */       opencv_core.cvGEMM(this.projector.T, n, -1.0D / d, this.projector.R, 1.0D, H, 2);
/* 247 */       opencv_core.cvMatMul(this.projector.cameraMatrix, H, H);
/* 248 */       opencv_core.cvMatMul(H, this.camKinv, H);
/* 249 */       opencv_core.cvConvertScale(H, H, 1.0D / H.get(8), 0.0D);
/*     */ 
/* 253 */       opencv_core.cvInvert(H, H);
/* 254 */       opencv_core.cvConvertScale(H, H, 1.0D / H.get(8), 0.0D);
/*     */ 
/* 257 */       opencv_core.cvPerspectiveTransform(this.projSrcPts, this.projDstPts, H);
/* 258 */       double[] projPts = this.projDstPts.get();
/*     */ 
/* 262 */       opencv_core.cvSetZero(this.mask);
/* 263 */       double cx = 0.0D; double cy = 0.0D;
/* 264 */       for (int j = 0; j < 4; j++) {
/* 265 */         cx += boardPts[(j * 2)];
/* 266 */         cy += boardPts[(j * 2 + 1)];
/*     */       }
/* 268 */       cx /= 4.0D; cy /= 4.0D;
/* 269 */       for (int j = 0; j < 4; j++) {
/* 270 */         boardPts[(j * 2)] -= (boardPts[(j * 2)] - cx) * this.settings.trimmingFraction;
/* 271 */         boardPts[(j * 2 + 1)] -= (boardPts[(j * 2 + 1)] - cy) * this.settings.trimmingFraction;
/*     */       }
/* 273 */       opencv_core.cvFillConvexPoly(this.mask, new opencv_core.CvPoint((byte)16, boardPts, 0, 8), 4, opencv_core.CvScalar.WHITE, 8, 16);
/*     */ 
/* 276 */       for (int j = 0; j < (boardPts.length - 8) / 8; j++) {
/* 277 */         opencv_core.cvFillConvexPoly(this.mask, new opencv_core.CvPoint((byte)16, boardPts, 8 + j * 8, 8), 4, opencv_core.CvScalar.BLACK, 8, 16);
/*     */       }
/*     */ 
/* 281 */       opencv_core.cvSetZero(this.mask2);
/* 282 */       cx = 0.0D; cy = 0.0D;
/* 283 */       for (int j = 0; j < 4; j++) {
/* 284 */         cx += projPts[(j * 2)];
/* 285 */         cy += projPts[(j * 2 + 1)];
/*     */       }
/* 287 */       cx /= 4.0D; cy /= 4.0D;
/* 288 */       for (int j = 0; j < 4; j++) {
/* 289 */         projPts[(j * 2)] -= (projPts[(j * 2)] - cx) * this.settings.trimmingFraction;
/* 290 */         projPts[(j * 2 + 1)] -= (projPts[(j * 2 + 1)] - cy) * this.settings.trimmingFraction;
/*     */       }
/* 292 */       opencv_core.cvFillConvexPoly(this.mask2, new opencv_core.CvPoint((byte)16, projPts, 0, 8), 4, opencv_core.CvScalar.WHITE, 8, 16);
/*     */ 
/* 295 */       opencv_core.cvAnd(this.mask, this.mask2, this.mask, null);
/* 296 */       opencv_imgproc.cvErode(this.mask, this.mask, null, 1);
/*     */ 
/* 305 */       opencv_core.CvScalar c = opencv_core.cvAvg(this.undistImage, this.mask);
/* 306 */       int[] o = this.camera.getRGBColorOrder();
/* 307 */       double s = cameraImage.highValue();
/* 308 */       this.cameraColors[this.counter] = new Color((float)(c.val(o[0]) / s), (float)(c.val(o[1]) / s), (float)(c.val(o[2]) / s));
/*     */ 
/* 311 */       return true;
/*     */     }
/*     */ 
/* 314 */     return false;
/*     */   }
/*     */ 
/*     */   public double calibrate() {
/* 318 */     Color[] cc = getCameraColors();
/* 319 */     Color[] pc = getProjectorColors();
/* 320 */     assert (this.counter == pc.length);
/*     */ 
/* 322 */     ColorCalibrator calibrator = new ColorCalibrator(this.projector);
/* 323 */     this.projector.avgColorErr = calibrator.calibrate(cc, pc);
/* 324 */     this.camera.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
/* 325 */     this.camera.additiveLight = opencv_core.CvMat.create(3, 1);
/* 326 */     opencv_core.cvSetIdentity(this.camera.colorMixingMatrix);
/* 327 */     opencv_core.cvSetZero(this.camera.additiveLight);
/* 328 */     this.counter = 0;
/* 329 */     return this.projector.avgColorErr;
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  65 */     int samplesPerChannel = 4;
/*  66 */     double trimmingFraction = 0.01D;
/*  67 */     double detectedBoardMin = 0.5D;
/*     */ 
/*     */     public int getSamplesPerChannel() {
/*  70 */       return this.samplesPerChannel;
/*     */     }
/*     */     public void setSamplesPerChannel(int samplesPerChannel) {
/*  73 */       this.samplesPerChannel = samplesPerChannel;
/*     */     }
/*     */ 
/*     */     public double getDetectedBoardMin()
/*     */     {
/*  84 */       return this.detectedBoardMin;
/*     */     }
/*     */     public void setDetectedBoardMin(double detectedBoardMin) {
/*  87 */       this.detectedBoardMin = detectedBoardMin;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ProCamColorCalibrator
 * JD-Core Version:    0.6.2
 */