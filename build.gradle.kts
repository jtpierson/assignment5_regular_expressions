plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin test (optional if you're using Kotest exclusively)
    testImplementation(kotlin("test"))

    // Kotest core
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")

    // Kotest assertions
    testImplementation("io.kotest:kotest-assertions-core:5.9.1")

    // Kotest property testing (optional)
    testImplementation("io.kotest:kotest-property:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
