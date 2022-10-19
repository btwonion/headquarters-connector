package dev.nyon.headquarters.connector.fabric.models

import kotlinx.serialization.Serializable

@Serializable
data class CompatibleLoader(
    val loader: Loader,
    val intermediary: Intermediary,
    val launcherMeta: ILauncherMeta
)