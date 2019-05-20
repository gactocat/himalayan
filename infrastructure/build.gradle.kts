val ktorVersion = "1.0.0"
val koinVersion = "1.0.1"

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
    implementation(project(":dataaccess"))
    implementation(project(":interface"))
    implementation(project(":usecase"))

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("org.koin:koin-ktor:$koinVersion")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.7")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:2.9.5")
    implementation("ch.qos.logback:logback-classic:1.2.1")
}
