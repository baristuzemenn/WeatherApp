package com.baristuzemen.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.baristuzemen.weatherapp.Repository.CityRepository
import com.baristuzemen.weatherapp.Server.ApiClient
import com.baristuzemen.weatherapp.Server.ApiServices
import retrofit2.create

class  CityViewModel(val repository: CityRepository) : ViewModel() {

    constructor() : this(CityRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCity(q: String, limit: Int) = repository.getCities(q, limit)

}