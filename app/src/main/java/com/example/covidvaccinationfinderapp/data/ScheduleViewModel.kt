package com.example.covidvaccinationfinderapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class ScheduleViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Schedule>>
    private val repository: ScheduleRepository

    init {
        val scheduleDao = ScheduleDatabase.getDatabase(application).scheduleDao()
        repository = ScheduleRepository(scheduleDao)
        readAllData = repository.readAllData
    }

    fun addSchedule(schedule: Schedule) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSchedule(schedule)
        }
    }
}