package com.jggdevelopment.rangersstats.model

data class PlayerStats(
    val gamesPlayed: Long,
    val goals: Long,
    val assists: Long,
    val points: Long,
    val plusMinus: Long,
    val pim: Long,
    val gameWinningGoals: Long,
    val otGoals: Long,
    val shots: Long,
    val shootingPctg: Double,
    val powerPlayGoals: Long,
    val powerPlayPoints: Long,
    val shorthandedGoals: Long,
    val shorthandedPoints: Long,
)
