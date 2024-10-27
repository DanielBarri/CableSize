package com.sunen.cablesize.view.components.functionsWizard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sunen.cablesize.R
import com.sunen.cablesize.enumerators.ViewIDs
import com.sunen.cablesize.view.components.BigNavButton
import com.sunen.cablesize.view.components.CustomSpacer


@Composable
fun HomeScreen (navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rb_8590),
                contentDescription = "Imagen electricos",
                modifier = Modifier.size(300.dp,300.dp)
            )

            CustomSpacer(height = 25.dp)

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BigNavButton(navController, ViewIDs.WireGaugeCalc.id, ViewIDs.WireGaugeCalc.tag)
            //BigNavButton(navController, ViewIDs.Shop.id, R.string.shop)
            BigNavButton(navController, ViewIDs.NewFeatures.id, ViewIDs.NewFeatures.tag)

        }
    }
}