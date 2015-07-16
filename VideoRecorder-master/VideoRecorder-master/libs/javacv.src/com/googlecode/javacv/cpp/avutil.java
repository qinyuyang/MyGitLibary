/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.DoublePointer;
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.LongPointer;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.ShortPointer;
/*      */ import com.googlecode.javacpp.SizeTPointer;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ 
/*      */ @Properties({@com.googlecode.javacpp.annotation.Platform(define={"__STDC_CONSTANT_MACROS"}, cinclude={"<libavutil/avutil.h>", "<libavutil/error.h>", "<libavutil/mem.h>", "<libavutil/mathematics.h>", "<libavutil/rational.h>", "<libavutil/log.h>", "<libavutil/buffer.h>", "<libavutil/frame.h>", "<libavutil/pixfmt.h>", "<libavutil/samplefmt.h>", "<libavutil/channel_layout.h>", "<libavutil/cpu.h>", "<libavutil/dict.h>", "<libavutil/opt.h>", "<libavutil/audioconvert.h>", "<libavutil/pixdesc.h>", "<libavutil/imgutils.h>"}, includepath={"/usr/local/include/ffmpeg/", "/opt/local/include/ffmpeg/", "/usr/include/ffmpeg/"}, link={"avutil@.52"}, options={"default", "nodeprecated"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, includepath={"C:/MinGW/local/include/ffmpeg/", "C:/MinGW/include/ffmpeg/", "src/main/resources/com/googlecode/javacv/cpp/"}, preload={"avutil-52"})})
/*      */ public class avutil
/*      */ {
/*      */   public static final int AVMEDIA_TYPE_UNKNOWN = -1;
/*      */   public static final int AVMEDIA_TYPE_VIDEO = 0;
/*      */   public static final int AVMEDIA_TYPE_AUDIO = 1;
/*      */   public static final int AVMEDIA_TYPE_DATA = 2;
/*      */   public static final int AVMEDIA_TYPE_SUBTITLE = 3;
/*      */   public static final int AVMEDIA_TYPE_ATTACHMENT = 4;
/*      */   public static final int AVMEDIA_TYPE_NB = 5;
/*      */   public static final int FF_LAMBDA_SHIFT = 7;
/*      */   public static final int FF_LAMBDA_SCALE = 128;
/*      */   public static final int FF_QP2LAMBDA = 118;
/*      */   public static final int FF_LAMBDA_MAX = 32767;
/*      */   public static final int FF_QUALITY_SCALE = 128;
/*  280 */   public static final long AV_NOPTS_VALUE = AV_NOPTS_VALUE();
/*      */   public static final int AV_TIME_BASE = 1000000;
/*      */   public static final int AV_PICTURE_TYPE_NONE = 0;
/*      */   public static final int AV_PICTURE_TYPE_I = 1;
/*      */   public static final int AV_PICTURE_TYPE_P = 2;
/*      */   public static final int AV_PICTURE_TYPE_B = 3;
/*      */   public static final int AV_PICTURE_TYPE_S = 4;
/*      */   public static final int AV_PICTURE_TYPE_SI = 5;
/*      */   public static final int AV_PICTURE_TYPE_SP = 6;
/*      */   public static final int AV_PICTURE_TYPE_BI = 7;
/*  433 */   public static final int AVERROR_BSF_NOT_FOUND = AVERROR_BSF_NOT_FOUND();
/*      */ 
/*  436 */   public static final int AVERROR_BUG = AVERROR_BUG();
/*      */ 
/*  439 */   public static final int AVERROR_BUFFER_TOO_SMALL = AVERROR_BUFFER_TOO_SMALL();
/*      */ 
/*  442 */   public static final int AVERROR_DECODER_NOT_FOUND = AVERROR_DECODER_NOT_FOUND();
/*      */ 
/*  445 */   public static final int AVERROR_DEMUXER_NOT_FOUND = AVERROR_DEMUXER_NOT_FOUND();
/*      */ 
/*  448 */   public static final int AVERROR_ENCODER_NOT_FOUND = AVERROR_ENCODER_NOT_FOUND();
/*      */ 
/*  451 */   public static final int AVERROR_EOF = AVERROR_EOF();
/*      */ 
/*  454 */   public static final int AVERROR_EXIT = AVERROR_EXIT();
/*      */ 
/*  457 */   public static final int AVERROR_EXTERNAL = AVERROR_EXTERNAL();
/*      */ 
/*  460 */   public static final int AVERROR_FILTER_NOT_FOUND = AVERROR_FILTER_NOT_FOUND();
/*      */ 
/*  463 */   public static final int AVERROR_INVALIDDATA = AVERROR_INVALIDDATA();
/*      */ 
/*  466 */   public static final int AVERROR_MUXER_NOT_FOUND = AVERROR_MUXER_NOT_FOUND();
/*      */ 
/*  469 */   public static final int AVERROR_OPTION_NOT_FOUND = AVERROR_OPTION_NOT_FOUND();
/*      */ 
/*  472 */   public static final int AVERROR_PATCHWELCOME = AVERROR_PATCHWELCOME();
/*      */ 
/*  475 */   public static final int AVERROR_PROTOCOL_NOT_FOUND = AVERROR_PROTOCOL_NOT_FOUND();
/*      */ 
/*  479 */   public static final int AVERROR_STREAM_NOT_FOUND = AVERROR_STREAM_NOT_FOUND();
/*      */ 
/*  485 */   public static final int AVERROR_BUG2 = AVERROR_BUG2();
/*      */ 
/*  488 */   public static final int AVERROR_UNKNOWN = AVERROR_UNKNOWN();
/*      */   public static final int AVERROR_EXPERIMENTAL = -733130664;
/*      */   public static final int AV_ERROR_MAX_STRING_SIZE = 64;
/*      */   public static final double M_E = 2.718281828459045D;
/*      */   public static final double M_LN2 = 0.6931471805599453D;
/*      */   public static final double M_LN10 = 2.302585092994046D;
/*      */   public static final double M_LOG2_10 = 3.321928094887362D;
/*      */   public static final double M_PHI = 1.618033988749895D;
/*      */   public static final double M_PI = 3.141592653589793D;
/*      */   public static final double M_SQRT1_2 = 0.7071067811865476D;
/*      */   public static final double M_SQRT2 = 1.414213562373095D;
/*  933 */   public static final int NAN = NAN();
/*      */ 
/*  937 */   public static final int INFINITY = INFINITY();
/*      */   public static final int AV_ROUND_ZERO = 0;
/*      */   public static final int AV_ROUND_INF = 1;
/*      */   public static final int AV_ROUND_DOWN = 2;
/*      */   public static final int AV_ROUND_UP = 3;
/*      */   public static final int AV_ROUND_NEAR_INF = 5;
/*      */   public static final int AV_ROUND_PASS_MINMAX = 8192;
/*      */   public static final int AV_CLASS_CATEGORY_NA = 0;
/*      */   public static final int AV_CLASS_CATEGORY_INPUT = 1;
/*      */   public static final int AV_CLASS_CATEGORY_OUTPUT = 2;
/*      */   public static final int AV_CLASS_CATEGORY_MUXER = 3;
/*      */   public static final int AV_CLASS_CATEGORY_DEMUXER = 4;
/*      */   public static final int AV_CLASS_CATEGORY_ENCODER = 5;
/*      */   public static final int AV_CLASS_CATEGORY_DECODER = 6;
/*      */   public static final int AV_CLASS_CATEGORY_FILTER = 7;
/*      */   public static final int AV_CLASS_CATEGORY_BITSTREAM_FILTER = 8;
/*      */   public static final int AV_CLASS_CATEGORY_SWSCALER = 9;
/*      */   public static final int AV_CLASS_CATEGORY_SWRESAMPLER = 10;
/*      */   public static final int AV_CLASS_CATEGORY_NB = 11;
/*      */   public static final int AV_LOG_QUIET = -8;
/*      */   public static final int AV_LOG_PANIC = 0;
/*      */   public static final int AV_LOG_FATAL = 8;
/*      */   public static final int AV_LOG_ERROR = 16;
/*      */   public static final int AV_LOG_WARNING = 24;
/*      */   public static final int AV_LOG_INFO = 32;
/*      */   public static final int AV_LOG_VERBOSE = 40;
/*      */   public static final int AV_LOG_DEBUG = 48;
/*      */   public static final int AV_LOG_MAX_OFFSET = 56;
/*      */   public static final int AV_LOG_SKIP_REPEATED = 1;
/*      */   public static final int AV_BUFFER_FLAG_READONLY = 1;
/*      */   public static final int AVCOL_SPC_RGB = 0;
/*      */   public static final int AVCOL_SPC_BT709 = 1;
/*      */   public static final int AVCOL_SPC_UNSPECIFIED = 2;
/*      */   public static final int AVCOL_SPC_FCC = 4;
/*      */   public static final int AVCOL_SPC_BT470BG = 5;
/*      */   public static final int AVCOL_SPC_SMPTE170M = 6;
/*      */   public static final int AVCOL_SPC_SMPTE240M = 7;
/*      */   public static final int AVCOL_SPC_YCOCG = 8;
/*      */   public static final int AVCOL_SPC_NB = 9;
/*      */   public static final int AVCOL_SPC_YCGCO = 8;
/*      */   public static final int AVCOL_RANGE_UNSPECIFIED = 0;
/*      */   public static final int AVCOL_RANGE_MPEG = 1;
/*      */   public static final int AVCOL_RANGE_JPEG = 2;
/*      */   public static final int AVCOL_RANGE_NB = 3;
/*      */   public static final int AV_FRAME_DATA_PANSCAN = 0;
/*      */   public static final int AVPALETTE_SIZE = 1024;
/*      */   public static final int AVPALETTE_COUNT = 256;
/*      */   public static final int AV_PIX_FMT_NONE = -1;
/*      */   public static final int AV_PIX_FMT_YUV420P = 0;
/*      */   public static final int AV_PIX_FMT_YUYV422 = 1;
/*      */   public static final int AV_PIX_FMT_RGB24 = 2;
/*      */   public static final int AV_PIX_FMT_BGR24 = 3;
/*      */   public static final int AV_PIX_FMT_YUV422P = 4;
/*      */   public static final int AV_PIX_FMT_YUV444P = 5;
/*      */   public static final int AV_PIX_FMT_YUV410P = 6;
/*      */   public static final int AV_PIX_FMT_YUV411P = 7;
/*      */   public static final int AV_PIX_FMT_GRAY8 = 8;
/*      */   public static final int AV_PIX_FMT_MONOWHITE = 9;
/*      */   public static final int AV_PIX_FMT_MONOBLACK = 10;
/*      */   public static final int AV_PIX_FMT_PAL8 = 11;
/*      */   public static final int AV_PIX_FMT_YUVJ420P = 12;
/*      */   public static final int AV_PIX_FMT_YUVJ422P = 13;
/*      */   public static final int AV_PIX_FMT_YUVJ444P = 14;
/*      */   public static final int AV_PIX_FMT_XVMC_MPEG2_MC = 15;
/*      */   public static final int AV_PIX_FMT_XVMC_MPEG2_IDCT = 16;
/*      */   public static final int AV_PIX_FMT_UYVY422 = 17;
/*      */   public static final int AV_PIX_FMT_UYYVYY411 = 18;
/*      */   public static final int AV_PIX_FMT_BGR8 = 19;
/*      */   public static final int AV_PIX_FMT_BGR4 = 20;
/*      */   public static final int AV_PIX_FMT_BGR4_BYTE = 21;
/*      */   public static final int AV_PIX_FMT_RGB8 = 22;
/*      */   public static final int AV_PIX_FMT_RGB4 = 23;
/*      */   public static final int AV_PIX_FMT_RGB4_BYTE = 24;
/*      */   public static final int AV_PIX_FMT_NV12 = 25;
/*      */   public static final int AV_PIX_FMT_NV21 = 26;
/*      */   public static final int AV_PIX_FMT_ARGB = 27;
/*      */   public static final int AV_PIX_FMT_RGBA = 28;
/*      */   public static final int AV_PIX_FMT_ABGR = 29;
/*      */   public static final int AV_PIX_FMT_BGRA = 30;
/*      */   public static final int AV_PIX_FMT_GRAY16BE = 31;
/*      */   public static final int AV_PIX_FMT_GRAY16LE = 32;
/*      */   public static final int AV_PIX_FMT_YUV440P = 33;
/*      */   public static final int AV_PIX_FMT_YUVJ440P = 34;
/*      */   public static final int AV_PIX_FMT_YUVA420P = 35;
/*      */   public static final int AV_PIX_FMT_VDPAU_H264 = 36;
/*      */   public static final int AV_PIX_FMT_VDPAU_MPEG1 = 37;
/*      */   public static final int AV_PIX_FMT_VDPAU_MPEG2 = 38;
/*      */   public static final int AV_PIX_FMT_VDPAU_WMV3 = 39;
/*      */   public static final int AV_PIX_FMT_VDPAU_VC1 = 40;
/*      */   public static final int AV_PIX_FMT_RGB48BE = 41;
/*      */   public static final int AV_PIX_FMT_RGB48LE = 42;
/*      */   public static final int AV_PIX_FMT_RGB565BE = 43;
/*      */   public static final int AV_PIX_FMT_RGB565LE = 44;
/*      */   public static final int AV_PIX_FMT_RGB555BE = 45;
/*      */   public static final int AV_PIX_FMT_RGB555LE = 46;
/*      */   public static final int AV_PIX_FMT_BGR565BE = 47;
/*      */   public static final int AV_PIX_FMT_BGR565LE = 48;
/*      */   public static final int AV_PIX_FMT_BGR555BE = 49;
/*      */   public static final int AV_PIX_FMT_BGR555LE = 50;
/*      */   public static final int AV_PIX_FMT_VAAPI_MOCO = 51;
/*      */   public static final int AV_PIX_FMT_VAAPI_IDCT = 52;
/*      */   public static final int AV_PIX_FMT_VAAPI_VLD = 53;
/*      */   public static final int AV_PIX_FMT_YUV420P16LE = 54;
/*      */   public static final int AV_PIX_FMT_YUV420P16BE = 55;
/*      */   public static final int AV_PIX_FMT_YUV422P16LE = 56;
/*      */   public static final int AV_PIX_FMT_YUV422P16BE = 57;
/*      */   public static final int AV_PIX_FMT_YUV444P16LE = 58;
/*      */   public static final int AV_PIX_FMT_YUV444P16BE = 59;
/*      */   public static final int AV_PIX_FMT_VDPAU_MPEG4 = 60;
/*      */   public static final int AV_PIX_FMT_DXVA2_VLD = 61;
/*      */   public static final int AV_PIX_FMT_RGB444LE = 62;
/*      */   public static final int AV_PIX_FMT_RGB444BE = 63;
/*      */   public static final int AV_PIX_FMT_BGR444LE = 64;
/*      */   public static final int AV_PIX_FMT_BGR444BE = 65;
/*      */   public static final int AV_PIX_FMT_GRAY8A = 66;
/*      */   public static final int AV_PIX_FMT_BGR48BE = 67;
/*      */   public static final int AV_PIX_FMT_BGR48LE = 68;
/*      */   public static final int AV_PIX_FMT_YUV420P9BE = 69;
/*      */   public static final int AV_PIX_FMT_YUV420P9LE = 70;
/*      */   public static final int AV_PIX_FMT_YUV420P10BE = 71;
/*      */   public static final int AV_PIX_FMT_YUV420P10LE = 72;
/*      */   public static final int AV_PIX_FMT_YUV422P10BE = 73;
/*      */   public static final int AV_PIX_FMT_YUV422P10LE = 74;
/*      */   public static final int AV_PIX_FMT_YUV444P9BE = 75;
/*      */   public static final int AV_PIX_FMT_YUV444P9LE = 76;
/*      */   public static final int AV_PIX_FMT_YUV444P10BE = 77;
/*      */   public static final int AV_PIX_FMT_YUV444P10LE = 78;
/*      */   public static final int AV_PIX_FMT_YUV422P9BE = 79;
/*      */   public static final int AV_PIX_FMT_YUV422P9LE = 80;
/*      */   public static final int AV_PIX_FMT_VDA_VLD = 81;
/*      */   public static final int AV_PIX_FMT_GBRP = 82;
/*      */   public static final int AV_PIX_FMT_GBRP9BE = 83;
/*      */   public static final int AV_PIX_FMT_GBRP9LE = 84;
/*      */   public static final int AV_PIX_FMT_GBRP10BE = 85;
/*      */   public static final int AV_PIX_FMT_GBRP10LE = 86;
/*      */   public static final int AV_PIX_FMT_GBRP16BE = 87;
/*      */   public static final int AV_PIX_FMT_GBRP16LE = 88;
/*      */   public static final int AV_PIX_FMT_YUVA422P_LIBAV = 89;
/*      */   public static final int AV_PIX_FMT_YUVA444P_LIBAV = 90;
/*      */   public static final int AV_PIX_FMT_YUVA420P9BE = 91;
/*      */   public static final int AV_PIX_FMT_YUVA420P9LE = 92;
/*      */   public static final int AV_PIX_FMT_YUVA422P9BE = 93;
/*      */   public static final int AV_PIX_FMT_YUVA422P9LE = 94;
/*      */   public static final int AV_PIX_FMT_YUVA444P9BE = 95;
/*      */   public static final int AV_PIX_FMT_YUVA444P9LE = 96;
/*      */   public static final int AV_PIX_FMT_YUVA420P10BE = 97;
/*      */   public static final int AV_PIX_FMT_YUVA420P10LE = 98;
/*      */   public static final int AV_PIX_FMT_YUVA422P10BE = 99;
/*      */   public static final int AV_PIX_FMT_YUVA422P10LE = 100;
/*      */   public static final int AV_PIX_FMT_YUVA444P10BE = 101;
/*      */   public static final int AV_PIX_FMT_YUVA444P10LE = 102;
/*      */   public static final int AV_PIX_FMT_YUVA420P16BE = 103;
/*      */   public static final int AV_PIX_FMT_YUVA420P16LE = 104;
/*      */   public static final int AV_PIX_FMT_YUVA422P16BE = 105;
/*      */   public static final int AV_PIX_FMT_YUVA422P16LE = 106;
/*      */   public static final int AV_PIX_FMT_YUVA444P16BE = 107;
/*      */   public static final int AV_PIX_FMT_YUVA444P16LE = 108;
/*      */   public static final int AV_PIX_FMT_VDPAU = 109;
/*      */   public static final int AV_PIX_FMT_XYZ12LE = 110;
/*      */   public static final int AV_PIX_FMT_XYZ12BE = 111;
/*      */   public static final int AV_PIX_FMT_NV16 = 112;
/*      */   public static final int AV_PIX_FMT_NV20LE = 113;
/*      */   public static final int AV_PIX_FMT_NV20BE = 114;
/*      */   public static final int AV_PIX_FMT_RGBA64BE = 291;
/*      */   public static final int AV_PIX_FMT_RGBA64LE = 292;
/*      */   public static final int AV_PIX_FMT_BGRA64BE = 293;
/*      */   public static final int AV_PIX_FMT_BGRA64LE = 294;
/*      */   public static final int AV_PIX_FMT_0RGB = 295;
/*      */   public static final int AV_PIX_FMT_RGB0 = 296;
/*      */   public static final int AV_PIX_FMT_0BGR = 297;
/*      */   public static final int AV_PIX_FMT_BGR0 = 298;
/*      */   public static final int AV_PIX_FMT_YUVA444P = 299;
/*      */   public static final int AV_PIX_FMT_YUVA422P = 300;
/*      */   public static final int AV_PIX_FMT_YUV420P12BE = 301;
/*      */   public static final int AV_PIX_FMT_YUV420P12LE = 302;
/*      */   public static final int AV_PIX_FMT_YUV420P14BE = 303;
/*      */   public static final int AV_PIX_FMT_YUV420P14LE = 304;
/*      */   public static final int AV_PIX_FMT_YUV422P12BE = 305;
/*      */   public static final int AV_PIX_FMT_YUV422P12LE = 306;
/*      */   public static final int AV_PIX_FMT_YUV422P14BE = 307;
/*      */   public static final int AV_PIX_FMT_YUV422P14LE = 308;
/*      */   public static final int AV_PIX_FMT_YUV444P12BE = 309;
/*      */   public static final int AV_PIX_FMT_YUV444P12LE = 310;
/*      */   public static final int AV_PIX_FMT_YUV444P14BE = 311;
/*      */   public static final int AV_PIX_FMT_YUV444P14LE = 312;
/*      */   public static final int AV_PIX_FMT_GBRP12BE = 313;
/*      */   public static final int AV_PIX_FMT_GBRP12LE = 314;
/*      */   public static final int AV_PIX_FMT_GBRP14BE = 315;
/*      */   public static final int AV_PIX_FMT_GBRP14LE = 316;
/*      */   public static final int AV_PIX_FMT_GBRAP = 317;
/*      */   public static final int AV_PIX_FMT_GBRAP16BE = 318;
/*      */   public static final int AV_PIX_FMT_GBRAP16LE = 319;
/*      */   public static final int AV_PIX_FMT_YUVJ411P = 320;
/*      */   public static final int AV_PIX_FMT_BAYER_BGGR8 = 321;
/*      */   public static final int AV_PIX_FMT_BAYER_RGGB8 = 322;
/*      */   public static final int AV_PIX_FMT_BAYER_GBRG8 = 323;
/*      */   public static final int AV_PIX_FMT_BAYER_GRBG8 = 324;
/*      */   public static final int AV_PIX_FMT_BAYER_BGGR16LE = 325;
/*      */   public static final int AV_PIX_FMT_BAYER_BGGR16BE = 326;
/*      */   public static final int AV_PIX_FMT_BAYER_RGGB16LE = 327;
/*      */   public static final int AV_PIX_FMT_BAYER_RGGB16BE = 328;
/*      */   public static final int AV_PIX_FMT_BAYER_GBRG16LE = 329;
/*      */   public static final int AV_PIX_FMT_BAYER_GBRG16BE = 330;
/*      */   public static final int AV_PIX_FMT_BAYER_GRBG16LE = 331;
/*      */   public static final int AV_PIX_FMT_BAYER_GRBG16BE = 332;
/*      */   public static final int AV_PIX_FMT_NB = 333;
/*      */   public static final int AV_PIX_FMT_Y400A = 66;
/*      */   public static final int AV_PIX_FMT_GBR24P = 82;
/* 3054 */   public static final int AV_PIX_FMT_RGB32 = AV_PIX_FMT_RGB32();
/*      */ 
/* 3056 */   public static final int AV_PIX_FMT_RGB32_1 = AV_PIX_FMT_RGB32_1();
/*      */ 
/* 3058 */   public static final int AV_PIX_FMT_BGR32 = AV_PIX_FMT_BGR32();
/*      */ 
/* 3060 */   public static final int AV_PIX_FMT_BGR32_1 = AV_PIX_FMT_BGR32_1();
/*      */ 
/* 3062 */   public static final int AV_PIX_FMT_0RGB32 = AV_PIX_FMT_0RGB32();
/*      */ 
/* 3064 */   public static final int AV_PIX_FMT_0BGR32 = AV_PIX_FMT_0BGR32();
/*      */ 
/* 3067 */   public static final int AV_PIX_FMT_GRAY16 = AV_PIX_FMT_GRAY16();
/*      */ 
/* 3069 */   public static final int AV_PIX_FMT_RGB48 = AV_PIX_FMT_RGB48();
/*      */ 
/* 3071 */   public static final int AV_PIX_FMT_RGB565 = AV_PIX_FMT_RGB565();
/*      */ 
/* 3073 */   public static final int AV_PIX_FMT_RGB555 = AV_PIX_FMT_RGB555();
/*      */ 
/* 3075 */   public static final int AV_PIX_FMT_RGB444 = AV_PIX_FMT_RGB444();
/*      */ 
/* 3077 */   public static final int AV_PIX_FMT_BGR48 = AV_PIX_FMT_BGR48();
/*      */ 
/* 3079 */   public static final int AV_PIX_FMT_BGR565 = AV_PIX_FMT_BGR565();
/*      */ 
/* 3081 */   public static final int AV_PIX_FMT_BGR555 = AV_PIX_FMT_BGR555();
/*      */ 
/* 3083 */   public static final int AV_PIX_FMT_BGR444 = AV_PIX_FMT_BGR444();
/*      */ 
/* 3086 */   public static final int AV_PIX_FMT_YUV420P9 = AV_PIX_FMT_YUV420P9();
/*      */ 
/* 3088 */   public static final int AV_PIX_FMT_YUV422P9 = AV_PIX_FMT_YUV422P9();
/*      */ 
/* 3090 */   public static final int AV_PIX_FMT_YUV444P9 = AV_PIX_FMT_YUV444P9();
/*      */ 
/* 3092 */   public static final int AV_PIX_FMT_YUV420P10 = AV_PIX_FMT_YUV420P10();
/*      */ 
/* 3094 */   public static final int AV_PIX_FMT_YUV422P10 = AV_PIX_FMT_YUV422P10();
/*      */ 
/* 3096 */   public static final int AV_PIX_FMT_YUV444P10 = AV_PIX_FMT_YUV444P10();
/*      */ 
/* 3098 */   public static final int AV_PIX_FMT_YUV420P12 = AV_PIX_FMT_YUV420P12();
/*      */ 
/* 3100 */   public static final int AV_PIX_FMT_YUV422P12 = AV_PIX_FMT_YUV422P12();
/*      */ 
/* 3102 */   public static final int AV_PIX_FMT_YUV444P12 = AV_PIX_FMT_YUV444P12();
/*      */ 
/* 3104 */   public static final int AV_PIX_FMT_YUV420P14 = AV_PIX_FMT_YUV420P14();
/*      */ 
/* 3106 */   public static final int AV_PIX_FMT_YUV422P14 = AV_PIX_FMT_YUV422P14();
/*      */ 
/* 3108 */   public static final int AV_PIX_FMT_YUV444P14 = AV_PIX_FMT_YUV444P14();
/*      */ 
/* 3110 */   public static final int AV_PIX_FMT_YUV420P16 = AV_PIX_FMT_YUV420P16();
/*      */ 
/* 3112 */   public static final int AV_PIX_FMT_YUV422P16 = AV_PIX_FMT_YUV422P16();
/*      */ 
/* 3114 */   public static final int AV_PIX_FMT_YUV444P16 = AV_PIX_FMT_YUV444P16();
/*      */ 
/* 3117 */   public static final int AV_PIX_FMT_RGBA64 = AV_PIX_FMT_RGBA64();
/*      */ 
/* 3119 */   public static final int AV_PIX_FMT_BGRA64 = AV_PIX_FMT_BGRA64();
/*      */ 
/* 3121 */   public static final int AV_PIX_FMT_GBRP9 = AV_PIX_FMT_GBRP9();
/*      */ 
/* 3123 */   public static final int AV_PIX_FMT_GBRP10 = AV_PIX_FMT_GBRP10();
/*      */ 
/* 3125 */   public static final int AV_PIX_FMT_GBRP12 = AV_PIX_FMT_GBRP12();
/*      */ 
/* 3127 */   public static final int AV_PIX_FMT_GBRP14 = AV_PIX_FMT_GBRP14();
/*      */ 
/* 3129 */   public static final int AV_PIX_FMT_GBRP16 = AV_PIX_FMT_GBRP16();
/*      */ 
/* 3131 */   public static final int AV_PIX_FMT_GBRAP16 = AV_PIX_FMT_GBRAP16();
/*      */ 
/* 3134 */   public static final int AV_PIX_FMT_BAYER_BGGR16 = AV_PIX_FMT_BAYER_BGGR16();
/*      */ 
/* 3136 */   public static final int AV_PIX_FMT_BAYER_RGGB16 = AV_PIX_FMT_BAYER_RGGB16();
/*      */ 
/* 3138 */   public static final int AV_PIX_FMT_BAYER_GBRG16 = AV_PIX_FMT_BAYER_GBRG16();
/*      */ 
/* 3140 */   public static final int AV_PIX_FMT_BAYER_GRBG16 = AV_PIX_FMT_BAYER_GRBG16();
/*      */ 
/* 3144 */   public static final int AV_PIX_FMT_YUVA420P9 = AV_PIX_FMT_YUVA420P9();
/*      */ 
/* 3146 */   public static final int AV_PIX_FMT_YUVA422P9 = AV_PIX_FMT_YUVA422P9();
/*      */ 
/* 3148 */   public static final int AV_PIX_FMT_YUVA444P9 = AV_PIX_FMT_YUVA444P9();
/*      */ 
/* 3150 */   public static final int AV_PIX_FMT_YUVA420P10 = AV_PIX_FMT_YUVA420P10();
/*      */ 
/* 3152 */   public static final int AV_PIX_FMT_YUVA422P10 = AV_PIX_FMT_YUVA422P10();
/*      */ 
/* 3154 */   public static final int AV_PIX_FMT_YUVA444P10 = AV_PIX_FMT_YUVA444P10();
/*      */ 
/* 3156 */   public static final int AV_PIX_FMT_YUVA420P16 = AV_PIX_FMT_YUVA420P16();
/*      */ 
/* 3158 */   public static final int AV_PIX_FMT_YUVA422P16 = AV_PIX_FMT_YUVA422P16();
/*      */ 
/* 3160 */   public static final int AV_PIX_FMT_YUVA444P16 = AV_PIX_FMT_YUVA444P16();
/*      */ 
/* 3163 */   public static final int AV_PIX_FMT_XYZ12 = AV_PIX_FMT_XYZ12();
/*      */ 
/* 3165 */   public static final int AV_PIX_FMT_NV20 = AV_PIX_FMT_NV20();
/*      */   public static final int PIX_FMT_Y400A = 66;
/*      */   public static final int PIX_FMT_GBR24P = 82;
/* 3175 */   public static final int PIX_FMT_RGB32 = AV_PIX_FMT_RGB32;
/* 3176 */   public static final int PIX_FMT_RGB32_1 = AV_PIX_FMT_RGB32_1;
/* 3177 */   public static final int PIX_FMT_BGR32 = AV_PIX_FMT_BGR32;
/* 3178 */   public static final int PIX_FMT_BGR32_1 = AV_PIX_FMT_BGR32_1;
/* 3179 */   public static final int PIX_FMT_0RGB32 = AV_PIX_FMT_0RGB32;
/* 3180 */   public static final int PIX_FMT_0BGR32 = AV_PIX_FMT_0BGR32;
/*      */ 
/* 3182 */   public static final int PIX_FMT_GRAY16 = AV_PIX_FMT_GRAY16;
/* 3183 */   public static final int PIX_FMT_RGB48 = AV_PIX_FMT_RGB48;
/* 3184 */   public static final int PIX_FMT_RGB565 = AV_PIX_FMT_RGB565;
/* 3185 */   public static final int PIX_FMT_RGB555 = AV_PIX_FMT_RGB555;
/* 3186 */   public static final int PIX_FMT_RGB444 = AV_PIX_FMT_RGB444;
/* 3187 */   public static final int PIX_FMT_BGR48 = AV_PIX_FMT_BGR48;
/* 3188 */   public static final int PIX_FMT_BGR565 = AV_PIX_FMT_BGR565;
/* 3189 */   public static final int PIX_FMT_BGR555 = AV_PIX_FMT_BGR555;
/* 3190 */   public static final int PIX_FMT_BGR444 = AV_PIX_FMT_BGR444;
/*      */ 
/* 3192 */   public static final int PIX_FMT_YUV420P9 = AV_PIX_FMT_YUV420P9;
/* 3193 */   public static final int PIX_FMT_YUV422P9 = AV_PIX_FMT_YUV422P9;
/* 3194 */   public static final int PIX_FMT_YUV444P9 = AV_PIX_FMT_YUV444P9;
/* 3195 */   public static final int PIX_FMT_YUV420P10 = AV_PIX_FMT_YUV420P10;
/* 3196 */   public static final int PIX_FMT_YUV422P10 = AV_PIX_FMT_YUV422P10;
/* 3197 */   public static final int PIX_FMT_YUV444P10 = AV_PIX_FMT_YUV444P10;
/* 3198 */   public static final int PIX_FMT_YUV420P12 = AV_PIX_FMT_YUV420P12;
/* 3199 */   public static final int PIX_FMT_YUV422P12 = AV_PIX_FMT_YUV422P12;
/* 3200 */   public static final int PIX_FMT_YUV444P12 = AV_PIX_FMT_YUV444P12;
/* 3201 */   public static final int PIX_FMT_YUV420P14 = AV_PIX_FMT_YUV420P14;
/* 3202 */   public static final int PIX_FMT_YUV422P14 = AV_PIX_FMT_YUV422P14;
/* 3203 */   public static final int PIX_FMT_YUV444P14 = AV_PIX_FMT_YUV444P14;
/* 3204 */   public static final int PIX_FMT_YUV420P16 = AV_PIX_FMT_YUV420P16;
/* 3205 */   public static final int PIX_FMT_YUV422P16 = AV_PIX_FMT_YUV422P16;
/* 3206 */   public static final int PIX_FMT_YUV444P16 = AV_PIX_FMT_YUV444P16;
/*      */ 
/* 3208 */   public static final int PIX_FMT_RGBA64 = AV_PIX_FMT_RGBA64;
/* 3209 */   public static final int PIX_FMT_BGRA64 = AV_PIX_FMT_BGRA64;
/* 3210 */   public static final int PIX_FMT_GBRP9 = AV_PIX_FMT_GBRP9;
/* 3211 */   public static final int PIX_FMT_GBRP10 = AV_PIX_FMT_GBRP10;
/* 3212 */   public static final int PIX_FMT_GBRP12 = AV_PIX_FMT_GBRP12;
/* 3213 */   public static final int PIX_FMT_GBRP14 = AV_PIX_FMT_GBRP14;
/* 3214 */   public static final int PIX_FMT_GBRP16 = AV_PIX_FMT_GBRP16;
/*      */   public static final int AV_SAMPLE_FMT_NONE = -1;
/*      */   public static final int AV_SAMPLE_FMT_U8 = 0;
/*      */   public static final int AV_SAMPLE_FMT_S16 = 1;
/*      */   public static final int AV_SAMPLE_FMT_S32 = 2;
/*      */   public static final int AV_SAMPLE_FMT_FLT = 3;
/*      */   public static final int AV_SAMPLE_FMT_DBL = 4;
/*      */   public static final int AV_SAMPLE_FMT_U8P = 5;
/*      */   public static final int AV_SAMPLE_FMT_S16P = 6;
/*      */   public static final int AV_SAMPLE_FMT_S32P = 7;
/*      */   public static final int AV_SAMPLE_FMT_FLTP = 8;
/*      */   public static final int AV_SAMPLE_FMT_DBLP = 9;
/*      */   public static final int AV_SAMPLE_FMT_NB = 10;
/*      */   public static final int AV_CH_FRONT_LEFT = 1;
/*      */   public static final int AV_CH_FRONT_RIGHT = 2;
/*      */   public static final int AV_CH_FRONT_CENTER = 4;
/*      */   public static final int AV_CH_LOW_FREQUENCY = 8;
/*      */   public static final int AV_CH_BACK_LEFT = 16;
/*      */   public static final int AV_CH_BACK_RIGHT = 32;
/*      */   public static final int AV_CH_FRONT_LEFT_OF_CENTER = 64;
/*      */   public static final int AV_CH_FRONT_RIGHT_OF_CENTER = 128;
/*      */   public static final int AV_CH_BACK_CENTER = 256;
/*      */   public static final int AV_CH_SIDE_LEFT = 512;
/*      */   public static final int AV_CH_SIDE_RIGHT = 1024;
/*      */   public static final int AV_CH_TOP_CENTER = 2048;
/*      */   public static final int AV_CH_TOP_FRONT_LEFT = 4096;
/*      */   public static final int AV_CH_TOP_FRONT_CENTER = 8192;
/*      */   public static final int AV_CH_TOP_FRONT_RIGHT = 16384;
/*      */   public static final int AV_CH_TOP_BACK_LEFT = 32768;
/*      */   public static final int AV_CH_TOP_BACK_CENTER = 65536;
/*      */   public static final int AV_CH_TOP_BACK_RIGHT = 131072;
/*      */   public static final int AV_CH_STEREO_LEFT = 536870912;
/*      */   public static final int AV_CH_STEREO_RIGHT = 1073741824;
/*      */   public static final long AV_CH_WIDE_LEFT = 2147483648L;
/*      */   public static final long AV_CH_WIDE_RIGHT = 4294967296L;
/*      */   public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
/*      */   public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
/*      */   public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
/*      */   public static final long AV_CH_LAYOUT_NATIVE = -9223372036854775808L;
/*      */   public static final int AV_CH_LAYOUT_MONO = 4;
/*      */   public static final int AV_CH_LAYOUT_STEREO = 3;
/*      */   public static final int AV_CH_LAYOUT_2POINT1 = 11;
/*      */   public static final int AV_CH_LAYOUT_2_1 = 259;
/*      */   public static final int AV_CH_LAYOUT_SURROUND = 7;
/*      */   public static final int AV_CH_LAYOUT_3POINT1 = 15;
/*      */   public static final int AV_CH_LAYOUT_4POINT0 = 263;
/*      */   public static final int AV_CH_LAYOUT_4POINT1 = 271;
/*      */   public static final int AV_CH_LAYOUT_2_2 = 1539;
/*      */   public static final int AV_CH_LAYOUT_QUAD = 51;
/*      */   public static final int AV_CH_LAYOUT_5POINT0 = 1543;
/*      */   public static final int AV_CH_LAYOUT_5POINT1 = 1551;
/*      */   public static final int AV_CH_LAYOUT_5POINT0_BACK = 55;
/*      */   public static final int AV_CH_LAYOUT_5POINT1_BACK = 63;
/*      */   public static final int AV_CH_LAYOUT_6POINT0 = 1799;
/*      */   public static final int AV_CH_LAYOUT_6POINT0_FRONT = 1731;
/*      */   public static final int AV_CH_LAYOUT_HEXAGONAL = 311;
/*      */   public static final int AV_CH_LAYOUT_6POINT1 = 1807;
/*      */   public static final int AV_CH_LAYOUT_6POINT1_BACK = 319;
/*      */   public static final int AV_CH_LAYOUT_6POINT1_FRONT = 1739;
/*      */   public static final int AV_CH_LAYOUT_7POINT0 = 1591;
/*      */   public static final int AV_CH_LAYOUT_7POINT0_FRONT = 1735;
/*      */   public static final int AV_CH_LAYOUT_7POINT1 = 1599;
/*      */   public static final int AV_CH_LAYOUT_7POINT1_WIDE = 1743;
/*      */   public static final int AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255;
/*      */   public static final int AV_CH_LAYOUT_OCTAGONAL = 1847;
/*      */   public static final int AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736;
/*      */   public static final int AV_MATRIX_ENCODING_NONE = 0;
/*      */   public static final int AV_MATRIX_ENCODING_DOLBY = 1;
/*      */   public static final int AV_MATRIX_ENCODING_DPLII = 2;
/*      */   public static final int AV_MATRIX_ENCODING_NB = 3;
/*      */   public static final int AV_CPU_FLAG_FORCE = -2147483648;
/*      */   public static final int AV_CPU_FLAG_MMX = 1;
/*      */   public static final int AV_CPU_FLAG_MMXEXT = 2;
/*      */   public static final int AV_CPU_FLAG_MMX2 = 2;
/*      */   public static final int AV_CPU_FLAG_3DNOW = 4;
/*      */   public static final int AV_CPU_FLAG_SSE = 8;
/*      */   public static final int AV_CPU_FLAG_SSE2 = 16;
/*      */   public static final int AV_CPU_FLAG_SSE2SLOW = 1073741824;
/*      */   public static final int AV_CPU_FLAG_3DNOWEXT = 32;
/*      */   public static final int AV_CPU_FLAG_SSE3 = 64;
/*      */   public static final int AV_CPU_FLAG_SSE3SLOW = 536870912;
/*      */   public static final int AV_CPU_FLAG_SSSE3 = 128;
/*      */   public static final int AV_CPU_FLAG_ATOM = 268435456;
/*      */   public static final int AV_CPU_FLAG_SSE4 = 256;
/*      */   public static final int AV_CPU_FLAG_SSE42 = 512;
/*      */   public static final int AV_CPU_FLAG_AVX = 16384;
/*      */   public static final int AV_CPU_FLAG_XOP = 1024;
/*      */   public static final int AV_CPU_FLAG_FMA4 = 2048;
/*      */   public static final int AV_CPU_FLAG_CMOV = 16781312;
/*      */   public static final int AV_CPU_FLAG_AVX2 = 32768;
/*      */   public static final int AV_CPU_FLAG_ALTIVEC = 1;
/*      */   public static final int AV_CPU_FLAG_ARMV5TE = 1;
/*      */   public static final int AV_CPU_FLAG_ARMV6 = 2;
/*      */   public static final int AV_CPU_FLAG_ARMV6T2 = 4;
/*      */   public static final int AV_CPU_FLAG_VFP = 8;
/*      */   public static final int AV_CPU_FLAG_VFPV3 = 16;
/*      */   public static final int AV_CPU_FLAG_NEON = 32;
/*      */ 
/*      */   /** @deprecated */
/*      */   public static final int AV_DICT_MATCH_CASE = 1;
/*      */   public static final int AV_DICT_IGNORE_SUFFIX = 2;
/*      */   public static final int AV_DICT_DONT_STRDUP_KEY = 4;
/*      */   public static final int AV_DICT_DONT_STRDUP_VAL = 8;
/*      */   public static final int AV_DICT_DONT_OVERWRITE = 16;
/*      */   public static final int AV_DICT_APPEND = 32;
/*      */   public static final int AV_OPT_TYPE_FLAGS = 0;
/*      */   public static final int AV_OPT_TYPE_INT = 1;
/*      */   public static final int AV_OPT_TYPE_INT64 = 2;
/*      */   public static final int AV_OPT_TYPE_DOUBLE = 3;
/*      */   public static final int AV_OPT_TYPE_FLOAT = 4;
/*      */   public static final int AV_OPT_TYPE_STRING = 5;
/*      */   public static final int AV_OPT_TYPE_RATIONAL = 6;
/*      */   public static final int AV_OPT_TYPE_BINARY = 7;
/*      */   public static final int AV_OPT_TYPE_CONST = 128;
/* 4330 */   public static final int AV_OPT_TYPE_IMAGE_SIZE = AV_OPT_TYPE_IMAGE_SIZE();
/*      */ 
/* 4333 */   public static final int AV_OPT_TYPE_PIXEL_FMT = AV_OPT_TYPE_PIXEL_FMT();
/*      */ 
/* 4336 */   public static final int AV_OPT_TYPE_SAMPLE_FMT = AV_OPT_TYPE_SAMPLE_FMT();
/*      */ 
/* 4340 */   public static final int AV_OPT_TYPE_VIDEO_RATE = AV_OPT_TYPE_VIDEO_RATE();
/*      */ 
/* 4343 */   public static final int AV_OPT_TYPE_DURATION = AV_OPT_TYPE_DURATION();
/*      */ 
/* 4346 */   public static final int AV_OPT_TYPE_COLOR = AV_OPT_TYPE_COLOR();
/*      */ 
/* 4349 */   public static final int AV_OPT_TYPE_CHANNEL_LAYOUT = AV_OPT_TYPE_CHANNEL_LAYOUT();
/*      */   public static final int FF_OPT_TYPE_FLAGS = 0;
/*      */   public static final int FF_OPT_TYPE_INT = 1;
/*      */   public static final int FF_OPT_TYPE_INT64 = 2;
/*      */   public static final int FF_OPT_TYPE_DOUBLE = 3;
/*      */   public static final int FF_OPT_TYPE_FLOAT = 4;
/*      */   public static final int FF_OPT_TYPE_STRING = 5;
/*      */   public static final int FF_OPT_TYPE_RATIONAL = 6;
/*      */   public static final int FF_OPT_TYPE_BINARY = 7;
/*      */   public static final int FF_OPT_TYPE_CONST = 128;
/*      */   public static final int AV_OPT_FLAG_IMPLICIT_KEY = 1;
/*      */   public static final int AV_OPT_SEARCH_CHILDREN = 1;
/*      */   public static final int AV_OPT_SEARCH_FAKE_OBJ = 2;
/*      */   public static final int AV_PIX_FMT_FLAG_BE = 1;
/*      */   public static final int AV_PIX_FMT_FLAG_PAL = 2;
/*      */   public static final int AV_PIX_FMT_FLAG_BITSTREAM = 4;
/*      */   public static final int AV_PIX_FMT_FLAG_HWACCEL = 8;
/*      */   public static final int AV_PIX_FMT_FLAG_PLANAR = 16;
/*      */   public static final int AV_PIX_FMT_FLAG_RGB = 32;
/*      */   public static final int AV_PIX_FMT_FLAG_PSEUDOPAL = 64;
/*      */   public static final int AV_PIX_FMT_FLAG_ALPHA = 128;
/*      */ 
/*      */   /** @deprecated */
/*      */   public static final int PIX_FMT_BE = 1;
/*      */   public static final int PIX_FMT_PAL = 2;
/*      */   public static final int PIX_FMT_BITSTREAM = 4;
/*      */   public static final int PIX_FMT_HWACCEL = 8;
/*      */   public static final int PIX_FMT_PLANAR = 16;
/*      */   public static final int PIX_FMT_RGB = 32;
/*      */   public static final int PIX_FMT_PSEUDOPAL = 64;
/*      */   public static final int PIX_FMT_ALPHA = 128;
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int avutil_version();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avutil_configuration();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avutil_license();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_media_type_string(@Cast({"AVMediaType"}) int paramInt);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native long AV_NOPTS_VALUE();
/*      */ 
/*      */   @Cast({"char"})
/*      */   public static native byte av_get_picture_type_char(@Cast({"AVPictureType"}) int paramInt);
/*      */ 
/*      */   public static native Pointer av_x_if_null(@Const Pointer paramPointer1, @Const Pointer paramPointer2);
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int av_int_list_length_for_size(@Cast({"unsigned"}) int paramInt, @Const Pointer paramPointer, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_BSF_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_BUG();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_BUFFER_TOO_SMALL();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_DECODER_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_DEMUXER_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_ENCODER_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_EOF();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_EXIT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_EXTERNAL();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_FILTER_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_INVALIDDATA();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_MUXER_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_OPTION_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_PATCHWELCOME();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_PROTOCOL_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_STREAM_NOT_FOUND();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_BUG2();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AVERROR_UNKNOWN();
/*      */ 
/*      */   public static native int av_strerror(int paramInt, @Cast({"char*"}) BytePointer paramBytePointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native int av_strerror(int paramInt, @Cast({"char*"}) ByteBuffer paramByteBuffer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native int av_strerror(int paramInt, @Cast({"char*"}) byte[] paramArrayOfByte, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native BytePointer av_make_error_string(@Cast({"char*"}) BytePointer paramBytePointer, @Cast({"size_t"}) long paramLong, int paramInt);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native ByteBuffer av_make_error_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, @Cast({"size_t"}) long paramLong, int paramInt);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native byte[] av_make_error_string(@Cast({"char*"}) byte[] paramArrayOfByte, @Cast({"size_t"}) long paramLong, int paramInt);
/*      */ 
/*      */   public static native Pointer av_malloc(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_malloc_array(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   public static native Pointer av_realloc(Pointer paramPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_realloc_f(Pointer paramPointer, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   public static native int av_reallocp(Pointer paramPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_realloc_array(Pointer paramPointer, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   public static native int av_reallocp_array(Pointer paramPointer, @Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   public static native void av_free(Pointer paramPointer);
/*      */ 
/*      */   public static native Pointer av_mallocz(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_calloc(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   public static native Pointer av_mallocz_array(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native BytePointer av_strdup(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native ByteBuffer av_strdup(String paramString);
/*      */ 
/*      */   public static native Pointer av_memdup(@Const Pointer paramPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_freep(Pointer paramPointer);
/*      */ 
/*      */   public static native void av_dynarray_add(Pointer paramPointer1, IntPointer paramIntPointer, Pointer paramPointer2);
/*      */ 
/*      */   public static native void av_dynarray_add(Pointer paramPointer1, IntBuffer paramIntBuffer, Pointer paramPointer2);
/*      */ 
/*      */   public static native void av_dynarray_add(Pointer paramPointer1, int[] paramArrayOfInt, Pointer paramPointer2);
/*      */ 
/*      */   public static native Pointer av_dynarray2_add(@Cast({"void**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong, @Cast({"const uint8_t*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native Pointer av_dynarray2_add(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong, @Cast({"const uint8_t*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native Pointer av_dynarray2_add(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, IntBuffer paramIntBuffer, @Cast({"size_t"}) long paramLong, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native Pointer av_dynarray2_add(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte);
/*      */ 
/*      */   public static native int av_size_mult(@Cast({"size_t"}) long paramLong1, @Cast({"size_t"}) long paramLong2, @Cast({"size_t*"}) SizeTPointer paramSizeTPointer);
/*      */ 
/*      */   public static native void av_max_alloc(@Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_memcpy_backptr(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_memcpy_backptr(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_memcpy_backptr(@Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int NAN();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int INFINITY();
/*      */ 
/*      */   @Const
/*      */   public static native long av_gcd(long paramLong1, long paramLong2);
/*      */ 
/*      */   public static native long av_rescale(long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native long av_rescale_rnd(long paramLong1, long paramLong2, long paramLong3, @Cast({"AVRounding"}) int paramInt);
/*      */ 
/*      */   public static native long av_rescale_q(long paramLong, @ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   public static native long av_rescale_q_rnd(long paramLong, @ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2, @Cast({"AVRounding"}) int paramInt);
/*      */ 
/*      */   public static native int av_compare_ts(long paramLong1, @ByVal AVRational paramAVRational1, long paramLong2, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   public static native long av_compare_mod(@Cast({"uint64_t"}) long paramLong1, @Cast({"uint64_t"}) long paramLong2, @Cast({"uint64_t"}) long paramLong3);
/*      */ 
/*      */   public static native long av_rescale_delta(@ByVal AVRational paramAVRational1, long paramLong, @ByVal AVRational paramAVRational2, int paramInt, LongPointer paramLongPointer, @ByVal AVRational paramAVRational3);
/*      */ 
/*      */   public static native long av_rescale_delta(@ByVal AVRational paramAVRational1, long paramLong, @ByVal AVRational paramAVRational2, int paramInt, LongBuffer paramLongBuffer, @ByVal AVRational paramAVRational3);
/*      */ 
/*      */   public static native long av_rescale_delta(@ByVal AVRational paramAVRational1, long paramLong, @ByVal AVRational paramAVRational2, int paramInt, long[] paramArrayOfLong, @ByVal AVRational paramAVRational3);
/*      */ 
/*      */   public static native int av_cmp_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   public static native double av_q2d(@ByVal AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_reduce(IntPointer paramIntPointer1, IntPointer paramIntPointer2, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native int av_reduce(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native int av_reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_mul_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_div_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_add_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_sub_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_inv_q(@ByVal AVRational paramAVRational);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_d2q(double paramDouble, int paramInt);
/*      */ 
/*      */   public static native int av_nearer_q(@ByVal AVRational paramAVRational1, @ByVal AVRational paramAVRational2, @ByVal AVRational paramAVRational3);
/*      */ 
/*      */   public static native int av_find_nearest_q_idx(@ByVal AVRational paramAVRational1, @Const AVRational paramAVRational2);
/*      */ 
/*      */   public static native void av_log(Pointer paramPointer, int paramInt, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native void av_log(Pointer paramPointer, int paramInt, String paramString);
/*      */ 
/*      */   public static native void av_vlog(Pointer paramPointer1, int paramInt, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */   public static native void av_vlog(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */   public static native int av_log_get_level();
/*      */ 
/*      */   public static native void av_log_set_level(int paramInt);
/*      */ 
/*      */   public static native void av_log_set_callback(Callback_Pointer_int_BytePointer_Pointer paramCallback_Pointer_int_BytePointer_Pointer);
/*      */ 
/*      */   public static native void av_log_set_callback(Callback_Pointer_int_String_Pointer paramCallback_Pointer_int_String_Pointer);
/*      */ 
/*      */   public static native void av_log_default_callback(Pointer paramPointer1, int paramInt, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */   public static native void av_log_default_callback(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_default_item_name(Pointer paramPointer);
/*      */ 
/*      */   @Cast({"AVClassCategory"})
/*      */   public static native int av_default_get_category(Pointer paramPointer);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer1, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt2, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt2, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt2, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native void av_log_format_line(Pointer paramPointer1, int paramInt1, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt2, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void av_log_set_flags(int paramInt);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_alloc(int paramInt);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_allocz(int paramInt);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_create(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, Free_Pointer_BytePointer paramFree_Pointer_BytePointer, Pointer paramPointer, int paramInt2);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_create(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt1, Free_Pointer_ByteBuffer paramFree_Pointer_ByteBuffer, Pointer paramPointer, int paramInt2);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_create(@Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt1, Free_Pointer_byte paramFree_Pointer_byte, Pointer paramPointer, int paramInt2);
/*      */ 
/*      */   public static native void av_buffer_default_free(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native void av_buffer_default_free(Pointer paramPointer, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native void av_buffer_default_free(Pointer paramPointer, @Cast({"uint8_t*"}) byte[] paramArrayOfByte);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_ref(AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native void av_buffer_unref(@Cast({"AVBufferRef**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void av_buffer_unref(@ByPtrPtr AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native int av_buffer_is_writable(@Const AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native Pointer av_buffer_get_opaque(@Const AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native int av_buffer_get_ref_count(@Const AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native int av_buffer_make_writable(@Cast({"AVBufferRef**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int av_buffer_make_writable(@ByPtrPtr AVBufferRef paramAVBufferRef);
/*      */ 
/*      */   public static native int av_buffer_realloc(@Cast({"AVBufferRef**"}) PointerPointer paramPointerPointer, int paramInt);
/*      */ 
/*      */   public static native int av_buffer_realloc(@ByPtrPtr AVBufferRef paramAVBufferRef, int paramInt);
/*      */ 
/*      */   public static native AVBufferPool av_buffer_pool_init(int paramInt, Alloc_int paramAlloc_int);
/*      */ 
/*      */   public static native void av_buffer_pool_uninit(@Cast({"AVBufferPool**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void av_buffer_pool_uninit(@ByPtrPtr AVBufferPool paramAVBufferPool);
/*      */ 
/*      */   public static native AVBufferRef av_buffer_pool_get(AVBufferPool paramAVBufferPool);
/*      */ 
/*      */   public static native long av_frame_get_best_effort_timestamp(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_best_effort_timestamp(AVFrame paramAVFrame, long paramLong);
/*      */ 
/*      */   public static native long av_frame_get_pkt_duration(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_pkt_duration(AVFrame paramAVFrame, long paramLong);
/*      */ 
/*      */   public static native long av_frame_get_pkt_pos(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_pkt_pos(AVFrame paramAVFrame, long paramLong);
/*      */ 
/*      */   public static native long av_frame_get_channel_layout(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_channel_layout(AVFrame paramAVFrame, long paramLong);
/*      */ 
/*      */   public static native int av_frame_get_channels(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_channels(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native int av_frame_get_sample_rate(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_sample_rate(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native AVDictionary av_frame_get_metadata(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_metadata(AVFrame paramAVFrame, AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int av_frame_get_decode_error_flags(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_decode_error_flags(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native int av_frame_get_pkt_size(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_pkt_size(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   @Cast({"AVDictionary**"})
/*      */   public static native PointerPointer avpriv_frame_get_metadatap(AVFrame paramAVFrame);
/*      */ 
/*      */   public static native BytePointer av_frame_get_qp_table(AVFrame paramAVFrame, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native ByteBuffer av_frame_get_qp_table(AVFrame paramAVFrame, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native byte[] av_frame_get_qp_table(AVFrame paramAVFrame, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native int av_frame_set_qp_table(AVFrame paramAVFrame, AVBufferRef paramAVBufferRef, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Cast({"AVColorSpace"})
/*      */   public static native int av_frame_get_colorspace(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_colorspace(AVFrame paramAVFrame, @Cast({"AVColorSpace"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVColorRange"})
/*      */   public static native int av_frame_get_color_range(@Const AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_set_color_range(AVFrame paramAVFrame, @Cast({"AVColorRange"}) int paramInt);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_colorspace_name(@Cast({"AVColorSpace"}) int paramInt);
/*      */ 
/*      */   public static native AVFrame av_frame_alloc();
/*      */ 
/*      */   public static native void av_frame_free(@Cast({"AVFrame**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void av_frame_free(@ByPtrPtr AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_frame_ref(AVFrame paramAVFrame1, AVFrame paramAVFrame2);
/*      */ 
/*      */   public static native AVFrame av_frame_clone(AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_unref(AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void av_frame_move_ref(AVFrame paramAVFrame1, AVFrame paramAVFrame2);
/*      */ 
/*      */   public static native int av_frame_get_buffer(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native int av_frame_is_writable(AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_frame_make_writable(AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int av_frame_copy_props(AVFrame paramAVFrame1, @Const AVFrame paramAVFrame2);
/*      */ 
/*      */   public static native AVBufferRef av_frame_get_plane_buffer(AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   public static native AVFrameSideData av_frame_new_side_data(AVFrame paramAVFrame, @Cast({"AVFrameSideDataType"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native AVFrameSideData av_frame_get_side_data(@Const AVFrame paramAVFrame, @Cast({"AVFrameSideDataType"}) int paramInt);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB32();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB32_1();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR32();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR32_1();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_0RGB32();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_0BGR32();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GRAY16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB48();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB565();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB555();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGB444();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR48();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR565();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR555();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGR444();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV420P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV422P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV444P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV420P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV422P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV444P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV420P12();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV422P12();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV444P12();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV420P14();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV422P14();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV444P14();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV420P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV422P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUV444P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_RGBA64();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BGRA64();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRP9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRP10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRP12();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRP14();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRP16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_GBRAP16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BAYER_BGGR16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BAYER_RGGB16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BAYER_GBRG16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_BAYER_GRBG16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA420P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA422P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA444P9();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA420P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA422P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA444P10();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA420P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA422P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_YUVA444P16();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_XYZ12();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_PIX_FMT_NV20();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_sample_fmt_name(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVSampleFormat"})
/*      */   public static native int av_get_sample_fmt(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"AVSampleFormat"})
/*      */   public static native int av_get_sample_fmt(String paramString);
/*      */ 
/*      */   @Cast({"AVSampleFormat"})
/*      */   public static native int av_get_alt_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   @Cast({"AVSampleFormat"})
/*      */   public static native int av_get_packed_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVSampleFormat"})
/*      */   public static native int av_get_planar_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native BytePointer av_get_sample_fmt_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native ByteBuffer av_get_sample_fmt_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native byte[] av_get_sample_fmt_string(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_get_bits_per_sample_fmt(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   public static native int av_get_bytes_per_sample(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   public static native int av_sample_fmt_is_planar(@Cast({"AVSampleFormat"}) int paramInt);
/*      */ 
/*      */   public static native int av_samples_get_buffer_size(IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_get_buffer_size(IntBuffer paramIntBuffer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_get_buffer_size(int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_fill_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, IntBuffer paramIntBuffer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc_array_and_samples(@Cast({"uint8_t***"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc_array_and_samples(@Cast({"uint8_t***"}) PointerPointer paramPointerPointer, IntBuffer paramIntBuffer, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_alloc_array_and_samples(@Cast({"uint8_t***"}) PointerPointer paramPointerPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_samples_copy(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, @Cast({"uint8_t*const*"}) PointerPointer paramPointerPointer2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5);
/*      */ 
/*      */   public static native int av_samples_copy(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"uint8_t*const*"}) @ByPtrPtr BytePointer paramBytePointer2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5);
/*      */ 
/*      */   public static native int av_samples_copy(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, @Cast({"uint8_t*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5);
/*      */ 
/*      */   public static native int av_samples_copy(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, @Cast({"uint8_t*const*"}) @ByPtrPtr byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5);
/*      */ 
/*      */   public static native int av_samples_set_silence(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4);
/*      */ 
/*      */   public static native int av_samples_set_silence(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4);
/*      */ 
/*      */   public static native int av_samples_set_silence(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4);
/*      */ 
/*      */   public static native int av_samples_set_silence(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Cast({"AVSampleFormat"}) int paramInt4);
/*      */ 
/*      */   @Cast({"uint64_t"})
/*      */   public static native long av_get_channel_layout(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"uint64_t"})
/*      */   public static native long av_get_channel_layout(String paramString);
/*      */ 
/*      */   public static native void av_get_channel_layout_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_get_channel_layout_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_get_channel_layout_string(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_bprint_channel_layout(AVBPrint paramAVBPrint, int paramInt, @Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native int av_get_channel_layout_nb_channels(@Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native long av_get_default_channel_layout(int paramInt);
/*      */ 
/*      */   public static native int av_get_channel_layout_channel_index(@Cast({"uint64_t"}) long paramLong1, @Cast({"uint64_t"}) long paramLong2);
/*      */ 
/*      */   @Cast({"uint64_t"})
/*      */   public static native long av_channel_layout_extract_channel(@Cast({"uint64_t"}) long paramLong, int paramInt);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_channel_name(@Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_channel_description(@Cast({"uint64_t"}) long paramLong);
/*      */ 
/*      */   public static native int av_get_standard_channel_layout(@Cast({"unsigned"}) int paramInt, @Cast({"uint64_t*"}) LongPointer paramLongPointer, @Cast({"const char**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int av_get_standard_channel_layout(@Cast({"unsigned"}) int paramInt, @Cast({"uint64_t*"}) LongPointer paramLongPointer, @Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_get_standard_channel_layout(@Cast({"unsigned"}) int paramInt, @Cast({"uint64_t*"}) LongBuffer paramLongBuffer, @Cast({"const char**"}) @ByPtrPtr ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native int av_get_standard_channel_layout(@Cast({"unsigned"}) int paramInt, @Cast({"uint64_t*"}) long[] paramArrayOfLong, @Cast({"const char**"}) @ByPtrPtr byte[] paramArrayOfByte);
/*      */ 
/*      */   public static native int av_get_cpu_flags();
/*      */ 
/*      */   public static native void av_force_cpu_flags(int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_set_cpu_flags_mask(int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_parse_cpu_flags(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_parse_cpu_flags(String paramString);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) IntPointer paramIntPointer, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) IntBuffer paramIntBuffer, String paramString);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) int[] paramArrayOfInt, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) IntPointer paramIntPointer, String paramString);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) IntBuffer paramIntBuffer, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_parse_cpu_caps(@Cast({"unsigned*"}) int[] paramArrayOfInt, String paramString);
/*      */ 
/*      */   public static native int av_cpu_count();
/*      */ 
/*      */   public static native AVDictionaryEntry av_dict_get(AVDictionary paramAVDictionary, @Cast({"const char*"}) BytePointer paramBytePointer, @Const AVDictionaryEntry paramAVDictionaryEntry, int paramInt);
/*      */ 
/*      */   public static native AVDictionaryEntry av_dict_get(AVDictionary paramAVDictionary, String paramString, @Const AVDictionaryEntry paramAVDictionaryEntry, int paramInt);
/*      */ 
/*      */   public static native int av_dict_count(@Const AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int av_dict_set(@Cast({"AVDictionary**"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt);
/*      */ 
/*      */   public static native int av_dict_set(@ByPtrPtr AVDictionary paramAVDictionary, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt);
/*      */ 
/*      */   public static native int av_dict_set(@ByPtrPtr AVDictionary paramAVDictionary, String paramString1, String paramString2, int paramInt);
/*      */ 
/*      */   public static native int av_dict_parse_string(@Cast({"AVDictionary**"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, int paramInt);
/*      */ 
/*      */   public static native int av_dict_parse_string(@ByPtrPtr AVDictionary paramAVDictionary, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, int paramInt);
/*      */ 
/*      */   public static native int av_dict_parse_string(@ByPtrPtr AVDictionary paramAVDictionary, String paramString1, String paramString2, String paramString3, int paramInt);
/*      */ 
/*      */   public static native void av_dict_copy(@Cast({"AVDictionary**"}) PointerPointer paramPointerPointer, AVDictionary paramAVDictionary, int paramInt);
/*      */ 
/*      */   public static native void av_dict_copy(@ByPtrPtr AVDictionary paramAVDictionary1, AVDictionary paramAVDictionary2, int paramInt);
/*      */ 
/*      */   public static native void av_dict_free(@Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void av_dict_free(@ByPtrPtr AVDictionary paramAVDictionary);
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_IMAGE_SIZE();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_PIXEL_FMT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_SAMPLE_FMT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_VIDEO_RATE();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_DURATION();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_COLOR();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_OPT_TYPE_CHANNEL_LAYOUT();
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_find_opt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_find_opt(Pointer paramPointer, String paramString1, String paramString2, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_set_string3(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt, @Cast({"const AVOption**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_set_string3(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_set_string3(Pointer paramPointer, String paramString1, String paramString2, int paramInt, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, double paramDouble);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_double(Pointer paramPointer, String paramString, double paramDouble);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_q(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal AVRational paramAVRational);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_q(Pointer paramPointer, String paramString, @ByVal AVRational paramAVRational);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, long paramLong);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_set_int(Pointer paramPointer, String paramString, long paramLong);
/*      */ 
/*      */   public static native double av_get_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"const AVOption**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native double av_get_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   public static native double av_get_double(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_get_q(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"const AVOption**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_get_q(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   @ByVal
/*      */   public static native AVRational av_get_q(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   public static native long av_get_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"const AVOption**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native long av_get_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   public static native long av_get_int(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption);
/*      */ 
/*      */   @Deprecated
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const AVOption**"}) PointerPointer paramPointerPointer, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) BytePointer paramBytePointer2, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native String av_get_string(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native String av_get_string(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native String av_get_string(Pointer paramPointer, String paramString, @Const @ByPtrPtr AVOption paramAVOption, @Cast({"char*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVOption av_next_option(Pointer paramPointer, @Const AVOption paramAVOption);
/*      */ 
/*      */   public static native int av_opt_show2(Pointer paramPointer1, Pointer paramPointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_opt_set_defaults(Pointer paramPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_opt_set_defaults2(Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_set_options_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native int av_set_options_string(Pointer paramPointer, String paramString1, String paramString2, String paramString3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*const*"}) PointerPointer paramPointerPointer, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*const*"}) @ByPtrPtr BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"const char*"}) BytePointer paramBytePointer4);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, String paramString1, @Cast({"const char*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer, String paramString2, String paramString3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*const*"}) @ByPtrPtr byte[] paramArrayOfByte, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, String paramString1, @Cast({"const char*const*"}) @ByPtrPtr BytePointer paramBytePointer, String paramString2, String paramString3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native int av_opt_set_from_string(Pointer paramPointer, String paramString1, @Cast({"const char*const*"}) @ByPtrPtr byte[] paramArrayOfByte, String paramString2, String paramString3);
/*      */ 
/*      */   public static native void av_opt_free(Pointer paramPointer);
/*      */ 
/*      */   public static native int av_opt_flag_is_set(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native int av_opt_flag_is_set(Pointer paramPointer, String paramString1, String paramString2);
/*      */ 
/*      */   public static native int av_opt_set_dict(Pointer paramPointer, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int av_opt_set_dict(Pointer paramPointer, @ByPtrPtr AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) PointerPointer paramPointerPointer1, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) PointerPointer paramPointerPointer2, @Cast({"char**"}) PointerPointer paramPointerPointer3);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"const char*"}) BytePointer paramBytePointer3, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr BytePointer paramBytePointer4, @Cast({"char**"}) @ByPtrPtr BytePointer paramBytePointer5);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, String paramString1, String paramString2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Cast({"char**"}) @ByPtrPtr ByteBuffer paramByteBuffer3);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr byte[] paramArrayOfByte1, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr byte[] paramArrayOfByte2, @Cast({"char**"}) @ByPtrPtr byte[] paramArrayOfByte3);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr BytePointer paramBytePointer1, String paramString1, String paramString2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr BytePointer paramBytePointer2, @Cast({"char**"}) @ByPtrPtr BytePointer paramBytePointer3);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Cast({"char**"}) @ByPtrPtr ByteBuffer paramByteBuffer3);
/*      */ 
/*      */   public static native int av_opt_get_key_value(@Cast({"const char**"}) @ByPtrPtr byte[] paramArrayOfByte1, String paramString1, String paramString2, @Cast({"unsigned"}) int paramInt, @Cast({"char**"}) @ByPtrPtr byte[] paramArrayOfByte2, @Cast({"char**"}) @ByPtrPtr byte[] paramArrayOfByte3);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_flags(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_int(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_int64(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, FloatBuffer paramFloatBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, FloatBuffer paramFloatBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_float(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, DoublePointer paramDoublePointer);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, DoubleBuffer paramDoubleBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, DoublePointer paramDoublePointer);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, DoubleBuffer paramDoubleBuffer);
/*      */ 
/*      */   public static native int av_opt_eval_double(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int av_opt_eval_q(Pointer paramPointer, @Const AVOption paramAVOption, @Cast({"const char*"}) BytePointer paramBytePointer, AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_opt_eval_q(Pointer paramPointer, @Const AVOption paramAVOption, String paramString, AVRational paramAVRational);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_find(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_find(Pointer paramPointer, String paramString1, String paramString2, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_find2(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2, @Cast({"void**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_find2(Pointer paramPointer1, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2, @Cast({"void**"}) @ByPtrPtr Pointer paramPointer2);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_find2(Pointer paramPointer1, String paramString1, String paramString2, int paramInt1, int paramInt2, @Cast({"void**"}) @ByPtrPtr Pointer paramPointer2);
/*      */ 
/*      */   @Const
/*      */   public static native AVOption av_opt_next(Pointer paramPointer, @Const AVOption paramAVOption);
/*      */ 
/*      */   public static native Pointer av_opt_child_next(Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */   @Const
/*      */   public static native AVClass av_opt_child_class_next(@Const AVClass paramAVClass1, @Const AVClass paramAVClass2);
/*      */ 
/*      */   public static native int av_opt_set(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const char*"}) BytePointer paramBytePointer2, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set(Pointer paramPointer, String paramString1, String paramString2, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, long paramLong, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_int(Pointer paramPointer, String paramString, long paramLong, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, double paramDouble, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_double(Pointer paramPointer, String paramString, double paramDouble, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_q(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal AVRational paramAVRational, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_q(Pointer paramPointer, String paramString, @ByVal AVRational paramAVRational, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, String paramString, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, String paramString, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_bin(Pointer paramPointer, String paramString, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_image_size(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_opt_set_image_size(Pointer paramPointer, String paramString, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_opt_set_pixel_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_pixel_fmt(Pointer paramPointer, String paramString, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_sample_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_sample_fmt(Pointer paramPointer, String paramString, @Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_opt_set_video_rate(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal AVRational paramAVRational, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_video_rate(Pointer paramPointer, String paramString, @ByVal AVRational paramAVRational, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_channel_layout(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, long paramLong, int paramInt);
/*      */ 
/*      */   public static native int av_opt_set_channel_layout(Pointer paramPointer, String paramString, long paramLong, int paramInt);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer1, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer2);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, String paramString, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, String paramString, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer);
/*      */ 
/*      */   public static native int av_opt_get(Pointer paramPointer, String paramString, int paramInt, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, String paramString, int paramInt, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, String paramString, int paramInt, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_get_int(Pointer paramPointer, String paramString, int paramInt, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, DoublePointer paramDoublePointer);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, String paramString, int paramInt, DoubleBuffer paramDoubleBuffer);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, String paramString, int paramInt, DoublePointer paramDoublePointer);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, DoubleBuffer paramDoubleBuffer);
/*      */ 
/*      */   public static native int av_opt_get_double(Pointer paramPointer, String paramString, int paramInt, double[] paramArrayOfDouble);
/*      */ 
/*      */   public static native int av_opt_get_q(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_opt_get_q(Pointer paramPointer, String paramString, int paramInt, AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, String paramString, int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, String paramString, int paramInt, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native int av_opt_get_image_size(Pointer paramPointer, String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVPixelFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVPixelFormat*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVPixelFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVPixelFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVPixelFormat*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_get_pixel_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVPixelFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVSampleFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVSampleFormat*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVSampleFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVSampleFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, @Cast({"AVSampleFormat*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_opt_get_sample_fmt(Pointer paramPointer, String paramString, int paramInt, @Cast({"AVSampleFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_opt_get_video_rate(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_opt_get_video_rate(Pointer paramPointer, String paramString, int paramInt, AVRational paramAVRational);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, String paramString, int paramInt, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, String paramString, int paramInt, LongPointer paramLongPointer);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt, LongBuffer paramLongBuffer);
/*      */ 
/*      */   public static native int av_opt_get_channel_layout(Pointer paramPointer, String paramString, int paramInt, long[] paramArrayOfLong);
/*      */ 
/*      */   public static native Pointer av_opt_ptr(@Const AVClass paramAVClass, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native Pointer av_opt_ptr(@Const AVClass paramAVClass, Pointer paramPointer, String paramString);
/*      */ 
/*      */   public static native void av_opt_freep_ranges(@Cast({"AVOptionRanges**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void av_opt_freep_ranges(@ByPtrPtr AVOptionRanges paramAVOptionRanges);
/*      */ 
/*      */   public static native int av_opt_query_ranges(@Cast({"AVOptionRanges**"}) PointerPointer paramPointerPointer, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int av_opt_query_ranges(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int av_opt_query_ranges(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, String paramString, int paramInt);
/*      */ 
/*      */   public static native int av_opt_query_ranges_default(@Cast({"AVOptionRanges**"}) PointerPointer paramPointerPointer, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int av_opt_query_ranges_default(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int av_opt_query_ranges_default(@ByPtrPtr AVOptionRanges paramAVOptionRanges, Pointer paramPointer, String paramString, int paramInt);
/*      */ 
/*      */   @MemberGetter
/*      */   @Const
/*      */   @Deprecated
/*      */   @ByVal
/*      */   public static native AVPixFmtDescriptor av_pix_fmt_descriptors(int paramInt);
/*      */ 
/*      */   @MemberGetter
/*      */   @Const
/*      */   @Deprecated
/*      */   public static native AVPixFmtDescriptor av_pix_fmt_descriptors();
/*      */ 
/*      */   public static native void av_read_image_line(@Cast({"uint16_t*"}) ShortPointer paramShortPointer, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer, @Const IntPointer paramIntPointer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native void av_read_image_line(@Cast({"uint16_t*"}) ShortPointer paramShortPointer, @Cast({"const uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, @Const IntPointer paramIntPointer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native void av_read_image_line(@Cast({"uint16_t*"}) ShortBuffer paramShortBuffer, @Cast({"const uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, @Const IntBuffer paramIntBuffer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native void av_read_image_line(@Cast({"uint16_t*"}) short[] paramArrayOfShort, @Cast({"const uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, @Const int[] paramArrayOfInt, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native void av_write_image_line(@Cast({"const uint16_t*"}) ShortPointer paramShortPointer, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, @Const IntPointer paramIntPointer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_write_image_line(@Cast({"const uint16_t*"}) ShortPointer paramShortPointer, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, @Const IntPointer paramIntPointer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_write_image_line(@Cast({"const uint16_t*"}) ShortBuffer paramShortBuffer, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, @Const IntBuffer paramIntBuffer, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_write_image_line(@Cast({"const uint16_t*"}) short[] paramArrayOfShort, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, @Const int[] paramArrayOfInt, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int av_get_pix_fmt(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int av_get_pix_fmt(String paramString);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_pix_fmt_name(@Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native BytePointer av_get_pix_fmt_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native ByteBuffer av_get_pix_fmt_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2);
/*      */ 
/*      */   @Cast({"char*"})
/*      */   public static native byte[] av_get_pix_fmt_string(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2);
/*      */ 
/*      */   public static native int av_get_bits_per_pixel(@Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   public static native int av_get_padded_bits_per_pixel(@Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   @Const
/*      */   public static native AVPixFmtDescriptor av_pix_fmt_desc_get(@Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   @Const
/*      */   public static native AVPixFmtDescriptor av_pix_fmt_desc_next(@Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int av_pix_fmt_desc_get_id(@Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   public static native int av_pix_fmt_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native int av_pix_fmt_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native int av_pix_fmt_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native int av_pix_fmt_count_planes(@Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   public static native void ff_check_pixfmt_descriptors();
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int av_pix_fmt_swap_endianness(@Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   public static native void av_image_fill_max_pixsteps(IntPointer paramIntPointer1, IntPointer paramIntPointer2, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   public static native void av_image_fill_max_pixsteps(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   public static native void av_image_fill_max_pixsteps(int[] paramArrayOfInt1, int[] paramArrayOfInt2, @Const AVPixFmtDescriptor paramAVPixFmtDescriptor);
/*      */ 
/*      */   public static native int av_image_get_linesize(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_image_fill_linesizes(IntPointer paramIntPointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_image_fill_linesizes(IntBuffer paramIntBuffer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_image_fill_linesizes(int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_image_fill_pointers(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, @Cast({"uint8_t*"}) BytePointer paramBytePointer, @Const IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_image_fill_pointers(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, @Const IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_image_fill_pointers(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer2, @Const IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_image_fill_pointers(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, @Cast({"uint8_t*"}) byte[] paramArrayOfByte2, @Const int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_image_alloc(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_alloc(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer, IntPointer paramIntPointer, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_alloc(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer, IntBuffer paramIntBuffer, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_alloc(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_image_copy_plane(@Cast({"uint8_t*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_image_copy_plane(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer1, int paramInt1, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_image_copy_plane(@Cast({"uint8_t*"}) byte[] paramArrayOfByte1, int paramInt1, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void av_image_copy(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, IntPointer paramIntPointer1, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer2, @Const IntPointer paramIntPointer2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void av_image_copy(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer1, @Cast({"const uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer2, @Const IntPointer paramIntPointer2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void av_image_copy(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer1, @Cast({"const uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Const IntBuffer paramIntBuffer2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void av_image_copy(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt1, @Cast({"const uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte2, @Const int[] paramArrayOfInt2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_image_fill_arrays(@Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_fill_arrays(@Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_get_buffer_size(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int av_image_copy_to_buffer(@Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt1, @Cast({"const uint8_t*const*"}) PointerPointer paramPointerPointer, @Const IntPointer paramIntPointer, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native int av_image_copy_to_buffer(@Cast({"uint8_t*"}) BytePointer paramBytePointer1, int paramInt1, @Cast({"const uint8_t*const*"}) @ByPtrPtr BytePointer paramBytePointer2, @Const IntPointer paramIntPointer, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native int av_image_copy_to_buffer(@Cast({"uint8_t*"}) ByteBuffer paramByteBuffer1, int paramInt1, @Cast({"const uint8_t*const*"}) @ByPtrPtr ByteBuffer paramByteBuffer2, @Const IntBuffer paramIntBuffer, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native int av_image_copy_to_buffer(@Cast({"uint8_t*"}) byte[] paramArrayOfByte1, int paramInt1, @Cast({"const uint8_t*const*"}) @ByPtrPtr byte[] paramArrayOfByte2, @Const int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */ 
/*      */   public static native int av_image_check_size(@Cast({"unsigned int"}) int paramInt1, @Cast({"unsigned int"}) int paramInt2, int paramInt3, Pointer paramPointer);
/*      */ 
/*      */   public static native int avpriv_set_systematic_pal2(@Cast({"uint32_t*"}) IntPointer paramIntPointer, @Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   public static native int avpriv_set_systematic_pal2(@Cast({"uint32_t*"}) IntBuffer paramIntBuffer, @Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   public static native int avpriv_set_systematic_pal2(@Cast({"uint32_t*"}) int[] paramArrayOfInt, @Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   static
/*      */   {
/*   43 */     Loader.load();
/*      */   }
/*      */ 
/*      */   public static class AVPixFmtDescriptor extends Pointer
/*      */   {
/*      */     public AVPixFmtDescriptor()
/*      */     {
/* 5148 */       allocate(); } 
/* 5149 */     public AVPixFmtDescriptor(int size) { allocateArray(size); } 
/* 5150 */     public AVPixFmtDescriptor(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 5154 */     public AVPixFmtDescriptor position(int position) { return (AVPixFmtDescriptor)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     public native byte nb_components();
/*      */ 
/*      */     public native AVPixFmtDescriptor nb_components(byte paramByte);
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     public native byte log2_chroma_w();
/*      */ 
/*      */     public native AVPixFmtDescriptor log2_chroma_w(byte paramByte);
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     public native byte log2_chroma_h();
/*      */ 
/*      */     public native AVPixFmtDescriptor log2_chroma_h(byte paramByte);
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     public native byte flags();
/*      */ 
/*      */     public native AVPixFmtDescriptor flags(byte paramByte);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVComponentDescriptor comp(int paramInt);
/*      */ 
/*      */     public native AVPixFmtDescriptor comp(int paramInt, avutil.AVComponentDescriptor paramAVComponentDescriptor);
/*      */ 
/*      */     @MemberGetter
/*      */     public native avutil.AVComponentDescriptor comp();
/*      */ 
/*      */     static
/*      */     {
/* 5147 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVComponentDescriptor extends Pointer
/*      */   {
/*      */     public AVComponentDescriptor()
/*      */     {
/* 5108 */       allocate(); } 
/* 5109 */     public AVComponentDescriptor(int size) { allocateArray(size); } 
/* 5110 */     public AVComponentDescriptor(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 5114 */     public AVComponentDescriptor position(int position) { return (AVComponentDescriptor)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     @NoOffset
/*      */     public native short plane();
/*      */ 
/*      */     public native AVComponentDescriptor plane(short paramShort);
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     @NoOffset
/*      */     public native short step_minus1();
/*      */ 
/*      */     public native AVComponentDescriptor step_minus1(short paramShort);
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     @NoOffset
/*      */     public native short offset_plus1();
/*      */ 
/*      */     public native AVComponentDescriptor offset_plus1(short paramShort);
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     @NoOffset
/*      */     public native short shift();
/*      */ 
/*      */     public native AVComponentDescriptor shift(short paramShort);
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     @NoOffset
/*      */     public native short depth_minus1();
/*      */ 
/*      */     public native AVComponentDescriptor depth_minus1(short paramShort);
/*      */ 
/*      */     static
/*      */     {
/* 5107 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVOptionRanges extends Pointer
/*      */   {
/*      */     public AVOptionRanges()
/*      */     {
/* 4457 */       allocate(); } 
/* 4458 */     public AVOptionRanges(int size) { allocateArray(size); } 
/* 4459 */     public AVOptionRanges(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4463 */     public AVOptionRanges position(int position) { return (AVOptionRanges)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native avutil.AVOptionRange range(int paramInt);
/*      */ 
/*      */     public native AVOptionRanges range(int paramInt, avutil.AVOptionRange paramAVOptionRange);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVOptionRange**"})
/*      */     public native PointerPointer range();
/*      */ 
/*      */     public native int nb_ranges();
/*      */ 
/*      */     public native AVOptionRanges nb_ranges(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4456 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVOptionRange extends Pointer
/*      */   {
/*      */     public AVOptionRange()
/*      */     {
/* 4432 */       allocate(); } 
/* 4433 */     public AVOptionRange(int size) { allocateArray(size); } 
/* 4434 */     public AVOptionRange(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4438 */     public AVOptionRange position(int position) { return (AVOptionRange)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer str();
/*      */ 
/*      */     public native double value_min();
/*      */ 
/*      */     public native AVOptionRange value_min(double paramDouble);
/*      */ 
/*      */     public native double value_max();
/*      */ 
/*      */     public native AVOptionRange value_max(double paramDouble);
/*      */ 
/*      */     public native double component_min();
/*      */ 
/*      */     public native AVOptionRange component_min(double paramDouble);
/*      */ 
/*      */     public native double component_max();
/*      */ 
/*      */     public native AVOptionRange component_max(double paramDouble);
/*      */ 
/*      */     public native int is_range();
/*      */ 
/*      */     public native AVOptionRange is_range(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4431 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVOption extends Pointer
/*      */   {
/*      */     public static final int AV_OPT_FLAG_ENCODING_PARAM = 1;
/*      */     public static final int AV_OPT_FLAG_DECODING_PARAM = 2;
/*      */     public static final int AV_OPT_FLAG_METADATA = 4;
/*      */     public static final int AV_OPT_FLAG_AUDIO_PARAM = 8;
/*      */     public static final int AV_OPT_FLAG_VIDEO_PARAM = 16;
/*      */     public static final int AV_OPT_FLAG_SUBTITLE_PARAM = 32;
/*      */     public static final int AV_OPT_FLAG_FILTERING_PARAM = 65536;
/*      */ 
/*      */     public AVOption()
/*      */     {
/* 4368 */       allocate(); } 
/* 4369 */     public AVOption(int size) { allocateArray(size); } 
/* 4370 */     public AVOption(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4374 */     public AVOption position(int position) { return (AVOption)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer help();
/*      */ 
/*      */     public native int offset();
/*      */ 
/*      */     public native AVOption offset(int paramInt);
/*      */ 
/*      */     @Cast({"AVOptionType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVOption type(int paramInt);
/*      */ 
/*      */     @Name({"default_val", ".i64"})
/*      */     public native long default_val_i64();
/*      */ 
/*      */     public native AVOption default_val_i64(long paramLong);
/*      */ 
/*      */     @Name({"default_val", ".dbl"})
/*      */     public native double default_val_dbl();
/*      */ 
/*      */     public native AVOption default_val_dbl(double paramDouble);
/*      */ 
/*      */     @Name({"default_val", ".str"})
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer default_val_str();
/*      */ 
/*      */     @Name({"default_val", ".q"})
/*      */     @ByVal
/*      */     public native avutil.AVRational default_val_q();
/*      */ 
/*      */     public native AVOption default_val_q(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native double min();
/*      */ 
/*      */     public native AVOption min(double paramDouble);
/*      */ 
/*      */     public native double max();
/*      */ 
/*      */     public native AVOption max(double paramDouble);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVOption flags(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer unit();
/*      */ 
/*      */     static
/*      */     {
/* 4367 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVDictionary extends Pointer
/*      */   {
/*      */     public AVDictionary()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVDictionary(Pointer p)
/*      */     {
/* 4010 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVDictionaryEntry extends Pointer
/*      */   {
/*      */     public AVDictionaryEntry()
/*      */     {
/* 3995 */       allocate(); } 
/* 3996 */     public AVDictionaryEntry(int size) { allocateArray(size); } 
/* 3997 */     public AVDictionaryEntry(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4001 */     public AVDictionaryEntry position(int position) { return (AVDictionaryEntry)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer key();
/*      */ 
/*      */     public native AVDictionaryEntry key(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer value();
/*      */ 
/*      */     public native AVDictionaryEntry value(BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 3994 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVBPrint extends Pointer
/*      */   {
/*      */     public AVBPrint()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVBPrint(Pointer p)
/*      */     {
/* 3699 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFrame extends Pointer
/*      */   {
/*      */     public static final int AV_NUM_DATA_POINTERS = 8;
/*      */     public static final int FF_DECODE_ERROR_INVALID_BITSTREAM = 1;
/*      */     public static final int FF_DECODE_ERROR_MISSING_REFERENCE = 2;
/*      */ 
/*      */     public AVFrame()
/*      */     {
/* 2043 */       allocate(); } 
/* 2044 */     public AVFrame(int size) { allocateArray(size); } 
/* 2045 */     public AVFrame(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2049 */     public AVFrame position(int position) { return (AVFrame)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data(int paramInt);
/*      */ 
/*      */     public native AVFrame data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer data();
/*      */ 
/*      */     public native int linesize(int paramInt);
/*      */ 
/*      */     public native AVFrame linesize(int paramInt1, int paramInt2);
/*      */ 
/*      */     @MemberGetter
/*      */     public native IntPointer linesize();
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer extended_data(int paramInt);
/*      */ 
/*      */     public native AVFrame extended_data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer extended_data();
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native AVFrame width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native AVFrame height(int paramInt);
/*      */ 
/*      */     public native int nb_samples();
/*      */ 
/*      */     public native AVFrame nb_samples(int paramInt);
/*      */ 
/*      */     public native int format();
/*      */ 
/*      */     public native AVFrame format(int paramInt);
/*      */ 
/*      */     public native int key_frame();
/*      */ 
/*      */     public native AVFrame key_frame(int paramInt);
/*      */ 
/*      */     @Cast({"AVPictureType"})
/*      */     public native int pict_type();
/*      */ 
/*      */     public native AVFrame pict_type(int paramInt);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     @Deprecated
/*      */     public native BytePointer base(int paramInt);
/*      */ 
/*      */     public native AVFrame base(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     @Deprecated
/*      */     public native PointerPointer base();
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational sample_aspect_ratio();
/*      */ 
/*      */     public native AVFrame sample_aspect_ratio(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native long pts();
/*      */ 
/*      */     public native AVFrame pts(long paramLong);
/*      */ 
/*      */     public native long pkt_pts();
/*      */ 
/*      */     public native AVFrame pkt_pts(long paramLong);
/*      */ 
/*      */     public native long pkt_dts();
/*      */ 
/*      */     public native AVFrame pkt_dts(long paramLong);
/*      */ 
/*      */     public native int coded_picture_number();
/*      */ 
/*      */     public native AVFrame coded_picture_number(int paramInt);
/*      */ 
/*      */     public native int display_picture_number();
/*      */ 
/*      */     public native AVFrame display_picture_number(int paramInt);
/*      */ 
/*      */     public native int quality();
/*      */ 
/*      */     public native AVFrame quality(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int reference();
/*      */ 
/*      */     public native AVFrame reference(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native BytePointer qscale_table();
/*      */ 
/*      */     public native AVFrame qscale_table(BytePointer paramBytePointer);
/*      */ 
/*      */     @Deprecated
/*      */     public native int qstride();
/*      */ 
/*      */     public native AVFrame qstride(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int qscale_type();
/*      */ 
/*      */     public native AVFrame qscale_type(int paramInt);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     @Deprecated
/*      */     public native BytePointer mbskip_table();
/*      */ 
/*      */     public native AVFrame mbskip_table(BytePointer paramBytePointer);
/*      */ 
/*      */     @Deprecated
/*      */     public native short motion_val(int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */     public native AVFrame motion_val(int paramInt1, int paramInt2, int paramInt3, short paramShort);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"int16_t(*)[2]"})
/*      */     @Deprecated
/*      */     public native ShortPointer motion_val();
/*      */ 
/*      */     @Cast({"uint32_t*"})
/*      */     @Deprecated
/*      */     public native IntPointer mb_type();
/*      */ 
/*      */     public native AVFrame mb_type(IntPointer paramIntPointer);
/*      */ 
/*      */     @Deprecated
/*      */     public native ShortPointer dct_coeff();
/*      */ 
/*      */     public native AVFrame dct_coeff(ShortPointer paramShortPointer);
/*      */ 
/*      */     @Deprecated
/*      */     public native BytePointer ref_index(int paramInt);
/*      */ 
/*      */     public native AVFrame ref_index(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"int8_t**"})
/*      */     @Deprecated
/*      */     public native PointerPointer ref_index();
/*      */ 
/*      */     public native Pointer opaque();
/*      */ 
/*      */     public native AVFrame opaque(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long error(int paramInt);
/*      */ 
/*      */     public native AVFrame error(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint64_t*"})
/*      */     public native LongPointer error();
/*      */ 
/*      */     @Deprecated
/*      */     public native int type();
/*      */ 
/*      */     public native AVFrame type(int paramInt);
/*      */ 
/*      */     public native int repeat_pict();
/*      */ 
/*      */     public native AVFrame repeat_pict(int paramInt);
/*      */ 
/*      */     public native int interlaced_frame();
/*      */ 
/*      */     public native AVFrame interlaced_frame(int paramInt);
/*      */ 
/*      */     public native int top_field_first();
/*      */ 
/*      */     public native AVFrame top_field_first(int paramInt);
/*      */ 
/*      */     public native int palette_has_changed();
/*      */ 
/*      */     public native AVFrame palette_has_changed(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int buffer_hints();
/*      */ 
/*      */     public native AVFrame buffer_hints(int paramInt);
/*      */ 
/*      */     @Cast({"AVPanScan*"})
/*      */     @Deprecated
/*      */     public native Pointer pan_scan();
/*      */ 
/*      */     public native AVFrame pan_scan(Pointer paramPointer);
/*      */ 
/*      */     /** @deprecated */
/*      */     public native long reordered_opaque();
/*      */ 
/*      */     public native AVFrame reordered_opaque(long paramLong);
/*      */ 
/*      */     @Deprecated
/*      */     public native Pointer hwaccel_picture_private();
/*      */ 
/*      */     public native AVFrame hwaccel_picture_private(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"AVCodecContext*"})
/*      */     @Deprecated
/*      */     public native Pointer owner();
/*      */ 
/*      */     public native AVFrame owner(Pointer paramPointer);
/*      */ 
/*      */     @Deprecated
/*      */     public native Pointer thread_opaque();
/*      */ 
/*      */     public native AVFrame thread_opaque(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     @Deprecated
/*      */     public native byte motion_subsample_log2();
/*      */ 
/*      */     public native AVFrame motion_subsample_log2(byte paramByte);
/*      */ 
/*      */     public native int sample_rate();
/*      */ 
/*      */     public native AVFrame sample_rate(int paramInt);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long channel_layout();
/*      */ 
/*      */     public native AVFrame channel_layout(long paramLong);
/*      */ 
/*      */     public native avutil.AVBufferRef buf(int paramInt);
/*      */ 
/*      */     public native AVFrame buf(int paramInt, avutil.AVBufferRef paramAVBufferRef);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVBufferRef**"})
/*      */     public native PointerPointer buf();
/*      */ 
/*      */     public native avutil.AVBufferRef extended_buf(int paramInt);
/*      */ 
/*      */     public native AVFrame extended_buf(int paramInt, avutil.AVBufferRef paramAVBufferRef);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVBufferRef**"})
/*      */     public native PointerPointer extended_buf();
/*      */ 
/*      */     public native int nb_extended_buf();
/*      */ 
/*      */     public native AVFrame nb_extended_buf(int paramInt);
/*      */ 
/*      */     public native avutil.AVFrameSideData side_data(int paramInt);
/*      */ 
/*      */     public native AVFrame side_data(int paramInt, avutil.AVFrameSideData paramAVFrameSideData);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVFrameSideData**"})
/*      */     public native PointerPointer side_data();
/*      */ 
/*      */     public native int nb_side_data();
/*      */ 
/*      */     public native AVFrame nb_side_data(int paramInt);
/*      */ 
/*      */     public native long best_effort_timestamp();
/*      */ 
/*      */     public native AVFrame best_effort_timestamp(long paramLong);
/*      */ 
/*      */     public native long pkt_pos();
/*      */ 
/*      */     public native AVFrame pkt_pos(long paramLong);
/*      */ 
/*      */     public native long pkt_duration();
/*      */ 
/*      */     public native AVFrame pkt_duration(long paramLong);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVFrame metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     public native int decode_error_flags();
/*      */ 
/*      */     public native AVFrame decode_error_flags(int paramInt);
/*      */ 
/*      */     public native int channels();
/*      */ 
/*      */     public native AVFrame channels(int paramInt);
/*      */ 
/*      */     public native int pkt_size();
/*      */ 
/*      */     public native AVFrame pkt_size(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorSpace"})
/*      */     public native int colorspace();
/*      */ 
/*      */     public native AVFrame colorspace(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorRange"})
/*      */     public native int color_range();
/*      */ 
/*      */     public native AVFrame color_range(int paramInt);
/*      */ 
/*      */     public native avutil.AVBufferRef qp_table_buf();
/*      */ 
/*      */     public native AVFrame qp_table_buf(avutil.AVBufferRef paramAVBufferRef);
/*      */ 
/*      */     static
/*      */     {
/* 2042 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVFrameSideData extends Pointer
/*      */   {
/*      */     public AVFrameSideData()
/*      */     {
/* 1997 */       allocate(); } 
/* 1998 */     public AVFrameSideData(int size) { allocateArray(size); } 
/* 1999 */     public AVFrameSideData(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 2003 */     public AVFrameSideData position(int position) { return (AVFrameSideData)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"AVFrameSideDataType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVFrameSideData type(int paramInt);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data();
/*      */ 
/*      */     public native AVFrameSideData data(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int size();
/*      */ 
/*      */     public native AVFrameSideData size(int paramInt);
/*      */ 
/*      */     public native avutil.AVDictionary metadata();
/*      */ 
/*      */     public native AVFrameSideData metadata(avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */     static
/*      */     {
/* 1996 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Alloc_int extends FunctionPointer
/*      */   {
/*      */     public Alloc_int(Pointer p)
/*      */     {
/* 1891 */       super(); } 
/* 1892 */     protected Alloc_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native avutil.AVBufferRef call(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1890 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVBufferPool extends Pointer
/*      */   {
/*      */     public AVBufferPool()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVBufferPool(Pointer p)
/*      */     {
/* 1877 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Free_Pointer_byte extends FunctionPointer
/*      */   {
/*      */     public Free_Pointer_byte(Pointer p)
/*      */     {
/* 1750 */       super(); } 
/* 1751 */     protected Free_Pointer_byte() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer, @Cast({"uint8_t*"}) byte[] paramArrayOfByte);
/*      */ 
/*      */     static
/*      */     {
/* 1749 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Free_Pointer_ByteBuffer extends FunctionPointer
/*      */   {
/*      */     public Free_Pointer_ByteBuffer(Pointer p)
/*      */     {
/* 1742 */       super(); } 
/* 1743 */     protected Free_Pointer_ByteBuffer() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer);
/*      */ 
/*      */     static
/*      */     {
/* 1741 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Free_Pointer_BytePointer extends FunctionPointer
/*      */   {
/*      */     public Free_Pointer_BytePointer(Pointer p)
/*      */     {
/* 1734 */       super(); } 
/* 1735 */     protected Free_Pointer_BytePointer() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer, @Cast({"uint8_t*"}) BytePointer paramBytePointer);
/*      */ 
/*      */     static
/*      */     {
/* 1733 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVBufferRef extends Pointer
/*      */   {
/*      */     public AVBufferRef()
/*      */     {
/* 1675 */       allocate(); } 
/* 1676 */     public AVBufferRef(int size) { allocateArray(size); } 
/* 1677 */     public AVBufferRef(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1681 */     public AVBufferRef position(int position) { return (AVBufferRef)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native avutil.AVBuffer buffer();
/*      */ 
/*      */     public native AVBufferRef buffer(avutil.AVBuffer paramAVBuffer);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data();
/*      */ 
/*      */     public native AVBufferRef data(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int size();
/*      */ 
/*      */     public native AVBufferRef size(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1674 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVBuffer extends Pointer
/*      */   {
/*      */     public AVBuffer()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVBuffer(Pointer p)
/*      */     {
/* 1664 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Callback_Pointer_int_String_Pointer extends FunctionPointer
/*      */   {
/*      */     public Callback_Pointer_int_String_Pointer(Pointer p)
/*      */     {
/* 1504 */       super(); } 
/* 1505 */     protected Callback_Pointer_int_String_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer1, int paramInt, String paramString, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */     static
/*      */     {
/* 1503 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Callback_Pointer_int_BytePointer_Pointer extends FunctionPointer
/*      */   {
/*      */     public Callback_Pointer_int_BytePointer_Pointer(Pointer p)
/*      */     {
/* 1496 */       super(); } 
/* 1497 */     protected Callback_Pointer_int_BytePointer_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native void call(Pointer paramPointer1, int paramInt, @Cast({"const char*"}) BytePointer paramBytePointer, @ByVal @Cast({"va_list*"}) Pointer paramPointer2);
/*      */ 
/*      */     static
/*      */     {
/* 1495 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVClass extends Pointer
/*      */   {
/*      */     public AVClass()
/*      */     {
/* 1249 */       allocate(); } 
/* 1250 */     public AVClass(int size) { allocateArray(size); } 
/* 1251 */     public AVClass(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1255 */     public AVClass position(int position) { return (AVClass)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer class_name();
/*      */ 
/*      */     @MemberGetter
/*      */     public native Item_name_Pointer item_name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVOption option();
/*      */ 
/*      */     public native int version();
/*      */ 
/*      */     public native AVClass version(int paramInt);
/*      */ 
/*      */     public native int log_level_offset_offset();
/*      */ 
/*      */     public native AVClass log_level_offset_offset(int paramInt);
/*      */ 
/*      */     public native int parent_log_context_offset();
/*      */ 
/*      */     public native AVClass parent_log_context_offset(int paramInt);
/*      */ 
/*      */     public native Child_next_Pointer_Pointer child_next();
/*      */ 
/*      */     public native AVClass child_next(Child_next_Pointer_Pointer paramChild_next_Pointer_Pointer);
/*      */ 
/*      */     @MemberGetter
/*      */     public native Child_class_next_AVClass child_class_next();
/*      */ 
/*      */     @Cast({"AVClassCategory"})
/*      */     public native int category();
/*      */ 
/*      */     public native AVClass category(int paramInt);
/*      */ 
/*      */     public native Get_category_Pointer get_category();
/*      */ 
/*      */     public native AVClass get_category(Get_category_Pointer paramGet_category_Pointer);
/*      */ 
/*      */     public native Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges();
/*      */ 
/*      */     public native AVClass query_ranges(Query_ranges_PointerPointer_Pointer_BytePointer_int paramQuery_ranges_PointerPointer_Pointer_BytePointer_int);
/*      */ 
/*      */     static
/*      */     {
/* 1248 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Query_ranges_PointerPointer_Pointer_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Query_ranges_PointerPointer_Pointer_BytePointer_int(Pointer p)
/*      */       {
/* 1362 */         super(); } 
/* 1363 */       protected Query_ranges_PointerPointer_Pointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(@Cast({"AVOptionRanges**"}) PointerPointer paramPointerPointer, Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 1361 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Get_category_Pointer extends FunctionPointer
/*      */     {
/*      */       public Get_category_Pointer(Pointer p)
/*      */       {
/* 1349 */         super(); } 
/* 1350 */       protected Get_category_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Cast({"AVClassCategory"})
/*      */       public native int call(Pointer paramPointer);
/*      */ 
/*      */       static
/*      */       {
/* 1348 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Child_class_next_AVClass extends FunctionPointer
/*      */     {
/*      */       public Child_class_next_AVClass(Pointer p)
/*      */       {
/* 1329 */         super(); } 
/* 1330 */       protected Child_class_next_AVClass() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Const
/*      */       public native avutil.AVClass call(@Const avutil.AVClass paramAVClass);
/*      */ 
/*      */       static
/*      */       {
/* 1328 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Child_next_Pointer_Pointer extends FunctionPointer
/*      */     {
/*      */       public Child_next_Pointer_Pointer(Pointer p)
/*      */       {
/* 1312 */         super(); } 
/* 1313 */       protected Child_next_Pointer_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native Pointer call(Pointer paramPointer1, Pointer paramPointer2);
/*      */ 
/*      */       static
/*      */       {
/* 1311 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Item_name_Pointer extends FunctionPointer
/*      */     {
/*      */       public Item_name_Pointer(Pointer p)
/*      */       {
/* 1270 */         super(); } 
/* 1271 */       protected Item_name_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Cast({"const char*"})
/*      */       public native BytePointer call(Pointer paramPointer);
/*      */ 
/*      */       static
/*      */       {
/* 1269 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVRational extends Pointer
/*      */   {
/*      */     public AVRational()
/*      */     {
/* 1083 */       allocate(); } 
/* 1084 */     public AVRational(int size) { allocateArray(size); } 
/* 1085 */     public AVRational(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1089 */     public AVRational position(int position) { return (AVRational)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int num();
/*      */ 
/*      */     public native AVRational num(int paramInt);
/*      */ 
/*      */     public native int den();
/*      */ 
/*      */     public native AVRational den(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1082 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.avutil
 * JD-Core Version:    0.6.2
 */