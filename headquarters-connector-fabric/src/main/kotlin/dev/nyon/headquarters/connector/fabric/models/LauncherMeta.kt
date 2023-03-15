package dev.nyon.headquarters.connector.fabric.models

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@Serializable(with = LauncherMetaSerializer::class)
interface ILauncherMeta

@Serializable
data class LauncherMeta(val version: Int, val libraries: Libraries, val mainClass: MainClass) : ILauncherMeta

@Serializable
data class Libraries(val client: List<Artifact>, val common: List<Artifact>, val server: List<Artifact>)

@Serializable
data class Artifact(val name: String, val url: String? = null)

@Serializable
data class MainClass(val client: String, val server: String)


@Serializable
data class OldLauncherMeta(
    val version: Int,
    val libraries: Libraries,
    val mainClass: String,
    val arguments: OldArguments,
    @SerialName("launchwrapper")
    val launchWrapper: LaunchWrapper
) : ILauncherMeta

@Serializable
data class OldArguments(val client: List<String>, val common: List<String>, val server: List<String>)

@Serializable
data class LaunchWrapper(val tweakers: Tweakers)

@Serializable
data class Tweakers(val client: List<String>, val common: List<String>, val server: List<String>)

object LauncherMetaSerializer : JsonContentPolymorphicSerializer<ILauncherMeta>(ILauncherMeta::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ILauncherMeta> =
        if (element.jsonObject.keys.size == 5) OldLauncherMeta.serializer() else LauncherMeta.serializer()
}