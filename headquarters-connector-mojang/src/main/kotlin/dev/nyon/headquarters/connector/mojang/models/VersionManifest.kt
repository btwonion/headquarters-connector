package dev.nyon.headquarters.connector.mojang.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The version manifest of the minecraft launcher
 *
 * @param latest The latest version of minecraft
 * @param versions All versions of minecraft
 */
@Serializable
data class VersionManifest(val latest: LatestVersion, val versions: List<MinecraftVersion>)

/**
 * The latest version of minecraft
 *
 * @param release The latest stable release
 * @param snapshot The latest snapshot release
 */
@Serializable
data class LatestVersion(val release: String, val snapshot: String)

/**
 * The model of a minecraft version
 *
 * @param id The id of the version
 * @param type The release type
 * @param url The package url of the version
 * @param time The time of the version
 * @param releaseTime The release date of the version
 * @param sha1 The identifier of the version
 * @param complianceLevel The compliance level of the version
 */
@Serializable
data class MinecraftVersion(
    val id: String,
    val type: MinecraftVersionType,
    val url: String,
    val time: Instant,
    val releaseTime: Instant,
    val sha1: String,
    val complianceLevel: Int
)

enum class MinecraftVersionType {
    @SerialName("release")
    Release,
    @SerialName("snapshot")
    Snapshot,
    @SerialName("old_alpha")
    OldAlpha,
    @SerialName("old_beta")
    OldBeta
}