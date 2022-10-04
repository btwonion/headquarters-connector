package dev.nyon.headquarters.connector.modrinth.models.request

import kotlinx.serialization.SerialName
import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType as RealProjectType

/**
 * A superclass for Facets of project search
 *
 * @param keyWord The keyword of the facet
 * @param value The value of the facet
 */
sealed class Facet<T>(open val keyWord: String, open val value: T) {
    /**
     * The abstract fun to serialize the facet into a json object
     */
    abstract fun toJsonObject(): String

    /**
     * The category facet
     */
    data class Categories(override val value: List<String>) : Facet<List<String>>("categories", value) {
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }

    /**
     * The version facet
     */
    data class Version(override val value: List<String>) : Facet<List<String>>("versions", value) {
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }

    /**
     * The license facet
     */
    data class License(override val value: List<String>) : Facet<List<String>>("license", value) {
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }

    /**
     * The ProjectType facet
     */
    data class ProjectType(override val value: List<RealProjectType>) :
        Facet<List<RealProjectType>>("project_type", value) {
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]") {
                it.getEnumFieldAnnotation<SerialName>()!!.value
            }
    }
}

inline fun <reified A : Annotation> Enum<*>.getEnumFieldAnnotation(): A? =
    javaClass.getDeclaredField(name).getAnnotation(A::class.java)

fun List<Facet<*>>.merge(): String =
    joinToString(separator = ",", prefix = "[", postfix = "]") { it.toJsonObject() }