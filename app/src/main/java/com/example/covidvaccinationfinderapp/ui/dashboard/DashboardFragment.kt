package com.example.covidvaccinationfinderapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidvaccinationfinderapp.Location
import com.example.covidvaccinationfinderapp.LocationAdapter
import com.example.covidvaccinationfinderapp.R
import com.example.covidvaccinationfinderapp.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment(), LocationAdapter.OnItemClickListener {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var locationRecyclerView: RecyclerView
    private lateinit var locationArrayList: ArrayList<Location>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var address: Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.title = "Location"
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h
        )

        name = arrayOf(
            "Siloam Hospitals Yogyakarta",
            "Bethesda Hospital, Yogyakarta",
            "Panti Rapih Hospital",
            "RS DKT Dr. Soetarto",
            "Dr. Sardjito General Hospital",
            "Happy Land Medical Centre",
            "Yogyakarta Public Hospital",
            "PKU Muhammadiyah Hospital Of Yogyakarta"
        )

        address = arrayOf(
            " Jl. Laksda Adisucipto No.32-34, Demangan, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55221",
            "Jl. Jend. Sudirman No.70, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224",
            "Jl. Cik Di Tiro No.30, Samirono, Terban, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55223",
            "Jl. Juadi No.19, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224",
            "Jl. Kesehatan No.1, Senolowo, Sinduadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281",
            "Jl. Ipda Tut Harsono Jl. Melati Wetan No.53, Muja Muju, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55165",
            "Jl. Ki Ageng Pemanahan No.1-6, Sorosutan, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55162",
            "Jl. KH. Ahmad Dahlan No.20, Ngupasan, Kec. Gondomanan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55122"
        )

        locationRecyclerView = binding.recyclerView
        locationRecyclerView.layoutManager = LinearLayoutManager(context)
        locationRecyclerView.setHasFixedSize(true)

        locationArrayList = arrayListOf<Location>()
        getData()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        val item = locationArrayList[position]
        val bundle = bundleOf("name" to item.name)

        findNavController().navigate(R.id.action_navigation_location_to_registerVaccination, bundle)
    }

    private fun getData() {
        for (i in imageId.indices) {
            val locations = Location(name[i], address[i], imageId[i])
            locationArrayList.add(locations)
        }

        locationRecyclerView.adapter = LocationAdapter(locationArrayList,this)
    }


}