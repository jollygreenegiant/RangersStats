package com.jggdevelopment.rangersstats.ui.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jggdevelopment.rangersstats.ui.NavScreens
import com.jggdevelopment.rangersstats.ui.screens.player_detail.PlayerDetailScreen
import com.jggdevelopment.rangersstats.view_models.player_detail.PlayerDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavController.navigateToPlayerDetail(playerId: Int) {
    navigate(NavScreens.PLAYER_DETAIL + "/$playerId")

}

fun NavGraphBuilder.playerDetailDestination(navController: NavController) {
    composable("${NavScreens.PLAYER_DETAIL}/{playerId}") { backStackEntry ->
        // Normally we would handle this error state more elegantly
        val playerId = backStackEntry.arguments?.getString("playerId")?.toInt() ?: 0
        val playerViewModel: PlayerDetailViewModel = koinViewModel(
            parameters = { parametersOf(playerId) }
        )

        val player by playerViewModel.player.collectAsState()

        PlayerDetailScreen(
            player = player,
            onRefresh = { playerViewModel.getPlayer(playerId) }
        )
    }
}
