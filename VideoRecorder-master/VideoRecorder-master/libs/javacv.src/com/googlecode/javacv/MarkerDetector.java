/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacv.cpp.ARToolKitPlus.ARMarkerInfo;
/*     */ import com.googlecode.javacv.cpp.ARToolKitPlus.MultiTracker;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvBox2D;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvFont;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSize;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSize2D32f;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvTermCriteria;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class MarkerDetector
/*     */ {
/*     */   private Settings settings;
/* 107 */   private ARToolKitPlus.MultiTracker tracker = null;
/* 108 */   private int width = 0; private int height = 0; private int depth = 0; private int channels = 0;
/*     */   private opencv_core.IplImage tempImage;
/*     */   private opencv_core.IplImage tempImage2;
/*     */   private opencv_core.IplImage sumImage;
/*     */   private opencv_core.IplImage sqSumImage;
/*     */   private opencv_core.IplImage thresholdedImage;
/* 110 */   private opencv_core.CvMat points = opencv_core.CvMat.create(1, 4, 5, 2);
/* 111 */   private opencv_core.CvPoint2D32f corners = new opencv_core.CvPoint2D32f(4);
/* 112 */   private opencv_core.CvMemStorage memory = opencv_core.CvMemStorage.create();
/* 113 */   private opencv_core.CvSize subPixelSize = null; private opencv_core.CvSize subPixelZeroZone = null;
/* 114 */   private opencv_core.CvTermCriteria subPixelTermCriteria = null;
/*     */ 
/* 116 */   private opencv_core.CvPoint pts = new opencv_core.CvPoint(4); private opencv_core.CvPoint pt1 = new opencv_core.CvPoint(); private opencv_core.CvPoint pt2 = new opencv_core.CvPoint();
/* 117 */   private opencv_core.CvFont font = new opencv_core.CvFont(1, 1.0D, 1);
/* 118 */   private opencv_core.CvSize textSize = new opencv_core.CvSize();
/*     */ 
/*     */   public MarkerDetector(Settings settings)
/*     */   {
/*  35 */     setSettings(settings);
/*     */   }
/*     */   public MarkerDetector() {
/*  38 */     this(new Settings());
/*     */   }
/*     */ 
/*     */   public Settings getSettings()
/*     */   {
/*  98 */     return this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 101 */     this.settings = settings;
/* 102 */     this.subPixelSize = opencv_core.cvSize(settings.subPixelWindow / 2, settings.subPixelWindow / 2);
/* 103 */     this.subPixelZeroZone = opencv_core.cvSize(-1, -1);
/* 104 */     this.subPixelTermCriteria = opencv_core.cvTermCriteria(2, 100, 0.001D);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getThresholdedImage()
/*     */   {
/* 121 */     return this.thresholdedImage;
/*     */   }
/*     */ 
/*     */   private void init(opencv_core.IplImage image) {
/* 125 */     if ((this.tracker != null) && (image.width() == this.width) && (image.height() == this.height) && (image.depth() == this.depth) && (image.nChannels() == this.channels))
/*     */     {
/* 127 */       return;
/*     */     }
/*     */ 
/* 130 */     this.width = image.width();
/* 131 */     this.height = image.height();
/* 132 */     this.depth = image.depth();
/* 133 */     this.channels = image.nChannels();
/*     */ 
/* 135 */     if ((this.depth != 8) || (this.channels > 1)) {
/* 136 */       this.tempImage = opencv_core.IplImage.create(this.width, this.height, 8, 1);
/*     */     }
/* 138 */     if ((this.depth != 8) && (this.channels > 1)) {
/* 139 */       this.tempImage2 = opencv_core.IplImage.create(this.width, this.height, 8, 3);
/*     */     }
/* 141 */     this.sumImage = opencv_core.IplImage.create(this.width + 1, this.height + 1, 64, 1);
/* 142 */     this.sqSumImage = opencv_core.IplImage.create(this.width + 1, this.height + 1, 64, 1);
/* 143 */     this.thresholdedImage = opencv_core.IplImage.create(this.width, this.height, 8, 1);
/*     */ 
/* 145 */     this.tracker = new ARToolKitPlus.MultiTracker(this.thresholdedImage.widthStep(), this.thresholdedImage.height());
/*     */ 
/* 150 */     int pixfmt = 7;
/*     */ 
/* 158 */     this.tracker.setPixelFormat(pixfmt);
/*     */ 
/* 163 */     this.tracker.setBorderWidth(0.125F);
/*     */ 
/* 167 */     this.tracker.setUndistortionMode(0);
/*     */ 
/* 169 */     this.tracker.setMarkerMode(2);
/* 170 */     this.tracker.setImageProcessingMode(1);
/*     */   }
/*     */ 
/*     */   public Marker[] detect(opencv_core.IplImage image, boolean whiteMarkers) {
/* 174 */     init(image);
/*     */ 
/* 176 */     if ((this.depth != 8) && (this.channels > 1)) {
/* 177 */       opencv_core.cvConvertScale(image, this.tempImage2, 255.0D / image.highValue(), 0.0D);
/* 178 */       opencv_imgproc.cvCvtColor(this.tempImage2, this.tempImage, this.channels > 3 ? 11 : 6);
/* 179 */       image = this.tempImage;
/* 180 */     } else if (this.depth != 8) {
/* 181 */       opencv_core.cvConvertScale(image, this.tempImage, 255.0D / image.highValue(), 0.0D);
/* 182 */       image = this.tempImage;
/* 183 */     } else if (this.channels > 1) {
/* 184 */       opencv_imgproc.cvCvtColor(image, this.tempImage, this.channels > 3 ? 11 : 6);
/* 185 */       image = this.tempImage;
/*     */     }
/*     */ 
/* 188 */     JavaCV.adaptiveThreshold(image, this.sumImage, this.sqSumImage, this.thresholdedImage, whiteMarkers, this.settings.thresholdWindowMax, this.settings.thresholdWindowMin, this.settings.thresholdVarMultiplier, whiteMarkers ? this.settings.thresholdKWhiteMarkers : this.settings.thresholdKBlackMarkers);
/*     */ 
/* 195 */     int[] n = new int[1];
/* 196 */     ARToolKitPlus.ARMarkerInfo markers = new ARToolKitPlus.ARMarkerInfo(null);
/* 197 */     this.tracker.arDetectMarkerLite(this.thresholdedImage.getByteBuffer(), 128, markers, n);
/*     */ 
/* 199 */     Marker[] markers2 = new Marker[n[0]];
/* 200 */     int n2 = 0;
/* 201 */     for (int i = 0; (i < n[0]) && (!markers.isNull()); i++) {
/* 202 */       markers.position(i);
/* 203 */       int id = markers.id();
/* 204 */       if (id >= 0)
/*     */       {
/* 208 */         int dir = markers.dir();
/* 209 */         float confidence = markers.cf();
/* 210 */         float[] vertex = new float[8];
/* 211 */         markers.vertex().get(vertex);
/*     */ 
/* 213 */         int w = this.settings.subPixelWindow / 2 + 1;
/* 214 */         if ((vertex[0] - w >= 0.0F) && (vertex[0] + w < this.width) && (vertex[1] - w >= 0.0F) && (vertex[1] + w < this.height) && (vertex[2] - w >= 0.0F) && (vertex[2] + w < this.width) && (vertex[3] - w >= 0.0F) && (vertex[3] + w < this.height) && (vertex[4] - w >= 0.0F) && (vertex[4] + w < this.width) && (vertex[5] - w >= 0.0F) && (vertex[5] + w < this.height) && (vertex[6] - w >= 0.0F) && (vertex[6] + w < this.width) && (vertex[7] - w >= 0.0F) && (vertex[7] + w < this.height))
/*     */         {
/* 222 */           this.points.getFloatBuffer().put(vertex);
/* 223 */           opencv_core.CvBox2D box = opencv_imgproc.cvMinAreaRect2(this.points, this.memory);
/* 224 */           float bw = box.size().width();
/* 225 */           float bh = box.size().height();
/* 226 */           opencv_core.cvClearMemStorage(this.memory);
/* 227 */           if ((bw > 0.0F) && (bh > 0.0F) && (bw / bh >= 0.1D) && (bw / bh <= 10.0F))
/*     */           {
/* 232 */             for (int j = 0; j < 4; j++) {
/* 233 */               this.corners.position(j).put(vertex[(2 * j)], vertex[(2 * j + 1)]);
/*     */             }
/*     */ 
/* 257 */             opencv_imgproc.cvFindCornerSubPix(image, this.corners.position(0), 4, this.subPixelSize, this.subPixelZeroZone, this.subPixelTermCriteria);
/* 258 */             double[] d = { this.corners.position((4 - dir) % 4).x(), this.corners.position((4 - dir) % 4).y(), this.corners.position((5 - dir) % 4).x(), this.corners.position((5 - dir) % 4).y(), this.corners.position((6 - dir) % 4).x(), this.corners.position((6 - dir) % 4).y(), this.corners.position((7 - dir) % 4).x(), this.corners.position((7 - dir) % 4).y() };
/*     */ 
/* 263 */             markers2[(n2++)] = new Marker(id, d, confidence);
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 271 */     return (Marker[])Arrays.copyOf(markers2, n2);
/*     */   }
/*     */ 
/*     */   public void draw(opencv_core.IplImage image, Marker[] markers) {
/* 275 */     for (Marker m : markers) {
/* 276 */       int cx = 0; int cy = 0;
/* 277 */       for (int i = 0; i < 4; i++) {
/* 278 */         int x = (int)Math.round(m.corners[(i * 2)] * 65536.0D);
/* 279 */         int y = (int)Math.round(m.corners[(i * 2 + 1)] * 65536.0D);
/* 280 */         this.pts.position(i).x(x);
/* 281 */         this.pts.position(i).y(y);
/* 282 */         cx += x;
/* 283 */         cy += y;
/*     */       }
/*     */ 
/* 295 */       cx /= 4;
/* 296 */       cy /= 4;
/*     */ 
/* 298 */       opencv_core.cvPolyLine(image, this.pts.position(0), new int[] { 4 }, 1, 1, opencv_core.CV_RGB(0.0D, 0.0D, image.highValue()), 1, 16, 16);
/*     */ 
/* 300 */       String text = Integer.toString(m.id);
/* 301 */       int[] baseline = new int[1];
/* 302 */       opencv_core.cvGetTextSize(text, this.font, this.textSize, baseline);
/*     */ 
/* 304 */       this.pt1.x(cx - (this.textSize.width() * 3 / 2 << 16) / 2);
/* 305 */       this.pt1.y(cy + (this.textSize.height() * 3 / 2 << 16) / 2);
/* 306 */       this.pt2.x(cx + (this.textSize.width() * 3 / 2 << 16) / 2);
/* 307 */       this.pt2.y(cy - (this.textSize.height() * 3 / 2 << 16) / 2);
/* 308 */       opencv_core.cvRectangle(image, this.pt1, this.pt2, opencv_core.CV_RGB(0.0D, image.highValue(), 0.0D), -1, 16, 16);
/*     */ 
/* 310 */       this.pt1.x((int)Math.round(cx / 65536.0D - this.textSize.width() / 2));
/* 311 */       this.pt1.y((int)Math.round(cy / 65536.0D + this.textSize.height() / 2 + 1.0D));
/* 312 */       opencv_core.cvPutText(image, text, this.pt1, this.font, opencv_core.CvScalar.BLACK);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  46 */     int thresholdWindowMin = 5;
/*  47 */     int thresholdWindowMax = 63;
/*  48 */     double thresholdVarMultiplier = 1.0D;
/*  49 */     double thresholdKBlackMarkers = 0.6D;
/*  50 */     double thresholdKWhiteMarkers = 1.0D;
/*  51 */     int subPixelWindow = 11;
/*     */ 
/*     */     public int getThresholdWindowMin() {
/*  54 */       return this.thresholdWindowMin;
/*     */     }
/*     */     public void setThresholdWindowMin(int thresholdWindowMin) {
/*  57 */       this.thresholdWindowMin = thresholdWindowMin;
/*     */     }
/*     */ 
/*     */     public int getThresholdWindowMax() {
/*  61 */       return this.thresholdWindowMax;
/*     */     }
/*     */     public void setThresholdWindowMax(int thresholdWindowMax) {
/*  64 */       this.thresholdWindowMax = thresholdWindowMax;
/*     */     }
/*     */ 
/*     */     public double getThresholdVarMultiplier() {
/*  68 */       return this.thresholdVarMultiplier;
/*     */     }
/*     */     public void setThresholdVarMultiplier(double thresholdVarMultiplier) {
/*  71 */       this.thresholdVarMultiplier = thresholdVarMultiplier;
/*     */     }
/*     */ 
/*     */     public double getThresholdKBlackMarkers() {
/*  75 */       return this.thresholdKBlackMarkers;
/*     */     }
/*     */     public void setThresholdKBlackMarkers(double thresholdKBlackMarkers) {
/*  78 */       this.thresholdKBlackMarkers = thresholdKBlackMarkers;
/*     */     }
/*     */ 
/*     */     public double getThresholdKWhiteMarkers() {
/*  82 */       return this.thresholdKWhiteMarkers;
/*     */     }
/*     */     public void setThresholdKWhiteMarkers(double thresholdKWhiteMarkers) {
/*  85 */       this.thresholdKWhiteMarkers = thresholdKWhiteMarkers;
/*     */     }
/*     */ 
/*     */     public int getSubPixelWindow() {
/*  89 */       return this.subPixelWindow;
/*     */     }
/*     */     public void setSubPixelWindow(int subPixelWindow) {
/*  92 */       this.subPixelWindow = subPixelWindow;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.MarkerDetector
 * JD-Core Version:    0.6.2
 */