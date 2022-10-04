package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The project types of Modrinth
 */
@Serializable
enum class ProjectType {
    @SerialName("mod")
    Mod,

    @SerialName("modpack")
    ModPack,

    @SerialName("resourcepack")
    ResourcePack
}