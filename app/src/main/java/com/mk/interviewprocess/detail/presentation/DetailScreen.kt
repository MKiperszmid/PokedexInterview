package com.mk.interviewprocess.detail.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel
}
