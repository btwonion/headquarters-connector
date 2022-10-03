package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.tags.*

/**
 * Gets all categories of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/categoryList">Modrinth docs</a>
 *
 * @return A [List] of [Category]
 */
suspend fun ModrinthConnector.getCategories() = request<List<Category>>("/tag/category")

/**
 * Gets all loaders of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/loaderList">Modrinth docs</a>
 *
 * @return A [List] of [Loader]
 */
suspend fun ModrinthConnector.getLoaders() = request<List<Loader>>("/tag/loader")

/**
 * Gets all game versions of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/versionList">Modrinth docs</a>
 *
 * @return A [List] of [GameVersion]
 */
suspend fun ModrinthConnector.getGameVersions() = request<List<GameVersion>>("/tag/game_version")

/**
 * Gets all licenses of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/licenseList">Modrinth docs</a>
 *
 * @return A [List] of [LicenseTag]
 */
suspend fun ModrinthConnector.getLicenses() = request<List<LicenseTag>>("/tag/license")

/**
 * Gets all donation platforms of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/donationPlatformList">Modrinth docs</a>
 *
 * @return A [List] of [DonationPlatformTag]
 */
suspend fun ModrinthConnector.getDonationPlatforms() = request<List<DonationPlatformTag>>("/tag/donation_platform")

/**
 * Gets all report types of Modrinth
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/tags/operation/reportTypeList">Modrinth docs</a>
 *
 * @return A [List] of [String]
 */
suspend fun ModrinthConnector.getReportTypes() = request<List<String>>("/tag/report_type")