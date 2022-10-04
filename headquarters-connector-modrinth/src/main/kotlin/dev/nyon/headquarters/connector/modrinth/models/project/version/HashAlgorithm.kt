package dev.nyon.headquarters.connector.modrinth.models.project.version

import kotlinx.serialization.Serializable

/**
 * The hash algorithms of a version [File]
 */
@Serializable
enum class HashAlgorithm {
    sha1,
    sha512
}