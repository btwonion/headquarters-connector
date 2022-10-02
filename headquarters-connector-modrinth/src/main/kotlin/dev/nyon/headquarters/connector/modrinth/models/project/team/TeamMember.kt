package dev.nyon.headquarters.connector.modrinth.models.project.team

import dev.nyon.headquarters.connector.modrinth.models.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamMember(
    @SerialName("team_id") val teamID: String,
    val user: User,
    val role: String,
    val permissions: Int?,
    val accepted: Boolean
)
