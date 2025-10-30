plugins {
    // 1. PERTAHANKAN: Plugin Android Application dan Kotlin
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // alias(libs.plugins.kotlin.compose) <--- DIHAPUS
}

android {
    namespace = "com.example.utspam"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.utspam"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // buildFeatures { compose = true } <--- DIHAPUS
}

dependencies {
    // 2. PERTAHANKAN: Core Kotlin
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // implementation(libs.androidx.activity.compose) <--- DIHAPUS

    // IMPLEMENTASI VIEWS TRADISIONAL (Wajib)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2") // Untuk Screen 5

    // implementation(platform(libs.androidx.compose.bom)) <--- DIHAPUS
    // implementation(libs.androidx.compose.ui) <--- DIHAPUS
    // implementation(libs.androidx.compose.ui.graphics) <--- DIHAPUS
    // implementation(libs.androidx.compose.ui.tooling.preview) <--- DIHAPUS
    // implementation(libs.androidx.compose.material3) <--- DIHAPUS

    // Dependensi lama yang sudah benar
    implementation(libs.androidx.appcompat) // sudah didefinisikan di atas
    implementation(libs.material) // sudah didefinisikan di atas
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout) // sudah didefinisikan di atas

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dependensi Test Compose <--- DIHAPUS
    // androidTestImplementation(platform(libs.androidx.compose.bom))
    // androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    // debugImplementation(libs.androidx.compose.ui.tooling)
    // debugImplementation(libs.androidx.compose.ui.test.manifest)
}