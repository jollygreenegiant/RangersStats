package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class Schedule(
    var clubTimezone: String,
    var clubUTCOffset: String,
    var games: List<Game>
)
