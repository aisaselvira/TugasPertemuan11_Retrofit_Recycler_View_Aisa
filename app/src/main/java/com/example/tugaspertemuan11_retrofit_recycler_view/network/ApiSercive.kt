package com.example.tugaspertemuan11_retrofit_recycler_view.network

import com.example.tugaspertemuan11_retrofit_recycler_view.model.HeroModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiSercive {
    @GET("rest-api-sample/data.php")
    fun getAllHeroes(): Call<HeroModel>
}