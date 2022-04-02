package com.example.covidvaccinationfinderapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.covidvaccinationfinderapp.databinding.FragmentHomeBinding
import com.example.covidvaccinationfinderapp.network.Api
import com.example.covidvaccinationfinderapp.network.CovidData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://data.covid19.go.id/public/api/"

class HomeFragment : Fragment() {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private var _binding: com.example.covidvaccinationfinderapp.databinding.FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.title = "Home"

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        getData()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getData() {
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL).build().create(Api::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<CovidData> {
            override fun onResponse(call: Call<CovidData>, response: Response<CovidData>) {
                val responseBody = response.body()!!
                val textView1: TextView = binding.jumlahpositif
                val textView2: TextView = binding.jumlahsembuh
                val textView3: TextView = binding.jumlahmati
                val textView4: TextView = binding.jumlahDirawat
                val dateText: TextView = binding.date
                val totalsembuh: TextView = binding.totalsembuhangka
                val totalmeninggal: TextView = binding.totalmeninggalangka
                val totaldirawat : TextView = binding.totaldirawatangka
                val totalpositif : TextView = binding.totalpositifangka
                textView1.text = responseBody.update.penambahan.jumlah_positif.toString()
                textView2.text = responseBody.update.penambahan.jumlah_sembuh.toString()
                textView3.text = responseBody.update.penambahan.jumlah_meninggal.toString()
                textView4.text = responseBody.update.penambahan.jumlah_dirawat.toString()
                dateText.text = responseBody.update.penambahan.tanggal
                totalsembuh.text = responseBody.update.total.jumlah_sembuh.toString()
                totaldirawat.text = responseBody.update.total.jumlah_dirawat.toString()
                totalpositif.text = responseBody.update.total.jumlah_positif.toString()
                totalmeninggal.text = responseBody.update.total.jumlah_meninggal.toString()
            }

            override fun onFailure(call: Call<CovidData>, t: Throwable) {
                Log.d("HomeFragment", "onFailure" + t.message)
            }
        })
    }
}