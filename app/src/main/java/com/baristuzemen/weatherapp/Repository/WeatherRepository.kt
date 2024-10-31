package com.baristuzemen.weatherapp.Repository

import com.baristuzemen.weatherapp.Server.ApiServices

class WeatherRepository(val api: ApiServices) {

    fun getCurrentWeatherData(lat: Double, lng: Double, unit: String) = api.getCurrentWeatherData(lat, lng, unit,"API_KEY")


    fun getForecastWeatherData(lat: Double, lng: Double, unit: String) = api.getForecastWeatherData(lat, lng, unit,"API_KEY")


}