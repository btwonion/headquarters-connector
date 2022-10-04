package dev.nyon.headquarters.connector.modrinth.models.result

import dev.nyon.headquarters.connector.modrinth.models.project.Project
import dev.nyon.headquarters.connector.modrinth.models.project.version.Version
import kotlinx.serialization.Serializable

/**
 * The result of a dependency search
 *
 * @param projects The [Project]s
 * @param versions The [Version]s
 */
@Serializable
data class DependencyResult(
    val projects: List<Project>,
    val versions: List<Version>
)