package com.example.covidapp.UI

import android.annotation.SuppressLint
import android.media.metrics.Event
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapp.Data.API.CovidProvinceResponse
import com.example.covidapp.databinding.ItemListCovidBinding
import java.util.*

class CovidAdapter(private var listCovid: List<CovidProvinceResponse.ListData>):
    RecyclerView.Adapter<CovidAdapter.ViewHolder>(){
        inner class ViewHolder(val binding: ItemListCovidBinding): RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<CovidProvinceResponse.ListData>) {
        this.listCovid = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListCovidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val type = listCovid[position]
        holder.binding.tvDaerah.text = type.key
        holder.binding.tvJumlahKasus.text = type.jumlahKasus.toString()
        holder.binding.tvJumlahSembuh.text = type.jumlahSembuh.toString()
        holder.binding.tvJumlahMeninggal.text = type.jumlahMeninggal.toString()
        holder.binding.tvJumlahDirawat.text = type.jumlahDirawat.toString()
    }

    override fun getItemCount(): Int {
        return listCovid.size
    }

}