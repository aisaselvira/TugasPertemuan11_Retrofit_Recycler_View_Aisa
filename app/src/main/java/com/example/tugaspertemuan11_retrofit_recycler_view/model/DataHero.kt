package com.example.tugaspertemuan11_retrofit_recycler_view.model

import com.google.gson.annotations.SerializedName

data class DataHero(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val nameHero: String,
    @SerializedName("image")
    val imageHero: String
)