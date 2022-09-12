package com.mk.interviewprocess.detail.presentation

import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth
import com.mk.interviewprocess.MainCoroutineRule
import com.mk.interviewprocess.detail.data.FakeDetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DetailViewModel
    private lateinit var repository: FakeDetailRepository

    @Before
    fun setUp() {
        repository = FakeDetailRepository()
        viewModel = DetailViewModel(
            savedStateHandle = SavedStateHandle(initialState = mapOf("pokemonId" to 1)),
            detailRepository = repository
        )
    }

    @Test
    fun `Get valid pokemon, sets the pokemons on state`() {
        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Truth.assertThat(viewModel.state.pokemonDetail).isNotNull()
        Truth.assertThat(viewModel.state.isLoading).isFalse()
        Truth.assertThat(viewModel.state.pokemonDetail!!.stats.size).isEqualTo(2)
    }

    @Test
    fun `Error on GetPokemons, state has 0 pokemons`() {
        repository.shouldReturnError = true
        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Truth.assertThat(viewModel.state.isLoading).isFalse()
        Truth.assertThat(viewModel.state.pokemonDetail).isNull()
    }
}
