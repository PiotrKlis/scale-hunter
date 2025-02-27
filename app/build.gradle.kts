import org.gradle.internal.impldep.bsh.commands.dir

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "com.pkmobileapps.scalehunter"
  compileSdk = 35
  defaultConfig {
    applicationId = "com.pkmobileapps.scalehunter"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    buildFeatures {
      compose = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.lifecycle.livedata.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.navigation.fragment.ktx)
  implementation(libs.androidx.navigation.ui.ktx)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.compose.ui.test.junit4)
  implementation(libs.androidx.compose.ui.test.manifest)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)
  implementation(libs.androidx.compose.runtime.livedata)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.squareup.okhttp3)
  implementation(libs.squareup.retrofit2)
  implementation(libs.squareup.retrofit2.converter.gson)
  implementation(fileTree("libs") { include("shazamkit-android-release.aar") })
  implementation("com.google.accompanist:accompanist-permissions:0.32.0")
  testImplementation(libs.junit)
}