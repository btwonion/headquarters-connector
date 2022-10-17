plugins {
    kotlin("jvm")
    `project-script`
    `dokka-script`
    `project-publish-script`
}

description = "Modrinth http api connector"

dependencies {
    implementation(rootProject.project(":${rootProject.name}-core"))
}