import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.graalvm.buildtools.native") version "0.9.28"
}

group = "tech.paramount"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// Paketo buildpacks for aarch64
// https://github.com/dashaun/paketo-arm64
if (System.getProperty("os.arch") == "aarch64") {
	tasks.named<BootBuildImage>("bootBuildImage") {
		builder = "dashaun/builder:tiny"
		environment = mapOf(
				"BP_NATIVE_IMAGE" to "true"
		)
	}
}
