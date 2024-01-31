package com.jggdevelopment.rangersstats.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.model.RosterPlayer
import com.jggdevelopment.rangersstats.model.mock.fakeRosterPlayer1
import com.jggdevelopment.rangersstats.ui.util.debugPlaceholder

@Composable
fun PlayerRow(
    player: RosterPlayer,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        AsyncImage(
            model = player.headshot,
            placeholder = debugPlaceholder(R.drawable.nyr_logo),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "${player.firstName.default} ${player.lastName.default}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = player.positionString,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "#${player.sweaterNumber}")
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayerRowPreview() {
    MaterialTheme {
        PlayerRow(
            player = fakeRosterPlayer1
        )
    }
}
