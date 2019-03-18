package com.example.fejn.windreport.data.repository.repository

import android.content.Context
import android.util.Log
import com.example.fejn.windreport.data.api.RestApi
import com.example.fejn.windreport.data.entity.WeatherBO
import com.example.fejn.windreport.data.mapper.toWeatherBO
import io.coroutines.cache.core.CoroutinesCache

class WeatherRepository(private val restApi: RestApi, context: Context): CoroutinesCache(context){

    suspend fun loadWeather(ids:String):List<WeatherBO>{

        return restApi.loadWeather(ids).await().list.toWeatherBO()
    }
}