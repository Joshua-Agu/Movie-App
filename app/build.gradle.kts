plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android) version "1.9.0"
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
android {
    namespace = "com.example.jhoehub"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jhoehub"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Networking and image loading
    implementation(libs.coil)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.picasso)
    implementation(libs.glide)

    // Coroutines and lifecycle
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // ViewPager2
    implementation(libs.androidx.viewpager2)
    implementation(libs.common)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.material3.desktop)
    implementation(libs.androidx.material3.jvmstubs)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)
    implementation(libs.androidx.room.runtime)

    implementation(libs.hilt.android.v248)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.ohkttp)
    implementation(libs.logging.interceptor)

    implementation(libs.coil.compose)

    implementation(libs.androidx.recyclerview)

    implementation(libs.androidx.material.icons.extended)

    implementation(libs.accompanist.systemicontroller)
    implementation(libs.gson)
    implementation(libs.okhttp3.logging.interceptor)
}
}
