package com.mk.interviewprocess.home.domain.model

data class PokemonPreview(
    val id: Int,
    val name: String,
    val url: String
) {
    val image =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$id.png"
}
