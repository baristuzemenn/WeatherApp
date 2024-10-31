package com.baristuzemen.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.baristuzemen.weatherapp.Repository.WeatherRepository
import com.baristuzemen.weatherapp.Server.ApiClient
import com.baristuzemen.weatherapp.Server.ApiServices

class WeatherViewModel(val repository: WeatherRepository):ViewModel() {

    constructor():this(WeatherRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCurrentWeatherData(lat: Double, lng: Double, unit: String) = repository.getCurrentWeatherData(lat, lng, unit)


    fun loadForecastWeatherData(lat: Double, lng: Double, unit: String) = repository.getForecastWeatherData(lat, lng, unit)


}