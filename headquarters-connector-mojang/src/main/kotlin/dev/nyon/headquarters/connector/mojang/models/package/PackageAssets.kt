package dev.nyon.headquarters.connector.mojang.models.`package`

import kotlinx.serialization.Serializable

@Serializable
data class AssetIndex(
    val id: String, val sha1: String, val size: Int, val totalSize: Int, val url: String
)