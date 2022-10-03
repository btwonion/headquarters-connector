package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.requests.getUser
import dev.nyon.headquarters.connector.modrinth.requests.getUsers
import io.kotest.matchers.nulls.shouldNotBeNull

class UserTests : CommonRequestTest({
    test("getUser") {
        val result = connector.getUser("btwonion")
        result.shouldNotBeNull()
    }

    test("getUsers") {
        val result = connector.getUsers(listOf("qDVtmZJc", "JZA4dW8o"))
        result.shouldNotBeNull()
    }
})