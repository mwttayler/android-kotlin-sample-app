buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildPlugins.ANDROID_GRADLE_PLUGIN)
        classpath(BuildPlugins.SAFEARGS_GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://ci.android.com/builds/submitted/5956592/androidx_snapshot/latest/repository/")
    }

    apply{
        from("$rootDir/ktlint.gradle.kts")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}