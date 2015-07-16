/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class IPCameraFrameGrabber extends FrameGrabber
/*     */ {
/*     */   private URL url;
/*     */   private URLConnection connection;
/*     */   private InputStream input;
/*     */   private Map<String, List<String>> headerfields;
/*     */   private String boundryKey;
/*  54 */   private opencv_core.IplImage decoded = null;
/*     */ 
/*     */   public IPCameraFrameGrabber(String urlstr) throws MalformedURLException {
/*  57 */     this.url = new URL(urlstr);
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/*     */     try
/*     */     {
/*  64 */       this.connection = this.url.openConnection();
/*  65 */       this.headerfields = this.connection.getHeaderFields();
/*  66 */       if (this.headerfields.containsKey("Content-Type")) {
/*  67 */         List ct = (List)this.headerfields.get("Content-Type");
/*  68 */         for (int i = 0; i < ct.size(); i++) {
/*  69 */           String key = (String)ct.get(i);
/*  70 */           int j = key.indexOf("boundary=");
/*  71 */           if (j != -1) {
/*  72 */             this.boundryKey = key.substring(j + 9);
/*     */           }
/*     */         }
/*     */       }
/*  76 */       this.input = this.connection.getInputStream();
/*     */     } catch (IOException e) {
/*  78 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception
/*     */   {
/*     */     try {
/*  85 */       this.input.close();
/*  86 */       this.input = null;
/*  87 */       this.connection = null;
/*  88 */       this.url = null;
/*  89 */       if (this.decoded != null)
/*  90 */         opencv_core.cvReleaseImage(this.decoded);
/*     */     }
/*     */     catch (IOException e) {
/*  93 */       throw new FrameGrabber.Exception(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception
/*     */   {
/*     */     try {
/* 104 */       byte[] b = readImage();
/* 105 */       opencv_core.CvMat mat = opencv_core.cvMat(1, b.length, opencv_core.CV_8UC1, new BytePointer(b));
/* 106 */       if (this.decoded != null) {
/* 107 */         opencv_core.cvReleaseImage(this.decoded);
/*     */       }
/* 109 */       return this.decoded = opencv_highgui.cvDecodeImage(mat);
/*     */     } catch (IOException e) {
/* 111 */       throw new FrameGrabber.Exception(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public BufferedImage grabBufferedImage() throws IOException {
/* 116 */     BufferedImage bi = ImageIO.read(new ByteArrayInputStream(readImage()));
/* 117 */     return bi;
/*     */   }
/*     */ 
/*     */   byte[] readImage() throws IOException {
/* 121 */     byte[] buffer = new byte[4096];
/* 122 */     int n = -1;
/* 123 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */ 
/* 125 */     StringBuffer sb = new StringBuffer();
/* 126 */     int total = 0;
/*     */     int c;
/* 129 */     while ((c = this.input.read()) != -1)
/*     */     {
/*     */       String subheader;
/*     */       int contentLength;
/*     */       int c0;
/*     */       int c1;
/* 130 */       if (c > 0) {
/* 131 */         sb.append((char)c);
/* 132 */         if (c == 13) {
/* 133 */           sb.append((char)this.input.read());
/* 134 */           c = this.input.read();
/* 135 */           sb.append((char)c);
/* 136 */           if (c == 13) {
/* 137 */             sb.append((char)this.input.read());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 145 */     subheader = sb.toString();
/*     */ 
/* 147 */     contentLength = -1;
/*     */ 
/* 151 */     c0 = subheader.indexOf("Content-Length: ");
/* 152 */     c1 = subheader.indexOf('\r', c0);
/*     */ 
/* 154 */     if (c0 < 0)
/*     */     {
/* 156 */       return null;
/*     */     }
/*     */ 
/* 159 */     c0 += 16;
/* 160 */     contentLength = Integer.parseInt(subheader.substring(c0, c1).trim());
/*     */ 
/* 164 */     if (contentLength > buffer.length) {
/* 165 */       buffer = new byte[contentLength];
/*     */     }
/*     */ 
/* 168 */     n = -1;
/* 169 */     total = 0;
/* 170 */     while ((n = this.input.read(buffer, 0, contentLength - total)) != -1) {
/* 171 */       total += n;
/* 172 */       baos.write(buffer, 0, n);
/*     */ 
/* 174 */       if (total == contentLength) {
/* 175 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 179 */     baos.flush();
/*     */ 
/* 181 */     this.input.read();
/* 182 */     this.input.read();
/* 183 */     this.input.read();
/* 184 */     this.input.read();
/*     */ 
/* 186 */     return baos.toByteArray();
/*     */   }
/*     */ 
/*     */   public void release()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.IPCameraFrameGrabber
 * JD-Core Version:    0.6.2
 */