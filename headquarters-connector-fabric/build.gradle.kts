plugins {
    kotlin("jvm")
    `project-script`
    `dokka-script`
    `project-publish-script`
}

description = "Fabric meta api connector"

dependencies {
    implementation(rootProject.project(":${rootProject.name}-core"))
}