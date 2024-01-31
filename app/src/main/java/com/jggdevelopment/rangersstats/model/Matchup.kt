package com.jggdevelopment.rangersstats.model

data class Matchup(
    val season: Int,
    val gameType: Int,
    val teamLeadersL5: List<TeamLeaders>,
    val last10Record: Last10Record
)
