package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.requests.getModrinthStatistics
import io.kotest.matchers.nulls.shouldNotBeNull

class MiscellaneousTests : CommonRequestTest({
    test("modrinthStats") {
        val result = connector.getModrinthStatistics()
        result.shouldNotBeNull()
    }
})