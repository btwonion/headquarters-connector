package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.Project
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.request.Index
import dev.nyon.headquarters.connector.modrinth.models.request.getEnumFieldAnnotation
import dev.nyon.headquarters.connector.modrinth.models.request.merge
import dev.nyon.headquarters.connector.modrinth.models.result.DependencyResult
import dev.nyon.headquarters.connector.modrinth.models.result.SearchResult
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.decodeFromString

/**
 * Searches for projects with the given settings
 * Full documentation:
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/projects/operation/searchProjects">Modrinth docs</a>
 *
 * @param query The query to look for
 * @param facets The recommended way of filtering search results
 * @param index The order of the results
 * @param offset The offset of the search
 * @param limit The limit of results
 * @param filters The filters of the search (should only be used if there is no facet for your need)
 *
 * @return The [SearchResult] for the search
 */
suspend fun ModrinthConnector.searchProjects(
    query: String,
    facets: List<Facet<*>>? = null,
    index: Index? = null,
    offset: Int? = null,
    limit: Int? = null,
    filters: String? = null
): SearchResult {
    val statement = client.prepareRequest("$baseUrl/search") {
        method = HttpMethod.Get
        parameter("query", query)
        parameter("facets", facets?.merge())
        parameter("index", index?.getEnumFieldAnnotation<SerialName>()?.value)
        parameter("offset", offset)
        parameter("limit", limit)
        parameter("filters", filters)
    }

    val response = statement.execute()
    return if (!response.status.isSuccess()) json.decodeFromString<SearchResult.SearchResultFailure>(response.bodyAsText()) else json.decodeFromString<SearchResult.SearchResultSuccess>(
        response.bodyAsText()
    )
}

/**
 * Gets the project of the id/slug
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/projects/operation/getProject">Modrinth docs</a>
 *
 * @param query The project's id or slug of the project
 *
 * @return The requested [Project]
 */
suspend fun ModrinthConnector.getProject(query: String) = request<Project>("/project/$query")

/**
 * Gets the projects of the ids
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/projects/operation/getProjects">Modrinth docs</a>
 *
 * @param ids The ids of the requested projects
 *
 * @return A [List] of [Project]
 */
suspend fun ModrinthConnector.getProjects(ids: List<String>) =
    request<List<Project>>("/projects") { parameter("ids", ids.merge()) }

/**
 * Gets the dependencies of the project
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/projects/operation/getDependencies">Modrinth docs</a>
 *
 * @param query The id/slug of the project
 *
 * @return The [DependencyResult] of the request
 */
suspend fun ModrinthConnector.getProjectDependencies(query: String) =
    request<DependencyResult>("/project/$query/dependencies")

/**
 * Gets all projects of the user
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/users/operation/getUserProjects">Modrinth docs</a>
 *
 * @param query The id/name of the user
 *
 * @return A [List] of [Project]
 */
suspend fun ModrinthConnector.getUsersProjects(query: String) = request<List<Project>>("/user/$query/projects")