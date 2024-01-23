package com.example.wallpaperapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.R
import com.makeramen.roundedimageview.RoundedImageView

class CollectionAdapter(val requireContext: Context, val listBestOfMonth: ArrayList<String>) : RecyclerView.Adapter<CollectionAdapter.bomViewHolder>() {
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView= itemView.findViewById<RoundedImageView>(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_wallpaper, parent, false)
        )
    }

    override fun getItemCount()= listBestOfMonth.size

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestOfMonth[position]).into(holder.imageView)
    }
}
