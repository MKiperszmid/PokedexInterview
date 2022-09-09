package com.mk.interviewprocess.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mk.interviewprocess.ui.theme.Grass

@Composable
fun DetailPokemonType(
    types: List<String>,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(types) {
            Box(
                modifier = Modifier
                    .background(backgroundColor, shape = RoundedCornerShape(18.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(text = it, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun DetailPokemonTypePreview() {
    DetailPokemonType(listOf("Grass", "Poison"), Grass)
}
