package com.jggdevelopment.rangersstats.model

data class Schedule(
    val clubTimezone: String,
    val clubUTCOffset: String,
    val games: List<ScheduleGame>
)
