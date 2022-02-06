package com.example.tinkoffapp.entity

interface Repository {
    suspend fun getCurrentPhoto(): Photo
    suspend fun getPrevPhoto(): Photo
    suspend fun getNextPhoto(): Photo
    suspend fun setCategory(category: Category = Category.LATEST)
}