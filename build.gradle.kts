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
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

val ktlint by configurations.creating

dependencies {
    ktlint(Libraries.KTLINT)
}

tasks.register<JavaExec>("ktlint") {
    group = "verification"
    description = "Check Kotlin code style."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args("--android", "src/**/*.kt")
}

tasks.register<JavaExec>("ktformat") {
    group = "formatting"
    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args("--android", "-F", "src/**/*.kt")
}