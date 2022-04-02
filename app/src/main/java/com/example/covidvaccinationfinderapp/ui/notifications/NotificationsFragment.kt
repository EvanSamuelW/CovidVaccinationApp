package com.example.covidvaccinationfinderapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidvaccinationfinderapp.R
import com.example.covidvaccinationfinderapp.ScheduleAdapter
import com.example.covidvaccinationfinderapp.data.ScheduleViewModel
import com.example.covidvaccinationfinderapp.databinding.FragmentHomeBinding
import com.example.covidvaccinationfinderapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var scheduleViewModel: ScheduleViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.title = "Schedule"

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val adapter = ScheduleAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        scheduleViewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        scheduleViewModel.readAllData.observe(viewLifecycleOwner, Observer {schedule ->
            adapter.setData(schedule)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}