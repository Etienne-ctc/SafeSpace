import org.apache.tools.ant.util.JavaEnvUtils.VERSION_1_8

plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.safespace"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.safespace"
        minSdk = 28
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8 // Use JavaVersion type
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.preference:preference:1.2.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.camera:camera-core:1.1.0-beta02")
    implementation("androidx.camera:camera-camera2:1.1.0-beta02")
    implementation("androidx.camera:camera-lifecycle:1.1.0-beta02")
    implementation("androidx.camera:camera-video:1.1.0-beta02")
    implementation("androidx.camera:camera-view:1.1.0-beta02")
    implementation("androidx.camera:camera-extensions:1.1.0-beta02")
    implementation("com.google.mlkit:vision-common:17.1.0")
    implementation("com.google.android.gms:play-services-mlkit-barcode-scanning:18.0.0")
    implementation("com.google.zxing:core:3.5.0")
    implementation("androidx.core:core:1.12.0")
    implementation ("org.postgresql:postgresql:9.4.1212")
    implementation("org.apache.commons:commons-lang3:3.7")
}