package com.jggdevelopment.rangersstats.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.jggdevelopment.rangersstats.model.mock.mockGame
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
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                TeamDisplay(
                    logo = game.awayTeam.logo,
                    name = game.awayTeam.placeName.default,
                    modifier = Modifier.weight(1f)
                )
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "@")
                    Spacer(modifier = Modifier.height(8.dp))
                    GameDate(
                        date = game.formattedStartDate,
                        time = game.formattedStartTimeEastern
                    )
                }
                TeamDisplay(
                    logo = game.homeTeam.logo,
                    name = game.homeTeam.placeName.default,
                    modifier = Modifier.weight(1f)
                )
            }
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
            fontWeight = FontWeight.Bold
        )
        Text(
            text = time,
            fontStyle = FontStyle.Italic
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
            game = mockGame,
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
