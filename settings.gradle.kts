pluginManagement{
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories{
        google()
        mavenCentral()
    }
}

rootProject.name = "ABSA Task"
include(":app")
include(":models")
include(":data")
include(":domain")
