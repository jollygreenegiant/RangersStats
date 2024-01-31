package com.jggdevelopment.rangersstats.model

data class Schedule(
    var clubTimezone: String,
    var clubUTCOffset: String,
    var games: List<ScheduleGame>
)
