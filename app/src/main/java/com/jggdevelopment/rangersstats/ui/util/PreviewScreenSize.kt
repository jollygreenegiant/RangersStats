package com.jggdevelopment.rangersstats.ui.util

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "small",
    group = "screen sizes",
    device = Devices.NEXUS_5,
    showSystemUi = true
)
@Preview(
    name = "medium",
    group = "screen sizes",
    device = Devices.PIXEL,
    showSystemUi = true
)
@Preview(
    name = "large",
    group = "screen sizes",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true
)
annotation class PreviewScreenSize
