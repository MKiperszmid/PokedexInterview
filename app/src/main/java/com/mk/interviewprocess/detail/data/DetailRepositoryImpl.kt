package com.mk.interviewprocess.detail.data

import com.mk.interviewprocess.detail.data.mapper.toDomain
import com.mk.interviewprocess.detail.data.remote.DetailApi
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.detail.domain.repository.DetailRepository
import java.util.concurrent.CancellationException

class DetailRepositoryImpl(
    private val api: DetailApi
) : DetailRepository {
    override suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        return try {
            val response = api.getPokemonDetail(id)
            Result.success(response.toDomain())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
