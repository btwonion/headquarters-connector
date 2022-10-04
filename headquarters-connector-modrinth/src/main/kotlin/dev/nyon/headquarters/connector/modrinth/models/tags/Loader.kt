package dev.nyon.headquarters.connector.modrinth.models.tags

import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A loader of Modrinth
 * @param icon The icon's svg [String] of the loader
 * @param name The name of the loader
 * @param supportedProjectTypes The supported [ProjectType]s of the loader
 */
@Serializable
data class Loader(
    val icon: String,
    val name: String,
    @SerialName("supported_project_types") val supportedProjectTypes: List<ProjectType>
)