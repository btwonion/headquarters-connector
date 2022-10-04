package dev.nyon.headquarters.connector.modrinth.models.tags

import kotlinx.serialization.Serializable

/**
 * A license of Modrinth
 *
 * @param short The short [String] of the license
 * @param name The name of the license
 */
@Serializable
data class LicenseTag(val short: String, val name: String)