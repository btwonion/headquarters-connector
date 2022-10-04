package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * A gallery entry of the gallery of a project
 * @param url The url of the entry
 * @param featured If the gallery entry is featured
 * @param title The title of the gallery entry (optional)
 * @param description The description of the gallery entry (optional)
 * @param created The creation date of the gallery entry
 */
@Serializable
data class GalleryEntry(
    val url: String, val featured: Boolean, val title: String?, val description: String?, val created: Instant
)
