package com.ss.weather.data

import com.ss.weather.api.DailyWeatherService
import com.ss.weather.db.DailyWeatherDao
import com.ss.weather.util.WEATHER_COORDINATES
import com.ss.weather.util.toList
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DailyWeatherDataSource @Inject constructor(
    private val service: DailyWeatherService,
    private val dao: DailyWeatherDao
) {

    fun getDailyWeatherRemote() = flow {
        val response = service.getDailyWeather(
            WEATHER_COORDINATES[0], WEATHER_COORDINATES[1]
        )
        emit(response)
    }.map { it.toList() }

    fun getDailyWeatherLocal() = dao.getDailyWeather()

}