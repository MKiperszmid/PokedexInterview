package com.mk.interviewprocess.detail.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailAbilityItem(
    position: Int,
    ability: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Ability $position: ", color = Color.Gray)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = ability, color = Color.White)
    }
}

@Preview
@Composable
fun DetailAbilityItemPreview() {
    DetailAbilityItem(1, "Growl")
}
