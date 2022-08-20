import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.ajinkyad.flickrelectrolux.android"
        minSdk = 21
        targetSdk = 31
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
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // Integration with activities
    implementation("androidx.activity:activity-compose:1.5.1")
    // Compose Material Design
    implementation("androidx.compose.material:material:1.2.0")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    implementation("androidx.compose.runtime:runtime-livedata:1.2.0")

    // Image Loading Library
    implementation("io.coil-kt:coil-compose:2.2.0")

    // Navigation Library
    implementation("androidx.navigation:navigation-compose:2.5.1")

    // Compatible with Compose Material, includes MdcTheme
    implementation("com.google.android.material:compose-theme-adapter:1.1.16")

    implementation("io.insert-koin:koin-android:3.2.0")

}