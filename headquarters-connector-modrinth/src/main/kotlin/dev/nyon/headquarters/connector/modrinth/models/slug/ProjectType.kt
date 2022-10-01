package dev.nyon.headquarters.connector.modrinth.models.slug

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProjectType {
    @SerialName("mod")
    Mod,

    @SerialName("modpack")
    ModPack,

    @SerialName("resourcepack")
    ResourcePack,

    @SerialName("plugin")
    Plugin
}