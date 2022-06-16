package ar.com.composehexagonalarchitecture.application.repository

import ar.com.composehexagonalarchitecture.domain.User

interface IUserRepository {
    suspend fun getUsers(): List<User>
}