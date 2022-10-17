package dev.nyon.headquarters.connector.mojang

import dev.nyon.headquarters.connector.api.AbstractConnector
import dev.nyon.headquarters.connector.mojang.models.VersionManifest
import dev.nyon.headquarters.connector.mojang.models.`package`.VersionPackage
import io.ktor.client.*
import kotlinx.serialization.json.Json

/**
 * Implementation of [AbstractConnector] to request from the Mojang V1 launcher http API
 *
 * @param client the [HttpClient] which performs the http requests
 * @param json The [Json] to deserialize the requested object
 * @param baseUrl The base api url of modrinth (default is the V2 API of Modrinth)
 */
class MojangConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://launchermeta.mojang.com"
) : AbstractConnector() {

    /**
     * Requests the launcher version manifest
     */
    suspend fun getVersionManifest() = request<VersionManifest>("/mc/game/version_manifest_v2.json")

    suspend fun getVersionPackage(version: String): VersionPackage? {
        val url = getVersionManifest()?.versions?.find { it.id == version }?.url ?: return null
        return request<VersionPackage>(url, false)
    }
}