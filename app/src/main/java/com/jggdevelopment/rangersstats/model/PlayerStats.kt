package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class PlayerStats(
    val gamesPlayed: Int,
    val goals: Int,
    val assists: Int,
    val points: Int,
    val plusMinus: Int,
    val pim: Int,
    val gameWinningGoals: Int,
    val otGoals: Int,
    val shots: Int,
    val shootingPctg: Double,
    val powerPlayGoals: Int,
    val powerPlayPoints: Int,
    val shorthandedGoals: Int,
    val shorthandedPoints: Int
)

data class SkaterStats(
    val gamesPlayed: Int,
    val goals: Int,
    val assists: Int,
    val points: Int,
    val plusMinus: Int,
    val pim: Int,
    val gameWinningGoals: Int,
    val otGoals: Int,
    val shots: Int,
    val shootingPctg: Double,
    val powerPlayGoals: Int,
    val powerPlayPoints: Int,
    val shorthandedGoals: Int,
    val shorthandedPoints: Int,
    @SerializedName("playerId")
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    override val positionCode: String
): Player()

data class GoalieStats(
    val gamesPlayed: Int,
    val gamesStarted: Int,
    val wins: Int,
    val losses: Int,
    val ties: Int,
    val overtimeLosses: Int,
    val goalsAgainst: Int,
    val savePercentage: Double,
    val shotsAgainst: Int,
    val saves: Int,
    val goalsAgainstAverage: Double,
    val shutouts: Int,
    val goals: Int,
    val assists: Int,
    val points: Int,
    val penaltyMinutes: Int,
    val timeOnIce: Int,
    @SerializedName("playerId")
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    override val positionCode: String
): Player()
