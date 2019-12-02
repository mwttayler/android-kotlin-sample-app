plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
}

dependencies {
    api(project(":domain"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.COROUTINES}")
    implementation("com.squareup.moshi:moshi:${DependencyVersions.MOSHI}")
    implementation("com.squareup.moshi:moshi-kotlin:${DependencyVersions.MOSHI}")
    implementation("com.squareup.retrofit2:converter-moshi:${DependencyVersions.MOSHI_CONVERTER}")
    implementation("com.squareup.retrofit2:retrofit:${DependencyVersions.RETROFIT}")
    implementation("com.squareup.okhttp3:logging-interceptor:${DependencyVersions.LOGGING}")

    kapt("com.google.dagger:dagger-compiler:${DependencyVersions.DAGGER}")
    kapt("androidx.room:room-compiler:${DependencyVersions.ROOM}")
}