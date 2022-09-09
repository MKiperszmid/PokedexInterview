package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class StatDto(
    @field:Json(name = "base_stat")
    val baseStat: Int,
    @field:Json(name = "effort")
    val effort: Int,
    @field:Json(name = "stat")
    val stat: StatX
)