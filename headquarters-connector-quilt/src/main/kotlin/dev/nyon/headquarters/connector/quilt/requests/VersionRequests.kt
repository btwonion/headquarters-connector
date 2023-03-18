package dev.nyon.headquarters.connector.quilt.requests

import dev.nyon.headquarters.connector.quilt.QuiltConnector
import dev.nyon.headquarters.connector.quilt.models.*

suspend fun QuiltConnector.getVersions() = request<Versions>("/versions")

suspend fun QuiltConnector.getGameVersions() = request<List<Game>>("/versions/game")
suspend fun QuiltConnector.getGameHashedVersions() = request<List<String>>("/versions/game/hashed")
suspend fun QuiltConnector.getGameIntermediaryVersions() = request<List<String>>("/versions/game/intermediary")

suspend fun QuiltConnector.getGameQuiltMappingsVersions() = request<List<String>>("/versions/game/quilt-mappings")

suspend fun QuiltConnector.getHashedVersionsOfGameVersion(minecraftVersion: String) =
    request<List<Hashed>>("/versions/hashed/$minecraftVersion")

suspend fun QuiltConnector.getIntermediariesOfGameVersion(version: String) =
    request<List<Intermediary>>("/versions/intermediary/$version")

suspend fun QuiltConnector.getLoaderVersions() = request<List<Loader>>("/versions/loader")
suspend fun QuiltConnector.getLoadersOfGameVersion(version: String) =
    request<List<CompatibleLoader>>("/versions/loader/$version")

suspend fun QuiltConnector.getLoaderOfGameAndLoaderVersion(gameVersion: String, loaderVersion: String) =
    request<CompatibleLoader>("/versions/loader/$gameVersion/$loaderVersion")

suspend fun QuiltConnector.getLoaderProfile(loaderVersion: String, gameVersion: String) =
    request<LoaderProfile>("/versions/loader/$gameVersion/$loaderVersion/profile/json")

suspend fun QuiltConnector.getServerLoaderProfile(loaderVersion: String, gameVersion: String) =
    request<LoaderProfile>("/versions/loader/$gameVersion/$loaderVersion/server/json")

suspend fun QuiltConnector.getInstallerVersions() = request<List<Installer>>("/versions/installer")

suspend fun QuiltConnector.getHashedVersions() = request<List<Hashed>>("/versions/hashed")

suspend fun QuiltConnector.getIntermediaryVersions() = request<List<Intermediary>>("/versions/intermediary")

suspend fun QuiltConnector.getQuiltMappingVersions() = request<List<QuiltMappings>>("/versions/quilt-mappings")