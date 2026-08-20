plugins {
    id("java-library")
}

subprojects {
    apply(plugin = "java-library")
    group = "fr.jessee.worldRouter"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    java {
        toolchain.languageVersion = JavaLanguageVersion.of(25)
    }

    tasks {
        withType().configureEach {
            if (this is JavaCompile) {
                options.encoding = "UTF-8"
            }
        }
    }
}


