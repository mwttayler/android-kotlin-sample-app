plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
}

dependencies {
    api(project(":core-data"))
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