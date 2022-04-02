package com.example.covidvaccinationfinderapp.network

data class Update(
    val harian: List<Harian>,
    val penambahan: Penambahan,
    val total: Total
)