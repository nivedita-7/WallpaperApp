package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpaperapp.Adapter.CatAdapter
import com.example.wallpaperapp.Adapter.CatImagesAdapter
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.Model.catModel
import com.example.wallpaperapp.databinding.ActivityCatBinding
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= FirebaseFirestore.getInstance()
        val vid= intent.getStringExtra("vid")
        val name= intent.getStringExtra("name")

        db.collection("categories").document(vid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->

            val listOfCatWallpaper= arrayListOf<BomModel>()
            val data= value?.toObjects(BomModel:: class.java)

            listOfCatWallpaper.addAll(data!!)

             binding.catTitle.text= name.toString()
             binding.catCount.text= "${listOfCatWallpaper.size} Wallpaper Available"

             binding.catRcv.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
             binding.catRcv.adapter= CatImagesAdapter(this, listOfCatWallpaper)
        }
    }
}