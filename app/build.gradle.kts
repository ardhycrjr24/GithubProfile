import java.util.Properties

// 🔥 LOAD apikey.properties
val apikeyProperties = Properties()
val apikeyPropertiesFile = rootProject.file("apikey.properties")

if (apikeyPropertiesFile.exists()) {
    apikeyProperties.load(apikeyPropertiesFile.inputStream())
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "id.ac.smpn8bks.ardiansyah.githubprofile"
    compileSdk = 36

    defaultConfig {
        applicationId = "id.ac.smpn8bks.ardiansyah.githubprofile"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // 🔥 AMBIL TOKEN DARI apikey.properties
        buildConfigField(
            "String",
            "GITHUB_TOKEN",
            "\"${apikeyProperties.getProperty("GITHUB_TOKEN")}\""
        )
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

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    // Core Android
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.androidx.activity)

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Lottie (Splash Screen Animation)
    implementation("com.airbnb.android:lottie:5.2.0")

    // Circle Image
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Glide (Image from URL)
    implementation("com.github.bumptech.glide:glide:4.13.2")
    kapt("com.github.bumptech.glide:compiler:4.13.0")

    // Retrofit (API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Logging API
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")
}