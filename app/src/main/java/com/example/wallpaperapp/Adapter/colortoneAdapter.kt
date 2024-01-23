package com.example.wallpaperapp.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.FinalWallpaper
import com.example.wallpaperapp.Model.colorToneModel
import com.example.wallpaperapp.R

class colortoneAdapter(val requireContext: Context, val listTheColorTone: ArrayList<colorToneModel>) : RecyclerView.Adapter<colortoneAdapter.colortoneViewHolder>() {

    inner class colortoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardBack= itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): colortoneViewHolder {
        return colortoneViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone, parent, false)
        )
    }

    override fun getItemCount()= listTheColorTone.size

    override fun onBindViewHolder(holder: colortoneViewHolder, position: Int) {

        val color= listTheColorTone[position].color
        holder.cardBack.setBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener{
            val intent= Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link", listTheColorTone[position].link)
            requireContext.startActivity(intent)
        }

    }
}
