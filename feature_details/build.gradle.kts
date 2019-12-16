import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.androidDynamicFeature)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions { jvmTarget = "1.8" }
    }
}

dependencies {
    api(project(":app"))
    kapt(Libraries.dagger_compiler)
}