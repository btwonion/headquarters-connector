package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The compatibility state of a project
 */
@Serializable
enum class CompatibilityState {
    @SerialName("required")
    Required,

    @SerialName("optional")
    Optional,

    @SerialName("unsupported")
    Unsupported,

    @SerialName("unknown")
    Unknown
}