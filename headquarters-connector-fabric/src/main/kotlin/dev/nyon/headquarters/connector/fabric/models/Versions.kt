package dev.nyon.headquarters.connector.fabric.models

import kotlinx.serialization.Serializable

@Serializable
data class Versions(
    val game: List<Game>,
    val mappings: List<Mapping>,
    val intermediary: List<Intermediary>,
    val loader: List<Loader>,
    val installer: List<Installer>
)

@Serializable
data class Game(val version: String, val stable: Boolean)

@Serializable
data class Mapping(
    val gameVersion: String,
    val separator: String,
    val build: Int,
    val maven: String,
    val version: String,
    val stable: Boolean
)

@Serializable
data class Intermediary(val maven: String, val version: String, val stable: Boolean)

@Serializable
data class Loader(val separator: String, val build: Int, val maven: String, val version: String, val stable: Boolean)

@Serializable
data class Installer(val url: String, val maven: String, val version: String, val stable: Boolean)