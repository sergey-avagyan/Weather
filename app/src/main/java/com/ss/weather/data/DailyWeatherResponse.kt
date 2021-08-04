package com.ss.weather.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class DailyWeatherResponse(
    @field:SerializedName("timezone") val timezone: String,
    @field:SerializedName("daily") val daily: List<DailyWeather>
) {

    data class DailyWeather(
        @field:SerializedName("dt") val date: Date,
        @field:SerializedName("temp") val temp: Temp,
        @field:SerializedName("humidity") val humidity: Int,
        @field:SerializedName("wind_speed") val windSpeed: Double,
        @field:SerializedName("clouds") val clouds: Int,
        @field:SerializedName("weather") val weather: List<Weather>
    ) {

        data class Temp(
            @field:SerializedName("night") val night: Double,
            @field:SerializedName("morn") val morn: Double,
            @field:SerializedName("day") val day: Double,
            @field:SerializedName("eve") val eve: Double,
        )

        data class Weather(
            @field:SerializedName("id") val id: Int,
            @field:SerializedName("main") val main: String,
            @field:SerializedName("icon") val icon: String
        )
    }
}