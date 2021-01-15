package com.renderforest.weather.db

import android.content.Context
import androidx.room.*
import com.renderforest.weather.models.Weather
import com.renderforest.weather.util.DATABASE_NAME

@Database(entities = [Weather::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dailyWeatherDao(): DailyWeatherDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}