package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme
import com.example.bankaccountapp.ui.theme.PrimaryPurple
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun BillsItem(
    title: String,
    day: String,
    month: String,
    year: String,
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleSmall)
            Text(text = "$month $day, $year")
        }
        BaseButton(
            modifier = Modifier.width(105.dp),
            onClick = { /*TODO*/ },
            border = BorderStroke(2.dp, color = PrimaryPurple),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
        ) {
            Text(text = "Pay", color = PrimaryPurple)
        }
    }
}