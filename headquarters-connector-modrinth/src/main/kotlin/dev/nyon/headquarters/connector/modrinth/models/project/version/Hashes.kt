package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.Serializable


@Serializable
data class Hashes(val sha512: String, val sha1: String)
