package com.example.covidvaccinationfinderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class LocationAdapter(
    private val locationsList: ArrayList<Location>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<LocationAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tv_heading)
        val tvAddress: TextView = itemView.findViewById(R.id.tv_address)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }

        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationAdapter.MyViewHolder, position: Int) {

        val currentLocation = locationsList[position]
        holder.titleImage.setImageResource(currentLocation.image)
        holder.tvHeading.text = currentLocation.name
        holder.tvAddress.text = currentLocation.address

    }

    override fun getItemCount(): Int {
        return locationsList.size
    }
}



