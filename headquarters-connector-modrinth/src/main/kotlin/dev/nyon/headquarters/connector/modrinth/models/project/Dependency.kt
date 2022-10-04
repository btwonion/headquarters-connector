package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The dependency object of a project
 * @param versionID The version id of the dependency
 * @param projectID The project id of the dependency
 * @param fileName The file name of the dependency
 * @param dependencyType The dependency's type
 */
@Serializable
data class Dependency(
    @SerialName("version_id") val versionID: String?,
    @SerialName("project_id") val projectID: String?,
    @SerialName("file_name") val fileName: String?,
    @SerialName("dependency_type") val dependencyType: DependencyType
)

/**
 * An enum of all dependency types
 */
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