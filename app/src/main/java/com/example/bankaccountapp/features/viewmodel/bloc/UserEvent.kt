package com.example.bankaccountapp.features.viewmodel.bloc

import com.example.model.BillsData
import com.example.bankaccountapp.database.model.BankAccountEntity as bankAccount

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class SetName(val name: String): UserEvent
    data class SetEmail(val email: String): UserEvent
    data class SetPassword(val password: Int): UserEvent
    data class DeleteUser(val user: bankAccount): UserEvent
    data class GetUserData(val email: String) : UserEvent
    object SetUsersBills : UserEvent
    object PopulateDB : UserEvent
    object UserIsAuthenticated: UserEvent
}