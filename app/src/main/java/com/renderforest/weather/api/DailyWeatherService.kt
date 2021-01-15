package com.renderforest.weather.api

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.renderforest.weather.BuildConfig
import com.renderforest.weather.data.DailyWeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.reflect.Type
import java.util.*

interface DailyWeatherService {

    @GET("data/2.5/onecall?exclude=current,minutely,hourly,alerts&units=metric")
    suspend fun getDailyWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String = BuildConfig.OPEN_WEATHER_API_KEY
    ): DailyWeatherResponse

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/"

        fun create(): DailyWeatherService {
            val gson = GsonBuilder()
                .registerTypeAdapter(Date::class.java, object : JsonDeserializer<Date> {
                    override fun deserialize(
                        json: JsonElement,
                        typeOfT: Type,
                        context: JsonDeserializationContext
                    ): Date {
                        return Date(json.asJsonPrimitive.asLong * 1000)
                    }
                }).create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(DailyWeatherService::class.java)
        }
    }
}