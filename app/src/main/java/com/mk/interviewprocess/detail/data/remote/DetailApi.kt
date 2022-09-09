package com.mk.interviewprocess.detail.data.remote

import com.mk.interviewprocess.detail.data.remote.dto.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetailResponse
}
