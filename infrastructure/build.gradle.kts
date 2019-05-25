val ktorVersion = "1.2.0"
val koinVersion = "1.0.2"
val jacksonVersion = "2.9.9"

plugins {
    application
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(project(":use-case"))
    implementation(project(":data-access"))
    implementation(project(":interface"))

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("org.koin:koin-ktor:$koinVersion")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:$jacksonVersion")

    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("io.mockk:mockk:1.8.10.kotlin13")
}
