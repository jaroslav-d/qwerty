package com.example.tinkoffapp

import com.bumptech.glide.Glide
import com.example.tinkoffapp.data.DataManger
import com.example.tinkoffapp.databinding.FragmentMainBinding
import com.example.tinkoffapp.entity.Photo

class MainViewModel(private val binding: FragmentMainBinding) : DataManger.Callback {

    override fun updatePhoto(photo: Photo) {
        Glide.with(binding.root)
            .asGif()
            .load(photo.url)
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(binding.photo)
    }

}