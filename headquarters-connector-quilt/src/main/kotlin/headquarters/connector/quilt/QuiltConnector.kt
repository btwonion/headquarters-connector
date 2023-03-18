package headquarters.connector.quilt

import dev.nyon.headquarters.connector.api.AbstractConnector
import io.ktor.client.*
import kotlinx.serialization.json.Json

class QuiltConnector(
    override val client: HttpClient,
    override val json: Json,
    override val baseUrl: String = "https://meta.quiltmc.org/v3"
) : AbstractConnector() {}