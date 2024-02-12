package com.jggdevelopment.rangersstats.view_models.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jggdevelopment.rangersstats.repository.RangersRepository
import kotlinx.coroutines.async
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
        getData()
    }

    fun getData() = viewModelScope.launch {
        _state.emit(HomeUiState.Loading)

        val rosterRequest = async { rangersRepository.getRoster() }
        val standingsRequest = async { rangersRepository.getStandings() }
        val scheduleRequest = async { rangersRepository.getSchedule() }

        val rosterResponse = rosterRequest.await()
        val standingsResponse = standingsRequest.await()
        val scheduleResponse = scheduleRequest.await()

        _state.update {
            HomeUiStateMapper().map(
                roster = rosterResponse,
                standings = standingsResponse,
                schedule = scheduleResponse
            )
        }
    }
}
