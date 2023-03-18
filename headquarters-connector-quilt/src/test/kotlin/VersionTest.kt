package dev.nyon.headquarters.connector.fabric.test

import headquarters.connector.quilt.requests.*
import io.kotest.matchers.nulls.shouldNotBeNull

class VersionTest : CommonRequestTest({
    test("versions") {
        val result = connector.getVersions()
        result.shouldNotBeNull()
    }

    test("game versions") {
        connector.getGameVersions()
        connector.getGameHashedVersions()
        connector.getGameIntermediaryVersions()

        connector.getGameQuiltMappingsVersions()
        connector.getInstallerVersions()
    }

    test("quilt mappings versions") {
        connector.getQuiltMappingVersions()
    }

    test("intermediary versions") {
        connector.getIntermediaryVersions()
        connector.getIntermediariesOfGameVersion("1.19.2")

        connector.getHashedVersionsOfGameVersion("1.19.2")
    }

    test("loader versions") {
        connector.getLoaderVersions()
        connector.getLoadersOfGameVersion("1.19.2")
        connector.getLoaderOfGameAndLoaderVersion("1.19.2", "0.18.5")
        connector.getLoaderProfile("0.14.9", "1.19.2")
        connector.getServerLoaderProfile("0.14.9", "1.19.2")
    }
})