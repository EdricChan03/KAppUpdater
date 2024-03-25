@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.gradle.library)
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    explicitApi()

    jvmToolchain(11)

    jvm {
        testRuns["test"].executionTask {
            useJUnitPlatform()
        }
    }
    androidTarget()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
    }
}

android {
    namespace = "io.github.edricchan03.appupdater"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}
