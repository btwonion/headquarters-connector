package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.team.TeamMember
import io.ktor.client.request.*

suspend fun ModrinthConnector.getProjectTeamMembers(query: String) =
    request<List<TeamMember>>("/project/$query/members")

suspend fun ModrinthConnector.getTeamMembers(id: String) = request<List<TeamMember>>("/team/$id/members")
suspend fun ModrinthConnector.getTeamMembers(ids: List<String>) =
    request<List<List<TeamMember>>>("/teams") { parameter("ids", ids.joinQuotedStrings()) }