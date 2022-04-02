package com.example.covidvaccinationfinderapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_table")
data class Schedule (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String ,
    val nik: String,
    val date: String,
    val location: String?
)