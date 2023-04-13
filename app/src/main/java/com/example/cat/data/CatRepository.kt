package com.example.cat.data

import com.example.cat.model.CatBreed
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CatApi::class.java)

    suspend fun getBreeds(): List<CatBreed> {
        return api.getBreeds()
    }
}