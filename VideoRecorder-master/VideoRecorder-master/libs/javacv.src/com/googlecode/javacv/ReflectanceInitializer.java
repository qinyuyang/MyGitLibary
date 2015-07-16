/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvPoint;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ public class ReflectanceInitializer
/*     */ {
/*  65 */   private static ThreadLocal<opencv_core.CvMat> mat3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
/*  66 */   private static ThreadLocal<opencv_core.CvMat> mat3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
/*  67 */   private static ThreadLocal<opencv_core.CvMat> mat4x4 = opencv_core.CvMat.createThreadLocal(4, 4);
/*     */   private GNImageAligner.Settings alignerSettings;
/*     */   private int smoothingSize;
/*     */   private double reflectanceMin;
/*     */   private CameraDevice cameraDevice;
/*     */   private ProjectorDevice projectorDevice;
/*     */   private opencv_core.IplImage[] projectorImages;
/*     */ 
/*     */   public ReflectanceInitializer(CameraDevice cameraDevice, ProjectorDevice projectorDevice, int channels, GNImageAligner.Settings alignerSettings)
/*     */   {
/*  38 */     this(cameraDevice, projectorDevice, channels, alignerSettings, 51, 0.01D);
/*     */   }
/*     */ 
/*     */   public ReflectanceInitializer(CameraDevice cameraDevice, ProjectorDevice projectorDevice, int channels, GNImageAligner.Settings alignerSettings, int smoothingSize, double reflectanceMin) {
/*  42 */     this.alignerSettings = alignerSettings;
/*  43 */     this.smoothingSize = smoothingSize;
/*  44 */     this.reflectanceMin = reflectanceMin;
/*  45 */     this.cameraDevice = cameraDevice;
/*  46 */     this.projectorDevice = projectorDevice;
/*  47 */     this.projectorImages = new opencv_core.IplImage[3];
/*     */ 
/*  49 */     for (int i = 0; i < this.projectorImages.length; i++) {
/*  50 */       this.projectorImages[i] = opencv_core.IplImage.create(projectorDevice.imageWidth, projectorDevice.imageHeight, 32, channels);
/*     */     }
/*     */ 
/*  55 */     opencv_core.cvSetZero(this.projectorImages[0]);
/*     */ 
/*  57 */     opencv_core.cvSet(this.projectorImages[1], opencv_core.CvScalar.ONE);
/*     */ 
/*  59 */     opencv_core.CvMat H = (opencv_core.CvMat)mat3x3.get();
/*  60 */     projectorDevice.getRectifyingHomography(cameraDevice, H);
/*  61 */     JavaCV.fractalTriangleWave(this.projectorImages[2], H);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage[] getProjectorImages()
/*     */   {
/*  77 */     return this.projectorImages;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage initializeReflectance(opencv_core.IplImage[] cameraImages, opencv_core.IplImage reflectance, double[] roiPts, double[] gainAmbientLight)
/*     */   {
/*  82 */     int w = cameraImages[0].width();
/*  83 */     int h = cameraImages[0].height();
/*  84 */     int channels = cameraImages[0].nChannels();
/*     */ 
/*  86 */     opencv_core.IplImage mask = opencv_core.IplImage.create(w, h, 8, 1);
/*  87 */     opencv_core.cvSetZero(mask);
/*  88 */     opencv_core.cvFillConvexPoly(mask, new opencv_core.CvPoint((byte)(16 - this.cameraDevice.getMapsPyramidLevel()), roiPts), 4, opencv_core.CvScalar.WHITE, 8, 16);
/*     */ 
/*  92 */     opencv_core.IplImage float1 = cameraImages[0];
/*  93 */     opencv_core.IplImage float2 = cameraImages[1];
/*  94 */     opencv_core.cvCopy(float2, reflectance);
/*  95 */     opencv_imgproc.cvSmooth(float1, float1, 2, this.smoothingSize, 0, 0.0D, 0.0D);
/*  96 */     opencv_imgproc.cvSmooth(float2, float2, 2, this.smoothingSize, 0, 0.0D, 0.0D);
/*     */ 
/*  99 */     opencv_core.cvSub(float2, float1, float2, null);
/*     */ 
/* 103 */     opencv_core.CvMat p = (opencv_core.CvMat)mat3x1.get();
/* 104 */     p.put(new double[] { 1.0D, 1.0D, 1.0D });
/* 105 */     opencv_core.cvMatMul(this.projectorDevice.colorMixingMatrix, p, p);
/*     */     opencv_core.CvMat invp;
/* 107 */     if (float2.nChannels() == 4) {
/* 108 */       opencv_core.CvMat invp = (opencv_core.CvMat)mat4x4.get();
/* 109 */       invp.put(new double[] { 1.0D / p.get(0), 0.0D, 0.0D, 0.0D, 0.0D, 1.0D / p.get(1), 0.0D, 0.0D, 0.0D, 0.0D, 1.0D / p.get(2), 0.0D, 0.0D, 0.0D, 0.0D, 1.0D });
/*     */     }
/*     */     else
/*     */     {
/* 114 */       invp = (opencv_core.CvMat)mat3x3.get();
/* 115 */       invp.put(new double[] { 1.0D / p.get(0), 0.0D, 0.0D, 0.0D, 1.0D / p.get(1), 0.0D, 0.0D, 0.0D, 1.0D / p.get(2) });
/*     */     }
/*     */ 
/* 119 */     opencv_core.cvTransform(float2, float2, invp, null);
/*     */ 
/* 125 */     FloatBuffer fb1 = float1.getFloatBuffer();
/* 126 */     FloatBuffer fb2 = float2.getFloatBuffer();
/* 127 */     ByteBuffer mb = mask.getByteBuffer();
/* 128 */     assert (fb1.capacity() == fb2.capacity() / 3);
/* 129 */     assert (fb1.capacity() == mb.capacity() / 3);
/* 130 */     int[] nPixels = new int[channels];
/* 131 */     int i = 0; for (int j = 0; j < fb1.capacity(); j += channels) {
/* 132 */       for (int z = 0; z < channels; z++) {
/* 133 */         float ra = fb1.get(j + z);
/* 134 */         float r = fb2.get(j + z);
/* 135 */         float a = r == 0.0F ? 0.0F : ra / r;
/* 136 */         fb1.put(j + z, a);
/* 137 */         if ((mb.get(i) != 0) && 
/* 138 */           (r > this.reflectanceMin)) {
/* 139 */           nPixels[z] += 1;
/* 140 */           gainAmbientLight[(z + 1)] += a;
/*     */         }
/*     */       }
/* 131 */       i++;
/*     */     }
/*     */ 
/* 145 */     gainAmbientLight[0] = 1.0D;
/* 146 */     for (int z = 0; z < gainAmbientLight.length - 1; z++) {
/* 147 */       gainAmbientLight[(z + 1)] = (nPixels[z] == 0 ? 0.0D : gainAmbientLight[(z + 1)] / nPixels[z]);
/*     */     }
/*     */ 
/* 152 */     opencv_core.cvAddS(float1, opencv_core.cvScalar(p.get(0), p.get(1), p.get(2), 0.0D), float1, null);
/* 153 */     opencv_core.cvDiv(reflectance, float1, reflectance, 1.0D);
/*     */ 
/* 155 */     opencv_core.cvNot(mask, mask);
/*     */ 
/* 158 */     opencv_imgproc.cvErode(mask, mask, null, 15);
/* 159 */     opencv_core.cvSet(reflectance, opencv_core.CvScalar.ZERO, mask);
/*     */ 
/* 161 */     return reflectance;
/*     */   }
/*     */ 
/*     */   public opencv_core.CvMat initializePlaneParameters(opencv_core.IplImage reflectance, opencv_core.IplImage cameraImage, double[] referencePoints, double[] roiPts, double[] gainAmbientLight)
/*     */   {
/* 166 */     ProCamTransformer transformer = new ProCamTransformer(referencePoints, this.cameraDevice, this.projectorDevice, null);
/* 167 */     transformer.setProjectorImage(this.projectorImages[2], 0, this.alignerSettings.pyramidLevelMax);
/*     */ 
/* 169 */     ProCamTransformer.Parameters parameters = transformer.createParameters();
/*     */ 
/* 173 */     int gainAmbientLightStart = parameters.size() - gainAmbientLight.length;
/* 174 */     int gainAmbientLightEnd = parameters.size();
/* 175 */     for (int i = gainAmbientLightStart; i < gainAmbientLightEnd; i++) {
/* 176 */       parameters.set(i, gainAmbientLight[(i - gainAmbientLightStart)]);
/*     */     }
/* 178 */     ImageAligner aligner = new GNImageAligner(transformer, parameters, reflectance, roiPts, cameraImage, this.alignerSettings);
/*     */ 
/* 181 */     double[] delta = new double[parameters.size() + 1];
/* 182 */     boolean converged = false;
/* 183 */     long iterationsStartTime = System.currentTimeMillis();
/* 184 */     int iterations = 0;
/* 185 */     while ((!converged) && (iterations < 100)) {
/* 186 */       converged = aligner.iterate(delta);
/* 187 */       iterations++;
/*     */     }
/* 189 */     parameters = (ProCamTransformer.Parameters)aligner.getParameters();
/*     */ 
/* 193 */     Logger.getLogger(ReflectanceInitializer.class.getName()).info("iteratingTime = " + (System.currentTimeMillis() - iterationsStartTime) + "  iterations = " + iterations + "  objectiveRMSE = " + (float)aligner.getRMSE());
/*     */ 
/* 196 */     return parameters.getN0();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ReflectanceInitializer
 * JD-Core Version:    0.6.2
 */