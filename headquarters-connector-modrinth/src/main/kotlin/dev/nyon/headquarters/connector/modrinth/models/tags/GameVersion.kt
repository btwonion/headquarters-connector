package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameVersion(
    val version: String, @SerialName("version_type") val versionType: VersionType, val date: Instant, val major: Boolean
)

@Serializable
enum class VersionType {
    @SerialName("release")
    Release,

    @SerialName("snapshot")
    Snapshot,

    @SerialName("alpha")
    Alpha,

    @SerialName("beta")
    Beta
}