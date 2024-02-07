package com.example.bankaccountapp.features.view.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val loginNavigationRoute = "login_route"
fun NavController.navigateToLogin() {
    this.navigate(loginNavigationRoute)
}

fun NavGraphBuilder.loginScreen(
    navigateToHome: () -> Unit,
) {
    composable(
        route = loginNavigationRoute
    ) {
        LoginRoute(
            navigateToHome = navigateToHome
        )
    }
}
