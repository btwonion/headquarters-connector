package dev.nyon.headquarters.connector.modrinth.models.result

import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import dev.nyon.headquarters.connector.modrinth.models.project.CompatibilityState
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The project result of a search
 *
 * @param slug The slug of the project
 * @param title The title of the project
 * @param description The description of the project
 * @param categories The categories of the project (optional)
 * @param clientSide The state to client side of the project
 * @param serverSide The state to server side of the project
 * @param projectType The [ProjectType] of the project
 * @param downloads The download count of the project
 * @param iconUrl The icon url of the project (optional)
 * @param projectID The project ID
 * @param author The author of the project
 * @param displayCategories The displayedCategories of the project (optional)
 * @param versions The versions of the project
 * @param follows The follow count of the project
 * @param dateCreated The creation date of the project
 * @param dateModified The date of the last modify of the project
 * @param latestVersion The latest version id of the project (optional)
 * @param license The license of the project
 * @param gallery The gallery of the project (optional)
 */
@Serializable
data class ProjectResult(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>? = null,
    @SerialName("client_side") val clientSide: CompatibilityState,
    @SerialName("server_side") val serverSide: CompatibilityState,
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