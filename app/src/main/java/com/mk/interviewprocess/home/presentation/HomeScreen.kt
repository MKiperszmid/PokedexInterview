package com.mk.interviewprocess.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mk.interviewprocess.home.presentation.components.PokemonCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (state.pokemons.isNotEmpty()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Pokedex", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(state.pokemons) {
                    PokemonCard(
                        pokemon = it,
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
