plugins {
    kotlin("jvm")

    id("com.github.breadmoirai.github-release")
    `maven-publish`
    signing
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
    releaseAssets(tasks["build"].outputs.files)
    body("- fix facets for modrinth search")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks {
    register("release") {
        group = "publishing"

        dependsOn("githubRelease")
        dependsOn("publish")
    }
}

publishing {
    repositories {
        maven {
            name = "nyon"
            url = uri("https://repo.nyon.dev/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.nyon"
            artifactId = project.name
            version = rootProject.version.toString()
            from(components["java"])
        }
    }
}

signing {
    sign(publishing.publications)
}