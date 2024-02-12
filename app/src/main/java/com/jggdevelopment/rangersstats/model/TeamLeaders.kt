package com.jggdevelopment.rangersstats.model

data class TeamLeaders(
    val category: String,
    val awayLeader: PlayerLeader,
    val homeLeader: PlayerLeader
) {
    val categoryAbbreviation
        get() = when(category) {
            "goals" -> "G"
            "assists" -> "A"
            "points" -> "P"
            "plusMinus" -> "+/-"
            "penaltyMinutes" -> "PIM"
            "powerPlayGoals" -> "PPG"
            "powerPlayAssists" -> "PPA"
            "powerPlayPoints" -> "PPP"
            "shortHandedGoals" -> "SHG"
            "shortHandedAssists" -> "SHA"
            "shortHandedPoints" -> "SHP"
            "gameWinningGoals" -> "GWG"
            "gameTyingGoals" -> "GTG"
            "shots" -> "S"
            "shotPercentage" -> "S%"
            "faceOffWins" -> "FOW"
            "faceoffTaken" -> "FOT"
            "faceOffPercentage" -> "FO%"
            "hits" -> "H"
            "blockedShots" -> "BS"
            "takeaways" -> "TK"
            "giveaways" -> "GV"
            "timeOnIce" -> "TOI"
            "timeOnIcePerGame" -> "TOI/G"
            "shifts" -> "S"
            "evenTimeOnIce" -> "EV TOI"
            "evenTimeOnIcePerGame" -> "EV TOI/G"
            "powerPlayTimeOnIce" -> "PP TOI"
            "powerPlayTimeOnIcePerGame" -> "PP TOI/G"
            "shortHandedTimeOnIce" -> "SH TOI"
            "shortHandedTimeOnIcePerGame" -> "SH TOI/G"
            else -> category
        }
}
