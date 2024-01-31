package com.jggdevelopment.rangersstats.model.mock

import Team
import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.Schedule
import com.jggdevelopment.rangersstats.model.ScheduleGame
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

val fakeSchedule = Schedule(
    clubTimezone = "America/New_York",
    clubUTCOffset = "-4:00",
    games = listOf(
        ScheduleGame(
            id = 1,
            season = 20202021,
            gameType = 2,
            gameDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            venue = Name(default = "Madison Square Garden"),
            startTimeUTC = "2021-01-14T00:00:00Z",
            easternUTCOffset = "-5:00",
            venueUTCOffset = "-5:00",
            awayTeam = Team(
                id = 3,
                placeName = Name(default = "New York"),
                abbrev = "NYR",
                logo = "image"
            ),
            homeTeam = Team(
                id = 4,
                placeName = Name(default = "Philadelphia"),
                abbrev = "PHI",
                logo = "image"
            )
        )
    )
)
