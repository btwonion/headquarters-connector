package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.Project
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.request.Index
import dev.nyon.headquarters.connector.modrinth.models.request.getEnumFieldAnnotation
import dev.nyon.headquarters.connector.modrinth.models.result.DependencyResult
import dev.nyon.headquarters.connector.modrinth.models.result.SearchResults
import io.ktor.client.request.*
import kotlinx.serialization.SerialName

suspend fun ModrinthConnector.searchProjects(
    query: String,
    facets: List<Facet<*>>? = null,
    index: Index? = null,
    offset: Int? = null,
    limit: Int? = null,
    filters: String? = null
): SearchResults? = request<SearchResults>("/search") {
    parameter("query", query)
    parameter("facets", facets?.merge())
    parameter("index", index?.getEnumFieldAnnotation<SerialName>()?.value)
    parameter("offset", offset)
    parameter("limit", limit)
    parameter("filters", filters)
}

suspend fun ModrinthConnector.getProject(query: String) = request<Project>("/project/$query")
suspend fun ModrinthConnector.getProjects(ids: List<String>) =
    request<List<Project>>("/projects") { parameter("ids", ids.joinQuotedStrings()) }

suspend fun ModrinthConnector.getProjectDependencies(query: String) =
    request<DependencyResult>("/project/$query/dependencies")

suspend fun ModrinthConnector.getUsersProjects(query: String) = request<List<Project>>("/user/$query/projects")