package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dependency(
    @SerialName("version_id") val versionID: String?,
    @SerialName("project_id") val projectID: String?,
    @SerialName("file_name") val fileName: String?,
    @SerialName("dependency_type") val dependencyType: DependencyType
)

@Serializable
enum class DependencyType {
    @SerialName("required")
    Required,

    @SerialName("optional")
    Optional,

    @SerialName("incompatible")
    Incompatible,

    @SerialName("embedded")
    Embedded
}