@file:Suppress("UnstableApiUsage")

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.hiltPlugin)
    id(BuildPlugins.googleServices)
    id("com.google.firebase.crashlytics")
    id("kotlin-kapt")
    kotlin("kapt")
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        applicationId = "com.mumbicodes.projectie"
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.mumbicodes.projectie"
}

dependencies {

    implementation(Libraries.ktxCore)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeFoundation)
    implementation(Libraries.composeMaterial3)
    implementation(Libraries.composeMaterial3Window)
    implementation(Libraries.composeTooling)
    implementation(Libraries.activityCompose)
    implementation(Libraries.constraintLayoutCompose)
    implementation(Libraries.composeMaterial2)
    implementation(Libraries.materialWindowClassSize)
    implementation(Libraries.composeCompiler)

    // Lifecycle
    implementation(Libraries.lifecycle)
    implementation(Libraries.lifecycleViewModel)

    // Room
    implementation(Libraries.roomRuntime)
    implementation("androidx.window:window:1.1.0")
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomKtx)

    // Coroutines
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)

    // Navigation
    implementation(Libraries.navigationCompose)

    // DI - Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompilerAndroid)
    kapt(Libraries.hiltCompiler)
    implementation(Libraries.hiltNavigation)
    implementation(Libraries.hiltWork)

    // Moshi
    implementation(Libraries.moshi)
    implementation(Libraries.moshiConverter)

    // Enable support for DateFormatter language APIs on any version of the Android platform
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")

    // Compose Calendar
    implementation("com.squaredem:composecalendar:1.1.0")

    // Datastore
    implementation(Libraries.dataStore)

    // Pager and indicators
    implementation(Libraries.pager)
    implementation(Libraries.pagerIndicators)

    // SplashScreen
    implementation(Libraries.splashScreen)

    // Firebase
    implementation(platform(Libraries.firebaseBom))
    implementation(Libraries.firebaseAnalytics)
    implementation(Libraries.firebaseCrashlytics)
    implementation(Libraries.firebasePerformance)
    implementation(Libraries.firebaseMessaging)

    // WorkManager
    implementation(Libraries.workManager)

    // Accompanist permissions
    implementation(Libraries.accompanistPermissions)

    // Livedata
    implementation(Libraries.livedata)

    // Unit tests
    testImplementation(TestLibraries.junit4)

    // Android Tests
    androidTestImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.composeJunit4)

    debugImplementation(TestLibraries.composeTooling)
    debugImplementation(TestLibraries.composeManifest)
    debugImplementation(Libraries.leakCanary)
}
