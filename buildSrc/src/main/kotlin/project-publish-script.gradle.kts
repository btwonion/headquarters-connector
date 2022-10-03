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
    releaseName("v${BuildConstants.version}")
    targetCommitish("master")
    tagName("v${BuildConstants.version}")
    prerelease(BuildConstants.isSnapshot)
    releaseAssets(tasks["build"].outputs.files)
    body("inital release")
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
            name = "ossrh"
            credentials(PasswordCredentials::class)
            setUrl(
                if (!BuildConstants.isSnapshot) "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
                else "https://s01.oss.sonatype.org/content/repositories/snapshots"
            )
        }
    }

    publications {
        register<MavenPublication>(project.name) {
            from(components["java"])

            this.groupId = project.group.toString()
            this.artifactId = project.name
            this.version = rootProject.version.toString()

            pom {
                name.set(project.name)
                description.set(project.description)

                developers {
                    BuildConstants.authors.forEach {
                        developer {
                            name.set(it)
                        }
                    }
                }

                licenses {
                    license {
                        name.set("GNU General Public License 3")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
                    }
                }

                url.set("https://github.com/${BuildConstants.githubRepo}")

                scm {
                    connection.set("scm:git:git://github.com/${BuildConstants.githubRepo}.git")
                    url.set("https://github.com/${BuildConstants.githubRepo}/tree/main")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}