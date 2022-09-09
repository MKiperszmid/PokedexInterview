package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class AbilityDto(
    @field:Json(name = "ability")
    val ability: AbilityX,
    @field:Json(name = "is_hidden")
    val isHidden: Boolean,
    @field:Json(name = "slot")
    val slot: Int
)