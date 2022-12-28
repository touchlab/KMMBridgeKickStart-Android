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
            name = "KMMBridgeKickStart"
            url = uri(TODO("You must add your package url here. For github packages it will look like \"https://maven.pkg.github.com/{YOUR_ORG}/{YOUR_REPO}\""))
            credentials {
                username = TODO("You must add your github username here")
                password = TODO("You must add your github personal access token here")
            }
        }
    }
}
rootProject.name = "KMMBridgeKickStart-Android"
include(":app")
