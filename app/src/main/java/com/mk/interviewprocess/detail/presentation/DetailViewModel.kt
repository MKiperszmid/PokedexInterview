package com.mk.interviewprocess.detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.interviewprocess.detail.domain.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val detailRepository: DetailRepository
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        val pokemonId = savedStateHandle.get<Int>("pokemonId")!!

        viewModelScope.launch {
            state = state.copy(isLoading = true)
            detailRepository.getPokemonDetail(pokemonId).onSuccess {
                state = state.copy(
                    pokemonDetail = it
                )
            }.onFailure {
                println()
            }
            state = state.copy(isLoading = false)
        }
    }
}
