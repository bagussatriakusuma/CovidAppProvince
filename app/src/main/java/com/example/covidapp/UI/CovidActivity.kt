package com.example.covidapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.covidapp.R
import com.example.covidapp.databinding.ActivityCovidBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CovidActivity : AppCompatActivity() {
    lateinit var binding: ActivityCovidBinding
    private lateinit var adapterCovid: CovidAdapter
    private val viewModel: CovidViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterCovid = CovidAdapter(listCovid = emptyList())
        binding.rvShowCovid.adapter = adapterCovid
        bindViewModel()
        viewModel.getCovidProvince()
    }

    private fun bindViewModel(){
        viewModel.showData.observe(this){
            adapterCovid.updateList(it.listData)
        }
    }
}