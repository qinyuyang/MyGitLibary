/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.ARToolKitPlus;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class Marker
/*     */   implements Cloneable
/*     */ {
/*     */   public int id;
/*     */   public double[] corners;
/*     */   public double confidence;
/*  94 */   private static opencv_core.IplImage[] imageCache = new opencv_core.IplImage[4096];
/*     */ 
/* 103 */   private static final double[] src = { 0.0D, 0.0D, 8.0D, 0.0D, 8.0D, 8.0D, 0.0D, 8.0D };
/*     */ 
/* 111 */   private static ThreadLocal<opencv_core.CvMat> H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 112 */   private static ThreadLocal<opencv_core.CvMat> srcPts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
/* 113 */   private static ThreadLocal<opencv_core.CvMat> dstPts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
/*     */ 
/*     */   public Marker(int id, double[] corners, double confidence)
/*     */   {
/*  35 */     this.id = id;
/*  36 */     this.corners = corners;
/*  37 */     this.confidence = confidence;
/*     */   }
/*     */   public Marker(int id, double[] corners) {
/*  40 */     this(id, corners, 1.0D);
/*     */   }
/*     */   public Marker clone() {
/*  43 */     return new Marker(this.id, (double[])this.corners.clone(), this.confidence);
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  50 */     int hash = 7;
/*  51 */     hash = 37 * hash + this.id;
/*  52 */     hash = 37 * hash + (this.corners != null ? this.corners.hashCode() : 0);
/*  53 */     return hash;
/*     */   }
/*     */   public boolean equals(Object o) {
/*  56 */     if ((o instanceof Marker)) {
/*  57 */       Marker m = (Marker)o;
/*  58 */       return (m.id == this.id) && (Arrays.equals(m.corners, this.corners));
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   public double[] getCenter() {
/*  64 */     double x = 0.0D; double y = 0.0D;
/*     */ 
/*  70 */     for (int i = 0; i < 4; i++) {
/*  71 */       x += this.corners[(2 * i)];
/*  72 */       y += this.corners[(2 * i + 1)];
/*     */     }
/*  74 */     x /= 4.0D;
/*  75 */     y /= 4.0D;
/*     */ 
/*  87 */     return new double[] { x, y };
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage getImage() {
/*  91 */     return getImage(this.id);
/*     */   }
/*     */ 
/*     */   public static opencv_core.IplImage getImage(int id)
/*     */   {
/*  96 */     if (imageCache[id] == null) {
/*  97 */       imageCache[id] = opencv_core.IplImage.create(8, 8, 8, 1);
/*  98 */       ARToolKitPlus.createImagePatternBCH(id, imageCache[id].getByteBuffer());
/*     */     }
/* 100 */     return imageCache[id];
/*     */   }
/*     */ 
/*     */   public void draw(opencv_core.IplImage image)
/*     */   {
/* 105 */     draw(image, opencv_core.CvScalar.BLACK, 1.0D, null);
/*     */   }
/*     */   public void draw(opencv_core.IplImage image, opencv_core.CvScalar color, double scale, opencv_core.CvMat prewarp) {
/* 108 */     draw(image, color, scale, scale, prewarp);
/*     */   }
/*     */ 
/*     */   public void draw(opencv_core.IplImage image, opencv_core.CvScalar color, double scaleX, double scaleY, opencv_core.CvMat prewarp)
/*     */   {
/* 115 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/* 116 */     JavaCV.getPerspectiveTransform(src, this.corners, H);
/* 117 */     if (prewarp != null) {
/* 118 */       opencv_core.cvGEMM(prewarp, H, 1.0D, null, 0.0D, H, 0);
/*     */     }
/* 120 */     opencv_core.IplImage marker = getImage();
/* 121 */     ByteBuffer mbuf = marker.getByteBuffer();
/* 122 */     opencv_core.CvMat srcPts = (opencv_core.CvMat)srcPts4x1.get();
/* 123 */     opencv_core.CvMat dstPts = (opencv_core.CvMat)dstPts4x1.get();
/* 124 */     opencv_core.CvPoint tempPts = new opencv_core.CvPoint(4);
/*     */ 
/* 126 */     int h = marker.height();
/* 127 */     int w = marker.width();
/* 128 */     for (int y = 0; y < h; y++)
/* 129 */       for (int x = 0; x < w; x++)
/* 130 */         if (mbuf.get(y * w + x) == 0) {
/* 131 */           srcPts.put(new double[] { x, y, x + 1, y, x + 1, y + 1, x, y + 1 });
/*     */ 
/* 133 */           opencv_core.cvPerspectiveTransform(srcPts, dstPts, H);
/*     */ 
/* 136 */           double centerx = 0.0D; double centery = 0.0D;
/* 137 */           for (int i = 0; i < 4; i++) {
/* 138 */             centerx += dstPts.get(i * 2);
/* 139 */             centery += dstPts.get(i * 2 + 1);
/*     */           }
/* 141 */           centerx /= 4.0D;
/* 142 */           centery /= 4.0D;
/* 143 */           for (int i = 0; i < 4; i++) {
/* 144 */             double a = dstPts.get(i * 2);
/* 145 */             double b = dstPts.get(i * 2 + 1);
/* 146 */             double dx = centerx - a;
/* 147 */             double dy = centery - b;
/* 148 */             dx = dx < 0.0D ? -1.0D : 0.0D;
/* 149 */             dy = dy < 0.0D ? -1.0D : 0.0D;
/* 150 */             tempPts.position(i).x((int)Math.round((a * scaleX + dx) * 65536.0D));
/* 151 */             tempPts.position(i).y((int)Math.round((b * scaleY + dy) * 65536.0D));
/*     */           }
/* 153 */           opencv_core.cvFillConvexPoly(image, tempPts.position(0), 4, color, 8, 16);
/*     */         }
/*     */   }
/*     */ 
/*     */   public static Marker[][] createArray(ArraySettings settings)
/*     */   {
/* 212 */     return createArray(settings, 0.0D, 0.0D);
/*     */   }
/*     */   public static Marker[][] createArray(ArraySettings settings, double marginx, double marginy) {
/* 215 */     Marker[] markers = new Marker[settings.rows * settings.columns];
/* 216 */     int id = 0;
/* 217 */     for (int y = 0; y < settings.rows; y++) {
/* 218 */       for (int x = 0; x < settings.columns; x++) {
/* 219 */         double sx = settings.sizeX / 2.0D;
/* 220 */         double sy = settings.sizeY / 2.0D;
/* 221 */         double cx = x * settings.spacingX + sx + marginx;
/* 222 */         double cy = y * settings.spacingY + sy + marginy;
/* 223 */         markers[id] = new Marker(id, new double[] { cx - sx, cy - sy, cx + sx, cy - sy, cx + sx, cy + sy, cx - sx, cy + sy }, 1.0D);
/*     */ 
/* 225 */         id++;
/*     */       }
/*     */     }
/* 228 */     if (!settings.checkered) {
/* 229 */       return new Marker[][] { markers };
/*     */     }
/* 231 */     Marker[] markers1 = new Marker[markers.length / 2];
/* 232 */     Marker[] markers2 = new Marker[markers.length / 2];
/* 233 */     for (int i = 0; i < markers.length; i++) {
/* 234 */       int x = i % settings.columns;
/* 235 */       int y = i / settings.columns;
/* 236 */       if (((x % 2 == 0 ? 1 : 0) ^ (y % 2 == 0 ? 1 : 0)) != 0)
/* 237 */         markers2[(i / 2)] = markers[i];
/*     */       else {
/* 239 */         markers1[(i / 2)] = markers[i];
/*     */       }
/*     */     }
/* 242 */     return new Marker[][] { markers2, markers1 };
/*     */   }
/*     */ 
/*     */   public static Marker[][] createArray(int rows, int columns, double sizeX, double sizeY, double spacingX, double spacingY, boolean checkered, double marginx, double marginy)
/*     */   {
/* 247 */     ArraySettings s = new ArraySettings();
/* 248 */     s.rows = rows; s.columns = columns;
/* 249 */     s.sizeX = sizeX; s.sizeY = sizeY;
/* 250 */     s.spacingX = spacingX; s.spacingY = spacingY;
/* 251 */     s.checkered = checkered;
/* 252 */     return createArray(s, marginx, marginy);
/*     */   }
/*     */ 
/*     */   public static void applyWarp(Marker[] markers, opencv_core.CvMat warp) {
/* 256 */     opencv_core.CvMat pts = (opencv_core.CvMat)srcPts4x1.get();
/*     */ 
/* 258 */     for (Marker m : markers) {
/* 259 */       opencv_core.cvPerspectiveTransform(pts.put(m.corners), pts, warp);
/* 260 */       pts.get(m.corners);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 265 */     String s = "[" + this.id + ": " + "(" + this.corners[0] + ", " + this.corners[1] + ") " + "(" + this.corners[2] + ", " + this.corners[3] + ") " + "(" + this.corners[4] + ", " + this.corners[5] + ") " + "(" + this.corners[6] + ", " + this.corners[7] + ")]";
/*     */ 
/* 270 */     return s;
/*     */   }
/*     */ 
/*     */   public static class ArraySettings extends BaseChildSettings
/*     */   {
/* 160 */     int rows = 8; int columns = 12;
/* 161 */     double sizeX = 200.0D; double sizeY = 200.0D; double spacingX = 300.0D; double spacingY = 300.0D;
/* 162 */     boolean checkered = true;
/*     */ 
/*     */     public int getRows() {
/* 165 */       return this.rows;
/*     */     }
/*     */     public void setRows(int rows) {
/* 168 */       firePropertyChange("rows", Integer.valueOf(this.rows), Integer.valueOf(this.rows = rows));
/*     */     }
/*     */ 
/*     */     public int getColumns() {
/* 172 */       return this.columns;
/*     */     }
/*     */     public void setColumns(int columns) {
/* 175 */       firePropertyChange("columns", Integer.valueOf(this.columns), Integer.valueOf(this.columns = columns));
/*     */     }
/*     */ 
/*     */     public double getSizeX() {
/* 179 */       return this.sizeX;
/*     */     }
/*     */     public void setSizeX(double sizeX) {
/* 182 */       firePropertyChange("sizeX", Double.valueOf(this.sizeX), Double.valueOf(this.sizeX = sizeX));
/*     */     }
/*     */     public double getSizeY() {
/* 185 */       return this.sizeY;
/*     */     }
/*     */     public void setSizeY(double sizeY) {
/* 188 */       firePropertyChange("sizeY", Double.valueOf(this.sizeY), Double.valueOf(this.sizeY = sizeY));
/*     */     }
/*     */ 
/*     */     public double getSpacingX() {
/* 192 */       return this.spacingX;
/*     */     }
/*     */     public void setSpacingX(double spacingX) {
/* 195 */       firePropertyChange("spacingX", Double.valueOf(this.spacingX), Double.valueOf(this.spacingX = spacingX));
/*     */     }
/*     */     public double getSpacingY() {
/* 198 */       return this.spacingY;
/*     */     }
/*     */     public void setSpacingY(double spacingY) {
/* 201 */       firePropertyChange("spacingY", Double.valueOf(this.spacingY), Double.valueOf(this.spacingY = spacingY));
/*     */     }
/*     */ 
/*     */     public boolean isCheckered() {
/* 205 */       return this.checkered;
/*     */     }
/*     */     public void setCheckered(boolean checkered) {
/* 208 */       firePropertyChange("checkered", Boolean.valueOf(this.checkered), Boolean.valueOf(this.checkered = checkered));
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.Marker
 * JD-Core Version:    0.6.2
 */