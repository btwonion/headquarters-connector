package dev.nyon.headquarters.connector.modrinth.requests

import dev.nyon.headquarters.connector.modrinth.ModrinthConnector
import dev.nyon.headquarters.connector.modrinth.models.project.team.TeamMember
import io.ktor.client.request.*

/**
 * Gets all team members of the project
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/teams/operation/getProjectTeamMembers">Modrinth docs</a>
 *
 * @param query The id/slug of the project
 *
 * @return A [List] of [TeamMember]
 */
suspend fun ModrinthConnector.getProjectTeamMembers(query: String) =
    request<List<TeamMember>>("/project/$query/members")

/**
 * Gets the members of the team
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/teams/operation/getTeamMembers">Modrinth docs</a>
 *
 * @param id The id of the team
 *
 * @return A [List] of [TeamMember]
 */
suspend fun ModrinthConnector.getTeamsMembers(id: String) = request<List<TeamMember>>("/team/$id/members")

/**
 * Gets the members of the teams
 * @see <a href="https://docs.modrinth.com/api-spec/#tag/teams/operation/getTeams">Modrinth docs</a>
 *
 * @param ids The list of the team's id
 *
 * @return A [List] of a [List] of a [TeamMember]
 */
suspend fun ModrinthConnector.getTeamsMembers(ids: List<String>) =
    request<List<List<TeamMember>>>("/teams") { parameter("ids", ids.merge()) }