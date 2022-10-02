package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

@Serializable
data class ModeratorMessage(val message: String, val body: String?)