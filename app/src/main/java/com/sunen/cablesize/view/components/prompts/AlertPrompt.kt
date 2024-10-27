package com.sunen.cablesize.view.components.prompts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(
    onDismiss: () ->Unit,
    title: String,
    message: String
) {

    BasicAlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true),
        modifier = Modifier.height(230.dp),

    ){
        Surface(
            modifier = Modifier.fillMaxWidth(),
            tonalElevation = AlertDialogDefaults.TonalElevation,
            color = MaterialTheme.colorScheme.errorContainer,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text(
                    text= title,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                    )
                Text(
                    text= message,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                    )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary)
                    ) { Text(text = "Ok") }
                }
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun ConfirmationPromptPreview() {

    var showDialog by remember { mutableStateOf(true)}


    MaterialTheme {
        Box(
            modifier=   Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(24.dp)
        ){
            if (showDialog) {
                AlertDialog(
                    onDismiss = {showDialog=false},
                    title = "Alert!!",
                    message = "Message"
                )
            }
        }
    }
}