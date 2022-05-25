package com.example.covidapp.Data.API

import retrofit2.Response
import retrofit2.http.GET

interface CovidAPI {
    @GET("prov.json")
    suspend fun getCovidProvince(): Response<CovidProvinceResponse>
}