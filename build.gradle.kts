// 1. Plugins
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

// 2. Plugin Configurations

// 2a. Java plugin configuration via extension function
java {
    sourceCompatibility = JavaVersion.VERSION_12
    targetCompatibility = JavaVersion.VERSION_12
}

// 2b. Project dependencies
dependencies {
    // Per the documentation, ensure the Lombok processor runs before the Micronaut processor
    // See: https://docs.micronaut.io/latest/guide/index.html#java

    // 1. Java Common Annotations
    compile("javax.annotation:javax.annotation-api")

    // 2. Lombok
    // See: https://github.com/rzwitserloot/lombok
    annotationProcessor("org.projectlombok:lombok:1.18.8")
    compileOnly("org.projectlombok:lombok:1.18.8")

    // 3. Micronaut
    // todo 3a. documentation
    annotationProcessor("io.micronaut:micronaut-inject-java")
    annotationProcessor("io.micronaut:micronaut-validation")
    annotationProcessor("io.micronaut:micronaut-validation")
    compile("io.micronaut:micronaut-inject")
    compile("io.micronaut:micronaut-validation")
    compile("io.micronaut:micronaut-runtime")
    compile("io.micronaut:micronaut-http-client")
    compile("io.micronaut:micronaut-http-server-netty")
    compile("io.micronaut.configuration:micronaut-hibernate-jpa")
    compile("io.micronaut.configuration:micronaut-jdbc-hikari")

    // 3b. Testing with JUnit 5
    // See: https://micronaut-projects.github.io/micronaut-test/latest/guide/index.html#junit5
    testAnnotationProcessor("io.micronaut:micronaut-inject-java")
    testCompile("io.micronaut.test:micronaut-test-junit5")

    // 4. JUnit
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")

    // 5. PostgreSQL
    runtime("org.postgresql:postgresql:42.2.4")

    // 6. Log4J2
    compile("org.apache.logging.log4j:log4j-api:2.11.2")
    compile("org.apache.logging.log4j:log4j-core:2.11.2")

    // todo resolve or include explanation for including this
    compile("org.slf4j:slf4j-nop:1.7.25")
}