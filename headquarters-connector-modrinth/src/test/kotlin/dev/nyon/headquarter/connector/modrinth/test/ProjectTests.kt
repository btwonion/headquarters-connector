package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.models.project.ProjectType
import dev.nyon.headquarters.connector.modrinth.models.request.Facet
import dev.nyon.headquarters.connector.modrinth.models.request.Index
import dev.nyon.headquarters.connector.modrinth.requests.*
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class ProjectTests : CommonRequestTest({
    test("getProject") {
        val result = connector.getProject("autodrop")
        result.shouldNotBeNull()
        result.id shouldBe "lg17V3i3"
    }

    test("searchProjects") {
        val result = connector.searchProjects(
            "SimpleAutoDrop", facets = listOf(
                Facet.ProjectType(listOf(ProjectType.Mod)), Facet.Version(
                    listOf("1.19.2")
                )
            ), limit = 1, index = Index.Downloads
        )
        result.shouldNotBeNull()
    }

    test("getProjects") {
        val result = connector.getProjects(listOf("lg17V3i3", "Ha28R6CL"))
        result.shouldNotBeNull()
    }

    test("getProjectDependencies") {
        val result = connector.getProjectDependencies("autodrop")
        result.shouldNotBeNull()
    }

    test("getUsersProjects") {
        val result = connector.getUsersProjects("btwonion")
        result.shouldNotBeNull()
    }
})