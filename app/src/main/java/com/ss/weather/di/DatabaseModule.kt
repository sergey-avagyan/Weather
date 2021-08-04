package com.ss.weather.di

import android.content.Context
import com.ss.weather.db.AppDatabase
import com.ss.weather.db.DailyWeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideDailyWeatherDao(appDatabase: AppDatabase): DailyWeatherDao {
        return appDatabase.dailyWeatherDao()
    }
}