package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.user.User
import io.ktor.client.request.*

/**
 * Gets the user
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/users/operation/getUser">Modrinth docs</a>
 *
 * @param query The name/id of the user
 *
 * @return The requested [User]
 */
suspend fun ModrinthConnector.getUser(query: String) = request<User>("/user/$query")

/**
 * Gets the users
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/users/operation/getUsers">Modrinth docs</a>
 *
 * @param ids The name/id of the users
 *
 * @return A [List] of [User]
 */
suspend fun ModrinthConnector.getUsers(ids: List<String>) =
    request<List<User>>("/users") { parameter("ids", ids.merge()) }