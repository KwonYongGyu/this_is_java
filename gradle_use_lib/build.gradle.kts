plugins {
    id("java")
}

group = "com.mjc813"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Source: https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.13.1")
    testImplementation("org.assertj:assertj-core:4.0.0-M1")
    testImplementation("org.testng:testng:RELEASE")
}

tasks.test {
    useJUnitPlatform()
}