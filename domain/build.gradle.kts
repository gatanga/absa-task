plugins {
    id(BuildPlugins.androidLibraryPlugin)
    id(BuildPlugins.androidKotlinPlugin)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.hiltAndroidPlugin)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = AndroidSdk.instrumentationRunnerClassName
        consumerProguardFiles(Proguard.consumerRulesName)
    }

    buildTypes {
        release {
            isMinifyEnabled = Proguard.enableObfuscation
            proguardFiles(
                getDefaultProguardFile(Proguard.proguardAndroidOptimizeName),
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
}

dependencies {

    implementation(AndroidLibs.coreKtx)
    implementation(kotlinLib)
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":models")))
    implementation(InjectionLibs.hiltAndroid)
    kapt(InjectionLibs.hiltAndroidCompiler)
    testImplementation(UnitTestLibs.jUnit5Api)
    testImplementation(UnitTestLibs.androidJUnit)
    androidTestImplementation(UiTestsLibs.espressoCore)
}

kapt {
    correctErrorTypes = true
}