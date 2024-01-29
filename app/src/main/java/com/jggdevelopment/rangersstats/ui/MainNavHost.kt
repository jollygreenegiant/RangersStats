package com.jggdevelopment.rangersstats.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jggdevelopment.rangersstats.ui.destinations.homeScreenDestination
import com.jggdevelopment.rangersstats.ui.destinations.playerDetailDestination

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreens.HOME) {
        homeScreenDestination(navController)
        playerDetailDestination(navController)
    }
}
