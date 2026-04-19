plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
