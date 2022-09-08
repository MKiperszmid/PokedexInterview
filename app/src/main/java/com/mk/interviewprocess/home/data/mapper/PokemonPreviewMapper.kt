package com.mk.interviewprocess.home.data.mapper

import com.mk.interviewprocess.home.data.remote.dto.PokemonPreviewDto
import com.mk.interviewprocess.home.domain.model.PokemonPreview

fun PokemonPreviewDto.toDomain(): PokemonPreview {
    val regex = "pokemon/(.*)/".toRegex()
    val image = regex.find(this.url)
    val pokemonId = image?.groups?.get(1)?.value ?: 1
    return PokemonPreview(
        name = this.name,
        url = this.url,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$pokemonId.png"
    )
}
