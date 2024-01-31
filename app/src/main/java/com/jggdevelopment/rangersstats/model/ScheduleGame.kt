package com.jggdevelopment.rangersstats.model

import Team

data class ScheduleGame(
    override val id: Int,
    override val season: Int,
    override val gameType: Int,
    override val gameDate: String,
    override val venue: Name,
    override val startTimeUTC: String,
    override val easternUTCOffset: String,
    override val venueUTCOffset: String,
    override val awayTeam: Team,
    override val homeTeam: Team
): Game()
