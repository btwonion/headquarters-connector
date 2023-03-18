package headquarters.connector.quilt.models

import kotlinx.serialization.Serializable

@Serializable
data class CompatibleLoader(
    val loader: Loader, val hashed: Hashed, val intermediary: Intermediary, val launcherMeta: LauncherMeta
)