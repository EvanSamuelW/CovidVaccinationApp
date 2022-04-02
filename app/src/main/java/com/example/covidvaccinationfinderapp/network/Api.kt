package com.example.covidvaccinationfinderapp.network

import retrofit2.http.GET

interface Api {
    @GET("update.json")
    fun getData(): retrofit2.Call<CovidData>
}