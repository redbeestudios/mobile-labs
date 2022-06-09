package ar.com.composehexagonalarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.composehexagonalarchitecture.application.service.UserService
import ar.com.composehexagonalarchitecture.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor( //TODO: Deberiamos separar UI STATE de BUSINESS STATE
    private val userService: UserService
) : ViewModel() {

    val users: StateFlow<List<User>> = userService.users.map { it ?: emptyList() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val error: StateFlow<Throwable?> = userService.error
    val loading: StateFlow<Boolean> = userService.users
        .combine(error) { users, error -> users == null && error == null }
        .stateIn(viewModelScope, SharingStarted.Eagerly, true)


    fun refresh() {
        userService.refreshAllUsers()
    }
}