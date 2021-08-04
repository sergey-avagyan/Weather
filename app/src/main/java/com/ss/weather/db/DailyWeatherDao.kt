package com.ss.weather.db

import androidx.room.*
import com.ss.weather.models.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyWeatherDao {

    @Query("SELECT * FROM daily_weather")
    fun getDailyWeather(): Flow<List<Weather>>

    @Transaction
    fun deleteAndInsert(list: List<Weather>) {
        deleteAll()
        insertAll(list)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Weather>)

    @Query("DELETE FROM daily_weather")
    fun deleteAll()
}
