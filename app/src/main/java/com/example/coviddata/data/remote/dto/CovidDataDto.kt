package com.example.coviddata.data.remote.dto

import com.example.coviddata.domain.model.CovidData

data class CovidDataDto(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global,
    val ID: String,
    val Message: String
)

fun CovidDataDto.toCovidData(): CovidData {
    return CovidData(
        newConfirmed = Global.NewConfirmed,
        newDeaths = Global.NewDeaths,
        newRecovered = Global.NewRecovered,
        totalConfirmed = Global.TotalConfirmed,
        totalDeaths = Global.TotalDeaths,
        totalRecovered = Global.TotalRecovered
    )
}