package com.example.coviddata.presentation.covid_data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coviddata.common.Resource
import com.example.coviddata.domain.use_case.get_global_covid_data.GetGlobalCovidDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CovidDataViewModel @Inject constructor(
    private val getGlobalCovidDataUseCase: GetGlobalCovidDataUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CovidDataState())
    val state : State<CovidDataState> = _state

    init {
        getCovidData()
    }

    private fun getCovidData() {
        getGlobalCovidDataUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CovidDataState(covidData = result.data)
                }
                is Resource.Error -> {
                    _state.value = CovidDataState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CovidDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}