// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

extra["DEFAULT_COMPILE_SDK_VERSION"] = 27
extra["DEFAULT_MIN_SDK_VERSION"] = 27
extra["DEFAULT_TARGET_SDK_VERSION"] = 27