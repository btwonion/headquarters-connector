package dev.nyon.headquarters.connector.modrinth.models.result

import dev.nyon.headquarters.connector.modrinth.models.project.Project
import dev.nyon.headquarters.connector.modrinth.models.project.Version
import kotlinx.serialization.Serializable

@Serializable
data class DependencyResult(
    val projects: List<Project>,
    val versions: List<Version>
)
