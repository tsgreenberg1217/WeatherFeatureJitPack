package com.example.weatherapplibrary.recyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datalib.models.CityWeatherResult
import com.example.weatherapplibrary.R
import com.example.weatherapplibrary.databinding.ViewholderWeatherBinding

class WeatherRecyclerViewAdapter(private val weatherList: MutableList<CityWeatherResult>) :
    RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return LayoutInflater.from(parent.context).inflate(
            R.layout.viewholder_weather, parent, false
        ).run { WeatherViewHolder(this) }
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindView(weatherList[position])
    }

    override fun getItemCount(): Int = weatherList.size

    fun updateCities(newCities:List<CityWeatherResult>){
        // TODO: use diff util
        weatherList.clear()
        weatherList.addAll(newCities)
        notifyDataSetChanged()
    }
}


class WeatherViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val binding: ViewholderWeatherBinding = ViewholderWeatherBinding.bind(item)

    fun bindView(data: CityWeatherResult) {
        binding.weatherVHCityTxt.text = data.name
        binding.weatherVHHumidityTxt.text = "Humidity: ${data.humidity.toString()}"
    }

}