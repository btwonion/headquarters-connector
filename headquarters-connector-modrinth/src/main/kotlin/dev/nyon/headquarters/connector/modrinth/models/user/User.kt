package dev.nyon.headquarters.connector.modrinth.models.user

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The model of a user of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/user_model">Modrinth docs</a>
 *
 * @param username The username of the user
 * @param name The name of the user (optional)
 * @param email The email of the user (optional)
 * @param bio The description of the user (optional)
 * @param id The id of the user
 * @param githubID The githubID of the user (optional)
 * @param avatarUrl The url of the avatar of the user
 * @param created The date when the user's account was created
 * @param role The user's [Role]
 */
@Serializable
data class User(
    val username: String,
    val name: String?,
    val email: String?,
    val bio: String?,
    val id: String,
    @SerialName("github_id") val githubID: Int?,
    @SerialName("avatar_url") val avatarUrl: String,
    val created: Instant,
    val role: Role
)