package com.example.bankaccountapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bankaccountapp.database.dao.BankAccountDao
import com.example.bankaccountapp.database.model.BankAccountEntity

@Database(
    entities = [
        BankAccountEntity::class,
    ],
    version = 1,
)

abstract class BankAccountDB : RoomDatabase() {
    abstract val dao: BankAccountDao
}