package dev.nyon.headquarters.connector.modrinth.models.user

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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