import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion by extra { "1.3.21" }

    repositories {
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

subprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    val compileKotlin: KotlinCompile by tasks
    compileKotlin.kotlinOptions {
        jvmTarget = "1.8"
    }

    val compileTestKotlin: KotlinCompile by tasks
    compileTestKotlin.kotlinOptions {
        jvmTarget = "1.8"
    }

    dependencies {
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")

        "implementation"("ch.qos.logback:logback-classic:1.2.3")

        "testImplementation"("org.jetbrains.kotlin:kotlin-test")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit")
    }
}
