package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.request.Index
import dev.nyon.headquarters.connector.modrinth.requests.getProject
import dev.nyon.headquarters.connector.modrinth.requests.searchProjects
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class RequestTests : DescribeSpec({
    val ktorClientJson = Json {
        ignoreUnknownKeys = true
    }

    val ktorClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(ktorClientJson)
        }
    }
    val connector = ModrinthConnector(ktorClient, ktorClientJson)

    describe("project requests") {
        it("getProject") {
            val result = connector.getProject("autodrop")
            result.shouldNotBeNull()
            result.id shouldBe "lg17V3i3"
        }

        it("searchProjects") {
            val result = connector.searchProjects(
                "SimpleAutoDrop", facets = listOf(
                    Facet.ProjectType(listOf(ProjectType.Mod)), Facet.Version(
                        listOf("1.19.2")
                    )
                ), limit = 1, index = Index.Downloads
            )
            result.shouldNotBeNull()
            println(result)
        }

        it("getProjects") {

        }
    }
})