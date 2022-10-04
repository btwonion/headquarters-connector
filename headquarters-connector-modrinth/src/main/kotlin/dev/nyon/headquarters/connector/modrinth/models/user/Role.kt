package dev.nyon.headquarters.connector.modrinth.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum of all user roles on Modrinth
 */
@Serializable
enum class Role {
    @SerialName("admin")
    Admin,

    @SerialName("moderator")
    Moderator,

    @SerialName("developer")
    Developer
}