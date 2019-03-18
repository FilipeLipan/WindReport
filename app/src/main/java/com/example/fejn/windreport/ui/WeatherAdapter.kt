package com.example.fejn.windreport.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.fejn.windreport.R
import com.example.fejn.windreport.data.entity.WeatherBO

class WeatherAdapter(data: List<WeatherBO>) : BaseQuickAdapter<WeatherBO, BaseViewHolder>(R.layout.item_weather, data) {

    override fun convert(helper: BaseViewHolder, item: WeatherBO) {
        helper.setText(R.id.cityNameTextView, item.city)
            .setText(R.id.windTextView, item.wind)
            .setText(R.id.weatherTextView, item.weather)
    }
}