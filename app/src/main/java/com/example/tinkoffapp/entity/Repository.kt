package com.example.tinkoffapp.entity

import android.graphics.Bitmap

interface Repository {
    suspend fun getCurrentPhoto(): Photo
    suspend fun getPrevPhoto(): Photo
    suspend fun getNextPhoto(): Photo
    suspend fun setCategory(category: Category = Category.LATEST)
}