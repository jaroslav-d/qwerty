package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.Category
import com.example.tinkoffapp.entity.Photo
import com.example.tinkoffapp.entity.Repository
import com.example.tinkoffapp.entity.StateApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomPhotosRepo : Repository {

    var state = StateApp.LOADING
    val source: RemoteSource = Retrofit.Builder()
        .baseUrl("https://developerslife.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RemoteSource::class.java)

    override suspend fun getCurrentPhoto(): Photo {
        return Photo(state.urlImg)
    }

    override suspend fun getPrevPhoto(): Photo {
        return Photo("http://static.devli.ru/public/images/gifs/201309/16a6b156-20f9-4261-8bc0-862d754792d1.gif")
    }

    override suspend fun getNextPhoto(): Photo {
        return try {
            val test = "http://static.devli.ru/public/images/gifs/201405/3aebb1c0-d943-44dc-8a21-e6be9eada500.gif"
            val url = source.request().gifURL
            state = StateApp.LOADED
            state.urlImg = url
            Photo(state.urlImg)
        } catch (e: Exception) {
            state = StateApp.ERROR
            Photo(state.urlImg)
        }
    }

    override suspend fun setCategory(category: Category) = Unit

}