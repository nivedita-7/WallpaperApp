package com.example.wallpaperapp.Fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpaperapp.Adapter.CollectionAdapter
import com.example.wallpaperapp.databinding.FragmentDownloadBinding
import java.io.File


class DownloadFragment : Fragment() {
    lateinit var binding: FragmentDownloadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDownloadBinding.inflate(layoutInflater, container, false)

        val allFiles: Array<File>
        val imageList= arrayListOf<String>()

        //permission

        //denied

        //allow

        val targetPath= Environment.getExternalStorageDirectory().absolutePath+ "/Pictures/Wallpaper App Downloads"

        val targetFile= File(targetPath)
        allFiles= targetFile.listFiles()!!

        for(data in allFiles){
            imageList.add(data.absolutePath)
        }


        binding.rcvCollection.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rcvCollection.adapter= CollectionAdapter(requireContext(), imageList)

        return binding.root
    }

}