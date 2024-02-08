package com.example.bankaccountapp.features.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bankaccountapp.features.viewmodel.bloc.UserState
import com.example.bankaccountapp.ui.composables.BottomNavBar
import com.example.bankaccountapp.ui.composables.UserCard
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme
import com.example.bankaccountapp.ui.theme.PrimaryPurple




//@Composable
//fun HomeRoute(
////    navigateToIncome: () -> Unit,
////    navigateToExpense: () -> Unit,
////    navigateToTransactions: () -> Unit,
//    state: UserState,
//) {
//    HomeScreen(
////        navigateToIncome = navigateToIncome,
////        navigateToExpense = navigateToExpense,
////        navigateToTransactions = navigateToTransactions,
//        uiState = state
//    )
//}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    state: UserState
) {
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
                text = "Good Morning, ${state.name}!",
                style = MaterialTheme.typography.headlineSmall.merge(
                    TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                ),
            )
            Box(
                modifier = Modifier.wrapContentSize()
            ) {
                UserCard(state.balance)
            }
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, end = 25.dp, start = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Upcoming bills",
                    style = MaterialTheme.typography.bodyLarge.merge(
                        TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ),
                )
                Text(
                    text = "See all",
                    modifier = Modifier.clickable { },
                    color = PrimaryPurple,
                )
            }
            LazyColumn( ) {
                //TODO: Implement LazyCColumn List Items
            }
        }
    }
}