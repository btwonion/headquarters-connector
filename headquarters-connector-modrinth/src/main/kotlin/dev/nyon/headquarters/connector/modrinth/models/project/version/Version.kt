package dev.nyon.headquarters.connector.modrinth.models.project.version

import dev.nyon.headquarters.connector.modrinth.models.project.Dependency
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The version model of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/version_model">Modrinth docs</a>
 *
 * @param name The version's name
 * @param versionNumber The version's version number
 * @param changelog The changelog of this version (optional)
 * @param dependencies The dependencies of the version
 * @param gameVersions The supported game versions of this version
 * @param versionType The [VersionType] of this version
 * @param loaders The supported loaders of this version
 * @param featured True if the version is featured by the project
 * @param id The version's id
 * @param projectID The id of the project
 * @param authorID The author's id
 * @param published The publishing date of this version
 * @param downloads The download count of this version
 * @param files The files of the version
 */
@Serializable
data class Version(
    val name: String,
    @SerialName("version_number") val versionNumber: String,
    val changelog: String?,
    val dependencies: List<Dependency>?,
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