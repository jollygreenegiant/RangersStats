package com.jggdevelopment.rangersstats.model.mock

import Team
import com.jggdevelopment.rangersstats.model.Game
import com.jggdevelopment.rangersstats.model.Name

val mockGame = Game(
    id = 2023021018,
    season = 20232024,
    gameType = 2,
    gameDate = "2024-03-09",
    venue = Name("Madison Square Garden"),
    neutralSite = false,
    startTimeUTC = "2024-03-10T00:30:00Z",
    easternUTCOffset = "-05:00",
    venueUTCOffset = "-05:00",
    venueTimezone = "America/New_York",
    gameState = "FUT",
    awayTeam = Team(
        id = 3,
        placeName = Name("New York"),
        abbrev = "NYR",
        logo = "https://assets.nhle.com/logos/nhl/svg/NYR_light.svg",
        score = 6
    ),
    homeTeam = Team(
        id = 3,
        placeName = Name("Boston"),
        abbrev = "BOS",
        logo = "https://assets.nhle.com/logos/nhl/svg/BOS_light.svg",
        score = 6
    ),
    gameCenterLink = "/api/v1/game/2019020001/feed/live"
)
