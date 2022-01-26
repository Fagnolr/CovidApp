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
        state.covidData?.let { res ->

            LazyVerticalGrid(modifier = Modifier.align(Alignment.Center) ,cells = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp), content = {
                item {
                    CovidCardItem(text = "Total Deaths", data = res.totalDeaths.toString())
                }
                item {
                    CovidCardItem(text = "Total Confirmed", data = res.totalConfirmed.toString())
                }
                item {
                    CovidCardItem(text = "Total Recovered", data = res.totalRecovered.toString())
                }
                item {
                    CovidCardItem(text = "New Confirmed", data = res.newConfirmed.toString())
                }
                item {
                    CovidCardItem(text = "New Deaths", data = res.newDeaths.toString())
                }
                item {
                    CovidCardItem(text = "New Recovered", data = res.newRecovered.toString())
                }
            } )
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