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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.R
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTextField(
    label: String,
    type: KeyboardType,
    onValueChange: (String) -> Unit
) {

    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.wrapContentSize()
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = text,
            onValueChange = {
                onValueChange(it)
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = type
            ),
        )
    }
}

@Preview
@Composable
fun TextFieldPreview(){
    BankAccountAppTheme {
        Surface(
            modifier = Modifier.height(155.dp)
        ) {
            BaseTextField(
                label = stringResource(R.string.email),
                type = KeyboardType.Email,
                onValueChange = {}
            )
        }
    }
}