package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.GoalieStats
import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.SkaterStats

val fakeSkaterStats = SkaterStats(
    gamesPlayed = 0,
    goals = 0,
    assists = 0,
    points = 0,
    plusMinus = 0,
    pim = 0,
    gameWinningGoals = 0,
    otGoals = 0,
    shots = 0,
    shootingPctg = 0.0,
    powerPlayGoals = 0,
    powerPlayPoints = 0,
    shorthandedGoals = 0,
    shorthandedPoints = 0,
    id = 0,
    headshot = "",
    firstName = Name("First"),
    lastName = Name("Last"),
    positionCode = "L"
)

val fakeGoalieStats = GoalieStats(
    gamesPlayed = 0,
    gamesStarted = 0,
    wins = 0,
    losses = 0,
    ties = 0,
    overtimeLosses = 0,
    goalsAgainst = 0,
    savePercentage = 0.0,
    shotsAgainst = 0,
    saves = 0,
    goalsAgainstAverage = 0.0,
    shutouts = 0,
    goals = 0,
    assists = 0,
    points = 0,
    penaltyMinutes = 0,
    timeOnIce = 0,
    id = 0,
    headshot = "",
    firstName = Name("First"),
    lastName = Name("Last"),
    positionCode = "G"
)
