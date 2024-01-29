package com.jggdevelopment.rangersstats.model

import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance

data class PlayerGameStats(
    val assists: Long,
    val gameDate: String,
    val gameId: Long,
    val gameTypeId: Long,
    val goals: Long,
    val homeRoadFlag: String,
    val opponentAbbrev: String,
    val pim: Long,
    val plusMinus: Long,
    val points: Long,
    val powerPlayGoals: Long,
    val shifts: Long,
    val shorthandedGoals: Long,
    val shots: Long,
    val teamAbbrev: String,
    val toi: String,
) {
    val gameDescription
        get() = "$gameDate ${if (homeRoadFlag == "H") "vs" else "at"} $opponentAbbrev"
}
