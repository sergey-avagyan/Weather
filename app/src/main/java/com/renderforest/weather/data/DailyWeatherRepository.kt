package com.renderforest.weather.data

import com.renderforest.weather.db.DailyWeatherDao
import com.renderforest.weather.models.Weather
import com.renderforest.weather.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyWeatherRepository @Inject constructor(
    private val dailyWeatherDataSource: DailyWeatherDataSource,
    private val dailyWeatherDao: DailyWeatherDao,
    private val networkUtils: NetworkUtils
) {

    val dailyWeather: Flow<List<Weather>>
        get() {
            return if (networkUtils.hasNetworkConnection()) {
                dailyWeatherDataSource.getDailyWeatherRemote()
                    .onEach { list -> dailyWeatherDao.deleteAndInsert(list) }
                    .flowOn(Dispatchers.IO)
            } else {
                dailyWeatherDataSource.getDailyWeatherLocal()
            }
        }
}