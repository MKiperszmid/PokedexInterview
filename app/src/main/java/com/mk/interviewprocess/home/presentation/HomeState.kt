package com.mk.interviewprocess.home.presentation

import com.mk.interviewprocess.home.domain.model.PokemonPreview

data class HomeState(
    val isLoading: Boolean = false,
    val pokemons: List<PokemonPreview> = emptyList()
)
