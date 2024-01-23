package com.example.wallpaperapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperapp.Adapter.BomAdapter
import com.example.wallpaperapp.Adapter.CatAdapter
import com.example.wallpaperapp.Adapter.colortoneAdapter
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.Model.catModel
import com.example.wallpaperapp.Model.colorToneModel
import com.example.wallpaperapp.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)

        db= FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener { value, error ->
            val listBestOfMonth= arrayListOf<BomModel>()
            val data= value?.toObjects(BomModel:: class.java)

            listBestOfMonth.addAll(data!!)

            binding.rcvBom.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvBom.adapter= BomAdapter(requireContext(), listBestOfMonth)


        }

        db.collection("thecolortone").addSnapshotListener { value, error ->
            val listTheColorTone= arrayListOf<colorToneModel>()
            val data= value?.toObjects(colorToneModel:: class.java)

            listTheColorTone.addAll(data!!)

            binding.rcvTct.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvTct.adapter= colortoneAdapter(requireContext(), listTheColorTone)


        }

               db.collection("categories").addSnapshotListener { value, error ->
            val listOfCategory= arrayListOf<catModel>()
            val data= value?.toObjects(catModel:: class.java)

            listOfCategory.addAll(data!!)
            binding.rcvCat.layoutManager= GridLayoutManager(requireContext(), 2)
            binding.rcvCat.adapter= CatAdapter(requireContext(), listOfCategory)

        }


        return binding.root
    }

}

