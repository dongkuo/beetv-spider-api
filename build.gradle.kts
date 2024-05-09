plugins {
    kotlin("jvm") version "1.9.23"
}

dependencies {
    val ktorVersion = "2.3.10"
    implementation("org.jsoup:jsoup:1.16.2")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation(kotlin("reflect"))
    implementation("org.slf4j:slf4j-api:2.0.12")
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.23.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}