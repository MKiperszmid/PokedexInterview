package com.mk.interviewprocess.detail.presentation

import androidx.compose.ui.graphics.Color
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.ui.theme.Grass

data class DetailState(
    val isLoading: Boolean = false,
    val pokemonDetail: PokemonDetail? = null,
    val mainColor: Color = Grass
)
