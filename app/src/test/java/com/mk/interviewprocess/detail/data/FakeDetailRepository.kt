package com.mk.interviewprocess.detail.data

import com.mk.interviewprocess.detail.domain.model.PokemonColor
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.detail.domain.model.PokemonStat
import com.mk.interviewprocess.detail.domain.repository.DetailRepository

class FakeDetailRepository : DetailRepository {
    val pokemon = PokemonDetail(
        id = 1,
        name = "Charizard",
        abilities = listOf("Bite", "Chew"),
        stats = listOf(PokemonStat("HP", 1), PokemonStat("Attack", 100)),
        types = listOf("Fire", "Flying"),
        color = PokemonColor.FIRE
    )
    var shouldReturnError = false

    override suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        if (shouldReturnError) {
            return Result.failure(Throwable())
        }
        return Result.success(pokemon)
    }
}
