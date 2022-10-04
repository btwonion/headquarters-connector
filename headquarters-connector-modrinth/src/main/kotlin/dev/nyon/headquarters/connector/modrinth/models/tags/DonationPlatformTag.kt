package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.serialization.Serializable

/**
 * A donation platform of Modrinth
 *
 * @param short The short [String] of the platform
 * @param name The name of the platform
 */
@Serializable
data class DonationPlatformTag(val short: String, val name: String)