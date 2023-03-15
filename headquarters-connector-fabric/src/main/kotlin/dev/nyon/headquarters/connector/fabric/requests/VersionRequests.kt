package dev.nyon.headquarters.connector.fabric.requests

import dev.nyon.headquarters.connector.fabric.FabricConnector
import dev.nyon.headquarters.connector.fabric.models.*

suspend fun FabricConnector.getVersions() = request<Versions>("/versions")

suspend fun FabricConnector.getGameVersions() = request<List<Game>>("/versions/game")
suspend fun FabricConnector.getYarnGameVersions() = request<List<Game>>("/versions/game/yarn")
suspend fun FabricConnector.getIntermediaryGameVersions() = request<List<Game>>("/versions/game/intermediary")

suspend fun FabricConnector.getYarnVersions() = request<List<Mapping>>("/versions/yarn")
suspend fun FabricConnector.getYarnOfGameVersion(version: String) = request<List<Mapping>>("/versions/yarn/$version")

suspend fun FabricConnector.getIntermediaryVersions() = request<List<Intermediary>>("/versions/intermediary")
suspend fun FabricConnector.getIntermediariesOfGameVersion(version: String) =
    request<List<Intermediary>>("/versions/intermediary/$version")

suspend fun FabricConnector.getLoaderVersions() = request<List<Loader>>("/versions/loader")
suspend fun FabricConnector.getLoadersOfGameVersion(version: String) =
    request<List<CompatibleLoader>>("/versions/loader/$version")

suspend fun FabricConnector.getLoaderOfGameAndLoaderVersion(gameVersion: String, loaderVersion: String) =
    request<CompatibleLoader>("/versions/loader/$gameVersion/$loaderVersion")

suspend fun FabricConnector.getLoaderProfile(loaderVersion: String, gameVersion: String) =
    request<LoaderProfile>("/versions/loader/$gameVersion/$loaderVersion/profile/json")

suspend fun FabricConnector.getServerLoaderProfile(loaderVersion: String, gameVersion: String) =
    request<LoaderProfile>("/versions/loader/$gameVersion/$loaderVersion/server/json")

suspend fun FabricConnector.getInstallerVersions() = request<List<Installer>>("/versions/installer")