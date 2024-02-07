package com.example.bankaccountapp.features.viewmodel.bloc

import com.example.model.BillsData
import com.example.bankaccountapp.database.model.BankAccountEntity as bankAccount


data class UserState(
    val users: bankAccount = bankAccount.empty(),
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val balance: Int = 0,
    val billsData: List<BillsData> = emptyList()
)