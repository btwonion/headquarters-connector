plugins {
    kotlin("jvm")
    `project-script`
    `project-publish-script`
}

description = "Modrinth http api connector"

dependencies {
    implementation(rootProject.project(":${rootProject.name}-core"))
}