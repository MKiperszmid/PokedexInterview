package com.mk.interviewprocess.detail.data.remote.dto

import com.squareup.moshi.Json

data class PokemonDetailResponse(
    @Json(name = "abilities")
    val abilities: List<AbilityDto>,
    @Json(name = "base_experience")
    val baseExperience: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "stats")
    val stats: List<StatDto>,
    @Json(name = "types")
    val types: List<TypeDto>,
    @Json(name = "weight")
    val weight: Int
)
