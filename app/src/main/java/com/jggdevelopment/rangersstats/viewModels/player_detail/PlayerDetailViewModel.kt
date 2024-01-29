package com.jggdevelopment.rangersstats.viewModels.player_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jggdevelopment.rangersstats.model.RosterPlayer
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.util.RangersResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerDetailViewModel(
    private val rangersRepository: RangersRepository,
    private val playerId: Int
): ViewModel() {

    private val _player: MutableStateFlow<RangersResult<RosterPlayerWithStats>> = MutableStateFlow(RangersResult.Loading)
    val player = _player.asStateFlow()

    init {
        viewModelScope.launch {
            getPlayer(playerId)
        }
    }

    private suspend fun getPlayer(playerId: Int) {
        _player.emit(rangersRepository.getPlayer(playerId))
    }
}
