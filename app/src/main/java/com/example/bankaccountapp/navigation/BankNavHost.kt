package com.example.bankaccountapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bankaccountapp.features.view.home.HomeScreen
import com.example.bankaccountapp.features.view.landingPage.LandingScreen
import com.example.bankaccountapp.features.view.login.LoginScreen
import com.example.bankaccountapp.features.viewmodel.bloc.UserEvent
import com.example.bankaccountapp.features.viewmodel.bloc.UserState

@Composable
fun BankNavHost(
    navController: NavHostController,
    state: UserState,
    onEvent: (UserEvent) -> Unit
) {

    onEvent(UserEvent.SetUsersBills)
    NavHost(
        navController = navController,
        startDestination = Screens.Landing.route,
        ) {
        composable(
            route = Screens.Landing.route
        ){
            LandingScreen(
                onEvent = onEvent,
                state = state,
                navController = navController
            )
        }
        composable(
            route = Screens.Login.route
        ){
            LoginScreen(
                navController = navController,
                onEvent = onEvent,
                state = state
            )
        }
        composable(
            route = Screens.Home.route
        ){
            HomeScreen(
                state = state,
                navController = navController
            )
        }
    }

}