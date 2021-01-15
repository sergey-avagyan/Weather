package com.renderforest.weather.di

import com.renderforest.weather.api.DailyWeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideDailyWeatherService(): DailyWeatherService {
        return DailyWeatherService.create()
    }
}