package com.example.countrylistappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylistappkotlin.model.Model

class HomeViewModel : ViewModel() {
    val countries = MutableLiveData<List<Model>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val testCountry = Model("Azerbaycan", "Baku", "Asia", "AZN", "Azerbaycan dili", "www.test.az")
        val testCountry2 = Model("Azerbaycan", "Baku", "Asia", "AZN", "Azerbaycan dili", "www.test.az")
        val testCountry3 = Model("Azerbaycan", "Baku", "Asia", "AZN", "Azerbaycan dili", "www.test.az")
        val testCountry4 = Model("Azerbaycan", "Baku", "Asia", "AZN", "Azerbaycan dili", "www.test.az")

        val testCountryList = arrayListOf<Model>(testCountry, testCountry2, testCountry3, testCountry4)

        countries.value = testCountryList
        countryError.value = false
        countryLoading.value = false
    }


}