package com.mk.interviewprocess.detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.detail.domain.repository.DetailRepository
import com.mk.interviewprocess.ui.theme.Fire
import com.mk.interviewprocess.ui.theme.Grass
import com.mk.interviewprocess.ui.theme.Water
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
                    pokemonDetail = it,
                    mainColor = getMainColor(it)
                )
            }.onFailure {
                println()
            }
            state = state.copy(isLoading = false)
        }
    }

    private fun getMainColor(pokemonDetail: PokemonDetail): Color {
        // TODO: Convert into an Enum of some sort
        if (pokemonDetail.types.any { it.lowercase() == "fire" }) return Fire
        if (pokemonDetail.types.any { it.lowercase() == "grass" }) return Grass
        if (pokemonDetail.types.any { it.lowercase() == "water" }) return Water
        return Grass
    }
}
