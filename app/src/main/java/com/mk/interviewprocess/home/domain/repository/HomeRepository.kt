package com.mk.interviewprocess.home.domain.repository

import com.mk.interviewprocess.home.domain.model.PokemonPreview

interface HomeRepository {
    suspend fun getPokemons(): Result<List<PokemonPreview>>
}
