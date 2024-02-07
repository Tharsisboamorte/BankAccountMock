package com.example.bankaccountapp.features.view.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.ui.composables.BaseTextField
import com.example.bankaccountapp.ui.composables.BaseButton
import com.example.bankaccountapp.ui.composables.PasswordField
import com.example.bankaccountapp.ui.composables.RememberMe
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme
import com.example.bankaccountapp.ui.theme.PrimaryPurple


@Composable
fun LoginRoute(
    navigateToHome: () -> Unit,
) {
    LoginScreen(
        navigateToHome = navigateToHome
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 12.dp, end = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(stringResource(R.string.login_title))
            Spacer(modifier = Modifier.height(20.dp))
            BaseTextField(
                label = stringResource(R.string.email),
                type = KeyboardType.Email,
                onValueChange = {},
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordField(
                label = stringResource(R.string.password),
                onValueChange = {},
            )
            Spacer(modifier = Modifier.height(20.dp))
            RememberMe()
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BaseButton(
                    onClick = {
                              
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryPurple,
                    ),
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}