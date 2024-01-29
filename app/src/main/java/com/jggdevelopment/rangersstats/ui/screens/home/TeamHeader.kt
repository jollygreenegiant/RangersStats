package com.jggdevelopment.rangersstats.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.ui.screens.player_detail.CornerStripes
import com.jggdevelopment.rangersstats.ui.theme.RangersBlue
import com.jggdevelopment.rangersstats.ui.theme.RangersFont
import com.jggdevelopment.rangersstats.ui.theme.RangersRed
import com.jggdevelopment.rangersstats.ui.theme.RangersWhite
import com.jggdevelopment.rangersstats.ui.util.PreviewScreenSize

@Composable
fun TeamHeader(
    record: String
) {
    val density = LocalDensity.current
    var logoHeight by remember { mutableFloatStateOf(0f) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(RangersBlue)
    ) {
        val (logo, text, stripes) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.nyr_logo),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.3f)
                .aspectRatio(1f)
                .onGloballyPositioned { coordinates ->
                    logoHeight = (coordinates.size.height.toFloat())
                }
                .constrainAs(logo) {
                    with(density) {
                        start.linkTo(
                            parent.start,
                            margin = (logoHeight * -0.35f)
                                .toInt()
                                .toDp()
                        )
                    }

                }
        )

        Row(
            modifier = Modifier
                .constrainAs(text) {
                    start.linkTo(logo.end)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "New York Rangers",
                    fontFamily = RangersFont,
                    fontSize = 36.sp,
                    letterSpacing = (-10).sp,
                    lineHeight = 40.sp,
                    color = RangersWhite
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = record,
                    color = RangersWhite
                )
            }
        }

        CornerStripes(
            modifier = Modifier
                .constrainAs(stripes) {
                    centerAround(parent.end)
                }
                .fillMaxWidth(0.3f)
                .height(40.dp)
                .rotate(45f)
                .offset(x = (-20).dp, y = 20.dp)
        )
    }
}

@PreviewScreenSize
@Composable
private fun TeamHeaderPreview() {
    MaterialTheme {
        TeamHeader(
            record = "21-16-6"
        )
    }
}
