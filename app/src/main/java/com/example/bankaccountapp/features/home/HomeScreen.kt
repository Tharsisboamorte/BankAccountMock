package com.example.bankaccountapp.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.ui.composables.BottomNavBar
import com.example.bankaccountapp.ui.composables.UserCard
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 5.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                text = "Good Morning, User!",
                style = MaterialTheme.typography.headlineSmall.merge(
                    TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                ),
            )
            Box(
                modifier = Modifier.wrapContentSize()
            ) {
                UserCard()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    BankAccountAppTheme {
        Surface {
            HomeScreen()
        }
    }
}