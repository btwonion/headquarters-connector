package headquarters.connector.quilt.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class LoaderProfile(
    val id: String,
    val inheritsFrom: String,
    val type: String,
    val mainClass: String,
    val arguments: Arguments,
    val libraries: List<Artifact>,
    val releaseTime: Instant,
    val time: Instant
)

@Serializable
data class Arguments(val game: List<String>, val jvm: List<String>? = null)