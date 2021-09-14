package com.example.coviddata.data.remote

import com.example.coviddata.data.remote.dto.CovidDataDto
import retrofit2.http.GET

interface CovidApi {

    @GET("/summary")
    suspend fun getCovidData(): CovidDataDto

}