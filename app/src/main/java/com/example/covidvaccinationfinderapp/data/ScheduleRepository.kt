package com.example.covidvaccinationfinderapp.data

import androidx.lifecycle.LiveData

class ScheduleRepository( private val scheduleDao: ScheduleDao) {

    val readAllData: LiveData<List<Schedule>> = scheduleDao.readAllData()

    suspend fun addSchedule(schedule: Schedule){
        scheduleDao.addSchedule(schedule)
    }
}