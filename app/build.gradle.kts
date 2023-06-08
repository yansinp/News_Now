plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.plugin.parcelize")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.yansin.myapplication"
    compileSdk = 33

    defaultConfig {
        applicationId ="com.yansin.myapplication"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions.jvmTarget = "17"

    buildFeatures.compose = true

    composeOptions.kotlinCompilerExtensionVersion = "1.4.7"

    packagingOptions.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

dependencies {


    // Project Core
    implementation( "androidx.core:core-ktx:1.10.1")
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation( "androidx.activity:activity-compose:1.7.2")
    implementation( "androidx.core:core-splashscreen:1.0.1")

    // Compose Core
    implementation( "androidx.compose.ui:ui:1.4.3")
    implementation( "androidx.compose.ui:ui-tooling-preview:1.4.3")

    // Lifecycle + ViewModel & LiveData
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Activity KTX for viewModels()
    implementation( "androidx.activity:activity-ktx:1.7.2")

    // Coroutines
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // HiltViewModel
    implementation( "androidx.hilt:hilt-navigation-compose:1.0.0")

    // Material 3
    implementation( "androidx.compose.material3:material3:1.2.0-alpha02")

    // Material
    implementation( "androidx.compose.material:material:1.4.3")

    // Testing
    testImplementation( "junit:junit:4.13.2")
    androidTestImplementation( "androidx.test.ext:junit:1.1.5")
    androidTestImplementation( "androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation( "androidx.compose.ui:ui-test-junit4:1.4.3")

    debugImplementation( "androidx.compose.ui:ui-tooling:1.4.3")
    debugImplementation( "androidx.compose.ui:ui-test-manifest:1.4.3")

    // Compose Navigation
    implementation( "androidx.navigation:navigation-compose:2.5.3")

    // Coil
    implementation( "io.coil-kt:coil-compose:2.2.2")
    implementation( "io.coil-kt:coil-gif:2.2.2")
    implementation( "io.coil-kt:coil-svg:2.2.2")

    // Glide
    implementation( "com.github.bumptech.glide:glide:4.14.2")

    // Retrofit
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")
    implementation( "com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation( "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")

    //sandwich
    implementation( "com.github.skydoves:sandwich:1.3.7")

    // Dagger Hilt
    implementation( "com.google.dagger:hilt-android:2.44.2")
    kapt( "com.google.dagger:hilt-android-compiler:2.44.2")

    // Moshi
    implementation( "com.squareup.moshi:moshi:1.14.0")
    kapt( "com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    //Gson
    implementation( "com.google.code.gson:gson:2.10")
}