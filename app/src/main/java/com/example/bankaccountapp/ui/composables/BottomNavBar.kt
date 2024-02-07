package com.example.bankaccountapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountapp.ui.theme.BankAccountAppTheme
import com.example.bankaccountapp.ui.theme.PrimaryPurple

@Composable
fun BottomNavBar() {
    var selectedTab by remember { mutableStateOf(0) }

    val items = listOf(
        Icons.Default.Home to "Home",
        Icons.Default.Search to "Search",
        Icons.Default.AddCircle to "Add",
        Icons.Default.Notifications to "Favorite",
        Icons.Default.Person to "Profile"
    )

    NavigationBar {
        items.forEachIndexed { index, (icon) ->
            val isSelected = index == selectedTab
            NavigationBarItem(
                selected = isSelected,
                onClick = { selectedTab = index },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) PrimaryPurple else Color.Gray,
                    )
                },
                alwaysShowLabel = false,
            )
        }
    }
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        contentColor = Color.White,
    ) {
        items.forEachIndexed { index, (icon) ->
            val isSelected = index == selectedTab
            NavigationBarItem(
                selected = isSelected,
                onClick = { selectedTab = index },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) PrimaryPurple else Color.Gray,
                    )
                },
                alwaysShowLabel = false,
            )
        }

    }

}

@Preview
@Composable
fun BottomNavBarPreview(){
    BankAccountAppTheme {
        Surface {
            BottomNavBar()
        }
    }
}