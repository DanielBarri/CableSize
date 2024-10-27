package com.sunen.cablesize.view.components.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sunen.cablesize.R
import com.sunen.cablesize.enumerators.ViewIDs
import com.sunen.cablesize.staticdata.OnboardingData
import com.sunen.cablesize.view.components.CustomSpacer


@Composable
fun MainOnboarding(navController: NavController) {
    val items = ArrayList<OnboardingData>()

    items.add(
        OnboardingData(
            R.raw.solarlandscape2,
            "Hello!",
            "Welcome to your Electric Calculator! Power up your calculations with ease and accuracy."
        )
    )

    items.add(
        OnboardingData(
            R.raw.baterrypanels,
            "¡Welcome!",
            "Explore advanced features like energy cost estimates and wire size calculation to aid you with your installations."
        )
    )

    items.add(
        OnboardingData(
            R.raw.buildingpanels,
            "¡Lets go!",
            "Get started now! Input your values, and let’s make your calculations electrifyingly simple!."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = {items.size},
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )

    Column(
        modifier = Modifier
            .padding(top= 100.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(state = pagerState) {
            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(items[it].image)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    text = items[it].title,
                    modifier = Modifier.padding(top = 50.dp ),
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = items[it].desc,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            repeat(items.size) {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(10.dp)
                        .width(25.dp)
                        .clip(CircleShape)
                        .background(if (it== pagerState.currentPage) Color.Blue else Color.Gray)
                )
            }
        }
        CustomSpacer(height = 50.dp)
        Box{
            Row {
                if (pagerState.currentPage == items.size - 1) {
                    Button(onClick = {
                        navController.navigate(ViewIDs.Home.id)
                    }) {
                        Text(text = "Enter")
                    }
                }
            }
        }
    }

}