package com.jggdevelopment.rangersstats.viewModels.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.RosterPlayer
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.util.RangersResult
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val rangersRepository: RangersRepository
): ViewModel() {
    private val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state

    init {
        viewModelScope.launch {
            // this is a fake delay because my loading indicator is really cool and I want to look at it
//            delay(1500)
            getData()
        }
    }

    private fun getData() = viewModelScope.launch {
        val rosterRequest = async {
            rangersRepository.getRoster()

//            if (roster is RangersResult.Success) {
//                val players = (roster.data.forwards + roster.data.defensemen + roster.data.goalies)
//                    .map {
//                        async { rangersRepository.getPlayer(it.id) }
//                    }
//                    .awaitAll()
//                    .filterIsInstance<RangersResult.Success<RosterPlayer>>()
//                    .map { it.data }
//            } else {
//                RangersResult.Error()
//            }
        }
        val standings = async { rangersRepository.getStandings() }
        val schedule = async { rangersRepository.getSchedule() }

        val rosterResponse = rosterRequest.await()
        val standingsResponse = standings.await()
        val scheduleResponse = schedule.await()

        _state.update {
            HomeUiStateMapper().map(
                roster = rosterResponse,
                standings = standingsResponse,
                schedule = scheduleResponse
            )
        }
    }
}
