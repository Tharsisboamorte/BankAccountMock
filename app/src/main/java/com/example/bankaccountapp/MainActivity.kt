package com.example.bankaccountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.bankaccountapp.data.repository.UserRepositoryImpl
import com.example.bankaccountapp.database.BankAccountDB
import com.example.bankaccountapp.features.viewmodel.MainViewModel
import com.example.bankaccountapp.navigation.BankNavHost
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        val db by lazy {
            Room.databaseBuilder(
                applicationContext,
                BankAccountDB::class.java,
                "bankDatabase",
            ).build()
        }

        val userRepo = UserRepositoryImpl(db.dao)

        val viewModel by viewModels<MainViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return MainViewModel(userRepo) as T
                    }
                }
            }
        )


        super.onCreate(savedInstanceState)
        setContent {
            BankAccountAppTheme {
                val state by viewModel.state.collectAsState()
                navController = rememberNavController()
                BankNavHost(
                    navController = navController,
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}