plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runMain"){
    mainClass.set("org.example.Main")
    classpath = sourceSets.getByName("main").runtimeClasspath
}

tasks.register<JavaExec>("runSpringBoot") {
    mainClass.set("org.example.SpringBoot") // 设置主类的完整类名
    classpath = sourceSets.main.get().runtimeClasspath // 设置类路径为项目的 main 源集的运行时类路径
}

tasks.named("bootRun") {
    doFirst {
        System.setProperty("spring.profiles.active", "development")
    }
}
