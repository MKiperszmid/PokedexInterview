package com.mk.interviewprocess.detail.data.remote.dto

import com.squareup.moshi.Json

data class PokemonDetailResponse(
    @field:Json(name = "abilities")
    val abilities: List<AbilityDto>,
    @field:Json(name = "base_experience")
    val baseExperience: Int,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "stats")
    val stats: List<StatDto>,
    @field:Json(name = "types")
    val types: List<TypeDto>,
    @field:Json(name = "weight")
    val weight: Int
)
