package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class File(
    val hashes: Hashes,
    val url: String,
    @SerialName("filename") val fileName: String,
    val primary: Boolean,
    val size: Int
)