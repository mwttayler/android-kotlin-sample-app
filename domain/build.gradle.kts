plugins {
    kotlin("jvm")
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${DependencyVersions.KOTLIN}")
    api("com.google.dagger:dagger:${DependencyVersions.DAGGER}")
    api("androidx.room:room-runtime:${DependencyVersions.ROOM}")
    api("androidx.room:room-ktx:${DependencyVersions.ROOM}")
}
