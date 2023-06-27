import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"

    kotlin("jvm") version "1.7.22"
    kotlin("plugin.allopen") version "1.6.21"
    kotlin("plugin.noarg") version "1.3.71"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
}

allOpen {
    annotation("javax.persistence.Entity")
}

noArg {
    annotation("javax.persistence.Entity")
}

group = "chat"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("au.com.console:kassava:2.1.0-rc.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.6.0")

    // MongoDB
    //implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation ("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation ("org.mongodb:mongodb-driver-sync")

    // JWT
    implementation ("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-jackson:0.11.2")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Query DSL
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation ("javax.validation:validation-api:2.0.1.Final")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    kapt("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
