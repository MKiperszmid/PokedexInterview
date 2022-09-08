package com.mk.interviewprocess.home.data.repository

import com.mk.interviewprocess.home.data.mapper.toDomain
import com.mk.interviewprocess.home.data.remote.PokedexService
import com.mk.interviewprocess.home.domain.model.PokemonPreview
import com.mk.interviewprocess.home.domain.repository.PokedexRepository
import java.util.concurrent.CancellationException

class PokedexRepositoryImpl(
    private val api: PokedexService
) : PokedexRepository {
    override suspend fun getPokemons(): Result<List<PokemonPreview>> {
        return try {
            val result = api.getPokemons()
            val mapped = result.results.map { it.toDomain() }
            Result.success(mapped)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
