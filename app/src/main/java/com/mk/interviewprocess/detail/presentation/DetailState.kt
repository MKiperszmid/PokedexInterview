package com.mk.interviewprocess.detail.presentation

import com.mk.interviewprocess.detail.domain.model.PokemonDetail

data class DetailState(
    val isLoading: Boolean = false,
    val pokemonDetail: PokemonDetail? = null,
    val navigateBack: Boolean = false
)
