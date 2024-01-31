package com.jggdevelopment.rangersstats.model.mock

import Team
import com.jggdevelopment.rangersstats.model.GameCenter
import com.jggdevelopment.rangersstats.model.Last10Record
import com.jggdevelopment.rangersstats.model.Last10TeamRecord
import com.jggdevelopment.rangersstats.model.Matchup
import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.TeamLeaders

val fakeGame = GameCenter(
    id = 2023021018,
    season = 20232024,
    gameType = 2,
    gameDate = "2024-03-09",
    venue = Name("Madison Square Garden"),
    startTimeUTC = "2024-03-10T00:30:00Z",
    easternUTCOffset = "-05:00",
    venueUTCOffset = "-05:00",
    awayTeam = Team(
        id = 3,
        placeName = Name("New York"),
        abbrev = "NYR",
        logo = "https://assets.nhle.com/logos/nhl/svg/NYR_light.svg"
    ),
    homeTeam = Team(
        id = 3,
        placeName = Name("Boston"),
        abbrev = "BOS",
        logo = "https://assets.nhle.com/logos/nhl/svg/BOS_light.svg"
    ),
    matchup = Matchup(
        season = 20232024,
        gameType = 2,
        teamLeadersL5 = listOf(
            TeamLeaders(
                category = "assists",
                awayLeader = fakePlayerLeader1,
                homeLeader = fakePlayerLeader2
            ),
            TeamLeaders(
                category = "assists",
                awayLeader = fakePlayerLeader2,
                homeLeader = fakePlayerLeader1
            )
        ),
        last10Record = Last10Record(
            awayTeam = Last10TeamRecord(
                record = "8-2-0",
                streakType = "W",
                streak = 4
            ),
            homeTeam = Last10TeamRecord(
                record = "6-4-0",
                streakType = "L",
                streak = 1
            )
        )
    )
)
