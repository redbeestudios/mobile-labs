package ar.com.composehexagonalarchitecture.data.network.adapter

import android.util.Log
import ar.com.composehexagonalarchitecture.application.port.out.UserRepository
import ar.com.composehexagonalarchitecture.data.network.mapper.UserMapper
import ar.com.composehexagonalarchitecture.data.network.service.UsersService
import ar.com.composehexagonalarchitecture.domain.User
import javax.inject.Inject

class UserAdapter @Inject constructor(private val usersService: UsersService) : UserRepository {

    override suspend fun getUsers(): List<User> = usersService.getUsers(50).body()!!
        .results
        .onEach { Log.d("response-users", it.toString()) }
        .map { userRest -> UserMapper.toDomain(userRest)}
        .onEach { Log.d("response-users-map", it.toString()) }
}
