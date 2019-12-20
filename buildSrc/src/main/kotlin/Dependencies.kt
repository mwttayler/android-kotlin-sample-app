const val KOTLIN_VERSION = "1.3.50"

object BuildPlugins {
    object Versions {
        const val ANDROID_BUILD_TOOLS = "3.5.3"
        const val SAFE_ARGS = "2.1.0"
    }

    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.ANDROID_BUILD_TOOLS}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val SAFEARGS_GRADLE_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.SAFE_ARGS}"

    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val SAFEARGS = "androidx.navigation.safeargs.kotlin"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val KOTLIN_ANDROID = "android"
    const val KOTLIN_ANDROID_EXTENSIONS = "android.extensions"
    const val KOTLIN_KAPT = "kapt"
}

object AndroidConfig {
    const val APPLICATION_ID = "com.maxtayler.punk"
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 29
}

object Libraries {
    private object Versions {
        const val APP_COMPAT_VERSION = "1.1.0"
        const val MATERIAL = "1.1.0-beta01"
        const val COROUTINES = "1.3.2"
        const val ROOM = "2.2.2"
        const val RECYCLER_VIEW_VERSION = "1.1.0-alpha06"
        const val NAVIGATION = "2.1.0"
        const val LIFECYCLE = "2.1.0"
        const val CORE_KTX = "1.1.0"
        const val FRAGMENT_KTX = "1.2.0-alpha02"
        const val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
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

    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KOTLIN_VERSION}"
    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW_VERSION}"

    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURES = "androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT"

    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"

    const val GROUPIE = "com.xwray:groupie:${Versions.GROUPIE}"
    const val GROUPIE_EXTENSIONS = "com.xwray:groupie-kotlin-android-extensions:${Versions.GROUPIE}"
    const val GROUPIE_DATABINDING = "com.xwray:groupie-databinding:${Versions.GROUPIE}"

    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.MOSHI_CONVERTER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING}"
}

object TestLibraries {
    private object Versions {
        const val JUNIT4_VERSION = "4.13-beta-2"
    }

    const val JUNIT4 = "junit:junit:${Versions.JUNIT4_VERSION}"
}
