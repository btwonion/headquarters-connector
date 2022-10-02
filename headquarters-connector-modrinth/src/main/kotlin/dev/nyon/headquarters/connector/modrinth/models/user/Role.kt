package dev.nyon.headquarters.connector.modrinth.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Role {
    @SerialName("admin")
    Admin,

    @SerialName("moderator")
    Moderator,

    @SerialName("developer")
    Developer
}