package com.example.tinkoffapp.data

import com.example.tinkoffapp.entity.Category
import com.example.tinkoffapp.entity.Photo
import com.example.tinkoffapp.entity.Repository
import com.example.tinkoffapp.entity.StateApp

object RandomPhotosRepo : Repository {

    var state = StateApp.LOADING

    override suspend fun getCurrentPhoto(): Photo {
        return Photo("http://static.devli.ru/public/images/gifs/201402/df9c732c-c89f-4510-8424-44087f86be1d.gif")
    }

    override suspend fun getPrevPhoto(): Photo {
        return Photo("http://static.devli.ru/public/images/gifs/201309/16a6b156-20f9-4261-8bc0-862d754792d1.gif")
    }

    override suspend fun getNextPhoto(): Photo {
        return Photo("http://static.devli.ru/public/images/gifs/201405/3aebb1c0-d943-44dc-8a21-e6be9eada500.gif")
    }


    override suspend fun setCategory(category: Category) = Unit

}