package com.example.countrylistappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylistappkotlin.model.Model

class DetailViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Model>()

    fun getDataFromRoom() {
        val country = Model("Azerbaycan", "Baku", "Asia", "AZN", "Azerbaycan dili", "www.test.az")
        countryLiveData.value = country
    }
}