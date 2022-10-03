package dev.nyon.headquarters.connector.modrinth

import dev.nyon.headquarters.connector.api.AbstractConnector
import dev.nyon.headquarters.connector.modrinth.models.project.HashAlgorithm
import dev.nyon.headquarters.connector.modrinth.models.project.Project
import dev.nyon.headquarters.connector.modrinth.models.project.Version
import dev.nyon.headquarters.connector.modrinth.models.project.team.TeamMember
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.result.DependencyResult
import dev.nyon.headquarters.connector.modrinth.models.result.SearchResults
import dev.nyon.headquarters.connector.modrinth.models.tags.*
import dev.nyon.headquarters.connector.modrinth.models.user.User
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class ModrinthConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://api.modrinth.com/v2"
) : AbstractConnector() {


    // Projects
    suspend fun searchProjects(
        query: String,
        facets: List<Facet<*>>? = null,
        index: String? = null,
        offset: Int? = null,
        limit: Int? = null,
        filters: String? = null
    ): SearchResults? = request<SearchResults>("/search") {
        parameter("query", query)
        parameter("facets", facets?.merge())
        parameter("index", index)
        parameter("offset", offset)
        parameter("limit", limit)
        parameter("filters", filters)
    }

    suspend fun getProject(query: String) = request<Project>("/project/$query")
    suspend fun getProjects(ids: List<String>) =
        request<List<Project>>("/projects") { parameter("ids", ids.joinQuotedStrings()) }

    suspend fun getProjectDependencies(query: String) = request<DependencyResult>("/project/$query/dependencies")

    suspend fun getProjectsOfUser(query: String) = request<List<Project>>("/user/$query/projects")


    // Versions
    suspend fun listVersions(
        query: String, loaders: List<String>? = null, gameVersions: List<String>? = null, featured: Boolean? = null
    ) = request<List<Version>>("/project/$query/version") {
        parameter("loaders", loaders?.joinQuotedStrings())
        parameter("game_versions", gameVersions?.joinQuotedStrings())
        parameter("featured", featured)
    }

    suspend fun getVersion(id: String) = request<Version>("/version/$id")
    suspend fun getVersions(ids: List<String>) =
        request<List<Version>>("/versions") { parameter("ids", ids.joinQuotedStrings()) }

    suspend fun getVersionByHash(hash: String, algorithm: HashAlgorithm = HashAlgorithm.sha1) =
        request<Version>("/version_file/$hash") { parameter("algorithm", algorithm) }

    // Users
    suspend fun getUser(query: String) = request<User>("/user/$query")
    suspend fun getUsers(ids: List<String>) =
        request<List<User>>("/users") { parameter("ids", ids.joinQuotedStrings()) }

    // Teams
    suspend fun getProjectTeamMembers(query: String) = request<List<TeamMember>>("/project/$query/members")
    suspend fun getTeamMembers(id: String) = request<List<TeamMember>>("/team/$id/members")
    suspend fun getTeamMembers(ids: List<String>) =
        request<List<List<TeamMember>>>("/teams") { parameter("ids", ids.joinQuotedStrings()) }

    // Tags
    suspend fun getCategories() = request<List<Category>>("/tag/category")
    suspend fun getLoaders() = request<List<Loader>>("/tag/loader")
    suspend fun getGameVersions() = request<List<GameVersion>>("/tag/game_version")
    suspend fun getLicenses() = request<List<LicenseTag>>("/tag/license")
    suspend fun getDonationPlatforms() = request<List<DonationPlatformTag>>("/tag/donation_platform")
    suspend fun getReportTypes() = request<List<String>>("/tag/report_type")

    private fun List<Facet<*>>.merge(): String =
        joinToString(separator = ",", prefix = "[", postfix = "]") { it.toJsonObject() }

    private fun List<String>.joinQuotedStrings() = joinToString("\", ", "[\"", "\"]")
}