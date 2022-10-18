package dev.nyon.headquarters.connector.fabric.test

import dev.nyon.headquarters.connector.fabric.FabricConnector
import io.kotest.core.spec.style.FunSpec
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@Suppress("UNCHECKED_CAST")
abstract class CommonRequestTest(block: CommonRequestTest.() -> Unit) : FunSpec(block as FunSpec.() -> Unit) {
    @OptIn(ExperimentalSerializationApi::class)
    private val ktorClientJson = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    private val ktorClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(ktorClientJson)
        }
    }
    val connector = FabricConnector(ktorClient, ktorClientJson)
}