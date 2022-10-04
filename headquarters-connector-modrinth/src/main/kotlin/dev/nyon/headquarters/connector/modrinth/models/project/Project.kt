package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The project model of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/project_model">Modrinth docs</a>
 *
 * @param slug The slug of the project
 * @param title The title of the project
 * @param description The description of the project
 * @param categories The categories of the project
 * @param clientSide The compatibility state of client side of the project
 * @param serverSide The compatibility state of server side of the project
 * @param body The body of the project
 * @param additionalCategories The additional categories of the project (optional)
 * @param issuesUrl The issues url of the project (optional)
 * @param sourceUrl The sources url of the project (optional)
 * @param wikiUrl The wiki url of the project (optional)
 * @param discordUrl The discord url of the project (optional)
 * @param donationUrl The donation url of the project (optional)
 * @param projectType The [ProjectType] of the project
 * @param downloads The download count of the project
 * @param iconUrl The icon url of the project (optional)
 * @param id The project's id
 * @param team The team which owns the project
 * @param moderatorMessage The [ModeratorMessage] of the project (optional)
 * @param published The publishing date of the project
 * @param updated The last project update date
 * @param approved The approving date of the project (optional)
 * @param followers The follower count of the project
 * @param status The project's status [Status]
 * @param license The license of the project
 * @param versions The supported versions of the project
 * @param gallery The gallery entries of the project
 */
@Serializable
data class Project(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>,
    @SerialName("client_side") val clientSide: CompatibilityState,
    @SerialName("server_side") val serverSide: CompatibilityState,
    val body: String,
    @SerialName("additional_categories") val additionalCategories: List<String>?,
    @SerialName("issues_url") val issuesUrl: String?,
    @SerialName("source_url") val sourceUrl: String?,
    @SerialName("wiki_url") val wikiUrl: String?,
    @SerialName("discord_url") val discordUrl: String?,
    @SerialName("donation_urls") val donationUrl: List<DonationPlatform>?,
    @SerialName("project_type") val projectType: ProjectType,
    val downloads: Int,
    @SerialName("icon_url") val iconUrl: String?,
    val id: String,
    val team: String,
    @SerialName("moderator_message") val moderatorMessage: ModeratorMessage?,
    val published: Instant,
    val updated: Instant,
    val approved: Instant?,
    val followers: Int,
    val status: Status,
    val license: License,
    val versions: List<String>,
    val gallery: List<GalleryEntry>
)
