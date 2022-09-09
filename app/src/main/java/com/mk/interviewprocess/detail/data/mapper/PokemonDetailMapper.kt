package com.mk.interviewprocess.detail.data.mapper

import com.mk.interviewprocess.detail.data.remote.dto.PokemonDetailResponse
import com.mk.interviewprocess.detail.data.remote.dto.StatDto
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.detail.domain.model.PokemonStat
import java.util.*

fun PokemonDetailResponse.toDomain(): PokemonDetail {
    return PokemonDetail(
        id = this.id,
        name = this.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
        abilities = this.abilities.map {
            it.ability.name.replaceFirstChar { letter ->
                if (letter.isLowerCase()) letter.titlecase(Locale.getDefault()) else letter.toString()
            }
        },
        stats = this.stats.map { it.toDomain() },
        types = this.types.map {
            it.type.name.replaceFirstChar { letter ->
                if (letter.isLowerCase()) letter.titlecase(Locale.getDefault()) else letter.toString()
            }
        }
    )
}

private fun StatDto.toDomain(): PokemonStat {
    return PokemonStat(
        name = this.stat.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
        value = this.baseStat
    )
}
