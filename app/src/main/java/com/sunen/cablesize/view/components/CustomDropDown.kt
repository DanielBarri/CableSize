package com.sunen.cablesize.view.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sunen.cablesize.R
import com.sunen.cablesize.enumerators.ViewModelIDs
import com.sunen.cablesize.staticdata.DataSource
import com.sunen.cablesize.viewmodel.CableSizeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropdown(
    title: String,
    options: List<Pair<String, Double>>,
    startValue: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedText by remember { mutableStateOf(startValue) }
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded },
            modifier = Modifier.width(150.dp).height(50.dp)
        ) {
            TextField(
                modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                scrollState = rememberScrollState()
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option.first) },
                        onClick = {
                            selectedText = option.first
                            onItemSelected(option.second.toString())
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}


@Composable
fun ConductorDropDownMenu(cableSizeViewModel: CableSizeViewModel) {
    val conductorsInPipe = DataSource.wiresInPipeOptions

    CustomDropdown(
        title = stringResource(R.string.conductorsInPipe),
        options = conductorsInPipe,
        startValue = conductorsInPipe[0].first,
        onItemSelected = { selectedValue ->
            cableSizeViewModel.onValue(selectedValue, ViewModelIDs.CondInPipeCorrection.id)
            println("El factor de corrección es: ${cableSizeViewModel.state.condInPipeCorrection}")
        },
        modifier = Modifier.padding(0.dp) // Puedes ajustar el modificador aquí
    )
}

@Composable
fun TemperatureDropDownMenu(cableSizeViewModel: CableSizeViewModel) {
    val temperatureOptions = DataSource.temperatureOptions

    CustomDropdown(
        title = stringResource(R.string.temperature),
        options = temperatureOptions,
        startValue = temperatureOptions[4].first,
        onItemSelected = { selectedValue ->
            cableSizeViewModel.onValue(selectedValue, ViewModelIDs.TemperatureCorrection.id)
            println("El factor de corrección es: ${cableSizeViewModel.state.temperatureCorrection}")
        },
        modifier = Modifier.padding(0.dp) // Puedes ajustar el modificador aquí
    )
}