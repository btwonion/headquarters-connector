package dev.nyon.headquarters.connector.fabric

import dev.nyon.headquarters.connector.api.AbstractConnector
import io.ktor.client.*
import kotlinx.serialization.json.Json

/**
 * Implementation of [AbstractConnector] to request from the Fabricmc-meta V2 http API
 *
 * @param client the [HttpClient] which performs the http requests
 * @param json The [Json] to deserialize the requested object
 * @param baseUrl The base api url of fabricmc meta api (default is the V2 API of Fabricmc)
 */
class FabricConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://meta.fabricmc.net/v2"
) : AbstractConnector() {

        

}