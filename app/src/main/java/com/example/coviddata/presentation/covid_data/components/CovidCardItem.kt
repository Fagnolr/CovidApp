package com.example.coviddata.presentation.covid_data.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CovidCardItem(
    text : String,
    data : String,
) {
    Card(backgroundColor = Color.White, shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(all = 8.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(all = 16.dp)) {
            Text(text = text, style = MaterialTheme.typography.h4, color = Color.Black)
            Text(text = data, style = MaterialTheme.typography.h3, color = Color.Black)
        }
    }
}