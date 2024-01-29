package com.jggdevelopment.rangersstats.ui.util

import android.widget.ImageView
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.jggdevelopment.rangersstats.R
import com.jggdevelopment.rangersstats.ui.theme.RangersBlue
import com.jggdevelopment.rangersstats.ui.theme.RangersRed
import com.jggdevelopment.rangersstats.ui.theme.RangersWhite

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        RangersLoadingIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun RangersLoadingIndicator(
    modifier: Modifier = Modifier,
    color: Color = if (isSystemInDarkTheme()) RangersWhite else RangersBlue
) {
    val context = LocalContext.current
    val animated = AnimatedVectorDrawableCompat.create(context, R.drawable.nyr_loader)

    LaunchedEffect(Unit) {
        animated?.start()
    }

    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                setImageDrawable(animated)
                setColorFilter(color.toArgb())
            }
        },
        modifier = modifier
    )
}
