package com.mk.interviewprocess.home

import com.mk.interviewprocess.home.domain.model.PokemonPreview
import com.mk.interviewprocess.home.domain.repository.HomeRepository

class FakeHomeRepository : HomeRepository {
    var shouldReturnError = false

    companion object {
        val pokemons = listOf(
            PokemonPreview(
                id = 1,
                name = "Charizard",
                url = "url.com"
            ),
            PokemonPreview(
                id = 2,
                name = "Pikachu",
                url = "url.com"
            ),
            PokemonPreview(
                id = 3,
                name = "Raichu",
                url = "url.com"
            )
        )
    }

    override suspend fun getPokemons(): Result<List<PokemonPreview>> {
        if (shouldReturnError) {
            return Result.failure(Throwable())
        }
        return Result.success(pokemons)
    }
}
