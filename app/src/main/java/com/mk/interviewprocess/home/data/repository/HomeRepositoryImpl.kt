package com.mk.interviewprocess.home.data.repository

import com.mk.interviewprocess.home.data.mapper.toDomain
import com.mk.interviewprocess.home.data.remote.HomeApi
import com.mk.interviewprocess.home.domain.model.PokemonPreview
import com.mk.interviewprocess.home.domain.repository.HomeRepository
import java.util.concurrent.CancellationException

class HomeRepositoryImpl(
    private val api: HomeApi
) : HomeRepository {
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
