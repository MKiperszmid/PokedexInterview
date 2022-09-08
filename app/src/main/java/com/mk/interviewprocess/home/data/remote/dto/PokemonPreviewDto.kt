package com.mk.interviewprocess.home.data.remote.dto

import com.squareup.moshi.Json

data class PokemonPreviewDto(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)
