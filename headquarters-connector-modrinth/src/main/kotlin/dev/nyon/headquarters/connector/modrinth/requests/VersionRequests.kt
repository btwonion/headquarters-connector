package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.version.HashAlgorithm
import dev.nyon.headquarters.connector.modrinth.models.project.version.Loader
import dev.nyon.headquarters.connector.modrinth.models.project.version.Version
import dev.nyon.headquarters.connector.modrinth.models.request.getEnumFieldAnnotation
import io.ktor.client.request.*
import kotlinx.serialization.SerialName

suspend fun ModrinthConnector.listVersions(
    query: String, loaders: List<Loader>? = null, gameVersions: List<String>? = null, featured: Boolean? = null
) = request<List<Version>>("/project/$query/version") {
    parameter("loaders", loaders?.map {
        it.getEnumFieldAnnotation<SerialName>()?.value ?: error("Loader ${it.name} doesn't have an SerialName")
    }?.merge())
    parameter("game_versions", gameVersions?.merge())
    parameter("featured", featured)
}

suspend fun ModrinthConnector.getVersion(id: String) = request<Version>("/version/$id")
suspend fun ModrinthConnector.getVersions(ids: List<String>) =
    request<List<Version>>("/versions") { parameter("ids", ids.merge()) }

suspend fun ModrinthConnector.getVersionByHash(hash: String, algorithm: HashAlgorithm = HashAlgorithm.sha1) =
    request<Version>("/version_file/$hash") { parameter("algorithm", algorithm) }