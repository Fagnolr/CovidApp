package com.example.coviddata.data.repository

import com.example.coviddata.data.remote.CovidApi
import com.example.coviddata.data.remote.dto.CovidDataDto
import com.example.coviddata.domain.model.CovidData
import com.example.coviddata.domain.repository.CovidRepository
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(
    private val api: CovidApi
) : CovidRepository {
    override suspend fun getCovidData(): CovidDataDto {
        return api.getCovidData()
    }
}