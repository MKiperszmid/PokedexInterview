package com.mk.interviewprocess.detail.data.remote.dto


import com.squareup.moshi.Json

data class StatX(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)