package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class TypeDto(
    @Json(name = "slot")
    val slot: Int,
    @Json(name = "type")
    val type: TypeX
)