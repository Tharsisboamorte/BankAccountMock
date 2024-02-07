package com.example.bankaccountapp.features.viewmodel.bloc

import com.example.model.BillsData
import com.example.bankaccountapp.database.model.BankAccountEntity as bankAccount

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class SetName(val name: String): UserEvent
    data class SetEmail(val email: String): UserEvent
    data class SetPassword(val password: String): UserEvent
    data class DeleteUser(val user: bankAccount): UserEvent
    data class GetUserData(val user: bankAccount) : UserEvent
    data class SetUsersBills(val billsData: List<BillsData>) : UserEvent

    object UserIsAuthenticated: UserEvent
}