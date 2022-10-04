package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A game version of Modrinth
 *
 * @param version The version of the game version
 * @param versionType The [VersionType] of the version
 * @param date The date when the version was released
 * @param major True if the version has a major version
 */
@Serializable
data class GameVersion(
    val version: String, @SerialName("version_type") val versionType: VersionType, val date: Instant, val major: Boolean
)

/**
 * A version type of game version
 */
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