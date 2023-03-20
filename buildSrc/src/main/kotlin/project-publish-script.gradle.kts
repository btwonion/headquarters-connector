plugins {
    kotlin("jvm")

    `maven-publish`
    signing
}

java {
    withSourcesJar()
    withJavadocJar()
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