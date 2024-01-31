package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.Roster
import kotlinx.collections.immutable.persistentListOf

val fakeRoster = Roster(
    forwards = persistentListOf(
        fakeRosterPlayer1,
        fakeRosterPlayer2,
        fakeRosterPlayer3
    ),
    defensemen = persistentListOf(
        fakeRosterPlayer4,
        fakeRosterPlayer5,
        fakeRosterPlayer6
    ),
    goalies = persistentListOf(
        fakeRosterPlayer7,
        fakeRosterPlayer8,
        fakeRosterPlayer9
    )
)
