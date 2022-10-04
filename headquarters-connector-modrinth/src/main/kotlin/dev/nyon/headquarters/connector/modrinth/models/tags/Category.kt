package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A category of Modrinth
 * @param icon The svg [String] of the category's icon
 * @param name The name of the category
 * @param projectType The projectType of the category
 * @param header The header of the category
 */
@Serializable
data class Category(
    val icon: String, val name: String, @SerialName("project_type") val projectType: String, val header: String
)