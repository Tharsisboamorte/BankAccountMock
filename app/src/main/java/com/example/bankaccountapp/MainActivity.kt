package com.example.bankaccountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.room.Room
import com.example.bankaccountapp.data.repository.UserRepositoryImpl
import com.example.bankaccountapp.database.di.DatabaseModule
import com.example.bankaccountapp.features.view.login.LoginScreen
import com.example.bankaccountapp.features.viewmodel.MainViewModel
import com.example.bankaccountapp.navigation.BankNavHost
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val db = DatabaseModule.provideDatabase(applicationContext)

    private val userRepo = UserRepositoryImpl(db.bankAccountDao())

    private val viewModel by viewModels<MainViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel(userRepo) as T
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAccountAppTheme {
                val state by viewModel.state.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BankNavHost(
                        navController = navController,
                        state = state,
                    )
                }
            }
        }
    }
}