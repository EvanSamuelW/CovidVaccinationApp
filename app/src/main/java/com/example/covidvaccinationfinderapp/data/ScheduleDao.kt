package com.example.covidvaccinationfinderapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSchedule(schedule: Schedule)

    @Query("SELECT * FROM schedule_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Schedule>>
}