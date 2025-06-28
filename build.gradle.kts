plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "2.1.21"
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.fakeaccountdetector"
    compileSdk = 36
    buildToolsVersion = "35.0.0"

    defaultConfig {
        applicationId = "com.example.fakeaccountdetector"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10" // ✅ MATCHED with BOM
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}



dependencies {
    // Compose BOM (manages Compose versions)
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Core Compose UI
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose")


    // Compose Tooling (Preview and debugging support)
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-tooling-preview")

    // Material Components (for XML-based UI or interoperability)
    implementation("com.google.android.material:material:1.11.0")

    // Networking with OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
// Unit Testing
     testImplementation("junit:junit:4.13.2")

    // Flexbox Layout (if using in Views-based UI)
    implementation("com.google.android.flexbox:flexbox:3.0.0")
}
