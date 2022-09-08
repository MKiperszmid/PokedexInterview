package com.mk.interviewprocess.home.data.remote.dto

import com.squareup.moshi.Json

data class PokemonPreviewResultDto(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "next")
    val next: String,
    @field:Json(name = "previous")
    val previous: Any,
    @field:Json(name = "results")
    val results: List<PokemonPreviewDto>
)
