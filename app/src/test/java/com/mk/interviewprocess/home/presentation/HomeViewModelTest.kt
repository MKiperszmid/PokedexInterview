package com.mk.interviewprocess.home.presentation

import com.google.common.truth.Truth.assertThat
import com.mk.interviewprocess.MainCoroutineRule
import com.mk.interviewprocess.home.data.repository.FakeHomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var repository: FakeHomeRepository

    @Before
    fun setUp() {
        repository = FakeHomeRepository()
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun `GetPokemons is valid, sets the pokemons on state`() {
        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.state.pokemons.size).isEqualTo(3)
    }

    @Test
    fun `Error on GetPokemons, state has 0 pokemons`() {
        repository.shouldReturnError = true
        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.state.pokemons.size).isEqualTo(0)
    }
}
