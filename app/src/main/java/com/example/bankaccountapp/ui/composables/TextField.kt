package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.features.viewmodel.bloc.UserEvent
import com.example.bankaccountapp.features.viewmodel.bloc.UserState
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTextField(
    label: String,
    type: KeyboardType,
    onEvent: (UserEvent) -> Unit,
    state: UserState,
) {

    val emailLabel = stringResource(id = R.string.email)
    val nameLabel = stringResource(id = R.string.name)

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
            value = if(label == emailLabel) state.email else state.name,
            onValueChange = {
                if(label == emailLabel){
                    onEvent(UserEvent.SetEmail(it))
                }
                if (label == nameLabel){
                    onEvent(UserEvent.SetName(it))
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = type
            ),
        )
    }
}