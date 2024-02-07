package com.example.bankaccountapp.data.repository

import com.example.bankaccountapp.database.dao.BankAccountDao
import com.example.bankaccountapp.database.model.BankAccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: BankAccountDao
): UserRepository{

    val getAllUser = userDao.getAccounts()
    override fun isAuthenticated(email: String, password: Int): Flow<Boolean> {
        return userDao.getUserByEmail(inputEmail = email)
            .map { user ->  checkUserPassword(user, password)}
            .catch { emit(false) }
    }

    override fun getUserData(email: String): Flow<BankAccountEntity?> {
        return userDao.getUserByEmail(email)
    }

    override fun checkUserPassword(user: BankAccountEntity?, password: Int): Boolean {
        return user?.password == password
    }
}