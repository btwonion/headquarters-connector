package dev.nyon.headquarters.connector.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * The abstract connector which handles the outgoing http requests
 */
abstract class AbstractConnector {
    /**
     * The url to the target http api
     */
    abstract val baseUrl: String

    /**
     * The [HttpClient] which performs the http requests
     */
    abstract val client: HttpClient

    /**
     * The [Json] to deserialize the requested object
     */
    abstract val json: Json

    /**
     * Performs the http request to the given url
     * @param url the target route
     * @param builder the [HttpRequestBuilder] to add e.g. parameters
     *
     * @return the deserialized version of [T]
     */
    suspend inline fun <reified T> request(
        url: String, useBaseUrl: Boolean = true, crossinline builder: HttpRequestBuilder.() -> Unit = {}
    ): T? {
        val statement = client.prepareRequest(if (useBaseUrl) "$baseUrl$url" else url) {
            method = HttpMethod.Get
            builder()
        }

        val response = statement.execute()
        return if (!response.status.isSuccess()) null else json.decodeFromString(response.bodyAsText())
    }
}