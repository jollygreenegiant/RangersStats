package com.jggdevelopment.rangersstats.model

data class Standings(
    val standings: List<Standing>
)

data class Standing(
    val wins: Int,
    val losses: Int,
    val otLosses: Int,
    val points: Int,
    val teamAbbrev: Name
) {
    fun getRecord(): String {
        return "$wins-$losses-$otLosses ($points PTS)"
    }
}
