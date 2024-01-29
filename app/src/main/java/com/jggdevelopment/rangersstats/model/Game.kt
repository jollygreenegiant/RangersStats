package com.jggdevelopment.rangersstats.model

import Team
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

data class Game(
    var id: Int,
    var season: Int,
    var gameType: Int,
    var gameDate: String,
    var venue: Name,
    var neutralSite: Boolean,
    var startTimeUTC: String,
    var easternUTCOffset: String,
    var venueUTCOffset: String,
    var venueTimezone: String,
    var gameState: String,
    var awayTeam: Team,
    var homeTeam: Team,
    var gameCenterLink: String
) {
    val formattedStartDate: String
        get() {
            val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
            return formatter.format(LocalDate.parse(gameDate))
        }

    val formattedStartTimeEastern: String
        get() {
            val formatter = DateTimeFormatter.ofPattern("hh:mm a")
            val instant = Instant.parse(startTimeUTC)

            return formatter.format(instant.atOffset(ZoneOffset.of(easternUTCOffset)))
        }
}

