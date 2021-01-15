package com.renderforest.weather.util

import com.renderforest.weather.data.DailyWeatherResponse
import com.renderforest.weather.models.Weather

fun DailyWeatherResponse.toList(): List<Weather> {
    return daily.map { daily ->
        Weather(
            date = daily.date,
            timezone = timezone,
            nightTemp = daily.temp.night,
            morningTemp = daily.temp.morn,
            dayTemp = daily.temp.day,
            eveningTemp = daily.temp.eve,
            humidity = daily.humidity,
            windSpeed = daily.windSpeed,
            icon = daily.weather.firstOrNull()?.icon
        )
    }
}