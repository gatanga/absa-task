plugins {
    id(BuildPlugins.androidApplicationPlugin)
    id(BuildPlugins.androidKotlinPlugin)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.hiltAndroidPlugin)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = AndroidSdk.instrumentationRunnerClassName
    }

    buildTypes {
        release {
            isMinifyEnabled = Proguard.enableObfuscation
            proguardFiles(
                getDefaultProguardFile(Proguard.textFileName),
                Proguard.ruleFileName
            )
        }
    }
    compileOptions {
        sourceCompatibility = jvmSourceCompatibility
        targetCompatibility = jvmTargetCompatibility
    }
    kotlinOptions {
        jvmTarget = javaTarget
    }
    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(AndroidLibs.coreKtx)
    implementation(AndroidLibs.fragmentKtx)
    implementation(AndroidLibs.appCompat)
    implementation(AndroidLibs.material)
    implementation(AndroidLibs.constraintLayout)
    implementation(AndroidLibs.lifeCycleLiveDataKtx)
    implementation(AndroidLibs.lifeCycleViewModelKtx)
    implementation(kotlinLib)
    implementation(InjectionLibs.hiltAndroid)
    kapt(InjectionLibs.hiltAndroidCompiler)
    implementation(project(mapOf("path" to ":domain")))
    testImplementation(UnitTestLibs.jUnit5Api)
    testImplementation(UnitTestLibs.androidJUnit)
    androidTestImplementation(UiTestsLibs.espressoCore)
}