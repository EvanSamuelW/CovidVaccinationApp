package com.example.covidvaccinationfinderapp.network

data class Penambahan(
    val created: String,
    val jumlah_dirawat: Int,
    val jumlah_meninggal: Int,
    val jumlah_positif: Int,
    val jumlah_sembuh: Int,
    val tanggal: String
)