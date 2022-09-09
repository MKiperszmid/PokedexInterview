package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class StatDto(
    @Json(name = "base_stat")
    val baseStat: Int,
    @Json(name = "effort")
    val effort: Int,
    @Json(name = "stat")
    val stat: StatX
)