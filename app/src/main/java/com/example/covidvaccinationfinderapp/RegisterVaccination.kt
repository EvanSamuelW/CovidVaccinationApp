package com.example.covidvaccinationfinderapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.covidvaccinationfinderapp.data.Schedule
import com.example.covidvaccinationfinderapp.data.ScheduleViewModel
import com.example.covidvaccinationfinderapp.databinding.FragmentDashboardBinding
import com.example.covidvaccinationfinderapp.databinding.FragmentRegisterVaccinationBinding
import java.util.*


class RegisterVaccination : Fragment() {

    private var _binding: FragmentRegisterVaccinationBinding? = null

    private lateinit var scheduleViewModel: ScheduleViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val location = arguments?.getString("location")

        scheduleViewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        _binding = FragmentRegisterVaccinationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.saveAction.setOnClickListener {
            insertData(location)
        }
        return root
    }

    private fun insertData(location: String?) {
        val name = binding.itemName.text.toString()
        val nik = binding.nikField.text.toString()
        val date = binding.datePicker1.dayOfMonth
        val month = binding.datePicker1.month
        val year = binding.datePicker1.year

        val formatted = Calendar.getInstance()
        formatted.set(year, month - 1, date, 0, 0)
        val s = formatted.time.toString()

        if (validate(name, nik, s)) {
            val schedule = Schedule(0, name, nik, s,location)
            scheduleViewModel.addSchedule(schedule)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_registerVaccination_to_navigation_schedule)
        }

    }

    private fun validate(name: String, nik: String, date: String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(nik) && TextUtils.isEmpty(date))
    }

}