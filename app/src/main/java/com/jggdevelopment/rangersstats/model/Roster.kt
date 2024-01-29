package com.jggdevelopment.rangersstats.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

data class Roster(
    val forwards: List<RosterPlayer>,
    val defensemen: List<RosterPlayer>,
    val goalies: List<RosterPlayer>
) {
    val allPlayers: ImmutableList<RosterPlayer>
        get() = (forwards + defensemen + goalies)
            .groupBy { it.positionString }
            .values
            .flatMap { playersAtPosition ->
                playersAtPosition.sortedBy { it.lastName.default }
            }
            .toImmutableList()
}
