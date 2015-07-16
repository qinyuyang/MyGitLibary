/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacv.cpp.opencv_calib3d;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSeq;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_flann.Index;
/*     */ import com.googlecode.javacv.cpp.opencv_flann.IndexParams;
/*     */ import com.googlecode.javacv.cpp.opencv_flann.KDTreeIndexParams;
/*     */ import com.googlecode.javacv.cpp.opencv_flann.SearchParams;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import com.googlecode.javacv.cpp.opencv_legacy;
/*     */ import com.googlecode.javacv.cpp.opencv_legacy.CvSURFParams;
/*     */ import com.googlecode.javacv.cpp.opencv_legacy.CvSURFPoint;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ public class ObjectFinder
/*     */ {
/*     */   private Settings settings;
/* 182 */   private static final Logger logger = Logger.getLogger(ObjectFinder.class.getName());
/*     */ 
/* 184 */   private opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();
/* 185 */   private opencv_core.CvMemStorage tempStorage = opencv_core.CvMemStorage.create();
/* 186 */   private opencv_legacy.CvSURFPoint[] objectKeypoints = null; private opencv_legacy.CvSURFPoint[] imageKeypoints = null;
/* 187 */   private FloatBuffer[] objectDescriptors = null; private FloatBuffer[] imageDescriptors = null;
/*     */   private opencv_core.CvMat objectMat;
/*     */   private opencv_core.CvMat imageMat;
/*     */   private opencv_core.CvMat indicesMat;
/*     */   private opencv_core.CvMat distsMat;
/* 189 */   private opencv_flann.Index flannIndex = null;
/* 190 */   private opencv_flann.IndexParams indexParams = null;
/* 191 */   private opencv_flann.SearchParams searchParams = null;
/* 192 */   private opencv_core.CvMat pt1 = null; private opencv_core.CvMat pt2 = null; private opencv_core.CvMat mask = null; private opencv_core.CvMat H = null;
/* 193 */   private ArrayList<Integer> ptpairs = null;
/*     */ 
/*     */   public ObjectFinder(opencv_core.IplImage objectImage)
/*     */   {
/*  57 */     this.settings = new Settings();
/*  58 */     this.settings.objectImage = objectImage;
/*  59 */     setSettings(this.settings);
/*     */   }
/*     */   public ObjectFinder(Settings settings) {
/*  62 */     setSettings(settings);
/*     */   }
/*     */ 
/*     */   public Settings getSettings()
/*     */   {
/* 146 */     return this.settings;
/*     */   }
/*     */   public void setSettings(Settings settings) {
/* 149 */     this.settings = settings;
/*     */ 
/* 151 */     opencv_core.CvSeq keypoints = new opencv_core.CvSeq(null); opencv_core.CvSeq descriptors = new opencv_core.CvSeq(null);
/* 152 */     opencv_core.cvClearMemStorage(this.storage);
/* 153 */     opencv_legacy.cvExtractSURF(settings.objectImage, null, keypoints, descriptors, this.storage, settings.parameters, 0);
/*     */ 
/* 155 */     int total = descriptors.total();
/* 156 */     int size = descriptors.elem_size();
/* 157 */     this.objectKeypoints = new opencv_legacy.CvSURFPoint[total];
/* 158 */     this.objectDescriptors = new FloatBuffer[total];
/* 159 */     for (int i = 0; i < total; i++) {
/* 160 */       this.objectKeypoints[i] = new opencv_legacy.CvSURFPoint(opencv_core.cvGetSeqElem(keypoints, i));
/* 161 */       this.objectDescriptors[i] = opencv_core.cvGetSeqElem(descriptors, i).capacity(size).asByteBuffer().asFloatBuffer();
/*     */     }
/* 163 */     if (settings.useFLANN) {
/* 164 */       int length = this.objectDescriptors[0].capacity();
/* 165 */       this.objectMat = opencv_core.CvMat.create(total, length, 5, 1);
/* 166 */       this.imageMat = opencv_core.CvMat.create(total, length, 5, 1);
/* 167 */       this.indicesMat = opencv_core.CvMat.create(total, 2, 4, 1);
/* 168 */       this.distsMat = opencv_core.CvMat.create(total, 2, 5, 1);
/*     */ 
/* 170 */       this.flannIndex = new opencv_flann.Index();
/* 171 */       this.indexParams = new opencv_flann.KDTreeIndexParams(4);
/* 172 */       this.searchParams = new opencv_flann.SearchParams(64, 0.0F, true);
/*     */     }
/* 174 */     this.pt1 = opencv_core.CvMat.create(1, total, 5, 2);
/* 175 */     this.pt2 = opencv_core.CvMat.create(1, total, 5, 2);
/* 176 */     this.mask = opencv_core.CvMat.create(1, total, 0, 1);
/* 177 */     this.H = opencv_core.CvMat.create(3, 3);
/* 178 */     this.ptpairs = new ArrayList(2 * this.objectDescriptors.length);
/* 179 */     logger.info(total + " object descriptors");
/*     */   }
/*     */ 
/*     */   public double[] find(opencv_core.IplImage image)
/*     */   {
/* 196 */     opencv_core.CvSeq keypoints = new opencv_core.CvSeq(null); opencv_core.CvSeq descriptors = new opencv_core.CvSeq(null);
/* 197 */     opencv_core.cvClearMemStorage(this.tempStorage);
/* 198 */     opencv_legacy.cvExtractSURF(image, null, keypoints, descriptors, this.tempStorage, this.settings.parameters, 0);
/*     */ 
/* 200 */     int total = descriptors.total();
/* 201 */     int size = descriptors.elem_size();
/* 202 */     this.imageKeypoints = new opencv_legacy.CvSURFPoint[total];
/* 203 */     this.imageDescriptors = new FloatBuffer[total];
/* 204 */     for (int i = 0; i < total; i++) {
/* 205 */       this.imageKeypoints[i] = new opencv_legacy.CvSURFPoint(opencv_core.cvGetSeqElem(keypoints, i));
/* 206 */       this.imageDescriptors[i] = opencv_core.cvGetSeqElem(descriptors, i).capacity(size).asByteBuffer().asFloatBuffer();
/*     */     }
/* 208 */     logger.info(total + " image descriptors");
/*     */ 
/* 210 */     int w = this.settings.objectImage.width();
/* 211 */     int h = this.settings.objectImage.height();
/* 212 */     double[] srcCorners = { 0.0D, 0.0D, w, 0.0D, w, h, 0.0D, h };
/* 213 */     double[] dstCorners = locatePlanarObject(this.objectKeypoints, this.objectDescriptors, this.imageKeypoints, this.imageDescriptors, srcCorners);
/*     */ 
/* 215 */     return dstCorners;
/*     */   }
/*     */ 
/*     */   private double compareSURFDescriptors(FloatBuffer d1, FloatBuffer d2, double best) {
/* 219 */     double totalCost = 0.0D;
/* 220 */     assert ((d1.capacity() == d2.capacity()) && (d1.capacity() % 4 == 0));
/* 221 */     for (int i = 0; i < d1.capacity(); i += 4) {
/* 222 */       double t0 = d1.get(i) - d2.get(i);
/* 223 */       double t1 = d1.get(i + 1) - d2.get(i + 1);
/* 224 */       double t2 = d1.get(i + 2) - d2.get(i + 2);
/* 225 */       double t3 = d1.get(i + 3) - d2.get(i + 3);
/* 226 */       totalCost += t0 * t0 + t1 * t1 + t2 * t2 + t3 * t3;
/* 227 */       if (totalCost > best)
/*     */         break;
/*     */     }
/* 230 */     return totalCost;
/*     */   }
/*     */ 
/*     */   private int naiveNearestNeighbor(FloatBuffer vec, int laplacian, opencv_legacy.CvSURFPoint[] modelKeypoints, FloatBuffer[] modelDescriptors)
/*     */   {
/* 235 */     int neighbor = -1;
/* 236 */     double dist1 = 1000000.0D; double dist2 = 1000000.0D;
/*     */ 
/* 238 */     for (int i = 0; i < modelDescriptors.length; i++) {
/* 239 */       opencv_legacy.CvSURFPoint kp = modelKeypoints[i];
/* 240 */       FloatBuffer mvec = modelDescriptors[i];
/* 241 */       if (laplacian == kp.laplacian())
/*     */       {
/* 243 */         double d = compareSURFDescriptors(vec, mvec, dist2);
/* 244 */         if (d < dist1) {
/* 245 */           dist2 = dist1;
/* 246 */           dist1 = d;
/* 247 */           neighbor = i;
/* 248 */         } else if (d < dist2) {
/* 249 */           dist2 = d;
/*     */         }
/*     */       }
/*     */     }
/* 252 */     if (dist1 < this.settings.distanceThreshold * dist2)
/* 253 */       return neighbor;
/* 254 */     return -1;
/*     */   }
/*     */ 
/*     */   private void findPairs(opencv_legacy.CvSURFPoint[] objectKeypoints, FloatBuffer[] objectDescriptors, opencv_legacy.CvSURFPoint[] imageKeypoints, FloatBuffer[] imageDescriptors)
/*     */   {
/* 259 */     for (int i = 0; i < objectDescriptors.length; i++) {
/* 260 */       opencv_legacy.CvSURFPoint kp = objectKeypoints[i];
/* 261 */       FloatBuffer descriptor = objectDescriptors[i];
/* 262 */       int nearestNeighbor = naiveNearestNeighbor(descriptor, kp.laplacian(), imageKeypoints, imageDescriptors);
/* 263 */       if (nearestNeighbor >= 0) {
/* 264 */         this.ptpairs.add(Integer.valueOf(i));
/* 265 */         this.ptpairs.add(Integer.valueOf(nearestNeighbor));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void flannFindPairs(FloatBuffer[] objectDescriptors, FloatBuffer[] imageDescriptors) {
/* 271 */     int length = objectDescriptors[0].capacity();
/*     */ 
/* 273 */     if (this.imageMat.rows() < imageDescriptors.length) {
/* 274 */       this.imageMat = opencv_core.CvMat.create(imageDescriptors.length, length, 5, 1);
/*     */     }
/* 276 */     int imageRows = this.imageMat.rows();
/* 277 */     this.imageMat.rows(imageDescriptors.length);
/*     */ 
/* 280 */     FloatBuffer objectBuf = this.objectMat.getFloatBuffer();
/* 281 */     for (int i = 0; i < objectDescriptors.length; i++) {
/* 282 */       objectBuf.put(objectDescriptors[i]);
/*     */     }
/*     */ 
/* 285 */     FloatBuffer imageBuf = this.imageMat.getFloatBuffer();
/* 286 */     for (int i = 0; i < imageDescriptors.length; i++) {
/* 287 */       imageBuf.put(imageDescriptors[i]);
/*     */     }
/*     */ 
/* 291 */     this.flannIndex.build(this.imageMat, this.indexParams, 1);
/* 292 */     this.flannIndex.knnSearch(this.objectMat, this.indicesMat, this.distsMat, 2, this.searchParams);
/*     */ 
/* 294 */     IntBuffer indicesBuf = this.indicesMat.getIntBuffer();
/* 295 */     FloatBuffer distsBuf = this.distsMat.getFloatBuffer();
/* 296 */     for (int i = 0; i < objectDescriptors.length; i++) {
/* 297 */       if (distsBuf.get(2 * i) < this.settings.distanceThreshold * distsBuf.get(2 * i + 1)) {
/* 298 */         this.ptpairs.add(Integer.valueOf(i));
/* 299 */         this.ptpairs.add(Integer.valueOf(indicesBuf.get(2 * i)));
/*     */       }
/*     */     }
/* 302 */     this.imageMat.rows(imageRows);
/*     */   }
/*     */ 
/*     */   private double[] locatePlanarObject(opencv_legacy.CvSURFPoint[] objectKeypoints, FloatBuffer[] objectDescriptors, opencv_legacy.CvSURFPoint[] imageKeypoints, FloatBuffer[] imageDescriptors, double[] srcCorners)
/*     */   {
/* 308 */     this.ptpairs.clear();
/* 309 */     if (this.settings.useFLANN)
/* 310 */       flannFindPairs(objectDescriptors, imageDescriptors);
/*     */     else {
/* 312 */       findPairs(objectKeypoints, objectDescriptors, imageKeypoints, imageDescriptors);
/*     */     }
/* 314 */     int n = this.ptpairs.size() / 2;
/* 315 */     logger.info(n + " matching pairs found");
/* 316 */     if (n < this.settings.matchesMin) {
/* 317 */       return null;
/*     */     }
/*     */ 
/* 320 */     this.pt1.cols(n);
/* 321 */     this.pt2.cols(n);
/* 322 */     this.mask.cols(n);
/* 323 */     for (int i = 0; i < n; i++) {
/* 324 */       opencv_core.CvPoint2D32f p1 = objectKeypoints[((Integer)this.ptpairs.get(2 * i)).intValue()].pt();
/* 325 */       this.pt1.put(2 * i, p1.x()); this.pt1.put(2 * i + 1, p1.y());
/* 326 */       opencv_core.CvPoint2D32f p2 = imageKeypoints[((Integer)this.ptpairs.get(2 * i + 1)).intValue()].pt();
/* 327 */       this.pt2.put(2 * i, p2.x()); this.pt2.put(2 * i + 1, p2.y());
/*     */     }
/*     */ 
/* 330 */     if (opencv_calib3d.cvFindHomography(this.pt1, this.pt2, this.H, 8, this.settings.ransacReprojThreshold, this.mask) == 0) {
/* 331 */       return null;
/*     */     }
/* 333 */     if (opencv_core.cvCountNonZero(this.mask) < this.settings.matchesMin) {
/* 334 */       return null;
/*     */     }
/*     */ 
/* 337 */     double[] h = this.H.get();
/* 338 */     double[] dstCorners = new double[srcCorners.length];
/* 339 */     for (int i = 0; i < srcCorners.length / 2; i++) {
/* 340 */       double x = srcCorners[(2 * i)]; double y = srcCorners[(2 * i + 1)];
/* 341 */       double Z = 1.0D / (h[6] * x + h[7] * y + h[8]);
/* 342 */       double X = (h[0] * x + h[1] * y + h[2]) * Z;
/* 343 */       double Y = (h[3] * x + h[4] * y + h[5]) * Z;
/* 344 */       dstCorners[(2 * i)] = X;
/* 345 */       dstCorners[(2 * i + 1)] = Y;
/*     */     }
/*     */ 
/* 348 */     this.pt1.cols(objectDescriptors.length);
/* 349 */     this.pt2.cols(objectDescriptors.length);
/* 350 */     this.mask.cols(objectDescriptors.length);
/* 351 */     return dstCorners;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 357 */     String objectFilename = args.length == 2 ? args[0] : "/usr/share/opencv/samples/c/box.png";
/* 358 */     String sceneFilename = args.length == 2 ? args[1] : "/usr/share/opencv/samples/c/box_in_scene.png";
/*     */ 
/* 360 */     opencv_core.IplImage object = opencv_highgui.cvLoadImage(objectFilename, 0);
/* 361 */     opencv_core.IplImage image = opencv_highgui.cvLoadImage(sceneFilename, 0);
/* 362 */     if ((object == null) || (image == null)) {
/* 363 */       System.err.println("Can not load " + objectFilename + " and/or " + sceneFilename);
/* 364 */       System.exit(-1);
/*     */     }
/*     */ 
/* 367 */     opencv_core.IplImage objectColor = opencv_core.IplImage.create(object.width(), object.height(), 8, 3);
/* 368 */     opencv_imgproc.cvCvtColor(object, objectColor, 8);
/*     */ 
/* 370 */     opencv_core.IplImage correspond = opencv_core.IplImage.create(image.width(), object.height() + image.height(), 8, 1);
/* 371 */     opencv_core.cvSetImageROI(correspond, opencv_core.cvRect(0, 0, object.width(), object.height()));
/* 372 */     opencv_core.cvCopy(object, correspond);
/* 373 */     opencv_core.cvSetImageROI(correspond, opencv_core.cvRect(0, object.height(), correspond.width(), correspond.height()));
/* 374 */     opencv_core.cvCopy(image, correspond);
/* 375 */     opencv_core.cvResetImageROI(correspond);
/*     */ 
/* 377 */     Settings settings = new Settings();
/* 378 */     settings.objectImage = object;
/* 379 */     settings.useFLANN = true;
/* 380 */     settings.ransacReprojThreshold = 5.0D;
/* 381 */     ObjectFinder finder = new ObjectFinder(settings);
/*     */ 
/* 383 */     long start = System.currentTimeMillis();
/* 384 */     double[] dst_corners = finder.find(image);
/* 385 */     System.out.println("Finding time = " + (System.currentTimeMillis() - start) + " ms");
/*     */ 
/* 387 */     if (dst_corners != null) {
/* 388 */       for (int i = 0; i < 4; i++) {
/* 389 */         int j = (i + 1) % 4;
/* 390 */         int x1 = (int)Math.round(dst_corners[(2 * i)]);
/* 391 */         int y1 = (int)Math.round(dst_corners[(2 * i + 1)]);
/* 392 */         int x2 = (int)Math.round(dst_corners[(2 * j)]);
/* 393 */         int y2 = (int)Math.round(dst_corners[(2 * j + 1)]);
/* 394 */         opencv_core.cvLine(correspond, opencv_core.cvPoint(x1, y1 + object.height()), opencv_core.cvPoint(x2, y2 + object.height()), opencv_core.CvScalar.WHITE, 1, 8, 0);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 400 */     for (int i = 0; i < finder.ptpairs.size(); i += 2) {
/* 401 */       opencv_core.CvPoint2D32f pt1 = finder.objectKeypoints[((Integer)finder.ptpairs.get(i)).intValue()].pt();
/* 402 */       opencv_core.CvPoint2D32f pt2 = finder.imageKeypoints[((Integer)finder.ptpairs.get(i + 1)).intValue()].pt();
/* 403 */       opencv_core.cvLine(correspond, opencv_core.cvPointFrom32f(pt1), opencv_core.cvPoint(Math.round(pt2.x()), Math.round(pt2.y() + object.height())), opencv_core.CvScalar.WHITE, 1, 8, 0);
/*     */     }
/*     */ 
/* 408 */     CanvasFrame objectFrame = new CanvasFrame("Object");
/* 409 */     CanvasFrame correspondFrame = new CanvasFrame("Object Correspond");
/*     */ 
/* 411 */     correspondFrame.showImage(correspond);
/* 412 */     for (int i = 0; i < finder.objectKeypoints.length; i++) {
/* 413 */       opencv_legacy.CvSURFPoint r = finder.objectKeypoints[i];
/* 414 */       opencv_core.CvPoint center = opencv_core.cvPointFrom32f(r.pt());
/* 415 */       int radius = Math.round(r.size() * 1.2F / 9.0F * 2.0F);
/* 416 */       opencv_core.cvCircle(objectColor, center, radius, opencv_core.CvScalar.RED, 1, 8, 0);
/*     */     }
/* 418 */     objectFrame.showImage(objectColor);
/*     */ 
/* 420 */     objectFrame.waitKey();
/*     */ 
/* 422 */     objectFrame.dispose();
/* 423 */     correspondFrame.dispose();
/*     */   }
/*     */ 
/*     */   public static class Settings extends BaseChildSettings
/*     */   {
/*  66 */     opencv_core.IplImage objectImage = null;
/*  67 */     opencv_legacy.CvSURFParams parameters = opencv_legacy.cvSURFParams(500.0D, 1);
/*  68 */     double distanceThreshold = 0.6D;
/*  69 */     int matchesMin = 4;
/*  70 */     double ransacReprojThreshold = 1.0D;
/*  71 */     boolean useFLANN = false;
/*     */ 
/*     */     public opencv_core.IplImage getObjectImage() {
/*  74 */       return this.objectImage;
/*     */     }
/*     */     public void setObjectImage(opencv_core.IplImage objectImage) {
/*  77 */       this.objectImage = objectImage;
/*     */     }
/*     */ 
/*     */     public boolean isExtended() {
/*  81 */       return this.parameters.extended() != 0;
/*     */     }
/*     */     public void setExtended(boolean extended) {
/*  84 */       this.parameters.extended(extended ? 1 : 0);
/*     */     }
/*     */ 
/*     */     public boolean isUpright() {
/*  88 */       return this.parameters.upright() != 0;
/*     */     }
/*     */     public void setUpright(boolean upright) {
/*  91 */       this.parameters.upright(upright ? 1 : 0);
/*     */     }
/*     */ 
/*     */     public double getHessianThreshold() {
/*  95 */       return this.parameters.hessianThreshold();
/*     */     }
/*     */     public void setHessianThreshold(double hessianThreshold) {
/*  98 */       this.parameters.hessianThreshold(hessianThreshold);
/*     */     }
/*     */ 
/*     */     public int getnOctaves() {
/* 102 */       return this.parameters.nOctaves();
/*     */     }
/*     */     public void setnOctaves(int nOctaves) {
/* 105 */       this.parameters.nOctaves(nOctaves);
/*     */     }
/*     */ 
/*     */     public int getnOctaveLayers() {
/* 109 */       return this.parameters.nOctaveLayers();
/*     */     }
/*     */     public void setnOctaveLayers(int nOctaveLayers) {
/* 112 */       this.parameters.nOctaveLayers(nOctaveLayers);
/*     */     }
/*     */ 
/*     */     public double getDistanceThreshold() {
/* 116 */       return this.distanceThreshold;
/*     */     }
/*     */     public void setDistanceThreshold(double distanceThreshold) {
/* 119 */       this.distanceThreshold = distanceThreshold;
/*     */     }
/*     */ 
/*     */     public int getMatchesMin() {
/* 123 */       return this.matchesMin;
/*     */     }
/*     */     public void setMatchesMin(int matchesMin) {
/* 126 */       this.matchesMin = matchesMin;
/*     */     }
/*     */ 
/*     */     public double getRansacReprojThreshold() {
/* 130 */       return this.ransacReprojThreshold;
/*     */     }
/*     */     public void setRansacReprojThreshold(double ransacReprojThreshold) {
/* 133 */       this.ransacReprojThreshold = ransacReprojThreshold;
/*     */     }
/*     */ 
/*     */     public boolean isUseFLANN() {
/* 137 */       return this.useFLANN;
/*     */     }
/*     */     public void setUseFLANN(boolean useFLANN) {
/* 140 */       this.useFLANN = useFLANN;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ObjectFinder
 * JD-Core Version:    0.6.2
 */