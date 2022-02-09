package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomPhotosRepo : Repository {

    var state = StateWrapper(StateApp.LOADING)
    val source: RemoteSource = Retrofit.Builder()
        .baseUrl("https://developerslife.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RemoteSource::class.java)

    override suspend fun getCurrentPhoto(): Photo {
        return state.photo
    }

    override suspend fun getPrevPhoto(): Photo {
        return state.toPrev().photo
    }

    override suspend fun getNextPhoto(): Photo {
        if (state.toNext() == StateApp.LOADED) {
            return state.photo
        }
        state.current = try {
            val url = source.request().gifURL
            StateApp.LOADED.apply {
                photo = Photo(url)
            }
        } catch (e: Exception) {
            StateApp.ERROR
        }
        return state.photo
    }

    override suspend fun setCategory(category: Category) = Unit

}