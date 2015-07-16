/*    */ package com.googlecode.javacv.cpp;
/*    */ 
/*    */ import com.googlecode.javacpp.BytePointer;
/*    */ import com.googlecode.javacpp.Loader;
/*    */ import com.googlecode.javacpp.annotation.Cast;
/*    */ import com.googlecode.javacpp.annotation.Properties;
/*    */ 
/*    */ @Properties(inherit={avfilter.class}, value={@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavdevice/avdevice.h>"}, link={"avdevice@.55"}), @com.googlecode.javacpp.annotation.Platform(value={"windows"}, preload={"avdevice-55"})})
/*    */ public class avdevice
/*    */ {
/*    */   @Cast({"unsigned"})
/*    */   public static native int avdevice_version();
/*    */ 
/*    */   @Cast({"const char*"})
/*    */   public static native BytePointer avdevice_configuration();
/*    */ 
/*    */   @Cast({"const char*"})
/*    */   public static native BytePointer avdevice_license();
/*    */ 
/*    */   public static native void avdevice_register_all();
/*    */ 
/*    */   static
/*    */   {
/* 45 */     Loader.load();
/*    */   }
/*    */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.cpp.avdevice
 * JD-Core Version:    0.6.2
 */