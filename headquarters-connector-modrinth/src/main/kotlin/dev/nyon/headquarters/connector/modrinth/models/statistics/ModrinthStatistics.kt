package dev.nyon.headquarters.connector.modrinth.models.statistics

import kotlinx.serialization.Serializable

@Serializable
data class ModrinthStatistics(val projects: Int, val versions: Int, val files: Int, val authors: Int)