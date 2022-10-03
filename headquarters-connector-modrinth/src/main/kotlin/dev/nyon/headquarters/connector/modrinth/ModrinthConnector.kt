package dev.nyon.headquarters.connector.modrinth

import dev.nyon.headquarters.connector.api.AbstractConnector
import io.ktor.client.*
import kotlinx.serialization.json.Json

/**
 * Implementation of [AbstractConnector] to request from the Modrinth V2 http API
 *
 * @param client the [HttpClient] which performs the http requests
 * @param json The [Json] to deserialize the requested object
 * @param baseUrl The base api url of modrinth (default is the V2 API of Modrinth)
 */
class ModrinthConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://api.modrinth.com/v2"
) : AbstractConnector() {

    /**
     * Formats all entries of the [List] to a json string
     *
     * @return the json as [String]
     */
    @JvmName("mergeString")
    fun List<String>.merge() = joinToString("\",\"", "[\"", "\"]")
}