import com.adelivery.buildsrc.Libraries

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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

    implementation (project (":domain"))

    implementation(Libraries.Activity.core)
    implementation(Libraries.Activity.appCompat)
    implementation(Libraries.Coroutines.coroutines)
    implementation(Libraries.Hilt.inject)
    implementation(Libraries.Room.room)
    implementation(Libraries.Room.roomKtx)
    kapt(Libraries.Room.roomCompiler)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.gsonConverter)
    implementation(Libraries.Moshi.moshi)
    kapt(Libraries.Moshi.moshiCompiler)
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
}