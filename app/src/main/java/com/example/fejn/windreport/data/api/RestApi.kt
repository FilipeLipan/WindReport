package com.example.fejn.windreport.data.api


import com.example.fejn.windreport.data.api.response.BaseResponse
import com.example.fejn.windreport.data.api.response.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*


interface RestApi {

    @GET("group")
    fun loadWeather(@Query("id", encoded = true) ids:String): Deferred<BaseResponse<WeatherResponse>>
}


