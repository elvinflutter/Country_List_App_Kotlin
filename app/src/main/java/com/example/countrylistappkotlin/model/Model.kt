package com.example.countrylistappkotlin.model

import com.google.gson.annotations.SerializedName

data class Model (
    @SerializedName("name")
    val countryName:String?,
    @SerializedName("capital")
    val countryCapital:String?,
    @SerializedName("region")
    val countryRegion:String?,
    @SerializedName("currency")
    val countryCurrency:String?,
    @SerializedName("flag")
    val imageUrl: String?,
    @SerializedName("language")
    val countryLanguage:String?)