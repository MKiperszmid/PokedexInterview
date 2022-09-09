package com.mk.interviewprocess.home.data.mapper

import com.mk.interviewprocess.home.data.remote.dto.PokemonPreviewDto
import com.mk.interviewprocess.home.domain.model.PokemonPreview
import com.mk.interviewprocess.util.capitalize
import java.util.*

fun PokemonPreviewDto.toDomain(): PokemonPreview {
    val regex = "pokemon/(.*)/".toRegex()
    val image = regex.find(this.url)
    val pokemonId = image?.groups?.get(1)?.value ?: 1
    return PokemonPreview(
        id = Integer.valueOf(pokemonId.toString()),
        name = this.name.capitalize(),
        url = this.url
    )
}
