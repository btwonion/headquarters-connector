package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ClientSide {
    @SerialName("required")
    Required,

    @SerialName("optional")
    Optional,

    @SerialName("unsupported")
    Unsupported
}