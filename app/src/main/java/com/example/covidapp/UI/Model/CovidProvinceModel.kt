package com.example.covidapp.UI.Model

data class CovidProvinceModel(
    val key: String,
    val jumlah_kasus: Int,
    val jumlah_sembuh: Int,
    val jumlah_meninggal: Int,
    val jumlah_dirawat: Int
)