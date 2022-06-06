package ar.com.composehexagonalarchitecture.data.network.adapter

import android.util.Log
import ar.com.composehexagonalarchitecture.application.port.out.UserRepository
import ar.com.composehexagonalarchitecture.data.network.mapper.UserMapper
import ar.com.composehexagonalarchitecture.data.network.service.UsersService
import ar.com.composehexagonalarchitecture.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class UserAdapter @Inject constructor(private val usersService: UsersService) : UserRepository {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getUsers(): Flow<List<User>> {

        return flow {
            val users = usersService.getUsers(50).body()!! //TODO: Ver
                .results
                .onEach { Log.d("response-users", it.toString()) }
                .map { userRest -> UserMapper.toDomain(userRest)}
                .onEach { Log.d("response-users-map", it.toString()) }

            emit(users)
        }.catch { throw Exception(it.message) }
        .flowOn(dispatcher)
    }
}
