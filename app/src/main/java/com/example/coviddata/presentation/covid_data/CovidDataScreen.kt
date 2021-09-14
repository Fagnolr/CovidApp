package com.example.coviddata.presentation.covid_data

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridCells.*
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coviddata.presentation.covid_data.components.CovidCardItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CovidDataScreen(
    viewModel: CovidDataViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.covidData?.let { result ->
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    CovidCardItem(text = "Total Deaths", data = result.totalDeaths.toString())
                    CovidCardItem(text = "Total Confirmed", data = result.totalConfirmed.toString())
                }
                Row() {
                    CovidCardItem(text = "Total Recovered", data = result.totalRecovered.toString())
                    CovidCardItem(text = "New Confirmed", data = result.newConfirmed.toString())
                }
                Row() {
                    CovidCardItem(text = "New Deaths", data = result.newDeaths.toString())
                    CovidCardItem(text = "New Recovered", data = result.newRecovered.toString())
                }
            }

        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}