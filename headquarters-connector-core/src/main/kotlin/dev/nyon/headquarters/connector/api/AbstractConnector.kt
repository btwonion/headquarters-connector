package dev.nyon.headquarters.connector.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

abstract class AbstractConnector {
    abstract val baseUrl: String
    abstract val client: HttpClient
    abstract val json: Json

    suspend inline fun <reified T> request(
        url: String, crossinline builder: HttpRequestBuilder.() -> Unit = {}
    ): T? {
        val statement = client.prepareRequest("$baseUrl$url") {
            method = HttpMethod.Get
            builder()
        }

        val response = statement.execute()
        return if (!response.status.isSuccess()) null else json.decodeFromString(response.bodyAsText())
    }
}