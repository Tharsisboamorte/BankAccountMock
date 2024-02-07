package com.example.bankaccountapp.features.viewmodel.bloc

import com.example.bankaccountapp.database.model.BankAccountEntity as bankAccount

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class SetFirstName(val firstName: String): UserEvent
    data class SetEmail(val email: String): UserEvent
    data class SetPassword(val password: Int): UserEvent
    data class DeleteUser(val user: bankAccount): UserEvent
    data class GetUserData(val user: bankAccount) : UserEvent
}