package dev.nyon.headquarters.connector.modrinth.models.request

import kotlinx.serialization.SerialName
import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType as RealProjectType

/**
 * A superclass for Facets of project search
 *
 * @param keyWord The keyword of the facet
 * @param value The value of the facet
 */
sealed class Facet<T>(
    open val keyWord: String, open val value: List<T>, open val operator: FacetKeyword = FacetKeyword.Or
) {
    /**
     * The abstract fun to serialize the facet into a json object
     */
    abstract fun toJsonObject(): String

    fun defaultJsonTransformation(): String = if (operator == FacetKeyword.And) value.joinToString(
        separator = "\"],[\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]"
    ) else value.joinToString(
        separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]"
    )

    /**
     * The category facet
     */
    data

    class Categories(override val value: List<String>) : Facet<String>("categories", value) {
        override fun toJsonObject(): String = defaultJsonTransformation()
    }

    /**
     * The version facet
     */
    data class Version(override val value: List<String>) : Facet<String>("versions", value) {
        override fun toJsonObject(): String = defaultJsonTransformation()
    }

    /**
     * The license facet
     */
    data class License(override val value: List<String>) : Facet<String>("license", value) {
        override fun toJsonObject(): String = defaultJsonTransformation()
    }

    /**
     * The ProjectType facet
     */
    data class ProjectType(override val value: List<RealProjectType>) : Facet<RealProjectType>("project_type", value) {
        override fun toJsonObject(): String = if (operator == FacetKeyword.And) value.joinToString(
            separator = "\"],[\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]"
        ) {
            it.getEnumFieldAnnotation<SerialName>()!!.value
        } else value.joinToString(
            separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]"
        ) {
            it.getEnumFieldAnnotation<SerialName>()!!.value
        }
    }
}

enum class FacetKeyword { And, Or }

inline fun <reified A : Annotation> Enum<*>.getEnumFieldAnnotation(): A? =
    javaClass.getDeclaredField(name).getAnnotation(A::class.java)

fun List<Facet<*>>.merge(): String = joinToString(separator = ",", prefix = "[", postfix = "]") { it.toJsonObject() }