package com.example.bankaccountapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bankAccount")
data class BankAccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: Int,
    val balance: Double,
) {
    companion object {
        fun empty() = BankAccountEntity(
            id = 0,
            name = "",
            email = "",
            password = 0,
            balance = 0.0,
        )

        fun fakeListOfUser() = listOf(
            BankAccountEntity(
                id = 1,
                name = "Tharsis",
                email = "Tharsisteste@gmail.com",
                password = 1234,
                balance = 2000.0,
            ),
            BankAccountEntity(
                id = 2,
                name = "Larissa",
                email = "larissateste@gmail.com",
                password = 1234,
                balance = 1400.0,
            )
        )
    }
}