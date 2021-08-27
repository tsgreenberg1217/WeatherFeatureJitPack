package com.example.weatherapplibrary.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datalib.DataState
import com.example.datalib.models.CityWeatherResult
import com.example.weatherapplibrary.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repo: WeatherRepository
) : ViewModel() {

    val weatherData: MutableLiveData<DataState<CityWeatherResult>> by lazy { MutableLiveData() }

    val cities: MutableLiveData<DataState<List<CityWeatherResult>>> by lazy { MutableLiveData() }

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            repo.getWeatherForCity(cityName).collect {
                weatherData.value = it
            }
        }
    }

    fun getAllCities() {
        viewModelScope.launch { repo.getAllCities().collect { cities.value = it } }
    }


}