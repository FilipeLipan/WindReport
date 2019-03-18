package com.example.fejn.windreport.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fejn.windreport.R
import com.example.fejn.windreport.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()
    override val activityLayout: Int
        get() = R.layout.activity_main

    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        observeViewModel()
    }

    fun initAdapter(){
        recyclerview.layoutManager = LinearLayoutManager(this)
        weatherAdapter = WeatherAdapter(arrayListOf());
        recyclerview.adapter = weatherAdapter
    }

    fun observeViewModel(){
        viewModel.weatherLiveData.observe(this@MainActivity, Observer { weather ->
            weatherAdapter.setNewData(weather)
        })
    }
}
