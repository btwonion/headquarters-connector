package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.version.HashAlgorithm
import dev.nyon.headquarters.connector.modrinth.models.project.version.Loader
import dev.nyon.headquarters.connector.modrinth.models.project.version.Version
import dev.nyon.headquarters.connector.modrinth.models.request.getEnumFieldAnnotation
import io.ktor.client.request.*
import kotlinx.serialization.SerialName

/**
 * Gets the versions of the project
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/versions/operation/getProjectVersions">Modrinth docs</a>
 *
 * @param query The id/slug of the project
 * @param loaders The version's [Loader]
 * @param gameVersions The version's gameVersion
 * @param featured Whether the version is featured or not
 *
 * @return A [List] of [Version]
 */
suspend fun ModrinthConnector.listVersions(
    query: String, loaders: List<Loader>? = null, gameVersions: List<String>? = null, featured: Boolean? = null
) = request<List<Version>>("/project/$query/version") {
    parameter("loaders", loaders?.map {
        it.getEnumFieldAnnotation<SerialName>()?.value ?: error("Loader ${it.name} doesn't have an SerialName")
    }?.merge())
    parameter("game_versions", gameVersions?.merge())
    parameter("featured", featured)
}

/**
 * Gets the version with the requested id
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/versions/operation/getVersion">Modrinth docs</a>
 *
 * @param id The id of the version
 *
 * @return The requested [Version]
 */
suspend fun ModrinthConnector.getVersion(id: String) = request<Version>("/version/$id")

/**
 * Gets the versions with the requested ids
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/versions/operation/getVersions">Modrinth docs</a>
 *
 * @param ids The id of the versions
 *
 * @return A [List] of [Version]
 */
suspend fun ModrinthConnector.getVersions(ids: List<String>) =
    request<List<Version>>("/versions") { parameter("ids", ids.merge()) }

/**
 * Gets the version by their hash
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/version-files/operation/versionFromHash">Modrinth docs</a>
 *
 * @param hash The hash of the version
 * @param algorithm The [HashAlgorithm] of the requested version
 *
 * @return The [Version]
 */
suspend fun ModrinthConnector.getVersionByHash(hash: String, algorithm: HashAlgorithm = HashAlgorithm.sha1) =
    request<Version>("/version_file/$hash") { parameter("algorithm", algorithm) }