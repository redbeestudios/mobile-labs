package ar.com.composehexagonalarchitecture.application.port.out

import ar.com.composehexagonalarchitecture.domain.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): Flow<List<User>>
}