package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme

@Composable
fun BaseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 14.dp, vertical = 16.dp),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        content = content
    )
}

@Preview
@Composable
private fun SavesButtonEnabledPreview() {
    BankAccountAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BaseButton(
                onClick = {},
                content = { Text("Saves button") },
                enabled = true
            )
        }
    }
}

@Preview
@Composable
private fun SavesButtonDisabledPreview() {
    BankAccountAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BaseButton(
                onClick = {},
                content = { Text("Saves button") },
                enabled = false
            )
        }
    }
}