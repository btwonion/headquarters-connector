package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.user.User
import io.ktor.client.request.*

suspend fun ModrinthConnector.getUser(query: String) = request<User>("/user/$query")
suspend fun ModrinthConnector.getUsers(ids: List<String>) =
    request<List<User>>("/users") { parameter("ids", ids.merge()) }