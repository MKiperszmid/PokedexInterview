package com.mk.interviewprocess.detail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mk.interviewprocess.detail.domain.model.PokemonStat
import com.mk.interviewprocess.ui.theme.Grass

@Composable
fun DetailStatItem(stat: PokemonStat, barColor: Color, modifier: Modifier = Modifier) {
    val statValueRange = remember {
        if (stat.value > 100) 100 else stat.value
    }
    val statFilledRange = remember { (statValueRange) * 2 }
    val statUnfilledRange = remember { (100 - statValueRange) * 2 }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stat.name, color = Color.Gray)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stat.value.toString(), color = Color.White)
            Spacer(modifier = Modifier.width(50.dp))
            Divider(Modifier.width((statFilledRange).dp), color = barColor)
            Divider(Modifier.width((statUnfilledRange).dp), color = Color.LightGray)
        }
    }
}

@Preview
@Composable
fun DetailStatItemPreview() {
    DetailStatItem(
        PokemonStat("HP", 99),
        barColor = Grass
    )
}
