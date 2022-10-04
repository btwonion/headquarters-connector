package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

/**
 * A moderator message of a project
 * @param message The message of the moderator message
 * @param body The body of the moderator message (optional)
 */
@Serializable
data class ModeratorMessage(val message: String, val body: String?)