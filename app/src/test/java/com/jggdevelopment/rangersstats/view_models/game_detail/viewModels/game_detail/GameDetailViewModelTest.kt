package com.jggdevelopment.rangersstats.view_models.game_detail.viewModels.game_detail

import com.jggdevelopment.rangersstats.model.TeamPlayerStats
import com.jggdevelopment.rangersstats.model.mock.fakeGame
import com.jggdevelopment.rangersstats.model.mock.fakeGoalieStats
import com.jggdevelopment.rangersstats.model.mock.fakeSkaterStats
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.util.RangersResult
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailState
import com.jggdevelopment.rangersstats.view_models.game_detail.GameDetailViewModel
import com.jggdevelopment.rangersstats.view_models.game_detail.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class GameDetailViewModelTest {
    lateinit var viewModel: GameDetailViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `test ui state is error when game is error`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getGame(any()) } returns RangersResult.Error()
        coEvery { repository.getTeamStats(any()) } returns RangersResult.Success(
            TeamPlayerStats(
                skaters = emptyList(),
                goalies = emptyList()
            )
        )

        viewModel = GameDetailViewModel(repository, 123)

        assert(viewModel.state.value is GameDetailState.Error)
    }

    @Test
    fun `test ui state is error when stats are error`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getGame(any()) } returns RangersResult.Success(fakeGame)
        coEvery { repository.getTeamStats(any()) } returns RangersResult.Error()

        viewModel = GameDetailViewModel(repository, 123)

        assert(viewModel.state.value is GameDetailState.Error)
    }

    @Test
    fun `test ui state is success when game and stats are success`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getGame(any()) } returns RangersResult.Success(fakeGame)
        coEvery { repository.getTeamStats(any()) } returns RangersResult.Success(
            TeamPlayerStats(
                skaters = listOf(fakeSkaterStats),
                goalies = listOf(fakeGoalieStats)
            )
        )

        viewModel = GameDetailViewModel(repository, 123)

        assert(viewModel.state.value is GameDetailState.Success)
    }
}
