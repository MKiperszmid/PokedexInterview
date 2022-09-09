package com.mk.interviewprocess.detail.domain.repository

import com.mk.interviewprocess.detail.domain.model.PokemonDetail

interface DetailRepository {
    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail>
}
