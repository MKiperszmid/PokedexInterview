package com.mk.interviewprocess.detail.data.mapper

import com.mk.interviewprocess.detail.data.remote.dto.PokemonDetailResponse
import com.mk.interviewprocess.detail.data.remote.dto.StatDto
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.detail.domain.model.PokemonStat
import com.mk.interviewprocess.util.capitalize

fun PokemonDetailResponse.toDomain(): PokemonDetail {
    return PokemonDetail(
        id = this.id,
        name = this.name.capitalize(),
        abilities = this.abilities.map {
            it.ability.name.capitalize()
        },
        stats = this.stats.map { it.toDomain() },
        types = this.types.map { it.type.name.capitalize() }
    )
}

private fun parseSpecialStat(stat: String): String {
    return when (stat.lowercase()) {
        "special-attack" -> "Sp. Atk"
        "special-defense" -> "Sp. Def"
        else -> stat
    }
}

private fun StatDto.toDomain(): PokemonStat {
    return PokemonStat(
        name = parseSpecialStat(this.stat.name).capitalize(),
        value = this.baseStat
    )
}
