LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-subdir-java-files)

LOCAL_PACKAGE_NAME := NicoWnnG

LOCAL_CERTIFICATE := $(NICOWNN_CERTIFICATE)

LOCAL_JNI_SHARED_LIBRARIES := \
	libnicoWnnGEngDic libnicoWnnGJpnDic libnicownngdict

include $(BUILD_PACKAGE)

include $(call all-makefiles-under,$(LOCAL_PATH))
