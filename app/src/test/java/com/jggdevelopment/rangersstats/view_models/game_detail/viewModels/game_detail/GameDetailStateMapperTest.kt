package com.jggdevelopment.rangersstats.view_models.game_detail.viewModels.game_detail

import com.jggdevelopment.rangersstats.model.TeamPlayerStats
import com.jggdevelopment.rangersstats.model.mock.fakeGame
import com.jggdevelopment.rangersstats.model.mock.fakeGoalieStats
import com.jggdevelopment.rangersstats.model.mock.fakeSkaterStats
import com.jggdevelopment.rangersstats.util.RangersResult
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailState
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailStateMapper
import org.junit.Test

class GameDetailStateMapperTest {
    val mapper = GameDetailStateMapper()

    private val player1Stats = fakeSkaterStats.copy(
        goals = 6,
        assists = 12,
        points = 18
    )
    private val player2Stats = fakeSkaterStats.copy(
        goals = 8,
        assists = 4,
        points = 12
    )
    private val player3Stats = fakeSkaterStats.copy(
        goals = 12,
        assists = 6,
        points = 16
    )
    private val player4Stats = fakeSkaterStats.copy(
        goals = 10,
        assists = 8,
        points = 20
    )

    @Test
    fun `test mapper returns error if away team is error`() {
        val result = mapper.map(
            fakeGame,
            awayTeamPlayerStats = RangersResult.Error(),
            homeTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(fakeSkaterStats),
                    goalies = listOf(fakeGoalieStats)
                )
            )
        )

        assert(result is GameDetailState.Error)
    }

    @Test
    fun `test mapper returns error if home team is error`() {
        val result = mapper.map(
            fakeGame,
            awayTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(fakeSkaterStats),
                    goalies = listOf(fakeGoalieStats)
                )
            ),
            homeTeamPlayerStats = RangersResult.Error()
        )

        assert(result is GameDetailState.Error)
    }

    @Test
    fun `test mapper returns success if all params are valid`() {
        val result = mapper.map(
            fakeGame,
            awayTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(fakeSkaterStats),
                    goalies = listOf(fakeGoalieStats)
                )
            ),
            homeTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(fakeSkaterStats),
                    goalies = listOf(fakeGoalieStats)
                )
            )
        )

        assert(result is GameDetailState.Success)
    }

    @Test
    fun `test mapper values are correct`() {
        val result = mapper.map(
            fakeGame,
            awayTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(player1Stats, player2Stats),
                    goalies = listOf(fakeGoalieStats)
                )
            ),
            homeTeamPlayerStats = RangersResult.Success(
                TeamPlayerStats(
                    skaters = listOf(player3Stats, player4Stats),
                    goalies = listOf(fakeGoalieStats)
                )
            )
        )

        with (result as GameDetailState.Success) {
            assert(teamLeaders.size == 3)
            assert(teamLeaders.find { it.category == "G" }?.awayLeader?.value == player2Stats.goals)
            assert(teamLeaders.find { it.category == "A" }?.awayLeader?.value == player1Stats.assists)
            assert(teamLeaders.find { it.category == "P" }?.awayLeader?.value == player1Stats.points)
            assert(teamLeaders.find { it.category == "G" }?.homeLeader?.value == player3Stats.goals)
            assert(teamLeaders.find { it.category == "A" }?.homeLeader?.value == player4Stats.assists)
            assert(teamLeaders.find { it.category == "P" }?.homeLeader?.value == player4Stats.points)
        }
    }
}
