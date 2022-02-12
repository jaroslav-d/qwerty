package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomPhotosRepo : Repository {

    private val state = StateWrapper()
    private val source: RemoteSource = Retrofit.Builder()
        .baseUrl("https://developerslife.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RemoteSource::class.java)

    override suspend fun getCurrentPhoto(): Photo {
        return state.current.photo
    }

    override suspend fun getPrevPhoto(): Photo {
        return state.toPrev().photo
    }

    override suspend fun getNextPhoto(): Photo {
        if (state.toNext() is StateApp.LOADED) {
            return state.current.photo
        }
        state.current = try {
            val url = source.request().gifURL
            StateApp.LOADED().apply {
                photo = Photo(url)
            }
        } catch (e: Exception) {
            StateApp.ERROR()
        }
        return state.current.photo
    }

    override suspend fun setCategory(category: Category) = Unit

}