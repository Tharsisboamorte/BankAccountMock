package com.example.bankaccountapp.navigation

sealed class Screens(val route : String){
    object Login: Screens(route = "login_screen")
    object Home: Screens(route = "home_screen")
    object Landing: Screens(route = "landing_screen")
    object Register: Screens(route = "register_screen")
}
