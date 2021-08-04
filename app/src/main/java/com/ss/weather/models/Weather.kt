package com.ss.weather.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "daily_weather")
data class Weather(
    @field:PrimaryKey val date: Date,
    val timezone: String,
    @field:ColumnInfo(name = "night_temp") val nightTemp: Double,
    @field:ColumnInfo(name = "morn_temp") val morningTemp: Double,
    @field:ColumnInfo(name = "day_temp") val dayTemp: Double,
    @field:ColumnInfo(name = "eve_temp") val eveningTemp: Double,
    val humidity: Int,
    val windSpeed: Double,
    @field:SerializedName("icon") val icon: String?
) {

    val title: String
        get() {
            return SimpleDateFormat("E, d MMM", Locale.getDefault()).format(date)
                .plus(", $timezone")
        }

    val iconUrl: String
        get() {
            return "http://openweathermap.org/img/wn/$icon@2x.png"
        }
}