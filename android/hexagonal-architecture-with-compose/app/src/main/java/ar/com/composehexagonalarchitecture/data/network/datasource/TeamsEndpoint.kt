package ar.com.composehexagonalarchitecture.data.network.datasource

import ar.com.composehexagonalarchitecture.data.network.model.TeamResponseRest
import ar.com.composehexagonalarchitecture.data.network.model.TeamRest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsEndpoint {
    @GET("/api/v1/teams")
    suspend fun getTeams(): Response<TeamResponseRest>

    @GET("/api/v1/teams/{id}")
    suspend fun getTeamById(@Path("id") id: Int): Response<List<TeamRest>>
}