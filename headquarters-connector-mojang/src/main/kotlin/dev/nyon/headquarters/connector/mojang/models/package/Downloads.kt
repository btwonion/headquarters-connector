package dev.nyon.headquarters.connector.mojang.models.`package`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Downloads(
    val client: DownloadEntry,
    @SerialName("client_mappings") val clientMappings: DownloadEntry,
    val server: DownloadEntry,
    @SerialName("server_mappings") val serverMappings: DownloadEntry
)

@Serializable
data class DownloadEntry(val sha1: String, val size: Int, val url: String)