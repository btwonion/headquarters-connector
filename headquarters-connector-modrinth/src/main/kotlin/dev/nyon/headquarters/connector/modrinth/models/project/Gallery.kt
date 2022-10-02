package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class GalleryEntry(
    val url: String, val featured: Boolean, val title: String?, val description: String?, val created: Instant
)
