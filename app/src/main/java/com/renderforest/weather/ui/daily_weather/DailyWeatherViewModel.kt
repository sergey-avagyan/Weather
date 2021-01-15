package com.renderforest.weather.ui.daily_weather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.renderforest.weather.data.DailyWeatherRepository
import com.renderforest.weather.models.Weather

class DailyWeatherViewModel @ViewModelInject constructor(
    repository: DailyWeatherRepository
) : ViewModel() {

    val dailyWeather: LiveData<List<Weather>> = repository.dailyWeather.asLiveData()

}