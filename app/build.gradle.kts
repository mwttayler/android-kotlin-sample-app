import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
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
    api("androidx.appcompat:appcompat:${DependencyVersions.APP_COMPAT}")
    api("com.google.android.material:material:${DependencyVersions.MATERIAL}")
    api("androidx.recyclerview:recyclerview:${DependencyVersions.RECYCLER_VIEW}")
    api("androidx.navigation:navigation-fragment-ktx:${DependencyVersions.NAVIGATION}")
    api("androidx.navigation:navigation-ui-ktx:${DependencyVersions.NAVIGATION}")
    api("androidx.lifecycle:lifecycle-extensions:${DependencyVersions.LIFECYCLE}")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersions.LIFECYCLE}")
    api("androidx.core:core-ktx:${DependencyVersions.CORE_KTX}")
    api("androidx.fragment:fragment-ktx:${DependencyVersions.FRAGMENT_KTX}")
    api("androidx.constraintlayout:constraintlayout:${DependencyVersions.CONSTRAINT_LAYOUT}")
    api("androidx.swiperefreshlayout:swiperefreshlayout:${DependencyVersions.SWIPE_REFRESH_LAYOUT}")
    api("com.jakewharton.timber:timber:${DependencyVersions.TIMBER}")
    api("io.coil-kt:coil:${DependencyVersions.COIL}")
    api("com.xwray:groupie:${DependencyVersions.GROUPIE}")
    api("com.xwray:groupie-kotlin-android-extensions:${DependencyVersions.GROUPIE}")
    api("com.xwray:groupie-databinding:${DependencyVersions.GROUPIE}")
    api("androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT")

    kapt("com.google.dagger:dagger-compiler:${DependencyVersions.DAGGER}")
}
