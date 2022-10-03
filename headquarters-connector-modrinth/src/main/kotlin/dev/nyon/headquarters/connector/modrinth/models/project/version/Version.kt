package dev.nyon.headquarters.connector.modrinth.models.project.version

import dev.nyon.headquarters.connector.modrinth.models.project.Dependency
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version(
    val name: String,
    @SerialName("version_number") val versionNumber: String,
    val changelog: String?,
    val dependencies: List<Dependency>,
    @SerialName("game_versions") val gameVersions: List<String>,
    @SerialName("version_type") val versionType: VersionType,
    val loaders: List<Loader>,
    val featured: Boolean,
    val id: String,
    @SerialName("project_id") val projectID: String,
    @SerialName("author_id") val authorID: String,
    @SerialName("date_published") val published: Instant,
    val downloads: Int,
    val files: List<File>
)