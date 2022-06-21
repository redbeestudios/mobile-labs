package ar.com.composehexagonalarchitecture.data.network.repository

import android.util.Log
import ar.com.composehexagonalarchitecture.application.repository.IUserRepository
import ar.com.composehexagonalarchitecture.data.network.mapper.UserMapper
import ar.com.composehexagonalarchitecture.data.network.datasource.UsersEndpoint
import ar.com.composehexagonalarchitecture.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val usersEndpoint: UsersEndpoint) :
    IUserRepository {

    override suspend fun getUsers(): List<User> = usersEndpoint.getUsers(50).body()!! //TODO: Manejo de error
        .results
        .onEach { Log.d("response-users", it.toString()) }
        .map { userRest -> UserMapper.toDomain(userRest) }
        .onEach { Log.d("response-users-map", it.toString()) }
}
