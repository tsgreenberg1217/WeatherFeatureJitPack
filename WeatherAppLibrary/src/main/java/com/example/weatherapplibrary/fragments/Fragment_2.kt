package com.example.weatherapplibrary.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datalib.DataState
import com.example.weatherapplibrary.R
import com.example.weatherapplibrary.baseClasses.BaseFragment
import com.example.weatherapplibrary.databinding.Fragment2Binding
import com.example.weatherapplibrary.recyclerViews.WeatherRecyclerViewAdapter
import com.example.weatherapplibrary.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment_2 : BaseFragment(R.layout.fragment_2) {
    lateinit var binding: Fragment2Binding

    private val weatherViewModel: WeatherViewModel by viewModels()
    lateinit var adapter: WeatherRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = Fragment2Binding.bind(view)
        binding.weatherRV.layoutManager = LinearLayoutManager(this@Fragment_2.context)
        adapter = WeatherRecyclerViewAdapter(mutableListOf())
        binding.weatherRV.adapter = adapter
        weatherViewModel.cities.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    adapter.updateCities(it.data)
                }
                is DataState.Error -> {
                }
                is DataState.Loading -> {
                }
                else -> {
                }
            }
        }
        weatherViewModel.getAllCities()
    }
}