package dev.nyon.headquarters.connector.modrinth.models.project

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
    val loaders: List<String>,
    val featured: Boolean,
    val id: String,
    @SerialName("project_id") val projectID: String,
    @SerialName("author_id") val authorID: String,
    @SerialName("date_published") val published: Instant,
    val downloads: Int,
    val files: List<File>
)

@Serializable
enum class VersionType {
    @SerialName("release")
    Release,

    @SerialName("alpha")
    Alpha,

    @SerialName("beta")
    Beta
}

@Serializable
data class File(
    val hashes: Hashes,
    val url: String,
    @SerialName("filename") val fileName: String,
    val primary: Boolean,
    val size: Int
)

@Serializable
data class Hashes(val sha512: String, val sha1: String)

@Serializable
enum class HashAlgorithm {
    sha1,
    sha512
}