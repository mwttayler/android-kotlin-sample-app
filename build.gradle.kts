buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildPlugins.ANDROID_GRADLE_PLUGIN)
        classpath(BuildPlugins.SAFEARGS_GRADLE_PLUGIN)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    apply{
        from("$rootDir/ktlint.gradle.kts")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
