package com.example.coviddata.domain.use_case.get_global_covid_data

import com.example.coviddata.common.Resource
import com.example.coviddata.data.remote.dto.toCovidData
import com.example.coviddata.domain.model.CovidData
import com.example.coviddata.domain.repository.CovidRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGlobalCovidDataUseCase @Inject constructor(
    private val repository: CovidRepository
) {
    operator fun invoke(): Flow<Resource<CovidData>> = flow {
        try {
            emit(Resource.Loading<CovidData>())
            val covidData = repository.getCovidData().toCovidData()
            emit(Resource.Success<CovidData>(covidData))
        } catch (e : HttpException) {
            emit(Resource.Error<CovidData>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CovidData>("Couldn't reach server. Check your internet connection."))
        }
    }

}