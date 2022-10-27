package dev.nyon.headquarters.connector.mojang.models.`package`

import dev.nyon.headquarters.connector.mojang.models.MinecraftVersionType
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionPackage(
    val arguments: PackageArguments,
    val assetIndex: AssetIndex,
    val assets: String,
    val complianceLevel: Int,
    val downloads: Downloads,
    val id: String,
    val javaVersion: JavaVersion,
    val libraries: List<Library>,
    val logging: Logging,
    val mainClass: String,
    val minimumLauncherVersion: Int,
    val releaseTime: Instant,
    val time: Instant,
    val type: MinecraftVersionType
)

@Serializable
data class JavaVersion(val component: String, val majorVersion: Int)

@Serializable
data class Library(val downloads: LibraryDownloads, val name: String, val rules: List<LibraryRule>? = null)

@Serializable
data class LibraryRule(val action: RuleAction, val os: OsEntry? = null)

@Serializable
data class OsEntry(val name: Os)

@Serializable
enum class Os {
    @SerialName("osx")
    OsX,

    @SerialName("linux")
    Linux,

    @SerialName("windows")
    Windows
}

@Serializable
data class LibraryDownloads(val artifact: LibraryArtifact, val classifiers: Map<String, LibraryArtifact>? = null)

@Serializable
data class LibraryArtifact(val path: String? = null, val sha1: String, val size: Int, val url: String)

@Serializable
data class Logging(val client: LoggingEntry? = null, val server: LoggingEntry? = null)

@Serializable
data class LoggingEntry(val argument: String, val file: LibraryArtifact, val type: String)