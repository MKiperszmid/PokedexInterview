package com.mk.interviewprocess.home.domain.repository

import com.mk.interviewprocess.home.domain.model.PokemonPreview

interface PokedexRepository {
    suspend fun getPokemons(): Result<List<PokemonPreview>>
}
