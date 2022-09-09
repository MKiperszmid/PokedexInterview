package com.mk.interviewprocess.home.data.remote

import com.mk.interviewprocess.home.data.remote.dto.PokemonPreviewResultDto
import retrofit2.http.GET

interface HomeApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon")
    suspend fun getPokemons(): PokemonPreviewResultDto
}
