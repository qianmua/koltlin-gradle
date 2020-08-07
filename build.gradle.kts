plugins {
    java
    kotlin("jvm") version "1.3.72"
}


group = "pres.qianmua"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven ("https://jitpack.io" )
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jsoup:jsoup:1.12.1")
    implementation("org.springframework:spring-jdbc:5.2.5.RELEASE")
    //implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1'
    implementation("org.jetbrains.kotlinx" , "kotlinx-coroutines-core" , "1.2.1")
    // kafka
    // org.springframework:spring-kafka:2.2.7.RELEASE
    implementation("org.springframework.kafka:spring-kafka:2.2.7.RELEASE")

    //compile group: 'com.alibaba.csp', name: 'sentinel-core', version: '1.7.2'
    // https://mvnrepository.com/artifact/com.alibaba.nacos/nacos-client
    //compile group: 'com.alibaba.nacos', name: 'nacos-client', version: '1.3.1'

    testCompile("junit", "junit", "4.12")

    compile("com.github.shaunxiao" , "kotlinGameEngine" , "v0.0.1")
    
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}