package com.example.bankaccountapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bankAccount")
data class BankAccountEntity (
    @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val password: Int,
    val balance: Double,
)