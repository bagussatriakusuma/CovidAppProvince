package com.example.covidapp.Repository

import com.example.covidapp.Data.API.CovidAPI
import com.example.covidapp.Data.API.CovidProvinceResponse
import retrofit2.Response
import javax.inject.Inject

class CovidRepository @Inject constructor(private val api: CovidAPI) {
    suspend fun getCovidProvince(): Response<CovidProvinceResponse>{
        return api.getCovidProvince()
    }
}