package com.example.fejn.windreport.app

import com.example.fejn.windreport.R
import com.example.fejn.windreport.data.api.RestClient
import com.example.fejn.windreport.data.repository.repository.WeatherRepository
import com.example.fejn.windreport.ui.MainViewModel
import io.coroutines.cache.core.CoroutinesCache
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

object AppInject {

    fun modules() : List<Module> = listOf(
        applicationModule,
        viewModelModule,
        repositoriesModule
    )

    private val applicationModule: Module = module {
        single { RestClient(androidContext().getString(R.string.country_metric)).api }
        single { CoroutinesCache(androidContext()) }
    }

    private val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }

    private val repositoriesModule: Module = module {
        single { WeatherRepository(get(), get()) }
    }
}