package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>,
    @SerialName("client_side") val clientSide: ClientSide,
    @SerialName("server_side") val serverSide: ServerSide,
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
