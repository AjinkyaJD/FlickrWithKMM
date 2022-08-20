plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
}

version = "1.0"
kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../FlickrElectroluxiOSApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(Libs.KTOR_CLIENT)
                implementation(Libs.KTOR_SERIALIZATION)
                implementation(Libs.KTOR_CONTENT_NEGOTIATION)
                implementation(Libs.KTOR_KOTLIN_SERIALIZATION)
                implementation(Libs.KTOR_LOGGING)
                implementation(Libs.KOIN_CORE)
                implementation(Libs.KOIN_TEST)
                implementation(Libs.COROUTINE_TEST)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Libs.KTOR_MOCK)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libs.KTOR_CLIENT_ANDROID)
                implementation(Libs.KTOR_CLIENT_JSON)
                implementation(Libs.KTOR_CLIENT_SERIALIZATION)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}