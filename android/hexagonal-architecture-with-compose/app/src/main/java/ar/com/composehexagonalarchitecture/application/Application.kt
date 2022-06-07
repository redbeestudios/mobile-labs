package ar.com.composehexagonalarchitecture.application

import ar.com.composehexagonalarchitecture.application.service.UserService
import javax.inject.Inject

class Application @Inject constructor(
    private val userService: UserService
) {
    val user: UserService get() = userService

    fun initialize() {
        userService.initialize()
    }
}