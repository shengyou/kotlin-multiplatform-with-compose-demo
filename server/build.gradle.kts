import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "io.kraftsman"
version = "0.0.1"

dependencies {
    implementation(project(":shared"))

    implementation("io.ktor:ktor-server-core-jvm:2.1.2")
    implementation("io.ktor:ktor-server-netty-jvm:2.1.2")
    implementation("io.ktor:ktor-server-content-negotiation:2.1.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.2")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("ch.qos.logback:logback-classic:1.4.3")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-tests-jvm:2.1.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.7.10")
}

application {
    mainClass.set("io.kraftsman.server.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
