import BuildConstants.githubRepo
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import java.net.URL

plugins {
    id("org.jetbrains.dokka")
}

tasks {
    val processDokkaMarkdown = register<Copy>("processDokkaMarkdown") {
        from(layout.projectDirectory.dir("docs"))
        into(layout.buildDirectory.dir("docs-markdown"))

        val properties = linkedMapOf(
            "dependencyNotice" to """
                ### Dependency
                ```kt
                implementation("dev.nyon:${project.name}:${BuildConstants.version}")
                ```
            """.trimIndent()
        )

        inputs.properties(properties)
        expand(properties)
    }

    withType<DokkaTaskPartial> {
        dependsOn(processDokkaMarkdown)

        dokkaSourceSets {
            configureEach {
                includes.from(
                    buildDir.resolve("docs-markdown").listFiles()!!
                        .sortedBy { if (it.name == "Module.md") "0" else it.name }
                        .map { "build/docs-markdown/${it.name}" }
                        .toTypedArray()
                )

                sourceLink {
                    localDirectory.set(file("src/main/kotlin"))
                    remoteUrl.set(
                        URL(
                            "https://github.com/$githubRepo/tree/master/${project.name}/src/main/kotlin"
                        )
                    )
                    remoteLineSuffix.set("#L")
                }

                listOf("internal", "mixin").forEach {
                    perPackageOption {
                        matchingRegex.set(""".*\.$it.*""")
                        suppress.set(true)
                    }
                }
            }
        }
    }
}