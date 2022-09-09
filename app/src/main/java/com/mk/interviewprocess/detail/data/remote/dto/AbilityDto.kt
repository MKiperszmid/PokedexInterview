package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class AbilityDto(
    @Json(name = "ability")
    val ability: AbilityX,
    @Json(name = "is_hidden")
    val isHidden: Boolean,
    @Json(name = "slot")
    val slot: Int
)