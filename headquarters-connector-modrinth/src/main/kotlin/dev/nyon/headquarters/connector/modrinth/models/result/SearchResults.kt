package dev.nyon.headquarters.connector.modrinth.models.result

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(
    val hits: List<ProjectResult>, val offset: Int, val limit: Int, @SerialName("total_hits") val totalHits: Int
)