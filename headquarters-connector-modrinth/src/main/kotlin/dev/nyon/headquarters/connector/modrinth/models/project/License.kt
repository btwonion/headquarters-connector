package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

@Serializable
data class License(val id: String, val name: String, val url: String?)