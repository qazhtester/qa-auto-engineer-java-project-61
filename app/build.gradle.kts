plugins {
    id("application")
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "7.2.0.6526"
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "qazhtester_qa-auto-engineer-java-project-61")
        property("sonar.organization", "qazhtester")
    }
}

tasks.test {
    useJUnitPlatform()
}