package com.jggdevelopment.rangersstats.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.model.Game
import com.jggdevelopment.rangersstats.model.mock.fakeGame
import com.jggdevelopment.rangersstats.ui.util.debugPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(
    game: Game,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onClick(game.id) },
        modifier = modifier
    ) {
        GameCardContent(
            awayLogo = game.awayTeam.logo,
            homeLogo = game.homeTeam.logo,
            awayName = game.awayTeam.placeName.default,
            homeName = game.homeTeam.placeName.default,
            gameDate = game.formattedStartDate,
            gameTime = game.formattedStartTimeEastern,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun GameCardContent(
    awayLogo: String,
    homeLogo: String,
    awayName: String,
    homeName: String,
    gameDate: String,
    gameTime: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            TeamDisplay(
                logo = awayLogo,
                name = awayName,
                modifier = Modifier.weight(1f)
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "@")
                Spacer(modifier = Modifier.height(8.dp))
                GameDate(
                    date = gameDate,
                    time = gameTime
                )
            }
            TeamDisplay(
                logo = homeLogo,
                name = homeName,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun GameDate(
    date: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = date,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = time,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun TeamDisplay(
    logo: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(logo)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            placeholder = debugPlaceholder(debugPreview = R.drawable.nyr_logo),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun GameCardPreview() {
    MaterialTheme {
        GameCard(
            game = fakeGame,
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
