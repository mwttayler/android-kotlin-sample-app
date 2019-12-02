buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersions.KOTLIN}")
        classpath("com.android.tools.build:gradle:3.5.2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0")
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