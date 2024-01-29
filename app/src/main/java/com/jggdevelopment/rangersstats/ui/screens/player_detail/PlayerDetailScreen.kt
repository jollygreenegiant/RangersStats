package com.jggdevelopment.rangersstats.ui.screens.player_detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.model.PlayerGameStats
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats
import com.jggdevelopment.rangersstats.model.mock.mockRosterPlayerWithStats
import com.jggdevelopment.rangersstats.ui.theme.RangersWhite
import com.jggdevelopment.rangersstats.ui.util.LoadingScreen
import com.jggdevelopment.rangersstats.ui.util.PreviewScreenSize
import com.jggdevelopment.rangersstats.ui.util.debugPlaceholder
import com.jggdevelopment.rangersstats.util.RangersResult
import eu.wewox.lazytable.LazyTable
import eu.wewox.lazytable.LazyTableItem

@Composable
fun PlayerDetailScreen(
    player: RangersResult<RosterPlayerWithStats>,
    onBackClick: () -> Unit
) {
    AnimatedContent(targetState = player, label = "screen animation") { result ->
        result.handleUi(
            onSuccess = {
                PlayerDetailContent(
                    player = it
                )
            },
            onLoading = {
                LoadingScreen()
            },
            onError = {
                Text("Error")
            }
        )
    }
}

@Composable
fun PlayerDetailContent(
    player: RosterPlayerWithStats
) {
    Column {
        PlayerBanner(
            headshotUrl = player.headshot,
            number = player.sweaterNumber.toString(),
            position = player.shortPositionString
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = player.fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${player.heightInFreedomUnits}, ${player.weightInPounds}lbs",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Last 5 Games",
                style = MaterialTheme.typography.headlineMedium,
            )
            Last5Games(player.last5Games)
        }
    }
}

@Composable
private fun Last5Games(games: List<PlayerGameStats>) {
    val columns = 11
    val rows = games.size + 1


    LazyTable {
        items(
            count = columns * rows,
            layoutInfo = {
                LazyTableItem(
                    column = it % columns,
                    row = it / columns
                )
            }
        ) {
            val row = it / columns
            if (row == 0) {
                HeaderCell(column = it % columns)
            } else {
                PlayerStatsCell(
                    game = games[row - 1],
                    column = it % columns
                )
            }
        }
    }
}

@Composable
private fun HeaderCell(
    column: Int
) {
    val content = when (column) {
        0 -> "Game"
        1 -> "G"
        2 -> "A"
        3 -> "P"
        4 -> "+/-"
        5 -> "PIM"
        6 -> "S"
        7 -> "Shifts"
        8 -> "TOI"
        9 -> "PPG"
        10 -> "SHG"

        else -> error("Unknown column index: $column")
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = content)
    }
}

@Composable
private fun PlayerStatsCell(
    game: PlayerGameStats,
    column: Int,
) {
    val content = when (column) {
        0 -> game.gameDescription
        1 -> game.goals.toString()
        2 -> game.assists.toString()
        3 -> game.points.toString()
        4 -> game.plusMinus.toString()
        5 -> game.pim.toString()
        6 -> game.shots.toString()
        7 -> game.shifts.toString()
        8 -> game.toi
        9 -> game.powerPlayGoals.toString()
        10 -> game.shorthandedGoals.toString()

        else -> error("Unknown column index: $column")
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = content)
    }
}

@Composable
private fun PlayerBanner(
    headshotUrl: String,
    number: String,
    position: String,
) {
    ConstraintLayout {
        val (teamHeader, headshot) = createRefs()

        TeamBanner(
            number = number,
            position = position,
            modifier = Modifier
                .constrainAs(teamHeader) { }
                .height(100.dp)
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(headshotUrl)
                .build(),
            placeholder = debugPlaceholder(debugPreview = R.drawable.nyr_logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(RangersWhite)
                .constrainAs(headshot) {
                    centerAround(teamHeader.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@PreviewScreenSize
@Composable
private fun PlayerDetailScreenPreview() {
    MaterialTheme {
        PlayerDetailScreen(
            player = RangersResult.Success(mockRosterPlayerWithStats),
            onBackClick = {}
        )
    }
}
