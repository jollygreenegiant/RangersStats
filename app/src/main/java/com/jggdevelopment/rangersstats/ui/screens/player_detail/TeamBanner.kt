package com.jggdevelopment.rangersstats.ui.screens.player_detail

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jggdevelopment.rangersstats.ui.theme.RangersBlue
import com.jggdevelopment.rangersstats.ui.theme.RangersFont
import com.jggdevelopment.rangersstats.ui.theme.RangersRed
import com.jggdevelopment.rangersstats.ui.theme.RangersWhite

@Composable
fun TeamBanner(
    number: String,
    position: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(RangersBlue)
    ) {
        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (stripes1, stripes2) = createRefs()

            CornerStripes(
                modifier = Modifier
                    .constrainAs(stripes1) {
                        centerAround(parent.start)
                    }
                    .fillMaxWidth(0.3f)
                    .height(40.dp)
                    .rotate(-45f)
                    .offset(x = 20.dp, y = 20.dp)
            )

            CornerStripes(
                modifier = Modifier
                    .constrainAs(stripes2) {
                        centerAround(parent.end)
                    }
                    .fillMaxWidth(0.3f)
                    .height(40.dp)
                    .rotate(45f)
                    .offset(x = (-20).dp, y = 20.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = number,
                color = RangersWhite,
                fontFamily = RangersFont,
                fontSize = 54.sp,
                letterSpacing = (-16).sp,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = position,
                color = RangersWhite,
                fontFamily = RangersFont,
                fontSize = 54.sp,
                letterSpacing = (-16).sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CornerStripes(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(RangersWhite)
                .fillMaxWidth()
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .background(RangersRed)
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Preview
@Composable
private fun TeamBannerPreview() {
    MaterialTheme {
        TeamBanner(
            number = "79",
            position = "LW",
            modifier = Modifier.height(100.dp)
        )
    }
}
