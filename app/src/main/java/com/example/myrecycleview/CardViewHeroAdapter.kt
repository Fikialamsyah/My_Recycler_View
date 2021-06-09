package com.example.myrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class CardViewHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.cardViewHolder>() {
    inner class cardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, int: Int): cardViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_hero, viewGroup, false)

        return cardViewHolder(view)
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        val hero = listHero[position]

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite " + listHero[holder.adapterPosition].name,Toast.LENGTH_SHORT).show()
        }

        holder.btnShare.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Share " + listHero[holder.adapterPosition].name,Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listHero[holder.adapterPosition].name,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}