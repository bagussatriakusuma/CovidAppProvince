package com.example.covidapp.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidapp.Data.API.CovidProvinceResponse
import com.example.covidapp.Repository.CovidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CovidViewModel @Inject constructor(private val repo: CovidRepository): ViewModel() {
    val showData: MutableLiveData<CovidProvinceResponse> = MutableLiveData()
    val showError: MutableLiveData<String> = MutableLiveData()

    fun getCovidProvince(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = repo.getCovidProvince()
            withContext(Dispatchers.Main){
                if (result.isSuccessful){
                    //show data
                    val data = result.body()
                    showData.postValue(data)
                }else{
                    //show error
                    val data = result.errorBody()
                    showError.postValue(data.toString())
                }
            }
        }
    }
}