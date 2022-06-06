package ar.com.composehexagonalarchitecture.data.network.service

import ar.com.composehexagonalarchitecture.data.network.model.UserResponseRest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET("/api")
    suspend fun getUsers(@Query("results") results: Int): Response<UserResponseRest>
}