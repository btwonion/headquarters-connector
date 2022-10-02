package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.serialization.Serializable

@Serializable
data class DonationPlatformTag(val short: String, val name: String)