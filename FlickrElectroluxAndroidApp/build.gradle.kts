plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Version.COMPILE_SDK
    defaultConfig {
        applicationId = "com.ajinkyad.flickrelectrolux.android"
        minSdk = Version.MIN_SDK
        targetSdk = Version.TARGET_SDK
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    // Set both the Java and Kotlin compilers to target Java 8.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":shared"))

    // Integration with activities
    implementation(Libs.COMPOSE_ACTIVITY)

    // Integration with ViewModels
    implementation(Libs.COMPOSE_VIEWMODEL)
    // Navigation Library
    implementation(Libs.COMPOSE_NAVIGATION)

    implementation(Libs.COMPOSE_MATERIAL_UI)
    implementation(Libs.COMPOSE_LIVEDATA)

    // Image Loading Library
    implementation(Libs.COIL)

    // Compatible with Compose Material, includes MdcTheme
    implementation(Libs.MATERIAL_THEME)

    implementation(Libs.KOIN_ANDROID)

}