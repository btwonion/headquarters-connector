plugins {
    id("com.github.breadmoirai.github-release")
    `dokka-root-script`
}

allprojects {
    group = "dev.nyon"
    description = "API for making requests to minecraft related http apis"
    version = "1.4.4"
}

tasks {
    register("release") {
        group = "publishing"

        dependsOn("githubRelease")
        dependsOn(":headquarters-connector-core:publish")
        dependsOn(":headquarters-connector-mojang:publish")
        dependsOn(":headquarters-connector-fabric:publish")
        dependsOn(":headquarters-connector-modrinth:publish")
        dependsOn(":headquarters-connector-quilt:publish")
    }
}

githubRelease {
    token(findProperty("github.token")?.toString())

    val split = BuildConstants.githubRepo.split("/")
    overwrite(true)
    owner(split[0])
    repo(split[1])
    releaseName("v${rootProject.version}")
    targetCommitish("master")
    tagName("v${rootProject.version}")
    prerelease(BuildConstants.isSnapshot)
    body("- fix facets for modrinth search")
}