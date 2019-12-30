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