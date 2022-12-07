plugins {
    id(BuildPlugins.androidLibraryPlugin)
    id(BuildPlugins.androidKotlinPlugin)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.hiltAndroidPlugin)
    id(BuildPlugins.androidJUnit5) version "1.8.2.1"
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
            resValue("string", "API_URL", "http://numbersapi.com/")
        }
        debug {
            resValue("string", "API_URL", "http://numbersapi.com/")
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

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(AndroidLibs.coreKtx)
    implementation(kotlinLib)
    implementation(project(mapOf("path" to ":models")))
    implementation(InjectionLibs.hiltAndroid)
    kapt(InjectionLibs.hiltAndroidCompiler)
    implementation(NetworkLibs.retrofit)
    implementation(NetworkLibs.okhttp)
    implementation(NetworkLibs.ktxRetrofitConverter)
    implementation(NetworkLibs.converterScalars)
    implementation(NetworkLibs.loggingInterceptor)
    implementation(SerializationLibs.kotlinSerialization)
    testImplementation(UnitTestLibs.jUnit5Api)
    testImplementation(UnitTestLibs.jUnit5Params)
    testRuntimeOnly(UnitTestLibs.jUnit5Engine)
    testImplementation(UnitTestLibs.androidJUnit)
    testImplementation(UnitTestLibs.mockitoCore)
    testImplementation(UnitTestLibs.mockitoCoreInline)
    testImplementation(UnitTestLibs.mockitoKotlin)
    androidTestImplementation(UiTestsLibs.espressoCore)
}
kapt {
    correctErrorTypes = true
}

