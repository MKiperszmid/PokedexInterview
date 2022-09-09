package com.mk.interviewprocess.detail.domain.model

import androidx.compose.ui.graphics.Color
import com.mk.interviewprocess.ui.theme.*

enum class PokemonColor(val color: Color) {
    FIRE(Fire),
    WATER(Water),
    GRASS(Grass),
    NORMAL(Normal),
    BUG(Bug);

    companion object {
        fun colorFromList(types: List<String>): PokemonColor {
            if (types.any { it.lowercase() == "fire" }) return FIRE
            if (types.any { it.lowercase() == "grass" }) return GRASS
            if (types.any { it.lowercase() == "water" }) return WATER
            if (types.any { it.lowercase() == "bug" }) return BUG
            if (types.any { it.lowercase() == "normal" }) return NORMAL
            return WATER
        }
    }
}
