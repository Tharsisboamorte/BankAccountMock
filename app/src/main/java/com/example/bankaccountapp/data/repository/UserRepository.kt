package com.example.bankaccountapp.data.repository

import com.example.bankaccountapp.database.model.BankAccountEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun isAuthenticated(email: String, password: Int): Flow<Boolean>
    fun getUserData(email: String): Flow<BankAccountEntity?>

    fun checkUserPassword(user: BankAccountEntity?, password: Int): Boolean
}