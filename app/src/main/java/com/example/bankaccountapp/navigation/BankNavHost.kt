package com.example.bankaccountapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.bankaccountapp.features.view.home.homeScreen
import com.example.bankaccountapp.features.view.home.navigateToHome
import com.example.bankaccountapp.features.view.login.loginNavigationRoute
import com.example.bankaccountapp.features.view.login.loginScreen
import com.example.bankaccountapp.features.viewmodel.bloc.UserState

@Composable
fun BankNavHost(
    navController: NavHostController,
    startDestination: String = loginNavigationRoute,
    state: UserState
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        ) {
        loginScreen(
            navigateToHome = {navController.navigateToHome()}
        )
        homeScreen(
            state = state
        )
    }

}