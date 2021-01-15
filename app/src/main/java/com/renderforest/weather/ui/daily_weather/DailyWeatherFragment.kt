package com.renderforest.weather.ui.daily_weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.renderforest.weather.R
import com.renderforest.weather.databinding.FragmentDailyWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyWeatherFragment : Fragment() {

    private val adapter = DailyWeatherAdapter()
    private val viewModel: DailyWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDailyWeatherBinding.inflate(inflater, container, false)

        binding.recycler.adapter = adapter
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.dailyWeather.observe(viewLifecycleOwner) { list ->
            if (list.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.label_check_your_internet_connection), Toast.LENGTH_SHORT
                ).show()
            }
            adapter.submitList(list)
        }
    }
}