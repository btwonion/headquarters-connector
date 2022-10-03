package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.requests.getProjectTeamMembers
import dev.nyon.headquarters.connector.modrinth.requests.getTeamsMembers
import io.kotest.matchers.nulls.shouldNotBeNull

class TeamTests : CommonRequestTest({
    test("getProjectTeamMembers") {
        val result = connector.getProjectTeamMembers("autodrop")
        result.shouldNotBeNull()
    }

    test("getTeamMembers") {
        val result = connector.getTeamsMembers("k0A8kAVQ")
        result.shouldNotBeNull()
    }

    test("getTeamsMembers") {
        val result = connector.getTeamsMembers(listOf("k0A8kAVQ", "ZuDNuQCn"))
        result.shouldNotBeNull()
    }
})