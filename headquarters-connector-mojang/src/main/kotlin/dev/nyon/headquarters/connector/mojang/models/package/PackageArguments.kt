package dev.nyon.headquarters.connector.mojang.models.`package`

import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class PackageArguments(val game: List<Argument>, val jvm: List<Argument>)

@Serializable(with = ArgumentSerializer::class)
sealed interface Argument {

    @Serializable
    @JvmInline
    value class SimpleArgument(val value: String) : Argument

    @Serializable
    data class ExtendedArgument(
        val rules: List<Rule>, val value: @Serializable(with = ArgumentValueSerializer::class) List<String>
    ) : Argument
}

object ArgumentSerializer : JsonContentPolymorphicSerializer<Argument>(Argument::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Argument> = when (element) {
        is JsonPrimitive -> Argument.SimpleArgument.serializer()
        else -> Argument.ExtendedArgument.serializer()
    }
}

object ArgumentValueSerializer : JsonContentPolymorphicSerializer<List<*>>(List::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<List<String>> = when (element) {
        is JsonPrimitive -> StringAsListSerializer
        else -> ListSerializer(String.serializer())
    }
}

private object StringAsListSerializer : KSerializer<List<String>> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): List<String> {
        return listOf(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: List<String>) {
        encoder.encodeString(Json.encodeToString(value))
    }
}

@Serializable
data class Rule(val action: RuleAction, val features: Map<String, Boolean>? = null, val os: Map<String, String>? = null)

@Serializable
enum class RuleAction {
    @SerialName("allow")
    Allow,

    @SerialName("disallow")
    Disallow
}