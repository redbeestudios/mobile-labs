package ar.com.composehexagonalarchitecture.application.port.out

import ar.com.composehexagonalarchitecture.domain.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}