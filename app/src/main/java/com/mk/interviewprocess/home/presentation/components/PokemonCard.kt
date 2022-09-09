package com.mk.interviewprocess.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mk.interviewprocess.home.domain.model.PokemonPreview
import com.mk.interviewprocess.ui.theme.Fire

@Composable
fun PokemonCard(
    pokemon: PokemonPreview,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(200.dp)
            .background(Fire, shape = RoundedCornerShape(6.dp))
            .clickable {
                onClick()
            }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = pokemon.name, color = Color.White)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.image)
                .crossfade(true)
                .build(),
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(75.dp)
        )
    }
}

@Preview
@Composable
fun PokemonCardPreview() {
    PokemonCard(
        PokemonPreview(
            4,
            "Charmander",
            ""
        ),
        {}
    )
}
