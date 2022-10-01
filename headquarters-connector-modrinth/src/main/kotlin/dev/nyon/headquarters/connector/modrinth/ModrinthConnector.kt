package dev.nyon.headquarters.connector.modrinth

import dev.nyon.headquarters.connector.api.AbstractConnector
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.result.SearchResults
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class ModrinthConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://api.modrinth.com/v2"
) : AbstractConnector() {
    suspend fun searchProjects(
        query: String,
        facets: List<Facet<*>>? = null,
        index: String? = null,
        offset: Int? = null,
        limit: Int? = null,
        filters: String? = null
    ): SearchResults? = request<SearchResults>("/search") {
        parameter("query", query)
        parameter("facets", facets)
        parameter("index", index)
    }

}