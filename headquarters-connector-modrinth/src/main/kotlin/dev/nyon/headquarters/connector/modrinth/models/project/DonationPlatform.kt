package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

/**
 * A project's donation platform
 *
 * @param id The id of the donation platform
 * @param platform The donation platform name
 * @param url The url of the donation platform
 */
@Serializable
data class DonationPlatform(val id: String, val platform: String, val url: String)