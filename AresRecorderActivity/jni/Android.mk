LOCAL_PATH := $(callmy-dir)

include $(CLEAR_VARS)
LOCAL_MODULE :=avcodec-54-prebuilt
LOCAL_SRC_FILES := cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libavcodec-54.so
include $(PREBUILT_SHARED_LIBRARY)  

include $(CLEAR_VARS)
LOCAL_MODULE :=avdevice-54-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libavdevice-54.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=avfilter-3-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libavfilter-3.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=avformat-54-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libavformat-54.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=  avutil-51-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libavutil-51.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=  avswresample-0-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libswresample-0.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=  swscale-2-prebuilt
LOCAL_SRC_FILES :=cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/prebuilt/libswscale-2.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_PATH := $(callmy-dir)
LOCAL_MY_INCLUDES := $(LOCAL_PATH)
LOCAL_C_INCLUDES := $(LOCAL_MY_INCLUDES)include/
LOCAL_CPP_INCLUDES := $(LOCAL_MY_INCLUDES)include/
LOCAL_MODULE := ffmpegtest
LOCAL_SRC_FILES := cygdrive/e/eclipse_workspace/AresRecorderActivity/jni/ffmpegtest1.cpp
LOCAL_CPP_EXTENSION := .cpp
LOCAL_CFLAGS := -D__STDC_CONSTANT_MACROS
LOCAL_LDLIBS := -llog -ljnigraphics -lz -landroid
LOCAL_SHARED_LIBRARIES:= avcodec-54-prebuilt avdevice-54-prebuilt avfilter-3-prebuilt avformat-54-prebuilt avutil-51-prebuilt avswresample-0-prebuilt swscale-2-prebuilt

include $(BUILD_SHARED_LIBRARY)