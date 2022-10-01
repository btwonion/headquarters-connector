package dev.nyon.headquarters.connector.modrinth.models.slug

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ServerSide {
    @SerialName("required")
    Required,

    @SerialName("optional")
    Optional,

    @SerialName("unsupported")
    Unsupported
}