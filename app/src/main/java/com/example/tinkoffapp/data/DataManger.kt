package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.Photo
import com.example.tinkoffapp.entity.StateApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DataManger {

    private val listeners = mutableListOf<Callback>()

    fun addListener(listener: Callback) = CoroutineScope(Dispatchers.Main).launch {
        if (listeners.isEmpty()) next()
        listeners.add(listener)
        listener.updatePhoto(RandomPhotosRepo.getCurrentPhoto())
    }

    fun removeListener(listener: Callback) {
        listeners.remove(listener)
    }

    fun prev() = CoroutineScope(Dispatchers.IO).launch {
        val photo = RandomPhotosRepo.getPrevPhoto()
        withContext(Dispatchers.Main) { listeners.forEach { it.updatePhoto(photo) } }
    }

    fun next() = CoroutineScope(Dispatchers.IO).launch {
        withContext(Dispatchers.Main) { listeners.forEach { it.updatePhoto(StateApp.LOADING().photo) } }
        val photo = RandomPhotosRepo.getNextPhoto()
        withContext(Dispatchers.Main) { listeners.forEach { it.updatePhoto(photo) } }
    }

    interface Callback {
        fun updatePhoto(photo: Photo)
    }
}