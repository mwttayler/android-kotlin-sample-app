buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.safeArgsGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://ci.android.com/builds/submitted/5956592/androidx_snapshot/latest/repository/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}