package com.jggdevelopment.rangersstats.model

import Team
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

abstract class Game {
    abstract val id: Int
    abstract val season: Int
    abstract val gameType: Int
    abstract val gameDate: String
    abstract val venue: Name
    abstract val startTimeUTC: String
    abstract val easternUTCOffset: String
    abstract val venueUTCOffset: String
    abstract val awayTeam: Team
    abstract val homeTeam: Team

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

