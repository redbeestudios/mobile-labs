package ar.com.composehexagonalarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.composehexagonalarchitecture.application.usecase.GetUsersUseCase
import ar.com.composehexagonalarchitecture.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor( //TODO: Deberiamos separar UI STATE de BUSINESS STATE
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _isUsersLoading = MutableStateFlow(false)
    val isUsersLoading: StateFlow<Boolean> = _isUsersLoading

    init {
            viewModelScope.launch(Dispatchers.Main) {
                _isUsersLoading.value = true
                getUsersUseCase.invoke().collect { users ->
                    _users.value = users
                    _isUsersLoading.value = false
                }
            }
        }

  /*  fun getUsers() { //TODO: Usamos init, o llamamos metodos?
        viewModelScope.launch(Dispatchers.Main) {
            _isUsersLoading.value = true
            getUsersUseCase.invoke().collect { users ->
                _users.value = users //TODO: Se puede hacer mas declarativo?
                _isUsersLoading.value = false //TODO: Hay forma mas parecida de hacerlo como en rxjs?
            }
        }
    }*/
}