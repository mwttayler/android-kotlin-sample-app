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
        ":features:latest",
        ":features:bookmarks",
        ":features:details"
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
    api(project(":core:data"))
    api(Libraries.APPCOMPAT)
    api(Libraries.MATERIAL)
    api(Libraries.RECYCLER_VIEW)
    api(Libraries.NAVIGATION_FRAGMENT_KTX)
    api(Libraries.NAVIGATION_KTX)
    api(Libraries.LIFECYCLE_EXTENSIONS)
    api(Libraries.LIFECYCLE_VIEWMODEL_KTX)
    api(Libraries.CORE_KTX)
    api(Libraries.FRAGMENT_KTX)
    api(Libraries.CONSTRAINT_LAYOUT)
    api(Libraries.SWIPE_REFRESH)
    api(Libraries.TIMBER)
    api(Libraries.COIL)
    api(Libraries.GROUPIE)
    api(Libraries.GROUPIE_EXTENSIONS)
    api(Libraries.GROUPIE_DATABINDING)
    api(Libraries.NAVIGATION_DYNAMIC_FEATURES)

    kapt(Libraries.DAGGER_COMPILER)
}
