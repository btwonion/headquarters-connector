package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The file object of a version
 *
 * @param hashes The [Hashes] of this version file
 * @param url The url of the version file
 * @param fileName The file name of the version file
 * @param primary True if this is the primary version file
 * @param size The size of the version file
 */
@Serializable
data class File(
    val hashes: Hashes,
    val url: String,
    @SerialName("filename") val fileName: String,
    val primary: Boolean,
    val size: Int
)