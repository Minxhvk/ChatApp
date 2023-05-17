import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"

    kotlin("jvm") version "1.7.22"
    kotlin("plugin.allopen") version "1.6.21"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
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
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // MongoDB
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation ("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation ("org.mongodb:mongodb-driver-sync")
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
