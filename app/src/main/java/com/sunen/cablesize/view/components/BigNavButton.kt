package com.sunen.cablesize.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sunen.cablesize.R
import com.sunen.cablesize.enumerators.ViewIDs

@Composable
fun BigNavButton(navController: NavController,string: String, int: Int) {
    Button(
        onClick = {
            navController.navigate(string)
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
            text = stringResource(int)
        )
    }
}