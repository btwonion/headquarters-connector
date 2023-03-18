package headquarters.connector.quilt.models

import kotlinx.serialization.Serializable

@Serializable
data class QuiltMappings(
    val gameVersion: String,
    val separator: String,
    val build: Int,
    val maven: String,
    val version: String,
    val hashed: String
)