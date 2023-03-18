# headquarters-connector

> library for using the Modrinth, Mojang and Fabric http api

</br> written in [Kotlin](https://kotlinlang.org) and uses [Ktor](https://ktor.io), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines), [Serialization](https://github.com/Kotlin/kotlinx.serialization) and [Kotlin Datetime](https://github.com/Kotlin/kotlinx-datetime)

### Setup

<img src="https://repo.nyon.dev/api/badge/latest/releases/dev/nyon/headquarters-connector-core?color=AD10A7&name=headquarters-connector&prefix=v" />

[Documentation](https://btwonion.github.io/headquarters-connector)

```kotlin
repositories {
  maven("https://repo.nyon.dev/releases")
}

dependencies {
  implementation("dev.nyon:headquarters-connector-core:1.4.2")
  // now the library you want to use
  // eg.
  implementation("dev.nyon:headquarters-connector-modrinth:1.4.2")
}
```

### Other
If you need help with any of my projects just join my [discord server](https://nyon.dev/discord)
