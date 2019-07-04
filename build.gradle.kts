// Plugins
plugins {
    // Gradle core plugins
    java
    application

    // Dependency Management Plugin
    // See: https://plugins.gradle.org/plugin/io.spring.dependency-management
    // todo remove version or use latest
    id("io.spring.dependency-management") version "1.0.6.RELEASE"

    // Plugin for creating fat/uber JARs with support for package relocation.
    // See: https://github.com/johnrengelman/shadow
    // todo remove version or use latest
    id("com.github.johnrengelman.shadow") version "4.0.2"
}