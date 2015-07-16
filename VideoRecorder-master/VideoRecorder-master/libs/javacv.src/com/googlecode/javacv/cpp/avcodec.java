/*      */ package com.googlecode.javacv.cpp;
/*      */ 
/*      */ import com.googlecode.javacpp.BytePointer;
/*      */ import com.googlecode.javacpp.FloatPointer;
/*      */ import com.googlecode.javacpp.FunctionPointer;
/*      */ import com.googlecode.javacpp.IntPointer;
/*      */ import com.googlecode.javacpp.Loader;
/*      */ import com.googlecode.javacpp.LongPointer;
/*      */ import com.googlecode.javacpp.Pointer;
/*      */ import com.googlecode.javacpp.PointerPointer;
/*      */ import com.googlecode.javacpp.ShortPointer;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ 
/*      */ @Properties(inherit={avutil.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavcodec/avcodec.h>", "<libavcodec/avfft.h>"}, link={"avcodec@.55"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"avcodec-55"})})
/*      */ public class avcodec
/*      */ {
/*      */   public static final int AV_CODEC_ID_NONE = 0;
/*      */   public static final int AV_CODEC_ID_MPEG1VIDEO = 1;
/*      */   public static final int AV_CODEC_ID_MPEG2VIDEO = 2;
/*      */   public static final int AV_CODEC_ID_MPEG2VIDEO_XVMC = 3;
/*      */   public static final int AV_CODEC_ID_H261 = 4;
/*      */   public static final int AV_CODEC_ID_H263 = 5;
/*      */   public static final int AV_CODEC_ID_RV10 = 6;
/*      */   public static final int AV_CODEC_ID_RV20 = 7;
/*      */   public static final int AV_CODEC_ID_MJPEG = 8;
/*      */   public static final int AV_CODEC_ID_MJPEGB = 9;
/*      */   public static final int AV_CODEC_ID_LJPEG = 10;
/*      */   public static final int AV_CODEC_ID_SP5X = 11;
/*      */   public static final int AV_CODEC_ID_JPEGLS = 12;
/*      */   public static final int AV_CODEC_ID_MPEG4 = 13;
/*      */   public static final int AV_CODEC_ID_RAWVIDEO = 14;
/*      */   public static final int AV_CODEC_ID_MSMPEG4V1 = 15;
/*      */   public static final int AV_CODEC_ID_MSMPEG4V2 = 16;
/*      */   public static final int AV_CODEC_ID_MSMPEG4V3 = 17;
/*      */   public static final int AV_CODEC_ID_WMV1 = 18;
/*      */   public static final int AV_CODEC_ID_WMV2 = 19;
/*      */   public static final int AV_CODEC_ID_H263P = 20;
/*      */   public static final int AV_CODEC_ID_H263I = 21;
/*      */   public static final int AV_CODEC_ID_FLV1 = 22;
/*      */   public static final int AV_CODEC_ID_SVQ1 = 23;
/*      */   public static final int AV_CODEC_ID_SVQ3 = 24;
/*      */   public static final int AV_CODEC_ID_DVVIDEO = 25;
/*      */   public static final int AV_CODEC_ID_HUFFYUV = 26;
/*      */   public static final int AV_CODEC_ID_CYUV = 27;
/*      */   public static final int AV_CODEC_ID_H264 = 28;
/*      */   public static final int AV_CODEC_ID_INDEO3 = 29;
/*      */   public static final int AV_CODEC_ID_VP3 = 30;
/*      */   public static final int AV_CODEC_ID_THEORA = 31;
/*      */   public static final int AV_CODEC_ID_ASV1 = 32;
/*      */   public static final int AV_CODEC_ID_ASV2 = 33;
/*      */   public static final int AV_CODEC_ID_FFV1 = 34;
/*      */   public static final int AV_CODEC_ID_4XM = 35;
/*      */   public static final int AV_CODEC_ID_VCR1 = 36;
/*      */   public static final int AV_CODEC_ID_CLJR = 37;
/*      */   public static final int AV_CODEC_ID_MDEC = 38;
/*      */   public static final int AV_CODEC_ID_ROQ = 39;
/*      */   public static final int AV_CODEC_ID_INTERPLAY_VIDEO = 40;
/*      */   public static final int AV_CODEC_ID_XAN_WC3 = 41;
/*      */   public static final int AV_CODEC_ID_XAN_WC4 = 42;
/*      */   public static final int AV_CODEC_ID_RPZA = 43;
/*      */   public static final int AV_CODEC_ID_CINEPAK = 44;
/*      */   public static final int AV_CODEC_ID_WS_VQA = 45;
/*      */   public static final int AV_CODEC_ID_MSRLE = 46;
/*      */   public static final int AV_CODEC_ID_MSVIDEO1 = 47;
/*      */   public static final int AV_CODEC_ID_IDCIN = 48;
/*      */   public static final int AV_CODEC_ID_8BPS = 49;
/*      */   public static final int AV_CODEC_ID_SMC = 50;
/*      */   public static final int AV_CODEC_ID_FLIC = 51;
/*      */   public static final int AV_CODEC_ID_TRUEMOTION1 = 52;
/*      */   public static final int AV_CODEC_ID_VMDVIDEO = 53;
/*      */   public static final int AV_CODEC_ID_MSZH = 54;
/*      */   public static final int AV_CODEC_ID_ZLIB = 55;
/*      */   public static final int AV_CODEC_ID_QTRLE = 56;
/*      */   public static final int AV_CODEC_ID_TSCC = 57;
/*      */   public static final int AV_CODEC_ID_ULTI = 58;
/*      */   public static final int AV_CODEC_ID_QDRAW = 59;
/*      */   public static final int AV_CODEC_ID_VIXL = 60;
/*      */   public static final int AV_CODEC_ID_QPEG = 61;
/*      */   public static final int AV_CODEC_ID_PNG = 62;
/*      */   public static final int AV_CODEC_ID_PPM = 63;
/*      */   public static final int AV_CODEC_ID_PBM = 64;
/*      */   public static final int AV_CODEC_ID_PGM = 65;
/*      */   public static final int AV_CODEC_ID_PGMYUV = 66;
/*      */   public static final int AV_CODEC_ID_PAM = 67;
/*      */   public static final int AV_CODEC_ID_FFVHUFF = 68;
/*      */   public static final int AV_CODEC_ID_RV30 = 69;
/*      */   public static final int AV_CODEC_ID_RV40 = 70;
/*      */   public static final int AV_CODEC_ID_VC1 = 71;
/*      */   public static final int AV_CODEC_ID_WMV3 = 72;
/*      */   public static final int AV_CODEC_ID_LOCO = 73;
/*      */   public static final int AV_CODEC_ID_WNV1 = 74;
/*      */   public static final int AV_CODEC_ID_AASC = 75;
/*      */   public static final int AV_CODEC_ID_INDEO2 = 76;
/*      */   public static final int AV_CODEC_ID_FRAPS = 77;
/*      */   public static final int AV_CODEC_ID_TRUEMOTION2 = 78;
/*      */   public static final int AV_CODEC_ID_BMP = 79;
/*      */   public static final int AV_CODEC_ID_CSCD = 80;
/*      */   public static final int AV_CODEC_ID_MMVIDEO = 81;
/*      */   public static final int AV_CODEC_ID_ZMBV = 82;
/*      */   public static final int AV_CODEC_ID_AVS = 83;
/*      */   public static final int AV_CODEC_ID_SMACKVIDEO = 84;
/*      */   public static final int AV_CODEC_ID_NUV = 85;
/*      */   public static final int AV_CODEC_ID_KMVC = 86;
/*      */   public static final int AV_CODEC_ID_FLASHSV = 87;
/*      */   public static final int AV_CODEC_ID_CAVS = 88;
/*      */   public static final int AV_CODEC_ID_JPEG2000 = 89;
/*      */   public static final int AV_CODEC_ID_VMNC = 90;
/*      */   public static final int AV_CODEC_ID_VP5 = 91;
/*      */   public static final int AV_CODEC_ID_VP6 = 92;
/*      */   public static final int AV_CODEC_ID_VP6F = 93;
/*      */   public static final int AV_CODEC_ID_TARGA = 94;
/*      */   public static final int AV_CODEC_ID_DSICINVIDEO = 95;
/*      */   public static final int AV_CODEC_ID_TIERTEXSEQVIDEO = 96;
/*      */   public static final int AV_CODEC_ID_TIFF = 97;
/*      */   public static final int AV_CODEC_ID_GIF = 98;
/*      */   public static final int AV_CODEC_ID_DXA = 99;
/*      */   public static final int AV_CODEC_ID_DNXHD = 100;
/*      */   public static final int AV_CODEC_ID_THP = 101;
/*      */   public static final int AV_CODEC_ID_SGI = 102;
/*      */   public static final int AV_CODEC_ID_C93 = 103;
/*      */   public static final int AV_CODEC_ID_BETHSOFTVID = 104;
/*      */   public static final int AV_CODEC_ID_PTX = 105;
/*      */   public static final int AV_CODEC_ID_TXD = 106;
/*      */   public static final int AV_CODEC_ID_VP6A = 107;
/*      */   public static final int AV_CODEC_ID_AMV = 108;
/*      */   public static final int AV_CODEC_ID_VB = 109;
/*      */   public static final int AV_CODEC_ID_PCX = 110;
/*      */   public static final int AV_CODEC_ID_SUNRAST = 111;
/*      */   public static final int AV_CODEC_ID_INDEO4 = 112;
/*      */   public static final int AV_CODEC_ID_INDEO5 = 113;
/*      */   public static final int AV_CODEC_ID_MIMIC = 114;
/*      */   public static final int AV_CODEC_ID_RL2 = 115;
/*      */   public static final int AV_CODEC_ID_ESCAPE124 = 116;
/*      */   public static final int AV_CODEC_ID_DIRAC = 117;
/*      */   public static final int AV_CODEC_ID_BFI = 118;
/*      */   public static final int AV_CODEC_ID_CMV = 119;
/*      */   public static final int AV_CODEC_ID_MOTIONPIXELS = 120;
/*      */   public static final int AV_CODEC_ID_TGV = 121;
/*      */   public static final int AV_CODEC_ID_TGQ = 122;
/*      */   public static final int AV_CODEC_ID_TQI = 123;
/*      */   public static final int AV_CODEC_ID_AURA = 124;
/*      */   public static final int AV_CODEC_ID_AURA2 = 125;
/*      */   public static final int AV_CODEC_ID_V210X = 126;
/*      */   public static final int AV_CODEC_ID_TMV = 127;
/*      */   public static final int AV_CODEC_ID_V210 = 128;
/*      */   public static final int AV_CODEC_ID_DPX = 129;
/*      */   public static final int AV_CODEC_ID_MAD = 130;
/*      */   public static final int AV_CODEC_ID_FRWU = 131;
/*      */   public static final int AV_CODEC_ID_FLASHSV2 = 132;
/*      */   public static final int AV_CODEC_ID_CDGRAPHICS = 133;
/*      */   public static final int AV_CODEC_ID_R210 = 134;
/*      */   public static final int AV_CODEC_ID_ANM = 135;
/*      */   public static final int AV_CODEC_ID_BINKVIDEO = 136;
/*      */   public static final int AV_CODEC_ID_IFF_ILBM = 137;
/*      */   public static final int AV_CODEC_ID_IFF_BYTERUN1 = 138;
/*      */   public static final int AV_CODEC_ID_KGV1 = 139;
/*      */   public static final int AV_CODEC_ID_YOP = 140;
/*      */   public static final int AV_CODEC_ID_VP8 = 141;
/*      */   public static final int AV_CODEC_ID_PICTOR = 142;
/*      */   public static final int AV_CODEC_ID_ANSI = 143;
/*      */   public static final int AV_CODEC_ID_A64_MULTI = 144;
/*      */   public static final int AV_CODEC_ID_A64_MULTI5 = 145;
/*      */   public static final int AV_CODEC_ID_R10K = 146;
/*      */   public static final int AV_CODEC_ID_MXPEG = 147;
/*      */   public static final int AV_CODEC_ID_LAGARITH = 148;
/*      */   public static final int AV_CODEC_ID_PRORES = 149;
/*      */   public static final int AV_CODEC_ID_JV = 150;
/*      */   public static final int AV_CODEC_ID_DFA = 151;
/*      */   public static final int AV_CODEC_ID_WMV3IMAGE = 152;
/*      */   public static final int AV_CODEC_ID_VC1IMAGE = 153;
/*      */   public static final int AV_CODEC_ID_UTVIDEO = 154;
/*      */   public static final int AV_CODEC_ID_BMV_VIDEO = 155;
/*      */   public static final int AV_CODEC_ID_VBLE = 156;
/*      */   public static final int AV_CODEC_ID_DXTORY = 157;
/*      */   public static final int AV_CODEC_ID_V410 = 158;
/*      */   public static final int AV_CODEC_ID_XWD = 159;
/*      */   public static final int AV_CODEC_ID_CDXL = 160;
/*      */   public static final int AV_CODEC_ID_XBM = 161;
/*      */   public static final int AV_CODEC_ID_ZEROCODEC = 162;
/*      */   public static final int AV_CODEC_ID_MSS1 = 163;
/*      */   public static final int AV_CODEC_ID_MSA1 = 164;
/*      */   public static final int AV_CODEC_ID_TSCC2 = 165;
/*      */   public static final int AV_CODEC_ID_MTS2 = 166;
/*      */   public static final int AV_CODEC_ID_CLLC = 167;
/*      */   public static final int AV_CODEC_ID_MSS2 = 168;
/*      */   public static final int AV_CODEC_ID_VP9 = 169;
/*      */   public static final int AV_CODEC_ID_AIC = 170;
/*      */   public static final int AV_CODEC_ID_ESCAPE130_DEPRECATED = 171;
/*      */   public static final int AV_CODEC_ID_G2M_DEPRECATED = 172;
/*      */   public static final int AV_CODEC_ID_WEBP_DEPRECATED = 173;
/*  326 */   public static final int AV_CODEC_ID_BRENDER_PIX = AV_CODEC_ID_BRENDER_PIX();
/*      */ 
/*  329 */   public static final int AV_CODEC_ID_Y41P = AV_CODEC_ID_Y41P();
/*      */ 
/*  332 */   public static final int AV_CODEC_ID_ESCAPE130 = AV_CODEC_ID_ESCAPE130();
/*      */ 
/*  335 */   public static final int AV_CODEC_ID_EXR = AV_CODEC_ID_EXR();
/*      */ 
/*  338 */   public static final int AV_CODEC_ID_AVRP = AV_CODEC_ID_AVRP();
/*      */ 
/*  342 */   public static final int AV_CODEC_ID_012V = AV_CODEC_ID_012V();
/*      */ 
/*  345 */   public static final int AV_CODEC_ID_G2M = AV_CODEC_ID_G2M();
/*      */ 
/*  348 */   public static final int AV_CODEC_ID_AVUI = AV_CODEC_ID_AVUI();
/*      */ 
/*  351 */   public static final int AV_CODEC_ID_AYUV = AV_CODEC_ID_AYUV();
/*      */ 
/*  354 */   public static final int AV_CODEC_ID_TARGA_Y216 = AV_CODEC_ID_TARGA_Y216();
/*      */ 
/*  357 */   public static final int AV_CODEC_ID_V308 = AV_CODEC_ID_V308();
/*      */ 
/*  360 */   public static final int AV_CODEC_ID_V408 = AV_CODEC_ID_V408();
/*      */ 
/*  363 */   public static final int AV_CODEC_ID_YUV4 = AV_CODEC_ID_YUV4();
/*      */ 
/*  366 */   public static final int AV_CODEC_ID_SANM = AV_CODEC_ID_SANM();
/*      */ 
/*  369 */   public static final int AV_CODEC_ID_PAF_VIDEO = AV_CODEC_ID_PAF_VIDEO();
/*      */ 
/*  372 */   public static final int AV_CODEC_ID_AVRN = AV_CODEC_ID_AVRN();
/*      */ 
/*  375 */   public static final int AV_CODEC_ID_CPIA = AV_CODEC_ID_CPIA();
/*      */ 
/*  378 */   public static final int AV_CODEC_ID_XFACE = AV_CODEC_ID_XFACE();
/*      */ 
/*  381 */   public static final int AV_CODEC_ID_SGIRLE = AV_CODEC_ID_SGIRLE();
/*      */ 
/*  384 */   public static final int AV_CODEC_ID_MVC1 = AV_CODEC_ID_MVC1();
/*      */ 
/*  387 */   public static final int AV_CODEC_ID_MVC2 = AV_CODEC_ID_MVC2();
/*      */ 
/*  390 */   public static final int AV_CODEC_ID_SNOW = AV_CODEC_ID_SNOW();
/*      */ 
/*  393 */   public static final int AV_CODEC_ID_WEBP = AV_CODEC_ID_WEBP();
/*      */ 
/*  396 */   public static final int AV_CODEC_ID_SMVJPEG = AV_CODEC_ID_SMVJPEG();
/*      */ 
/*  399 */   public static final int AV_CODEC_ID_HEVC = AV_CODEC_ID_HEVC();
/*      */ 
/*  401 */   public static final int AV_CODEC_ID_H265 = AV_CODEC_ID_HEVC;
/*      */   public static final int AV_CODEC_ID_FIRST_AUDIO = 65536;
/*      */   public static final int AV_CODEC_ID_PCM_S16LE = 65536;
/*      */   public static final int AV_CODEC_ID_PCM_S16BE = 65537;
/*      */   public static final int AV_CODEC_ID_PCM_U16LE = 65538;
/*      */   public static final int AV_CODEC_ID_PCM_U16BE = 65539;
/*      */   public static final int AV_CODEC_ID_PCM_S8 = 65540;
/*      */   public static final int AV_CODEC_ID_PCM_U8 = 65541;
/*      */   public static final int AV_CODEC_ID_PCM_MULAW = 65542;
/*      */   public static final int AV_CODEC_ID_PCM_ALAW = 65543;
/*      */   public static final int AV_CODEC_ID_PCM_S32LE = 65544;
/*      */   public static final int AV_CODEC_ID_PCM_S32BE = 65545;
/*      */   public static final int AV_CODEC_ID_PCM_U32LE = 65546;
/*      */   public static final int AV_CODEC_ID_PCM_U32BE = 65547;
/*      */   public static final int AV_CODEC_ID_PCM_S24LE = 65548;
/*      */   public static final int AV_CODEC_ID_PCM_S24BE = 65549;
/*      */   public static final int AV_CODEC_ID_PCM_U24LE = 65550;
/*      */   public static final int AV_CODEC_ID_PCM_U24BE = 65551;
/*      */   public static final int AV_CODEC_ID_PCM_S24DAUD = 65552;
/*      */   public static final int AV_CODEC_ID_PCM_ZORK = 65553;
/*      */   public static final int AV_CODEC_ID_PCM_S16LE_PLANAR = 65554;
/*      */   public static final int AV_CODEC_ID_PCM_DVD = 65555;
/*      */   public static final int AV_CODEC_ID_PCM_F32BE = 65556;
/*      */   public static final int AV_CODEC_ID_PCM_F32LE = 65557;
/*      */   public static final int AV_CODEC_ID_PCM_F64BE = 65558;
/*      */   public static final int AV_CODEC_ID_PCM_F64LE = 65559;
/*      */   public static final int AV_CODEC_ID_PCM_BLURAY = 65560;
/*      */   public static final int AV_CODEC_ID_PCM_LXF = 65561;
/*      */   public static final int AV_CODEC_ID_S302M = 65562;
/*      */   public static final int AV_CODEC_ID_PCM_S8_PLANAR = 65563;
/*      */   public static final int AV_CODEC_ID_PCM_S24LE_PLANAR_DEPRECATED = 65564;
/*      */   public static final int AV_CODEC_ID_PCM_S32LE_PLANAR_DEPRECATED = 65565;
/*  439 */   public static final int AV_CODEC_ID_PCM_S24LE_PLANAR = AV_CODEC_ID_PCM_S24LE_PLANAR();
/*      */ 
/*  442 */   public static final int AV_CODEC_ID_PCM_S32LE_PLANAR = AV_CODEC_ID_PCM_S32LE_PLANAR();
/*      */ 
/*  445 */   public static final int AV_CODEC_ID_PCM_S16BE_PLANAR = AV_CODEC_ID_PCM_S16BE_PLANAR();
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_QT = 69632;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_WAV = 69633;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_DK3 = 69634;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_DK4 = 69635;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_WS = 69636;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_SMJPEG = 69637;
/*      */   public static final int AV_CODEC_ID_ADPCM_MS = 69638;
/*      */   public static final int AV_CODEC_ID_ADPCM_4XM = 69639;
/*      */   public static final int AV_CODEC_ID_ADPCM_XA = 69640;
/*      */   public static final int AV_CODEC_ID_ADPCM_ADX = 69641;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA = 69642;
/*      */   public static final int AV_CODEC_ID_ADPCM_G726 = 69643;
/*      */   public static final int AV_CODEC_ID_ADPCM_CT = 69644;
/*      */   public static final int AV_CODEC_ID_ADPCM_SWF = 69645;
/*      */   public static final int AV_CODEC_ID_ADPCM_YAMAHA = 69646;
/*      */   public static final int AV_CODEC_ID_ADPCM_SBPRO_4 = 69647;
/*      */   public static final int AV_CODEC_ID_ADPCM_SBPRO_3 = 69648;
/*      */   public static final int AV_CODEC_ID_ADPCM_SBPRO_2 = 69649;
/*      */   public static final int AV_CODEC_ID_ADPCM_THP = 69650;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_AMV = 69651;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA_R1 = 69652;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA_R3 = 69653;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA_R2 = 69654;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_EA_SEAD = 69655;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_EA_EACS = 69656;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA_XAS = 69657;
/*      */   public static final int AV_CODEC_ID_ADPCM_EA_MAXIS_XA = 69658;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_ISS = 69659;
/*      */   public static final int AV_CODEC_ID_ADPCM_G722 = 69660;
/*      */   public static final int AV_CODEC_ID_ADPCM_IMA_APC = 69661;
/*  480 */   public static final int AV_CODEC_ID_VIMA = AV_CODEC_ID_VIMA();
/*      */ 
/*  483 */   public static final int AV_CODEC_ID_ADPCM_AFC = AV_CODEC_ID_ADPCM_AFC();
/*      */ 
/*  486 */   public static final int AV_CODEC_ID_ADPCM_IMA_OKI = AV_CODEC_ID_ADPCM_IMA_OKI();
/*      */ 
/*  489 */   public static final int AV_CODEC_ID_ADPCM_DTK = AV_CODEC_ID_ADPCM_DTK();
/*      */ 
/*  492 */   public static final int AV_CODEC_ID_ADPCM_IMA_RAD = AV_CODEC_ID_ADPCM_IMA_RAD();
/*      */ 
/*  495 */   public static final int AV_CODEC_ID_ADPCM_G726LE = AV_CODEC_ID_ADPCM_G726LE();
/*      */   public static final int AV_CODEC_ID_AMR_NB = 73728;
/*      */   public static final int AV_CODEC_ID_AMR_WB = 73729;
/*      */   public static final int AV_CODEC_ID_RA_144 = 77824;
/*      */   public static final int AV_CODEC_ID_RA_288 = 77825;
/*      */   public static final int AV_CODEC_ID_ROQ_DPCM = 81920;
/*      */   public static final int AV_CODEC_ID_INTERPLAY_DPCM = 81921;
/*      */   public static final int AV_CODEC_ID_XAN_DPCM = 81922;
/*      */   public static final int AV_CODEC_ID_SOL_DPCM = 81923;
/*      */   public static final int AV_CODEC_ID_MP2 = 86016;
/*      */   public static final int AV_CODEC_ID_MP3 = 86017;
/*      */   public static final int AV_CODEC_ID_AAC = 86018;
/*      */   public static final int AV_CODEC_ID_AC3 = 86019;
/*      */   public static final int AV_CODEC_ID_DTS = 86020;
/*      */   public static final int AV_CODEC_ID_VORBIS = 86021;
/*      */   public static final int AV_CODEC_ID_DVAUDIO = 86022;
/*      */   public static final int AV_CODEC_ID_WMAV1 = 86023;
/*      */   public static final int AV_CODEC_ID_WMAV2 = 86024;
/*      */   public static final int AV_CODEC_ID_MACE3 = 86025;
/*      */   public static final int AV_CODEC_ID_MACE6 = 86026;
/*      */   public static final int AV_CODEC_ID_VMDAUDIO = 86027;
/*      */   public static final int AV_CODEC_ID_FLAC = 86028;
/*      */   public static final int AV_CODEC_ID_MP3ADU = 86029;
/*      */   public static final int AV_CODEC_ID_MP3ON4 = 86030;
/*      */   public static final int AV_CODEC_ID_SHORTEN = 86031;
/*      */   public static final int AV_CODEC_ID_ALAC = 86032;
/*      */   public static final int AV_CODEC_ID_WESTWOOD_SND1 = 86033;
/*      */   public static final int AV_CODEC_ID_GSM = 86034;
/*      */   public static final int AV_CODEC_ID_QDM2 = 86035;
/*      */   public static final int AV_CODEC_ID_COOK = 86036;
/*      */   public static final int AV_CODEC_ID_TRUESPEECH = 86037;
/*      */   public static final int AV_CODEC_ID_TTA = 86038;
/*      */   public static final int AV_CODEC_ID_SMACKAUDIO = 86039;
/*      */   public static final int AV_CODEC_ID_QCELP = 86040;
/*      */   public static final int AV_CODEC_ID_WAVPACK = 86041;
/*      */   public static final int AV_CODEC_ID_DSICINAUDIO = 86042;
/*      */   public static final int AV_CODEC_ID_IMC = 86043;
/*      */   public static final int AV_CODEC_ID_MUSEPACK7 = 86044;
/*      */   public static final int AV_CODEC_ID_MLP = 86045;
/*      */   public static final int AV_CODEC_ID_GSM_MS = 86046;
/*      */   public static final int AV_CODEC_ID_ATRAC3 = 86047;
/*      */   public static final int AV_CODEC_ID_VOXWARE = 86048;
/*      */   public static final int AV_CODEC_ID_APE = 86049;
/*      */   public static final int AV_CODEC_ID_NELLYMOSER = 86050;
/*      */   public static final int AV_CODEC_ID_MUSEPACK8 = 86051;
/*      */   public static final int AV_CODEC_ID_SPEEX = 86052;
/*      */   public static final int AV_CODEC_ID_WMAVOICE = 86053;
/*      */   public static final int AV_CODEC_ID_WMAPRO = 86054;
/*      */   public static final int AV_CODEC_ID_WMALOSSLESS = 86055;
/*      */   public static final int AV_CODEC_ID_ATRAC3P = 86056;
/*      */   public static final int AV_CODEC_ID_EAC3 = 86057;
/*      */   public static final int AV_CODEC_ID_SIPR = 86058;
/*      */   public static final int AV_CODEC_ID_MP1 = 86059;
/*      */   public static final int AV_CODEC_ID_TWINVQ = 86060;
/*      */   public static final int AV_CODEC_ID_TRUEHD = 86061;
/*      */   public static final int AV_CODEC_ID_MP4ALS = 86062;
/*      */   public static final int AV_CODEC_ID_ATRAC1 = 86063;
/*      */   public static final int AV_CODEC_ID_BINKAUDIO_RDFT = 86064;
/*      */   public static final int AV_CODEC_ID_BINKAUDIO_DCT = 86065;
/*      */   public static final int AV_CODEC_ID_AAC_LATM = 86066;
/*      */   public static final int AV_CODEC_ID_QDMC = 86067;
/*      */   public static final int AV_CODEC_ID_CELT = 86068;
/*      */   public static final int AV_CODEC_ID_G723_1 = 86069;
/*      */   public static final int AV_CODEC_ID_G729 = 86070;
/*      */   public static final int AV_CODEC_ID_8SVX_EXP = 86071;
/*      */   public static final int AV_CODEC_ID_8SVX_FIB = 86072;
/*      */   public static final int AV_CODEC_ID_BMV_AUDIO = 86073;
/*      */   public static final int AV_CODEC_ID_RALF = 86074;
/*      */   public static final int AV_CODEC_ID_IAC = 86075;
/*      */   public static final int AV_CODEC_ID_ILBC = 86076;
/*      */   public static final int AV_CODEC_ID_OPUS_DEPRECATED = 86077;
/*      */   public static final int AV_CODEC_ID_COMFORT_NOISE = 86078;
/*      */   public static final int AV_CODEC_ID_TAK_DEPRECATED = 86079;
/*      */   public static final int AV_CODEC_ID_METASOUND = 86080;
/*  583 */   public static final int AV_CODEC_ID_FFWAVESYNTH = AV_CODEC_ID_FFWAVESYNTH();
/*      */ 
/*  586 */   public static final int AV_CODEC_ID_SONIC = AV_CODEC_ID_SONIC();
/*      */ 
/*  589 */   public static final int AV_CODEC_ID_SONIC_LS = AV_CODEC_ID_SONIC_LS();
/*      */ 
/*  592 */   public static final int AV_CODEC_ID_PAF_AUDIO = AV_CODEC_ID_PAF_AUDIO();
/*      */ 
/*  595 */   public static final int AV_CODEC_ID_OPUS = AV_CODEC_ID_OPUS();
/*      */ 
/*  598 */   public static final int AV_CODEC_ID_TAK = AV_CODEC_ID_TAK();
/*      */ 
/*  601 */   public static final int AV_CODEC_ID_EVRC = AV_CODEC_ID_EVRC();
/*      */ 
/*  604 */   public static final int AV_CODEC_ID_SMV = AV_CODEC_ID_SMV();
/*      */   public static final int AV_CODEC_ID_FIRST_SUBTITLE = 94208;
/*      */   public static final int AV_CODEC_ID_DVD_SUBTITLE = 94208;
/*      */   public static final int AV_CODEC_ID_DVB_SUBTITLE = 94209;
/*      */   public static final int AV_CODEC_ID_TEXT = 94210;
/*      */   public static final int AV_CODEC_ID_XSUB = 94211;
/*      */   public static final int AV_CODEC_ID_SSA = 94212;
/*      */   public static final int AV_CODEC_ID_MOV_TEXT = 94213;
/*      */   public static final int AV_CODEC_ID_HDMV_PGS_SUBTITLE = 94214;
/*      */   public static final int AV_CODEC_ID_DVB_TELETEXT = 94215;
/*      */   public static final int AV_CODEC_ID_SRT = 94216;
/*  621 */   public static final int AV_CODEC_ID_MICRODVD = AV_CODEC_ID_MICRODVD();
/*      */ 
/*  624 */   public static final int AV_CODEC_ID_EIA_608 = AV_CODEC_ID_EIA_608();
/*      */ 
/*  627 */   public static final int AV_CODEC_ID_JACOSUB = AV_CODEC_ID_JACOSUB();
/*      */ 
/*  630 */   public static final int AV_CODEC_ID_SAMI = AV_CODEC_ID_SAMI();
/*      */ 
/*  633 */   public static final int AV_CODEC_ID_REALTEXT = AV_CODEC_ID_REALTEXT();
/*      */ 
/*  636 */   public static final int AV_CODEC_ID_SUBVIEWER1 = AV_CODEC_ID_SUBVIEWER1();
/*      */ 
/*  639 */   public static final int AV_CODEC_ID_SUBVIEWER = AV_CODEC_ID_SUBVIEWER();
/*      */ 
/*  642 */   public static final int AV_CODEC_ID_SUBRIP = AV_CODEC_ID_SUBRIP();
/*      */ 
/*  645 */   public static final int AV_CODEC_ID_WEBVTT = AV_CODEC_ID_WEBVTT();
/*      */ 
/*  648 */   public static final int AV_CODEC_ID_MPL2 = AV_CODEC_ID_MPL2();
/*      */ 
/*  651 */   public static final int AV_CODEC_ID_VPLAYER = AV_CODEC_ID_VPLAYER();
/*      */ 
/*  654 */   public static final int AV_CODEC_ID_PJS = AV_CODEC_ID_PJS();
/*      */ 
/*  658 */   public static final int AV_CODEC_ID_ASS = AV_CODEC_ID_ASS();
/*      */   public static final int AV_CODEC_ID_FIRST_UNKNOWN = 98304;
/*      */   public static final int AV_CODEC_ID_TTF = 98304;
/*  666 */   public static final int AV_CODEC_ID_BINTEXT = AV_CODEC_ID_BINTEXT();
/*      */ 
/*  669 */   public static final int AV_CODEC_ID_XBIN = AV_CODEC_ID_XBIN();
/*      */ 
/*  672 */   public static final int AV_CODEC_ID_IDF = AV_CODEC_ID_IDF();
/*      */ 
/*  675 */   public static final int AV_CODEC_ID_OTF = AV_CODEC_ID_OTF();
/*      */ 
/*  678 */   public static final int AV_CODEC_ID_SMPTE_KLV = AV_CODEC_ID_SMPTE_KLV();
/*      */ 
/*  681 */   public static final int AV_CODEC_ID_DVD_NAV = AV_CODEC_ID_DVD_NAV();
/*      */   public static final int AV_CODEC_ID_PROBE = 102400;
/*      */   public static final int AV_CODEC_ID_MPEG2TS = 131072;
/*      */   public static final int AV_CODEC_ID_MPEG4SYSTEMS = 131073;
/*      */   public static final int AV_CODEC_ID_FFMETADATA = 135168;
/*      */   public static final int AV_CODEC_PROP_INTRA_ONLY = 1;
/*      */   public static final int AV_CODEC_PROP_LOSSY = 2;
/*      */   public static final int AV_CODEC_PROP_LOSSLESS = 4;
/*      */   public static final int AV_CODEC_PROP_BITMAP_SUB = 65536;
/*      */   public static final int AV_CODEC_PROP_TEXT_SUB = 131072;
/*      */   public static final int FF_INPUT_BUFFER_PADDING_SIZE = 16;
/*      */   public static final int FF_MIN_BUFFER_SIZE = 16384;
/*      */   public static final int ME_ZERO = 1;
/*      */   public static final int ME_FULL = 2;
/*      */   public static final int ME_LOG = 3;
/*      */   public static final int ME_PHODS = 4;
/*      */   public static final int ME_EPZS = 5;
/*      */   public static final int ME_X1 = 6;
/*      */   public static final int ME_HEX = 7;
/*      */   public static final int ME_UMH = 8;
/*      */   public static final int ME_TESA = 9;
/*      */   public static final int ME_ITER = 50;
/*      */   public static final int AVDISCARD_NONE = -16;
/*      */   public static final int AVDISCARD_DEFAULT = 0;
/*      */   public static final int AVDISCARD_NONREF = 8;
/*      */   public static final int AVDISCARD_BIDIR = 16;
/*      */   public static final int AVDISCARD_NONKEY = 32;
/*      */   public static final int AVDISCARD_ALL = 48;
/*      */   public static final int AVCOL_PRI_BT709 = 1;
/*      */   public static final int AVCOL_PRI_UNSPECIFIED = 2;
/*      */   public static final int AVCOL_PRI_BT470M = 4;
/*      */   public static final int AVCOL_PRI_BT470BG = 5;
/*      */   public static final int AVCOL_PRI_SMPTE170M = 6;
/*      */   public static final int AVCOL_PRI_SMPTE240M = 7;
/*      */   public static final int AVCOL_PRI_FILM = 8;
/*      */   public static final int AVCOL_PRI_NB = 9;
/*      */   public static final int AVCOL_TRC_BT709 = 1;
/*      */   public static final int AVCOL_TRC_UNSPECIFIED = 2;
/*      */   public static final int AVCOL_TRC_GAMMA22 = 4;
/*      */   public static final int AVCOL_TRC_GAMMA28 = 5;
/*      */   public static final int AVCOL_TRC_SMPTE240M = 7;
/*      */   public static final int AVCOL_TRC_NB = 8;
/*      */   public static final int AVCHROMA_LOC_UNSPECIFIED = 0;
/*      */   public static final int AVCHROMA_LOC_LEFT = 1;
/*      */   public static final int AVCHROMA_LOC_CENTER = 2;
/*      */   public static final int AVCHROMA_LOC_TOPLEFT = 3;
/*      */   public static final int AVCHROMA_LOC_TOP = 4;
/*      */   public static final int AVCHROMA_LOC_BOTTOMLEFT = 5;
/*      */   public static final int AVCHROMA_LOC_BOTTOM = 6;
/*      */   public static final int AVCHROMA_LOC_NB = 7;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_MAIN = 0;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_EFFECTS = 1;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_VISUALLY_IMPAIRED = 2;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_HEARING_IMPAIRED = 3;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_DIALOGUE = 4;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_COMMENTARY = 5;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_EMERGENCY = 6;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_VOICE_OVER = 7;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_KARAOKE = 8;
/*      */   public static final int AV_AUDIO_SERVICE_TYPE_NB = 9;
/*      */   public static final int FF_MAX_B_FRAMES = 16;
/*      */   public static final int CODEC_FLAG_UNALIGNED = 1;
/*      */   public static final int CODEC_FLAG_QSCALE = 2;
/*      */   public static final int CODEC_FLAG_4MV = 4;
/*      */   public static final int CODEC_FLAG_QPEL = 16;
/*      */   public static final int CODEC_FLAG_GMC = 32;
/*      */   public static final int CODEC_FLAG_MV0 = 64;
/*      */   public static final int CODEC_FLAG_INPUT_PRESERVED = 256;
/*      */   public static final int CODEC_FLAG_PASS1 = 512;
/*      */   public static final int CODEC_FLAG_PASS2 = 1024;
/*      */   public static final int CODEC_FLAG_GRAY = 8192;
/*      */   public static final int CODEC_FLAG_EMU_EDGE = 16384;
/*      */   public static final int CODEC_FLAG_PSNR = 32768;
/*      */   public static final int CODEC_FLAG_TRUNCATED = 65536;
/*      */   public static final int CODEC_FLAG_NORMALIZE_AQP = 131072;
/*      */   public static final int CODEC_FLAG_INTERLACED_DCT = 262144;
/*      */   public static final int CODEC_FLAG_LOW_DELAY = 524288;
/*      */   public static final int CODEC_FLAG_GLOBAL_HEADER = 4194304;
/*      */   public static final int CODEC_FLAG_BITEXACT = 8388608;
/*      */   public static final int CODEC_FLAG_AC_PRED = 16777216;
/*      */   public static final int CODEC_FLAG_LOOP_FILTER = 2048;
/*      */   public static final int CODEC_FLAG_INTERLACED_ME = 536870912;
/*      */   public static final int CODEC_FLAG_CLOSED_GOP = -2147483648;
/*      */   public static final int CODEC_FLAG2_FAST = 1;
/*      */   public static final int CODEC_FLAG2_NO_OUTPUT = 4;
/*      */   public static final int CODEC_FLAG2_LOCAL_HEADER = 8;
/*      */   public static final int CODEC_FLAG2_DROP_FRAME_TIMECODE = 8192;
/*      */   public static final int CODEC_FLAG2_IGNORE_CROP = 65536;
/*      */   public static final int CODEC_FLAG2_CHUNKS = 32768;
/*      */   public static final int CODEC_FLAG2_SHOW_ALL = 4194304;
/*      */   public static final int CODEC_CAP_DRAW_HORIZ_BAND = 1;
/*      */   public static final int CODEC_CAP_DR1 = 2;
/*      */   public static final int CODEC_CAP_TRUNCATED = 8;
/*      */   public static final int CODEC_CAP_HWACCEL = 16;
/*      */   public static final int CODEC_CAP_DELAY = 32;
/*      */   public static final int CODEC_CAP_SMALL_LAST_FRAME = 64;
/*      */   public static final int CODEC_CAP_HWACCEL_VDPAU = 128;
/*      */   public static final int CODEC_CAP_SUBFRAMES = 256;
/*      */   public static final int CODEC_CAP_EXPERIMENTAL = 512;
/*      */   public static final int CODEC_CAP_CHANNEL_CONF = 1024;
/*      */   public static final int CODEC_CAP_NEG_LINESIZES = 2048;
/*      */   public static final int CODEC_CAP_FRAME_THREADS = 4096;
/*      */   public static final int CODEC_CAP_SLICE_THREADS = 8192;
/*      */   public static final int CODEC_CAP_PARAM_CHANGE = 16384;
/*      */   public static final int CODEC_CAP_AUTO_THREADS = 32768;
/*      */   public static final int CODEC_CAP_VARIABLE_FRAME_SIZE = 65536;
/*      */   public static final int CODEC_CAP_INTRA_ONLY = 1073741824;
/*      */   public static final int CODEC_CAP_LOSSLESS = -2147483648;
/*      */   public static final int MB_TYPE_INTRA4x4 = 1;
/*      */   public static final int MB_TYPE_INTRA16x16 = 2;
/*      */   public static final int MB_TYPE_INTRA_PCM = 4;
/*      */   public static final int MB_TYPE_16x16 = 8;
/*      */   public static final int MB_TYPE_16x8 = 16;
/*      */   public static final int MB_TYPE_8x16 = 32;
/*      */   public static final int MB_TYPE_8x8 = 64;
/*      */   public static final int MB_TYPE_INTERLACED = 128;
/*      */   public static final int MB_TYPE_DIRECT2 = 256;
/*      */   public static final int MB_TYPE_ACPRED = 512;
/*      */   public static final int MB_TYPE_GMC = 1024;
/*      */   public static final int MB_TYPE_SKIP = 2048;
/*      */   public static final int MB_TYPE_P0L0 = 4096;
/*      */   public static final int MB_TYPE_P1L0 = 8192;
/*      */   public static final int MB_TYPE_P0L1 = 16384;
/*      */   public static final int MB_TYPE_P1L1 = 32768;
/*      */   public static final int MB_TYPE_L0 = 12288;
/*      */   public static final int MB_TYPE_L1 = 49152;
/*      */   public static final int MB_TYPE_L0L1 = 61440;
/*      */   public static final int MB_TYPE_QUANT = 65536;
/*      */   public static final int MB_TYPE_CBP = 131072;
/*      */   public static final int FF_QSCALE_TYPE_MPEG1 = 0;
/*      */   public static final int FF_QSCALE_TYPE_MPEG2 = 1;
/*      */   public static final int FF_QSCALE_TYPE_H264 = 2;
/*      */   public static final int FF_QSCALE_TYPE_VP56 = 3;
/*      */   public static final int FF_BUFFER_TYPE_INTERNAL = 1;
/*      */   public static final int FF_BUFFER_TYPE_USER = 2;
/*      */   public static final int FF_BUFFER_TYPE_SHARED = 4;
/*      */   public static final int FF_BUFFER_TYPE_COPY = 8;
/*      */   public static final int FF_BUFFER_HINTS_VALID = 1;
/*      */   public static final int FF_BUFFER_HINTS_READABLE = 2;
/*      */   public static final int FF_BUFFER_HINTS_PRESERVE = 4;
/*      */   public static final int FF_BUFFER_HINTS_REUSABLE = 8;
/*      */   public static final int AV_GET_BUFFER_FLAG_REF = 1;
/*      */   public static final int AV_PKT_DATA_PALETTE = 0;
/*      */   public static final int AV_PKT_DATA_NEW_EXTRADATA = 1;
/*      */   public static final int AV_PKT_DATA_PARAM_CHANGE = 2;
/*      */   public static final int AV_PKT_DATA_H263_MB_INFO = 3;
/*      */   public static final int AV_PKT_DATA_SKIP_SAMPLES = 70;
/*      */   public static final int AV_PKT_DATA_JP_DUALMONO = 71;
/*      */   public static final int AV_PKT_DATA_STRINGS_METADATA = 72;
/*      */   public static final int AV_PKT_DATA_SUBTITLE_POSITION = 73;
/*      */   public static final int AV_PKT_DATA_MATROSKA_BLOCKADDITIONAL = 74;
/*      */   public static final int AV_PKT_DATA_WEBVTT_IDENTIFIER = 75;
/*      */   public static final int AV_PKT_DATA_WEBVTT_SETTINGS = 76;
/*      */   public static final int AV_PKT_FLAG_KEY = 1;
/*      */   public static final int AV_PKT_FLAG_CORRUPT = 2;
/*      */   public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_COUNT = 1;
/*      */   public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_LAYOUT = 2;
/*      */   public static final int AV_SIDE_DATA_PARAM_CHANGE_SAMPLE_RATE = 4;
/*      */   public static final int AV_SIDE_DATA_PARAM_CHANGE_DIMENSIONS = 8;
/*      */   public static final int AV_FIELD_UNKNOWN = 0;
/*      */   public static final int AV_FIELD_PROGRESSIVE = 1;
/*      */   public static final int AV_FIELD_TT = 2;
/*      */   public static final int AV_FIELD_BB = 3;
/*      */   public static final int AV_FIELD_TB = 4;
/*      */   public static final int AV_FIELD_BT = 5;
/*      */   public static final int SUBTITLE_NONE = 0;
/*      */   public static final int SUBTITLE_BITMAP = 1;
/*      */   public static final int SUBTITLE_TEXT = 2;
/*      */   public static final int SUBTITLE_ASS = 3;
/*      */   public static final int AV_SUBTITLE_FLAG_FORCED = 1;
/*      */   public static final int AV_PICTURE_STRUCTURE_UNKNOWN = 0;
/*      */   public static final int AV_PICTURE_STRUCTURE_TOP_FIELD = 1;
/*      */   public static final int AV_PICTURE_STRUCTURE_BOTTOM_FIELD = 2;
/*      */   public static final int AV_PICTURE_STRUCTURE_FRAME = 3;
/*      */   public static final int FF_LOSS_RESOLUTION = 1;
/*      */   public static final int FF_LOSS_DEPTH = 2;
/*      */   public static final int FF_LOSS_COLORSPACE = 4;
/*      */   public static final int FF_LOSS_ALPHA = 8;
/*      */   public static final int FF_LOSS_COLORQUANT = 16;
/*      */   public static final int FF_LOSS_CHROMA = 32;
/*      */   public static final int AV_LOCK_CREATE = 0;
/*      */   public static final int AV_LOCK_OBTAIN = 1;
/*      */   public static final int AV_LOCK_RELEASE = 2;
/*      */   public static final int AV_LOCK_DESTROY = 3;
/*      */   public static final int DFT_R2C = 0;
/*      */   public static final int IDFT_C2R = 1;
/*      */   public static final int IDFT_R2C = 2;
/*      */   public static final int DFT_C2R = 3;
/*      */   public static final int DCT_II = 0;
/*      */   public static final int DCT_III = 1;
/*      */   public static final int DCT_I = 2;
/*      */   public static final int DST_I = 3;
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_BRENDER_PIX();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_Y41P();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ESCAPE130();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_EXR();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_AVRP();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_012V();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_G2M();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_AVUI();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_AYUV();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_TARGA_Y216();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_V308();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_V408();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_YUV4();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SANM();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PAF_VIDEO();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_AVRN();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_CPIA();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_XFACE();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SGIRLE();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_MVC1();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_MVC2();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SNOW();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_WEBP();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SMVJPEG();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_HEVC();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PCM_S24LE_PLANAR();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PCM_S32LE_PLANAR();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PCM_S16BE_PLANAR();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_VIMA();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ADPCM_AFC();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ADPCM_IMA_OKI();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ADPCM_DTK();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ADPCM_IMA_RAD();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ADPCM_G726LE();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_FFWAVESYNTH();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SONIC();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SONIC_LS();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PAF_AUDIO();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_OPUS();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_TAK();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_EVRC();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SMV();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_MICRODVD();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_EIA_608();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_JACOSUB();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SAMI();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_REALTEXT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SUBVIEWER1();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SUBVIEWER();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SUBRIP();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_WEBVTT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_MPL2();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_VPLAYER();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_PJS();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_ASS();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_BINTEXT();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_XBIN();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_IDF();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_OTF();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_SMPTE_KLV();
/*      */ 
/*      */   @MemberGetter
/*      */   public static native int AV_CODEC_ID_DVD_NAV();
/*      */ 
/*      */   @ByVal
/*      */   public static native avutil.AVRational av_codec_get_pkt_timebase(@Const AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native void av_codec_set_pkt_timebase(AVCodecContext paramAVCodecContext, @ByVal avutil.AVRational paramAVRational);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecDescriptor av_codec_get_codec_descriptor(@Const AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native void av_codec_set_codec_descriptor(AVCodecContext paramAVCodecContext, @Const AVCodecDescriptor paramAVCodecDescriptor);
/*      */ 
/*      */   public static native int av_codec_get_lowres(@Const AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native void av_codec_set_lowres(AVCodecContext paramAVCodecContext, int paramInt);
/*      */ 
/*      */   public static native int av_codec_get_seek_preroll(@Const AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native void av_codec_set_seek_preroll(AVCodecContext paramAVCodecContext, int paramInt);
/*      */ 
/*      */   public static native int av_codec_get_max_lowres(@Const AVCodec paramAVCodec);
/*      */ 
/*      */   public static native AVCodec av_codec_next(@Const AVCodec paramAVCodec);
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int avcodec_version();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avcodec_configuration();
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avcodec_license();
/*      */ 
/*      */   public static native void avcodec_register(AVCodec paramAVCodec);
/*      */ 
/*      */   public static native void avcodec_register_all();
/*      */ 
/*      */   public static native AVCodecContext avcodec_alloc_context3(@Const AVCodec paramAVCodec);
/*      */ 
/*      */   public static native int avcodec_get_context_defaults3(AVCodecContext paramAVCodecContext, @Const AVCodec paramAVCodec);
/*      */ 
/*      */   @Const
/*      */   public static native avutil.AVClass avcodec_get_class();
/*      */ 
/*      */   @Const
/*      */   public static native avutil.AVClass avcodec_get_frame_class();
/*      */ 
/*      */   @Const
/*      */   public static native avutil.AVClass avcodec_get_subtitle_rect_class();
/*      */ 
/*      */   public static native int avcodec_copy_context(AVCodecContext paramAVCodecContext1, @Const AVCodecContext paramAVCodecContext2);
/*      */ 
/*      */   public static native avutil.AVFrame avcodec_alloc_frame();
/*      */ 
/*      */   public static native void avcodec_get_frame_defaults(avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native void avcodec_free_frame(@Cast({"AVFrame**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native void avcodec_free_frame(@ByPtrPtr avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int avcodec_open2(AVCodecContext paramAVCodecContext, @Const AVCodec paramAVCodec, @Cast({"AVDictionary**"}) PointerPointer paramPointerPointer);
/*      */ 
/*      */   public static native int avcodec_open2(AVCodecContext paramAVCodecContext, @Const AVCodec paramAVCodec, @ByPtrPtr avutil.AVDictionary paramAVDictionary);
/*      */ 
/*      */   public static native int avcodec_close(AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native void avsubtitle_free(AVSubtitle paramAVSubtitle);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_destruct_packet(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native void av_init_packet(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_new_packet(AVPacket paramAVPacket, int paramInt);
/*      */ 
/*      */   public static native void av_shrink_packet(AVPacket paramAVPacket, int paramInt);
/*      */ 
/*      */   public static native int av_grow_packet(AVPacket paramAVPacket, int paramInt);
/*      */ 
/*      */   public static native int av_packet_from_data(AVPacket paramAVPacket, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   public static native int av_packet_from_data(AVPacket paramAVPacket, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt);
/*      */ 
/*      */   public static native int av_packet_from_data(AVPacket paramAVPacket, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt);
/*      */ 
/*      */   public static native int av_dup_packet(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_copy_packet(AVPacket paramAVPacket1, AVPacket paramAVPacket2);
/*      */ 
/*      */   public static native int av_copy_packet_side_data(AVPacket paramAVPacket1, AVPacket paramAVPacket2);
/*      */ 
/*      */   public static native void av_free_packet(AVPacket paramAVPacket);
/*      */ 
/*      */   @Cast({"uint8_t*"})
/*      */   public static native BytePointer av_packet_new_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_packet_shrink_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   @Cast({"uint8_t*"})
/*      */   public static native BytePointer av_packet_get_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt, IntPointer paramIntPointer);
/*      */ 
/*      */   @Cast({"uint8_t*"})
/*      */   public static native ByteBuffer av_packet_get_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt, IntBuffer paramIntBuffer);
/*      */ 
/*      */   @Cast({"uint8_t*"})
/*      */   public static native byte[] av_packet_get_side_data(AVPacket paramAVPacket, @Cast({"AVPacketSideDataType"}) int paramInt, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int av_packet_merge_side_data(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_packet_split_side_data(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native void av_packet_free_side_data(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int av_packet_ref(AVPacket paramAVPacket1, AVPacket paramAVPacket2);
/*      */ 
/*      */   public static native void av_packet_unref(AVPacket paramAVPacket);
/*      */ 
/*      */   public static native void av_packet_move_ref(AVPacket paramAVPacket1, AVPacket paramAVPacket2);
/*      */ 
/*      */   public static native int av_packet_copy_props(AVPacket paramAVPacket1, @Const AVPacket paramAVPacket2);
/*      */ 
/*      */   public static native AVCodec avcodec_find_decoder(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   public static native AVCodec avcodec_find_decoder_by_name(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVCodec avcodec_find_decoder_by_name(String paramString);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_default_get_buffer(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void avcodec_default_release_buffer(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_default_reget_buffer(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int avcodec_default_get_buffer2(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */   @Cast({"unsigned"})
/*      */   public static native int avcodec_get_edge_width();
/*      */ 
/*      */   public static native void avcodec_align_dimensions(AVCodecContext paramAVCodecContext, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native void avcodec_align_dimensions(AVCodecContext paramAVCodecContext, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native void avcodec_align_dimensions(AVCodecContext paramAVCodecContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   public static native void avcodec_align_dimensions2(AVCodecContext paramAVCodecContext, IntPointer paramIntPointer1, IntPointer paramIntPointer2, IntPointer paramIntPointer3);
/*      */ 
/*      */   public static native void avcodec_align_dimensions2(AVCodecContext paramAVCodecContext, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3);
/*      */ 
/*      */   public static native void avcodec_align_dimensions2(AVCodecContext paramAVCodecContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
/*      */ 
/*      */   public static native int avcodec_enum_to_chroma_pos(IntPointer paramIntPointer1, IntPointer paramIntPointer2, @Cast({"AVChromaLocation"}) int paramInt);
/*      */ 
/*      */   public static native int avcodec_enum_to_chroma_pos(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, @Cast({"AVChromaLocation"}) int paramInt);
/*      */ 
/*      */   public static native int avcodec_enum_to_chroma_pos(int[] paramArrayOfInt1, int[] paramArrayOfInt2, @Cast({"AVChromaLocation"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVChromaLocation"})
/*      */   public static native int avcodec_chroma_pos_to_enum(int paramInt1, int paramInt2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_decode_audio3(AVCodecContext paramAVCodecContext, ShortPointer paramShortPointer, IntPointer paramIntPointer, AVPacket paramAVPacket);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_decode_audio3(AVCodecContext paramAVCodecContext, ShortBuffer paramShortBuffer, IntBuffer paramIntBuffer, AVPacket paramAVPacket);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_decode_audio3(AVCodecContext paramAVCodecContext, short[] paramArrayOfShort, int[] paramArrayOfInt, AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_audio4(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, IntPointer paramIntPointer, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_audio4(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, IntBuffer paramIntBuffer, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_audio4(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, int[] paramArrayOfInt, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_video2(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, IntPointer paramIntPointer, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_video2(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, IntBuffer paramIntBuffer, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_video2(AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, int[] paramArrayOfInt, @Const AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_subtitle2(AVCodecContext paramAVCodecContext, AVSubtitle paramAVSubtitle, IntPointer paramIntPointer, AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_subtitle2(AVCodecContext paramAVCodecContext, AVSubtitle paramAVSubtitle, IntBuffer paramIntBuffer, AVPacket paramAVPacket);
/*      */ 
/*      */   public static native int avcodec_decode_subtitle2(AVCodecContext paramAVCodecContext, AVSubtitle paramAVSubtitle, int[] paramArrayOfInt, AVPacket paramAVPacket);
/*      */ 
/*      */   public static native AVCodecParser av_parser_next(AVCodecParser paramAVCodecParser);
/*      */ 
/*      */   public static native void av_register_codec_parser(AVCodecParser paramAVCodecParser);
/*      */ 
/*      */   public static native AVCodecParserContext av_parser_init(int paramInt);
/*      */ 
/*      */   public static native int av_parser_parse2(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native int av_parser_parse2(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native int av_parser_parse2(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   public static native int av_parser_parse2(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */ 
/*      */   /** @deprecated */
/*      */   public static native int av_parser_change(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_parser_change(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_parser_change(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_parser_change(AVCodecParserContext paramAVCodecParserContext, AVCodecContext paramAVCodecContext, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_parser_close(AVCodecParserContext paramAVCodecParserContext);
/*      */ 
/*      */   public static native AVCodec avcodec_find_encoder(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   public static native AVCodec avcodec_find_encoder_by_name(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVCodec avcodec_find_encoder_by_name(String paramString);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_audio(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @Const ShortPointer paramShortPointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_audio(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt, @Const ShortBuffer paramShortBuffer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_audio(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt, @Const short[] paramArrayOfShort);
/*      */ 
/*      */   public static native int avcodec_encode_audio2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int avcodec_encode_audio2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int avcodec_encode_audio2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, int[] paramArrayOfInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_video(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @Const avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_video(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt, @Const avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avcodec_encode_video(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt, @Const avutil.AVFrame paramAVFrame);
/*      */ 
/*      */   public static native int avcodec_encode_video2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int avcodec_encode_video2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int avcodec_encode_video2(AVCodecContext paramAVCodecContext, AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native int avcodec_encode_subtitle(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @Const AVSubtitle paramAVSubtitle);
/*      */ 
/*      */   public static native int avcodec_encode_subtitle(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt, @Const AVSubtitle paramAVSubtitle);
/*      */ 
/*      */   public static native int avcodec_encode_subtitle(AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) byte[] paramArrayOfByte, int paramInt, @Const AVSubtitle paramAVSubtitle);
/*      */ 
/*      */   @Deprecated
/*      */   public static native ReSampleContext av_audio_resample_init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Cast({"AVSampleFormat"}) int paramInt5, @Cast({"AVSampleFormat"}) int paramInt6, int paramInt7, int paramInt8, int paramInt9, double paramDouble);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int audio_resample(ReSampleContext paramReSampleContext, ShortPointer paramShortPointer1, ShortPointer paramShortPointer2, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int audio_resample(ReSampleContext paramReSampleContext, ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int audio_resample(ReSampleContext paramReSampleContext, short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void audio_resample_close(ReSampleContext paramReSampleContext);
/*      */ 
/*      */   @Deprecated
/*      */   public static native AVResampleContext av_resample_init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_resample(AVResampleContext paramAVResampleContext, ShortPointer paramShortPointer1, ShortPointer paramShortPointer2, IntPointer paramIntPointer, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_resample(AVResampleContext paramAVResampleContext, ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2, IntBuffer paramIntBuffer, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int av_resample(AVResampleContext paramAVResampleContext, short[] paramArrayOfShort1, short[] paramArrayOfShort2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_resample_compensate(AVResampleContext paramAVResampleContext, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_resample_close(AVResampleContext paramAVResampleContext);
/*      */ 
/*      */   public static native int avpicture_alloc(AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void avpicture_free(AVPicture paramAVPicture);
/*      */ 
/*      */   public static native int avpicture_fill(AVPicture paramAVPicture, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int avpicture_fill(AVPicture paramAVPicture, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int avpicture_fill(AVPicture paramAVPicture, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int avpicture_layout(@Const AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, @Cast({"unsigned char*"}) BytePointer paramBytePointer, int paramInt4);
/*      */ 
/*      */   public static native int avpicture_layout(@Const AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, @Cast({"unsigned char*"}) ByteBuffer paramByteBuffer, int paramInt4);
/*      */ 
/*      */   public static native int avpicture_layout(@Const AVPicture paramAVPicture, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3, @Cast({"unsigned char*"}) byte[] paramArrayOfByte, int paramInt4);
/*      */ 
/*      */   public static native int avpicture_get_size(@Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   @Deprecated
/*      */   public static native int avpicture_deinterlace(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native void av_picture_copy(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_picture_crop(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */   public static native int av_picture_pad(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, IntPointer paramIntPointer);
/*      */ 
/*      */   public static native int av_picture_pad(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, IntBuffer paramIntBuffer);
/*      */ 
/*      */   public static native int av_picture_pad(AVPicture paramAVPicture1, @Const AVPicture paramAVPicture2, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void avcodec_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, IntPointer paramIntPointer1, IntPointer paramIntPointer2);
/*      */ 
/*      */   public static native void avcodec_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   public static native void avcodec_get_chroma_sub_sample(@Cast({"AVPixelFormat"}) int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int avcodec_pix_fmt_to_codec_tag(@Cast({"AVPixelFormat"}) int paramInt);
/*      */ 
/*      */   public static native int avcodec_get_pix_fmt_loss(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, int paramInt3);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_list(@Cast({"const AVPixelFormat*"}) IntPointer paramIntPointer1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, IntPointer paramIntPointer2);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_list(@Cast({"const AVPixelFormat*"}) IntBuffer paramIntBuffer1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, IntBuffer paramIntBuffer2);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_list(@Cast({"const AVPixelFormat*"}) int[] paramArrayOfInt1, @Cast({"AVPixelFormat"}) int paramInt1, int paramInt2, int[] paramArrayOfInt2);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, IntPointer paramIntPointer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, IntBuffer paramIntBuffer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt_of_2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, IntPointer paramIntPointer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, IntBuffer paramIntBuffer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_find_best_pix_fmt2(@Cast({"AVPixelFormat"}) int paramInt1, @Cast({"AVPixelFormat"}) int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int[] paramArrayOfInt);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_default_get_format(AVCodecContext paramAVCodecContext, @Cast({"const AVPixelFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_default_get_format(AVCodecContext paramAVCodecContext, @Cast({"const AVPixelFormat*"}) IntBuffer paramIntBuffer);
/*      */ 
/*      */   @Cast({"AVPixelFormat"})
/*      */   public static native int avcodec_default_get_format(AVCodecContext paramAVCodecContext, @Cast({"const AVPixelFormat*"}) int[] paramArrayOfInt);
/*      */ 
/*      */   public static native void avcodec_set_dimensions(AVCodecContext paramAVCodecContext, int paramInt1, int paramInt2);
/*      */ 
/*      */   @Cast({"size_t"})
/*      */   public static native long av_get_codec_tag_string(@Cast({"char*"}) BytePointer paramBytePointer, @Cast({"size_t"}) long paramLong, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"size_t"})
/*      */   public static native long av_get_codec_tag_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, @Cast({"size_t"}) long paramLong, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"size_t"})
/*      */   public static native long av_get_codec_tag_string(@Cast({"char*"}) byte[] paramArrayOfByte, @Cast({"size_t"}) long paramLong, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   public static native void avcodec_string(@Cast({"char*"}) BytePointer paramBytePointer, int paramInt1, AVCodecContext paramAVCodecContext, int paramInt2);
/*      */ 
/*      */   public static native void avcodec_string(@Cast({"char*"}) ByteBuffer paramByteBuffer, int paramInt1, AVCodecContext paramAVCodecContext, int paramInt2);
/*      */ 
/*      */   public static native void avcodec_string(@Cast({"char*"}) byte[] paramArrayOfByte, int paramInt1, AVCodecContext paramAVCodecContext, int paramInt2);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer av_get_profile_name(@Const AVCodec paramAVCodec, int paramInt);
/*      */ 
/*      */   public static native int avcodec_default_execute(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer paramFunc_AVCodecContext_Pointer, Pointer paramPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avcodec_default_execute(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer paramFunc_AVCodecContext_Pointer, Pointer paramPointer, IntBuffer paramIntBuffer, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avcodec_default_execute(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer paramFunc_AVCodecContext_Pointer, Pointer paramPointer, int[] paramArrayOfInt, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int avcodec_default_execute2(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer_int_int paramFunc_AVCodecContext_Pointer_int_int, Pointer paramPointer, IntPointer paramIntPointer, int paramInt);
/*      */ 
/*      */   public static native int avcodec_default_execute2(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer_int_int paramFunc_AVCodecContext_Pointer_int_int, Pointer paramPointer, IntBuffer paramIntBuffer, int paramInt);
/*      */ 
/*      */   public static native int avcodec_default_execute2(AVCodecContext paramAVCodecContext, Func_AVCodecContext_Pointer_int_int paramFunc_AVCodecContext_Pointer_int_int, Pointer paramPointer, int[] paramArrayOfInt, int paramInt);
/*      */ 
/*      */   public static native int avcodec_fill_audio_frame(avutil.AVFrame paramAVFrame, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int avcodec_fill_audio_frame(avutil.AVFrame paramAVFrame, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native int avcodec_fill_audio_frame(avutil.AVFrame paramAVFrame, int paramInt1, @Cast({"AVSampleFormat"}) int paramInt2, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte, int paramInt3, int paramInt4);
/*      */ 
/*      */   public static native void avcodec_flush_buffers(AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native int av_get_bits_per_sample(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   @Cast({"AVCodecID"})
/*      */   public static native int av_get_pcm_codec(@Cast({"AVSampleFormat"}) int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_get_exact_bits_per_sample(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   public static native int av_get_audio_frame_duration(AVCodecContext paramAVCodecContext, int paramInt);
/*      */ 
/*      */   public static native void av_register_bitstream_filter(AVBitStreamFilter paramAVBitStreamFilter);
/*      */ 
/*      */   public static native AVBitStreamFilterContext av_bitstream_filter_init(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   public static native AVBitStreamFilterContext av_bitstream_filter_init(String paramString);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer2, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer3, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, String paramString, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, String paramString, @Cast({"uint8_t**"}) @ByPtrPtr BytePointer paramBytePointer1, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, @Cast({"const char*"}) BytePointer paramBytePointer, @Cast({"uint8_t**"}) @ByPtrPtr ByteBuffer paramByteBuffer1, IntBuffer paramIntBuffer, @Cast({"const uint8_t*"}) ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native int av_bitstream_filter_filter(AVBitStreamFilterContext paramAVBitStreamFilterContext, AVCodecContext paramAVCodecContext, String paramString, @Cast({"uint8_t**"}) @ByPtrPtr byte[] paramArrayOfByte1, int[] paramArrayOfInt, @Cast({"const uint8_t*"}) byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_bitstream_filter_close(AVBitStreamFilterContext paramAVBitStreamFilterContext);
/*      */ 
/*      */   public static native AVBitStreamFilter av_bitstream_filter_next(AVBitStreamFilter paramAVBitStreamFilter);
/*      */ 
/*      */   public static native Pointer av_fast_realloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_fast_realloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntBuffer paramIntBuffer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native Pointer av_fast_realloc(Pointer paramPointer, @Cast({"unsigned int*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntBuffer paramIntBuffer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) IntBuffer paramIntBuffer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_malloc(Pointer paramPointer, @Cast({"unsigned int*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_mallocz(Pointer paramPointer, @Cast({"unsigned int*"}) IntPointer paramIntPointer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_mallocz(Pointer paramPointer, @Cast({"unsigned int*"}) IntBuffer paramIntBuffer, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   public static native void av_fast_padded_mallocz(Pointer paramPointer, @Cast({"unsigned int*"}) int[] paramArrayOfInt, @Cast({"size_t"}) long paramLong);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int av_xiphlacing(@Cast({"unsigned char*"}) BytePointer paramBytePointer, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int av_xiphlacing(@Cast({"unsigned char*"}) ByteBuffer paramByteBuffer, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Cast({"unsigned int"})
/*      */   public static native int av_xiphlacing(@Cast({"unsigned char*"}) byte[] paramArrayOfByte, @Cast({"unsigned int"}) int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_log_missing_feature(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_log_missing_feature(Pointer paramPointer, String paramString, int paramInt);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_log_ask_for_sample(Pointer paramPointer, @Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Deprecated
/*      */   public static native void av_log_ask_for_sample(Pointer paramPointer, String paramString);
/*      */ 
/*      */   public static native void av_register_hwaccel(AVHWAccel paramAVHWAccel);
/*      */ 
/*      */   public static native AVHWAccel av_hwaccel_next(AVHWAccel paramAVHWAccel);
/*      */ 
/*      */   public static native int av_lockmgr_register(Cb_PointerPointer_int paramCb_PointerPointer_int);
/*      */ 
/*      */   public static native int av_lockmgr_register(Cb_Pointer_int paramCb_Pointer_int);
/*      */ 
/*      */   @Cast({"AVMediaType"})
/*      */   public static native int avcodec_get_type(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   @Cast({"const char*"})
/*      */   public static native BytePointer avcodec_get_name(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   public static native int avcodec_is_open(AVCodecContext paramAVCodecContext);
/*      */ 
/*      */   public static native int av_codec_is_encoder(@Const AVCodec paramAVCodec);
/*      */ 
/*      */   public static native int av_codec_is_decoder(@Const AVCodec paramAVCodec);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecDescriptor avcodec_descriptor_get(@Cast({"AVCodecID"}) int paramInt);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecDescriptor avcodec_descriptor_next(@Const AVCodecDescriptor paramAVCodecDescriptor);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecDescriptor avcodec_descriptor_get_by_name(@Cast({"const char*"}) BytePointer paramBytePointer);
/*      */ 
/*      */   @Const
/*      */   public static native AVCodecDescriptor avcodec_descriptor_get_by_name(String paramString);
/*      */ 
/*      */   public static native FFTContext av_fft_init(int paramInt1, int paramInt2);
/*      */ 
/*      */   public static native void av_fft_permute(FFTContext paramFFTContext, FFTComplex paramFFTComplex);
/*      */ 
/*      */   public static native void av_fft_calc(FFTContext paramFFTContext, FFTComplex paramFFTComplex);
/*      */ 
/*      */   public static native void av_fft_end(FFTContext paramFFTContext);
/*      */ 
/*      */   public static native FFTContext av_mdct_init(int paramInt1, int paramInt2, double paramDouble);
/*      */ 
/*      */   public static native void av_imdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatPointer paramFloatPointer1, @Cast({"const FFTSample*"}) FloatPointer paramFloatPointer2);
/*      */ 
/*      */   public static native void av_imdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatBuffer paramFloatBuffer1, @Cast({"const FFTSample*"}) FloatBuffer paramFloatBuffer2);
/*      */ 
/*      */   public static native void av_imdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) float[] paramArrayOfFloat1, @Cast({"const FFTSample*"}) float[] paramArrayOfFloat2);
/*      */ 
/*      */   public static native void av_imdct_half(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatPointer paramFloatPointer1, @Cast({"const FFTSample*"}) FloatPointer paramFloatPointer2);
/*      */ 
/*      */   public static native void av_imdct_half(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatBuffer paramFloatBuffer1, @Cast({"const FFTSample*"}) FloatBuffer paramFloatBuffer2);
/*      */ 
/*      */   public static native void av_imdct_half(FFTContext paramFFTContext, @Cast({"FFTSample*"}) float[] paramArrayOfFloat1, @Cast({"const FFTSample*"}) float[] paramArrayOfFloat2);
/*      */ 
/*      */   public static native void av_mdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatPointer paramFloatPointer1, @Cast({"const FFTSample*"}) FloatPointer paramFloatPointer2);
/*      */ 
/*      */   public static native void av_mdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) FloatBuffer paramFloatBuffer1, @Cast({"const FFTSample*"}) FloatBuffer paramFloatBuffer2);
/*      */ 
/*      */   public static native void av_mdct_calc(FFTContext paramFFTContext, @Cast({"FFTSample*"}) float[] paramArrayOfFloat1, @Cast({"const FFTSample*"}) float[] paramArrayOfFloat2);
/*      */ 
/*      */   public static native void av_mdct_end(FFTContext paramFFTContext);
/*      */ 
/*      */   public static native RDFTContext av_rdft_init(int paramInt1, @Cast({"RDFTransformType"}) int paramInt2);
/*      */ 
/*      */   public static native void av_rdft_calc(RDFTContext paramRDFTContext, @Cast({"FFTSample*"}) FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static native void av_rdft_calc(RDFTContext paramRDFTContext, @Cast({"FFTSample*"}) FloatBuffer paramFloatBuffer);
/*      */ 
/*      */   public static native void av_rdft_calc(RDFTContext paramRDFTContext, @Cast({"FFTSample*"}) float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native void av_rdft_end(RDFTContext paramRDFTContext);
/*      */ 
/*      */   public static native DCTContext av_dct_init(int paramInt1, @Cast({"DCTTransformType"}) int paramInt2);
/*      */ 
/*      */   public static native void av_dct_calc(DCTContext paramDCTContext, @Cast({"FFTSample*"}) FloatPointer paramFloatPointer);
/*      */ 
/*      */   public static native void av_dct_calc(DCTContext paramDCTContext, @Cast({"FFTSample*"}) FloatBuffer paramFloatBuffer);
/*      */ 
/*      */   public static native void av_dct_calc(DCTContext paramDCTContext, @Cast({"FFTSample*"}) float[] paramArrayOfFloat);
/*      */ 
/*      */   public static native void av_dct_end(DCTContext paramDCTContext);
/*      */ 
/*      */   static
/*      */   {
/*   39 */     Loader.load();
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class DCTContext extends Pointer
/*      */   {
/*      */     public DCTContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public DCTContext(Pointer p)
/*      */     {
/* 5952 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class RDFTContext extends Pointer
/*      */   {
/*      */     public RDFTContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public RDFTContext(Pointer p)
/*      */     {
/* 5934 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class FFTContext extends Pointer
/*      */   {
/*      */     public FFTContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public FFTContext(Pointer p)
/*      */     {
/* 5888 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class FFTComplex extends Pointer
/*      */   {
/*      */     public FFTComplex()
/*      */     {
/* 5873 */       allocate(); } 
/* 5874 */     public FFTComplex(int size) { allocateArray(size); } 
/* 5875 */     public FFTComplex(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 5879 */     public FFTComplex position(int position) { return (FFTComplex)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"FFTSample"})
/*      */     public native float re();
/*      */ 
/*      */     public native FFTComplex re(float paramFloat);
/*      */ 
/*      */     @Cast({"FFTSample"})
/*      */     public native float im();
/*      */ 
/*      */     public native FFTComplex im(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/* 5872 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cb_Pointer_int extends FunctionPointer
/*      */   {
/*      */     public Cb_Pointer_int(Pointer p)
/*      */     {
/* 5771 */       super(); } 
/* 5772 */     protected Cb_Pointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, @Cast({"AVLockOp"}) int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 5770 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Cb_PointerPointer_int extends FunctionPointer
/*      */   {
/*      */     public Cb_PointerPointer_int(Pointer p)
/*      */     {
/* 5763 */       super(); } 
/* 5764 */     protected Cb_PointerPointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(@Cast({"void**"}) PointerPointer paramPointerPointer, @Cast({"AVLockOp"}) int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 5762 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVBitStreamFilter extends Pointer
/*      */   {
/*      */     public AVBitStreamFilter()
/*      */     {
/* 5502 */       allocate(); } 
/* 5503 */     public AVBitStreamFilter(int size) { allocateArray(size); } 
/* 5504 */     public AVBitStreamFilter(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 5508 */     public AVBitStreamFilter position(int position) { return (AVBitStreamFilter)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVBitStreamFilter priv_data_size(int paramInt);
/*      */ 
/*      */     public native Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int filter();
/*      */ 
/*      */     public native AVBitStreamFilter filter(Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int paramFilter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int);
/*      */ 
/*      */     public native Close_AVBitStreamFilterContext close();
/*      */ 
/*      */     public native AVBitStreamFilter close(Close_AVBitStreamFilterContext paramClose_AVBitStreamFilterContext);
/*      */ 
/*      */     public native AVBitStreamFilter next();
/*      */ 
/*      */     public native AVBitStreamFilter next(AVBitStreamFilter paramAVBitStreamFilter);
/*      */ 
/*      */     static
/*      */     {
/* 5501 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Close_AVBitStreamFilterContext extends FunctionPointer
/*      */     {
/*      */       public Close_AVBitStreamFilterContext(Pointer p)
/*      */       {
/* 5526 */         super(); } 
/* 5527 */       protected Close_AVBitStreamFilterContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVBitStreamFilterContext paramAVBitStreamFilterContext);
/*      */ 
/*      */       static
/*      */       {
/* 5525 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int extends FunctionPointer
/*      */     {
/*      */       public Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int(Pointer p)
/*      */       {
/* 5515 */         super(); } 
/* 5516 */       protected Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVBitStreamFilterContext paramAVBitStreamFilterContext, avcodec.AVCodecContext paramAVCodecContext, @Cast({"const char*"}) BytePointer paramBytePointer1, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer2, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 5514 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVBitStreamFilterContext extends Pointer
/*      */   {
/*      */     public AVBitStreamFilterContext()
/*      */     {
/* 5484 */       allocate(); } 
/* 5485 */     public AVBitStreamFilterContext(int size) { allocateArray(size); } 
/* 5486 */     public AVBitStreamFilterContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 5490 */     public AVBitStreamFilterContext position(int position) { return (AVBitStreamFilterContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native Pointer priv_data();
/*      */ 
/*      */     public native AVBitStreamFilterContext priv_data(Pointer paramPointer);
/*      */ 
/*      */     public native avcodec.AVBitStreamFilter filter();
/*      */ 
/*      */     public native AVBitStreamFilterContext filter(avcodec.AVBitStreamFilter paramAVBitStreamFilter);
/*      */ 
/*      */     public native avcodec.AVCodecParserContext parser();
/*      */ 
/*      */     public native AVBitStreamFilterContext parser(avcodec.AVCodecParserContext paramAVCodecParserContext);
/*      */ 
/*      */     public native AVBitStreamFilterContext next();
/*      */ 
/*      */     public native AVBitStreamFilterContext next(AVBitStreamFilterContext paramAVBitStreamFilterContext);
/*      */ 
/*      */     static
/*      */     {
/* 5483 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Func_AVCodecContext_Pointer_int_int extends FunctionPointer
/*      */   {
/*      */     public Func_AVCodecContext_Pointer_int_int(Pointer p)
/*      */     {
/* 5390 */       super(); } 
/* 5391 */     protected Func_AVCodecContext_Pointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */     static
/*      */     {
/* 5389 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Func_AVCodecContext_Pointer extends FunctionPointer
/*      */   {
/*      */     public Func_AVCodecContext_Pointer(Pointer p)
/*      */     {
/* 5379 */       super(); } 
/* 5380 */     protected Func_AVCodecContext_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */     private native void allocate();
/*      */ 
/*      */     public native int call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer);
/*      */ 
/*      */     static
/*      */     {
/* 5378 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVResampleContext extends Pointer
/*      */   {
/*      */     public AVResampleContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVResampleContext(Pointer p)
/*      */     {
/* 4970 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   /** @deprecated */
/*      */   @Opaque
/*      */   public static class ReSampleContext extends Pointer
/*      */   {
/*      */     public ReSampleContext()
/*      */     {
/*      */     }
/*      */ 
/*      */     public ReSampleContext(Pointer p)
/*      */     {
/* 4966 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVCodecParser extends Pointer
/*      */   {
/*      */     public AVCodecParser()
/*      */     {
/* 4641 */       allocate(); } 
/* 4642 */     public AVCodecParser(int size) { allocateArray(size); } 
/* 4643 */     public AVCodecParser(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4647 */     public AVCodecParser position(int position) { return (AVCodecParser)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int codec_ids(int paramInt);
/*      */ 
/*      */     public native AVCodecParser codec_ids(int paramInt1, int paramInt2);
/*      */ 
/*      */     @MemberGetter
/*      */     public native IntPointer codec_ids();
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVCodecParser priv_data_size(int paramInt);
/*      */ 
/*      */     public native Parser_init_AVCodecParserContext parser_init();
/*      */ 
/*      */     public native AVCodecParser parser_init(Parser_init_AVCodecParserContext paramParser_init_AVCodecParserContext);
/*      */ 
/*      */     public native Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse();
/*      */ 
/*      */     public native AVCodecParser parser_parse(Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int paramParser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int);
/*      */ 
/*      */     public native Parser_close_AVCodecParserContext parser_close();
/*      */ 
/*      */     public native AVCodecParser parser_close(Parser_close_AVCodecParserContext paramParser_close_AVCodecParserContext);
/*      */ 
/*      */     public native Split_AVCodecContext_BytePointer_int split();
/*      */ 
/*      */     public native AVCodecParser split(Split_AVCodecContext_BytePointer_int paramSplit_AVCodecContext_BytePointer_int);
/*      */ 
/*      */     public native AVCodecParser next();
/*      */ 
/*      */     public native AVCodecParser next(AVCodecParser paramAVCodecParser);
/*      */ 
/*      */     static
/*      */     {
/* 4640 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Split_AVCodecContext_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Split_AVCodecContext_BytePointer_int(Pointer p)
/*      */       {
/* 4682 */         super(); } 
/* 4683 */       protected Split_AVCodecContext_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 4681 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Parser_close_AVCodecParserContext extends FunctionPointer
/*      */     {
/*      */       public Parser_close_AVCodecParserContext(Pointer p)
/*      */       {
/* 4674 */         super(); } 
/* 4675 */       protected Parser_close_AVCodecParserContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVCodecParserContext paramAVCodecParserContext);
/*      */ 
/*      */       static
/*      */       {
/* 4673 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int(Pointer p)
/*      */       {
/* 4663 */         super(); } 
/* 4664 */       protected Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecParserContext paramAVCodecParserContext, avcodec.AVCodecContext paramAVCodecContext, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer, IntPointer paramIntPointer, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 4662 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Parser_init_AVCodecParserContext extends FunctionPointer
/*      */     {
/*      */       public Parser_init_AVCodecParserContext(Pointer p)
/*      */       {
/* 4655 */         super(); } 
/* 4656 */       protected Parser_init_AVCodecParserContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecParserContext paramAVCodecParserContext);
/*      */ 
/*      */       static
/*      */       {
/* 4654 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVCodecParserContext extends Pointer
/*      */   {
/*      */     public static final int AV_PARSER_PTS_NB = 4;
/*      */     public static final int PARSER_FLAG_COMPLETE_FRAMES = 1;
/*      */     public static final int PARSER_FLAG_ONCE = 2;
/*      */     public static final int PARSER_FLAG_FETCHED_OFFSET = 4;
/*      */     public static final int PARSER_FLAG_USE_CODEC_TS = 4096;
/*      */ 
/*      */     public AVCodecParserContext()
/*      */     {
/* 4469 */       allocate(); } 
/* 4470 */     public AVCodecParserContext(int size) { allocateArray(size); } 
/* 4471 */     public AVCodecParserContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 4475 */     public AVCodecParserContext position(int position) { return (AVCodecParserContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native Pointer priv_data();
/*      */ 
/*      */     public native AVCodecParserContext priv_data(Pointer paramPointer);
/*      */ 
/*      */     public native avcodec.AVCodecParser parser();
/*      */ 
/*      */     public native AVCodecParserContext parser(avcodec.AVCodecParser paramAVCodecParser);
/*      */ 
/*      */     public native long frame_offset();
/*      */ 
/*      */     public native AVCodecParserContext frame_offset(long paramLong);
/*      */ 
/*      */     public native long cur_offset();
/*      */ 
/*      */     public native AVCodecParserContext cur_offset(long paramLong);
/*      */ 
/*      */     public native long next_frame_offset();
/*      */ 
/*      */     public native AVCodecParserContext next_frame_offset(long paramLong);
/*      */ 
/*      */     public native int pict_type();
/*      */ 
/*      */     public native AVCodecParserContext pict_type(int paramInt);
/*      */ 
/*      */     public native int repeat_pict();
/*      */ 
/*      */     public native AVCodecParserContext repeat_pict(int paramInt);
/*      */ 
/*      */     public native long pts();
/*      */ 
/*      */     public native AVCodecParserContext pts(long paramLong);
/*      */ 
/*      */     public native long dts();
/*      */ 
/*      */     public native AVCodecParserContext dts(long paramLong);
/*      */ 
/*      */     public native long last_pts();
/*      */ 
/*      */     public native AVCodecParserContext last_pts(long paramLong);
/*      */ 
/*      */     public native long last_dts();
/*      */ 
/*      */     public native AVCodecParserContext last_dts(long paramLong);
/*      */ 
/*      */     public native int fetch_timestamp();
/*      */ 
/*      */     public native AVCodecParserContext fetch_timestamp(int paramInt);
/*      */ 
/*      */     public native int cur_frame_start_index();
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_start_index(int paramInt);
/*      */ 
/*      */     public native long cur_frame_offset(int paramInt);
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_offset(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer cur_frame_offset();
/*      */ 
/*      */     public native long cur_frame_pts(int paramInt);
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_pts(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer cur_frame_pts();
/*      */ 
/*      */     public native long cur_frame_dts(int paramInt);
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_dts(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer cur_frame_dts();
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVCodecParserContext flags(int paramInt);
/*      */ 
/*      */     public native long offset();
/*      */ 
/*      */     public native AVCodecParserContext offset(long paramLong);
/*      */ 
/*      */     public native long cur_frame_end(int paramInt);
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_end(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer cur_frame_end();
/*      */ 
/*      */     public native int key_frame();
/*      */ 
/*      */     public native AVCodecParserContext key_frame(int paramInt);
/*      */ 
/*      */     public native long convergence_duration();
/*      */ 
/*      */     public native AVCodecParserContext convergence_duration(long paramLong);
/*      */ 
/*      */     public native int dts_sync_point();
/*      */ 
/*      */     public native AVCodecParserContext dts_sync_point(int paramInt);
/*      */ 
/*      */     public native int dts_ref_dts_delta();
/*      */ 
/*      */     public native AVCodecParserContext dts_ref_dts_delta(int paramInt);
/*      */ 
/*      */     public native int pts_dts_delta();
/*      */ 
/*      */     public native AVCodecParserContext pts_dts_delta(int paramInt);
/*      */ 
/*      */     public native long cur_frame_pos(int paramInt);
/*      */ 
/*      */     public native AVCodecParserContext cur_frame_pos(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     public native LongPointer cur_frame_pos();
/*      */ 
/*      */     public native long pos();
/*      */ 
/*      */     public native AVCodecParserContext pos(long paramLong);
/*      */ 
/*      */     public native long last_pos();
/*      */ 
/*      */     public native AVCodecParserContext last_pos(long paramLong);
/*      */ 
/*      */     public native int duration();
/*      */ 
/*      */     public native AVCodecParserContext duration(int paramInt);
/*      */ 
/*      */     @Cast({"AVFieldOrder"})
/*      */     public native int field_order();
/*      */ 
/*      */     public native AVCodecParserContext field_order(int paramInt);
/*      */ 
/*      */     @Cast({"AVPictureStructure"})
/*      */     public native int picture_structure();
/*      */ 
/*      */     public native AVCodecParserContext picture_structure(int paramInt);
/*      */ 
/*      */     public native int output_picture_number();
/*      */ 
/*      */     public native AVCodecParserContext output_picture_number(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 4468 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVSubtitle extends Pointer
/*      */   {
/*      */     public AVSubtitle()
/*      */     {
/* 3729 */       allocate(); } 
/* 3730 */     public AVSubtitle(int size) { allocateArray(size); } 
/* 3731 */     public AVSubtitle(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3735 */     public AVSubtitle position(int position) { return (AVSubtitle)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint16_t"})
/*      */     public native short format();
/*      */ 
/*      */     public native AVSubtitle format(short paramShort);
/*      */ 
/*      */     @Cast({"uint32_t"})
/*      */     public native int start_display_time();
/*      */ 
/*      */     public native AVSubtitle start_display_time(int paramInt);
/*      */ 
/*      */     @Cast({"uint32_t"})
/*      */     public native int end_display_time();
/*      */ 
/*      */     public native AVSubtitle end_display_time(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned"})
/*      */     public native int num_rects();
/*      */ 
/*      */     public native AVSubtitle num_rects(int paramInt);
/*      */ 
/*      */     public native avcodec.AVSubtitleRect rects(int paramInt);
/*      */ 
/*      */     public native AVSubtitle rects(int paramInt, avcodec.AVSubtitleRect paramAVSubtitleRect);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"AVSubtitleRect**"})
/*      */     public native PointerPointer rects();
/*      */ 
/*      */     public native long pts();
/*      */ 
/*      */     public native AVSubtitle pts(long paramLong);
/*      */ 
/*      */     static
/*      */     {
/* 3728 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVSubtitleRect extends Pointer
/*      */   {
/*      */     public AVSubtitleRect()
/*      */     {
/* 3687 */       allocate(); } 
/* 3688 */     public AVSubtitleRect(int size) { allocateArray(size); } 
/* 3689 */     public AVSubtitleRect(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3693 */     public AVSubtitleRect position(int position) { return (AVSubtitleRect)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int x();
/*      */ 
/*      */     public native AVSubtitleRect x(int paramInt);
/*      */ 
/*      */     public native int y();
/*      */ 
/*      */     public native AVSubtitleRect y(int paramInt);
/*      */ 
/*      */     public native int w();
/*      */ 
/*      */     public native AVSubtitleRect w(int paramInt);
/*      */ 
/*      */     public native int h();
/*      */ 
/*      */     public native AVSubtitleRect h(int paramInt);
/*      */ 
/*      */     public native int nb_colors();
/*      */ 
/*      */     public native AVSubtitleRect nb_colors(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avcodec.AVPicture pict();
/*      */ 
/*      */     public native AVSubtitleRect pict(avcodec.AVPicture paramAVPicture);
/*      */ 
/*      */     @Cast({"AVSubtitleType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVSubtitleRect type(int paramInt);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer text();
/*      */ 
/*      */     public native AVSubtitleRect text(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer ass();
/*      */ 
/*      */     public native AVSubtitleRect ass(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVSubtitleRect flags(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3686 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVPicture extends Pointer
/*      */   {
/*      */     public AVPicture()
/*      */     {
/* 3643 */       allocate(); } 
/* 3644 */     public AVPicture(int size) { allocateArray(size); } 
/* 3645 */     public AVPicture(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3649 */     public AVPicture position(int position) { return (AVPicture)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data(int paramInt);
/*      */ 
/*      */     public native AVPicture data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint8_t**"})
/*      */     public native PointerPointer data();
/*      */ 
/*      */     public native int linesize(int paramInt);
/*      */ 
/*      */     public native AVPicture linesize(int paramInt1, int paramInt2);
/*      */ 
/*      */     @MemberGetter
/*      */     public native IntPointer linesize();
/*      */ 
/*      */     static
/*      */     {
/* 3642 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVHWAccel extends Pointer
/*      */   {
/*      */     public AVHWAccel()
/*      */     {
/* 3512 */       allocate(); } 
/* 3513 */     public AVHWAccel(int size) { allocateArray(size); } 
/* 3514 */     public AVHWAccel(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3518 */     public AVHWAccel position(int position) { return (AVHWAccel)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVHWAccel type(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int id();
/*      */ 
/*      */     public native AVHWAccel id(int paramInt);
/*      */ 
/*      */     @Cast({"AVPixelFormat"})
/*      */     public native int pix_fmt();
/*      */ 
/*      */     public native AVHWAccel pix_fmt(int paramInt);
/*      */ 
/*      */     public native int capabilities();
/*      */ 
/*      */     public native AVHWAccel capabilities(int paramInt);
/*      */ 
/*      */     public native AVHWAccel next();
/*      */ 
/*      */     public native AVHWAccel next(AVHWAccel paramAVHWAccel);
/*      */ 
/*      */     public native Start_frame_AVCodecContext_BytePointer_int start_frame();
/*      */ 
/*      */     public native AVHWAccel start_frame(Start_frame_AVCodecContext_BytePointer_int paramStart_frame_AVCodecContext_BytePointer_int);
/*      */ 
/*      */     public native Decode_slice_AVCodecContext_BytePointer_int decode_slice();
/*      */ 
/*      */     public native AVHWAccel decode_slice(Decode_slice_AVCodecContext_BytePointer_int paramDecode_slice_AVCodecContext_BytePointer_int);
/*      */ 
/*      */     public native End_frame_AVCodecContext end_frame();
/*      */ 
/*      */     public native AVHWAccel end_frame(End_frame_AVCodecContext paramEnd_frame_AVCodecContext);
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVHWAccel priv_data_size(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 3511 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class End_frame_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public End_frame_AVCodecContext(Pointer p)
/*      */       {
/* 3611 */         super(); } 
/* 3612 */       protected End_frame_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */       static
/*      */       {
/* 3610 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Decode_slice_AVCodecContext_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Decode_slice_AVCodecContext_BytePointer_int(Pointer p)
/*      */       {
/* 3593 */         super(); } 
/* 3594 */       protected Decode_slice_AVCodecContext_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"uint32_t"}) int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 3592 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Start_frame_AVCodecContext_BytePointer_int extends FunctionPointer
/*      */     {
/*      */       public Start_frame_AVCodecContext_BytePointer_int(Pointer p)
/*      */       {
/* 3573 */         super(); } 
/* 3574 */       protected Start_frame_AVCodecContext_BytePointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, @Cast({"const uint8_t*"}) BytePointer paramBytePointer, @Cast({"uint32_t"}) int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 3572 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVCodec extends Pointer
/*      */   {
/*      */     public AVCodec()
/*      */     {
/* 3332 */       allocate(); } 
/* 3333 */     public AVCodec(int size) { allocateArray(size); } 
/* 3334 */     public AVCodec(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3338 */     public AVCodec position(int position) { return (AVCodec)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer long_name();
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVCodec type(int paramInt);
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int id();
/*      */ 
/*      */     public native AVCodec id(int paramInt);
/*      */ 
/*      */     public native int capabilities();
/*      */ 
/*      */     public native AVCodec capabilities(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVRational supported_framerates();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVPixelFormat*"})
/*      */     public native IntPointer pix_fmts();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native IntPointer supported_samplerates();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const AVSampleFormat*"})
/*      */     public native IntPointer sample_fmts();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const uint64_t*"})
/*      */     public native LongPointer channel_layouts();
/*      */ 
/*      */     @Cast({"uint8_t"})
/*      */     public native byte max_lowres();
/*      */ 
/*      */     public native AVCodec max_lowres(byte paramByte);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass priv_class();
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avcodec.AVProfile profiles();
/*      */ 
/*      */     public native int priv_data_size();
/*      */ 
/*      */     public native AVCodec priv_data_size(int paramInt);
/*      */ 
/*      */     public native AVCodec next();
/*      */ 
/*      */     public native AVCodec next(AVCodec paramAVCodec);
/*      */ 
/*      */     public native Init_thread_copy_AVCodecContext init_thread_copy();
/*      */ 
/*      */     public native AVCodec init_thread_copy(Init_thread_copy_AVCodecContext paramInit_thread_copy_AVCodecContext);
/*      */ 
/*      */     public native Update_thread_context_AVCodecContext_AVCodecContext update_thread_context();
/*      */ 
/*      */     public native AVCodec update_thread_context(Update_thread_context_AVCodecContext_AVCodecContext paramUpdate_thread_context_AVCodecContext_AVCodecContext);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avcodec.AVCodecDefault defaults();
/*      */ 
/*      */     public native Init_static_data_AVCodec init_static_data();
/*      */ 
/*      */     public native AVCodec init_static_data(Init_static_data_AVCodec paramInit_static_data_AVCodec);
/*      */ 
/*      */     public native Init_AVCodecContext init();
/*      */ 
/*      */     public native AVCodec init(Init_AVCodecContext paramInit_AVCodecContext);
/*      */ 
/*      */     public native Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle encode_sub();
/*      */ 
/*      */     public native AVCodec encode_sub(Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle paramEncode_sub_AVCodecContext_BytePointer_int_AVSubtitle);
/*      */ 
/*      */     public native Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer encode2();
/*      */ 
/*      */     public native AVCodec encode2(Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer paramEncode2_AVCodecContext_AVPacket_AVFrame_IntPointer);
/*      */ 
/*      */     public native Decode_AVCodecContext_Pointer_IntPointer_AVPacket decode();
/*      */ 
/*      */     public native AVCodec decode(Decode_AVCodecContext_Pointer_IntPointer_AVPacket paramDecode_AVCodecContext_Pointer_IntPointer_AVPacket);
/*      */ 
/*      */     public native Close_AVCodecContext close();
/*      */ 
/*      */     public native AVCodec close(Close_AVCodecContext paramClose_AVCodecContext);
/*      */ 
/*      */     public native Flush_AVCodecContext flush();
/*      */ 
/*      */     public native AVCodec flush(Flush_AVCodecContext paramFlush_AVCodecContext);
/*      */ 
/*      */     static
/*      */     {
/* 3331 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Flush_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public Flush_AVCodecContext(Pointer p)
/*      */       {
/* 3497 */         super(); } 
/* 3498 */       protected Flush_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */       static
/*      */       {
/* 3496 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Close_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public Close_AVCodecContext(Pointer p)
/*      */       {
/* 3485 */         super(); } 
/* 3486 */       protected Close_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */       static
/*      */       {
/* 3484 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Decode_AVCodecContext_Pointer_IntPointer_AVPacket extends FunctionPointer
/*      */     {
/*      */       public Decode_AVCodecContext_Pointer_IntPointer_AVPacket(Pointer p)
/*      */       {
/* 3477 */         super(); } 
/* 3478 */       protected Decode_AVCodecContext_Pointer_IntPointer_AVPacket() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer, IntPointer paramIntPointer, avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */       static
/*      */       {
/* 3476 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer extends FunctionPointer
/*      */     {
/*      */       public Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer(Pointer p)
/*      */       {
/* 3468 */         super(); } 
/* 3469 */       protected Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avcodec.AVPacket paramAVPacket, @Const avutil.AVFrame paramAVFrame, IntPointer paramIntPointer);
/*      */ 
/*      */       static
/*      */       {
/* 3467 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle extends FunctionPointer
/*      */     {
/*      */       public Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle(Pointer p)
/*      */       {
/* 3449 */         super(); } 
/* 3450 */       protected Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, @Cast({"uint8_t*"}) BytePointer paramBytePointer, int paramInt, @Const avcodec.AVSubtitle paramAVSubtitle);
/*      */ 
/*      */       static
/*      */       {
/* 3448 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Init_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public Init_AVCodecContext(Pointer p)
/*      */       {
/* 3441 */         super(); } 
/* 3442 */       protected Init_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */       static
/*      */       {
/* 3440 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Init_static_data_AVCodec extends FunctionPointer
/*      */     {
/*      */       public Init_static_data_AVCodec(Pointer p)
/*      */       {
/* 3432 */         super(); } 
/* 3433 */       protected Init_static_data_AVCodec() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVCodec paramAVCodec);
/*      */ 
/*      */       static
/*      */       {
/* 3431 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Update_thread_context_AVCodecContext_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public Update_thread_context_AVCodecContext_AVCodecContext(Pointer p)
/*      */       {
/* 3414 */         super(); } 
/* 3415 */       protected Update_thread_context_AVCodecContext_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext1, @Const avcodec.AVCodecContext paramAVCodecContext2);
/*      */ 
/*      */       static
/*      */       {
/* 3413 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Init_thread_copy_AVCodecContext extends FunctionPointer
/*      */     {
/*      */       public Init_thread_copy_AVCodecContext(Pointer p)
/*      */       {
/* 3399 */         super(); } 
/* 3400 */       protected Init_thread_copy_AVCodecContext() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext);
/*      */ 
/*      */       static
/*      */       {
/* 3398 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVCodecDefault extends Pointer
/*      */   {
/*      */     public AVCodecDefault()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVCodecDefault(Pointer p)
/*      */     {
/* 3324 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVProfile extends Pointer
/*      */   {
/*      */     public AVProfile()
/*      */     {
/* 3308 */       allocate(); } 
/* 3309 */     public AVProfile(int size) { allocateArray(size); } 
/* 3310 */     public AVProfile(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 3314 */     public AVProfile position(int position) { return (AVProfile)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int profile();
/*      */ 
/*      */     public native AVProfile profile(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     static
/*      */     {
/* 3307 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVCodecContext extends Pointer
/*      */   {
/*      */     public static final int FF_COMPRESSION_DEFAULT = -1;
/*      */     public static final int FF_ASPECT_EXTENDED = 15;
/*      */     public static final int FF_RC_STRATEGY_XVID = 1;
/*      */     public static final int FF_PRED_LEFT = 0;
/*      */     public static final int FF_PRED_PLANE = 1;
/*      */     public static final int FF_PRED_MEDIAN = 2;
/*      */     public static final int FF_CMP_SAD = 0;
/*      */     public static final int FF_CMP_SSE = 1;
/*      */     public static final int FF_CMP_SATD = 2;
/*      */     public static final int FF_CMP_DCT = 3;
/*      */     public static final int FF_CMP_PSNR = 4;
/*      */     public static final int FF_CMP_BIT = 5;
/*      */     public static final int FF_CMP_RD = 6;
/*      */     public static final int FF_CMP_ZERO = 7;
/*      */     public static final int FF_CMP_VSAD = 8;
/*      */     public static final int FF_CMP_VSSE = 9;
/*      */     public static final int FF_CMP_NSSE = 10;
/*      */     public static final int FF_CMP_W53 = 11;
/*      */     public static final int FF_CMP_W97 = 12;
/*      */     public static final int FF_CMP_DCTMAX = 13;
/*      */     public static final int FF_CMP_DCT264 = 14;
/*      */     public static final int FF_CMP_CHROMA = 256;
/*      */     public static final int FF_DTG_AFD_SAME = 8;
/*      */     public static final int FF_DTG_AFD_4_3 = 9;
/*      */     public static final int FF_DTG_AFD_16_9 = 10;
/*      */     public static final int FF_DTG_AFD_14_9 = 11;
/*      */     public static final int FF_DTG_AFD_4_3_SP_14_9 = 13;
/*      */     public static final int FF_DTG_AFD_16_9_SP_14_9 = 14;
/*      */     public static final int FF_DTG_AFD_SP_4_3 = 15;
/*      */     public static final int FF_DEFAULT_QUANT_BIAS = 999999;
/*      */     public static final int SLICE_FLAG_CODED_ORDER = 1;
/*      */     public static final int SLICE_FLAG_ALLOW_FIELD = 2;
/*      */     public static final int SLICE_FLAG_ALLOW_PLANE = 4;
/*      */     public static final int FF_MB_DECISION_SIMPLE = 0;
/*      */     public static final int FF_MB_DECISION_BITS = 1;
/*      */     public static final int FF_MB_DECISION_RD = 2;
/*      */     public static final int FF_CODER_TYPE_VLC = 0;
/*      */     public static final int FF_CODER_TYPE_AC = 1;
/*      */     public static final int FF_CODER_TYPE_RAW = 2;
/*      */     public static final int FF_CODER_TYPE_RLE = 3;
/*      */     public static final int FF_CODER_TYPE_DEFLATE = 4;
/*      */     public static final int FF_BUG_AUTODETECT = 1;
/*      */     public static final int FF_BUG_OLD_MSMPEG4 = 2;
/*      */     public static final int FF_BUG_XVID_ILACE = 4;
/*      */     public static final int FF_BUG_UMP4 = 8;
/*      */     public static final int FF_BUG_NO_PADDING = 16;
/*      */     public static final int FF_BUG_AMV = 32;
/*      */     public static final int FF_BUG_AC_VLC = 0;
/*      */     public static final int FF_BUG_QPEL_CHROMA = 64;
/*      */     public static final int FF_BUG_STD_QPEL = 128;
/*      */     public static final int FF_BUG_QPEL_CHROMA2 = 256;
/*      */     public static final int FF_BUG_DIRECT_BLOCKSIZE = 512;
/*      */     public static final int FF_BUG_EDGE = 1024;
/*      */     public static final int FF_BUG_HPEL_CHROMA = 2048;
/*      */     public static final int FF_BUG_DC_CLIP = 4096;
/*      */     public static final int FF_BUG_MS = 8192;
/*      */     public static final int FF_BUG_TRUNCATED = 16384;
/*      */     public static final int FF_COMPLIANCE_VERY_STRICT = 2;
/*      */     public static final int FF_COMPLIANCE_STRICT = 1;
/*      */     public static final int FF_COMPLIANCE_NORMAL = 0;
/*      */     public static final int FF_COMPLIANCE_UNOFFICIAL = -1;
/*      */     public static final int FF_COMPLIANCE_EXPERIMENTAL = -2;
/*      */     public static final int FF_EC_GUESS_MVS = 1;
/*      */     public static final int FF_EC_DEBLOCK = 2;
/*      */     public static final int FF_DEBUG_PICT_INFO = 1;
/*      */     public static final int FF_DEBUG_RC = 2;
/*      */     public static final int FF_DEBUG_BITSTREAM = 4;
/*      */     public static final int FF_DEBUG_MB_TYPE = 8;
/*      */     public static final int FF_DEBUG_QP = 16;
/*      */     public static final int FF_DEBUG_MV = 32;
/*      */     public static final int FF_DEBUG_DCT_COEFF = 64;
/*      */     public static final int FF_DEBUG_SKIP = 128;
/*      */     public static final int FF_DEBUG_STARTCODE = 256;
/*      */     public static final int FF_DEBUG_PTS = 512;
/*      */     public static final int FF_DEBUG_ER = 1024;
/*      */     public static final int FF_DEBUG_MMCO = 2048;
/*      */     public static final int FF_DEBUG_BUGS = 4096;
/*      */     public static final int FF_DEBUG_VIS_QP = 8192;
/*      */     public static final int FF_DEBUG_VIS_MB_TYPE = 16384;
/*      */     public static final int FF_DEBUG_BUFFERS = 32768;
/*      */     public static final int FF_DEBUG_THREADS = 65536;
/*      */     public static final int FF_DEBUG_VIS_MV_P_FOR = 1;
/*      */     public static final int FF_DEBUG_VIS_MV_B_FOR = 2;
/*      */     public static final int FF_DEBUG_VIS_MV_B_BACK = 4;
/*      */     public static final int AV_EF_CRCCHECK = 1;
/*      */     public static final int AV_EF_BITSTREAM = 2;
/*      */     public static final int AV_EF_BUFFER = 4;
/*      */     public static final int AV_EF_EXPLODE = 8;
/*      */     public static final int AV_EF_CAREFUL = 65536;
/*      */     public static final int AV_EF_COMPLIANT = 131072;
/*      */     public static final int AV_EF_AGGRESSIVE = 262144;
/*      */     public static final int FF_DCT_AUTO = 0;
/*      */     public static final int FF_DCT_FASTINT = 1;
/*      */     public static final int FF_DCT_INT = 2;
/*      */     public static final int FF_DCT_MMX = 3;
/*      */     public static final int FF_DCT_ALTIVEC = 5;
/*      */     public static final int FF_DCT_FAAN = 6;
/*      */     public static final int FF_IDCT_AUTO = 0;
/*      */     public static final int FF_IDCT_INT = 1;
/*      */     public static final int FF_IDCT_SIMPLE = 2;
/*      */     public static final int FF_IDCT_SIMPLEMMX = 3;
/*      */     public static final int FF_IDCT_ARM = 7;
/*      */     public static final int FF_IDCT_ALTIVEC = 8;
/*      */     public static final int FF_IDCT_SH4 = 9;
/*      */     public static final int FF_IDCT_SIMPLEARM = 10;
/*      */     public static final int FF_IDCT_IPP = 13;
/*      */     public static final int FF_IDCT_XVIDMMX = 14;
/*      */     public static final int FF_IDCT_SIMPLEARMV5TE = 16;
/*      */     public static final int FF_IDCT_SIMPLEARMV6 = 17;
/*      */     public static final int FF_IDCT_SIMPLEVIS = 18;
/*      */     public static final int FF_IDCT_FAAN = 20;
/*      */     public static final int FF_IDCT_SIMPLENEON = 22;
/*      */     public static final int FF_IDCT_SIMPLEALPHA = 23;
/*      */     public static final int FF_THREAD_FRAME = 1;
/*      */     public static final int FF_THREAD_SLICE = 2;
/*      */     public static final int FF_PROFILE_UNKNOWN = -99;
/*      */     public static final int FF_PROFILE_RESERVED = -100;
/*      */     public static final int FF_PROFILE_AAC_MAIN = 0;
/*      */     public static final int FF_PROFILE_AAC_LOW = 1;
/*      */     public static final int FF_PROFILE_AAC_SSR = 2;
/*      */     public static final int FF_PROFILE_AAC_LTP = 3;
/*      */     public static final int FF_PROFILE_AAC_HE = 4;
/*      */     public static final int FF_PROFILE_AAC_HE_V2 = 28;
/*      */     public static final int FF_PROFILE_AAC_LD = 22;
/*      */     public static final int FF_PROFILE_AAC_ELD = 38;
/*      */     public static final int FF_PROFILE_MPEG2_AAC_LOW = 128;
/*      */     public static final int FF_PROFILE_MPEG2_AAC_HE = 131;
/*      */     public static final int FF_PROFILE_DTS = 20;
/*      */     public static final int FF_PROFILE_DTS_ES = 30;
/*      */     public static final int FF_PROFILE_DTS_96_24 = 40;
/*      */     public static final int FF_PROFILE_DTS_HD_HRA = 50;
/*      */     public static final int FF_PROFILE_DTS_HD_MA = 60;
/*      */     public static final int FF_PROFILE_MPEG2_422 = 0;
/*      */     public static final int FF_PROFILE_MPEG2_HIGH = 1;
/*      */     public static final int FF_PROFILE_MPEG2_SS = 2;
/*      */     public static final int FF_PROFILE_MPEG2_SNR_SCALABLE = 3;
/*      */     public static final int FF_PROFILE_MPEG2_MAIN = 4;
/*      */     public static final int FF_PROFILE_MPEG2_SIMPLE = 5;
/*      */     public static final int FF_PROFILE_H264_CONSTRAINED = 512;
/*      */     public static final int FF_PROFILE_H264_INTRA = 2048;
/*      */     public static final int FF_PROFILE_H264_BASELINE = 66;
/*      */     public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
/*      */     public static final int FF_PROFILE_H264_MAIN = 77;
/*      */     public static final int FF_PROFILE_H264_EXTENDED = 88;
/*      */     public static final int FF_PROFILE_H264_HIGH = 100;
/*      */     public static final int FF_PROFILE_H264_HIGH_10 = 110;
/*      */     public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
/*      */     public static final int FF_PROFILE_H264_HIGH_422 = 122;
/*      */     public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
/*      */     public static final int FF_PROFILE_H264_HIGH_444 = 144;
/*      */     public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
/*      */     public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
/*      */     public static final int FF_PROFILE_H264_CAVLC_444 = 44;
/*      */     public static final int FF_PROFILE_VC1_SIMPLE = 0;
/*      */     public static final int FF_PROFILE_VC1_MAIN = 1;
/*      */     public static final int FF_PROFILE_VC1_COMPLEX = 2;
/*      */     public static final int FF_PROFILE_VC1_ADVANCED = 3;
/*      */     public static final int FF_PROFILE_MPEG4_SIMPLE = 0;
/*      */     public static final int FF_PROFILE_MPEG4_SIMPLE_SCALABLE = 1;
/*      */     public static final int FF_PROFILE_MPEG4_CORE = 2;
/*      */     public static final int FF_PROFILE_MPEG4_MAIN = 3;
/*      */     public static final int FF_PROFILE_MPEG4_N_BIT = 4;
/*      */     public static final int FF_PROFILE_MPEG4_SCALABLE_TEXTURE = 5;
/*      */     public static final int FF_PROFILE_MPEG4_SIMPLE_FACE_ANIMATION = 6;
/*      */     public static final int FF_PROFILE_MPEG4_BASIC_ANIMATED_TEXTURE = 7;
/*      */     public static final int FF_PROFILE_MPEG4_HYBRID = 8;
/*      */     public static final int FF_PROFILE_MPEG4_ADVANCED_REAL_TIME = 9;
/*      */     public static final int FF_PROFILE_MPEG4_CORE_SCALABLE = 10;
/*      */     public static final int FF_PROFILE_MPEG4_ADVANCED_CODING = 11;
/*      */     public static final int FF_PROFILE_MPEG4_ADVANCED_CORE = 12;
/*      */     public static final int FF_PROFILE_MPEG4_ADVANCED_SCALABLE_TEXTURE = 13;
/*      */     public static final int FF_PROFILE_MPEG4_SIMPLE_STUDIO = 14;
/*      */     public static final int FF_PROFILE_MPEG4_ADVANCED_SIMPLE = 15;
/*      */     public static final int FF_PROFILE_JPEG2000_CSTREAM_RESTRICTION_0 = 0;
/*      */     public static final int FF_PROFILE_JPEG2000_CSTREAM_RESTRICTION_1 = 1;
/*      */     public static final int FF_PROFILE_JPEG2000_CSTREAM_NO_RESTRICTION = 2;
/*      */     public static final int FF_PROFILE_JPEG2000_DCINEMA_2K = 3;
/*      */     public static final int FF_PROFILE_JPEG2000_DCINEMA_4K = 4;
/*      */     public static final int FF_LEVEL_UNKNOWN = -99;
/*      */     public static final int FF_SUB_CHARENC_MODE_DO_NOTHING = -1;
/*      */     public static final int FF_SUB_CHARENC_MODE_AUTOMATIC = 0;
/*      */     public static final int FF_SUB_CHARENC_MODE_PRE_DECODER = 1;
/*      */ 
/*      */     public AVCodecContext()
/*      */     {
/* 1432 */       allocate(); } 
/* 1433 */     public AVCodecContext(int size) { allocateArray(size); } 
/* 1434 */     public AVCodecContext(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1438 */     public AVCodecContext position(int position) { return (AVCodecContext)super.position(position); }
/*      */ 
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avutil.AVClass av_class();
/*      */ 
/*      */     public native int log_level_offset();
/*      */ 
/*      */     public native AVCodecContext log_level_offset(int paramInt);
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int codec_type();
/*      */ 
/*      */     public native AVCodecContext codec_type(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avcodec.AVCodec codec();
/*      */ 
/*      */     @Cast({"char"})
/*      */     public native byte codec_name(int paramInt);
/*      */ 
/*      */     public native AVCodecContext codec_name(int paramInt, byte paramByte);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"char*"})
/*      */     public native BytePointer codec_name();
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int codec_id();
/*      */ 
/*      */     public native AVCodecContext codec_id(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int codec_tag();
/*      */ 
/*      */     public native AVCodecContext codec_tag(int paramInt);
/*      */ 
/*      */     @Cast({"unsigned int"})
/*      */     public native int stream_codec_tag();
/*      */ 
/*      */     public native AVCodecContext stream_codec_tag(int paramInt);
/*      */ 
/*      */     public native Pointer priv_data();
/*      */ 
/*      */     public native AVCodecContext priv_data(Pointer paramPointer);
/*      */ 
/*      */     public native avcodec.AVCodecInternal internal();
/*      */ 
/*      */     public native AVCodecContext internal(avcodec.AVCodecInternal paramAVCodecInternal);
/*      */ 
/*      */     public native Pointer opaque();
/*      */ 
/*      */     public native AVCodecContext opaque(Pointer paramPointer);
/*      */ 
/*      */     public native int bit_rate();
/*      */ 
/*      */     public native AVCodecContext bit_rate(int paramInt);
/*      */ 
/*      */     public native int bit_rate_tolerance();
/*      */ 
/*      */     public native AVCodecContext bit_rate_tolerance(int paramInt);
/*      */ 
/*      */     public native int global_quality();
/*      */ 
/*      */     public native AVCodecContext global_quality(int paramInt);
/*      */ 
/*      */     public native int compression_level();
/*      */ 
/*      */     public native AVCodecContext compression_level(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVCodecContext flags(int paramInt);
/*      */ 
/*      */     public native int flags2();
/*      */ 
/*      */     public native AVCodecContext flags2(int paramInt);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer extradata();
/*      */ 
/*      */     public native AVCodecContext extradata(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int extradata_size();
/*      */ 
/*      */     public native AVCodecContext extradata_size(int paramInt);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational time_base();
/*      */ 
/*      */     public native AVCodecContext time_base(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native int ticks_per_frame();
/*      */ 
/*      */     public native AVCodecContext ticks_per_frame(int paramInt);
/*      */ 
/*      */     public native int delay();
/*      */ 
/*      */     public native AVCodecContext delay(int paramInt);
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native AVCodecContext width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native AVCodecContext height(int paramInt);
/*      */ 
/*      */     public native int coded_width();
/*      */ 
/*      */     public native AVCodecContext coded_width(int paramInt);
/*      */ 
/*      */     public native int coded_height();
/*      */ 
/*      */     public native AVCodecContext coded_height(int paramInt);
/*      */ 
/*      */     public native int gop_size();
/*      */ 
/*      */     public native AVCodecContext gop_size(int paramInt);
/*      */ 
/*      */     @Cast({"AVPixelFormat"})
/*      */     public native int pix_fmt();
/*      */ 
/*      */     public native AVCodecContext pix_fmt(int paramInt);
/*      */ 
/*      */     public native int me_method();
/*      */ 
/*      */     public native AVCodecContext me_method(int paramInt);
/*      */ 
/*      */     public native Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int draw_horiz_band();
/*      */ 
/*      */     public native AVCodecContext draw_horiz_band(Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int paramDraw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int);
/*      */ 
/*      */     public native Get_format_AVCodecContext_IntPointer get_format();
/*      */ 
/*      */     public native AVCodecContext get_format(Get_format_AVCodecContext_IntPointer paramGet_format_AVCodecContext_IntPointer);
/*      */ 
/*      */     public native int max_b_frames();
/*      */ 
/*      */     public native AVCodecContext max_b_frames(int paramInt);
/*      */ 
/*      */     public native float b_quant_factor();
/*      */ 
/*      */     public native AVCodecContext b_quant_factor(float paramFloat);
/*      */ 
/*      */     public native int rc_strategy();
/*      */ 
/*      */     public native AVCodecContext rc_strategy(int paramInt);
/*      */ 
/*      */     public native int b_frame_strategy();
/*      */ 
/*      */     public native AVCodecContext b_frame_strategy(int paramInt);
/*      */ 
/*      */     public native float b_quant_offset();
/*      */ 
/*      */     public native AVCodecContext b_quant_offset(float paramFloat);
/*      */ 
/*      */     public native int has_b_frames();
/*      */ 
/*      */     public native AVCodecContext has_b_frames(int paramInt);
/*      */ 
/*      */     public native int mpeg_quant();
/*      */ 
/*      */     public native AVCodecContext mpeg_quant(int paramInt);
/*      */ 
/*      */     public native float i_quant_factor();
/*      */ 
/*      */     public native AVCodecContext i_quant_factor(float paramFloat);
/*      */ 
/*      */     public native float i_quant_offset();
/*      */ 
/*      */     public native AVCodecContext i_quant_offset(float paramFloat);
/*      */ 
/*      */     public native float lumi_masking();
/*      */ 
/*      */     public native AVCodecContext lumi_masking(float paramFloat);
/*      */ 
/*      */     public native float temporal_cplx_masking();
/*      */ 
/*      */     public native AVCodecContext temporal_cplx_masking(float paramFloat);
/*      */ 
/*      */     public native float spatial_cplx_masking();
/*      */ 
/*      */     public native AVCodecContext spatial_cplx_masking(float paramFloat);
/*      */ 
/*      */     public native float p_masking();
/*      */ 
/*      */     public native AVCodecContext p_masking(float paramFloat);
/*      */ 
/*      */     public native float dark_masking();
/*      */ 
/*      */     public native AVCodecContext dark_masking(float paramFloat);
/*      */ 
/*      */     public native int slice_count();
/*      */ 
/*      */     public native AVCodecContext slice_count(int paramInt);
/*      */ 
/*      */     public native int prediction_method();
/*      */ 
/*      */     public native AVCodecContext prediction_method(int paramInt);
/*      */ 
/*      */     public native IntPointer slice_offset();
/*      */ 
/*      */     public native AVCodecContext slice_offset(IntPointer paramIntPointer);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational sample_aspect_ratio();
/*      */ 
/*      */     public native AVCodecContext sample_aspect_ratio(avutil.AVRational paramAVRational);
/*      */ 
/*      */     public native int me_cmp();
/*      */ 
/*      */     public native AVCodecContext me_cmp(int paramInt);
/*      */ 
/*      */     public native int me_sub_cmp();
/*      */ 
/*      */     public native AVCodecContext me_sub_cmp(int paramInt);
/*      */ 
/*      */     public native int mb_cmp();
/*      */ 
/*      */     public native AVCodecContext mb_cmp(int paramInt);
/*      */ 
/*      */     public native int ildct_cmp();
/*      */ 
/*      */     public native AVCodecContext ildct_cmp(int paramInt);
/*      */ 
/*      */     public native int dia_size();
/*      */ 
/*      */     public native AVCodecContext dia_size(int paramInt);
/*      */ 
/*      */     public native int last_predictor_count();
/*      */ 
/*      */     public native AVCodecContext last_predictor_count(int paramInt);
/*      */ 
/*      */     public native int pre_me();
/*      */ 
/*      */     public native AVCodecContext pre_me(int paramInt);
/*      */ 
/*      */     public native int me_pre_cmp();
/*      */ 
/*      */     public native AVCodecContext me_pre_cmp(int paramInt);
/*      */ 
/*      */     public native int pre_dia_size();
/*      */ 
/*      */     public native AVCodecContext pre_dia_size(int paramInt);
/*      */ 
/*      */     public native int me_subpel_quality();
/*      */ 
/*      */     public native AVCodecContext me_subpel_quality(int paramInt);
/*      */ 
/*      */     public native int dtg_active_format();
/*      */ 
/*      */     public native AVCodecContext dtg_active_format(int paramInt);
/*      */ 
/*      */     public native int me_range();
/*      */ 
/*      */     public native AVCodecContext me_range(int paramInt);
/*      */ 
/*      */     public native int intra_quant_bias();
/*      */ 
/*      */     public native AVCodecContext intra_quant_bias(int paramInt);
/*      */ 
/*      */     public native int inter_quant_bias();
/*      */ 
/*      */     public native AVCodecContext inter_quant_bias(int paramInt);
/*      */ 
/*      */     public native int slice_flags();
/*      */ 
/*      */     public native AVCodecContext slice_flags(int paramInt);
/*      */ 
/*      */     public native int xvmc_acceleration();
/*      */ 
/*      */     public native AVCodecContext xvmc_acceleration(int paramInt);
/*      */ 
/*      */     public native int mb_decision();
/*      */ 
/*      */     public native AVCodecContext mb_decision(int paramInt);
/*      */ 
/*      */     @Cast({"uint16_t*"})
/*      */     public native ShortPointer intra_matrix();
/*      */ 
/*      */     public native AVCodecContext intra_matrix(ShortPointer paramShortPointer);
/*      */ 
/*      */     @Cast({"uint16_t*"})
/*      */     public native ShortPointer inter_matrix();
/*      */ 
/*      */     public native AVCodecContext inter_matrix(ShortPointer paramShortPointer);
/*      */ 
/*      */     public native int scenechange_threshold();
/*      */ 
/*      */     public native AVCodecContext scenechange_threshold(int paramInt);
/*      */ 
/*      */     public native int noise_reduction();
/*      */ 
/*      */     public native AVCodecContext noise_reduction(int paramInt);
/*      */ 
/*      */     public native int me_threshold();
/*      */ 
/*      */     public native AVCodecContext me_threshold(int paramInt);
/*      */ 
/*      */     public native int mb_threshold();
/*      */ 
/*      */     public native AVCodecContext mb_threshold(int paramInt);
/*      */ 
/*      */     public native int intra_dc_precision();
/*      */ 
/*      */     public native AVCodecContext intra_dc_precision(int paramInt);
/*      */ 
/*      */     public native int skip_top();
/*      */ 
/*      */     public native AVCodecContext skip_top(int paramInt);
/*      */ 
/*      */     public native int skip_bottom();
/*      */ 
/*      */     public native AVCodecContext skip_bottom(int paramInt);
/*      */ 
/*      */     public native float border_masking();
/*      */ 
/*      */     public native AVCodecContext border_masking(float paramFloat);
/*      */ 
/*      */     public native int mb_lmin();
/*      */ 
/*      */     public native AVCodecContext mb_lmin(int paramInt);
/*      */ 
/*      */     public native int mb_lmax();
/*      */ 
/*      */     public native AVCodecContext mb_lmax(int paramInt);
/*      */ 
/*      */     public native int me_penalty_compensation();
/*      */ 
/*      */     public native AVCodecContext me_penalty_compensation(int paramInt);
/*      */ 
/*      */     public native int bidir_refine();
/*      */ 
/*      */     public native AVCodecContext bidir_refine(int paramInt);
/*      */ 
/*      */     public native int brd_scale();
/*      */ 
/*      */     public native AVCodecContext brd_scale(int paramInt);
/*      */ 
/*      */     public native int keyint_min();
/*      */ 
/*      */     public native AVCodecContext keyint_min(int paramInt);
/*      */ 
/*      */     public native int refs();
/*      */ 
/*      */     public native AVCodecContext refs(int paramInt);
/*      */ 
/*      */     public native int chromaoffset();
/*      */ 
/*      */     public native AVCodecContext chromaoffset(int paramInt);
/*      */ 
/*      */     public native int scenechange_factor();
/*      */ 
/*      */     public native AVCodecContext scenechange_factor(int paramInt);
/*      */ 
/*      */     public native int mv0_threshold();
/*      */ 
/*      */     public native AVCodecContext mv0_threshold(int paramInt);
/*      */ 
/*      */     public native int b_sensitivity();
/*      */ 
/*      */     public native AVCodecContext b_sensitivity(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorPrimaries"})
/*      */     public native int color_primaries();
/*      */ 
/*      */     public native AVCodecContext color_primaries(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorTransferCharacteristic"})
/*      */     public native int color_trc();
/*      */ 
/*      */     public native AVCodecContext color_trc(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorSpace"})
/*      */     public native int colorspace();
/*      */ 
/*      */     public native AVCodecContext colorspace(int paramInt);
/*      */ 
/*      */     @Cast({"AVColorRange"})
/*      */     public native int color_range();
/*      */ 
/*      */     public native AVCodecContext color_range(int paramInt);
/*      */ 
/*      */     @Cast({"AVChromaLocation"})
/*      */     public native int chroma_sample_location();
/*      */ 
/*      */     public native AVCodecContext chroma_sample_location(int paramInt);
/*      */ 
/*      */     public native int slices();
/*      */ 
/*      */     public native AVCodecContext slices(int paramInt);
/*      */ 
/*      */     @Cast({"AVFieldOrder"})
/*      */     public native int field_order();
/*      */ 
/*      */     public native AVCodecContext field_order(int paramInt);
/*      */ 
/*      */     public native int sample_rate();
/*      */ 
/*      */     public native AVCodecContext sample_rate(int paramInt);
/*      */ 
/*      */     public native int channels();
/*      */ 
/*      */     public native AVCodecContext channels(int paramInt);
/*      */ 
/*      */     @Cast({"AVSampleFormat"})
/*      */     public native int sample_fmt();
/*      */ 
/*      */     public native AVCodecContext sample_fmt(int paramInt);
/*      */ 
/*      */     public native int frame_size();
/*      */ 
/*      */     public native AVCodecContext frame_size(int paramInt);
/*      */ 
/*      */     public native int frame_number();
/*      */ 
/*      */     public native AVCodecContext frame_number(int paramInt);
/*      */ 
/*      */     public native int block_align();
/*      */ 
/*      */     public native AVCodecContext block_align(int paramInt);
/*      */ 
/*      */     public native int cutoff();
/*      */ 
/*      */     public native AVCodecContext cutoff(int paramInt);
/*      */ 
/*      */     @Deprecated
/*      */     public native int request_channels();
/*      */ 
/*      */     public native AVCodecContext request_channels(int paramInt);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long channel_layout();
/*      */ 
/*      */     public native AVCodecContext channel_layout(long paramLong);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long request_channel_layout();
/*      */ 
/*      */     public native AVCodecContext request_channel_layout(long paramLong);
/*      */ 
/*      */     @Cast({"AVAudioServiceType"})
/*      */     public native int audio_service_type();
/*      */ 
/*      */     public native AVCodecContext audio_service_type(int paramInt);
/*      */ 
/*      */     @Cast({"AVSampleFormat"})
/*      */     public native int request_sample_fmt();
/*      */ 
/*      */     public native AVCodecContext request_sample_fmt(int paramInt);
/*      */ 
/*      */     public native Get_buffer_AVCodecContext_AVFrame get_buffer();
/*      */ 
/*      */     public native AVCodecContext get_buffer(Get_buffer_AVCodecContext_AVFrame paramGet_buffer_AVCodecContext_AVFrame);
/*      */ 
/*      */     public native Release_buffer_AVCodecContext_AVFrame release_buffer();
/*      */ 
/*      */     public native AVCodecContext release_buffer(Release_buffer_AVCodecContext_AVFrame paramRelease_buffer_AVCodecContext_AVFrame);
/*      */ 
/*      */     public native Reget_buffer_AVCodecContext_AVFrame reget_buffer();
/*      */ 
/*      */     public native AVCodecContext reget_buffer(Reget_buffer_AVCodecContext_AVFrame paramReget_buffer_AVCodecContext_AVFrame);
/*      */ 
/*      */     public native Get_buffer2_AVCodecContext_AVFrame_int get_buffer2();
/*      */ 
/*      */     public native AVCodecContext get_buffer2(Get_buffer2_AVCodecContext_AVFrame_int paramGet_buffer2_AVCodecContext_AVFrame_int);
/*      */ 
/*      */     public native int refcounted_frames();
/*      */ 
/*      */     public native AVCodecContext refcounted_frames(int paramInt);
/*      */ 
/*      */     public native float qcompress();
/*      */ 
/*      */     public native AVCodecContext qcompress(float paramFloat);
/*      */ 
/*      */     public native float qblur();
/*      */ 
/*      */     public native AVCodecContext qblur(float paramFloat);
/*      */ 
/*      */     public native int qmin();
/*      */ 
/*      */     public native AVCodecContext qmin(int paramInt);
/*      */ 
/*      */     public native int qmax();
/*      */ 
/*      */     public native AVCodecContext qmax(int paramInt);
/*      */ 
/*      */     public native int max_qdiff();
/*      */ 
/*      */     public native AVCodecContext max_qdiff(int paramInt);
/*      */ 
/*      */     public native float rc_qsquish();
/*      */ 
/*      */     public native AVCodecContext rc_qsquish(float paramFloat);
/*      */ 
/*      */     public native float rc_qmod_amp();
/*      */ 
/*      */     public native AVCodecContext rc_qmod_amp(float paramFloat);
/*      */ 
/*      */     public native int rc_qmod_freq();
/*      */ 
/*      */     public native AVCodecContext rc_qmod_freq(int paramInt);
/*      */ 
/*      */     public native int rc_buffer_size();
/*      */ 
/*      */     public native AVCodecContext rc_buffer_size(int paramInt);
/*      */ 
/*      */     public native int rc_override_count();
/*      */ 
/*      */     public native AVCodecContext rc_override_count(int paramInt);
/*      */ 
/*      */     public native avcodec.RcOverride rc_override();
/*      */ 
/*      */     public native AVCodecContext rc_override(avcodec.RcOverride paramRcOverride);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer rc_eq();
/*      */ 
/*      */     public native int rc_max_rate();
/*      */ 
/*      */     public native AVCodecContext rc_max_rate(int paramInt);
/*      */ 
/*      */     public native int rc_min_rate();
/*      */ 
/*      */     public native AVCodecContext rc_min_rate(int paramInt);
/*      */ 
/*      */     public native float rc_buffer_aggressivity();
/*      */ 
/*      */     public native AVCodecContext rc_buffer_aggressivity(float paramFloat);
/*      */ 
/*      */     public native float rc_initial_cplx();
/*      */ 
/*      */     public native AVCodecContext rc_initial_cplx(float paramFloat);
/*      */ 
/*      */     public native float rc_max_available_vbv_use();
/*      */ 
/*      */     public native AVCodecContext rc_max_available_vbv_use(float paramFloat);
/*      */ 
/*      */     public native float rc_min_vbv_overflow_use();
/*      */ 
/*      */     public native AVCodecContext rc_min_vbv_overflow_use(float paramFloat);
/*      */ 
/*      */     public native int rc_initial_buffer_occupancy();
/*      */ 
/*      */     public native AVCodecContext rc_initial_buffer_occupancy(int paramInt);
/*      */ 
/*      */     public native int coder_type();
/*      */ 
/*      */     public native AVCodecContext coder_type(int paramInt);
/*      */ 
/*      */     public native int context_model();
/*      */ 
/*      */     public native AVCodecContext context_model(int paramInt);
/*      */ 
/*      */     public native int lmin();
/*      */ 
/*      */     public native AVCodecContext lmin(int paramInt);
/*      */ 
/*      */     public native int lmax();
/*      */ 
/*      */     public native AVCodecContext lmax(int paramInt);
/*      */ 
/*      */     public native int frame_skip_threshold();
/*      */ 
/*      */     public native AVCodecContext frame_skip_threshold(int paramInt);
/*      */ 
/*      */     public native int frame_skip_factor();
/*      */ 
/*      */     public native AVCodecContext frame_skip_factor(int paramInt);
/*      */ 
/*      */     public native int frame_skip_exp();
/*      */ 
/*      */     public native AVCodecContext frame_skip_exp(int paramInt);
/*      */ 
/*      */     public native int frame_skip_cmp();
/*      */ 
/*      */     public native AVCodecContext frame_skip_cmp(int paramInt);
/*      */ 
/*      */     public native int trellis();
/*      */ 
/*      */     public native AVCodecContext trellis(int paramInt);
/*      */ 
/*      */     public native int min_prediction_order();
/*      */ 
/*      */     public native AVCodecContext min_prediction_order(int paramInt);
/*      */ 
/*      */     public native int max_prediction_order();
/*      */ 
/*      */     public native AVCodecContext max_prediction_order(int paramInt);
/*      */ 
/*      */     public native long timecode_frame_start();
/*      */ 
/*      */     public native AVCodecContext timecode_frame_start(long paramLong);
/*      */ 
/*      */     public native Rtp_callback_AVCodecContext_Pointer_int_int rtp_callback();
/*      */ 
/*      */     public native AVCodecContext rtp_callback(Rtp_callback_AVCodecContext_Pointer_int_int paramRtp_callback_AVCodecContext_Pointer_int_int);
/*      */ 
/*      */     public native int rtp_payload_size();
/*      */ 
/*      */     public native AVCodecContext rtp_payload_size(int paramInt);
/*      */ 
/*      */     public native int mv_bits();
/*      */ 
/*      */     public native AVCodecContext mv_bits(int paramInt);
/*      */ 
/*      */     public native int header_bits();
/*      */ 
/*      */     public native AVCodecContext header_bits(int paramInt);
/*      */ 
/*      */     public native int i_tex_bits();
/*      */ 
/*      */     public native AVCodecContext i_tex_bits(int paramInt);
/*      */ 
/*      */     public native int p_tex_bits();
/*      */ 
/*      */     public native AVCodecContext p_tex_bits(int paramInt);
/*      */ 
/*      */     public native int i_count();
/*      */ 
/*      */     public native AVCodecContext i_count(int paramInt);
/*      */ 
/*      */     public native int p_count();
/*      */ 
/*      */     public native AVCodecContext p_count(int paramInt);
/*      */ 
/*      */     public native int skip_count();
/*      */ 
/*      */     public native AVCodecContext skip_count(int paramInt);
/*      */ 
/*      */     public native int misc_bits();
/*      */ 
/*      */     public native AVCodecContext misc_bits(int paramInt);
/*      */ 
/*      */     public native int frame_bits();
/*      */ 
/*      */     public native AVCodecContext frame_bits(int paramInt);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer stats_out();
/*      */ 
/*      */     public native AVCodecContext stats_out(BytePointer paramBytePointer);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer stats_in();
/*      */ 
/*      */     public native AVCodecContext stats_in(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int workaround_bugs();
/*      */ 
/*      */     public native AVCodecContext workaround_bugs(int paramInt);
/*      */ 
/*      */     public native int strict_std_compliance();
/*      */ 
/*      */     public native AVCodecContext strict_std_compliance(int paramInt);
/*      */ 
/*      */     public native int error_concealment();
/*      */ 
/*      */     public native AVCodecContext error_concealment(int paramInt);
/*      */ 
/*      */     public native int debug();
/*      */ 
/*      */     public native AVCodecContext debug(int paramInt);
/*      */ 
/*      */     public native int debug_mv();
/*      */ 
/*      */     public native AVCodecContext debug_mv(int paramInt);
/*      */ 
/*      */     public native int err_recognition();
/*      */ 
/*      */     public native AVCodecContext err_recognition(int paramInt);
/*      */ 
/*      */     /** @deprecated */
/*      */     public native long reordered_opaque();
/*      */ 
/*      */     public native AVCodecContext reordered_opaque(long paramLong);
/*      */ 
/*      */     public native avcodec.AVHWAccel hwaccel();
/*      */ 
/*      */     public native AVCodecContext hwaccel(avcodec.AVHWAccel paramAVHWAccel);
/*      */ 
/*      */     public native Pointer hwaccel_context();
/*      */ 
/*      */     public native AVCodecContext hwaccel_context(Pointer paramPointer);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long error(int paramInt);
/*      */ 
/*      */     public native AVCodecContext error(int paramInt, long paramLong);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"uint64_t*"})
/*      */     public native LongPointer error();
/*      */ 
/*      */     public native int dct_algo();
/*      */ 
/*      */     public native AVCodecContext dct_algo(int paramInt);
/*      */ 
/*      */     public native int idct_algo();
/*      */ 
/*      */     public native AVCodecContext idct_algo(int paramInt);
/*      */ 
/*      */     public native int bits_per_coded_sample();
/*      */ 
/*      */     public native AVCodecContext bits_per_coded_sample(int paramInt);
/*      */ 
/*      */     public native int bits_per_raw_sample();
/*      */ 
/*      */     public native AVCodecContext bits_per_raw_sample(int paramInt);
/*      */ 
/*      */     public native int lowres();
/*      */ 
/*      */     public native AVCodecContext lowres(int paramInt);
/*      */ 
/*      */     public native avutil.AVFrame coded_frame();
/*      */ 
/*      */     public native AVCodecContext coded_frame(avutil.AVFrame paramAVFrame);
/*      */ 
/*      */     public native int thread_count();
/*      */ 
/*      */     public native AVCodecContext thread_count(int paramInt);
/*      */ 
/*      */     public native int thread_type();
/*      */ 
/*      */     public native AVCodecContext thread_type(int paramInt);
/*      */ 
/*      */     public native int active_thread_type();
/*      */ 
/*      */     public native AVCodecContext active_thread_type(int paramInt);
/*      */ 
/*      */     public native int thread_safe_callbacks();
/*      */ 
/*      */     public native AVCodecContext thread_safe_callbacks(int paramInt);
/*      */ 
/*      */     public native Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int execute();
/*      */ 
/*      */     public native AVCodecContext execute(Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int paramExecute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int);
/*      */ 
/*      */     public native Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int execute2();
/*      */ 
/*      */     public native AVCodecContext execute2(Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int paramExecute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int);
/*      */ 
/*      */     public native Pointer thread_opaque();
/*      */ 
/*      */     public native AVCodecContext thread_opaque(Pointer paramPointer);
/*      */ 
/*      */     public native int nsse_weight();
/*      */ 
/*      */     public native AVCodecContext nsse_weight(int paramInt);
/*      */ 
/*      */     public native int profile();
/*      */ 
/*      */     public native AVCodecContext profile(int paramInt);
/*      */ 
/*      */     public native int level();
/*      */ 
/*      */     public native AVCodecContext level(int paramInt);
/*      */ 
/*      */     @Cast({"AVDiscard"})
/*      */     public native int skip_loop_filter();
/*      */ 
/*      */     public native AVCodecContext skip_loop_filter(int paramInt);
/*      */ 
/*      */     @Cast({"AVDiscard"})
/*      */     public native int skip_idct();
/*      */ 
/*      */     public native AVCodecContext skip_idct(int paramInt);
/*      */ 
/*      */     @Cast({"AVDiscard"})
/*      */     public native int skip_frame();
/*      */ 
/*      */     public native AVCodecContext skip_frame(int paramInt);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer subtitle_header();
/*      */ 
/*      */     public native AVCodecContext subtitle_header(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int subtitle_header_size();
/*      */ 
/*      */     public native AVCodecContext subtitle_header_size(int paramInt);
/*      */ 
/*      */     public native int error_rate();
/*      */ 
/*      */     public native AVCodecContext error_rate(int paramInt);
/*      */ 
/*      */     public native avcodec.AVPacket pkt();
/*      */ 
/*      */     public native AVCodecContext pkt(avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */     @Cast({"uint64_t"})
/*      */     public native long vbv_delay();
/*      */ 
/*      */     public native AVCodecContext vbv_delay(long paramLong);
/*      */ 
/*      */     @ByVal
/*      */     public native avutil.AVRational pkt_timebase();
/*      */ 
/*      */     public native AVCodecContext pkt_timebase(avutil.AVRational paramAVRational);
/*      */ 
/*      */     @MemberGetter
/*      */     @Const
/*      */     public native avcodec.AVCodecDescriptor codec_descriptor();
/*      */ 
/*      */     public native long pts_correction_num_faulty_pts();
/*      */ 
/*      */     public native AVCodecContext pts_correction_num_faulty_pts(long paramLong);
/*      */ 
/*      */     public native long pts_correction_num_faulty_dts();
/*      */ 
/*      */     public native AVCodecContext pts_correction_num_faulty_dts(long paramLong);
/*      */ 
/*      */     public native long pts_correction_last_pts();
/*      */ 
/*      */     public native AVCodecContext pts_correction_last_pts(long paramLong);
/*      */ 
/*      */     public native long pts_correction_last_dts();
/*      */ 
/*      */     public native AVCodecContext pts_correction_last_dts(long paramLong);
/*      */ 
/*      */     @Cast({"char*"})
/*      */     public native BytePointer sub_charenc();
/*      */ 
/*      */     public native AVCodecContext sub_charenc(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int sub_charenc_mode();
/*      */ 
/*      */     public native AVCodecContext sub_charenc_mode(int paramInt);
/*      */ 
/*      */     public native int skip_alpha();
/*      */ 
/*      */     public native AVCodecContext skip_alpha(int paramInt);
/*      */ 
/*      */     public native int seek_preroll();
/*      */ 
/*      */     public native AVCodecContext seek_preroll(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/* 1431 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int extends FunctionPointer
/*      */     {
/*      */       public Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int(Pointer p)
/*      */       {
/* 3052 */         super(); } 
/* 3053 */       protected Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avcodec.AVCodecContext.Func_AVCodecContext_Pointer_int_int paramFunc_AVCodecContext_Pointer_int_int, Pointer paramPointer, IntPointer paramIntPointer, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 3051 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Func_AVCodecContext_Pointer_int_int extends FunctionPointer
/*      */     {
/*      */       public Func_AVCodecContext_Pointer_int_int(Pointer p)
/*      */       {
/* 3044 */         super(); } 
/* 3045 */       protected Func_AVCodecContext_Pointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 3043 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int extends FunctionPointer
/*      */     {
/*      */       public Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int(Pointer p)
/*      */       {
/* 3017 */         super(); } 
/* 3018 */       protected Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avcodec.AVCodecContext.Func_AVCodecContext_Pointer paramFunc_AVCodecContext_Pointer, Pointer paramPointer, IntPointer paramIntPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 3016 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Func_AVCodecContext_Pointer extends FunctionPointer
/*      */     {
/*      */       public Func_AVCodecContext_Pointer(Pointer p)
/*      */       {
/* 3009 */         super(); } 
/* 3010 */       protected Func_AVCodecContext_Pointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer);
/*      */ 
/*      */       static
/*      */       {
/* 3008 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Rtp_callback_AVCodecContext_Pointer_int_int extends FunctionPointer
/*      */     {
/*      */       public Rtp_callback_AVCodecContext_Pointer_int_int(Pointer p)
/*      */       {
/* 2694 */         super(); } 
/* 2695 */       protected Rtp_callback_AVCodecContext_Pointer_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVCodecContext paramAVCodecContext, Pointer paramPointer, int paramInt1, int paramInt2);
/*      */ 
/*      */       static
/*      */       {
/* 2693 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Get_buffer2_AVCodecContext_AVFrame_int extends FunctionPointer
/*      */     {
/*      */       public Get_buffer2_AVCodecContext_AVFrame_int(Pointer p)
/*      */       {
/* 2475 */         super(); } 
/* 2476 */       protected Get_buffer2_AVCodecContext_AVFrame_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame, int paramInt);
/*      */ 
/*      */       static
/*      */       {
/* 2474 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Reget_buffer_AVCodecContext_AVFrame extends FunctionPointer
/*      */     {
/*      */       public Reget_buffer_AVCodecContext_AVFrame(Pointer p)
/*      */       {
/* 2384 */         super(); } 
/* 2385 */       protected Reget_buffer_AVCodecContext_AVFrame() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Deprecated
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */       static
/*      */       {
/* 2383 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     /** @deprecated */
/*      */     public static class Release_buffer_AVCodecContext_AVFrame extends FunctionPointer
/*      */     {
/*      */       public Release_buffer_AVCodecContext_AVFrame(Pointer p)
/*      */       {
/* 2363 */         super(); } 
/* 2364 */       protected Release_buffer_AVCodecContext_AVFrame() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Deprecated
/*      */       public native void call(avcodec.AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */       static
/*      */       {
/* 2362 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     /** @deprecated */
/*      */     public static class Get_buffer_AVCodecContext_AVFrame extends FunctionPointer
/*      */     {
/*      */       public Get_buffer_AVCodecContext_AVFrame(Pointer p)
/*      */       {
/* 2343 */         super(); } 
/* 2344 */       protected Get_buffer_AVCodecContext_AVFrame() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Deprecated
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, avutil.AVFrame paramAVFrame);
/*      */ 
/*      */       static
/*      */       {
/* 2342 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Get_format_AVCodecContext_IntPointer extends FunctionPointer
/*      */     {
/*      */       public Get_format_AVCodecContext_IntPointer(Pointer p)
/*      */       {
/* 1695 */         super(); } 
/* 1696 */       protected Get_format_AVCodecContext_IntPointer() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Cast({"AVPixelFormat"})
/*      */       public native int call(avcodec.AVCodecContext paramAVCodecContext, @Cast({"const AVPixelFormat*"}) IntPointer paramIntPointer);
/*      */ 
/*      */       static
/*      */       {
/* 1694 */         Loader.load();
/*      */       }
/*      */     }
/*      */ 
/*      */     public static class Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int extends FunctionPointer
/*      */     {
/*      */       public Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int(Pointer p)
/*      */       {
/* 1675 */         super(); } 
/* 1676 */       protected Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       public native void call(avcodec.AVCodecContext paramAVCodecContext, @Const avutil.AVFrame paramAVFrame, IntPointer paramIntPointer, int paramInt1, int paramInt2, int paramInt3);
/*      */ 
/*      */       static
/*      */       {
/* 1674 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   @Opaque
/*      */   public static class AVCodecInternal extends Pointer
/*      */   {
/*      */     public AVCodecInternal()
/*      */     {
/*      */     }
/*      */ 
/*      */     public AVCodecInternal(Pointer p)
/*      */     {
/* 1409 */       super();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVPacket extends Pointer
/*      */   {
/*      */     public AVPacket()
/*      */     {
/* 1307 */       allocate(); } 
/* 1308 */     public AVPacket(int size) { allocateArray(size); } 
/* 1309 */     public AVPacket(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1313 */     public AVPacket position(int position) { return (AVPacket)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native avutil.AVBufferRef buf();
/*      */ 
/*      */     public native AVPacket buf(avutil.AVBufferRef paramAVBufferRef);
/*      */ 
/*      */     public native long pts();
/*      */ 
/*      */     public native AVPacket pts(long paramLong);
/*      */ 
/*      */     public native long dts();
/*      */ 
/*      */     public native AVPacket dts(long paramLong);
/*      */ 
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer data();
/*      */ 
/*      */     public native AVPacket data(BytePointer paramBytePointer);
/*      */ 
/*      */     public native int size();
/*      */ 
/*      */     public native AVPacket size(int paramInt);
/*      */ 
/*      */     public native int stream_index();
/*      */ 
/*      */     public native AVPacket stream_index(int paramInt);
/*      */ 
/*      */     public native int flags();
/*      */ 
/*      */     public native AVPacket flags(int paramInt);
/*      */ 
/*      */     @Name({"side_data", ".data"})
/*      */     @Cast({"uint8_t*"})
/*      */     public native BytePointer side_data_data(int paramInt);
/*      */ 
/*      */     public native AVPacket side_data_data(int paramInt, BytePointer paramBytePointer);
/*      */ 
/*      */     @Name({"side_data", ".size"})
/*      */     public native int side_data_size(int paramInt);
/*      */ 
/*      */     public native AVPacket side_data_size(int paramInt1, int paramInt2);
/*      */ 
/*      */     @Name({"side_data", ".type"})
/*      */     @Cast({"AVPacketSideDataType"})
/*      */     public native int side_data_type(int paramInt);
/*      */ 
/*      */     public native AVPacket side_data_type(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native int side_data_elems();
/*      */ 
/*      */     public native AVPacket side_data_elems(int paramInt);
/*      */ 
/*      */     public native int duration();
/*      */ 
/*      */     public native AVPacket duration(int paramInt);
/*      */ 
/*      */     public native Destruct_AVPacket destruct();
/*      */ 
/*      */     public native AVPacket destruct(Destruct_AVPacket paramDestruct_AVPacket);
/*      */ 
/*      */     @Deprecated
/*      */     public native Pointer priv();
/*      */ 
/*      */     public native AVPacket priv(Pointer paramPointer);
/*      */ 
/*      */     public native long pos();
/*      */ 
/*      */     public native AVPacket pos(long paramLong);
/*      */ 
/*      */     public native long convergence_duration();
/*      */ 
/*      */     public native AVPacket convergence_duration(long paramLong);
/*      */ 
/*      */     static
/*      */     {
/* 1306 */       Loader.load();
/*      */     }
/*      */ 
/*      */     public static class Destruct_AVPacket extends FunctionPointer
/*      */     {
/*      */       public Destruct_AVPacket(Pointer p)
/*      */       {
/* 1362 */         super(); } 
/* 1363 */       protected Destruct_AVPacket() { allocate(); }
/*      */ 
/*      */ 
/*      */       private native void allocate();
/*      */ 
/*      */       @Deprecated
/*      */       public native void call(avcodec.AVPacket paramAVPacket);
/*      */ 
/*      */       static
/*      */       {
/* 1361 */         Loader.load();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVPanScan extends Pointer
/*      */   {
/*      */     public AVPanScan()
/*      */     {
/* 1119 */       allocate(); } 
/* 1120 */     public AVPanScan(int size) { allocateArray(size); } 
/* 1121 */     public AVPanScan(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/* 1125 */     public AVPanScan position(int position) { return (AVPanScan)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int id();
/*      */ 
/*      */     public native AVPanScan id(int paramInt);
/*      */ 
/*      */     public native int width();
/*      */ 
/*      */     public native AVPanScan width(int paramInt);
/*      */ 
/*      */     public native int height();
/*      */ 
/*      */     public native AVPanScan height(int paramInt);
/*      */ 
/*      */     @Name({"position"})
/*      */     public native short _position(int paramInt1, int paramInt2);
/*      */ 
/*      */     public native AVPanScan _position(int paramInt1, int paramInt2, short paramShort);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"int16_t(*)[2]"})
/*      */     @Name({"position"})
/*      */     public native ShortPointer _position();
/*      */ 
/*      */     static
/*      */     {
/* 1118 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class RcOverride extends Pointer
/*      */   {
/*      */     public RcOverride()
/*      */     {
/*  890 */       allocate(); } 
/*  891 */     public RcOverride(int size) { allocateArray(size); } 
/*  892 */     public RcOverride(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  896 */     public RcOverride position(int position) { return (RcOverride)super.position(position); }
/*      */ 
/*      */ 
/*      */     public native int start_frame();
/*      */ 
/*      */     public native RcOverride start_frame(int paramInt);
/*      */ 
/*      */     public native int end_frame();
/*      */ 
/*      */     public native RcOverride end_frame(int paramInt);
/*      */ 
/*      */     public native int qscale();
/*      */ 
/*      */     public native RcOverride qscale(int paramInt);
/*      */ 
/*      */     public native float quality_factor();
/*      */ 
/*      */     public native RcOverride quality_factor(float paramFloat);
/*      */ 
/*      */     static
/*      */     {
/*  889 */       Loader.load();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class AVCodecDescriptor extends Pointer
/*      */   {
/*      */     public AVCodecDescriptor()
/*      */     {
/*  707 */       allocate(); } 
/*  708 */     public AVCodecDescriptor(int size) { allocateArray(size); } 
/*  709 */     public AVCodecDescriptor(Pointer p) { super(); } 
/*      */     private native void allocate();
/*      */ 
/*      */     private native void allocateArray(int paramInt);
/*      */ 
/*  713 */     public AVCodecDescriptor position(int position) { return (AVCodecDescriptor)super.position(position); }
/*      */ 
/*      */ 
/*      */     @Cast({"AVCodecID"})
/*      */     public native int id();
/*      */ 
/*      */     public native AVCodecDescriptor id(int paramInt);
/*      */ 
/*      */     @Cast({"AVMediaType"})
/*      */     public native int type();
/*      */ 
/*      */     public native AVCodecDescriptor type(int paramInt);
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer name();
/*      */ 
/*      */     @MemberGetter
/*      */     @Cast({"const char*"})
/*      */     public native BytePointer long_name();
/*      */ 
/*      */     public native int props();
/*      */ 
/*      */     public native AVCodecDescriptor props(int paramInt);
/*      */ 
/*      */     static
/*      */     {
/*  706 */       Loader.load();
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.avcodec
 * JD-Core Version:    0.6.2
 */