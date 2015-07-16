/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui;
/*     */ import com.jogamp.opencl.CLMemory.Mem;
/*     */ import com.jogamp.opencl.gl.CLGLImage2d;
/*     */ import com.jogamp.opengl.util.Gamma;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.DisplayMode;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBuffer;
/*     */ import java.awt.image.DataBufferByte;
/*     */ import java.awt.image.DataBufferDouble;
/*     */ import java.awt.image.DataBufferFloat;
/*     */ import java.awt.image.DataBufferInt;
/*     */ import java.awt.image.DataBufferShort;
/*     */ import java.awt.image.DataBufferUShort;
/*     */ import java.awt.image.SampleModel;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import javax.media.opengl.GL;
/*     */ import javax.media.opengl.GL2;
/*     */ import javax.media.opengl.GLAutoDrawable;
/*     */ import javax.media.opengl.GLCapabilitiesImmutable;
/*     */ import javax.media.opengl.GLContext;
/*     */ import javax.media.opengl.GLEventListener;
/*     */ import javax.media.opengl.awt.GLCanvas;
/*     */ 
/*     */ public class GLCanvasFrame extends CanvasFrame
/*     */ {
/* 132 */   private int[] params = new int[2];
/* 133 */   private Color color = null;
/*     */   private int width;
/*     */   private int height;
/*     */   private int format;
/*     */   private int type;
/* 135 */   private Buffer buffer = null;
/* 136 */   private int frameBuffer = 0; private int renderBuffer = 0;
/*     */ 
/* 138 */   private GLEventListener eventListener = new GLEventListener() {
/*     */     public void init(GLAutoDrawable drawable) {
/* 140 */       GL2 gl = drawable.getGL().getGL2();
/*     */ 
/* 142 */       gl.setSwapInterval(1);
/*     */ 
/* 144 */       if (GLCanvasFrame.this.inverseGamma != 1.0D)
/*     */       {
/* 146 */         Gamma.setDisplayGamma(gl, (float)GLCanvasFrame.this.inverseGamma, 0.0F, 1.0F);
/*     */       }
/* 148 */       gl.glGenFramebuffers(1, GLCanvasFrame.this.params, 0);
/* 149 */       GLCanvasFrame.this.frameBuffer = GLCanvasFrame.this.params[0];
/*     */     }
/*     */     public void dispose(GLAutoDrawable drawable) {
/* 152 */       GL2 gl = drawable.getGL().getGL2();
/*     */ 
/* 154 */       GLCanvasFrame.this.params[0] = GLCanvasFrame.this.frameBuffer;
/* 155 */       gl.glDeleteFramebuffers(1, GLCanvasFrame.this.params, 0);
/* 156 */       if (GLCanvasFrame.this.inverseGamma != 1.0D)
/* 157 */         Gamma.resetDisplayGamma(gl);
/*     */     }
/*     */ 
/*     */     public void display(GLAutoDrawable drawable) {
/* 161 */       GL2 gl = drawable.getGL().getGL2();
/*     */ 
/* 163 */       if (GLCanvasFrame.this.color != null) {
/* 164 */         gl.glClearColor(GLCanvasFrame.this.color.getRed() / 255.0F, GLCanvasFrame.this.color.getGreen() / 255.0F, GLCanvasFrame.this.color.getBlue() / 255.0F, 1.0F);
/* 165 */         gl.glClear(16384);
/* 166 */       } else if (GLCanvasFrame.this.buffer != null) {
/* 167 */         if ((GLCanvasFrame.this.isResizable()) && (GLCanvasFrame.this.needInitialResize)) {
/* 168 */           int w = (int)Math.round(GLCanvasFrame.this.width * GLCanvasFrame.this.initialScale);
/* 169 */           int h = (int)Math.round(GLCanvasFrame.this.height * GLCanvasFrame.this.initialScale);
/* 170 */           GLCanvasFrame.this.setCanvasSize(w, h);
/*     */         }
/* 172 */         gl.glWindowPos2i(0, GLCanvasFrame.this.canvas.getHeight());
/* 173 */         gl.glPixelZoom(GLCanvasFrame.this.canvas.getWidth() / GLCanvasFrame.this.width, -GLCanvasFrame.this.canvas.getHeight() / GLCanvasFrame.this.height);
/*     */ 
/* 175 */         gl.glDrawPixels(GLCanvasFrame.this.width, GLCanvasFrame.this.height, GLCanvasFrame.this.format, GLCanvasFrame.this.type, GLCanvasFrame.this.buffer);
/* 176 */       } else if (GLCanvasFrame.this.renderBuffer > 0) {
/* 177 */         gl.glBindRenderbuffer(36161, GLCanvasFrame.this.renderBuffer);
/* 178 */         gl.glGetRenderbufferParameteriv(36161, 36162, GLCanvasFrame.this.params, 0);
/*     */ 
/* 180 */         gl.glGetRenderbufferParameteriv(36161, 36163, GLCanvasFrame.this.params, 1);
/*     */ 
/* 182 */         if ((GLCanvasFrame.this.isResizable()) && (GLCanvasFrame.this.needInitialResize)) {
/* 183 */           int w = (int)Math.round(GLCanvasFrame.this.params[0] * GLCanvasFrame.this.initialScale);
/* 184 */           int h = (int)Math.round(GLCanvasFrame.this.params[1] * GLCanvasFrame.this.initialScale);
/* 185 */           GLCanvasFrame.this.setCanvasSize(w, h);
/*     */         }
/* 187 */         gl.glBindFramebuffer(36008, GLCanvasFrame.this.frameBuffer);
/* 188 */         gl.glFramebufferRenderbuffer(36008, 36064, 36161, GLCanvasFrame.this.renderBuffer);
/*     */ 
/* 197 */         assert (gl.glCheckFramebufferStatus(36008) == 36053);
/* 198 */         gl.glBlitFramebuffer(0, 0, GLCanvasFrame.this.params[0], GLCanvasFrame.this.params[1], 0, GLCanvasFrame.this.canvas.getHeight(), GLCanvasFrame.this.canvas.getWidth(), 0, 16384, 9729);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
/*     */     {
/*     */     }
/* 138 */   };
/*     */   private static GLCanvasFrame canvasFrame;
/*     */ 
/*     */   public GLCanvasFrame(String title)
/*     */   {
/*  62 */     this(title, 0.0D);
/*     */   }
/*     */   public GLCanvasFrame(String title, double gamma) {
/*  65 */     super(title, gamma);
/*  66 */     init(false, null, null);
/*     */   }
/*     */ 
/*     */   public GLCanvasFrame(String title, GraphicsConfiguration gc, GLCapabilitiesImmutable caps, GLContext shareWith)
/*     */   {
/*  71 */     this(title, gc, caps, shareWith, 0.0D);
/*     */   }
/*     */ 
/*     */   public GLCanvasFrame(String title, GraphicsConfiguration gc, GLCapabilitiesImmutable caps, GLContext shareWith, double gamma) {
/*  75 */     super(title, gc, gamma);
/*  76 */     init(false, caps, shareWith);
/*     */   }
/*     */ 
/*     */   public GLCanvasFrame(String title, int screenNumber, DisplayMode displayMode) throws CanvasFrame.Exception {
/*  80 */     this(title, screenNumber, displayMode, 0.0D);
/*     */   }
/*     */   public GLCanvasFrame(String title, int screenNumber, DisplayMode displayMode, double gamma) throws CanvasFrame.Exception {
/*  83 */     super(title, screenNumber, displayMode, gamma);
/*  84 */     init(true, null, null);
/*     */   }
/*     */ 
/*     */   public GLCanvasFrame(String title, int screenNumber, DisplayMode displayMode, GLCapabilitiesImmutable caps, GLContext shareWith) throws CanvasFrame.Exception
/*     */   {
/*  89 */     this(title, screenNumber, displayMode, caps, shareWith, 0.0D);
/*     */   }
/*     */ 
/*     */   public GLCanvasFrame(String title, int screenNumber, DisplayMode displayMode, GLCapabilitiesImmutable caps, GLContext shareWith, double gamma) throws CanvasFrame.Exception {
/*  93 */     super(title, screenNumber, displayMode, gamma);
/*  94 */     init(true, caps, shareWith);
/*     */   }
/*     */ 
/*     */   private void init(final boolean fullScreen, final GLCapabilitiesImmutable caps, final GLContext shareWith)
/*     */   {
/*  99 */     Runnable r = new Runnable() {
/* 100 */       public void run() { String wasErase = System.setProperty("sun.awt.noerasebackground", "true");
/*     */ 
/* 102 */         GLCanvasFrame.this.canvas = new GLCanvas(caps, shareWith);
/* 103 */         ((GLCanvas)GLCanvasFrame.this.canvas).addGLEventListener(GLCanvasFrame.this.eventListener);
/* 104 */         if (fullScreen) {
/* 105 */           GLCanvasFrame.this.canvas.setSize(GLCanvasFrame.this.getSize());
/* 106 */           GLCanvasFrame.this.needInitialResize = false;
/*     */         } else {
/* 108 */           GLCanvasFrame.this.canvas.setSize(1, 1);
/* 109 */           GLCanvasFrame.this.needInitialResize = true;
/*     */         }
/* 111 */         GLCanvasFrame.this.getContentPane().add(GLCanvasFrame.this.canvas);
/* 112 */         GLCanvasFrame.this.canvas.setVisible(true);
/*     */ 
/* 114 */         if (wasErase != null)
/* 115 */           System.setProperty("sun.awt.noerasebackground", wasErase);
/*     */         else
/* 117 */           System.clearProperty("sun.awt.noerasebackground");
/*     */       }
/*     */     };
/* 121 */     if (EventQueue.isDispatchThread())
/* 122 */       r.run();
/*     */     else
/*     */       try {
/* 125 */         EventQueue.invokeAndWait(r);
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   protected void initCanvas(boolean fullScreen, DisplayMode displayMode, double gamma)
/*     */   {
/*     */   }
/*     */ 
/*     */   public GLCanvas getGLCanvas()
/*     */   {
/* 207 */     return (GLCanvas)this.canvas;
/*     */   }
/*     */ 
/*     */   public void showColor(Color color) {
/* 211 */     this.color = color;
/* 212 */     this.buffer = null;
/* 213 */     getGLCanvas().display();
/*     */   }
/*     */ 
/*     */   public void showImage(opencv_core.IplImage image) {
/* 217 */     showImage(image, false);
/*     */   }
/*     */   public void showImage(opencv_core.IplImage image, boolean flipChannels) {
/* 220 */     if (flipChannels) {
/* 221 */       throw new RuntimeException("GLCanvasFrame does not support channel flipping.");
/*     */     }
/* 223 */     if (image == null) {
/* 224 */       return;
/*     */     }
/* 226 */     this.color = null;
/* 227 */     this.width = image.width();
/* 228 */     this.height = image.height();
/* 229 */     this.buffer = image.getByteBuffer();
/* 230 */     int size = 0;
/* 231 */     switch (image.depth()) { case -2147483640:
/* 232 */       this.type = 5120; size = 1; break;
/*     */     case 8:
/* 233 */       this.type = 5121; size = 1; break;
/*     */     case -2147483632:
/* 234 */       this.type = 5122; size = 2; break;
/*     */     case 16:
/* 235 */       this.type = 5123; size = 2; break;
/*     */     case -2147483616:
/* 236 */       this.type = 5124; size = 4; break;
/*     */     case 32:
/* 237 */       this.type = 5126; size = 4; break;
/*     */     case 64:
/* 238 */       this.type = 5130; size = 8; break;
/*     */     default:
/* 239 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 241 */     switch (image.nChannels()) { case 1:
/* 242 */       this.format = 6409; break;
/*     */     case 2:
/* 243 */       this.format = 33319; break;
/*     */     case 3:
/* 244 */       this.format = 6407; break;
/*     */     case 4:
/* 245 */       this.format = 6408; break;
/*     */     default:
/* 246 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 248 */     getGLCanvas().display();
/*     */   }
/*     */   public void showImage(Image image) {
/* 251 */     if (!(image instanceof BufferedImage)) {
/* 252 */       throw new RuntimeException("GLCanvasFrame does not support " + image + ", BufferedImage required.");
/*     */     }
/* 254 */     showImage((BufferedImage)image);
/*     */   }
/*     */   public void showImage(BufferedImage image) {
/* 257 */     if (image == null) {
/* 258 */       return;
/*     */     }
/* 260 */     this.color = null;
/* 261 */     this.width = image.getWidth();
/* 262 */     this.height = image.getHeight();
/*     */ 
/* 264 */     DataBuffer buffer = image.getRaster().getDataBuffer();
/* 265 */     if ((buffer instanceof DataBufferByte)) {
/* 266 */       this.buffer = ByteBuffer.wrap(((DataBufferByte)buffer).getData());
/* 267 */       this.type = 5121;
/* 268 */     } else if ((buffer instanceof DataBufferDouble)) {
/* 269 */       this.buffer = DoubleBuffer.wrap(((DataBufferDouble)buffer).getData());
/* 270 */       this.type = 5130;
/* 271 */     } else if ((buffer instanceof DataBufferFloat)) {
/* 272 */       this.buffer = FloatBuffer.wrap(((DataBufferFloat)buffer).getData());
/* 273 */       this.type = 5126;
/* 274 */     } else if ((buffer instanceof DataBufferInt)) {
/* 275 */       this.buffer = IntBuffer.wrap(((DataBufferInt)buffer).getData());
/* 276 */       this.type = 5124;
/* 277 */     } else if ((buffer instanceof DataBufferShort)) {
/* 278 */       this.buffer = ShortBuffer.wrap(((DataBufferShort)buffer).getData());
/* 279 */       this.type = 5122;
/* 280 */     } else if ((buffer instanceof DataBufferUShort)) {
/* 281 */       this.buffer = ShortBuffer.wrap(((DataBufferUShort)buffer).getData());
/* 282 */       this.type = 5123;
/*     */     }
/* 284 */     else if (!$assertionsDisabled) { throw new AssertionError(); }
/*     */ 
/* 286 */     switch (image.getSampleModel().getNumBands()) { case 1:
/* 287 */       this.format = 6409; break;
/*     */     case 2:
/* 288 */       this.format = 33319; break;
/*     */     case 3:
/* 289 */       this.format = 6407; break;
/*     */     case 4:
/* 290 */       this.format = 6408; break;
/*     */     default:
/* 291 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 293 */     getGLCanvas().display();
/*     */   }
/*     */   public void showImage(int renderBuffer) {
/* 296 */     if (renderBuffer <= 0) {
/* 297 */       return;
/*     */     }
/* 299 */     this.color = null;
/* 300 */     this.buffer = null;
/* 301 */     this.renderBuffer = renderBuffer;
/* 302 */     getGLCanvas().display();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception
/*     */   {
/* 307 */     EventQueue.invokeAndWait(new Runnable() {
/*     */       public void run() {
/*     */         try {
/* 310 */           GLCanvasFrame.access$1002(new GLCanvasFrame("Some Title"));
/* 311 */           GLCanvasFrame.canvasFrame.setDefaultCloseOperation(3);
/*     */ 
/* 313 */           GLCanvasFrame.canvasFrame.showColor(Color.BLUE);
/*     */         } catch (Exception ex) {
/* 315 */           ex.printStackTrace();
/*     */         }
/*     */       }
/*     */     });
/* 320 */     JavaCVCL context = new JavaCVCL(canvasFrame.getGLCanvas().getContext());
/* 321 */     opencv_core.IplImage image = opencv_highgui.cvLoadImageBGRA("/usr/share/opencv/samples/c/lena.jpg");
/*     */ 
/* 324 */     CLGLImage2d imageCLGL = context.createCLGLImageFrom(image, new CLMemory.Mem[0]);
/*     */ 
/* 326 */     context.acquireGLObject(imageCLGL);
/* 327 */     context.writeImage(imageCLGL, image, true);
/* 328 */     context.releaseGLObject(imageCLGL);
/*     */ 
/* 332 */     canvasFrame.setCanvasScale(0.5D);
/* 333 */     for (int i = 0; i < 1000; i++) {
/* 334 */       canvasFrame.showImage(imageCLGL.getGLObjectID());
/* 335 */       Thread.sleep(10L);
/* 336 */       canvasFrame.showColor(Color.RED);
/* 337 */       Thread.sleep(10L);
/*     */     }
/* 339 */     canvasFrame.waitKey();
/* 340 */     context.release();
/* 341 */     System.exit(0);
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.GLCanvasFrame
 * JD-Core Version:    0.6.2
 */