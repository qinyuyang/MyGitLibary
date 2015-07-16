/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvBox2D;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvRect;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSize2D32f;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplROI;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class JavaCV
/*     */ {
/*     */   public static final double SQRT2 = 1.414213562373095D;
/*     */   public static final double FLT_EPSILON = 1.192092895507813E-007D;
/*     */   public static final double DBL_EPSILON = 2.220446049250313E-016D;
/*  61 */   private static ThreadLocal<opencv_imgproc.CvMoments> moments = opencv_imgproc.CvMoments.createThreadLocal();
/*     */ 
/* 125 */   private static ThreadLocal<opencv_core.CvMat> A8x8 = opencv_core.CvMat.createThreadLocal(8, 8);
/* 126 */   private static ThreadLocal<opencv_core.CvMat> b8x1 = opencv_core.CvMat.createThreadLocal(8, 1);
/* 127 */   private static ThreadLocal<opencv_core.CvMat> x8x1 = opencv_core.CvMat.createThreadLocal(8, 1);
/*     */ 
/* 174 */   private static ThreadLocal<opencv_core.CvMat> A3x3 = opencv_core.CvMat.createThreadLocal(3, 3); private static ThreadLocal<opencv_core.CvMat> b3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*     */ 
/* 198 */   private static ThreadLocal<opencv_core.CvMat> n3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*     */ 
/* 214 */   private static ThreadLocal<opencv_core.CvMat> H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/* 234 */   private static ThreadLocal<opencv_core.CvMat> M3x2 = opencv_core.CvMat.createThreadLocal(3, 2); private static ThreadLocal<opencv_core.CvMat> S2x2 = opencv_core.CvMat.createThreadLocal(2, 2);
/* 235 */   private static ThreadLocal<opencv_core.CvMat> U3x2 = opencv_core.CvMat.createThreadLocal(3, 2); private static ThreadLocal<opencv_core.CvMat> V2x2 = opencv_core.CvMat.createThreadLocal(2, 2);
/*     */ 
/* 254 */   private static ThreadLocal<opencv_core.CvMat> R13x3 = opencv_core.CvMat.createThreadLocal(3, 3); private static ThreadLocal<opencv_core.CvMat> R23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 255 */   private static ThreadLocal<opencv_core.CvMat> t13x1 = opencv_core.CvMat.createThreadLocal(3, 1); private static ThreadLocal<opencv_core.CvMat> t23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 256 */   private static ThreadLocal<opencv_core.CvMat> n13x1 = opencv_core.CvMat.createThreadLocal(3, 1); private static ThreadLocal<opencv_core.CvMat> n23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/* 257 */   private static ThreadLocal<opencv_core.CvMat> H13x3 = opencv_core.CvMat.createThreadLocal(3, 3); private static ThreadLocal<opencv_core.CvMat> H23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/* 326 */   private static ThreadLocal<opencv_core.CvMat> S3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 327 */   private static ThreadLocal<opencv_core.CvMat> U3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/* 328 */   private static ThreadLocal<opencv_core.CvMat> V3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*     */ 
/*     */   public static double distanceToLine(double x1, double y1, double x2, double y2, double x3, double y3)
/*     */   {
/*  46 */     double dx = x2 - x1;
/*  47 */     double dy = y2 - y1;
/*  48 */     double d2 = dx * dx + dy * dy;
/*  49 */     double u = ((x3 - x1) * dx + (y3 - y1) * dy) / d2;
/*     */ 
/*  51 */     double x = x1 + u * dx;
/*  52 */     double y = y1 + u * dy;
/*     */ 
/*  54 */     dx = x - x3;
/*  55 */     dy = y - y3;
/*  56 */     return dx * dx + dy * dy;
/*     */   }
/*     */ 
/*     */   public static opencv_core.CvBox2D boundedRect(opencv_core.CvMat contour, opencv_core.CvBox2D box)
/*     */   {
/*  63 */     int contourLength = contour.length();
/*  64 */     opencv_imgproc.CvMoments m = (opencv_imgproc.CvMoments)moments.get();
/*  65 */     opencv_imgproc.cvMoments(contour, m, 0);
/*  66 */     double inv_m00 = 1.0D / m.m00();
/*  67 */     double centerX = m.m10() * inv_m00;
/*  68 */     double centerY = m.m01() * inv_m00;
/*     */ 
/*  70 */     float[] pts = new float[8];
/*  71 */     opencv_core.CvPoint2D32f center = box.center();
/*  72 */     opencv_core.CvSize2D32f size = box.size();
/*  73 */     center.put(centerX, centerY);
/*  74 */     opencv_imgproc.cvBoxPoints(box, pts);
/*     */ 
/*  76 */     float scale = (1.0F / 1.0F);
/*  77 */     for (int i = 0; i < 4; i++) {
/*  78 */       double x1 = centerX; double y1 = centerY;
/*  79 */       double x2 = pts[(2 * i)]; double y2 = pts[(2 * i + 1)];
/*  80 */       for (int j = 0; j < contourLength; j++) {
/*  81 */         int k = (j + 1) % contourLength;
/*  82 */         double x3 = contour.get(2 * j); double y3 = contour.get(2 * j + 1);
/*  83 */         double x4 = contour.get(2 * k); double y4 = contour.get(2 * k + 1);
/*  84 */         double d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
/*  85 */         double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / d;
/*  86 */         double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / d;
/*  87 */         if ((ub >= 0.0D) && (ub <= 1.0D) && (ua >= 0.0D) && (ua < scale)) {
/*  88 */           scale = (float)ua;
/*     */         }
/*     */       }
/*     */     }
/*  92 */     size.width(scale * size.width()).height(scale * size.height());
/*  93 */     return box;
/*     */   }
/*     */ 
/*     */   public static opencv_core.CvRect boundingRect(double[] contour, opencv_core.CvRect rect, int padX, int padY, int alignX, int alignY)
/*     */   {
/* 102 */     double minX = contour[0];
/* 103 */     double minY = contour[1];
/* 104 */     double maxX = contour[0];
/* 105 */     double maxY = contour[1];
/* 106 */     for (int i = 1; i < contour.length / 2; i++) {
/* 107 */       double x = contour[(2 * i)];
/* 108 */       double y = contour[(2 * i + 1)];
/* 109 */       minX = Math.min(minX, x);
/* 110 */       minY = Math.min(minY, y);
/* 111 */       maxX = Math.max(maxX, x);
/* 112 */       maxY = Math.max(maxY, y);
/*     */     }
/* 114 */     int x = (int)Math.floor(Math.max(rect.x(), minX - padX) / alignX) * alignX;
/* 115 */     int y = (int)Math.floor(Math.max(rect.y(), minY - padY) / alignY) * alignY;
/* 116 */     int width = (int)Math.ceil(Math.min(rect.width(), maxX + padX) / alignX) * alignX - x;
/* 117 */     int height = (int)Math.ceil(Math.min(rect.height(), maxY + padY) / alignY) * alignY - y;
/*     */ 
/* 119 */     return rect.x(x).y(y).width(Math.max(0, width)).height(Math.max(0, height));
/*     */   }
/*     */ 
/*     */   public static opencv_core.CvMat getPerspectiveTransform(double[] src, double[] dst, opencv_core.CvMat map_matrix)
/*     */   {
/* 131 */     opencv_core.CvMat A = (opencv_core.CvMat)A8x8.get();
/* 132 */     opencv_core.CvMat b = (opencv_core.CvMat)b8x1.get();
/* 133 */     opencv_core.CvMat x = (opencv_core.CvMat)x8x1.get();
/*     */ 
/* 135 */     for (int i = 0; i < 4; i++) {
/* 136 */       A.put(i * 8 + 0, src[(i * 2)]); A.put((i + 4) * 8 + 3, src[(i * 2)]);
/* 137 */       A.put(i * 8 + 1, src[(i * 2 + 1)]); A.put((i + 4) * 8 + 4, src[(i * 2 + 1)]);
/* 138 */       A.put(i * 8 + 2, 1.0D); A.put((i + 4) * 8 + 5, 1.0D);
/* 139 */       A.put(i * 8 + 3, 0.0D); A.put(i * 8 + 4, 0.0D); A.put(i * 8 + 5, 0.0D);
/* 140 */       A.put((i + 4) * 8 + 0, 0.0D); A.put((i + 4) * 8 + 1, 0.0D); A.put((i + 4) * 8 + 2, 0.0D);
/*     */ 
/* 142 */       A.put(i * 8 + 6, -src[(i * 2)] * dst[(i * 2)]);
/* 143 */       A.put(i * 8 + 7, -src[(i * 2 + 1)] * dst[(i * 2)]);
/* 144 */       A.put((i + 4) * 8 + 6, -src[(i * 2)] * dst[(i * 2 + 1)]);
/* 145 */       A.put((i + 4) * 8 + 7, -src[(i * 2 + 1)] * dst[(i * 2 + 1)]);
/*     */ 
/* 147 */       b.put(i, dst[(i * 2)]);
/* 148 */       b.put(i + 4, dst[(i * 2 + 1)]);
/*     */     }
/* 150 */     opencv_core.cvSolve(A, b, x, 0);
/* 151 */     map_matrix.put(x.get());
/* 152 */     map_matrix.put(8, 1.0D);
/*     */ 
/* 154 */     return map_matrix;
/*     */   }
/*     */ 
/*     */   public static void perspectiveTransform(double[] src, double[] dst, opencv_core.CvMat map_matrix) {
/* 158 */     double[] mat = map_matrix.get();
/* 159 */     for (int j = 0; j < src.length; j += 2) {
/* 160 */       double x = src[j]; double y = src[(j + 1)];
/* 161 */       double w = x * mat[6] + y * mat[7] + mat[8];
/*     */ 
/* 163 */       if (Math.abs(w) > 1.192092895507813E-007D) {
/* 164 */         w = 1.0D / w;
/* 165 */         dst[j] = ((x * mat[0] + y * mat[1] + mat[2]) * w);
/* 166 */         dst[(j + 1)] = ((x * mat[3] + y * mat[4] + mat[5]) * w);
/*     */       }
/*     */       else
/*     */       {
/*     */         double tmp131_130 = 0.0D; dst[(j + 1)] = tmp131_130; dst[j] = tmp131_130;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static opencv_core.CvMat getPlaneParameters(double[] src, double[] dst, opencv_core.CvMat invSrcK, opencv_core.CvMat dstK, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n)
/*     */   {
/* 177 */     opencv_core.CvMat A = (opencv_core.CvMat)A3x3.get(); opencv_core.CvMat b = (opencv_core.CvMat)b3x1.get();
/*     */ 
/* 179 */     double[] x = new double[6]; double[] y = new double[6];
/* 180 */     perspectiveTransform(src, x, invSrcK);
/* 181 */     opencv_core.cvInvert(dstK, A);
/* 182 */     perspectiveTransform(dst, y, A);
/*     */ 
/* 184 */     for (int i = 0; i < 3; i++) {
/* 185 */       A.put(i, 0, (t.get(2) * y[(i * 2)] - t.get(0)) * x[(i * 2)]);
/* 186 */       A.put(i, 1, (t.get(2) * y[(i * 2)] - t.get(0)) * x[(i * 2 + 1)]);
/* 187 */       A.put(i, 2, t.get(2) * y[(i * 2)] - t.get(0));
/*     */ 
/* 189 */       b.put(i, (R.get(2, 0) * x[(i * 2)] + R.get(2, 1) * x[(i * 2 + 1)] + R.get(2, 2)) * y[(i * 2)] - (R.get(0, 0) * x[(i * 2)] + R.get(0, 1) * x[(i * 2 + 1)] + R.get(0, 2)));
/*     */     }
/*     */ 
/* 192 */     opencv_core.cvSolve(A, b, n, 0);
/*     */ 
/* 194 */     return n;
/*     */   }
/*     */ 
/*     */   public static opencv_core.CvMat getPerspectiveTransform(double[] src, double[] dst, opencv_core.CvMat invSrcK, opencv_core.CvMat dstK, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat H)
/*     */   {
/* 201 */     opencv_core.CvMat n = (opencv_core.CvMat)n3x1.get();
/* 202 */     getPlaneParameters(src, dst, invSrcK, dstK, R, t, n);
/*     */ 
/* 205 */     opencv_core.cvGEMM(t, n, -1.0D, R, 1.0D, H, 2);
/*     */ 
/* 207 */     opencv_core.cvMatMul(dstK, H, H);
/* 208 */     opencv_core.cvMatMul(H, invSrcK, H);
/*     */ 
/* 210 */     return H;
/*     */   }
/*     */ 
/*     */   public static void perspectiveTransform(double[] src, double[] dst, opencv_core.CvMat invSrcK, opencv_core.CvMat dstK, opencv_core.CvMat R, opencv_core.CvMat t, opencv_core.CvMat n, boolean invert)
/*     */   {
/* 217 */     opencv_core.CvMat H = (opencv_core.CvMat)H3x3.get();
/*     */ 
/* 220 */     opencv_core.cvGEMM(t, n, -1.0D, R, 1.0D, H, 2);
/*     */ 
/* 223 */     opencv_core.cvMatMul(dstK, H, H);
/* 224 */     opencv_core.cvMatMul(H, invSrcK, H);
/* 225 */     if (invert) {
/* 226 */       opencv_core.cvInvert(H, H);
/*     */     }
/* 228 */     perspectiveTransform(src, dst, H);
/*     */   }
/*     */ 
/*     */   public static void HtoRt(opencv_core.CvMat H, opencv_core.CvMat R, opencv_core.CvMat t)
/*     */   {
/* 237 */     opencv_core.CvMat M = (opencv_core.CvMat)M3x2.get(); opencv_core.CvMat S = (opencv_core.CvMat)S2x2.get();
/* 238 */     opencv_core.CvMat U = (opencv_core.CvMat)U3x2.get(); opencv_core.CvMat V = (opencv_core.CvMat)V2x2.get();
/* 239 */     M.put(new double[] { H.get(0), H.get(1), H.get(3), H.get(4), H.get(6), H.get(7) });
/*     */ 
/* 242 */     opencv_core.cvSVD(M, S, U, V, 4);
/*     */ 
/* 244 */     double lambda = S.get(3);
/* 245 */     t.put(new double[] { H.get(2) / lambda, H.get(5) / lambda, H.get(8) / lambda });
/*     */ 
/* 247 */     opencv_core.cvMatMul(U, V, M);
/* 248 */     R.put(new double[] { M.get(0), M.get(1), M.get(2) * M.get(5) - M.get(3) * M.get(4), M.get(2), M.get(3), M.get(1) * M.get(4) - M.get(0) * M.get(5), M.get(4), M.get(5), M.get(0) * M.get(3) - M.get(1) * M.get(2) });
/*     */   }
/*     */ 
/*     */   public static double HnToRt(opencv_core.CvMat H, opencv_core.CvMat n, opencv_core.CvMat R, opencv_core.CvMat t)
/*     */   {
/* 259 */     opencv_core.CvMat S = (opencv_core.CvMat)S3x3.get(); opencv_core.CvMat U = (opencv_core.CvMat)U3x3.get(); opencv_core.CvMat V = (opencv_core.CvMat)V3x3.get();
/* 260 */     opencv_core.cvSVD(H, S, U, V, 0);
/*     */ 
/* 262 */     opencv_core.CvMat R1 = (opencv_core.CvMat)R13x3.get(); opencv_core.CvMat R2 = (opencv_core.CvMat)R23x3.get();
/* 263 */     opencv_core.CvMat t1 = (opencv_core.CvMat)t13x1.get(); opencv_core.CvMat t2 = (opencv_core.CvMat)t23x1.get();
/* 264 */     opencv_core.CvMat n1 = (opencv_core.CvMat)n13x1.get(); opencv_core.CvMat n2 = (opencv_core.CvMat)n23x1.get();
/* 265 */     opencv_core.CvMat H1 = (opencv_core.CvMat)H13x3.get(); opencv_core.CvMat H2 = (opencv_core.CvMat)H23x3.get();
/* 266 */     double zeta = homogToRt(S, U, V, R1, t1, n1, R2, t2, n2);
/*     */ 
/* 269 */     opencv_core.cvGEMM(R1, H, 1.0D / S.get(4), null, 0.0D, H1, 1);
/* 270 */     opencv_core.cvGEMM(R2, H, 1.0D / S.get(4), null, 0.0D, H2, 1);
/*     */ 
/* 273 */     H1.put(0, H1.get(0) - 1.0D); H1.put(4, H1.get(4) - 1.0D); H1.put(8, H1.get(8) - 1.0D);
/* 274 */     H2.put(0, H2.get(0) - 1.0D); H2.put(4, H2.get(4) - 1.0D); H2.put(8, H2.get(8) - 1.0D);
/*     */ 
/* 277 */     double d = Math.abs(n.get(0)) + Math.abs(n.get(1)) + Math.abs(n.get(2));
/* 278 */     double[] s = { -Math.signum(n.get(0)), -Math.signum(n.get(1)), -Math.signum(n.get(2)) };
/* 279 */     t1.put(new double[] { 0.0D, 0.0D, 0.0D });
/* 280 */     t2.put(new double[] { 0.0D, 0.0D, 0.0D });
/* 281 */     for (int i = 0; i < 3; i++) {
/* 282 */       t1.put(0, t1.get(0) + s[i] * H1.get(i) / d);
/* 283 */       t1.put(1, t1.get(1) + s[i] * H1.get(i + 3) / d);
/* 284 */       t1.put(2, t1.get(2) + s[i] * H1.get(i + 6) / d);
/*     */ 
/* 286 */       t2.put(0, t2.get(0) + s[i] * H2.get(i) / d);
/* 287 */       t2.put(1, t2.get(1) + s[i] * H2.get(i + 3) / d);
/* 288 */       t2.put(2, t2.get(2) + s[i] * H2.get(i + 6) / d);
/*     */     }
/*     */ 
/* 292 */     opencv_core.cvGEMM(t1, n, 1.0D, H1, 1.0D, H1, 2);
/* 293 */     opencv_core.cvGEMM(t2, n, 1.0D, H2, 1.0D, H2, 2);
/*     */ 
/* 297 */     double err1 = opencv_core.cvNorm(H1);
/* 298 */     double err2 = opencv_core.cvNorm(H2);
/*     */     double err;
/*     */     double err;
/* 301 */     if (err1 < err2) {
/* 302 */       if (R != null) {
/* 303 */         R.put(R1);
/*     */       }
/* 305 */       if (t != null) {
/* 306 */         t.put(t1);
/*     */       }
/* 308 */       err = err1;
/*     */     } else {
/* 310 */       if (R != null) {
/* 311 */         R.put(R2);
/*     */       }
/* 313 */       if (t != null) {
/* 314 */         t.put(t2);
/*     */       }
/* 316 */       err = err2;
/*     */     }
/*     */ 
/* 319 */     return err;
/*     */   }
/*     */ 
/*     */   public static double homogToRt(opencv_core.CvMat H, opencv_core.CvMat R1, opencv_core.CvMat t1, opencv_core.CvMat n1, opencv_core.CvMat R2, opencv_core.CvMat t2, opencv_core.CvMat n2)
/*     */   {
/* 332 */     opencv_core.CvMat S = (opencv_core.CvMat)S3x3.get(); opencv_core.CvMat U = (opencv_core.CvMat)U3x3.get(); opencv_core.CvMat V = (opencv_core.CvMat)V3x3.get();
/* 333 */     opencv_core.cvSVD(H, S, U, V, 0);
/* 334 */     double zeta = homogToRt(S, U, V, R1, t1, n1, R2, t2, n2);
/* 335 */     return zeta;
/*     */   }
/*     */ 
/*     */   public static double homogToRt(opencv_core.CvMat S, opencv_core.CvMat U, opencv_core.CvMat V, opencv_core.CvMat R1, opencv_core.CvMat t1, opencv_core.CvMat n1, opencv_core.CvMat R2, opencv_core.CvMat t2, opencv_core.CvMat n2)
/*     */   {
/* 340 */     double s1 = S.get(0) / S.get(4);
/* 341 */     double s3 = S.get(8) / S.get(4);
/* 342 */     double zeta = s1 - s3;
/* 343 */     double a1 = Math.sqrt(1.0D - s3 * s3);
/* 344 */     double b1 = Math.sqrt(s1 * s1 - 1.0D);
/* 345 */     double[] ab = unitize(a1, b1);
/* 346 */     double[] cd = unitize(1.0D + s1 * s3, a1 * b1);
/* 347 */     double[] ef = unitize(-ab[1] / s1, -ab[0] / s3);
/*     */ 
/* 349 */     R1.put(new double[] { cd[0], 0.0D, cd[1], 0.0D, 1.0D, 0.0D, -cd[1], 0.0D, cd[0] });
/* 350 */     opencv_core.cvGEMM(U, R1, 1.0D, null, 0.0D, R1, 0);
/* 351 */     opencv_core.cvGEMM(R1, V, 1.0D, null, 0.0D, R1, 2);
/*     */ 
/* 353 */     R2.put(new double[] { cd[0], 0.0D, -cd[1], 0.0D, 1.0D, 0.0D, cd[1], 0.0D, cd[0] });
/* 354 */     opencv_core.cvGEMM(U, R2, 1.0D, null, 0.0D, R2, 0);
/* 355 */     opencv_core.cvGEMM(R2, V, 1.0D, null, 0.0D, R2, 2);
/*     */ 
/* 357 */     double[] v1 = { V.get(0), V.get(3), V.get(6) };
/* 358 */     double[] v3 = { V.get(2), V.get(5), V.get(8) };
/* 359 */     double sign1 = 1.0D; double sign2 = 1.0D;
/* 360 */     for (int i = 2; i >= 0; i--) {
/* 361 */       n1.put(i, sign1 * (ab[1] * v1[i] - ab[0] * v3[i]));
/* 362 */       n2.put(i, sign2 * (ab[1] * v1[i] + ab[0] * v3[i]));
/* 363 */       t1.put(i, sign1 * (ef[0] * v1[i] + ef[1] * v3[i]));
/* 364 */       t2.put(i, sign2 * (ef[0] * v1[i] - ef[1] * v3[i]));
/* 365 */       if (i == 2) {
/* 366 */         if (n1.get(2) < 0.0D) {
/* 367 */           n1.put(2, -n1.get(2));
/* 368 */           t1.put(2, -t1.get(2));
/* 369 */           sign1 = -1.0D;
/*     */         }
/* 371 */         if (n2.get(2) < 0.0D) {
/* 372 */           n2.put(2, -n2.get(2));
/* 373 */           t2.put(2, -t2.get(2));
/* 374 */           sign2 = -1.0D;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 379 */     return zeta;
/*     */   }
/*     */ 
/*     */   public static double[] unitize(double a, double b) {
/* 383 */     double norm = Math.sqrt(a * a + b * b);
/* 384 */     if (norm > 1.192092895507813E-007D) {
/* 385 */       a /= norm;
/* 386 */       b /= norm;
/*     */     }
/* 388 */     return new double[] { a, b };
/*     */   }
/*     */ 
/*     */   public static void adaptiveThreshold(opencv_core.IplImage srcImage, opencv_core.IplImage sumImage, opencv_core.IplImage sqSumImage, opencv_core.IplImage dstImage, final boolean invert, final int windowMax, final int windowMin, double varMultiplier, final double k)
/*     */   {
/* 395 */     int w = srcImage.width();
/* 396 */     final int h = srcImage.height();
/* 397 */     int srcChannels = srcImage.nChannels();
/* 398 */     int srcDepth = srcImage.depth();
/* 399 */     int dstDepth = dstImage.depth();
/*     */ 
/* 401 */     if ((srcChannels > 1) && (dstDepth == 8)) {
/* 402 */       opencv_imgproc.cvCvtColor(srcImage, dstImage, srcChannels == 4 ? 11 : 6);
/* 403 */       srcImage = dstImage;
/*     */     }
/*     */ 
/* 406 */     final ByteBuffer srcBuf = srcImage.getByteBuffer();
/* 407 */     final ByteBuffer dstBuf = dstImage.getByteBuffer();
/* 408 */     final DoubleBuffer sumBuf = sumImage.getDoubleBuffer();
/* 409 */     final DoubleBuffer sqSumBuf = sqSumImage.getDoubleBuffer();
/* 410 */     final int srcStep = srcImage.widthStep();
/* 411 */     int dstStep = dstImage.widthStep();
/* 412 */     final int sumStep = sumImage.widthStep();
/* 413 */     final int sqSumStep = sqSumImage.widthStep();
/*     */ 
/* 416 */     opencv_imgproc.cvIntegral(srcImage, sumImage, sqSumImage, null);
/*     */ 
/* 420 */     double totalMean = sumBuf.get((h - 1) * sumStep / 8 + (w - 1)) - sumBuf.get((h - 1) * sumStep / 8) - sumBuf.get(w - 1) + sumBuf.get(0);
/*     */ 
/* 423 */     totalMean /= w * h;
/* 424 */     double totalSqMean = sqSumBuf.get((h - 1) * sqSumStep / 8 + (w - 1)) - sqSumBuf.get((h - 1) * sqSumStep / 8) - sqSumBuf.get(w - 1) + sqSumBuf.get(0);
/*     */ 
/* 427 */     totalSqMean /= w * h;
/* 428 */     double totalVar = totalSqMean - totalMean * totalMean;
/*     */ 
/* 431 */     final double targetVar = totalVar * varMultiplier;
/*     */ 
/* 434 */     Parallel.loop(0, h, new Parallel.Looper() {
/*     */       public void loop(int from, int to, int looperID) {
/* 436 */         for (int y = from; y < to; y++)
/* 437 */           for (int x = 0; x < this.val$w; x++) {
/* 438 */             double var = 0.0D; double mean = 0.0D; double sqMean = 0.0D;
/* 439 */             int upperLimit = windowMax;
/* 440 */             int lowerLimit = windowMin;
/* 441 */             int window = upperLimit;
/* 442 */             while (upperLimit - lowerLimit > 2) {
/* 443 */               int x1 = Math.max(x - window / 2, 0);
/* 444 */               int x2 = Math.min(x + window / 2 + 1, this.val$w);
/*     */ 
/* 446 */               int y1 = Math.max(y - window / 2, 0);
/* 447 */               int y2 = Math.min(y + window / 2 + 1, h);
/*     */ 
/* 449 */               mean = sumBuf.get(y2 * sumStep / 8 + x2) - sumBuf.get(y2 * sumStep / 8 + x1) - sumBuf.get(y1 * sumStep / 8 + x2) + sumBuf.get(y1 * sumStep / 8 + x1);
/*     */ 
/* 453 */               mean /= window * window;
/* 454 */               sqMean = sqSumBuf.get(y2 * sqSumStep / 8 + x2) - sqSumBuf.get(y2 * sqSumStep / 8 + x1) - sqSumBuf.get(y1 * sqSumStep / 8 + x2) + sqSumBuf.get(y1 * sqSumStep / 8 + x1);
/*     */ 
/* 458 */               sqMean /= window * window;
/* 459 */               var = sqMean - mean * mean;
/*     */ 
/* 463 */               if ((window == upperLimit) && (var < targetVar))
/*     */               {
/*     */                 break;
/*     */               }
/*     */ 
/* 468 */               if (var > targetVar)
/* 469 */                 upperLimit = window;
/*     */               else {
/* 471 */                 lowerLimit = window;
/*     */               }
/*     */ 
/* 474 */               window = lowerLimit + (upperLimit - lowerLimit) / 2;
/* 475 */               window = window / 2 * 2 + 1;
/*     */             }
/*     */ 
/* 478 */             double value = 0.0D;
/* 479 */             if (srcBuf == 8)
/* 480 */               value = srcStep.get(y * invert + x) & 0xFF;
/* 481 */             else if (srcBuf == 32)
/* 482 */               value = srcStep.getFloat(y * invert + 4 * x);
/* 483 */             else if (srcBuf == 64) {
/* 484 */               value = srcStep.getDouble(y * invert + 8 * x);
/*     */             }
/* 488 */             else if (!$assertionsDisabled) throw new AssertionError();
/*     */ 
/* 490 */             if (k)
/*     */             {
/* 492 */               double threshold = 255.0D - (255.0D - mean) * dstBuf;
/* 493 */               this.val$dstBuf.put(y * this.val$dstStep + x, (byte)(value < threshold ? -1 : 0));
/*     */             }
/*     */             else {
/* 496 */               double threshold = mean * dstBuf;
/* 497 */               this.val$dstBuf.put(y * this.val$dstStep + x, (byte)(value > threshold ? -1 : 0));
/*     */             }
/*     */           }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public static void hysteresisThreshold(opencv_core.IplImage srcImage, opencv_core.IplImage dstImage, double highThresh, double lowThresh, double maxValue)
/*     */   {
/* 507 */     int highThreshold = (int)Math.round(highThresh);
/* 508 */     int lowThreshold = (int)Math.round(lowThresh);
/* 509 */     byte lowValue = 0;
/* 510 */     byte medValue = (byte)(int)Math.round(maxValue / 2.0D);
/* 511 */     byte highValue = (byte)(int)Math.round(maxValue);
/*     */ 
/* 513 */     int height = srcImage.height();
/* 514 */     int width = srcImage.width();
/*     */ 
/* 516 */     ByteBuffer srcData = srcImage.getByteBuffer();
/* 517 */     ByteBuffer dstData = dstImage.getByteBuffer();
/* 518 */     int srcStep = srcImage.widthStep();
/* 519 */     int dstStep = dstImage.widthStep();
/* 520 */     int srcIndex = 0;
/* 521 */     int dstIndex = 0;
/*     */ 
/* 528 */     int i = 0;
/* 529 */     int in = srcData.get(srcIndex + i) & 0xFF;
/* 530 */     if (in >= highThreshold)
/* 531 */       dstData.put(dstIndex + i, highValue);
/* 532 */     else if (in < lowThreshold)
/* 533 */       dstData.put(dstIndex + i, lowValue);
/*     */     else {
/* 535 */       dstData.put(dstIndex + i, medValue);
/*     */     }
/*     */ 
/* 538 */     for (i = 1; i < width - 1; i++) {
/* 539 */       in = srcData.get(srcIndex + i) & 0xFF;
/* 540 */       if (in >= highThreshold) {
/* 541 */         dstData.put(dstIndex + i, highValue);
/* 542 */       } else if (in < lowThreshold) {
/* 543 */         dstData.put(dstIndex + i, lowValue);
/*     */       } else {
/* 545 */         byte prev = dstData.get(dstIndex + i - 1);
/* 546 */         if (prev == highValue)
/* 547 */           dstData.put(dstIndex + i, highValue);
/*     */         else {
/* 549 */           dstData.put(dstIndex + i, medValue);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 554 */     i = width - 1;
/* 555 */     in = srcData.get(srcIndex + i) & 0xFF;
/* 556 */     if (in >= highThreshold) {
/* 557 */       dstData.put(dstIndex + i, highValue);
/* 558 */     } else if (in < lowThreshold) {
/* 559 */       dstData.put(dstIndex + i, lowValue);
/*     */     } else {
/* 561 */       byte prev = dstData.get(dstIndex + i - 1);
/* 562 */       if (prev == highValue)
/* 563 */         dstData.put(dstIndex + i, highValue);
/*     */       else {
/* 565 */         dstData.put(dstIndex + i, medValue);
/*     */       }
/*     */     }
/*     */ 
/* 569 */     height--;
/*     */ 
/* 572 */     while (height-- > 0) {
/* 573 */       srcIndex += srcStep;
/* 574 */       dstIndex += dstStep;
/*     */ 
/* 577 */       i = 0;
/* 578 */       in = srcData.get(srcIndex + i) & 0xFF;
/* 579 */       if (in >= highThreshold) {
/* 580 */         dstData.put(dstIndex + i, highValue);
/* 581 */       } else if (in < lowThreshold) {
/* 582 */         dstData.put(dstIndex + i, lowValue);
/*     */       } else {
/* 584 */         byte prev1 = dstData.get(dstIndex + i - dstStep);
/* 585 */         byte prev2 = dstData.get(dstIndex + i - dstStep + 1);
/* 586 */         if ((prev1 == highValue) || (prev2 == highValue))
/* 587 */           dstData.put(dstIndex + i, highValue);
/*     */         else {
/* 589 */           dstData.put(dstIndex + i, medValue);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 594 */       for (i = 1; i < width - 1; i++) {
/* 595 */         in = srcData.get(srcIndex + i) & 0xFF;
/* 596 */         if (in >= highThreshold) {
/* 597 */           dstData.put(dstIndex + i, highValue);
/* 598 */         } else if (in < lowThreshold) {
/* 599 */           dstData.put(dstIndex + i, lowValue);
/*     */         } else {
/* 601 */           byte prev1 = dstData.get(dstIndex + i - 1);
/* 602 */           byte prev2 = dstData.get(dstIndex + i - dstStep - 1);
/* 603 */           byte prev3 = dstData.get(dstIndex + i - dstStep);
/* 604 */           byte prev4 = dstData.get(dstIndex + i - dstStep + 1);
/*     */ 
/* 606 */           if ((prev1 == highValue) || (prev2 == highValue) || (prev3 == highValue) || (prev4 == highValue))
/*     */           {
/* 608 */             dstData.put(dstIndex + i, highValue);
/*     */           }
/* 610 */           else dstData.put(dstIndex + i, medValue);
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 616 */       i = width - 1;
/* 617 */       in = srcData.get(srcIndex + i) & 0xFF;
/* 618 */       if (in >= highThreshold) {
/* 619 */         dstData.put(dstIndex + i, highValue);
/* 620 */       } else if (in < lowThreshold) {
/* 621 */         dstData.put(dstIndex + i, lowValue);
/*     */       } else {
/* 623 */         byte prev1 = dstData.get(dstIndex + i - 1);
/* 624 */         byte prev2 = dstData.get(dstIndex + i - dstStep - 1);
/* 625 */         byte prev3 = dstData.get(dstIndex + i - dstStep);
/*     */ 
/* 627 */         if ((prev1 == highValue) || (prev2 == highValue) || (prev3 == highValue))
/*     */         {
/* 629 */           dstData.put(dstIndex + i, highValue);
/*     */         }
/* 631 */         else dstData.put(dstIndex + i, medValue);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 636 */     height = srcImage.height();
/* 637 */     width = srcImage.width();
/* 638 */     dstIndex = (height - 1) * dstStep;
/*     */ 
/* 645 */     i = width - 1;
/* 646 */     if (dstData.get(dstIndex + i) == medValue) {
/* 647 */       dstData.put(dstIndex + i, lowValue);
/*     */     }
/*     */ 
/* 650 */     for (i = width - 2; i > 0; i--) {
/* 651 */       if (dstData.get(dstIndex + i) == medValue) {
/* 652 */         if (dstData.get(dstIndex + i + 1) == highValue)
/* 653 */           dstData.put(dstIndex + i, highValue);
/*     */         else {
/* 655 */           dstData.put(dstIndex + i, lowValue);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 660 */     i = 0;
/* 661 */     if (dstData.get(dstIndex + i) == medValue) {
/* 662 */       if (dstData.get(dstIndex + i + 1) == highValue)
/* 663 */         dstData.put(dstIndex + i, highValue);
/*     */       else {
/* 665 */         dstData.put(dstIndex + i, lowValue);
/*     */       }
/*     */     }
/*     */ 
/* 669 */     height--;
/*     */ 
/* 672 */     while (height-- > 0) {
/* 673 */       dstIndex -= dstStep;
/*     */ 
/* 676 */       i = width - 1;
/* 677 */       if (dstData.get(dstIndex + i) == medValue) {
/* 678 */         if ((dstData.get(dstIndex + i + dstStep) == highValue) || (dstData.get(dstIndex + i + dstStep - 1) == highValue))
/*     */         {
/* 680 */           dstData.put(dstIndex + i, highValue);
/*     */         }
/* 682 */         else dstData.put(dstIndex + i, lowValue);
/*     */ 
/*     */       }
/*     */ 
/* 687 */       for (i = width - 2; i > 0; i--) {
/* 688 */         if (dstData.get(dstIndex + i) == medValue) {
/* 689 */           if ((dstData.get(dstIndex + i + 1) == highValue) || (dstData.get(dstIndex + i + dstStep + 1) == highValue) || (dstData.get(dstIndex + i + dstStep) == highValue) || (dstData.get(dstIndex + i + dstStep - 1) == highValue))
/*     */           {
/* 693 */             dstData.put(dstIndex + i, highValue);
/*     */           }
/* 695 */           else dstData.put(dstIndex + i, lowValue);
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 701 */       i = 0;
/* 702 */       if (dstData.get(dstIndex + i) == medValue)
/* 703 */         if ((dstData.get(dstIndex + i + 1) == highValue) || (dstData.get(dstIndex + i + dstStep + 1) == highValue) || (dstData.get(dstIndex + i + dstStep) == highValue))
/*     */         {
/* 706 */           dstData.put(dstIndex + i, highValue);
/*     */         }
/* 708 */         else dstData.put(dstIndex + i, lowValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void clamp(opencv_core.IplImage src, opencv_core.IplImage dst, double min, double max)
/*     */   {
/* 716 */     switch (src.depth()) {
/*     */     case 8:
/* 718 */       ByteBuffer sb = src.getByteBuffer();
/* 719 */       ByteBuffer db = dst.getByteBuffer();
/* 720 */       for (int i = 0; i < sb.capacity(); i++) {
/* 721 */         db.put(i, (byte)(int)Math.max(Math.min(sb.get(i) & 0xFF, max), min));
/*     */       }
/* 723 */       break;
/*     */     case 16:
/* 726 */       ShortBuffer sb = src.getShortBuffer();
/* 727 */       ShortBuffer db = dst.getShortBuffer();
/* 728 */       for (int i = 0; i < sb.capacity(); i++) {
/* 729 */         db.put(i, (short)(int)Math.max(Math.min(sb.get(i) & 0xFFFF, max), min));
/*     */       }
/* 731 */       break;
/*     */     case 32:
/* 734 */       FloatBuffer sb = src.getFloatBuffer();
/* 735 */       FloatBuffer db = dst.getFloatBuffer();
/* 736 */       for (int i = 0; i < sb.capacity(); i++) {
/* 737 */         db.put(i, (float)Math.max(Math.min(sb.get(i), max), min));
/*     */       }
/* 739 */       break;
/*     */     case -2147483640:
/* 742 */       ByteBuffer sb = src.getByteBuffer();
/* 743 */       ByteBuffer db = dst.getByteBuffer();
/* 744 */       for (int i = 0; i < sb.capacity(); i++) {
/* 745 */         db.put(i, (byte)(int)Math.max(Math.min(sb.get(i), max), min));
/*     */       }
/* 747 */       break;
/*     */     case -2147483632:
/* 750 */       ShortBuffer sb = src.getShortBuffer();
/* 751 */       ShortBuffer db = dst.getShortBuffer();
/* 752 */       for (int i = 0; i < sb.capacity(); i++) {
/* 753 */         db.put(i, (short)(int)Math.max(Math.min(sb.get(i), max), min));
/*     */       }
/* 755 */       break;
/*     */     case -2147483616:
/* 758 */       IntBuffer sb = src.getIntBuffer();
/* 759 */       IntBuffer db = dst.getIntBuffer();
/* 760 */       for (int i = 0; i < sb.capacity(); i++) {
/* 761 */         db.put(i, (int)Math.max(Math.min(sb.get(i), max), min));
/*     */       }
/* 763 */       break;
/*     */     case 64:
/* 766 */       DoubleBuffer sb = src.getDoubleBuffer();
/* 767 */       DoubleBuffer db = dst.getDoubleBuffer();
/* 768 */       for (int i = 0; i < sb.capacity(); i++) {
/* 769 */         db.put(i, Math.max(Math.min(sb.get(i), max), min));
/*     */       }
/* 771 */       break;
/*     */     default:
/* 773 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static double norm(double[] v)
/*     */   {
/* 779 */     return norm(v, 2.0D);
/*     */   }
/*     */   public static double norm(double[] v, double p) {
/* 782 */     double norm = 0.0D;
/* 783 */     if (p == 1.0D) {
/* 784 */       for (double e : v)
/* 785 */         norm += Math.abs(e);
/*     */     }
/* 787 */     else if (p == 2.0D) {
/* 788 */       for (double e : v) {
/* 789 */         norm += e * e;
/*     */       }
/* 791 */       norm = Math.sqrt(norm);
/* 792 */     } else if (p == (1.0D / 0.0D)) {
/* 793 */       for (double e : v) {
/* 794 */         e = Math.abs(e);
/* 795 */         if (e > norm)
/* 796 */           norm = e;
/*     */       }
/*     */     }
/* 799 */     else if (p == (-1.0D / 0.0D)) {
/* 800 */       norm = 1.7976931348623157E+308D;
/* 801 */       for (double e : v) {
/* 802 */         e = Math.abs(e);
/* 803 */         if (e < norm)
/* 804 */           norm = e;
/*     */       }
/*     */     }
/*     */     else {
/* 808 */       for (double e : v) {
/* 809 */         norm += Math.pow(Math.abs(e), p);
/*     */       }
/* 811 */       norm = Math.pow(norm, 1.0D / p);
/*     */     }
/* 813 */     return norm;
/*     */   }
/*     */ 
/*     */   public static double norm(opencv_core.CvMat A)
/*     */   {
/* 818 */     return norm(A, 2.0D);
/*     */   }
/*     */   public static double norm(opencv_core.CvMat A, double p) {
/* 821 */     return norm(A, p, null);
/*     */   }
/*     */   public static double norm(opencv_core.CvMat A, double p, opencv_core.CvMat W) {
/* 824 */     double norm = -1.0D;
/*     */ 
/* 826 */     if (p == 1.0D) {
/* 827 */       int cols = A.cols(); int rows = A.rows();
/* 828 */       for (int j = 0; j < cols; j++) {
/* 829 */         double n = 0.0D;
/* 830 */         for (int i = 0; i < rows; i++) {
/* 831 */           n += Math.abs(A.get(i, j));
/*     */         }
/* 833 */         norm = Math.max(n, norm);
/*     */       }
/* 835 */     } else if (p == 2.0D) {
/* 836 */       int size = Math.min(A.rows(), A.cols());
/* 837 */       if ((W == null) || (W.rows() != size) || (W.cols() != 1)) {
/* 838 */         W = opencv_core.CvMat.create(size, 1);
/*     */       }
/* 840 */       opencv_core.cvSVD(A, W, null, null, 0);
/* 841 */       norm = W.get(0);
/* 842 */     } else if (p == (1.0D / 0.0D)) {
/* 843 */       int rows = A.rows(); int cols = A.cols();
/* 844 */       for (int i = 0; i < rows; i++) {
/* 845 */         double n = 0.0D;
/* 846 */         for (int j = 0; j < cols; j++) {
/* 847 */           n += Math.abs(A.get(i, j));
/*     */         }
/* 849 */         norm = Math.max(n, norm);
/*     */       }
/*     */     }
/* 852 */     else if (!$assertionsDisabled) { throw new AssertionError(); }
/*     */ 
/* 854 */     return norm;
/*     */   }
/*     */ 
/*     */   public static double cond(opencv_core.CvMat A) {
/* 858 */     return cond(A, 2.0D);
/*     */   }
/*     */   public static double cond(opencv_core.CvMat A, double p) {
/* 861 */     return cond(A, p, null);
/*     */   }
/*     */   public static double cond(opencv_core.CvMat A, double p, opencv_core.CvMat W) {
/* 864 */     double cond = -1.0D;
/*     */ 
/* 866 */     if (p == 2.0D) {
/* 867 */       int size = Math.min(A.rows(), A.cols());
/* 868 */       if ((W == null) || (W.rows() != size) || (W.cols() != 1)) {
/* 869 */         W = opencv_core.CvMat.create(size, 1);
/*     */       }
/* 871 */       opencv_core.cvSVD(A, W, null, null, 0);
/* 872 */       cond = W.get(0) / W.get(W.length() - 1);
/*     */     }
/*     */     else
/*     */     {
/* 876 */       int rows = A.rows(); int cols = A.cols();
/* 877 */       if ((W == null) || (W.rows() != rows) || (W.cols() != cols)) {
/* 878 */         W = opencv_core.CvMat.create(rows, cols);
/*     */       }
/* 880 */       opencv_core.CvMat Ainv = W;
/* 881 */       opencv_core.cvInvert(A, Ainv);
/* 882 */       cond = norm(A, p) * norm(Ainv, p);
/*     */     }
/* 884 */     return cond;
/*     */   }
/*     */ 
/*     */   public static double median(double[] doubles) {
/* 888 */     double[] sorted = (double[])doubles.clone();
/* 889 */     Arrays.sort(sorted);
/* 890 */     if (doubles.length % 2 == 0) {
/* 891 */       return (sorted[(doubles.length / 2 - 1)] + sorted[(doubles.length / 2)]) / 2.0D;
/*     */     }
/* 893 */     return sorted[(doubles.length / 2)];
/*     */   }
/*     */ 
/*     */   public static <T> T median(T[] objects) {
/* 897 */     Object[] sorted = (Object[])objects.clone();
/* 898 */     Arrays.sort(sorted);
/* 899 */     return sorted[(sorted.length / 2)];
/*     */   }
/*     */ 
/*     */   public static void fractalTriangleWave(double[] line, int i, int j, double a) {
/* 903 */     fractalTriangleWave(line, i, j, a, -1);
/*     */   }
/*     */   public static void fractalTriangleWave(double[] line, int i, int j, double a, int roughness) {
/* 906 */     int m = (j - i) / 2 + i;
/* 907 */     if ((i == j) || (i == m)) {
/* 908 */       return;
/*     */     }
/* 910 */     line[m] = ((line[i] + line[j]) / 2.0D + a);
/* 911 */     if ((roughness > 0) && (line.length > roughness * (j - i))) {
/* 912 */       fractalTriangleWave(line, i, m, 0.0D, roughness);
/* 913 */       fractalTriangleWave(line, m, j, 0.0D, roughness);
/*     */     } else {
/* 915 */       fractalTriangleWave(line, i, m, a / 1.414213562373095D, roughness);
/* 916 */       fractalTriangleWave(line, m, j, -a / 1.414213562373095D, roughness);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void fractalTriangleWave(opencv_core.IplImage image, opencv_core.CvMat H) {
/* 921 */     fractalTriangleWave(image, H, -1);
/*     */   }
/*     */   public static void fractalTriangleWave(opencv_core.IplImage image, opencv_core.CvMat H, int roughness) {
/* 924 */     assert (image.depth() == 32);
/* 925 */     double[] line = new double[image.width()];
/* 926 */     fractalTriangleWave(line, 0, line.length / 2, 1.0D, roughness);
/* 927 */     fractalTriangleWave(line, line.length / 2, line.length - 1, -1.0D, roughness);
/*     */ 
/* 929 */     double[] minMax = { 1.7976931348623157E+308D, 4.9E-324D };
/* 930 */     int height = image.height();
/* 931 */     int width = image.width();
/* 932 */     int channels = image.nChannels();
/* 933 */     int step = image.widthStep();
/* 934 */     int start = 0;
/* 935 */     if (image.roi() != null) {
/* 936 */       height = image.roi().height();
/* 937 */       width = image.roi().width();
/* 938 */       start = image.roi().yOffset() * step / 4 + image.roi().xOffset() * channels;
/*     */     }
/* 940 */     FloatBuffer fb = image.getFloatBuffer(start);
/* 941 */     double[] h = H == null ? null : H.get();
/* 942 */     for (int y = 0; y < height; y++) {
/* 943 */       for (int x = 0; x < width; x++) {
/* 944 */         for (int z = 0; z < channels; z++) {
/* 945 */           double sum = 0.0D;
/* 946 */           if (h == null) {
/* 947 */             sum += line[x];
/*     */           } else {
/* 949 */             double x2 = (h[0] * x + h[1] * y + h[2]) / (h[6] * x + h[7] * y + h[8]);
/* 950 */             while (x2 < 0.0D) {
/* 951 */               x2 += line.length;
/*     */             }
/* 953 */             int xi2 = (int)x2;
/* 954 */             double xn = x2 - xi2;
/* 955 */             sum += line[(xi2 % line.length)] * (1.0D - xn) + line[((xi2 + 1) % line.length)] * xn;
/*     */           }
/*     */ 
/* 958 */           minMax[0] = Math.min(minMax[0], sum);
/* 959 */           minMax[1] = Math.max(minMax[1], sum);
/* 960 */           fb.put(y * step / 4 + x * channels + z, (float)sum);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 965 */     opencv_core.cvConvertScale(image, image, 1.0D / (minMax[1] - minMax[0]), -minMax[0] / (minMax[1] - minMax[0]));
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 970 */     String version = JavaCV.class.getPackage().getImplementationVersion();
/* 971 */     if (version == null) {
/* 972 */       version = "unknown";
/*     */     }
/* 974 */     System.out.println("JavaCV version " + version + "\n" + "Copyright (C) 2009-2013 Samuel Audet <samuel.audet@gmail.com>\n" + "Project site: http://code.google.com/p/javacv/\n\n" + "Licensed under the GNU General Public License version 2 (GPLv2) with Classpath exception.\n" + "Please refer to LICENSE.txt or http://www.gnu.org/licenses/ for details.");
/*     */ 
/* 981 */     System.exit(0);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.JavaCV
 * JD-Core Version:    0.6.2
 */