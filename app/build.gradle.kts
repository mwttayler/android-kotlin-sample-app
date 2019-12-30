import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.SAFEARGS)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    dynamicFeatures = mutableSetOf(
        ":feature_latest",
        ":feature_bookmarks",
        ":feature_details"
    )
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions { jvmTarget = "1.8" }
    }
    dataBinding { isEnabled = true }
}

dependencies {
    api(project(":core"))
    kapt(Libraries.DAGGER_COMPILER)
}