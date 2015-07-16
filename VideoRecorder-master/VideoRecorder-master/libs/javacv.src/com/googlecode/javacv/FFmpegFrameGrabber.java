/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.PointerPointer;
/*     */ import com.googlecode.javacv.cpp.avcodec;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVCodec;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVCodecContext;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVPacket;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVPicture;
/*     */ import com.googlecode.javacv.cpp.avdevice;
/*     */ import com.googlecode.javacv.cpp.avformat;
/*     */ import com.googlecode.javacv.cpp.avformat.AVFormatContext;
/*     */ import com.googlecode.javacv.cpp.avformat.AVInputFormat;
/*     */ import com.googlecode.javacv.cpp.avformat.AVStream;
/*     */ import com.googlecode.javacv.cpp.avutil;
/*     */ import com.googlecode.javacv.cpp.avutil.AVDictionary;
/*     */ import com.googlecode.javacv.cpp.avutil.AVFrame;
/*     */ import com.googlecode.javacv.cpp.avutil.AVRational;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.swscale;
/*     */ import com.googlecode.javacv.cpp.swscale.SwsContext;
/*     */ import java.io.File;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class FFmpegFrameGrabber extends FrameGrabber
/*     */ {
/*     */   private static FrameGrabber.Exception loadingException;
/*     */   private String filename;
/*     */   private avformat.AVFormatContext oc;
/*     */   private avformat.AVStream video_st;
/*     */   private avformat.AVStream audio_st;
/*     */   private avcodec.AVCodecContext video_c;
/*     */   private avcodec.AVCodecContext audio_c;
/*     */   private avutil.AVFrame picture;
/*     */   private avutil.AVFrame picture_rgb;
/*     */   private BytePointer buffer_rgb;
/*     */   private avutil.AVFrame samples_frame;
/*     */   private BytePointer[] samples_ptr;
/*     */   private Buffer[] samples_buf;
/*     */   private avcodec.AVPacket pkt;
/*     */   private avcodec.AVPacket pkt2;
/*     */   private int sizeof_pkt;
/*     */   private int[] got_frame;
/*     */   private swscale.SwsContext img_convert_ctx;
/*     */   private opencv_core.IplImage return_image;
/*     */   private boolean frameGrabbed;
/*     */   private Frame frame;
/*     */ 
/*     */   public static String[] getDeviceDescriptions()
/*     */     throws FrameGrabber.Exception
/*     */   {
/*  72 */     tryLoad();
/*  73 */     throw new UnsupportedOperationException("Device enumeration not support by FFmpeg.");
/*     */   }
/*     */   public static FFmpegFrameGrabber createDefault(File deviceFile) throws FrameGrabber.Exception {
/*  76 */     return new FFmpegFrameGrabber(deviceFile); } 
/*  77 */   public static FFmpegFrameGrabber createDefault(String devicePath) throws FrameGrabber.Exception { return new FFmpegFrameGrabber(devicePath); } 
/*  78 */   public static FFmpegFrameGrabber createDefault(int deviceNumber) throws FrameGrabber.Exception { return null; }
/*     */ 
/*     */   public static void tryLoad() throws FrameGrabber.Exception
/*     */   {
/*  82 */     if (loadingException != null)
/*  83 */       throw loadingException;
/*     */     try
/*     */     {
/*  86 */       Loader.load(avutil.class);
/*  87 */       Loader.load(avcodec.class);
/*  88 */       Loader.load(avformat.class);
/*  89 */       Loader.load(avdevice.class);
/*  90 */       Loader.load(swscale.class);
/*     */     } catch (Throwable t) {
/*  92 */       if ((t instanceof FrameGrabber.Exception)) {
/*  93 */         throw (FFmpegFrameGrabber.loadingException = (FrameGrabber.Exception)t);
/*     */       }
/*  95 */       throw (FFmpegFrameGrabber.loadingException = new FrameGrabber.Exception("Failed to load " + FFmpegFrameGrabber.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public FFmpegFrameGrabber(File file)
/*     */   {
/* 110 */     this(file.getAbsolutePath());
/*     */   }
/*     */   public FFmpegFrameGrabber(String filename) {
/* 113 */     this.filename = filename;
/*     */   }
/*     */   public void release() throws FrameGrabber.Exception {
/* 116 */     synchronized (avcodec.class) {
/* 117 */       releaseUnsafe();
/*     */     }
/*     */   }
/*     */ 
/* 121 */   public void releaseUnsafe() throws FrameGrabber.Exception { if ((this.pkt != null) && (this.pkt2 != null)) {
/* 122 */       if (this.pkt2.size() > 0) {
/* 123 */         avcodec.av_free_packet(this.pkt);
/*     */       }
/* 125 */       this.pkt = (this.pkt2 = null);
/*     */     }
/*     */ 
/* 129 */     if (this.buffer_rgb != null) {
/* 130 */       avutil.av_free(this.buffer_rgb);
/* 131 */       this.buffer_rgb = null;
/*     */     }
/* 133 */     if (this.picture_rgb != null) {
/* 134 */       avcodec.avcodec_free_frame(this.picture_rgb);
/* 135 */       this.picture_rgb = null;
/*     */     }
/*     */ 
/* 139 */     if (this.picture != null) {
/* 140 */       avcodec.avcodec_free_frame(this.picture);
/* 141 */       this.picture = null;
/*     */     }
/*     */ 
/* 145 */     if (this.video_c != null) {
/* 146 */       avcodec.avcodec_close(this.video_c);
/* 147 */       this.video_c = null;
/*     */     }
/*     */ 
/* 151 */     if (this.samples_frame != null) {
/* 152 */       avcodec.avcodec_free_frame(this.samples_frame);
/* 153 */       this.samples_frame = null;
/*     */     }
/*     */ 
/* 157 */     if (this.audio_c != null) {
/* 158 */       avcodec.avcodec_close(this.audio_c);
/* 159 */       this.audio_c = null;
/*     */     }
/*     */ 
/* 163 */     if ((this.oc != null) && (!this.oc.isNull())) {
/* 164 */       avformat.avformat_close_input(this.oc);
/* 165 */       this.oc = null;
/*     */     }
/*     */ 
/* 168 */     if (this.img_convert_ctx != null) {
/* 169 */       swscale.sws_freeContext(this.img_convert_ctx);
/* 170 */       this.img_convert_ctx = null;
/*     */     }
/*     */ 
/* 173 */     this.got_frame = null;
/* 174 */     this.return_image = null;
/* 175 */     this.frameGrabbed = false;
/* 176 */     this.frame = null;
/* 177 */     this.timestamp = 0L;
/* 178 */     this.frameNumber = 0; }
/*     */ 
/*     */   protected void finalize() throws Throwable {
/* 181 */     super.finalize();
/* 182 */     release();
/*     */   }
/*     */ 
/*     */   public double getGamma()
/*     */   {
/* 204 */     if (this.gamma == 0.0D) {
/* 205 */       return 2.2D;
/*     */     }
/* 207 */     return this.gamma;
/*     */   }
/*     */ 
/*     */   public String getFormat()
/*     */   {
/* 212 */     if (this.oc == null) {
/* 213 */       return super.getFormat();
/*     */     }
/* 215 */     return this.oc.iformat().name().getString();
/*     */   }
/*     */ 
/*     */   public int getImageWidth()
/*     */   {
/* 220 */     return this.return_image == null ? super.getImageWidth() : this.return_image.width();
/*     */   }
/*     */ 
/*     */   public int getImageHeight() {
/* 224 */     return this.return_image == null ? super.getImageHeight() : this.return_image.height();
/*     */   }
/*     */ 
/*     */   public int getAudioChannels() {
/* 228 */     return this.audio_c == null ? super.getAudioChannels() : this.audio_c.channels();
/*     */   }
/*     */ 
/*     */   public int getPixelFormat() {
/* 232 */     if ((this.imageMode == FrameGrabber.ImageMode.COLOR) || (this.imageMode == FrameGrabber.ImageMode.GRAY)) {
/* 233 */       if (this.pixelFormat == -1) {
/* 234 */         return this.imageMode == FrameGrabber.ImageMode.COLOR ? 3 : 8;
/*     */       }
/* 236 */       return this.pixelFormat;
/*     */     }
/* 238 */     if (this.video_c != null) {
/* 239 */       return this.video_c.pix_fmt();
/*     */     }
/* 241 */     return super.getPixelFormat();
/*     */   }
/*     */ 
/*     */   public double getFrameRate()
/*     */   {
/* 246 */     if (this.video_st == null) {
/* 247 */       return super.getFrameRate();
/*     */     }
/* 249 */     avutil.AVRational r = this.video_st.r_frame_rate();
/* 250 */     return r.num() / r.den();
/*     */   }
/*     */ 
/*     */   public int getSampleFormat()
/*     */   {
/* 255 */     return this.audio_c == null ? super.getSampleFormat() : this.audio_c.sample_fmt();
/*     */   }
/*     */ 
/*     */   public int getSampleRate() {
/* 259 */     return this.audio_c == null ? super.getSampleRate() : this.audio_c.sample_rate();
/*     */   }
/*     */ 
/*     */   public void setFrameNumber(int frameNumber) throws FrameGrabber.Exception
/*     */   {
/* 264 */     setTimestamp(Math.round(1000000L * frameNumber / getFrameRate()));
/*     */   }
/*     */ 
/*     */   public void setTimestamp(long timestamp) throws FrameGrabber.Exception
/*     */   {
/* 269 */     if ((this.oc == null) || (this.video_c == null)) {
/* 270 */       super.setTimestamp(timestamp);
/*     */     } else {
/* 272 */       timestamp = timestamp * 1000000L / 1000000L;
/*     */ 
/* 274 */       if (this.oc.start_time() != avutil.AV_NOPTS_VALUE)
/* 275 */         timestamp += this.oc.start_time();
/*     */       int ret;
/* 277 */       if ((ret = avformat.avformat_seek_file(this.oc, -1, -9223372036854775808L, timestamp, 9223372036854775807L, 1)) < 0) {
/* 278 */         throw new FrameGrabber.Exception("avformat_seek_file() error " + ret + ": Could not seek file to timestamp " + timestamp + ".");
/*     */       }
/* 280 */       avcodec.avcodec_flush_buffers(this.video_c);
/* 281 */       if (this.audio_c != null) {
/* 282 */         avcodec.avcodec_flush_buffers(this.audio_c);
/*     */       }
/* 284 */       if (this.pkt2.size() > 0) {
/* 285 */         this.pkt2.size(0);
/* 286 */         avcodec.av_free_packet(this.pkt);
/*     */       }
/* 288 */       while ((this.timestamp > timestamp) && (grab(false) != null));
/* 291 */       while ((this.timestamp < timestamp) && (grab(false) != null));
/* 294 */       this.frameGrabbed = (this.timestamp >= timestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getLengthInFrames()
/*     */   {
/* 300 */     return (int)(getLengthInTime() * getFrameRate() / 1000000.0D);
/*     */   }
/*     */   public long getLengthInTime() {
/* 303 */     return this.oc.duration() * 1000000L / 1000000L;
/*     */   }
/*     */ 
/*     */   public void start() throws FrameGrabber.Exception {
/* 307 */     synchronized (avcodec.class) {
/* 308 */       startUnsafe();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void startUnsafe() throws FrameGrabber.Exception {
/* 313 */     this.img_convert_ctx = null;
/* 314 */     this.oc = new avformat.AVFormatContext(null);
/* 315 */     this.video_c = null;
/* 316 */     this.audio_c = null;
/* 317 */     this.pkt = new avcodec.AVPacket();
/* 318 */     this.pkt2 = new avcodec.AVPacket();
/* 319 */     this.sizeof_pkt = this.pkt.sizeof();
/* 320 */     this.got_frame = new int[1];
/* 321 */     this.return_image = null;
/* 322 */     this.frameGrabbed = false;
/* 323 */     this.frame = new Frame();
/* 324 */     this.timestamp = 0L;
/* 325 */     this.frameNumber = 0;
/*     */ 
/* 327 */     this.pkt2.size(0);
/*     */ 
/* 330 */     avformat.AVInputFormat f = null;
/* 331 */     if ((this.format != null) && (this.format.length() > 0) && 
/* 332 */       ((f = avformat.av_find_input_format(this.format)) == null)) {
/* 333 */       throw new FrameGrabber.Exception("av_find_input_format() error: Could not find input format \"" + this.format + "\".");
/*     */     }
/*     */ 
/* 336 */     avutil.AVDictionary options = new avutil.AVDictionary(null);
/* 337 */     if (this.frameRate > 0.0D) {
/* 338 */       avutil.AVRational r = avutil.av_d2q(this.frameRate, 1001000);
/* 339 */       avutil.av_dict_set(options, "framerate", r.num() + "/" + r.den(), 0);
/*     */     }
/* 341 */     if (this.imageMode != FrameGrabber.ImageMode.RAW) {
/* 342 */       avutil.av_dict_set(options, "pixel_format", this.imageMode == FrameGrabber.ImageMode.COLOR ? "bgr24" : "gray8", 0);
/*     */     }
/* 344 */     if ((this.imageWidth > 0) && (this.imageHeight > 0)) {
/* 345 */       avutil.av_dict_set(options, "video_size", this.imageWidth + "x" + this.imageHeight, 0);
/*     */     }
/* 347 */     if (this.sampleRate > 0) {
/* 348 */       avutil.av_dict_set(options, "sample_rate", "" + this.sampleRate, 0);
/*     */     }
/* 350 */     if (this.audioChannels > 0)
/* 351 */       avutil.av_dict_set(options, "channels", "" + this.audioChannels, 0);
/*     */     int ret;
/* 353 */     if ((ret = avformat.avformat_open_input(this.oc, this.filename, f, options)) < 0) {
/* 354 */       throw new FrameGrabber.Exception("avformat_open_input() error " + ret + ": Could not open input \"" + this.filename + "\". (Has setFormat() been called?)");
/*     */     }
/* 356 */     avutil.av_dict_free(options);
/*     */ 
/* 359 */     if ((ret = avformat.avformat_find_stream_info(this.oc, (PointerPointer)null)) < 0) {
/* 360 */       throw new FrameGrabber.Exception("avformat_find_stream_info() error " + ret + ": Could not find stream information.");
/*     */     }
/*     */ 
/* 364 */     avformat.av_dump_format(this.oc, 0, this.filename, 0);
/*     */ 
/* 367 */     this.video_st = (this.audio_st = null);
/* 368 */     int nb_streams = this.oc.nb_streams();
/* 369 */     for (int i = 0; i < nb_streams; i++) {
/* 370 */       avformat.AVStream st = this.oc.streams(i);
/*     */ 
/* 372 */       avcodec.AVCodecContext c = st.codec();
/* 373 */       if ((this.video_st == null) && (c.codec_type() == 0)) {
/* 374 */         this.video_st = st;
/* 375 */         this.video_c = c;
/* 376 */       } else if ((this.audio_st == null) && (c.codec_type() == 1)) {
/* 377 */         this.audio_st = st;
/* 378 */         this.audio_c = c;
/*     */       }
/*     */     }
/* 381 */     if ((this.video_st == null) && (this.audio_st == null)) {
/* 382 */       throw new FrameGrabber.Exception("Did not find a video or audio stream inside \"" + this.filename + "\".");
/*     */     }
/*     */ 
/* 385 */     if (this.video_st != null)
/*     */     {
/* 387 */       avcodec.AVCodec codec = avcodec.avcodec_find_decoder(this.video_c.codec_id());
/* 388 */       if (codec == null) {
/* 389 */         throw new FrameGrabber.Exception("avcodec_find_decoder() error: Unsupported video format or codec not found: " + this.video_c.codec_id() + ".");
/*     */       }
/*     */ 
/* 393 */       if ((ret = avcodec.avcodec_open2(this.video_c, codec, (PointerPointer)null)) < 0) {
/* 394 */         throw new FrameGrabber.Exception("avcodec_open2() error " + ret + ": Could not open video codec.");
/*     */       }
/*     */ 
/* 398 */       if ((this.video_c.time_base().num() > 1000) && (this.video_c.time_base().den() == 1)) {
/* 399 */         this.video_c.time_base().den(1000);
/*     */       }
/*     */ 
/* 403 */       if ((this.picture = avcodec.avcodec_alloc_frame()) == null) {
/* 404 */         throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate raw picture frame.");
/*     */       }
/* 406 */       if ((this.picture_rgb = avcodec.avcodec_alloc_frame()) == null) {
/* 407 */         throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate RGB picture frame.");
/*     */       }
/*     */ 
/* 410 */       int width = getImageWidth() > 0 ? getImageWidth() : this.video_c.width();
/* 411 */       int height = getImageHeight() > 0 ? getImageHeight() : this.video_c.height();
/*     */ 
/* 413 */       switch (1.$SwitchMap$com$googlecode$javacv$FrameGrabber$ImageMode[this.imageMode.ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/* 416 */         int fmt = getPixelFormat();
/*     */ 
/* 419 */         int size = avcodec.avpicture_get_size(fmt, width, height);
/* 420 */         this.buffer_rgb = new BytePointer(avutil.av_malloc(size));
/*     */ 
/* 424 */         avcodec.avpicture_fill(new avcodec.AVPicture(this.picture_rgb), this.buffer_rgb, fmt, width, height);
/*     */ 
/* 426 */         this.return_image = opencv_core.IplImage.createHeader(width, height, 8, 1);
/* 427 */         break;
/*     */       case 3:
/* 430 */         this.buffer_rgb = null;
/* 431 */         this.return_image = opencv_core.IplImage.createHeader(this.video_c.width(), this.video_c.height(), 8, 1);
/* 432 */         break;
/*     */       default:
/* 435 */         if (!$assertionsDisabled) throw new AssertionError();
/*     */         break;
/*     */       }
/*     */     }
/* 439 */     if (this.audio_st != null)
/*     */     {
/* 441 */       avcodec.AVCodec codec = avcodec.avcodec_find_decoder(this.audio_c.codec_id());
/* 442 */       if (codec == null) {
/* 443 */         throw new FrameGrabber.Exception("avcodec_find_decoder() error: Unsupported audio format or codec not found: " + this.audio_c.codec_id() + ".");
/*     */       }
/*     */ 
/* 447 */       if ((ret = avcodec.avcodec_open2(this.audio_c, codec, (PointerPointer)null)) < 0) {
/* 448 */         throw new FrameGrabber.Exception("avcodec_open2() error " + ret + ": Could not open audio codec.");
/*     */       }
/*     */ 
/* 452 */       if ((this.samples_frame = avcodec.avcodec_alloc_frame()) == null)
/* 453 */         throw new FrameGrabber.Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameGrabber.Exception
/*     */   {
/* 459 */     release();
/*     */   }
/*     */ 
/*     */   public void trigger() throws FrameGrabber.Exception {
/* 463 */     if ((this.oc == null) || (this.oc.isNull())) {
/* 464 */       throw new FrameGrabber.Exception("Could not trigger: No AVFormatContext. (Has start() been called?)");
/*     */     }
/* 466 */     if (this.pkt2.size() > 0) {
/* 467 */       this.pkt2.size(0);
/* 468 */       avcodec.av_free_packet(this.pkt);
/*     */     }
/* 470 */     for (int i = 0; i < this.numBuffers + 1; i++) {
/* 471 */       if (avformat.av_read_frame(this.oc, this.pkt) < 0) {
/* 472 */         return;
/*     */       }
/* 474 */       avcodec.av_free_packet(this.pkt);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void processImage() throws FrameGrabber.Exception {
/* 479 */     switch (1.$SwitchMap$com$googlecode$javacv$FrameGrabber$ImageMode[this.imageMode.ordinal()])
/*     */     {
/*     */     case 1:
/*     */     case 2:
/* 483 */       if (this.deinterlace) {
/* 484 */         avcodec.AVPicture p = new avcodec.AVPicture(this.picture);
/* 485 */         avcodec.avpicture_deinterlace(p, p, this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height());
/*     */       }
/*     */ 
/* 489 */       this.img_convert_ctx = swscale.sws_getCachedContext(this.img_convert_ctx, this.video_c.width(), this.video_c.height(), this.video_c.pix_fmt(), getImageWidth(), getImageHeight(), getPixelFormat(), 2, null, null, (DoublePointer)null);
/*     */ 
/* 493 */       if (this.img_convert_ctx == null) {
/* 494 */         throw new FrameGrabber.Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
/*     */       }
/*     */ 
/* 498 */       swscale.sws_scale(this.img_convert_ctx, new PointerPointer(this.picture), this.picture.linesize(), 0, this.video_c.height(), new PointerPointer(this.picture_rgb), this.picture_rgb.linesize());
/*     */ 
/* 500 */       this.return_image.imageData(this.buffer_rgb);
/* 501 */       this.return_image.widthStep(this.picture_rgb.linesize(0));
/* 502 */       break;
/*     */     case 3:
/* 505 */       assert ((this.video_c.width() == this.return_image.width()) && (this.video_c.height() == this.return_image.height()));
/*     */ 
/* 507 */       this.return_image.imageData(this.picture.data(0));
/* 508 */       this.return_image.widthStep(this.picture.linesize(0));
/* 509 */       break;
/*     */     default:
/* 512 */       if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */     }
/* 514 */     this.return_image.imageSize(this.return_image.height() * this.return_image.widthStep());
/* 515 */     this.return_image.nChannels(this.return_image.widthStep() / this.return_image.width());
/*     */   }
/*     */ 
/*     */   public opencv_core.IplImage grab() throws FrameGrabber.Exception {
/* 519 */     Frame f = grabFrame(true, false, false);
/* 520 */     return f != null ? f.image : null;
/*     */   }
/*     */   private opencv_core.IplImage grab(boolean processImage) throws FrameGrabber.Exception {
/* 523 */     Frame f = grabFrame(processImage, false, false);
/* 524 */     return f != null ? f.image : null;
/*     */   }
/*     */   public Frame grabFrame() throws FrameGrabber.Exception {
/* 527 */     return grabFrame(true, true, false);
/*     */   }
/*     */   public Frame grabKeyFrame() throws FrameGrabber.Exception {
/* 530 */     return grabFrame(true, false, true);
/*     */   }
/*     */   private Frame grabFrame(boolean processImage, boolean doAudio, boolean keyFrames) throws FrameGrabber.Exception {
/* 533 */     if ((this.oc == null) || (this.oc.isNull())) {
/* 534 */       throw new FrameGrabber.Exception("Could not grab: No AVFormatContext. (Has start() been called?)");
/*     */     }
/* 536 */     this.frame.keyFrame = false;
/* 537 */     this.frame.image = null;
/* 538 */     this.frame.sampleRate = 0;
/* 539 */     this.frame.samples = null;
/* 540 */     this.frame.opaque = null;
/* 541 */     if (this.frameGrabbed) {
/* 542 */       this.frameGrabbed = false;
/* 543 */       if (processImage) {
/* 544 */         processImage();
/*     */       }
/* 546 */       this.frame.keyFrame = (this.picture.key_frame() != 0);
/* 547 */       this.frame.image = this.return_image;
/* 548 */       this.frame.opaque = this.picture;
/* 549 */       return this.frame;
/*     */     }
/* 551 */     boolean done = false;
/* 552 */     while (!done) {
/* 553 */       if ((this.pkt2.size() <= 0) && 
/* 554 */         (avformat.av_read_frame(this.oc, this.pkt) < 0)) {
/* 555 */         if (this.video_st != null)
/*     */         {
/* 557 */           this.pkt.stream_index(this.video_st.index());
/* 558 */           this.pkt.flags(1);
/* 559 */           this.pkt.data(null);
/* 560 */           this.pkt.size(0);
/*     */         } else {
/* 562 */           return null;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 568 */       if ((this.video_st != null) && (this.pkt.stream_index() == this.video_st.index()) && ((!keyFrames) || (this.pkt.flags() == 1)))
/*     */       {
/* 571 */         int len = avcodec.avcodec_decode_video2(this.video_c, this.picture, this.got_frame, this.pkt);
/*     */ 
/* 574 */         if ((len >= 0) && (this.got_frame[0] != 0) && ((!keyFrames) || (this.picture.pict_type() == 1)))
/*     */         {
/* 576 */           long pts = avutil.av_frame_get_best_effort_timestamp(this.picture);
/* 577 */           avutil.AVRational time_base = this.video_st.time_base();
/* 578 */           this.timestamp = (1000000L * pts * time_base.num() / time_base.den());
/*     */ 
/* 580 */           this.frameNumber = ((int)(this.timestamp * getFrameRate() / 1000000.0D));
/* 581 */           if (processImage) {
/* 582 */             processImage();
/*     */           }
/* 584 */           done = true;
/* 585 */           this.frame.keyFrame = (this.picture.key_frame() != 0);
/* 586 */           this.frame.image = this.return_image;
/* 587 */           this.frame.opaque = this.picture;
/* 588 */         } else if ((this.pkt.data() == null) && (this.pkt.size() == 0)) {
/* 589 */           return null;
/*     */         }
/* 591 */       } else if ((doAudio) && (this.audio_st != null) && (this.pkt.stream_index() == this.audio_st.index())) {
/* 592 */         if (this.pkt2.size() <= 0)
/*     */         {
/* 595 */           BytePointer.memcpy(this.pkt2, this.pkt, this.sizeof_pkt);
/*     */         }
/* 597 */         avcodec.avcodec_get_frame_defaults(this.samples_frame);
/*     */ 
/* 599 */         int len = avcodec.avcodec_decode_audio4(this.audio_c, this.samples_frame, this.got_frame, this.pkt2);
/* 600 */         if (len <= 0)
/*     */         {
/* 602 */           this.pkt2.size(0);
/*     */         } else {
/* 604 */           this.pkt2.data(this.pkt2.data().position(len));
/* 605 */           this.pkt2.size(this.pkt2.size() - len);
/* 606 */           if (this.got_frame[0] != 0) {
/* 607 */             long pts = avutil.av_frame_get_best_effort_timestamp(this.samples_frame);
/* 608 */             avutil.AVRational time_base = this.audio_st.time_base();
/* 609 */             this.timestamp = (1000000L * pts * time_base.num() / time_base.den());
/*     */ 
/* 611 */             done = true;
/* 612 */             int sample_format = this.samples_frame.format();
/* 613 */             int planes = avutil.av_sample_fmt_is_planar(sample_format) != 0 ? this.samples_frame.channels() : 1;
/* 614 */             int data_size = avutil.av_samples_get_buffer_size((IntPointer)null, this.audio_c.channels(), this.samples_frame.nb_samples(), this.audio_c.sample_fmt(), 1) / planes;
/*     */ 
/* 616 */             if ((this.samples_buf == null) || (this.samples_buf.length != planes)) {
/* 617 */               this.samples_ptr = new BytePointer[planes];
/* 618 */               this.samples_buf = new Buffer[planes];
/*     */             }
/* 620 */             this.frame.keyFrame = (this.samples_frame.key_frame() != 0);
/* 621 */             this.frame.sampleRate = this.audio_c.sample_rate();
/* 622 */             this.frame.samples = this.samples_buf;
/* 623 */             this.frame.opaque = this.samples_frame;
/* 624 */             int sample_size = data_size / avutil.av_get_bytes_per_sample(sample_format);
/* 625 */             for (int i = 0; i < planes; i++) {
/* 626 */               BytePointer p = this.samples_frame.data(i);
/* 627 */               if ((!p.equals(this.samples_ptr[i])) || (this.samples_ptr[i].capacity() < data_size)) {
/* 628 */                 this.samples_ptr[i] = p.capacity(data_size);
/* 629 */                 ByteBuffer b = p.asBuffer();
/* 630 */                 switch (sample_format) { case 0:
/*     */                 case 5:
/* 632 */                   this.samples_buf[i] = b; break;
/*     */                 case 1:
/*     */                 case 6:
/* 634 */                   this.samples_buf[i] = b.asShortBuffer(); break;
/*     */                 case 2:
/*     */                 case 7:
/* 636 */                   this.samples_buf[i] = b.asIntBuffer(); break;
/*     */                 case 3:
/*     */                 case 8:
/* 638 */                   this.samples_buf[i] = b.asFloatBuffer(); break;
/*     */                 case 4:
/*     */                 case 9:
/* 640 */                   this.samples_buf[i] = b.asDoubleBuffer(); break;
/*     */                 default:
/* 641 */                   if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */                 }
/*     */               }
/* 644 */               this.samples_buf[i].position(0).limit(sample_size);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 650 */       if (this.pkt2.size() <= 0)
/*     */       {
/* 652 */         avcodec.av_free_packet(this.pkt);
/*     */       }
/*     */     }
/* 655 */     return this.frame;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  80 */     loadingException = null;
/*     */ 
/* 103 */     avcodec.avcodec_register_all();
/* 104 */     avdevice.avdevice_register_all();
/* 105 */     avformat.av_register_all();
/* 106 */     avformat.avformat_network_init();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.FFmpegFrameGrabber
 * JD-Core Version:    0.6.2
 */