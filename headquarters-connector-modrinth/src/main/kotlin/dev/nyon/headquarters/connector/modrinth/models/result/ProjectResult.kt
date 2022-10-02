package dev.nyon.headquarters.connector.modrinth.models.result

import dev.nyon.headquarters.connector.modrinth.models.project.ClientSide
import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import dev.nyon.headquarters.connector.modrinth.models.project.ServerSide
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectResult(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>? = null,
    @SerialName("client_side") val clientSide: ClientSide,
    @SerialName("server_side") val serverSide: ServerSide,
    @SerialName("project_type") val projectType: ProjectType,
    val downloads: Int,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("project_id") val projectID: String,
    val author: String,
    @SerialName("display_categories") val displayCategories: List<String>? = null,
    val versions: List<String>,
    val follows: Int,
    @SerialName("date_created") val dateCreated: Instant,
    @SerialName("date_modified") val dateModified: Instant,
    @SerialName("latest_version") val latestVersion: String? = null,
    val license: String,
    val gallery: List<String>? = null
)
