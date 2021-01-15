package com.renderforest.weather.data

import com.renderforest.weather.api.DailyWeatherService
import com.renderforest.weather.db.DailyWeatherDao
import com.renderforest.weather.util.WEATHER_COORDINATES
import com.renderforest.weather.util.toList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

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