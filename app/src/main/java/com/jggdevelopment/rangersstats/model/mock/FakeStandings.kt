package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.Standing
import com.jggdevelopment.rangersstats.model.Standings

val fakeStandings = Standings(
    standings = listOf(
        Standing(
            wins = 1,
            losses = 2,
            otLosses = 3,
            points = 4,
            teamAbbrev = Name(
                default = "NYR"
            )
        )
    )
)
