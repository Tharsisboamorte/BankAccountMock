package com.example.bankaccountapp.features.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankaccountapp.data.repository.UserRepositoryImpl
import com.example.bankaccountapp.database.model.BankAccountEntity
import com.example.bankaccountapp.features.viewmodel.bloc.UserEvent
import com.example.bankaccountapp.features.viewmodel.bloc.UserState
import com.example.model.BillsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepo: UserRepositoryImpl
) : ViewModel() {

    private val _users = userRepo.users.value
    private val _state = userRepo.state

    val state = combine(_state, _users) { state, users ->
        state.copy(
            users = users[0],
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserState())

    val getAllUsers = userRepo.getAllUser

    private val listOfBills = BillsData.fakeList()

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.DeleteUser -> {
                viewModelScope.launch {
                    userRepo.deleteAccount(event.user)
                }
            }

            is UserEvent.GetUserData -> {
                userRepo.getUserData(state.value.email)
            }

            UserEvent.SaveUser -> {
                val name = state.value.name
                val email = state.value.email
                val password = state.value.password

                if (name.isBlank() || email.isBlank() || password.isBlank()) {
                    return
                }

                val user = BankAccountEntity(
                    name = name,
                    balance = 0.0,
                    email = email,
                    password = password.toInt(),
                )

                viewModelScope.launch {
                    userRepo.createUser(user)
                }

                _state.update {
                    it.copy(
                        name = "",
                        email = "",
                        password = "",
                    )
                }


            }

            is UserEvent.SetEmail -> {
                _state.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is UserEvent.SetName -> {
                _state.update {
                    it.copy(
                        email = event.name
                    )
                }
            }

            is UserEvent.SetPassword -> {
                _state.update {
                    it.copy(
                        password = event.password.toString()
                    )
                }
            }

            is UserEvent.SetUsersBills -> {
                _state.update {
                    it.copy(
                        billsData = listOfBills
                    )
                }
            }

            UserEvent.UserIsAuthenticated -> {
                val email = state.value.email
                val password = state.value.password


                viewModelScope.launch {
                    val isAuthenticated =
                        userRepo.isAuthenticated(email = email, password = password.toInt()).first()
                    _state.update {
                        it.copy(userIsAuthenticated = isAuthenticated)
                    }
                }
            }

            UserEvent.PopulateDB -> {
                val users = BankAccountEntity.fakeListOfUser()
                for (user in users) {
                    viewModelScope.launch {
                        userRepo.createUser(user)
                    }
                }
            }
        }
    }


}