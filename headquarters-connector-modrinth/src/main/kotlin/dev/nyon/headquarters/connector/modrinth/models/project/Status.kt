package dev.nyon.headquarters.connector.modrinth.models.project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Status {
    @SerialName("approved")
    Approved,

    @SerialName("rejected")
    Rejected,

    @SerialName("draft")
    Draft,

    @SerialName("unlisted")
    Unlisted,

    @SerialName("archive")
    Archive,

    @SerialName("processing")
    Processing,

    @SerialName("unknown")
    Unknown
}