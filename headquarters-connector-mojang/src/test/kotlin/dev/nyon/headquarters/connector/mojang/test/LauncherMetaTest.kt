package dev.nyon.headquarters.connector.mojang.test

import io.kotest.matchers.nulls.shouldNotBeNull

class LauncherMetaTest : CommonRequestTest({
    test("version manifest") {
        val result = connector.getVersionManifest()
        result.shouldNotBeNull()
    }

    test("versionPackage") {
        val result = connector.getVersionPackage("22w43a")
        result.shouldNotBeNull()
        println(result)
    }
})