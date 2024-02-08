package com.example.bankaccountapp.data.repository

import com.example.bankaccountapp.database.dao.BankAccountDao
import com.example.bankaccountapp.database.model.BankAccountEntity
import com.example.bankaccountapp.features.viewmodel.bloc.UserState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: BankAccountDao
): UserRepository{

    val getAllUser = userDao.getAccounts()

    val users = MutableStateFlow(userDao.getAccounts())

    val state = MutableStateFlow(UserState())
    override suspend fun createUser(user: BankAccountEntity) {
        return userDao.upsertUser(user)
    }

    override fun isAuthenticated(email: String, password: Int): Flow<Boolean> {
        return userDao.getUserByEmail(inputEmail = email)
            .map { user -> checkUserPassword(user, password)}
    }

    override fun getUserData(email: String): Flow<BankAccountEntity?> {
        return userDao.getUserByEmail(email)
    }

    override fun checkUserPassword(user: BankAccountEntity?, password: Int): Boolean {
        val isAuth =  user?.password == password
        state.update {
            it.copy(
                userIsAuthenticated = isAuth
            )
        }
        return isAuth
    }

    override suspend fun deleteAccount(user: BankAccountEntity?) {
        return userDao.deleteUser(user!!)
    }
}