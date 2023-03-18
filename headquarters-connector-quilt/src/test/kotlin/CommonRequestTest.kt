package dev.nyon.headquarters.connector.fabric.test

import headquarters.connector.quilt.QuiltConnector
import io.kotest.core.spec.style.FunSpec
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Suppress("UNCHECKED_CAST")
abstract class CommonRequestTest(block: CommonRequestTest.() -> Unit) : FunSpec(block as FunSpec.() -> Unit) {
    private val ktorClientJson = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    private val ktorClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(ktorClientJson)
        }
    }
    val connector = QuiltConnector(ktorClient, ktorClientJson)
}