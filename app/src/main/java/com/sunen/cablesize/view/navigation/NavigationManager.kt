package com.sunen.cablesize.view.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sunen.cablesize.enumerators.ViewIDs
import com.sunen.cablesize.view.components.functionsWizard.WireGaugeCalcScreen
import com.sunen.cablesize.view.components.functionsWizard.HomeScreen
import com.sunen.cablesize.view.components.splash.SplashScreen
import com.sunen.cablesize.viewmodel.CableSizeViewModel

//Todo: Crear funcion para el topbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CableSizeAppBar () {
    CenterAlignedTopAppBar(
        title = {},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

//Todo: Crear el nav manager
@Composable
fun NavigationManager(cableSizeViewModel: CableSizeViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {CableSizeAppBar()},
        bottomBar = { Text(text = "I am the bottom container")}
    ) {
        NavHost(
            navController = navController,
            startDestination = ViewIDs.Splash.id ,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable(ViewIDs.Splash.id) {
                SplashScreen(navController)
            }
            composable(ViewIDs.Home.id) {
                HomeScreen(navController, cableSizeViewModel)
            }
            composable(ViewIDs.WireGaugeCalc.id) {
                WireGaugeCalcScreen(navController, cableSizeViewModel)
            }
            composable(ViewIDs.Shop.id) {
                Text(text = "Placeholder Shop")
            }

        }
    }
}
