package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.Serializable

@Serializable
enum class HashAlgorithm {
    sha1,
    sha512
}