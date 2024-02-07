package com.example.bankaccountapp.data.repository

import com.example.bankaccountapp.database.model.BankAccountEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun createUser(user: BankAccountEntity)
    fun isAuthenticated(email: String, password: Int): Flow<Boolean>
    fun getUserData(email: String): Flow<BankAccountEntity?>
    fun checkUserPassword(user: BankAccountEntity?, password: Int): Boolean
    suspend fun deleteAccount(user: BankAccountEntity?)
}