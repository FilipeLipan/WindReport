package com.example.fejn.windreport.ui

import androidx.lifecycle.MutableLiveData
import com.example.fejn.windreport.data.entity.WeatherBO
import com.example.fejn.windreport.data.repository.repository.WeatherRepository
import com.example.fejn.windreport.ui.base.BaseViewModel
import com.example.fejn.windreport.utils.safeAsync

class MainViewModel(val weatherRepository: WeatherRepository) : BaseViewModel() {

    val weatherLiveData: MutableLiveData<List<WeatherBO>> = MutableLiveData()

    init {
        loadWeather("524901,703448,2643743")
    }

    fun loadWeather(ids :String){

        showLoading()
        safeAsync(
            action = { weatherRepository.loadWeather(ids) },
            onSuccess = {result ->
                dismissLoading()
              weatherLiveData.value = result
            },
            onError = {error ->
                dismissLoading()
                //TODO show error
            })
    }
}