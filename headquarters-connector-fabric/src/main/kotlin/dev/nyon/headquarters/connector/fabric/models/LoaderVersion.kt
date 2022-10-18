package dev.nyon.headquarters.connector.fabric.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class LoaderProfile(
    val id: String,
    val inheritsFrom: String,
    val releaseTime: Instant,
    val time: Instant,
    val type: String,
    val mainClass: String,
    val arguments: Arguments,
    val libraries: List<Artifact>
)

@Serializable
data class Arguments(val game: ArrayList<String>, val jvm: ArrayList<String>)