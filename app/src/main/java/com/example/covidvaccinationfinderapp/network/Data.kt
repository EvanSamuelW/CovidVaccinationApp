package com.example.covidvaccinationfinderapp.network

data class Data(
    val id: Int,
    val jumlah_odp: Int,
    val jumlah_pdp: Int,
    val total_spesimen: Int,
    val total_spesimen_negatif: Int
)