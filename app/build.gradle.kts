import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kotlinKapt)
    id(BuildPlugins.safeArgs)
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
    api(project(":data"))
    api(Libraries.appCompat)
    api(Libraries.material)
    api(Libraries.recyclerview)
    api(Libraries.navigation_fragment_ktx)
    api(Libraries.navigation_ktx)
    api(Libraries.lifecycle_extensions)
    api(Libraries.lifecycle_viewmodel_ktx)
    api(Libraries.core_ktx)
    api(Libraries.fragment_ktx)
    api(Libraries.constraintlayout)
    api(Libraries.swiperefresh)
    api(Libraries.timber)
    api(Libraries.coil)
    api(Libraries.groupie)
    api(Libraries.groupie_extensoions)
    api(Libraries.groupie_databinding)
    api(Libraries.navigation_dynamic_features)

    kapt(Libraries.dagger_compiler)
}