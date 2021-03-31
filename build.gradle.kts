import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.apache.tools.ant.filters.*

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	id("com.gorylenko.gradle-git-properties") version "2.2.4"
}

group = "tw.elliot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus")
	implementation("org.junit.jupiter:junit-jupiter:5.4.2")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

springBoot {
	buildInfo()
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "8"
	}
}


tasks.getByName<BootBuildImage>("bootBuildImage") {
	imageName = "elliot/minispring:latest"
	isVerboseLogging = true
}

val activeProfile=project.properties["activeProfile"] ?: "local"

tasks.processResources {

	logger.error("Got active profile [{}]", activeProfile)
	val filterTokens = mapOf("activeProfile" to activeProfile)
	filter<ReplaceTokens>("tokens" to filterTokens)
	//filter<ReplaceTokens>("activeProfile" to activeProfile)
}