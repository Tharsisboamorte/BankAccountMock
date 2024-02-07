package com.example.bankaccountapp.database.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.bankaccountapp.database.BankAccountDB
import com.example.bankaccountapp.database.dao.BankAccountDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BankAccountDB::class.java,
        "bank_database",
    ).createFromAsset("database/bankUserAccount.db").build()

    @Singleton
    @Provides
    fun provideDao(database: BankAccountDao) = database.getAccounts()
}