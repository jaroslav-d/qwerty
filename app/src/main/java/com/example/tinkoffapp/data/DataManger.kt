package com.example.tinkoffapp.data

import android.content.Context
import com.example.tinkoffapp.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DataManger {

    private val listeners = mutableListOf<Callback>()

    fun addListener(listener: Callback) {
        listeners.add(listener)
        CoroutineScope(Dispatchers.Main).launch {
            listener.updatePhoto(RandomPhotosRepo.getCurrentPhoto())
        }
    }

    fun removeListener(listener: Callback) {
        listeners.remove(listener)
    }

    fun prev() = CoroutineScope(Dispatchers.Main).launch {

    }

    fun next() {

    }

    interface Callback {
        fun updatePhoto(photo: Photo)
    }
}