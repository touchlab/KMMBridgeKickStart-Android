pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "KickstartTest"
            url = uri("https://maven.pkg.github.com/samhill303/TestKickStart")
            credentials {
                username = "samhill303"
                password = {My PAT}
            }
        }
    }
}
rootProject.name = "KMMBridgeKickStart-Android"
include(":app")
