package dev.nyon.headquarters.connector.modrinth.models.project.team

import dev.nyon.headquarters.connector.modrinth.models.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The team member model of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/team_member_model">Modrinth docs</a>
 *
 * @param teamID The id of the team
 * @param user The user object of the team member
 * @param role The role of the team member in the team
 * @param permissions The permissions of the player (optional)
 * @param accepted True if the team member is accepted in the team
 */
@Serializable
data class TeamMember(
    @SerialName("team_id") val teamID: String,
    val user: User,
    val role: String,
    val permissions: Int?,
    val accepted: Boolean
)
