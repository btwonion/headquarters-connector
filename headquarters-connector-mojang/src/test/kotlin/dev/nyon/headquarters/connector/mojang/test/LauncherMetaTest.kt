package dev.nyon.headquarters.connector.mojang.test

import io.kotest.matchers.nulls.shouldNotBeNull

class LauncherMetaTest : CommonRequestTest({
    test("version manifest") {
        val result = connector.getVersionManifest()
        result.shouldNotBeNull()
    }

    test("versionPackage") {
        val result = connector.getVersionPackage("1.19.4")
        result.shouldNotBeNull()
        println(result)
    }
})