package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.PlayerGameStats
import com.jggdevelopment.rangersstats.model.PlayerStats
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats

val fakeRosterPlayerWithStats = RosterPlayerWithStats(
    id = 1,
    headshot = "https://assets.nhle.com/mugs/nhl/20232024/NYR/8482157.png",
    firstName = Name("firstName1"),
    lastName = Name("lastName1"),
    sweaterNumber = 1,
    positionCode = "RW",
    shootsCatches = "R",
    heightInInches = 1,
    weightInPounds = 1,
    heightInCentimeters = 1,
    weightInKilograms = 1,
    birthDate = "birthDate1",
    birthCity = Name("birthCity1"),
    birthCountry = "birthCountry1",
    birthStateProvince = Name("birthStateProvince1"),
    careerTotals = PlayerStats(
        gamesPlayed = 100,
        goals = 100,
        assists = 100,
        points = 100,
        plusMinus = 100,
        pim = 100,
        gameWinningGoals = 100,
        otGoals = 100,
        shots = 100,
        shootingPctg = 100.0,
        powerPlayGoals = 100,
        powerPlayPoints = 100,
        shorthandedGoals = 100,
        shorthandedPoints = 100
    ),
    last5Games = buildList {
        repeat(5) {
            add(
                PlayerGameStats(
                    goals = 100,
                    assists = 100,
                    points = 100,
                    plusMinus = 100,
                    pim = 100,
                    homeRoadFlag = "H",
                    shots = 100,
                    powerPlayGoals = 100,
                    shorthandedGoals = 100,
                    gameDate = "20204-01-23",
                    gameId = 2023020765,
                    gameTypeId = 2,
                    opponentAbbrev = "OTT",
                    teamAbbrev = "NYR",
                    shifts = 100,
                    toi = "12:46"
                )
            )
        }
    },
    seasonTotals = listOf(
        PlayerStats(
            gamesPlayed = 100,
            goals = 100,
            assists = 100,
            points = 100,
            plusMinus = 100,
            pim = 100,
            gameWinningGoals = 100,
            otGoals = 100,
            shots = 100,
            shootingPctg = 100.0,
            powerPlayGoals = 100,
            powerPlayPoints = 100,
            shorthandedGoals = 100,
            shorthandedPoints = 100
        )
    )
)
