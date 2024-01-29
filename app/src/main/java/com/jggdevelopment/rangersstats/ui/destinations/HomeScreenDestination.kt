package com.jggdevelopment.rangersstats.ui.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jggdevelopment.rangersstats.ui.NavScreens
import com.jggdevelopment.rangersstats.ui.screens.home.HomeScreen
import com.jggdevelopment.rangersstats.viewModels.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeScreenDestination(navController: NavController) {
    composable(NavScreens.HOME) {
        val viewModel = koinViewModel<HomeViewModel>()

        val state by viewModel.state.collectAsState()

        HomeScreen(
            state = state,
            onPlayerClick = {
                navController.navigateToPlayerDetail(it)
            }
        )
    }
}
