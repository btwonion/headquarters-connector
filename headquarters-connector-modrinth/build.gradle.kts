plugins {
    kotlin("jvm")
    `project-script`
    `dokka-script`
    `project-publish-script`
}

description = "Modrinth http api connector"

dependencies {
    implementation(rootProject.project(":${rootProject.name}-core"))

    val kotestVersion = "5.5.0"
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}