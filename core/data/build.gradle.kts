plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
}

dependencies {
    api(project(":core:domain"))

    implementation(Libraries.KOTLIN_COROUTINES)
    implementation(Libraries.MOSHI)
    implementation(Libraries.MOSHI_KOTLIN)
    implementation(Libraries.MOSHI_CONVERTER)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.OKHTTP_LOGGING)
    kapt(Libraries.DAGGER_COMPILER)
    kapt(Libraries.ROOM_COMPILER)
}
