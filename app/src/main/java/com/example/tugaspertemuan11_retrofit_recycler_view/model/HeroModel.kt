package com.example.tugaspertemuan11_retrofit_recycler_view.model

import com.google.gson.annotations.SerializedName

data class HeroModel(
    @SerializedName("result")
    val `data`: List<DataHero>
)