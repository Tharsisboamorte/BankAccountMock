package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

@Composable
fun UserCard() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.user_card),
            contentDescription = "Credit card",
        )
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp).wrapContentSize()
        ) {
            Column {
                Text(
                    text = "Balance",
                    style = TextStyle(
                        color = Color.White,
                    ),
                )
                Text(
                    text = "R$ 20.000,00",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Column(
                    Modifier.padding(end = 160.dp)
                ) {
                    Text(
                        text = "Account Number",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Text(
                        text = "*** *** *** 8399",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.mc_symbol),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun UserCardPreview() {
    BankAccountAppTheme {
        Surface {
            UserCard()
        }
    }
}