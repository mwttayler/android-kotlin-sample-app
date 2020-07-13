import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.ANDROID_DYNAMIC_FEATURE)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
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
    implementation(Libraries.DAGGER)
    kapt(Libraries.DAGGER_COMPILER)
}
