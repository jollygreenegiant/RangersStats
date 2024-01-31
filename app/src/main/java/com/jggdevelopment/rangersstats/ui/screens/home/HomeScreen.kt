package com.jggdevelopment.rangersstats.ui.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jggdevelopment.rangersstats.model.Game
import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.mock.fakeGame
import com.jggdevelopment.rangersstats.model.mock.fakeRosterPlayer1
import com.jggdevelopment.rangersstats.model.mock.fakeRosterPlayer2
import com.jggdevelopment.rangersstats.model.mock.fakeRosterPlayer3
import com.jggdevelopment.rangersstats.ui.screens.ErrorScreen
import com.jggdevelopment.rangersstats.ui.util.LoadingScreen
import com.jggdevelopment.rangersstats.ui.util.PreviewScreenSize
import com.jggdevelopment.rangersstats.viewModels.home.HomeUiState
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreen(
    state: HomeUiState,
    onPlayerClick: (Int) -> Unit,
    onGameClick: (Int) -> Unit,
    onRefresh: () -> Unit
) {
    AnimatedContent(
        targetState = state,
        label = "screen state",
        modifier = Modifier.fillMaxSize()
    ) { uiState ->
        when (uiState) {
            is HomeUiState.Loading -> {
                LoadingScreen()
            }
            is HomeUiState.Success -> {
                HomeContent(
                    roster = uiState.roster,
                    record = uiState.record,
                    nextGame = uiState.nextGame,
                    onPlayerClick = onPlayerClick,
                    onGameClick = onGameClick
                )
            }
            is HomeUiState.Error -> {
                ErrorScreen(onRefresh)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    roster: Roster,
    record: String,
    nextGame: Game,
    onPlayerClick: (Int) -> Unit,
    onGameClick: (Int) -> Unit
) {
    LazyColumn {
        stickyHeader {
            TeamHeader(
                record = record
            )
        }
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Next Game",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                GameCard(
                    game = nextGame,
                    onClick = onGameClick
                )
            }
        }
        item {
            Text(
                "Roster",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            )
        }
        items(
            items = roster.allPlayers,
            key = { it.id }
        ) {
            PlayerRow(
                player = it,
                modifier = Modifier
                    .clickable {
                        onPlayerClick(it.id)
                    }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@PreviewScreenSize
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            state = HomeUiState.Success(
                roster = Roster(
                    forwards = persistentListOf(
                        fakeRosterPlayer1,
                        fakeRosterPlayer2,
                        fakeRosterPlayer3
                    ),
                    defensemen = persistentListOf(),
                    goalies = persistentListOf()
                ),
                record = "21-2-3",
                nextGame = fakeGame
            ),
            onPlayerClick = { },
            onGameClick = { },
            onRefresh = { }
        )
    }
}
