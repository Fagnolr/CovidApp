package com.example.coviddata.di

import androidx.compose.ui.unit.Constraints
import com.example.coviddata.common.Constants
import com.example.coviddata.data.remote.CovidApi
import com.example.coviddata.data.repository.CovidRepositoryImpl
import com.example.coviddata.domain.repository.CovidRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCovidApi(): CovidApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CovidApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCovidRepository(api : CovidApi) : CovidRepository {
        return CovidRepositoryImpl(api)
    }

}