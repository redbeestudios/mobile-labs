package ar.com.composehexagonalarchitecture.data.network.datasource

import ar.com.composehexagonalarchitecture.data.network.model.UserResponseRest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersEndpoint {
    @GET("/api")
    suspend fun getUsers(@Query("results") results: Int): Response<UserResponseRest>
}