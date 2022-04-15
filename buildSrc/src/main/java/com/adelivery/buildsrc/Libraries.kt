package com.adelivery.buildsrc

object Libraries {

    object Compose {
        const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeUiUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.activity}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    }

    object Activity{
        const val material = "com.google.android.material:material:1.4.0"
        const val core = "androidx.core:core:${Versions.core}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
        const val activity = "androidx.activity:activity:${Versions.activity}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    }

    object LifeCycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
        const val inject = "javax.inject:javax.inject:1"
    }

    object Coroutines {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Moshi{
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}"
    }

}