package com.example.coviddata.domain.model

data class CovidData(
    val newConfirmed: Int,
    val newDeaths: Int,
    val newRecovered: Int,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int
)
