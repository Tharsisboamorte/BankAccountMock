package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.features.viewmodel.bloc.UserEvent
import com.example.bankaccountapp.features.viewmodel.bloc.UserState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    label: String,
    onEvent: (UserEvent) -> Unit,
    state: UserState,
) {

    Column(
        modifier = Modifier.wrapContentSize()
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.password,
            onValueChange = {
                onEvent(UserEvent.SetPassword(it.toInt()))
                onEvent(UserEvent.UserIsAuthenticated)
            },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
        )
    }
}