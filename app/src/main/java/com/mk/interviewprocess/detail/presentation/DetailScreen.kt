package com.mk.interviewprocess.detail.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mk.interviewprocess.R
import com.mk.interviewprocess.detail.presentation.components.DetailAbilityItem
import com.mk.interviewprocess.detail.presentation.components.DetailHeader
import com.mk.interviewprocess.detail.presentation.components.DetailStatItem

@Composable
fun DetailScreen(
    onBack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state

    LaunchedEffect(state.navigateBack) {
        if (state.navigateBack) {
            onBack()
        }
    }

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    state.pokemonDetail?.let {
        val context = LocalContext.current
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                    IconButton(
                        onClick = { viewModel.onEvent(DetailEvent.onBackPress) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(
                                R.string.back
                            )
                        )
                    }
                }
            }
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
            item {
                Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.stats),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            items(it.stats) { stat ->
                DetailStatItem(stat = stat, barColor = state.mainColor)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.abilities),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            itemsIndexed(it.abilities) { index, ability ->
                DetailAbilityItem(ability = ability, position = index + 1)
            }
        }
    }
}
