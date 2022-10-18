package dev.nyon.headquarters.connector.fabric.test

import dev.nyon.headquarters.connector.fabric.requests.*
import io.kotest.matchers.nulls.shouldNotBeNull

class VersionTest : CommonRequestTest({
    test("versions") {
        val result = connector.getVersions()
        result.shouldNotBeNull()
    }

    test("alles") {
        connector.getGameVersions()
        connector.getYarnGameVersions()
        connector.getIntermediaryGameVersions()

        connector.getYarnVersions()
        connector.getYarnOfGameVersion("1.19.2")

        connector.getIntermediaryVersions()
        connector.getIntermediariesOfGameVersion("1.19.2")

        connector.getLoaderVersions()
        connector.getLoadersOfGameVersion("1.19.2")
        connector.getLoaderOfGameAndLoaderVersion("1.19.2", "0.14.9")
        connector.getLoaderProfile("0.14.9", "1.19.2")
        connector.getServerLoaderProfile("0.14.9", "1.19.2")

        connector.getInstallerVersions()
    }
})