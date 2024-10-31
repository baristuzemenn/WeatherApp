package com.baristuzemen.weatherapp.Server

import com.baristuzemen.weatherapp.Model.CityResponseApi
import com.baristuzemen.weatherapp.Model.CurrentResponseApi
import com.baristuzemen.weatherapp.Model.ForecastResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("/data/2.5/weather")
    fun getCurrentWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") ApiKey: String,
    ): Call<CurrentResponseApi>


    @GET("/data/2.5/forecast")
    fun getForecastWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") ApiKey: String,
    ): Call<ForecastResponseApi>


    @GET("/geo/1.0/direct")
    fun getCitiesList(
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("appid") ApiKey: String,
    ): Call<CityResponseApi>


}