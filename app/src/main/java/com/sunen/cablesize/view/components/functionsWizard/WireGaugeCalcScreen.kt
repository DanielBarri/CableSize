package com.sunen.cablesize.view.components.functionsWizard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sunen.cablesize.R
import com.sunen.cablesize.enumerators.ViewIDs
import com.sunen.cablesize.enumerators.ViewModelIDs
import com.sunen.cablesize.view.components.BigNavButton
import com.sunen.cablesize.view.components.ConductorDropDownMenu
import com.sunen.cablesize.view.components.CustomSpacer
import com.sunen.cablesize.view.components.TemperatureDropDownMenu
import com.sunen.cablesize.view.components.TitleLarge
import com.sunen.cablesize.viewmodel.CableSizeViewModel


@Composable
fun WireGaugeCalcScreen (navController: NavController,
                         cableSizeViewModel: CableSizeViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            TitleLarge(text = stringResource(R.string.wireGaugeCalc))
            CustomSpacer(height = 16.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.electricCharge))

                TextField(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    value = cableSizeViewModel.state.electricCharge,
                    onValueChange = { newValue ->
                        cableSizeViewModel.onValue(newValue, ViewModelIDs.ElectricCharge.id)
                        println("Electric charge: " + cableSizeViewModel.state.electricCharge)
                    },
                    placeholder = { Text(text = "Numbers only") },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.conductorsPerPhase))

                TextField(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    value = cableSizeViewModel.state.conductorsPerPhase,
                    onValueChange = { newOption ->
                        cableSizeViewModel.onValue(newOption, ViewModelIDs.ConductorsPerPhase.id)
                        println("Conductors per phase: " + cableSizeViewModel.state.conductorsPerPhase)
                    },
                    placeholder = { Text(text = "Numbers only") },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
            }
            ConductorDropDownMenu(cableSizeViewModel)
            TemperatureDropDownMenu(cableSizeViewModel)
            CustomSpacer(height = 10.dp)
            Button(
                onClick = {
                    cableSizeViewModel.calculateCorrectedCharge()
                    cableSizeViewModel.calculateRecommendedConductor()
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
                    text = stringResource(R.string.calculate)
                )
            }

            CustomSpacer(height = 10.dp)
            HorizontalDivider(thickness = 1.dp)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleLarge(text = "Results")
            Text( text = "Recommended wire size: ")
            CustomSpacer(height = 16.dp)
            Text( text = cableSizeViewModel.state.recommendedConductor, fontSize = 80.sp)
        }



    }
}