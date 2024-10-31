package com.baristuzemen.weatherapp.Repository

import com.baristuzemen.weatherapp.Server.ApiServices

class CityRepository(val api: ApiServices) {
    fun getCities(q: String, limit: Int) = api.getCitiesList(q, limit, "API_KEY")
}