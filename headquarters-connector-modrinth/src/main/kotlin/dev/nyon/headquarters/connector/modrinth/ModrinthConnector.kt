package dev.nyon.headquarters.connector.modrinth

import dev.nyon.headquarters.connector.api.AbstractConnector
import io.ktor.client.*
import kotlinx.serialization.json.Json

class ModrinthConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://api.modrinth.com/v2"
): AbstractConnector() {

    suspend fun

}