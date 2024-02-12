package com.jggdevelopment.rangersstats.view_models.home

import com.jggdevelopment.rangersstats.model.Game
import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.Schedule
import com.jggdevelopment.rangersstats.model.Standings
import com.jggdevelopment.rangersstats.util.RangersResult
import org.threeten.bp.LocalDate

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(
        val roster: Roster,
        val record: String,
        val nextGame: Game
    ) : HomeUiState
    data object Error: HomeUiState
}

class HomeUiStateMapper {
    fun map(
        roster: RangersResult<Roster>,
        standings: RangersResult<Standings>,
        schedule: RangersResult<Schedule>
    ): HomeUiState {
        return if (
            roster is RangersResult.Success &&
            standings is RangersResult.Success &&
            schedule is RangersResult.Success
        ) {
            val record = standings.data.standings.find { it.teamAbbrev.default == "NYR" }?.getRecord()
            val nextGame = schedule.data.games.first {
                LocalDate.parse(it.gameDate) >= LocalDate.now()
            }

            if (record != null) {
                HomeUiState.Success(
                    roster = roster.data,
                    record = record,
                    nextGame = nextGame
                )
            } else {
                HomeUiState.Error
            }
        } else {
            HomeUiState.Error
        }
    }
}
