package ar.com.composehexagonalarchitecture.application.service

import ar.com.composehexagonalarchitecture.application.port.out.UserRepository
import ar.com.composehexagonalarchitecture.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(
    private val userRepository: UserRepository
) {
    private var dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val errorFlow = MutableStateFlow<Throwable?>(null)
    private val usersFlow = MutableStateFlow<List<User>?>(null)

    val users: StateFlow<List<User>?> get() = usersFlow.asStateFlow()
    val error: StateFlow<Throwable?> get() = errorFlow.asStateFlow()

    fun initialize() {
        MainScope().launch(dispatcher) {
            refresh()
        }
    }

    fun initialize(dispatcher: CoroutineDispatcher) {
        this.dispatcher = dispatcher
        initialize()
    }


    fun refreshAllUsers() {
        MainScope().launch(dispatcher) {
            refresh()
        }
    }


    private suspend fun refresh() {
        val users: List<User>

        try {
            users = userRepository.getUsers()
        } catch (e: Throwable) {
            errorFlow.emit(e)
            return
        }

        usersFlow.emit(users)
    }
}