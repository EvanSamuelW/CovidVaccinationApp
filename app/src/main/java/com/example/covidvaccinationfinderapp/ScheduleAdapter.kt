package com.example.covidvaccinationfinderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covidvaccinationfinderapp.data.Schedule

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.MyViewHolder>() {


    private var scheduleList = emptyList<Schedule>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val location: TextView = itemView.findViewById(R.id.location)
        val nik: TextView = itemView.findViewById(R.id.nik)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScheduleAdapter.MyViewHolder, position: Int) {
        val currentItem = scheduleList[position]
        holder.name.text = currentItem.name
        holder.location.text = currentItem.location
        holder.date.text = currentItem.date
        holder.nik.text = currentItem.nik
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    fun setData(schedule: List<Schedule>){
        this.scheduleList = schedule
        notifyDataSetChanged()
    }
}