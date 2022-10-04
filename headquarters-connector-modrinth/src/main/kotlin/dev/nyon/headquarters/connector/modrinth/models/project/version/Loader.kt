package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The possible loaders of a version
 */
@Serializable
enum class Loader {
    @SerialName("bukkit")
    Bukkit,

    @SerialName("bungeecord")
    BungeeCord,

    @SerialName("fabric")
    Fabric,

    @SerialName("forge")
    Forge,

    @SerialName("liteloader")
    LiteLoader,

    @SerialName("minecraft")
    Minecraft,

    @SerialName("modloader")
    ModLoader,

    @SerialName("paper")
    Paper,

    @SerialName("purpur")
    Purpur,

    @SerialName("quilt")
    Quilt,

    @SerialName("rift")
    Rift,

    @SerialName("spigot")
    Spigot,

    @SerialName("sponge")
    Sponge,

    @SerialName("velocity")
    Velocity,

    @SerialName("waterfall")
    Waterfall
}