package com.example.bankaccountapp.features.view.landingPage

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bankaccountapp.R
import com.example.bankaccountapp.features.viewmodel.bloc.UserEvent
import com.example.bankaccountapp.features.viewmodel.bloc.UserState
import com.example.bankaccountapp.navigation.Screens
import com.example.bankaccountapp.ui.composables.BaseButton
import com.example.bankaccountapp.ui.theme.PrimaryPurple


@Composable
fun LandingRoute(
    navigateToLogin: NavController,
    onEvent:(UserEvent) -> Unit,
    state: UserState
) {
    LandingScreen(
        navController = navigateToLogin,
        onEvent = onEvent,
        state = state
    )
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(
    navController: NavController,
    onEvent:(UserEvent) -> Unit,
    state: UserState
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.landing_page),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 25.dp, start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    stringResource(id = R.string.welcome),
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    stringResource(id = R.string.fipay_presentation),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(28.dp))
                BaseButton(
                    onClick = { navController.navigate(route = Screens.Login.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryPurple
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.sign_in))
                }
                Spacer(modifier = Modifier.height(20.dp))
                BaseButton(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.sign_up))
                }
            }
        }
    }
}