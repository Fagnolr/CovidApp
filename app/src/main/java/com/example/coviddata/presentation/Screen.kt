package com.example.coviddata.presentation

sealed class Screen(val route: String) {
    object CovidDataScreen: Screen("covid_data_screen")
}
