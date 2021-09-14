package com.example.coviddata.domain.repository

import com.example.coviddata.data.remote.dto.CovidDataDto

interface CovidRepository {

    suspend fun getCovidData(): CovidDataDto
}