package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

@Serializable
data class DonationPlatform(val id: String, val platform: String, val url: String)