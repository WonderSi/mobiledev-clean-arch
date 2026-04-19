plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    // cross-feature reuse of habits domain is allowed
    implementation(project(":habits:domain"))
    implementation(libs.kotlinx.coroutines.core)
}
