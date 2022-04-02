package com.example.covidvaccinationfinderapp.network

data class Total(
    val jumlah_dirawat: Int,
    val jumlah_meninggal: Int,
    val jumlah_positif: Int,
    val jumlah_sembuh: Int
)