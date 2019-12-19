const val KOTLIN_VERSION = "1.3.50"

object BuildPlugins {
    object Versions {
        const val ANDROID_BUILD_TOOLS = "3.5.3"
        const val SAFE_ARGS = "2.1.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.ANDROID_BUILD_TOOLS}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.SAFE_ARGS}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val androidDynamicFeature = "com.android.dynamic-feature"
    const val kotlinAndroid = "android"
    const val kotlinAndroidExtensions = "android.extensions"
    const val kotlinKapt = "kapt"
}

object AndroidConfig {
    const val APPLICATION_ID = "com.maxtayler.punk"
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 29
}

object Libraries {
    private object Versions {
        const val APP_COMPAT = "1.1.0"
        const val MATERIAL = "1.1.0-beta01"
        const val COROUTINES = "1.3.2"
        const val ROOM = "2.2.2"
        const val RECYCLER_VIEW = "1.1.0-alpha06"
        const val NAVIGATION = "2.1.0"
        const val LIFECYCLE = "2.1.0"
        const val CORE_KTX = "1.1.0"
        const val FRAGMENT_KTX = "1.2.0-alpha02"
        const val CONSTRAINT_LAYOUT = "1.1.3"
        const val SWIPE_REFRESH_LAYOUT = "1.1.0-alpha02"
        const val DAGGER = "2.24"
        const val TIMBER = "4.7.1"
        const val RETROFIT = "2.6.2"
        const val MOSHI = "1.8.0"
        const val MOSHI_CONVERTER = "2.4.0"
        const val COIL = "0.8.0"
        const val LOGGING = "4.2.2"
        const val GROUPIE = "2.7.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KOTLIN_VERSION}"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val material = "com.google.android.material:material:${Versions.MATERIAL}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"

    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val navigation_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val navigation_dynamic_features = "androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT"

    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    const val core_ktx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val coil = "io.coil-kt:coil:${Versions.COIL}"

    const val groupie = "com.xwray:groupie:${Versions.GROUPIE}"
    const val groupie_extensoions = "com.xwray:groupie-kotlin-android-extensions:${Versions.GROUPIE}"
    const val groupie_databinding = "com.xwray:groupie-databinding:${Versions.GROUPIE}"

    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
    const val dagger = "com.google.dagger:dagger:${Versions.DAGGER}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.ROOM}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.ROOM}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.ROOM}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.MOSHI_CONVERTER}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING}"
}

object TestLibraries {
    private object Versions {
        const val JUNIT4 = "4.13-beta-2"
    }

    const val junit4 = "junit:junit:${Versions.JUNIT4}"
}
