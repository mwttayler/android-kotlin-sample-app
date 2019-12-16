plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
}

dependencies {
    api(project(":domain"))

    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.moshi)
    implementation(Libraries.moshi_kotlin)
    implementation(Libraries.moshi_converter)
    implementation(Libraries.retrofit)
    implementation(Libraries.okhttp_logging)
    kapt(Libraries.dagger_compiler)
    kapt(Libraries.room_compiler)
}