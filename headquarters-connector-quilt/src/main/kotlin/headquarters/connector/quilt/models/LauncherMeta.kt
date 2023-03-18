package headquarters.connector.quilt.models

import kotlinx.serialization.Serializable

@Serializable
data class LauncherMeta(val version: Int, val libraries: Libraries, val mainClass: MainClass)

@Serializable
data class Libraries(val client: List<Artifact>, val common: List<Artifact>, val server: List<Artifact>)

@Serializable
data class Artifact(val name: String, val url: String? = null)

@Serializable
data class MainClass(val client: String, val server: String, val serverLauncher: String? = null)