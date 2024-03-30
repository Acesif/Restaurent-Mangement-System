plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "dev.project"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.itextpdf:itextpdf:5.5.13.3")
	implementation("org.apache.pdfbox:pdfbox:3.0.2")
	implementation("io.github.cdimascio:dotenv-java:3.0.0")
	implementation("com.google.guava:guava:33.1.0-jre")
	implementation("com.google.code.gson:gson:2.10.1")
	implementation("com.vaadin.external.google:android-json:0.0.20131108.vaadin1")
	implementation("org.springframework.boot:spring-boot-starter-security:3.2.4")
	implementation("io.jsonwebtoken:jjwt-api:0.12.5")
	implementation("org.springframework.boot:spring-boot-starter-mail:3.2.4")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.2.4")
	implementation("org.apache.commons:commons-lang3:3.14.0")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test:6.2.3")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
