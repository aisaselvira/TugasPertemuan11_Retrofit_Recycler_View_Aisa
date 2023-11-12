package com.example.tugaspertemuan11_retrofit_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan11_retrofit_recycler_view.databinding.ItemHeroBinding
import com.example.tugaspertemuan11_retrofit_recycler_view.model.DataHero
import com.squareup.picasso.Picasso

class HeroAdapter(private var listHero: List<DataHero>) :
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {

    inner class ItemHeroViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(data: DataHero) {
            with(binding) {
                namaHero.text = data.nameHero
                idHero.text = data.id.toString()

                Picasso.get()
                    .load(data.imageHero)
                    .error(R.drawable.defaultt)
                    .into(gambarHero)
            }
        }
    }

    fun setDataHero(newData: List<DataHero>) {
        listHero = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroViewHolder {
        val binding = ItemHeroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size
}