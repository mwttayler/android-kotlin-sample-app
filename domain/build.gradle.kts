plugins {
    kotlin("jvm")
}

dependencies {
    api(Libraries.kotlinStdLib)
    api(Libraries.dagger)
    api(Libraries.roomRuntime)
    api(Libraries.roomKtx)
}
