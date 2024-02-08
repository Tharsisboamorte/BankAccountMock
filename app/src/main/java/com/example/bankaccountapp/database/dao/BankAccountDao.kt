package com.example.bankaccountapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.bankaccountapp.database.model.BankAccountEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface BankAccountDao {

    @Upsert
    suspend fun upsertUser(user: BankAccountEntity)

    @Query(value = "SELECT * FROM bankAccount")
    fun getAccounts(): Flow<List<BankAccountEntity>>

    @Query(value = "SELECT * FROM bankAccount WHERE email = :inputEmail")
    fun getUserByEmail(inputEmail: String): Flow<BankAccountEntity>

    @Delete
    suspend fun deleteUser(user: BankAccountEntity)
}