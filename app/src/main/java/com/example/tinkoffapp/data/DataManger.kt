package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.Photo
import com.example.tinkoffapp.entity.StateApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DataManger {

    private val listeners = mutableListOf<Callback>()

    fun addListener(listener: Callback) {
        if (listeners.isEmpty()) CoroutineScope(Dispatchers.Main).launch { RandomPhotosRepo.getNextPhoto() }
        listeners.add(listener)
        CoroutineScope(Dispatchers.Main).launch {
            listener.updatePhoto(RandomPhotosRepo.getCurrentPhoto())
        }
    }

    fun removeListener(listener: Callback) {
        listeners.remove(listener)
    }

    fun prev() = CoroutineScope(Dispatchers.Main).launch {
        val photo = RandomPhotosRepo.getPrevPhoto()
        listeners.forEach { it.updatePhoto(photo) }
    }

    fun next() = CoroutineScope(Dispatchers.Main).launch {
        val photo = RandomPhotosRepo.getNextPhoto()
        listeners.forEach { it.updatePhoto(photo) }
    }

    interface Callback {
        fun updatePhoto(photo: Photo)
    }
}