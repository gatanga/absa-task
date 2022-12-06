// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id(BuildPlugins.androidApplicationPlugin) version BuildPlugins.androidVersion apply false
    id(BuildPlugins.androidLibraryPlugin) version BuildPlugins.androidVersion apply false
    id(BuildPlugins.androidKotlinPlugin) version kotlinVersion apply false
    id(BuildPlugins.kotlinJvm) version kotlinVersion apply false
    id(BuildPlugins.mainKotlinAndroidExtensions) version kotlinVersion apply false
    id(BuildPlugins.hiltAndroidPlugin) version hiltAndroidVersion apply false
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}