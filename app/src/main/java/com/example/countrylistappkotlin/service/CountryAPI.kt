package com.example.countrylistappkotlin.service


import com.example.countrylistappkotlin.model.Model
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    // https://raw.githubusercontent.com/
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Model>>
}