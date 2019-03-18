package com.example.fejn.windreport.data.mapper

import com.example.fejn.windreport.data.api.response.WeatherResponse
import com.example.fejn.windreport.data.entity.WeatherBO

fun List<WeatherResponse>.toWeatherBO(): List<WeatherBO> = this.map {

    val weatherDesc = it.weather?.first()?.description ?: ""
    WeatherBO(city = it.name, wind = it.wind.deg, weather = weatherDesc)
}