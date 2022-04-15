import com.adelivery.buildsrc.Libraries

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.adelivery"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
}

dependencies {

    implementation (Libraries.Activity.core)
    implementation (Libraries.Compose.composeUi)
    implementation (Libraries.Compose.composeMaterial)
    implementation (Libraries.Compose.composePreview)
    implementation (Libraries.LifeCycle.runTime)
    implementation (Libraries.Compose.composeActivity)
    debugImplementation(Libraries.Compose.composeUiTooling)
    implementation(Libraries.Hilt.hilt)
    kapt(Libraries.Hilt.hiltCompiler)
    implementation(Libraries.Hilt.hiltCompose)
    implementation(Libraries.Hilt.inject)
    implementation(Libraries.LifeCycle.runTime)
    implementation(Libraries.LifeCycle.liveData)
    implementation(Libraries.LifeCycle.viewModel)
    implementation(Libraries.OkHttp.okhttp)
    implementation(Libraries.OkHttp.okhttpLogging)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.gsonConverter)
    implementation(Libraries.Coroutines.coroutines)
    implementation(Libraries.Coroutines.coroutinesAndroid)
    implementation(Libraries.Moshi.moshiKotlin)
    implementation(Libraries.Room.room)
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${com.adelivery.buildsrc.Versions.compose}")
}