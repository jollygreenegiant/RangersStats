package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.Roster
import kotlinx.collections.immutable.persistentListOf

val mockRoster = Roster(
    forwards = persistentListOf(
        mockRosterPlayer1,
        mockRosterPlayer2,
        mockRosterPlayer3
    ),
    defensemen = persistentListOf(
        mockRosterPlayer4,
        mockRosterPlayer5,
        mockRosterPlayer6
    ),
    goalies = persistentListOf(
        mockRosterPlayer7,
        mockRosterPlayer8,
        mockRosterPlayer9
    )
)
