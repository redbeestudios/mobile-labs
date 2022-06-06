package ar.com.composehexagonalarchitecture.data.network.service

import ar.com.composehexagonalarchitecture.data.network.model.TeamResponseRest
import ar.com.composehexagonalarchitecture.data.network.model.TeamRest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsService {
    @GET("/api/v1/teams")
    suspend fun getTeams(): Response<TeamResponseRest>

    @GET("/api/v1/teams/{id}")
    suspend fun getTeamById(@Path("id") id: Int): Response<List<TeamRest>>
}