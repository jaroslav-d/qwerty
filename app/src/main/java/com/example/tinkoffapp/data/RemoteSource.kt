package com.example.tinkoffapp.data

import retrofit2.http.GET

interface RemoteSource {

    @GET("random?json=true")
    suspend fun request(): ModelJSON
}