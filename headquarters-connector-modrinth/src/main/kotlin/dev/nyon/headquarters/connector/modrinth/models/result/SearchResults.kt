package dev.nyon.headquarters.connector.modrinth.models.result

import dev.nyon.headquarters.connector.modrinth.models.project.Project
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(
    val hits: List<Project>,
    val offset: Int,
    val limit: Int,
    @SerialName("total_hits")
    val totalHits: Int
)