package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.requests.*
import io.kotest.matchers.nulls.shouldNotBeNull

class TagTests : CommonRequestTest({
    test("categories") {
        val result = connector.getCategories()
        result.shouldNotBeNull()
    }
    test("loaders") {
        val result = connector.getLoaders()
        result.shouldNotBeNull()
    }
    test("gameVersions") {
        val result = connector.getGameVersions()
        result.shouldNotBeNull()
    }
    test("licenses") {
        val result = connector.getLicenses()
        result.shouldNotBeNull()
    }
    test("donationPlatforms") {
        val result = connector.getDonationPlatforms()
        result.shouldNotBeNull()
    }
    test("reportTypes") {
        val result = connector.getReportTypes()
        result.shouldNotBeNull()
    }
})