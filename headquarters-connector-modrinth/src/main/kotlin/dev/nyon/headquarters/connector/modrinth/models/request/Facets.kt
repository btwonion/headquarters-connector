package dev.nyon.headquarters.connector.modrinth.models.request

import kotlinx.serialization.SerialName
import dev.nyon.headquarters.connector.modrinth.models.slug.ProjectType as RealProjectType

sealed class Facet<T>(open val keyWord: String, open val value: T) {
    abstract fun toJsonObject(): String
    data class Categories(override val value: List<String>) : Facet<List<String>>("categories", value) {
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }

    data class Version(override val value: List<String>) : Facet<List<String>>("versions", value){
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }
    data class License(override val value: List<String>) : Facet<List<String>>("license", value){
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]")
    }
    data class ProjectType(override val value: List<RealProjectType>) :
        Facet<List<RealProjectType>>("project_type", value){
        override fun toJsonObject(): String =
            this.value.joinToString(separator = "\",\"$keyWord:", prefix = "[\"$keyWord:", postfix = "\"]") {
                it.getEnumFieldAnnotation<SerialName>()!!.value
            }
    }
}

inline fun <reified A : Annotation> Enum<*>.getEnumFieldAnnotation(): A? =
    javaClass.getDeclaredField(name).getAnnotation(A::class.java)
