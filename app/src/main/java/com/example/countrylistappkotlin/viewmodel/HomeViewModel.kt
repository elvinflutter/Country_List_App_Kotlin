package com.example.countrylistappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylistappkotlin.model.Model
import com.example.countrylistappkotlin.service.CountryAPIServices
import io.reactivex.disposables.CompositeDisposable


class HomeViewModel : ViewModel() {
    private val countryAPIServices = CountryAPIServices()
    private val disposable = CompositeDisposable()
    val countries = MutableLiveData<List<Model>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    private fun getDataFromAPI() {
        countryLoading.value = true

        disposable.add(
            countryAPIServices.getCountryData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Model>>() {
                    override fun onSuccess(data: List<Model>) {
                        // Handle the successful response here
                        // You can update the LiveData `countries` with the data
                        countries.value = data

                        // Set loading to false since the data loading is complete
                        countryLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        // Handle errors here, e.g., show an error message to the user
                        countryError.value = true

                        // Set loading to false since an error occurred during data loading
                        countryLoading.value = false
                    }
                })
        )

    }

    fun refreshData() {
        getDataFromAPI()

    }




}