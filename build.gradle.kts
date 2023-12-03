import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
	dependencies {
		classpath("com.google.cloud.tools:jib-layer-filter-extension-gradle:0.3.0")
	}
}

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.google.cloud.tools.jib") version "3.4.0"
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

tasks.register<JavaExec>("extractLayers") {
	workingDir = file("build/libs")
	classpath = tasks.getByName<BootJar>("bootJar").outputs.files
	systemProperties = mapOf("jarmode" to "layertools")
	args("extract")
	dependsOn("bootJar")
}

tasks.named("jibDockerBuild") {
	dependsOn(":extractLayers")
}

tasks.named("jibBuildTar") {
	dependsOn(":extractLayers")
}

tasks.named("jib") {
	dependsOn(":extractLayers")
}

jib {
	from {
		image = "bellsoft/liberica-openjre-alpine:21.0.1-cds"
		platforms {
//			platform {
//				architecture = "amd64"
//				os = "linux"
//			}
			platform {
				architecture = "arm64"
				os = "linux"
			}
		}
	}
	to {
		image = "spring-boot-jib"
	}
	container {
		entrypoint = listOf("java", "org.springframework.boot.loader.launch.JarLauncher")
		workingDirectory = "/app"
	}
	extraDirectories {
		paths {
			path {
				setFrom(file("build/libs/dependencies"))
				into = "/app"
			}
			path {
				setFrom(file("build/libs/spring-boot-loader"))
				into = "/app"
			}
			path {
				setFrom(file("build/libs/application"))
				into = "/app"
			}
		}
	}
	pluginExtensions {
		pluginExtension {
			implementation = "com.google.cloud.tools.jib.gradle.extension.layerfilter.JibLayerFilterExtension"
			configuration(Action<com.google.cloud.tools.jib.gradle.extension.layerfilter.Configuration> {
				filters {
					filter {
						glob = "**/**"
					}
					filter {
						glob = "/app/BOOT-INF/lib/**"
						toLayer = "dependdencies"
					}
					filter {
						glob = "/app/org/**"
						toLayer = "spring-boot-loader"
					}
					filter {
						glob = "/app/BOOT-INF/classes/**"
						toLayer = "application"
					}
					filter {
						glob = "/app/BOOT-INF/**.idx"
						toLayer = "application"
					}
					filter {
						glob = "/app/META-INF/**"
						toLayer = "application"
					}
				}
			})
		}
	}
}
