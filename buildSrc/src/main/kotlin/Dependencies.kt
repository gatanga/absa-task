import org.gradle.api.JavaVersion

const val kotlinVersion = "1.7.20"
const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
const val javaTarget = "1.8"
val jvmSourceCompatibility = JavaVersion.VERSION_1_8
val jvmTargetCompatibility = JavaVersion.VERSION_1_8
const val hiltAndroidVersion = "2.44"

object AndroidSdk {
    const val applicationId = "za.co.absa.absatask"
    const val compileSdkVersion = 33
    const val minSdkVersion = 21
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val instrumentationRunnerClassName = "androidx.test.runner.AndroidJUnitRunner"
    const val useSupportLibraryWithVectorDrawables = true
}

object Proguard {
    const val enableObfuscation = false
    const val textFileName = "proguard-android.txt"
    const val ruleFileName = "proguard-rules.pro"
    const val consumerRulesName = "consumer-rules.pro"
    const val proguardAndroidOptimizeName = "proguard-android-optimize.txt"
}

object BuildPlugins {
    private object Versions {
        const val gradleVersion = "4.0.2"
    }

    const val androidVersion = "7.3.1"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val mainKotlinAndroidExtensions = "org.jetbrains.kotlin.android.extensions"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinAndroid = "kotlin-android"
    const val androidApplicationPlugin = "com.android.application"
    const val androidLibraryPlugin = "com.android.library"
    const val androidKotlinPlugin = "org.jetbrains.kotlin.android"
    const val javaLibrary = "java-library"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val hiltAndroidPlugin = "com.google.dagger.hilt.android"
    const val kapt = "kapt"
}

object AndroidLibs {
    private object Versions {
        const val appCompat = "1.5.1"
        const val constraintLayout = "2.1.4"
        const val recyclerView = "1.2.1"
        const val cardView = "1.0.0"
        const val material = "1.7.0"
        const val coreKtx = "1.9.0"
        const val fragmentKtx = "1.5.4"
        const val lifeCycle = "2.5.1"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val lifeCycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val lifeCycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
}

object InjectionLibs {
    private object Versions {
        const val javax = "1"
    }

    const val javax = "javax.inject:javax.inject:${Versions.javax}"
    const val hiltAndroid = "com.google.dagger:hilt-android:$hiltAndroidVersion"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltAndroidVersion"
}

object CoroutinesLibs {
    private object Versions {
        const val coroutines = "1.6.4"
    }

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object SerializationLibs {
    private object Versions {
        const val kotlinSerialization = "1.4.1"
    }

    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
}

object NetworkLibs {
    private object Versions {
        const val retrofit = "2.9.0"
        const val okhttp = "5.0.0-alpha.10"
        const val loggingInterceptor = "5.0.0-alpha.10"
        const val retrofitKotlinSerializationConverter = "0.8.0"
        const val converterScalars = "2.9.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val ktxRetrofitConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinSerializationConverter}"

    const val converterScalars =
        "com.squareup.retrofit2:converter-scalars:${Versions.converterScalars}"
}

object UnitTestLibs {
    private object Versions {
        const val jUnit5 = "5.9.1"
        const val androidJUnit = "1.1.4"
        const val mockWebServer = "5.0.0-alpha.10"
        const val hiltAndroidTesting = "2.44.2"
        const val mockitoCore = "4.9.0"
        const val mockitoKotlin = "4.1.0"
    }

    const val jUnit5Api = "org.junit.jupiter:junit-jupiter-api:${Versions.jUnit5}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val hiltAndroidTesting =
        "com.google.dagger:hilt-android-testing:${Versions.hiltAndroidTesting}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val mockitoCoreInline = "org.mockito:mockito-inline:${Versions.mockitoCore}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
}

object UiTestsLibs {
    private object Versions {
        const val espressoCore = "3.5.0"
    }

    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}