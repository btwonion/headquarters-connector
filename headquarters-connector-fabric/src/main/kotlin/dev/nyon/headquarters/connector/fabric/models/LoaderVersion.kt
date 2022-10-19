package dev.nyon.headquarters.connector.fabric.models

import kotlinx.serialization.Serializable

@Serializable
data class LoaderProfile(
    val id: String,
    val inheritsFrom: String,
    val releaseTime: String,
    val time: String,
    val type: String,
    val mainClass: String,
    val arguments: Arguments,
    val libraries: List<Artifact>
)

@Serializable
data class Arguments(val game: List<String>, val jvm: List<String>? = null)