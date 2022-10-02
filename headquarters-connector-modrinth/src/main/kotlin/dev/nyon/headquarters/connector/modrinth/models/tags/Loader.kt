package dev.nyon.headquarters.connector.modrinth.models.tags

import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Loader(val icon: String, val name: String, @SerialName("supported_project_types") val supportedProjectTypes: List<ProjectType>)