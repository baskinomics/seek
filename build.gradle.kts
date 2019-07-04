// 1. Plugins
plugins {

    // 1a. Gradle core plugins
    java
    application

    // 1b. Dependency Management Plugin
    // See: https://plugins.gradle.org/plugin/io.spring.dependency-management
    // todo remove version or use latest
    id("io.spring.dependency-management") version "1.0.6.RELEASE"

    // 1c. Plugin for creating fat/uber JARs with support for package relocation.
    // See: https://github.com/johnrengelman/shadow
    // todo remove version or use latest
    id("com.github.johnrengelman.shadow") version "4.0.2"

    // 1d. Lombok Plugin
    //id("io.freefair.lombok") version "3.7.5"
}

// 2. Plugin Configurations
// 2a. Application Plugin Configuration
application {
    mainClassName = "seek.Application"
    group = "seek"
    version = "0.0.2-SNAPSHOT"
}

// 2b. Repository Configuration
repositories {

    // Adds a repository which looks in the Maven central repository for dependencies.
    mavenCentral()

    // Define custom Maven repository
    // See: https://docs.gradle.org/current/userguide/repository_types.html#sub:maven_repo
    // todo Is this necessary with Maven Central already defined?
    maven {
        url = uri("https://jcenter.bintray.com")
    }
}

// 2c. Java plugin configuration via extension function
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

// 2d. todo documentation
dependencyManagement {
    imports {
        mavenBom("io.micronaut:micronaut-bom:1.1.3")
    }
}

configurations {

}

// 2e. Project dependencies
dependencies {

    // Per the documentation, ensure the Lombok processor runs before the Micronaut processor
    // See: https://docs.micronaut.io/latest/guide/index.html#java

    // Java Common Annotations
    compile("javax.annotation:javax.annotation-api")

    // Lombok
    // See: https://github.com/rzwitserloot/lombok
    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")

    // Micronaut
    // todo documentation
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

    // Testing with JUnit 5
    // See: https://micronaut-projects.github.io/micronaut-test/latest/guide/index.html#junit5
    testAnnotationProcessor("io.micronaut:micronaut-inject-java")
    testCompile("io.micronaut.test:micronaut-test-junit5")

    // JUnit
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")

    // PostgreSQL
    runtime("org.postgresql:postgresql:42.2.4")

    // Log4J2
    compile("org.apache.logging.log4j:log4j-api:2.11.2")
    compile("org.apache.logging.log4j:log4j-core:2.11.2")

    // todo resolve or include explanation for including this
    compile("org.slf4j:slf4j-nop:1.7.25")

    // Mockito
}

// 3. Task configuration
// See:
//  * https://docs.gradle.org/current/userguide/application_plugin.html#sec:application_tasks
//  *
tasks {

    // 3a. `test` task configuration
    // See: https://micronaut-projects.github.io/micronaut-test/latest/guide/index.html#junit5
    test {
        useJUnitPlatform()
    }

    // 3b. `shadowJar` task configuration
    shadowJar {
        mergeServiceFiles()
    }

    // 3c. Java Plugin - `compileJava` task configuration
    compileJava {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }

    // 3d. Java Plugin - `run` task configuration
    // See: https://stackoverflow.com/questions/53118756/gradle-kotlin-dsl-equivalent-for-groovy-dsl-run
    // todo Find in official documentation
    (run) {
        // todo run.classpath += configurations.developmentOnly
        // classpath()

        // Set the JVM arguments
        jvmArgs("-noverify", "-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
    }

    // 3e. Java Plugin - `test` task configuration
}
