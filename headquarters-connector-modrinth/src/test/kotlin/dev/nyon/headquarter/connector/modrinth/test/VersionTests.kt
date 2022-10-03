package dev.nyon.headquarter.connector.modrinth.test

import dev.nyon.headquarters.connector.modrinth.models.project.version.HashAlgorithm
import dev.nyon.headquarters.connector.modrinth.models.project.version.Loader
import dev.nyon.headquarters.connector.modrinth.requests.getVersion
import dev.nyon.headquarters.connector.modrinth.requests.getVersionByHash
import dev.nyon.headquarters.connector.modrinth.requests.getVersions
import dev.nyon.headquarters.connector.modrinth.requests.listVersions
import io.kotest.matchers.nulls.shouldNotBeNull

class VersionTests : CommonRequestTest({
    test("listVersions") {
        val result = connector.listVersions(
            "autodrop", loaders = listOf(Loader.Quilt, Loader.Fabric), gameVersions = listOf("1.19.2")
        )
        result.shouldNotBeNull()
    }

    test("getVersion") {
        val result = connector.getVersion("8TOgNwQL")
        result.shouldNotBeNull()
    }

    test("getVersions") {
        val result = connector.getVersions(listOf("8TOgNwQL", "oU5qfeR6"))
        result.shouldNotBeNull()
    }

    test("getVersionByHash") {
        val result = connector.getVersionByHash("045c33a901c3004bced082495041718d65b88ede")
        val secondResult = connector.getVersionByHash(
            "07d4e2cb39523b4df1c60e00d830e520cdf007be4fc0d442020b7cec7aa590fe5a170778e9ec2a49595068c73bdff4d3578365e6e216abde28d93134dfbda39a",
            algorithm = HashAlgorithm.sha512
        )
        secondResult.shouldNotBeNull()
        result.shouldNotBeNull()
    }
})