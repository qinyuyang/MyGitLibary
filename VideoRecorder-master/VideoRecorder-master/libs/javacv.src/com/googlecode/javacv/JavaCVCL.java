/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacv.cpp.opencv_core;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvSize;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplROI;
/*     */ import com.googlecode.javacv.cpp.opencv_highgui;
/*     */ import com.googlecode.javacv.cpp.opencv_imgproc;
/*     */ import com.jogamp.opencl.CLBuffer;
/*     */ import com.jogamp.opencl.CLCommandQueue;
/*     */ import com.jogamp.opencl.CLContext;
/*     */ import com.jogamp.opencl.CLDevice;
/*     */ import com.jogamp.opencl.CLEventList;
/*     */ import com.jogamp.opencl.CLImage2d;
/*     */ import com.jogamp.opencl.CLImageFormat;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelOrder;
/*     */ import com.jogamp.opencl.CLImageFormat.ChannelType;
/*     */ import com.jogamp.opencl.CLKernel;
/*     */ import com.jogamp.opencl.CLMemory.Map;
/*     */ import com.jogamp.opencl.CLMemory.Mem;
/*     */ import com.jogamp.opencl.CLObject;
/*     */ import com.jogamp.opencl.CLPlatform;
/*     */ import com.jogamp.opencl.CLProgram;
/*     */ import com.jogamp.opencl.gl.CLGLContext;
/*     */ import com.jogamp.opencl.gl.CLGLImage2d;
/*     */ import com.jogamp.opencl.gl.CLGLObject;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Logger;
/*     */ import javax.media.opengl.GL;
/*     */ import javax.media.opengl.GL2;
/*     */ import javax.media.opengl.GLCapabilities;
/*     */ import javax.media.opengl.GLCapabilitiesImmutable;
/*     */ import javax.media.opengl.GLContext;
/*     */ import javax.media.opengl.GLDrawable;
/*     */ import javax.media.opengl.GLDrawableFactory;
/*     */ import javax.media.opengl.GLException;
/*     */ import javax.media.opengl.GLPbuffer;
/*     */ import javax.media.opengl.GLProfile;
/*     */ import javax.media.opengl.glu.GLU;
/*     */ 
/*     */ public class JavaCVCL
/*     */ {
/*     */   public static final String fastCompilerOptions = "-cl-fast-relaxed-math -cl-mad-enable";
/* 184 */   private static final Logger logger = Logger.getLogger(JavaCVCL.class.getName());
/*     */   private final GLPbuffer pbuffer;
/*     */   private final CLContext context;
/*     */   private final CLCommandQueue commandQueue;
/*     */   private final GLU glu;
/*     */   private final CLKernel pyrDownKernel;
/*     */   private final CLKernel remapKernel;
/*     */   private final CLKernel remapBayerKernel;
/*     */ 
/*     */   public JavaCVCL(CLContext context)
/*     */   {
/*  75 */     this(context, context.getDevices()[0]);
/*     */   }
/*     */   public JavaCVCL(CLContext context, CLDevice device) {
/*  78 */     this.pbuffer = null;
/*  79 */     this.context = context;
/*  80 */     this.glu = ((context instanceof CLGLContext) ? new GLU() : null);
/*  81 */     this.commandQueue = device.createCommandQueue();
/*  82 */     CLKernel[] kernels = buildKernels("-cl-fast-relaxed-math -cl-mad-enable", "JavaCV.cl", new String[] { "pyrDown", "remap", "remapBayer" });
/*  83 */     this.pyrDownKernel = kernels[0];
/*  84 */     this.remapKernel = kernels[1];
/*  85 */     this.remapBayerKernel = kernels[2];
/*     */   }
/*     */ 
/*     */   public static GLCapabilities getDefaultGLCapabilities(GLProfile profile) {
/*  89 */     GLCapabilities caps = new GLCapabilities(profile != null ? profile : GLProfile.getDefault());
/*     */ 
/*  91 */     caps.setDoubleBuffered(false);
/*  92 */     return caps;
/*     */   }
/*     */ 
/*     */   public JavaCVCL() {
/*  96 */     this(false);
/*     */   }
/*     */   public JavaCVCL(boolean createPbuffer) {
/*  99 */     this(createPbuffer ? getDefaultGLCapabilities(null) : null, null, null);
/*     */   }
/*     */   public JavaCVCL(GLContext shareWith) {
/* 102 */     this(getDefaultGLCapabilities(shareWith == null ? null : shareWith.getGLDrawable().getGLProfile()), shareWith, null);
/*     */   }
/*     */ 
/*     */   public JavaCVCL(GLCapabilitiesImmutable caps, GLContext shareWith, CLDevice device) {
/* 106 */     GLPbuffer pbuffer = null;
/* 107 */     if (caps != null) {
/* 108 */       GLDrawableFactory factory = GLDrawableFactory.getFactory(caps.getGLProfile());
/* 109 */       if (factory.canCreateGLPbuffer(null))
/*     */         try
/*     */         {
/* 112 */           pbuffer = factory.createGLPbuffer(null, caps, null, 32, 32, shareWith);
/*     */ 
/* 114 */           pbuffer.createContext(shareWith).makeCurrent();
/*     */         } catch (GLException e) {
/* 116 */           logger.warning("Could not create PBuffer: " + e);
/*     */         }
/*     */       else {
/* 119 */         logger.warning("OpenGL implementation does not support PBuffers.");
/*     */       }
/*     */     }
/* 122 */     this.pbuffer = pbuffer;
/*     */ 
/* 124 */     GLContext glContext = GLContext.getCurrent();
/* 125 */     if ((device == null) && (glContext != null))
/*     */     {
/* 129 */       CLDevice[] devices = CLPlatform.getDefault().listCLDevices();
/* 130 */       for (CLDevice d : devices) {
/* 131 */         if (d.isGLMemorySharingSupported()) {
/* 132 */           device = d;
/* 133 */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 140 */     if ((glContext != null) && (device != null))
/*     */     {
/* 143 */       this.context = CLGLContext.create(glContext, new CLDevice[] { device });
/* 144 */       this.glu = GLU.createGLU();
/* 145 */     } else if (device != null) {
/* 146 */       this.context = CLContext.create(new CLDevice[] { device });
/* 147 */       this.glu = null;
/*     */     }
/*     */     else
/*     */     {
/* 151 */       this.context = CLContext.create();
/* 152 */       device = this.context.getDevices()[0];
/* 153 */       this.glu = null;
/*     */     }
/*     */ 
/* 157 */     this.commandQueue = device.createCommandQueue();
/*     */ 
/* 159 */     CLKernel[] kernels = buildKernels("-cl-fast-relaxed-math -cl-mad-enable", "JavaCV.cl", new String[] { "pyrDown", "remap", "remapBayer" });
/* 160 */     this.pyrDownKernel = kernels[0];
/* 161 */     this.remapKernel = kernels[1];
/* 162 */     this.remapBayerKernel = kernels[2];
/*     */   }
/*     */ 
/*     */   public void release() {
/* 166 */     if (!this.context.isReleased()) {
/* 167 */       this.context.release();
/* 168 */       if (this.pbuffer != null) {
/* 169 */         this.pbuffer.getContext().makeCurrent();
/* 170 */         this.pbuffer.getContext().release();
/* 171 */         this.pbuffer.getContext().destroy();
/* 172 */         this.pbuffer.destroy();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/* 177 */   protected void finalize() throws Throwable { super.finalize();
/* 178 */     release();
/*     */   }
/*     */ 
/*     */   public CLContext getCLContext()
/*     */   {
/* 193 */     return this.context;
/*     */   }
/*     */ 
/*     */   public CLCommandQueue getCLCommandQueue() {
/* 197 */     return this.commandQueue;
/*     */   }
/*     */ 
/*     */   public CLGLContext getCLGLContext() {
/* 201 */     return (this.context instanceof CLGLContext) ? (CLGLContext)this.context : null;
/*     */   }
/*     */ 
/*     */   public GLContext getGLContext() {
/* 205 */     return (this.context instanceof CLGLContext) ? ((CLGLContext)this.context).getGLContext() : null;
/*     */   }
/*     */ 
/*     */   public GL getGL() {
/* 209 */     GLContext glContext = getGLContext();
/* 210 */     return glContext != null ? glContext.getGL() : null;
/*     */   }
/*     */ 
/*     */   public GL2 getGL2() {
/* 214 */     GL gl = getGL();
/* 215 */     return gl != null ? gl.getGL2() : null;
/*     */   }
/*     */ 
/*     */   public GLU getGLU() {
/* 219 */     return this.glu;
/*     */   }
/*     */ 
/*     */   public CLKernel buildKernel(String resourceNames, String kernelName) {
/* 223 */     return buildKernels("-cl-fast-relaxed-math -cl-mad-enable", Loader.getCallerClass(2), resourceNames, new String[] { kernelName })[0];
/*     */   }
/*     */   public CLKernel buildKernel(String compilerOptions, String resourceNames, String kernelName) {
/* 226 */     return buildKernels(compilerOptions, Loader.getCallerClass(2), resourceNames, new String[] { kernelName })[0];
/*     */   }
/*     */ 
/*     */   public CLKernel[] buildKernels(String compilerOptions, String resourceNames, String[] kernelNames) {
/* 230 */     return buildKernels(compilerOptions, Loader.getCallerClass(2), resourceNames, kernelNames);
/*     */   }
/*     */ 
/*     */   public CLKernel[] buildKernels(String compilerOptions, Class resourceClass, String resourceNames, String[] kernelNames)
/*     */   {
/*     */     try {
/* 236 */       String[] a = resourceNames.split(":");
/*     */       InputStream s;
/*     */       InputStream s;
/* 237 */       if (a.length == 1) {
/* 238 */         s = resourceClass.getResourceAsStream(a[0]);
/*     */       } else {
/* 240 */         Vector vs = new Vector(a.length);
/* 241 */         for (String name : a) {
/* 242 */           vs.addElement(resourceClass.getResourceAsStream(name));
/*     */         }
/* 244 */         s = new SequenceInputStream(vs.elements());
/*     */       }
/* 246 */       CLProgram program = this.context.createProgram(s);
/*     */ 
/* 248 */       program.build(compilerOptions);
/*     */ 
/* 250 */       assert (program.isExecutable());
/*     */ 
/* 253 */       CLKernel[] kernels = new CLKernel[kernelNames.length];
/* 254 */       for (int i = 0; i < kernelNames.length; i++) {
/* 255 */         kernels[i] = program.createCLKernel(kernelNames[i]);
/*     */       }
/* 257 */       return kernels;
/*     */     } catch (IOException ex) {
/* 259 */       throw ((Error)new LinkageError(ex.toString()).initCause(ex));
/*     */     }
/*     */   }
/*     */ 
/*     */   public CLImage2d createCLImageFrom(opencv_core.IplImage image, CLMemory.Mem[] flags) {
/* 264 */     int width = image.width();
/* 265 */     int height = image.height();
/* 266 */     int pitch = image.widthStep();
/* 267 */     ByteBuffer buffer = image.getByteBuffer();
/* 268 */     CLImageFormat.ChannelOrder order = null;
/* 269 */     CLImageFormat.ChannelType type = null;
/* 270 */     int size = 0;
/* 271 */     switch (image.depth()) { case -2147483640:
/* 272 */       type = CLImageFormat.ChannelType.SNORM_INT8; size = 1; break;
/*     */     case 8:
/* 273 */       type = CLImageFormat.ChannelType.UNORM_INT8; size = 1; break;
/*     */     case -2147483632:
/* 274 */       type = CLImageFormat.ChannelType.SNORM_INT16; size = 2; break;
/*     */     case 16:
/* 275 */       type = CLImageFormat.ChannelType.UNORM_INT16; size = 2; break;
/*     */     case -2147483616:
/* 276 */       type = CLImageFormat.ChannelType.SIGNED_INT32; size = 4; break;
/*     */     case 32:
/* 277 */       type = CLImageFormat.ChannelType.FLOAT; size = 4; break;
/*     */     default:
/* 278 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 280 */     switch (image.nChannels()) { case 1:
/* 281 */       order = CLImageFormat.ChannelOrder.LUMINANCE; break;
/*     */     case 2:
/* 282 */       order = CLImageFormat.ChannelOrder.RG; size *= 2; break;
/*     */     case 3:
/* 283 */       order = CLImageFormat.ChannelOrder.RGB; size *= 3; break;
/*     */     case 4:
/* 284 */       order = CLImageFormat.ChannelOrder.RGBA; size *= 4; break;
/*     */     default:
/* 285 */       if (!$assertionsDisabled) throw new AssertionError();
/*     */       break;
/*     */     }
/* 288 */     if (width != pitch / size) {
/* 289 */       width = pitch / size;
/*     */     }
/* 291 */     CLImageFormat format = new CLImageFormat(order, type);
/* 292 */     return this.context.createImage2d(buffer, width, height, format, flags);
/*     */   }
/*     */ 
/*     */   public CLGLImage2d createCLGLImageFrom(opencv_core.IplImage image, CLMemory.Mem[] flags) {
/* 296 */     GL2 gl = getGL2();
/* 297 */     if (gl == null) {
/* 298 */       return null;
/*     */     }
/*     */ 
/* 301 */     int width = image.width();
/* 302 */     int height = image.height();
/* 303 */     int pitch = image.widthStep();
/*     */ 
/* 305 */     int format = 0;
/* 306 */     int size = 0;
/* 307 */     switch (image.nChannels()) {
/*     */     case 1:
/* 309 */       switch (image.depth()) { case -2147483640:
/* 310 */         format = 36885; size = 1; break;
/*     */       case 8:
/* 311 */         format = 32832; size = 1; break;
/*     */       case -2147483632:
/* 312 */         format = 36889; size = 2; break;
/*     */       case 16:
/* 313 */         format = 32834; size = 2; break;
/*     */       case -2147483616:
/* 314 */         format = 36230; size = 4; break;
/*     */       case 32:
/* 315 */         format = 34840; size = 4; break;
/*     */       default:
/* 316 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/*     */       break;
/*     */     case 2:
/* 320 */       switch (image.depth()) { case -2147483640:
/* 321 */         format = 36757; size = 2; break;
/*     */       case 8:
/* 322 */         format = 33323; size = 2; break;
/*     */       case -2147483632:
/* 323 */         format = 36761; size = 4; break;
/*     */       case 16:
/* 324 */         format = 33324; size = 4; break;
/*     */       case -2147483616:
/* 325 */         format = 33339; size = 8; break;
/*     */       case 32:
/* 326 */         format = 33328; size = 8; break;
/*     */       default:
/* 327 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/*     */       break;
/*     */     case 3:
/* 331 */       switch (image.depth()) { case -2147483640:
/* 332 */         format = 36758; size = 3; break;
/*     */       case 8:
/* 333 */         format = 32849; size = 3; break;
/*     */       case -2147483632:
/* 334 */         format = 36762; size = 6; break;
/*     */       case 16:
/* 335 */         format = 32852; size = 6; break;
/*     */       case -2147483616:
/* 336 */         format = 36227; size = 12; break;
/*     */       case 32:
/* 337 */         format = 34837; size = 12; break;
/*     */       default:
/* 338 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/*     */       break;
/*     */     case 4:
/* 342 */       switch (image.depth()) { case -2147483640:
/* 343 */         format = 36759; size = 4; break;
/*     */       case 8:
/* 344 */         format = 32856; size = 4; break;
/*     */       case -2147483632:
/* 345 */         format = 36763; size = 8; break;
/*     */       case 16:
/* 346 */         format = 32859; size = 8; break;
/*     */       case -2147483616:
/* 347 */         format = 36226; size = 16; break;
/*     */       case 32:
/* 348 */         format = 34836; size = 16; break;
/*     */       default:
/* 349 */         if (!$assertionsDisabled) throw new AssertionError(); break; }
/*     */       break;
/*     */     default:
/* 352 */       if (!$assertionsDisabled) throw new AssertionError();
/*     */       break;
/*     */     }
/* 355 */     if (width != pitch / size) {
/* 356 */       width = pitch / size;
/*     */     }
/* 358 */     int[] renderBuffer = new int[1];
/* 359 */     gl.glGenRenderbuffers(1, renderBuffer, 0);
/* 360 */     gl.glBindRenderbuffer(36161, renderBuffer[0]);
/* 361 */     gl.glRenderbufferStorage(36161, format, width, height);
/* 362 */     return getCLGLContext().createFromGLRenderbuffer(renderBuffer[0], flags);
/*     */   }
/*     */ 
/*     */   public void releaseCLGLImage(CLGLImage2d image) {
/* 366 */     image.release();
/* 367 */     getGL2().glDeleteRenderbuffers(1, new int[] { image.getGLObjectID() }, 0);
/*     */   }
/*     */ 
/*     */   public CLBuffer createPinnedBuffer(int size)
/*     */   {
/* 373 */     CLBuffer pinnedBuffer = this.context.createBuffer(size, new CLMemory.Mem[] { CLMemory.Mem.ALLOCATE_BUFFER });
/* 374 */     ByteBuffer byteBuffer = this.commandQueue.putMapBuffer(pinnedBuffer, CLMemory.Map.READ_WRITE, true);
/* 375 */     pinnedBuffer.use(byteBuffer);
/* 376 */     return pinnedBuffer;
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage createPinnedIplImage(int width, int height, int depth, int channels)
/*     */   {
/* 404 */     return new PinnedIplImage(width, height, depth, channels);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage createIplImageFrom(CLImage2d image) {
/* 408 */     int width = image.width;
/* 409 */     int height = image.height;
/* 410 */     CLImageFormat format = image.getFormat();
/* 411 */     CLImageFormat.ChannelOrder order = format.getImageChannelOrder();
/* 412 */     CLImageFormat.ChannelType type = format.getImageChannelDataType();
/* 413 */     int depth = 0; int channels = 0;
/* 414 */     switch (1.$SwitchMap$com$jogamp$opencl$CLImageFormat$ChannelOrder[order.ordinal()]) {
/*     */     case 1:
/*     */     case 2:
/*     */     case 3:
/*     */     case 4:
/* 419 */       channels = 1;
/* 420 */       break;
/*     */     case 5:
/*     */     case 6:
/*     */     case 7:
/* 424 */       channels = 2;
/* 425 */       break;
/*     */     case 8:
/*     */     case 9:
/* 428 */       channels = 3;
/* 429 */       break;
/*     */     case 10:
/*     */     case 11:
/*     */     case 12:
/*     */     case 13:
/* 434 */       channels = 4;
/* 435 */       break;
/*     */     default:
/* 436 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 438 */     switch (1.$SwitchMap$com$jogamp$opencl$CLImageFormat$ChannelType[type.ordinal()]) { case 1:
/*     */     case 2:
/* 440 */       depth = -2147483640; break;
/*     */     case 3:
/*     */     case 4:
/* 442 */       depth = 8; break;
/*     */     case 5:
/*     */     case 6:
/* 444 */       depth = -2147483632; break;
/*     */     case 7:
/*     */     case 8:
/* 446 */       depth = 16; break;
/*     */     case 9:
/*     */     case 10:
/* 448 */       depth = -2147483616; break;
/*     */     case 11:
/* 449 */       depth = 32; break;
/*     */     case 12:
/*     */     case 13:
/*     */     case 14:
/*     */     case 15:
/*     */     default:
/* 454 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 456 */     return opencv_core.IplImage.create(width, height, depth, channels);
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage readImage(CLImage2d clImg, opencv_core.IplImage iplImage, boolean blocking)
/*     */   {
/* 462 */     if (iplImage == null) {
/* 463 */       iplImage = createIplImageFrom(clImg);
/*     */     }
/* 465 */     int x = 0; int y = 0;
/* 466 */     int width = clImg.width;
/* 467 */     int height = clImg.height;
/* 468 */     int pitch = iplImage.widthStep();
/* 469 */     ByteBuffer buffer = iplImage.getByteBuffer();
/* 470 */     opencv_core.IplROI roi = iplImage.roi();
/* 471 */     if (roi != null) {
/* 472 */       x = roi.xOffset();
/* 473 */       y = roi.yOffset();
/* 474 */       width = roi.width();
/* 475 */       height = roi.height();
/* 476 */       int pixelSize = iplImage.nChannels() * ((iplImage.depth() & 0x7FFFFFFF) / 8);
/* 477 */       buffer = iplImage.getByteBuffer(y * pitch + x * pixelSize);
/*     */     }
/* 479 */     clImg.use(buffer);
/* 480 */     this.commandQueue.putReadImage(clImg, pitch, x, y, width, height, blocking);
/* 481 */     return iplImage;
/*     */   }
/*     */ 
/*     */   public CLImage2d writeImage(CLImage2d clImg, opencv_core.IplImage iplImage, boolean blocking)
/*     */   {
/* 486 */     if (clImg == null) {
/* 487 */       clImg = createCLImageFrom(iplImage, new CLMemory.Mem[0]);
/*     */     }
/* 489 */     int x = 0; int y = 0;
/* 490 */     int width = iplImage.width();
/* 491 */     int height = iplImage.height();
/* 492 */     int pitch = iplImage.widthStep();
/* 493 */     ByteBuffer buffer = iplImage.getByteBuffer();
/* 494 */     opencv_core.IplROI roi = iplImage.roi();
/* 495 */     if (roi != null) {
/* 496 */       x = roi.xOffset();
/* 497 */       y = roi.yOffset();
/* 498 */       width = roi.width();
/* 499 */       height = roi.height();
/* 500 */       int pixelSize = iplImage.nChannels() * ((iplImage.depth() & 0x7FFFFFFF) / 8);
/* 501 */       buffer = iplImage.getByteBuffer(y * pitch + x * pixelSize);
/*     */     }
/* 503 */     clImg.use(buffer);
/* 504 */     this.commandQueue.putWriteImage(clImg, pitch, x, y, width, height, blocking);
/* 505 */     return clImg;
/*     */   }
/*     */ 
/*     */   public void acquireGLObject(CLObject object) {
/* 509 */     if ((object instanceof CLGLObject))
/* 510 */       this.commandQueue.putAcquireGLObject((CLGLObject)object);
/*     */   }
/*     */ 
/*     */   public void releaseGLObject(CLObject object) {
/* 514 */     if ((object instanceof CLGLObject))
/* 515 */       this.commandQueue.putReleaseGLObject((CLGLObject)object);
/*     */   }
/*     */ 
/*     */   public void readBuffer(CLBuffer<?> buffer, boolean blocking)
/*     */   {
/* 520 */     this.commandQueue.putReadBuffer(buffer, blocking);
/*     */   }
/*     */   public void writeBuffer(CLBuffer<?> buffer, boolean blocking) {
/* 523 */     this.commandQueue.putWriteBuffer(buffer, blocking);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkSizeX, long localWorkSizeX)
/*     */   {
/* 528 */     this.commandQueue.put1DRangeKernel(kernel, globalWorkOffsetX, globalWorkSizeX, localWorkSizeX);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkSizeX, long localWorkSizeX, CLEventList events)
/*     */   {
/* 533 */     this.commandQueue.put1DRangeKernel(kernel, globalWorkOffsetX, globalWorkSizeX, localWorkSizeX, events);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkSizeX, long localWorkSizeX, CLEventList condition, CLEventList events)
/*     */   {
/* 539 */     this.commandQueue.put1DRangeKernel(kernel, globalWorkOffsetX, globalWorkSizeX, localWorkSizeX, condition, events);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkSizeX, long globalWorkSizeY, long localWorkSizeX, long localWorkSizeY)
/*     */   {
/* 547 */     this.commandQueue.put2DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkSizeX, globalWorkSizeY, localWorkSizeX, localWorkSizeY);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkSizeX, long globalWorkSizeY, long localWorkSizeX, long localWorkSizeY, CLEventList events)
/*     */   {
/* 556 */     this.commandQueue.put2DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkSizeX, globalWorkSizeY, localWorkSizeX, localWorkSizeY, events);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkSizeX, long globalWorkSizeY, long localWorkSizeX, long localWorkSizeY, CLEventList condition, CLEventList events)
/*     */   {
/* 566 */     this.commandQueue.put2DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkSizeX, globalWorkSizeY, localWorkSizeX, localWorkSizeY, condition, events);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkOffsetZ, long globalWorkSizeX, long globalWorkSizeY, long globalWorkSizeZ, long localWorkSizeX, long localWorkSizeY, long localWorkSizeZ)
/*     */   {
/* 576 */     this.commandQueue.put3DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkOffsetZ, globalWorkSizeX, globalWorkSizeY, globalWorkSizeZ, localWorkSizeX, localWorkSizeY, localWorkSizeZ);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkOffsetZ, long globalWorkSizeX, long globalWorkSizeY, long globalWorkSizeZ, long localWorkSizeX, long localWorkSizeY, long localWorkSizeZ, CLEventList events)
/*     */   {
/* 585 */     this.commandQueue.put3DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkOffsetZ, globalWorkSizeX, globalWorkSizeY, globalWorkSizeZ, localWorkSizeX, localWorkSizeY, localWorkSizeZ, events);
/*     */   }
/*     */ 
/*     */   public void executeKernel(CLKernel kernel, long globalWorkOffsetX, long globalWorkOffsetY, long globalWorkOffsetZ, long globalWorkSizeX, long globalWorkSizeY, long globalWorkSizeZ, long localWorkSizeX, long localWorkSizeY, long localWorkSizeZ, CLEventList condition, CLEventList events)
/*     */   {
/* 595 */     this.commandQueue.put3DRangeKernel(kernel, globalWorkOffsetX, globalWorkOffsetY, globalWorkOffsetZ, globalWorkSizeX, globalWorkSizeY, globalWorkSizeZ, localWorkSizeX, localWorkSizeY, localWorkSizeZ, condition, events);
/*     */   }
/*     */ 
/*     */   public void finish()
/*     */   {
/* 602 */     this.commandQueue.finish();
/*     */   }
/*     */   public void flush() {
/* 605 */     this.commandQueue.flush();
/*     */   }
/*     */ 
/*     */   public static int alignCeil(int x, int n) {
/* 609 */     return (x + n - 1) / n * n;
/*     */   }
/*     */   public static int alignFloor(int x, int n) {
/* 612 */     return x / n * n;
/*     */   }
/*     */ 
/*     */   public void pyrDown(CLImage2d srcImg, CLImage2d dstImg) {
/* 616 */     CLEventList list = null;
/*     */ 
/* 618 */     this.pyrDownKernel.putArg(srcImg).putArg(dstImg).rewind();
/* 619 */     executeKernel(this.pyrDownKernel, 0L, 0L, alignCeil(dstImg.width, 2), alignCeil(dstImg.height, 64), 2L, 64L, list);
/*     */   }
/*     */ 
/*     */   public void remap(CLImage2d srcImg, CLImage2d dstImg, CLImage2d mapxImg, CLImage2d mapyImg)
/*     */   {
/* 628 */     remap(srcImg, dstImg, mapxImg, mapyImg, -1L);
/*     */   }
/*     */   public void remap(CLImage2d srcImg, CLImage2d dstImg, CLImage2d mapxImg, CLImage2d mapyImg, long sensorPattern) {
/* 631 */     CLEventList list = null;
/*     */     CLKernel kernel;
/*     */     CLKernel kernel;
/* 634 */     if (sensorPattern != -1L)
/* 635 */       kernel = this.remapBayerKernel.putArg(srcImg).putArg(dstImg).putArg(mapxImg).putArg(mapyImg).putArg(sensorPattern).rewind();
/*     */     else {
/* 637 */       kernel = this.remapKernel.putArg(srcImg).putArg(dstImg).putArg(mapxImg).putArg(mapyImg).rewind();
/*     */     }
/* 639 */     executeKernel(kernel, 0L, 0L, alignCeil(dstImg.width, 2), alignCeil(dstImg.height, 64), 2L, 64L, list);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 648 */     JavaCVCL context = new JavaCVCL();
/*     */ 
/* 650 */     CLImageFormat[] formats = context.getCLContext().getSupportedImage2dFormats(new CLMemory.Mem[0]);
/* 651 */     for (CLImageFormat f : formats) {
/* 652 */       System.out.println(f);
/*     */     }
/*     */ 
/* 655 */     CameraDevice camera = new CameraDevice("Camera");
/* 656 */     camera.imageWidth = 1280;
/* 657 */     camera.imageHeight = 960;
/* 658 */     camera.cameraMatrix = opencv_core.CvMat.create(3, 3);
/* 659 */     double f = camera.imageWidth * 2.5D;
/* 660 */     camera.cameraMatrix.put(new double[] { f, 0.0D, camera.imageWidth / 2, 0.0D, f, camera.imageHeight / 2, 0.0D, 0.0D, 1.0D });
/*     */ 
/* 663 */     camera.R = opencv_core.CvMat.create(3, 3);
/* 664 */     opencv_core.cvSetIdentity(camera.R);
/* 665 */     camera.T = opencv_core.CvMat.create(3, 1);
/* 666 */     opencv_core.cvSetZero(camera.T);
/* 667 */     camera.distortionCoeffs = opencv_core.CvMat.create(1, 4);
/* 668 */     opencv_core.cvSetZero(camera.distortionCoeffs);
/* 669 */     camera.distortionCoeffs.put(new double[] { 0.2D });
/* 670 */     camera.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
/* 671 */     opencv_core.cvSetIdentity(camera.colorMixingMatrix);
/*     */ 
/* 673 */     opencv_core.IplImage srcImg = opencv_highgui.cvLoadImageRGBA(args[0]);
/*     */ 
/* 675 */     opencv_core.IplImage downDst = opencv_core.IplImage.create(srcImg.width() / 2, srcImg.height() / 2, 8, 4);
/* 676 */     camera.setFixedPointMaps(false);
/* 677 */     camera.setMapsPyramidLevel(1);
/* 678 */     opencv_core.IplImage mapxImg = camera.getUndistortMap1();
/* 679 */     opencv_core.IplImage mapyImg = camera.getUndistortMap2();
/* 680 */     long start = System.nanoTime();
/* 681 */     opencv_imgproc.cvRemap(srcImg, downDst, mapxImg, mapyImg, 9, opencv_core.CvScalar.ZERO);
/* 682 */     System.out.println("cvRemap: " + (System.nanoTime() - start) / 1000000.0D);
/* 683 */     opencv_highgui.cvSaveImage("/tmp/opencv.png", downDst);
/*     */ 
/* 685 */     CLImage2d src = context.createCLImageFrom(srcImg, new CLMemory.Mem[0]);
/*     */ 
/* 687 */     CLImage2d dst = context.createCLImageFrom(downDst, new CLMemory.Mem[0]);
/*     */ 
/* 689 */     CLImage2d mapx = context.createCLImageFrom(mapxImg, new CLMemory.Mem[0]);
/* 690 */     CLImage2d mapy = context.createCLImageFrom(mapyImg, new CLMemory.Mem[0]);
/* 691 */     context.writeImage(src, srcImg, false);
/* 692 */     context.writeImage(mapx, mapxImg, false);
/* 693 */     context.writeImage(mapy, mapyImg, false);
/*     */ 
/* 696 */     context.remap(src, dst, mapx, mapy);
/* 697 */     context.readImage(dst, downDst, true);
/*     */ 
/* 699 */     opencv_highgui.cvSaveImage("/tmp/javacvcl.png", downDst);
/*     */ 
/* 701 */     context.release();
/* 702 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   class PinnedIplImage extends opencv_core.IplImage
/*     */   {
/*     */     final CLBuffer pinnedBuffer;
/*     */ 
/*     */     PinnedIplImage(int width, int height, int depth, int channels)
/*     */     {
/* 381 */       super();
/* 382 */       this.pinnedBuffer = JavaCVCL.this.createPinnedBuffer(imageSize());
/* 383 */       imageData(getByteBuffer());
/*     */     }
/*     */ 
/*     */     public CLBuffer getCLBuffer()
/*     */     {
/* 389 */       return this.pinnedBuffer;
/*     */     }
/*     */ 
/*     */     public ByteBuffer getByteBuffer() {
/* 393 */       return (ByteBuffer)this.pinnedBuffer.getBuffer();
/*     */     }
/*     */ 
/*     */     public void release() {
/* 397 */       JavaCVCL.this.commandQueue.putUnmapMemory(this.pinnedBuffer, getByteBuffer());
/* 398 */       this.pinnedBuffer.release();
/* 399 */       opencv_core.cvReleaseImageHeader(this);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.JavaCVCL
 * JD-Core Version:    0.6.2
 */