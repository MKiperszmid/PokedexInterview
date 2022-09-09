package com.mk.interviewprocess.detail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mk.interviewprocess.detail.domain.model.PokemonDetail
import com.mk.interviewprocess.ui.theme.Grass

@Composable
fun DetailHeader(pokemon: PokemonDetail, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().padding(12.dp)) {
        Text(text = pokemon.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        DetailPokemonType(pokemon.types, backgroundColor = color)
    }
}

@Preview
@Composable
fun DetailHeaderPreview() {
    DetailHeader(
        pokemon = PokemonDetail(
            id = 4,
            name = "Charmander",
            abilities = listOf("Fire"),
            stats = listOf(),
            types = listOf("Fire", "Grass")
        ),
        Grass
    )
}
