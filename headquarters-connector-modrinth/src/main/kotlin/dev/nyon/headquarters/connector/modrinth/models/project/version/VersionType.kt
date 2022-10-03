package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VersionType {
    @SerialName("release")
    Release,

    @SerialName("alpha")
    Alpha,

    @SerialName("beta")
    Beta
}