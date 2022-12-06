plugins {
    id(BuildPlugins.javaLibrary)
    id(BuildPlugins.kotlinJvm)
}

java {
    sourceCompatibility = jvmSourceCompatibility
    targetCompatibility = jvmTargetCompatibility
}