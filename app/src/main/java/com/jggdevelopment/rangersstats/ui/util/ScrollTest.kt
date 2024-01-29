package com.jggdevelopment.rangersstats.ui.util

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScrollTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        repeat(5) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                repeat(20) {
                    Text("Test")
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScrollTestPreview() {
    MaterialTheme {
        ScrollTest()
    }
}
