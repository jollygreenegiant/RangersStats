package com.jggdevelopment.rangersstats.ui.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jggdevelopment.rangersstats.ui.NavScreens
import com.jggdevelopment.rangersstats.ui.screens.game_detail.GameDetailScreen
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavController.navigateToGameDetail(gameId: Int) {
    navigate("${NavScreens.GAME_DETAIL}/$gameId")
}

fun NavGraphBuilder.gameDetailDestination(navController: NavController) {
    composable(
        route = "${NavScreens.GAME_DETAIL}/{gameId}",
        arguments = listOf(
            navArgument("gameId") {
                defaultValue = 0
            }
        )
    ) { backStackEntry ->
        // Normally we would handle this error state more elegantly
        val gameId = backStackEntry.arguments?.getInt("gameId") ?: 0
        val viewModel: GameDetailViewModel = koinViewModel(
            parameters = { parametersOf(gameId) }
        )
        val state by viewModel.state.collectAsState()

        GameDetailScreen(
            state = state,
            onPlayerClick = { navController.navigateToPlayerDetail(it) },
            onRefresh = { viewModel.getGame(gameId) }
        )
    }
}
