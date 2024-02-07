package com.example.bankaccountapp.features.viewmodel.bloc

import com.example.bankaccountapp.database.model.BankAccountEntity as bankAccount


data class UserState(
    val users: List<bankAccount> = emptyList(),
    val firstName: String = "",
    val email: String = "",
    val password: Int = 0,
)