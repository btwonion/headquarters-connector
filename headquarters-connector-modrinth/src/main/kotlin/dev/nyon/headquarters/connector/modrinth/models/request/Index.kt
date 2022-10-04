package dev.nyon.headquarters.connector.modrinth.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum for the sorting/indexing of Modrinth
 */
@Serializable
enum class Index {
    @SerialName("relevance")
    Relevance,

    @SerialName("downloads")
    Downloads,

    @SerialName("follows")
    Follows,

    @SerialName("newest")
    Newest,

    @SerialName("updated")
    Updated
}