package com.jggdevelopment.rangersstats.viewModels.game_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.util.RangersResult
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val rangersRepository: RangersRepository,
    private val gameId: Int
): ViewModel() {
    private val _state: MutableStateFlow<GameDetailState> = MutableStateFlow(GameDetailState.Loading)
    val state: StateFlow<GameDetailState> = _state

    init {
        getGame(gameId)
    }

    fun getGame(gameId: Int) = viewModelScope.launch {
        _state.update { GameDetailState.Loading }

        val gameCenterResponse = async { rangersRepository.getGame(gameId) }.await()

        if (gameCenterResponse is RangersResult.Success) {
            val awayTeamStatsRequest = async {
                rangersRepository.getTeamStats(teamAbbrev = gameCenterResponse.data.awayTeam.abbrev)
            }
            val homeTeamStatsRequest = async {
                rangersRepository.getTeamStats(teamAbbrev = gameCenterResponse.data.homeTeam.abbrev)
            }

            val awayTeamStatsResponse = awayTeamStatsRequest.await()
            val homeTeamStatsResponse = homeTeamStatsRequest.await()

            _state.update {
                GameDetailStateMapper().map(
                    gameCenter = gameCenterResponse.data,
                    awayTeamPlayerStats = awayTeamStatsResponse,
                    homeTeamPlayerStats = homeTeamStatsResponse
                )
            }
        } else {
            _state.update {
                GameDetailState.Error("Error getting game")
            }
        }
    }
}
