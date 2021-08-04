package com.ss.weather.ui.daily_weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ss.weather.databinding.ListItemDailyWeatherBinding
import com.ss.weather.models.Weather

class DailyWeatherAdapter : RecyclerView.Adapter<DailyWeatherAdapter.DailyWeatherViewHolder>(){

    private var weatherList = emptyList<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherViewHolder {
        return DailyWeatherViewHolder(
            ListItemDailyWeatherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount() = weatherList.size

    fun submitList(list: List<Weather>) {
        if (weatherList != list) {
            weatherList = list
            notifyDataSetChanged()
        }
    }

    class DailyWeatherViewHolder(
        private val binding: ListItemDailyWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Weather) {
            binding.apply {
                weather = item
                executePendingBindings()
            }
        }
    }
}
