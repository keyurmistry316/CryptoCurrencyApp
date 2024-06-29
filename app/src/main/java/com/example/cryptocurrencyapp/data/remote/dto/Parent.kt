package com.example.cryptocurrencyapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)