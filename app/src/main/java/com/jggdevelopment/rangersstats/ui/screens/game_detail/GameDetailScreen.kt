package com.jggdevelopment.rangersstats.ui.screens.game_detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.model.GameCenter
import com.jggdevelopment.rangersstats.model.TeamLeaders
import com.jggdevelopment.rangersstats.model.mock.fakeGame
import com.jggdevelopment.rangersstats.model.mock.fakePlayerLeader1
import com.jggdevelopment.rangersstats.model.mock.fakePlayerLeader2
import com.jggdevelopment.rangersstats.ui.screens.ErrorScreen
import com.jggdevelopment.rangersstats.ui.screens.home.GameCardContent
import com.jggdevelopment.rangersstats.ui.util.LoadingScreen
import com.jggdevelopment.rangersstats.ui.util.PreviewScreenSize
import com.jggdevelopment.rangersstats.ui.util.debugPlaceholder
import com.jggdevelopment.rangersstats.viewModels.game_detail.GameDetailState

@Composable
fun GameDetailScreen(
    state: GameDetailState,
    onPlayerClick: (Int) -> Unit,
    onRefresh: () -> Unit
) {
    AnimatedContent(
        targetState = state,
        label = "screen state",
        modifier = Modifier.fillMaxSize()
    ) { uiState ->
        when (uiState) {
            is GameDetailState.Loading -> {
                LoadingScreen()
            }
            is GameDetailState.Success -> {
                GameDetailContent(
                    game = uiState.game,
                    teamLeaders = uiState.teamLeaders,
                    onPlayerClick = onPlayerClick
                )
            }
            is GameDetailState.Error -> {
                ErrorScreen(onRefresh)
            }
        }
    }
}

@Composable
private fun GameDetailContent(
    game: GameCenter,
    teamLeaders: List<TeamLeaders>,
    onPlayerClick: (Int) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        GameCardContent(
            awayLogo = game.awayTeam.logo,
            homeLogo = game.homeTeam.logo,
            awayName = game.awayTeam.placeName.default,
            homeName = game.homeTeam.placeName.default,
            gameDate = game.formattedStartDate,
            gameTime = game.formattedStartTimeEastern,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Leaders: Last 5",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        PlayerLeaders(
            game.matchup.teamLeadersL5,
            onPlayerClick = onPlayerClick
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Leaders: Season",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        PlayerLeaders(
            teamLeaders,
            onPlayerClick = onPlayerClick
        )
    }
}

@Composable
private fun PlayerLeaders(
    playerLeaders: List<TeamLeaders>,
    onPlayerClick: (Int) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(playerLeaders) {
            PlayerLeaderRow(
                stat = it,
                onPlayerClick = onPlayerClick
            )
        }
    }
}

@Composable
fun PlayerLeaderRow(
    stat: TeamLeaders,
    onPlayerClick: (Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onPlayerClick(stat.awayLeader.id)
                }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(stat.awayLeader.headshot)
                    .build(),
                placeholder = debugPlaceholder(debugPreview = R.drawable.nyr_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stat.awayLeader.lastName.default,
                maxLines = 2,
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = stat.awayLeader.value.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stat.categoryAbbreviation,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stat.homeLeader.value.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onPlayerClick(stat.homeLeader.id)
                }
        ) {
            Text(
                text = stat.homeLeader.lastName.default,
                maxLines = 2,
                modifier = Modifier.weight(1f)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(stat.homeLeader.headshot)
                    .build(),
                placeholder = debugPlaceholder(debugPreview = R.drawable.nyr_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@PreviewScreenSize
@Composable
private fun GameDetailScreenPreview() {
    MaterialTheme {
        GameDetailScreen(
            state = GameDetailState.Success(
                game = fakeGame,
                teamLeaders = listOf(
                    TeamLeaders(
                        category = "points",
                        awayLeader = fakePlayerLeader1,
                        homeLeader = fakePlayerLeader2
                    ),
                    TeamLeaders(
                        category = "goals",
                        awayLeader = fakePlayerLeader2,
                        homeLeader = fakePlayerLeader1
                    )
                )
            ),
            onPlayerClick = {},
            onRefresh = {}
        )
    }
}
