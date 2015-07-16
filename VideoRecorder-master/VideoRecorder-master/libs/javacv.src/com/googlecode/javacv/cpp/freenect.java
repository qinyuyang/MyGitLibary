/*     */ package com.googlecode.javacv.cpp;
/*     */ 
/*     */ import com.googlecode.javacpp.BytePointer;
/*     */ import com.googlecode.javacpp.FunctionPointer;
/*     */ import com.googlecode.javacpp.IntPointer;
/*     */ import com.googlecode.javacpp.Loader;
/*     */ import com.googlecode.javacpp.Pointer;
/*     */ import com.googlecode.javacpp.ShortPointer;
/*     */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*     */ import com.googlecode.javacpp.annotation.ByVal;
/*     */ import com.googlecode.javacpp.annotation.Cast;
/*     */ import com.googlecode.javacpp.annotation.Opaque;
/*     */ import com.googlecode.javacpp.annotation.Properties;
/*     */ 
/*     */ @Properties({@com.googlecode.javacpp.annotation.Platform(include={"<libfreenect.h>", "<libfreenect-registration.h>", "<libfreenect_sync.h>"}, link={"freenect@0.1", "freenect_sync@0.1"}, includepath={"/usr/local/include/libfreenect/", "/opt/local/include/libfreenect/", "/usr/include/libfreenect/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, link={"freenect", "freenect_sync", "pthreadVC2"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86"}, includepath={"C:/Program Files (x86)/libfreenect/include/libfreenect/"}, linkpath={"C:/pthreads-w32-2-9-1-release/Pre-built.2/lib/x86", "C:/Program Files (x86)/libfreenect/lib/"}), @com.googlecode.javacpp.annotation.Platform(value={"windows-x86_64"}, includepath={"C:/Program Files/libfreenect/include/libfreenect/"}, linkpath={"C:/pthreads-w32-2-9-1-release/Pre-built.2/lib/x64", "C:/Program Files/libfreenect/lib/"})})
/*     */ public class freenect
/*     */ {
/*     */   public static final int FREENECT_COUNTS_PER_G = 819;
/*     */   public static final int FREENECT_DEPTH_MM_MAX_VALUE = 10000;
/*     */   public static final int FREENECT_DEPTH_MM_NO_VALUE = 0;
/*     */   public static final int FREENECT_DEPTH_RAW_MAX_VALUE = 2048;
/*     */   public static final int FREENECT_DEPTH_RAW_NO_VALUE = 2047;
/*     */   public static final int FREENECT_DEVICE_CAMERA = 2;
/*     */   public static final int FREENECT_DEVICE_AUDIO = 4;
/*     */   public static final int FREENECT_RESOLUTION_LOW = 0;
/*     */   public static final int FREENECT_RESOLUTION_MEDIUM = 1;
/*     */   public static final int FREENECT_RESOLUTION_HIGH = 2;
/*     */   public static final int FREENECT_VIDEO_RGB = 0;
/*     */   public static final int FREENECT_VIDEO_BAYER = 1;
/*     */   public static final int FREENECT_VIDEO_IR_8BIT = 2;
/*     */   public static final int FREENECT_VIDEO_IR_10BIT = 3;
/*     */   public static final int FREENECT_VIDEO_IR_10BIT_PACKED = 4;
/*     */   public static final int FREENECT_VIDEO_YUV_RGB = 5;
/*     */   public static final int FREENECT_VIDEO_YUV_RAW = 6;
/*     */   public static final int FREENECT_DEPTH_11BIT = 0;
/*     */   public static final int FREENECT_DEPTH_10BIT = 1;
/*     */   public static final int FREENECT_DEPTH_11BIT_PACKED = 2;
/*     */   public static final int FREENECT_DEPTH_10BIT_PACKED = 3;
/*     */   public static final int FREENECT_DEPTH_REGISTERED = 4;
/*     */   public static final int FREENECT_DEPTH_MM = 5;
/*     */   public static final int LED_OFF = 0;
/*     */   public static final int LED_GREEN = 1;
/*     */   public static final int LED_RED = 2;
/*     */   public static final int LED_YELLOW = 3;
/*     */   public static final int LED_BLINK_GREEN = 4;
/*     */   public static final int LED_BLINK_RED_YELLOW = 6;
/*     */   public static final int TILT_STATUS_STOPPED = 0;
/*     */   public static final int TILT_STATUS_LIMIT = 1;
/*     */   public static final int TILT_STATUS_MOVING = 4;
/*     */   public static final int FREENECT_LOG_FATAL = 0;
/*     */   public static final int FREENECT_LOG_ERROR = 1;
/*     */   public static final int FREENECT_LOG_WARNING = 2;
/*     */   public static final int FREENECT_LOG_NOTICE = 3;
/*     */   public static final int FREENECT_LOG_INFO = 4;
/*     */   public static final int FREENECT_LOG_DEBUG = 5;
/*     */   public static final int FREENECT_LOG_SPEW = 6;
/*     */   public static final int FREENECT_LOG_FLOOD = 7;
/*     */ 
/*     */   public static native int freenect_init(@ByPtrPtr freenect_context paramfreenect_context, freenect_usb_context paramfreenect_usb_context);
/*     */ 
/*     */   public static native int freenect_shutdown(freenect_context paramfreenect_context);
/*     */ 
/*     */   public static native void freenect_set_log_level(freenect_context paramfreenect_context, @Cast({"freenect_loglevel"}) int paramInt);
/*     */ 
/*     */   public static native void freenect_set_log_callback(freenect_context paramfreenect_context, freenect_log_cb paramfreenect_log_cb);
/*     */ 
/*     */   public static native int freenect_process_events(freenect_context paramfreenect_context);
/*     */ 
/*     */   public static native int freenect_process_events_timeout(freenect_context paramfreenect_context, timeval paramtimeval);
/*     */ 
/*     */   public static native int freenect_num_devices(freenect_context paramfreenect_context);
/*     */ 
/*     */   public static native int freenect_list_device_attributes(freenect_context paramfreenect_context, @ByPtrPtr freenect_device_attributes paramfreenect_device_attributes);
/*     */ 
/*     */   public static native void freenect_free_device_attributes(freenect_device_attributes paramfreenect_device_attributes);
/*     */ 
/*     */   public static native int freenect_supported_subdevices();
/*     */ 
/*     */   public static native void freenect_select_subdevices(freenect_context paramfreenect_context, @Cast({"freenect_device_flags"}) int paramInt);
/*     */ 
/*     */   public static native int freenect_open_device(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, int paramInt);
/*     */ 
/*     */   public static native int freenect_open_device_by_camera_serial(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, String paramString);
/*     */ 
/*     */   public static native int freenect_open_device_by_camera_serial(freenect_context paramfreenect_context, @ByPtrPtr freenect_device paramfreenect_device, @Cast({"char*"}) BytePointer paramBytePointer);
/*     */ 
/*     */   public static native int freenect_close_device(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native void freenect_set_user(freenect_device paramfreenect_device, Pointer paramPointer);
/*     */ 
/*     */   public static native Pointer freenect_get_user(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native void freenect_set_depth_callback(freenect_device paramfreenect_device, freenect_depth_cb paramfreenect_depth_cb);
/*     */ 
/*     */   public static native void freenect_set_video_callback(freenect_device paramfreenect_device, freenect_video_cb paramfreenect_video_cb);
/*     */ 
/*     */   public static native int freenect_set_depth_buffer(freenect_device paramfreenect_device, Pointer paramPointer);
/*     */ 
/*     */   public static native int freenect_set_video_buffer(freenect_device paramfreenect_device, Pointer paramPointer);
/*     */ 
/*     */   public static native int freenect_start_depth(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native int freenect_start_video(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native int freenect_stop_depth(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native int freenect_stop_video(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native int freenect_update_tilt_state(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native freenect_raw_tilt_state freenect_get_tilt_state(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native double freenect_get_tilt_degs(freenect_raw_tilt_state paramfreenect_raw_tilt_state);
/*     */ 
/*     */   public static native int freenect_set_tilt_degs(freenect_device paramfreenect_device, double paramDouble);
/*     */ 
/*     */   @Cast({"freenect_tilt_status_code"})
/*     */   public static native int freenect_get_tilt_status(freenect_raw_tilt_state paramfreenect_raw_tilt_state);
/*     */ 
/*     */   public static native int freenect_set_led(freenect_device paramfreenect_device, @Cast({"freenect_led_options"}) int paramInt);
/*     */ 
/*     */   public static native void freenect_get_mks_accel(freenect_raw_tilt_state paramfreenect_raw_tilt_state, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
/*     */ 
/*     */   public static native int freenect_get_video_mode_count();
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_get_video_mode(int paramInt);
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_get_current_video_mode(freenect_device paramfreenect_device);
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_find_video_mode(@Cast({"freenect_resolution"}) int paramInt1, @Cast({"freenect_video_format"}) int paramInt2);
/*     */ 
/*     */   public static native int freenect_set_video_mode(freenect_device paramfreenect_device, @ByVal freenect_frame_mode paramfreenect_frame_mode);
/*     */ 
/*     */   public static native int freenect_get_depth_mode_count();
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_get_depth_mode(int paramInt);
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_get_current_depth_mode(freenect_device paramfreenect_device);
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_frame_mode freenect_find_depth_mode(@Cast({"freenect_resolution"}) int paramInt1, @Cast({"freenect_depth_format"}) int paramInt2);
/*     */ 
/*     */   public static native int freenect_set_depth_mode(freenect_device paramfreenect_device, @ByVal freenect_frame_mode paramfreenect_frame_mode);
/*     */ 
/*     */   @ByVal
/*     */   public static native freenect_registration freenect_copy_registration(freenect_device paramfreenect_device);
/*     */ 
/*     */   public static native int freenect_destroy_registration(freenect_registration paramfreenect_registration);
/*     */ 
/*     */   public static native void freenect_camera_to_world(freenect_device paramfreenect_device, int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
/*     */ 
/*     */   public static native int freenect_sync_get_video(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, @Cast({"uint32_t*"}) int[] paramArrayOfInt, int paramInt1, @Cast({"freenect_video_format"}) int paramInt2);
/*     */ 
/*     */   public static native int freenect_sync_get_depth(@Cast({"void**"}) @ByPtrPtr Pointer paramPointer, @Cast({"uint32_t*"}) int[] paramArrayOfInt, int paramInt1, @Cast({"freenect_depth_format"}) int paramInt2);
/*     */ 
/*     */   public static native int freenect_sync_set_tilt_degs(int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native int freenect_sync_get_tilt_state(@ByPtrPtr freenect_raw_tilt_state paramfreenect_raw_tilt_state, int paramInt);
/*     */ 
/*     */   public static native int freenect_sync_set_led(@Cast({"freenect_led_options"}) int paramInt1, int paramInt2);
/*     */ 
/*     */   public static native void freenect_sync_stop();
/*     */ 
/*     */   static
/*     */   {
/* 120 */     Loader.load();
/*     */   }
/*     */ 
/*     */   public static class freenect_registration extends Pointer
/*     */   {
/*     */     public freenect_registration()
/*     */     {
/* 421 */       allocate(); } 
/* 422 */     public freenect_registration(int size) { allocateArray(size); } 
/* 423 */     public freenect_registration(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     @ByVal
/*     */     public native freenect.freenect_reg_info reg_info();
/*     */ 
/*     */     public native freenect_registration reg_info(freenect.freenect_reg_info paramfreenect_reg_info);
/*     */ 
/*     */     @ByVal
/*     */     public native freenect.freenect_reg_pad_info reg_pad_info();
/*     */ 
/*     */     public native freenect_registration reg_pad_info(freenect.freenect_reg_pad_info paramfreenect_reg_pad_info);
/*     */ 
/*     */     @ByVal
/*     */     public native freenect.freenect_zero_plane_info zero_plane_info();
/*     */ 
/*     */     public native freenect_registration zero_plane_info(freenect.freenect_zero_plane_info paramfreenect_zero_plane_info);
/*     */ 
/*     */     public native double const_shift();
/*     */ 
/*     */     public native freenect_registration const_shift(double paramDouble);
/*     */ 
/*     */     @Cast({"uint16_t*"})
/*     */     public native ShortPointer raw_to_mm_shift();
/*     */ 
/*     */     public native freenect_registration raw_to_mm_shift(ShortPointer paramShortPointer);
/*     */ 
/*     */     public native IntPointer depth_to_rgb_shift();
/*     */ 
/*     */     public native freenect_registration depth_to_rgb_shift(IntPointer paramIntPointer);
/*     */ 
/*     */     @Cast({"int32_t(*)[2]"})
/*     */     public native IntPointer registration_table();
/*     */ 
/*     */     public native freenect_registration registration_table(IntPointer paramIntPointer);
/*     */ 
/*     */     static
/*     */     {
/* 420 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_zero_plane_info extends Pointer
/*     */   {
/*     */     public freenect_zero_plane_info()
/*     */     {
/* 407 */       allocate(); } 
/* 408 */     public freenect_zero_plane_info(int size) { allocateArray(size); } 
/* 409 */     public freenect_zero_plane_info(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native float dcmos_emitter_dist();
/*     */ 
/*     */     public native freenect_zero_plane_info dcmos_emitter_dist(float paramFloat);
/*     */ 
/*     */     public native float dcmos_rcmos_dist();
/*     */ 
/*     */     public native freenect_zero_plane_info dcmos_rcmos_dist(float paramFloat);
/*     */ 
/*     */     public native float reference_distance();
/*     */ 
/*     */     public native freenect_zero_plane_info reference_distance(float paramFloat);
/*     */ 
/*     */     public native float reference_pixel_size();
/*     */ 
/*     */     public native freenect_zero_plane_info reference_pixel_size(float paramFloat);
/*     */ 
/*     */     static
/*     */     {
/* 406 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_reg_pad_info extends Pointer
/*     */   {
/*     */     public freenect_reg_pad_info()
/*     */     {
/* 394 */       allocate(); } 
/* 395 */     public freenect_reg_pad_info(int size) { allocateArray(size); } 
/* 396 */     public freenect_reg_pad_info(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native short start_lines();
/*     */ 
/*     */     public native freenect_reg_pad_info start_lines(short paramShort);
/*     */ 
/*     */     public native short end_lines();
/*     */ 
/*     */     public native freenect_reg_pad_info end_lines(short paramShort);
/*     */ 
/*     */     public native short cropping_lines();
/*     */ 
/*     */     public native freenect_reg_pad_info cropping_lines(short paramShort);
/*     */ 
/*     */     static
/*     */     {
/* 393 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_reg_info extends Pointer
/*     */   {
/*     */     public freenect_reg_info()
/*     */     {
/* 342 */       allocate(); } 
/* 343 */     public freenect_reg_info(int size) { allocateArray(size); } 
/* 344 */     public freenect_reg_info(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native int dx_center();
/*     */ 
/*     */     public native freenect_reg_info dx_center(int paramInt);
/*     */ 
/*     */     public native int ax();
/*     */ 
/*     */     public native freenect_reg_info ax(int paramInt);
/*     */ 
/*     */     public native int bx();
/*     */ 
/*     */     public native freenect_reg_info bx(int paramInt);
/*     */ 
/*     */     public native int cx();
/*     */ 
/*     */     public native freenect_reg_info cx(int paramInt);
/*     */ 
/*     */     public native int dx();
/*     */ 
/*     */     public native freenect_reg_info dx(int paramInt);
/*     */ 
/*     */     public native int dx_start();
/*     */ 
/*     */     public native freenect_reg_info dx_start(int paramInt);
/*     */ 
/*     */     public native int ay();
/*     */ 
/*     */     public native freenect_reg_info ay(int paramInt);
/*     */ 
/*     */     public native int by();
/*     */ 
/*     */     public native freenect_reg_info by(int paramInt);
/*     */ 
/*     */     public native int cy();
/*     */ 
/*     */     public native freenect_reg_info cy(int paramInt);
/*     */ 
/*     */     public native int dy();
/*     */ 
/*     */     public native freenect_reg_info dy(int paramInt);
/*     */ 
/*     */     public native int dy_start();
/*     */ 
/*     */     public native freenect_reg_info dy_start(int paramInt);
/*     */ 
/*     */     public native int dx_beta_start();
/*     */ 
/*     */     public native freenect_reg_info dx_beta_start(int paramInt);
/*     */ 
/*     */     public native int dy_beta_start();
/*     */ 
/*     */     public native freenect_reg_info dy_beta_start(int paramInt);
/*     */ 
/*     */     public native int rollout_blank();
/*     */ 
/*     */     public native freenect_reg_info rollout_blank(int paramInt);
/*     */ 
/*     */     public native int rollout_size();
/*     */ 
/*     */     public native freenect_reg_info rollout_size(int paramInt);
/*     */ 
/*     */     public native int dx_beta_inc();
/*     */ 
/*     */     public native freenect_reg_info dx_beta_inc(int paramInt);
/*     */ 
/*     */     public native int dy_beta_inc();
/*     */ 
/*     */     public native freenect_reg_info dy_beta_inc(int paramInt);
/*     */ 
/*     */     public native int dxdx_start();
/*     */ 
/*     */     public native freenect_reg_info dxdx_start(int paramInt);
/*     */ 
/*     */     public native int dxdy_start();
/*     */ 
/*     */     public native freenect_reg_info dxdy_start(int paramInt);
/*     */ 
/*     */     public native int dydx_start();
/*     */ 
/*     */     public native freenect_reg_info dydx_start(int paramInt);
/*     */ 
/*     */     public native int dydy_start();
/*     */ 
/*     */     public native freenect_reg_info dydy_start(int paramInt);
/*     */ 
/*     */     public native int dxdxdx_start();
/*     */ 
/*     */     public native freenect_reg_info dxdxdx_start(int paramInt);
/*     */ 
/*     */     public native int dydxdx_start();
/*     */ 
/*     */     public native freenect_reg_info dydxdx_start(int paramInt);
/*     */ 
/*     */     public native int dxdxdy_start();
/*     */ 
/*     */     public native freenect_reg_info dxdxdy_start(int paramInt);
/*     */ 
/*     */     public native int dydxdy_start();
/*     */ 
/*     */     public native freenect_reg_info dydxdy_start(int paramInt);
/*     */ 
/*     */     public native int back_comp1();
/*     */ 
/*     */     public native freenect_reg_info back_comp1(int paramInt);
/*     */ 
/*     */     public native int dydydx_start();
/*     */ 
/*     */     public native freenect_reg_info dydydx_start(int paramInt);
/*     */ 
/*     */     public native int back_comp2();
/*     */ 
/*     */     public native freenect_reg_info back_comp2(int paramInt);
/*     */ 
/*     */     public native int dydydy_start();
/*     */ 
/*     */     public native freenect_reg_info dydydy_start(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 341 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_video_cb extends FunctionPointer
/*     */   {
/*     */     public freenect_video_cb(Pointer p)
/*     */     {
/* 302 */       super(); } 
/* 303 */     protected freenect_video_cb() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(freenect.freenect_device paramfreenect_device, Pointer paramPointer, @Cast({"uint32_t"}) int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 301 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_depth_cb extends FunctionPointer
/*     */   {
/*     */     public freenect_depth_cb(Pointer p)
/*     */     {
/* 295 */       super(); } 
/* 296 */     protected freenect_depth_cb() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(freenect.freenect_device paramfreenect_device, Pointer paramPointer, @Cast({"uint32_t"}) int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 294 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_log_cb extends FunctionPointer
/*     */   {
/*     */     public freenect_log_cb(Pointer p)
/*     */     {
/* 271 */       super(); } 
/* 272 */     protected freenect_log_cb() { allocate(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     public native void call(freenect.freenect_context paramfreenect_context, @Cast({"freenect_loglevel"}) int paramInt, String paramString);
/*     */ 
/*     */     static
/*     */     {
/* 270 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class freenect_usb_context extends Pointer
/*     */   {
/*     */     public freenect_usb_context()
/*     */     {
/*     */     }
/*     */ 
/*     */     public freenect_usb_context(Pointer p)
/*     */     {
/* 252 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 250 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class freenect_device extends Pointer
/*     */   {
/*     */     public freenect_device()
/*     */     {
/*     */     }
/*     */ 
/*     */     public freenect_device(Pointer p)
/*     */     {
/* 246 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 244 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Opaque
/*     */   public static class freenect_context extends Pointer
/*     */   {
/*     */     public freenect_context()
/*     */     {
/*     */     }
/*     */ 
/*     */     public freenect_context(Pointer p)
/*     */     {
/* 240 */       super();
/*     */     }
/*     */ 
/*     */     static
/*     */     {
/* 238 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_raw_tilt_state extends Pointer
/*     */   {
/*     */     public freenect_raw_tilt_state()
/*     */     {
/* 223 */       allocate(); } 
/* 224 */     public freenect_raw_tilt_state(int size) { allocateArray(size); } 
/* 225 */     public freenect_raw_tilt_state(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native short accelerometer_x();
/*     */ 
/*     */     public native freenect_raw_tilt_state accelerometer_x(short paramShort);
/*     */ 
/*     */     public native short accelerometer_y();
/*     */ 
/*     */     public native freenect_raw_tilt_state accelerometer_y(short paramShort);
/*     */ 
/*     */     public native short accelerometer_z();
/*     */ 
/*     */     public native freenect_raw_tilt_state accelerometer_z(short paramShort);
/*     */ 
/*     */     public native byte tilt_angle();
/*     */ 
/*     */     public native freenect_raw_tilt_state tilt_angle(byte paramByte);
/*     */ 
/*     */     @Cast({"freenect_tilt_status_code"})
/*     */     public native int tilt_status();
/*     */ 
/*     */     public native freenect_raw_tilt_state tilt_status(int paramInt);
/*     */ 
/*     */     static
/*     */     {
/* 222 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_frame_mode extends Pointer
/*     */   {
/*     */     public freenect_frame_mode()
/*     */     {
/* 185 */       allocate(); } 
/* 186 */     public freenect_frame_mode(int size) { allocateArray(size); } 
/* 187 */     public freenect_frame_mode(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native int reserved();
/*     */ 
/*     */     public native freenect_frame_mode reserved(int paramInt);
/*     */ 
/*     */     @Cast({"freenect_resolution"})
/*     */     public native int resolution();
/*     */ 
/*     */     public native freenect_frame_mode resolution(int paramInt);
/*     */ 
/*     */     @Cast({"freenect_video_format"})
/*     */     public native int video_format();
/*     */ 
/*     */     public native freenect_frame_mode video_format(int paramInt);
/*     */ 
/*     */     @Cast({"freenect_depth_format"})
/*     */     public native int depth_format();
/*     */ 
/*     */     public native freenect_frame_mode depth_format(int paramInt);
/*     */ 
/*     */     public native int bytes();
/*     */ 
/*     */     public native freenect_frame_mode bytes(int paramInt);
/*     */ 
/*     */     public native short width();
/*     */ 
/*     */     public native freenect_frame_mode width(short paramShort);
/*     */ 
/*     */     public native short height();
/*     */ 
/*     */     public native freenect_frame_mode height(short paramShort);
/*     */ 
/*     */     public native byte data_bits_per_pixel();
/*     */ 
/*     */     public native freenect_frame_mode data_bits_per_pixel(byte paramByte);
/*     */ 
/*     */     public native byte padding_bits_per_pixel();
/*     */ 
/*     */     public native freenect_frame_mode padding_bits_per_pixel(byte paramByte);
/*     */ 
/*     */     public native byte framerate();
/*     */ 
/*     */     public native freenect_frame_mode framerate(byte paramByte);
/*     */ 
/*     */     public native byte is_valid();
/*     */ 
/*     */     public native freenect_frame_mode is_valid(byte paramByte);
/*     */ 
/*     */     static
/*     */     {
/* 184 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class freenect_device_attributes extends Pointer
/*     */   {
/*     */     public freenect_device_attributes()
/*     */     {
/* 149 */       allocate(); } 
/* 150 */     public freenect_device_attributes(int size) { allocateArray(size); } 
/* 151 */     public freenect_device_attributes(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native freenect_device_attributes next();
/*     */ 
/*     */     public native freenect_device_attributes next(freenect_device_attributes paramfreenect_device_attributes);
/*     */ 
/*     */     @Cast({"const char*"})
/*     */     public native BytePointer camera_serial();
/*     */ 
/*     */     public native freenect_device_attributes camera_serial(BytePointer paramBytePointer);
/*     */ 
/*     */     static
/*     */     {
/* 148 */       Loader.load();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class timeval extends Pointer
/*     */   {
/*     */     public timeval()
/*     */     {
/* 124 */       allocate(); } 
/* 125 */     public timeval(int size) { allocateArray(size); } 
/* 126 */     public timeval(Pointer p) { super(); }
/*     */ 
/*     */ 
/*     */     private native void allocate();
/*     */ 
/*     */     private native void allocateArray(int paramInt);
/*     */ 
/*     */     public native long tv_sec();
/*     */ 
/*     */     public native timeval tv_sec(long paramLong);
/*     */ 
/*     */     public native long tv_usec();
/*     */ 
/*     */     public native timeval tv_usec(long paramLong);
/*     */ 
/*     */     static
/*     */     {
/* 123 */       Loader.load();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.freenect
 * JD-Core Version:    0.6.2
 */