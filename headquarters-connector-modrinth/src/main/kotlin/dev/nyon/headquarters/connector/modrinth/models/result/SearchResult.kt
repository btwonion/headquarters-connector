package dev.nyon.headquarters.connector.modrinth.models.result

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
sealed interface SearchResult {

    /**
     * The result of a search
     * @see <a href="https://docs.modrinth.com/api-spec/#tag/project_result_model">Modrinth docs</a>
     *
     * @param hits The retrieved projects
     * @param offset The offset
     * @param limit The limit
     * @param totalHits The total hit count
     */
    @Serializable
    data class SearchResultSuccess(
        val hits: List<ProjectResult>, val offset: Int, val limit: Int, @SerialName("total_hits") val totalHits: Int
    ) : SearchResult

    /**
     * The failure result of a search
     *
     * @param error The error
     * @param description The error description
     */
    @Serializable
    data class SearchResultFailure(
        val error: String, val description: String
    ) : SearchResult
}