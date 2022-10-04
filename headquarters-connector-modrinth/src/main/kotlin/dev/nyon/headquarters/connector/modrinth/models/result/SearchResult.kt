package dev.nyon.headquarters.connector.modrinth.models.result

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
data class SearchResult(
    val hits: List<ProjectResult>, val offset: Int, val limit: Int, @SerialName("total_hits") val totalHits: Int
)