package com.jggdevelopment.rangersstats.view_models.player_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        getPlayer(playerId)
    }

    fun getPlayer(playerId: Int) = viewModelScope.launch {
        _player.emit(RangersResult.Loading)
        _player.emit(rangersRepository.getPlayer(playerId))
    }
}