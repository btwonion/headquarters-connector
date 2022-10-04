package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.Serializable

/**
 * A license of a project
 *
 * @param id The id of the license
 * @param name The name of the license
 * @param url The url of the license (optional)
 */
@Serializable
data class License(val id: String, val name: String, val url: String?)