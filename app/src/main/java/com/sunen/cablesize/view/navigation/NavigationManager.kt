package com.sunen.cablesize.view.navigation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sunen.cablesize.enumerators.ViewIDs
import com.sunen.cablesize.view.components.functionsWizard.WireGaugeCalcScreen
import com.sunen.cablesize.view.components.functionsWizard.HomeScreen
import com.sunen.cablesize.view.components.onboarding.MainOnboarding
import com.sunen.cablesize.view.components.onboarding.NewFeaturesOnboarding
import com.sunen.cablesize.view.components.splash.SplashScreen
import com.sunen.cablesize.viewmodel.CableSizeViewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CableSizeAppBar (currentScreen: ViewIDs) {
    CenterAlignedTopAppBar(
        title = { Text(currentScreen.tag)},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Composable
fun NavigationManager(cableSizeViewModel: CableSizeViewModel) {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ViewIDs.valueOf(
        backStackEntry?.destination?.route ?: ViewIDs.Home.id
    )

    Scaffold(
        topBar = {
            if(currentScreen !in listOf(ViewIDs.Splash, ViewIDs.Onboarding)){
                CableSizeAppBar(currentScreen)
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Electric Tools 1.0")
            }
        }
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
            composable(ViewIDs.Onboarding.id) {
                MainOnboarding(navController)
            }
            composable(ViewIDs.Home.id) {
                HomeScreen(navController)
            }
            composable(ViewIDs.WireGaugeCalc.id) {
                WireGaugeCalcScreen(navController, cableSizeViewModel)
            }
            composable(ViewIDs.NewFeatures.id) {
                NewFeaturesOnboarding(navController)
            }
            composable(ViewIDs.Shop.id) {
                Text(text = "Placeholder Shop")
            }

        }
    }
}
