package com.mk.interviewprocess.detail.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mk.interviewprocess.detail.presentation.components.DetailHeader
import com.mk.interviewprocess.detail.presentation.components.DetailStatItem

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    state.pokemonDetail?.let {
        val context = LocalContext.current
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                DetailHeader(pokemon = it, color = state.mainColor)
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(it.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = it.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(250.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            items(it.stats) { stat ->
                DetailStatItem(stat = stat, barColor = state.mainColor)
            }
        }
    }
}
