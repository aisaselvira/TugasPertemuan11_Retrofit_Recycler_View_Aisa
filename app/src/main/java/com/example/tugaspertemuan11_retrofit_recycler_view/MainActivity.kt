package com.example.tugaspertemuan11_retrofit_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan11_retrofit_recycler_view.databinding.ActivityMainBinding
import com.example.tugaspertemuan11_retrofit_recycler_view.model.DataHero
import com.example.tugaspertemuan11_retrofit_recycler_view.model.HeroModel
import com.example.tugaspertemuan11_retrofit_recycler_view.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var heroAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHero.layoutManager = LinearLayoutManager(this@MainActivity)

        heroAdapter = HeroAdapter(emptyList<DataHero>())
        binding.rvHero.adapter = heroAdapter

        val apiService = ApiClient.getInstance()

        apiService.getAllHeroes().enqueue(object : Callback<HeroModel> {
            override fun onResponse(call: Call<HeroModel>, response: Response<HeroModel>) {
                if (response.isSuccessful) {
                    val modelHero = response.body()
                    val heroo = modelHero?.data ?: emptyList()
                    heroAdapter.setDataHero(heroo)
                }
            }

            override fun onFailure(call: Call<HeroModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error Connection",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}