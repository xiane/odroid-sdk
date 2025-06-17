plugins {
    id("com.android.library")
}

val DEFAULT_COMPILE_SDK_VERSION : Int by rootProject
val DEFAULT_MIN_SDK_VERSION : Int by rootProject
val DEFAULT_TARGET_SDK_VERSION : Int by rootProject

android {
    namespace = "com.hardkernel.vendor.sdk.Rtc"
    compileSdk = DEFAULT_COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = DEFAULT_MIN_SDK_VERSION
        targetSdk = DEFAULT_TARGET_SDK_VERSION
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
