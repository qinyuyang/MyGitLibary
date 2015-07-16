/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.DoublePointer;
/*     */ import com.googlecode.javacpp.FloatPointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.PointerPointer;
/*     */ import com.googlecode.javacpp.ShortPointer;
/*     */ import com.googlecode.javacv.cpp.avcodec;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVCodec;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVCodecContext;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVPacket;
/*     */ import com.googlecode.javacv.cpp.avcodec.AVPicture;
/*     */ import com.googlecode.javacv.cpp.avformat;
/*     */ import com.googlecode.javacv.cpp.avformat.AVFormatContext;
/*     */ import com.googlecode.javacv.cpp.avformat.AVIOContext;
/*     */ import com.googlecode.javacv.cpp.avformat.AVOutputFormat;
/*     */ import com.googlecode.javacv.cpp.avformat.AVStream;
/*     */ import com.googlecode.javacv.cpp.avutil;
/*     */ import com.googlecode.javacv.cpp.avutil.AVDictionary;
/*     */ import com.googlecode.javacv.cpp.avutil.AVFrame;
/*     */ import com.googlecode.javacv.cpp.avutil.AVRational;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import com.googlecode.javacv.cpp.swresample;
/*     */ import com.googlecode.javacv.cpp.swresample.SwrContext;
/*     */ import com.googlecode.javacv.cpp.swscale;
/*     */ import com.googlecode.javacv.cpp.swscale.SwsContext;
/*     */ import java.io.File;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class FFmpegFrameRecorder extends FrameRecorder
/*     */ {
/*     */   private static FrameRecorder.Exception loadingException;
/*     */   private String filename;
/*     */   private avutil.AVFrame picture;
/*     */   private avutil.AVFrame tmp_picture;
/*     */   private BytePointer picture_buf;
/*     */   private BytePointer video_outbuf;
/*     */   private int video_outbuf_size;
/*     */   private avutil.AVFrame frame;
/*     */   private Pointer[] samples_in;
/*     */   private BytePointer[] samples_out;
/*     */   private PointerPointer samples_in_ptr;
/*     */   private PointerPointer samples_out_ptr;
/*     */   private BytePointer audio_outbuf;
/*     */   private int audio_outbuf_size;
/*     */   private int audio_input_frame_size;
/*     */   private avformat.AVOutputFormat oformat;
/*     */   private avformat.AVFormatContext oc;
/*     */   private avcodec.AVCodec video_codec;
/*     */   private avcodec.AVCodec audio_codec;
/*     */   private avcodec.AVCodecContext video_c;
/*     */   private avcodec.AVCodecContext audio_c;
/*     */   private avformat.AVStream video_st;
/*     */   private avformat.AVStream audio_st;
/*     */   private swscale.SwsContext img_convert_ctx;
/*     */   private swresample.SwrContext samples_convert_ctx;
/*     */   private avcodec.AVPacket video_pkt;
/*     */   private avcodec.AVPacket audio_pkt;
/*     */   private int[] got_video_packet;
/*     */   private int[] got_audio_packet;
/*     */ 
/*     */   public static FFmpegFrameRecorder createDefault(File f, int w, int h)
/*     */     throws FrameRecorder.Exception
/*     */   {
/*  81 */     return new FFmpegFrameRecorder(f, w, h); } 
/*  82 */   public static FFmpegFrameRecorder createDefault(String f, int w, int h) throws FrameRecorder.Exception { return new FFmpegFrameRecorder(f, w, h); }
/*     */ 
/*     */   public static void tryLoad() throws FrameRecorder.Exception
/*     */   {
/*  86 */     if (loadingException != null)
/*  87 */       throw loadingException;
/*     */     try
/*     */     {
/*  90 */       Loader.load(avutil.class);
/*  91 */       Loader.load(avcodec.class);
/*  92 */       Loader.load(avformat.class);
/*  93 */       Loader.load(swscale.class);
/*     */     } catch (Throwable t) {
/*  95 */       if ((t instanceof FrameRecorder.Exception)) {
/*  96 */         throw (FFmpegFrameRecorder.loadingException = (FrameRecorder.Exception)t);
/*     */       }
/*  98 */       throw (FFmpegFrameRecorder.loadingException = new FrameRecorder.Exception("Failed to load " + FFmpegFrameRecorder.class, t));
/*     */     }
/*     */   }
/*     */ 
/*     */   public FFmpegFrameRecorder(File file, int audioChannels)
/*     */   {
/* 111 */     this(file, 0, 0, audioChannels);
/*     */   }
/*     */   public FFmpegFrameRecorder(String filename, int audioChannels) {
/* 114 */     this(filename, 0, 0, audioChannels);
/*     */   }
/*     */   public FFmpegFrameRecorder(File file, int imageWidth, int imageHeight) {
/* 117 */     this(file, imageWidth, imageHeight, 0);
/*     */   }
/*     */   public FFmpegFrameRecorder(String filename, int imageWidth, int imageHeight) {
/* 120 */     this(filename, imageWidth, imageHeight, 0);
/*     */   }
/*     */   public FFmpegFrameRecorder(File file, int imageWidth, int imageHeight, int audioChannels) {
/* 123 */     this(file.getAbsolutePath(), imageWidth, imageHeight);
/*     */   }
/*     */   public FFmpegFrameRecorder(String filename, int imageWidth, int imageHeight, int audioChannels) {
/* 126 */     this.filename = filename;
/* 127 */     this.imageWidth = imageWidth;
/* 128 */     this.imageHeight = imageHeight;
/* 129 */     this.audioChannels = audioChannels;
/*     */ 
/* 131 */     this.pixelFormat = -1;
/* 132 */     this.videoCodec = 0;
/* 133 */     this.videoBitrate = 400000;
/* 134 */     this.frameRate = 30.0D;
/*     */ 
/* 136 */     this.sampleFormat = -1;
/* 137 */     this.audioCodec = 0;
/* 138 */     this.audioBitrate = 64000;
/* 139 */     this.sampleRate = 44100;
/*     */ 
/* 141 */     this.interleaved = true;
/*     */ 
/* 143 */     this.video_pkt = new avcodec.AVPacket();
/* 144 */     this.audio_pkt = new avcodec.AVPacket();
/*     */   }
/*     */   public void release() throws FrameRecorder.Exception {
/* 147 */     synchronized (avcodec.class) {
/* 148 */       releaseUnsafe();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void releaseUnsafe() throws FrameRecorder.Exception {
/* 153 */     if (this.video_c != null) {
/* 154 */       avcodec.avcodec_close(this.video_c);
/* 155 */       this.video_c = null;
/*     */     }
/* 157 */     if (this.audio_c != null) {
/* 158 */       avcodec.avcodec_close(this.audio_c);
/* 159 */       this.audio_c = null;
/*     */     }
/* 161 */     if (this.picture_buf != null) {
/* 162 */       avutil.av_free(this.picture_buf);
/* 163 */       this.picture_buf = null;
/*     */     }
/* 165 */     if (this.picture != null) {
/* 166 */       avcodec.avcodec_free_frame(this.picture);
/* 167 */       this.picture = null;
/*     */     }
/* 169 */     if (this.tmp_picture != null) {
/* 170 */       avcodec.avcodec_free_frame(this.tmp_picture);
/* 171 */       this.tmp_picture = null;
/*     */     }
/* 173 */     if (this.video_outbuf != null) {
/* 174 */       avutil.av_free(this.video_outbuf);
/* 175 */       this.video_outbuf = null;
/*     */     }
/* 177 */     if (this.frame != null) {
/* 178 */       avcodec.avcodec_free_frame(this.frame);
/* 179 */       this.frame = null;
/*     */     }
/* 181 */     if (this.samples_out != null) {
/* 182 */       for (int i = 0; i < this.samples_out.length; i++) {
/* 183 */         avutil.av_free(this.samples_out[i].position(0));
/*     */       }
/* 185 */       this.samples_out = null;
/*     */     }
/* 187 */     if (this.audio_outbuf != null) {
/* 188 */       avutil.av_free(this.audio_outbuf);
/* 189 */       this.audio_outbuf = null;
/*     */     }
/* 191 */     this.video_st = null;
/* 192 */     this.audio_st = null;
/*     */ 
/* 194 */     if ((this.oc != null) && (!this.oc.isNull())) {
/* 195 */       if ((this.oformat.flags() & 0x1) == 0)
/*     */       {
/* 197 */         avformat.avio_close(this.oc.pb());
/*     */       }
/*     */ 
/* 201 */       int nb_streams = this.oc.nb_streams();
/* 202 */       for (int i = 0; i < nb_streams; i++) {
/* 203 */         avutil.av_free(this.oc.streams(i).codec());
/* 204 */         avutil.av_free(this.oc.streams(i));
/*     */       }
/*     */ 
/* 208 */       avutil.av_free(this.oc);
/* 209 */       this.oc = null;
/*     */     }
/*     */ 
/* 212 */     if (this.img_convert_ctx != null) {
/* 213 */       swscale.sws_freeContext(this.img_convert_ctx);
/* 214 */       this.img_convert_ctx = null;
/*     */     }
/*     */ 
/* 217 */     if (this.samples_convert_ctx != null) {
/* 218 */       swresample.swr_free(this.samples_convert_ctx);
/* 219 */       this.samples_convert_ctx = null;
/*     */     }
/*     */   }
/*     */ 
/* 223 */   protected void finalize() throws Throwable { super.finalize();
/* 224 */     release();
/*     */   }
/*     */ 
/*     */   public int getFrameNumber()
/*     */   {
/* 251 */     return this.picture == null ? super.getFrameNumber() : (int)this.picture.pts();
/*     */   }
/*     */   public void setFrameNumber(int frameNumber) {
/* 254 */     if (this.picture == null) super.setFrameNumber(frameNumber); else this.picture.pts(frameNumber);
/*     */   }
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 259 */     return Math.round(getFrameNumber() * 1000000L / getFrameRate());
/*     */   }
/*     */   public void setTimestamp(long timestamp) {
/* 262 */     setFrameNumber((int)Math.round(timestamp * getFrameRate() / 1000000.0D));
/*     */   }
/*     */ 
/*     */   public void start() throws FrameRecorder.Exception {
/* 266 */     synchronized (avcodec.class) {
/* 267 */       startUnsafe();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void startUnsafe() throws FrameRecorder.Exception {
/* 272 */     this.picture = null;
/* 273 */     this.tmp_picture = null;
/* 274 */     this.picture_buf = null;
/* 275 */     this.frame = null;
/* 276 */     this.video_outbuf = null;
/* 277 */     this.audio_outbuf = null;
/* 278 */     this.oc = null;
/* 279 */     this.video_c = null;
/* 280 */     this.audio_c = null;
/* 281 */     this.video_st = null;
/* 282 */     this.audio_st = null;
/* 283 */     this.got_video_packet = new int[1];
/* 284 */     this.got_audio_packet = new int[1];
/*     */ 
/* 287 */     String format_name = (this.format == null) || (this.format.length() == 0) ? null : this.format;
/* 288 */     if ((this.oformat = avformat.av_guess_format(format_name, this.filename, null)) == null) {
/* 289 */       int proto = this.filename.indexOf("://");
/* 290 */       if (proto > 0) {
/* 291 */         format_name = this.filename.substring(0, proto);
/*     */       }
/* 293 */       if ((this.oformat = avformat.av_guess_format(format_name, this.filename, null)) == null) {
/* 294 */         throw new FrameRecorder.Exception("av_guess_format() error: Could not guess output format for \"" + this.filename + "\" and " + this.format + " format.");
/*     */       }
/*     */     }
/* 297 */     format_name = this.oformat.name().getString();
/*     */ 
/* 300 */     if ((this.oc = avformat.avformat_alloc_context()) == null) {
/* 301 */       throw new FrameRecorder.Exception("avformat_alloc_context() error: Could not allocate format context");
/*     */     }
/*     */ 
/* 304 */     this.oc.oformat(this.oformat);
/* 305 */     this.oc.filename().putString(this.filename);
/*     */ 
/* 310 */     if ((this.imageWidth > 0) && (this.imageHeight > 0)) {
/* 311 */       if (this.videoCodec != 0)
/* 312 */         this.oformat.video_codec(this.videoCodec);
/* 313 */       else if ("flv".equals(format_name))
/* 314 */         this.oformat.video_codec(22);
/* 315 */       else if ("mp4".equals(format_name))
/* 316 */         this.oformat.video_codec(13);
/* 317 */       else if ("3gp".equals(format_name))
/* 318 */         this.oformat.video_codec(5);
/* 319 */       else if ("avi".equals(format_name)) {
/* 320 */         this.oformat.video_codec(26);
/*     */       }
/*     */ 
/* 324 */       if (((this.video_codec = avcodec.avcodec_find_encoder_by_name(this.videoCodecName)) == null) && ((this.video_codec = avcodec.avcodec_find_encoder(this.oformat.video_codec())) == null))
/*     */       {
/* 326 */         release();
/* 327 */         throw new FrameRecorder.Exception("avcodec_find_encoder() error: Video codec not found.");
/*     */       }
/*     */ 
/* 330 */       avutil.AVRational frame_rate = avutil.av_d2q(this.frameRate, 1001000);
/* 331 */       avutil.AVRational supported_framerates = this.video_codec.supported_framerates();
/* 332 */       if (supported_framerates != null) {
/* 333 */         int idx = avutil.av_find_nearest_q_idx(frame_rate, supported_framerates);
/* 334 */         frame_rate = supported_framerates.position(idx);
/*     */       }
/*     */ 
/* 338 */       if ((this.video_st = avformat.avformat_new_stream(this.oc, this.video_codec)) == null) {
/* 339 */         release();
/* 340 */         throw new FrameRecorder.Exception("avformat_new_stream() error: Could not allocate video stream.");
/*     */       }
/* 342 */       this.video_c = this.video_st.codec();
/* 343 */       this.video_c.codec_id(this.oformat.video_codec());
/* 344 */       this.video_c.codec_type(0);
/*     */ 
/* 347 */       this.video_c.bit_rate(this.videoBitrate);
/*     */ 
/* 349 */       this.video_c.width((this.imageWidth + 15) / 16 * 16);
/* 350 */       this.video_c.height(this.imageHeight);
/*     */ 
/* 355 */       this.video_c.time_base(avutil.av_inv_q(frame_rate));
/* 356 */       this.video_c.gop_size(12);
/* 357 */       if (this.videoQuality >= 0.0D) {
/* 358 */         this.video_c.flags(this.video_c.flags() | 0x2);
/* 359 */         this.video_c.global_quality((int)Math.round(118.0D * this.videoQuality));
/*     */       }
/*     */ 
/* 362 */       if (this.pixelFormat != -1)
/* 363 */         this.video_c.pix_fmt(this.pixelFormat);
/* 364 */       else if ((this.video_c.codec_id() == 14) || (this.video_c.codec_id() == 62) || (this.video_c.codec_id() == 26) || (this.video_c.codec_id() == 34))
/*     */       {
/* 366 */         this.video_c.pix_fmt(avutil.AV_PIX_FMT_RGB32);
/*     */       }
/* 368 */       else this.video_c.pix_fmt(0);
/*     */ 
/* 371 */       if (this.video_c.codec_id() == 2)
/*     */       {
/* 373 */         this.video_c.max_b_frames(2);
/* 374 */       } else if (this.video_c.codec_id() == 1)
/*     */       {
/* 378 */         this.video_c.mb_decision(2);
/* 379 */       } else if (this.video_c.codec_id() == 5)
/*     */       {
/* 381 */         if ((this.imageWidth <= 128) && (this.imageHeight <= 96))
/* 382 */           this.video_c.width(128).height(96);
/* 383 */         else if ((this.imageWidth <= 176) && (this.imageHeight <= 144))
/* 384 */           this.video_c.width(176).height(144);
/* 385 */         else if ((this.imageWidth <= 352) && (this.imageHeight <= 288))
/* 386 */           this.video_c.width(352).height(288);
/* 387 */         else if ((this.imageWidth <= 704) && (this.imageHeight <= 576))
/* 388 */           this.video_c.width(704).height(576);
/*     */         else
/* 390 */           this.video_c.width(1408).height(1152);
/*     */       }
/* 392 */       else if (this.video_c.codec_id() == 28)
/*     */       {
/* 395 */         this.video_c.profile(578);
/*     */       }
/*     */ 
/* 399 */       if ((this.oformat.flags() & 0x40) != 0) {
/* 400 */         this.video_c.flags(this.video_c.flags() | 0x400000);
/*     */       }
/*     */ 
/* 403 */       if ((this.video_codec.capabilities() & 0x200) != 0) {
/* 404 */         this.video_c.strict_std_compliance(-2);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 411 */     if ((this.audioChannels > 0) && (this.audioBitrate > 0) && (this.sampleRate > 0)) {
/* 412 */       if (this.audioCodec != 0)
/* 413 */         this.oformat.audio_codec(this.audioCodec);
/* 414 */       else if (("flv".equals(format_name)) || ("mp4".equals(format_name)) || ("3gp".equals(format_name)))
/* 415 */         this.oformat.audio_codec(86018);
/* 416 */       else if ("avi".equals(format_name)) {
/* 417 */         this.oformat.audio_codec(65536);
/*     */       }
/*     */ 
/* 421 */       if (((this.audio_codec = avcodec.avcodec_find_encoder_by_name(this.audioCodecName)) == null) && ((this.audio_codec = avcodec.avcodec_find_encoder(this.oformat.audio_codec())) == null))
/*     */       {
/* 423 */         release();
/* 424 */         throw new FrameRecorder.Exception("avcodec_find_encoder() error: Audio codec not found.");
/*     */       }
/*     */ 
/* 427 */       if ((this.audio_st = avformat.avformat_new_stream(this.oc, this.audio_codec)) == null) {
/* 428 */         release();
/* 429 */         throw new FrameRecorder.Exception("avformat_new_stream() error: Could not allocate audio stream.");
/*     */       }
/* 431 */       this.audio_c = this.audio_st.codec();
/* 432 */       this.audio_c.codec_id(this.oformat.audio_codec());
/* 433 */       this.audio_c.codec_type(1);
/*     */ 
/* 436 */       this.audio_c.bit_rate(this.audioBitrate);
/* 437 */       this.audio_c.sample_rate(this.sampleRate);
/* 438 */       this.audio_c.channels(this.audioChannels);
/* 439 */       this.audio_c.channel_layout(avutil.av_get_default_channel_layout(this.audioChannels));
/* 440 */       if (this.sampleFormat != -1)
/* 441 */         this.audio_c.sample_fmt(this.sampleFormat);
/* 442 */       else if ((this.audio_c.codec_id() == 86018) && ((this.audio_codec.capabilities() & 0x200) != 0))
/*     */       {
/* 444 */         this.audio_c.sample_fmt(8);
/*     */       }
/* 446 */       else this.audio_c.sample_fmt(1);
/*     */ 
/* 448 */       this.audio_c.time_base().num(1).den(this.sampleRate);
/* 449 */       switch (this.audio_c.sample_fmt()) { case 0:
/*     */       case 5:
/* 451 */         this.audio_c.bits_per_raw_sample(8); break;
/*     */       case 1:
/*     */       case 6:
/* 453 */         this.audio_c.bits_per_raw_sample(16); break;
/*     */       case 2:
/*     */       case 7:
/* 455 */         this.audio_c.bits_per_raw_sample(32); break;
/*     */       case 3:
/*     */       case 8:
/* 457 */         this.audio_c.bits_per_raw_sample(32); break;
/*     */       case 4:
/*     */       case 9:
/* 459 */         this.audio_c.bits_per_raw_sample(64); break;
/*     */       default:
/* 460 */         if (!$assertionsDisabled) throw new AssertionError(); break;
/*     */       }
/* 462 */       if (this.audioQuality >= 0.0D) {
/* 463 */         this.audio_c.flags(this.audio_c.flags() | 0x2);
/* 464 */         this.audio_c.global_quality((int)Math.round(118.0D * this.audioQuality));
/*     */       }
/*     */ 
/* 468 */       if ((this.oformat.flags() & 0x40) != 0) {
/* 469 */         this.audio_c.flags(this.audio_c.flags() | 0x400000);
/*     */       }
/*     */ 
/* 472 */       if ((this.audio_codec.capabilities() & 0x200) != 0) {
/* 473 */         this.audio_c.strict_std_compliance(-2);
/*     */       }
/*     */     }
/*     */ 
/* 477 */     avformat.av_dump_format(this.oc, 0, this.filename, 1);
/*     */ 
/* 481 */     if (this.video_st != null) {
/* 482 */       avutil.AVDictionary options = new avutil.AVDictionary(null);
/* 483 */       if (this.videoQuality >= 0.0D) {
/* 484 */         avutil.av_dict_set(options, "crf", "" + this.videoQuality, 0);
/*     */       }
/* 486 */       for (Map.Entry e : this.videoOptions.entrySet())
/* 487 */         avutil.av_dict_set(options, (String)e.getKey(), (String)e.getValue(), 0);
/*     */       int ret;
/* 490 */       if ((ret = avcodec.avcodec_open2(this.video_c, this.video_codec, options)) < 0) {
/* 491 */         release();
/* 492 */         throw new FrameRecorder.Exception("avcodec_open2() error " + ret + ": Could not open video codec.");
/*     */       }
/* 494 */       avutil.av_dict_free(options);
/*     */ 
/* 496 */       this.video_outbuf = null;
/* 497 */       if ((this.oformat.flags() & 0x20) == 0)
/*     */       {
/* 504 */         this.video_outbuf_size = Math.max(262144, 8 * this.video_c.width() * this.video_c.height());
/* 505 */         this.video_outbuf = new BytePointer(avutil.av_malloc(this.video_outbuf_size));
/*     */       }
/*     */ 
/* 509 */       if ((this.picture = avcodec.avcodec_alloc_frame()) == null) {
/* 510 */         release();
/* 511 */         throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate picture.");
/*     */       }
/* 513 */       this.picture.pts(0L);
/*     */ 
/* 515 */       int size = avcodec.avpicture_get_size(this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height());
/* 516 */       if ((this.picture_buf = new BytePointer(avutil.av_malloc(size))).isNull()) {
/* 517 */         release();
/* 518 */         throw new FrameRecorder.Exception("av_malloc() error: Could not allocate picture buffer.");
/*     */       }
/*     */ 
/* 523 */       if ((this.tmp_picture = avcodec.avcodec_alloc_frame()) == null) {
/* 524 */         release();
/* 525 */         throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate temporary picture.");
/*     */       }
/*     */     }
/*     */ 
/* 529 */     if (this.audio_st != null) {
/* 530 */       avutil.AVDictionary options = new avutil.AVDictionary(null);
/* 531 */       if (this.audioQuality >= 0.0D) {
/* 532 */         avutil.av_dict_set(options, "crf", "" + this.audioQuality, 0);
/*     */       }
/* 534 */       for (Map.Entry e : this.audioOptions.entrySet())
/* 535 */         avutil.av_dict_set(options, (String)e.getKey(), (String)e.getValue(), 0);
/*     */       int ret;
/* 538 */       if ((ret = avcodec.avcodec_open2(this.audio_c, this.audio_codec, options)) < 0) {
/* 539 */         release();
/* 540 */         throw new FrameRecorder.Exception("avcodec_open2() error " + ret + ": Could not open audio codec.");
/*     */       }
/* 542 */       avutil.av_dict_free(options);
/*     */ 
/* 544 */       this.audio_outbuf_size = 262144;
/* 545 */       this.audio_outbuf = new BytePointer(avutil.av_malloc(this.audio_outbuf_size));
/*     */ 
/* 549 */       if (this.audio_c.frame_size() <= 1) {
/* 550 */         this.audio_outbuf_size = 16384;
/* 551 */         this.audio_input_frame_size = (this.audio_outbuf_size / this.audio_c.channels());
/* 552 */         switch (this.audio_c.codec_id()) {
/*     */         case 65536:
/*     */         case 65537:
/*     */         case 65538:
/*     */         case 65539:
/* 557 */           this.audio_input_frame_size >>= 1;
/* 558 */           break;
/*     */         default:
/* 560 */           break;
/*     */         }
/*     */       } else {
/* 563 */         this.audio_input_frame_size = this.audio_c.frame_size();
/*     */       }
/*     */ 
/* 566 */       int planes = avutil.av_sample_fmt_is_planar(this.audio_c.sample_fmt()) != 0 ? this.audio_c.channels() : 1;
/* 567 */       int data_size = avutil.av_samples_get_buffer_size((IntPointer)null, this.audio_c.channels(), this.audio_input_frame_size, this.audio_c.sample_fmt(), 1) / planes;
/*     */ 
/* 569 */       this.samples_out = new BytePointer[planes];
/* 570 */       for (int i = 0; i < this.samples_out.length; i++) {
/* 571 */         this.samples_out[i] = new BytePointer(avutil.av_malloc(data_size)).capacity(data_size);
/*     */       }
/* 573 */       this.samples_in = new Pointer[8];
/* 574 */       this.samples_in_ptr = new PointerPointer(8);
/* 575 */       this.samples_out_ptr = new PointerPointer(8);
/*     */ 
/* 578 */       if ((this.frame = avcodec.avcodec_alloc_frame()) == null) {
/* 579 */         release();
/* 580 */         throw new FrameRecorder.Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 585 */     if ((this.oformat.flags() & 0x1) == 0) {
/* 586 */       avformat.AVIOContext pb = new avformat.AVIOContext(null);
/*     */       int ret;
/* 587 */       if ((ret = avformat.avio_open(pb, this.filename, 2)) < 0) {
/* 588 */         release();
/* 589 */         throw new FrameRecorder.Exception("avio_open error() error " + ret + ": Could not open '" + this.filename + "'");
/*     */       }
/* 591 */       this.oc.pb(pb);
/*     */     }
/*     */ 
/* 595 */     avformat.avformat_write_header(this.oc, (PointerPointer)null);
/*     */   }
/*     */ 
/*     */   public void stop() throws FrameRecorder.Exception {
/* 599 */     if (this.oc != null)
/*     */       try
/*     */       {
/* 602 */         while ((this.video_st != null) && (record((opencv_core.IplImage)null, -1)));
/* 603 */         while ((this.audio_st != null) && (record((avutil.AVFrame)null)));
/* 605 */         if ((this.interleaved) && (this.video_st != null) && (this.audio_st != null))
/* 606 */           avformat.av_interleaved_write_frame(this.oc, null);
/*     */         else {
/* 608 */           avformat.av_write_frame(this.oc, null);
/*     */         }
/*     */ 
/* 612 */         avformat.av_write_trailer(this.oc);
/*     */       } finally {
/* 614 */         release();
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean record(opencv_core.IplImage image) throws FrameRecorder.Exception
/*     */   {
/* 620 */     return record(image, -1);
/*     */   }
/*     */   public boolean record(opencv_core.IplImage image, int pixelFormat) throws FrameRecorder.Exception {
/* 623 */     if (this.video_st == null) {
/* 624 */       throw new FrameRecorder.Exception("No video output stream (Is imageWidth > 0 && imageHeight > 0 and has start() been called?)");
/*     */     }
/*     */ 
/* 628 */     if (image != null)
/*     */     {
/* 633 */       int width = image.width();
/* 634 */       int height = image.height();
/* 635 */       int step = image.widthStep();
/* 636 */       BytePointer data = image.imageData();
/*     */ 
/* 638 */       if (pixelFormat == -1) {
/* 639 */         int depth = image.depth();
/* 640 */         int channels = image.nChannels();
/* 641 */         if (((depth == 8) || (depth == -2147483640)) && (channels == 3)) {
/* 642 */           pixelFormat = 3;
/* 643 */         } else if (((depth == 8) || (depth == -2147483640)) && (channels == 1)) {
/* 644 */           pixelFormat = 8;
/* 645 */         } else if (((depth == 16) || (depth == -2147483632)) && (channels == 1)) {
/* 646 */           pixelFormat = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN) ? 31 : 32;
/*     */         }
/* 648 */         else if (((depth == 8) || (depth == -2147483640)) && (channels == 4)) {
/* 649 */           pixelFormat = 28;
/* 650 */         } else if (((depth == 8) || (depth == -2147483640)) && (channels == 2)) {
/* 651 */           pixelFormat = 26;
/* 652 */           step = width;
/*     */         } else {
/* 654 */           throw new FrameRecorder.Exception("Could not guess pixel format of image: depth=" + depth + ", channels=" + channels);
/*     */         }
/*     */       }
/*     */ 
/* 658 */       if ((this.video_c.pix_fmt() != pixelFormat) || (this.video_c.width() != width) || (this.video_c.height() != height))
/*     */       {
/* 660 */         this.img_convert_ctx = swscale.sws_getCachedContext(this.img_convert_ctx, width, height, pixelFormat, this.video_c.width(), this.video_c.height(), this.video_c.pix_fmt(), 2, null, null, (DoublePointer)null);
/*     */ 
/* 663 */         if (this.img_convert_ctx == null) {
/* 664 */           throw new FrameRecorder.Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
/*     */         }
/* 666 */         avcodec.avpicture_fill(new avcodec.AVPicture(this.tmp_picture), data, pixelFormat, width, height);
/* 667 */         avcodec.avpicture_fill(new avcodec.AVPicture(this.picture), this.picture_buf, this.video_c.pix_fmt(), this.video_c.width(), this.video_c.height());
/* 668 */         this.tmp_picture.linesize(0, step);
/* 669 */         swscale.sws_scale(this.img_convert_ctx, new PointerPointer(this.tmp_picture), this.tmp_picture.linesize(), 0, height, new PointerPointer(this.picture), this.picture.linesize());
/*     */       }
/*     */       else {
/* 672 */         avcodec.avpicture_fill(new avcodec.AVPicture(this.picture), data, pixelFormat, width, height);
/* 673 */         this.picture.linesize(0, step);
/*     */       }
/*     */     }
/*     */ 
/* 677 */     if ((this.oformat.flags() & 0x20) != 0) {
/* 678 */       if (image == null) {
/* 679 */         return false;
/*     */       }
/*     */ 
/* 682 */       avcodec.av_init_packet(this.video_pkt);
/* 683 */       this.video_pkt.flags(this.video_pkt.flags() | 0x1);
/* 684 */       this.video_pkt.stream_index(this.video_st.index());
/* 685 */       this.video_pkt.data(new BytePointer(this.picture));
/* 686 */       this.video_pkt.size(Loader.sizeof(avcodec.AVPicture.class));
/*     */     }
/*     */     else {
/* 689 */       avcodec.av_init_packet(this.video_pkt);
/* 690 */       this.video_pkt.data(this.video_outbuf);
/* 691 */       this.video_pkt.size(this.video_outbuf_size);
/* 692 */       this.picture.quality(this.video_c.global_quality());
/*     */       int ret;
/* 693 */       if ((ret = avcodec.avcodec_encode_video2(this.video_c, this.video_pkt, image == null ? null : this.picture, this.got_video_packet)) < 0) {
/* 694 */         throw new FrameRecorder.Exception("avcodec_encode_video2() error " + ret + ": Could not encode video packet.");
/*     */       }
/* 696 */       this.picture.pts(this.picture.pts() + 1L);
/*     */ 
/* 699 */       if (this.got_video_packet[0] != 0) {
/* 700 */         if (this.video_pkt.pts() != avutil.AV_NOPTS_VALUE) {
/* 701 */           this.video_pkt.pts(avutil.av_rescale_q(this.video_pkt.pts(), this.video_c.time_base(), this.video_st.time_base()));
/*     */         }
/* 703 */         if (this.video_pkt.dts() != avutil.AV_NOPTS_VALUE) {
/* 704 */           this.video_pkt.dts(avutil.av_rescale_q(this.video_pkt.dts(), this.video_c.time_base(), this.video_st.time_base()));
/*     */         }
/* 706 */         this.video_pkt.stream_index(this.video_st.index());
/*     */       } else {
/* 708 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 712 */     synchronized (this.oc)
/*     */     {
/* 714 */       if ((this.interleaved) && (this.audio_st != null))
/*     */       {
/*     */         int ret;
/* 715 */         if ((ret = avformat.av_interleaved_write_frame(this.oc, this.video_pkt)) < 0)
/* 716 */           throw new FrameRecorder.Exception("av_interleaved_write_frame() error " + ret + " while writing interleaved video frame.");
/*     */       }
/*     */       else
/*     */       {
/*     */         int ret;
/* 719 */         if ((ret = avformat.av_write_frame(this.oc, this.video_pkt)) < 0) {
/* 720 */           throw new FrameRecorder.Exception("av_write_frame() error " + ret + " while writing video frame.");
/*     */         }
/*     */       }
/*     */     }
/* 724 */     return this.picture.key_frame() != 0;
/*     */   }
/*     */ 
/*     */   public boolean record(int sampleRate, Buffer[] samples) throws FrameRecorder.Exception {
/* 728 */     if (this.audio_st == null) {
/* 729 */       throw new FrameRecorder.Exception("No audio output stream (Is audioChannels > 0 and has start() been called?)");
/*     */     }
/*     */ 
/* 733 */     int inputSize = samples[0].limit() - samples[0].position();
/* 734 */     int inputFormat = -1;
/* 735 */     int inputChannels = samples.length > 1 ? 1 : this.audioChannels;
/* 736 */     int inputDepth = 0;
/* 737 */     int outputFormat = this.audio_c.sample_fmt();
/* 738 */     int outputChannels = this.samples_out.length > 1 ? 1 : this.audioChannels;
/* 739 */     int outputDepth = avutil.av_get_bytes_per_sample(outputFormat);
/* 740 */     if (sampleRate <= 0) {
/* 741 */       sampleRate = this.audio_c.sample_rate();
/*     */     }
/* 743 */     if ((samples[0] instanceof ByteBuffer)) {
/* 744 */       inputFormat = samples.length > 1 ? 5 : 0;
/* 745 */       inputDepth = 1;
/* 746 */       for (int i = 0; i < samples.length; i++) {
/* 747 */         ByteBuffer b = (ByteBuffer)samples[i];
/* 748 */         if (((this.samples_in[i] instanceof BytePointer)) && (this.samples_in[i].capacity() >= inputSize) && (b.hasArray()))
/* 749 */           ((BytePointer)this.samples_in[i]).position(0).put(b.array(), b.position(), inputSize);
/*     */         else
/* 751 */           this.samples_in[i] = new BytePointer(b);
/*     */       }
/*     */     }
/* 754 */     else if ((samples[0] instanceof ShortBuffer)) {
/* 755 */       inputFormat = samples.length > 1 ? 6 : 1;
/* 756 */       inputDepth = 2;
/* 757 */       for (int i = 0; i < samples.length; i++) {
/* 758 */         ShortBuffer b = (ShortBuffer)samples[i];
/* 759 */         if (((this.samples_in[i] instanceof ShortPointer)) && (this.samples_in[i].capacity() >= inputSize) && (b.hasArray()))
/* 760 */           ((ShortPointer)this.samples_in[i]).position(0).put(b.array(), samples[i].position(), inputSize);
/*     */         else
/* 762 */           this.samples_in[i] = new ShortPointer(b);
/*     */       }
/*     */     }
/* 765 */     else if ((samples[0] instanceof IntBuffer)) {
/* 766 */       inputFormat = samples.length > 1 ? 7 : 2;
/* 767 */       inputDepth = 4;
/* 768 */       for (int i = 0; i < samples.length; i++) {
/* 769 */         IntBuffer b = (IntBuffer)samples[i];
/* 770 */         if (((this.samples_in[i] instanceof IntPointer)) && (this.samples_in[i].capacity() >= inputSize) && (b.hasArray()))
/* 771 */           ((IntPointer)this.samples_in[i]).position(0).put(b.array(), samples[i].position(), inputSize);
/*     */         else
/* 773 */           this.samples_in[i] = new IntPointer(b);
/*     */       }
/*     */     }
/* 776 */     else if ((samples[0] instanceof FloatBuffer)) {
/* 777 */       inputFormat = samples.length > 1 ? 8 : 3;
/* 778 */       inputDepth = 4;
/* 779 */       for (int i = 0; i < samples.length; i++) {
/* 780 */         FloatBuffer b = (FloatBuffer)samples[i];
/* 781 */         if (((this.samples_in[i] instanceof FloatPointer)) && (this.samples_in[i].capacity() >= inputSize) && (b.hasArray()))
/* 782 */           ((FloatPointer)this.samples_in[i]).position(0).put(b.array(), b.position(), inputSize);
/*     */         else
/* 784 */           this.samples_in[i] = new FloatPointer(b);
/*     */       }
/*     */     }
/* 787 */     else if ((samples[0] instanceof DoubleBuffer)) {
/* 788 */       inputFormat = samples.length > 1 ? 9 : 4;
/* 789 */       inputDepth = 8;
/* 790 */       for (int i = 0; i < samples.length; i++) {
/* 791 */         DoubleBuffer b = (DoubleBuffer)samples[i];
/* 792 */         if (((this.samples_in[i] instanceof DoublePointer)) && (this.samples_in[i].capacity() >= inputSize) && (b.hasArray()))
/* 793 */           ((DoublePointer)this.samples_in[i]).position(0).put(b.array(), b.position(), inputSize);
/*     */         else
/* 795 */           this.samples_in[i] = new DoublePointer(b);
/*     */       }
/*     */     }
/*     */     else {
/* 799 */       throw new FrameRecorder.Exception("Audio samples Buffer has unsupported type: " + samples);
/*     */     }
/*     */ 
/* 802 */     if (this.samples_convert_ctx == null) {
/* 803 */       this.samples_convert_ctx = swresample.swr_alloc_set_opts(null, this.audio_c.channel_layout(), outputFormat, this.audio_c.sample_rate(), this.audio_c.channel_layout(), inputFormat, sampleRate, 0, null);
/*     */ 
/* 806 */       if (this.samples_convert_ctx == null)
/* 807 */         throw new FrameRecorder.Exception("swr_alloc_set_opts() error: Cannot allocate the conversion context.");
/*     */       int ret;
/* 808 */       if ((ret = swresample.swr_init(this.samples_convert_ctx)) < 0) {
/* 809 */         throw new FrameRecorder.Exception("swr_init() error " + ret + ": Cannot initialize the conversion context.");
/*     */       }
/*     */     }
/*     */ 
/* 813 */     for (int i = 0; i < samples.length; i++) {
/* 814 */       this.samples_in[i].position(this.samples_in[i].position() * inputDepth).limit((this.samples_in[i].position() + inputSize) * inputDepth);
/*     */     }
/*     */     while (true)
/*     */     {
/* 818 */       int inputCount = (this.samples_in[0].limit() - this.samples_in[0].position()) / (inputChannels * inputDepth);
/* 819 */       int outputCount = (this.samples_out[0].limit() - this.samples_out[0].position()) / (outputChannels * outputDepth);
/* 820 */       inputCount = Math.min(inputCount, 2 * (outputCount * sampleRate) / this.audio_c.sample_rate());
/* 821 */       for (int i = 0; i < samples.length; i++) {
/* 822 */         this.samples_in_ptr.put(i, this.samples_in[i]);
/*     */       }
/* 824 */       for (int i = 0; i < this.samples_out.length; i++)
/* 825 */         this.samples_out_ptr.put(i, this.samples_out[i]);
/*     */       int ret;
/* 827 */       if ((ret = swresample.swr_convert(this.samples_convert_ctx, this.samples_out_ptr, outputCount, this.samples_in_ptr, inputCount)) < 0)
/* 828 */         throw new FrameRecorder.Exception("swr_convert() error " + ret + ": Cannot convert audio samples.");
/* 829 */       if (ret == 0) {
/*     */         break;
/*     */       }
/* 832 */       for (int i = 0; i < samples.length; i++) {
/* 833 */         this.samples_in[i].position(this.samples_in[i].position() + inputCount * inputChannels * inputDepth);
/*     */       }
/* 835 */       for (int i = 0; i < this.samples_out.length; i++) {
/* 836 */         this.samples_out[i].position(this.samples_out[i].position() + ret * outputChannels * outputDepth);
/*     */       }
/*     */ 
/* 839 */       if (this.samples_out[0].position() >= this.samples_out[0].limit()) {
/* 840 */         this.frame.nb_samples(this.audio_input_frame_size);
/* 841 */         avcodec.avcodec_fill_audio_frame(this.frame, this.audio_c.channels(), outputFormat, this.samples_out[0], this.samples_out[0].limit(), 0);
/* 842 */         for (int i = 0; i < this.samples_out.length; i++) {
/* 843 */           this.frame.data(i, this.samples_out[i].position(0));
/* 844 */           this.frame.linesize(i, this.samples_out[i].limit());
/*     */         }
/* 846 */         this.frame.quality(this.audio_c.global_quality());
/* 847 */         record(this.frame);
/*     */       }
/*     */     }
/* 850 */     return this.frame.key_frame() != 0;
/*     */   }
/*     */ 
/*     */   boolean record(avutil.AVFrame frame)
/*     */     throws FrameRecorder.Exception
/*     */   {
/* 856 */     avcodec.av_init_packet(this.audio_pkt);
/* 857 */     this.audio_pkt.data(this.audio_outbuf);
/* 858 */     this.audio_pkt.size(this.audio_outbuf_size);
/*     */     int ret;
/* 859 */     if ((ret = avcodec.avcodec_encode_audio2(this.audio_c, this.audio_pkt, frame, this.got_audio_packet)) < 0) {
/* 860 */       throw new FrameRecorder.Exception("avcodec_encode_audio2() error " + ret + ": Could not encode audio packet.");
/*     */     }
/* 862 */     if (this.got_audio_packet[0] != 0) {
/* 863 */       if (this.audio_pkt.pts() != avutil.AV_NOPTS_VALUE) {
/* 864 */         this.audio_pkt.pts(avutil.av_rescale_q(this.audio_pkt.pts(), this.audio_c.time_base(), this.audio_c.time_base()));
/*     */       }
/* 866 */       if (this.audio_pkt.dts() != avutil.AV_NOPTS_VALUE) {
/* 867 */         this.audio_pkt.dts(avutil.av_rescale_q(this.audio_pkt.dts(), this.audio_c.time_base(), this.audio_c.time_base()));
/*     */       }
/* 869 */       this.audio_pkt.flags(this.audio_pkt.flags() | 0x1);
/* 870 */       this.audio_pkt.stream_index(this.audio_st.index());
/*     */     } else {
/* 872 */       return false;
/*     */     }
/*     */ 
/* 876 */     synchronized (this.oc) {
/* 877 */       if ((this.interleaved) && (this.video_st != null)) {
/* 878 */         if ((ret = avformat.av_interleaved_write_frame(this.oc, this.audio_pkt)) < 0) {
/* 879 */           throw new FrameRecorder.Exception("av_interleaved_write_frame() error " + ret + " while writing interleaved audio frame.");
/*     */         }
/*     */       }
/* 882 */       else if ((ret = avformat.av_write_frame(this.oc, this.audio_pkt)) < 0) {
/* 883 */         throw new FrameRecorder.Exception("av_write_frame() error " + ret + " while writing audio frame.");
/*     */       }
/*     */     }
/*     */ 
/* 887 */     return true;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  84 */     loadingException = null;
/*     */ 
/* 106 */     avformat.av_register_all();
/* 107 */     avformat.avformat_network_init();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.FFmpegFrameRecorder
 * JD-Core Version:    0.6.2
 */