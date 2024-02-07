package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme
import com.example.bankaccountapp.ui.theme.PrimaryPurple

@Composable
fun RememberMe() {
    var rememberMe by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = rememberMe,
            onCheckedChange = { isChecked ->
                rememberMe = isChecked
            },
            modifier = Modifier.padding(end = 2.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryPurple,
                checkmarkColor = Color.White,
                uncheckedColor = PrimaryPurple
            ),
        )

        Text(
            text = stringResource(R.string.remember_me),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
    }

}

@Preview
@Composable
fun RememberMePreview(){
    BankAccountAppTheme {
        Surface {
            RememberMe()
        }
    }
}