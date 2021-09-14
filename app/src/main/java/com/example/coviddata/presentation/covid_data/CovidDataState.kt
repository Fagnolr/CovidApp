package com.example.coviddata.presentation.covid_data

import com.example.coviddata.domain.model.CovidData

data class CovidDataState(
    val isLoading: Boolean = false,
    val covidData: CovidData? = null,
    val error: String = ""
)