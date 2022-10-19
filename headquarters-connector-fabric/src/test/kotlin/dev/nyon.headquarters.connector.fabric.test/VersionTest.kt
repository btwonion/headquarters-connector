package dev.nyon.headquarters.connector.fabric.test

import dev.nyon.headquarters.connector.fabric.requests.*
import io.kotest.matchers.nulls.shouldNotBeNull

class VersionTest : CommonRequestTest({
    test("versions") {
        val result = connector.getVersions()
        result.shouldNotBeNull()
    }

    test("game versions") {
        connector.getGameVersions()
        connector.getYarnGameVersions()
        connector.getIntermediaryGameVersions()

        connector.getInstallerVersions()
    }

    test("yarn versions") {
        connector.getYarnVersions()
        connector.getYarnOfGameVersion("1.19.2")
    }

    test("intermediary versions") {
        connector.getIntermediaryVersions()
        connector.getIntermediariesOfGameVersion("1.19.2")
    }

    test("loader versions") {
        connector.getLoaderVersions()
        println(1)
        connector.getLoadersOfGameVersion("1.19.2")
        println(2)
        connector.getLoaderOfGameAndLoaderVersion("1.19.2", "0.14.9")
        println(3)
        connector.getLoaderProfile("0.14.9", "1.19.2")
        println(4)
        connector.getServerLoaderProfile("0.14.9", "1.19.2")
    }
})