package com.jggdevelopment.rangersstats.view_models.game_detail

import com.jggdevelopment.rangersstats.model.GameCenter
import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.PlayerLeader
import com.jggdevelopment.rangersstats.model.TeamLeaders
import com.jggdevelopment.rangersstats.model.TeamPlayerStats
import com.jggdevelopment.rangersstats.util.RangersResult

sealed interface GameDetailState {
    data object Loading: GameDetailState
    data class Success(
        val game: GameCenter,
        val teamLeaders: List<TeamLeaders>
    ): GameDetailState
    data class Error(val message: String): GameDetailState
}

class GameDetailStateMapper {
    fun map(
        gameCenter: GameCenter,
        awayTeamPlayerStats: RangersResult<TeamPlayerStats>,
        homeTeamPlayerStats: RangersResult<TeamPlayerStats>
    ): GameDetailState {
        return if (
            awayTeamPlayerStats is RangersResult.Success &&
            homeTeamPlayerStats is RangersResult.Success
        ) {
            val leaders = buildList {
                add(
                    TeamLeaders(
                        category = "G",
                        awayLeader = with(awayTeamPlayerStats.data.skaters.maxBy { it.goals }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.goals
                            )
                        },
                        homeLeader = with(homeTeamPlayerStats.data.skaters.maxBy { it.goals }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.goals
                            )
                        }
                    )
                )
                add(
                    TeamLeaders(
                        category = "A",
                        awayLeader = with(awayTeamPlayerStats.data.skaters.maxBy { it.assists }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.assists
                            )
                        },
                        homeLeader = with(homeTeamPlayerStats.data.skaters.maxBy { it.assists }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.assists
                            )
                        }
                    )
                )
                add(
                    TeamLeaders(
                        category = "P",
                        awayLeader = with(awayTeamPlayerStats.data.skaters.maxBy { it.points }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.points
                            )
                        },
                        homeLeader = with(homeTeamPlayerStats.data.skaters.maxBy { it.points }) {
                            PlayerLeader(
                                id = this.id,
                                name = Name("${this.firstName} ${this.lastName}"),
                                firstName = this.firstName,
                                lastName = this.lastName,
                                positionCode = this.positionCode,
                                headshot = this.headshot,
                                value = this.points
                            )
                        }
                    )
                )
            }
            GameDetailState.Success(
                game = gameCenter,
                teamLeaders = leaders
            )
        } else {
            GameDetailState.Error("Error getting team stats")
        }
    }
}
