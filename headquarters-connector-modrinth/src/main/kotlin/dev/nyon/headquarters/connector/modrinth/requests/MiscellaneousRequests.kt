package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.statistics.ModrinthStatistics

/**
 * Requests multiple statistics about the modrinth instance
 * <a href="https://docs.modrinth.com/api-spec/#tag/misc/operation/statistics">Modrinth docs</a>
 *
 * @return The [ModrinthStatistics] object
 */
suspend fun ModrinthConnector.getModrinthStatistics() = request<ModrinthStatistics>("/statistics")