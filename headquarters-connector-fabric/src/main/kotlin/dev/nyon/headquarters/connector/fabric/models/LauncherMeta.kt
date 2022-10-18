package dev.nyon.headquarters.connector.fabric.models

import kotlinx.serialization.Serializable

@Serializable
data class LauncherMeta(val version: Int, val libraries: List<Libraries>, val mainClass: MainClass)

@Serializable
data class Libraries(val client: List<Artifact>, val common: List<Artifact>, val server: List<Artifact>)

@Serializable
data class Artifact(val name: String, val url: String)

@Serializable
data class MainClass(val client: String, val server: String)