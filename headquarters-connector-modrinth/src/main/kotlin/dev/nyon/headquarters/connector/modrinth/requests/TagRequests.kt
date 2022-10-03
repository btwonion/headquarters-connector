package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.tags.*

suspend fun ModrinthConnector.getCategories() = request<List<Category>>("/tag/category")
suspend fun ModrinthConnector.getLoaders() = request<List<Loader>>("/tag/loader")
suspend fun ModrinthConnector.getGameVersions() = request<List<GameVersion>>("/tag/game_version")
suspend fun ModrinthConnector.getLicenses() = request<List<LicenseTag>>("/tag/license")
suspend fun ModrinthConnector.getDonationPlatforms() = request<List<DonationPlatformTag>>("/tag/donation_platform")
suspend fun ModrinthConnector.getReportTypes() = request<List<String>>("/tag/report_type")