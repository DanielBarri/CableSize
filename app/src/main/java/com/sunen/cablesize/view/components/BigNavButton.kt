package com.sunen.cablesize.view.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BigNavButton(navController: NavController,screen: String, tag: String) {
    Button(
        onClick = {
            navController.navigate(screen)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 30.dp),
        colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(
            text = tag
        )
    }
}