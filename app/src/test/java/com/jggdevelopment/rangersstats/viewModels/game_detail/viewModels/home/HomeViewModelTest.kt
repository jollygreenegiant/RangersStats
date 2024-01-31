package com.jggdevelopment.rangersstats.viewModels.game_detail.viewModels.home

import com.jggdevelopment.rangersstats.model.mock.fakeRoster
import com.jggdevelopment.rangersstats.model.mock.fakeSchedule
import com.jggdevelopment.rangersstats.model.mock.fakeStandings
import com.jggdevelopment.rangersstats.repository.RangersRepository
import com.jggdevelopment.rangersstats.util.RangersResult
import com.jggdevelopment.rangersstats.viewModels.game_detail.MainDispatcherRule
import com.jggdevelopment.rangersstats.viewModels.home.HomeUiState
import com.jggdevelopment.rangersstats.viewModels.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    lateinit var viewModel: HomeViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `test ui state is error when roster is error`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getRoster() } returns RangersResult.Error()
        coEvery { repository.getStandings() } returns RangersResult.Success(
           fakeStandings
        )
        coEvery { repository.getSchedule() } returns RangersResult.Success(
            fakeSchedule
        )

        viewModel = HomeViewModel(repository)

        assert(viewModel.state.value is HomeUiState.Error)
    }

    @Test
    fun `test ui state is error when standings is error`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getRoster() } returns RangersResult.Success(fakeRoster)
        coEvery { repository.getStandings() } returns RangersResult.Error()
        coEvery { repository.getSchedule() } returns RangersResult.Success(fakeSchedule)

        viewModel = HomeViewModel(repository)

        assert(viewModel.state.value is HomeUiState.Error)
    }

    @Test
    fun `test ui state is error when schedule is error`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getRoster() } returns RangersResult.Success(fakeRoster)
        coEvery { repository.getStandings() } returns RangersResult.Success(fakeStandings)
        coEvery { repository.getSchedule() } returns RangersResult.Error()

        viewModel = HomeViewModel(repository)

        assert(viewModel.state.value is HomeUiState.Error)
    }

    @Test
    fun `test ui state is success when all values are success`() {
        val repository: RangersRepository = mockk()
        coEvery { repository.getRoster() } returns RangersResult.Success(fakeRoster)
        coEvery { repository.getStandings() } returns RangersResult.Success(fakeStandings)
        coEvery { repository.getSchedule() } returns RangersResult.Success(fakeSchedule)

        viewModel = HomeViewModel(repository)

        assert(viewModel.state.value is HomeUiState.Success)
    }
}
