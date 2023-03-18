plugins {
    kotlin("jvm")
    `project-script`
    `dokka-script`
    `project-publish-script`
}

description = "QuiltMC meta api connector"

dependencies {
    implementation(rootProject.project(":${rootProject.name}-core"))
}