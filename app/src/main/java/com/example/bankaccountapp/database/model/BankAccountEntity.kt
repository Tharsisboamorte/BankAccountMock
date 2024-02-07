package com.example.bankaccountapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bankAccount")
data class BankAccountEntity (
    @PrimaryKey
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: Int,
    val balance: Double,
){
    companion object{
        fun empty() = BankAccountEntity(
            id = 0,
            name = "",
            email = "",
            password = 0,
            balance = 0.0,
        )
    }
}