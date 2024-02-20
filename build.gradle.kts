plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.protobuf") version "0.8.17"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//protobuf {
//    // 配置 Protocol Buffers 插件的选项
//    protoc {
//        // 可选：指定 Protocol Buffers 编译器的路径，如果不设置会使用默认的
//        path = "/path/to/protoc"
//    }
//    generateProtoTasks {
//        all().forEach { task ->
//            // 可选：配置生成的代码的输出路径
//            // task.outputSubDir = "generated"
//        }
//    }
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.google.protobuf:protobuf-java:3.21.0")
    implementation("javax.websocket:javax.websocket-api:1.1")
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
