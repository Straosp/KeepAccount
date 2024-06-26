plugins {
	war
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.serialization") version "2.0.0"
}

group = "cn.straosp.keepaccount"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.6")
	implementation("com.mysql:mysql-connector-j:8.4.0")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0")
	implementation("org.apache.shiro:shiro-spring-boot-starter:2.0.1")
	implementation("org.apache.shiro:shiro-spring:2.0.1")
	implementation("javax.servlet:javax.servlet-api:3.1.0")
	//compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
